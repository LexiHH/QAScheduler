package qascheduler.streams;

public class DevOpsStream extends BaseStream {

    public DevOpsStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudentPerCourse(100);
        this.setChargePerStudentPerCourse(250);
    }
}
