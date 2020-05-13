package qascheduler.people;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trainer extends Person {
    private Date availableDate;

    public Trainer(String name) throws ParseException {
        super(name);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.availableDate = sdf.parse("2000-01-01");
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }
}
