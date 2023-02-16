package delayOptionsTests;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayOptions;

//TODO: finish this and add javadocs
public class DelayOptionsTest_SetAndCopy {
    private static final long
            TEST_VALUE_1 = 50,
            TEST_VALUE_2 = 200;
    private static final @NotNull DelayOptionsContainer
            CONTAINER_1,
            CONTAINER_2;

    static {
        CONTAINER_1 = new DelayOptionsContainer("container 1") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(TEST_VALUE_1);
            }
        };

        CONTAINER_2 = new DelayOptionsContainer("container 2") {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(CONTAINER_1.getDelayOptions());
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
        printContainers();

        //manually sets preferences
        setPreferences_container1(TEST_VALUE_2);
        printContainers();

        //copies preferences
        CONTAINER_2.getDelayOptions().setPreferences(CONTAINER_1.getDelayOptions());
        printContainers();

        //manually sets preferences again
        setPreferences_container1(TEST_VALUE_1);
        printContainers();
    }

    private static void printContainers() {
        CONTAINER_1.print();
        CONTAINER_2.print();
    }

    private static void setPreferences_container1(long value) {
        CONTAINER_1.getDelayOptions().setPreferences(null, value);
    }
}