package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class EncodeDecodeStringsTest {

    @Test
    public void test() {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();

        String encode = encodeDecodeStrings.encode(Collections.emptyList());
        System.out.println(encode);
        List<String> decode = encodeDecodeStrings.decode(encode);
        System.out.println(decode);
    }
}
