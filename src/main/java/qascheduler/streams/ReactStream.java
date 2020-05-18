package qascheduler.streams;

public class ReactStream extends BaseStream {

    public ReactStream(Streams streamName) {
        super(streamName);
        this.setCostPerStudentPerCourse(220.50);
        this.setChargePerStudentPerCourse(350);
    }
}
