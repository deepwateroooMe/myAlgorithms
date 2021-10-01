// import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class grathreeph {
    public static class Solution {
        // HashMap<Integer, Integer> m = new HashMap<>();
        // public int minSwapsCouples(int[] row) {
        //     int n = row.length;
        //     for (int i = 1; i < n/2 + 1; i++) {
        //         m.put(2*i-2, 2*i-1);
        //         m.put(2*i-1, 2*i-2);
        //     }
        //     int cnt = 0, tmp = 0;
        //     for (int i = 1; i < n; i += 2) {
        //         if (m.get(row[i-1]) != row[i]) {
        //             for (int j = 0; j < row.length; j++) {
        //                 if (row[j] == m.get(row[i-1])) {
        //                     tmp = row[i];
        //                     row[i] = row[j];
        //                     row[j] = tmp;
        //                     break;
        //                 }
        //             }
        //             ++cnt;
        //         }
        //     }
        //     return cnt;
        // }

        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) {
        //             pare[i] = i;
        //         }
        //         Arrays.fill(rank, 0);
        //     }
        //     public int find(int val) {
        //         while (val != pare[val]) {
        //             pare[val] = pare[pare[val]];
        //             val = pare[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) {
        //             swap(rp, rq);
        //         }
        //         pare[rq] = rp;
        //         rank[rp] += rank[rq];
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        // }
        // public class Node {
        //     int val;
        //     int x;
        //     int y;
        //     Node() {}
        //     Node(int x, int y, int val) {
        //         this.x = x;
        //         this.y = y;
        //         this.val = val;
        //     }
        // }
        // Comparator<Node> compare = new Comparator<Node>() {
        //     @Override public int compare(Node a, Node b) {
        //         return a.val - b.val;
        //     }
        // };
        // int [][] rowRank;
        // int [][] colRank;
        // int [][] arr;
        // int [] f;
        // int [] v;
        // int [] row;
        // int [] col;
        // int [][] tag;
        // int m, n;
        // Node[] a;
        // Node[] b;
        // Node [] c;
        // int find(int x) {
        //     if (f[x] != x)
        //         f[x] = find(f[x]);
        //     return f[x];
        // }
        // void merge(int x, int y) {
        //     int fx = find(x);
        //     int fy = find(y);
        //     f[fy] = fx;
        // }
        // public int[][] matrixRankTransform(int[][] matrix) {
        //     m = matrix.length; // 这些个变量、结构组织等太琐碎了，改天再重新写一遍
        //     n = matrix[0].length;
        //     rowRank = new int[m][n];
        //     colRank = new int[m][n];
        //     arr = new int[m][n];
        //     f = new int[m*n];
        //     v = new int[m*n];
        //     row = new int[m];
        //     col = new int[n];
        //     tag = new int[m][n];
        //     a = new Node[n*m];
        //     b = new Node[n]; // 
        //     c = new Node[m]; // 
            
        //     int p = 0, pp = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             a[p++] = new Node(i, j, matrix[i][j]);
        //     Arrays.sort(a, compare);
        //     for (int i = 0; i < p; i++) {
        //         tag[a[i].x][a[i].y] = i; // 新的rank数组
        //         f[i] = i;
        //     }
        //     for (int i = 0; i < m; i++) { // 遍历行
        //         pp = 0;
        //         for (int j = 0; j < n; j++) // 遍历列
        //             b[pp++] = new Node(i, j, matrix[i][j]);
        //         Arrays.sort(b, compare);
        //         for (int j = 1; j < pp; j++) {
        //             if (b[j].val != b[j-1].val) continue;
        //             else {
        //                 int rx = find(tag[i][b[j-1].y]);
        //                 int ry = find(tag[i][b[j].y]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     for (int i = 0; i < n; i++) { // 列
        //         pp = 0;
        //         for (int j = 0; j < m; j++) // 行
        //             c[pp++] = new Node(j, i, matrix[j][i]);
        //         Arrays.sort(c, compare);
        //         for (int j = 1; j < pp; j++) {
        //             if (c[j].val != c[j-1].val) continue;
        //             else {
        //                 int rx = find(tag[c[j-1].x][i]);
        //                 int ry = find(tag[c[j].x][i]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     int bgn = 0;
        //     for (int i = 0; i < p; i++) {
        //         int rank = Math.max(row[a[i].x], col[a[i].y])+1;
        //         int ff = find(i);
        //         if (v[ff] < rank) v[ff] = rank;
        //         if (i == p-1 || a[i+1].val != a[i].val) {
        //             for (int j = bgn; j <= i; j++) {
        //                 int xx = v[find(j)];
        //                 rowRank[a[j].x][a[j].y] = xx;
        //                 row[a[j].x] = xx;
        //                 col[a[j].y] = xx;
        //             }
        //             bgn = i+1;
        //         }
        //     }
        //     int [][] arr = new int [m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             arr[i][j] = rowRank[i][j];
        //     return arr;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{7,3,6},{1,4,5},{9,8,2}};

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }
        
        int [][] es = s.matrixRankTransform(a);
        System.out.println("es.length: " + es.length);
        for (int z = 0; z < es.length; ++z) {
            for (int w = 0; w < es[z].length; w++) 
                System.out.print(es[z][w] + ", ");
            System.out.print("\n");
        }
        
    }
}
