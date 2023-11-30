package be.vives.ti.CycloCrossApi.Controller;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import be.vives.ti.CycloCrossApi.Domain.Race;
import be.vives.ti.CycloCrossApi.Repository.CalendarRepository;
import be.vives.ti.CycloCrossApi.Repository.RaceRepository;
import be.vives.ti.CycloCrossApi.Request.CalendarRequest;
import be.vives.ti.CycloCrossApi.Response.CalendarResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Year;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {
    private final CalendarRepository calendarRepository;

    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    //vb call: http://localhost:8080/api/calendar
    @GetMapping
    public Page<CalendarResponse> getAllCalendars(Pageable pageable){
        return this.calendarRepository.findAll(pageable).map(CalendarResponse::new);
    }

    //vb call: http://localhost:8080/api/calendar/byId/1
    @GetMapping(value = "/byId/{calendarId}")
    public ResponseEntity<CalendarResponse> getCalendarById(@PathVariable Long calendarId){
        Calendar calendar = this.calendarRepository.getReferenceById(calendarId);
        CalendarResponse calendarResponse = new CalendarResponse(calendar);
        return new ResponseEntity<>(calendarResponse, HttpStatus.OK);

    }

    //vb call: http://localhost:8080/api/calendar/byYears/2024/2025
    @GetMapping(value = "/byYears/{startYear}/{endYear}")
    public ResponseEntity<Optional<CalendarResponse>> getCalendarByStartYearAndEndYear(
            @PathVariable Year startYear,
            @PathVariable Year endYear) {

        Optional<Calendar> calendar = this.calendarRepository.findByStartYearAndEndYear(startYear, endYear);
        if (calendar.isPresent()) {
            CalendarResponse calendarResponse = new CalendarResponse(calendar.get());
            return new ResponseEntity<>(Optional.of(calendarResponse), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping()
    public ResponseEntity<Void> addCalendar(@RequestBody @Valid CalendarRequest calendarRequest){
        HttpHeaders headers = new HttpHeaders();

        Calendar calendar = new Calendar(calendarRequest.getStartYear(), calendarRequest.getEndYear());
        Calendar newCalendar = calendarRepository.save(calendar);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCalendar.getId())
                .toUri();

        headers.setLocation(location);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}


