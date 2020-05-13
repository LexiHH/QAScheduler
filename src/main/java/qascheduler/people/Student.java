package qascheduler.people;

import qascheduler.Streams;
import qascheduler.courses.Course;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student extends Person {
    private Streams stream;
    private LocalDate enrollmentDate;
    private Course currentCourse;
    ArrayList<String> coursesAttended = new ArrayList<String>();

    public Student(String name, Streams stream, String enrollmentDate) {
        super(name);
        this.stream = stream;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.enrollmentDate = LocalDate.parse(enrollmentDate, dtf);
    }

    public Streams getStream() {
        return stream;
    }

    public ArrayList<String> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(ArrayList<String> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public boolean hasCurrentCourse() {
        if(currentCourse != null) {
            return true;
        }
        return false;
    }
}
