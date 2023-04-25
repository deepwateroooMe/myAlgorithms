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

public class dpfour {
    public static class Solution {

// // 【主要是长整型溢出之类的细节】：这个题的细节，比我想像得要再多一点儿，改天上午再写一下。。。 // TODO TODO TODO: 1977 157/257
//         public int numberOfCombinations(String t) { 
//             n = t.length(); s = t.toCharArray();
//             if (n == 1) return s[0] == '0' ? 0 : 1;
//             return dfs(0, 0);
//         }
//         static final int mod = (int)1e9 + 7;
//         char [] s;
//         int n;
//         Map<String, Integer> m = new HashMap<>(); // 它可能还要记一下前面的数字是多少？如果这样，数据过于离散，是需要用字典的
//         int dfs(int i, long j) { // 【繁琐深搜：】这个记忆化深搜，的难点在， Integer.MAX_VALUE 待特殊数字的处理，狠繁琐，改天再写。。。
//             if (i == n) return 1;
//             String key = i + "-" + j;
//             if (m.containsKey(key)) return m.get(key);
//             if (i < n && s[i] == '0') { // 以【0】打头, 不合法，直接返回
//                 m.put(key, 0);
//                 return 0;
//             }
//             long r = 0, v = 0;
//             int k = i;
//             for (k = i; k < n; k++) {
//                 // if (v > (Long.MAX_VALUE - (s[k] - '0')) / 10l) break;
//                 v = v * 10 + (s[k] - '0');
//                 if (v >= j) r = (r + dfs(k+1, v)) % mod;
//             }
//             if (k < n) r = (r + dfs(k, v)) % mod;
//             m.put(key, (int)r);
//             return (int)r;
//         }

//         // 【内存溢出：】Memory Limit Exceeded 71/83 这里的意思就是说， max 取值过大，而实际存在的元素少，就成了为一个数据的离散化处理
//         // 线段树数据【离散化处理】：意思是说，分布过散的数据，重样集中集合到【0,n-1】下标，不取实际的值了，而用相对集中的下标代替 // TODO TODO TODO: 这里还有点儿没想透彻。。。
//         public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值【这个题仍然成了学习题】
//             int n = a.length, m = Arrays.stream(a).max().getAsInt()+1, ans = 1;
//             System.out.println("m: " + m); // 当 m 取到 100001 的时候，就会内存溢出，感觉卡到边界了，也只是稍微的内存占用增大一点儿而已
//             t = new int [4 * m]; // 不是说，线段树？下标是从 1 开始的吗？最大值 m 元素在哪里 
//             int [][] f = new int [n][m]; // 第二维表达的是以当前数 a[i] 为结尾的最长合法子序列长度，所以取最值
//             for (int i = 0; i < n; i++) { // 注意【0】下标更新线段树。。。
//                 int v = a[i];
//                 f[i][v] = 1;
//                 // 这里要找：前所有 i 个数【0,i-1】中，以【v-k,v-1】结尾的最大值，最大长度，
// // 这里我是在想要遍历，总复杂度为【O(N^2)】，线段树可以做到【O(NlogN)】线段树中的第一维就给消除掉，只累加更新【0,maxVal+1】范围内的最大值
//                 // for (int j = Math.max(0, v - k); j < v; j++) // 因为线段树区间求最大值：这里就不用遍历，一次【 O(logN)】查询就可以了
//                     // f[i][v] = Math.max(f[i][v], f[i-1][j] + 1); // 【分不清：哪个 i?】
//                 f[i][v] = Math.max(f[i][v], getMax(0, 0, m-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
//                 // f[i][v] = Math.max(f[i][v], getMax(0, 0, n-1, v-k, v-1, t) + 1); // 查询线段树【v-k,v-1】区间最大值：下标1 开始，左闭右闭区间
//                 update(0, 0, m-1, v, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
//                 // update(0, 0, n-1, i, f[i][v], t); // 更新线段树单点元素： v 下标值为 f[i][v]
//                 // ans = Math.max(ans, f[i][v]);
//             }
//             System.out.println(Arrays.toString(t));
//             return t[0];
//         }
//         int [] t;
//         void update(int u, int l, int r, int idx, int v, int [] t) { // 我这里参考别人的奇葩写法，写得自己稀里糊涂的。。。重写一遍
//             if (l == r) {
//                 t[u] = v;
//                 return ;
//             }
//             int m = l + (r - l) / 2;
//             if (idx <= m) update(u << 1 | 1, l, m, idx, v, t);
//             else update((u << 1) + 2, m+1, r, idx, v, t);
//             t[u] = Math.max(t[u << 1 | 1], t[(u << 1) + 2]); // 最大值线段树：根节点最大值，取左右子节点最大值 
//         }
//         int getMax(int u, int l, int r, int L, int R, int [] t) { // 【 l,r】：现存线段树的有效区间跨度；【L,R】：查询区间跨度
//             if (R < l || r < L) return 0;
//             if (L <= l && r <= R) return t[u];
//             int m = l + (r - l) / 2;
//             int ll = getMax(u << 1 | 1, l, m, L, R, t);
//             int rr = getMax((u << 1) + 2, m+1, r, L, R, t);
//             return Math.max(ll, rr);
//         }
//         public int lengthOfLIS(int[] a, int k) {  // 动规：＋线段树来找前 f【i】【v-k】范围内的最大值【这个题仍然成了学习题】
//             int n = a.length, m = Arrays.stream(a).max().getAsInt();
//             t = new int [4 * m]; // 线段树？下标是从 1 开始的吗？
//             for (int v : a) {
//                 System.out.println("\n v: " + v);
//                 if (v == 1) update(1, 1, m, 1, 1);
//                 else {
//                     int res = 1 + query(1, 1, m, Math.max(1, v-k), v-1);
//                     System.out.println("res: " + res);
//                     update(1, 1, m, v, res);
//                }
//                 System.out.println(Arrays.toString(t));
//             }
//             System.out.println(Arrays.toString(t));
//             return t[1];
//         }
//         int [] t; // 线段树：最大值线段树，下标从1 开始的标准写法
//         void update(int u, int l, int r, int i, int v) { // 更新下标为 i 元素的值为 v, 从 u 节点开始遍历
//             if (l == r) {
//                 t[u] = v;
//                 return ;
//             }
//             int m = l + (r - l) / 2;
//             if (i <= m) update(u << 1, l, m, i, v);
//             else update(u << 1 | 1, m+1, r, i, v); // 【左右节点的下标：】 U 《 1 | 1 
//             t[u] = Math.max(t[u << 1], t[u << 1 | 1]); // 根节点最大值：取左右节点的最大值 
//         }
// // 查询【L,R】范围内的最大值，线段树的跨越区间为【l,r】. L 和 R 在整个递归过程中均不变，将其大写，视作常量
//         int query(int u, int l, int r, int L, int R) { // 返回区间 [L,R] 内的最大值
//             if (L <= l && r <= R) return t[u];
//             int m = l + (r - l) / 2, leftMax = 0, rightMax = 0;
//             if (L <= m) leftMax = query(u << 1, l, m, L, R);
//             if (m+1 <= R) rightMax = query(u << 1 | 1, m+1, r, L, R);
//             return Math.max(leftMax, rightMax);
//         }

