package be.vives.ti.CycloCrossApi.Domain;

import jakarta.persistence.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Year startYear; //vb 2023
    @Column(nullable = false)
    private Year endYear; //vb 2024
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id")
    @Column(nullable = false)
    private List<Race> races = new ArrayList<>();

    protected Calendar() {
    }

    public Calendar(Year startYear, Year endYear){
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Year getStartYear() {
        return startYear;
    }

    public Year getEndYear() {
        return endYear;
    }

    public void setStartYear(Year startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(Year endYear) {
        this.endYear = endYear;
    }

    public void addRace(Race race){
        this.races.add(race);
    }

    public List<Race> getRaces() {
        return races;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "id=" + id +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", races=" + races +
                '}';
    }
}


