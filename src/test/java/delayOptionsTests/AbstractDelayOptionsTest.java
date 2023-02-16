package delayOptionsTests;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayOptions;

/**
 * An abstract DelayOptions test.
 */
abstract class AbstractDelayOptionsTest {
    private final @NotNull List<@NotNull DelayOptionsContainer> containerList;

    /**
     * Creates a new AbstractDelayOptionsTest.
     */
    protected AbstractDelayOptionsTest() {
        containerList = new ArrayList<>();
    }

    /**
     * Adds a new container to this test.
     *
     * @param delayOptionsName Custom printable part of the console buffer.
     * @param delayOptions     DelayOptions object to contain.
     */
    protected final void addContainer(@NotNull String delayOptionsName,
                                      @NotNull DelayOptions delayOptions) {
        containerList.add(new DelayOptionsContainer(delayOptionsName) {
            /**
             * TODO: finish this javadoc
             */
            @Override
            protected @NotNull DelayOptions getInitialDelayOptions() {
                return new DelayOptions(delayOptions);
            }
        });
    }

    /**
     * Gets a container by its index.
     *
     * @param index Index.
     */
    protected final @NotNull DelayOptionsContainer getContainer(int index) throws IndexOutOfBoundsException {
        return containerList.get(index);
    }

    /**
     * Prints all contained containers.
     */
    protected final void print() {
        for (@NotNull DelayOptionsContainer container : containerList) {
            container.print();
        }
    }
}