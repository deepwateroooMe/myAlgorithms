// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dynaninemicProgramming {
    public static class Solution {

        // private int getDist(int [] arr, int i, int j) { // 求区间start到end间放置邮筒后的距离和 i: left, j: right
        //     if (dist[i][j] > 0) return dist[i][j];
        //     int m = i + (j-i)/2, v = arr[m], sum = 0;
        //     for (int k = i; k <= j; k++) 
        //         sum += Math.abs(arr[k] - v);
        //     return dist[i][j] = sum;
        // }
        // private int dfs(int [] arr, int idx, int k) {  // idx: 待分割大子区间的起始坐标；k: 待分割成的子区间的个数 
        //     if (idx == n || idx == n-k) return 0;
        //     if (dp[idx][k] > 0) return dp[idx][k];
        //     if (k == 1) return dp[idx][k] = getDist(arr, idx, n-1);
        //     int res = Integer.MAX_VALUE;
        //     for (int i = idx; i < n-(k-1); i++) 
        //         res = Math.min(res, getDist(arr, idx, i) + dfs(arr, i+1, k-1));
        //     return dp[idx][k] = res;
        // }
        // int [][] dp;
        // int [][] dist;
        // int n;
        // public int minDistance(int [] houses, int k) {
        //     n = houses.length;
        //     dist = new int [n][n];
        //     dp = new int [n][k+1];
        //     Arrays.sort(houses);
        //     return dfs(houses, 0, k);
        // }


        // public int minOperationsToFlip(String expression) {
        //     char [] exp = expression.toCharArray();  // 转为char[]简化代码
        //     Deque<Integer> num = new LinkedList<>(); // 栈，存储当前表达式的结果值
        //     Deque<Integer> op = new LinkedList<>();  // 栈，存储反转当前表达式的最小操作次数，与表达式结果栈中的元素一一对应（二者也可合并为一个存储了对应数组的栈）
        //     Deque<Character> sign = new LinkedList<>();// 符号栈
        //     for (char e : exp) {
        //         if (e == '(' || e == '&' || e == '|') {// 除')'以外的符号直接入栈
        //             sign.offerFirst(e);
        //             continue;
        //         } else if (e == ')') {// 遇到右括号，弹出上一左括号，触发后续计算
        //             sign.pollFirst();
        //         } else {// 遇到数字，入栈
        //             num.offerFirst((int)(e - '0'));// 数值
        //             op.offerFirst(1);// 任意单个数值反转操作次数为1
        //         }
        //         // 计算当前可处理的表达式部分
        //         if (num.size() > 1 && sign.peekFirst() != '(') {// 栈中存在超过2个数字，且未被括号分隔，可处理
        //             int [] result = minOp(num.pollFirst(), num.pollFirst(), op.pollFirst(), op.pollFirst(), sign.pollFirst());// 计算当前表达式的值和最小反转操作次数
        //             num.offerFirst(result[0]);
        //             op.offerFirst(result[1]);
        //         }
        //     }
        //     return op.peekFirst();// 反转操作次数栈此时只剩1个元素，就是整个表达式反转的最小操作次数
        // }
        // // 针对计算当前表达式中的2个元素，计算值和最小反转操作次数
        // public int[] minOp(int num1, int num2, int op1, int op2, char sign) {
        //     if (sign == '&') {
        //         if (num1 == 1 && num2 == 1)// 1&1,将其中一个1反转为0
        //             return new int[]{1, Math.min(op1, op2)};
        //         else if (num1 == 0 && num2 == 0)// 0&0,将其中一个0反转为1,并将&反转为|
        //             return new int[]{0, Math.min(op1, op2) + 1};
        //         else// 1&0,将&反转为|
        //             return new int[]{0, 1};
        //     } else {
        //         if (num1 == 0 && num2 == 0)// 0|0，将其中一个0反转为1
        //             return new int[]{0, Math.min(op1, op2)};
        //         else if (num1 == 1 && num2 == 1)// 1|1,将其中一个1反转为0，并将|反转为&
        //             return new int[]{1, Math.min(op1, op2) + 1};
        //         else// 1|0,将|反转为&
        //             return new int[]{1, 1};
        //     }
        // }
        // private int [] getMinOperations(int va, int vb, int ca, int cb, char sign) {
        //     if (sign == '&') {
        //         if (va == 1 && vb == 1)      // 1&1, 将其中一个1反转为0
        //             return new int [] {1, Math.min(ca, cb)};
        //         else if (va == 0 && vb == 0) // 0&0, 将其中一个0反转为1,并将&反转为|
        //             return new int [] {0, Math.min(ca, cb) + 1};
        //         else return new int [] {0, 1}; // 1&0, 将&反转为|
        //     } else {
        //         if (va == 1 && vb == 1)        // 1|1,将其中一个1反转为0，并将|反转为&
        //             return new int [] {1, Math.min(ca, cb) + 1};
        //         else if (va == 0 && vb == 0)   // 0|0，将其中一个0反转为1
        //             return new int [] {0, Math.min(ca, cb)};
        //         else return new int [] {1, 1}; // 1|0,将|反转为&
        //     }
        // }
        // public int minOperationsToFlip(String expression) {
        //     Stack<Integer> res = new Stack<>();
        //     Stack<Character> sgn = new Stack<>();
        //     Stack<Integer> cnt = new Stack<>();
        //     for (char c : expression.toCharArray()) {
        //         if (c == '(' || c == '&' || c == '|') {
        //             sgn.push(c);
        //             continue;
        //         } else if (c == ')') sgn.pop();
        //         else {
        //             res.push((int)(c - '0'));
        //             cnt.push(1);
        //         }
        //         if (res.size() > 1 && sgn.peek() != '(') {
        //             int [] loc = getMinOperations(res.pop(), res.pop(), cnt.pop(), cnt.pop(), sgn.pop());
        //             res.push(loc[0]); // expr results
        //             cnt.push(loc[1]); // min operations
        //         }
        //     }
        //     return cnt.peek();
        // }

        
        // private boolean hasApple(int rx, int ry, int cx, int cy) {
        //     for (int i = rx; i <= ry; i++) 
        //         for (int j = cx; j <= cy; j++) 
        //             if (arr[i][j] == 'A') return true;
        //     return false;
        // }
        // private int dfs(int x, int y, int k) {
        //     if (k == 1) return hasApple(x, m-1, y, n-1) ? 1 : 0;  
        //     if (dp[x][y][k] != null) return dp[x][y][k];
        //     long res = 0;
        //     for (int i = x; i < m-1; i++) { // horizontal
        //         if (hasApple(x, i, y, n-1)) 
        //             res = (res + dfs(i+1, y, k-1)) % mod;
        //     }
        //     for (int j = y; j < n-1; j++) {
        //         if (hasApple(x, m-1, y, j))
        //         res = (res + dfs(x, j+1, k-1)) % mod;
        //     }
        //     return dp[x][y][k] = (int)res;
        // }
        // Integer [][][] dp;
        // char [][] arr;
        // int m, n, mod = (int)1e9 + 7;
        // public int ways(String[] pizza, int k) {
        //     if (k == 1) return 1;
        //     m = pizza.length;
        //     n = pizza[0].length();
        //     arr = new char [m][n];
        //     for (int i = 0; i < m; i++) 
        //         arr[i] = pizza[i].toCharArray();
        //     dp = new Integer [m][n][k+1];
        //     return dfs(0, 0, k);
        // }
        // private int dfs(int x, int y, int k) {
        //     if (x > m || y > n) return 0;
        //     if (k == 1) {
        //         int sum = arr[m][n] - arr[x-1][n] - arr[m][y-1] + arr[x-1][y-1];
        //         return sum > 0 ? 1 : 0;  
        //     } 
        //     if (dp[x][y][k] > 0) return dp[x][y][k];
        //     if (x == m && y == n) return 0;
        //     long res = 0, sum = 0;
        //     for (int i = x; i < m; i++) { // horizontal
        //         if (arr[i][n] - arr[x-1][n] - arr[i][y-1] + arr[x-1][y-1] == 0) continue;
        //         res = (res + dfs(i+1, y, k-1)) % mod;
        //     }
        //     for (int j = y; j < n; j++) {
        //         if (arr[m][j] - arr[m][y-1] - arr[x-1][j] + arr[x-1][y-1] == 0) continue;
        //         res = (res + dfs(x, j+1, k-1)) % mod;
        //     }
        //     return dp[x][y][k] = (int)res;
        // }
        // int [][][] dp;
        // int [][] arr;
        // int m, n, mod = (int)1e9 + 7;
        // public int ways(String[] pizza, int k) {
        //     if (k == 1) return 1;
        //     m = pizza.length;
        //     n = pizza[0].length();
        //     arr = new int [m+1][n+1];
        //     int cnt = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             arr[i][j] = arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1] + (pizza[i-1].charAt(j-1) == 'A' ? 1 : 0);
        //     dp = new int [m+1][n+1][k+1];
        //     dfs(1, 1, k);
        //     return dp[1][1][k];
        // } 

        
        // private Set<Integer> dfs(int v, int x, int y) { 
        //     Map<Integer, Set<Integer>> m = new HashMap<>();
        //     Set<Integer> tmp = new HashSet<>();
        //     tmp.add(0);
        //     m.put(0, tmp);
        //     int n = Integer.bitCount(v), idx = n / 2, cur = 0, va = 0, vb = 0, j  = 0;
        //     for (int i = idx; i < n; i++) {
        //         for (Integer val : m.get(i-idx)) {
        //             if (i == idx) {
        //                 cur = 1 << idx;
        //                 m.computeIfAbsent(1, k -> new HashSet<>()).add(cur);
        //                 if (n % 2 == 1) continue;
        //                 cur = 1 << idx-1;
        //                 m.computeIfAbsent(1, k -> new HashSet<>()).add(cur);
        //                 if (idx == x && idx-1 == y || idx == y && idx-1 == x) {
        //                     min = Math.min(min, 1);
        //                     max = Math.max(max, 1);
        //                 }
        //                 continue;
        //             }
        //             va = val | 1 << i;
        //             m.computeIfAbsent(i-idx+1, k -> new HashSet<>()).add(va);
        //             if (n % 2 == 1) j = idx - (i - idx);
        //             else j = idx-1 - (i - idx);
        //             vb = val | 1 << j;
        //             m.get(i-idx+1).add(vb);
        //             if (i == x && j == y || i == y && j == x) {
        //                 min = Math.min(min, 1);
        //                 max = Math.max(max, 1);
        //             }
        //         }
        //     }
        //     return m.get(n-1-idx+1);
        // }
// 我又一次不加思索地使用了暴力来解。。。。。。
        // private void solve(int v, int cnt, int x, int y) { 
        //     Map<Integer, Set<Integer>> map = new HashMap<>(); 
        //     Set<Integer> si = new HashSet<>();
        //     si.add(0);
        //     map.put(0, si);
        //     int n = Integer.bitCount(v), cur = 0, va = 0, vb = 0, idx = 1;
        //     for (int i = 27, j = 0; i >= j; i--, j++) {
        //         while ((v & (1 << i)) == 0) --i;
        //         while ((v & (1 << j)) == 0) ++j;   
        //         if (i < j) return;
        //         if (map.size() == 0) {
        //             cur = 1 << i;
        //             map.computeIfAbsent(idx, k -> new HashSet<>()).add(cur);
        //             cur = 1 << j;
        //             map.get(idx).add(cur);
        //         } else 
        //             for (int val : map.get(idx-1)) { 
        //                 va = val | 1 << i;
        //                 vb = val | 1 << j;
        //                 map.computeIfAbsent(idx, k -> new HashSet<>()).add(va);
        //                 map.get(idx).add(vb);
        //             }
        //         ++idx;
        //         if (i == x && j == y || i == y && j == x) {
        //             min = Math.min(min, cnt);
        //             max = Math.max(max, cnt);
        //         }
        //     }
        //     for (Integer val : map.get(map.size()-1)) 
        //         if (((val >> x) & 1) == 1 && ((val >> y) & 1) == 1)  
        //             solve(val, cnt+1, x, y);
        // }
        // int min, max;
        // public int [] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        //     if (n == 2) return new int []{1, 1};
        //     int mask = 0;
        //     for (int i = 0; i < n; i++) 
        //         mask |= 1 << i;
        //     min = Integer.MAX_VALUE;
        //     max = 0;
        //     solve(mask, 1, firstPlayer-1, secondPlayer-1);
        //     return new int [] {min, max};
        // }
    // https://leetcode-cn.com/problems/the-earliest-and-latest-rounds-where-players-compete/solution/zui-jia-yun-dong-yuan-de-bi-pin-hui-he-b-lhuo/
        // private int [] dfs(int n, int f, int s) { // f: firstPlayer, // s: secondPlayer
        //     if (min[n][f][s] > 0) return new int [] {min[n][f][s], max[n][f][s]};
        //     if (f + s == n+1) return new int [] {1, 1};
        //     if (f + s > n + 1) {
        //         int [] res = dfs(n, n+1 - s, n+1 - f);
        //         min[n][f][s] = res[0];
        //         max[n][f][s] = res[1];
        //         return res;
        //     }
        //     int glbMin = Integer.MAX_VALUE, glbMax = 0;
        //     int half = (n+1) >> 1;
        //     if (s <= half) 
        //         for (int i = 0; i < f; i++) // f左侧人数
        //             for (int j = 0; j < s-f; j++) { // f和s之间的人数
        //                 int [] res = dfs(half, i+1, i+j+2);
        //                 glbMin = Math.min(glbMin, res[0] + 1);
        //                 glbMax = Math.max(glbMax, res[1] + 1);
        //             }
        //     else // s在右侧
        //         for (int i = 0; i < f; i++) 
        //             for (int j = 0; j < n+1-s-f; j++) {
        //                 int [] res = dfs(half, i+1, i+j+2+(s*2-n-1)/2);
        //                 glbMin = Math.min(glbMin, res[0] + 1);
        //                 glbMax = Math.max(glbMax, res[1] + 1); 
        //             }
        //     min[n][f][s] = glbMin;
        //     max[n][f][s] = glbMax;
        //     return new int [] {glbMin, glbMax};
        // }
        // int [][][] min, max;
        // public int [] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        //     min = new int [n+1][n+1][n+1];
        //     max = new int [n+1][n+1][n+1];
        //     if (firstPlayer < secondPlayer) return dfs(n, firstPlayer, secondPlayer);
        //     return dfs(n, secondPlayer, firstPlayer);
        // }


        // private int getUniqueCnt(int [] arr) {
        //     int cnt = 0;
        //     for (int i = 0; i < arr.length; i++)
        //         if (arr[i] == 1) ++cnt;
        //     return cnt;
        // }        
        // public int uniqueLetterString(String s) {
        //     int n = s.length(), res = 0, cur = 0;
        //     boolean bk = false;
        //     Map<String, Integer> map = new HashMap<>();
        //     int [][][] cnt = new int [n][n+1][26];
        //     for (int d = 1; d <= n; d++) {
        //         for (int i = 0; i+d <= n; i++) {
        //             if (map.keySet().contains(s.substring(i, i+d))) {
        //                 res += map.get(s.substring(i, i+d));
        //                 continue;
        //             }
        //             for (int j = i; j < i+d; j++) 
        //                 cnt[i][i+d][s.charAt(j)-'A']++;
        //             cur = getUniqueCnt(cnt[i][i+d]);
        //             map.put(s.substring(i, i+d), cur);
        //             res += cur;
        //         }
        //     }
        //     return res;
        // }
        // public int uniqueLetterString(String s) {
        //     int n = s.length(), res = 0, mod = (int)1e9 + 7;
        //     int [][] idx = new int [26][2];
        //     for (int i = 0; i < 26; i++) 
        //         Arrays.fill(idx[i], -1);
        //     for (int i = 0; i < n; i++) {
        //         int c = s.charAt(i) - 'A';
        //         res = (res + (i - idx[c][1]) * (idx[c][1] - idx[c][0]) % mod) % mod;
        //         idx[c][0] = idx[c][1];
        //         idx[c][1] = i;
        //     }
        //     for (int i = 0; i < 26; i++) 
        //         res = (res + (n - idx[i][1]) * (idx[i][1] - idx[i][0]) % mod) % mod;
        //     return res;
        // }


        // public String pushDominoes(String dominoes) {
        //     int n = dominoes.length(), pre = Integer.MAX_VALUE;
        //     int [][] idx = new int [2][n];
        //     for (int i = 0; i < 2; i++) 
        //         Arrays.fill(idx[i], Integer.MAX_VALUE);
        //     for (int i = 0; i < n; i++)  
        //         if (dominoes.charAt(i) == '.' && pre != Integer.MAX_VALUE)
        //             idx[0][i] = i - pre; // 0: R-idx
        //         else if (dominoes.charAt(i) == 'R')
        //             pre = i;
        //         else pre = Integer.MAX_VALUE;
        //     pre = Integer.MAX_VALUE;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (dominoes.charAt(i) == '.' && pre != Integer.MAX_VALUE)
        //             idx[1][i] = pre - i; // 0: R-idx
        //         else if (dominoes.charAt(i) == 'L')
        //             pre = i;
        //         else pre = Integer.MAX_VALUE;
        //     StringBuilder s = new StringBuilder();
        //     for (int i = 0; i < n; i++) {
        //         if (dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R')
        //             s.append(dominoes.charAt(i));
        //         else {
        //             if (idx[0][i] < idx[1][i]) s.append('R');
        //             else if (idx[0][i] == idx[1][i]) s.append('.');
        //             else s.append('L');
        //         }
        //     }
        //     return s.toString();
        // }


        // public int minTaps(int n, int[] ranges) {
        //     int cnt = 0, i = 0, j = 0;
        //     int maxRight = -1, maxj = -1, left = 0, right = 0;
        //     while (i <= n) {
        //         maxRight = -1;
        //         maxj = -1;
        //         while (j <= n) {
        //             left = j - ranges[j];
        //             right = j + ranges[j];
        //             if (i >= left && i <= right) 
        //                 if (right > maxRight) {
        //                     maxRight = right;
        //                     maxj = j;
        //                 }
        //             j++;
        //         }
        //         if (maxRight == -1) return -1;
        //         cnt++;
        //         if (maxRight >= n) return cnt;
        //         i = maxRight;
        //         j = maxj + 1;
        //     }
        //     return -1;
        // }
        // public int minTaps(int n, int[] ranges) {
        //     int [] max = new int [n+1];
        //     int left = 0, right = 0;
        //     for (int i = 0; i <= n; i++) {
        //         left = i - ranges[i];
        //         right = i + ranges[i];
        //         if (left < 0) left = 0;
        //         if (right > n) right = n;
        //         max[left] = Math.max(max[left], right);
        //     }
        //     int cnt = 1, l = 0, r = max[0], maxRight = 0, maxLeft = 0;
        //     while (r < n) {
        //         maxRight = r;
        //         maxLeft = l;
        //         for (int i = l; i <= r; i++) 
        //             if (max[i] > maxRight) {
        //                 maxRight = max[i];
        //                 maxLeft = i;
        //             }
        //         if (maxRight == r) return -1; // 如果最大right不能大于当前right，返回-1
        //         r = maxRight;
        //         l = maxLeft + 1;
        //         cnt++;
        //     }
        //     return cnt;
        // }

        
        // private int binarySearchMin(int [] arr, int v, int l, int r) {
            // if (l == r) return arr[l] > v ? arr[l] : -1;
            // if (l == r-1) return arr[l] > v ? arr[l] : (arr[r] > v ? arr[r] : -1);
            // int m = l + (r - l) / 2;
            // if (arr[m] > v) return binarySearchMin(arr, v, l, m);
            // return binarySearchMin(arr, v, m+1, r);
        // }
        // private int binarySearchMin(int [] arr, int v) { // 与上面的方法等效
        //     int l = 0, r = arr.length-1, m = 0;
        //     while (l < r) { // while的三种模板还是很生
        //         m = l + (r-l) / 2;
        //         if (arr[m] <= v) l = m+1;
        //         else r = m;
        //     }
        //     return arr[l] > v ? arr[l] : -1;
        // }
        // public int makeArrayIncreasing(int [] a, int [] arr2) {
        //     int [] b = Arrays.stream(arr2).distinct().toArray();
        //     Arrays.sort(b);
        //     int m = b.length;
        //     int n = a.length;
        //     int size = 0, minCnt = 0, minVal = 0;
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {-1, 0});
        //     int [] cur = null;
        //     for (int i = 0; i < n; i++) {
        //         minCnt = Integer.MAX_VALUE;
        //         size = q.size();
        //         while (size-- > 0) {
        //             cur = q.poll();
        //             if (a[i] > cur[0]) minCnt = Math.min(minCnt, cur[1]);
        //             minVal = binarySearchMin(b, cur[0]);
        //             if (minVal != -1) q.offer(new int [] {minVal, cur[1]+1});
        //         }
        //         if (minCnt != Integer.MAX_VALUE) q.offer(new int [] {a[i], minCnt});
        //     }
        //     if (q.size() == 0) return -1;
        //     int res = Integer.MAX_VALUE;
        //     while (!q.isEmpty()) res = Math.min(res, q.poll()[1]);
        //     return res;
        // }


        // public int search(int[] nums, int target) {
        //     int left = 0;
        //     int right = nums.length - 1;
        //     while (left <= right) {
        //         int mid = left + ((right - left) >> 1);
        //         if (nums[mid] == target) return mid;
        //         else if (nums[mid] > target) 
        //             right = mid - 1;
        //         else 
        //             left = mid + 1;
        //     }
        //     return -1;
        // }
        // public int search(int[] nums, int target) {
        //     int left = 0;
        //     int right = nums.length - 1;
        //     while (left < right) {
        //         int mid = left + (right - left) / 2;
        //         if (nums[mid] < target) 
        //             left = mid + 1;
        //         else 
        //             right = mid;
        //     }
        //     return nums[left] == target ? left : -1;
        // }
        // public int searchInsert(int[] nums, int target) {
        //     int len = nums.length;
        //     if (nums[len - 1] < target) return len;
        //     int left = 0;
        //     int right = len - 1;
        //     while (left <= right) {
        //         int mid = (left + right) / 2;
        //         // 等于的情况最简单，我们应该放在第 1 个分支进行判断
        //         if (nums[mid] == target) {
        //             return mid;
        //         } else if (nums[mid] < target) {
        //             // 题目要我们返回大于或者等于目标值的第 1 个数的索引
        //             // 此时 mid 一定不是所求的左边界，
        //             // 此时左边界更新为 mid + 1
        //             left = mid + 1;
        //         } else {
        //             // 既然不会等于，此时 nums[mid] > target
        //             // mid 也一定不是所求的右边界
        //             // 此时右边界更新为 mid - 1
        //             right = mid - 1;
        //         }
        //     }
        //     // 注意：一定得返回左边界 left，
        //     // 理由是对于 [1,3,5,6]，target = 2，返回大于等于 target 的第 1 个数的索引，此时应该返回 1
        //     // 在上面的 while (left <= right) 退出循环以后，right < left，right = 0 ，left = 1
        //     // 根据题意应该返回 left，
        //     // 如果题目要求你返回小于等于 target 的所有数里最大的那个索引值，应该返回 right
        //     return left;
        // }
        // public int search(int[] nums, int target) {
        //     int left = 0;
        //     int right = nums.length - 1;
        //     while (left < right) {
        //         int mid = left + (right - left) / 2;
        //         if (nums[mid] < target) 
        //             left = mid + 1;
        //         else if (nums[mid] > target) 
        //             right = mid;
        //         else 
        //             right--;
        //     }
        //     return nums[left] == target ? left : -1;
        // }
        // public int search(int[] nums, int target) {
        //     int left = 0;
        //     int right = nums.length - 1;
        //     while (left < right) {
        //         int mid = left + ((right - left) >> 1) + 1;
        //         if (nums[mid] > target) 
        //             right = mid - 1;
        //         else 
        //             left = mid;
        //     }
        //     return nums[right] == target ? right : -1;
        // }
        // public int findPeakElement(int[] nums) {
        //     int left = 0;
        //     int right = nums.length - 1;
        //     while (left < right) {
        //         int mid = left + ((right - left) >> 1);
        //         if (nums[mid] < nums[mid + 1]) 
        //             left = mid + 1;
        //         else 
        //             right = mid;
        //     }
        //     return left;
        // }


        // public int binarySearch2(int[] nums, int target) {
        //     // left和right都在数组下标范围内
        //     // [left, right]
        //     int left = 0;
        //     int right = nums.length - 1;
        //     // while循环跳出的条件是left > right
        //     // 所以如果没找到target的话，也不需要特判了
        //     while (left <= right) {
        //         int mid = left + (right - left) / 2;
        //         if (nums[mid] == target) return mid;
        //         else if (nums[mid] < target) 
        //             left = mid + 1;
        //         else
        //             right = mid - 1;
        //     }
        //     // 如果没找到就只能返回-1
        //     return -1;
        // }
        // public int binarySearch3(int[] nums, int target) {
        //     // right不在下标范围内
        //     // [left, right)
        //     int left = 0;
        //     int right = nums.length;
        //     // while循环跳出的条件是left == right
        //     // 这个模板比较适合判断当前index和index + 1之间的关系
        //     // left < right, example, left = 0, right = 1
        //     while (left < right) {
        //         int mid = left + (right - left) / 2;
        //         if (nums[mid] == target) return mid;
        //         else if (nums[mid] < target) 
        //             left = mid + 1;
        //         else
        //             // 因为搜索范围是左闭右开所以这里不能-1
        //             right = mid;
        //     }
        //     // 最后的特判
        //     if (left != nums.length && nums[left] == target) 
        //         return left;
        //     return -1;
        // }
        // public int binarySearch1(int[] nums, int target) {
        //     // left和right都在数组下标范围内
        //     // [left, right]
        //     int left = 0;
        //     int right = nums.length - 1;
        //     // 举例，start - 0, end = 3
        //     // 中间隔了起码有start + 1和start + 2两个下标
        //     // 这样跳出while循环的时候，start + 1 == end
        //     // 才有了最后的两个判断
        //     while (left + 1 < right) {
        //         int mid = left + (right - left) / 2;
        //         if (nums[mid] == target) return mid;
        //         else if (nums[mid] < target) 
        //             left = mid;
        //         else 
        //             right = mid;
        //     }
        //     // 特判
        //     if (nums[left] == target) return left;
        //     if (nums[right] == target) return right;
        //     // 如果没找到就只能返回-1
        //     return -1;
        // }


        // public String largestMultipleOfThree(int[] digits) {
        //     int n = digits.length, fstOne = 9, secOne = 9, fstTwo = 9, secTwo = 9, sum = 0;
        //     int [] cnt = new int [10];
        //     for (int i = 0; i < n; i++) {
        //         cnt[digits[i]]++;
        //         sum += digits[i];
        //         if (digits[i] % 3 == 1) {
        //             if (digits[i] < fstOne) fstOne = digits[i];
        //             else if (digits[i] < secOne) secOne = digits[i];
        //         } else if (digits[i] % 3 == 2) {
        //             if (digits[i] < fstTwo) {
        //                 secTwo = fstTwo;
        //                 fstTwo = digits[i];
        //             }
        //             else if (digits[i] < secTwo) secTwo = digits[i];
        //         }
        //     }
        //     StringBuilder s = new StringBuilder();
        //     if (sum == 0) return "0";
        //     if (sum % 3 == 1) {
        //         if (fstOne < 9) cnt[fstOne]--;
        //         else {
        //             cnt[fstTwo]--;
        //             cnt[secTwo]--;
        //         }
        //     } else if (sum % 3 == 2) {
        //         if (fstTwo < 9) cnt[fstTwo]--;
        //         else {
        //             cnt[fstOne]--;
        //             cnt[secOne]--;
        //         }
        //     }
        //     for (int i = 9; i >= 0; i--) 
        //         while (cnt[i] > 0) {
        //             s.append((char)(i+'0'));
        //             cnt[i]--;
        //         }
        //     return s.toString();
        // }


        // public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //     int  n = stations.length;
        //     if (startFuel >= target) return 0;
        //     if (startFuel < target && n == 0 || startFuel < stations[0][0]) return -1;
        //     Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        //     q.offer(startFuel);
        //     int cur = 0, cnt = 0, gas = 0, idx = 0;
        //     while (!q.isEmpty()) {
        //         gas = q.poll();
        //         cur += gas;
        //         if (cur >= target) return cnt;
        //         while (idx < n && stations[idx][0] <= cur) 
        //             q.offer(stations[idx++][1]);
        //         cnt++;
        //     }
        //     return -1;
        // }


