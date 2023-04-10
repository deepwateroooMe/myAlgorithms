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

        // public int diagonalPrime(int[][] a) {
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             l.add(new int [] {a[i][j], i, j});
        //     Collections.sort(l, (x, y)-> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]); // 降序排列
        //     for (int [] v : l)
        //         if ((v[1] == v[2] || v[2] == n-1 - v[1]) && isPrime(v[0])) return v[0];
        //     return 0;
        // }
        // public static boolean isPrime(int n) {
        //     if (n < 3) {
        //         if (n == 2) 
        //             return true;
        //         else
        //             return false;
        //     }
        //     for (int i = 2; i < n; i++) 
        //         if (n % i == 0) 
        //             return false;
        //     return true;
        // }

        // // 这里好像还有一个贪心的思想，这个题目知道自己想错后，就没再写了。。。
        // public int minimizeMax(int[] a, int p) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     return a[2*(p-1)+1] - a[2*(p-1)];
        // }

        // public long [] distance(int[] a) { // TLE TLE TLE: 就是想不到平时这类没要求的题目怎么会超时的？ 1066/1068 不知道是哪里错掉了？ 3 个不过
        //     int n = a.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     long [] r = new long [n];
        //     for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
        //         List<Integer> l = en.getValue();
        //         if (l.size() == 1) {
        //             r[l.get(0)] = 0;
        //             continue;
        //         }
        //         long [] s = new long [l.size()]; // 它说这里用 prefix 算。妈的。。。
        //         s[0] = l.get(0);
        //         for (int i = 1; i < l.size(); i++) 
        //             s[i] = s[i-1] + l.get(i);
        //         for (int i = 0; i < l.size(); i++) 
        //             r[l.get(i)] = (long)l.get(i) * (i+1) - s[i] + (s[l.size()-1] - (i == 0 ? 0 : s[i-1])) - l.get(i) * (l.size()-i);
        //     }
        //     return r;
        // }

        // // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
        // // 那么这个题目，就成为血淋淋的教训题：并不是永远两种方向相反的方法都是同等效率的，必要的时候，毕竟，还是要根据 TLE 需要，来改写自己尚写得不够顺手的动态规划的版本。。。
        // public int minimumVisitedCells(int[][] a) { // TLE TLE TLE 已经是记忆化搜索了呀？！！！怎么会超时的呢？
        //     m = a.length;
        //     n = a[0].length;
        //     f = new Integer [m][n];  
        //     for (int i = 0; i < m; i++) // 这里有个可以 stream 一行搞定的写法，忘记了
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     int r = dfs(0, 0, a);
        //     System.out.println("f.length: " + f.length);
        //     for (int z = 0; z < f.length; ++z) 
        //         System.out.println(Arrays.toString(f[z]));
        //     return r == Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // Integer [][] f;
        // int m, n;
        // int dfs(int ii, int jj, int [][] a) { // 记忆化揵从当前坐标到终点的最小步数
        //     // if (ii >= m || jj >= n) return Integer.MAX_VALUE / 2; // 主要是免得溢出
        //     if (ii == m-1 && jj == n-1) return f[ii][jj] = 1;
        //     if (f[ii][jj] < Integer.MAX_VALUE / 2) return f[ii][jj];
        //     int r = Integer.MAX_VALUE / 2;
        //     // for (int j = Math.min(a[ii][jj] + jj, n-1); j > jj; j--) {
        //     int max = Math.min(a[ii][jj] + jj, n-1);
        //     for (int j = max; j > jj; j--) {
        //         int cur = 1 + dfs(ii, j, a);
        //         r = Math.min(r, cur);
        //     }
        //     max = Math.min(a[ii][jj] + ii, m-1);
        //     for (int i = max; i > ii; i--) {
        //         int cur = 1 + dfs(i, jj, a);
        //         r = Math.min(r, cur);
        //     }
        //     return f[ii][jj] = r;
        // }
        // // 我记忆化搜索的方向，与它动态规划的方向是反的。可是两个本来就是反着的。。。
        // // 那么这个题目，就成为血淋淋的教训题：并不是永远两种方向相反的方法都是同等效率的，必要的时候，毕竟，还是要根据 TLE 需要，来改写自己尚写得不够顺手的动态规划的版本。。。
        // // Queue<Integer> q = new PriorityQueue<>(); 感觉确实能再快一点儿
        // public int minimumVisitedCells(int[][] a) { // TODO: TLE TLE TLE 动态规划，要跟上面的记忆化搜索的方向是反着遍历的，就是自顶向下，与自底向上的区别. 另外最后 11 个测试样例不过。。。
        //     int m = a.length, n = a[0].length;
        //     int [][] f = new int [m][n];
        //     Arrays.stream(f).forEach(x -> Arrays.fill(x, Integer.MAX_VALUE / 2));  // 流式处理法
        //     f[0][0] = 1; // 初始化：左上角，只遍历了当前一个格
        //     // 开始遍历：从上到下，一行一行；从左到右，一列一列，计算到达 a[i][j] 的最小访问方格数 f[i][j]
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) { // 计算能够到达当前方格 a[i][j] 的最小访问方格数 f[i][j]
        //             Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // 我想不明白，为什么要分开用两个优先队列？
        //             for (int k = 0; k < j; k++) {
        //                 if (a[i][k] + k < j) continue;
        //                 q.offer(new int [] {f[i][k] + 1, k}); // 这里只统计一步跳过来的
        //             }
        //             for (int k = 0; k < i; k++) {
        //                 if (a[k][j] + k < i) continue;
        //                 q.offer(new int [] {f[k][j] + 1, k});
        //             }
        //             if (!q.isEmpty())
        //                 f[i][j] = q.peek()[0];
        //         }
        //     return f[m-1][n-1] >= Integer.MAX_VALUE / 2 ? -1 : f[m-1][n-1];
        // }
    // BFS: 广度优先搜索: 这一种解法弄通了。。。。。【任何时候，活宝妹就是一定要嫁给亲爱的表哥！！！】
        public int minimumVisitedCells(int[][] a) { // 动态规划，要跟上面的记忆化搜索的方向是反着遍历的，就是自顶向下，与自底向上的区别. 另外最后 11 个测试样例不过。。。
            int m = a.length, n = a[0].length, cnt = 1;
            if (m == 1 && n == 1) return 1;
            Deque<int []> q = new ArrayDeque<>();
            boolean [][] vis = new boolean [m][n];
            q.offerFirst(new int [] {0, 0});
            vis[0][0] = true;
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] r = q.pollLast();
                    int ii = r[0], jj = r[1];
                    // if (ii == m-1 && jj == n-1) return cnt;     // 先行检查结果，每个测试用例省一点儿。。。。。
                    // if (a[ii][jj] == 0 || vis[ii][jj]) continue;// 先行判断，可以省空间，妈呀。。。真过分
                    // vis[ii][jj] = true;
                    // 向右扫描扩展
                    for (int j = jj+1; j <= a[ii][jj] + jj && j < n; j++) {
                        if (ii == m-1 && j == n-1) return cnt+1;
                        if (a[ii][j] != 0 && !vis[ii][j]) {
                            vis[ii][j] = true;
                            q.offerFirst(new int [] {ii, j});
                        }
                    }
                    // 向下扫描扩展
                    for (int i = ii+1; i <= a[ii][jj] + ii && i < m; i++) {
                        if (i == m-1 && jj == n-1) return cnt+1;
                        if (a[i][jj] != 0 && !vis[i][jj]) {
                            vis[i][jj] = true;
                            q.offerFirst(new int [] {i, jj});
                        }
                    }
                }
                cnt++;
            }
            return -1; 
        }
    }
    public static void main (String[] args) { 
        Solution s = new Solution ();

        int [][] a = new int [][] {{3,4,2,1},{4,2,1,1},{2,1,1,0},{3,4,1,0}};

        int r = s.minimumVisitedCells(a);
        System.out.println("r: " + r);
    }
}
// 【爱表哥，爱生活！！！活宝妹就是一定要嫁给亲爱的表哥！！！】
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);








