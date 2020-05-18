package qascheduler.streams;

public class NetworkSecurityStream extends BaseStream {

    public NetworkSecurityStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudentPerCourse(120);
        this.setChargePerStudentPerCourse(250);
    }
}
