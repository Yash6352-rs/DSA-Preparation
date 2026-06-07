// Leetcode Link: https://leetcode.com/problems/group-anagrams/

import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> ansMap = new HashMap<>();

        for (String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            
            String key = new String(arr);

            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList());
            }
            ansMap.get(key).add(s);
        }

        return new ArrayList(ansMap.values());
    }
}