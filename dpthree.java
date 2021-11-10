import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpthree {
    public static class Solution {

        private boolean dfs(int v, int t) {
            if (v == 1) return t % 2 == 1;
            if (dp[v][t%2] != null) return dp[v][t%2];
            if (t % 2 == 0) { // alice
                for (int i = 1; i < v; i++) 
                    if (v % i == 0 && dfs(v - i, t+1))
                        return dp[v][t%2] = true;
                return dp[v][t%2] = false;
            } else {
                for (int i = 1; i < v; i++) 
                    if (v % i == 0 && !dfs(v - i, t+1))
                        return dp[v][t%2] = false;
                return dp[v][t%2] = true;
            }
        }
        Boolean [][] dp;
        int n;
        public boolean divisorGame(int n) {
            this.n = n;
            dp = new Boolean [n+1][2];
            return dfs(n, 0);
        }
        public boolean divisorGame(int n) {
            return n % 2 == 0;
        }

        private void getLeafNodes(TreeNode r, List<TreeNode> l) {
            if (r == null) return ;
            if (r.left == null && r.right == null) {
                l.add(r);
                return ;
            }
            getLeafNodes(r.left, l);
            getLeafNodes(r.right, l);
        }
        private TreeNode cloneTree(TreeNode r) {
            if (r == null) return null;
            TreeNode p = new TreeNode(0);
            p.left = cloneTree(r.left);
            p.right = cloneTree(r.right);
            return p;
        }
        private boolean isSameTree(TreeNode r, TreeNode p) {
            if (r == null && p == null) return true;
            if (r == null || p == null) return false;
            return isSameTree(r.left, p.left) && isSameTree(r.right, p.right);
        }
        private boolean contains(List<TreeNode> l, TreeNode r) {
            for (TreeNode p : l) 
                if (isSameTree(p, r)) return true;
            return false;
        }
        public List<TreeNode> allPossibleFBT(int n) { // n: [1, 20] 感觉跟回溯相关，第二次写一开始的思路还是需要借鉴一下
            List<TreeNode> ans = new ArrayList<>();
            Map<Integer, List<TreeNode>> dp = new HashMap<>();
            if (n % 2 == 0) return ans;
            TreeNode root = new TreeNode(0);
            ans.add(root);
            if (n == 1) return ans;
            dp.put(1, ans);
            Set<TreeNode> sn = new HashSet<>();
            for (int i = 3; i <= n; i += 2) {
                List<TreeNode> tmpAns = new ArrayList<>();
                for (TreeNode  r : dp.get(i-2)) {
                    List<TreeNode> leaves = new ArrayList<>();
                    getLeafNodes(r, leaves);
                    for (TreeNode leaf : leaves) {
                        leaf.left = new TreeNode(0);
                        leaf.right = new TreeNode(0);
                        if (!contains(tmpAns, r))
                            tmpAns.add(cloneTree(r));
                        leaf.left = null;
                        leaf.right = null;
                    }
                }
                dp.put(i, tmpAns);
            }
            return dp.get(n);
        }
        public List<TreeNode> allPossibleFBT(int n) { // 纯粹回归的做法，没有记忆
            if (n % 2 == 0) return new ArrayList<>(0);
            List<TreeNode> list = new ArrayList<>();
            if (n == 1) {
                list.add(new TreeNode(0));
                return list;
            }
            n--; // root node
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(0); // root
                        node.left = l;
                        node.right = r;
                        list.add(node);
                    }
                }
            }
            return list;
        }
        public List<TreeNode> allPossibleFBT(int n) { // 聪明是因为拥有记忆
            Map<Integer, List<TreeNode>> map = new HashMap<>();
            if (map.containsKey(n)) return map.get(n);
            List<TreeNode> res = new ArrayList<>();
            if (n == 1) {
                res.add(new TreeNode(0,null,null));
            } else {
                for (int i = 1 ; i < n ; i += 2){
                    List<TreeNode> leftSub = allPossibleFBT(i);
                    List<TreeNode> rightSub = allPossibleFBT(n - i - 1);
                    for (TreeNode left : leftSub)
                        for (TreeNode right : rightSub)
                            res.add(new TreeNode(0, left, right));
                }
            }
            map.put(n , res);
            return map.get(n);
        }

        public int numTeams(int[] a) { // bug bug bug
            int n = a.length, ans = 0;
            TreeSet<Integer> left = new TreeSet<>();
            TreeSet<Integer> right = new TreeSet<>();
            for (int i = n-1; i >= 2; i--) right.add(a[i]);
            left.add(a[0]);
            for (int i = 1; i < n-1; i++) {
                Integer lower = left.lower(a[i]);
                if (lower != null) {
                    Integer higher = right.higher(a[i]);
                    if (higher != null) ans++;
                }
                Integer higher = left.higher(a[i]);
                if (higher != null) {
                    lower = right.lower(a[i]);
                    if (lower != null) 
                        ans++;
                }
                left.add(a[i]);
                right.remove(a[i+1]);
            }
            return ans;
        }

        public List<Integer> diffWaysToCompute(String t) {
            List<Integer> ans = new ArrayList<>();
            int n = t.length();
            if (t == null || n == 0) return ans;
            if (t.indexOf('+') == -1 && t.indexOf('-') == -1 && t.indexOf('*') == -1) {
                ans.add(Integer.parseInt(t));
                return ans;
            }
            char [] s = t.toCharArray();
            for (int i = 1; i < n-1; i++) {
                if (s[i] != '+' && s[i] != '-' && s[i] != '*') continue;
                List<Integer> left = diffWaysToCompute(t.substring(0, i));
                List<Integer> right = diffWaysToCompute(t.substring(i+1));
                for (Integer u : left) 
                    for (Integer v : right) {
                        if (s[i] == '+')
                            ans.add(u + v);
                        else if (s[i] == '-')
                            ans.add(u - v);
                        else ans.add(u * v);
                    }
            }
            return ans;
        }

        public int minimumDeletions(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] pre = new int [n];
            int [] suf = new int [n];
            int cnt = 0, ans = 0;
            for (int i = 0; i < n; i++)
                pre[i] = s[i] == 'b' ? ++cnt : cnt;
            cnt = 0;
            for (int i = n-1; i >= 0; i--)
                suf[i] = s[i] == 'a' ? ++cnt : cnt;
            for (int i = 0; i < n; i++) {
                if (s[i] == 'b' && pre[i] <= suf[i]) ans++;
                else if (s[i] == 'a' && pre[i] > suf)
            }
        }

        private int dfs(int [] a, int i, int j) { // 没有搞明白这个题目的划分到底是怎么回事，以及终止条件
            System.out.println("\n i: " + i);
            System.out.println("j: " + j);
            // if (i == j) return a[i];
            if (j - i == 2) return dp[i][j] = a[i] * a[i+1] * a[j];
                                // if (i > j) return 0;
            if (dp[i][j] > 0) return dp[i][j];
            int ans = Integer.MAX_VALUE;
            for (int k = i; k < j; k++) 
                ans = Math.min(ans, a[i]*a[k]*a[j] + dfs(a, i+1, k) + dfs(a, k+1, j));
             dp[i][j] = ans;
             System.out.println("dp[i][j]: " + dp[i][j]);
             return ans;
            // return dp[i][j] = ans;
        }
        int [][] dp;
        int n;
        public int minScoreTriangulation(int[] a) {
            n = a.length;
            dp = new int [n][n];
            return dfs(a, 0, n-1);
        }

        private int getLongestPalinSubsequence(String ss) {
            int n = ss.length();
            String tt = new StringBuilder(ss).reverse().toString();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [][] dp = new int [n+1][n+1];
            for (int i = 1; i <= n; i++) 
                for (int j = 1; j <= n; j++)
                    if (s[i-1] == t[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            return dp[n][n];
        }
        public int maxProduct(String t) {
            int n = t.length(), range = (1 << n), max = 1;
            if (n == 2) return 1;
            char [] s = t.toCharArray();
            for (int i = 1; i <= range / 2; i++) {
                StringBuilder a = new StringBuilder();
                StringBuilder b = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (((i >> j) & 1) == 1) a.append(s[j]);
                    else b.append(s[j]);
                }
                int va = getLongestPalinSubsequence(a.toString());
                int vb = getLongestPalinSubsequence(b.toString());
                max = Math.max(max, va * vb);
                // String a = "accbcaxxcxx";  // todo: ??? !!!
                // max = Math.max(max, getLongestPalinSubsequence(a.toString())) * getLongestPalinSubsequence(b.toString()); // 为什么这里连写就算得不对呢？
            }
            return max;
        }

        public int longestSubarray(int[] a) { // bug bug bug
            int n = a.length, i = 0, j = -1, max = 0, cnt = 0;
            boolean leadingZoo = false;
            while (i < n && a[i] == 0) {
                if (!leadingZoo) leadingZoo = true;
                i++;
            }
            if (i > 0) j = i-1;
            // System.out.println("i: " + i);
            // System.out.println("j: " + j);
            while (i < n) {
                while (i < n && cnt <= 1) {
                    if (a[i] == 0) ++cnt;
                    i++;
                }
                // System.out.println("i: " + i);
                // System.out.println("cnt: " + cnt);
                max = Math.max(max, i-j-1- Math.max(cnt, leadingZoo ? 0 : 1));
                if (leadingZoo) leadingZoo = false;
                cnt = 0;
                while (i < n && a[i] == 0) {
                    if (!leadingZoo) leadingZoo = true;
                    i++;
                }
                while (cnt > 1) {
                    if (a[j] == 0) --cnt;
                    j++;
                }
                j -= 1;
                max = Math.max(max, i-j-1- Math.max(cnt, leadingZoo ? 0 : 1));
                // j = i-1;
            }
            return max;
        }

        private int dfs(int v) {
            if (v <= 2) return dp[v] = 1;
            if (v == 3) return dp[v] = 2;
            if (dp[v] > 0) return dp[v]; // tle tle tle 为什么写写忘记了呢？
            int ans = 1;
            // int pre = 0, cur = 0;
            // for (int i = v/2; i >= 2; i--) {
            for (int i = v/2; i >= 1; i--) {
                ans = Math.max(Math.max(i, dfs(i)) * Math.max(v-i, dfs(v-i)), ans); // 这么写答案是错的 ?
                // cur = i * Math.max(v-i, dfs(v-i)); 
                // if (cur < pre) break;
                // ans = Math.max(ans, cur);
                // pre = cur;
            }
            return dp[v] = ans;
        }
        int [] dp;
        int m;
        public int integerBreak(int n) {
            m = n;
            dp = new int [n+1];
            return dfs(n);
        }

        public int findLength(int[] a, int[] b) { // 这个题没想透 bug bug bug
            int m = a.length, n = b.length;
            int [][] dp = new int [m][n];
            for (int j = 0; j < n; j++) 
                if (a[0] == b[j]) dp[0][j] = 1;
                else dp[0][j] = (j == 0 ? 0 : dp[0][j-1]);
            for (int i = 0; i < m; i++) 
                if (a[i] == b[0]) dp[i][0] = 1;
                else dp[i][0] = (i == 0 ? 0 : dp[i-1][0]);
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) {
                    if (a[i] == b[j] && a[i-1] == b[j-1])
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            return dp[m-1][n-1];
        }

        private void getAllPerm(int [] a, int idx, List<Integer> l) { // tle tle tle 
            if (l.size() == a.length) {
                if (!ll.contains(l)) ll.add(new ArrayList<>(l));
                return ;
            }
            for (int i = 0; i < a.length; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    l.add(a[i]);
                    getAllPerm(a, i+1, l);
                    l.remove(l.size()-1);
                    vis[i] = false;
                }
            }
        }
        private int getScore(List<Integer> l, int [][] a, int [][] b) {
            int cur = 0;
            for (int i = 0; i < l.size(); i++) {
                int j = 0;
                for (int v : a[l.get(i)]) {
                    cur += (v == b[i][j] ? 1 : 0);
                    j++;
                }
            }
            return cur;
        }
        List<List<Integer>> ll = new ArrayList<>();
        boolean [] vis;
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int m = students.length;
            int [] a = new int [m];
            for (int i = 0; i < m; i++) a[i] = i;
            vis = new boolean[m];
            getAllPerm(a, 0, new ArrayList<>());
            int max = 0;
            for (List<Integer> idx : ll) 
                max = Math.max(max, getScore(idx, students, mentors));
            return max;
        }
        public int calScore(  int[] st , int[] ment){ // Counts number of match 基本思路是一样的，但尽量把代码写得简洁一点儿
            int score = 0;
            for (int i = 0 ; i < st.length ; i++){            
                if (st[i] == ment[i])
                    score++;
            }
            return score;  
        }   
        public  void calAns( boolean[] vis , int mtCount , int curr){ // Bactracking method to find best student - mentor pairs. 
            if( mtCount >= n){
                ans = Math.max( ans , curr);
                return;
            }
            for (int i = 0 ; i <  n  ; i++){            
                if (! vis[i]){
                    vis[i]  = true;               
                    calAns( vis, mtCount+1 ,curr+match[i][mtCount] );
                    vis[i] = false;
                }
            }
        }
        int [][] match;
        boolean [] vis;
        int n, ans = 0;
        public int maxCompatibilitySum(int[][] st, int[][] ment) {        
            n = st.length;
            match = new int[n][n];
            for (int i = 0 ; i < n ; i++) // calculating the maximum match for each student and mentor
                for (int j = 0 ; j < n ; j++)            
                    match[i][j] = calScore( st[i] , ment[j]);
            vis = new boolean [n];  
            calAns( vis , 0 , 0); // calling helper functio
            return ans;
        }
        public int maxCompatibilitySum(int[][] st, int[][] mt) { // 这个思路理解起来有点儿困难，却是非常好的解法
            int m = st.length, n = st[0].length;
// 预处理得到每对师生间的兼容性评分
            int [][] score = new int [m][m]; // score[i][j]表示第i个学生和第j个导师间的兼容性评分
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < m; j++) {
                    score[i][j] = 0;
                    for (int k = 0; k < n; k++) 
                        if (st[i][k] == mt[j][k]) score[i][j]++;
                }
