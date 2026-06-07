// Leetcode Link: https://leetcode.com/problems/first-unique-character-in-a-string/

import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();

        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c,0) + 1);
        }

        for (int i=0; i<s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;   
    }
}


//  for index from 1 so do -> i+1
    //     for (int i=0; i<s.length(); i++) {
    //         if (count.get(s.charAt(i)) == 1) {
    //             return i+1;
    //         }
    //     }
