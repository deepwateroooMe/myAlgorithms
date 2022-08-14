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

        // public int[][] largestLocal(int[][] a) {
        //     int n = a.length, m = n - 2;
        //     int [][] r = new int [m][m];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < m; j++) 
        //             for (int x = i; x <= i+2; x++)
        //                 for (int y = j; y <= j+2; y++) 
        //                     r[i][j] = Math.max(r[i][j], a[x][y]);
        //     return r;
        // }

        // public int edgeScore(int[] a) {
        //     int n = a.length, r = -1;
        //     long max = -1;
        //     Map<Integer, Long> m = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         m.put(a[i], m.getOrDefault(a[i], 0l) + i);
        //     for (Map.Entry<Integer, Long> en : m.entrySet()) {
        //         if (en.getValue() > max) {
        //             max = en.getValue();
        //             r = en.getKey();
        //         }
        //     }
        //     return r;
        // }

        // public String smallestNumber(String t) { // n: [1, 8]
        //     n = t.length();
        //     s = t.toCharArray();
        //     dfsBackTracking(0, new StringBuilder(), new boolean [n+2]);
        //     return ans;
        // }
        // char [] s;
        // String ans = "";
        // int n;
        // void dfsBackTracking(int idx, StringBuilder cur, boolean [] vis) {
        //     if (idx == n+1) {
        //         if (ans.equals("") || cur.toString().compareTo(ans) < 0)
        //             ans = cur.toString();
        //         return ;
        //     }
        //     for (int i = 1; i <= n+1; i++) {
        //         if (!ans.equals("")) return;
        //         if (vis[i]) continue;
        //         if (idx > 0 && idx <= n && s[idx-1] == 'I' && i <= cur.charAt(idx-1) - '0') continue;
        //         if (idx > 0 && idx <= n && s[idx-1] == 'D' && i >= cur.charAt(idx-1) - '0') continue;
        //         cur.append(i);
        //         vis[i] = true;
        //         dfsBackTracking(idx+1, cur, vis);
        //         vis[i] = false;
        //         cur.setLength(cur.length()-1);
        //     }
        // }

        // 不喜欢这个题目，不写了，下个周再参加比赛
        public int countSpecialNumbers(int n) { // n: [1, 2 * 10^9] 因为N超大，所以不能够一个一个数，必须与10的倍数为单位来数
            //   123 456 789 / 0
            // 1 023 456 789  N: [1, 1 987 654 320] 因为N超大，所以不能够一个一个数，必须与10的倍数为单位来数
            if (n < 10) return n;
            
        }
        int cntLessThan10(int v) {
            return v;
        }
        int cntLessThan100(int v) {
            return v;
        }

    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        String a = "IIIDIDDD"; // "12354 9876"
        
        String r = s.smallestNumber(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
