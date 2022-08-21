package DelayCalculatorTest;

import java.util.Random;

//TODO: add javadocs and check visibility
class TestCalculations {
    protected String name;
    protected double[] randomArray;
    private static final int MEMBER_COUNT = 100000;

    protected TestCalculations(int i) {
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

    protected double getAverage() {
        double sum = 0;
        for (double d : randomArray) {
            sum += d;
        }
        return sum / randomArray.length;
    }
}