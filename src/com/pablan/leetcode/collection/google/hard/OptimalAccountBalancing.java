package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

    /**
     *  A group of friends went on holiday and sometimes lent each other money.
     *  For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride.
     *  We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice,
     *  Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID),
     *  the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
     *
     * Given a list of transactions between a group of people, return the minimum number
     * of transactions required to settle the debt.
     *
     * Note:
     *
     * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
     * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2
     * or we could also have the persons 0, 2, 6.
     * Example 1:
     *
     * Input:
     * [[0,1,10], [2,0,5]]
     *
     * Output:
     * 2
     *
     * Explanation:
     * Person #0 gave person #1 $10.
     * Person #2 gave person #0 $5.
     *
     * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
     *
     * Pablo's notes: This is straight up from a paper... there is proof but it's hard to understand. What you need to
     * remember is... keep balance of each person. SO for example above
     *
     *  -5  10  -5
     *  0   1   2
     *
     *  The state represent all the deb from each persons perspective. What we are going to try to do is to test
     *  every possibility where someone can payoff another's persons debt. Imagine you are at 0...
     *  you can claim 5 from 1
     *
     *  0  5  -5
     *  0  1   2
     *
     *  Now at positions 1 you can pay off 2's debt
     *  0  0  0
     *  0  1  2
     *
     *  And we reached the end  of the array. How did you reach this position? by looking at opposite sings. Now...
     *  it gets tricky in the sense that you could have send all your money to position i + 1 or position i + n
     *  You have to try all those possibilities. Going back to the table. Imagine you had
     *
     *  -15 10 5
     *   0  1  2
     *
     *  If you send -15 to 1... now he has a balance of -5. Then you are going to attempt to find someone that can
     *  payoff that by looking at opposite sides
     */
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            m.put(t[0], m.getOrDefault(t[0], 0) - t[2]);
            m.put(t[1], m.getOrDefault(t[1], 0) + t[2]);
        }
        return settle(0, new ArrayList<>(m.values()));
    }

    private int settle(int start, List<Integer> balances) {
        if(start == balances.size() - 1) {
            return 0; // can't make any more transactions. Reached the end of array
        }

        int transactions = Integer.MAX_VALUE;
        for(int i = start + 1; i < balances.size(); i++) {
            if(balances.get(start) * balances.get(i) < -1) {
                // try this transaction
                balances.set(i, balances.get(i) + balances.get(start));
                transactions = Math.min(transactions, 1 + settle(i, balances));
                // backtrack to test next solutions
                balances.set(i, balances.get(i) - balances.get(start));
            }
        }

        return transactions;
    }
}
