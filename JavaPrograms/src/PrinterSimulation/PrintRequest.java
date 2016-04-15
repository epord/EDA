package PrinterSimulation;

import PriorityQueue.PriorityQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Pedro on 15/4/2016.
 */
public class PrintRequest {
    String printableInfo;
    int timeToProcess;

    public PrintRequest(String printableInfo) {
        this.printableInfo = printableInfo;
    }

    public void setTimeToProcess(int time) {
        timeToProcess = time;
    }

    public int getTimeToProcess() {
        return timeToProcess;
    }

    public String getPrintableInfo() {
        return printableInfo;
    }


}
