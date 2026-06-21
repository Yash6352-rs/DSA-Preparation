// Leetcode Link: https://leetcode.com/problems/largest-number/

import java.util.*;
class Solution {
    public String largestNumber(int[] nums) {

        String[] asStrs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }            
        });
        
        if (asStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder largestStr = new StringBuilder();
        for (String s : asStrs) {
            largestStr.append(s);
        }

        return largestStr.toString();
    }
}

// Input: nums = [10,2]
// Output: "210"

// Input: nums = [3,30,34,5,9]
// Output: "9534330"
  