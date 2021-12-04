import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
// import javafx.util.Pair;
import java.util.stream.Collectors;
import java.lang.Math;
// import org.apache.commons.math4.util;

import static java.util.stream.Collectors.toMap;

public class dynafourmicProgramming {
    public static class Solution {

        // public class MinSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MinSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); 
        //         for (int i = n-1; i >= 0; i--)  // i >= 0
        //             tree.set(i,  Math.min(tree.get(2*i),  tree.get(2*i+1)));
        //     }
        //     public void update(int idx,  int v) {
        //         idx += n;
        //         tree.set(idx,  v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx,  Math.min(tree.get(2*idx),  tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMin(int l,  int r) { // [l, r) include left, not included right
        //         l += n;
        //         r += n;
        //         int min = Integer.MAX_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 min = Math.min(min,  tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 min = Math.min(min,  tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return min;
        //     }
        // }
        // public int minNumberOperationsRecursive(int[] arr, int l, int r, int pv) { // l: left, r: right idx, inclusive, pv: pre min value
        //     if (l == r) return arr[l]-pv;
        //     if (r == l+1) return Math.max(arr[l], arr[r])-pv;
        //     int min = minSeg.getMin(l, r+1);
        //     int i = 0, j = 0, res = min -pv;
        //     if (arr[l] == min) {
        //         i = l+1;
        //         while (i < r && arr[i] == min) ++i;
        //         if (arr[r] == min) {
        //             j = r-1;
        //             if (i == r) return min-pv;
        //             while (j >= l && arr[j] == min) --j;
        //             res += minNumberOperationsRecursive(arr, i, j, min);
        //         } else res += minNumberOperationsRecursive(arr, i, r, min);
        //         return res;
        //     }
        //     if (arr[l] > min) {
        //         i = l +1;
        //         while (i < r && arr[i] > min) ++i;
        //         res += minNumberOperationsRecursive(arr, l, i-1, min);
        //         while (i < r && arr[i] == min) ++i;
        //         if (i == r && arr[r] == min) return res;
        //         return res + minNumberOperationsRecursive(arr, i, r, min);
        //     }
        //     return -1;
        // }
        // MinSeg minSeg;
        // int n;
        // public int minNumberOperations(int[] target) {
        //     n = target.length;
        //     if (n == 1) return target[0];
        //     minSeg = new MinSeg(target);
        //     return minNumberOperationsRecursive(target, 0, n-1, 0);
        // }


        // public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        //     int [] res = new int [n-1]; 
        //     Set<Integer> vc = new HashSet<>();  // visited edges bitmasks vis of cur
        //     Set<Integer> vn = new HashSet<>();  // visited edges bitmasks vis of next
        //     int mask = 1;
        //     for (int d = 1; d <= n-1; d++) {
        //         // for (Integer v : vc) {
        //         // }
        //         if (d == 1) {
        //             for (int i = 0; i < edges.length; i++) {
        //                 mask = (1 <<= i+1);
        //                 System.out.println("mask: " + mask);
        //                 if (!vn.contains(mask)) {
        //                 }
        //             }
        //         }
        //     }
        // }


        // public int minFallingPathSum(int[][] grid) {
        //     int m = grid.length; // 不知道前缀和在这个题目是要怎么用、怎么优化
        //     int n = grid[0].length;
        //     if (m == 1 && n == 1) return grid[0][0];
        //     int [][] dp = new int [m][n];
        //     for (int i = 1; i < m; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     int min = Integer.MAX_VALUE;
        //     System.arraycopy(grid[0], 0, dp[0], 0, n);
        //     for (int i = 1; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             for (int k = 0; k < n; k++) {
        //                 if (k == j) continue;
        //                 dp[i][j] = Math.min(dp[i][j], dp[i-1][k]+grid[i][j]);
        //                 if (i == m-1) min = Math.min(min, dp[i][j]);
        //             }
        //     return min;
        // }

