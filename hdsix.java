import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class hdsix {
    public static class Solution {

        // public String minInteger(String t, int k) {
        //     int n = t.length();
        //     t = " " + t;
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Integer> [] q = new ArrayDeque [10];
        //     for (int i = 1; i <= n; i++) {
        //         int j = s[i] - '0';
        //         if (q[j] == null) q[j] = new ArrayDeque<>();
        //         q[j].offerLast(i);
        //     }
        //     BIT bit = new BIT(n);
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 0; j < 10; j++) { // 从小数值往大数值遍历
        //             if (q[j] == null || q[j].isEmpty()) continue;
        //             int top = q[j].peekFirst(), pos = top + bit.sum(top); // pos是最优解的位置，最优解的位置是原来的位置加上偏移量
        //             if (pos - i <= k) {
        //                 k -= pos - i;
        //                 sb.append(j);
        //                 q[j].pollFirst();
        //                 bit.add(1, 1); // 更新[1, t)这段的值每个加1，即向右偏移1位.为什么要 从1开始更新：假装每次都移动到最前端，方便计算 ?
        //                 bit.add(top, -1);
        //                 break;
        //             }
        //         }
        //     }
        //     return sb.toString();
        // }
        // class BIT { // 开一个树状数组类，维护每个位置的字符的向右的偏移量 ? 向左偏移量
        //     private int n;
        //     private int [] a;
        //     public BIT(int n) {
        //         this.n = n;
        //         this.a = new int [n+1];
        //     }
        //     public void add(int idx, int v) { // 只有发生偏移，才移动某段区间的值
        //         while (idx <= n) {
        //             a[idx] += v;
        //             idx += lowbit(idx);
        //         }
        //     }
        //     public int sum(int idx) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, idx]的和，1-based
        //         int ans = 0;
        //         while (idx > 0) {
        //             ans += a[idx];
        //             idx -= lowbit(idx);
        //         }
        //         return ans;
        //     }
        //     int lowbit(int x) {
        //         return x & -x;
        //     }
        // }

    // private long add, mul;
    // private List<Integer> l;
    // static final int mod = (int)1e9 + 7;
    // public Fancy() {
    //     add = 0;
    //     mul = 1;
    //     l = new ArrayList<>();
    // }
    // public void append(int val) {
    //     val = (int)((val - add + mod) % mod);
    //     val = (int)((long)val * quickMul(mul, mod - 2) % mod);
    //     l.add(val);
    // }
    // public void addAll(int inc) {
    //     add = (add + inc) % mod;
    // }
    // public void multAll(int m) {
    //     add = add * m % mod;
    //     mul = mul * m % mod;
    // }
    // public int getIndex(int idx) {
    //     if (idx >= l.size()) return -1;
    //     return (int)((l.get(idx) * mul + add) % mod);
    // }
    // long quickMul(long base, int exp) {
    //     long ans = 1;
    //     while (exp > 0) {
    //         if (exp % 2 == 1)
    //             ans = ans * base % mod;
    //         base = base * base % mod;
    //         exp >>= 1;
    //     }
    //     return ans;
    // }

        // public int minimumEffort(int[][] a) {
        //     int n = a.length, ans = 0;
        //     Arrays.sort(a, (x, y)->(x[1]-x[0] - (y[1]-y[0]))); // 从能量消耗最小的任务，到能量消耗较大的任务
        //     for (int i = 0; i < n; i++) 
        //         ans = Math.max(ans + a[i][0], a[i][1]);
        //     return ans;
        // }

        // public int countPairs(int[] a, int low, int high) { // 暴力解法，勉强能过
        //     int n = a.length, N = 2 * 10000 + 1;
        //     int [] cnt = new int [N];
        //     for (int v : a) cnt[v]++;
        //     int val = 0, ans = 0;
        //     for (int v : a) {
        //         for (int i = low; i <= high; i++) {
        //             val = v ^ i;
        //             if (val < N)
        //                 ans += cnt[val];
        //         }
        //         cnt[v]--;
        //     }
        //     return ans;
        // }
        // public int countPairs(int[] a, int low, int high) { // trie
        //     int n = a.length, ans = 0, maxHeight = 14; // 2^15=32768 ， 15 位二进制足够计算
        //     Trie t = new Trie();
        //     for (int v : a) {
        //         ans += t.search(t, maxHeight, v, high) - t.search(t, maxHeight, v, low-1);
        //         t.insert(v);
        //     }
        //     return ans;
        // }
        // class Trie {
        //     static final int h = 14; // 2^15=32768 ， 15 位二进制足够计算
        //     int cnt;
        //     Trie [] next;
        //     public Trie() {
        //         this.cnt = 0;
        //         this.next = new Trie[2];
        //     }
        //     public void insert(int v) {
        //         Trie r = this;
        //         for (int i = h; i >= 0; i--) {
        //             int j = (v >> i) & 1;
        //             if (r.next[j] == null)
        //                 r.next[j] = new Trie();
        //             r = r.next[j];
        //             r.cnt++;
        //         }
        //     }
        //     public int search(Trie r, int d, int v, int range) {
        //         if (r == null) return 0;
        //         if (d < 0) return r.cnt;
        //         int vb = (v >> d) & 1;
        //         int vr = (range >> d) & 1;
        //         if (vr == 1) {   // range在该位为1
        //             if (vb == 0) // num在该位为0，num2在该位为0的全部满足，为1的部分需要继续判断
        //                 return (r.next[0] == null ? search(r.next[1], d-1, v, range) : r.next[0].cnt + search(r.next[1], d-1, v, range));
        //             else // num在该位为1，num2在该位为1的全部满足，为0的需要继续判断
        //                 return (r.next[1] == null ? search(r.next[0], d-1, v, range) : r.next[1].cnt + search(r.next[0], d-1, v, range));
        //         } // range在该位为0，num2在该位必须与num一致
        //         return search(r.next[vb], d-1, v, range);
        //     }
        // }

        // long mul = 1_000_000_007;
        // long mod = (1l<<61)-1;
        // long[] pow;
        // public int longestCommonSubpath(int n, int[][] paths) { // 这个题要好好再理解消化一下
        //     int pl = paths.length;
        //     int max = Integer.MAX_VALUE;
        //     for(int i = 0; i < pl; i++)
        //         max = Math.min(max, paths[i].length);
        //     pow = new long[max+1];
        //     pow[0] = 1;
        //     for(int i = 1; i <= max; i++) 
        //         pow[i] = multipy(pow[i-1], mul);
        //     int le = 0, ri = max;
        //     while(le < ri) {
        //         int mid = le + (ri - le + 1) / 2;
        //         if(valid(paths, mid)) le = mid;
        //         else ri = mid - 1;
        //     }
        //     return le;
        // }
        // private boolean valid(int[][] paths, int len) {
        //     int pl = paths.length;
        //     Set<Long> prev = null;
        //     for(int i = 0; i < pl; i++) {
        //         Set<Long> hashs = rollingHashs(paths[i], len);
        //         if(prev == null) 
        //             prev = hashs;
        //         else {
        //             prev.retainAll(hashs);
        //             if(prev.size() == 0) return false;
        //         }
        //     }
        //     return true;
        // }
        // private Set<Long> rollingHashs(int[] arr, int len) {
        //     int l = arr.length;
        //     long[] hash = new long[l+1];
        //     for(int i = 1; i <= l; i++) 
        //         hash[i] = modulo(multipy(hash[i-1], mul) + (arr[i-1]+1));
        //     Set<Long> ret = new HashSet<>();
        //     for(int i = len-1; i < l; i++) {
        //         long soFarHash = hash[i+1];
        //         long prevHash = hash[i-len+1];
        //         prevHash = multipy(prevHash, pow[len]);
        //         long currHash = modulo(soFarHash - prevHash);
        //         ret.add(currHash);
        //     }
        //     return ret;
        // }
        // private long multipy(long a, long b) {
        //     long al = a&((1l<<31)-1), ah = (a>>>31);  // ???
        //     long bl = b&((1l<<31)-1), bh = (b>>>31);
        //     long ll = al * bl;
        //     long mid = al * bh + bl * ah;
        //     long hh = bh * ah + (mid >>> 31);
        //     long ret = modulo(modulo(2*hh+ll) + ((mid & (1l<<31)-1)<<31));
        //     return ret;
        // }
        // private long modulo(long hash) {
        //     while(hash >= mod)
        //         hash -= mod;
        //     while(hash < 0)
        //         hash += mod;
        //     return hash;
        // }
        // public int longestCommonSubpath(int n, int[][] a) { // BUG: 78/81 passed
        //     m = a.length;
        //     idx = 0;
        //     int r = Integer.MAX_VALUE, l = 1;
        //     for (int i = 0; i < m; i++)
        //         if (a[i].length < r) {
        //             r = a[i].length;
        //             idx = i;
        //         }
        //     while (l <= r) {
        //         int mid = l + (r - l) / 2;
        //         if (hasCommonPathOfLengthVal(mid, a)) 
        //             l = mid + 1;
        //         else r = mid - 1;
        //     }
        //     return l - 1;
        // } // The collision probability here will be = 10^5 / 10^11 = 10^-6, which is acceptable for current leetcode testcases.
        // // long base = 100001, mod = (long)(Math.pow(10,11) + 7);
        // // int m, idx;
        // static final int mod = (int)1e9 + 7;
        // int m, idx, base = 113;
        // boolean hasCommonPathOfLengthVal(int n, int [][] a) { // rolling hash to tell if has common subpath of length n
        //     long hash = 0;                                    // n: length 这种解法可能还存在hash冲突的问题
        //     Set<Long> sl = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         hash = (hash * base + a[idx][i]) % mod;
        //     sl.add(hash);
        //     long mul = quickMul(base, n-1);
        //     for (int i = n; i < a[idx].length; i++) {
        //         hash = ((hash - a[idx][i-n] * mul % mod + mod) % mod * base + a[idx][i]) % mod;
        //         sl.add(hash); // 遍历所有m条路径中最短的一条，并计算出所有长度为n的hash值 备用
        //     }
        //     int j = 0;
        //     for (int i = 0; i < a.length; i++) {
        //         if (i == idx) continue;
        //         long hb = 0; // the other hash: current path len n hashes
        //         for (j = 0; j < n; j++) 
        //             hb = (hb * base + a[i][j]) % mod;
        //         if (sl.contains(hb)) continue; 
        //         for ( j = n; j < a[i].length; j++) {
        //             hb = ((hb - a[i][j-n] * mul % mod + mod) % mod * base + a[i][j]) % mod;
        //             if (sl.contains(hb)) break;
        //         }
        //         if (j < a[i].length) continue;
        //         else return false;
        //     }
        //     return true;
        // }
        // long quickMul(long base, int exp) {
        //     long ans = 1;
        //     while (exp > 0) {
        //         if (exp % 2 == 1)
        //             ans = ans * base % mod;
        //         base = base * base % mod;
        //         exp >>= 1;
        //     }
        //     return ans;
        // }
        // long base = 100001, mod = (long)(Math.pow(10,11) + 7), pow[];  
        // public int longestCommonSubpath(int n, int[][] paths) { // 这个思路可以过，好好看一下
        //     int res = 0, min = Integer.MAX_VALUE;
        //     for(int[] path : paths) min = Math.min(min, path.length);
        //     pow = new long[min+1]; pow[0]++; 
        //     for(int i=1 ; i<=min ; i++)
        //         pow[i] = ( pow[i-1] * base ) % mod;
        //     for(int st=1, end=min, mid = (st+end)/2; st <=end ; mid = (st+end)/2){ 
        //         if( commonSubstring(paths, mid) ){
        //             res = mid;
        //             st = mid+1;
        //         }
        //         else
        //             end = mid-1;   
        //     }
        //     return res;
        // }
        // private boolean commonSubstring(int[][] paths, int l){
        //     HashSet<Long> set = rollingHash(paths[0],l);
        //     for(int i=1,n = paths.length; i<n ; i++){
        //         set.retainAll(rollingHash(paths[i],l));
        //         if(set.isEmpty()) return false;
        //     }
        //     return true;
        // }
        // private HashSet<Long> rollingHash(int[] a,int l){
        //     HashSet<Long> set = new HashSet<>();
        //     long hash = 0;
        //     for(int i=0 ; i<l ; i++)
        //         hash = ( hash*base + a[i] ) % mod;
        //     set.add(hash);
        //     for(int n=a.length, curr=l, prev = 0; curr<n ; prev++,curr++){
        //         hash = ( ( (hash*base)%mod - (a[prev]*pow[l])%mod + a[curr] ) + mod ) % mod;
        //         set.add(hash);
        //     }
        //     return set;
        // }

        // public TreeNode deserialize(String d) { // 因为是层级遍历，实现起来相地容易
        //     if (d == null || d.length() == 0) return null;
        //     int n = d.length(), i = 0;
        //     List<Integer> l = deserializeToList(d);
        //     TreeNode root = new TreeNode (l.get(0));
        //     Deque<TreeNode> q = new ArrayDeque<>();
        //     TreeNode r = root;
        //     q.offerLast(r);
        //     while (!q.isEmpty() && i < l.size()) {
        //         r = q.pollFirst(); // 先进先出
        //         ++i;
        //         if (i % 2 == 1) {
        //             if (l.get(i) == 1001) r.left = null;
        //             else {
        //                 r.left = new TreeNode (l.get(i));
        //                 q.offerLast(r.left);
        //             }
        //         }
        //         ++i;
        //         if (i % 2 == 0) {
        //             if (l.get(i) == 1001) r.right = null;
        //             else {
        //                 r.right = new TreeNode(l.get(i));
        //                 q.offerLast(r.right);
        //             }
        //         }
        //     }
        //     return root;
        // }
        // public String serialize(TreeNode r) {
        //     StringBuilder s = new StringBuilder();
        //     if (r == null) return s.toString();
        //     Deque<TreeNode> q = new ArrayDeque<>();
        //     q.offerLast(r);
        //     s.append(r.val + ",");
        //     while (!q.isEmpty()) {
        //         TreeNode p = q.pollFirst(); // 先进先出
        //         if (p.left != null) {
        //             q.offerLast(p.left);
        //             s.append(p.left.val + ",");
        //         } else s.append("#,");
        //         if (p.right != null) {
        //             q.offerLast(p.right);
        //             s.append(p.right.val + ",");
        //         } else s.append("#,");
        //     }
        //     return s.toString();
        // } 
        // List<Integer> deserializeToList(String t) {
        //     List<Integer> l = new ArrayList<>();
        //     char [] s = t.toCharArray();
        //     int n = t.length(), i = 0, j = s[0] == '-' ? 1 : 0;
        //     while (j < n) {
        //         while (j < n && (Character.isDigit(s[j]) || s[j] == '-')) j++;
        //         if (j > i && j < n) {
        //             l.add(Integer.parseInt(t.substring(i, j)));
        //             if (j == n) return l;
        //         }
        //         if (s[j] == '#') {
        //             l.add(1001);
        //             ++j;
        //         }
        //         if (j < n && s[j] == ',') j++;
        //         if (j == n) return l;
        //         i = j;
        //     }
        //     return l;
        // }
        // public String serialize(TreeNode root) { // 思路也对，实现起来相对复杂一点儿：这个改天再补一下
        //     if (root == null) return "#";
        //     return serializeRecursive(root);
        // } 
        // public TreeNode deserialize(String d) { // 用iterative的方法，parse出来
        //     if (data.equals("#")) return null;
        //     ArrayDeque<TreeNode> s = new ArrayDeque<>(); // 借助一个stack
        //     int n = d.length(), i = 0, pre = -1;
        //     while (i < n && Character.isDigit(d.charAt(i))) i++;
        //     TreeNode r = new TreeNode(Integer.parseInt(d.substring(0, i)));
        //     s.offerLast(r);
        //     i += 1;
        //     return null;
        // }
        // public TreeNode deserializeRecursive(TreeNode r, String s) {
        //     return null;
        // }
        // private String serializeRecursive(TreeNode r) {
        //     if (r == null) return "";
        //     String ans = "" + r.val + " ";
        //     String left = serializeRecursive(r.left);
        //     String right = serializeRecursive(r.right);
        //     return ans + (left.equals("") ? "#" : left) + (right.equals("") ? "#" : right);
        // }

        // public int reversePairs(int[] a) { // O(NlogN)
        //     return mergeSortCnt(Arrays.stream(a).mapToLong(i->i).toArray(), 0, a.length-1);
        // }
        // int mergeSortCnt(long [] a, int bgn, int end) {
        //     if (bgn >= end) return 0;
        //     int mid = bgn + (end - bgn) / 2;
        //     int cnt = mergeSortCnt(a, bgn, mid) + mergeSortCnt(a, mid+1, end); // 递归处理左右两边的子问题；完后左边两段片段分别已经排好序
        //     for (int i = bgn, j = mid+1; i <= mid; i++) { // 处理子问题中不曾处理的case：去数 i在左半段，j在右半段，并且a[i] > 2*a[j]的个数
        //         while (j <= end && a[i] > 2 * a[j]) j++;  // 对于每个当前的i来说，j可以右移到的最大边界，便是当前i分布两片段、合法解的个数
        //         cnt += j - (mid + 1); // 右半段从下标mid+1开始，合法解不包括j当前位置
        //     }
        //     Arrays.sort(a, bgn, end+1);
        //     return cnt;
        // }

        // public int[][] outerTrees(int[][] a) {
        //     if (a.length <= 1) return a;
        //     int [] bgn = getBottomLeft(a);
        //     Arrays.sort(a, (x, y) -> { // 将给定点集按照相对初始点的极角坐标排序（也就是从点 0 出发的一条直线）
        //             double dif = getRelativeDir(bgn, x, y) - getRelativeDir(bgn, y, x); // 使用过的函数 orientation 。极角顺序更小的点排在数组的前面。
        //             if (dif == 0) return getDist(bgn, x) - getDist(bgn, y);     // 如果有两个点相对于点 0 在同一方向上，我们将它们按照与点 0 的距离排序
        //             return dif > 0 ? 1 : -1; 
        //         });
        //     int i = a.length-1;
        //     while (i >= 0 && getRelativeDir(bgn, a[a.length-1], a[i]) == 0) i--;
        //     for (int l = i+1, h = a.length-1; l < h; l++, h--) {
        //         int [] tmp = a[l];
        //         a[l] = a[h];
        //         a[h] = tmp;
        //     }
        //     Deque<int []> s = new ArrayDeque<>();
        //     s.offerLast(a[0]);
        //     s.offerLast(a[1]);
        //     for (int j = 2; j < a.length; j++) {
        //         int [] top = s.pollLast();
        //         while (!s.isEmpty() && getRelativeDir(s.peekLast(), top, a[j]) > 0)
        //             top = s.pollLast();
        //         s.offerLast(top);
        //         s.offerLast(a[j]);
        //     }
        //     int [][] ans = new int [s.size()][2];
        //     i = 0;
        //     for (int [] v : s) 
        //         ans[i++] = v;
        //     return ans;
        // }
        // int getDist(int [] s, int [] r) {
        //     return (int)Math.pow(s[0] - r[0], 2) + (int)Math.pow(s[1] - r[1], 2);
        // }
        // int getRelativeDir(int [] s, int [] p, int [] q) {                        // 观察到点 s, p, q 形成的向量相应地都是逆时针方向，
        //     return (p[1] - s[1]) * (q[0] - p[0]) - (p[0] - s[0]) * (q[1] - p[1]); // 向量sp和向量pq的方向都朝平面向外，也就是是个正值
        // }
        // int [] getBottomLeft(int [][] a) { // 选择 y 坐标最小的点为起始点，如果有相同的最小 y 坐标，我们选择 x 坐标最小的，这个点被记为动图中的点 0
        //     int [] ans = a[0];
        //     for (int [] v : a) 
        //         if (v[1] < ans[1])
        //             ans =v;
        //     return ans;
        // }

        // public String longestDupSubstring(String t) {
        //     int n = t.length(), l = 0, r = n; // r = n-1 bug
        //     String ans = "";
        //     while (l <= r) {
        //         int m = l + (r - l) / 2;
        //         String tmp = exist(m, t);
        //         if (tmp == null) r = m-1;
        //         else {
        //             if (tmp.length() > ans.length())
        //                 ans = tmp;
        //             l = m + 1;
        //         }
        //     }
        //     return ans;
        // }
        // static final int mod = (1 << 31)-1, base = 26;
        // String exist(int m, String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Map<Long, List<Integer>> map = new HashMap<>();
        //     long h = 0, p = 1;
        //     for (int i = 0; i < m; i++) {
        //         h = (h * base + s[i]) % mod;
        //         if (i >= 1) p = p * base % mod;
        //     }
        //     map.computeIfAbsent(h, z -> new ArrayList<>()).add(0);
        //     for (int i = 1; i+m <= n; i++) { // 换一种遍历方法的目的是，方便接下来collision检测的时候回调原始字符串
        //         h = ((h - s[i-1] * p % mod + mod) % mod * base % mod + s[i+m-1]) % mod;
        //         if (map.containsKey(h)) {
        //             for (int idx : map.get(h)) 
        //                 if (isMatch(t.substring(i, i+m), t.substring(idx, idx+m))) 
        //                     return t.substring(i, i+m);
        //         }
        //         map.computeIfAbsent(h, z -> new ArrayList<>()).add(i);
        //     }
        //     return null;
        // }
        // boolean isMatch(String ss, String tt) {
        //     if (ss.length() != tt.length()) return false;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0;
        //     while (i < ss.length()) {
        //         if (s[i] != t[i]) return false;
        //         i++;
        //     }
        //     return true;
        // }

        // public List<String> braceExpansionII(String s) {
        //     return expr(s).stream().sorted().collect(Collectors.toList()); // set to list
        // }
        // Set<String> expr(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Set<String> ans = new HashSet<>();
        //     if (t.equals("")) return ans;  // 空串就返回空
        //     // 最快的就是indexOf方法，其次是contains方法，二者应该没有实际区别，contains是调用indexOf来实现的。
        //     // Apache的StringUtils为第三方库，相对慢一些。最慢的是使用了正则的Pattern的方法，这不难理解，正则引擎的匹配是比较耗性能的。
        //     else if (t.indexOf("{") == -1) // 不包含{}，则直接以,为分隔，组成set
        //         return Arrays.stream(t.split(",")).collect(Collectors.toSet());
        //     int cnt = 0, bgn = -1, end = -1; // 统计与计数：{ } 出现的位置或个数
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '{') {
        //             if (bgn == -1) bgn = i;
        //             cnt++;
        //         } else if (s[i] == '}') 
        //             cnt--;
        //         if (cnt == 0) {
        //             if (bgn != -1 && end == -1) end = i; // }
        //             if (s[i] == ',') { // cnt = 0, & s[i] = ','说明，并没有出现在任何一对{}之间，因此可以就此，将t分为左右两个片段，并返回答案
        //                 ans.addAll(expr(t.substring(0, i)));
        //                 ans.addAll(expr(t.substring(i+1)));
        //                 return ans;
        //             }
        //         }
        //     }
        //     String pre = (bgn == 0 ? "" : t.substring(0, bgn));
        //     Set<String> l = expr(t.substring(bgn+1, end));
        //     Set<String> r = expr(t.substring(end+1)); // {},{} : , ???
        //     if (l.isEmpty()) l.add("");
        //     if (r.isEmpty()) r.add("");
        //     for (String one : l) 
        //         for (String two : r) {
        //             String tmp = pre + one + two;
        //             ans.add(tmp);
        //         }
        //     return ans;
        // }
        // public List<String> braceExpansionII(String t) {
        //     int n = t.length();
        //     if (t.indexOf("{") == -1)
        //         return Arrays.stream(t.split(",")).collect(Collectors.toList());
        //     char [] s = t.toCharArray();
        //     List<String> ans = new ArrayList<>();
        //     Deque<Character> st = new ArrayDeque<>();
        //     for (int i = 0, j = 0; i < n; i++) {
        //         if (s[i] == '{') st.offerLast(s[i]);
        //         else if (s[i] == '}') {
        //             st.pollLast();
        //             if (st.isEmpty() && (i < n-1 && s[i+1] == ',' || i == n-1)) {
        //                 ans.addAll(helper(t.substring(j, i+1)));
        //                 j = i+2;
        //             }
        //         } else if (st.isEmpty() && i == n-1)
        //             ans.addAll(helper(t.substring(j, i+1)));
        //     }
        //     return ans;
        // }
        // List<String> helper(String t) {
        //     Deque<String> q = new ArrayDeque<>();
        //     q.offerLast(t);
        //     Set<String> ans = new HashSet<>();
        //     StringBuilder s = new StringBuilder();
        //     while (!q.isEmpty()) {
        //         String cur = q.pollLast();
        //         if (cur.indexOf("{") == -1) {
        //             ans.add(cur);
        //             continue;
        //         }
        //         int i = 0, l = 0, r = 0;
        //         while (cur.charAt(i) != '}') {
        //             if (cur.charAt(i) == '{') l = i;
        //             i++;
        //         }
        //         r = i;
        //         String bef = cur.substring(0, l);
        //         String aft = cur.substring(r+1);
        //         String [] str = cur.substring(l+1, r).split(",");
        //         for (String v : str) {
        //             s.setLength(0);
        //             q.offerLast(s.append(bef).append(v).append(aft).toString());
        //         }
        //     }
        //     List<String> res = new ArrayList<>(ans);
        //     Collections.sort(res);
        //     return res;
        // }

        // public int maxValueAfterReverse(int[] a) {
        //     int n = a.length, ans = 0, sum = 0;
        //     if (n == 1) return 0;
        //     for (int i = 0; i < n-1; i++) // 不发生交换情况下的解
        //         sum += Math.abs(a[i] - a[i+1]);
        //     for (int i = 0; i < n-1; i++) // 发生交换、但交换的左端点为数组头的case, 交换的区间左端点是数组的左边界
        //         ans = Math.max(ans, sum + Math.abs(a[i+1]-a[0]) - Math.abs(a[i+1]-a[i]));
        //     for (int i = n-1; i > 0; i--) // 发生交换、但交换的左端点为数组尾的case, 交换的区间右端点是数组的右边界
        //         ans = Math.max(ans, sum + Math.abs(a[n-1] - a[i-1]) - Math.abs(a[i] - a[i-1]));
        //     // 交换区间左右端点在数组内部
        //     int l = 1; // 1.找出左端点b：每两个相邻的，选最大的那一个数；在所有相邻对中，选最小的
        //     for (int i = 2; i < n; i++) 
        //         if (Math.max(a[i], a[i-1]) < Math.max(a[l], a[l-1])) l = i;
        //     int r = 0; // 2.找出右端点c：每两个相邻的，先最小的那一个数；在所有相邻对中，选最大的
        //     for (int i = 1; i < n-1; i++) 
        //         if (Math.min(a[i], a[i+1]) > Math.min(a[r], a[r+1])) r = i;
        //     ans = Math.max(ans, sum + 2 * (Math.min(a[r], a[r+1]) - Math.max(a[l], a[l-1])));
        //     return ans;
        // }

        // int [][] rowRank;
        // int [][] colRank;
        // int [][] arr;
        // int [] f;
        // int [] v;
        // int [] row;
        // int [] col;
        // int [][] tag;
        // int m, n, mn;
        // Node[] a;
        // Node[] b;
        // Node [] c;
        // public int[][] matrixRankTransform(int [][] ma) {
        //     m = ma.length;
        //     n = ma[0].length; mn = m * n;
        //     rowRank = new int [m][n];
        //     colRank = new int [m][n];
        //     arr = new int [m][n];
        //     f = new int [mn];
        //     v = new int [mn];
        //     row = new int [m];
        //     col = new int [n];
        //     tag = new int [m][n];
        //     a = new Node[mn];
        //     b = new Node[n];
        //     c = new Node[m];
        //     int p = 0, pp = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++)
        //             a[p++] = new Node(i, j, ma[i][j]);
        //     Arrays.sort(a, (x, y)->x.v - y.v); // 按值升序排列
        //     for (int i = 0; i < p; i++) {
        //         tag[a[i].i][a[i].j] = i;    // 新的rank数组
        //         f[i] = i;
        //     }
        //     for (int i = 0; i < m; i++) {   // 遍历行
        //         pp = 0;
        //         for (int j = 0; j < n; j++) // 遍历列
        //             b[pp++] = new Node(i, j, ma[i][j]);
        //         Arrays.sort(b, (x, y)->x.v - y.v);
        //         for (int j = 1; j < pp; j++) {
        //             if (b[j].v != b[j-1].v) continue;
        //             else {
        //                 int rx = find(tag[i][b[j-1].j]);
        //                 int ry = find(tag[i][b[j].j]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     for (int i = 0; i < n; i++) { // 遍历列
        //         pp = 0;
        //         for (int j = 0; j < m; j++) // 遍历行
        //             c[pp++] = new Node(j, i, ma[j][i]);
        //         Arrays.sort(c, (x,y)->x.v - y.v);
        //         for (int j = 1; j < pp; j++) {
        //             if (c[j].v != c[j-1].v) continue;
        //             else {
        //                 int rx = find(tag[c[j-1].i][i]);
        //                 int ry = find(tag[c[j].i][i]);
        //                 f[rx] = ry;
        //             }
        //         }
        //     }
        //     int bgn = 0;
        //     for (int i = 0; i < p; i++) {
        //         int rank = Math.max(row[a[i].i], col[a[i].j]) + 1;
        //         int ff = find(i);
        //         if (v[ff] < rank) v[ff] = rank;
        //         if (i == p-1 || a[i+1].v != a[i].v) {
        //             for (int j = bgn; j <= i; j++) {
        //                 int xx = v[find(j)];
        //                 rowRank[a[j].i][a[j].j] = xx;
        //                 row[a[j].i] = xx;
        //                 col[a[j].j] = xx;
        //             }
        //             bgn = i + 1;
        //         }
        //     }
        //     int [][] ans = new int [m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             ans[i][j] = rowRank[i][j];
        //     return ans;
        // }
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
        // public class Node {
        //     int i;
        //     int j;
        //     int v;
        //     Node() {}
        //     Node(int x, int y, int val) {
        //         this.i = x;
        //         this.j = y;
        //         this.v = val;
        //     }
        // }
        // public class UnionFind {
        //     int [] par;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         par = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) 
        //             par[i] = i;
        //     }
        //     public int find(int val) {
        //         while (val != par[val]) {
        //             par[val] = par[par[val]];
        //             val = par[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) 
        //             swap(rp, rq);
        //         par[rq] = rp;
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

        // Map<Integer, List<Integer>> idx; // idx 存储数组出现元素种类 以及该元素下标索引
        // Node root; // 线段树的根节点
        // int key = 0, cnt = 0; // key 所查找的区域众数; count 所查找的区域众数出现次数, 
        // public MajorityChecker(int[] a) {
        //     idx = new HashMap<>(); // idx 存储数组出现元素种类 以及该元素下标索引
        //     for (int i = 0; i < a.length; i++)
        //         idx.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     root = buildTree(a, 0, a.length-1);
        // }
        // public int query(int left, int right, int threshold) {
        //     key = 0; cnt = 0; // 初始化 所查询众数key 及辅助判断的计数cnt
        //     searchTree(root, left, right); // 查询线段树
        //     // 如果查询区域没有众数 即key没被更改; 或者,
        //     // 所查询出来的众数 在原数组中根本没有超出阈值的能力
        //     if (key == 0 || idx.get(key).size() < threshold) return -1;
        //     // 上确界 排序数组中 第一个大于right的下标
        //     int r = upper_bound(idx.get(key), right);
        //     // 下确界 排序数组中 第一个大于等于left的下标
        //     int l = lower_bound(idx.get(key), left);
        //     cnt = r - l;
        //     return cnt >= threshold ? key : -1;
        // }
        // int upper_bound(List<Integer> list, int v) { // 排序数组中 第一个大于tar的下标
        //     int l = 0, r = list.size();
        //     while (l < r) {
        //         int mid = l + (r - l) / 2;
        //         if (list.get(mid) <= v) l = mid + 1;
        //         else r = mid;
        //     }
        //     return l;
        // }
        // int lower_bound(List<Integer> list, int v) { // 排序数组中 第一个大于等于tar的下标
        //     int l = 0, r = list.size();
        //     while (l < r) {
        //         int mid = l + (r - l) / 2;
        //         if (list.get(mid) < v) l = mid+1;
        //         else r = mid;
        //     }
        //     return l;
        // }
        // void searchTree(Node root, int l, int r) {
        //     if (root == null || l > r) return ;
        //     if (root.l > r || root.r < l) return ;
        //     if (root.l >= l && root.r <= r) { // 当查询边界被节点边界覆盖，该节点就是查询区域
        //         if (key == root.v) cnt += root.cnt;
        //         else if (cnt <= root.cnt) {
        //             key = root.v;
        //             cnt = root.cnt - cnt;
        //         } else cnt = cnt - root.cnt;
        //         return ;
        //     }
        //     int mid = (root.l + root.r) / 2; // 这两个查询条件再好好想想 ！！！！！！！！！！！！！！！
        //     if (l <= mid)   // root.l <= l <= mid 左节点也可以是查询区域
        //         searchTree(root.left, l, r);
        //     if (r >= mid+1) // mid+1 <= r <= root.r 右节点也可以是查询区域
        //         searchTree(root.right, l, r);
        // }
        // Node buildTree(int [] a, int l, int r) {
        //     if (l > r) return null;
        //     Node root = new Node(l, r); // 初始一个线段树的根节点
        //     if (l == r) { // 叶子节点  
        //         root.v = a[l];
        //         root.cnt = 1;
        //         return root;
        //     }
        //     int mid = (l + r) / 2;
        //     root.left = buildTree(a, l, mid);
        //     root.right = buildTree(a, mid+1, r);
        //     makeRoot(root); // 整合父节点
        //     return root;
        // }
        // void makeRoot(Node r) { // 整合父节点
        //     if (r == null) return ;
        //     if (r.left != null) { // 如果该节点有左子节点 该节点的值"先"等于左子节点
        //         r.v = r.left.v;
        //         r.cnt = r.left.cnt;
        //     }
        //     if (r.right != null) { // 如果该节点还有右子节点 融合父节点和子节点
        //         if (r.v == r.right.v)
        //             r.cnt = r.cnt + r.right.cnt;
        //         else {
        //             if (r.cnt >= r.right.cnt)
        //                 r.cnt = r.cnt - r.right.cnt;
        //             else {
        //                 r.v = r.right.v;
        //                 r.cnt = r.right.cnt - r.cnt;
        //             }
        //         }
        //     }
        // }
        // class Node {
        //     int l, r, v, cnt;
        //     Node left, right;
        //     public Node(int l, int r) {
        //         this.l = l; this.r = r;
        //         v = 0; cnt = 0;
        //         left = null; right = null;
        //     }
        // }
        
        // Stack<ArrayDeque<Integer>> ss; // BUG: 不知道哪里写错了，改天再回来看这个
        // TreeSet<Integer> si = new TreeSet<>(); // 这里记的是除了最后一个外，所有不满的deque下标编号
        // int capacity;
        // public DinnerPlates(int capacity) {
        //     // public hdsix(int capacity) {
        //     this.capacity = capacity;
        //     ss = new Stack<>();
        // }
        // public void push(int val) {
        //     if (si.size() != 0) {
        //         int idx = si.iterator().next();
        //         ss.get(idx).offerLast(val);
        //         if (ss.get(idx).size() == capacity)
        //             si.remove(idx);
        //     } else {
        //         if (ss.isEmpty() || ss.peek().size() == capacity) {
        //             ss.add(new ArrayDeque<>());
        //             ss.peek().offerLast(val);
        //         } else ss.peek().offerLast(val);
        //     }
        // }
        // public int pop() {
        //     if (!ss.isEmpty()) {
        //         // while (!ss.isEmpty() && ss.peek().isEmpty()) {
        //         //     si.remove(ss.size()-1);
        //         //     ss.pop();
        //         // }
        //         int top = ss.peek().pollLast();
        //         while (!ss.isEmpty() && ss.peek().isEmpty()) {
        //             si.remove(ss.size()-1);
        //             ss.pop();
        //         }
        //         return top;
        //     }
        //     return -1;
        // }
        // public int popAtStack(int idx) {
        //     if (idx >= ss.size() || ss.get(idx).size() == 0) return -1;
        //     if (idx == ss.size()-1)
        //         return ss.peek().pollLast();
        //         // return ss.get(idx).pollLast();
        //     si.add(idx); // ?
        //     return ss.get(idx).pollLast();
        // }

        // public int minPushBox(char [][] g) { // BUG: TLE 这次写，思路变简洁了，但解这个题应该还需要再简化一下思路
        //     m = g.length;
        //     n = g[0].length;
        //     tar = new int [2];
        //     int bi = -1, bj = -1, pi = -1, pj = -1; // box player
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (g[i][j] == 'B') { // B
        //                 bi = i; bj = j;
        //                 g[i][j] = '.';
        //             } else if (g[i][j] == 'S') { // S
        //                 pi = i; pj = j;
        //                 g[i][j] = '.';
        //             } else if (g[i][j] == 'T') {
        //                 tar[0] = i; tar[1] = j;
        //             }
        //     boolean [][][][] vis = new boolean [m][n][m][n];
        //     boolean [][] vd = new boolean [m][n];
        //     Deque<int []> q = new ArrayDeque<>();
        //     for (int [] d : dirs) {
        //         int i = bi + d[0], j = bj + d[1];
        //         if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] == '#') continue;
        //         if (dfs(pi, pj, i, j, bi, bj, vd, g)) {
        //             q.offerLast(new int [] {bi, bj, i, j});
        //             vis[bi][bj][i][j] = true;
        //         }
        //     }
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [] cur = q.pollFirst();
        //             int i = cur[0], j = cur[1], x = cur[2], y = cur[3];
        //             for (int [] d : dirs) { // 这里面可能会有大量的重复计算，导致速度变慢
        //                 int a = i + d[0], b = j + d[1]; // 箱子 现状态下的 目标位置
        //                 if (a < 0 || a >= m || b < 0 || b >= n || g[a][b] == '#') continue;
        //                 int c = i - d[0], e = j - d[1]; // 人 现状态下 随箱子的目标位置
        //                 if (c < 0 || c >= m || e < 0 || e >= n || g[c][e] == '#') continue;
        //                 if (vis[a][b][c][e]) continue; 
        //                 if (dfs(x, y, c, e, i, j, vd, g)) { // 如果每一个方向上都需要dfs来计算某个位置是否可达，也是速度变慢的主要原因之一
        //                     if (a == tar[0] && b == tar[1]) return cnt + 1;
        //                     q.offerLast(new int [] {a, b, c, e});
        //                     vis[a][b][c][e] = true;
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // int [] tar;
        // boolean dfs(int i, int j, int ti, int tj, int bi, int bj, boolean [][] vis, char [][] a) {
        //     if (i < 0 || i >= m || j < 0 || j >= n || a[i][j] == '#' || vis[i][j]) return false;
        //     if (i == bi && j == bj) return false; // 不能从箱子上过
        //     if (i == ti && j == tj) return true;
        //     vis[i][j] = true;
        //     for (int [] d : dirs) 
        //         if (dfs(i+d[0], j +d[1], ti, tj, bi, bj, vis, a)) {
        //             vis[i][j] = false;
        //             return true;
        //         }
        //     vis[i][j] = false;
        //     return false;
        // }

//         public int shortestPath(int[][] a, int k) {
//             int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//             int m = a.length, n = a[0].length;
//             int [][] vis = new int [m][n]; 
//             Deque<int []> q = new ArrayDeque<>();
//             q.offerLast(new int [] {0, 0, k});
//             int cnt = 0;
//             while (!q.isEmpty()) {
//                 for (int z = q.size()-1; z >= 0; z--) {
//                     int [] cur = q.pollFirst();
//                     if (cur[0] == m-1 && cur[1] == n-1) return cnt;
//                     for (int [] d : dirs) {
//                         int i = cur[0] + d[0], j = cur[1] + d[1];
//                         if (i >= 0 && i < m && j >= 0 && j < n) {
// // 1.当前格子为非障碍物时，普通路径可以走访问状态为0的格子，走过后，访问状态更新为1
// // 3.当前格子为非障碍物时，普通路径可以走访问状态为2的格子，走过后，访问状态更新为1
//                             if (a[i][j] == 0 && (vis[i][j] == 0 || vis[i][j] == 2 && cur[2] == k)) { // 当前格为非障碍物
//                                 if (vis[i][j] == 0) // 普通路径：可以走状态为0的格子，走过后变为1 or 2
//                                     // 2.当前格子为非障碍物时，穿越路径可以走访问状态为0的格子，走过后，访问状态更新为2 
//                                     vis[i][j] = (cur[2] == k ? 1 : 2);
//                                 else vis[i][j] = 1;
//                                 q.offerLast(new int [] {i, j, cur[2]});
//                                 // 4.当前格子为障碍物时，如果还保有穿越次数，并且该格子的访问状态为0时，所有路径可以通过此处，
//                                 //     通过后，该路径变为穿越路径，并且当前格子访问状态更新为1（更新为2也无所谓）                                
//                             } else if (a[i][j] == 1 && vis[i][j] == 0 && cur[2] > 0) {
//                                 vis[i][j] = 2;
//                                 q.offerLast(new int [] {i, j, cur[2]-1});
//                             }
//                         }
//                     }
//                 }
//                 cnt++;
//             }
//             return -1;
//         }
        // public int shortestPath(int[][] a, int k) { // 这个思路极为简洁，但速度跟上一个方法比，会慢很多
        //     if (a.length <= 1 && a[0].length <= 1) return 0;
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int m = a.length, n = a[0].length;
        //     boolean [][][] vis = new boolean [m][n][k+1];
        //     Deque<int []> q = new ArrayDeque<>();
        //     q.offerLast(new int [] {0, 0, 0}); // 前两个数代表坐标，最后一个数代表已经移除了多少个障碍物
        //     vis[0][0][0] = true;
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int [] cur = q.pollFirst();
        //             for (int [] d : dirs) {
        //                 int i = cur[0] + d[0], j = cur[1] + d[1], x = -1;
        //                 if (i < 0 || i >= m || j < 0 || j >= n) continue;
        //                 x = cur[2] + a[i][j];
        //                 if (k >= x && !vis[i][j][x]) {
        //                     if (i == a.length-1 && j == a[0].length-1) return cnt+1;
        //                     q.offerLast(new int [] {i, j, x});
        //                     vis[i][j][x] = true;
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }

        // public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        //     boolean [] hasKey = new boolean[status.length];
        //     Queue<Integer> q = new LinkedList<>();
        //     for (int box : initialBoxes) q.add(box);
        //     int res = 0;
        //     while (q.size() > 0) {
        //         int size = q.size();
        //         boolean isValid = false;
        //         int cur = 0; // cur box
        //         while (size-- > 0) {
        //             cur = q.poll();
        //             if (status[cur] == 1 || hasKey[cur]) {
        //                 res += candies[cur];
        //                 for (int k : keys[cur]) 
        //                     hasKey[k] = true;
        //                 for (int box : containedBoxes[cur]) 
        //                     q.add(box);
        //                 isValid = true;
        //             } else {
        //                 q.add(cur); // 当前盒子打不开时，将盒子重新加回到Queue中
        //             }
        //         }
        //         if (!isValid) break;
        //     }
        //     return res;
        // }
        // // public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // public int maxCandies(int[] s, int[] c, int[][] key, int[][] box, int[] ini) { // bfs
        //     int n = s.length, ans = 0;
        //     boolean [] hasKey = new boolean [n];
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     for (int v : ini) q.offerLast(v);
        //     while (!q.isEmpty()) {
        //         boolean valid = false;
        //         for (int z = q.size()-1; z >= 0; z--) {
        //             int cur = q.pollFirst();
        //             if (s[cur] == 1 || hasKey[cur]) {
        //                 ans += c[cur];
        //                 for (int k : key[cur]) hasKey[k] = true;
        //                 for (int b : box[cur]) q.offerLast(b);
        //                 valid = true;
        //             } else q.add(cur); // 盒子打不开，再把它放回去重新轮巡
        //         }
        //         if (!valid) break;
        //     }
        //     return ans;
        // }

        // public boolean isTransformable(String ss, String t) { 
        //     char [] s = ss.toCharArray();
        //     ArrayDeque<Integer> [] q = new ArrayDeque[10];
        //     for (int i = 0; i < 10; i++)
        //         q[i] = new ArrayDeque<>();
        //     for (int i = 0; i < ss.length(); i++) 
        //         q[s[i]-'0'].offerLast(i);
        //     for (char c : t.toCharArray()) {
        //         int i = c - '0';
        //         if (q[i].isEmpty()) return false;
        //         for (int j = 0; j < i; j++) 
        //             if (!q[j].isEmpty() && q[j].peekFirst() < q[i].peekFirst())
        //                 return false;
        //         q[i].pollFirst();
        //     }
        //     return true;
        // }

        // public int[] maximizeXor(int [] a, int [][] q) {
        //     int n = a.length, m = q.length, j = 0;
        //     Arrays.sort(a);
        //     List<int []> li = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         li.add(new int [] {i, q[i][0], q[i][1]}); // i, xi, mi, needs a[j] <= mi
        //     Collections.sort(li, (x, y)->x[2] - y[2]);
        //     int [] ans = new int [m];
        //     // Arrays.fill(ans, -1); //
        //     Trie t = new Trie();
        //     for (int i = 0; i < m; i++) {
        //         int [] cur = li.get(i);
        //         if (j == 0 && cur[2] < a[j]) continue;
        //         while (j < n && a[j] <= cur[2]) t.insert(a[j++]);
        //         ans[cur[0]] = t.search(cur[1]);
        //     }
        //     return ans;
        // }
        // class Trie {
        //     Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     // public int getMaxXORWithVal(int v) { // bug bug
        //     //     Node r = root;
        //     //     return getMaxXORWithValRecursive(v, r, 31);
        //     // }
        //     // int getMaxXORWithValRecursive(int v, Node r, int i) {
        //     //     if (i < 0) return 0;
        //     //     int j = -1, ans = 0;
        //     //     if (r == null || r.next == null) return 0;
        //     //     int curV = ((1 << i) & v) > 0 ? 1 : 0; // v 在当前位上的取值： 1 or 0
        //     //     if (r.next == null) return curV;
        //     //     if (curV == 1) { 
        //     //         if (r.next[0] != null)
        //     //             ans = (1 << i) | getMaxXORWithValRecursive(v, r.next[0], i-1);
        //     //         else if (r.next[1] != null)
        //     //             ans = getMaxXORWithValRecursive(v, r.next[1], i-1);
        //     //     } else { // curV = 0
        //     //         if (r.next[1] != null)
        //     //             ans = (1 << i) | getMaxXORWithValRecursive(v, r.next[0], i-1);
        //     //         else if (r.next[0] != null)
        //     //             ans = getMaxXORWithValRecursive(v, r.next[0], i-1);
        //     //     }
        //     //     return ans;
        //     // }
        //     public int search(int v) {
        //         int ans = 0;
        //         Node r = root;
        //         for (int i = 31; i >= 0; i--) {
        //             int j = (v >> i) & 1;
        //             if (r == null) return -1;
        //             if (r.next[j ^ 1] != null) {
        //                 ans |= 1 << i;
        //                 r = r.next[j ^ 1];
        //             } else r = r.next[j & 1];
        //         }
        //         return ans;
        //     }
        //     public void insert(int v) {
        //         Node r = root;
        //         for (int i = 31; i >= 0; i--) {
        //             int j = (v >> i) & 1;
        //             if (r.next[j] == null)
        //                 r.next[j] = new Node();
        //             r = r.next[j];
        //         }
        //     }
        //     class Node {
        //         Node [] next;
        //         public Node() {
        //             next = new Node[2];
        //         }
        //     }
        // }

        public int makeStringSorted(String s) {
        
        }
     }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {5, 2, 4, 6, 6, 3};
        int [][] b = new int [][] {{12,4},{8,1},{6,3}};

        int [] r = s.maximizeXor(a, b);
        System.out.println(Arrays.toString(r));
    }
}

