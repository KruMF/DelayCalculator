package DelayCalculator;

import java.util.ArrayList;
import java.util.Random;

//TODO: add javadoc
class DelayTestThread extends Thread implements Runnable {
    public static void main(String[] args) {
        (new DelayTestThread()).start();
    }

    private final DelayCalculator delayCalculator;

    DelayTestThread() {
        delayCalculator = new DelayCalculator(new DelayOptions(PreferenceType.DELAY_MS, 500L));
    }

    @SuppressWarnings({"BusyWait", "InfiniteLoopStatement"})
    @Override
    public void run() {
        while (true) {
            delayCalculator.start();
            someCalculations();
            delayCalculator.end();
            try {
                Thread.sleep(delayCalculator.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printDelayInfo();
        }
    }

    private void printDelayInfo() {
        printLine("Elapsed time: " + delayCalculator.getElapsedTime());
        printLine("Delay : " + delayCalculator.getDelay());
    }

    private static void printLine(String line) {
        System.out.println(line);
    }

    private void someCalculations() {
        printResults(getTestList());
    }

    private static ArrayList<TestCalculationsClass> getTestList() {
        ArrayList<TestCalculationsClass> list = new ArrayList<>();
        int memberCount = 5;
        for (int i = 0; i < memberCount; i++) {
            list.add(new TestCalculationsClass(i));
        }
        return list;
    }

    private void printResults(ArrayList<TestCalculationsClass> list) {
        for (TestCalculationsClass member : list) {
            printLine(member.name + ", average: " + member.getAverage());
        }
    }

    private static class TestCalculationsClass {
        String name;
        double[] randomArray;
        private static final int MEMBER_COUNT = 100000;

        TestCalculationsClass(int i) {
            name = "member number: " + i;
            setRandomArray();
        }

        private void setRandomArray() {
            randomArray = new double[MEMBER_COUNT];
            for (int i = 0; i < MEMBER_COUNT; i++) {
                Random r = new Random();
                randomArray[i] = r.nextDouble();
            }
        }

        double getAverage() {
            double sum = 0;
            for (double d : randomArray) {
                sum += d;
            }
            return sum / randomArray.length;
        }
    }
}