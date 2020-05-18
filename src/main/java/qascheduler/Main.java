package qascheduler;

import qascheduler.streams.BaseStream;
import qascheduler.streams.DevOpsStream;
import qascheduler.streams.JavaStream;
import qascheduler.streams.NetworkSecurityStream;
import qascheduler.streams.PythonStream;
import qascheduler.streams.ReactStream;
import qascheduler.courses.CourseRegister;
import qascheduler.people.StudentRegister;
import qascheduler.streams.Streams;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();
        DevOpsStream devOpsStream = new DevOpsStream(Streams.DevOpsStream);
        JavaStream javaStream = new JavaStream(Streams.JavaStream);
        NetworkSecurityStream networkSecurityStream = new NetworkSecurityStream(Streams.NetworkSecurityStream);
        PythonStream pythonStream = new PythonStream(Streams.PythonStream);
        ReactStream reactStream = new ReactStream(Streams.ReactStream);
        allStreams.add(devOpsStream);
        allStreams.add(javaStream);
        allStreams.add(networkSecurityStream);
        allStreams.add(pythonStream);
        allStreams.add(reactStream);
        CourseRegister coursesOf2020 = new CourseRegister(allStreams);
        coursesOf2020.printCourses();
        StudentRegister studentsOf2020 = new StudentRegister(5, allStreams);
        studentsOf2020.printStudentStreamEnrollments();
        Scheduler scheduleOf2020 = new Scheduler(allStreams);
        coursesOf2020.printCourses();
//        for(Streams stream:studentsOf2020.getStudentStreamMap().keySet()) {
//            for(Student student:studentsOf2020.getStudentStreamMap().get(stream)) {
//                System.out.println(student.getName() + " enrolled on " + student.getEnrollmentDate() + " is in stream " + stream + " and is attending the following courses:");
//                for(String course:student.getCoursesAttended()){
//                    System.out.println(course);
//                }
//            }
//        }
    }
}
