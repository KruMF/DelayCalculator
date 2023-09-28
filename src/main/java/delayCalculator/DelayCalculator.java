package delayCalculator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import delayCalculator.delayOptions.DelayOptions;

/**
 * TODO: finish javadocs
 */
public class DelayCalculator extends AbstractDelayCalculator {

    /**
     * Creates a DelayCalculator with default delay in milliseconds.
     */
    @SuppressWarnings("unused")
    public DelayCalculator() {
        this(null);
    }

    /**
     * Creates a DelayCalculator with specified DelayOptions.
     *      (Null DelayOptions -> default type and value)
     *
     * @param delayOptions Delay options object.
     */
    public DelayCalculator(@Nullable DelayOptions delayOptions) {
        super(delayOptions);
    }

    //TODO: add javadocs
    @Override
    public final void setOptions(@Nullable DelayOptions options) {
        super.setOptions(options);
    }

    //TODO: add javadocs
    @SuppressWarnings("unused")
    @Override
    public final @NotNull DelayOptions getOptions() {
        return super.getOptions();
    }

    /**
     * Starts measuring elapsed time.
     * Call this at the start of a cycle.
     */
    @Override
    public final void start() {
        super.start();
    }

    /**
     * Stops measuring elapsed time.
     * Call this at the end of a cycle.
     */
    @Override
    public final void end() {
        super.end();
    }

    /**
     * Gets the appropriate delay.
     * Call this when specifying delay for Thread.sleep().
     */
    @Override
    public final long getDelay() {
        return super.getDelay();
    }

    /**
     * Gets the elapsed time from start() to end() (one full cycle for continuous cycles).
     * Call this before start() or after end() for meaningful results.
     *
     * @return Elapsed time in milliseconds.
     */
    @Override
    public final long getElapsedTime() {
        return super.getElapsedTime();
    }
}