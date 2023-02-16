package delayOptionsTests;

import org.jetbrains.annotations.NotNull;

import consoleUtils.bufferedPrinting.BufferSection;
import consoleUtils.bufferedPrinting.AbstractConsoleBuffer;
import consoleUtils.bufferedPrinting.SingleSectionConsoleBuffer;

import delayCalculator.delayOptions.DelayOptions;

/**
 * A class for containing and handling a DelayOptions object and a console buffer.
 */
abstract class DelayOptionsContainer {
    private final @NotNull DelayOptions delayOptions;
    private final @NotNull AbstractConsoleBuffer consoleBuffer;

    /**
     * Creates a new DelayOptionsContainer.
     *
     * @param delayOptionsName Custom printable part of the console buffer.
     */
    protected DelayOptionsContainer(@NotNull String delayOptionsName) {
        delayOptions = getInitialDelayOptions();
        consoleBuffer = new SingleSectionConsoleBuffer(
                new DelayOptionsBufferSection(delayOptionsName, this)
        );
    }

    /**
     * Prepares the initial DelayOptions object.
     *
     * @return The initial DelayOptions object.
     */
    protected abstract @NotNull DelayOptions getInitialDelayOptions();

    /**
     * Gets the contained DelayOptions object.
     *
     * @return The contained DelayOptions object.
     */
    protected final @NotNull DelayOptions getDelayOptions() {
        return delayOptions;
    }

    /**
     * Prints the information about the contained DelayOptions object.
     */
    protected final void print() {
        consoleBuffer.print();
    }

    /**
     * A test-specific section for console buffer.
     */
    private static final class DelayOptionsBufferSection extends BufferSection {
        private final @NotNull String delayOptionsName;
        private final @NotNull DelayOptionsContainer container;

        /**
         * Creates a new buffer section.
         *
         * @param delayOptionsName Custom printable part of this section.
         * @param container        Reference container.
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