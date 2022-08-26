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

        // public int minNumberOfHours(int oe, int op, int[] a, int[] e) {
        //     int ans = Arrays.stream(a).sum();
        //     if (ans >= oe) ans = ans + 1 - oe;
        //     else ans = 0;
        //     for (int i = 0; i < a.length; i++) 
        //         if (op <= e[i]) {
        //             ans += 1 + e[i] - op;
        //             op = 1 + e[i] + e[i];
        //         } else op += e[i];
        //     return ans;
        // }

        // public String largestPalindromic(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<int []> [] l = new ArrayList[10];
        //     for (int i = 0; i < 10; i++) 
        //         l[i] = new ArrayList<>();
        //     for (char c : s)
        //         if (l[c-'0'].size() == 0)
        //             l[c-'0'].add(new int [] {c-'0', 1});
        //         else l[c-'0'].get(0)[1]++;
        //     StringBuilder r = new StringBuilder();
        //     for (int i = 9; i >= 0; i--) {
        //         if (l[i].size() == 0) continue;
        //         int cur = l[i].get(0)[1];
        //         if (cur >= 2 && (i > 0 || r.length() > 0)) {
        //             r.append(((char)('0'+i) + "").repeat(cur / 2));
        //             l[i].get(0)[1] %= 2;
        //         }
        //     }
        //     String front = r.toString();
        //     for (int i = 9; i >= 0; i--) {
        //         if (l[i].size() == 0) continue;
        //         int cur = l[i].get(0)[1];
        //         if (cur == 1) {
        //             r.append((char)('0' + i));
        //             break;
        //         }
        //     }
        //     String ans = r.toString() + new StringBuilder(front).reverse().toString();
        //     return ans.equals("") ? "0" : ans;
        // }

        // 问题没有想透：当是叶子节点的时候，因为上层的分叉，会有很多复杂的情况
        // 把整个新树再遍历一遍，去找全局最大值
        // public int amountOfTime(TreeNode r, int v) {
        //     if (r == null) return 0;
        //     root = buildTree(r);
        //     updateDepth(root, v);
        //     if (v == r.val) return root.d-1;
        //     int ans = 0;
        //     System.out.println("rd: " + rd);
        //     System.out.println("root.d: " + root.d);

        //     if (r.left == null || r.right == null)
        //         travis(root);
        //     else {
        //         if (r.left != null && root.l.vis) 
        //             ans = Math.max(rd-1, (root.l.d - rd + 1  + (r.right == null ? 0 : root.r.d)));
        //         if (r.right != null && root.r.vis)
        //             ans = Math.max(rd-1, (root.r.d - rd + 1 + (r.left == null ? 0 : root.l.d)));
        //     }
            
        //     return Math.max(max, ans);
        // }
        // int rd = 0, max = 0;
        // TND root;
        // void travis(TND r) {
        //     if (r == null) return ;
        //     int cur = getMaxAsRoot(r);
        //     if (cur > max) max = cur;
        //     travis(r.l);
        //     travis(r.r);
        // }
        // int getMaxAsRoot(TND r) {
        //     int ans = 0;
        //     if (r.l != null && r.l.vis) 
        //         ans = Math.max(rd-1, r.d - rd + Math.max(root.d - r.d, r.r == null ? 0 : r.r.d));
        //     else if (r.r != null && r.r.vis)
        //         ans = Math.max(rd-1, r.d - rd + Math.max(root.d - r.d, r.l == null ? 0 : r.l.d));
        //     return ans;
        // }
        // int updateDepth(TND r, int val) {
        //     // if (r != null)
        //     //     System.out.println("\n r.n.val: " + r.n.val);
        //     if (r == null) return 0;
        //     if (r.l == null && r.r == null) {
        //         if (r.n.val == val) {
        //             rd = 1;
        //             r.vis = true;
        //         }
        //         r.d = 1;
        //         return 1;
        //     }
        //     int cntLeft = updateDepth(r.l, val);
        //     int cntRight = updateDepth(r.r, val);
        //     r.d = Math.max(cntLeft, cntRight) + 1;
        //     // System.out.println("r.d: " + r.d);
        //     if (r.l != null && r.l.vis || r.r != null && r.r.vis) r.vis = true;
        //     if (r.n.val == val) {
        //         rd = r.d;
        //         r.vis = true;
        //     }
        //     return r.d;
        // }
        // TND buildTree(TreeNode r) {
        //     if (r == null) return null;
        //     TND s = new TND(r);
        //     s.l = buildTree(r.left);
        //     s.r = buildTree(r.right);
        //     return s;
        // }
        // class TND {
        //     TreeNode n;
        //     int d;
        //     boolean vis; // mark 是否在子树中
        //     TND l, r;
        //     public TND(TreeNode n) {
        //         this.n = n;
        //     }
        //     public TND(TreeNode n, int d) {
        //         this.n = n;
        //         this.d =d;
        //     }
        // }

        // public int maxDepth(TreeNode r) { //  这里用了两个方法来写，合成一个 
        //     cntDepth(r, 1);
        //     return d;
        // }
        // int d = 0;
        // void cntDepth(TreeNode r, int v) {
        //     if (r == null) return;
        //     if (r.left == null && r.right == null) {
        //         if (v > d) d = v;
        //         return ;
        //     }
        //     cntDepth(r.left, v + 1);
        //     cntDepth(r.right, v + 1);
        // }

