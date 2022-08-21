package DelayCalculatorTest;

import java.util.Random;

//TODO: add javadoc
class TestCalculations {
    private String name;
    private double[] randomArray;
    private final int memberCount;

    //TODO: add javadoc
    protected TestCalculations(int index, int memberCount) {
        name = "member number: " + index;
        this.memberCount = memberCount;
        setRandomArray();
    }

    //creates an array of random numbers
    private void setRandomArray() {
        randomArray = new double[memberCount];
        for (int i = 0; i < memberCount; i++) {
            Random r = new Random();
            randomArray[i] = r.nextDouble();
        }
    }

    //TODO: add javadoc
    protected String getName() {
        return name;
    }

    //TODO: add javadoc
    protected double getAverage() {
        double sum = 0;
        for (double d : randomArray) {
            sum += d;
        }
        return sum / randomArray.length;
    }
}