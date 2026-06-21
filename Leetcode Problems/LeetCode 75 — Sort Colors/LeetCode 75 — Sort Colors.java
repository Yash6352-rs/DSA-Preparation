// Leetcode Link: https://leetcode.com/problems/sort-colors/

import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1, curr = 0;

        while (curr <= high) {
            if (nums[curr] == 0) {
                swap(nums, curr, low);
                low++;
                curr++;
            } 
            else if (nums[curr] == 2) {
                // here dont do curr++ because after swap that value may be 0 
                // so check again that same curr
                swap(nums, curr, high);
                high--;
            }
            else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Input: nums = [2,0,1]
// Output: [0,1,2]