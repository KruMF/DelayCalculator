package delayCalculator;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A class for storing and handling delay preferences.
 */
public class DelayOptions {
    private @NotNull DelayPreference preferences;

    /**
     * Creates delay options with default value in milliseconds.
     */
    public DelayOptions() {
        preferences = new DelayPreference();
    }

    /**
     * Creates delay options with specified value in milliseconds.
     *
     * @param delay Milliseconds.
     */
    public DelayOptions(long delay) {
        this(null, delay);
    }

    /**
     * Creates delay options with specified value and specified type.
     *
     * @param delayType Type.
     * @param preferredValue Value.
     */
    public DelayOptions(@Nullable DelayType delayType, long preferredValue) {
        preferences = new DelayPreference(delayType, preferredValue);
    }

    /**
     * Copies delay options.
     *
     * @param delayOptions DelayOptions object. (Null - default options)
     */
    public DelayOptions(@Nullable DelayOptions delayOptions) {
        preferences = getPreferences(delayOptions);
    }

    private static @NotNull DelayPreference getPreferences(@Nullable DelayOptions delayOptions) {
        if (delayOptions == null) {
            return new DelayPreference();
        } else {
            return delayOptions.preferences;
        }
    }

    /**
     * Copy preferences from a DelayOptions object.
     *
     * @param delayOptions DelayOptions object.
     */
    public final void setPreferences(@Nullable DelayOptions delayOptions) {
        preferences = getPreferences(delayOptions);
    }

    /**
     * Manually set preferences by type and value.
     *
     * @param delayType      Type.
     * @param preferredValue Value.
     */
    public final void setPreferences(@Nullable DelayType delayType, long preferredValue) {
        preferences = new DelayPreference(delayType, preferredValue);
    }

    /**
     * Get preferred delay in milliseconds.
     *
     * @return Preferred delay in milliseconds.
     */
    public final long getPreferredMS() {
        switch (preferences.getDelayType()) {
            case DELAY_MS -> {
                return preferences.getValue();
            }
            case FPS -> {
                return UnitConversion.convertFPStoMS(preferences.getValue());
            }
            //Add new types here.
            default -> {
                return DelayPreference.DEFAULT_VALUE;
            }
        }
    }

    /**
     * Get preferred frames-per-second.
     *
     * @return Preferred frames-per-second.
     */
    public final long getPreferredFPS() {
        switch (preferences.getDelayType()) {
            case DELAY_MS -> {
                return UnitConversion.convertMStoFPS(preferences.getValue());
            }
            case FPS -> {
                return preferences.getValue();
            }
            //Add new types here.
            default -> {
                return DelayPreference.DEFAULT_VALUE;
            }
        }
    }
}