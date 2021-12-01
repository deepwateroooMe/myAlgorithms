import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;


public class twoPointers {
    public static class Solution {

        // public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //     List<int []> res = new ArrayList<>();
        //     int m = firstList.length;
        //     int n = secondList.length;
        //     if (m == 0 || n == 0) return new int [0][0];
        //     int i = 0, j = 0;
        //     int [] a = null, b = null;
        //     while (i < m && j < n) {
        //         a = firstList[i];
        //         b = secondList[j];
        //         if (a[1] < b[0]) i++;
        //         else if (a[0] > b[1]) j++; // no intersections
        //         else if (a[0] <= b[0] && a[1] >= b[1]) { // a includes b
        //             res.add(b);
        //             j++;
        //         } else if (b[0] <= a[0] && b[1] >= a[1]) { // b includes a
        //             res.add(a);
        //             i++;
        //         } else if (a[1] >= b[1] && a[0] <= b[1]) { 
        //             res.add(new int [] {a[0], b[1]});
        //             j++;
        //         } else { 
        //             res.add(new int [] {b[0], a[1]});
        //             i++;
        //         }
        //     }
        //     int [][] ans = new int [res.size()][2];
        //     for ( i = 0; i < res.size(); i++) 
        //         ans[i] = res.get(i);
        //     return ans;
        // }


        // public char[][] rotateTheBox(char[][] box) {
        //     int m = box.length;
        //     int n = box[0].length, idx = n-1, bot = n-1;
        //     char [][] ans = new char [n][m];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < m; j++) 
        //             ans[i][j] = box[m-1-j][i];
        //     System.out.println("ans.length: " + ans.length);
        //     for (int z = 0; z < ans.length; ++z) 
        //         System.out.println(Arrays.toString(ans[z]));
        //     for (int j = 0; j < m; j++) { // looping cols
        //         System.out.println("\n j: " + j);
        //         if ((new String(box[m-1-j])).indexOf('*') != -1) {
        //             idx = n-1; bot = n-1;
        //             while (idx > 0 && ans[idx][j] != '*' && ans[idx][j] != '#') --idx;
        //             if (ans[idx][j] == '#') {
        //                 while (idx > 0 && ans[idx][j] != '*') {
        //                     ans[bot][j] = '#';
        //                     ans[idx][j] = '.';
        //                     --idx;
        //                     --bot;
        //                 } 
        //             }
        //             System.out.println("idx: " + idx);
        //             int cnt = 0, k = idx-1, bcnt = 0, scnt = 0;
        //             while (k >= 0) {
        //                 while (k >= 0 && ans[k][j] != '*') {
        //                     if (ans[k][j] == '#') ++cnt;
        //                     else if (ans[k][j] == '*') ++bcnt;
        //                     --k;
        //                 }
        //                 System.out.println("k: " + k);
        //                 System.out.println("idx: " + idx);
        //                 if (k < 0 && cnt + bcnt == idx) break;
        //                 if (scnt > 0) {
        //                     bot = idx-1;
        //                     --idx;
        //                 } else if (scnt == 0) {
        //                     bot = k-1;
        //                     idx = k-1;
        //                 }
        //                 k--;
        //                 while (idx >= 0) {
        //                     if (ans[idx][j] == '#') {
        //                         ans[bot][j] = '#';
        //                         ans[idx][j] = '.';
        //                         --bot;
        //                     }
        //                     --idx;
        //                 }
        //             } 
        //             if (idx > 0) continue;
        //         } else {
        //             bot = n-1;
        //             idx = n-1;
        //             while (idx >= 0) {
        //                 if (ans[idx][j] == '#') {
        //                     ans[bot][j] = '#';
        //                     ans[idx][j] = '.';
        //                     --bot;
        //                 }
        //                 --idx;
        //             } 
        //         }
        //     }
        //     return ans;
        // }


        // public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        //     int n = arr.length, ans = 0, j = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         // while (!q.isEmpty() && q.peekLast() < arr[i]) q.pollLast();
        //     }
        // }

        // public String findLongestWord(String s, List<String> dictionary) {
        //     int n = s.length();
        //     int m = dictionary.size(), i, j;
        //     String res = "", cur;
        //     for (int k = 0; k < m; k++) {
        //         i = 0; j = 0;
        //         cur = dictionary.get(k);
        //         while (i < n && j < cur.length()) {
        //             while (i < n && j < cur.length() && s.charAt(i) == cur.charAt(j)) {
        //                 i++;
        //                 j++;
        //             }
        //             if (i < n && j < cur.length() && s.charAt(i) != cur.charAt(j)) i++;
        //         }
        //         if (j == cur.length() && (cur.length() > res.length() || cur.length() == res.length() && res.compareTo(cur) > 0))
        //             res = cur;
        //     }
        //     return res;
        // }


