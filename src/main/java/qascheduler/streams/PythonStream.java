package qascheduler.streams;

public class PythonStream extends BaseStream {

    public PythonStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudentPerCourse(130.05);
        this.setChargePerStudentPerCourse(250);
    }
}
