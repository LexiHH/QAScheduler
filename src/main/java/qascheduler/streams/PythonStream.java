package qascheduler.streams;

public class PythonStream extends BaseStream {

    public PythonStream() {
        super(Streams.PYTHON_STREAM);
        this.costPerStudent = 130.05;
        this.feePerStudent = 250;
    }
}