// // DFS: 深度优先遍历        
//         public int maxDepth(TreeNode r) {
//             if (r == null) return 0;
// // 下面这个CASE: 仔细想也是被上面的包括的，所以可以不用
//             if (r.left == null && r.right == null) return 1; // 这句可以不用要
//             int left = maxDepth(r.left);
//             int right = maxDepth(r.right);
// // 下面这一行包括上面那一句，所以上面那一句可以不用
//             return Math.max(left, right) + 1; 
//         }
// // 广度优先遍历
//         public int maxDepth(TreeNode r) {
//             if (r == null) return 0;
//             int cnt = 0;
//             Deque<TreeNode> q = new ArrayDeque<>();
//             q.offerFirst(r);
//             while (!q.isEmpty()) {
//                 int qsize = q.size();
//                 for (int size = qsize-1; size >= 0; size--) {
//                     TreeNode cur = q.pollLast();
//                     if (cur.left != null) q.offerFirst(cur.left);
//                     if (cur.right != null) q.offerFirst(cur.right);
//                 }
//                 cnt++;
//             }
//             return cnt;
//         }

        // public int diameterOfBinaryTree(TreeNode r) {
        //     traverse(r);
        //     return max;
        // }
        // int max = 0;
        // int traverse(TreeNode r) {
        //     if (r == null) return 0; // 叶子节点会是1，成了数节点个数
        //     int left = traverse(r.left);
        //     int right = traverse(r.right);
        //     max = Math.max(max, left + right);
        //     return Math.max(left, right) + 1;
        // }

// // 用数组下标比用图相对省事一点儿，但是数据不连续，还是应该用图        
//         int N = 100001;
//         public int amountOfTime(TreeNode root, int start) {
//             adj = new ArrayList [N];
//             buildGraph(root, null);
//             return traverse(start);
//         }
//         List<Integer> [] adj;
// // BFS 遍历无向图，寻找最长手臂长度        
        // int traverse(int u) {
        //     if (adj[u] == null) return 0;
        //     int cnt = -1;
        //     Deque<Integer> q = new ArrayDeque<>();
        //     boolean [] vis = new boolean [N];
        //     q.offerFirst(u);
        //     vis[u] = true;
        //     while (!q.isEmpty()) {
        //         int qsize = q.size();
        //         for (int i = qsize-1; i >= 0; i--) {
        //             int cur = q.pollLast();
        //             vis[cur] = true;
        //             if (adj[cur] == null || adj[cur].size() == 1 && vis[adj[cur].get(0)]) continue;
        //             for (int v : adj[cur]) {
        //                 if (vis[v]) continue;
        //                 q.offerFirst(v);
        //             }
        //         }
        //         cnt++;
        //     }
        //     return cnt;
        // }
//         void buildGraph(TreeNode r, TreeNode p) {
//             if (r == null) return ;
//             if (adj[r.val] == null) adj[r.val] = new ArrayList<>();
//             if (p != null) adj[r.val].add(p.val); // to parent
//             if (r.left != null) adj[r.val].add(r.left.val);
//             if (r.right != null) adj[r.val].add(r.right.val);
//             buildGraph(r.left, r);
//             buildGraph(r.right, r);
//         }

