import com.TreeNode;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
public class cmp {
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] minDistinctFreqPair(int[] a) {
        //     int n = a.length, m = 101;
        //     int [] f = new int [m];
        //     for (int v : a)
        //         f[v]++;
        //     int [] r = new int [2];
        //     for (int i = 0; i < m; i++) {
        //         if (f[i] == 0) continue;
        //         for (int j = i+1; j < m; j++) {
        //             if (f[j] == 0 || f[j] == f[i]) continue;
        //             r[0] = i; r[1] = j;
        //             return r;
        //         }
        //     }
        //     Arrays.fill(r, -1);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数据规模小，直接暴力解法
        // public String mergeCharacters(String S, int k) {
        //     int n = S.length(), m = 26, o = 0; char [] s = S.toCharArray();
        //     int [] f = new int [m]; Arrays.fill(f, -1);
        //     StringBuilder sb = new StringBuilder();
        //     sb.append(s[0]);
        //     boolean merged = false;
        //     for (int i = 1; i < n; i++) {
        //         o = sb.length();
        //         merged = false;
        //         for (int j = Math.max(0, o-k); j < o; j++) 
        //             if (sb.charAt(j) == s[i]) {
        //                 merged = true;
        //                 break;
        //             }
        //         if (merged) continue;
        //         sb.append(s[i]);
        //     }
        //     return sb.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 今天早上的破烂题目，都出得极其恶心，恶心死人、恶心坏这个世界不偿命！！！它们的贱鸡、贱畜牲们，真贱！！！
        // public int[] makeParityAlternating(int[] a) {
        //     int n = a.length, min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
        //     int r = 0, curMin = Integer.MAX_VALUE / 2, curMax = Integer.MIN_VALUE / 2;
        //     int [] f = new int [2]; 
        //     if (n == 1) return f;
        //     f[0] = n;
        //     if (n == 2 && a[0] == a[1]) {
        //         Arrays.fill(f, 1);
        //         return f;
        //     }
        //     boolean odd = false;
        //     // 遍历 2 遍
        //     // 第一遍：【不修改 0-index】的数值
        //     r = 0;
        //     odd = false;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0
        //             || odd && i % 2 != (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 == (a[i] % 2 + 2) % 2) {
        //             curMin = Math.min(curMin, a[i]);
        //             curMax = Math.max(curMax, a[i]);
        //             if (i == 0) odd = ((a[i] % 2 + 2) % 2 == 1 ? true : false);
        //             continue;
        //         }
        //         if (odd && i % 2 == (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 != ((a[i] % 2) + 2) % 2) {
        //             if (a[i] == min) {
        //                 curMin = Math.min(curMin, a[i] + 1);
        //                 curMax = Math.max(curMax, a[i]);
        //             } else if (a[i] == max) {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]-1);
        //             }
        //             r++;
        //         }
        //     }
        //     if (r < f[0]) {
        //         f[0] = r; f[1] = curMax - curMin;
        //     }
        //     // 第二遍：【修改 0-index】的数值
        //     r = 0;
        //     odd = false;
        //     curMin = Integer.MAX_VALUE / 2; curMax = Integer.MIN_VALUE / 2;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0
        //             || odd && i % 2 != (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 == (a[i] % 2 + 2) % 2) {
        //             if (i == 0) {
        //                 if (a[i] == min) {
        //                     curMin = Math.min(curMin, a[i] + 1);
        //                     curMax = Math.max(curMax, a[i]);
        //                 } else if (a[i] == max) {
        //                     curMin = Math.min(curMin, a[i]);
        //                     curMax = Math.max(curMax, a[i]-1);
        //                 }
        //                 odd = (((a[i] % 2) + 2) % 2 == 1 ? false : true);
        //                 r++;
        //                 continue;
        //             } else {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]);
        //             }
        //         }
        //         if (odd && i % 2 == (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 != ((a[i] % 2) + 2) % 2) {
        //             if (a[i] == min) {
        //                 curMin = Math.min(curMin, a[i] + 1);
        //                 curMax = Math.max(curMax, a[i]);
        //             } else if (a[i] == max) {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]-1);
        //             }
        //             r++;
        //         }
        //     }
        //     if (r < f[0] || r == f[0] && curMax - curMin < f[1]) {
        //         f[0] = r; f[1] = curMax - curMin;
        //     }
        //     if (n > 1 && min == max) f[1] = 1;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，这个破烂题目，是【暴力数】个数，太不想写这类恶心死人、恶心坏这个世界不偿命！！！数个数的题目了。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int sumOfNumbers(int l, int r, int k) {
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String trimTrailingVowels(String S) {
        //     Set<Character> s = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     int n = S.length(), i = n-1;
        //     while (i >= 0 && s.contains(S.charAt(i))) --i;
        //     return (i >= 0 ? S.substring(0, i+1) : "");
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minCost(int n) {
        //     if (n == 1) return 0;
        //     if (n == 2) return 1;
        //     int [] f = new int [n+1];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     f[1] = 1;
        //     f[2] = 1;
        //     f[3] = 3;
        //     for (int i = 4; i <= n; i++) 
        //         for (int j = 1; j <= i/2; j++) 
        //             f[i] = Math.min(f[i], j * (i-j) + (j > 1 ? f[j] : 0) + (i-j > 1 ? f[i-j] : 0));
        //     return f[n];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 不知道这个题目怎么去想，亲爱的表哥的活宝妹，写不到后面的两个破烂题目了，不想再写了。。。下个周六再写
        // public int minimumOR(int[][] a) {
        //     int m = a.length, n = a[0].length, f = 0;
        //     for (int i = 0; i < m; i++)
        //         Arrays.sort(a[i]);
        //     for (int i = 0; i < m; i++)
        //         f |= a[i][0];
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumIndex(int[] a, int v) {
        //     int n = a.length;
        //     int min = 1027, j = -1;
        //     for (int i = 0; i < n; i++)
        //         if (a[i] >= v) 
        //             if (a[i] < min) {
        //                 min = a[i];
        //                 j = i;
        //             }
        //     return j;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int smallestBalancedIndex(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return -1;
        //     long [] f = new long [n+1], g = new long [n+1];
        //     for (int i = 1; i <= n; i++)
        //         f[i] = f[i-1] + (long)a[i-1];
        //     g[n] = 1;
        //     for (int i = n-1; i >= 0; i--)
        //         g[i] = g[i+1] * (long)a[i];
        //     for (int i = 1; i <= n; i++)
        //         if (f[i] == (i == n ? 1 : g[i+1])) return i;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】思路不对；最贪心的算法，却没能保障（答案正确）。。。
        // public int minOperations(String S) {
        //     n = S.length(); 
        //     s = S.toCharArray(); t = S.toCharArray();
        //     Arrays.sort(t);
        //     System.out.println(Arrays.toString(s));
        //     System.out.println(Arrays.toString(t));
        //     m = new HashMap<>();
        //     int i = 0, j = 0, r = 0;
        //     for (i = 0, j = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (s[i] == t[i]) continue;
        //         if (i < n-1 && s[i+1] == t[i] && t[i+1] == s[i]) {
        //             r++;
        //             i++;
        //             continue;
        //         }
        //         m.put(s[i], m.getOrDefault(s[i], 0)+1);
        //         m.put(t[i], m.getOrDefault(t[i], 0)-1);
        //         j = i+1;
        //         m.put(s[j], m.getOrDefault(s[j], 0)+1);
        //         m.put(t[j], m.getOrDefault(t[j], 0)-1);
        //         System.out.println("i: " + i + " " + "j: " + j);
        //         while (j < n && m.values().stream().distinct().count() > 1) {
        //             j++;
        //             if (j == n) break;
        //             m.put(s[j], m.getOrDefault(s[j], 0)+1);
        //             m.put(t[j], m.getOrDefault(t[j], 0)-1);
        //         }
        //         System.out.println("j: " + j);
        //         if (j == n) break;
        //         // if (i > 0 &&  m.values().stream().distinct().count() == 1) {
        //         if (m.values().stream().distinct().count() == 1) {
        //             r++;
        //             System.out.println("j: " + j + " " + "r: " + r);
        //             if (j == n-1) return (i > 0 ? r : -1);
        //             m.clear();
        //             i = j;
        //         }
        //     }
        //     System.out.println("i: " + i + " " + "j: " + j + " " + "r: " + r);
        //    if (i != 0 && j == n && m.values().stream().distinct().count() == 1) return r+1;
        //    if (i > 0 && n > 2) return r;
        //    return -1;
        // }
        // Map<Character, Integer> m;
        // char [] s, t;
        // int n;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 885/1009-passed..
        // // 亲爱的表哥的活宝妹，今天不想再写这组题目了，下个周六再写。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minCost(String S, int y, int x) {
        //     n = S.length(); this.x = x; this.y = y;
        //     s = S.toCharArray();
        //     // 【前缀和】
        //     f = new int [n+1]; ff = new int [n+1]; 
        //     for (int i = 0; i < n; i++) 
        //         f[i+1] = f[i] + s[i]-'0';
        //     // 数【最小：片段】前缀和个数
        //     ff[1] = 1;
        //     for (int i = 1; i < n; i++) 
        //         if (s[i] != s[i-1])
        //             ff[i+1] = ff[i] + 1;
        //     // 区间型动规：【记忆字典】
        //     m = new HashMap<>();
        //     return dfs(0, n-1);
        // }
        // Map<String, Long> m;
        // int [] f, ff; char [] s;
        // int n, x, y;
        // long dfs(int i, int j) {
        //     if (i > j) return 0l;
        //     String key = i + "-" + j;
        //     if (m.containsKey(key)) return m.get(key);
        //     long r = Long.MAX_VALUE / 2;
        //     if (i == j || f[j+1]-f[i] == 0l) {
        //         if (i == j)
        //             r = (long)(s[i] == '1' ? y : x);
        //         else r = x;
        //         m.put(key, r);
        //         return r;
        //     }
        //     // 【1 整条片段】的代价
        //     r = Math.min(r, (f[j+1]-f[i] > 0 ? (long)(j-i+1) * (f[j+1]-f[i]) * y : x));
        //    System.out.println("r: " + r);
        //    // 2 个【半条片段】的、代价和, 只在，整条片段代价过大时，使用
        //    // if ((j-i+1) % 2 == 0 && r > (long)(j-i+1-(f[j+1]-f[i])) * x) { // 思路不透彻，这么不能保障【正确答案】
        //    if ((j-i+1) % 2 == 0) {
        //         r = Math.min(r, dfs(i, i + (j+1-i)/2 -1) + dfs(i+(j-i+1)/2, j));
        //         System.out.println("r: " + r);
        //     }
        //     m.put(key, r); 
        //     return r; 
        // }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        String a = "0111";
        long r = s.minCost(a, 4, 50);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a0]);  
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】