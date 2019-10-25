package com.pablan.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /**
     * Study this one, is a more elegant approach to backtrack
     * @param n
     * @return
     */

    public List<String> generateParentheses(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder expression = new StringBuilder();
        dfs(n, n, expression, results);

        return results;
    }

    public void dfs(int leftCount, int rightCount, StringBuilder expression, List<String> result) {
        if(rightCount < leftCount) {
            // this is an invalid expression
            return;
            // ))(
        }

        if(leftCount == 0 && rightCount == 0) {
            result.add(expression.toString());
            return;
        }

        if(leftCount > 0) {
            expression.append("(");
            dfs(leftCount - 1, rightCount, expression, result);
            expression.deleteCharAt(expression.length() - 1);
        }

        if(rightCount > 0 && rightCount > leftCount) {
            expression.append(")");
            dfs(leftCount, rightCount - 1, expression, result);
            expression.deleteCharAt(expression.length() - 1);
        }
    }

}
