package qascheduler.streams;

public class JavaStream extends BaseStream {

    public JavaStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudentPerCourse(100.25);
        this.setChargePerStudentPerCourse(250);
    }
}
