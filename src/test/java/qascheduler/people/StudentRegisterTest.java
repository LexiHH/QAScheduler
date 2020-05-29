package qascheduler.people;

import org.junit.jupiter.api.Test;
import qascheduler.streams.BaseStream;
import qascheduler.streams.StreamHandler;
import qascheduler.streams.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegisterTest {

    StreamHandler streamHandler = new StreamHandler();
    ArrayList<BaseStream> allStreams = streamHandler.getAllStreams();

    @Test
    void registeringNoStudentsNoError() {
        StudentRegister studentsOf2020 = new StudentRegister(0, allStreams);
        int numberOfStudents = studentsOf2020.getStudents().size();
        assertEquals(0, numberOfStudents);
    }

    @Test
    void registering26StudentsAddsToArraySuccessfully() {
        StudentRegister studentsOf2020 = new StudentRegister(26, allStreams);
        int numberOfStudents = studentsOf2020.getStudents().size();
        assertEquals(26, numberOfStudents);
    }

    @Test
    void moreThan26StudentsThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> new StudentRegister(28, allStreams));
    }

    @Test
    void getStreamReturningValidStream () {
        boolean valid = false;
        Streams stream = StudentRegister.getStream();
        for(Streams each: Streams.values()) {
            if(stream.equals(each)) {
                valid = true;
            }
        }
        assertTrue(valid);
    }

    @Test
    void setEachStreamsStudents() {
        int numberOfStudents = 26;
        StudentRegister studentsOf2020 = new StudentRegister(numberOfStudents, allStreams);
        int count = 0;
        for(BaseStream baseStream: allStreams) {
            count += baseStream.getStudentsForThisStream().size();
        }
        assertEquals(numberOfStudents, count);
    }

    @Test
    void createStudentStreamMapUsesAllStreams() {
        StudentRegister studentsOf2020 = new StudentRegister(26, allStreams);
        HashMap<Streams,ArrayList<Student>> studentStreamMap = studentsOf2020.createStudentStreamMap();
        Streams[] streamsEnumArray = Streams.values();
        Arrays.sort(streamsEnumArray);
        Streams[] hashMapStreamArray = studentStreamMap.keySet().toArray(new Streams[studentStreamMap.keySet().size()]);
        Arrays.sort(hashMapStreamArray);
        assertArrayEquals(streamsEnumArray, hashMapStreamArray);
    }

    @Test
    void putStudentsInStreamMapAddsAllStudents() {
        int numberOfStudents = 26;
        StudentRegister studentsOf2020 = new StudentRegister(numberOfStudents, allStreams);
        HashMap<Streams,ArrayList<Student>> studentStreamMap = studentsOf2020.createStudentStreamMap();
        studentStreamMap = studentsOf2020.putStudentsInStreamMap(studentStreamMap);
        int countStudents = 0;
        for(Streams stream:studentStreamMap.keySet()) {
            countStudents += studentStreamMap.get(stream).size();
        }
        assertEquals(numberOfStudents, countStudents);
    }

    @Test
    void addStudentsToStreamAddsAllStudents() {
        int numberOfStudents = 26;
        StudentRegister studentsOf2020 = new StudentRegister(numberOfStudents, allStreams);
        int count = 0;
        for(BaseStream baseStream:allStreams) {
            count += baseStream.getStudentsForThisStream().size();
        }
        assertEquals(numberOfStudents, count);
    }

    @Test
    void studentsAddedToCorrectStreams() {
        int numberOfStudents = 26;
        StudentRegister studentsOf2020 = new StudentRegister(numberOfStudents, allStreams);
        int count = 0;
        for(BaseStream baseStream:allStreams) {
            for(Student student: baseStream.getStudentsForThisStream()) {
                if(baseStream.getStreamName() == student.getStream()) {
                    count ++;
                }
            }
        }
        assertEquals(numberOfStudents, count);
    }
}