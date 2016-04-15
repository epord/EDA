package PrinterSimulation;

import java.util.Random;

/**
 * Created by Pedro on 15/4/2016.
 */
public class Test {

    public static void main(String[] args) {
        float arrivalProbability = 0.5f;
        int minServiceTime = 2;
        int maxServiceTime = 12;
        int simulationTime = 100;

        String[] printInfos = {"This is an impression.", "Hey! I'm printing som text!!", "Hello World",
                                    "Wasting paper lika a boss... 8)", "Free printer... Let's use it!",
                                    "Printing some homework...", "No! Please no!"};

        Random rnd = new Random(System.currentTimeMillis());

        Printer printer = new Printer();
        Server server = new Server(printer, minServiceTime, maxServiceTime);

        for (int i = 0; i < simulationTime; i++) {
            if (rnd.nextFloat() < arrivalProbability) {
                PrintRequest printRequest = new PrintRequest(printInfos[Math.abs(rnd.nextInt()) % printInfos.length]);
                server.addPrintRequest(printRequest);
            }
            server.processPrintRequest();
        }


//        int currentTime = 1;
//        while (currentTime <= simulationTime) {
//            if (rnd.nextFloat() < arrivalProbability) {
//                PrintRequest printRequest = new PrintRequest(printInfos[Math.abs(rnd.nextInt()) % printInfos.length]);
//                server.addPrintRequest(printRequest);
//            }
//            currentTime += server.processPrintRequest();
//        }
        System.out.printf("\n");
        server.printPrinterInformation();
    }

}