// char [][] a = new char [][] {{'.','.','#','.','.','.','.','#'},{'.','B','.','.','.','.','.','#'},{'.','.','S','.','.','.','.','.'},{'.','#','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','T','.','.','.','.'},{'.','.','.','.','.','.','.','#'},{'.','#','.','.','.','.','.','.'}}// hdsix s = new hdsix(2);
// s.push(373);
// s.push(86);
// s.push(395);
// s.push(306);
// s.push(370);
// s.push(94);
// s.push(41);
// s.push(17);
// s.push(387);
// s.push(403);
// s.push(66);
// s.push(82);
// s.push(27);
// s.push(335);
// s.push(252);
// s.push(6);
// s.push(269);
// s.push(231);
// s.push(35);
// s.push(346);
// // s.push(1);
// // s.push(2);
// // s.push(3);
// // s.push(4);
// // s.push(7);
// int r = s.popAtStack(4);
// int r1 = s.popAtStack(6);
// int r2 = s.popAtStack(2);
// int r3 = s.popAtStack(5);
// int r4 = s.popAtStack(2);
// int r5 = s.popAtStack(2);
// int r6 = s.popAtStack(7);
// int r7 = s.popAtStack(9);
// int r8 = s.popAtStack(8);
// int r9 = s.popAtStack(1);
