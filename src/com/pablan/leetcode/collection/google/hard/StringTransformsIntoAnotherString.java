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
     *
     * Look at this image: https://trello.com/c/Nfy08I0d
     *
     * It will help you understand two key use cases, mapping is not possible when
     *
     * 1.- One letter in str1 maps to 2 letters in str2, this is sort of obvious
     *
     * abb -> adc, b maps to d and c... if you change b to d = add then you have add you you need the last
     *             d to be c, you can't do that... try it, d -> c = acc
     *
     * In any case a more elaborate example is:
     *
     * aabccc -> ccdeef, try it... there is no way  to do this
     *
     * 2.- there is a loop in the transformation, for example:
     *
     * You see, if you have a cyclic transformation like a -> c and c -> a
     * then you to transform a string like aaaccc to cccaaa; you can't go a -> c
     * because you won't be able to distinguish which 'c's you want to transform back later.
     * So you need to swap these with some 3rd character to break the cyclic transformation
     * (may be aaaccc -> eeeccc -> eeeaaa -> cccaaa).
     * But if the destination string already expecting all 26 letters to be converted from some other letter,
     * then it is impossible to find a 3rd char like e above, to break the cycle. Hence we check if the mapping range is <=26.
     *
     * BUT HOW THIS IS DIFFERENT FROM CASE 1? Well, you do have 1:1 mappings is just that it's cyclical
     * a -> c   and not     a -> c
     * c -> a               a -> d
     *
     *
     */
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) {
            return true;
        }

        Map<Character, Character> mappings = new HashMap<>();
        for(int i = 0; i < str1.length(); i++) {
              if(!mappings.containsKey(str1.charAt(i))) {
                  mappings.put(str1.charAt(i), str2.charAt(i));
              } else {
                  if(mappings.get(str1.charAt(i)) != str2.charAt(i)) {
                      return false;
                  }
              }
        }

        // This is so we just eliminate duplicates, remember as per the rules above
        // multiple letters can map to one char, but one char can't map to multiple letterrrs
        return new HashSet<Character>(mappings.values()).size()  <  26;
    }
}
