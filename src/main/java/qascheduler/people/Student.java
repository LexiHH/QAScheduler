package qascheduler.people;

import qascheduler.Streams;
import qascheduler.courses.Course;

import java.util.ArrayList;

public class Student extends Person {
    private Streams stream;
    ArrayList<Course> coursesAttended = new ArrayList<Course>();

    public Student(String name, Streams stream) {
        super(name);
        this.stream = stream;
    }

    public Streams getStream() {
        return stream;
    }

    public ArrayList<Course> getCoursesAttended() {
        return coursesAttended;
    }

    public void setCoursesAttended(ArrayList<Course> coursesAttended) {
        this.coursesAttended = coursesAttended;
    }
}
