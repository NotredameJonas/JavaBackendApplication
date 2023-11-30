package be.vives.ti.CycloCrossApi.Response;

import be.vives.ti.CycloCrossApi.Domain.Rider;
import be.vives.ti.CycloCrossApi.Domain.Team;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class RiderResponse {
    @NotEmpty
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private  String lastName;

    @NotEmpty
    private LocalDate birthDay;

    @NotEmpty
    private int wins;

    @NotEmpty
    private Team team;

    private String gearDescription;

    public RiderResponse(Rider rider){
        this.id = rider.getId();
        this.firstName = rider.getFirstName();
        this.lastName = rider.getLastName();
        this.birthDay = rider.getBirthDay();
        this.wins =rider.getWins();
        this.team = rider.getTeam();
        this.gearDescription = rider.getGearDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getGearDescription() {
        return gearDescription;
    }

    public void setGearDescription(String gearDescription) {
        this.gearDescription = gearDescription;
    }
}
