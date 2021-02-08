package com.pablan.leetcode.collection.google.medium;

import java.util.Arrays;

public class ImplementMinHeap {

    private static int DEFAULT_CAPACITY = 20;

    private Integer[] heap;
    private int size;

    public ImplementMinHeap() {
        size = 0;
        heap = new Integer[DEFAULT_CAPACITY];
    }

    public Integer peek() {
        if(isEmpty()) {
            return null;
        }

        return heap[0];
    }

    public void add(Integer value) {
        // check for capacity, if we are over capacity double it's capacity
        if(size > heap.length) {
            heap = resize();
        }

        heap[size] = value;
        size++;
        bubbleUp();
    }

    public Integer remove() {
        Integer result = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;

        bubbleDown();

        return result;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void bubbleUp() {
        int current = size -1;
        int parent = getParentIndex(current);

        while(heap[parent] > heap[current]) {
            swap(current, parent);

            current = parent;
            parent = getParentIndex(current);
        }
    }

    private void bubbleDown() {
        int current = 0;

        // This is because this is a complete binary tree
       while (hasLeftChild(current)) {
           int smallestChild = getLeftChild(current);

           if(hasRightChild(current) && heap[getLeftChild(current)] > heap[getRightChild(current)]) {
               smallestChild = getRightChild(current);
           }

           if(heap[current] > heap[smallestChild]) {
               swap(current, smallestChild);
           } else {
               // we shouldn't continue
               break;
           }

           current = smallestChild;
       }
    }

    /**
     *  For example: index 5... because 0 is the root we transpose the whole / 2 to work with 1 less
     *
     *  0 is root; left is 1, right is 2
     *  3 is left child of 1;  we get there with 3 / 2 == 1
     *  4 is left right child of 1; we get there with 4 / 2 == 2 ! wrong... this is why we do (-1)
     *
     *  REMEMBER! when working with 0 based index this whole algorithm... you reach the parent with -1
     *
     */
    private int getParentIndex(int i) {
        // this is done just because we are working with 0-based indexes.
        return i - 1 / 2;
    }

    /**
     * Again, these two operations are just meant to move from 0 index to where it should be.
     * Similarly to how you went -1 in get parent index... here you operate and then add + 1
     */
    private int getLeftChild(int i) {
        return i * 2 + 1;
    }

    private boolean hasLeftChild(int i) {
        return getLeftChild(i) < size;
    }

    private boolean hasRightChild(int i) {
        return getRightChild(i) < size;
    }

    /**
     * Again, these two operations are just meant to move from 0 index to where it should be.
     * Similarly to how you went -1 in get parent index... here you operate and then add + 2
     */
    private int getRightChild(int i) {
        return (i * 2) + 2;
    }

    private Integer[] resize() {
        return Arrays.copyOf(heap, heap.length * 2);
    }

    private void swap(int a, int b) {
        Integer aux = heap[a];
        heap[a] = heap[b];
        heap[b] = aux;
    }
}
