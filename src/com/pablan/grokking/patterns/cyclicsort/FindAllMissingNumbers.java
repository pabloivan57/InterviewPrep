package com.pablan.grokking.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

    public List<Integer> findNumbers(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1 , nums);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);
        }

        return missingNumbers;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
