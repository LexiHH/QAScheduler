package qascheduler.streams;

import java.util.ArrayList;
import java.util.HashMap;

public class StreamHandler {
    private ArrayList<BaseStream> allStreams = new ArrayList<BaseStream>();

    public StreamHandler() {
        createStreamsArray();
    }

    public ArrayList<BaseStream> getAllStreams() {
        return allStreams;
    }

    public void createStreamsArray() {
        allStreams.add(new DevOpsStream());
        allStreams.add(new JavaStream());
        allStreams.add(new NetworkSecurityStream());
        allStreams.add(new PythonStream());
        allStreams.add(new ReactStream());
    }

    public void printStreamCosts() {
        double totalStreamOutgoings = 0;
        double totalStreamIncome = 0;
        double totalStudents = 0;
        for(BaseStream baseStream:allStreams) {
            HashMap<String, Double> income = new HashMap<String, Double>();
            income = baseStream.calculateStreamCosts();
            totalStudents += income.get("Equipment");
            totalStreamOutgoings += income.get("Cost");
            totalStreamIncome += income.get("Fees");
        }
        System.out.printf("For all streams combined, a total of %.0f laptops will be required. The total income will be £%.2f, the total cost will be £%.2f, and therefore the total profit will be £%.2f%n", totalStudents, totalStreamIncome, totalStreamOutgoings, (totalStreamIncome - totalStreamOutgoings));
    }
}
