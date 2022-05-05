package DelayCalculator;

import java.util.Objects;

import com.google.inject.internal.Nullable;

public class DelayOptions {
    private static final PreferenceType DEFAULT_PREFERENCE_TYPE = PreferenceType.DELAY_MS;
    private static final long DEFAULT_DELAY = 100L;

    private PreferenceType preferenceType;
    private long preferredValue;

    public DelayOptions() {
        this(DEFAULT_DELAY);
    }

    public DelayOptions(long delay) {
        this(PreferenceType.DELAY_MS, delay);
    }

    public DelayOptions(PreferenceType preferenceType, long preferredValue) {
        setPreferences(preferenceType, preferredValue);
    }

    public DelayOptions(@Nullable DelayOptions delayOptions) {
        setPreferences(delayOptions);
    }

    public void setPreferences(@Nullable DelayOptions delayOptions) {
        DelayOptions nonNullDelayOptions = delayOptionNullCheck(delayOptions);
        setPreferences(nonNullDelayOptions.preferenceType, nonNullDelayOptions.preferredValue);
    }

    private static DelayOptions delayOptionNullCheck(@Nullable DelayOptions delayOptions) {
        return Objects.requireNonNullElse(delayOptions, new DelayOptions());
    }

    public void setPreferences(PreferenceType preferenceType, long preferredValue) {
        this.preferenceType = preferenceType;
        this.preferredValue = preferredValue;
    }

    public long getPreferredMS() {
        switch (preferenceType) {
            case DELAY_MS -> {
                return preferredValue;
            }
            case FPS -> {
                return Utilities.convertFPStoMS(preferredValue);
            }
            //Add new types here.
            default -> {
                return DEFAULT_DELAY;
            }
        }
    }

    public long getPreferredFPS() {
        switch (preferenceType) {
            case DELAY_MS -> {
                return Utilities.convertMStoFPS(preferredValue);
            }
            case FPS -> {
                return preferredValue;
            }
            //Add new types here.
            default -> {
                return DEFAULT_DELAY;
            }
        }
    }
}