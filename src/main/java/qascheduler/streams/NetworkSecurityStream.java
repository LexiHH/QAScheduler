package qascheduler.streams;

public class NetworkSecurityStream extends BaseStream {

    public NetworkSecurityStream() {
        super(Streams.NETWORK_SECURITY_STREAM);
        this.costPerStudent = 120;
        this.feePerStudent = 250;
    }
}
