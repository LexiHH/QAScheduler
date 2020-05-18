package qascheduler.courses;

import qascheduler.streams.Streams;
import qascheduler.streams.BaseStream;

import java.text.ParseException;
import java.util.ArrayList;

public class CourseRegister {
    ArrayList<BaseStream> streamsWithCourses;

    public CourseRegister(ArrayList<BaseStream> streamsWithCourses) throws ParseException {
        this.streamsWithCourses = streamsWithCourses;
        devOpsCourses(Streams.DevOpsStream);
        javaCourses(Streams.JavaStream);
        networkCourses(Streams.NetworkSecurityStream);
        pythonCourses(Streams.PythonStream);
        reactCourses(Streams.ReactStream);
    }


    public void courseCreator(ArrayList<Course> courses, Streams stream) {
        for(BaseStream baseStream:streamsWithCourses) {
            if(baseStream.getStreamName() == stream) {
                baseStream.setCoursesForThisStream(courses);
            }
        }
    }

    public void devOpsCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("DevOps 101", stream, 5, "2020-05-13"));
        courses.add(new Course("Integrating DevOps into your work environment", stream, 3, "2020-05-15"));
        courses.add(new Course("DevOps 101", stream, 5, "2020-06-13"));
        courses.add(new Course("Integrating DevOps into your work environment", stream, 3, "2020-06-20"));
        courseCreator(courses, stream);
    }

    public void javaCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Java 101", stream, 12, "2020-05-13"));
        courses.add(new Course("Intermediate Java", stream, 12, "2020-05-20"));
        courses.add(new Course("Java 101", stream, 12, "2020-06-13"));
        courses.add(new Course("Intermediate Java", stream, 12, "2020-06-26"));
        courseCreator(courses, stream);
    }

    public void networkCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Network Security 101", stream, 5, "2020-05-18"));
        courses.add(new Course("OWASP Top 10", stream, 5, "2020-05-27"));
        courses.add(new Course("Network Security 101", stream, 5, "2020-06-18"));
        courses.add(new Course("OWASP Top 10", stream, 5, "2020-06-27"));
        courseCreator(courses, stream);
    }

    public void pythonCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Python 101", stream, 5, "2020-05-26"));
        courses.add(new Course("Python Battleships Game", stream, 12, "2020-05-28"));
        courses.add(new Course("Python 101", stream, 5, "2020-06-26"));
        courses.add(new Course("Python Battleships Game", stream, 12, "2020-06-28"));
        courseCreator(courses, stream);
    }


    public void reactCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("React 101", stream, 5, "2020-05-03"));
        courses.add(new Course("React: To-Do List Application", stream, 5, "2020-05-09"));
        courses.add(new Course("React 101", stream, 5, "2020-06-03"));
        courses.add(new Course("React: To-Do List Application", stream, 5, "2020-06-09"));
        courseCreator(courses, stream);
    }

    public void printCourses() {
        for(BaseStream stream:streamsWithCourses) {
            for(Course course:stream.getCoursesForThisStream()) {
                System.out.println(course.getCourseName() + " starting on " + course.getStartDate() + " and ending on " + course.getEndDate());
            }
        }
    }
}