        // static final int mod = (int)1e9 + 7; // TODO TODO TODO: 太繁琐了，写得没有意思。。。改天再写 639
        // public int numDecodings(String t) {
        //     n = t.length();
        //     s = t.toCharArray();
        //     f = new Integer [n];
        //     return dfs(0);
        // }
        // char [] s;
        // int n;
        // Integer [] f;
        // int dfs(int i) {
        //     // if (i == n) return 1;
        //     if (s[i] == '0') return f[i] = 0; // 主要是防：哪里自己写漏了，没处理好这个逻辑
        //     if (i == n-1) {
        //         if (s[i] == '*') return f[i] = 9;
        //         else if (s[i] == '0') return f[i] = 0;
        //         else return f[i] = s[i] - '0';
        //     }
        //     if (i == n-2) {
        //         int j = s[i] - '0';
        //         if (s[n-1] == '*' || s[n-1] == '0') {
        //             if (s[n-1] == '0') {
        //                 if (s[i] == '*') return f[i] = 2;
        //                 else if (s[i] -'0' > 0 && s[i] - '0' <= 2) return f[i] = 1;
        //                 else return f[i] = 0;
        //             } else if (s[n-1] == '*') { // 
        //                 if (j >= 3) return f[i] = dfs(i+1); // 9
        //                 else if (j == 1) return f[i] = dfs(i+1) * 2;
        //                 else if (j == 2) return f[i] = dfs(i+1) + 6;
        //                 else if (s[i] == '*') return f[i] = 96; // 不知道这个是怎么数来的。。。
        //             }
        //         } else if (s[i] == '*') {
        //             if (s[i+1] == '*') return f[i] = 96; // 不知道这个是怎么数来的。。。
        //             else if (s[i+1] - '0' == 0) return f[i] = 2;
        //             else if (s[i+1] - '0' <= 6 && s[i+1] - '0' > 0) return f[i] = 11;
        //             else if (s[i+1] - '0' <= 9 && s[i+1] - '0' > 6) return f[i] = 9;
        //         }
        //     }
        //     if (f[i] != null) return f[i];
        //     long r = 0;
        //     int j = s[i] - '0';
        //     if (s[i+1] == '0') {
        //         if (s[i] == '*') return f[i] = 2 * dfs(i+2);
        //         else if (s[i] -'0' > 0 && s[i] - '0' <= 2) return f[i] = dfs(i+2);
        //         else return f[i] = 0; // 【3456789-0】【00】
        //     } else if (s[i+1] == '*') { // '*' 如果当前位是 0 呢
        //         if (j >= 3 && j <= 9) return f[i] = dfs(i+1);
        //         else if (j == 1) return f[i] = dfs(i+1) * 2;
        //         else if (j == 2) return f[i] = dfs(i+1) + 6 * dfs(i+2);
        //         else if (j == 0) return f[i] = dfs(i+1); // "*' 打头
        //     } else if (i == 0 && s[i] == '*') { // s[i] [12...9]
        //         if (s[i+1] == '0') return f[i] = 2 * dfs(i+2);
        //         else if (s[i+1] == '*') return f[i] = 2 * dfs(i+2);
                
        //     } else if (j > 0 && j <= 9) { // s[i] [12...9]
        //         if (j == 2 && s[i+1] - '0' <= 6 && s[i+1] -'0' > 0) {
        //             // r = (r + 2 * dfs(i+2)) % mod;
        //             r = (r + dfs(i+1)) % mod; // 当前位单独处理
        //             r = (r + dfs(i+2)) % mod; // 当前位，与后一位一起（20,27)
        //         } else if (j == 1 && s[i+1] - '0' <= 9 && s[i+1] -'0' >= 0) {
        //             r = (r + dfs(i+2)) % mod; // 两位当一个处理 
        //             if (s[i+1] - '0' > 0)
        //                 r = (r + dfs(i+1)) % mod;
        //         }
        //     }
        //     return f[i] = (int)r;
        // }

