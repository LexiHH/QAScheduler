package qascheduler.streams;

import qascheduler.courses.Course;
import qascheduler.people.Student;

import java.util.ArrayList;

public class BaseStream implements IStream {
    ArrayList<Student> studentsForThisStream = new ArrayList<Student>();
    ArrayList<Course> coursesForThisStream = new ArrayList<Course>();
    Streams streamName;

    public BaseStream() {
        System.out.println("No argument constructor of BaseStream called");
    }

    public BaseStream(Streams streamName) {
        this.streamName = streamName;
    }

    public ArrayList<Student> getStudentsForThisStream() {
        return studentsForThisStream;
    }

    public void setStudentsForThisStream(ArrayList<Student> studentsForThisStream) {
        this.studentsForThisStream = studentsForThisStream;
    }

    public ArrayList<Course> getCoursesForThisStream() {
        return coursesForThisStream;
    }

    public void setCoursesForThisStream(ArrayList<Course> coursesForThisStream) {
        this.coursesForThisStream = coursesForThisStream;
    }

    public Streams getStreamName() {
        return streamName;
    }
}