        // public String lastSubstring(String s) {
        //     int n = s.length();
        //     TreeSet<String> ts = new TreeSet<>();
        //     for (int i = n-1; i >= 0; i--) 
        //         ts.add(s.substring(i));
        //     return ts.last();
        // }

        
        // private int helper(int [] arr, int v) {
        //     int n = arr.length, ans = 0, j = 0;
        //     int [] sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if ()
        //     }
        // }
        // public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        //     return helper(arr, right) - helper(arr, left == 0 ? 0 : left - 1);
        // }


        // public int minimumLength(String s) {
        //     int n = s.length();
        //     if (n == 1) return 1;
        //     if (s.chars().distinct().count() == 1) return 0;
        //     int i = 0, j = n-1;
        //     if (s.charAt(i) != s.charAt(j)) return s.length();
        //     while (i < j) {
        //         char c = s.charAt(i);
        //         while (i < n && s.charAt(i) == s.charAt(j)) i++;
        //         while (j >= 0 && s.charAt(j) == c) j--;
        //         if (s.charAt(j) != s.charAt(i)) return (Math.abs(j-i)  + 1);
        //     }
        //     return i == j ? 1 : 0;
        // }


        // public String largestMerge(String s, String t) { // bug bug bug bug bug bug bug bug bug
        //     int m = s.length(), n = t.length();
        //     String ans = "";
        //     if (s.equals(t)) {
        //         for (int i = 0; i < m; i++) 
        //             ans += (""+s.charAt(i)).repeat(2);
        //         return ans;
        //     }
        //     int i = 0, j = 0;
        //     while (i < m && j < n) {
        //         if (s.charAt(i) > t.charAt(j) || s.charAt(i) == t.charAt(j) && s.substring(i+1).compareTo(t.substring(j+1)) > 0) {
        //             ans += "" + s.charAt(i);
        //             i++;
        //         } else if (s.charAt(i) < t.charAt(j) || s.charAt(i) == t.charAt(j) && s.substring(i+1).compareTo(t.substring(j+1)) < 0) {
        //             ans += "" + t.charAt(j);
        //             j++;
        //         } else {
        //             // while (i < m) 
        //             //     ans += (""+s.charAt(i++)).repeat(2);
        //             ans += (""+s.charAt(i)).repeat(m+n-ans.length());
        //             System.out.println("ans: " + ans);
        //             return ans;
        //         }
        //     }
        //     if (i < m) ans += s.substring(i);
        //     else if (j < n) ans += t.substring(j);
        //     return ans;
        // }
        // public String largestMerge(String s, String t) {
        //     Queue<String> q = new PriorityQueue<String>(Collections.reverseOrder());
        //     String merge = "";
        //     q.add(s);
        //     q.add(t);
        //     while (!q.isEmpty()) {
        //         String cur = q.poll();
        //         if (!cur.isEmpty()) {
        //             merge += cur.charAt(0);
        //             q.add(cur.substring(1));
        //         }
        //     }
        //     return merge;
        // }
        // public String largestMerge(String s, String t) {
        //     int m = s.length(), n = t.length(), len = m + n;
        //     char[] ss = s.toCharArray(), tt = t.toCharArray(), ans = new char[len];
        //     int x = 0, y = 0;
        //     for (int i = 0; i < len;) {
        //         if (y == n || (x < m && ss[x] > tt[y])) {// t已空或s字典序大，添加s中字符
        //             ans[i++] = ss[x++];
        //         } else if (x == m || (y < n && tt[y] > ss[x])) {// s已空或t字典序大，添加t中字符
        //             ans[i++] = tt[y++];
        //         } else { // 二者均非空且当前字符字典序相同
        //             int j = 0;
        //             while (x + j < m && y + j < n && ss[x + j] == tt[y + j])// 遍历直至一者末尾或二者字典序不同
        //                 j++;
        //             if (y + j == n || (x + j < m && ss[x + j] > tt[y + j]))// 重复上述判断过程
        //                 ans[i++] = ss[x++];
        //             else 
        //                 ans[i++] = tt[y++];
        //         }
        //     }
        //     return String.valueOf(ans);
        // }