        // public int minNumberOfSemesters(int n, int[][] a, int k) { // 动规写法
        //     int [] p = new int [n], f = new int [n+1];
        //     for (int [] e : a) p[e[1]-1] |= (1 << (e[0] - 1));
        //     Arrays.fill(f, n);
        //     f[0] = 0;
        //     for (int i = 0; i < (1 << n); i++) {
        //         // 【筛选出所有备选课程：】
        //         int max = 0; 
        //         for (int x = 0; x < n; x++) 
        //             // if (r[x]== 0 && ((i >> x) & 1) == 0) // 当前课：【( 没有其它必选课要求，或是有且全选过了 )可选，还没有选过】
        //             if (((i >> x) & 1) == 0 && (p[x] == 0  || (i & p[x]) == p[x])) // 当前课：【还没有选过, 可以选】: 所有必须的前提课都选过了。。。
        //                 max |= (1 << x);
        //         // 【先写个蠢笨的遍历方法】
        //         for (int j = max; j > 0 && Integer.bitCount(j) <= k && ((max & j) == j); j--) {
        //         }
        //     }
        // }
//         public int minNumberOfSemesters(int n, int[][] a, int k) { // // TLE TLE TLE: 
//             this.n = n; this.k = k; min = n;
//             if (a.length == 0) return n / k + (n % k > 0 ? 1 : 0);
//             for (int [] e : a) {
//                 int u = e[0]-1, v = e[1]-1;
//                 m.put(v, m.getOrDefault(v, 0) | (1 << u));
//             }
//             backTracking(0, 0);
//             return min;
//         }
//         Map<Integer, Integer> m = new HashMap<>(); // 每门课的选课前提
//         int n, k, min;
//         void backTracking(int i, int j) { // i: 已经选过课的mask, j: 用到的学期数
//             if (j >= min) return ;  // 剪枝
//             if (Integer.bitCount(i) == n) {
//                 min = Math.min(min, j);
//                 return ;
//             }
//             int max = 0; 
//             for (int x = 0; x < n; x++) 
//                // if (r[x]== 0 && ((i >> x) & 1) == 0) // 当前课：【( 没有其它必选课要求，或是有且全选过了 )可选，还没有选过】
//                 if ((i & (1 << x)) == 0 && (!m.containsKey(x) || (i & m.get(x)) == m.get(x))) // 当前课：【还没有选过, 可以选】: 所有必须的前提课都选过了。。。
//                    max |= (1 << x);
//            int bitCnts = Integer.bitCount(max);
// // 【遍历 max-bit 位的所有的子集：】这里用了个奇招：对一个 bit-mask, 怎么去掉一个 bit 位，并取到当前数的所有可能的 bit 位子集的？？？忘光了。。。【这个深搜方向写不到】用个动规也该会写呀。。。
//            // for (int x = max; x > 0; x--) {
//            //     if (Integer.bitCount(x) > k || ((max & x) != x)) continue; // 【BUGLLY CODING】
//            for (int x = max; x > 0; x = ((x-1) & max)) {
//                if (Integer.bitCount(x) > k) continue; // 【BUGLLY CODING】
//                int y = i | x;
//                backTracking(y, j+1);
//            }
//         }
        // public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //     int[] pre = new int[n];
        //     for(int[] relation:relations){
        //         //1. 因为点编号是1到n,所以对应于0到n-1的数组，映射位置应为 i-1
        //         //2. 使用状压代表课程先修
        //         pre[relation[1]-1]|=1<<(relation[0]-1);
        //     }
        
        //     int max = 1 << n;
        //     int [] dp = new int[max];
        //     Arrays.fill(dp,n);
        //     dp[0]=0;
        //     //3. 枚举学习课程的已经学习情况
        //     for(int learned = 0; learned < max; learned++){
        //         //4. 枚举当前学习情况，后续可学习的可能情况
        //         int waitStudy = 0;
        //         for(int i = 0; i < n; i++){
        //             if((pre[i]&learned)==pre[i])
        //                 waitStudy |= 1 << i;
        //         }
        //         //细节1. 枚举可学课程需要排除已学课程
        //         waitStudy = waitStudy & (~learned);
        //         //5. 枚举当前1的位置的子集（包含自身），然后用 当前课程= (当前课程-1)&所有可学课程,这种方式，循环找到所有课程枚举子集
        //         for(int learnTerm = waitStudy; learnTerm>0; learnTerm = (learnTerm-1)&waitStudy){
        //             //细节2. 枚举选择的本轮课程需要排除掉一轮学习可能超过最大目标课程的情况
        //             if(Integer.bitCount(learnTerm)>k)
        //                 continue;
        //             dp[learned|learnTerm] = Math.min(dp[learned|learnTerm],dp[learned]+1);
        //         }
        //     }
        //     return dp[max-1];
        // }

        // // 早上从最难往最简单写，下午傍晚从最简单往最难写，哈哈哈哈哈
        // public boolean divisorGame(int n) {
        //     this.n = n;
        //     f = new Boolean [n+1][2];
        //     return dfs(n, 0);
        // }
        // Boolean [][] f;
        // int n;
        // boolean dfs(int i, int j) {
        //     if (i == 1) return f[i][j%2] = (j % 2 == 0 ? false : true);
        //     if (f[i][j%2] != null) return f[i][j%2];
        //     boolean fst = j % 2 == 0;
        //     for (int k = 1; k < i; k++) {
        //         if (i % k != 0) continue;
        //         if (fst && dfs(i - k, j+1)) return f[i][j%2] = true;
        //         else if (!fst && !dfs(i - k, j+1)) return f[i][j%2] = false;
        //     }
        //     return f[i][j%2] = fst ? false : true;
        // }

