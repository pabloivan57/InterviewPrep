package com.pablan.leetcode.collection.google.medium;

import java.util.List;
import java.util.TreeMap;

public class SnapshotArray {

    /**
     * Implement a SnapshotArray that supports the following interface:
     *
     * SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
     * void set(index, val) sets the element at the given index to be equal to val.
     * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
     * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
     *
     *
     * Example 1:
     *
     * Input: ["SnapshotArray","set","snap","set","get"]
     * [[3],[0,5],[],[0,6],[0,0]]
     * Output: [null,null,0,null,5]
     * Explanation:
     * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
     * snapshotArr.set(0,5);  // Set array[0] = 5
     * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
     * snapshotArr.set(0,6);
     * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
     *
     * Pablo's notes: At the beginning of course you think this is a spare matrix
     * and you keep a pointer. Basically you copy the entire array.
     *
     * HOWEVER, a smarter way is to store an array of maps. Where A[i] is the entry
     * and A[i] = snapshot_id -> value. Now... you use a TreeMap because it's an
     * optimization to store sorted numbers as in this case snapshotId. But
     * Hashmap of hashmap works too
     */

    TreeMap<Integer, Integer> A[];

    int snap_id = 0;

    public SnapshotArray(int length) {
        this.A = new TreeMap[length];

        for(int i = 0; i < A.length; i++) {
            A[i] = new TreeMap<>();
        }
    }

    public void set(int index, int val) {
        this.A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return this.A[index].floorEntry(snap_id).getValue(); // floorEntry is just a safety net
                                                             // in case you're give a snapshot Id that doesn't exist
                                                             // we will default to the greatest snapshotId before that
    }
}
