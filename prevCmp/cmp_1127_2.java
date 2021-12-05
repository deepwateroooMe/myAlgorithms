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

        public List<Integer> targetIndices(int[] a, int target) {
            Arrays.sort(a);
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < a.length; i++) 
                if (a[i] == target)
                    ans.add(i);
            return ans;
        }

        public int[] getAverages(int[] a, int k) {
            int n = a.length;
            long [] sum = new long [n];
            for (int i = 0; i < n; i++) 
                sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
            int [] ans = new int [n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < n; i++) {
                if (i-k < 0 || i+k >= n) continue;
                ans[i] = (int)((sum[i+k] - (i-k == 0 ? 0 : sum[i-k-1])) / (2l * k + 1l));
            }
            return ans;
        }

        public int minimumDeletions(int[] a) {
            int n = a.length, minIdx = -1, maxIdx = -1;
            ArrayDeque<Integer> min = new ArrayDeque<>(); // 单调递增
            ArrayDeque<Integer> max = new ArrayDeque<>(); // 单调递减
            for (int i = 0; i < n; i++) {
                while (!max.isEmpty() && a[max.peekLast()] <= a[i]) max.pollLast();
                max.offerLast(i);
                while (!min.isEmpty() && a[min.peekLast()] >= a[i]) min.pollLast();
                min.offerLast(i);
            }
            minIdx = min.peekFirst();
            maxIdx = max.peekFirst();
            return Math.min(Math.min(Math.max(minIdx+1, maxIdx+1), Math.max(n-minIdx, n-maxIdx)),
                            Math.min(minIdx+1+n-maxIdx, maxIdx+1+n-minIdx));
        }

        // class UnionFind {
        //     public int[] parent;
        //     public int[] size;
        //     public int[] root;
        //     public int n;
        //     public UnionFind(int n) {
        //         this.n = n;
        //         parent = new int[n];
        //         size = new int[n];
        //         root = new int[n];
        //         Arrays.fill(size, 1);
        //         for (int i = 0; i < n; i++) {
        //             parent[i] = i;
        //             root[i] = i;
        //         }
        //     }
        //     public int findset(int x) {
        //         return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        //     }
        //     public int getroot(int x) {
        //         return root[findset(x)];
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return findset(x) == findset(y);
        //     }
        //     public void unite(int x, int y) {
        //         root[y] = root[x];
        //         if (size[x] < size[y]) {
        //             int temp = x;
        //             x = y;
        //             y = temp;
        //         }
        //         parent[y] = x;
        //         size[x] += size[y];
        //     }
        //     public boolean findAndUnite(int x, int y) {
        //         int i = findset(x);
        //         int j = findset(y);
        //         if (i != j) {
        //             unite(i, j);
        //             return true;
        //         }
        //         return false;
        //     }
        // }
        // public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) { // 这个题像是考脱壳了，完全没有搞明白它在问什么、考什么,脑袋短路了
        //     Set<Integer> ans = new HashSet<>(); // 就现在的代码量和思路来看，不是很简单吗？可是比赛的时候就是读不懂题目，早上写这种题型写得。。。。。。倒背如流。。。。。。
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]); // [idx, time]
        //     q.offer(new int [] {0, 0});
        //     q.offer(new int [] {firstPerson, 0});
        //     Map<Integer, List<int []>> adj = new HashMap<>();
        //     for (int [] meet : meetings) {
        //         adj.computeIfAbsent(meet[0], z -> new ArrayList<>()).add(new int [] {meet[1], meet[2]});;
        //         adj.computeIfAbsent(meet[1], z -> new ArrayList<>()).add(new int [] {meet[0], meet[2]});;
        //     }
        //     while (!q.isEmpty()) {
        //         int [] p = q.poll();
        //         ans.add(p[0]);
        //         if (!adj.containsKey(p[0])) continue;
        //         List<int []> l = adj.get(p[0]);
        //         for (int [] m : l) {
        //             if (m[1] < p[1]) continue;
        //             q.offer(new int [] {m[0], m[1]});
        //         }
        //         adj.remove(p[0]); // tle without this line
        //     }
        //     return new ArrayList<>(ans);
        // }
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            ans.add(0);
            ans.add(firstPerson);
            Arrays.sort(meetings, Comparator.comparingInt(a -> a[2])); // sort by time
            for (int i = 0; i < meetings.length; ) {
                if (ans.size() == n) return new ArrayList<>(ans);
                HashMap<Integer, List<Integer>> map = new HashMap<>();
                int j = i;
                while (j < meetings.length && meetings[j][2] == meetings[i][2]) {
                    int[] m = meetings[j];
                    map.computeIfAbsent(m[0], z -> new ArrayList<>()).add(m[1]);
                    map.computeIfAbsent(m[1], z -> new ArrayList<>()).add(m[0]);
                    j++;
                }
                Set<Integer> tmp = new HashSet<>(map.keySet());
                tmp.retainAll(ans); // 
                for (Integer start : tmp) 
                    dfs(start, map);
                i = j;
            }
            return new ArrayList<>(ans);
        }
        Set<Integer> ans = new HashSet<>();
        private void dfs(Integer start, HashMap<Integer, List<Integer>> map) {
            List<Integer> path = map.get(start);
            for (Integer v : path) {
                if (ans.contains(v)) continue;
                ans.add(v);
                dfs(v, map);
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [][] a = new int [][] {{3,4,2},{1,2,1},{2,3,1}};
        int [][] a = new int [][] {{0,2,1},{1,3,1},{4,5,1}};

        List<Integer> r = s.findAllPeople(294, a, 27);

        // List<Integer> r = s.findAllPeople(294, a, 27);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
        
    }
}
// cmp s = new cmp (a);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
        
// TreeNode res = s.(root );
// res.levelPrintTree(res);
