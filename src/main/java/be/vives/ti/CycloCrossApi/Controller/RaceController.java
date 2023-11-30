package be.vives.ti.CycloCrossApi.Controller;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import be.vives.ti.CycloCrossApi.Domain.Race;
import be.vives.ti.CycloCrossApi.Repository.RaceRepository;
import be.vives.ti.CycloCrossApi.Response.CalendarResponse;
import be.vives.ti.CycloCrossApi.Response.RaceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("api/race")
public class RaceController {

    public final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    //vb call: http://localhost:8080/api/race
    @GetMapping
    public Page<RaceResponse> getAllRaces(Pageable pageable){
        return this.raceRepository.findAll(pageable).map(RaceResponse::new);
    }

    // Call: http://localhost:8080/api/race/byId/2
    @GetMapping(value = "/byId/{raceId}")
    public ResponseEntity<RaceResponse> getRaceById(@PathVariable Long raceId) {
        Race race = this.raceRepository.getReferenceById(raceId);
        RaceResponse raceResponse = new RaceResponse(race);
        return new ResponseEntity<>(raceResponse, HttpStatus.OK);
    }

    // Call: http://localhost:8080/api/race/byName/Thegaveer
    @GetMapping(value = "/byName/{raceName}")
    public ResponseEntity<RaceResponse> getRaceByName(@PathVariable String raceName) {
        Optional<Race> race = this.raceRepository.findByName(raceName);

        if (race.isPresent()) {
            RaceResponse raceResponse = new RaceResponse(race.get());
            return new ResponseEntity<>(raceResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Call: http://localhost:8080/api/race/byLocation/Aalst
    @GetMapping(value = "/byLocation/{location}")
    public ResponseEntity<RaceResponse> getRaceByLocation(@PathVariable String location) {
        Optional<Race> race = this.raceRepository.findByLocation(location);

        if (race.isPresent()) {
            RaceResponse raceResponse = new RaceResponse(race.get());
            return new ResponseEntity<>(raceResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
