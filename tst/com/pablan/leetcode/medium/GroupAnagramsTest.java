package com.pablan.leetcode.medium;

import org.junit.Test;

public class GroupAnagramsTest {

    @Test
    public void test() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        System.out.println(groupAnagrams.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        // should be
        /* [
                ["ate","eat","tea"],
                ["nat","tan"],
                ["bat"]
            ] */
    }
}
