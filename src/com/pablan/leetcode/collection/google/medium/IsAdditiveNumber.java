package com.pablan.leetcode.collection.google.medium;

public class IsAdditiveNumber {

    /**
     *  Additive number is a string whose digits can form additive sequence.
     *
     * A valid additive sequence should contain at least three numbers. Except for the first
     * two numbers, each subsequent number in the sequence must be the sum of the preceding two.
     *
     * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
     *
     * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
     *
     *
     *
     * Example 1:
     *
     * Input: "112358"
     * Output: true
     * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
     *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
     * Example 2:
     *
     * Input: "199100199"
     * Output: true
     * Explanation: The additive sequence is: 1, 99, 100, 199.
     *              1 + 99 = 100, 99 + 100 = 199
     *
     * Pablo's notes: There is smart faster algorithm but it's hard to understand. this one is
     * simple and can be done. Basically, try all possibilities for the very first two numbers
     * then check if the rest of the string fits.
     *
     */
    public boolean isAdditiveNumber(String num) {
        for(int i = 0; i < num.length(); i++) {
            long firstNum = parse(num.substring(0, i));
            for(int j = i + 1; j < num.length(); j++) {
                long secondNum = parse(num.substring(j));
                if(firstNum == -1 || secondNum == -1) {
                    continue; // invalid number according to the problem
                }

                if(dfs(firstNum, secondNum, num) == true) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(long firstNum, long secondNum, String num) {
        for(int i = 0; i < num.length(); i++) {
            long thirdNum = parse(num.substring(0, i));
            if(thirdNum == -1) { // invalid number per problem conditions, cannot be 0 or start with 0
                continue;
            }

            if(thirdNum - firstNum == secondNum && dfs(secondNum, thirdNum, num.substring(i))) {
                return true;
            }
        }

        return false;
    }

    private long parse(String num) {
        if (!num.equals("0") && num.startsWith("0"))    return -1;

        long result = 0;
        try {
            result = Long.parseLong(num);
        } catch (NumberFormatException e) {
            return -1;
        }
        return result;
    }

}
