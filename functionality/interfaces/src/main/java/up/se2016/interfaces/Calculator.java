package up.se2016.interfaces;

/**
 * Defines the actions a calculator engine must provide
 */
public interface Calculator {
    /**
     * Calculates the sum of two integers
     * @param summand1  The first integer
     * @param summand2  The second integer
     * @return          Sum of the two integers
     */
    public int sum(int summand1, int summand2);

    /**
     * Calculates the difference between two integers
     * @param subtrahend    The first integer
     * @param minuend       The second integer
     * @return              Difference between subtrahend and minuend
     */
    public int difference(int subtrahend, int minuend);

    /**
     * Calculates the product of two integers
     * @param factor1   The first integer
     * @param factor2   The second integer
     * @return          Product of the two integers
     */
    public int product(int factor1, int factor2);

    /**
     * Calculates the (integer) quotient of two integers
     * @param dividend  The first integer
     * @param divisor   The second integer
     * @return          Quotient of the two integers
     */
    public int quotient(int dividend, int divisor);
}
