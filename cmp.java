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
        
        // public static List<Integer> minimalHeaviestSetA(List<Integer> a) { // N: [1, 10^5] 降序排列
        //     int n = a.size();
        //     // Collections.sort(a, (x, y) -> y - x);
        //     Collections.sort(a); // 升序排列
        //     long [] s = new long [n];
        //     long t = s[n-1], cur = 0l;
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + a.get(i);
        //     for (int i = n-1; i > 0; i--) {
        //         cur = t - s[i-1];
        //         if (cur > s[i-1])
        //             return a.subList(i, n);
        //     }
        //     return new ArrayList<>();
        // }
        
        // public static int countGroups(List<String> a) {
        //     int m = a.size(), n = a.get(0).length();
        //     char [][] arr = new char [m][n];
        //     for (int i = 0; i < m; i++) 
        //         arr[i] = a.get(i).toCharArray();
        //     DSU uf = new DSU(n);
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < i; j++) {
        //             if (arr[i][j] == 1 && !uf.areConnected(i, j))
        //                 uf.union(i, j);
        //         }
        //     return uf.getCnt();
        // }
        // private static class DSU {
        //     private int N;
        //     private int [] parent, rank;
        //     public DSU( int n) {
        //         this.N = n;
        //         this.parent = new int [N];
        //         this.rank = new int [N];
        //         for (int i = 0; i < N; i++) {
        //             this.parent[i] = i;
        //             this.rank[i] = 1;
        //         }
        //     }
        //     public int getCnt() {
        //         Set<Integer> s = new HashSet<>();
        //         for (int i = 0; i < N; i++) {
        //             find(i);
        //             if (!s.contains(parent[i])) s.add(parent[i]);
        //         }
        //         return s.size();
        //     }
        //     public boolean areConnected(int u, int v) {
        //         return find(u) == find(v);
        //     }
        //     public void union(int u, int v) { // O(Log(N))
        //         if (u != v) {
        //             int p = find(u);
        //             int q = find(v);
        //                 if (p != q) {
        //                     if (rank[p] > rank[q]) {
        //                         parent[q] = p;
        //                         rank[p] += rank[q];
        //                     } else {
        //                         parent[p] = q;
        //                         rank[q] += rank[p];
        //                     }
        //                 }
        //         }
        //     }
        //     private int find(int v) {
        //         int x = v;
        //         while (x != parent[x])
        //             x = parent[x];
        //         parent[v] = x;
        //         return x;
        //     }
        // }

        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int r = s.wordCount(a, b);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // ListNode r = s.deleteMiddle(head);
 // r.printList(r);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
        
 // String r = s.getDirections(root, 2, 1);
 // System.out.println("r: " + r);