        // public int cherryPickup(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int [][][] dp = new int [m][n][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     dp[0][0][n-1] = n != 1 ? grid[0][0] + grid[0][n-1] : grid[0][0];
        //     int xi = 0, xii =0;
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 0; j <= Math.min(i, n-1); j++) {
        //             for (int k = Math.max(0, n-i-1); k <= n-1; k++) {
        //                 for (int x = -1; x <= 1; x++) {
        //                     for (int y = -1; y <= 1; y++) {
        //                         xi = j + x;
        //                         xii = k + y;
        //                         if (xi >= 0 && xi < n && xii >= 0 && xii < n) {
        //                             if (dp[i-1][xi][xii] != -1) {
        //                                 if (j == k)
        //                                     dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][xi][xii]+grid[i][j]);
        //                                 else dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][xi][xii]+grid[i][j] + grid[i][k]);
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        //     int res = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             res = Math.max(res, dp[m-1][i][j]);
        //     return res;
        // }
        // private int helper (int [][] arr, int i, int j, int k) { // 还是没能想明白怎么压缩重复计算问题
        //     if (dp[i][j][k] != null) return dp[i][j][k];         // 这里自顶向下，与自底向上不同方向的计算、以及是否返回值逻辑上容易混乱
        //     int res = arr[i][j];
        //     if (j != k) res += arr[i][k];
        //     int max = 0;
        //     for (int [] d : dirs) {
        //         if (i+d[0] == m) break;
        //         if (j+d[1] < 0 || j+d[1] >= n) continue;
        //         for (int [] dd : dirs) {
        //             if (k+dd[1] < 0 || k +dd[1] >= n) continue;
        //             max = Math.max(max, helper(arr, i+d[0], j+d[1], k+dd[1]));
        //         }
        //     }
        //     res += max;
        //     dp[i][j][k] = res;
        //     return res;
        // }
        // int[][] dirs = new int[][]{{1,-1},{1,0},{1,1}}; // 可移动的方向
        // int max = 0;
        // Integer [][][] dp;
        // int m, n;
        // public int cherryPickup(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     dp = new Integer [m][n][n]; // m rows, r1 n cols and r2 n cols
        //     max = 0;
        //     return helper(grid, 0, 0, n-1);
        // }

 
        // private int dfs(int n) { // O(logN)
        //     if (n == 0) return 0;
        //     int k = 1;
        //     while (k << 1 <= n) k <<= 1;
        //     // f(n)=f(n^110...0)+1+k−1=f(n^110...0)+k
        //     return dfs(k ^ (k >> 1) ^ n) + k;
        // }
        // public int minimumOneBitOperations(int n) {
        //     return dfs(n);
        // }
        // Solution 1: Graycode
        // Time complexity: O(logn)
        // Space complexity: O(1)
        // Ans is the order of n in graycode.
        // public int minimumOneBitOperations(int n) {
        //     int ans = 0;
        //     while (n > 0) {
        //         ans ^= n;
        //         n >>= 1;
        //     }
        //     return ans;
        // }

        
/**
 * Approach: Iterative Greedy
 * 枚举长度 i（最大只能到 text.length/2），采用贪心的策略：
 * 只要 text.substring(i) 和 text.substring(n - i - 1) 相等，就说明能够组成一对回文。
 * 因此立刻将他们切割出来，结果+2，然后对剩下的字符串继续进行上述处理。
 * 直到字符串为空或者仅身下一个无法被切分的字符串。（这个过程可以使用递归进行处理）
 *
 * 时间复杂度：O(n * len(string))
 * 空间复杂度：O(n)
 */
        // public int longestDecomposition(String text) {
        //     int n = text.length();
        //     for (int i = 0; i < n/2; i++) {
        //         if (text.substring(0, i+1).equals(text.substring(n-1-i)))
        //             return 2 + longestDecomposition(text.substring(i+1, n-1-i));
        //     }
        //     return 1;
        // }  
        // 贪心的做法，遇到相等的前后子串就取出来，循环检查剩余串，证明见题解区
        // 要自己来一个一个数这个东西的时候就容易出错， 所以还是上面的递归更简洁、适用和常用不易错
        // public int longestDecomposition(String text) { // 这里面还有一个小bug需要找出来，现在不弄它了
        //     int n = text.length();
        //     int i = 0, j = n-1, ans = 0, maxLen = 0;
        //     while (i <= j) {
        //         maxLen = j - i + 1;
        //         for (int k = 1; k <= maxLen; k++) {
        //             if (text.substring(i, k) == text.substring(j-k+1, k)) {
        //                 if (k < maxLen) ans += 2;
        //                 else ans += 1;
        //                 i += k;
        //                 j -= k;
        //                 break;
        //             }
        //         }
        //     }
        //     return ans;
        // }


           // public int countVowelPermutation(int n) {
           //     if (n == 1) return 5;
           //     int [][] map = {{1, 2, 4}, {0, 2}, {1, 3}, {2}, {2, 3}};
           //     long [][] dp = new long [n][5];
           //     long tmp = 0, res = 0;
           //     Arrays.fill(dp[0], 1);
           //     long mod = 1000000007;
           //     for (int i = 1; i < n; i++) {
           //         for (int j = 0; j < 5; j++) {
           //             tmp = 0;
           //             for (int v : map[j]) 
           //                 tmp += dp[i-1][v] % mod;
           //             dp[i][j] = tmp % mod;
           //         }
           //     }
           //     for (int i = 0; i < 5; i++)
           //         res += dp[n-1][i]% 1000000007;
           //     return (int)(res % 1000000007);
           // }


        // public int numOfWays(int n) { // 改成是dp 的写法
        //     if (n == 1) return 12;
        //     long [][][][] dp = new long [n][3][3][3]; // 0: red, 1: yellow, 2: green
        //     long res = 0, mod = 1000000007;
        //     int [][] init = {{0, 1, 0}, {1, 0, 1}, {2, 0, 1},
        //                      {0, 1, 2}, {1, 0, 2}, {2, 0, 2},
        //                      {0, 2, 0}, {1, 2, 0}, {2, 1, 0},
        //                      {0, 2, 1}, {1, 2, 1}, {2, 1, 2}};
        //     for (int [] v : init) 
        //         dp[0][v[0]][v[1]][v[2]] = 1;
        //     for (int r = 1; r < n; r++) {
        //         for (int i = 0; i < 3; i++) {
        //             for (int j = 0; j < 3; j++) {
        //                 for (int k = 0; k < 3; k++) {
        //                     if (i == j || j == k) continue;
        //                     res = 0;
        //                     for (int [] v : init) { // 这里转得有点儿晕，快不知道是怎么回事了
        //                         if (i == v[0] || j == v[1] || k == v[2]) continue;
        //                         res += dp[r-1][v[0]][v[1]][v[2]] % mod;
        //                     }
        //                     dp[r][i][j][k] += res;
        //                     dp[r][i][j][k] %= mod;
        //                 }
        //             }
        //         }
        //     }
        //     res = 0;
        //     for (int i = 0; i < 3; i++) 
        //         for (int j = 0; j < 3; j++) 
        //             for (int k = 0; k < 3; k++) 
        //                 res += dp[n-1][i][j][k];
        //     return (int)(res % 1000000007);
        // }
        // private int dfs(int n, int r, int i, int j, int k) { // 这种写法有bug,还没想出来这里到底怎么了
        //     if (r == n-1) return 1;
        //     if (dp[r][i][j][k] != 0) return dp[r][i][j][k]; // 这就是记录过的好处了：不用再重复计算
        //     int res = 0;
        //     // int [] colors = {1, 2, 3};
        //     // for (int x : colors) {
        //     //     if (x == i) continue;
        //     //     for (int y : colors) {
        //     //         if (y == j) continue;
        //     //         for (int z : colors) {
        //     //             if (z == k) continue;
        //     //             res = (res % mod + dfs(n, r+1, x, y, z) % mod) % mod;
        //     //         }
        //     //     }
        //     // }
        //     for (int [] v : init) {
        //         if (i == v[0] || j == v[1] || k == v[2]) continue;
        //         res = (int)((res + dfs(n, r+1, v[0], v[1], v[2])) % mod);
        //     }
        //     dp[r][i][j][k] = res;
        //     return dp[r][i][j][k];
        // }
        // int [][][][] dp;
        // int mod = 1000000007;
        // int [][] init = {{0, 1, 0}, {1, 0, 1}, {2, 0, 1},
        //                  {0, 1, 2}, {1, 0, 2}, {2, 0, 2},
        //                  {0, 2, 0}, {1, 2, 0}, {2, 1, 0},
        //                  {0, 2, 1}, {1, 2, 1}, {2, 1, 2}};
        // public int numOfWays(int n) {
        //     dp = new int [n][3][3][3]; // 0: red, 1: yellow, 2: green
        //     int res = 0;
        //     // return dfs(n, 1, 1, 1, 0);
        //     for (int [] v : init) {
        //         res = (int)(res + dfs(n, 0, v[0], v[1], v[2]) % mod); 
        //         // res += dp[0][v[0]][v[1]][v[2]];
        //     }
        //     return (int)(res % 1000000007);
        // } 

        
        // public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        //     int t = minutesToTest / minutesToDie;
        //     if (t == 1 && buckets == 1) return 0;
        //     int x = 1;
        //     while (Math.pow(t+1, x) < buckets) x += 1;
        //     return x;
        // }


        // public long solve(List<Integer> l) {
        //     int n = l.size();
        //     if (n <= 1) return 1;
        //     List<Integer> left = new ArrayList<>();
        //     List<Integer> right = new ArrayList<>();
        //     int v = 0;
        //     for (int i = 1; i < n; i++) { 
        //         v = l.get(i);
        //         if (v > l.get(0)) right.add(v);
        //         else left.add(v);
        //     }
        //     long ansLeft = solve(left);
        //     long ansRight = solve(right);
        //     long ans = (ansLeft * ansRight) % mod;
        //     ans = (long)(ans * dp[n-1][left.size()] % mod);
        //     return ans;
        // }
        // long dp [][] = new long[1001][1001];
        // int mod = 1000000007;
        // public int numOfWays(int[] nums) {
        //     dp[0][0] = 1;
        //     int n = nums.length;
        //     for (int i = 1; i <= n; i++) { // 这应该是一个组合数组
        //         dp[i][0] = 1;
        //         dp[i][i] = 1;
        //         for (int j = 1; j < i; j++) 
        //             dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
        //     }
        //     List<Integer> list = new ArrayList<>();
        //     for (int v : nums) 
        //         list.add(v);
        //     return (int) solve(list)-1;
        // }
/*      private static final long MOD = 1000000007;
        public int numOfWays(int[] nums) {
            BinarySearchTree tree = new BinarySearchTree();
            for (int i = 0; i < nums.length; i++) 
                tree.insert(nums[i]);
            return recursion(tree.root, getTriangle(nums.length + 1)) - 1;
        }
        int recursion(Node root, long[][] combs) {
            if (root == null) return 1;
            int left = count(root.left);
            int right = count(root.right);
// main formula here is count left and right subtree combinations possible 
            // X left subtree combinations and right subtree combinations  
            return (int)
                ((combs[left + right][left] % MOD * recursion(root.left, combs) % MOD)
                 % MOD
                 * recursion(root.right, combs)
                 % MOD);
        }
        // count the number of nodes in each subtree
        int count(Node root) {
            if (root == null) return 0;
            return 1 + count(root.right) + count(root.left);
        }
        // pasacal triangle use this instead of doing factorial for finding nCm combination values
        private static long[][] getTriangle(int n) {
// Yang Hui (Pascle) triangle
// 4C2 = triangle[4][2] = 6
            long[][] triangle = new long[n][n];
            for (int i = 0; i < n; i++) 
                triangle[i][0] = triangle[i][i] = 1;
            for (int i = 2; i < n; i++) 
                for (int j = 1; j < i; j++)
                    triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
            return triangle;
        }
        class Node {
            public int data;
            public Node left;
            public Node right;
            public Node(int data) {
                this.data = data;
            }
            public Node(int data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }
        // BST insert Node contruction
        class BinarySearchTree {
            Node root;
            void insert(int data) {
                root = insertNode(root, data);
            }
            Node insertNode(Node node, int data) {
                if (node == null) {
                    return new Node(data);
                } else if (data > node.data) {
                    node.right = insertNode(node.right, data);
                } else {
                    node.left = insertNode(node.left, data);
                }
                return node;
            }
        }  */


        // public int maxHeight(int[][] arr) { // test case 数据太大，最后两个case不过，参考答案
        //     int n = arr.length;
        //     for (int i = 0; i < n; i++) 
        //         Arrays.sort(arr[i]);
        //     Arrays.sort(arr, (a, b)-> (b[0] != a[0] ? a[0] - b[0] : (b[1] != a[1]  ? a[1] - b[1] : a[2] - b[2])));
        //     int [] dp = new int [n];
        //     int max = 0;
        //     for (int i = 0; i < n; i++) {
        //         dp[i] = arr[i][2];
        //         for (int j = i-1; j >= 0; j--) {
        //             if (arr[j][1] <= arr[i][1] && arr[j][2] <= arr[i][2]) 
        //                 dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }

        
        // private int findNext(int idx, int [][] arr) {
        //     for (int i = idx+1; i < arr.length; i++) 
        //         if (arr[i][0] >= arr[idx][1]) return i;
        //     return -1;
        // }
        // public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        //     int n = startTime.length;
        //     int [][] arr = new int [n][3];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = new int[] {startTime[i], endTime[i], profit[i]};
        //     Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        //     int [] dp = new int [n];
        //     dp[n-1] = arr[n-1][2];
        //     int j = 0;
        //     for (int i = n-2; i >= 0; i--) {
        //         j = findNext(i, arr);
        //         dp[i] = Math.max(dp[i+1], arr[i][2] + (j == -1 ? 0 : dp[j]));
        //     }
        //     return dp[0];
        // } 
        // public int jobScheduling(int[] startTime, int[] endTime, int[] profit) { // 这个人的乱代码总是有错
        //     int n = startTime.length;
        //     int [][] arr = new int [n][3];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = new int[] {startTime[i], endTime[i], profit[i]};
        //     Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        //     // 关键点在于把 dp 数组的意义改变一下。
        //     //     之前 dp 数组储存的是以当前项为末尾时最大 profit。
        //     //     而现在认为 dp[i] 的意义是区间 0~i ii 里的最大profit，但不一定以 i ii 结尾！
        //     int [] dp = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         dp[i] = arr[i][2];
        //     for (int i = 1; i < n; i++) {
        //         dp[i] = Math.max(dp[i-1], arr[i][2]);
        //         for (int j = i-1; j >= 0; j--) {
        //             if (arr[i][0] >= arr[j][1]) {
        //                 dp[i] = Math.max(dp[i], dp[j] + arr[i][2]);
        //                 break;
        //             }
        //         }
        //     }
        //     return dp[n-1];
        // }


        // let dp(n, k) be the ways to have product k of array size n.
        // dp(n, k) = sum(dp(n – 1, i)) where i is a factor of k and i != k.
        //     base case:
        //     dp(0, 1) = 1, dp(0, *) = 0
        //     dp(i, 1) = C(n, i)
        //     e.g.
        //     dp(2, 6) = dp(1, 1) + dp(1, 2) + dp(1, 3)
        //     = 2 + 1 + 1 = 4
        //     dp(4, 4) = dp(3, 1) + dp(3, 2)
        //     = dp(3, 1) + dp(2, 1)
        //     = 4 + 6 = 10
        //     Time complexity: O(sum(k_i))?
        //     Space complexity: O(sum(k_i))?
        // public List<Integer> getPrimes(int n) {
        //     boolean [] notPrime = new boolean[n+1];
        //     List<Integer> res = new ArrayList<>();
        //     for (int i = 2; i <= n; i++) {
        //         if (!notPrime[i]) {
        //             res.add(i);
        //             for (int j = i*i; j <= n; j += i) 
        //                 notPrime[j] = true;
        //         }
        //     }
        //     return res;
        // }
        // public long [][] getTri(int m, int n) { // 这个著名三角形要把它彻底搞懂到会像这个样子用的程度
        //     long [][] res = new long[m+1][n+1];
        //     for (int i = 0; i <= m; i++) {
        //         res[i][0] = 1;
        //         for (int j = 1; j <= Math.min(n, i); j++) 
        //             res[i][j] = (res[i-1][j-1]+res[i-1][j]) % mod;
        //     }
        //     return res;
        // }
        // private int getCnt(int n, int target) {
        //     long res = 1;
        //     for (int prime : primes) {
        //         if (prime > target) break;
        //         int cnt = 0;
        //         while (target % prime == 0) { // 这里还有点儿稀里糊涂
        //             ++cnt;
        //             target /= prime;
        //         }
        //         res = (res * tri[cnt+n-1][cnt]) % mod;
        //     }
        //     return target > 1 ? (int)(res * n % mod) : (int)res;
        // }
        // int mod = 1_000_000_007;
        // List<Integer> primes;
        // long [][] tri;
        // // basic idea is to factorize every target, then group prime factors into n groups.
        // //     It is very similiar to put N balls into M boxes, allow empty boxes(because we can fill the empty box with 1)
        // //     formula： C(N+M-1, M-1)
        // //     Note that we dont have to comput C(10000+10000 10000), since the constraint limit the max number to 10000,
        // // say we choose minimum prime which is 2, 2^14>10000, so count of any single prime will not exceed 13,
        // //     and also we know C(10013, 10000) = C(10013, 13). Then calculate pascal triangle to get C(m, n).
        // public int[] waysToFillArray(int[][] queries) {
        //      int n = queries.length;
        //      int [] ans = new int [n];
        //      primes = getPrimes(100);
        //      tri = getTri(10015, 15);
        //      for (int i = 0; i < n; i++)
        //          ans[i] = getCnt(queries[i][0], queries[i][1]);
        //      return ans;
        //  }
        // Integer [] getPrimes(int max) { // 这里也有点儿昏乎乎地。。。。。。
        //     TreeSet<Integer> primes = new TreeSet<>();
        //     primes.add(2);
        //     for (int i = 3; i <= max; i += 2)
        //         primes.add(i);
        //     Integer min = 3;
        //     while (min != null && min <= max) {
        //         for (int i = min; i*min <= max; i += 2)
        //             primes.remove(i*min);
        //         min = primes.ceiling(min+1);
        //     }
        //     return primes.toArray(new Integer[primes.size()]);
        // }
        // private int choose(int n, int k, Integer [][] memo) {
        //     if (n == 0 || k == 0 || k == n) return 1;
        //     if (k > n / 2) return choose(n, n-k, memo);
        //     if (memo[n][k] != null) return memo[n][k];
        //     return memo[n][k] = (choose(n-1, k, memo) + choose(n-1, k-1, memo)) % mod; // C(n,k) = C(n-1, k) + C(n-1, k-1), each C(i,j) can be memorized.
        // }
        // int mod = 1_000_000_007;
        // public int[] waysToFillArray(int[][] queries) {
        //     int n = queries.length;
        //     int [] ans = new int [n];
        //     Integer [] plist = getPrimes(10000); // too much
        //     Integer [][] memo = new Integer[10024][24];
        //     for (int i = 0; i < n; i++) {
        //         if (queries[i][0] == 1 || queries[i][1] == 1) {
        //             ans[i] = 1;
        //             continue;
        //         }
        //         int idx = 0, num = queries[i][1];
        //         Map<Integer, Integer> factorMap = new HashMap<>();
        //         while (plist[idx] <= num) {
        //             if (num % plist[idx] == 0) {
        //                 factorMap.merge(plist[idx], 1, (a, b)->a+b);
        //                 num /= plist[idx];
        //             } else idx++;
        //         }
        //         long res = 1;
        //         for (Integer v : factorMap.values()) 
        //             res = (res * choose(queries[i][0]+v-1, v, memo)) % mod;
        //         ans[i] = (int)res;
        //     }
        //     return ans;
        // }
        // private List<Integer> getPrimeFactors(int v) {
        //     List<Integer> l = new ArrayList<>();
        //     int tmp = v;
        //     tmp = v;
        //     l.clear();
        //     while (tmp % 2 == 0) {
        //         l.add(2);
        //         tmp /= 2;
        //     }
        //     for (int i = 3; i <= Math.sqrt(v); i++) {
        //         while (tmp % i == 0)  {
        //             l.add(i);
        //             tmp /= i;
        //         }
        //     }
        //     if (tmp > 1) l.add(tmp);
        //     Collections.sort(l);
        //     return l;
        // }
        // int mod = 1000000007;
        // private int getCnt(int n, int k) {
        //     // System.out.println("\nn: " + n);
        //     // System.out.println("k: " + k);
        //     List<Integer> l = getPrimeFactors(k);
        //     // 这里再次对l 里的元素进行排列组合成2个数的积、3个数的积......l.size()个数的乘积，对每种情况计算次数
        //     // System.out.println("l.size(): " + l.size());
        //     // for (int z = 0; z < l.size(); ++z) 
        //     //     System.out.print(l.get(z) + ", ");
        //     // System.out.print("\n");
        //     int res = n;
        //     // for (int i = 0; i < l.size(); i++) 
        //     //     res = (int)((res + fact[n]/fact[ll.get(i).size()]/fact[n-ll.get(i).size()]) % mod);
        //     return res;
        // }

        
        // private int getMax(int [] arr, int l, int r) {
        //     int max = 0;
        //     for (int i = l; i <= Math.min(r, n-1); i++) 
        //         max = Math.max(max, arr[i]);
        //     return max;
        // }
        // int [][] dp;
        // int n;
        // public int minDifficulty(int[] jobDifficulty, int d) {
        //     n = jobDifficulty.length;
        //     if (d > n) return -1;
        //     dp = new int[n][d+1];
        //    return helper(jobDifficulty, 0, d);
        // }
        // private int helper(int [] arr, int idx, int d) {
        //     if (dp[idx][d] > 0) return dp[idx][d];
        //     if (d == 1) {
        //         dp[idx][d] = getMax(arr, idx, n-1);
        //         return dp[idx][d];
        //     }
        //     int res = Integer.MAX_VALUE;
        //     if (idx == n-d) {
        //         res = 0;
        //         for (int i = idx; i < n; i++) 
        //             res += arr[i];
        //         dp[idx][d] = res;
        //         return res;
        //     }
        //     for (int i = n-d; i >= idx; i--) {
        //         res = Math.min(res, getMax(arr, idx, i) + (i+1 <= n-1 ? helper(arr, i+1, d-1) : 0));
        //     }
        //     dp[idx][d] = res;
        //     return res;
        // }


        // private int getSum(int [] arr, int l, int r) {
        //     int sum = 0;
        //     for (int i = l; i <= r; i++) 
        //         sum += arr[i];
        //     return sum;
        // }
        // private int helper(int [] arr, int idx, int k) {
        //     if (dp[idx][k] < Integer.MAX_VALUE) return dp[idx][k];
        //     int res = Integer.MAX_VALUE;
        //     if (k == 1) {
        //         dp[idx][k] = getSum(arr, idx, n-1);
        //         return dp[idx][k];
        //     } else if (idx == n-k) {
        //         res = 0;
        //         for (int i = idx; i < n; i++) 
        //             res = Math.max(res, arr[i]);
        //         dp[idx][k] = res;
        //         return res;
        //     }
        //     for (int i = n-k; i >= idx; i--) {
        //         if (i < n-k && arr[i] == arr[i+1] && arr[i] == 0) continue;
        //         res = Math.min(res, Math.max(getSum(arr, idx, i),  (k == 1 || i == n-1 ? 0 : helper(arr, i+1, k-1)))); // i+1 contditions
        //     }
        //     dp[idx][k] = res;
        //     return res;
        // }
        // int min = Integer.MAX_VALUE;
        // int [][] dp;
        // int n;
        // public int splitArray(int[] nums, int m) {
        //     n = nums.length;
        //     if (m == n) {
        //         int max = 0;
        //         for (int v : nums) 
        //             max = Math.max(max, v);
        //         return max;
        //     }
        //     dp = new int [n][m+1];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(dp[i], Integer.MAX_VALUE);
        //     return helper(nums, 0, m);
        // }


        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); 
        //         for (int i = n-1; i >= 0; i--)  // i >= 0
        //             tree.set(i,  Math.max(tree.get(2*i),  tree.get(2*i+1)));
        //     }
        //     public void update(int idx,  int v) {
        //         idx += n;
        //         tree.set(idx,  v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx,  Math.max(tree.get(2*idx),  tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMax(int l,  int r) { // [l, r) include left, not included right
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max,  tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 max = Math.max(max,  tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }
        // public int constrainedSubsetSum(int[] arr, int k) { 
        //     int n = arr.length;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, Integer.MIN_VALUE);
        //     dp[0] = arr[0];
        //     int max = dp[0];
        //     MaxSeg maxSeg = new MaxSeg(dp);
        //     int locMax = 0;
        //     for (int i = 1; i < n; i++) {
        //         locMax = maxSeg.getMax(Math.max(0, i-k), i);
        //         dp[i] = Math.max(dp[i], arr[i] + Math.max(0, locMax));
        //         maxSeg.update(i, dp[i]);
        //         // for (int j = Math.max(0, i-k); j < i; j++) { // 会超时
        //         //     dp[i] = Math.max(dp[i], arr[i] + Math.max(0, dp[j]));
        //         // }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }


