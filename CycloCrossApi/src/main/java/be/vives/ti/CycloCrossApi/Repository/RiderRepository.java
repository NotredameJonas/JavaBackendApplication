package be.vives.ti.CycloCrossApi.Repository;

import be.vives.ti.CycloCrossApi.Domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RiderRepository extends JpaRepository<Rider,Long> {

    Optional<Rider> findByFirstNameAndLastName(String firstName, String lastName);



}
