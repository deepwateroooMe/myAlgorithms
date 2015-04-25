import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class singleNumberII {
    public static class Solution {

        // straight forward idea is hashmap
        public int singleNumber0(int[] A) {
            Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
            for(int i : A) {
                if (!hash.containsKey(i))
                    hash.put(i, 1);
                else
                    hash.put(i, hash.get(i) + 1);
            }
            for (Integer i : hash.keySet()) {
                if (hash.get(i) != 3) return i;
            }
            return -1;// why always ask for return statement? feel stupid put sth like this here
        }

        // anything special about three ?
        // perfect answers are here:
        // https://oj.leetcode.com/discuss/6632/challenge-me-thx
        // but can not digest it tonight, tomorrow maybe ~
        public int singleNumber(int[] A) {
        }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 2, 2, 1};
        int res = result.singleNumber(a);
        
        System.out.println(res);
    }
}
