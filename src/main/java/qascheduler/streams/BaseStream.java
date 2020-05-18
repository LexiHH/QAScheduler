package qascheduler.streams;

import qascheduler.courses.Course;
import qascheduler.people.Student;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseStream implements IStream {
    ArrayList<Student> studentsForThisStream = new ArrayList<Student>();
    ArrayList<Course> coursesForThisStream = new ArrayList<Course>();
    Streams streamName;
    double costPerStudentPerCourse;
    double chargePerStudentPerCourse;

    public BaseStream() {
        System.out.println("No argument constructor of BaseStream called");
    }

    public BaseStream(Streams streamName) {
        this.streamName = streamName;
    }

    public ArrayList<Student> getStudentsForThisStream() {
        return studentsForThisStream;
    }

    public void setStudentsForThisStream(ArrayList<Student> studentsForThisStream) {
        this.studentsForThisStream = studentsForThisStream;
    }

    public ArrayList<Course> getCoursesForThisStream() {
        return coursesForThisStream;
    }

    public void setCoursesForThisStream(ArrayList<Course> coursesForThisStream) {
        this.coursesForThisStream = coursesForThisStream;
    }

    public Streams getStreamName() {
        return streamName;
    }

    public double getCostPerStudentPerCourse() {
        return costPerStudentPerCourse;
    }

    public double getChargePerStudentPerCourse() {
        return chargePerStudentPerCourse;
    }

    public void setCostPerStudentPerCourse(double costPerStudentPerCourse) {
        this.costPerStudentPerCourse = costPerStudentPerCourse;
    }

    public void setChargePerStudentPerCourse(double chargePerStudentPerCourse) {
        this.chargePerStudentPerCourse = chargePerStudentPerCourse;
    }

    @Override
    public HashMap<String, Double> calculateStreamCosts() {
        HashMap<String, Double> income = new HashMap<String, Double>();
        double numberOfCourseAttendees = (double)countStudents();
        double totalCost = numberOfCourseAttendees * this.getCostPerStudentPerCourse();
        double totalFee = numberOfCourseAttendees * this.getChargePerStudentPerCourse();
        income.put("Equipment", numberOfCourseAttendees);
        income.put("Cost", totalCost);
        income.put("Fees", totalFee);
        return income;
    }

    public int countStudents() {
        int numberOfStudents = this.getStudentsForThisStream().size();
        return numberOfStudents;
    }
}
