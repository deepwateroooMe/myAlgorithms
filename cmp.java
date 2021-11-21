import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        // public int maxDistance(int[] a) {
        //     int n = a.length;
        //     if (n < 2) return 0;
        //     if (a[0] != a[n-1]) return n-1;
        //     int i = 0, j = n-1;
        //     while (i < n-1 && a[i] == a[i+1]) i++;
        //     if (i == n) return 0;
        //     while (j > 0 && a[j-1] == a[j]) j--;
        //     return Math.max(j-1 - 0, n-1-(i+1));
        // }

        // public int wateringPlants(int[] p, int cap) {
        //     int n = p.length, cnt = 0, cur = cap;
        //     int [] dp = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (cur >= p[i]) {
        //             dp[i] = (i == 0 ? 0 : dp[i-1]) + 1;
        //             cur -= p[i];
        //         } else {
        //             dp[i] = dp[i-1] + 2 * (i-1 +1) + 1;
        //             cur = cap - p[i];
        //         }
        //     }
        //     return dp[n-1];
        // }

        // Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        // int [] a;
        // int n;
        // // public RangeFreqQuery(int[] arr) {
        // public cmp(int[] arr) {
        //     n = arr.length;
        //     a = Arrays.copyOf(arr, n);
        //     int [] cnt = new int [10001];
        //     for (int i = 0; i < n; i++) {
        //         cnt[arr[i]]++;
        //         Map<Integer, Integer> tmp = new HashMap<>();
        //         for (int j = 0; j < 10001; j++) 
        //             if (cnt[j] > 0)
        //                 tmp.put(j, cnt[j]);
        //         m.put(i, tmp);
        //     }            
        // }
    
        // public int query(int left, int right, int value) {
        //     // System.out.println("right: " + right);
        //     // System.out.println("left: " + left);
        //     // Map<Integer, Integer> tmp  = m.get(left);
        //     // System.out.println("tmp.size(): " + tmp.size());
        //     // for (Map.Entry<Integer, Integer> en : tmp.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     // System.out.println("(m.get(left-1) == null): " + (m.get(left-1) == null));
        //     if (m.get(right).get(value) == null) return 0;
        //     return m.get(right).get(value) - (left == 0 ? 0 : (m.get(left-1) == null ? 0 : m.get(left-1).get(value) == null ? 0 : m.get(left-1).get(value)));
        // }

        // private int  getBaseKValue (int v, int k) {
        //     String ans = v % k == 0 ? "" : "" + v % k;
        //     int cur = v - v % k;
        //     cur /= k;
        //     while (cur > 0) {
        //         if (cur < k) {
        //             ans = ""+ cur + ans;
        //             break;
        //         } else {
        //                 }
        //     }
        // }
        public static String baseConversion(String number, int sBase, int dBase) {
            // Parse the number with source radix
            // and return in specified radix(base)
            return Integer.toString(Integer.parseInt(number, sBase), dBase);
        }
        public long kMirror(int k, int n) {
           long sum = 0;
           // int cnt = 17;
           // Set<Integer> s = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 6597956, 6958596));
           int cnt = 0, i = 1;
           while (cnt < n) {
               String v = baseConversion("" + i, 10, k);
               // System.out.println("v: " + v);
               if (valid(v) && valid(i)) {
                   sum += i;
                   cnt++;
                   i++;
               }
           }
           return sum;
        }
        private boolean valid(int i) {
            String s = "" + i;
            if (s.length() == 1) return true;
            return new StringBuilder (s).reverse().toString().equals(s);
        }
        private boolean valid(String s) {
            return new StringBuilder (s).reverse().toString().equals(s);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {1, 1, 1, 2, 2};
        // // int [] a = new int [] {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        // cmp s = new cmp(a);

        long r = s.kMirror(7, 17);
        System.out.println("r: " + r);
        
    }
}