        // public boolean canTransform(String s, String t) { // 不知道题目说的是什么意思
        //     int n = s.length();
        //     if (t.length() != n) return false;
        //     int i = 0, j = 0;
        //     if (n == 1) return s.charAt(0) == t.charAt(j);
        //     while (i < n && j < n) {
        //         // System.out.println("\n i: " + i);
        //         // System.out.println("j: " + j);
        //         // System.out.println("s.charAt(i): " + s.charAt(i));
        //         // System.out.println("t.charAt(j): " + t.charAt(j));
        //         if (i <= n-2 && j <= n-2 && (s.substring(i, i+2).equals("RX") && t.substring(j, j+2).equals("XR")
        //                                      || s.substring(i, i+2).equals("XL") && t.substring(j, j+2).equals("LX")
        //                                      || s.substring(i, i+2).equals("XR") && t.substring(j, j+2).equals("RX")
        //                                      || s.substring(i, i+2).equals("LX") && t.substring(j, j+2).equals("XL")
        //                                      // || s.substring(i, i+2).equals(t.substring(j, j+2))
        //                 )) {
        //             i += 2;
        //             j += 2;
        //         } else if (s.charAt(i) == t.charAt(j)) {
        //             i++;
        //             j++;
        //         } else return false;
        //     }
        //     return true;
        // }


        // public int findUnsortedSubarray(int[] arr) {
        //     int n = arr.length;
        //     int [] cp = Arrays.copyOf(arr, n);
        //     Arrays.sort(cp);
        //     int i = 0, j = n -1;
        //     while (i < n && arr[i] == cp[i]) i++;
        //     if (i == n) return 0;
        //     while (j >=  0 && arr[j] == cp[j]) j--;
        //     return j - i + 1;
        // }


        // public int nextGreaterElement(int n) {
        //     if (n == Integer.MAX_VALUE) return -1;
        //     StringBuilder s = new StringBuilder("" + n).reverse();
        //     char [] tmp = (""+n).toCharArray();
        //     Arrays.sort(tmp);
        //     if (s.toString().equals(new String(tmp))) return -1;
        // }


        // public boolean areSentencesSimilar(String s, String t) {
        //     String [] ss = s.split("\\s+");
        //     String [] tt = t.split("\\s+");
        //     int m = ss.length, n = tt.length;
        //     int i = 0, j = m-1, k = n-1;
        //     while (i < m && i < n && ss[i].equals(tt[i])) i++;
        //     while (j >= 0 && k >= 0 && ss[j].equals(tt[k])) {
        //         j--;
        //         k--;
        //     }
        //     if (j < i || k < i) return true;
        //     return  false;
        // }


        // public String lastSubstring(String s) { // tle tle tle
        //     int n = s.length();
        //     String res = "";
        //     // TreeSet<String> ts = new TreeSet<>();
        //     for (int i = n-1; i >= 0; i--) {
        //         String cur = s.substring(i);
        //         if (res.equals("") || cur.compareTo(res) > 0) res = cur;
        //     }
        //     return res;
        //     //     ts.add(s.substring(i));
        //     // return ts.last();
        // }      

        
        // public boolean canReach(String t, int minJump, int maxJump) { 
        //     int n = t.length(), len = maxJump - minJump;
        //     char [] s = t.toCharArray();
        //     if (s[n-1] == '1') return false;
        //     Queue<Integer> q = new LinkedList<>(); // 记录符合条件的左边界
        //     q.offer(0);
        //     Set<Integer> vis = new HashSet<>();
        //     vis.add(0);
        //     int range = 0;  // 当前已处理过的位置
        //     while (!q.isEmpty()) {
        //         int l = q.poll() + minJump, r = l + len; // 下次跳跃的左、右边界
        //         if (l > n-1) return false;  // 左边界超出字符串范围，说明无法到达
        //         if (r >= n-1) return true;
        //         l = Math.max(l, range + 1); // 左边界快进到已处理过的位置，这里没有重复添加应该是一种优化了
        //         for (int i = l; i <= r; i++) {
        //             if (s[i] == '0') q.offer(i);
        //             range = r; // 记录当前已处理过的位置
        //             // while (!q.isEmpty() && q.peek() + len < range) // 这里删除掉会漏掉一些得到正确的机会，所以不能删除
        //             //     q.poll();
        //         }
        //     }
        //     return false;
        // }
        // public boolean canReach(String t, int minJump, int maxJump) {
        //     int n = s.length();
        //     boolean[] dp = new boolean[n];
        //     dp[0] = true;
        //     int farthest = 0;  // 优化
        //     for (int i = 0; i < n; i++) {
        //         if (!dp[i]) continue;
        //         int l = i + minJump;
        //         int r = Math.min(n - 1, i + maxJump);
        //         for (int j = Math.max(l, farthest); j <= r; j++) { // 优化
        //             if (s.charAt(j) == '0')
        //                 dp[j] = true;
        //         }
        //         farthest = Math.max(farthest, r); // 优化
        //     }
        //     return dp[n - 1];
        // }

        
        // private void shiftRightByOne(int [] arr) { // tle
        //     int n = arr.length;
        //     int v = arr[n-1];
        //     System.arraycopy(arr, 0, arr, 1, n-1);
        //     arr[0] = v;
        // }
        // public void rotate(int[] arr, int k) {
        //     while (k-- > 0)
        //         shiftRightByOne(arr);
        // }
        // private void swap(int [] arr, int i, int j) {
        //     int tmp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = tmp;
        // }
        // private void reverse(int [] arr, int i, int j) {
        //     while (i < j) {
        //         swap(arr, i, j);
        //         i++;
        //         j--;
        //     }
        // }
        // public void rotate(int[] arr, int k) {
        //     int n = arr.length;
        //     if (n == 1) return;
        //     if (k >= n) k %= n;
        //     reverse(arr, 0, n-k-1);
        //     reverse(arr, n-k, n-1);
        //     reverse(arr, 0, n-1);
        // }


