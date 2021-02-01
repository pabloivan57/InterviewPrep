package com.pablan.leetcode.collection.google.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CurlyBraces {

    /**
     *  Question: Curly braces can be used in programming to provide scope-limit.
     *  Write a function to print all valid( properly opened and closed) combinations of n-pairs of curly braces.
     *
     *
     */
    public void printBraces(int n) {

        Queue<BracePair> queue = new LinkedList<>();
        queue.offer(new BracePair("", 0, 0));
        while(!queue.isEmpty()) {
            BracePair current = queue.poll();
            if(current.left == n && current.right == n) {
                System.out.print(current.braces + ",");
            }

            if(current.left > current.right && current.right < n) {
                queue.offer(new BracePair(current.braces + "}", current.left, current.right+ 1));
            }

            if(current.left < n) {
                queue.offer(new BracePair(current.braces + "{", current.left + 1, current.right));
            }
        }
    }

    private class BracePair {
        int left;
        int right;
        String braces;

        public BracePair(String braces, int left, int right) {
            this.left = left;
            this.right = right;
            this.braces = braces;
        }
    }
}