        // public boolean canMouseWin(String[] a, int catLen, int mouseLen) { // 【返回的是：小老鼠赢了吗？】159/179 // TODO TODO TODO: 
        //     this.catLen = catLen;
        //     this.mouseLen = mouseLen;
        //     m = a.length;
        //     n = a[0].length(); N = m * n;
        //     s = new char [m][n];
        //     for (int i = 0; i < m; i++) s[i] = a[i].toCharArray();
        //     f = new Boolean [N][N][2];
        //     int mi = 0, mj = 0, ci = 0, cj = 0, fi = 0, fj = 0;
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             if (s[i][j] == 'C') {
        //                 ci = i; cj = j;
        //             } else if (s[i][j] == 'M') {
        //                 mi = i; mj = j;
        //             } else if (s[i][j] == 'F') {
        //                 fi = i; fj = j;
        //             }
        //     fd = fi * n + fj;
        //     return dfs(mi * n + mj, ci * n + cj, 0);
        // }
        // Boolean [][][] f;
        // int m, n, fd, N, mouseLen, catLen;
        // char [][] s;
        // boolean dfs(int ii, int jj, int k) { // 【想不明白：】哪里写错了。。。
        //     boolean mouseTurn = (k % 2 == 0);
        //     int len = (mouseTurn ? mouseLen : catLen);
        //     int i = 0, j = 0;
        //     if (mouseTurn) { i = ii / n; j = ii % n; }
        //     else { i = jj / n; j = jj % n; }
        //     if (k >= 2000) return !mouseTurn;
        //     if (f[ii][jj][k%2] != null) return f[ii][jj][k%2];
        //     if (ii == jj) return f[ii][jj][k%2] = false;
        //     if (s[i][j] == 'F') return f[ii][jj][k%2] = mouseTurn;
        //     for (int x = j-1; x >= Math.max(0, j - len); x--) { // 向左
        //         if (s[i][x] == '#') break;
        //         if (i * n + x == fd) return f[ii][jj][k%2] = mouseTurn;
        //         if (mouseTurn && i * n + x == jj) continue; // 这就是从猫头上跳过了呀。。。
        //         else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k%2] = false;
        //         if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k%2] = mouseTurn;
        //     }
        //     for (int x = j+1; x <= Math.min(n-1, j + len); x++) { // 向右
        //         if (s[i][x] == '#') break;
        //         if (i * n + x == fd) return f[ii][jj][k%2] = mouseTurn; 
        //         if (mouseTurn && i * n + x == jj) continue;
        //         else if (!mouseTurn && i * n + x == ii) return f[ii][jj][k%2] = false;
        //         if (mouseTurn && dfs(i * n + x, jj, k+1) || !mouseTurn && !dfs(ii, i * n + x, k+1)) return f[ii][jj][k%2] = mouseTurn;
        //     }
        //     for (int x = i-1; x >= Math.max(0, i - len); x--) { // 向上
        //         if (s[x][j] == '#') break;
        //         if (x * n + j == fd) return f[ii][jj][k%2] = mouseTurn;
        //         if (mouseTurn && x * n + j == jj) continue;
        //         else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k%2] = false;
        //         if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k%2] = mouseTurn;
        //     }
        //     for (int x = i+1; x <= Math.min(m-1, i + len); x++) { // 向下
        //         if (s[x][j] == '#') break;
        //         if (x * n + j == fd) return f[ii][jj][k%2] = mouseTurn;
        //         if (mouseTurn && x * n + j == jj) continue;
        //         else if (!mouseTurn && x * n + j == ii) return f[ii][jj][k%2] = false;
        //         if (mouseTurn && dfs(x * n + j, jj, k+1) || !mouseTurn && !dfs(ii, x * n + j, k+1)) return f[ii][jj][k%2] = mouseTurn;
        //     }
        //     if (mouseTurn && dfs(ii, jj, k+1) || !mouseTurn && !(dfs(ii, jj, k+1))) // 【原地不动】
        //         return f[ii][jj][k%2] = mouseTurn;
        //     return f[ii][jj][k%2] = !mouseTurn;
        // }

        // public int getMaximumGenerated(int n) { // 鬼知道这个题说的是什么意思。。。。。
        //     if (n < 2) return n == 1 ? 1 : 0;
        //     int [] f = new int [n+1];
        //     f[1] = 1;
        //     for (int i = 1; i <= n/2; i++) {
        //         System.out.println("i: " + i);
        //         f[2 * i] = f[i];
        //         System.out.println(Arrays.toString(f));
        //     }
        //     for (int i = 1; i <= (n - 1) / 2; i++) {
        //         System.out.println("i: " + i);
        //         f[2 * i + 1] = f[i] + f[i+1];
        //         System.out.println(Arrays.toString(f));
        //     }
        //     System.out.println(Arrays.toString(f));
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // Map<Integer, List<TreeNode>> m = new HashMap<>(); // 【记忆化】
        // public List<TreeNode> allPossibleFBT(int n) { // 用昨天晚上的回塑：可是是怎么生成的呢？
        //     List<TreeNode> ans = new ArrayList<>();
        //     if (m.containsKey(n)) return m.get(n);
        //     if (n == 1) {
        //         ans.add(new TreeNode(0));
        //         return ans;
        //     } else if (n % 2 == 1) {
        //         for (int i = 0; i < n; i++) {
        //             int y = n-1 - i;
        //             for (TreeNode l : allPossibleFBT(i))
        //                 for (TreeNode r : allPossibleFBT(n-1-i)) {
        //                     TreeNode root = new TreeNode(0);
        //                     root.left = l;
        //                     root.right = r;
        //                     ans.add(root);
        //                 }
        //         }
        //         m.put(n, ans);
        //     }
        //     return ans;
        // }

        // public int minimumDeleteSum(String ss, String tt) {
        //     m = ss.length(); n = tt.length();
        //     s = ss.toCharArray(); t = tt.toCharArray();
        //     f = new Integer [m][n];
        //     return dfs(0, 0);
        // }
        // int m, n;
        // char [] s, t;
        // Integer [][] f;
        // int dfs(int i, int j) {
        //     if (i == m || j == n) {
        //         if (i == m && j == n) return 0;
        //         int r = 0, k = j;
        //         if (i == m) {
        //             k = j;
        //             while (k < n) r += t[k++];
        //         } else {
        //             k = i;
        //             while (k < m) r += s[k++];
        //        }
        //         return r;
        //     }
        //     if (f[i][j] != null) return f[i][j];
        //     if (s[i] == t[j]) return f[i][j] = dfs(i+1, j+1);
        //     return f[i][j] = Math.min(s[i] + dfs(i+1, j), t[j] + dfs(i, j+1));
        // }        
        
        // public int change(int v, int[] a) {
        //     this.a = a; n = a.length;
        //     Arrays.sort(a);
        //     f = new Integer [n][v+1];
        //     return dfs(n-1, v);
        // }
        // Integer [][] f;
        // int [] a;
        // int n;
        // int dfs(int i, int j) {
        //     if (j == 0 && i >= 0) return 1;
        //     if (i < 0) return (j > 0 ? 0 : 1);
        //     if (f[i][j] != null) return f[i][j];
        //     if (a[i] > j) return f[i][j] = dfs(i-1, j);
        //     int r = dfs(i-1, j), k = j;
        //     while (k - a[i] >= 0) {
        //         r += dfs(i-1, k - a[i]);
        //         k -= a[i];
        //     }
        //     return f[i][j] = r;
        // }        

    //     public int longestStrChain(String[] a) { // TODO: 这里要找的是同一个词的一连串的桥接下来，不能两三个混搭，想想怎么写
    //         int n = 16, m = a.length, max = 0, min = n;
    //         int [] f = new int [n];
    //         Arrays.fill(f, 1);
    //         Set<String> [] s = new HashSet[n];
    //         Arrays.setAll(s, z -> new HashSet<>());
    //         for (String v : a) {
    //             int i = v.length();
    //             max = Math.max(max, i);
    //             min = Math.min(min, i);
    //             s[i].add(v);
    //         }
    //         for (int i = n-1; i >= 0; i--)  {
    //             System.out.println("i: " + i);
    //             System.out.println(Arrays.toString(new ArrayList<>(s[i]).toArray()));
    //         }
    //         for (int i = max; i >= min+1; i--) 
    //             for (String v : s[i]) 
    //                 for (int j = 0; j < i; j++) {
    //                     String cur = (j == 0 ? "" : v.substring(0, j)) + (j == i-1 ? "" : v.substring(j+1, i));
    //                     if (s[i-1].contains(cur)) f[i-1] = Math.max(f[i-1], f[i] + 1);
    //                 }
    //         System.out.println(Arrays.toString(f));
    //         return Arrays.stream(f).max().getAsInt();
    //     }
    //     String [] a = new String [] {"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
    // i: 10
    // [zczpzfvdhx]
    // i: 9
    // [zczpzvdhx]
    // i: 8
    // [zczpzvhx]
    // i: 7
    // [ksqvsyq, grukkmj, zczpzvh]
    // i: 6
    // [zcpzvh, ksqvsq, grukmj]
    // i: 5
    // [zczvh, grukj, ksqsq]
    // i: 4
    // [gruj, kssq, czvh]
    // i: 3
    // [kss, gru]
    // i: 2
    // [ks, gr]
    // i: 1
    // []
    // i: 0
    // []
    // [1, 1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1]

       //  public long getDescentPeriods(int[] a) {
       //      int n = a.length, i = 0, j = 0;
       //      long r = 0;
       //      while (i < n) {
       //          while (i < n-1 && a[i] - a[i+1] == 1) i++;
       //          int len = i - j + (i == n ? 0 : 1);
       //          r += getSum(len);
       //          if (i == n) return r;
       //          i += 1;
       //          j = i;
       //      }
       //      return r;
       //  }
       // long getSum(int v) {
       //      if (v == 1) return 1l;
       //      return (long)v * ((long)v + 1l) / 2l;
       //  }

        // public int rotatedDigits(int n) {
        //     r = new int [10];
        //     r[2] = 5; r[5] = 2; r[6] = 9; r[9] = 6; r[1] = 1; r[8] = 8;
        //     int ans = 0;
        //     for (int i = 2; i <= n; i++) {
        //         String cur = String.valueOf(i);
        //         if (cur.indexOf('3') != -1 || cur.indexOf('4') != -1 || cur.indexOf('7') != -1) continue;
        //         int v = getRotated(cur);
        //         if (i == v) continue;
        //         ans++;
        //     }
        //     return ans;
        // }
        // int [] r;
        // int getRotated(String t) {
        //     int n = t.length(); char [] s = t.toCharArray();
        //     int cur = 0;
        //     for (int i = 0; i < n; i++)
        //         cur = cur * 10 + r[s[i] - '0'];
        //     return cur;
        // }

        // public double largestSumOfAverages(int[] a, int k) {
        //     this.a = a; n = a.length;
        //     r = new int [n+1];
        //     for (int i = 0; i < n; i++) r[i+1] = r[i] + a[i];
        //     System.out.println(Arrays.toString(r));
        //     f = new Double [n][k+1];
        //     return dfs(0, k);
        // }
        // int n; int [] a, r;
        // Double [][] f;
        // double dfs(int i, int j) { // 这里是最多分成 j 片
        //     if (i == n) return 0;
        //     if (j == 1) return f[i][j] = (double)(r[n] - r[i]) / (n - i);
        //     if (f[i][j] != null) return f[i][j];
        //     double ans = (double)((r[n]  - r[i])/ n);
        //     for (int k = 1; k < j; k++) 
        //         for (int x = i+1; x <= n-k; x++) 
        //             ans = Math.max(ans, (double)(r[x] - r[i]) / (x - i) + dfs(x, k));
        //     return f[i][j] = ans;
        // }

        // public double knightProbability(int n, int k, int row, int column) {
        //     if (k == 0) return 1; this.n = n;
        //     f = new Double [n][n][k+1];
        //     return dfs(row, column, k);
        // }
        // int [][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1},
        //                  {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        // Double [][][] f;
        // int n;
        // double dfs(int i, int j, int k) {
        //     if (k == 1) {
        //         int cnt = 0;
        //         for (int [] d : dirs) {
        //             int x = i + d[0], y = j + d[1];
        //             if (x < 0 || x >= n || y < 0 || y >= n) continue;
        //             cnt++;
        //         }
        //         return f[i][j][k] = (double)(cnt / 8.0);
        //     }
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     int cnt = 0; double p = 0d;
        //     for (int [] d : dirs) {
        //         int x = i + d[0], y = j + d[1];
        //         if (x < 0 || x >= n || y < 0 || y >= n) continue;
        //         cnt++;
        //         p += (1.0 / 8.0) * dfs(x, y, k-1);
        //     }
        //     return f[i][j][k] = p;
        // }

        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // public int maxDistance(int[][] a) {
        //     int n = a.length, max = 0;
        //     Deque<int []> q = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) 
        //             if (a[i][j] == 1) q.offerFirst(new int [] {i, j, 0});
        //     if (q.isEmpty() || q.size() == n * n) return -1;
        //     boolean [][] v = new boolean [n][n];
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.pollLast();
        //             int i = cur[0], j = cur[1], k = cur[2];
        //             max = Math.max(max, k);
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= n || y < 0 || y >= n || a[x][y] == 1 || v[x][y]) continue;
        //                 v[x][y] = true;
        //                 q.offerFirst(new int [] {x, y, k + Math.abs(x - i) + Math.abs(y - j)});
        //             }
        //         }
        //     }
        //     return max;
        // }

