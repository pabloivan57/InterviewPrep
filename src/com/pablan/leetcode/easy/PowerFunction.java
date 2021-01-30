package com.pablan.leetcode.easy;

public class PowerFunction {

    /**
     * Create a function to calculate pow(a, b) efficiently
     *
     * pablo''s notes:
     *
     * The intution here is that if you have a^4 you can split that into
     * a^2 * a^2... in other words, you don't have to calculate a^2 twice you you can use the same value
     *
     * Therefore recursively you can say... give me a^2 as result and multiply that by itself. If the exponential
     * is odd then you simply do result(exponent / 2) * result(exponent / 2) * a
     * For example: a^6 == a^3 * a^3 == a ^ 1 * a ^ 1 * a ^ 1
     *
     * The result of the computation then reduces to O(log b) time
     */
    public int power(int a, int b) {
        if(b == 0) {
            return 1;
        }

        if(b == 1) {
            return a;
        }

        int result = power(a, b / 2);

        if(b % 2 == 0) {
            return result * result;
        } else {
            return result * result * a;
        }
    }
}