// // 计算左半部分编码后长度
// // num：相同字符数量
//         int getLength(int num){
//             // 如果只有一个字母，返回长度1
//             if(num == 1) return 1;
//             // 编码后长度，1代表字母占位长度
//             int length = 1;
//             // 求num的位数
//             while(num>0){
//                 length++;
//                 num/ = 10;
//             }
//             return length;
//         }
//         int[][] memo; // 记忆数组
//         public int getLengthOfOptimalCompression(String s, int k) {
//             memo = new int[s.length()][s.length()-k+1]; // 初始化记忆数组
//             return help(s.toCharArray(), 0, s.length()-k); // 递归求解
//         }
// // 求从下标index开始向后，所有长度为count的子序列中，编码后的最小长度
//         int help(char[] arr, int index, int count){
//             if(count == 0) return 0; // 子序列长度为0，返回0
//             if(index == arr.length){ // 当下标越界时还未找到长度为count的子序列
//                 // 返回一个最大值，代表未找到合理解
//                 return Integer.MAX_VALUE;
//             }
//             // 如果记忆数组中存在数值，直接返回
//             if(memo[index][count]>0) return memo[index][count];
//             int min = Integer.MAX_VALUE; // 当前最优解
//             boolean[] used = new boolean[26]; // 记录已经处理过的开头字母
//             // 从index向后循环，寻找左半部分的开头字母
//             for(int i = index;i<arr.length;i++){
//                 if(used[arr[i]-'a']) continue; // 优化：已处理过当前的字母，跳过
//                 // 优化：如果当前字母与上层递归的左半部分相同，跳过
//                 if(index>0&&arr[i] == arr[index-1]) continue;
//                 used[arr[i]-'a'] = true; // 设当前字母已被处理过
//                 int leftCount = 0; // 左半部分长度
//                 // 从当前下标开始向后循环，寻找相同字符（可不连续）
//                 for(int j = i;j<arr.length;j++){
//                     if(arr[j] != arr[i]) continue; // 如果字符不相同，跳过
//                     leftCount++; // 左半部分长度(相同字符个数)加一
//                     if(count-leftCount<0) break; // 如果左半部分长度大于子序列长度，退出
//                     int left = getLength(leftCount); // 计算左半部分编码后长度
//                     int right = help(arr,j+1,count-leftCount); // 递归求解右半部分编码长度
//                     if(right == Integer.MAX_VALUE) continue; // 若递归返回值为最大值，代表不和理解，跳过
//                     int length = left+right; // 左右长度相加为当前子序列编码后长度
//                     min = Math.min(min, length); // 更新最小值
//                 }
//             }
//             memo[index][count] = min; // 将最小值存入记忆数组
//             return min;
//         }
        //  private int dfs(char [] s, int idx, int cnt) { // 求从下标index开始向后，所有长度为count的子序列中，编码后的最小长度
        //     if (cnt == 0) return 0;
        //     if (idx == n) return Integer.MAX_VALUE;   // 当下标越界时还未找到长度为count的子序列
        //     if (dp[idx][cnt] > 0) return dp[idx][cnt];
        //     int min = Integer.MAX_VALUE, leftCnt = 0;
        //     boolean [] vis = new boolean [26];
        //     for (int i = idx; i < n; i++) {
        //         if (vis[s[i]-'a']) continue;   // 优化：已处理过当前的字母，跳过
        //         if (idx > 0 && s[i] == s[idx-1]) continue;
        //         vis[s[i]-'a'] = true;
        //         leftCnt = 0;
        //         for (int j = i; j < n; j++) {
        //             if (s[j] != s[i]) continue;
        //             leftCnt++;
        //             if (cnt - leftCnt < 0) break;  // 如果左半部分长度大于子序列长度，退出
        //             int right = dfs(s, j+1, cnt - leftCnt);
        //             if (right == Integer.MAX_VALUE) continue;
        //             int left = String.valueOf(leftCnt).length();
        //             min = Math.min(min, left + right + (left == 1 && leftCnt == 1 ? 0 : 1));
        //         }
        //     }
        //     return dp[idx][cnt] = min;
        // }
        // int [][] dp;
        // int n;
        // public int getLengthOfOptimalCompression(String s, int k) {
        //     n = s.length();
        //     dp = new int [n][n-k+1];
        //     return dfs(s.toCharArray(), 0, n-k);
        // }
        

        // private int dfs(String s, int k, int idx) {
        //     if (idx == n) return 1;
        //     if (dp[idx] > 0) return dp[idx];
        //     if (s.charAt(idx) == '0') return dp[idx] = 0;
        //     long res = 0;
        //     for (int i = idx; i < idx + m && i < n; i++) {
        //         if (Long.parseLong(s.substring(idx, i+1)) <= k)
        //             res = (res + dfs(s, k, i+1)) % mod;
        //         else break;
        //     }
        //     return dp[idx] = (int)res;
        // }
        // int [] dp;
        // int mod = (int)1e9 + 7;
        // int n, m;
        // public int numberOfArrays(String s, int k) {
        //     n = s.length();
        //     m = String.valueOf(k).length();
        //     dp = new int [n];
        //     dfs(s, k, 0);
        //     return dp[0];
        // }
        // private int dfs(char [] s, int k, int idx) {
        //     if (idx == n) return 1;
        //     if (dp[idx] != -1) return dp[idx];
        //     if (s[idx] == '0') return dp[idx] = 0;
        //     long res = 0, cur = 0;
        //     for (int i = idx; i < n; i++) {
        //         cur = cur * 10 + (long)(s[i] - '0');
        //         if (cur > k) break;
        //         res = (res + dfs(s, k, i+1)) % mod;
        //     }
        //     return dp[idx] = (int)res;
        // }
        // int [] dp;
        // int mod = (int)1e9 + 7;
        // int n;
        // public int numberOfArrays(String s, int k) {
        //     n = s.length();
        //     dp = new int [n];
        //     Arrays.fill(dp, -1);
        //     return dfs(s.toCharArray(), k, 0);
        // }


        // public int atMostNGivenDigitSet(String[] digits, int n) {
        //     String s = String.valueOf(n);
        //     int N = digits.length;
        //     int len = s.length();
        //     int res = 0;
        //     for (int i = 1; i < len; i++) res += Math.pow(N, i);
        //     for (int i = 0; i < len; i++) {
        //         boolean sameVal = false;
        //         for (String v : digits) {
        //             if (v.charAt(0) < s.charAt(i)) res += Math.pow(N, len-1-i);
        //             else if (v.charAt(0) == s.charAt(i)) sameVal = true;
        //         }
        //         if (!sameVal) return res;
        //     }
        //     return res + 1;
        // }


        // private int A(int m, int n) {
        //     return n == 0 ? 1 : A(m, n-1) * (m-n+1);
        // }
        // public int numDupDigitsAtMostN(int n) {
        //     List<Integer> digits = new ArrayList<>();
        //     Set<Integer> vis = new HashSet<>();
        //     for (int i = n+1; i > 0; i /= 10) 
        //         digits.add(0, i % 10);
        //     int res = 0, m = digits.size();
        //     for (int i = 1; i < m; i++) res += 9 * A(9,  i-1);
        //     for (int i = 0; i < m; i++) {
        //         for (int j = i > 0 ? 0 : 1; j < digits.get(i); ++j) {
        //             if (vis.contains(j)) continue;
        //             res += A(9-i, m-i-1);
        //         }
        //         if (vis.contains(digits.get(i))) break;
        //         vis.add(digits.get(i));
        //     }
        //     return n - res;
        // }

        // private int dfs(String s, int idx, int bit, int state) {
        //     if (idx >= s.length()) return 1;
        //     if (dp[idx][bit][state] != -1) return dp[idx][bit][state];
        //     int digit = s.charAt(idx) - '0', res = 0;
        //     if (state == 1)  // same prefix
        //         for (int i = 0; i <= digit; i++) {
        //             if ((bit & (1 << i)) != 0) continue;
        //             if (i == digit) res += dfs(s, idx+1, (bit | (1 << i)), 1);
        //             else res += dfs(s, idx+1, (bit | (1 << i)), 0);
        //         }
        //     else for (int i = 0; i < 10; i++) {
        //             if ((bit & (1 << i)) != 0) continue;
        //             if (i == 0 && bit == 0 && idx == s.length()-1) continue;
        //             if (i == 0 && bit == 0) res += dfs(s, idx+1, 0, 0);
        //             else res += dfs(s, idx+1, (bit | (1 << i)), 0);
        //         }
        //     return dp[idx][bit][state] = res;
        // }
        // int dp [][][];
        // public int numDupDigitsAtMostN(int n) {
        //     if (n <= 10) return 0;
        //     String s = n+"";
        //     int cnt = 0;
        //     int first = s.charAt(0) - '0';
        //     dp = new int [s.length()][1 << 10][2];
        //     for (int i = 0; i < s.length(); i++) 
        //         for (int j = 0; j < 1 << 10; j++) 
        //             Arrays.fill(dp[i][j], -1);
        //     for (int i = 1; i <= first; i++) {
        //         if (i == first) cnt += dfs(s, 1, 1 << i, 1);
        //         else cnt += dfs(s, 1, 1 << i, 0);
        //     }
        //     cnt += dfs(s, 1, 0, 0);
        //     return n - cnt;
        // }
        // private int dfs(int len, int limit, int mask) { // 不重复数的个数
        //     if (len == 0) return 1;
        //     if (limit == 0 && dp[len][mask][limit] > 0) return dp[len][mask][limit]; // 记忆化部分
        //     int maxn = limit > 0 ? bit[len] : 9; // 求出最高可以枚举到哪个数字
        //     int ans = 0;
        //     for (int i = 0; i <= maxn; i++)  // 当前位
        //         if ((mask&(1 << i)) == 0)
        //             if (mask == 0 && i == 0)
        //                 ans += dfs(len - 1, (limit > 0 && i == maxn ? 1 : 0), mask); // 有前导0,所以0不能统计,不更新mask
        //             else ans += dfs(len - 1, (limit > 0 && i == maxn ? 1 : 0), mask | (1 << i)); // 更新mask
        //     if (limit == 0) dp[len][mask][limit] = ans; // 如果没有限制,代表搜满了,可以记忆化,否则就不能
        //     return ans;
        // }
        // int [][][] dp;
        // int [] bit;
        // public int numDupDigitsAtMostN(int N) {
        //     int sum = N + 1;
        //     bit = new int [19];
        //     dp = new int [19][1 << 10][2];
        //     int idx = 0;
        //     while (N > 0) {
        //         bit[++idx] = N % 10;
        //         N /= 10;
        //     }
        //     return sum - dfs(idx, 1, 0);
        // }


        // // 定义dp[l][r][k]表示在[l, r]区间并且在后面包含了k个与boxes[r]相同颜色的boxes的情况下，可以获得的最大得分，显然题目要求的就是dp[0][boxes.size() - 1][0]。
        // // 首先将dp[l][r][k]的值初始化为dp[l][r - 1][0] + (k + 1)^2，表示首先消除l到r-1之间的boxes,然后将boxes[r]连同后面的k个boxes一起消除。
        // // 然后就尝试对dp[l][r][k]进行更新了：
        // // 如果在l到r-1区间内有boxes[i]和boxes[r]相同的字符，那么可以尝试首先将区间[i + 1, r - 1]消除，这样i就和后面的k + 1个boxes连起来了，
        // // 其可以获得分数就是需要进一步计算的dp[l][i][k + 1]。
        // private int dfs(int [] arr, int i, int j, int  k) {
        //     if (i > j) return 0;
        //     if (dp[i][j][k] > 0) return dp[i][j][k];
        //     int res = dfs(arr, i, j-1, 0) + (k+1)*(k+1);
        //     for (int x = i; x < j; x++) 
        //         if (arr[x] == arr[j]) {
        //             res = Math.max(res, dfs(arr, i, x, k+1) + dfs(arr, x+1, j-1, 0));
        //         }
        //     return dp[i][j][k] = res;
        // }
        // int [][][] dp;
        // int n;
        // public int removeBoxes(int[] boxes) {
        //     n = boxes.length;
        //     dp = new int [n][n][n];
        //     return dfs(boxes, 0, n-1, 0);
        // }


        // public int minDeletionSize(String[] strs) {
        //     int n = strs[0].length(), max = 1;
        //     int [] dp = new int [n];
        //     Arrays.fill(dp, 1);
        //     boolean valid = false;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             valid = true;
        //             for (int k = 0; k < strs.length; k++) 
        //                 if (strs[k].charAt(j) > strs[k].charAt(i)) {
        //                     valid = false;
        //                     break;
        //                 }
        //             if (valid) {
        //                 dp[i] = Math.max(dp[i], dp[j]+1);
        //                 max = Math.max(max, dp[i]);
        //             }
        //         }
        //     }
        //     return n - max;
        // }


        // public int racecar(int target) {
        //     if (target == 1) return 0;
        //     Set<String> vis = new HashSet<>();
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {0, 1});
        //     vis.add("0-1");
        //     vis.add("0--1");
        //     int [] cur = null;
        //     int cnt = 0, size = 0, v = 0, s = 0, nv = 0, ns = 0;
        //     while (q.size() > 0) {
        //         size = q.size();
        //         while (size-- > 0) {
        //             cur = q.poll();
        //             v = cur[0];
        //             s = cur[1];
        //             nv = v + s;
        //             ns = 2 * s;
        //             if (nv == target) return cnt + 1;
        //             String ta = nv + "-" + ns;
        //             if (nv > 0 && nv < target * 2) 
        //                 q.offer(new int [] {nv, ns});
        //             nv = v;
        //             ns = s > 0 ? -1 : 1;
        //             String tb = nv + "-" + ns;
        //             if (!vis.contains(tb)) {
        //                 vis.add(tb);
        //                 q.offer(new int [] {nv, ns});
        //             }
        //         }
        //         ++cnt;
        //     }
        //     return cnt;
        // }


        // List<int []> ll = new ArrayList<>();
        // int m, n;
        // public int profitableSchemes(int nn, int minProfit, int[] group, int[] profit) {
        //     // int m = group.length, n  = nn;
        //     // for (int i = 0; i < m; i++) 
        //     //     ll.add(new int [] {profit[i], group[i]});
        //     // Collections.sort(ll, (a, b)-> b[0]-a[0]);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(1, 2);
        //     m.put(2, 2);
        //     m.put(1, 2);
        //     System.out.println("m.size(): " + m.size());
        //     for (Integer key : m.keySet()) 
        //         System.out.print(key + ", ");
        //     System.out.println("");
        //     System.out.println("m.size(): " + m.size());
        //     System.out.println(Arrays.toString(new ArrayList<>($1).toArray()));
        //     System.out.println("map.size(): " + map.size());
        //     for (Integer val : map.values()) 
        //         System.out.print(val + ", ");
        //     System.out.println("");
        //     return 0;
        // }


        // // 要把这种工具方法像写binarySearch一样随手拈来随手就敲才行: 仍然超时，最后两个不过
        // public void getSum(List<Integer> li, int [] arr, int sum , int l, int r) {
        //     if (l >= r) { //
        //         li.add(sum);
        //         return;
        //     }
        //     getSum(li, arr, sum + arr[l], l+1, r); // choose and add idx l to sum
        //     getSum(li, arr, sum, l+1, r);          // skip idx l, move directly to next element
        // }
        // public int minAbsDifference(int[] arr, int goal) {
        //     int n = arr.length, m = arr.length / 2;
        //     List<Integer> l = new ArrayList<>();
        //     List<Integer> r = new ArrayList<>();
        //     getSum(l, arr, 0, 0, m); // m 
        //     getSum(r, arr, 0, m, n); // m ? 这里反而想不明白了？
        //     Collections.sort(l);
        //     Collections.sort(r);
        //     int i = 0, j = r.size()-1, cur = 0;
        //     int minDiff = Integer.MAX_VALUE;
        //     while (i < l.size() && j >= 0) {
        //         cur = l.get(i) + r.get(j) - goal;
        //         if (cur > 0) {
        //             minDiff = Math.min(minDiff, cur);
        //             j--;
        //         } else if (cur < 0) {
        //             minDiff = Math.min(minDiff, -cur);
        //             i++;
        //         }
        //         else return 0;
        //     }
        //     return minDiff;
        // }
        public int minAbsDifference(int[] arr, int goal) {
            int n = arr.length;
            List<Integer> lsum = new ArrayList<>();
            List<Integer> rsum = new ArrayList<>();
            lsum.add(0);
            rsum.add(0);
            for (int i = 0; i <= n/2; i++) { // 这种生成和的方式
                int size = lsum.size();
                for (int j = 0; j < size; j++) 
                    lsum.add(lsum.get(j) + arr[i]);
            }
            for (int i = n/2+1; i < n; i++) {
                int size = rsum.size();
                for (int j = 0; j < size; j++) 
                    rsum.add(rsum.get(j) + arr[i]);
            }
            TreeSet<Integer> rightSumSet = new TreeSet<>(rsum);
            Set<Integer> leftSumSet = new HashSet<>(lsum);
            int ans = Math.abs(goal);
            for (int v : leftSumSet) {
                int b = goal - v;
                Integer lower = rightSumSet.floor(b);
                Integer higher = rightSumSet.ceiling(b);
                if (lower != null)
                    ans = Math.min(ans, Math.abs(goal-v-lower));
                if (higher != null)
                    ans = Math.min(ans, Math.abs(goal-v-higher));
            }
            return ans;
        }
        // public int minimumDifference(int[] arr) { // 暴力解，数据规模太大，需要更高效的解法
        //     int n = arr.length, range = 1 << n, cur = 0;
        //     int sum = Arrays.stream(arr).sum();
        //     Set<Integer> s = new HashSet<>();
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < range; i++) {
        //         if (Integer.bitCount(i) != n/2) continue;
        //         cur = 0;
        //         for (int j = 0; j < n; j++) 
        //             if (((i >> j) & 1) == 1) 
        //                 cur += arr[j];
        //         if (s.contains(sum - cur)) 
        //             min = Math.min(min, Math.abs(sum-cur-cur));
        //         else s.add(cur);
        //     }
        //     return min;
        // }
        // private void calcHalvesSubsetSums(int [] arr, Map<Integer, Set<Integer>> map, int l) {
        //     map.computeIfAbsent(0, k -> new HashSet<>()).add(0);
        //     int cur = 0;
        //     for (int k = 1; k <= n; k++) // 过个生成的过程是O(n*(2^n)), could be O(2^n)
        //         for (int i = 1; i < (1 << n); i++) {
        //             if (cnt[i] != k) continue;
        //             cur = 0;
        //             for (int j = 0; j < n; j++) 
        //                 if (((i >> j) & 1) == 1) cur += arr[l+j];
        //             map.computeIfAbsent(k, w -> new HashSet<>()).add(cur);
        //         }
        // }
        // Map<Integer, Set<Integer>> left = new HashMap<>(); 
        // Map<Integer, Set<Integer>> right = new HashMap<>(); 
        // int [] cnt;
        // int n;
        // public int minimumDifference(int[] arr) {
        //     n = arr.length / 2;
        //     if (n == 1) return Math.abs(arr[0] - arr[1]);
        //     cnt = new int [1 << n];
        //     int sum = Arrays.stream(arr).sum(), half = sum / 2;
        //     for (int i = 0; i < (1 << n); i++) 
        //         cnt[i] = Integer.bitCount(i);
        //     calcHalvesSubsetSums(arr, left, 0);
        //     calcHalvesSubsetSums(arr, right, n);
        //     int min = Integer.MAX_VALUE;
        //     TreeSet<Integer> rightKSums; // 用TreeSet就可以不用自己手动写binarySearch while loop了，并且保证答案正确
        //     for (int i = 1; i <= n; i++) {
        //         rightKSums = new TreeSet(right.get(n-i));
        //         for (Integer leftKSum : left.get(i)) {
        //             Integer lower = rightKSums.floor(half - leftKSum);
        //             Integer higher = rightKSums.ceiling(half - leftKSum);
        //             if (lower != null) 
        //                 min = Math.min(min, Math.abs(sum - 2 * (leftKSum + lower)));
        //             if (higher != null) 
        //                 min = Math.min(min, Math.abs(sum - 2 * (leftKSum + higher)));
        //         }
        //     }
        //     return min;
        // }
        // public int minimumDifference(int[] nums) {
        //     int n = nums.length;
        //     int sum = Arrays.stream(nums).sum();
        //     TreeSet<Integer>[] sets = new TreeSet[n/2+1]; // 数组，而不是hashMap，这个应该关系不是很大
        //     for (int i = 0; i < (1 << (n / 2)); ++i) {    // 一次遍历，而不是n次遍历
        //         int curSum = 0;
        //         int m = 0; // element Cnts                         
        //         for (int j = 0; j < n / 2; ++j) 
        //             if ((i & (1<<j)) != 0) {
        //                 curSum += nums[j]; // 左半部分
        //                 m ++;
        //             }
        //         if (sets[m] == null) sets[m] = new TreeSet<Integer>();
        //         sets[m].add(curSum);
        //     }
        //     int res = Integer.MAX_VALUE;
        //     for (int i = 0; i < (1 << (n / 2)); ++i) {
        //         int curSum = 0;
        //         int m = 0;
        //         for (int j = 0; j < n / 2; ++j) 
        //             if ((i & (1<<j)) != 0) {
        //                 curSum += nums[n/2 + j]; // 遍历计算右半部分的和：边遍历，边解决问题
        //                 m ++;
        //             }
        //         int target = (sum - 2 * curSum) / 2;
        //         Integer left = sets[n/2-m].floor(target), right = sets[n/2-m].ceiling(target);
        //         if (left != null) 
        //             res = Math.min(res, Math.abs(sum - 2 * (curSum + left.intValue())));
        //         if (right != null) 
        //             res = Math.min(res, Math.abs(sum - 2 * (curSum + right.intValue())));
        //         if (res == 0) return 0;
        //     }
        //     return res;
        // }


        // // dp[i][j] 表示前面i根木棍可以看到j根
        // // 设 dp[i][j] 表示从高度为 1, 2, ..., i 的木棍中，高度逐渐递减地插入新的木棍，从左侧看恰好看到 k 根木棍的方案数。
        // // 后面说看到ith根，不是指从小到大的第ith根棍子，而是指ith这个位置上的棍子
        // // 如果可以看到ith根的话，那么数量为dp[i-1][j-1]
        // // 如果看不到ith的话，那么取前面(i-1)里面任意一个出来放在ith的最后，接下来就是从前面i-1个棍子里面看到j根，所以结果是 (i-1)* dp[i-1][j]
        // public int rearrangeSticks(int n, int k) {
        //     int mod = (int)1e9 + 7;
        //     long [][] dp = new long [n+1][k+1];
        //     dp[0][0] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 1; j <= Math.min(n, k); j++) 
        //             dp[i][j] = (dp[i-1][j-1] + (dp[i-1][j] * (i-1)) % mod) % mod;
        //     return (int)dp[n][k];
        // }

        // long mod = 1000_000_000 + 7;
        // Long[][] dp;
        // public int rearrangeSticks(int n, int k) {
        //     dp = new Long[n + 1][k + 1];
        //     long ans = dfs(n, k);
        //     return (int) (ans % mod);
        // }
        // long dfs(int n, int k) {
        //     if (n < k || k == 0) return 0;
        //     if (n == k) return 1;
        //     if (dp[n][k] != null) return dp[n][k];
        //     long ans = 0;
        //     // trying each stick from 1 to n
        //     // placing them at last position
        //     for (int N = 1; N <= n; N++) {
        //         if (N == n) { // if the current stick is largest
        //             ans += dfs(n - 1, k - 1);
        //         } else { // if the current stick is not largest
        //             ans += dfs(n - 1, k);
        //         }
        //         ans %= mod;
        //     }
        //     dp[n][k] = ans;
        //     return ans;
        // }
        // long mod = 1000_000_000 + 7;
        // long[][] dp;
        // public int rearrangeSticks(int n, int k) {
        //     dp = new long[n + 1][k + 1];
        //     long ans = dfs(n, k);
        //     return (int) (ans % mod);
        // }
        // long dfs(int n, int k) {
        //     if(n < k || k == 0) return 0;
        //     if(n == k) return 1;
        //     if(dp[n][k] != 0) return dp[n][k];
        //     long ans = 0;
        //     // instead of iterating for every stick
        //     // we are just multiplying number of ways with (n - 1)
        //     ans += (((n - 1) * dfs(n - 1, k)) % mod);
        //     ans %= mod;
        //     ans += dfs(n - 1, k - 1);
        //     ans %= mod;
        //     return dp[n][k] = ans;
        // }


        // public int numberOfUniqueGoodSubsequences(String binary) {
        //     int mod = (int)1e9 + 7;
        //     int n = binary.length(), preZoo = 0, preOne = 0, m = 1;
        //     long [] dp = new long [n+1];
        //     String s = "#" + binary;
        //     while (m <= n && s.charAt(m) == '0') m++;
        //     if (m == n+1) return 1;
        //     dp[m] = 1;
        //     preOne = m;
        //     preZoo = m-1;
        //     for (int i = m+1; i <= n; i++) {
        //         char c = s.charAt(i);
        //         int j = (c == '0' ? preZoo : preOne);
        //         dp[i] = (2 * dp[i-1] % mod - (j >= 1 ? dp[j-1] : 0) + mod) % mod;
        //         if (c == '0') preZoo = i;
        //         else preOne = i;
        //     }
        //     return (int)dp[n] + (s.indexOf("0") != -1 ?  1 : 0);
        // }
        // public int numberOfUniqueGoodSubsequences(String binary) {
        //     int mod = (int)1e9 + 7;
        //     int endZoo = 0, endOne = 0, hasZoo = 0;
        //     for (int i = 0; i < binary.length(); i++) 
        //         if (binary.charAt(i) == '1')
        //             endOne = (endOne + endZoo + 1) % mod;
        //         else {
        //             endZoo = (endZoo + endOne) % mod;
        //             hasZoo = 1;
        //         }
        //     return (endOne + endZoo + hasZoo) % mod;
        // }

        
        // // 快速计算x^y的乘方
        // public int quickMul(int x , int y) {
        //     long res = 1, cur = x;
        //     while (y > 0) {
        //         if ((y & 1) == 1)
        //             res = res * cur % mod;
        //         cur = cur * cur % mod;
        //         y >>= 1;
        //     }
        //     return (int)res;
        // }
        // // 深度优先搜索，返回以当前节点为根的子树节点个数 及 内部排列数
        // public int [] dfs (int idx) {
        //     if (!map.containsKey(idx)) return new int [] {1, 1}; // 子节点，节点个数及内部排列数均为1
        //     int cnt = 1, res = 1;       //  子树的节点个数、内部排列数
        //     for (Integer node : map.get(idx)) {
        //       int [] cur = dfs(node); // 递归得到子节点对应树的节点个数和排列数
        //         cnt += cur[0];
        //         res = (int)((long)res * cur[1] % mod * inv[cur[0]] % mod);
        //     }
        //     res = (int)((long)res * fac[cnt-1] % mod);
        //     return new int [] {cnt, res};
        // }
        // int mod = (int)1e9 + 7;
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // int [] fac, inv;
        // public int waysToBuildRooms(int[] prevRoom) {
        //     int n = prevRoom.length;
        //     // 求阶乘数列及对应逆元
        //     this.fac = new int [n]; // fac[i]=i!
        //     this.inv = new int [n]; // inv[i]=i!^(-1)
        //     fac[0] = inv[0] = 1;
        //     for (int i = 1; i < n; i++) {
        //         fac[i] = (int)((long)fac[i-1] * i % mod);
        //         inv[i] = quickMul(fac[i], mod - 2); // 费马小定理: (fac[i]^(-1))%mod = (fac[i]^(mod-2))%mod
        //     }
        //     // 记录各个节点与子节点之间的边
        //     for (int i = 1; i < n; i++) 
        //         map.computeIfAbsent(prevRoom[i], k->new ArrayList<>()).add(i);
        //     // 动态规划得到总体顺序数量x
        //     return dfs(0)[1];      
        // }


        
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int []  a = new int []  { -1, 0, 0, 1, 2};

        int res = s.waysToBuildRooms(a);
        System.out.println("res: " + res);
    }
}