        // public int longestSubsequence(int[] a, int dif) { // TLE TLE TLE: 34/39 O(N^2) 可能还需要一点儿特殊处理与优化 
        //     int n = a.length, f [] = new int [n], max = 1;
        //     Arrays.fill(f, 1);
        //     for (int i = 1; i < n; i++) {
        //         int v = a[i];
        //         for (int j = i-1; j >= 0; j--) {
        //             if (a[i] - a[j] == dif) {
        //                 f[i] = Math.max(f[i], f[j] + 1);
        //                 break;
        //             } else if (a[i] == a[j])
        //                 f[i] = Math.max(f[i], f[j]);
        //         }
        //         max = Math.max(max, f[i]);
        //     }
        //     return max;
        // }

        // // public int bestTeamScore(int[] a, int[] b) { // TLE TLE TLE: 131/149 记忆化深搜会，TLE 
        // //     n = a.length;
        // //     for (int i = 0; i < n; i++)
        // //         l.add(new int [] {b[i], a[i]});
        // //     Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        // //     return dfs(0, 0);
        // // }
        // // List<int []> l = new ArrayList<>();
        // // int n;
        // // Map<String, Integer> m = new HashMap<>();
        // // int dfs(int i, int j) {
        // //     if (i == n) return 0;
        // //     String k = i + "-" + j;
        // //     if (m.containsKey(k)) return m.get(k);
        // //     int [] r = l.get(i);
        // //     if (j > 0 && r[1] < j) {
        // //         int v = dfs(i+1, j);
        // //         m.put(k, v);
        // //         return v;
        // //     }
        // //     int ans = r[1] + dfs(i+1, r[1]);
        // //     int v = Math.max(ans, dfs(i+1, j));
        // //     m.put(k, v);
        // //     return v;
        // // }        
        // public int bestTeamScore(int[] a, int[] b) { // 动规就不会。。。
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {b[i], a[i]});
        //     Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) f[i] = l.get(i)[1];
        //     for (int i = n-2; i >= 0; i--) {
        //         int u = l.get(i)[1];
        //         for (int j = i+1; j < n; j++) {
        //             int v = l.get(j)[1];
        //             if (u <= v) {
        //                 f[i] = Math.max(f[i], f[j] + u);
        //                 // break; // 【BUG:】会舍掉最优解，不能加
        //             }
        //         }
        //     }
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // public int maxSumDivThree(int[] a) { // TODO TODO TODO: 
        //     this.a = a; n = a.length; m = 3;
        //     f = new Integer [n][3];
        //     return dfs(0, 0);
        // }
        // Integer [][] f;
        // int [] a;
        // int n, m;
        // int dfs(int i, int j) {
        //     if (i == n) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     if (i == n-1) return (a[i] % m == j ? a[i] : 0);
        //     int curMod = a[i] % m;
        //     int r = a[i] + dfs(i+1, (curMod == j ? 0 : (j == 1 ? ))); // 这里的逻辑仍然是疯的。。。1262
        //     r = Math.max(r, (curMod == j ? a[i] : 0) + dfs(i+1, 0));
        //     return f[i][j] = r;
        // }

