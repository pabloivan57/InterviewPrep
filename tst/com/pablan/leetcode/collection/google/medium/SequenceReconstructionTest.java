package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceReconstructionTest {

    @Test
    public void test() {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        List<List<Integer>> sequence1 = new ArrayList<>();
        sequence1.add(Arrays.asList(new Integer[] {1, 2}));
        sequence1.add(Arrays.asList(new Integer[] {1, 4}));
        System.out.println(sequenceReconstruction.sequenceReconstruction(new int[] {1,2,3}, sequence1));

        List<List<Integer>> sequence2 = new ArrayList<>();
        sequence2.add(Arrays.asList(new Integer[] {1, 2}));
        System.out.println(sequenceReconstruction.sequenceReconstruction(new int[] {1,2,3}, sequence2));

        List<List<Integer>> sequence3 = new ArrayList<>();
        sequence3.add(Arrays.asList(new Integer[] {1, 2}));
        sequence3.add(Arrays.asList(new Integer[] {1, 3}));
        sequence3.add(Arrays.asList(new Integer[] {2, 3}));
        System.out.println(sequenceReconstruction.sequenceReconstruction(new int[] {1,2,3}, sequence1));
    }
}
