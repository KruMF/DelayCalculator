package delayCalculator;

import java.util.Date;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import delayCalculator.delayOptions.DelayOptions;

/**
 * TODO:
 *      * calculate average elapsed time over multiple cycles (see somewhere near the end of this file)
 *      * finish javadocs
 */
abstract class AbstractDelayCalculator {
    private static final long MINIMUM_DELAY = 0;

    protected DelayOptions options;
    private long
            startingTime,
            elapsedTime;

    /**
     * Creates a AbstractDelayCalculator with specified DelayOptions.
     *      (Null DelayOptions -> default type and value)
     *
     * @param delayOptions Delay options object.
     */
    public AbstractDelayCalculator(@Nullable DelayOptions delayOptions) {
        setOptions(delayOptions);
    }

    public void setOptions(@Nullable DelayOptions options) {
        if (options == null) {
            this.options = new DelayOptions();
        } else {
            this.options = options;
        }
    }

    public @NotNull DelayOptions getOptions() {
        return options;
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