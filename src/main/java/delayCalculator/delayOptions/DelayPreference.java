package delayCalculator.delayOptions;

import java.util.Objects;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//TODO: add javadocs
class DelayPreference {
    private static final @NotNull DelayType DEFAULT_TYPE = DelayType.DELAY_MS;
    protected static final long DEFAULT_VALUE = 100L; //milliseconds
    private final @NotNull DelayType delayType;
    private final long value;

    //TODO: add javadoc
    protected DelayPreference() {
        this(null, DEFAULT_VALUE);
    }

    //TODO: add javadoc
    protected DelayPreference(@Nullable DelayType delayType, long value) {
        this.delayType = Objects.requireNonNullElse(delayType, DEFAULT_TYPE);
        this.value = Math.max(value, 0);
    }

    //TODO: add javadoc
    protected final @NotNull DelayType getDelayType() {
        return delayType;
    }

    //TODO: add javadoc
    protected final long getValue() {
        return value;
    }
}