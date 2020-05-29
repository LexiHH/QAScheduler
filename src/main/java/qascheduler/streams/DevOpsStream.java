package qascheduler.streams;

public class DevOpsStream extends BaseStream {

    public DevOpsStream(Streams streamName) {
        super(streamName);
        this.costPerStudent = 100;
        this.feePerStudent = 250;
    }
}
