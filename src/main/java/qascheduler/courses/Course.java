package qascheduler.courses;

import qascheduler.streams.Streams;
import qascheduler.people.Student;
import qascheduler.people.Trainer;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Course {
    String courseName;
    int durationInDays;
    LocalDate startDate;
    LocalDate endDate;
    Streams stream;
    ArrayList<Student> students = new ArrayList<Student>();
    Trainer trainer;

    public Course(String courseName, Streams stream, int durationInDays, String startDate) throws ParseException {
        this.courseName = courseName;
        this.stream = stream;
        this.durationInDays = durationInDays;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.startDate = LocalDate.parse(startDate, dtf);
        this.endDate = this.startDate.plusDays(durationInDays);
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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

}
