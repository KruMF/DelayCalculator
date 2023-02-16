package delayOptionsTests;

import delayCalculator.delayOptions.*;

/**
 * A DelayOptions test for testing various constructors and DelayType types.
 */
public final class DelayOptionsTest_ConstructorAndType extends AbstractDelayOptionsTest {
    private static final long TEST_VALUE = 50;

    /**
     * Main method of this test.
     * Run this to start.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new DelayOptionsTest_ConstructorAndType();
    }

    private DelayOptionsTest_ConstructorAndType() {
        super();
        addContainer("default", new DelayOptions());
        addContainer("default type, custom value", new DelayOptions(TEST_VALUE));
        addContainer("fully custom, MS", new DelayOptions(DelayType.DELAY_MS, TEST_VALUE));
        addContainer("fully custom, FPS", new DelayOptions(DelayType.FPS, TEST_VALUE));
        addContainer("fully custom, null type", new DelayOptions(null, TEST_VALUE));
        print();
    }
}