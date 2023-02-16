package delayOptionsTests;

import org.jetbrains.annotations.NotNull;

import consoleUtils.bufferedPrinting.BufferSection;
import consoleUtils.bufferedPrinting.AbstractConsoleBuffer;
import consoleUtils.bufferedPrinting.SingleSectionConsoleBuffer;

import delayCalculator.delayOptions.DelayOptions;

//TODO: finish this and add javadocs
abstract class DelayOptionsContainer {
    private final @NotNull DelayOptions delayOptions;
    private final @NotNull AbstractConsoleBuffer consoleBuffer;

    /**
     * TODO: finish this javadoc
     */
    protected DelayOptionsContainer(@NotNull String delayOptionsName) {
        delayOptions = getInitialDelayOptions();
        consoleBuffer = new SingleSectionConsoleBuffer(
                new DelayOptionsBufferSection(delayOptionsName, this)
        );
    }

    /**
     * TODO: finish this javadoc
     */
    protected abstract @NotNull DelayOptions getInitialDelayOptions();

    /**
     * TODO: finish this javadoc
     */
    protected final @NotNull DelayOptions getDelayOptions() {
        return delayOptions;
    }

    /**
     * TODO: finish this javadoc
     */
    protected final void print() {
        consoleBuffer.print();
    }

    /**
     * TODO: finish this javadoc
     */
    private static final class DelayOptionsBufferSection extends BufferSection {
        private final @NotNull String delayOptionsName;
        private final @NotNull DelayOptionsContainer container;

        /**
         * TODO: finish this javadoc
         */
        private DelayOptionsBufferSection(@NotNull String delayOptionsName,
                                          @NotNull DelayOptionsContainer container) {
            super();
            this.delayOptionsName = delayOptionsName;
            this.container = container;
        }

        /**
         * Gets the contents of this buffer section.
         * Override this to set the actual contents.
         */
        @Override
        public void getContents() {
            addLine("Delay options type: " + delayOptionsName);
            @NotNull DelayOptions delayOptions = container.getDelayOptions();
            addLine("MS: " + delayOptions.getPreferredMS());
            addLine("FPS: " + delayOptions.getPreferredFPS());
        }
    }
}