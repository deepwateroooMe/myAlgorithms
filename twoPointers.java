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


        // public int expressiveWords(String s, String[] words) {
        //     int m = words.length;
        //     int n = s.length(), i, ans = 0;
        //     int [] cnt = new int [n];
        //     Arrays.fill(cnt, -1);
        //     int i = 0, idx = 0;
        //     while (i < n) {
        //     }
        //     for ( i = 0; i < n; i++) 
        //         cnt[s.charAt(i)]++;
        //     int [] cur = new int [128];
        //     for (String t : words) {
        //         Arrays.fill(cur, 0);
        //         for ( i = 0; i < t.length(); i++) 
        //             cur[t.charAt(i)]++;
        //         for ( i = 0; i < 128; i++) 
        //             if (cur[i] - cnt[i] > 0 || cnt[i] < 3 && cur[i] < cnt[i] || cnt[i] > 0 && cur[i] == 0) break;
        //         if (i < 128) continue;
        //         ++ans;
        //     }
        //     return ans;
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

        // private void shiftRightByOne(int [] arr) { // tle tle tle tle tle tle tle
        //     int n = arr.length;
        //     int v = arr[n-1];
        //     System.arraycopy(arr, 0, arr, 1, n-1);
        //     arr[0] = v;
        // }
        // public void rotate(int[] arr, int k) {
        //     while (k-- > 0)
        //         shiftRightByOne(arr);
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

        
    }   
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "011010";
        // String a = "01";
        String a = "011001110001000";

        boolean r = s.canReach(a, 3, 5);
        System.out.println("r: " + r);
    }
}

