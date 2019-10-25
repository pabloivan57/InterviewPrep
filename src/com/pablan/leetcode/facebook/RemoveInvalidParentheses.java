package com.pablan.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    private Set<String> validExpressions = new HashSet<>();

    public List<String> remove(String s) {
        validExpressions =  new HashSet<>();
        int left = 0;
        int right = 0;

        // First, we find out the number of misplaced left and right parentheses
        for (int i = 0; i < s.length(); i++) {
            // Simply record the left one/
            if (s.charAt(i) == '(') {
                left++;
            } else  if(s.charAt(i) == ')') {
                // If we don't have a matching left, then this is a misplaced right, record it.
                if(left == 0) {
                    right = right + 1;
                }

                // Decrement count of left parentheses because we have found a right
                if(left > 0) {
                    left = left - 1;
                }
            }
        }

        dfs(s, 0, 0, 0, left, right, new StringBuilder());

        return new ArrayList<>(this.validExpressions);
    }

    public void dfs(String s,
                        int index,
                        int leftCount,
                        int rightCount,
                        int leftRem,
                        int rightRem,
                        StringBuilder expression) {

        // If we reached the end of the string, just check if the resulting expression is
        // valid or not and also if we have removed the total number of left and right
        // parentheses that we should have removed
        if(index == s.length()) {
            if(leftRem == 0 && rightRem == 0) {
                validExpressions.add(expression.toString());
            }
        } else {
            char character = s.charAt(index);
            int length = expression.length();

            // The discard case. Note that here we have our own pruning condition.
            // We don't recurse if the remaining count for that parentheses is == 0.
            if((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                dfs(s, index + 1,
                        leftCount,
                        rightCount,
                        leftRem - (character == '(' ? 1 : 0),
                        rightRem - (character == ')' ? 1 : 0),
                        expression);
            }

            expression.append(character);

            // Simply recurse one step further if the current character is not a parenthesis.
            if(character != '(' && character != ')') {
                dfs(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            } else if (character == '(') {

                // Consider an opening bracket.
                dfs(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            } else if (rightCount < leftCount) {
                // Consider a closing bracket.
                dfs(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            }

            // Delete for backtracking
            expression.deleteCharAt(length);
        }
    }


    public List<String> removePablanInefficient(String s) {
        Set<String> result = new HashSet<>();

        int leftCount  = 0;
        int rightCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(currentChar == '(') {
                leftCount++;
            } else if(currentChar == ')') {
                if(leftCount == 0) {
                    rightCount++;
                } else {
                    leftCount = leftCount - 1;
                }
            }
        }

        dfsPablanInefficient(0, s, new StringBuilder(""), result, leftCount, rightCount, 0, 0);

        return new ArrayList<>(result);
    }

    /**
     *  The idea is to create a tree with all possibilities and go through it
     */
    public void dfsPablanInefficient(int index,
                                     String s,
                                     StringBuilder sequence,
                                     Set<String> result,
                                     int leftRem,
                                     int rightRem,
                                     int leftCount,
                                     int rightCount) {
        if(index == s.length()) {
            if(leftRem == 0 && rightRem == 0) {
                //  This is a valid sequence
                result.add(sequence.toString());
            }
        } else {
            // Remove case
            if((s.charAt(index) == '(' && leftRem > 0) || (s.charAt(index) == ')') && rightRem > 0) {
                dfsPablanInefficient(index + 1,
                        s,
                        sequence,
                        result,
                        s.charAt(index) ==  '(' ? leftRem - 1 : leftRem,
                        s.charAt(index) == ')' ? rightRem - 1 : rightRem,
                        leftCount,
                        rightCount);
            }

            // Append to create current Level
            sequence.append(s.charAt(index));

            // This decision part of the logic is needed... see this example
            // ()())( -> derived from ()())(), if you don't check that
            // leftCount > rightCount you will end up with such an expression
            // that's why we keep track of left count and right count

            if(s.charAt(index) != '(' && s.charAt(index) != ')') {
                // is not a parenthesis we simply expand dfs
                dfsPablanInefficient(index + 1, s, sequence, result, leftRem, rightRem, leftCount, rightCount);
            } else if(s.charAt(index) == '(') {
                dfsPablanInefficient(index + 1, s, sequence, result, leftRem, rightRem, leftCount + 1, rightCount);
            } else if(leftCount > rightCount) {
                dfsPablanInefficient(index + 1, s, sequence, result, leftRem, rightRem, leftCount, rightCount + 1);
            }

            // Remove  current level for backtracking
            sequence.deleteCharAt(sequence.length() - 1);
        }
    }
}
