package qascheduler.streams;

public class JavaStream extends BaseStream {

    public JavaStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudent(100.25);
        this.setFeePerStudent(250);
    }
}
