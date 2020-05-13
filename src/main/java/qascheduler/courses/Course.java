package qascheduler.courses;

import qascheduler.Streams;
import qascheduler.people.Student;
import qascheduler.people.Trainer;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Course {
    String courseName;
    int durationInDays;
    Date startDate;
    Date endDate;
    Streams stream;
    ArrayList<Student> pastStudents = new ArrayList<Student>();
    Trainer trainer;

    public Course(String courseName, Streams stream, int durationInDays, String startDate) throws ParseException {
        this.courseName = courseName;
        this.stream = stream;
        this.durationInDays = durationInDays;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.parse(startDate);
        calculateEndDate();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public ArrayList<Student> getPastStudents() {
        return pastStudents;
    }

    public void setPastStudents(ArrayList<Student> pastStudents) {
        this.pastStudents = pastStudents;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public boolean hasTrainer() {
        if(this.trainer == null){
            return false;
        }
        return true;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void calculateEndDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, durationInDays);
        this.endDate = c.getTime();
    }
}
