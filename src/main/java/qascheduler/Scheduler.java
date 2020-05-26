package qascheduler;

import qascheduler.streams.BaseStream;
import qascheduler.courses.Course;
import qascheduler.people.Student;
import qascheduler.people.Trainer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Scheduler {
    ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();
    static String[] trainerNames = {"Chris", "Paul", "Margaret", "Jessica", "Peter", "Rose"};
    ArrayList<Trainer> trainers = new ArrayList<Trainer>();

    public Scheduler(ArrayList<BaseStream> allStreams) {
        this.allStreams = allStreams;
        addStudentsToCourses();
        addTrainersToCourses();
    }


    public void addStudentsToCourses() {
        for(BaseStream stream: allStreams) {
            for(Course course:stream.getCoursesForThisStream()) {
                ArrayList<Student> courseStudents = new ArrayList<Student>();
                for(Student student:stream.getStudentsForThisStream()) {
                    if(studentCanBeAddedToCourse(student, course)) {
                        courseStudents.add(student);
                    }
                }
                course.setStudents(courseStudents);
            }
        }
    }

    public boolean studentCanBeAddedToCourse(Student student, Course course) {
        String courseName = course.getCourseName();
        ArrayList<String> coursesAttended = student.getCoursesAttended();
        LocalDate enrollmentDate = student.getEnrollmentDate();
        LocalDate currentCourseEndDate = studentCurrentCourseEndDate(student);
        LocalDate courseStartDate = course.getStartDate();
        if(!coursesAttended.contains(courseName) && (enrollmentDate.isBefore(courseStartDate) || enrollmentDate.isEqual(courseStartDate)) && courseStartDate.isAfter(currentCourseEndDate)) {
            student.setCurrentCourse(course);
            coursesAttended.add(courseName);
            student.setCoursesAttended(coursesAttended);
            return true;
        }
        return false;
    }

    public LocalDate studentCurrentCourseEndDate(Student student) {
        LocalDate endDate;
        if(student.hasCurrentCourse()){
            endDate = student.getCurrentCourse().getEndDate();
        }
        else {
            endDate = LocalDate.of(2000,1,1);
        }
        return endDate;
    }


    public void addTrainersToCourses() {
        for(String name:trainerNames) {
            trainers.add(new Trainer(name));
        }
        assignTrainers();
    }

    public void assignTrainers() {
        for(BaseStream baseStream:allStreams) {
            ArrayList<Course> coursesNotCancelled = new ArrayList<Course>();
            for (Course course:baseStream.getCoursesForThisStream()) {
                boolean courseCancelled = cancelCourseNoStudents(course);
                boolean trainerAssigned = false;
                if(!courseCancelled) {
                    for (Trainer trainer : trainers) {
                        trainerAssigned = trainerAssigned(course, trainer);
                        if (trainerAssigned) {
                            break;
                        }
                    }
                    coursesNotCancelled.add(course);
                    if(!trainerAssigned) {
                        extraTrainerNeeded(course);
                    }
                }
            }
            baseStream.setCoursesForThisStream(coursesNotCancelled);
        }
    }

    public boolean cancelCourseNoStudents(Course course) {
        if(course.getStudents().isEmpty()) {
            System.out.println(course.getCourseName() + " on " + course.getStartDate() + " has been cancelled as no students are available to attend");
            return true;
        }
        return false;
    }

    public boolean trainerAssigned(Course course, Trainer trainer) {
        if(trainer.getAvailableDate().isBefore(course.getStartDate()) || trainer.getAvailableDate().isEqual(course.getStartDate())) {
            course.setTrainer(trainer);
            trainer.setAvailableDate(course.getEndDate().plusDays(1));
            return true;
        }
        return false;
    }

    public void extraTrainerNeeded(Course course) {
        if(!course.getStudents().isEmpty()) {
            if(course.hasTrainer() == false){
                System.out.printf("There is no trainer available for %s; either find another resource or put students into a later course.\n", course.getCourseName());
            }
        }
    }
}
