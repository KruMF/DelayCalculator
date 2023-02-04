package DelayCalculatorTest;

import DelayCalculator.DelayCalculator;

import java.util.List;
import java.util.ArrayList;

//for synchronizing output
//TODO: add javadocs
class Output {
    //private final ConsoleBuffer consoleBuffer;

    //TODO: add javadoc
    protected Output() {
        /*consoleBuffer = new ConsoleBuffer() {
            @Override
            public List<String> header() {
                return new ArrayList<>() {{
                    add(separatorString());
                }};
            }
        };*/
    }

    //TODO: add javadoc
    protected void addCalculationResults(ArrayList<TestCalculations> results) {
        /*for (TestCalculations member : results) {
            consoleBuffer.addLine(getLine(member));
        }*/
    }

    private String getLine(TestCalculations member) {
        return member.getName() + ", average: " + member.getAverage();
    }

    //TODO: add javadoc
    protected void addDelayInfo(DelayCalculator delayCalculator) {
        /*consoleBuffer.addLine("Elapsed time (ms) : " + delayCalculator.getElapsedTime());
        consoleBuffer.addLine("Delay (ms) : " + delayCalculator.getDelay());*/
    }

    //TODO: add javadoc
    protected void print() {
        //consoleBuffer.print();
    }
}