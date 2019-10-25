package com.pablan.grokking.patterns.twoheaps;

import org.junit.Test;

public class MedianOfStreamTest {

    @Test
    public void test() {
        MedianOfStream medianOfAStream = new MedianOfStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
