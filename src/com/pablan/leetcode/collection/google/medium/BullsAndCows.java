package com.pablan.leetcode.collection.google.medium;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {

    /**
     *  You are playing the Bulls and Cows game with your friend.
     *
     * You write down a secret number and ask your friend to guess what the number is.
     * When your friend makes a guess, you provide a hint with the following info:
     *
     * The number of "bulls", which are digits in the guess that are in the correct position.
     * The number of "cows", which are digits in the guess that are in your secret number but are
     * located in the wrong position. Specifically, the non-bull digits in the guess that could be
     * rearranged such that they become bulls.
     * Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.
     *
     * The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows.
     * Note that both secret and guess may contain duplicate digits.
     *
     *
     * Example 1:
     *
     * Input: secret = "1807", guess = "7810"
     * Output: "1A3B"
     * Explanation: Bulls are connected with a '|' and cows are underlined:
     * "1807"
     *   |
     * "7810"
     * Example 2:
     *
     * Input: secret = "1123", guess = "0111"
     * Output: "1A1B"
     * Explanation: Bulls are connected with a '|' and cows are underlined:
     * "1123"        "1123"
     *   |      or     |
     * "0111"        "0111"
     * Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
     * Example 3:
     *
     * Input: secret = "1", guess = "0"
     * Output: "0A0B"
     * Example 4:
     *
     * Input: secret = "1", guess = "1"
     * Output: "1A0B"
     *
     * Pablo's notes: The idea is as follows. go through every character in secret and check if it's bull
     * if it is... then straight up skip those two and add +1 to bull. If it isn't
     * keep track of both values to see if we can match them in the future
     * Example: 1807 7810
     *
     * 1 == 7 ? No, can I match with something? Nope... then add those to match buffer. buffer = 1,7
     * 8 == 8 ? Yes, bulls++
     * 0 == 1 ? No, can I match with something? Yes, 1. Then cows++ and remove 1 from match buffer, and also add 0 to match buffer.
     * buffer = 0, 7
     * 7 == 0? No, can I match with something? yes, 0 and 7. Then cos + 2 and remove 0 7 from match buffer
     */

    /**
     *  This is very smart in the sense that secret is + and cows is -
     *  if we have > 0 and we analyze guess, that means we have something to match against. Therefore a cow
     *  If we have < 0 and we analyze guess, that means guess has excess of numbers. No cow in this case
     *  Similarly
     *  if we have < 0 and we analyze secret, that means there is a number on guess we can match againts. Therefore a cow
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] buffer = new int[10]; // digits from 0 to 9

        for(int i = 0; i < secret.length(); i++) {
            int secretNumber = secret.charAt(i) - '0';
            int guessNumber = guess.charAt(i) - '0';

            if(secretNumber == guessNumber) {
                bulls++;
            } else {
                if(buffer[secretNumber] < 0) {
                    // we have something to match against
                    cows++;
                }
                if(buffer[guessNumber] > 0) {
                    // same we have something to match against
                    cows++;
                }

                buffer[secretNumber]++;
                buffer[guessNumber]--;
            }
        }

        return bulls + "A" + cows + "B";
    }


    public String getHintIntuition(String secret, String guess) {
        Map<Integer, Integer> matchBuffer = new HashMap<>();

        int bulls = 0;
        int cows = 0;

        for(int i = 0; i < secret.length(); i++) {
            int secretNumber = secret.charAt(i) - '0';
            int guessNumber = secret.charAt(i) - '0';
            if(secretNumber == guessNumber) {
                bulls++;
            } else {

                if(matchBuffer.containsKey(secretNumber)) {
                    cows++;
                    matchBuffer.put(secretNumber, matchBuffer.get(secretNumber) - 1);

                    if(matchBuffer.get(secretNumber) == 0) {
                        matchBuffer.remove(secretNumber);
                    }
                } else {
                    matchBuffer.put(secretNumber, matchBuffer.getOrDefault(secretNumber, 0) + 1);
                }

                if(matchBuffer.containsKey(guessNumber)) {
                    cows++;
                    matchBuffer.put(guessNumber, matchBuffer.get(guessNumber) - 1);

                    if(matchBuffer.get(guessNumber) == 0) {
                        matchBuffer.remove(guessNumber);
                    }
                } else {
                    matchBuffer.put(guessNumber, matchBuffer.getOrDefault(guessNumber, 0) + 1);
                }
            }
        }

        return bulls + "A" + cows + "B";
    }

}
