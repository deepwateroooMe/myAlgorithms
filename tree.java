import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class tree {
    public static class Solution {

        // public int numOfSubarrays(int[] arr, int k, int threshold) {
        //     int n = arr.length;
        //     int [] pre = new int [n];
        //     pre[0] = arr[0];
        //     int res = 0;
        //     for (int i = 1; i < n; i++) 
        //         pre[i] = pre[i-1] + arr[i];
        //     for (int i = 0; i+k <= n; i++) { // j = i+k-1]
        //         if (pre[i+k-1] < k * threshold) continue;
        //         if (pre[i+k-1]-(i == 0 ? 0 : pre[i-1]) >= threshold*k) ++res;
        //     } 
        //     return res;
        // } 


        // // https://blog.csdn.net/Yaokai_AssultMaster/article/details/79599809
        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); // same effect as below
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.max(tree.get(2*i), tree.get(2*i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.max(tree.get(2*idx), tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMax(int l, int r) {
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--;            // order matters !!!
        //                 max = Math.max(max, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length;
        //     MaxSeg mat = new MaxSeg(arr);
        //     if (n == k) return new int [] {mat.getMax(0, n)};
        //     int [] res = new int [n-k+1];
        //     for (int i = 0; i+k <= n; i++) 
        //         res[i] = mat.getMax(i, i+k);
        //     return res;
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length, startWindowIdx = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // ????????????????????????
        //     int [] ans = new int [n - k + 1];
        //     for (int i = 0; i < n; i++) {
        //         startWindowIdx = i-k+1;
        //         while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();     // ??????q???maintain k size window, ???????????????k windows???????????????
        //         while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) q.pollLast(); // ??????q??????????????????????????????????????????????????????????????????????????????????????????
        //         q.offerLast(i);  // ???q???????????????q.size() == k 
        //         if (startWindowIdx >= 0)
        //             ans[startWindowIdx] = arr[q.peekFirst()]; // ?????????????????????????????????
        //     }
        //     return ans;
        // }

        
        // public int shortestSubarray(int[] nums, int k) { 
        //     int n = nums.length;
        //     int [] sum = new int[n+1];  
        //     for (int i = 1; i <= n; i++)  
        //         sum[i] = nums[i-1] + sum[i-1];
        //     int res = n + 1;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // decreasing sum [] deque
        //     for (int i = 0; i <= n; i++) {
        //         while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k)  // ?????????
        //             res = Math.min(res, i - q.pollFirst()); // ?????????      // ??????
        //         while (!q.isEmpty() && sum[q.peekLast()] >= sum[i])       // ??????
        //             q.pollLast();  
        //         q.offerLast(i);                                           // ?????????????????????
        //     }
        //     return res <= n ? res : -1;
        // }


        // public int longestSubarray(int[] arr, int limit) { // ???????????????????????????????????????????????? 
        //     int n = arr.length, max = 0;
        //     ArrayDeque<Integer> minq = new ArrayDeque<>(), maxq = new ArrayDeque<>(); 
        //     for (int i = 0; i < n; i++) {
        //         while (!minq.isEmpty() && arr[i] - arr[q.peekFirst()] > limit) 
        //             q.pollFirst(); 
        //         while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) // ???????????????arr[i]????????????????????????????????????????????????????????????????????????
        //             q.pollLast();
        //         minq.offerLast(i);   
        //         maxq.offerLast(i);   
        //         max = Math.max(max, Math.max(maxq.peekLast() - minq.peekFirst(), minq.peekLast()-maxq.peekFirst()) + 1);
        //     }
        //     return max;
        // }


        // public int minKBitFlips(int [] arr, int k) {
        //     int n = arr.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == 0) {
        //             if (i + k <= n) {
        //                 ++cnt;
        //                 for (int j = i; j < i+k; j++) 
        //                     arr[j] = 1 - arr[j];
        //             } else return -1;
        //         }
        //     }
        //     return cnt;
        // }


        // private int dfs(TreeNode r) { // ?????????????????????????????????????????????????????????coins??????
        //     if (r == null) return 0;
        //     int left = dfs(r.left);      // ????????????????????????
        //     int right = dfs(r.right);
        //     res += Math.abs(left) + Math.abs(right); // ???????????????????????????????????????????????????
        //     return left + right + r.val-1;
        // }
        // int res;
        // public int distributeCoins(TreeNode root) {
        //     res = 0;
        //     return res;
        // }
        // ??????????????????????????????????????? ???????????????????????????????????????????????????????????? ????????? ???dfs??????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // public int[] dfs(TreeNode node) {
        //     if (null == node) 
        //         return new int[]{0,0};
        //     int[] left = dfs(node.left);
        //     int[] right = dfs(node.right);
        //     int v = left[0] + right[0] + node.val;
        //     return new int[]{v-1, left[1] + right[1] + Math.abs(left[0]) + Math.abs(right[0])};
        // }        
        // public int distributeCoins(TreeNode root) {
        //     return dfs(root)[1];
        // }


        // public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        //     int m = n-1, range = 1 << (n-1);
        //     int [] ans = new int [n-1];
        //     for (int i = 1; i < range; i++) {
        //         // build tree based on each i mask
        //         // validate if the tree is valid
        //         // if it is, count it towards the Integer.bitCount(i) answer
        //     }
        // }


        // private int topDownTraverse(TreeNode r) { 
        //     if (r == null) return 0;
        //     int left = topDownTraverse(r.left);
        //     int right = topDownTraverse(r.right);
        //     if (r.left == null || r.left.val != r.val) left = 0;
        //     if (r.right == null || r.right.val != r.val) right = 0;
        //     max = Math.max(max, left + right);
        //     return Math.max(left, right) + 1;
        // }
        // int max = 0;
        // public int longestUnivaluePath(TreeNode root) {
        //     if (root == null) return 0;
        //     topDownTraverse(root);
        //     return max;
        // }

        // private void preOrder(TreeNode r, int [] arr, int i, int j) {
        //     if (r == null || (res.size() > 0 && res.get(0) == -1)) return;
        //     if (r.val != arr[i]) {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        //     if (i == j && r.left == null && r.right == null
        //         || j == i+1 && (r.left == null || r.right == null)) return;
        //     else if (i == j || i+1 == j) {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        //     if (r.left != null && r.left.val == arr[i+1]) {
        //         if (r.right == null) preOrder(r.left, arr, i+1, j);
        //         else {
        //             int k = i;
        //             for ( k = i; k <= j; k++) 
        //                 if (arr[k] == r.right.val) break;
        //             preOrder(r.left, arr, i+1, k-1);
        //             preOrder(r.right, arr, k, j);
        //         }
        //     } else if (r.right != null && arr[i+1] == r.right.val) { 
        //         if (r.left == null) preOrder(r.right, arr, i+1, j);
        //         else {
        //             res.add(r.val);  // flip here
        //             int k = i;
        //             for ( k = i; k <= j; k++) 
        //                 if (arr[k] == r.left.val) break;
        //             preOrder(r.right, arr, i+1, k-1);
        //             preOrder(r.left, arr, k, j);
        //         }
        //     } else {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        // }
        // List<Integer> res = new ArrayList<>();
        // public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //     preOrder(root, voyage, 0, voyage.length-1);
        //     return res;
        // }


        // private void traversal(TreeNode r, int d, int left, int l) { // l: 0 root, 1 left, 2 right ??????????????????????????????
        //     if (r == null) return;
        //     System.out.println("\nr.val: " + r.val);
        //     if (d != 0) {
        //         int li = 0, ri = 0;
        //         if (l == 1) {
        //             li = Math.min(left, m.getOrDefault(d, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE})[0]);
        //             m.put(d, new int [] {li, m.getOrDefault(d, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE})[1]});
        //         } else if (l == 2) {
        //             ri = Math.max(left, m.getOrDefault(d, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE})[1]);
        //             m.put(d, new int [] {m.getOrDefault(d, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE})[0], ri});
        //         }
        //     }
        //     traversal(r.left, d+1, left-1, 1);
        //     traversal(r.right, d+1, left+1, 2);
        // }
        // Map<Integer, int []> m = new HashMap<>();
        // public int widthOfBinaryTree(TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     traversal(root, 0, 0, 0);
        //     int max = 0;
        //     for (Map.Entry<Integer, int []> entry : m.entrySet()) 
        //         max = Math.max(max, entry.getValue()[1]-entry.getValue()[0]);
        //     return max;
        // }
        // class Pt {
        //     TreeNode r;
        //     int v;
        //     public Pt(TreeNode r, int v) {
        //         this.r = r;
        //         this.v = v;
        //     }
        // }
        // public int widthOfBinaryTree(TreeNode root) { // ????????????????????????java??????????????????
        //     int res = 0;
        //     Queue<Pt> q = new LinkedList<>();
        //     q.offer(new Pt(root, 1));
        //     while (!q.isEmpty()) {
        //         if (q.size() == 1) q.peek().v = 1;
        //         int left = q.peek().v, right = left, n = q.size();
        //         for (int i = 0; i < n; i++) {
        //             TreeNode cur = q.peek().r;
        //             right = q.peek().v;
        //             q.poll();
        //             if (cur.left != null) q.offer(new Pt(cur.left, right*2));
        //             if (cur.right != null) q.offer(new Pt(cur.right, right*2+1));
        //         }
        //         res = Math.max(res, right - left + 1);
        //     }
        //     return res;
        // }

        // public TreeNode recoverFromPreorder(String t) {
        //     int n = t.length(), i = t.indexOf("-"), j = 0, cnt = 0, pre = 0;
        //     if (i == -1) return new TreeNode(Integer.parseInt(t));
        //     char [] s = t.toCharArray();
        //     TreeNode root = new TreeNode(Integer.parseInt(t.substring(0, i))), r = root;
        //     ArrayDeque<TreeNode> st = new ArrayDeque<>();
        //     st.offerLast(r);
        //     while (i < n) {
        //         j = i;
        //         while (j < n && s[j] == '-') j++;
        //         cnt = j - i;
        //         i = j;
        //         while (i < n && Character.isDigit(s[i])) i++; // 1st -
        //         int v = Integer.parseInt(t.substring(j, i));
        //         if (cnt == pre + 1) {
        //             r.left = new TreeNode(v);
        //             r = r.left;
        //         } else {
        //             if (cnt == pre) 
        //                 st.pollLast(); // ?????????????????????????????????
        //             else
        //                 while (!st.isEmpty() && st.size() > cnt) st.pollLast();
        //             st.peekLast().right = new TreeNode(v);
        //             r = st.peekLast().right; //
        //             // r = st.pollLast().right; // ????????????????????????????????????????????????????????????
        //         }
        //         st.offerLast(r);
        //         pre = cnt;
        //         cnt = 0;
        //     }
        //     return root;
        // }
        // public TreeNode recoverFromPreorder(String t) {
        //     Deque<TreeNode> st = new LinkedList<TreeNode>();
        //     char [] s = t.toCharArray();
        //     int n = t.length();
        //     int idx = 0;
        //     while (idx < n) {
        //         int lvl = 0;
        //         while (s[idx] == '-') {
        //             ++lvl;
        //             ++idx;
        //         }
        //         int val = 0;
        //         while (idx < n && Character.isDigit(s[idx])) {
        //             val = val * 10 + (s[idx] - '0');
        //             ++idx;
        //         }
        //         TreeNode node = new TreeNode(val);
        //         if (lvl == st.size()) {
        //             if (!st.isEmpty()) 
        //                 st.peekLast().left = node;
        //         } else {
        //             while (lvl != st.size()) 
        //                 st.pollLast();
        //             st.peekLast().right = node;
        //         }
        //         st.offerLast(node);
        //     }
        //     while (st.size() > 1) st.pollLast();
        //     return st.peekLast();
        // }
        // private int idx = 0; // ??????S???????????????
        // public TreeNode recoverFromPreorder(String S) {
        //     if (S.isEmpty()) return null;
        //     return buildBinaryTree(S.toCharArray(), 0);
        // }
        // public TreeNode buildBinaryTree(char[] ss, int depth) {
        //     // ???????????????????????????null
        //     if (idx + depth >= ss.length || isNullPointer(ss, depth)) return null;
        //     idx += depth; // idx????????????depth???'-'???????????????????????????????????????
        //     // ??????????????????
        //     TreeNode root = new TreeNode(getValue(ss));
        //     root.left = buildBinaryTree(ss, depth + 1);
        //     root.right = buildBinaryTree(ss, depth + 1);
        //     // ??????????????????
        //     return root;
        // }
        // // ?????????????????????val????????????????????????????????????????????????
        // public int getValue(char[] ss) {
        //     int value = 0;
        //     while (idx < ss.length && ss[idx] != '-') {
        //         value = value * 10 + (ss[idx] - '0');
        //         idx ++;
        //     }
        //     return value;
        // }
        // // ????????????????????????????????????null
        // public boolean isNullPointer(char[] ss, int depth) {
        //     for (int i = idx; i < idx + depth; i ++) 
        //         if (ss[i] != '-') return true;
        //     return false;
        // }
        // public TreeNode recoverFromPreorder(String S) {
        //     if (S.isEmpty()) return null;
        //     n = S.length();
        //     return buildBinaryTree(S.toCharArray(), 0);
        // }
        // private int idx = 0, n; // ??????S???????????????
        // TreeNode buildBinaryTree(char [] s, int level) {
        //     int cnt = 0, val = 0;
        //     while (idx + cnt < n && s[idx + cnt] == '-') ++cnt;
        //     if (cnt != level) return null;
        //     idx += cnt;
        //     for (; idx < n && s[idx] != '-'; idx++) 
        //         val = val * 10 + s[idx] - '0';
        //     TreeNode r =  new TreeNode(val);
        //     r.left = buildBinaryTree(s, level + 1);
        //     r.right = buildBinaryTree(s, level + 1);
        //     return r;
        // }

        // public int checkWays(int[][] pairs) { // ????????????
        //     int max = 0;
        //     for (int [] p : pairs)
        //         max = Math.max(max, Math.max(p[0], p[1]));
        //     int [] cnt = new int [max+1]; 
        //     int [][] adj = new int [max+1][max+1];
        //     for (int [] p : pairs) {
        //         cnt[p[0]]++;
        //         cnt[p[1]]++;
        //         adj[p[0]][p[1]] = 1;
        //         adj[p[1]][p[0]] = 1;
        //     }
        //     Integer [] nodes = new Integer[max+1];
        //     int n = 0;
        //     for (int i = 1; i <= max; i++) 
        //         if (cnt[i] > 0) nodes[n++] = i;
        //     Arrays.sort(nodes, 0, n, (a, b)->cnt[b] - cnt[a]); // ?????????????????????????????????
        //     if (cnt[nodes[0]] != n-1) return 0; 
        //     int [] par = new int [max+1];
        //     int [][] allPar = new int [max+1][max+1];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i-1; j >= 0; j--) 
        //             if (adj[nodes[i]][nodes[j]] == 1) {
        //                 par[nodes[i]] = nodes[j];
        //                 for (int k = nodes[j]; k != 0; k = par[k]) // ??????????????? ?????????????????????
        //                     allPar[nodes[i]][k] = 1;
        //                 break; // ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //             }
        //     int ans = 1;
        //     for (int i = 1; i <= max; i++) 
        //         for (int j = i+1; j <= max; j++) {
        //             if (adj[i][j] == 1 && cnt[i] == cnt[j]) ans = 2;
        //             if (adj[i][j] != (allPar[i][j] | allPar[j][i])) return 0;
        //         }
        //     return ans;
        // }

        // public int[] getCoprimes(int[] a, int[][] edges) {
        //     cop = new boolean [51][51];
        //     for (int i = 1; i < 51; i++) 
        //         for (int j = 1; j < 51; j++) 
        //             if (!cop[i][j] && gcd(i, j) == 1) {
        //                 cop[i][j] = true;
        //                 cop[j][i] = true;
        //             }
        //     int n = a.length;
        //     tree = new ArrayList[n];
        //     for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         tree[e[0]].add(e[1]);
        //         tree[e[1]].add(e[0]);
        //     }
        //     ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     vis = new boolean [n];
        //     dfs(0, 0, a);
        //     return ans;
        // }
        // Map<Integer, int []> m = new HashMap<>(); // k, v: value, [depth, ndIndex]
        // ArrayList<Integer>[] tree;
        // boolean [][] cop;
        // boolean [] vis;
        // int [] ans;
        // void dfs(int dp, int nd, int [] a) { // dp: depth; nd: node
        //     if (vis[nd]) return ;
        //     vis[nd] = true;
        //     int par = -1, d = Integer.MAX_VALUE; // parent, depth of ancestor
        //     for (int i = 1; i < 51; i++) 
        //         if (cop[a[nd]][i] && m.containsKey(i)) 
        //             if (dp - m.get(i)[0] <= d) { // 
        //                 d = dp - m.get(i)[0];
        //                 par = m.get(i)[1];
        //             }
        //     ans[nd] = par;
        //     int [] ext = (m.containsKey(a[nd]) ? m.get(a[nd]) : new int [] {-1, -1});
        //     m.put(a[nd], new int [] {dp, nd});
        //     for (Integer next : tree[nd]) {
        //         if (vis[next]) continue;
        //         dfs(dp + 1, next, a);
        //     }
        //     if (ext[0] != -1) m.put(a[nd], ext);
        //     else m.remove(a[nd]);
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }
        // vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        //     int n = nums.size();
        //     G.resize(n);
        //     for(auto& e : edges) {
        //         G[e[0]].push_back(e[1]);
        //         G[e[1]].push_back(e[0]);
        //     }
        //     res.resize(n);
        //     dfs(0, -1, 0, nums);
        //     return res;
        // }
        // vector<vector<int>> G;
        // stack<pair<int,int>> lasts[55];
        // vector<int> res;
        // void dfs(int node, int pre, int level, vector<int>& a) {
        //     int re = -1, lev = -1;
        //     for(int i = 1; i <= 50; ++i) {
        //         if(lasts[i].size() && lasts[i].top().first > lev && __gcd(i, a[node]) == 1) {
        //             re = lasts[i].top().second;
        //             lev = lasts[i].top().first;
        //         }
        //     }
        //     res[node] = re;
        //     for(int ne : G[node]) {
        //         if(ne != pre) {
        //             lasts[a[node]].push({level, node});
        //             dfs(ne, node, level + 1, a);
        //             lasts[a[node]].pop();
        //         }
        //     }
        // }
        // public int[] getCoprimes(int[] a, int[][] edges) {
        //     cop = new boolean [51][51];
        //     for (int i = 1; i < 51; i++) 
        //         for (int j = 1; j < 51; j++) 
        //             if (!cop[i][j] && gcd(i, j) == 1) {
        //                 cop[i][j] = true;
        //                 cop[j][i] = true;
        //             }
        //     int n = a.length;
        //     li = new ArrayList[n];
        //     for (int i = 0; i < n; i++) li[i] = new ArrayList<>();
        //     for (int [] e : edges) {
        //         li[e[0]].add(e[1]);
        //         li[e[1]].add(e[0]);
        //     }
        //     ans = new int [n];
        //     for (int i = 0; i < 51; i++) 
        //         st[i] = new ArrayDeque<>();
        //     dfs(0, -1, 0, a);
        //     return ans;
        // }
        // List<Integer>[] li;
        // ArrayDeque<int []> [] st = new ArrayDeque[51];
        // boolean [][] cop;
        // int [] ans;
        // void dfs(int node, int pre, int level, int [] a) {
        //     int re = -1, lev = -1;
        //     for (int i = 1; i < 51; i++) 
        //         if (st[i].size() > 0 && st[i].peekLast()[0] > lev && cop[i][a[node]]) {
        //             re = st[i].peekLast()[1];
        //             lev = st[i].peekLast()[0];
        //         }
        //     ans[node] = re;
        //     for (int next : li[node]) {
        //         if (next != pre) {
        //             st[a[node]].offerLast(new int [] {level, node});
        //             dfs(next, node, level + 1, a);
        //             st[a[node]].pollLast();
        //         }
        //     }
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

// // ????????????????????????????????????????????????????????????????????????????????????        
//         public boolean hasPathSum(TreeNode r, int t) {
//             traversal(r, 0, t);
//             return vis;
//         }
//         boolean vis = false;
//         void traversal(TreeNode r, int v, int t) {
//             if (r == null) return ;
//             if (r.left == null && r.right == null) {
//                 if (v + r.val == t) vis = true;
//                 return ;
//             }
//             traversal(r.left, v + r.val, t);
//             traversal(r.right, v + r.val, t);
//         }
//         int cnt = 0; // ????????????????????? 
//         public boolean hasPathSum(TreeNode r, int t) {
//             if (r == null) return false;
//             cnt += r.val;
//             if (r.left == null && r.right == null) {
//                 if (cnt == t) return true;
//                 // return false; // ?????????????????????????????????????????????????????????????????????????????????false
//             }
//             boolean left = hasPathSum(r.left, t);
//             boolean right = hasPathSum(r.right, t);
//             cnt -= r.val;
//             return left || right;
//         }

        // public boolean isSymmetric(TreeNode r) {
        //     if (r == null) return true;
        //     return isMirrorTrees(r.left, r.right);
        // }
        // boolean isMirrorTrees(TreeNode p, TreeNode q) {
        //     if (p == null && q == null) return true;
        //     else if (p == null || q == null || p.val != q.val) return false;
        //     return isMirrorTrees(p.left, q.right) && isMirrorTrees(p.right, q.left);
        // }

        // public TreeNode invertTree(TreeNode r) {
        //     if (r == null) return null;
        //     TreeNode tmp = invertTree(r.right);
        //     r.right = invertTree(r.left);
        //     r.left = tmp;
        //     return r;
        // }

        // public TreeNode mergeTrees(TreeNode p, TreeNode q) {
        //     if (p == null && q == null) return null;
        //     if (p == null || q == null) return p == null ? q : p;
        //     p.val += q.val;
        //     p.left = mergeTrees(p.left, q.left);
        //     p.right = mergeTrees(p.right, q.right);
        //     return p;
        // }

        // List<Integer> l = new ArrayList<>();
        // public int [] inOrderTraversal(TreeNode r) {
        //     inOrderTraversalRecur(r);
        //     return l.stream().mapToInt(Integer::intValue).toArray();
        // }
        // void inOrderTraversalRecur(TreeNode r) {
        //     if (r == null) return ;
        //     inOrderTraversalRecur(r.left);
        //     l.add(r.val);
        //     inOrderTraversalRecur(r.right);
        // }
// // ????????????????????????????????????????????????????????????????????????        
//         public int [] inOrderTraversal(TreeNode r) {
//             List<Integer> l = new ArrayList<>();
//             Deque<TreeNode> s = new ArrayDeque<>();
//             while (r != null || !s.isEmpty()) {
//                 while (r != null) {
//                     s.offerLast(r);
//                     r = r.left;
//                 }
//                 r = s.pollLast();
//                 l.add(r.val);
//                 r = r.right;
//             }
//             return l.stream().mapToInt(Integer::intValue).toArray();
//         }

        // public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        //     return searchNode(r, p, q).val;
        // }                        
        // TreeNode searchNode(TreeNode r, TreeNode p, TreeNode q) {
        //     if (r == null) return null;
        //     if (r == p || r == q) return r;
        //     TreeNode l = searchNode(r.left, p, q);
        //     TreeNode ri = searchNode(r.right, p, q);
        //     if (l != null && ri != null) return r;
        //     return l == null ? ri : l;
        // }
        // public TreeNode lowestCommonAncestor(TreeNode r, TreeNode p, TreeNode q) {
        //     if (r == null || r == p || r == q) return r;
        //     TreeNode left = lowestCommonAncestor(r.left, p, q);
        //     TreeNode right = lowestCommonAncestor(r.right, p, q);
        //     return left == null ? right : right == null ? left : r;
        // }
        
        // public boolean isBalanced(TreeNode r) {
        //     if (r == null) return true;
        //     getDepth(r);
        //     return balanced;
        // }
        // boolean balanced = true;
// ???????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // int getDepth(TreeNode r) { 
        //     if (r == null) return 0;
        //     int l = getDepth(r.left);
        //     int ri = getDepth(r.right);
        //     if (Math.abs(l - ri) > 1) balanced = false;
        //     return Math.max(l, ri) + 1;
        // }
// // ?????????????????????????????????????????????????????????1????????????????????????????????????   
//         public boolean isBalanced(TreeNode r) {
//             if (r == null) return true;
//             return Math.abs(getDepth(r.left) - getDepth(r.right)) <= 1
//                 && isBalanced(r.left) && isBalanced(r.right);
//         }
//         int getDepth(TreeNode r) {
//             if (r == null) return 0;
//             return Math.max(getDepth(r.left), getDepth(r.right)) + 1;
//         }
        // public boolean isBalanced(TreeNode r) { // 
        //     if (r == null) return true;
        //     if (Math.abs(getDepth(r.left) - getDepth(r.right)) > 1)
        //         return false;
        //     return isBalanced(r.left) && isBalanced(r.right);
        // }
        // int getDepth(TreeNode r) {
        //     if (r == null) return 0;
        //     return Math.max(getDepth(r.left), getDepth(r.right)) + 1;
        // }

        public List<Integer> pathInZigZagTree(int label) {
            
        }
    }
        
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
        TreeNode r1 = new TreeNode(a[0]);
        r1.buildTree(r1, a);
        r1.levelPrintTree(r1);
        
        int r = s.lowestCommonAncestor(r1, 5, 1);
        System.out.println("r: " + r);
    }
}
