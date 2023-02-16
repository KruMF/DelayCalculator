package delayCalculator.delayOptions;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A class for handling delay type and reference value.
 */
final class DelayPreference {
    private static final @NotNull DelayType DEFAULT_TYPE = DelayType.DELAY_MS;
    static final long DEFAULT_VALUE = 100L; //milliseconds
    private final @NotNull DelayType delayType;
    private final long value;

    /**
     * Creates DelayPreference object with default preferences.
     */
    DelayPreference() {
        this(null, DEFAULT_VALUE);
    }

    /**
     * Creates DelayPreference object with custom preferences.
     *
     * @param delayType Delay type.
     * @param value     Reference value.
     */
    DelayPreference(@Nullable DelayType delayType, long value) {
        this.delayType = Objects.requireNonNullElse(delayType, DEFAULT_TYPE);
        this.value = Math.max(value, 0);
    }

    /**
     * Gets the delay type.
     *
     * @return Delay type.
     */
    @NotNull DelayType getDelayType() {
        return delayType;
    }

    /**
     * Gets the reference value.
     *
     * @return Reference value.
     */
    long getValue() {
        return value;
    }
}