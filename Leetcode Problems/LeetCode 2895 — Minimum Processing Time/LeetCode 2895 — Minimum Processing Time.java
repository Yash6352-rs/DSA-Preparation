// Leetcode Link: https://leetcode.com/problems/minimum-processing-time/

import java.util.*;
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {

        int n = tasks.size();
        Collections.sort(processorTime);
        Collections.sort(tasks);

        int j = n - 1;
        int m = processorTime.size();
        int ans = 0;
        
        for (int i=0; i<m; i++) {
            int c = 0;

            while (c < 4 && j >= 0) {
                ans = Math.max(ans, processorTime.get(i) + tasks.get(j));
                c += 1;
                j--;
            }
        }

        return ans;   
    }
}