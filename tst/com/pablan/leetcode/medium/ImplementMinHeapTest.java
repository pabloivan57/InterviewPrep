package com.pablan.leetcode.medium;

import com.pablan.leetcode.collection.google.medium.ImplementMinHeap;
import org.junit.Test;

public class ImplementMinHeapTest {

    @Test
    public void test() {
        ImplementMinHeap implementMinHeap = new ImplementMinHeap();
        implementMinHeap.add(5);
        implementMinHeap.add(3);
        implementMinHeap.add(1);

        System.out.println(implementMinHeap.remove()); // should be 1
        System.out.println(implementMinHeap.peek()); // should be 3
    }
}
