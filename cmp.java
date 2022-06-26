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

        // public boolean checkXMatrix(int[][] a) {
        //     int n = a.length;
        //     boolean ans = true;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if ((i == j || i+j == n-1) && a[i][j] == 0) return false;
        //             else if (i != j && i+j != n-1 && a[i][j] != 0) return false;
        //         }
        //     return true;
        // }

        // static final int mod = (int)1e9 + 7;
        // public int countHousePlacements(int n) {
        //     long a = 1, b = 2;
        //     for (int i = 2; i <= n; i++) {
        //         long c = (a + b) % mod;
        //         a = b;
        //         b = c;
        //     }
        //     return (int)((b * b) % mod);
        // }

        public int maximumsSplicedArray(int[] a, int[] b) { 
            int n = a.length, max = 0;
            int [] sa = Arrays.copyOf(a, n);
            int [] sb = Arrays.copyOf(b, n);
            for (int i = 1; i < n; i++) {
                sa[i] = sa[i-1] + a[i];
                sb[i] = sb[i-1] + b[i];
            }
            max = Math.max(sa[n-1], sb[n-1]);
        }

        public abstract int minimumScore(int[] nums, int[][] edges) {
            return 0;
        }

    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int [][] a = new int [][] {{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}};

        int r = s.countHousePlacements(2);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
