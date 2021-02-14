package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeDecodeStringsTest {

    @Test
    public void test() {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();

        List<String> words = new ArrayList<>();
        words.add("aloha");
        words.add("faa");
        words.add("enc");
        String encode = encodeDecodeStrings.encode(words);
        System.out.println(encode);
        List<String> decode = encodeDecodeStrings.decode(encode);
        System.out.println(decode);
        encode = encodeDecodeStrings.encode(Collections.emptyList());
        System.out.println(encode);
        decode = encodeDecodeStrings.decode(encode);
        System.out.println(decode);
    }
}
