package delayOptionsTests;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayOptions;

//TODO: finish this and add javadocs
public final class DelayOptionsTest_SetAndCopy extends AbstractDelayOptionsTest {
    private static final long
            TEST_VALUE_1 = 50,
            TEST_VALUE_2 = 200;

    /**
     * Main method of this test.
     * Run this to start.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new DelayOptionsTest_SetAndCopy();
    }

    private DelayOptionsTest_SetAndCopy() {
        super();
        addContainer("container 1", new DelayOptions(TEST_VALUE_1));
        addContainer("container 2", new DelayOptions(getFirstContainer().getDelayOptions()));
        print();

        //manually sets preferences
        setFirstContainerPreferences(TEST_VALUE_2);
        print();

        //copies preferences
        copyPreferences();
        print();

        //manually sets preferences again
        setFirstContainerPreferences(TEST_VALUE_1);
        print();
    }

    private @NotNull DelayOptionsContainer getFirstContainer() {
        return getContainer(0);
    }

    private @NotNull DelayOptionsContainer getSecondContainer() {
        return getContainer(1);
    }

    private void setFirstContainerPreferences(long value) {
        getFirstContainer().getDelayOptions().setPreferences(null, value);
    }

    private void copyPreferences() {
        getSecondContainer().getDelayOptions().setPreferences(getFirstContainer().getDelayOptions());
    }
}