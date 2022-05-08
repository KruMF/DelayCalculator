package DelayCalculator;

import java.util.Date;

import com.google.inject.internal.Nullable;

//TODO: finish this and add javadoc
public class DelayCalculator {

    private static final long MINIMUM_DELAY = 0;

    private DelayOptions options;
    private long
            startingTime,
            elapsedTime;

    @SuppressWarnings("unused")
    public DelayCalculator() {
        options = new DelayOptions();
    }

    @SuppressWarnings("unused")
    public DelayCalculator(long delay) {
        options = new DelayOptions(delay);
    }

    @SuppressWarnings("unused")
    public DelayCalculator(@Nullable DelayOptions delayOptions) {
        options = new DelayOptions(delayOptions);
    }

    public void start() {
        startingTime = getCurrentTime();
    }

    public void end() {
        elapsedTime = getCurrentTime() - startingTime;
    }

    private static long getCurrentTime() {
        return (new Date()).getTime();
    }

    public long getDelay() {
        return Math.max(
                MINIMUM_DELAY,
                options.getPreferredMS() - elapsedTime);
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    //TODO: calculate average elapsed time
}