        // public int[] numMovesStonesII(int[] stones) {
        //     Arrays.sort(stones);
        //     int n = stones.length, low = n, i = 0;
        //     for (int j = 0; j < n; j++) {
        //         while (stones[j] - stones[i] + 1 > n) i++;
        //         int occ = j - i + 1;
        //         if (occ == n-1 && stones[j] - stones[i] + 1 == n-1) 
        //             low = Math.min(low, 2);
        //         else low = Math.min(low, n - occ);
        //     }
        //     return new int [] {low, Math.max(stones[n-1] - stones[1]-n+2, stones[n-2] - stones[0]-n+2)};
        // }


        // public int numSubarrayBoundedMax(int[] arr, int left, int right) { // 这里还是那个数个数数不清楚
        //     int n = arr.length, pre = -1;
        //     int [] dp = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] < left) 
        //             dp[i] = (i == 0 ? 0 : dp[i-1]);
        //         else if (arr[i] > right) {
        //             dp[i] = 0;
        //             pre = i;
        //         } else dp[i] = i - pre;
        //     }
        //     return Arrays.stream(dp).sum();
        // }
        // public int numSubarrayBoundedMax(int[] arr, int left, int right) { // 这里还是那个数个数数不清楚
        //     int n = arr.length, pre = -1, ans = 0, cnt = 0, preCnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] < left) {
        //             cnt = (i == 0 ? 0 : preCnt);
        //             ans += cnt;
        //             preCnt = cnt;
        //         }
        //         else if (arr[i] > right) {
        //             preCnt = 0;
        //             pre = i;
        //         } else {
        //             cnt = i - pre;
        //             ans += cnt;
        //             preCnt = cnt;
        //         } 
        //     }
        //     return ans;
        // }


        // private int findRightMostIdx(int [] a, int l, int r, int v) { // 寻找右边界
        //     if (a[l] >= v) return -1;
        //     while (l < r) {
        //         int m = l + (r - l) / 2 + 1;
        //         if (a[m] >= v) r = m -1;
        //         else l = m;
        //     }
        //     return a[r] < v ? r : -1;
        // }
        // public int triangleNumber(int[] a) {
        //     Arrays.sort(a);
        //     int n = a.length, ans = 0;
        //     for (int i = 1; i < n-1; i++) {
        //         for (int j = i-1; j >= 0; j--) {
        //             if (a[i] + a[j] <= a[i+1]) break;
        //             int k = findRightMostIdx(a, i, n-1, a[i] + a[j]);
        //             if (k != -1) ans += k - i;
        //         }
        //     }
        //     return ans;
        // }
        // private int binarySearch(int [] a, int l, int v) {
        //     int r = a.length-1;
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         if (a[m] >= v) r = m-1;
        //         else l = m+1;
        //     }
        //     return l;
        // }
        // public int triangleNumber(int[] a) { // O(N^2logN)
        //     Arrays.sort(a);
        //     int n = a.length, ans = 0;
        //     for (int i = 0; i < n-2; i++) 
        //         for (int j = i+1; j < n-1; j++) {
        //             int k = binarySearch(a, j+1, a[i]+a[j]);
        //             ans += k - j - 1;
        //         }
        //     return ans;
        // }
        // // 解法II 排序（Sort） + 双指针（Two Pointers）
        // // 时间复杂度O(n^2)
        // //     对输入数组nums排序
        // //     枚举长度最小的边，利用双指针寻找符合条件的长度较大的两条边。
        // public int triangleNumber(int[] a) { // O(N^2)
        //     Arrays.sort(a);
        //     int n = a.length, ans = 0;
        //     for (int i = 0; i < n-2; i++) {
        //         if (a[i] == 0) continue;
        //         int k = i+2; // i + 2 这里的2
        //         for (int j = i+1; j < n-1; j++) {
        //             while (k < n && a[k] < a[i] + a[j]) k++;
        //             ans += k - j - 1;
        //         }
        //     }
        //     return ans;
        // }
        // public int triangleNumber(int[] a) { // O(N^2)
        //     Arrays.sort(a);
        //     int n = a.length, ans = 0;
        //     for (int i = n-1; i >= 2; i--) {
        //         int l = 0, r = i-1;
        //         while (l < r) {
        //             if (a[l] + a[r] > a[i]) {
        //                 ans += r - l;
        //                 --r;
        //             } else l++;
        //         }
        //     }
        //     return ans;
        // }


