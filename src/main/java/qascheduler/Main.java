package qascheduler;

import qascheduler.streams.BaseStream;
import qascheduler.courses.CourseRegister;
import qascheduler.people.StudentRegister;
import qascheduler.streams.StreamHandler;

import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        StreamHandler streamHandler = new StreamHandler();
        ArrayList<BaseStream> allStreams = streamHandler.getAllStreams();
        CourseRegister coursesOf2020 = new CourseRegister(allStreams);
        StudentRegister studentsOf2020 = new StudentRegister(5, allStreams);
        studentsOf2020.printStudentStreamEnrollments();
        Scheduler scheduleOf2020 = new Scheduler(allStreams);
        coursesOf2020.printOrganisedCourses();
        streamHandler.printStreamCosts();
    }
}
