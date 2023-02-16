package DelayCalculatorTest;

import delayCalculator.delayOptions.DelayType;

//TODO: add javadoc
record TestParameters(
        DelayType testingType, long testingValue,
        int displayableMemberCount, int innerMemberCount) {}