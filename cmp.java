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

        // public int[] answerQueries(int[] a, int[] q) {
        //     int n = a.length, m = q.length;
        //     Arrays.sort(a);
        //     int [] sum = new int [n], ans = new int [m];
        //     TreeMap<Integer, Integer> mi = new TreeMap<>();
        //     sum[0] = a[0];
        //     mi.put(sum[0], 1);
        //     for (int i = 1; i < n; i++) {
        //         sum[i] = sum[i-1] + a[i];
        //         mi.put(sum[i], i+1);
        //     }
        //     for (int i = 0; i < m; i++) {
        //         int v = q[i];
        //         Integer k = mi.floorKey(v);
        //         if (k != null) ans[i] = mi.get(k);
        //         else ans[i] = 0;
        //     }
        //     return ans;
        // }

        // public String removeStars(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Deque<Character> st = new ArrayDeque<>();
        //     for (var c : s) {
        //         if (c != '*') { // 从尾巴上加，也要从尾巴上抛
        //             st.offerLast(c);
        //             continue;
        //         }
        //         if (!st.isEmpty()) 
        //             st.pollLast();
        //         continue;
        //     }
        //     StringBuilder r = new StringBuilder();
        //     while (!st.isEmpty()) 
        //         r.append(st.pollFirst());
        //     return r.toString();
        // }

        // public int garbageCollection(String[] a, int[] t) {
        //     int n = a.length, m = t.length;
        //     int [][] cnt = new int [3][n]; // M P G
        //     int [] sum = new int [n];
        //     for (int i = 1; i < n; i++) // 累积时间
        //         sum[i] = t[i-1] + sum[i-1];
        //     int r = 0;
        //     for (int i = 0; i < n; i++) {
        //         r += a[i].length();
        //         for (var c : a[i].toCharArray()) {
        //             if (c == 'M') cnt[0][i]++;
        //             else if (c == 'P') cnt[1][i]++;
        //             else cnt[2][i]++;
        //         }
        //     }
        //     for (int i = 0; i < 3; i++)
        //         for (int j = n-1; j >= 0; j--) {
        //             if (cnt[i][j] > 0) {
        //                 r += sum[j];
        //                 break;
        //             }
        //         }
        //     return r;
        // }

        // public int [] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //     // 组间组内信赖图
        //     List<List<Integer>> groupItem = new ArrayList<>();
        //     List<List<Integer>> groupGraph = new ArrayList<>();
        //     List<Integer> id = new ArrayList<>();        // m+n .....
        //     for (int i = 0; i < m+n; i++) {
        //         id.add(i);
        //         groupItem.add(new ArrayList<Integer>()); // m+n
        //         groupGraph.add(new ArrayList<Integer>());// m+n
        //     }
        //     List<List<Integer>> itemGraph = new ArrayList<>();
        //     for (int i = 0; i < n; i++)                // n items only
        //         itemGraph.add(new ArrayList<Integer>());
        //     int [] insGroup = new int[n+m];     // 组间组内依敕入度级数
        //     int [] insItem = new int[n];
        //     int leftoverId = m;                 // reassign -1 groupped items to be groupped from [m, m+1, m+n)
        //     for (int i = 0; i < n; i++) {
        //         if (group[i] == -1)
        //             group[i] = leftoverId++;    // update group[] data
        //         groupItem.get(group[i]).add(i); // leftoverId i befores to new assigned group[i]
        //     }
        //     for (int i = 0; i < n; i++) {
        //         int curGroupId = group[i];
        //         for (int item : beforeItems.get(i)) {
        //             int befGroupId = group[item];   // ids bef item i belong to which group ?
        //             if (befGroupId == curGroupId) { // 属于同一个组，进行组内排序
        //                 insItem[i] ++;
        //                 itemGraph.get(item).add(i);
        //             } else { // 不属于同一个组：构建组间依赖关系
        //                 if (groupGraph.get(curGroupId).contains(befGroupId)) return new int [0]; // 4 1  {-1, 0, 0, -1}; {{},{0},{1,3},{2}};
        //                 insGroup[curGroupId]++;
        //                 groupGraph.get(befGroupId).add(curGroupId); // group befGroupId goes before group curGroupId
        //             }
        //         }
        //     }
        //     List<Integer> groupTopSort = topSort(insGroup, groupGraph, id);
        //     if (groupTopSort.size() == 0) return new int [0];
        //     int [] ans = new int[n];
        //     int idx = 0;
        //     for (int curGroupId : groupTopSort) {
        //         int size = groupItem.get(curGroupId).size();
        //         if (size == 0) continue;
        //         List<Integer> res = topSort(insItem, itemGraph, groupItem.get(curGroupId));
        //         if (res.size() == 0) return new int [0];
        //         for (int item : res) {
        //             ans[idx++] = item;
        //         }
        //     }
        //     return ans;
        // }
        public int[][] buildMatrix(int k, int[][] row, int[][] col) {
            int m = row.length, n = col.length;
            int [] r = new int [k+1], c = new int [k+1]; // ins
            List<Integer> [] rg = new ArrayList [k+1], cg = new ArrayList [k+1];
            Arrays.setAll(rg, z -> new ArrayList<>()); 
            Arrays.setAll(cg, z -> new ArrayList<>());
            Set<Integer> ri = new HashSet<>();
            Set<Integer> ci = new HashSet<>();
            for (var a : row) {
                int u = a[0], v = a[1];
                r[v]++;
                rg[u].add(v);
                ri.add(u);
                ri.add(v);
            }
            for (var a : col) {
                int u = a[0], v = a[1];
                c[v]++;
                cg[u].add(v);
                ci.add(u);
                ci.add(v);
            }
            List<Integer> rr = topologicalSort(r, rg, ri); // 排得不准，只列出了一种情况，不是所有情况
            List<Integer> cc = topologicalSort(c, cg, ci);
            // System.out.println("rr.size(): " + rr.size());
            // System.out.println(Arrays.toString(rr.toArray()));
            // System.out.println("cc.size(): " + cc.size());
            // System.out.println(Arrays.toString(cc.toArray()));
            int [][] ans = new int [k][k];
// 接下来应该是用gready算法一个一个往里面塞，可是感觉还是没想透，暂时不做了
            return ans;
        }
        List<Integer> topologicalSort(int [] ins, List<Integer> [] g, Set<Integer> vals) {
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (var v : vals) 
                if (ins[v] == 0) q.offerLast(v);
            List<Integer> r = new ArrayList<>();
            while (!q.isEmpty()) {
                int cur = q.pollFirst();
                r.add(cur);
                for (var v : g[cur]) 
                    if (--ins[v] == 0) q.offerLast(v);
            }
            return r;
        }
        

    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2},{3,2}};
        int [][] b = new int [][] {{2,1},{3,2}};
        
        int [][] r = s.buildMatrix(3, a, b);

        System.out.println("r.length: " + r.length);
        for (int z = 0; z < r.length; ++z) 
            System.out.println(Arrays.toString(r[z]));    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
