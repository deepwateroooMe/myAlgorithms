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

        // public String greatestLetter(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [][] cnt = new int [2][26]; // 0:lower; 1: upper
        //     for (char c : s) {
        //         if (Character.isUpperCase(c)) cnt[1][c-'A']++;
        //         else cnt[0][c-'a']++;
        //     }
        //     for (int i = 25; i >= 0; i--) 
        //         if (cnt[0][i] > 0 && cnt[1][i] > 0) return (char)('A' + i) + "";
        //     return "";
        // }

// 这里我是想明白了每个数位上只要出现过的，都可以构成有效结果的那一位；可是方便不是最简便的
        // 此题重点在于上下左右边界的移动。
        // 先从左至右，填充完之后，上边界下移
        // 再从上至下，填充完之后，右边界左移
        // 再从右至左，填充完之后，下边界上移
        // 再从下至上，填充完之后，左边界右移
        // 最后注意三种特殊情况的边界判定：
        // m = 1 时，只有横向左至右移动，注意不要让他死循环
        //     n = 1 时，只有纵向上至下移动
        //     m = 1 且 n = 1 时
        // public int maximumXOR(int[] a) {
        //     int [] cnt = new int [27];
        //     for (int v : a) {
        //         String t = Integer.toBinaryString(v);
        //         char [] s = t.toCharArray();
        //         int n = s.length;
        //         for (int i = n-1; i >= 0; i--) 
        //             if (s[i] == '1') cnt[n-1-i] |= 1;
        //     }
        //     int [] p = new int [27];
        //     p[0] = 1;
        //     for (int i = 1; i < 27; i++) 
        //         p[i] = 2 * p[i-1];
        //     int ans = 0;
        //     for (int i = 0; i < 27; i++) 
        //         if (cnt[i] == 1) ans += p[i];
        //     return ans;
        // }
// 不需要每一位上都去异或，只要异或这些数就可以了        
        // public int maximumXOR(int[] a) {
        //     int ans = 0;
        //     for (int v : a) ans |= v;
        //     return ans;
        // }

        // public String decodeMessage(String k, String t) {
        //     Map<Character, Character> m = new HashMap<>();
        //     Set<Character> s = new HashSet<>();
        //     int idx = 0;
        //     m.put(' ', ' ');
        //     s.add(' ');
        //     for (char c : k.toCharArray()) {
        //         if (s.contains(c)) continue;
        //         m.put(c, (char)('a'+idx));
        //         s.add(c);
        //         idx++;
        //     }
        //     StringBuilder r = new StringBuilder();
        //     for (char c : t.toCharArray()) 
        //         r.append(m.get(c));
        //     return r.toString();
        // }

// // 矩阵每格的遍历顺序旋转方向：你看别人写，也是这么一步一步一行一列地转回来的，还是要不怕困难地去老老实实地写。。。。。
//         public int[][] spiralMatrix(int m, int n, ListNode h) {
//             int [][] ans = new int [m][n]; // 1. 创建新数组，默认全部填充 -1
//             for (int i = 0; i < m; i++) 
//                 Arrays.fill(ans[i], -1);
//             // 2. 定义边界 left top right bottom
//             int l = 0, t = 0, r = n-1, b = m-1; 
//             // 3. 遍历链表，填充数据(结束条件: 左边界大于右边界 或者上边界大于下边界)
//             while (!(r < l || b < t)) {
//                 // 3.1 → 向右移动, 遍历一行
//                 if (l <= r && t <= b) {
//                     // 如果top大于bottom，则说明最后一个横行已经填充完成，结束，如果不结束会又反着 ← 回来
//                     for (int i = l; i <= r; i++) {
//                         if (h == null) return ans;
//                         ans[t][i] = h.val;
//                         h = h.next;
//                     }
//                     t++; // 上边界下移
//                 }
//                 // 3.2 ↓ 向下移动，遍历一列
//                 if (t <= b && l <= r) {
//                     for (int i = t; i <= b; i++) {
//                         if (h == null) return ans;
//                         ans[i][r] = h.val;
//                         h = h.next;
//                     }
//                     r--; // 右边界左移
//                 }
//                 // 3.3 ← 向左移动，遍历一行
//                 if (t <= b && l <= r) {
//                     for (int i = r; i >= l; i--) {
//                         if (h == null) return ans;
//                         ans[b][i] = h.val;
//                         h = h.next;
//                     }
//                     b--; // 下边界上移
//                 }
//                 // 3.4 ↑ 向上移动，遍历一列
//                 if (t <= b && l <= r) {
//                     for (int i = b; i >= t; i--) {
//                         if (h == null) return ans;
//                         ans[i][l] = h.val;
//                         h = h.next;
//                     }
//                     l++; // 左边界右移
//                 }
//             }
//             return ans;
//         }

        // public int countPaths(int[][] a) {
        //     m = a.length;
        //     n = a[0].length;
        //     dp = new Integer [m][n];
        //     long r = 0l;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             dfsWithMemorization(i, j, a);
        //             r = (r + dp[i][j]) % mod;
        //         }
        //     return (int)r;
        // }
        // static final int mod = (int)1e9 + 7;
        // Integer [][] dp;
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // int dfsWithMemorization(int i, int j, int [][] a) {
        //     if (dp[i][j] != null) return dp[i][j];
        //     long r = 1l;
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= m || y < 0 || y >= n || a[i][j] >= a[x][y]) continue;
        //         r = (r + dfsWithMemorization(x, y, a)) % mod;
        //     }
        //     return dp[i][j] = (int) r;
        // }

        // "_L__R__R_"
        // "L______RR"
        //  public boolean canChange(String ss, String ee) { // 不喜欢这个题目，改天再回来写
        //     int n = ss.length(), j = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = ee.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (j == n) {
        //             while (i < n && s[i] == '_') i++;
        //             return i == n;
        //         }
        //         if (s[i] == t[j]) { // 同时移动
        //             j++;
        //             continue;
        //         }
        //         if (s[i] == '_' && t[j] != '_') continue; // 只移动 i
        //         if (s[i] == 'R' && t[j] == '_') { // 只移动j
        //             while (j < n && t[j] == '_') j++;
        //             if (j == n || s[i] != t[j]) return false;
        //             j++;
        //         }
        //         // return false;
        //     }
        //     return true;
        // }

        // public long countBadPairs(int[] a) {
        //     int n = a.length;
        //     long r = 0l;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i] - i;
        //         r += m.getOrDefault(v, 0); // 这个，居然也会忘记
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     }
        //     return (long)n * (n-1) / 2 - r;
        // }
 
