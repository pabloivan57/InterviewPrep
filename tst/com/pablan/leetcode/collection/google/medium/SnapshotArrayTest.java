package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class SnapshotArrayTest {

    @Test
    public void test() {
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,5);  // Set array[0] = 5
        snapshotArray.snap();  // Take a snapshot, return snap_id = 0
        snapshotArray.set(0,6);
        System.out.println(snapshotArray.get(0,0));  // Get the value of array[0] with snap_id = 0, return 5
        System.out.println(snapshotArray.get(0, 1));
    }
}
