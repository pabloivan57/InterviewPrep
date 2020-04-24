package com.pablan.leetcode.collection.google.medium;

import com.pablan.leetcode.collection.google.medium.MinimumDominoRotationsForEqualRow;
import org.junit.Test;

public class MinimumDominoRotationsForEqualRowTest {

    @Test
    public void test() {
        MinimumDominoRotationsForEqualRow minimumDominoRotationsForEqualRow = new MinimumDominoRotationsForEqualRow();
        System.out.println(minimumDominoRotationsForEqualRow.minDominoRotations(new int[] {2,1,2,4,2,2}, new int[] {5,2,6,2,3,2})); // should be 2
        System.out.println(minimumDominoRotationsForEqualRow.minDominoRotations(new int[] {1,2,1,1,1,2,2,2}, new int[] {2,1,2,2,2,2,2,2})); // should be 1
    }
}
