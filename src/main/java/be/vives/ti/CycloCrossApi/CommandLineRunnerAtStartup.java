package be.vives.ti.CycloCrossApi;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import be.vives.ti.CycloCrossApi.Domain.Race;
import be.vives.ti.CycloCrossApi.Domain.Rider;
import be.vives.ti.CycloCrossApi.Domain.Team;
import be.vives.ti.CycloCrossApi.Repository.CalendarRepository;
import be.vives.ti.CycloCrossApi.Repository.RaceRepository;
import be.vives.ti.CycloCrossApi.Repository.RiderRepository;
import be.vives.ti.CycloCrossApi.Repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerAtStartup implements CommandLineRunner {


    private final CalendarRepository calendarRepository;
    private final RaceRepository raceRepository;
    private final RiderRepository riderRepository;
    private final TeamRepository teamRepository;



    public CommandLineRunnerAtStartup(CalendarRepository calendarRepository, RaceRepository raceRepository, RiderRepository riderRepository, TeamRepository teamRepository) {
        this.calendarRepository = calendarRepository;
        this.raceRepository = raceRepository;
        this.riderRepository = riderRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<Calendar> calendars = new ArrayList<>();
        List<Team> teams = new ArrayList<>();
        List<Rider> riders = new ArrayList<>();
        List<Race> races = new ArrayList<>();

        // List of country codes for high-level cyclocross countries
        List<String> countryCodes = List.of("BE", "NL", "CZ", "FR", "US", "IT", "CH", "GB", "DE", "BR");

        for (int i = 0; i < 100; i++) {
            LocalDate raceDate = LocalDate.of(2023, 11, 20);
            LocalDate birthDate = LocalDate.of(2023, 11, 20);

            // Randomly select a country code
            String countryCode = countryCodes.get(i % countryCodes.size());

            Calendar calendar = calendarRepository.save(new Calendar(Year.of(2023 + i), Year.of(2024 + i)));
            Team team = teamRepository.save(new Team(i + 1, "team" + i, "user" + i));
            Rider rider = riderRepository.save(new Rider(i + 1, "rider" + i, "g", birthDate, countryCode, 12, team, "bike with wheels"));
            Race race = raceRepository.save(new Race(i + 1, "Race" + i, raceDate, countryCode, "Location" + i, "Creator" + i, 2300, null));

            // Add riders to the race
            race.addRider(rider);

            // Set a winner for the race
            race.setWinner(rider);

            Optional<Race> savedRace = raceRepository.findById(race.getId());
            calendar.addRace(savedRace.orElseThrow());

            riderRepository.save(new Rider(i + 1, "rider" + i, "LastName" + i, birthDate, countryCode, 12, team, "bike with wheels"));
            Optional<Rider> savedRider = riderRepository.findByFirstNameAndLastName("rider" + i, "LastName" + i);
            team.addMember(savedRider.orElseThrow());

            // Add the rider to the program
            rider.addToProgram(savedRace.orElseThrow());

            calendars.add(calendar);
            teams.add(team);
            riders.add(rider);
            races.add(race);
        }

        calendarRepository.saveAll(calendars);
        teamRepository.saveAll(teams);
        raceRepository.saveAll(races);
        riderRepository.saveAll(riders);
    }
}
