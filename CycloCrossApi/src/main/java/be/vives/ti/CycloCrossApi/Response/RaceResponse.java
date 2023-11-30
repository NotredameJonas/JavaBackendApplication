package be.vives.ti.CycloCrossApi.Response;

import be.vives.ti.CycloCrossApi.Domain.Race;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class RaceResponse {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private LocalDate date;

    private String countryCode;
    @NotEmpty
    private String location;
    private String raceCreator;
    private int countOfViewers;

    public RaceResponse(Race race){
        this.id = race.getId();
        this.name = race.getName();
        this.date = race.getDate();
        this.countryCode = race.getCountryCode();
        this.location = race.getLocation();
        this.raceCreator = race.getRaceCreator();
        this.countOfViewers = race.getCountOfViewers();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRaceCreator() {
        return raceCreator;
    }

    public void setRaceCreator(String raceCreator) {
        this.raceCreator = raceCreator;
    }

    public int getCountOfViewers() {
        return countOfViewers;
    }

    public void setCountOfViewers(int countOfViewers) {
        this.countOfViewers = countOfViewers;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
