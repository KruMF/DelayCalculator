package DelayCalculatorTest;

import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import delayCalculator.DelayType;
import delayCalculator.DelayOptions;
import delayCalculator.DelayCalculator;

/**
 * A test class for testing the DelayCalculator
 */
public class DelayTestThread extends Thread implements Runnable {
    private static final @NotNull TestParameters TEST_PARAMETERS = new TestParameters(
            DelayType.DELAY_MS, 500L,
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

    private final @NotNull DelayCalculator delayCalculator;
    private final @NotNull Output output;

    private DelayTestThread() {
        delayCalculator = new DelayCalculator(new DelayOptions(
                TEST_PARAMETERS.testingType(),
                TEST_PARAMETERS.testingValue()));
        output = new Output();
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
            output.addCalculationResults(someCalculations(
                    TEST_PARAMETERS.displayableMemberCount(),
                    TEST_PARAMETERS.innerMemberCount()));
            delayCalculator.end();
            try {
                Thread.sleep(delayCalculator.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            output.addDelayInfo(delayCalculator);
            output.print();
        }
    }

    private @NotNull ArrayList<@NotNull TestCalculations> someCalculations(int displayableMemberCount,
                                                                           int innerMemberCount) {
        @NotNull ArrayList<@NotNull TestCalculations> list = new ArrayList<>();
        for (int i = 0; i < displayableMemberCount; i++) {
            list.add(new TestCalculations(i, innerMemberCount));
        }
        return list;
    }
}