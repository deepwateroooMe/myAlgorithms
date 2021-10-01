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

//         privaet int getAns(String t) { // parse the string to get value, two stacks ,one for vals, and one for symbol
//             char [] s = t.toCharArray();
//             int n = s.length;
// // if no * ops, short cut to add
//             int i = 0, res = 0, j = 0;
//             if (t.indexOf('*') == -1) {
//                 while (i < n) {
//                     j = i;
//                     while (j < n && s[j] != '+') ++j;
//                     res += Integer.parseInt(t.substring(i, j));
//                     i = j+1;
//                 }
//                 return res;
//             }
//             Stack<Integer> si = new Stack<>();
//             Stack<Character> ss = new Stack<>();
//         }
//         public int scoreOfStudents(String s, int[] arr) {
//             int n = arr.length;
//             // 这个题目的举例给得不好，会不会还有其它不正确认算顺序的呢？先算加再算乘只有一种错法吗？
//         }


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


    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,3,1,15},{1,3,3,1}};
        int [][] a = new int [][] {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};

       long r = s.gridGame(a);
        System.out.println("r: " + r);
    }
}

