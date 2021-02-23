package com.pablan.leetcode.collection.google.easy;

public class ConvertDecimalToBinary {

    public int convert(int decimal) {
        String binary = "";

        while(decimal > 0) {
            int nextNumber = decimal % 2;
            binary += nextNumber;
            decimal = decimal / 2;
        }

        return Integer.valueOf(binary);
    }
}
