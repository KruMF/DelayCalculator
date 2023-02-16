package delayOptionsTests;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import delayCalculator.delayOptions.DelayOptions;

//TODO: add javadocs
abstract class AbstractDelayOptionsTest {
    private final @NotNull List<@NotNull DelayOptionsContainer> containerList;

    /**
     * TODO: finish this javadoc
     */
    protected AbstractDelayOptionsTest() {
        containerList = new ArrayList<>();
    }

    /**
     * TODO: finish this javadoc
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
     * TODO: finish this javadoc
     */
    protected final @NotNull DelayOptionsContainer getContainer(int index) throws IndexOutOfBoundsException {
        return containerList.get(index);
    }

    /**
     * TODO: finish this javadoc
     */
    protected final void print() {
        for (@NotNull DelayOptionsContainer container : containerList) {
            container.print();
        }
    }
}