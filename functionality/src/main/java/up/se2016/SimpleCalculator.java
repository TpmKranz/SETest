package up.se2016;

import up.se2016.interfaces.Calculator;

/**
 * Represents a very basic integer calculator engine
 * <p>
 * Also offers setting an offset and multiplier that'll be applied to each operation (multiplier takes precedence)
 */
public class SimpleCalculator implements Calculator {
    private int offset;
    private int multiplier;

    /**
     * Builds the engine with neutral offset and multiplier
     */
    public SimpleCalculator() {
        this(0, 1);
    }

    /**
     * Builds the engine with the given offset and multiplier
     * @param offset        Offset applied to each operation
     * @param multiplier    Multiplier applied to each operation
     */
    public SimpleCalculator(int offset, int multiplier) {
        this.offset = offset;
        this.multiplier = multiplier;
    }

    @Override
    public int sum(int summand1, int summand2) {
        return (summand1+summand2)*multiplier+offset;
    }

    @Override
    public int difference(int subtrahend, int minuend) {
        return (subtrahend-minuend)*multiplier+offset;
    }

    @Override
    public int product(int factor1, int factor2) {
        return (factor1*factor2)*multiplier+offset;
    }

    @Override
    public int quotient(int dividend, int divisor) {
        return (dividend/divisor)*multiplier+offset;
    }
}
