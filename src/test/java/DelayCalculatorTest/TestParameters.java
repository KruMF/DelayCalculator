package DelayCalculatorTest;

import DelayCalculator.PreferenceType;

//TODO: add javadoc
record TestParameters(
        PreferenceType testingType, long testingValue,
        int displayableMemberCount, int innerMemberCount) {}