        // private int getMax(int [] arr, int l, int h) {
        //     int max = 0;
        //     for (int i = l; i <= h; i++) 
        //         max = Math.max(max, arr[i]);
        //     return max;
        // }
        // private int getSum(int [] arr, int l, int r) {
        //     int sum = 0;
        //     for (int i = l; i <= r; i++) 
        //         sum += arr[i];
        //     return sum;
        // }
        // private int dfs(int [] arr, int idx, int k) { // 这是不对的，没人要你按顺序分，要按一个个任务分给别人
        //     if (dp[idx][k] > 0) return dp[idx][k];    // 不过这个分组成为一个标准模板，这个题再换种解法
        //     if (k == 1) {
        //         dp[idx][k] = getSum(arr, idx, n-1);
        //         return dp[idx][k];
        //     } else if (idx == n-k) {
        //         dp[idx][k] = getMax(arr, idx, n-1);
        //         return dp[idx][k];
        //     }
        //     int res = Integer.MAX_VALUE;
        //     for (int i = n-k; i >= idx; i--) 
        //         res = Math.min(res, Math.max(getSum(arr, idx, i), (k == 1 || idx == n-1 ? 0 : dfs(arr, i+1, k-1))));
        //     dp[idx][k] = res;
        //     return dp[idx][k];
        // }
        // int [][] dp;
        // int n;
        // public int minimumTimeRequired(int[] jobs, int k) {
        //     n = jobs.length;
        //     dp = new int[n][k+1];
        //     return dfs(jobs, 0, k);
        // }
        // private int cntOnes(int v) {
        //     int cnt = 0;
        //     while (v > 0) {
        //         if (v % 2 == 1) ++cnt;
        //         v >>= 1;
        //     }
        //     return cnt;
        // }
        // private void dfs(int [] arr, int k, Set<Integer> masks) { // 这个mask怎么才能再轮询到下一个recursion,还得再想一下
        // }
        // int min = Integer.MAX_VALUE;
        // int n;
        // public int minimumTimeRequired(int[] jobs, int k) {
        //     n = jobs.length;
        //     int sum = 0;
        //     int max = 0;
        //     for (int v : jobs) {
        //         max = Math.max(max, v);
        //         sum += v;
        //     }
        //     if (n == k) return max;
        //     if (k == 1) return sum;
        //     Set<Integer> masks = new HashSet<>();
        //     for (int i = 1; i < Math.pow(2, n)-1; i++) {
        //         if (cntOnes(i) <= n-k+1)
        //             masks.add(i);
        //     }
        //     dfs(jobs, k, masks);
        //     return min;
        // }
        // int min = Integer.MAX_VALUE;
        // boolean [] vis;
        // private void helper (int [] arr, List<List<Integer>> ll, int [] jobs, int k, int t, int idx, int ind) {
        //     if (idx == jobs.length) {
        //         int max = 0;
        //         for (int j = 0; j < arr.length; j++) {
        //             if (arr[j] < t - ind) return;
        //             max = Math.max(max, arr[j]);
        //         }
        //         min = Math.min(min, max);
        //         return;
        //     }
        //     for (int i = idx; i < jobs.length; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             for (int j = 0; j < arr.length; j++) {
        //                 if (arr[j] + jobs[i] <= t) {
        //                     arr[j] += jobs[i];
        //                     ll.get(j).add(jobs[i]);
        //                     helper(arr, ll, jobs, k, t, i+1, ind);
        //                     ll.get(j).remove(ll.get(j).size()-1);
        //                     arr[j] -= jobs[i];
        //                 }
        //             }
        //             vis[i] = false;
        //         }                
        //     }
        // }
        // public int minimumTimeRequired(int[] jobs, int k) {
        //     int n = jobs.length;
        //     int sum = 0;
        //     int max = 0;
        //     for (int i = 0; i < n; i++) {
        //         max = Math.max(max, jobs[i]);
        //         sum += jobs[i];
        //     }
        //     int target = sum / k + (sum % k == 0 ? 0 : 1);
        //     int ind = sum % k == 0 ? 0 : 1;
        //     if (max > target) return max;
        //     int [] arr = new int[k];
        //     List<List<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < k; i++) 
        //         ll.add(new ArrayList<Integer>());
        //     vis = new boolean[n];
        //     // Arrays.sort(jobs);
        //     // int [] sorted = IntStream.rangeClosed(1, jobs.length).map(i -> jobs[jobs.length-i]).toArray();
        //     helper(arr, ll, jobs, k, target, 0, ind);
        //     return min;
        // }

        

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {3, 2, 3};
        int []  a = new int []  {1, 2, 4, 7, 8};

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) 
            System.out.print(a[z] + ", ");
        System.out.println("");
        

        int res = s.minimumTimeRequired(a, 2);
        System.out.println("res: " + res);
    }
}

IntStream.rangeClosed(0, n-1).mapToObj(z->${1:arr}[z]).collect(Collectors.toList());

// l = IntStream.rangeClosed(tmp, tmp+k-1).mapToObj(z->nums[z]).collect(Collectors.toList());
