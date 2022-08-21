package DelayCalculatorTest;

import DelayCalculator.DelayCalculator;
import DelayCalculator.DelayOptions;
import DelayCalculator.PreferenceType;

import java.util.ArrayList;

import static DelayCalculatorTest.Utilities.printLine;

/**
 * A test class for testing the DelayCalculator
 * TODO: add javadocs where needed
 */
public class DelayTestThread extends Thread implements Runnable {
    private static final PreferenceType TESTING_TYPE = PreferenceType.DELAY_MS;
    private static final long TESTING_VALUE = 500L;

    /**
     * The main method. Run this to start.
     * Starts a new thread containing a DelayCalculator.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        (new DelayTestThread()).start();
    }

    private final DelayCalculator delayCalculator;

    DelayTestThread() {
        delayCalculator = new DelayCalculator(new DelayOptions(TESTING_TYPE, TESTING_VALUE));
    }

    /**
     * An infinite loop that does some calculations at a constant rate.
     * Constant rate indicates that the DelayCalculator is working correctly.
     * Prints delay info after each cycle, for run-time monitoring.
     */
    @SuppressWarnings({"BusyWait", "InfiniteLoopStatement"})
    @Override
    public void run() {
        while (true) {
            delayCalculator.start();
            someCalculations();
            delayCalculator.end();
            try {
                Thread.sleep(delayCalculator.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printDelayInfo();
        }
    }

    private void printDelayInfo() {
        printLine("Elapsed time (ms) : " + delayCalculator.getElapsedTime());
        printLine("Delay (ms) : " + delayCalculator.getDelay());
    }

    private void someCalculations() {
        printResults(getTestList());
    }

    private static ArrayList<TestCalculations> getTestList() {
        ArrayList<TestCalculations> list = new ArrayList<>();
        int memberCount = 5;
        for (int i = 0; i < memberCount; i++) {
            list.add(new TestCalculations(i));
        }
        return list;
    }

    private void printResults(ArrayList<TestCalculations> list) {
        for (TestCalculations member : list) {
            printLine(member.name + ", average: " + member.getAverage());
        }
    }
}