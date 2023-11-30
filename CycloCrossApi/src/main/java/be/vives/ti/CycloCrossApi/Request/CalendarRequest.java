package be.vives.ti.CycloCrossApi.Request;

import be.vives.ti.CycloCrossApi.Domain.Calendar;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public class CalendarRequest {
    @NotNull
    private Year startYear;
    @NotNull
    private Year endYear;

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
