// Leetcode Link: https://leetcode.com/problems/majority-element/

import java.util.*;
class Solution {
     public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int i=0; i<nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : count.keySet()) {
            if (count.get(key) > nums.length / 2) {
                ans = key;
            }
        }
        return ans;
    }
}

// Input: nums = [3,2,3]
// Output: 3

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2