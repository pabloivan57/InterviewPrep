package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class FindDuplicatePathInSystemTest {

    @Test
    public void test() {
        FindDuplicatePathInSystem findDuplicatePathInSystem = new FindDuplicatePathInSystem();
        System.out.println(findDuplicatePathInSystem.findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }
}
