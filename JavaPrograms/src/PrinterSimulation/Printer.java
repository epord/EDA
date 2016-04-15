package PrinterSimulation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Pedro on 15/4/2016.
 */
public class Printer {

    public void print(PrintRequest printRequest) {
        System.out.println(printRequest.getPrintableInfo());
    }
}