        // private boolean isMatch(String ss, String tt) {
        //     int m = ss.length(), n = tt.length(), cs = 0, ct = 0, i = 0, j = 0, k = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for ( i = 0; i < m && j < n; i++) {
        //         if (s[i] != t[j]) return false;
        //         k = i;
        //         cs = 0;
        //         while (k < m && s[k] == s[i]) {
        //             k++;
        //             cs++;
        //         }
        //         k = j;
        //         ct = 0;
        //         while (k < n && t[k] == t[j]) {
        //             k++;
        //             ct++;
        //         }
        //         if (cs > ct || cs < ct && ct < 3) return false; // 这里不应该要 >= 的
        //         i += cs-1;
        //         j += ct;
        //     }
        //     return j == n && i == m;
        // }
        // public int expressiveWords(String s, String[] words) {
        //     int ans = 0;
        //     for (String v : words) 
        //         if (isMatch(v, s)) ans++;
        //     return ans;
        // }


        // private void getAllSubsequences(char [] s, Set<String> ss, int idx, StringBuilder sb) { // 居然不会写有return type的函数
        //     if (idx == s.length) {
        //         ss.add(new String(sb.toString()));
        //         return;
        //     }
        //     for (int i = idx; i < s.length; i++) {
        //         sb.append(s[i]);
        //         getAllSubsequences(s, ss, i+1, sb);
        //         sb.deleteCharAt(sb.length()-1);
        //     }
        //     getAllSubsequences(s, ss, idx+1, sb); // 这个case不能忘记了
        // }
        // private Set<String> getAllSubsequences(String s) {
        //     Set<String> ss = new HashSet<>();
        //     if (s.length() == 0) {
        //         ss.add("");
        //         return ss;
        //     }
        //     Set<String> sub = getAllSubsequences(s.substring(1));
        //     ss.addAll(sub);
        //     for (String v : sub) 
        //         ss.add(s.charAt(0) + v);
        //     return ss;
        // }
        // public int findLUSlength(String[] strs) {
        //     int n = strs.length;
        //     Map<String, Integer> m = new HashMap<>();
        //     for (String s : strs) {
        //         // Set<String> ss = new HashSet<>();
        //         // getAllSubsequences(s.toCharArray(), ss, 0, new StringBuilder());
        //         Set<String> ss = getAllSubsequences(s);
        //         for (String cur : ss) 
        //             m.put(cur, m.getOrDefault(cur, 0) + 1);
        //     }
        //     int ans = -1;
        //     for (Map.Entry<String, Integer> en : m.entrySet()) {
        //         String k = en.getKey();
        //         if (en.getValue() == 1)
        //             ans = Math.max(ans, k.length());
        //     }
        //     return ans;
        // }
        // We can check each string that whether it is a subsequence of any other string.
        // If a string is not a subsequence of any other string i.e. it is uncommon , we will return maximum length string out of them.
        //     If no string found, we will return -1.
        // public int findLUSlength(String [] strs) {
        //     int max = -1;
        //     for (int i = 0; i < strs.length; i++) {
        //         boolean flag = false;
        //         int curLen = strs[i].length();
        //         for (int j = 0; j < strs.length; j++) 
        //             if (i != j && check(strs[i], strs[j])) {
        //                 flag = true;
        //                 break;
        //             }
        //         if (!flag)
        //             max = Math.max(max, curLen);
        //     }
        //     return max;
        // }
        // public boolean check(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     while (m > 0 && n > 0) {
        //         int i = ss.length() - m;
        //         int j = tt.length() - n;
        //         if (s[i] == t[j]) m--;
        //         n--;
        //     }
        //     return m == 0;
        // }


