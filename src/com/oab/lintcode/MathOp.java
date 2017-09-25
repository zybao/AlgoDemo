package com.oab.lintcode;


public class MathOp {
    public static void main(String[] args) {
        System.out.println("addSum: " + addSum(123141));
        System.out.println("divide two integer: " + divideTwoInteger(1210123, -123) );
    }


    /**
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * <p>
     * For example:
     * <p>
     * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     * <p>
     * Follow up:
     * Could you do it without any loop/recursion in O(1) runtime?
     * <p>
     * Hint:
     * <p>
     * A naive implementation of the above process is trivial. Could you come up with other methods?
     * What are all the possible results?
     * How do they occur, periodically or randomly?
     * You may find this Wikipedia article useful.
     */
    public static int addSum(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * Divide two integers without using multiplication, division and mod operator.
     * <p>
     * If it is overflow, return MAX_INT.
     */
    public static int divideTwoInteger(int a, int b) {
        if (b == 0) return Integer.MAX_VALUE;
        int absA = Math.abs(a), absB = Math.abs(b), result = 0;
        if (absA < absB) return 0;
        while (absA > absB) {
            int t = absB, p = 1;
            while (absA > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            result += p;
            absA -= t;
        }
        if ((a < 0) ^ (b < 0)) result = -result;

        return result;
    }

}
