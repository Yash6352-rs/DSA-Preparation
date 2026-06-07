// Leetcode Link: https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for (int n: numSet) {
            if (numSet.contains(n-1)) {
                continue;
            }
            else {
                int currentNum = n;
                int currentSub = 1;

                while (numSet.contains(currentNum+1)) {
                    currentNum++;
                    currentSub++;
                }
                longestSub = Math.max(longestSub, currentSub);
            }
        }
        return longestSub;
    }      
}