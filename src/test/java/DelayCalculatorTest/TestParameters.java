package DelayCalculatorTest;

import DelayCalculator.PreferenceType;

record TestParameters(
        PreferenceType testingType, long testingValue,
        int displayableMemberCount, int innerMemberCount) {}