package qascheduler.streams;

import qascheduler.courses.Course;
import qascheduler.people.Student;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BaseStream implements IStream {
    protected ArrayList<Student> studentsForThisStream = new ArrayList<Student>();
    protected ArrayList<Course> coursesForThisStream = new ArrayList<Course>();
    protected Streams streamName;
    protected double costPerStudent;
    protected double feePerStudent;

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

    public double getCostPerStudent() {
        return costPerStudent;
    }

    public double getFeePerStudent() {
        return feePerStudent;
    }

    @Override
    public HashMap<String, Double> calculateStreamCosts() {
        HashMap<String, Double> income = new HashMap<String, Double>();
        double numberOfStudentsInStream = (double)countStudents();
        double totalCost = numberOfStudentsInStream * this.getCostPerStudent();
        double totalFee = numberOfStudentsInStream * this.getFeePerStudent();
        income.put("Equipment", numberOfStudentsInStream);
        income.put("Cost", totalCost);
        income.put("Fees", totalFee);
        return income;
    }

    public int countStudents() {
        int numberOfStudents = this.getStudentsForThisStream().size();
        return numberOfStudents;
    }
}
