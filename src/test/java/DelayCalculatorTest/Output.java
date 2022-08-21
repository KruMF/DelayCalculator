package DelayCalculatorTest;

import DelayCalculator.DelayCalculator;

import java.util.ArrayList;

import static consoleUtils.ConsoleUtils.printLine;
import static consoleUtils.ConsoleUtils.separator;

//TODO: add javadocs
class Output {
    protected static void printResults(ArrayList<TestCalculations> list) {
        separator();
        for (TestCalculations member : list) {
            printLine(member.getName() + ", average: " + member.getAverage());
        }
    }

    protected static void printDelayInfo(DelayCalculator delayCalculator) {
        printLine("Elapsed time (ms) : " + delayCalculator.getElapsedTime());
        printLine("Delay (ms) : " + delayCalculator.getDelay());
    }
}
