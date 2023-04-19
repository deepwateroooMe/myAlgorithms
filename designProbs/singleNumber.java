import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.util.ArrayList;

import java.util.List;


public class singleNumber {
    public static class Solution {

        public int singleNumber(int[] nums) {
            int num = 0;
            for (int x : nums) {
                num ^= x;
            }
            return num;
            
            // HashSet<Integer> set = new HashSet<>();
            // for (int x : nums) {
            //     if (set.contains(x))
            //     set.remove(x);
            //     else
            //     set.add(x);
            // }
            // return set.iterator().next();
            

            // Map<Integer, Integer> map = new HashMap<>();
            // for (int x : nums) {
            //     int cnt = map.containsKey(x) ? map.get(x) : 0;
            //     map.put(x, cnt + 1);
            // }
            // for (int x : nums) {
            //     if (map.get(x) == 1)
            //     return x;
            // }
            // throw new IllegalArgumentException("No single valeu");
         }
        
    }

    public static void main(String[] args){
        Solution result = new Solution();

        int [] a = {1, 1, 2, 2, 3};
        int res = result.singleNumber(a);

        System.out.println(res);
    }
    
}