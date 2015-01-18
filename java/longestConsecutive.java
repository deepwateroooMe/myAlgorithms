import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class longestConsecutive {
    public static class Solution {
        
        // or use two sets to ensure O(n)
        public int longestConsecutive(int[] num) {
            if (num == null || num.length == 0) return 0;
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            int res = 0, tmp;
            int left, right;

            for(int i : num) {
                if (!hash.containsKey(i)) {
                    left = (hash.containsKey(i - 1)) ? hash.get(i - 1) : 0;
                    right = (hash.containsKey(i + 1)) ? hash.get(i + 1) : 0;
                    tmp = left + right + 1;
                    hash.put(i, tmp);
                    res = Math.max(res, tmp);
                    hash.put(i - left, tmp);
                    hash.put(i + right, tmp);
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