        // private int quickmul(int base, int exp) {
        //     long ans = 1, b = base;
        //     while (exp > 0) {
        //         if (exp % 2 == 1)
        //             ans = (ans * b) % mod;
        //         b = (b * b) % mod;
        //         exp >>= 1;
        //     }
        //     return (int) ans;
        // }
        // public int numSubseq(int[] arr, int target) {
        //     Arrays.sort(arr);
        //     int n = arr.length, res = 0, j = 0;
        //     int mod = (int)1e9 + 7;
        //     int [] dp = new int [n+1];
        //     dp[0] = 1;
        //     for (int i = 1; i <= n; i++) 
        //         dp[i] = (int)((dp[i-1] * 2) % mod);
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] * 2 > target) break; 
        //         j = i;
        //         while (j < n && arr[i] + arr[j] <= target) j++; // 这个向右遍历，我每个i都走了一次，实际上可以全局只一次遍历到最远，再往回缩
        //         res = (res + dp[j-i-1]) % mod;
        //     }
        //     return res;
        // }
        // O(nlogn) sorting, O(n)
        // public int numSubseq(int[] arr, int target) {
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length, ans = 0;
        //     Arrays.sort(arr);
        //     int [] pow = new int [n];
        //     pow[0] = 1;
        //     for (int i = 1; i < n; i++) 
        //         pow[i] = (int)((pow[i-1] * 2) % mod);
        //     int l = 0, r = 0;
        //     while (r < n && arr[l] + arr[r] <= target) r++;
        //     r--;
        //     while (l <= r) {
        //         int cnt = r - l + 1;
        //         ans = (int)((ans + (long)pow[cnt - 1]) % mod);
        //         l++;
        //         while (l < n && r >= 0 && arr[l] + arr[r] > target) r--;
        //     }
        //     return ans;
        // }


        // private boolean isPalindrome(String s) {
        //     int n = s.length();
        //     int i = 0, j = n-1;
        //     while (i < j && s.charAt(i) == s.charAt(j)) {
        //         i++;
        //         j--;
        //     }
        //     return i >= j;
        // }
        // public boolean checkPalindromeFormation(String s, String t) { // tle tle tle
        //     int n = a.length();
        //     for (int i = 0; i < n; i++) {
        //         String a = s.substring(0, i) + t.substring(i);
        //         if (isPalindrome(a)) return true;
        //         String b = t.substring(0, i) + s.substring(i);
        //         if (isPalindrome(b)) return true;
        //     }            
        //     return false;
        // }
        // private boolean isPalindrom(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int i = 0, j = n-1;
        //     while (i < j) {
        //         if (s[i] == s[j]) {
        //             i++;
        //             j--;
        //         } else break;
        //     }
        //     return i >= j;
        // }
        // public boolean checkPalindromeFormation(String ss, String tt) { // bug bug bug
        //     if (isPalindrom(ss) || isPalindrom(tt)) return true;
        //     int n = ss.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0, j = n-1;
        //     while (i < n && j >= 0 && i < j) {
        //         if (s[i] == t[j]) {
        //             ++i;
        //             --j;
        //         } else break;
        //     }
        //     if (i == j || i == j+1) return true;
        //     if (isPalindrom(ss.substring(0, i) + tt.substring(i)) || isPalindrom(tt.substring(0, j+1) + tt.substring(j+1))) return true;
        //     i = n-1;
        //     j = 0;
        //     while (i >= 0 && j < n && j < i) {
        //         if (s[i] == t[j]) {
        //             --i;
        //             ++j;
        //         } else return false;
        //     }
        //     return true;
        // }
        // private boolean isPalindrome(String t, int i, int j) {
        //     char [] s = t.toCharArray();
        //     while (i < j && s[i] == s[j]) {
        //         i++;
        //         j--;
        //     }
        //     return i >= j;
        // }
        // private boolean check(String ss, String tt) {
        //     int n = ss.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0, j = n-1;
        //     while (i < j && s[i] == t[j]) {
        //         i++;
        //         j--;
        //     }
        //     return isPalindrome(ss, i, j) || isPalindrome(tt, i, j);
        // }

        // public boolean canTransform(String ss, String tt) {
        //     int n = ss.length(), i = 0, j = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     while (i < n && j < n) {
        //         while (i < n && s[i] == 'X') i++;
        //         while (j < n && t[j] == 'X') j++;
        //         if (i == n || j == n) break;
        //         if (s[i] != t[j]) return false;
        //         if (s[i] == 'L' && i < j || s[i] == 'R' && i > j) return false;
        //         i++;
        //         j++;
        //     }
        //     while (i < n) {
        //         if (s[i] != 'X') return false;
        //         i++;
        //     }
        //     while (j < n) {
        //         if (t[j] != 'X') return false;
        //         j++;
        //     }
        //     return true;
        // }
        // public boolean canTransform(String ss, String tt) { // 这个方法是存在漏洞的
        //     int n = ss.length(), cntL = 0, cntR = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (t[i] == 'L') ++cntL;
        //         if (s[i] == 'R') ++cntR;
        //         if (s[i] == 'L') --cntL;
        //         if (t[i] == 'R') --cntR;
        //         if (cntL < 0 || cntR < 0 || cntL * cntR != 0) return false;
        //     }
        //     return cntL == 0 && cntR == 0;
        // }
        // // String a = "RLX";
        // // String b = "XLR";

        // public int [][] flipAndInvertImage(int [][] a) {
        //     int m = a.length, n = a[0].length;
        //     for (int i = 0; i < m; i++) {
        //         int j = 0, k = n-1;
        //         while (j < k) {
        //             int tmp = a[i][j];
        //             a[i][j++] = 1 - a[i][k];
        //             a[i][k--] = 1 - tmp;
        //         }
        //         if (k == j)
        //             a[i][j] = 1 - a[i][j];
        //     }
        //     return a;
        // }

        //  public String reverseWords(String t) {
        //     String [] str = t.split("\\s+");
        //     for (int i = 0; i < str.length; i++) 
        //         str[i] = new StringBuilder(str[i]).reverse().toString();
        //     String ans = str[0];
        //     for (int i = 1; i < str.length; i++) 
        //         ans += " " + str[i];
        //     return ans;
        // }

        // public String mergeAlternately(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0, j = 0;
        //     String ans = "";
        //     while (i < m && j < n) 
        //         ans += "" + s[i++] + t[j++];
        //     if (i < m) ans += ss.substring(i);
        //     if (j < n) ans += tt.substring(j);
        //     return ans;
        // }

        // public int[] sortArrayByParityII(int[] a) {
        //     int n = a.length, i = 0, j = 1;
        //     while (i < n && j < n) {
        //         if (a[i] % 2 == 0) i += 2;
        //         else if (a[j] % 2 == 1) j += 2;
        //         else {
        //             int tmp = a[i];
        //             a[i] = a[j];
        //             a[j] = tmp;
        //         }
        //     }
        //     return a;
        // }

        
        // public String reverseStr(String s, int k) { // bug
        //     int n = s.length(), i = k, j = 0, cnt = 0;
        //     while (n >= 2 * k && i < n) {
        //         s = (j == 0 ? "" : s.substring(0, j)) + new StringBuilder(s.substring(j, i)).reverse().toString() + s.substring(i);
        //         i += 2 * k;
        //         j = i + k;
        //     }
        //     if (n % (2 * k) != 0) s = s.substring(0, n-n% (2 * k)) 
        //                               + new StringBuilder(s.substring(n - n % (2 * k), Math.min(n-n%(2*k)+k, n))).reverse().toString()
        //                               + (n-n%(2*k)+k <= n ? s.substring(n - n % (2 * k) + k) : "");
        //     return s;
        // }

        // public int[] shortestToChar(String t, char c) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     TreeSet<Integer> ts = new TreeSet<>();
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == c) ts.add(i);
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == c) continue;
        //         Integer lower = ts.lower(i);
        //         Integer higher = ts.higher(i);
        //         if (lower == null) lower = Integer.MIN_VALUE / 2;
        //         if (higher == null) higher = Integer.MAX_VALUE / 2;
        //         ans[i] = Math.min(i-lower, higher - i);
        //     }
        //     return ans;
        // }

        // public int removePalindromeSub(String t) {
        //     int n = t.length();
        //     if (isPalindrom(t)) return 1;
        //     return 2;
        // }
        // private boolean isPalindrom(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }

        // public String reverseOnlyLetters(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     char [] s = t.toCharArray();
        //     while (i < j) {
        //         if (!Character.isLetter(s[i])) {
        //             i++;
        //             continue;
        //         }
        //         if (!Character.isLetter(s[j])) {
        //             j--;
        //             continue;
        //         }
        //         char tmp = s[i];
        //         s[i++] = s[j];
        //         s[j--] = tmp;
        //     }
        //     return new String(s);
        // }

        // public int countBinarySubstrings(String t) {
        //     int n = t.length(), cnt = 0, j = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n-1; i++) {
        //         j = i+1;
        //         if (s[i] == '0' && s[j] == '1' || s[i] == '1' && s[j] == '0') {
        //             cnt++;
        //             for (int d = 1; i - d >= 0 && j + d < n; d++) {
        //                 if (s[i-d] == s[i] && s[j+d] == s[j]) cnt++;
        //                 else break;
        //             }
        //         }
        //     }
        //     return cnt;
        // }

        // public int findTheDistanceValue(int[] a, int[] b, int d) {
        //     int m = a.length, n = b.length, cnt = 0;
        //     Arrays.sort(b);
        //     for (int i = 0; i < m; i++) {
        //         int v = binarySearch(a[i], b);
        //         if (Math.abs(a[i] - v) > d) cnt++;
        //     }
        //     return cnt;
        // }
        // private int binarySearch(int v, int [] a) {
        //     int n = a.length, ans = 0, l = 0, r = n-1;
        //     while (l < r-1) {
        //         int m = l + (r - l)/ 2;
        //         if (a[m] == v) return v;
        //         else if (a[m] < v)
        //             l = m;
        //         else r = m;
        //     }
        //     return Math.abs(a[l] - v) <= Math.abs(a[r] - v) ? a[l] : a[r];
        // }

        // public void duplicateZeros(int[] a) { // bug: todo
        //     int n = a.length, cnt = 0, i = 0, j = 0;
        //     if (Arrays.stream(a).max().getAsInt() == 0) return ;
        //     while (i < n) {
        //         if (a[i] == 0) {
        //             while (i < n && a[i++] == 0) cnt++;
        //             int k = i;
        //             if (i + cnt * 2 < n) {
        //                 System.arraycopy(a, i+cnt, a, i+2 * cnt, n-(i + 2 * cnt + 1)); // BUG: 这里i 会变
        //             }
        //             System.out.println("k: " + k); // k 也会变
        //             Arrays.fill(a, k, Math.min(n, k + cnt * 2), 0);
        //             // Arrays.fill(a, 3, 8, 0);
        //             System.out.println(Arrays.toString(a));
        //             if (k + cnt * 2 >= n) return ;
        //             i = Math.min(n, k + 2 * cnt);
        //             System.out.println("i: " + i);
        //         } else i++;
        //     }
        //     System.out.println(Arrays.toString(a));
        // }

        // public boolean backspaceCompare(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     ArrayDeque<Character> sts = new ArrayDeque<>();
        //     ArrayDeque<Character> stt = new ArrayDeque<>();
        //     for (int i = 0; i < m; i++) 
        //         if (s[i] == '#') {
        //             if (!sts.isEmpty()) 
        //                 sts.pollLast();
        //         } else sts.offerLast(s[i]);
        //     for (int i = 0; i < n; i++) 
        //         if (t[i] == '#') {
        //             if (!stt.isEmpty()) stt.pollLast();
        //         } else stt.offerLast(t[i]);
        //     while (!sts.isEmpty() && !stt.isEmpty()) 
        //         if (sts.pollLast() != stt.pollLast()) return false;
        //     if (!sts.isEmpty() || !stt.isEmpty()) return false;
        //     return true;
        // }
        
        // public boolean validPalindrome(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     if (n == 1) return true;
        //     char [] s = t.toCharArray();
        //     while (i < j) {
        //         if (s[i] == s[j]) {
        //             i++;
        //             j--;
        //         } else 
        //             return isPalindrom(t.substring(i, j)) || isPalindrom(t.substring(i+1, j+1));
        //     }
        //     return true;
        // }
        // private boolean isPalindrom(String t) {
        //     int n = t.length(), i = 0, j = n-1;;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }

        // public boolean checkIfExist(int[] a) {
        //     int n = a.length;
        //     Set<Integer> vis = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] % 2 == 0 && vis.contains(a[i] / 2)
        //             || vis.contains(a[i] * 2)) return true;
        //         vis.add(a[i]);
        //     }
        //     return false;
        // }

        // public boolean isLongPressedName(String ss, String tt) {
        //     int m = ss.length(), n = tt.length(), i = 1, j = 1;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     if (s[0] != t[0]) return false;
        //     while (i < m && j < n) {
        //         if (s[i] == t[j]) {
        //             i++;
        //             j++;
        //             continue;
        //         }
        //         while (j < n && t[j] == t[j-1]) j++;
        //         if (i < m && j < n && s[i] != t[j]) return false;
        //     }
        //     if (i < m) return false;
        //     while (j < n && t[j] == s[m-1]) j++;
        //     if (j < n) return false;
        //     return true;
        // }

    }   
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "saeed";
        // String b = "ssaaedd";

        // String a = "vtkgn";
        // String b = "vttkgnn";
        
        String a = "alex";
        String b = "alexxr";

        boolean r = s.isLongPressedName(a, b);
        System.out.println("r: " + r);
    }
}                                        //....
// "jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfx ubewllxzqhpasguvlrxt kgatzfybprfmmfithphccxfsogsgqsnvckjvnskk"
// "jlnnxsetgcpsbhsfymrkhfursyissjnsocgdhgfx txrlvugsaphqzxllwebu kgatzfybprfmmfithphccxfsogsgqsnvckjvnskk"
