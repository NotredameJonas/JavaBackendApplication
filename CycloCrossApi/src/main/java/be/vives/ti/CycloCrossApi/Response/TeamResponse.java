package be.vives.ti.CycloCrossApi.Response;

import be.vives.ti.CycloCrossApi.Domain.Team;
import jakarta.validation.constraints.NotEmpty;

public class TeamResponse {
    @NotEmpty
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String headSponsor;

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.headSponsor = team.getHeadSponsor();
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

    public String getHeadSponsor() {
        return headSponsor;
    }

    public void setHeadSponsor(String headSponsor) {
        this.headSponsor = headSponsor;
    }
}