        // public int videoStitching(int[][] a, int t) {
        //     int n = a.length;
        //     int [][] f = new int [n][t+1];
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     if (a[0][0] > 0 || a[n-1][1] < t) return -1;
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, Integer.MAX_VALUE));
        //     f[0][a[0][1]] = 1;
        //     for (int i = 1; i < n; i++) {
        //         int u = a[i][0], v = a[i][1];
        //         for (int j = i-1; j >= 0; j--) {
        //             int x = a[j][0], y = a[j][1];
        //             if (y < u) return -1;
        //             f[i][v] = Math.min(f[i][v], f[j][y] + 1);
        //         }
        //     }
        // }

        // public int eraseOverlapIntervals(int[][] a) {
        //     int n = a.length;
        //     Arrays.sort(a, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1);
        //     for (int i = 1; i < n; i++) {
        //         int u = a[i][0], v = a[i][1];
        //         for (int j = i-1; j >= 0; j--) {
        //             int x = a[j][0], y = a[j][1];
        //             if (u >= y) {
        //                 f[i] = Math.max(f[i], f[j] + 1);
        //                 break;
        //             }
        //         }
        //     }
        //     return n - Arrays.stream(f).max().getAsInt();
        // }

        // public int minOperations(int n) { // 不对，把过程想得太简单了点儿。。。 // TODO TODO TODO: 
        //     return Math.min(Integer.bitCount(n), 1 + Integer.bitCount(~n));
        // }

        // public int minSideJumps(int[] a) {
        //     n = a.length; this.a = a;
        //     f = new Integer [n][4];
        //     return dfs(0, 2, false);
        // }
        // int n; int [] a;
        // Integer [][] f;
        // int dfs(int i, int j, boolean vis) {
        //     System.out.println("\n i: " + i);
        //     System.out.println("j: " + j);
        //     if (i == n) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     if (a[i] == j) return f[i][j] = Integer.MAX_VALUE / 2;
        //     int r = Integer.MAX_VALUE / 2;
        //     if (a[i] == 0 && !vis) {
        //         for (int k = 1; k <= 3; k++)
        //             if (k == j)
        //                 r = Math.min(r, dfs(i+1, j, false));
        //             else if (k != j && !vis)
        //                 r = Math.min(r, dfs(i, k, true));
        //     } else {
        //         for (int k = 1; k <= 3; k++) {
        //             if (a[i] == k) continue;
        //             if (j == k)
        //                 r = Math.min(r, dfs(i+1, j, false));
        //             else if (j != k && !vis)
        //                 r = Math.min(r, dfs(i, k, true));
        //         }
        //     }
        //     return f[i][j] = r;
        // }

        // public List<Integer> goodDaysToRobBank(int[] a, int t) {
        //     int n = a.length;
        //     int [] l = new int [n], r = new int [n];
        //     for (int i = 1; i < n; i++) 
        //         if (a[i-1] >= a[i]) l[i] = l[i-1] + 1;
        //     for (int i = n-2; i >= 0; i--)
        //         if (a[i] <= a[i+1]) r[i] = r[i+1] + 1;
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = t; i + t < n; i++)             
        //         if (l[i] >= t && r[i] >= t) ans.add(i);
        //     return ans;
        // }

        // public int orderOfLargestPlusSign(int n, int[][] b) {
        //     int [][] a = new int [n][n];
        //     Arrays.stream(a).forEach(z -> Arrays.fill(z, 1));
        //     for (int [] v : b) a[v[0]][v[1]] = 0;
        //     if (n == 1) return a[0][0];
        //     int [][] l = new int [n+1][n+1], r = new int [n+1][n+1], u = new int [n+1][n+1], d = new int [n+1][n+1];
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++)
        //             if (a[i][j] == 1) l[i+1][j+1] = l[i+1][j] + 1;
        //         for (int j = n-1; j >= 0; j--)
        //             if (a[i][j] == 1) r[i+1][j] = r[i+1][j+1] + 1;
        //     }
        //     for (int j = 0; j < n; j++) {
        //         for (int i = 0; i < n; i++)
        //             if (a[i][j] == 1) u[i+1][j+1] = u[i][j+1] + 1;
        //         for (int i = n-1; i >= 0; i--)
        //             if (a[i][j] == 1) d[i][j+1] = d[i+1][j+1] + 1;
        //     }
        //     int max = (n * n > b.length ? 1 : 0);
        //     for (int i = 0; i < n-1; i++)
        //         for (int j = 0; j < n-1; j++) {
        //             if (a[i][j] == 1) {
        //                 int minLR = Math.min(l[i+1][j+1], r[i+1][j]);
        //                 int minUD = Math.min(u[i+1][j+1], d[i][j+1]);
        //                 max = Math.max(max, Math.min(minLR, minUD));
        //             }
        //         }
        //     return max;
        // }

        // public int lenLongestFibSubseq(int[] a) {
        //     int n = a.length, max = 0, cnt = 0; this.a = a;
        //     if (n == 3) return a[0] + a[1] == a[2] ? 3 : 0;
        //     for (int i = 1; i < n; i++) {
        //         for (int j = i-1; j >= 0; j--) {
        //             int x = i, y = j;
        //             int u = a[y], v = a[x];
        //             cnt = 2;
        //             int idx = binarySearch(x+1, n-1, u + v);
        //             while (idx != -1 && idx <= n-1) {
        //                 cnt++;
        //                 u = v; v = a[idx];
        //                 if (idx == n-1) break;
        //                 idx = binarySearch(idx+1, n-1, u + v);
        //             }
        //             max = Math.max(max, cnt);
        //         }
        //     }
        //     return max >= 3 ? max : 0;
        // }
        // int [] a;
        // int binarySearch(int l, int r, int v) {
        //     if (l > r) return -1;
        //     if (v < a[l] || v > a[r]) return -1;
        //     while (l < r) {
        //         int m = (l + r) >> 1;
        //         if (a[m] >= v) r = m;
        //         else l = m+1;
        //     }
        //     return (l <= r && a[l] == v) ? l : -1;
        // }

        // public int closestCost(int[] a, int[] b, int t) {
        //     n = a.length; m = b.length; this.t = t; this.a = a; this.b = b;
        //     Arrays.sort(a); Arrays.sort(b);
        //     for (int i = n-1; i >= 0; i--) 
        //         backTracking(m-1, a[i]);
        //     return val;
        // }
        // int [] a, b;
        // int m, n, t, min = Integer.MAX_VALUE, val = 0;
        // void backTracking(int i, int cur) {
        //     int v = Math.abs(cur - t);
        //     if (v > min && cur > t) return;
        //     if (v == 0) {
        //         min = 0;
        //         val = cur;
        //         return ;
        //     }
        //     if (v == min && min > 0) val = Math.min(val, cur);
        //     else if (v < min) {
        //         min = v;
        //         val = cur;
        //         if (min == 0) return;
        //     }
        //     if (i < 0) return;
        //     if (cur < t) {
        //         backTracking(i-1, cur + b[i] * 2);
        //         backTracking(i-1, cur + b[i]);
        //         backTracking(i-1, cur);
        //     }
        // }

        // public int maxTurbulenceSize(int [] a) {
        //     int n = a.length;
        //     if (n < 3) return n < 2 || a[0] != a[1] ? n : 1;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1); f[1] = (a[1] == a[0] ? 1 : 2);
        //     for (int i = 2; i < n; i++) {
        //         if (a[i-2] < a[i-1] && a[i-1] > a[i] || a[i-2] > a[i-1] && a[i-1] < a[i])
        //             f[i] = f[i-1] + 1;
        //         else if (a[i] != a[i-1]) f[i] = Math.max(f[i], 2);
        //     }
        //     return Arrays.stream(f).max().getAsInt();
        // }

        // static final int mod = (int)1e9 + 7;
        // public int countTexts(String t) {
        //     n = t.length(); s = t.toCharArray();
        //     f = new Integer [n];
        //     r = new int [10];
        //     for (int i = 2; i < 7; i++) r[i] = 3;
        //     r[8] = 3; r[7] = 4; r[9] = 4;
        //     return dfs(0);
        // }
        // Integer [] f;
        // char [] s;
        // int n, r [];
        // int dfs(int i) {
        //     if (i == n) return 1;
        //     if (f[i] != null) return f[i];
        //     if (i == n-1) return f[i] = 1;
        //     long ans = 0;
        //     int j = i+1;
        //     while (j < n && j < i+r[s[i]-'0'] && s[j] == s[i]) j++;
        //     for (int k = i; k < j; k++) 
        //         ans = (ans + dfs(k+1)) % mod;
        //     return f[i] = (int)ans;
        // }

        // public int findMaxForm(String[] sa, int m, int n) { // TODO : 换种方法来写，真不敢想，我几天是用回塑来写这个题的。。。
        //     for (String s : sa) 
        //         if (valid(s, m+n, n)) ll.add(s);
        //     Collections.sort(ll, (x, y) -> x.length() - y.length());
        //     // min = 0;
        //     // backTracking(0, m, n, 0); // TLE TLE TLE:
        //     int min = 0;
        //     // int [] f = new int [ll.size()];
        //     for (int i = 0; i < ll.size(); i++)
        //         return min;
        // }
        // Map<String, int []> ms = new HashMap<>(); // 【0-cnt, 1-cnt】
        // List<String> ll = new ArrayList<>();
        // int min;
        // void backTracking(int idx, int zero, int one, int len) {
        //     if (min > 0 && ll.size() - idx + len < min) return;
        //     if (idx == ll.size()) {
        //         if (len > min) 
        //             min = len;
        //         return ;
        //     }
        //     int [] cur = ms.get(ll.get(idx));
        //     if (cur[0] <= zero && cur[1] <= one)
        //         backTracking(idx+1, zero - cur[0], one - cur[1], len+1);
        //     backTracking(idx+1, zero, one, len);
        // }        
        // boolean valid(String t, int l, int n) { // n 1s
        //     int m = t.length(), cnt = 0;
        //     if (m > l) return false;
        //     char [] s = t.toCharArray();
        //     for (char c : s) cnt += c - '0';
        //     if (cnt <= n) {
        //         ms.put(t, new int [] {m-cnt, cnt});
        //         return true;
        //     }
        //     return false;
        // }
    }
    public static void main (String[] args) { // 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
        Solution s  =  new Solution ();

        String a = "22233";
        System.out.println("a: " + a);

        int r = s.countTexts(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);













