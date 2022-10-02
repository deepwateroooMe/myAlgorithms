import com.TreeNode;

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

        // public int commonFactors(int a, int b) {
        //     Set<Integer> sa = getFactors(a);
        //     Set<Integer> sb = getFactors(b);
        //     sa.retainAll(sb);
        //     return sa.size() + 1;
        // }
        // Set<Integer> getFactors(int v) {
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 2; i <= v; i++) 
        //         if (v % i == 0)
        //             s.add(i);
        //     return s;
        // }

        // public int maxSum(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     int [][] s = new int[m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + a[i-1][j-1];
        //     int max = 0, cur = 0;
        //     for (int i = 1; i < m-1; i++) 
        //         for (int j = 1; j < n-1; j++) {
        //             cur = s[i+2][j+2] - a[i][j-1] - a[i][j+1] - s[i-1][j+2] - s[i+2][j-1] + s[i-1][j-1];
        //             if (cur > max) max = cur;
        //         }
        //     return max;
        // }

        // public int minimizeXor(int a, int b) {
        //     int m = Integer.bitCount(a);
        //     int n = Integer.bitCount(b);
        //     int cnt = 0, v = 0;
        //     for (int i = 31; i >= 0 && cnt < n; i--) {
        //         if (((a >> i) & 1) == 1) {
        //             cnt++;
        //             v |= (1 << i);
        //         }
        //     }
        //     if (cnt == n) return v;
        //     for (int i = 0; i <= 31 && cnt < n; i++) 
        //         if (((a >>> i) & 1) == 0) {
        //             cnt++;
        //             v |= (1 << i);
        //         }
        //     return v;
        // }

        // public int deleteString(String s) { // TLE TLE TLE:超时是因为没有记忆
        //     int n = s.length(), max = 1;
        //     if (n == 1 || n == 2 && s.charAt(0) != s.charAt(1)) return 1;
        //     if (n == 2 && s.charAt(0) == s.charAt(1)) return 2;
        //     char [] t = s.toCharArray();
        //     if (n == 3 && t[0] == t[1]) return t[1] == t[2] ? 3 : 2;
        //     else if (n == 3) return 1;
        //     for (int i = 1; i <= n/2; i++) {
        //         if (s.substring(i).startsWith(s.substring(0, i))) {
        //             int cur = 1 + deleteString(s.substring(i));
        //             if (cur > max) max = cur;
        //         }
        //     }
        //     return max;
        // }
        public int deleteString(String t) { // 超时是因为没有记忆, 用dfs记忆化搜索
            n = t.length();
            if (t.chars().distinct().count() == 1) return n;
            this.t = t;
            s = t.toCharArray();
            if (n == 1 || n == 2 && s[0] != s[1]) return 1;
            if (n == 2 && s[0] == s[1]) return 2;
            if (n == 3 && s[0] == s[1]) return s[1] == s[2] ? 3 : 2;
            else if (n == 3) return 1;
            f = new Integer [n];
            dfsSearchWithMemory(0);
            System.out.println(Arrays.toString(f));
            return f[0];
        }
        Integer [] f;
        char [] s;
        String t;
        int n;
        int dfsSearchWithMemory(int i) {
            if (i >= n) return 0;
            if (f[i] != null) return f[i];
            if (i == n-1) return f[i] = 1;
            int max = 0, cur = 0, j = i+1;
            for (j = i+1; j <= (n-i)/2 + i; j++) {
                if (t.substring(j).startsWith(t.substring(i, j))) {
                    cur = 1 + dfsSearchWithMemory(j);
                    if (cur > max) max = cur;
                }
            }
            if (j > (n-i)/2 + i && max == 0) return f[i] = 1;
            return f[i] = max;
        }        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        String a = "aaabaab";

        int r = s.deleteString(a);
        System.out.println("r: " + r); 
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
