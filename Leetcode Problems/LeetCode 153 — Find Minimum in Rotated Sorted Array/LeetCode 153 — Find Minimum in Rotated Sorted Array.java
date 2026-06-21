// Leetcode Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

import java.util.*;
class Solution {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        if (nums.length == 1) {
            return nums[0];
        }

        while (left <= right) {
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
            }

            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
