import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class longestConsecutive {
    public static class Solution {
        public int longestConsecutive(int[] num) {
            if (num == null || num.length == 0) return 0;
            if (num.length == 1) return 1;
            if (num.length == 2)
                return Math.abs(num[0]-num[1]) == 1 ? 2 : 1;

            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            int result = 1;
            int leftbound, rightbound;
            for(int i : num) {
                System.out.println("i: " + i);
                
                if (hash.containsKey(i)) continue;
                hash.put(i, 1);
                if (hash.containsKey(i-1))
                    leftbound = hash.get(i-1);
                else leftbound = 0;
                if (hash.containsKey(i+1))
                    rightbound = hash.get(i+1);
                else rightbound = 0;
                
                hash.put(i-leftbound, 1 + leftbound + rightbound);
                hash.put(i+leftbound, 1 + leftbound + rightbound);
                result = Math.max(result, 1 + leftbound + rightbound);
                System.out.println("result: " + result);
            }
            return result;
        }
    }
    
    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int res = result.longestConsecutive(a);
        
        System.out.println(res);
    }
}
