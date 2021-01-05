package com.pablan.grokking.patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyStack {

    /**
     *  Design a class that simulates a Stack data structure, implementing the following two operations:
     *
     *  push(int num): Pushes the number ‘num’ on the stack.
     *  pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
     *  Example:
     *
     *  After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)
     *
     *  1. pop() should return 2, as it is the most frequent number
     *  2. Next pop() should return 1
     *  3. Next pop() should return 2
     *
     *  Pablo's notes: So this is confusing at first, but basically it is telling you that you should be popping
     *  by frequence. So in the example you have two 1, three 2, two 3. Of course the one with the most numbers is
     *  2, so you pop that first... BUT you still have 2 two's to deal with so now which one is next? Imagine you're
     *  pushing to a stack
     *
     *|>5
     *| 2 --> we popped this one because it had the most the most frequency
     *| 1 --> now the most frequency is 2 times, which is shared by 2, and 1. But 1 was pushed after 2... so next pop is 1
     *| 2 --> now most frequency is number 2 with 2 times. We pop 2
     *|>3 --> Next we pop 5, because it has frequency 1 and it was sent later
     *  2
     *  1
     *
     *  So after the explanation we can model this using the priority heap. But we sort by frequency. and we keep
     *  track of how many elements are at each point in time, the stack would look like this
     *
     *  2 -> #3 -> sequence 6
     *  1 -> #2 -> sequence 5
     *  2 -> #2 -> sequence 4
     *  5 -> #1 -> sequence 7
     *  3 -> #1 -> sequence 3
     *  2 -> #1 -> sequence 2
     *  1 -> #1 -> sequence 1
     *
     *  So now, each pop corresponds to the element that should be there
     */
    Map<Integer, Integer> occurrences = new HashMap<>();
    PriorityQueue<Element> maxHeap = new PriorityQueue<>((a, b) -> {
        if(b.frequency == a.frequency) {
            return b.sequence - a.sequence;
        } else {
            return b.frequency - a.frequency;
        }
    });
    int sequence;

    public FrequencyStack() {
        sequence = 1;
    }

    public void push(int num) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, occurrences.get(num), sequence++));
    }

    public int pop() {
        return maxHeap.poll().num;
    }

    private class Element {
        int num;
        int frequency;
        int sequence;

        public Element(int num, int frequency, int sequence) {
            this.num = num;
            this.frequency = frequency;
            this.sequence = sequence;
        }
    }
}