// BFS:         
//         public int amountOfTime(TreeNode r, int start) {
//             buildGraph(r, null);
//             return maxDistance(new ArrayDeque<>(List.of(r.val)),
//                                new HashSet<>(Set.of(start)));
//         }
//         Map<Integer, List<Integer>> m = new HashMap<>();
//         int maxDistance(Deque<Integer> q, HashSet<Integer> vis) {
//             int cnt = 0;
//             while (!q.isEmpty()) {
//                 int size = q.size();
//                 while (size-- > 0) {
//                     int u = q.pollLast();
//                     vis.add(u);
//                     if (m.get(u) == null) continue;
//                     for (int v : m.get(u)) {
//                         if (vis.contains(v)) continue;
//                         q.offerFirst(v);
//                     }
//                 }
//                 cnt++;
//             }
//             return cnt-1;
//         }
// // DFS:        
//         public int amountOfTime(TreeNode r, int start) {
//             buildGraph(r, null);
//             maxDistance(new HashSet<>(), start, 0);
//             return max;
//         }
//         Map<Integer, List<Integer>> m = new HashMap<>();
//         int max = 0;
//         void maxDistance(Set<Integer> vis, int u, int d) {
//             if (vis.contains(u)) return ;
//             vis.add(u);
//             max = Math.max(max, d);
//             for (int v : m.get(u))
//                 maxDistance(vis, v, d+1);
//         }
//         void buildGraph(TreeNode r, TreeNode p) { // 我还是比较喜欢自己这种相对简洁的方法
//             if (r == null) return ;
// // 这里是，从当前节点，加父节点，加左右两个子节点；简洁，但是需要父节点作为参数            
//             m.computeIfAbsent(r.val, z -> new ArrayList<>());
//             if (p != null) m.get(r.val).add(p.val);
//             if (r.left != null) m.get(r.val).add(r.left.val);
//             if (r.right != null) m.get(r.val).add(r.right.val);
//             buildGraph(r.left, r);
//             buildGraph(r.right, r);
//         }
//         void buildGraph(TreeNode r) {
//             if (r == null) return ;
//             m.computeIfAbsent(r.val, z -> new ArrayList<>());
// // 从左右两个确定存在的子节点，加父节点
//             if (r.left != null) {
//                 m.computeIfAbsent(r.left.val, z -> new ArrayList<>()).add(r.val);
//                 m.get(r.val).add(r.left.val); // 从当前节点，加左右两个子节点；
//                 buildGraph(r.left);
//             }
//             if (r.right != null) {
//                 m.computeIfAbsent(r.right.val, z -> new ArrayList<>()).add(r.val);
//                 m.get(r.val).add(r.right.val); // 从当前节点，加左右两个子节点；
//                 buildGraph(r.right);
//             }
//         }

//         public String shiftingLetters(String t, int[][] a) { // TLE TLE TLE
//             int n = t.length(), m = a.length;
//             char [] s = t.toCharArray();
//             int [] dif = new int [n+1];
//             for (int i = 0; i < m; i++) {
//                 if (a[i][2] == 1) {
//                     dif[a[i][0]] += 1;
//                     dif[a[i][1]+1] -= 1;
//                 } else {
//                     dif[a[i][0]] -= 1;
//                     dif[a[i][1]+1] += 1;
//                 }
// // 这里不能真的这么一个一个地来，使用差分数组                
//                 // for (int j = a[i][0]; j <= a[i][1]; j++) {
//                 //     if (a[i][2] == 1) dif[j]++;
//                 //     else dif[j]--;
//                 // }
//             }
// // change dif [] to be sum []
//             for (int i = 1; i < n; i++) 
//                 dif[i] += dif[i-1];
//             for (int i = 0; i < n; i++) 
//                 s[i] = (char)('a' + (s[i]-'a' + 26 + dif[i] % 26) % 26);
//             return new String(s);
//         }

