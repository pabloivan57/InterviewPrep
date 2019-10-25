package com.pablan.grokking.patterns.fastslow;

public class HappyNumber {

    public boolean find(int number) {
        int slow = number;
        int fast = 0;

        while(slow != 1) {
            if (slow == fast) return false;

            slow = squareOfDigits(slow);
            fast = squareOfDigits(squareOfDigits(slow));
        }

        return true;
    }

    private int squareOfDigits(int number) {
        int digit = number / 10;
        int remainder = number % 10;
        int result = digit * digit;

        while(remainder > 10) {
            digit = digit / 10;
            result += digit * digit;
            remainder = remainder % 10;
        }

        result += remainder * remainder;
        return result;
    }
}
