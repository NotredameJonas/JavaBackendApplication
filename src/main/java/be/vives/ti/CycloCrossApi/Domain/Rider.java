package be.vives.ti.CycloCrossApi.Domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Past
    private LocalDate birthDay;
    @Column(nullable = false)
    private String countryCode;
    private int wins;

    @ManyToOne
    @JoinColumn(name = "fk_team", nullable = false)
    private Team team;
    private String gearDescription;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "rider_program",
            joinColumns = {@JoinColumn(name = "rider_id")},
            inverseJoinColumns = {@JoinColumn(name = "race_id")})
    private List<Race> program = new ArrayList<>();

    protected Rider(){}
    public Rider(long id, String firstName, String lastName, LocalDate birthDay,String countryCode, int wins, Team team, String gearDescription) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.countryCode = countryCode;
        this.wins = wins;
        this.team = team;
        this.gearDescription = gearDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    @Transactional
    public void addToProgram(Race race){
        this.program.add(race);
//        race.getRiders().add(this);
    }

    public List<Race> getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", countryCode='" + countryCode + '\'' +
                ", wins=" + wins +
                ", team=" + team +
                ", gearDescription='" + gearDescription + '\'' +
                ", program=" + program +
                '}';
    }
}
