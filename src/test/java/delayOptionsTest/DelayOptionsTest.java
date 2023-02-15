package delayOptionsTest;

import org.jetbrains.annotations.NotNull;

import delayCalculator.DelayOptions;

//TODO: finish this
public class DelayOptionsTest extends AbstractDelayOptionsTest {

    //by constructor:
    //delayoptions() - default
    //delayoptions(delay) - default type, custom value
    //delayoptions(type, value) - fully custom
    //delayoptions(delayoptions) - copied

    //by type:
    //delayoptions_ms
    //delayoptions_fps
    //delayoptions_undefined

    //methods:
    //setPreferences(delayoptions) - copy
    //setPreferences(type, value) - custom
    //geyPreferredMS()
    //geyPreferredFPS()

    /**
     * Main method of this test.
     * Run this to start.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new DelayOptionsTest();
    }

    //
    DelayOptionsTest() {
        super();
    }

    //
    @Override
    final @NotNull DelayOptions getInitialDelayOptions() {
        return null;//
    }
}

//
abstract class AbstractDelayOptionsTest {
    private final @NotNull DelayOptions delayOptions;

    //
    AbstractDelayOptionsTest() {
        delayOptions = getInitialDelayOptions();
    }

    //
    abstract @NotNull DelayOptions getInitialDelayOptions();

    //
    final @NotNull DelayOptions getDelayOptions() {
        return delayOptions;
    }
}