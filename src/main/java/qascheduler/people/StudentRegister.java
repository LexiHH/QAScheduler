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
    private ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();

    public StudentRegister(int numberOfStudents, ArrayList<BaseStream> allStreams) {
        this.allStreams = allStreams;
        if(numberOfStudents > 26) {
            throw new IndexOutOfBoundsException();
        }
        else {
            register(numberOfStudents);
        }
        setEachStreamsStudents();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<BaseStream> getAllStreams() {
        return allStreams;
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

    public void setEachStreamsStudents() {
        HashMap<Streams,ArrayList<Student>> studentStreamMap = createStudentStreamMap();
        studentStreamMap = putStudentsInStreamMap(studentStreamMap);
        addStudentsToStream(studentStreamMap);
    }

    public HashMap<Streams,ArrayList<Student>> createStudentStreamMap() {
        HashMap<Streams,ArrayList<Student>> studentStreamMap = new HashMap<Streams, ArrayList<Student>>();
        for(Streams stream:Streams.values()) {
            ArrayList<Student> streamStudents = new ArrayList<Student>();
            studentStreamMap.put(stream, streamStudents);
        }
        return studentStreamMap;
    }

    public HashMap<Streams,ArrayList<Student>> putStudentsInStreamMap(HashMap<Streams,ArrayList<Student>> studentStreamMap) {
        for(Student student:students) {
            Streams stream = student.getStream();
            studentStreamMap.get(stream).add(student);
        }
        return studentStreamMap;
    }

    public void addStudentsToStream(HashMap<Streams,ArrayList<Student>> studentStreamMap) {
        for(BaseStream baseStream: allStreams) {
            for(Streams stream:studentStreamMap.keySet()) {
                if(baseStream.getStreamName().equals(stream)) {
                    baseStream.setStudentsForThisStream(studentStreamMap.get(stream));
                }
            }
        }
    }

    public void printStudentStreamEnrollments() {
        System.out.printf("%-40s%-40s%-12s%n", "Stream", "Student", "Enrollment Date");
        for(BaseStream baseStream: allStreams) {
            ArrayList<Student> students = baseStream.getStudentsForThisStream();
            String streamName = baseStream.getStreamName().toString().toLowerCase().replace("_", " ");
            streamName = streamName.substring(0,1).toUpperCase() + streamName.substring(1);
            System.out.printf("%-40s", streamName);
            if(students.isEmpty()) {
                System.out.printf("%-40s%-12s%n", "No Students", "N/A");
            }
            else {
                int firstStudent = 0;
                for(Student student:students) {
                    if(firstStudent == 0) {
                        System.out.printf("%-40s%-12s%n", student.getName(), student.getEnrollmentDate());
                        firstStudent ++;
                    }
                    else {
                        System.out.printf("%-40s%-40s%-12s%n", "", student.getName(), student.getEnrollmentDate());
                    }

                }
            }
        }
        System.out.println();
    }
}
