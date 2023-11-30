package be.vives.ti.CycloCrossApi.Domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String headSponsor;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rider> members = new ArrayList<>();

    protected Team(){}

    public Team(long id, String name, String headSponsor) {
        this.id = id;
        this.name = name;
        this.headSponsor = headSponsor;
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

    public String getHeadSponsor() {
        return headSponsor;
    }

    public void setHeadSponsor(String headSponsor) {
        this.headSponsor = headSponsor;
    }

    public void addMember(Rider rider){
        this.members.add(rider);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headSponsor='" + headSponsor + '\'' +
                ", members=" + members +
                '}';
    }
}
