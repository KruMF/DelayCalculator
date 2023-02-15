package delayOptionsTest;

import org.jetbrains.annotations.NotNull;

import delayCalculator.DelayOptions;

//TODO: finish this
abstract class DelayOptionsContainer {
    private final @NotNull DelayOptions delayOptions;
    private final @NotNull String delayOptionsName;

    //TODO: add javadoc
    DelayOptionsContainer(@NotNull String delayOptionsName) {
        delayOptions = getInitialDelayOptions();
        this.delayOptionsName = delayOptionsName;
    }

    //TODO: add javadoc
    abstract @NotNull DelayOptions getInitialDelayOptions();

    //TODO: add javadoc
    final @NotNull DelayOptions getDelayOptions() {
        return delayOptions;
    }

    //TODO: finish this
    final void print() {
        String a = "delay options type: " + delayOptionsName;
        String b = "MS: " + delayOptions.getPreferredMS();
        String c = "FPS: " + delayOptions.getPreferredFPS();
    }
}