import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class grethreeedy {
    public static class Solution {
            
        // public int findMinMoves(int[] machines) {
        //     int n = machines.length, sum = Arrays.stream(machines).sum(), avg = sum / n;
        //     if (sum % n != 0) return -1;
        //     int ans = 0;
        //     for (Integer v : machines) 
        //         ans += Math.abs(avg - v);
        //     return ans / 2;
        // }

        // public int minTimeToType(String word) {
        //     int n = word.length(), ans = 0, pre = 0;
        //     char [] s = word.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         int idx = s[i] - 'a';
        //         int dis = Math.min(Math.abs(idx-pre), 26 - idx +pre);
        //         System.out.println("dis: " + dis);
        //         ans += dis;
        //         System.out.println("ans: " + ans);
        //     }
        //     return ans;
        // }

        // public int smallestRangeII(int[] a, int k) { // bug
        //     int n = a.length, ans = 0, max = 0, min = Integer.MAX_VALUE;
        //     if (n == 1) return 0;
        //     Arrays.sort(a);
        //     int mem = a[n-1] - a[0];
        //     if (a[n-1] - a[0] <= k) return a[n-1] - a[0];
        //     a[0] += k;
        //     a[n-1] -= k;
        //     max = Math.max(a[0], a[n-1]);
        //     min = Math.min(a[0], a[n-1]);
        //     ans = Math.abs(a[0] - a[n-1]);
        //     for (int i = 1; i < n-1; i++) {
        //         int va = Math.max(Math.abs(a[i]+k-min), Math.abs(a[i]+k-max));
        //         int vb = Math.max(Math.abs(a[i]-k-min), Math.abs(a[i]-k-max));
        //         ans = Math.max(ans, Math.min(va, vb));
        //         if (va < vb) a[i] += k;
        //         else if (va == vb) {
        //             if (Math.abs(a[i] + k - max) >= Math.abs(a[i] - k - min))
        //                 a[i] -= k;
        //             else a[i] += k;
        //         } else a[i] -= k;
        //         max = Math.max(max, a[i]);
        //         min = Math.min(min, a[i]);
        //         System.out.println(Arrays.toString(a));
        //     }
        //     return Math.min(mem, ans);
        // }
        // public int smallestRangeII(int[] a, int k) {
        //     Arrays.sort(a);
        //     int n = a.length, ans = a[n-1] - a[0];
        //     int l = a[0] + k, r = a[n-1] - k;
        //     for (int i = 0; i < n-1; i++) {
        //         int hi = Math.max(r, a[i] + k);
        //         int lo = Math.min(l, a[i+1] - k);
        //         ans = Math.min(ans, hi - lo);
        //     }
        //     return ans;
        // }

        // private long quickMultiply(long base, long exp) { // 快速乘方计算
        //     long ans = 1;
        //     while (exp > 0) {
        //         if ((exp & 1) == 1) 
        //             ans = ans * base % mod;
        //         base = base * base % mod;
        //         exp >>= 1;
        //     }
        //     return ans;
        // }
        // static final long mod = (int)1e9 + 7;
        // public int minNonZeroProduct(int p) {  //贪心
        //     long r = (1l << p) - 1; // BUG: (1 << P) - 1, 没有括号就是 1 << (p - 1)
        //     // long ans = quickMultiply(r-1, (r-1) >> 1) * r % mod; // (r-1) % MOD MOD needed here base * base : (2^60-1)*(2^60-1) 会溢出
        //     // long ans = quickMultiply((r-1) % mod, (r-1) >> 1) * r % mod; // BUG: MOD
        //     long ans = quickMultiply((r-1) % mod, (r-1) >> 1) * (r % mod) % mod; // 答案 = (((最大数值-1)*1) ^ 操作后最大数值-1的个数) * 最大数值
        //     return (int) ans;
        // }

        // public int maxArea(int h, int w, int[] h, int[] v) {
        //     Arrays.sort(h);
        //     Arrays.sort(v);
        //     System.out.println(Arrays.toString(h));
        //     System.out.println(Arrays.toString(v));
        //     int max = 0;
        //     return max;
        // }
    }
    public static void main(String[] args) {
        Solution s = new Solution();


        int r = s.minNonZeroProduct(32);
        System.out.println("r: " + r);
    }
}