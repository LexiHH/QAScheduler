package qascheduler.people;

import qascheduler.Streams;
import qascheduler.courses.Course;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseRegister {
    HashMap<Streams, ArrayList<Course>> courseTimetable;

    public CourseRegister() throws ParseException {
        courseCreator();
    }

    public HashMap<Streams, ArrayList<Course>> getCourseTimetable() {
        return courseTimetable;
    }


    public void courseCreator() throws ParseException {
        courseTimetable = new HashMap<Streams, ArrayList<Course>>();
        courseTimetable.put(Streams.DevOpsStream, devOpsCourses(Streams.DevOpsStream));
        courseTimetable.put(Streams.JavaStream, javaCourses(Streams.JavaStream));
        courseTimetable.put(Streams.NetworkSecurityStream, networkCourses(Streams.NetworkSecurityStream));
        courseTimetable.put(Streams.PythonStream, pythonCourses(Streams.PythonStream));
        courseTimetable.put(Streams.ReactStream, reactCourses(Streams.ReactStream));

    }

    public ArrayList<Course> devOpsCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("DevOps 101", stream, 5, "2020-05-13"));
        courses.add(new Course("Integrating DevOps into your work environment", stream, 3, "2020-05-15"));
        return courses;
    }

    public ArrayList<Course> javaCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Java 101", stream, 12, "2020-05-13"));
        courses.add(new Course("Intermediate Java", stream, 12, "2020-05-20"));
        return courses;
    }

    public ArrayList<Course> networkCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Network Security 101", stream, 5, "2020-05-18"));
        courses.add(new Course("OWASP Top 10", stream, 5, "2020-05-27"));
        return courses;
    }

    public ArrayList<Course> pythonCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Python 101", stream, 5, "2020-05-26"));
        courses.add(new Course("Python Battleships Game", stream, 12, "2020-05-28"));
        return courses;
    }


    public ArrayList<Course> reactCourses(Streams stream) throws ParseException {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("React 101", stream, 5, "2020-06-03"));
        courses.add(new Course("React: To-Do List Application", stream, 5, "2020-06-09"));
        return courses;

    }
}
