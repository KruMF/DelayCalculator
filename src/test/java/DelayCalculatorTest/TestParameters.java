package DelayCalculatorTest;

import delayCalculator.DelayType;

//TODO: add javadoc
record TestParameters(
        DelayType testingType, long testingValue,
        int displayableMemberCount, int innerMemberCount) {}