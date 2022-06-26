package DelayCalculator;

import java.util.Date;

import org.jetbrains.annotations.Nullable;

/**
 * TODO:
 *      * calculate average elapsed time over multiple cycles (see somewhere near the end of this file)
 *      * finish javadocs
 */
public class DelayCalculator {

    private static final long MINIMUM_DELAY = 0;

    private DelayOptions options;
    private long
            startingTime,
            elapsedTime;

    /**
     * Creates a DelayCalculator with default delay in milliseconds.
     */
    @SuppressWarnings("unused")
    public DelayCalculator() {
        options = new DelayOptions();
    }

    /**
     * Creates a DelayCalculator with delay specified in milliseconds.
     *
     * @param delay Delay in milliseconds.
     */
    @SuppressWarnings("unused")
    public DelayCalculator(long delay) {
        options = new DelayOptions(delay);
    }

    /**
     * Creates a DelayCalculator with specified DelayOptions.
     *      (Null DelayOptions -> default type and value)
     *
     * @param delayOptions Delay options object.
     */
    @SuppressWarnings("unused")
    public DelayCalculator(@Nullable DelayOptions delayOptions) {
        options = new DelayOptions(delayOptions);
    }

    /**
     * Starts measuring elapsed time.
     * Call this at the start of a cycle.
     */
    public void start() {
        startingTime = getCurrentTime();
    }

    /**
     * Stops measuring elapsed time.
     * Call this at the end of a cycle.
     */
    public void end() {
        elapsedTime = getCurrentTime() - startingTime;
    }

    private static long getCurrentTime() {
        return (new Date()).getTime();
    }

    /**
     * Gets the appropriate delay.
     * Call this when specifying delay for Thread.sleep().
     */
    public long getDelay() {
        return Math.max(
                MINIMUM_DELAY,
                options.getPreferredMS() - elapsedTime);
    }

    /**
     * Gets the elapsed time from start() to end() (one full cycle for continuous cycles).
     * Call this before start() or after end() for meaningful results.
     *
     * @return Elapsed time in milliseconds.
     */
    public long getElapsedTime() {
        return elapsedTime;
    }

    //TODO: calculate average elapsed time over multiple cycles
}