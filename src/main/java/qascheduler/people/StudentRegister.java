package qascheduler.people;

import qascheduler.streams.Streams;
import qascheduler.streams.BaseStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class StudentRegister {
    static String[] studentNames = {"Andrew", "Billy", "Charlotte", "Danielle", "Edward", "Fred", "Georgia", "Holly", "Isaac", "John", "Kelly", "Lisa", "Matthew", "Nigel", "Olivia", "Pippa", "Quinton", "Rupert", "Sarah", "Tina", "Umar", "Victor", "Wendy", "Xena", "Yosef", "Zoe"};
    static String[] enrollmentDates = {"2020-05-01", "2020-05-01", "2020-05-01", "2020-05-01", "2020-05-08", "2020-05-08", "2020-05-08", "2020-05-08", "2020-05-15", "2020-05-15", "2020-05-15", "2020-05-15", "2020-05-22", "2020-05-22", "2020-05-22", "2020-05-22", "2020-05-29", "2020-05-29", "2020-05-29", "2020-05-29", "2020-06-05", "2020-06-05", "2020-06-05", "2020-06-12", "2020-06-12", "2020-06-12"};
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<BaseStream> streamsWithCourses = new ArrayList<BaseStream>();

    public StudentRegister(int numberOfStudents, ArrayList<BaseStream> streamsWithCourses) {
        this.streamsWithCourses = streamsWithCourses;
        register(numberOfStudents);
        createStudentStreamMap();
    }

    public void register(int numberOfStudents) {
        for(int i = 0; i<numberOfStudents; i++) {
            String currentName = studentNames[i];
            Streams assignedStream = getStream();
            String enrollmentDate = enrollmentDates[i];
            students.add(new Student(currentName, assignedStream, enrollmentDate));
        }
    }

    public static Streams getStream() {
        Random random = new Random();
        int size = Streams.values().length;
        int randomInt = random.nextInt(size);
        Streams toReturn = Streams.values()[randomInt];
        return toReturn;
    }

    public void createStudentStreamMap() {
        HashMap<Streams,ArrayList<Student>> studentStreamMap = new HashMap<Streams, ArrayList<Student>>();
        for(Streams stream:Streams.values()) {
            ArrayList<Student> newStream = new ArrayList<Student>();
            studentStreamMap.put(stream, newStream);
        }
        putStudentsInStreamMap(studentStreamMap);
    }

    public void putStudentsInStreamMap(HashMap<Streams,ArrayList<Student>> studentStreamMap) {
        for(Student student:students) {
            Streams stream = student.getStream();
            studentStreamMap.get(stream).add(student);
        }
        addStudentsToStream(studentStreamMap);
    }

    public void addStudentsToStream(HashMap<Streams,ArrayList<Student>> studentStreamMap) {
        for(BaseStream baseStream:streamsWithCourses) {
            for(Streams stream:studentStreamMap.keySet()) {
                if(baseStream.getStreamName().equals(stream)) {
                    baseStream.setStudentsForThisStream(studentStreamMap.get(stream));
                }
            }
        }
    }

    public void printStudentStreamEnrollments() {
        for(BaseStream baseStream:streamsWithCourses) {
            ArrayList<Student> students = baseStream.getStudentsForThisStream();
            if(students.isEmpty()) {
                System.out.println("There are no students enrolled in the " + baseStream.getStreamName() + " stream.");
            }
            else {
                System.out.println("Students enrolled in the " + baseStream.getStreamName() + " are:");
                for(Student student:students) {
                    System.out.println(student.getName() + ", who enrolled on " + student.getEnrollmentDate());
                }
            }
            System.out.println();
        }
    }
}
