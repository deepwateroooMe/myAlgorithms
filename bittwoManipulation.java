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

        // public int numberOfSteps(int v) {
        //     int cnt = 0;
        //     while (v > 0) {
        //         if ((v & 1) == 1) v -= 1;
        //         else v >>= 1;
        //         cnt++;
        //     }
        //     return cnt;
        // }

        // public int xorOperation(int n, int start) {
        //     int [] ans = new int [n];
        //     int xor = 0;
        //     for (int i = 0; i < n; i++) {
        //         ans[i] = start + 2 * i;
        //         xor ^= ans[i];
        //     }
        //     return xor;
        // }

        // public int countConsistentStrings(String allowed, String[] words) {
        //     int a = 0, b = 0, cnt = 0, i = 0;
        //     char [] s = allowed.toCharArray();
        //     for ( i = 0; i < allowed.length(); i++) 
        //         a |= (1 << s[i] - 'a');
        //     // Set<Integer> vis = new HashSet<>(); // 因为allowed长度比较长，生成子集的过程反而很慢
        //     // b = a;
        //     // while (b > 0) {
        //     //     vis.add(b);
        //     //     b = (b-1) & a;
        //     // }
        //     for (String  t : words) {
        //         int cur = 0;
        //         for ( i = 0; i < t.length(); i++) 
        //             cur |= (1 << (t.charAt(i) - 'a'));
        //         for ( i = 25; i >= 0; i--) 
        //             if (((cur >> i) & 1) == 1 && ((a >> i) & 1) == 0) break;
        //         if (i < 0) cnt++;
        //         // if (vis.contains(cur)) cnt++;
        //     }
        //     return cnt;
        // }

        // private int getXorOfSubset(int [] a, int v) {
        //     int ans = 0;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (((v >> i) & 1) == 1) ans ^= a[i];
        //     return ans;
        // }
        // int n;
        // public int subsetXORSum(int[] a) {
        //     n = a.length;
        //     int range = (1 << n), sum = 0;
        //     for (int i = 1; i < range; i++)
        //         sum += getXorOfSubset(a, i);
        //     return sum;
        // }        
        // private void backTracking(int [] a, int idx, int xor) {
        //     ans += xor;
        //     if (idx == a.length) return;
        //     for (int i = idx; i < a.length; i++) {
        //         xor ^= a[i];
        //         backTracking(a, i+1, xor);
        //         xor ^= a[i];
        //     }
        // }
        // int ans = 0;    // to store the answer
        // public int subsetXORSum(int[] nums) {
        //     subsetXORSumHelper(nums, 0, 0);     
        //     return ans;
        // }

        // public int hammingDistance(int x, int y) {
        //     int cnt = 0;
        //     while (x > 0 && y > 0) {
        //         if ((x & 1) == 1 && (y & 1) == 0
        //             || (x & 1) == 0 && (y & 1) == 1)
        //             cnt++;
        //         x >>= 1;
        //         y >>= 1;
        //     }
        //     cnt += (x > 0 ? Integer.bitCount(x) : Integer.bitCount(y));
        //     return cnt;
        //     // return Integer.bitCount(x ^ y);
        // }

        // public int[] sortByBits(int[] a) {
        //     // Arrays.sort(a, (x, y) -> (Integer.bitCount(x) != Integer.bitCount(y) ? (int)(Integer.bitCount((Integer)x) - Integer.bitCount((Integer)y)) : x - y)); // 为什么数组就不能这么直接sort呢？
        //         //         new Comparator<Integer>() {
        //         //     public int compare(Integer x, Integer y) {
        //         //         int i = Integer.bitCount(x);
        //         //         int j = Integer.bitCount(y);
        //         //         if (i != j) return i - j;
        //         //         return x - y;
        //         //     }
        //         // });
        //     int [] cnt = new int [10001];
        //     for (Integer v : a) cnt[v]++;
        //     TreeSet<Integer> s = new TreeSet<>((x, y) -> (Integer.bitCount(x) != Integer.bitCount(y) ? (int)(Integer.bitCount((Integer)x) - Integer.bitCount((Integer)y)) : x - y));
        //     for (Integer v : a) s.add(v);
        //     int idx = 0;
        //     Iterator it = s.iterator();
        //     while (it.hasNext()) {
        //         int cur = (int)it.next();
        //         while (cnt[cur] > 0) {
        //             a[idx++] = cur;
        //             cnt[cur]--;
        //         }
        //     }           
        //     return a;
        // }
        // public int[] sortByBits(int[] a) {
        //     for (int i=0;i<arr.length;i++)
        //         arr[i]+=10001*Integer.bitCount(arr[i]);
        //     Arrays.sort(arr);
        //     for (int i=0;i<arr.length;i++)
        //         arr[i]=arr[i]%10001;
        //     return arr;
        // }

        // private int getBitsCnt(int v) {
        //     int cnt = 0;
        //     while (v != 0) {
        //         cnt++;           // 刚才还用过快进，转眼做师时就没能回想起来
        //         v = v & (v - 1); // 这是遍历v上的bit位，不遍历0位，有一种快进效果在里面
        //     }
        //     // while (v > 0) {
        //     //     if ((v & 1) == 1) cnt++;
        //     //     v >>= 1; // 这是一位一位地数的
        //     // }
        //     return cnt;
        // }
        // private boolean isPrime(int v) {
        //     if (v <= 1) return false;
        //     if (v == 2) return true;
        //     if (v % 2 == 0) return false;
        //     for (int i = 3; i <= Math.sqrt(v); i += 2) 
        //         if (v % i == 0) return false;
        //     return true;
        // }
        // public int countPrimeSetBits(int left, int right) {
        //     // Set<Integer> p = new HashSet<>(List.of(2, 3, 5, 7, 11, 13, 17, 19));
        //     int ans = 0;
        //     for (int i = left; i <= right; i++)
        //         if (isPrime(getBitsCnt(i))) ans++;
        //         // if (p.contains(getBitsCnt(i))) ans++;
        //     return ans;
        // }

        // public int binaryGap(int v) {
        //     int pre = -1, max = 0, cnt = 0;
        //     // while (v != 0) {
        //     //     if ((v & 1) == 1) {
        //     //         if (pre < 0) pre = cnt;
        //     //         else {
        //     //             max = Math.max(max, cnt - pre);
        //     //             pre = cnt;
        //     //         }
        //     //     }
        //     //     v >>= 1; // 这里还是没有办法使用 i = i & (i-1)的，因为要记住各个位的位置
        //     //     cnt++;
        //     // }
        //     for (int i = 30; i >= 0; i--) 
        //         if (((v >> i) & 1) == 1) {
        //             if (pre < 0) pre = i;
        //             else {
        //                 max = Math.max(max, pre - i);
        //                 pre = i;
        //             }
        //         }
        //     return max;
        // }

        // private boolean isNice(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int l = 0, u = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (Character.isUpperCase(s[i])) u |= (1 << (s[i] - 'A'));
        //         else l |= (1 << (s[i] - 'a'));
        //     }
        //     return (l ^ u) == 0;
        // }
        // public String longestNiceSubstring(String s) {
        //     int n = s.length();
        //     String ans = "";
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j <= n; j++) {
        //             String cur = s.substring(i, j);
        //             if (isNice(cur) && (ans.length() == 0 || ans.length() < j-i)) 
        //                 ans = cur;
        //         }
        //     return ans;
        // }

        public boolean hasAlternatingBits(int n) {
            return (n & (n-1)) == 0;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        boolean r = s.hasAlternatingBits(5);
        System.out.println("r: " + r);
    }
}
