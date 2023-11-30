package be.vives.ti.CycloCrossApi.Repository;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import be.vives.ti.CycloCrossApi.Domain.Race;
import be.vives.ti.CycloCrossApi.Domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,Long> {

    Optional<Team> findByName(String name);

    Optional<Team> findByHeadSponsor(String headSponsor);
}
