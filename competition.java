import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class competition {
    public static class Solution {

        // public String reversePrefix(String word, char ch) {
        //     int n = word.length();
        //     char [] sa = word.toCharArray();
        //     boolean contains = false;
        //     for (char c : sa) {
        //         if (c == ch) {
        //             contains = true;
        //             break;
        //         }
        //     }
        //     if (!contains || n == 1) return word;
        //     int i = 0;
        //     while (i < n && word.charAt(i) != ch) ++i;
        //     return new StringBuilder(word.substring(0, i+1)).reverse().toString() + word.substring(i+1);
        // }

        // public long interchangeableRectangles(int[][] rectangles) {
        //     int n = rectangles.length;
        //     Arrays.sort(rectangles, (a, b)->a[0] - b[0]);
        //     long cnt = 0;
        //     int [] a = null, b = null;
        //     for (int i = 0; i < n; i++) {
        //         a = rectangles[i];
        //         for (int j = i+1; j < n; j++) {
        //             b = rectangles[j];
        //             // System.out.println("((double)(a[0] / a[1])): " + ((double)(a[0]*1.0 / a[1])));
        //             // System.out.println("(double)(b[0]/b[1]): " + (double)(b[0]*1.0/b[1]));
        //             if (Math.abs((double)(a[0]*1.0 / a[1]) - (double)(b[0]*1.0/b[1])) <= 0.00001) ++cnt;
        //         }
        //     }
        //     return cnt;
        // }

        // public int maxProduct(String s) {
        //     int n = s.length();
        //     if (n == 2) return 1;
        //     if (n == 3) return (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) ? 2 : 1;
        //     int [][] dp = new int [n][n];
        //     dp[n-1][n-1] = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         dp[i][i] = 1;
        //         for (int j = i+1; j < n; j++) {
        //             if (s.charAt(i) == s.charAt(j))
        //                 dp[i][j] = 2 + dp[i+1][j-1];
        //             else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
        //         }
        //     }
        //     int max = 1, sec = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         for (int j = i+1; j < n; j++) {
        //             if (dp[i][j] == Math.max(dp[i+1][j], dp[i][j-1]) && dp[i+1][j] == dp[i][j-1] && dp[i][j] == dp[0][n-1])
        //                 return dp[0][n-1]*dp[0][n-1];
        //             else {
        //                 sec = max;
        //                 max = Math.max(max, dp[i][j]);
        //             }
        //         }
        //     }
        //     return sec * max;
        // }

        // public int countKDifference(int[] arr, int k) {
        //     int n = arr.length;
        //     int cnt =0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             if (Math.abs(arr[i] - arr[j]) == k) ++cnt;
        //     return cnt;
        // }

        // public long maxTaxiEarnings(int n, int[][] rides) { // 别人的写得很优雅又不会超时的
        //     Arrays.sort(rides, (a, b)-> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        //     long [] dp = new long [n+1];
        //     int j = 0;
        //     for (int i = 1; i <= n; i++) {
        //         dp[i] = Math.max(dp[i], dp[i-1]);
        //         while (j < rides.length && rides[j][0] == i) {
        //             dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
        //             ++j;
        //         }
        //     }
        //     return dp[n];
        // }

        // public int minOperations(int[] arr) { // 用双端队列
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     int maxNumInWindo = 0;
        //     Deque<Integer> q = new ArrayDeque<>();
        //     for (int v : arr) {
        //         while (q.size() > 0 && v - q.peekFirst() >= n) // 现值跟双端队列数小的一端比，超出域值范围的扔出去
        //             q.poll();
        //         // Add the new number to the window (if it's not a duplicate)
        //         if (q.size() == 0 || !q.peekLast().equals(v)) // 队列是空的，或者不是重复的数值（不等于最大值）？
        //             q.offer(v);
        //         maxNumInWindo = Math.max(maxNumInWindo, q.size());
        //     }
        //     return n-maxNumInWindo;
        // }
        // public int minOperations(int[] arr) { // 用树图
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     TreeMap<Integer, Integer> map = new TreeMap<>();
        //     int [] unq = new int [n];
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (!map.containsKey(arr[i])) cnt++;
        //         unq[i] = cnt;
        //         map.put(arr[i], i);
        //     }
        //     int max = 0;
        //     for (int key : map.keySet()) {
        //         Map.Entry<Integer, Integer> low = map.ceilingEntry(key - (n-1)); // 要把这些表达的概念想清楚：就是界定筛选过滤出当前值可能存在的上下边界的最大长度值
        //         Map.Entry<Integer, Integer> hi = map.floorEntry(key + (n-1));
        //         int hiLow = map.ceilingEntry(hi.getKey() - (n-1)).getValue();
        //         int lowHi = map.floorEntry(low.getKey() + (n-1)).getValue();
        //         int locMax = Math.max(unq[lowHi] - unq[low.getValue()]+1, unq[hi.getValue()] - unq[hiLow]+1);
        //         max = Math.max(max, locMax);
        //     }
        //     return n - max;
        // }


        // private int binarySearch(List<Integer> arr, int v, int l, int r) {
        //     if (l == r) return arr.get(l) == v ? l : -1;
        //     if (l == r-1) return arr.get(l) == v ? l : (arr.get(r) == v ? r : -1);
        //     int m = l + (r-l)/2;
        //     if (arr.get(m) == v) return m;
        //     if (arr.get(m) < v) return binarySearch(arr, v, m+1, r);
        //     return binarySearch(arr, v, l, m-1);
        // }
        // public int[] findOriginalArray(int[] arr) { // 还有两个测试没过
        //     int n = arr.length;
        //     if (n % 2 == 1) return new int [0];
        //     // if (n % 2 == 1 || Arrays.stream(arr).sum() % 3 != 0) return new int [0]; // 这里的sum()在数据比较大的情况下会overflow
        //     Arrays.sort(arr);
        //     List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //     int [] ans = new int [n/2];
        //     int idx = 0, i = 0;
        //     while (l.size() > 0) {
        //         ans[idx++] = l.get(0);
        //         i = binarySearch(l, l.get(0)*2, 1, l.size()-1);
        //         if (i == -1) return new int [0];
        //         l.remove(i);
        //         l.remove(0);
        //     }
        //     return ans;
        // } 
        // public int[] findOriginalArray(int[] arr) { 
        //     int n = arr.length;
        //     if (n % 2 == 1) return new int [0];
        //     int [] ans = new int [n/2];
        //     int idx = 0;
        //     Map<Integer, Integer> map = new TreeMap<>(); // 抄吧： 明白用不同图的不同了吧！！！
        //     for (int v : arr)
        //         map.put(v, map.getOrDefault(v, 0) + 1);
        //     for (int k : map.keySet()) {
        //         if (map.get(k) > map.getOrDefault(k+k, 0)) 
        //             return new int [0];
        //         for (int i = 0; i < map.get(k); i++) {
        //             ans[idx++] = k;
        //             map.put(k+k, map.get(k+k)-1);
        //         }
        //     }
        //     return ans;
        // }

        // public int finalValueAfterOperations(String[] arr) {
        //     int n = arr.length;
        //     Map<String, Integer> m = new HashMap<>();
        //     m.put("++X", 1);
        //     m.put("X++", 1);
        //     m.put("--X", -1);
        //     m.put("X--", -1);
        //     int ans = 0;
        //     for (int i = 0; i < n; i++) 
        //         ans += m.get(arr[i]);
        //     return ans;
        // }


        // public int sumOfBeauties(int[] arr) {
        //     int n = arr.length;
        //     int [] max = new int [n];
        //     int [] min = new int [n];
        //     int tmp = 0;
        //     for (int i = 1; i < n; i++) {
        //         tmp = Math.max(tmp, arr[i-1]);
        //         max[i] = tmp;
        //     }
        //     tmp = Integer.MAX_VALUE;
        //     for (int i = n-2; i >= 0; i--) {
        //         tmp = Math.min(tmp, arr[i+1]);
        //         min[i] = tmp;
        //     }
        //     int ans = 0;
        //     for (int i = 1; i < n-1; i++) {
        //         if (arr[i] > max[i] && arr[i] < min[i])
        //             ans += 2;
        //         else if (arr[i] > arr[i-1] && arr[i] < arr[i+1]) ans += 1;
        //     }
        //     return ans;
        // }


        // private boolean isSub(String s, String sub, int k) {
        //     int j = 0, repeat = 0;
        //     for (int i = 0; i < s.length(); i++) {
        //         if (s.charAt(i) == sub.charAt(j)) {
        //             j++;
        //             if (j == sub.length()) {
        //                 repeat++;
        //                 if (repeat == k) return true;
        //                 j = 0;
        //             }
        //         }
        //     }
        //     return false;
        // }
        // public String longestSubsequenceRepeatedK(String s, int k) {
        //     int n = 26;
        //     String res = "";
        //     Queue<String> q = new ArrayDeque<>();
        //     q.offer("");  // start from the shortest, gradually add characters to any valid subsequence.
        //     while (!q.isEmpty()) {
        //         int size = q.size();
        //         // BFS layer by layer, within each layer, the cur string has same length
        //         while (size-- > 0) {
        //             String cur = q.poll();
        //             for (int i = 0; i < n; i++) {
        //                 String next = cur + (char)('a' + i); // 好疯啊： 从来没有想过还有这种生成序列的方法
        //                 if (isSub(s, next, k)) {
        //                     res = next; // always update res since we are looking for lexicographically largest.
        //                     q.offer(next);
        //                 }
        //             }
        //         }
        //     }
        //     return res;
        // }
        // private String bfs(String s, int k) { // 另一种善用裁枝的
        //     Queue<String> q = new LinkedList<>();
        //     q.offer("");
        //     while (!q.isEmpty()) {
        //         int size = q.size();
        //         for (int j = 0; j < size; j++) {
        //             String cur = q.poll();
        //             for (char c : l) {
        //                 String next = cur + c;
        //                 if (isSub(s, next, k)) {
        //                     res = next;
        //                     q.offer(next);
        //                 }
        //             }
        //         }
        //     }
        //     return res;
        // }
        // private boolean isSub(String s, String sub, int k) {
        //     int j = 0, repeat = 0;
        //     for (int i = 0; i < s.length(); i++) {
        //         if (s.length() - i < (k-repeat-1) * sub.length()) return false;
        //         if (s.charAt(i) == sub.charAt(j)) {
        //             j++;
        //             j %= sub.length();
        //             if (j == 0) {
        //                 repeat++;
        //                 if (repeat == k) return true;
        //             }
        //         }
        //     }
        //     return false;
        // }
        // private void dfs(String s, String sub, int k) {
        //     if (sub.length() > 1 && !isSub(s, sub, k)) return;
        //     if (sub.length() > res.length()) res = sub;
        //     for (int i = l.size()-1; i >= 0; i--) {
        //         String next = sub + l.get(i);
        //         dfs(s, next, k);
        //     }
        // }
        // List<Character> l = new ArrayList<>();
        // String res = "";
        // public String longestSubsequenceRepeatedK(String s, int k) {
        //     int [] cnt = new int [26];
        //     for (Character c : s.toCharArray()) 
        //         cnt[c-'a']++;
        //     for (char c = 'a'; c <= 'z'; c++) 
        //         if (cnt[c-'a'] >= k) l.add(c);
        //     dfs(s, "", k);
        //     return res;
        // }


       //  public int maximumDifference(int[] arr) {
       //      int n = arr.length, max = -1;
       //      for (int i = 0; i < n; i++) 
       //          for (int j = i+1; j < n; j++) 
       //              if (arr[i] < arr[j]) 
       //                  max = Math.max(max, arr[j]-arr[i]);
       //      return max;
       // } 

        // public long gridGame(int[][] bd) {
        //     int m = bd.length;
        //     int n = bd[0].length;
        //     long [][] sum = new long [m][n+1];
        //     for (int j = 1; j <= n; j++) {
        //         sum[0][j] = sum[0][j-1] + bd[0][j-1];
        //         sum[1][j] = sum[1][j-1] + bd[1][j-1];
        //     }
        //     long [] dp = new long [n];
        //     long res = Long.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         if (i == n-1) dp[i] = sum[1][i];
        //         else if (i == 0) dp[i] = sum[0][n] - sum[0][i+1];
        //         else dp[i] = Math.max(sum[0][n] - sum[0][i+1], sum[1][i]);
        //         res = Math.min(res, dp[i]);
        //     }
        //     return res;
        // }


        // private Boolean dfs(char [][] arr, String s, int i, int j, int idx, int d) { // 还需要剪枝
        //     // System.out.println("\ni: " + i);
        //     // System.out.println("j: " + j);
        //     // System.out.println("idx: " + idx);
        //     // System.out.println(" (idx == s.length() && (arr[i][j] == ' ' || Character.isLowerCase(arr[i][j]))): " +  (idx == s.length() && (arr[i][j] == ' ' || Character.isLowerCase(arr[i][j]))));
        //     if (i == m || j == n) return idx == s.length();
        //     if (idx == s.length() && (arr[i][j] == ' ' || Character.isLowerCase(arr[i][j])))
        //         return vis[i][j] = false;
        //     else if (idx == s.length()) return vis[i][j] = true;
        //     if (vis[i][j] != null) return vis[i][j];
        //     if (arr[i][j] == '#') return vis[i][j] = false;
        //     if (Character.isLowerCase(arr[i][j]) && arr[i][j] != s.charAt(idx)) return vis[i][j] = false;
        //     if (d == 0) return vis[i][j] = dfs(arr, s, i, j+1, idx+1, d); // horizontal
        //     else return vis[i][j] = dfs(arr, s, i+1, j, idx+1, d);        // vertical
        // }
        // Boolean [][] vis;
        // int m, n;
        // public boolean placeWordInCrossword(char[][] board, String word) {
        //     m = board.length;
        //     n = board[0].length;
        //     vis = new Boolean[m][n];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) { // 昨天晚上没休息好，今天太累，这些细节转得好晕,改天再回来写，今天只把电脑系统运行环境弄好
        //             if (board[i][j] == ' ' || board[i][j] == word.charAt(0) || board[i][j] == word.charAt(word.length()-1)) {
        //                 if ((i == 0 || board[i-1][j] == '#')
        //                     && (board[i][j] == word.charAt(0) ? dfs(board, word, i, j, 0, 1) :
        //                         dfs(board, (new StringBuilder(word)).reverse().toString(), i, j, 0, 1)))
        //                     return true;
        //                 vis = new Boolean[m][n];
        //                 if ((j == 0 || board[i][j-1] == '#')
        //                     && (board[i][j] == word.charAt(0) ? dfs(board, word, i, j, 0, 0) :
        //                         dfs(board, (new StringBuilder(word)).reverse().toString(), i, j, 0, 0)))
        //                     // && dfs(board, word, i, j, 0, 0))
        //                     return true;
        //             }
        //         }
        //     return false;
        // }


        // public int[][] construct2DArray(int[] original, int m, int n) {
        //     int o = original.length;
        //     if (o != m * n) return new int [0][0];
        //     int [][] ans = new int [m][n];
        //     int idx = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //            ans[idx/n][idx%n] = original[idx++];
        //     return ans;
        // }
        // public int numOfPairs(String[] nums, String target) { // hashing
        //     int n = target.length();
        //     int res = 0;
        //     for (int i = 0; i < nums.length; i++) 
        //         for (int j = 0; j < nums.length; j++) {
        //             if (i == j || !target.startsWith(nums[i])) continue;
        //             if (target.substring(nums[i].length()).equals(nums[j])) ++res;
        //         }
        //     return res;
        // }
        // public int maxConsecutiveAnswers(String answerKey, int k) {
        //     int n = answerKey.length();
        //     if (n == 1) return 1;
        //     if (k >= n) return n;
        //     Map<Character, Integer> m = new HashMap<>();
        //     int i = 0, j = -1, max = 0, locMax = 0;
        //     while (j < n) {
        //         if (j == -1) j = i;
        //         while (j < n && (Math.min(m.getOrDefault('T', 0), m.getOrDefault('F', 0)) <= k)) {
        //             m.put(answerKey.charAt(j), m.getOrDefault(answerKey.charAt(j), 0) + 1);
        //             ++j;
        //         }
        //         locMax = m.getOrDefault('T', 0) + m.getOrDefault('F', 0) - (Math.min(m.getOrDefault('T', 0), m.getOrDefault('F', 0)) <= k ? 0 : 1);
        //         max = Math.max(max, locMax);
        //         m.put(answerKey.charAt(i), m.get(answerKey.charAt(i))-1);
        //         if (m.get(answerKey.charAt(i)) == 0) m.remove(answerKey.charAt(i));
        //         ++i;
        //     }
        //     return max;
        // }


        // public int[] missingRolls(int[] rolls, int mean, int n) {
        //     int m = rolls.length;
        //     int v = mean * (m + n) - Arrays.stream(rolls).sum();
        //     if (v > n * 6 || v < n) return new int [0];
        //     int sum = mean * (m + n) - Arrays.stream(rolls).sum();
        //     int [] ans = new int [n];
        //     Arrays.fill(ans, 1);
        //     sum -= n;
        //     int i = 0;
        //     while (sum > 0 && i < n) {
        //         ans[i++]++;
        //         --sum;
        //         if (i == n) i = 0;
        //     }
        //     return ans;
        // }
        // public int minimumMoves(String s) {
        //     int n = s.length();
        //     int i = 0, cnt = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) == 'O') ++i;
        //         if (i == n) return cnt;
        //         ++cnt;
        //         i += 3;
        //     }
        //     return cnt;
        // }

        
        // public String smallestSubsequence(String s, int k, char letter, int repetition) {
        //     int n = s.length();
        //     if (n == k) return s;
        //     int i = 0, cnt = 0, j = 0;
        //     String res = "";
        //     while (j < n) {
        //         while (cnt < repetition && j < n) {
        //             if (s.charAt(j) == letter) ++cnt;
        //             ++j;
        //         }
        //         if (j - i == k && (res.equals("") || res.compareTo(s.substring(i, j)) > 0))
        //             res = s.substring(i, j);
        //         else if (i + k > j) {
        //             while (i + k > j && j < n) {
        //                 if (s.charAt(j) == letter) ++cnt;
        //                 ++j;   
        //             }
        //         } // 我觉得这里需要借助什么数据结构或dp来理一下思路，有点儿混乱
        //         if (res.compareTo(s.substring(i, j)) > 0) res = s.substring(i, j);
        //         while (i < j && cnt > repetition){
        //             ++i;  
        //         } 
        //     }
        // }


        // private boolean dfs(int val, int one, int two, int zro) {
        //     if (val == 0) return true;
        //     String key = one + "-" + two + "-" + zro + "-" + val;
        //     if (dp.containsKey(key)) return dp.get(key);
        //     if (one == 0 && two == 0 && zro == 0) return n % 2 != 0; // 题目这个要求我可能没有理解清楚
        //     boolean res = false;
        //     if (!res && one > 0 && val != 2) 
        //         if (!dfs((val+1) % 3, one-1, two, zro)) 
        //             res = true;
        //     if (!res && two > 0 && val != 1)
        //         if (!dfs((val + 2) % 3, one, two-1, zro))
        //             res = true;
        //     if (!res && zro > 0 && val != 0)
        //         if (!dfs((val+0) % 3, one, two, zro-1))
        //             res = true;
        //     dp.put(key, res);
        //     return res;
        // }
        // Map<String, Boolean> dp = new HashMap<>();
        // int n;
        // public boolean stoneGameIX(int[] stones) {
        //     n = stones.length;
        //     dp = new HashMap<String, Boolean>();
        //     int one = 0, two = 0, zro = 0;
        //     for (int v : stones)
        //         if (v % 3 == 0) zro++;
        //         else if (v % 3 == 1) one++;
        //         else two++;
        //     return dfs(3, one, two, zro % 2);
        // }
        // public boolean stoneGameIX(int[] stones) {
        //     int[] cnt = new int[3];
        //     for (int a: stones)
        //         cnt[a % 3]++;
        //     if (Math.min(cnt[1], cnt[2]) == 0)
        //         return Math.max(cnt[1], cnt[2]) > 2 && cnt[0] % 2 > 0;
        //     return Math.abs(cnt[1] - cnt[2]) > 2 || cnt[0] % 2 == 0;
        // }


      // private int getAns(String s) { 
      //     int n = s.length();
      //     int j = 0, i = 0;
      //     Stack<Integer> va = new Stack<>();
      //     Stack<Character> sn = new Stack<>();
      //     for (i = 0; i < n; i++) {
      //         char c = s.charAt(i);
      //         if (c == '+' || c == '*') {
      //             sign[si++] = c;
      //             sn.push(c);
      //             continue;
      //         } else {
      //             j = i+1;
                  
      //             while (j < n && Character.isDigit(s.charAt(j))) ++j;
      //             num[vi] = Integer.parseInt(s.substring(i, j)); // bug
      //             va.push(num[vi++]);
      //             if (j - i > 1)
      //                 i = j-1;
      //         }
      //         while (sn.size() > 0 && sn.peek() == '*' && va.size() >= 2) {
      //             int ans = va.pop() * va.pop();
      //             sn.pop();
      //             va.push(ans);
      //         }
      //     }
      //     while (!sn.isEmpty()) {
      //         int ans = va.pop() + va.pop();
      //         sn.pop();
      //         va.push(ans);
      //     }
      //     return va.peek();
      // }
      //   Map<String, Set<Integer>> m = new HashMap<>(); // memo all possile ans of the string
      //   int [] num;
      //   char [] sign;
      //   int si, vi;
      //   public int scoreOfStudents(String s, int [] arr) { 
      //       int n = arr.length;
      //       num = new int [n];
      //       sign = new char[n];
      //       si = 0;
      //       vi = 0;
      //       int ans = getAns(s);
      //       return 0;
      //   }


        // public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        //     Set<Integer> res = new HashSet<>();
        //     Set<Integer> a = new HashSet<>();
        //     Set<Integer> b = new HashSet<>();
        //     Set<Integer> c = new HashSet<>();
        //     a.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        //     b.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        //     c.addAll(Arrays.stream(nums3).boxed().collect(Collectors.toList()));
        //     Set<Integer> tmp = new HashSet<>();
        //     tmp.addAll(a);   
        //     tmp.retainAll(c); // a c 
        //     a.retainAll(b);   // a & b a modified
        //     res.addAll(c); 
        //     res.retainAll(b); // c & b
        //     res.addAll(a);
        //     res.addAll(tmp);
        //     return new ArrayList<>(res);
        // }

        // public int minimumDifference(int[] arr) {
        //     int n = arr.length, range = 1 << n, cur = 0;
        //     int sum = Arrays.stream(arr).sum();
        //     Set<Integer> s = new HashSet<>();
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < range; i++) {
        //         if (Integer.bitCount(i) != n/2) continue;
        //         cur = 0;
        //         for (int j = 0; j < n; j++) {
        //             if (((i >> j) & 1) == 1) {
        //                 cur += arr[j];
        //             }
        //         }
        //         if (s.contains(sum - cur)) 
        //             min = Math.min(min, Math.abs(sum-cur-cur));
        //         else s.add(cur);
        //     }
        //     return min;
        // }


        // public int minOperations(int [][] grid, int x) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     List<Integer> al = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             al.add(grid[i][j]);
        //     Collections.sort(al);
        //     int median = al.get((al.size()-1)/2);
        //     int cnt = 0;
        //     for (int  i : al) {
        //         if (i != median) {
        //             int diff = Math.abs(i - median);
        //             if (diff % x != 0) return -1;
        //             cnt += diff / x;
        //         }
        //     }
        //     return cnt;
        // }


        // public int waysToPartition(int[] arr, int k) { // todo: this problem needs deeper understanding
        //     int n = arr.length;
        //     long [] sum = new long [n];
        //     long totalSum = (long)Arrays.stream(arr).sum();
        //     for (int i = 0; i < n; i++) 
        //         sum[i] = (i == 0 ? 0 : sum[i-1]) + arr[i];
        //     int res = 0;
        //     Map<Long, Integer> leftSum = new HashMap<>(), rightSum = new HashMap<>();
        //     for (int i = 1; i < n; i++) 
        //         if (sum[i-1] == sum[n-1] - sum[i-1]) ++res;
        //     long cur = 0;
        //     for (int i = n-1; i > 0; i--) {
        //         cur += arr[i];
        //         rightSum.put(cur, rightSum.getOrDefault(cur, 0) + 1);
        //     }
        //     long newSum = totalSum + (long)k - arr[0];
        //     if (newSum % 2 == 0 && rightSum.containsKey(newSum / 2))
        //         res = Math.max(res, rightSum.get(newSum / 2));
        //     cur = 0;
        //     for (int i = 1; i < n; i++) {
        //         cur += arr[i-1];
        //         leftSum.put(cur, leftSum.getOrDefault(cur, 0) + 1);
        //         if (rightSum.containsKey(totalSum - cur)) {
        //             int freq = rightSum.get(totalSum - cur);
        //             if (freq == 1) rightSum.remove(totalSum - cur);
        //             else rightSum.put(totalSum - cur, freq - 1);
        //         }
        //         newSum = totalSum + (long)k - arr[i];
        //         if (newSum % 2 != 0) continue;
        //         int cntLeft = leftSum.getOrDefault(newSum/2, 0), cntRight = rightSum.getOrDefault(newSum/2, 0);
        //         res = Math.max(res, cntLeft + cntRight);
        //     }
        //     return res;
        // }


        // public int minMovesToSeat(int[] seats, int[] students) {
        //     Arrays.sort(seats);
        //     Arrays.sort(students);
        //     int ans = 0;
        //     for (int i = 0; i < seats.length; i++) 
        //         ans += Math.abs(seats[i] - students[i]);
        //     return ans;
        // }


        // public boolean winnerOfGame(String s) {
        //     int n = s.length();
        //     if (n <= 2) return false;
        //     int cnta = (s.charAt(0) == 'A' ? 1 : 0), cntb = (s.charAt(0) == 'B' ? 1 : 0), i = 0, j = 0;
        //     int tta = 0, ttb = 0;
        //     while (i < n) {
        //         while (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
        //             if (s.charAt(i) == 'A') cnta++;
        //             else cntb++;
        //             i++;
        //         }
        //         if (i == 0) {
        //             i = 1;
        //             j = 1;
        //             continue;
        //         }
        //         if (cnta >= 3 && s.charAt(i) == 'A') {
        //             cnta -= 2;
        //             tta += cnta;
        //         } else if (cntb >= 3 && s.charAt(i) == 'B'){
        //             cntb -= 2;
        //             ttb += cntb;
        //         } 
        //         j = i+1;
        //         i++;
        //         if (i == n) break;
        //         cnta = (s.charAt(i) == 'A' ? 1 : 0);
        //         cntb = (s.charAt(i) == 'B' ? 1 : 0);
        //     }
        //     return tta > ttb;
        // }

        
        // private void dijkstra(int idx) { // 不知道哪个细节错了
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {idx, 0});
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int u = cur[0];
        //         int d = cur[1];
        //         if (t[u] < d || m.get(u) == null) continue;
        //         for (Integer v : m.get(u)) 
        //             if (t[v] > t[u] + 1) {
        //                 t[v] = t[u] + 1;
        //                 q.offer(new int [] {v, t[v]});
        //             }
        //     }
        // }
        // Map<Integer, List<Integer>> m = new HashMap<>();
        // int [] t;
        // public int networkBecomesIdle(int[][] edges, int[] patience) { // 不知道哪个细节错了
        //     for (int [] e : edges) {
        //         m.computeIfAbsent(e[0], z -> new ArrayList<>()).add(e[1]);
        //         m.computeIfAbsent(e[1], z -> new ArrayList<>()).add(e[0]);
        //     }
        //     t = new int [m.size()];
        //     Arrays.fill(t, Integer.MAX_VALUE);
        //     t[0] = 0;
        //     dijkstra(0); // 你想先把耗时算出来，然后统一管理，但实际上可以一次遍历达到所有的目的，不用分两次
        //     for (int i = 0; i < t.length; i++) 
        //         t[i] *= 2;
        //     System.out.println(Arrays.toString(t));
        //     Queue<int []> q = new PriorityQueue<>((a, b)->(a[1]+t[a[0]]/2)-(b[1]+t[b[0]]/2));
        //     Set<String> vis = new HashSet<>();
        //     for (Integer key : m.keySet()) 
        //         if (key != 0) {
        //             q.offer(new int [] {key, 0});
        //             vis.add(""+key+"_0");
        //         }
        //     int now = 1, ans = 0;
        //     int [] tt = new int [m.size()];
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int i = cur[0], time = cur[1] + t[i] / 2;
        //         if (tt[i] == 0) // 只设置一次，到了这个时间点，就不再重发了
        //             tt[i] = cur[1] + t[i];
        //         now = Math.max(now, time); // ???
        //         ans = cur[1] + t[i] + 1;
        //         if (patience[i] >= t[i] && q.size() > 0) continue;
        //         if (patience[i] >= t[i] && q.isEmpty()) return cur[1] + t[i] + 1;
        //         if (now >= tt[i]) continue;
        //         for (int j = cur[1]+1; j <= Math.min(now, tt[i]-1); j++) {
        //             String tmp = "" + i + "_" + j;
        //             if (vis.contains(tmp)) continue;
        //             q.offer(new int [] {i, j});
        //             vis.add(tmp);
        //         }
        //     }
        //     return ans;
        // }
        // public int networkBecomesIdle(int[][] edges, int[] patience) {
        //     int n = patience.length;
        //     List<List<Integer>> adj = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         adj.add(new ArrayList<>());
        //     for (int [] e : edges) {
        //         adj.get(e[0]).add(e[1]);
        //         adj.get(e[1]).add(e[0]);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     q.offer(0);
        //     int [] vis = new int [n];
        //     Arrays.fill(vis, -1); // you can remove Arrays.fill(visited, -1); and instead just check visited[next] == 0 since it's a connected graph.
        //     vis[0] = 0;
        //     // vis[0] = 1; // 按照以上建议，也可以把它mark出来以避开重复遍历
        //     int time = 0;
        //     while (!q.isEmpty()) {
        //         time++;
        //         for (int size = q.size(); size > 0; size--) {
        //             int cur = q.poll();
        //             System.out.println("cur: " + cur);
        //             for (Integer next : adj.get(cur)) 
        //                 // if (vis[next] == 0) { // 会把0 node重复遍历好多次，但不影响结果正确性，只是重复遍历了它好多次
        //                 if (vis[next] == -1) {
        //                     q.offer(next);
        //                     vis[next] = 2 * time;
        //                 }
        //         }
        //     }
        //     int res = 0;
        //     for (int i = 1; i < vis.length; i++) {
        //         int travelTime = vis[i];
        //         int k = travelTime / patience[i]; // how many messages send after first message
        //         if (travelTime % patience[i] == 0) k--;
        //         int totalTime = k * patience[i] + travelTime;
        //         res = Math.max(res, totalTime);
        //     }
        //     return res + 1;
        // }


        // public long kthSmallestProduct(int[] a, int[] b, long k) { 
        //     int m = a.length; // ma mb, na, nb 0 four five cnts, 
        //     int n = b.length; // 以m or n为单位向前推进，找到第 a, a+(m/n) >= k个数，
        //     int l = 0, r = m*n-1;
        //     while (l <= r) {
        //         int m = l + (r-l)/2;
        //     }
        // }


        // public boolean areNumbersAscending(String so) {
        //     String [] arr = so.split("\\s+");
        //     System.out.println(Arrays.toString(arr));
        //     List<Integer> l = new ArrayList<>();
        //     for (String s : arr) {
        //         if (Character.isDigit(s.charAt(0)))
        //             l.add(Integer.parseInt(s));
        //     }
        //     if (l.size() <= 1) return true;
        //     for (int i = 1; i < l.size(); i++) 
        //         if (l.get(i) <= l.get(i-1)) return false;
        //     return true;
        // }


        // public int countMaxOrSubsets(int[] arr) {
        //     int n = arr.length, range = (1 << n);
        //     Map<Integer, Set<Integer>> m = new HashMap<>();
        //     int cur = 0;
        //     for (int i = 1; i < range; i++) {
        //         cur = 0;
        //         for (int j = 0; j < n; j++) 
        //             if (((i >> j) & 1) == 1) cur |= arr[j];
        //         m.computeIfAbsent(cur, z -> new HashSet<>()).add(i);
        //     }
        //     Map<Integer, Set<Integer>> tmp = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())) 
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     return tmp.entrySet().iterator().next().getValue().size();
        // }


        public int secondMinimum(int n, int[][] edges, int time, int change) {
            List<List<Integer>> ll = new ArrayList<>();
            for (int i = 0; i <= n; i++) 
                ll.add(new ArrayList<>());
            for (int [] e : edges) {
                ll.get(e[0]).add(e[1]);
                ll.get(e[1]).add(e[0]);
            }
            int min = Integer.MAX_VALUE, t = 0;
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {1, 0}); // [idx, time]
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                System.out.println(Arrays.toString(cur));
                t = cur[1] + time; // now
                boolean bk = false;
                for (Integer next : ll.get(cur[0])) {
                    if (next == n) 
                        if (min == Integer.MAX_VALUE) {
                            min = t;
                            bk = true;
                            break;
                        }
                        // else {
                        //     if (t == min) continue;
                        //     return t;
                        // }
                    if ((t / change) % 2 == 0) {
                        q.offer(new int [] {next, t});
                    } else {
                        q.offer(new int [] {next, t + change - t % change});
                    }
                }
                if (bk) break;
            }
            System.out.println("t: " + t);
            
            int cnt = 0;
            while (cnt < 2) {
                t += time;
                if (cnt == 1) break;
                System.out.println("t: " + t);
                // if ((t / change) % 2 == 0) {
                //     t += time;
                // } else {
                if ((t / change) % 2 == 1) {
                    t += change - t % change;
                }
                ++cnt;
            }
            return t;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2},{1,3},{1,4},{3,4},{4,5}};
        int r = s.secondMinimum(5, a, 3, 5);

        // int[] [] a = new int [][] {{1, 2}};
        // int r = s.secondMinimum(2, a, 3, 2);

        System.out.println("r: " + r);
    }
}