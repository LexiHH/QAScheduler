package qascheduler.people;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trainer extends Person {
    private LocalDate availableDate;

    public Trainer(String name) {
        super(name);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.availableDate = LocalDate.parse("2000-01-01", dtf);
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }
}
