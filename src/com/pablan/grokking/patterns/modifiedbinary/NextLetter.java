package com.pablan.grokking.patterns.modifiedbinary;

import java.util.Arrays;

public class NextLetter {

    /**
     *  Given an array of lowercase letters sorted in ascending order,
     *  find the smallest letter in the given array greater than a given ‘key’.
     *
     *  Assume the given array is a circular list, which means that the last letter is assumed
     *  to be connected with the first letter. This also means that the smallest letter in the given
     *  array is greater than the last letter of the array and is also the first letter of the array.
     *
     *  Write a function to return the next letter of the given ‘key’.
     *
     *  Example 1:
     *
     *  Input: ['a', 'c', 'f', 'h'], key = 'f'
     *  Output: 'h'
     *  Explanation: The smallest letter greater than 'f' is 'h' in the given array.
     *  Example 2:
     *
     *  Input: ['a', 'c', 'f', 'h'], key = 'b'
     *  Output: 'c'
     *  Explanation: The smallest letter greater than 'b' is 'c'.
     *  Example 3:
     *
     *  Input: ['a', 'c', 'f', 'h'], key = 'm'
     *  Output: 'a'
     *  Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.
     *  Example 4:
     *
     *  Input: ['a', 'c', 'f', 'h'], key = 'h'
     *  Output: 'a'
     *  Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
     *
     *  Pablo's notes: The ceiling is the next number of a target, At some point
     *  if target is not in the array we will be down to the number before it [2 to 2 for example].
     *  And because of our clause. less or equal will go to the next hop. 3 in this case
     *  if 3 is outside bounds... then because is circular we go back to 0
     */
    public char searchNextLetter(char[] letters, char key) {
       int low = 0;
       int high = letters.length - 1;

       while(low <= high) {
           int middle = low + ((high - low) / 2);

           if(letters[middle] <= key) {
               low = middle + 1;
           } else {
               high = middle - 1;
           }
       }

       return letters[low % letters.length];
    }
}
