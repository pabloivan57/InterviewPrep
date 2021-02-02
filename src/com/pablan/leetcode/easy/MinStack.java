package com.pablan.leetcode.easy;

/**
 * Write an implementation of a Stack that supports push(), pop(), and min() functions in constant time.
 */
public class MinStack {

    MinStackNode head;
    MinStackNode minHead;

    public void push(Integer value) {
        if(head == null) {
            head = new MinStackNode(value);
            minHead = new MinStackNode(value);
        } else {
            MinStackNode newNode = new MinStackNode(value);
            newNode.next = head;
            head = newNode;

            if(newNode.value <= minHead.value) {
                MinStackNode newMin = new MinStackNode(newNode.value);
                newMin.next = minHead;
                minHead = newMin;
            }
        }
    }

    public Integer pop() {
        if(head == null) {
            return null;
        }

        MinStackNode node = head;
        head = node.next;

        if(node.value == minHead.value) {
            minHead = minHead.next;
        }

        return node.value;
    }

    public Integer min() {
        if(minHead == null) {
            return null;
        }

        return minHead.value;
    }

    private class MinStackNode {
        int value;
        MinStackNode next;

        public MinStackNode(int value) {
            this.value = value;
        }
    }
}
