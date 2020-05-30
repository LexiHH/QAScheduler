package qascheduler.streams;

public class DevOpsStream extends BaseStream {

    public DevOpsStream() {
        super(Streams.DEVOPS_STREAM);
        this.costPerStudent = 100;
        this.feePerStudent = 250;
    }
}
