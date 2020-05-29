package qascheduler.courses;

import qascheduler.streams.Streams;
import qascheduler.people.Student;
import qascheduler.people.Trainer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private int durationInDays;
    private LocalDate startDate;
    private LocalDate endDate;
    private Streams stream;
    private ArrayList<Student> students = new ArrayList<Student>();
    private Trainer trainer;

    public Course(String courseName, Streams stream, int durationInDays, String startDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
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
