// Leetcode Link: https://leetcode.com/problems/longest-repeating-character-replacement/

import java.util.*;
class Solution {
    public int characterReplacement(String s, int k) {

        int[] occurrance = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        for (; right<s.length(); right++) {
            maxOccurance = Math.max(maxOccurance, ++occurrance[s.charAt(right) - 'A']);
            if (right - left + 1 - maxOccurance > k) {
                occurrance[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;  
    }
}