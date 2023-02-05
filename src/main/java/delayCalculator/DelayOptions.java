package delayCalculator;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A class for storing and handling delay preferences.
 */
public class DelayOptions {
    private static final @NotNull PreferenceType DEFAULT_PREFERENCE_TYPE = PreferenceType.DELAY_MS;
    private static final long DEFAULT_DELAY = 100L;

    private PreferenceType preferenceType;
    private long preferredValue;

    /**
     * Creates delay options with default value in milliseconds.
     */
    public DelayOptions() {
        this(DEFAULT_DELAY);
    }

    /**
     * Creates delay options with specified value in milliseconds.
     *
     * @param delay Milliseconds.
     */
    public DelayOptions(long delay) {
        this(DEFAULT_PREFERENCE_TYPE, delay);
    }

    /**
     * Creates delay options with specified value and specified type.
     *
     * @param preferenceType Type.
     * @param preferredValue Value.
     */
    public DelayOptions(PreferenceType preferenceType, long preferredValue) {
        setPreferences(preferenceType, preferredValue);
    }

    /**
     * Copies delay options (or creates new with default values, if null).
     *
     * @param delayOptions DelayOptions object.
     */
    @SuppressWarnings("unused")
    public DelayOptions(@Nullable DelayOptions delayOptions) {
        setPreferences(delayOptions);
    }

    /**
     * Manually set preferences from delay options.
     *
     * @param delayOptions DelayOptions object.
     */
    public void setPreferences(@Nullable DelayOptions delayOptions) {
        DelayOptions nonNullDelayOptions = delayOptionNullCheck(delayOptions);
        setPreferences(nonNullDelayOptions.preferenceType, nonNullDelayOptions.preferredValue);
    }

    private static DelayOptions delayOptionNullCheck(@Nullable DelayOptions delayOptions) {
        return Objects.requireNonNullElse(delayOptions, new DelayOptions());
    }

    /**
     * Manually set preferences from preferred value and preferred type.
     *
     * @param preferenceType Type.
     * @param preferredValue Value.
     */
    public void setPreferences(PreferenceType preferenceType, long preferredValue) {
        this.preferenceType = preferenceType;
        this.preferredValue = preferredValue;
    }

    /**
     * Get preferred delay in milliseconds.
     *
     * @return Preferred delay in milliseconds.
     */
    public long getPreferredMS() {
        switch (preferenceType) {
            case DELAY_MS -> {
                return preferredValue;
            }
            case FPS -> {
                return UnitConversion.convertFPStoMS(preferredValue);
            }
            //Add new types here.
            default -> {
                return DEFAULT_DELAY;
            }
        }
    }

    /**
     * Get preferred frames-per-second.
     *
     * @return Preferred frames-per-second.
     */
    public long getPreferredFPS() {
        switch (preferenceType) {
            case DELAY_MS -> {
                return UnitConversion.convertMStoFPS(preferredValue);
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