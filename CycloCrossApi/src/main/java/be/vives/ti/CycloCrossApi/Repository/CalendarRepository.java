package be.vives.ti.CycloCrossApi.Repository;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface CalendarRepository extends JpaRepository<Calendar,Long> {

    Optional<Calendar> findByStartYearAndEndYear(Year startYear, Year endYear);

}