// // 这么想起来，整个思路还是很清晰的        
//         public long[] maximumSegmentSum(int[] a, int[] qr) {
//             int n = a.length;
//             Queue<long []> q = new PriorityQueue<>((x, y) -> x[2] <= y[2] ? 1 : -1); // 转化成int值
//             TreeSet<Integer> s = new TreeSet<>();
//             long [] sum = new long [n], ans = new long [n];
//             s.add(-1); // qr[i] in range [0, n)
//             s.add(n);
//             for (int i = 0; i < n; i++) {
//                 sum[i] = a[i];
//                 if (i > 0) sum[i] += sum[i-1];
//             }
//             q.offer(new long [] {0, n-1, sum[n-1]}); // [ bgn, end ], sum of segment
//             for (int i = 0; i < n; i++) {
//                 int v = qr[i];
//                 s.add(v);
// // 先添加可能会产生的分割点左右的两个新片段；再从QUEUE里移除含有当前分割点的一个片段，或是直接读最大有效值                
//                 // l, r: left, right, 比当前分割点小的最大值，和比当前分割点大的最小值
//                 int l = s.lower(v), r = s.higher(v); 
//                 if (l + 1 < v) // 比当前分割点小的可以产生段新的片段
//                     q.offer(new long [] {(long)l + 1, (long)v - 1, sum[v-1] - (long)(l == -1 ? 0 : sum[l])}); // - sum[l]
//                 if (v + 1 < r) // 比当前分割点大的也可以产生一段新的片段
//                     q.offer(new long [] {(long)v+1, (long)r-1, sum[r-1] - sum[v]}); // - sum[v]
//                 while (!q.isEmpty()) {
//                     long [] cur = q.peek();
//                     int bgn = (int)cur[0], end = (int)cur[1];
//                     // 根据当前片段的两个端点值来确认：当前片段是有效片段，取第一个有效片段读值
//                     if (s.higher(bgn-1) > end) {
//                         ans[i] = q.peek()[2];
//                         break;
//                     } else q.poll(); // 如果是无效片段，就把它扔掉
//                 }
//             }
//             return ans;
//         }
        // public long[] maximumSegmentSum(int[] a, int[] q) {
        //     int n = a.length;
        //     long [] sum = new long [n+1], ans = new long [n];
        //     for (int i = 0; i < n; i++) // calc preSum
        //         sum[i+1] = sum[i] + a[i];
        //     TreeMap<int [], Long> m = new TreeMap<>((x, y)->x[0] - y[0]); // 这里定义了一个相对独特的比较方式  ranges
        //     // TreeMap to store all the possible sums of range we encounter while solving queries, we are storing frequencies because 
        //     // multiple range can have same sum.            
        //     TreeMap<Long, Integer> sums = new TreeMap<>(); 
        //     m.put(new int [] {0, n-1}, sum[n]);
        //     sums.put(sum[n], 1);
        //     for (int i = 0; i < n; i++) {
        //         int v = q[i];
        //         // finding range which will split when node index is removed or set 0.                
        //         int [] rangeToBeRemoved = m.floorKey(new int [] {v}); // 所以数组的长短都没有关系
        //         Long sumv =m.get(rangeToBeRemoved);
        //         // removing/ reducing sum from sums Map because we are splitting that range, so it is no longer valid
        //         int freq = sums.get(sumv);
        //         if (freq == 1) sums.remove(sumv);
        //         else sums.put(sumv, freq-1);
        //         m.remove(rangeToBeRemoved); // removing that range
        //         int l = rangeToBeRemoved[0], r = rangeToBeRemoved[1];
        //         long curSum = 0;
        //         // Splitting range and store back new ranges form along with its sum.
        //         if (l == v && r != v) { // 更新当前分割点右边的片段
        //             curSum = sum[r+1] - sum[v+1];
        //             m.put(new int [] {v+1, r}, curSum);
        //             sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        //         } else if (l != v && r == v) { // 更新当前分割点左边的片段
        //             curSum = sum[v] - sum[l];
        //             m.put(new int [] {l, v-1}, curSum);
        //             sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        //         } else if (l < v && r > v) {
        //             // 左边
        //             curSum = sum[v] - sum[l];
        //             m.put(new int [] {l, v-1}, curSum);
        //             sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        //             // 右边
        //             curSum = sum[r+1] - sum[v+1];
        //             m.put(new int [] {v+1, r}, curSum);
        //             sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        //         }
        //         if (sums.size() !=  0)
        //             ans[i] = sums.lastKey();
        //     }
        //     return ans;
        // }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [] a = new int []  {1, 2, 5, 6, 1};
        int [] b = new int [] {0,3,2,4,1};

        long [] r = s.maximumSegmentSum(a, b);
        System.out.println(Arrays.toString(r));
    }
}

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

