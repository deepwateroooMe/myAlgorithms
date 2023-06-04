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

        // // 不知道所有的 i<j 都能连通是什么意思，但是大概是先转化成一个无向图，再求所有的 i<j
        // // N(10^5) 感觉上面想得太复杂了，能不能直接理解为存在一个公质因子
        // // 走连通图，含公因质子的一个模块里: 好好的思路，被我写成了 TLE...
        // class UnionFind {
        //     private int[] p;
        //     int cnt;
        //     public UnionFind(int size) {
        //         p = new int[size];
        //         cnt = size;
        //         for (int i = 0; i < size; i++) 
        //             p[i] = i;
        //     }
        //     public int find(int x) {
        //         if (p[x] != x) 
        //             p[x] = find(p[x]);
        //         return p[x];
        //     }
        //     public void union(int x, int y) {
        //         int px = find(x), py = find(y);
        //         if (px != py) {
        //             p[px] = py;
        //             --cnt;
        //         }
        //     }
        //     public int getCnt() {// 去拿连通集的个数：我这里数得不对。。。。。【活宝妹就是一定要嫁给亲爱的表哥！！】
        //         return cnt;
        //     }
        // }
        // private UnionFind uf; // 【活宝妹就是一定要嫁给亲爱的表哥！！！】
        // Set<Integer> s = new HashSet<>(); // 出现过的质因子，备案
        // public boolean canTraverseAllPairs(int[] a) {
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), j;
        //     if (n == 1) return true;
        //     // 自己求质数表备案
        //     List<Integer> p = new ArrayList<>();
        //     for (int i = 1; i <= max; i++) 
        //         if (isPrime(i)) p.add(i);
        //     System.out.println("p.size(): " + p.size());
        //     System.out.println(Arrays.toString(p.toArray()));
        //     uf = new UnionFind(p.size());
        //     boolean [] v = new boolean [p.size()];
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         int pre = -1;
        //         for (j = 0; j < p.size(); j++) // 这么写的目的是：把【O(N^2)】转化成【O(N*Contant)】免得超时
        //             if (a[i] % p.get(j) == 0) {
        //                 s.add(j);
        //                 if (pre == -1) pre = j;
        //                 else uf.union(j, pre); // 对同一个数来说，它的质因子要连起来
        //                 if (v[j]) break;
        //                 else v[j] = true;
        //             }
        //         System.out.println("j: " + j);
        //         if (j < p.size()) // 可以与其它的连通: 用这个数把它所有质因子的连通集连接起来
        //             for (int k = 0; k < p.size(); k++) {
        //                 if (k == j) continue;
        //                 if (v[k])
        //                     uf.union(k, j);
        //                 if (!v[k] && a[i] % p.get(k) == 0) v[k] = true;
        //             }
        //         System.out.println(Arrays.toString(v));
        //         System.out.println("uf.getCnt(): " + uf.getCnt());
        //     }
        //     // 然后数个数，返回只有一个集，就可以了
        //     // 这里的【BUG：】是： 100000 以内的数，某些质因子可能从来不曾出现过
        //     int cnt = 0;
        //     for (var vis : v) if (vis) cnt++;
        //     System.out.println("cnt: " + cnt);
        //     System.out.println("uf.getCnt(): " + uf.getCnt());
        //     return uf.getCnt() == p.size() - cnt + 1;
        // }
        // boolean isPrime(int x) {
        //     if (x <= 1) return false;
        //     // 判断是否被2~自身数-1范围内的值整除
        //     for (int i = 2; i < x;++i){
        //         if (x%i == 0)
        //             return false;
        //     }
        //     return true;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // public int minimizedStringLength(String s) {
        //     return (int)s.chars().distinct().count();
        // }

        // public int semiOrderedPermutation(int[] a) {
        //     int n = a.length, i = -1, j = -1;
        //     for (int k = 0; k < n; k++) {
        //         if (a[k] == 1) i = k;
        //         else if (a[k] == n) j = k;
        //         if (i != -1 && j != -1) break;
        //     }
        //     return i + n - j - 1 - (i > j ? 1 : 0);
        // }

        // // 这个题说有无数重复，所以过滤掉先前的重复，只保留最多 2m 次调用
        // // 内存溢出：必须动规
        // public long matrixSumQueries(int n, int[][] a) {
        //     int m = a.length;
        //     int [] r = new int [n], c = new int [n];
        //     Arrays.fill(r, -1); Arrays.fill(c, -1);
        //     for (int i = 0; i < m; i++) {
        //         int [] cur = a[i];
        //         if (cur[0] == 0) r[cur[1]] = i;
        //         else c[cur[1]] = i;
        //     }
        //     // // 这里大概不能直接生成数组，而用个什么 DP 的形式来统计结果。。。
        //     // long [][] ans = new long [n][n];
        //     // for (int i = 0; i < m; i++) {
        //     //     int [] cur = a[i];
        //     //     if (cur[0] == 0 && r[cur[1]] == i) 
        //     //         for (int j = 0; j < n; j++) 
        //     //             ans[cur[1]][j] = cur[2];
        //     //     else if (cur[0] == 1 && c[cur[1]] == i)
        //     //         for (int j = 0; j < n; j++)
        //     //             ans[j][cur[1]] = cur[2];
        //     // }
        //     long [] rr = new long [n], cc = new long [n];// 记行和列的和
        //     Arrays.fill(rr, 0); Arrays.fill(cc, 0);
        //     long ans = 0;
        //     for (int k = 0; k < m; k++) {
        //         int [] cur = a[k];
        //         int i = cur[1], j = cur[1];
        //         if (cur[0] == 0 && r[i] == k) {
        //             if (rr[i] == 0) {
        //                 rr[i] = (long)cur[2] * n;
        //                 ans += (long)n * cur[2];
        //             } else {
        //                 ans += (long)n * cur[2] - rr[i];
        //                 rr[i] = (long)cur[2] * n;
        //                 for ( j = 0; j < n; j++) {
        //                     if (c[j] != )
        //                         }
        //             }
        //             r[i] = cur[2]; // 更改这个值可能还会造成其它问题，用另两个数组来纪录
        //             // 那么它可能会带来的列的变化: 暂时不管，反正只算一遍, 感觉这里可能会出错，没考虑列的更新
        //         } else if (cur[0] == 1 && c[j] == k) {
        //             if (cc[j] == 0) {
        //                 cc[j] = (long)n * cur[2];
        //                 ans += cc[j];
        //             } else {
        //                 ans += (long)n * cur[2] - cc[j];
        //                 cc[j] = (long)n * cur[2];
        //             }
        //             c[j] = cur[2];
        //         }
        //     }
        //     // for (int i = 0; i < m; i++) {
        //     //     int [] cur = a[i];
        //     //     if (cur[0] == 0 && r[cur[1]] == i) {
        //     //         if (rr[cur[1]] == 0) {
        //     //             rr[cur[1]] = (long)cur[2] * n;
        //     //             ans += (long)n * cur[2];
        //     //         } else {
        //     //             ans += (long)n * cur[2] - rr[cur[1]];
        //     //             rr[cur[1]] = (long)cur[2] * n;
        //     //             for (int j = 0; j < n; j++) {
        //     //                 if ()
        //     //             }
        //     //         }
        //     //         r[cur[1]] = cur[2];
        //     //         // 那么它可能会带来的列的变化: 暂时不管，反正只算一遍, 感觉这里可能会出错，没考虑列的更新
        //     //     } else if (cur[0] == 1 && c[cur[1]] == i) {
        //     //         if (cc[cur[1]] == 0) {
        //     //             cc[cur[1]] = (long)n * cur[2];
        //     //             ans += cc[cur[1]];
        //     //         } else {
        //     //             ans += (long)n * cur[2] - cc[cur[1]];
        //     //             cc[cur[1]] = (long)n * cur[2];
        //     //         }
        //     //         c[cur[1]] = cur[2];
        //     //     }
        //     // }
        //     return ans / 2;
        // }

        // 这个死题：大概是要按位来生成这些数，因为数量级非常大，数位动规【记忆化深搜】参考 1397 大概需要一两个 boolean 变量来标记是 lo-hi 最后一位什么的
        public int count(String S, String T, int min, int max) {
            m = S.length(); n = T.length(); this.min = min; this.max = max; 
            s = S.toCharArray(); t = T.toCharArray();
            f = new Integer [n]; // 长度为 27－32【活宝妹就是一定要嫁给亲爱的表哥！！！】
            return 
        }
        Integer [] f;
        int m, n, min, max;
        char [] s, t;
        static final int mod = (int)1e9 + 7;
    }             
    public static void main (String[] args) { 
        Solution s = new Solution ();

        int [][] a = new int [][] {{1,1,1},{1,0,7},{0,0,0}};

        long r = s.matrixSumQueries(2, a);
        System.out.println("r: " + r);
    }
}
// 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);