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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 感觉，这个破烂题目，是【暴力数】个数，太不想写这类恶心死人、恶心坏这个世界不偿命！！！数个数的题目了。。
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public int sumOfNumbers(int l, int r, int k) {
            return 0;
        }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int [] a = new int [] {1};

        int [] r = s.makeParityAlternating(a);
        System.out.println(Arrays.toString(r));
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