//         public int minimumScore(int[] a, int[][] eg) {
//             int n = a.length;
//             g = new ArrayList [n];
//             Arrays.setAll(g, z -> new ArrayList<>());
//             for (var e : eg) {
//                 int u = e[0], v = e[1];
//                 g[u].add(v);
//                 g[v].add(u);
//             }
//             this.a = a;
//             xor = new int [n];
//             in = new int [n];  // 用来判断父子关系：为什么需要使用两个时间戳数组呢 ？
//             out = new int [n]; // 
//             dfs(0, -1);
//             var ans = Integer.MAX_VALUE;
//             for (int i = 2, x, y, z ; i < n; i++) // 就直接把0号当作根节点(任何节点作为根节点都无所谓)
//                 for (int j = 1; j < i; ++j) {
//                     if (in[i] < in[j] && in[j] <= out[i]) { // i 是 j 的祖先节点
//                         x = xor[j];
//                         y = xor[i] ^ x;
//                         z = xor[0] ^ xor[i];
//                     } else if (in[j] < in[i] && in[i] <= out[j]) { // j 是 i 的祖先节点
//                         x = xor[i];
//                         y = xor[j] ^ x;
//                         z = xor[0] ^ xor[j];
//                     } else { // 删除的两条边分别属于两颗不相交的子树
//                         x = xor[i];
//                         y = xor[j];
//                         z = xor[0] ^ x ^ y;
//                     }
//                     ans = Math.min(ans, Math.max(Math.max(x, y), z) - Math.min(Math.min(x, y), z));
//                     if (ans == 0) return 0; // 提前退出: 这是最小值，不可能再有更小的了，大可不必再作无用功
//                 }
//             return ans;
//         }       
//         List<Integer> [] g;
// // xor【i】: 以当前节点为根节点的所有子节点(包括当前根结点)的累积异或结果(所有节点值相异或)
//         int [] a, xor, in, out; 
//         int t;
//         void dfs(int u, int p) { // 参数：当前节点，与父节点
//             in[u] = ++t; 
//             xor[u] = a[u];
//             for (var v : g[u]) { // 遍历与当前节点连通的所有节点
//                 if (v == p) continue; // 若是父节点，可以跳过，因为已经做过了
//                 dfs(v, u); // 深度优先遍历子节点
//                 xor[u] ^= xor[v]; // 这里用了极巧妙的递归来求所以子树节点的异或值
//             }
//             out[u] = t;
//         }

        public long minSumSquareDiff(int[] a, int[] b, int x, int y) {
            int n = a.length;
            long k = x + (long)y, sum = 0;
            Queue<Integer> q = new PriorityQueue<>((z, w) -> w - z); // 降序排列
            for (int i = 0; i < n; i++) {
                int v = Math.abs(a[i] - b[i]);
                sum += v;
                q.offer(v);
            }
            if (k >= sum) return 0;
            while (k > 0) {
                int v = q.poll();
                // System.out.println("\n v: " + v);
                --v;
                --k;
                if (!q.isEmpty() && k > 0) {
                    while (!q.isEmpty() && v >= q.peek() && k > 0 && v > 0) {
                        v--;
                        k--;
                    }
                    if (k >= 0 && v > 0)
                        q.offer(v);
                } else if (k >= 0) {
                    q.offer(Math.max(0, v - (int)k));
                    k = 0;
                }
            }
            long r = 0l;
            for (var v : q) {
                // System.out.println("\n v: " + v);
                r += Math.pow(v, 2);
            }
            return r;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [] a = new int [] {1, 4, 10, 12};
        int [] b = new int [] {5, 8, 6, 9};
        
        long r = s.minSumSquareDiff(a, b, 1, 1);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
