package be.vives.ti.CycloCrossApi.Response;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import jakarta.validation.constraints.NotEmpty;

import java.time.Year;

public class CalendarResponse {

    @NotEmpty
    private Long id;
    @NotEmpty
    private Year startYear;
    @NotEmpty
    private Year endYear;

    public CalendarResponse(Calendar calendar){
        this.id = calendar.getId();
        this.startYear = calendar.getStartYear();
        this.endYear = calendar.getEndYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Year getStartYear() {
        return startYear;
    }

    public void setStartYear(Year startYear) {
        this.startYear = startYear;
    }

    public Year getEndYear() {
        return endYear;
    }

    public void setEndYear(Year endYear) {
        this.endYear = endYear;
    }
}
