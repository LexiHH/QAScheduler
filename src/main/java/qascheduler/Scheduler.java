package qascheduler;

import qascheduler.courses.BaseStream;
import qascheduler.courses.Course;
import qascheduler.courses.DevOpsStream;
import qascheduler.courses.JavaStream;
import qascheduler.courses.NetworkSecurityStream;
import qascheduler.courses.PythonStream;
import qascheduler.courses.ReactStream;
import qascheduler.people.CourseRegister;
import qascheduler.people.Student;
import qascheduler.people.StudentRegister;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {
    ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();

    public Scheduler(StudentRegister studentRegister, CourseRegister courseRegister) {
        initialiseStreams(studentRegister, courseRegister);
        addStudentsToCourses();
    }


    public void initialiseStreams(StudentRegister studentRegister, CourseRegister courseRegister) {
        HashMap<Streams,ArrayList<Student>> studentStreamMap = studentRegister.getStudentStreamMap();
        HashMap<Streams,ArrayList<Course>> courseTimetable = courseRegister.getCourseTimetable();
        DevOpsStream devOpsStream = new DevOpsStream(studentStreamMap.get(Streams.DevOpsStream), courseTimetable.get(Streams.DevOpsStream));
        JavaStream javaStream = new JavaStream(studentStreamMap.get(Streams.JavaStream), courseTimetable.get(Streams.JavaStream));
        NetworkSecurityStream networkSecurityStream = new NetworkSecurityStream(studentStreamMap.get(Streams.NetworkSecurityStream), courseTimetable.get(Streams.NetworkSecurityStream));
        PythonStream pythonStream = new PythonStream(studentStreamMap.get(Streams.PythonStream), courseTimetable.get(Streams.PythonStream));
        ReactStream reactStream = new ReactStream(studentStreamMap.get(Streams.ReactStream), courseTimetable.get(Streams.ReactStream));
        allStreams.add(devOpsStream);
        allStreams.add(javaStream);
        allStreams.add(networkSecurityStream);
        allStreams.add(pythonStream);
        allStreams.add(reactStream);
    }

    public void addStudentsToCourses() {
        for(BaseStream stream: allStreams) {
            for(Course course:stream.getCoursesForThisStream()) {
            }
        }
    }
}
