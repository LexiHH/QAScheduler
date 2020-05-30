package qascheduler.courses;

import qascheduler.people.Student;
import qascheduler.streams.Streams;
import qascheduler.streams.BaseStream;

import java.util.ArrayList;

public class CourseRegister {
    private ArrayList<BaseStream> allStreams;

    public CourseRegister(ArrayList<BaseStream> allStreams) {
        this.allStreams = allStreams;
        devOpsCourses(Streams.DEVOPS_STREAM);
        javaCourses(Streams.JAVA_STREAM);
        networkCourses(Streams.NETWORK_SECURITY_STREAM);
        pythonCourses(Streams.PYTHON_STREAM);
        reactCourses(Streams.REACT_STREAM);
    }


    public void courseCreator(ArrayList<Course> courses, Streams stream) {
        for(BaseStream baseStream: allStreams) {
            if(baseStream.getStreamName() == stream) {
                baseStream.setCoursesForThisStream(courses);
            }
        }
    }

    public void devOpsCourses(Streams stream) {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("DevOps 101", stream, 5, "2020-05-13"));
        courses.add(new Course("Integrating DevOps into your work environment", stream, 3, "2020-05-15"));
        courses.add(new Course("DevOps 101", stream, 5, "2020-06-13"));
        courses.add(new Course("Integrating DevOps into your work environment", stream, 3, "2020-06-20"));
        courseCreator(courses, stream);
    }

    public void javaCourses(Streams stream) {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Java 101", stream, 15, "2020-05-13"));
        courses.add(new Course("Intermediate Java", stream, 15, "2020-05-20"));
        courses.add(new Course("Java 101", stream, 15, "2020-06-13"));
        courses.add(new Course("Intermediate Java", stream, 15, "2020-06-26"));
        courseCreator(courses, stream);
    }

    public void networkCourses(Streams stream) {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Network Security 101", stream, 5, "2020-05-18"));
        courses.add(new Course("OWASP Top 10", stream, 5, "2020-05-27"));
        courses.add(new Course("Network Security 101", stream, 5, "2020-06-18"));
        courses.add(new Course("OWASP Top 10", stream, 5, "2020-06-27"));
        courseCreator(courses, stream);
    }

    public void pythonCourses(Streams stream) {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("Python 101", stream, 5, "2020-05-26"));
        courses.add(new Course("Python Battleships Game", stream, 15, "2020-05-28"));
        courses.add(new Course("Python 101", stream, 5, "2020-06-26"));
        courses.add(new Course("Python Battleships Game", stream, 15, "2020-06-28"));
        courseCreator(courses, stream);
    }


    public void reactCourses(Streams stream) {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("React 101", stream, 5, "2020-05-03"));
        courses.add(new Course("React: To-Do List Application", stream, 5, "2020-05-09"));
        courses.add(new Course("React 101", stream, 5, "2020-06-03"));
        courses.add(new Course("React: To-Do List Application", stream, 5, "2020-06-09"));
        courseCreator(courses, stream);
    }

    public void printInititalCourses() {
        System.out.println();
        System.out.printf("%-60s %-15s %-15s %n", "Course Name", "Start Date", "End Date");
        for(BaseStream stream: allStreams) {
            for(Course course:stream.getCoursesForThisStream()) {
                System.out.printf("%-60s %-15s %-15s %n", course.getCourseName(), course.getStartDate().toString(), course.getEndDate().toString());
            }
        }
        System.out.println();
    }

    public void printOrganisedCourses() {
        System.out.println();
        System.out.printf("%-60s%-30s%-15s%-15s%-15s%n", "Course Name", "Trainer", "Start Date", "End Date", "Students");
        for(BaseStream stream: allStreams) {
            for(Course course:stream.getCoursesForThisStream()) {
                int firstStudent = 0;
                String courseName = course.getCourseName();
                String trainer = course.getTrainer().getName();
                String startDate = course.getStartDate().toString();
                String endDate = course.getEndDate().toString();
                for(Student student: course.getStudents()) {
                    if(firstStudent == 0) {
                        System.out.printf("%-60s%-30s%-15s%-15s%-15s%n", courseName, trainer, startDate, endDate, student.getName());
                        firstStudent++;
                    }
                    else {
                        System.out.printf("%-60s%-30s%-15s%-15s%-15s%n", "", "", "", "", student.getName());
                    }
                }
            }
        }
        System.out.println();
    }
}
