package delayCalculator;

/**
 * A helper class for static unit-conversion methods.
 */
class UnitConversion {
    private static final int MILLISECONDS_IN_SECOND = 1000;

    /**
     * Converts frames-per-second to milliseconds.
     *
     * @param fps Frames-per-second.
     *
     * @return    Milliseconds.
     */
    protected static long convertFPStoMS(long fps) {
        return constantOverX(fps);
    }

    /**
     * Converts milliseconds to frames-per-second.
     *
     * @param ms Milliseconds.
     *
     * @return   Frames-per-second.
     */
    protected static long convertMStoFPS(long ms) {
        return constantOverX(ms);
    }

    private static long constantOverX(long x) {
        return MILLISECONDS_IN_SECOND / x;
    }
}