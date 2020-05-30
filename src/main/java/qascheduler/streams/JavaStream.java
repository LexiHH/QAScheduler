package qascheduler.streams;

public class JavaStream extends BaseStream {

    public JavaStream() {
        super(Streams.JAVA_STREAM);
        this.costPerStudent = 100.25;
        this.feePerStudent = 250;
    }
}
