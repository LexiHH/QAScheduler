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
import qascheduler.people.Trainer;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Scheduler {
    ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();
    static String[] trainerNames = {"Chris", "Paul", "Margaret", "Jessica", "Peter", "Rose"};
    ArrayList<Trainer> trainers = new ArrayList<Trainer>();

    public Scheduler(StudentRegister studentRegister, CourseRegister courseRegister) throws ParseException {
        initialiseStreams(studentRegister, courseRegister);
        addStudentsToCourses();
        registerTrainers();
        assignTrainers();
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
                String courseName = course.getCourseName();
                ArrayList<Student> courseStudents = new ArrayList<Student>();
                for(Student student:stream.getStudentsForThisStream()) {
                    LocalDate endDate;
                    if(student.hasCurrentCourse()){
                        Course currentCourse = student.getCurrentCourse();
                        endDate = currentCourse.getEndDate();
                    }
                    else {
                        endDate = LocalDate.of(2000,1,1);
                    }
                    ArrayList<String> coursesAttended = student.getCoursesAttended();
                    if(!student.getCoursesAttended().contains(courseName) && (student.getEnrollmentDate().isBefore(course.getStartDate()) || student.getEnrollmentDate().isEqual(course.getStartDate())) && course.getStartDate().isAfter(endDate)) {
                        student.setCurrentCourse(course);
                        coursesAttended.add(courseName);
                        student.setCoursesAttended(coursesAttended);
                        courseStudents.add(student);
                    }
                }
                course.setStudents(courseStudents);
            }
        }
    }

    public void registerTrainers() throws ParseException {
        for(String name:trainerNames) {
            trainers.add(new Trainer(name));
        }
    }

    public void assignTrainers() {
        ArrayList<Course> allCourses = new ArrayList<Course>();
        for(BaseStream stream:allStreams) {
            allCourses.addAll(stream.getCoursesForThisStream());
        }
        for(Course course:allCourses) {
            for(Trainer trainer:trainers) {
                if(course.getStudents().isEmpty()) {
                    System.out.println(course.getCourseName() + " on " + course.getStartDate() + " has been cancelled as no students are available to attend");
                    break;
                }
                if(trainer.getAvailableDate().isBefore(course.getStartDate()) || trainer.getAvailableDate().isEqual(course.getStartDate())) {
                    course.setTrainer(trainer);
                    trainer.setAvailableDate(course.getEndDate().plusDays(1));
                    System.out.println(course.getCourseName() + " in stream " + course.getStream() + " starts on " + course.getStartDate() + " with duration of " + course.getDurationInDays() + " days, ending on " + course.getEndDate() + " with trainer " + course.getTrainer().getName());
                    System.out.println("The students attending this course are: ");
                    for(Student student:course.getStudents()) {
                        System.out.println(student.getName());
                    }
                    break;
                }
            }
            if(!course.getStudents().isEmpty()) {
                if(course.hasTrainer() == false){
                    System.out.println("There is no trainer available for " + course.getCourseName());
                }
            }
        }
    }
}
