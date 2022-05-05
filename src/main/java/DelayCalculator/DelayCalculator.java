package DelayCalculator;

import com.google.inject.internal.Nullable;

//TODO: finish this
public class DelayCalculator {


    private DelayOptions options;

    public DelayCalculator() {
        options = new DelayOptions();
    }

    public DelayCalculator(long delay) {
        options = new DelayOptions(delay);
    }

    public DelayCalculator(@Nullable DelayOptions delayOptions) {
        options = new DelayOptions(delayOptions);
    }



    //set max FPS/delay
    //get at start
    //get at end
    //return difference

    //calculate delay from difference and max

    public long getDelay() {
        return options.getPreferredMS();
    }

    //calculate average delta and corresponding delay



}