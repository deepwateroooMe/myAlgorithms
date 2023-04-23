import com.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class dpthree {
    public static class Solution {

// // 【 n<= 500, 2^10】【 o<= 50, 2^6】【YN:2^2】【YN:2^2】【可以建一个 20 （10+6+2+2）位的 mask】1397
//         public int findGoodStrings(int n, String S, String T, String E) { // 【哪里没有写对，上下字符的处理，与受限字符的处理，可能不对】// TODO TODO TODO: 
//             this.n = n;
//             m = E.length();
//             s = S.toCharArray();
//             t = T.toCharArray();
//             e = E.toCharArray();
//             return dfs(0, 0, true, true);
//         }
//         Map<Integer, Integer> f = new HashMap<>(); // 动规：记忆化用它，因为2^20=(int)1e6 数据规模有点儿大，但是是离散化的，用字典比较好
//         static final int mod = (int)1e9 + 7;
//         char [] s, t, e;
//         int m, n;
//         int dfs(int i, int j, boolean lo, boolean hi) {
//             if (j == m) return 0; // 是说，包含了 evil 字符串为子串，【不合法】
//             if (i == n) return j < m ? 1 : 0;
//             int key = getKey(i, j, lo, hi);
//             if (f.containsKey(key)) return f.get(key);
//             // 遍历当前下标 i 所有【可能，且合法】的字符选择并深搜：受最小最大限制，且不能出现在不可出现的字符串
//             int x = lo ? s[i] - 'a' : 0;   // 【等于S:】最小字符受限，
//             int y = hi ? t[i] - 'a' : 25; // 【等于T:】最大字符受限
//             // System.out.println("x: " + x);
//             // System.out.println("y: " + y);
//             long r = 0;
//             for (int k = x; k <= y; k++) {
//                 // System.out.println("k: " + k);
//                 r = (r + (long)dfs(i+1, j + (k == e[j] - 'a' ? 1 : 0), lo && k == s[i] - 'a', hi && k == t[i] - 'a')) % mod;
//                 // System.out.println("r: " + r);
//             }
//             f.put(key, (int)r);
//             return (int)r;
//         }
//         int getKey(int i, int j, boolean l, boolean r) {
//             // return ((1 << i) << 10) | ((1 << j) << 4) | ((1 << (l ? 1 : 0)) << 2) | (1 << (r ? 1 : 0));
//             return (1 << i) << 10 | (1 << j) << 4 | (1 << (l ? 1 : 0)) << 2 | 1 << (r ? 1 : 0); // 【没括号】
//         }

        // public int minimumTime(String t) { // 不知道这个题说的是什么意思 // TODO TODO TODO: 
        //     int n = t.length(), l [] = new int [n+1], r [] = new int [n+1], i = 0;
        //     char [] s = t.toCharArray();
        //     System.out.println(Arrays.toString(s));
        //     while (i < n && s[i] == '1' && (i == 0 || s[i-1] == '1')) {
        //         // System.out.println("i: " + i);
        //         l[i+1] = l[i] + 1;
        //         i++;
        //     }
        //     // System.out.println("i: " + i);
        //     for (; i < n; i++)
        //         if (s[i] == '1') l[i+1] = l[i] + 2;
        //         else l[i+1] = l[i];
        //     // System.out.println(Arrays.toString(l));
        //     i = n-1;
        //     while (i >= 0 && s[i] == '1') {
        //         r[i] = r[i+1] + 1;
        //         i--;
        //     }
        //     for (; i >= 0; i--) 
        //         if (s[i] == '1') r[i] = r[i+1] + 2;
        //         else r[i] = r[i+1];
        //     // System.out.println(Arrays.toString(r));
        //     int min = Integer.MAX_VALUE;
        //     for (i = 1; i < n; i++)  // 【 l: 0...n-2】
        //         min = Math.min(min, (l[i] + r[i]));
        //     min = Math.min(min, Math.min(l[n], r[0]));
        //     return min;
        // }

        // public int checkRecord(int n) {
        //     this.n = n;
        //     this.m = 2;
        //     f = new Integer [n][m][m+1]; // 【N, A, L】
        //     return dfs(0, 1, 0);
        // }
        // static final int mod = (int)1e9 + 7;
        // int n, m;
        // Integer [][][] f;
        // int dfs(int i, int j, int k) {
        //     if (j < 0 || k >= 3) return 0;
        //     if (i == n) return j >= 0 && k <= 2 ? 1 : 0;
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     long r = 0;
        //     r = (r + dfs(i+1, j, 0)) % mod; // present
        //     r = (r + dfs(i+1, j-1, 0)) % mod; // absent
        //     if (k <= 1)
        //         r = (r + dfs(i+1, j, k+1)) % mod; // Late for 1 more day
        //     return f[i][j][k] = (int)r;
        // }

        // public int stoneGameV(int[] a) {
        //     n = a.length;
        //     r = new int [n+1];
        //     for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
        //     System.out.println(Arrays.toString(r));
        //     f = new Integer [n][n];
        //     return dfs(0, n-1, a);
        // }
        // Integer [][] f;
        // int n;
        // int [] r;
        // int dfs(int i, int j, int [] a) {
        //     // if (i == j) return f[i][j] = a[i]; // 【BUG:】这里算多了
        //     if (i == j) return f[i][j] = 0;
        //     if (f[i][j] != null) return f[i][j];
        //     int ans = 0;
        //     for (int x = i; x < j; x++) { // 在 x】下标后分两段
        //         int left = r[x+1] - r[i];
        //         int right = r[j+1] - r[x+1];
        //         int min = Math.min(left, right);
        //         if (left != right) 
        //             ans = Math.max(ans, min + (min == left ? dfs(i, x, a) : dfs(x+1, j, a)));
        //         else 
        //             ans = Math.max(ans, min + Math.max(dfs(i, x, a), dfs(x+1, j, a)));
        //     } 
        //     return f[i][j] = ans;
        // }

        // public int maxHappyGroups(int m, int[] a) { // 这个不太好理解，好像带点儿贪心思想在里面。。。 // TODO TODO TODO: 
        //     this.m = m;
        //     n = a.length;
        //     Arrays.sort(a);
        //     backTracking(n-1, 0, new ArrayList<Integer>(), a);
        //     return max;
        // }
        // int n, m, max = 0;
        // void backTracking(int i, int j, List<Integer> l, int [] a) {
        //     if (i < 0) {
        //         if (j > max) max = j;
        //         return ;
        //     }
        // }

        // public int tallestBillboard(int[] a) { // 这里，简单地分左右两半，在原数组有序的情况下，会丢掉最优解，错误答案。。。 // TODO TODO TODO: 
        //     int m = a.length, n = m / 2, max = 0;
        //     TreeSet<Integer> l = new TreeSet<>();
        //     for (int i = 1; i < (1 << n); i++) {
        //         int r = 0;
        //         for (int j = 0; j < n; j++) 
        //             if (((i >> j) & 1) == 1) r += a[j];
        //         l.add(r);
        //     }
        //     for (int i = 1; i < (1 << (m - n)); i++) {
        //         int r = 0;
        //         for (int j = 0; j < m-n; j++) 
        //             if (((i >> j) & 1) == 1)
        //                 r += a[n+j];
        //         if (l.contains(r)) max = Math.max(max, r);
        //     }
        //     return max;
        // }

        // class Node { // TODO TODO TODO: 55/58
        //     int s, ll, rr; // ll: maxLeft, rr: minRight: 主要是用来帮助父节点判断是否是 BST 来用来着。。。
        //     boolean b;
        //     Node l, r;
        //     public Node() {
        //         // l = new Node(); // 栈溢出
        //         // r = new Node();
        //     }
        // }
        // boolean allNeg = true;
        // public int maxSumBST(TreeNode root) {
        //     Node r = new Node();
        //     traversal(root, r);
        //     if (allNeg) return 0;
        //     return getMax(r);
        // }
        // int max = 0;
        // int getMax(Node r) {
        //     if (r == null) return 0;
        //     if (r.b) max = Math.max(max, r.s);
        //     return Math.max(max, Math.max(getMax(r.l), getMax(r.r)));
        // }
        // void traversal(TreeNode r, Node p) {
        //     if (r == null) {
        //         p.b = true;
        //         p = null; // <<<<<<<<<<<<<<<<<<<< 不起效？
        //         return ;
        //     }
        //     // System.out.println("\n r.val: " + r.val);
        //     if (r.val >= 0 && allNeg) allNeg = false;
        //     if (r.left == null && r.right == null) {
        //         p.s = r.val;
        //         p.b = true;
        //         p.ll = p.s; // 【叶子节点：】左右最值，是自己
        //         p.rr = p.s;
        //         return;
        //     }
        //     p.l = new Node();
        //     p.r = new Node();
        //     // p.l.b = true;
        //     // p.r.b = true;
        //     traversal(r.left, p.l);
        //     traversal(r.right, p.r);
        //     // System.out.println("\n r.val: " + r.val);
        //     p.s = p.l.s + p.r.s + r.val; // 左右子树，与父节点和
        //     // p.b = (p.l == null || p.l.b && p.l.ll < r.val) && (p.r == null || p.r.b && r.val < p.r.rr); // BST: 左中右，小大关系
        //     p.b = (p.l.b || p.l.s == 0) && (p.r.b || p.r.s == 0) && (p.l.ll == 0 || p.l.ll < r.val) && (p.r.rr == 0 || r.val < p.r.rr);
        //     // System.out.println("p.b: " + p.b);
        //     // System.out.println("p.s: " + p.s);
        //     p.ll = Math.max(p.l.ll, r.val); // 【这里不要更新到根节点】：
        //     // p.rr = Math.min(Math.min(p.l.ll, p.r.rr), r.val);
        //     p.rr = Math.min(p.r.rr, r.val);
        //     // p.rr = Math.min((p.r.s == 0 ? Integer.MAX_VALUE : p.r.rr), r.val);
        // }

        // public boolean canMouseWin(String[] a, int catLen, int mouseLen) { // 【返回的是：小老鼠赢了吗？】【脑袋写昏了。。。】 // TODO TODO TODO: 
        //     this.catLen = catLen;
        //     this.mouseLen = mouseLen;
        //     m = a.length;
        //     n = a[0].length();
        //     s = new char [m][n];
        //     for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
        //     f = new Boolean [m][n][2];
        //     int mi = 0, mj = 0, ci = 0, cj = 0;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             if (s[i][j] == 'C') {
        //                 ci = i; cj = j;
        //             } else if (s[i][j] == 'M') {
        //                 mi = i; mj = j;
        //             }
        //     return dfs(mi, mj, 0, ci, cj);
        // }
        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // char [][] s;
        // Boolean [][][] f;
        // int m, n, mouseLen, catLen;
        // boolean dfs(int i, int j, int k, int ci, int cj) {// return TRUE ONLY WHEN MOUSE WINDS 老鼠要赢！！！
        //     if (k >= 1000) return k % 2 == 0 ? false : true;
        //     if (f[i][j][k%2] != null) return f[i][j][k%2];
        //     boolean mouseTurn = k % 2 == 0;
        //     if (s[i][j] == 'C' && mouseTurn) return f[i][j][k%2] = true;
        //     if (s[ci][cj] == 'M' && !mouseTurn) return f[ci][cj][k%2] = false;
        //     if (s[i][j] == 'F' && mouseTurn) return f[i][j][k%2] = true;
        //     if (s[ci][cj] == 'F' && !mouseTurn) return f[ci][cj][k%2] = false;
        //     int len = (k % 2 == 0 ? mouseLen : catLen);
        //     // // 向左
        //     // for (int x = j-1; x >= Math.max(0, j - len); x--) {
        //     //     if (s[i][x] == '#') break;
        //     //     if (s[i][x] == 'C' && mouseTurn) continue; // 这里，老鼠想赢，得找到一种可以赢的方法，【原本这里踩着猫，就输了。。。】
        //     //     if (s[i][x] == 'M' && !mouseTurn) return f[i][j][k%2] = false;
        //     //     if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true; 
        //     // }
        //     // // 向右
        //     // for (int x = j+1; x <= Math.min(n-1, j + len); x++) {
        //     //     if (s[i][x] == '#') break;
        //     //     if (s[i][x] == 'C' && mouseTurn) continue; 
        //     //     if (s[i][x] == 'M' && !mouseTurn) return f[i][j][k%2] = false;
        //     //     if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true;
        //     // }
        //     // // 向上
        //     // for (int x = i-1; x >= Math.max(0, i - len); x--) {
        //     //     if (s[i][x] == '#') break;
        //     //     if (s[i][x] == 'C' && mouseTurn) continue; 
        //     //     if (s[i][x] == 'M' && !mouseTurn) return f[i][j][k%2] = false;
        //     //     if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true;
        //     // }
        //     // // 向下
        //     // for (int x = i+1; x < Math.min(m-1, i + len); x++) {
        //     //     if (s[i][x] == '#') break;
        //     //     if (s[i][x] == 'C' && mouseTurn) continue; 
        //     //     if (s[i][x] == 'M' && !mouseTurn) return f[i][j][k%2] = false;
        //     //     if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true;
        //     // }
        //     // return f[i][j][k%2] = false;
        //     if (k % 2 == 0) { // 小老鼠
        //         if (s[i][j] == 'F') return f[i][j][k%2] = true; // 先吃到食物
        //         // 向左
        //         for (int x = j-1; x >= Math.max(0, j - mouseLen); x--) {
        //             if (s[i][x] == '#') break;
        //             if (s[i][x] == 'C') continue; // 这里，老鼠想赢，得找到一种可以赢的方法，【原本这里踩着猫，就输了。。。】
        //             // if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //             if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向右
        //         for (int x = j+1; x <= Math.min(n-1, j + mouseLen); x++) {
        //             if (s[i][x] == '#') break;
        //             if (s[i][x] == 'C') continue; // 这里，老鼠想赢，得找到一种可以赢的方法，【原本这里踩着猫，就输了。。。】
        //             // if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //             if (dfs(i, x, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向上
        //         for (int x = i-1; x >= Math.max(0, i - mouseLen); x--) {
        //             if (s[i][x] == '#') break;
        //             if (s[i][x] == 'C') continue; // 这里，老鼠想赢，得找到一种可以赢的方法，【原本这里踩着猫，就输了。。。】
        //             // if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //             if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向下
        //         for (int x = i+1; x < Math.min(m-1, i + mouseLen); x++) {
        //             if (s[i][x] == '#') break;
        //             if (s[i][x] == 'C') continue; // 这里，老鼠想赢，得找到一种可以赢的方法，【原本这里踩着猫，就输了。。。】
        //             // if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //             if (dfs(x, j, k+1, ci, cj)) return f[i][j][k%2] = true; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         return f[i][j][k%2] = false;
        //     } else { // 猫: 只有老鼠输了，才算是它贏
        //         if (s[ci][cj] == 'F') return f[ci][cj][k%2] = false; // 先吃到食物
        //         // 向左
        //         for (int x = cj-1; x >= Math.max(0, cj - catLen); x--) {
        //             if (s[ci][x] == '#') break;
        //             if (s[ci][x] == 'M') return f[ci][cj][k%2] = false;
        //             if (!dfs(i, j, k, ci, x)) return f[ci][cj][k%2] = false; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向右
        //         for (int x = cj+1; x <= Math.min(n-1, cj + catLen); x++) {
        //             if (s[ci][x] == '#') break;
        //             if (s[ci][x] == 'M') return f[ci][cj][k%2] = false;
        //             if (!dfs(i, j, k, ci, x)) return f[ci][cj][k%2] = false; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向上
        //         for (int x = ci-1; x >= Math.max(0, ci - mouseLen); x--) {
        //             if (s[ci][x] == '#') break;
        //             if (s[ci][x] == 'M') return f[ci][cj][k%2] = false;
        //             if (!dfs(i, j, k, x, cj)) return f[ci][cj][k%2] = false; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         // 向下
        //         for (int x = ci+1; x < Math.min(m-1, ci + catLen); x++) {
        //             if (s[ci][x] == '#') break;
        //             if (s[ci][x] == 'M') return f[ci][cj][k%2] = false;
        //             if (!dfs(i, j, k, x, cj)) return f[ci][cj][k%2] = false; // 【老鼠想要找一种赢法，哪怕一种。。。】
        //         }
        //         return f[ci][cj][k%2] = true;
        //     }
        // }

        // public int maxSum(int[] a, int[] b) { // // TODO TODO TODO: 35/82 1537
        //     int m = a.length, n = b.length, i = 0, j = 0, x = -1, y = -1;
        //     long [] l = new long [m+1], r = new long [n+1];
        //     for ( i = 0; i < m; i++) l[i+1] = l[i] + a[i];
        //     for ( i = 0; i < n; i++) r[i+1] = r[i] + b[i];
        //     // System.out.println(Arrays.toString(l));
        //     // System.out.println(Arrays.toString(r));
        //     Map<Integer, List<Integer>> mi = new HashMap<>();
        //     i = 0; j = 0;
        //     while (i < m && j < n) {
        //         if (a[i] == b[j]) {
        //             mi.put(a[i], List.of(i, j));
        //             i++;
        //             j++;
        //         } else if (a[i] < b[j]) i++;
        //         else j++;
        //     }
        //     // System.out.println("mi.size(): " + mi.size());
        //     // for (Map.Entry<Integer, List<Integer>> en : mi.entrySet()) {
        //     //     System.out.print(en.getKey() + ": ");
        //     //     System.out.println(Arrays.toString(en.getValue().toArray()));
        //     // }
        //     long ans = 0;
        //     i = 0; j = 0;
        //     for (Map.Entry<Integer, List<Integer>> en : mi.entrySet()) {
        //         int k = en.getKey();
        //         List<Integer> li = en.getValue();
        //         if (x == -1 && y == -1) {
        //             x = li.get(0);
        //             y = li.get(1);
        //             ans = Math.max(l[x], r[y]); // 不带公共点
        //         } else {
        //             ans += Math.max(l[li.get(0)] - l[x], r[li.get(1)] - r[y]); // 带一端公共点：带头，不带尾。。。
        //             x = li.get(0);
        //             y = li.get(1);
        //         }
        //     }
        //     if (x != -1 && y != -1)
        //         ans += Math.max(l[m] - l[x], r[n] - r[y]);
        //     else return (int)Math.max(l[m], r[n]);
        //     return (int)ans;
        // }

        // public boolean isScramble(String S, String T) {
        //     if (S.equals(T)) return true;
        //     int m = S.length(), n = T.length();
        //     char [] s = S.toCharArray();
        //     char [] t = T.toCharArray();
        // }

        // static final int mod = (int)1e9 + 7;
        // int [][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
        // public int[] pathsWithMaxScore(List<String> l) {
        //     int m = l.size(), n = l.get(0).length(), i = 0, j = 0;
        //     int [][] f = new int [m][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
        //     f[m-1][n-1] = 0;
        //     long [][] r = new long [m][n];
        //     r[m-1][n-1] = 1;
        //     for (i = m-1; i >= 0; i--) 
        //         for (j = n-1; j >= 0; j--) {
        //             if (f[i][j] == -1) continue;
        //             char c = l.get(i).charAt(j);
        //             if (c == 'X') continue;
        //             if (c == 'S' || c != 'X' || c == 'E') {
        //                 for (int [] d : dirs) {
        //                     int x = i + d[0], y = j + d[1];
        //                     if (x < 0 || y < 0 || l.get(x).charAt(y) == 'X') continue;
        //                     int v = f[i][j] + (Character.isDigit(l.get(x).charAt(y)) ? l.get(x).charAt(y) - '0' : 0);
        //                     if (v > f[x][y]) {
        //                         f[x][y] = v;
        //                         r[x][y] = 1;
        //                     } else if (v == f[x][y])
        //                         r[x][y]++;
        //                     // else
        //                     //     r[x][y] = (r[x][y] + r[i][j]) % mod;
        //                 }
        //             }
        //         }
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     if (i < 0 && j < 0 && f[0][0] != -1) return new int [] {f[0][0], (int)r[0][0]};
        //     else return new int [] {0, 0};
        // }
        // List<String> a = List.of("E11345","X452XX","3X43X4","422812","284522","13422S"); // "E11","XXX","11S"

        // public int maxPalindromes(String t, int k) { // TODO TODO TODO: 
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     boolean [][] f = new boolean [n][n]; // 方便 O[1] 查询是否为回文
        //     for (int i = 0; i < n; i++) f[i][i] = true;
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = i+1; j < n; j++) 
        //             if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1]))
        //                 f[i][j] = true;
        //     int [] dp = new int [n];
        //     for (int i = k-1; i < n; i++) {
        //         if (i == k-1 && f[0][i]) {
        //             dp[i] = 1;
        //             continue;
        //         }
        //         for (int j = 0; j < i; j++) 
        //             if (f[j+1][i] && (i - j - 1 >= k)) dp[i] = Math.max(dp[i], dp[j] + 1);
        //         dp[i] = Math.max(dp[i], dp[i-1]);
        //     }
        //     // System.out.println(Arrays.toString(dp));
        //     return dp[n-1];
        // }

        // public int minimumIncompatibility(int[] a, int k) { // TLE TLE TLE: 优化不够，会超时
        //     n = a.length; m = n / k;
        //     if (n == 1 || n < 2 * k) return 0;
        //     this.k = k;
        //     Arrays.sort(a);
        //     g = new ArrayList [k];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     backTracking(n-1, 0, a);
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }
        // int n, m, k, min = Integer.MAX_VALUE;
        // List<Integer> [] g;
        // void backTracking(int i, int j, int [] a) {
        //     if (i < 0) {
        //         if (j < min) min = j;
        //         return ;
        //     }
        //     for (int x = 0; x < k; x++) {  // 遍历这 k 个桶
        //         // if (x > 0 && g[x].get(0) == g[x-1].get(0)) continue; // 当前桶，与前一个桶差值一样【不一定对】
        //         int s = g[x].size();
        //         if (s > 0 && g[x].get(s-1) == a[i]) continue; // 同一个桶：不能有相同元素
        //         g[x].add(a[i]);
        //         backTracking(i-1, j + (s == 0 ? a[i] : (s == 1 ? -a[i] : g[x].get(s-1) - a[i])), a);
        //         g[x].remove(s);
        //     }
        // }

