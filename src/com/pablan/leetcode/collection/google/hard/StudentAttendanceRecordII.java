package com.pablan.leetcode.collection.google.hard;

public class StudentAttendanceRecordII {

    /**
     *  Given a positive integer n, return the number of all possible attendance records with length n,
     *  which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
     *
     *  A student attendance record is a string that only contains the following three characters:
     *
     *  'A' : Absent.
     *  'L' : Late.
     *  'P' : Present.
     *  A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
     *
     *  Example 1:
     *
     *  Input: n = 2
     *  Output: 8
     *  Explanation:
     *  There are 8 records with length 2 will be regarded as rewardable:
     *  "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
     *  Only "AA" won't be regarded as rewardable owing to more than one absent times.
     *
     *  Pablo's notes: Key here is to just consider the sequences that end in P or L
     *  You take advantage of the fact that they are asking just 1 'A' so that sort of
     *  locks the sequence
     *
     *  Imagine a sequence with No A and No more than 1 L
     *  |----------| n = 10 These is the inital part... all valid records with no A
     *
     *  Ok, let's say from this sequences now... you want to add A in each position
     *  which would be still valid right? We start locking each position to A
     *
     *  How would you go about it... let's say n = 2
     *  |--| A |-------|
     *    2       7
     *
     *  PorL means sequences that end in P or L with no A and no more than 1 L
     *
     *  Basically you are saying... Give me PorL sequences of length 2 and
     *  multiply them by PorL sequences of length 7. This is because
     *  they are asking for permutations. In other words you are inserting A
     *  and in each space
     *
     *  Now when you calculate them you don't go all the way to n that's because
     *  |---------| A
     *       9          A is locked to 10, no need to count it
     *
     *  in a for loop if n = 10 and i = 2 the equivalent would be
     *
     *  PorL[10 - 2 - 1] * PorL[2]
     *
     *
     *  As far as PorL... how can you find it. Well let' say I know all the sequences ending in P
     *  as P[n], I can have up to two Ls so  (P[n - 1] + L) or P([n - 2] + L + L) --> Here at the beginning
     *                              I was like... there has to be more combos with P[n - 2], but remember you're ignoring A for now and
     *                              if you have P[n - 2] and next option you select P that is the same as P[n - 1]
     */
    public int checkRecord(int n) {
        int P[] = new int[n + 1]; // as every DP you are working with numbers and you need a use case 0
        int PorL[] = new int[n + 1];

        P[0] = 1; // How many valid series with no days... 1, no attendance
        P[1] = 1; // How many valid series ending with P of length 1... 1, P
        PorL[0] = 1; // How many valid series with no days... 1, no attendance
        PorL[1] = 2; // How many valid series ending with P or L of length 1... 2, P or L

        for(int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = P[i] + P[i - 1] + P[i - 2];
        }

        int res = PorL[n];
        for(int i = 0; i < n; i++) { // < n because we are inserting an A in (n - 1) sequences
            int s = PorL[n - i - 1] * PorL[i];
            res = res + s;
        }

        return res;
    }
}
