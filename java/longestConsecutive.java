import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class longestConsecutive {
    public static class Solution {
        public int longestConsecutive(int[] num) {
            Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
            int longest = 0;
            for(int i : num) {
                if (used.containsKey(i)) continue;
                int length = 1;
                used.put(i, true);
                for (int j = i + 1; used.containsKey(j); j++) {
                    used.put(j, true);
                    ++length;
                }
                for (int j = i - 1; used.containsKey(j); j--) {
                    used.put(j, true);
                    ++length;
                }
                longest = Math.max(longest, length);
            }
            return longest;
        }
        
        public int longestConsecutive0(int[] num) {
            //if (num == null || num.length == 0) return 0;
            Map<Integer, Integer> used = new HashMap<Integer, Integer>();
            int res = 0, tmp;
            int left, right;

            for(int i : num) {
                if (!used.containsKey(i)) {
                    left = (used.containsKey(i - 1)) ? used.get(i - 1) : 0;
                    right = (used.containsKey(i + 1)) ? used.get(i + 1) : 0;
                    tmp = left + right + 1;
                    used.put(i, tmp);
                    res = Math.max(res, tmp);
                    used.put(i - left, tmp);
                    used.put(i + right, tmp);
                } else continue;
            }
            return res;
        }
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = result.longestConsecutive(a);
        
        System.out.println(res);
    }
}
/*
Input:	[0,3,7,2,5,8,4,6,0,1]
Output:	6
Expected:	9
 */
