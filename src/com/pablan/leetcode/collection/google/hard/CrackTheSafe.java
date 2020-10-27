package com.pablan.leetcode.collection.google.hard;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CrackTheSafe {

    /**
     * There is a box protected by a password.
     * The password is a sequence of n digits where each digit can be one of the first k digits 0, 1, ..., k-1.
     *
     * While entering a password, the last n digits entered will automatically
     * be matched against the correct password.
     *
     * For example, assuming the correct password is "345", if you type "012345",
     * the box will open because the correct password matches the suffix of the entered password.
     *
     * Return any password of minimum length that is guaranteed to open the box at some point of entering it.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1, k = 2
     * Output: "01"
     * Note: "10" will be accepted too.
     * Example 2:
     *
     * Input: n = 2, k = 2
     * Output: "00110"
     * Note: "01100", "10011", "11001" will be accepted too.
     *
     * Pablo's notes:
     *
     * DeBruijin Sequence: The exisitance of such a sequence can be proven. Basically it means
     * that there is a sequence containing all the n ^ k combinations possible with k characters
     *
     * You start with n - 1 characters, let's start with n = 2, k = 2 (0, 1)
     * '00' base password, now you take 2 - 1 == '0'
     * '0' and analyze all it's possibilities
     * '0 0' Have I seen this before? Yes... ok and have I found all 4 possibilities? No.. ok, backtrac
     * '0 1' Have I seen this before? No.. let's add it to set ['00', '01']  PASSWORD = 001
     *    Now, let;s pick n - 1, '1' and try all possibilities
     *    '1' '0' Have I seen this before? No.. let's add it to set ['00', '01', '10'] PASSWORD = 0010
     *        Let's pick n - 1, '0'
     *            '0 1'  Have I seen this before? yes. have I found all 4 possibilities? No... ok, backtrack
     *             '0 0 ' Have I seen this before? yes. have I found all 4 possibilities? No... ok, backtrack
     *        Couldn't find answer... backtrack. At this point the sequence had '10' but now we know that if
     *        we pick that sequence we will end up in a death end. Backtrack and remove the sequence
     *        ['00', '01', '10'] ==> ['00', '01'] PASSWORD = 001
     *    '1' '1' Have I seen  '11' no, Let's add it to set ['00', '01', '11'] PASSWORD = 0011
     *        Let's pick n - 1, '1'
     *            '1 0'. Have I seen this before? No, let's add it to set ['00', '01', '11', '10'] PASSWORD = 00110
     *                I have see all possibilities. Return true
     *            I have seen all possibilities return true
     *     I have seen all possibilities return true
     *  I have seen all possibilities, return true
     *
     *  PASSWORD = 00110
     */
    public String crackSafe(int n, int k) {
        int possibilities = (int) Math.pow(2, 3);

        StringBuilder password = new StringBuilder(Collections.nCopies(n, '0').toString());
        Set<String> visited = new HashSet<>();

        dfs(password, visited, n, k, possibilities);

        return password;
    }

    private boolean dfs(StringBuilder password, Set<String> visited, int n, int k, int possibilities) {
        if(visited.size() == possibilities) {
            return true;
        }

        String prevPassword = password.substring(password.length() - (n - 1));
        for(int i = 0; i < k; i++) {
            String newPassword = prevPassword + i;
            if(!visited.contains(newPassword)) {
                visited.add(newPassword);
                password.append(i);
                if(dfs(password, visited, n, k, possibilities)) {
                    return true;
                }
                visited.remove(newPassword);
                password.deleteCharAt(password.length() - 1);
            }
        }

        return false;
    }
}
