package qascheduler;

import qascheduler.courses.CourseRegister;
import qascheduler.people.StudentRegister;
import qascheduler.streams.BaseStream;
import qascheduler.streams.StreamHandler;

import java.util.ArrayList;

public abstract class QAScheduleCreator {

    public static void CreateSchedule(int numberOfStudents) {
        StreamHandler streamHandler = new StreamHandler();
        ArrayList<BaseStream> allStreams = streamHandler.getAllStreams();
        CourseRegister coursesOf2020 = new CourseRegister(allStreams);
        StudentRegister studentsOf2020;
        try {
            studentsOf2020 = new StudentRegister(numberOfStudents, allStreams);
        }
        catch (IndexOutOfBoundsException exc){
            studentsOf2020 = new StudentRegister(26, allStreams);
            System.out.println("A maximum of 26 students can be registered. Registration completed for 26 students.");
        }
        studentsOf2020.printStudentStreamEnrollments();
        Scheduler scheduleOf2020 = new Scheduler(allStreams);
        coursesOf2020.printOrganisedCourses();
        streamHandler.printStreamCosts();
    }
}
