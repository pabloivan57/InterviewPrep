package com.pablan.leetcode.collection.google.medium;

import java.util.Arrays;

public class CarFleet {

    /**
     *  N cars are going to the same destination along a one lane road.
     *  The destination is target miles away.
     *
     *  Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.
     *
     *  A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.
     *
     *  The distance between these two cars is ignored - they are assumed to have the same position.
     *
     *  A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.
     *
     *  If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
     *
     *
     *  How many car fleets will arrive at the destination?
     *
     *  Example 1:
     *
     *  Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     *  Output: 3
     *  Explanation:
     *  The cars starting at 10 and 8 become a fleet, meeting each other at 12.
     *  The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
     *  The cars starting at 5 and 3 become a fleet, meeting each other at 6.
     *  Note that no other cars meet these fleets before the destination, so the answer is 3.
     *
     *
     *  Pablo's notes: This is an easy problem, just that wording is scary
     *
     *  1.- You can calculate how much time is left by dividing the space left by the speed
     *  Basically, imagine car at position 10. In order to reach 12 it has 2 miles left... now,
     *  it moves at 2 miles per hour. So it needs 1 hour
     *  (12 - 10) / 2 ==> target - position[i] / speed[i]
     *
     *  Let's do that
     *  carPos     timeLeft
     *  10          (12 - 10) / 2 == 1
     *  8           (12 - 8)  / 4 == 1
     *  0           (12 - 0) / 1 == 12
     *  5           (12 - 5) / 1 == 7
     *  3           (12 - 3) / 3 == 3
     *
     *  10, 1
     *  8, 1
     *  0, 12
     *  5, 7
     *  3, 3
     *
     *  2.- Now, sort them by starting position, Now because they are on a single lane
     *      they will merge
     *
     *  0, 12
     *  3, 3  \  -> This guy will reach target faster than 5. But 5 will block him. So they
     *  5, 7  /     will become a fleet
     *  8, 1
     *  10, 1
     *
     *  3.- In other words, from the car closest to the end. If I find that timeLeft is more than current,
     *  this means it will take longer to reach target, therefore will become the lead of a new fleet
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] timeLeft = new int[position.length][2];

        // Build matrix of how much time left for target on each car
        for(int i = 0; i < position.length; i++) {
            timeLeft[i][0] = position[i];
            timeLeft[i][1] = (target - position[i]) / speed[i];
        }

        // sort in ascending order
        Arrays.sort(timeLeft, (a, b) -> a[0] - b[0]);

        // from top to bottom check if time left is more than current car. Each time this happens
        // we are in a new fleet
        int currentSlowest = 0;
        int carFleets = 0;
        for(int i = timeLeft.length - 1; i >= 0; i--) {
            if(timeLeft[i][1] > currentSlowest) {
                currentSlowest = timeLeft[i][1];
                carFleets++;
            }
        }

        return carFleets;
    }
}
