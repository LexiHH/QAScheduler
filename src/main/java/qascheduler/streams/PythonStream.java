package qascheduler.streams;

public class PythonStream extends BaseStream {

    public PythonStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudent(130.05);
        this.setFeePerStudent(250);
    }
}
