package qascheduler.people;

import qascheduler.Streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class StudentRegister {
    static String[] studentNames = {"Andrew", "Billy", "Charlotte", "Danielle", "Edward", "Fred", "Georgia", "Holly", "Isaac", "John", "Kelly", "Lisa", "Matthew", "Nigel", "Olivia", "Pippa", "Quinton", "Rupert", "Sarah", "Tina", "Umar", "Victor", "Wendy", "Xena", "Yosef", "Zoe"};
    static String[] enrollmentDates = {"2020-05-01", "2020-05-01", "2020-05-01", "2020-05-01", "2020-05-08", "2020-05-08", "2020-05-08", "2020-05-08", "2020-05-15", "2020-05-15", "2020-05-15", "2020-05-15", "2020-05-22", "2020-05-22", "2020-05-22", "2020-05-22", "2020-05-29", "2020-05-29", "2020-05-29", "2020-05-29", "2020-06-05", "2020-06-05", "2020-06-05", "2020-06-12", "2020-06-12", "2020-06-12"};
    private ArrayList<Student> students = new ArrayList<Student>();
    private HashMap<Streams,ArrayList<Student>> studentStreamMap = new HashMap<Streams, ArrayList<Student>>();

    public StudentRegister(int numberOfStudents) {
        register(numberOfStudents);
        createStudentStreamMap();
        putStudentsInStreamMap();
    }

    public HashMap<Streams, ArrayList<Student>> getStudentStreamMap() {
        return studentStreamMap;
    }

    public void register(int numberOfStudents) {
        for(int i = 0; i<numberOfStudents; i++) {
            String currentName = studentNames[i];
            Streams assignedStream = getStream();
            String enrollmentDate = enrollmentDates[i];
            students.add(new Student(currentName, assignedStream, enrollmentDate));
        }
    }

    public Streams getStream() {
        Random random = new Random();
        int size = Streams.values().length;
        int randomInt = random.nextInt(size);
        Streams toReturn = Streams.values()[randomInt];
        return toReturn;
    }

    public void createStudentStreamMap() {
        for(Streams stream:Streams.values()) {
            ArrayList<Student> newStream = new ArrayList<Student>();
            studentStreamMap.put(stream, newStream);
        }
    }

    public void putStudentsInStreamMap() {
        for(Student student:students) {
            Streams stream = student.getStream();
            studentStreamMap.get(stream).add(student);
        }
    }
}
