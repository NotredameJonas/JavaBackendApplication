package be.vives.ti.CycloCrossApi.Repository;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import be.vives.ti.CycloCrossApi.Domain.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RaceRepository extends JpaRepository<Race,Long> {

    Optional<Race> findByName(String name);

    Optional<Race> findByDate(LocalDate date);

    Optional<Race> findByLocation(String location);

    Optional<Race> findByRaceCreator(String raceCreator);


}
