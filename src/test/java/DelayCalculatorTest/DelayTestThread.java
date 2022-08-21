package DelayCalculatorTest;

import DelayCalculator.DelayCalculator;
import DelayCalculator.DelayOptions;
import DelayCalculator.PreferenceType;

import java.util.ArrayList;

import static consoleUtils.ConsoleUtils.printLine;

/**
 * A test class for testing the DelayCalculator
 */
public class DelayTestThread extends Thread implements Runnable {
    private static final TestParameters TEST_PARAMETERS = new TestParameters(
            PreferenceType.DELAY_MS, 500L,
            3, 1000000);

    /**
     * The main method of the test. Run this to start.
     * Starts a new thread containing a DelayCalculator.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        (new DelayTestThread()).start();
    }

    private final DelayCalculator delayCalculator;

    private DelayTestThread() {
        delayCalculator = new DelayCalculator(new DelayOptions(
                TEST_PARAMETERS.testingType(), TEST_PARAMETERS.testingValue()));
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
            printResults(someCalculations(
                    TEST_PARAMETERS.displayableMemberCount(),
                    TEST_PARAMETERS.innerMemberCount()));
            delayCalculator.end();
            try {
                Thread.sleep(delayCalculator.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printDelayInfo();
        }
    }

    private ArrayList<TestCalculations> someCalculations(int displayableMemberCount,
                                                         int innerMemberCount) {
        ArrayList<TestCalculations> list = new ArrayList<>();
        for (int i = 0; i < displayableMemberCount; i++) {
            list.add(new TestCalculations(i, innerMemberCount));
        }
        return list;
    }

    private void printResults(ArrayList<TestCalculations> list) {
        for (TestCalculations member : list) {
            printLine(member.getName() + ", average: " + member.getAverage());
        }
    }

    private void printDelayInfo() {
        printLine("Elapsed time (ms) : " + delayCalculator.getElapsedTime());
        printLine("Delay (ms) : " + delayCalculator.getDelay());
    }
}