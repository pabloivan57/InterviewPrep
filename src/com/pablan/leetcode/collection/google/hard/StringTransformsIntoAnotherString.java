package com.pablan.leetcode.collection.google.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {

    /**
     * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2
     * by doing zero or more conversions.
     *
     * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
     *
     * Return true if and only if you can transform str1 into str2.
     *
     * Example 1:
     *
     * Input: str1 = "aabcc", str2 = "ccdee"
     * Output: true
     * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
     * Example 2:
     *
     * Input: str1 = "leetcode", str2 = "codeleet"
     * Output: false
     * Explanation: There is no way to transform str1 to str2.
     *
     *
     * Note:
     *
     * 1 <= str1.length == str2.length <= 10^4
     * Both str1 and str2 contain only lowercase English letters.
     *
     * Pablo's notes:
     * So, the problem in this exercise is when we transform to something that was already assigned, because that
     * triggers a chain reaction.
     *
     * 1) aabcc : ccdee
     * key -> value
     * a   ->  c   Note how this doesn't have a cycle
     * b   ->  d
     * c   ->  e
     *
     * a -> c ; b -> d ; c -> e ! not a problem because c has not been assigned to any key
     *
     * 2) ace : cea
     *
     * key -> value
     * a   ->  c
     * c   ->  e
     * e   ->  a
     *
     * a -> c ; c -> e; e -> a ! a is a problem, because the transform would look something like this:
     *  ce e->a == ce a->c == ce c->e == ce e->a (we came back to first element)
     *
     * Now, to break this cycle we simply map to a temporary character
     *  a -> x == xce
     *  c -> e == xee
     *  e -> a == xea
     *  x -> c == cea
     *
     *  We can keep breaking cycles as long as there is a letter that has not been used
     *
     *  Important 2: In the case of leetcode : codeleet, there has to be a transformation 1 by 1
     *  l -> c
     *  e -> o
     *  e -> d .. but e is already going to o, so we can't transform, Otherwise you will end up with something like
     *  leetcode -> ceetcode -> cootcode -> cddtcode -> cootcode? (can't match 1 by 1)
     */
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < str1.length(); ++i) {
            if (dp.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i))
                return false;
            dp.put(str1.charAt(i), str2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    }
}