// // 【记忆化深搜：】什么题用记忆，什么可以不用记忆，看来现在还是傻傻分不清楚。。【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
//         public boolean hasValidPath(char[][] a) {
//             this.a = a;
//             m = a.length;
//             n = a[0].length;
//             f = new Boolean [m][n][m+n];
//             return dfs(0, 0, 0, 0);
//         }
//         int [][] dirs = {{1, 0}, {0, 1}};
//         Boolean [][][] f; 
     
//         char [][] a;
//         int m, n;
//         boolean dfs(int x, int y, int l, int r) {
//             if (x >= m || y >= n) return false;
//             l += a[x][y] == '(' ? 1 : 0;
//             r += a[x][y] == ')' ? 1 : 0;
//             if (r > l) return false;
//             if (f[x][y][l-r] != null) return f[x][y][l-r];
//             if (x == m-1 && y == n-1 && l == r) return f[x][y][0] = true;
//             if (dfs(x+1, y, l, r)) return f[x][y][l-r] = true;
//             return f[x][y][l-r] = dfs(x, y+1, l, r);
//         }

        // public int maximumScore(int[] a, int[] b) { // 【注意记忆化数组降维：】原本用三维会内存溢出，用二维就可以了
        //     this.a = a; this.b = b;
        //     n = a.length; m = b.length;
        //     f = new Integer [n][m];
        //     return dfs(0, 0);
        // }
        // Integer [][] f;
        // int [] a, b;
        // int n, m;
        // int dfs(int i, int j) {
        //     if (j == m) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     return f[i][j] = Math.max(a[i] * b[j] + dfs(i+1, j+1), a[n-(j-i)-1] * b[j] + dfs(i, j+1));
        // }

        // int [][] dirs = {{0, -1}, {-1, 0}}; // 思路可能想错了。。。
        // public int calculateMinimumHP(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     int [][] f = new int [m][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE / 2));
        //     f[m-1][n-1] = a[m-1][n-1];
        //     for (int i = m-1; i >= 0; i--) 
        //         for (int j = n-1; j >= 0; j--) {
        //             if (f[i][j] == Integer.MIN_VALUE / 2) continue;
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || y < 0) continue;
        //                 f[x][y] = Math.max(f[x][y], f[i][j] + a[x][y]);
        //             }
        //         }
        //     return f[0][0] + 1;
        // }

        // public int minAbsDifference(int[] a, int goal) {
        //     n = a.length; m = n / 2; this.a = a;
        //     TreeSet<Integer> l = new TreeSet<>(), r = new TreeSet<>();
        //     backTracking(0, 0, m, l);
        //     backTracking(m, 0, n, r);
        //     int min = Integer.MAX_VALUE;
        //     for (int v : r) {
        //         Integer lo = l.floor(goal - v);
        //         Integer hi = l.ceiling(goal - v);
        //         if (lo != null) min = Math.min(min, Math.abs(lo + v - goal));
        //         if (hi != null) min = Math.min(min, Math.abs(hi + v - goal));
        //     }
        //     return min;
        // }
        // int [] a;
        // int n, m;
        // void backTracking(int i, int j, int end, TreeSet<Integer> l) {
        //     if (i == end) {
        //         l.add(j);
        //         return ;
        //     }
        //     backTracking(i+1, j + a[i], end, l);
        //     backTracking(i+1, j, end, l);
        // }

        // // 不知道怎么写；先走一遍，采最多的走，再走一遍，能采多少采多少？ // TODO TODO TODO: 
        // public int cherryPickup(int[][] a) {
        //     int n = a.length;
        //     int [][] f = new int [n][n];
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MIN_VALUE));
        //     f[0][0] = a[0][0];
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (f[i][j] == Integer.MIN_VALUE) continue;
        //             // 向下
        //             if (j < n-1 && a[i][j+1] != -1) f[i][j+1] = Math.max(f[i][j+1], f[i][j] + a[i][j+1]);
        //             // 向右
        //             if (i < n-1 && a[i+1][j] != -1) f[i+1][j] = Math.max(f[i+1][j], f[i][j] + a[i+1][j]);
        //         }
        //     int ans = f[m-1][n-1];
        //     if (ans == Integer.MIN_VALUE) return 0;
        // }

        // public int squareFreeSubsets(int[] a) { // 这里回到了写动规的 baby 状态。。。
        //     n = a.length;
        //     p = new int [n];
        //     for (int i = 0; i < n; i++) p[i] = getPrimeFactors(a[i]);
        //     System.out.println(Arrays.toString(p));
            
        //     int m = (1 << 10);
        //     f = new Integer [n][m];
        //     return (int)dfs(0, 0, a) - 1;
        // }
        // static final int mod = (int)1e9 + 7;
        // List<Integer> ip = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        // int [] p;
        // Integer [][] f;
        // int n, ans = 0;
        // int dfs(int i, int j, int [] a) { // J: mask
        //     if (i == n) return 1;
        //     if (f[i][j] != null) return f[i][j];
        //     long ans = 0;
        //     if ((j & p[i]) == 0) // 【包含】当前数，因为不存在公因子，乘积就不会产生平方因子
        //         ans = (ans + dfs(i+1, j | p[i], a)) % mod;
        //     // 【不包含】当前数：任何情况下都是可以不包含当前数的
        //     ans = (ans + dfs(i+1, j, a)) % mod;
        //     return f[i][j] = (int)ans;
        // }
        // // 刚才写糊了，是因为，回想一下，最开始不会写动规时，
        // // 不总把动规自顶向下，与记忆化深搜自底向上【向下与向上，一起】写一起写糊吗？【一起不该是前两天，那个树 ZigZag 才向下与向上一起的吗？】
        // // 用动规写起来，应该是最自然的，昨天的青蛙跳，就是单向从头跳到尾，这里两维与一维的本质相同，第一维下标就是单向跳，从头跳到尾，自头向尾更新。。。
        // static final int mod = (int)1e9 + 7; // TODO TODO TODO: 这里还有点儿小问题
        // List<Integer> ip = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        // // int [] p;
        // // Integer [][] f;
        // // int n, ans = 0;
        // public int squareFreeSubsets(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return 1;
        //     int [] p = new int [n];
        //     for (int i = 0; i < n; i++) p[i] = getPrimeFactors(a[i]);
        //     int m = (1 << 10);
        //     int [][] f = new int [n+1][m];
        //     // 【初始化：】感觉有时候弄不清楚，怎么初始化？
        //     for (int i = 0; i < n; i++) f[i+1][0] = 1; // 每个元素单数，都是一个最小的子集
        //     // f[0][0] = 1; // 空集是 1 ？ 
        //     for (int i = 1; i <= n; i++) { // 遍历当前的下标 i
        //         int mask = p[i-1]; // 当前数 a[i] 的质因子掩码
        //         f[i][mask] = (f[i][0] + f[i][mask]) % mod;
        //         for (int j = m-1; j >= mask; j--) { // 遍历所有可能的子集：
        //             if ((j & mask) == mask) // 掩码 j 可以通过添加一个当前元素 a[i], 或是或上当前掩码 mask 得到
        //                 f[i][j] = (f[i][j] + f[i-1][j ^ mask]) % mod; // 添加了由 f[j^mask] 而来的所有可能数
        //         }
        //     }
        //     return (int)(Arrays.stream(f[n]).asLongStream().sum() % mod) - 1;
        // }
        // int getPrimeFactors(int x) {
        //     int r = 0;
        //     for (int i = 0; i < 10; i++) {
        //         int v = ip.get(i);
        //         if (x >= v && x % v == 0) r |= (1 << i);
        //     }
        //     return r;
        // }

        // static final int mod = (int)1e9 + 7; // 1994: 结果的集合是遍历【1 《 10】，但每个合法 mask 的可产生频率仍跟上一题相关。。。
        // List<Integer> ip = List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        // public int numberOfGoodSubsets(int [] a) { // 这个应该不用考虑数组里是否有重得的好数，没意义。。。
        //     int n = a.length;
        //     Set<Integer> [] s = new HashSet [10];
        //     for (int v : a) {
        //         int [] r = getPrimeFactorCnts(v);
        //         if (Arrays.stream(r).max().getAsInt() > 1) continue;
        //         for (int i = 0; i < 10; i++)
        //             if (r[i] > 0) s[i].add()
        //     }
        // }
        // int [] getPrimeFactorCnts(int x) { // 这里仍然可以返回一个 mask
        //     int [] r = new int [10];
        //     for (int i = 0; i < 10; i++) {
        //         int v = ip.get(i);
        //         while (x >= v && x % v == 0) {
        //             r[i]++;
        //             x /= v;
        //         }
        //     }
        //     return r;
        // }

        // public int minCut(String t) { // 最小切割数：那么每个回文子串，尽可能地最长。。。132 // TODO TODO TODO: 
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     boolean [][] f = new boolean [n][n]; // 方便O[1] 查询是否为回文
        //     for (int i = 0; i < n; i++) f[i][i] = true;
        //     for (int i = n-2; i >= 0; i--)
        //         for (int j = i+1; j < n; j++)
        //             if (s[i] == s[j] && (j - i <= 2 || f[i+1][j-1])) f[i][j] = true;
        //     int [][] r = new int [n][n]; // 统计最少切割等: 还是不知道怎么算最长回文。。。
        //     for (int i = 0; i < n; i++) r[0][i] = 1;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //         }
        // }

        // static final int mod = (int)1e9 + 7; // 注意数、计数的原理：生成与撤销的原理
        // public int countPalindromes(String t) {
        //     int n = t.length(), m = 10;
        //     System.out.println("n: " + n);
        //     char [] s = t.toCharArray();
        //     int r [] = new int [m], rr [][] = new int [m][m]; // 这里今天晚上的脑袋有点儿昏，计数的地方不知道计对了没有？二四八四
        //     // 向右向左遍历
        //     for (int i = n-1; i >= 0; i--) {
        //         int j = s[i] - '0';
        //         for (int k = 0; k < m; k++) // 从左向右，【J-Xk】
        //             rr[j][k] += r[k];
        //         r[j]++;
        //     }
        //     long ans = 0;
        //     int l [] = new int [m], ll [][] = new int [m][m];
        //     for (int i = 0; i < n; i++) {
        //         // 右侧更新：撤销所有由当前下标的结果，对后续统计造成的错误影响
        //         int j = s[i] - '0';
        //         --r[j]; // 【撤销：】右边计数，取消所有【当前下标字符】所造成的影响。。。
        //         for (int k = 0; k < m; k++) // 由当前 j 字符所计入的所有必要撤销
        //             rr[j][k] -= r[k];
        //         for (int x = 0; x < m; x++)
        //             for (int y = 0; y < m; y++)
        //                 ans = (ans + (long)ll[x][y] * (long)rr[x][y]) % mod;
        //         // 左侧更新：加入当前下标的结果入后续统计
        //         for (int k = 0; k < m; k++)
        //             ll[j][k] += l[k];
        //         l[j]++;
        //     }
        //     return (int)ans;
        // }

        // static final int mod = (int)1e9 + 7; // TLE TLE TLE: 68/74 
        // public int beautifulPartitions(String t, int k, int minLength) {
        //     n = t.length(); this.minLength = minLength;
        //     if (k * minLength > n) return 0;
        //     s = t.toCharArray();
        //     if (!sc.contains(s[0]) || sc.contains(s[n-1])) return 0;
        //     f = new Integer [n][k+1];
        //     return dfs(0, k);
        // }
        // Set<Character> sc = new HashSet<>(List.of('2', '3', '5', '7'));
        // int n, k, minLength;
        // char [] s;
        // Integer [][] f;
        // int dfs(int i, int j) {
        //     if (j == 1) {
        //         if (i + minLength > n) return f[i][j] = 0; // 最后一段不够长度
        //         return f[i][j] = 1;
        //     }
        //     if (i < n && !sc.contains(s[i])) return f[i][j] = 0; // 不是太质数打头
        //     if (i < n && i + minLength >= n && j > 1) return f[i][j] = 0;
        //     if (f[i][j] != null) return f[i][j];
        //     long r = 0;
        //     for (int k = i+minLength; k < n; k++) 
        //         if (!sc.contains(s[k-1]) && sc.contains(s[k]))
        //             r = (r + dfs(k, j-1)) % mod;
        //     return f[i][j] = (int)r;
        // }
        
        // public int numDecodings(String s) {
        // }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        String a = "23542185131";

        int r = s.beautifulPartitions(a, 3, 2);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);

