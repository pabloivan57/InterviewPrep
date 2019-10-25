package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    public List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while(!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
              if (ps.openCount < num) // if we can add an open parentheses, add it
                queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
              if (ps.openCount > ps.closeCount) // if we can add a close parentheses, add it
                queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
            }
        }

        return result;
    }
}
