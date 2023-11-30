package be.vives.ti.CycloCrossApi.Domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private String location;

    private String raceCreator;

    private int CountOfViewers;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "riders_in_race",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "rider_id")
    )
    private List<Rider> riders = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Rider winner;

    protected Race() {
    }

    public Race(long id, String name, LocalDate date,String countryCode, String location, String raceCreator, int countOfViewers, Rider winner) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.countryCode = countryCode;
        this.location = location;
        this.raceCreator = raceCreator;
        this.CountOfViewers = countOfViewers;
        this.winner = winner;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
        return CountOfViewers;
    }

    public void setCountOfViewers(int countOfViewers) {
        CountOfViewers = countOfViewers;
    }

    public void addRider(Rider rider) {
        this.riders.add(rider);
    }

    public List<Rider> getRiders() {
        return riders;
    }

    public Rider getWinner() {
        return winner;
    }

    public void setWinner(Rider winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", countryCode='" + countryCode + '\'' +
                ", location='" + location + '\'' +
                ", raceCreator='" + raceCreator + '\'' +
                ", CountOfViewers=" + CountOfViewers +
                ", riders=" + riders +
                ", winner=" + winner +
                '}';
    }
}
