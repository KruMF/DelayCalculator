package DelayCalculatorTest;

import delayCalculator.PreferenceType;

//TODO: add javadoc
record TestParameters(
        PreferenceType testingType, long testingValue,
        int displayableMemberCount, int innerMemberCount) {}