// 状态压缩 + 动态规划
            int range = 1 << m;
            int [] dp = new int [range]; // dp[i]中i的第x位为1，表示第x位导师已被分配，为0表示该导师尚未分配，dp[i]表示该分配状态下当前的最大兼容性评分和
            for (int i = 0; i < range; i++) {  // 遍历所有可能的分配状态
                int cnt = Integer.bitCount(i); // i中有count位为1，说明正在分配给这个导师的是第count-1位学生
                for (int j = 0; j < m; j++) {  // 尝试匹配所有导师
                    if (((i >> j) & 1) == 1)   // 状态i中第j位导师需被分配
                        dp[i] = Math.max(dp[i], dp[i ^ (1 << j)] + score[cnt-1][j]); // 尝试用第count-1位学生和第j位导师的分配方案更新dp
                }
            }
            return dp[range-1]; // 全部导师被分配时的最大兼容性评分和，就是待求解的答案
        }        


        private void dfs(TreeNode r, int cnt, boolean left) { // 1372
            max = Math.max(max, cnt - (r == null ? 1 : 0));
            if (r == null) return ;
            if (left) { 
                dfs(r.left, 1, true);
                dfs(r.right, cnt+1, false);
            } else {
                dfs(r.left, cnt+1, true);
                dfs(r.right, 1, false);
            }
        }
        int max = 0;
        public int longestZigZag(TreeNode root) {
            dfs(root.left, 1, true);
            dfs(root.right, 1, false);
            return max;
        }

        private int binarySearch(int [] a, int l, int r, int v) { // bug bug bug
            while (l <= r) {
                int m = (l+r) / 2;
                if (a[m] == v) return m;
                if (a[m] > v) r = m-1;
                else l = m + 1;
            }
            return -1;
        }
        public int lenLongestFibSubseq(int[] a) {
            int n = a.length, max = 0;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    System.out.println("\n i: " + i);
                    System.out.println("j: " + j);
                    int next = a[i] + a[j];
                    System.out.println("\n next: " + next);
                    int idx = binarySearch(a, j+1, n-1, next);
                    System.out.println("idx: " + idx);
                    int k = j;
                    if (idx != -1) dp[k] = Math.max(dp[k], dp[i]+1);
                    System.out.println("dp[idx]: " + dp[idx]);
                    while (idx != -1) {
                        dp[idx] = Math.max(dp[idx], dp[k]+1);
                        System.out.println("dp[idx]: " + dp[idx]);
                        next = a[k] + a[idx];
                        System.out.println("next: " + next);
                        k = idx;
                        idx = binarySearch(a, idx+1, n-1, next);
                        System.out.println("idx: " + idx);
                    }
                    System.out.println(Arrays.toString(dp));
                }
            }
            System.out.println(Arrays.toString(dp));
            return Arrays.stream(dp).max().getAsInt();
        }

        public int numRollsToTarget(int d, int f, int target) {
            int mod = (int)1e9 + 7;
            long [][] dp = new long [d][Math.max(f, target) + 1];
            for (int i = 0; i < f; i++) 
                dp[0][i+1] = 1;
            for (int i = 1; i < d; i++) {
                for (int j = 1; j <= target; j++) {
                    if (dp[i-1][j] == 0) continue;
                    for (int k = 1; k <= f && j+k <= target; k++) 
                        dp[i][j+k] = (dp[i][j+k] + dp[i-1][j]) % mod;
                }
            }
            return (int)dp[d-1][target];
        }
        private int dfs(int f, int d, int cur) {
            if (d == 0 && cur == 0) return 1;
            if (d == 0 || cur <= 0) return 0;
            // if (d <= 0) return 1; // 终止条件没有写对
            if (dp[d][cur] != null) return dp[d][cur];
            long ans = 0;
            for (int i = 1; i <= f; i++) 
                ans = (ans + dfs(f, d-1, cur-i)) % mod;
            return dp[d][cur] = (int)ans;
        }
        int mod = (int)1e9 + 7;
        Integer [][] dp;
        public int numRollsToTarget(int d, int f, int target) {
            dp = new Integer [d+1][target + 1];
            return dfs(f, d, target);
        }

        public int eraseOverlapIntervals(int[][] it) {
            int n = it.length;
            int [] dp = new int [n];
            Arrays.fill(dp, n);
        }

        private boolean dfs(int [] a, int k, int target, int idx, int cnt) { // 确定是用回溯，但写的过程中有些小 bug
            if (cnt == k-1) return true;
            if (idx < 0) return false;
            // for (int i = idx; i >= 0; i--) { // 画蛇添足 第二次！！！
            for (int j = 0; j < k; j++) { 
                if (j > 0 && dp[j] == dp[j-1] || dp[j] == target) continue;
                if (dp[j] + a[idx] <= target) {
                    dp[j] += a[idx];
                    // if (dfs(a, k, target, i-1, cnt + (dp[j] + a[idx] == target ? 1 : 0))) // dp[j] + a[idx]: dp[j] has been updated already
                    if (dfs(a, k, target, idx-1, cnt + (dp[j] == target ? 1 : 0))) 
                        return true;
                    dp[j] -= a[idx];
                }
            }
            // }
            return false;
        }
        boolean res = false;
        int [] dp;
        int n;
        public boolean canPartitionKSubsets(int[] a, int k) {
            n = a.length;
            Arrays.sort(a);
            int sum = Arrays.stream(a).sum();
            if (sum % k != 0) return false;
            dp = new int [k];
            return dfs(a, k, sum / k, n-1, 0);
        }

        public int numFactoredBinaryTrees(int [] a) {
            int mod = (int)1e9 + 7;
            Arrays.sort(a);
            int n =  a.length;
            long ans = 0;
            Map<Integer, Long> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long cur = 1;
                for (int j = 0; j < i; j++) // 这里没有＊2是因为会加两遍，2*3 = 6 3 * 2 = 6 相当于处理了左右子树调换的问题
                    if (a[i] % a[j] == 0 && m.containsKey(a[i] / a[j])) 
                        cur = (cur + m.get(a[j]) * m.get(a[i]/a[j])) % mod; 
                m.put(a[i], cur);
            }
            for (int i = 0; i < n; i++) 
                ans = (ans + m.get(a[i])) % mod;
            return (int) ans;
        }

        public int numOfSubarrays(int[] a) {
            int mod = (int)1e9 + 7;
            int n = a.length;
            int [] sum = Arrays.copyOf(a, n);
            long ans = 0;
            for (int i = 1; i < n; i++) sum[i] += sum[i-1];
            Map<Integer, List<Integer>> m = new HashMap<>();
            m.computeIfAbsent(0, z -> new ArrayList<>()).add(0);
            // m.put(0, new ArrayList<>(add(0)；)); // 在哪里见过一次类似这种写法，但记不清楚了 in dpone.java or dptwo.java
            for (int i = 0; i < n; i++) {
                if (sum[i] % 2 == 0) {
                    if (m.get(1) != null && m.get(1).size() > 0)
                        ans = (ans + m.get(1).size()) % mod;
                } else { 
                    if (m.get(0) != null && m.get(0).size() > 0)
                        ans = (ans + m.get(0).size()) % mod;
                }
                m.computeIfAbsent(sum[i]%2, z -> new ArrayList<>()).add(sum[i]);
            }            
            return (int)ans;
        }

        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m, n;
        public int[][] updateMatrix(int[][] mat) { // tle tle tle: 我决定反过来搜试试，搜离所有0最近的1离0的距离 
            m = mat.length;
            n = mat[0].length;
            int [][] ans = new int [m][];
            for (int i = 0; i < m; i++) 
                ans[i] = Arrays.copyOf(mat[i], n);
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1)
                        ans[i][j] = bfs(mat, i, j);
                }
            return ans;
        }
        private int bfs(int [][] a, int x, int y) {
            Set<Integer> vis = new HashSet<>();
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {x, y});
            vis.add(x * n + y);
            int cnt = 0;
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll();
                    for (int [] d : dirs) {
                        int i = cur[0] + d[0], j = cur[1] + d[1];
                        if (i < 0 || i >= m || j < 0 || j >= n || vis.contains(i * n + j)) continue;
                        if (a[i][j] == 0) return cnt + 1;
                        q.offer(new int [] {i, j});
                        vis.add(i * n + j);
                    }
                }
                cnt ++;
            }
            return -1;
        }
        public int[][] updateMatrix(int[][] mat) { // tle了：反过来搜试试，搜离所有0最近的1离0的距离 
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int m = mat.length, n = mat[0].length;
            int [][] ans = new int [m][];
            for (int i = 0; i < m; i++) 
                ans[i] = Arrays.copyOf(mat[i], n);
            Queue<int []> q = new LinkedList<>();
            boolean [][] vis = new boolean [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        q.offer(new int [] {i, j});
                        vis[i][j] = true;
                        // ans[i][j] = bfs(mat, i, j); // 往往你这么一个格一个格地计算的时候，就容易超时，要想着怎么才能批量处理
                    }
                }
            int cnt = 0;
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll();
                    for (int [] d : dirs) {
                        int i = cur[0] + d[0], j = cur[1] + d[1];
                        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue;
                        if (mat[i][j] == 1) ans[i][j] = cnt + 1;
                        q.offer(new int [] {i, j});
                        vis[i][j] = true;
                    }
                }
                cnt++;
            }
            return ans;
        }

        public int maximalSquare(char[][] mat) {
            int m = mat.length, n = mat[0].length, max = 0;
            int [][] sum = new int [m+1][n+1];
            boolean updated = false;
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (mat[i-1][j-1] == '1' ? 1 : 0);
            for (int d = 1; d <= Math.min(m, n); d++) {
                for (int i = 1; i+d-1 <= m; i++)
                    for (int j = 1; j+d-1 <= n; j++) {
                        int x = i + d-1, y = j + d-1;
                        if (sum[x][y] - sum[x][j-1] - sum[i-1][y] + sum[i-1][j-1] == d * d)
                            if (d > max) {
                                max = d;
                                updated = true;
                            }
                    }
                if (!updated) break;
            }
            return max * max;
        }

        private boolean dfs(int [] a, int target, int i, int cnt) {
            if (cnt == 3) return true;
            if (i < 0 || a[i] > target) return false;
            for (int j = 0; j < 4; j++) {
                if (sum[j] == target || sum[j] + a[i] > target) continue;
                if (j > 0 && sum[j] == sum[j-1]) continue; // 一定要把可以 continue 快进的策略都列出来
                sum[j] += a[i];
                if (dfs(a, target, i-1, cnt + (sum[j] == target ? 1 : 0))) return true;
                sum[j] -= a[i];
            }
            return false;
        }
        int [] sum;
        int n;
        public boolean makesquare(int[] ms) {
            n = ms.length;
            int tot = Arrays.stream(ms).sum();
            // if (tot % 4 != 0 || Arrays.stream(ms).max().getAsInt() > tot / 4) return false;
            if (tot % 4 != 0) return false; // 这个上下两句差别不大
            sum = new int [4];
            Arrays.sort(ms); // sort一下，按从大数到小数分可以提速很多
            return dfs(ms, tot / 4, n-1, 0);
        }

        public int findNumberOfLIS(int[] a) { // bug bug bug
            int n = a.length;
            int [] dp = new int [n];
            Arrays.fill(dp, 1);
            int [] cnt = new int [n];
            int max = 0, maxIdx = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (a[i] > a[j]) {
                        // dp[i] = Math.max(dp[i], dp[j]+1);
                        if (dp[i] <= dp[j] + 1) {
                            // if (dp[i] < dp[j]+1 && dp[i] == 0 || dp[i] == dp[j]+1)
                            // if (dp[i] == dp[j]+1)
                                cnt[i] ++; // 这里数得不对，要么数多了，要么数少了
                            dp[i] = dp[j] + 1;
                        }
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                    maxIdx = i;
                }
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(Arrays.toString(cnt));
            return cnt[maxIdx];
        }

        // Let dp[i] be "the maximum score to reach the end starting at index i".
        // The answer for dp[i] is nums[i] + max{dp[i+j]} for 1 <= j <= k. That gives an O(n*k) solution.
        public int maxResult(int[] a, int k) {
            int n = a.length, max = a[n-1];
            int [] dp = new int [n];
            ArrayDeque<int []> q = new ArrayDeque<>(); // max deque, 单调递降，右进 两端都可以出 这个deque还要再熟悉一下，别得好费劲
            dp[n-1] = a[n-1];
            q.offerLast(new int [] {n-1, dp[n-1]});
            for (int i = n-2; i >= 0; i--) {
                while (!q.isEmpty() && q.peekFirst()[0] > i+k) q.pollFirst();
                // max = Integer.MIN_VALUE; // tle tle tle
                // for (int j = i+1; j <= Math.min(n-1, i+k); j++)
                //     max = Math.max(max, dp[j]);
                dp[i] = a[i] + q.peekFirst()[1];
                while (!q.isEmpty() && q.peekLast()[1] < dp[i]) q.pollLast();
                q.offerLast(new int [] {i, dp[i]});
            }
            return dp[0];
        }

        public long maxTaxiEarnings(int m, int[][] rides) { // tle tle tle
            int n = rides.length;
            Arrays.sort(rides, (a, b)-> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
            long [] dp = new long [n];
            dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
            long max = dp[0];
            // Queue<long []> q = new PriorityQueue<long []>((a, b)->(int)(b[1] - a[1]));
            // q.offer(new long [] {(long)rides[0][1], dp[0]});
            int [] cur = null, pre = null;
            for (int i = 1; i < n; i++) {
                cur = rides[i];
                // while (!q.isEmpty() && q.peek()[0] > cur[0]) q.poll();
                // dp[i] = (q.isEmpty() ? 0 : q.peek()[1]) + cur[1] - cur[0] + cur[2];
                dp[i] = cur[1] - cur[0] + cur[2];
                for (int j = i-1; j >= 0; j--) {
                    pre = rides[j];
                    if (pre[1] > cur[0]) continue;
                    dp[i] = Math.max(dp[i], dp[j] + cur[1] - cur[0] + cur[2]);
                }
                // q.offer(new long [] {(long)cur[1], dp[i]});
                max = Math.max(max, dp[i]);
            }
            return Arrays.stream(dp).max().getAsLong();
        }

        public int bestTeamScore(int [] scores, int [] ages) {
            int n = scores.length;
            List<int []> sur = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                sur.add(new int [] {age[i], scores[i]});
            Collections.sort(sur, (a, b)->a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int [] dp = new int [n]; // 这里的思路还没有想清楚
        }

        private long dfs(int i, int j, int k) {
            if (i < 0 || i >= m || j < 0 || j >= n) return 0;
            if (k == 1) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    if (m == 1 && n == 1) return dp[i][j][k] = 4l;
                    if (m == 1 || n == 1) {
                        if (m == 1 && (j == 0 || j == n-1)
                            || n == 1 && (i == 0 || i == m-1)) return dp[i][j][k] = 3l;
                        return dp[i][j][k] = 2l;
                    }
                    if ((i == 0 || i == m-1) && (j == 0 || j == n-1)) return dp[i][j][k] = 2l;
                    return dp[i][j][k] = 1l;
                }
                return dp[i][j][k] = 0l;
            }
            if (dp[i][j][k] != null) return dp[i][j][k];
            long ans = 0;
            for (int [] d : dirs) 
                ans = (ans + dfs(i+d[0], j+d[1], k-1)) % mod;
            return dp[i][j][k] = ans;
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        long mod = (int)1e9 + 7;
        Long [][][] dp;
        int m, n;
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            this.m = m;
            this.n = n;
            dp = new Long[m][n][maxMove+1];
            long ans = 0;
            for (int i = 1; i <= maxMove; i++) 
                ans = (ans + dfs(startRow, startColumn, i)) % mod;
            return (int)ans;
        }

        public int longestMountain(int[] a) {
            int n = a.length, i = 0, j = n-1, max = 0, cur = 0, bgn = 0;
            while (i < n-1 && a[i] >= a[i+1]) i++;
            while (j > 0 && a[j] >= a[j-1]) j--;
            if (i == n-1 || j == 0 || j == i) return 0;
            bgn = i;
            boolean invalid = false;
            while (i < j) {
                while (i < j && a[i] < a[i+1]) i++;
                if (i < j && i < n-1 && a[i] == a[i+1]) invalid = true;
                while (i < n-1 && i+1 <= j && a[i] >= a[i+1]) {
                    if (a[i] == a[i+1] && !invalid) invalid = true;
                    i++;
                }
                if (!invalid) max = Math.max(max, i-bgn + 1);
                invalid = false;
                bgn = i;
            }
            return max;
        }

        public int maxRotateFunction(int[] a) { // 草稿纸了推了很久，终于自己找递推公式找出来了
            int n = a.length, max = 0, sum = Arrays.stream(a).sum();
            for (int i = 0; i < n; i++) 
                max += i * a[i];
            int [] dp = new int [n];
            dp[0] = max;
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i-1] + sum - n*a[n-i];
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public int findSubstringInWraproundString(String t) { // 思路还不清楚
            int n = t.length();
            char [] s = t.toCharArray();
            long [] dp = new long [26];
        }

        private int dfs(int sur, int k, int dst) { // 图上的记忆化搜索, 还需要熟悉，落笔的时候总是远古时代不识记忆化搜索为何物的样子。。。。。。
            if (k < 0) return Integer.MAX_VALUE/ 2;
            if (map.get(sur) == null) return Integer.MAX_VALUE / 2;
            if (dp[sur][k] > 0) return dp[sur][k];
            int ans = Integer.MAX_VALUE / 2;
            for (int [] v : map.get(sur)) {
                if (v[0] == sur) continue;
                if (v[0] == dst) {
                    ans = Math.min(ans, v[1]);
                    continue;
                }
                ans = Math.min(ans, (k == 0 ? Integer.MAX_VALUE / 2 : v[1] + dfs(v[0], k-1, dst)));
            }
            return dp[sur][k] = ans;
        }
        Map<Integer, List<int []>> map = new HashMap<>();
        int [][] dp;
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            for (int [] f : flights) 
                map.computeIfAbsent(f[0], z -> new ArrayList<>()).add(new int [] {f[1], f[2]});
            dp = new int [n][k+1];
            int ans = dfs(src, k, dst);
            return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
        }

        public int subarrayBitwiseORs(int[] a) { // 这个现在有点儿想不清楚了，改天再写
            int n = a.length;
            int [] sum = Arrays.copyOf(a, n);
            Set<Integer> vis = new HashSet<>();
            Set<Integer> ss = new HashSet<>();
            // for (int i = 1; i < n; i++) sum[i] += sum[i-1];
            // System.out.println(Arrays.toString(sum));
            int [] or = Arrays.copyOf(a, n);
            for (int i = 1; i < n; i++) or[i] |= or[i-1];
            // System.out.println(Arrays.toString(or));
            for (int i = 0; i < n; i++) {
                // System.out.println("\n i: " + i);
                if (vis.size() > 0) {
                    Set<Integer> sn = new HashSet<>();
                    for (Integer v : vis)
                        if (or[i] != v)
                        sn.add(or[i] - v);
                    ss.addAll(sn);
                }
                vis.add(or[i]);
                // System.out.println("vis.size(): " + vis.size());
                // System.out.println(Arrays.toString(vis.toArray()));
            }
            // System.out.println("vis.size(): " + vis.size());
            // System.out.println(Arrays.toString(vis.toArray()));
            // System.out.println("ss.size(): " + ss.size());
            // System.out.println(Arrays.toString(ss.toArray()));
            ss.addAll(vis);
            ss.addAll(Arrays.stream(a).boxed().collect(Collectors.toList()));
            System.out.println("ss.size(): " + ss.size());
            System.out.println(Arrays.toString(ss.toArray()));
            return ss.size();
        }

        private double dfs(int n, int k, int maxPts) { // bug bug bug
            if (n == maxPts) return 1.0;
            if (maxPts > n) return dp[n][k] = (double)n / (double)maxPts;
            if (dp[n][k] > 0) return dp[n][k];
            double ans = 0;
            for (int i = 1; i <= maxPts; i++) {
                if (n - i >= k) continue;
                ans += 1.0 / (double)maxPts * dfs(n - i, k, maxPts);
            }
            return dp[n][k] = ans;
        }
        double [][] dp;
        public double new21Game(int n, int k, int maxPts) {
            dp = new double [n+1][k+1];
            return dfs(n, k, maxPts);
        }
        public double new21Game(int n, int k, int maxPts) {
            double [] dp = new double [n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
            }
        }

        public boolean checkValidString(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
        }

        public int minimizeTheDifference(int[][] mat, int target) {
            int m = mat.length, n = mat[0].length, min = 0, max = 0;
            for (int i = 0; i < m; i++) {
                Arrays.sort(mat[i]);
                min += mat[i][0];
                max += mat[i][n-1];
            }
            if (target <= min || target >= max) return Math.abs(target - (target <= min ? min : max));
            if (n == 1) return Math.abs(target - min);
            if (m == 1) {
                min = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) 
                    min = Math.min(min, Math.abs(target - mat[0][i]));
                return min;
            }
            Set<Integer> sum = new HashSet<>();
            sum.addAll(Arrays.stream(mat[0]).boxed().collect(Collectors.toList()));
            // 要存多少进set里，这里还得再想想

            
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        double r = s.new21Game(21, 17, 10);
        System.out.println("r: " + r);
    }
}

// TreeNode root = new TreeNode(a{0});
// root.buildTree(root, a);
// root.levelPrintTree(root);

//  for (TreeNode v : r) 
//      v.levelPrintTree(v);
