package PrinterSimulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Pedro on 15/4/2016.
 */
public class Server {
    private Queue<PrintRequest> printRequests = new LinkedList<>();
    private Printer printer = new Printer();
    private int minServiceTime, maxServiceTime;
    private Random rnd = new Random(System.currentTimeMillis());

    // Current Printing Data
    private PrintRequest currentPrintRequest;

    // Print information
    private int cantPrintDocuments = 0;
    private int totalTimeElapsed = 0;
    private int acumQueueLength = 0;
    private int currentQueueLength = 0;

    public Server(Printer printer, int minServiceTime, int maxServiceTime) {
        this.printer = printer;
        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
    }

    public void addPrintRequest(PrintRequest printRequest) {
        printRequests.add(printRequest);
        currentQueueLength++;
    }


    /**
     * Server processes the next request and send it to the printer to print it
     *
     * @author Pedro_Balaguer
     * @return amount of time that took the procession

     */
    public void processPrintRequest() {
        if (printRequests.peek() == null && currentPrintRequest == null) { // it takes 1 unit of time to check if
            return;                                                      // there is a print request to process
        }

        if (currentPrintRequest == null) {
            currentPrintRequest = printRequests.poll();
            currentPrintRequest.setTimeToProcess((int)(rnd.nextFloat()*(maxServiceTime - minServiceTime) + minServiceTime));
            currentQueueLength--;
        }

        currentPrintRequest.setTimeToProcess(currentPrintRequest.getTimeToProcess() - 1);

        if (currentPrintRequest.getTimeToProcess() == 0){
            printer.print(currentPrintRequest);
            currentPrintRequest = null;
            cantPrintDocuments++;
        }

        acumQueueLength += currentQueueLength;
        totalTimeElapsed++;
//        printer.print(printRequests.poll());
//        cantPrintDocuments++;
//        int timeElapsed = (int)(rnd.nextFloat()*(maxServiceTime - minServiceTime) + minServiceTime) + 1;
//        totalTimeElapsed += timeElapsed;
//        return timeElapsed;
    }

    public void printPrinterInformation() {
        System.out.println("Total documents printed: " + cantPrintDocuments);
        System.out.println("Average time per request: " + (float)totalTimeElapsed / cantPrintDocuments);
        System.out.println("Average queued elements: " + (float)acumQueueLength / totalTimeElapsed);
    }

    public void resetPrinterInformation() {
        cantPrintDocuments = 0;
        totalTimeElapsed = 0;
    }
}
