package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    /**
     *  For a given number ‘N’, write a function to generate all combination
     *  of ‘N’ pairs of balanced parentheses.
     *
     *  Example 1:
     *
     *  Input: N=2
     *  Output: (()), ()()
     *  Example 2:
     *
     *  Input: N=3
     *  Output: ((())), (()()), (())(), ()(()), ()()()
     *
     *  Pablo's notes: This is a bfs exploratory sort of like playing a game.
     *  We keep each state and we attempt to generate next state based on rules.
     *
     *  In this example, we start from the fact that:
     *  1.- You cannot close a parentheses that you haven't opened... therefore we always check if we can
     *      add a left
     *
     *  2.- As long as there are more lefts than right on the expression, we can close them
     *
     *  So we can go as follows
     *
     *     (
     *  |     \
     *  ((    ()
     *  |      |
     *  (()    ()(
     *  |       |
     *  (())    ()()
     */
    public List<String> generateValidParentheses(int num) {
        Queue<Parentheses> queue = new LinkedList<>();
        queue.offer(new Parentheses("", 0, 0));

        List<String> result = new ArrayList<>();

        while(!queue.isEmpty()) {
            Parentheses current = queue.poll();
            if(current.rightCount == num && current.leftCount == num) {
                result.add(current.str);
                continue;
            }

            if(current.leftCount < num) {
                queue.offer(new Parentheses(current.str + "(", current.leftCount + 1, current.rightCount));
            }

            if(current.leftCount > current.rightCount) {
                queue.offer(new Parentheses(current.str + ")", current.leftCount, current.rightCount + 1));
            }
        }

        return result;
    }

    private class Parentheses {
        String str;
        int leftCount;
        int rightCount;

        Parentheses(String str, int leftCount, int rightCount) {
            this.str = str;
            this.leftCount = leftCount;
            this.rightCount = rightCount;
        }
    }
}
