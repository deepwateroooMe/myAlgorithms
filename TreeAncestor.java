import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class TreeAncestor {

// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/binary-lifting-dong-tai-gui-hua-dpjie-fa-zhi-xu-ya/
// https://blog.csdn.net/u013325815/article/details/106744635

    HashMap<Integer, List<Integer>> graph;
    int [][] father;
    public TreeAncestor(int n, int[] parent) {
        // binary lifting: father[i][j]表示：第i点node的往上的2^j的祖先是谁 (20 = 1 21 = 2 22 = 4 23 = 8)
        this.father = new int [n][30];
        this.graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(father[i], -1);
            graph.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                graph.get(parent[i]).add(i);
                father[i][0] = parent[i]; // node i's first (j == 0 20 = 1) parent
            }
        }
        dfs(0);
    }
    private void dfs(int cur) {
        for (int i = 1; father[cur][i-1] >= 0; i++) // from 2^1 grandparent going upwards
            father[cur][i] = father[father[cur][i-1]][i-1];
        for (int next : graph.get(cur)) 
            dfs(next);
    }
    public int getKthAncestor(int node, int k) {
        for (int i = 0; k > 0; i++, k >>= 1) {
            if ((k & 1) == 1) {
                node = father[node][i];
                if (node < 0) return -1;
            }
        }
        return node;
    }
    // int [] pare;  // 这里面还有bug, 改天再回来改这个
    // int [] heit;
    // int n;
    // public TreeAncestor(int n, int[] parent) {
    //     this.n = n;
    //     this.pare = parent;
    //     this.heit = new int[n];
    //     for (int i = 0; i < n; i++) 
    //         findHeight(i);
    // }
    // private int findHeight(int v) {
    //     if (v == 0 || heit[v] != 0) return heit[v];
    //     heit[v] = heit[pare[v]] + 1;
    //     return heit[v];
    // }
    // public int getKthAncestor(int node, int k) {
    //     if (heit[node] < k) return -1;
    //     int res = node;
    //     while (k > 0) {
    //         res = pare[res];
    //         k--;
    //     }
    //     return res;
    // }
// ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
// [[4,[-1,2,3,0]],[2,3],[2,2],[2,1]]
    
    public static void main(String[] args) {

        // int [] a = new int []  {-1,  0,  0,  1,  1,  2,  2}; 
        // int [] a = new int [] {1, 3, 5, -1, 2, 3, 5, 2, 1}; 
        int [] a = new int [] {-1, 2, 3, 0};

        TreeAncestor s = new TreeAncestor(4, a);

        int r = s.getKthAncestor(2, 2); // 5, 2; 6, 3
        System.out.println("r: " + r);
    }
}

