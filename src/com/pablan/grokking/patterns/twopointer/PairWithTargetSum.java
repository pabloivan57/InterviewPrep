package com.pablan.grokking.patterns.twopointer;

public class PairWithTargetSum {

    public int[] solve(int[] numbers, int target) {
        int[] result = new int[2];

        int ptr1 = 0;
        int ptr2 = numbers.length - 1;
        int sum;

        while(ptr1 < ptr2) {
            sum = numbers[ptr1] + numbers[ptr2];

            if (sum == target) {
                result[0] = ptr1;
                result[1] = ptr2;
            }

            if(sum > target) {
                ptr2--;
            } else {
                ptr1++;
            }
        }

        return result;
    }
}
