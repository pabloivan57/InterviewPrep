package com.pablan.leetcode.medium;

public class ContainerWithMostWater {

    /**
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.

    Pablo's Notes: Look at what the area formula means... (base * height). This means... height is more important
    towards achieving big values than base. For example
          |
        | |
      | | |
    | | | |

     In this case i = 1, base1 = (4 - 1) = 3
                   height1 = Min(1, 4) = 1
                   area1 = 3 * 1 == 3

     Let's see case i = 2, base2 = (4 - 2) = 2
                   height2 = Min(2, 4) = 2
                   area2 = 4 * 2 == 4 + 4 = 8
    **/
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while(start <= end) {
            int localArea = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(maxArea, localArea);

            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
