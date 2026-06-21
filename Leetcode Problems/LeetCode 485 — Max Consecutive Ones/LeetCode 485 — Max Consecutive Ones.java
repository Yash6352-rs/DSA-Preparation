// Leetcode Link: https://leetcode.com/problems/max-consecutive-ones/

import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count = 0;
        int maxCount = 0;

        for (int n : nums) {
            if (n == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else {
                count = 0;
            }
        }
        return maxCount;
    }
}

// Input: nums = [1,1,0,1,1,1]
// Output: 3

// Input: nums = [1,0,1,1,0,1]
// Output: 2