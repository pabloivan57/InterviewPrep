package com.pablan.grokking.patterns.fastslow;

public class HappyNumber {

    public boolean find(int number) {
        int slow = number;
        int fast = number;

        while(slow != 1 && fast != 1) {
            slow = squareOfNumbers(slow);
            fast = squareOfNumbers(squareOfNumbers(fast));

            if(slow == fast) {
                return false;
            }
        }

        return true;
    }

    private int squareOfNumbers(int number) {
        int total = 0;

        while(number >= 10) {
            int remainder = number % 10;
            int digit = number / 10;

            total = total + (digit * digit);
            number = remainder;
        }

        total = total + (number * number);
        return total;
    }

}
