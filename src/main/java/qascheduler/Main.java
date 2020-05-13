package qascheduler;

import qascheduler.courses.Course;
import qascheduler.people.CourseRegister;
import qascheduler.people.Student;
import qascheduler.people.StudentRegister;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws ParseException {
        StudentRegister studentsOf2020 = new StudentRegister(8);
        for(Streams stream:studentsOf2020.getStudentStreamMap().keySet()) {
            System.out.println(stream + " has these students:");
            for(Student student:studentsOf2020.getStudentStreamMap().get(stream)) {
                System.out.println(student.getName());
            }
        }
        CourseRegister coursesOf2020 = new CourseRegister();
        Scheduler scheduleOf2020 = new Scheduler(studentsOf2020, coursesOf2020);
        for(Streams stream:studentsOf2020.getStudentStreamMap().keySet()) {
            for(Student student:studentsOf2020.getStudentStreamMap().get(stream)) {
                System.out.println(student.getName() + " is in stream " + stream + " and is attending the following courses:");
                for(String course:student.getCoursesAttended()){
                    System.out.println(course);
                }
            }
        }
    }
}
