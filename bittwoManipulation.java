import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class bittwoManipulation {
    public static class Solution {
            
        // public int minFlips(int a, int b, int c) {
        //     if ((a | b) == c) return 0;
        //     int res = 0;
        //     for (int i = 0; i < 31; i++) {
        //         if (((c >> i) & 1) == 1) {
        //             if ((a & (1 << i)) == 0 && ((b & (1 << i)) == 0))
        //                 res++;
        //         } else { // c: 0
        //             if (((a >> i) & 1) == 1 || ((b >> i) & 1) == 1) {
        //                 if (((a >> i) & 1) == 1 && ((b >> i) & 1) == 1)
        //                     res += 2;
        //                 else res++;
        //             }
        //         }
        //     }
        //     return res;
        // }


         // public int longestAwesome(String s) { // mask: 10 digits
         //     int n = s.length(), mask = 0, max = 0, cur = 0;
         //     Map<Integer, Integer> m = new HashMap<>();
         //     for (int i = 0; i < n; i++) {
         //         mask ^= (1 << (s.charAt(i) - '0'));
         //         if (Integer.bitCount(mask) <= 1) // odd or even palindrome
         //             max = Math.max(max, i+1);
         //         else {
         //             if (m.containsKey(mask))
         //                 max = Math.max(max, i-m.get(mask)+1); // // 这不是最优解，不能从这里中断
         //             for (int j = 0; j < 10; j++) {
         //                 if (((mask >> j) & 1) == 1) {
         //                     cur = (mask & ~(1 << j));
         //                     if (m.containsKey(cur)) 
         //                         max = Math.max(max, i-m.get(cur));
         //                 } else {
         //                     cur = (mask | (1 << j));
         //                     if (m.containsKey(cur)) 
         //                         max = Math.max(max, i-m.get(cur));
         //                 }
         //             }
         //         }
         //         if (!m.containsKey(mask)) m.put(mask, i);
         //     }
         //     return max;
         // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int r = s.longestAwesome(a);
        System.out.println("r: " + r);
    }
}
