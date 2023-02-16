package delayOptionsTests;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.*;

//TODO: add javadocs
public class DelayOptionsTest_ConstructorAndType {
    private static final long TEST_VALUE = 50;
    private static final @NotNull DelayOptionsContainer
            CONTAINER_DEFAULT,
            CONTAINER_CUSTOM_VALUE,
            CONTAINER_FULLY_CUSTOM_MS,
            CONTAINER_FULLY_CUSTOM_FPS,
            CONTAINER_FULLY_CUSTOM_DEFAULT_TYPE;

    static {
        CONTAINER_DEFAULT = new DelayOptionsContainer("default") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions();
            }
        };
        CONTAINER_CUSTOM_VALUE = new DelayOptionsContainer("default type, custom value") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(TEST_VALUE);
            }
        };
        CONTAINER_FULLY_CUSTOM_MS = new DelayOptionsContainer("fully custom, MS") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(DelayType.DELAY_MS, TEST_VALUE);
            }
        };
        CONTAINER_FULLY_CUSTOM_FPS = new DelayOptionsContainer("fully custom, FPS") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(DelayType.FPS, TEST_VALUE);
            }
        };
        CONTAINER_FULLY_CUSTOM_DEFAULT_TYPE = new DelayOptionsContainer("fully custom, default type") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(null, TEST_VALUE);
            }
        };
    }

    /**
     * Main method of this test.
     * Run this to start.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        CONTAINER_DEFAULT.print();
        CONTAINER_CUSTOM_VALUE.print();
        CONTAINER_FULLY_CUSTOM_MS.print();
        CONTAINER_FULLY_CUSTOM_FPS.print();
        CONTAINER_FULLY_CUSTOM_DEFAULT_TYPE.print();
    }
}