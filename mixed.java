// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class mixed {
    public static class Solution {
            
        // Iterator<Integer> it;
        // Integer next;
        // public PeekingIterator(Iterator<Integer> iterator) {
        //     this.it = iterator;
        //     if (it.hasNext())
        //         next = it.next();
        // }
        // public Integer peek() {
        //     return next;
        // }
        // @Override
        // public Integer next() {
        //     Integer res = next;
        //     next = it.hasNext() ? it.next() : null;
        //     return res;
        // }
        // @Override
        // public boolean hasNext() {
        //     return next != null;
        // }


        // int [] arr;
        // int idx;
        // public RLEIterator(int[] encoding) {
        //     idx = 0;
        //     this.arr = Arrays.copyOf(encoding, encoding.length);
        // }
        // public int next(int n) {
        //     int cnt = 0;
        //     while (cnt < n) {
        //         while (idx < arr.length-1 && cnt < n) {
        //             if (arr[idx] >= n-cnt) {
        //                 arr[idx] -= n-cnt;
        //                 return arr[idx+1];
        //             } else {
        //                 cnt += arr[idx];
        //                 arr[idx] = 0;
        //                 idx += 2;
        //             }
        //         }
        //         if (idx == arr.length) break;
        //     }
        //     return -1;
        // }

        
        // public boolean sumGame(String t) {
        //     int n = t.length(), m = n / 2, ca = 0, cb = 0, sa = 0, sb = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < m; i++) 
        //         if (s[i] != '?') sa += s[i] - '0';
        //         else ca++;
        //     for (int i = m; i < n; i++) 
        //         if (s[i] != '?') sb += s[i] - '0';
        //         else cb++;
        //     System.out.println("sa: " + sa);
        //     System.out.println("ca: " + ca);
        //     System.out.println("sb: " + sb);
        //     System.out.println("cb: " + cb);
        //     if (ca == 0 && cb == 0) return sa != sb; // 这个里面的策略还要再想一想
        //     if (ca == 0 || cb == 0) {
        //         if (ca == 0) {
        //             if (sa < sb) return true;
        //         }
        //     }
        //     return true;
        // } 


        // private boolean dfs(int i, int cnt) { // memory limit reached
        //     if (dp[i][cnt] != null) return dp[i][cnt];
        //     if (cnt == 0) return i == 1;
        //     if (i == 0) { // my turn
        //         for (int j = 1; j <= Math.min(3, cnt); j++) 
        //             if (dfs(1-i, cnt-j)) return dp[i][cnt] = true;
        //         return  dp[i][cnt] = false;
        //     } else {
        //         for (int j = 1; j <= Math.min(3, cnt); j++) 
        //             if (!dfs(1-i, cnt-j)) return dp[i][cnt] = false;
        //         return dp[i][cnt] = true;
        //     }
        // }
        // Boolean [][] dp;
        // public boolean canWinNim(int n) {
        //     dp = new Boolean [2][n+1];
        //     return dfs(0, n);
        // }
        // public boolean canWinNim(int n) { // 终于该要学习动态规划，以及空间压缩了。。。。。。 
        //     // if (n == 0) return false;
        //     // if (n < 4) return true;
        //     // boolean [] dp = new boolean[6];
        //     // dp[0] = false;
        //     // for (int i = 1; i <= 3; i++) 
        //     //     dp[i] = true;
        //     // for (int cur = 4; cur <= n; cur++) {
        //     //     int i = 1;
        //     //     for (i = 1; i <= 3; i++) //依次尝试拿走 1,2,3 个
        //     //         if (dp[(cur-i-1) % 6] && dp[(cur-i-2) % 6] && dp[(cur-i-3) % 6]) { //对方拿走 1 个，2 个，3 个, 你都有稳赢的策略
        //     //             dp[cur % 6] = true;
        //     //             break;
        //     //         } // 数组在循环使用，所以如果内层的 for 循环尝试了所有情况都不行的话，我们要将当前值置为 false ，因为它之前可能是 true。
        //     //     if (i == 4) dp[cur % 6] = false; // 因为压缩空间带来的问题
        //     // }
        //     // return dp[n % 6];
        //     return n % 4 != 0;
        // }


        // public int reverseBits(int n) { // bug
        //     String t = "" + n;
        //     char [] s = t.toCharArray();
        //     String ans = "";
        //     for (int i = 0; i < s.length; i++) 
        //         ans += "" + ((char)(1 - s[i]-'0') + '0');
        //     return new BigInteger(ans, 2).intValue();
        // }

        // public int hammingWeight(int n) {
        //     int cnt = 0;
        //     for (int i = 31; i >= 0; i--) 
        //         if (((n >> i) & 1) == 1) cnt++;
        //     return cnt;
        // }


        // public boolean isHappy(int n) {
        //     int v = 0, cnt = 1000;
        //     while (n > 0 && cnt > 0) {
        //         while (n > 0) {
        //             v += (n % 10) * (n % 10);
        //             n /= 10;
        //         }
        //        cnt--;
        //         if (v == 1) return true;
        //         n = v;
        //         v = 0;
        //     }
        //     return false;
        // }


        // public boolean isIsomorphic(String ss, String tt) {
        //     int n = ss.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     Set<Character> chs = new HashSet<>();
        //     Map<Character, Character> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (!m.containsKey(s[i]) && !chs.contains(t[i])) {
        //             m.put(s[i], t[i]);
        //             chs.add(t[i]);
        //         } else if (!m.containsKey(s[i]) && chs.contains(t[i]))
        //             return false;
        //         if (m.get(s[i]) == t[i]) continue;
        //         if (m.get(s[i]) != t[i])
        //             return false;
        //      }
        //     return true;
        // }


        // public boolean containsDuplicate(int[] arr) {
        //     int n = arr.length;
        //     Set<Integer> s = new HashSet<>();
        //     for (Integer v : arr) 
        //         if (!s.add(v)) return true;
        //     return false;
        // }


        // public boolean containsNearbyDuplicate(int[] arr, int k) {
        //     int n = arr.length;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         m.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
        //         int v = m.get(arr[i]).size();
        //         if (v >= 2 && i - m.get(arr[i]).get(v-2) <= k)
        //             return true;
        //     }
        //     return false;
        // }


        // public int computeArea(int ai, int aj, int bi, int bj, int xi, int xj, int yi, int yj) {
        //     if (bi < xi || yi < ai || yj < aj || bj < xj) { // no overlap, left right up down
        //         return (bi - ai) * (bj - aj) + (yi - xi) * (yj - xj);
        //     } else if (xi >= ai && xj >= aj && yi <= bi && yj <= bj // one inside the other
        //                || xi <= ai && xj <= aj && bi <= yi && bj <= yj) {
        //         if (ai <= xi && yj <= bj) 
        //             return (bi - ai) * (bj - aj);
        //         return (yi - xi) * (yj - xj);
        //     } else { // overlaps
        //     }
        // }

        // ArrayDeque<Integer> s;
        // public MyStack() {
        //     s = new ArrayDeque<>();
        // }
        // public void push(int x) {
        //     s.push(x);
        // }
        // public int pop() {
        //     return s.pop();
        // }
        // public int top() {
        //     return s.peek();
        // }
        // public boolean empty() {
        //     return s.isEmpty();
        // }


        // public List<String> summaryRanges(int[] a) {
        //     List<String> l = new ArrayList<>();
        //     int n = a.length, j = 0, i = 0;
        //     if (n == 0) return l;
        //     while (i < n) {
        //         j = i;
        //         while (i < n-1 && a[i+1] == a[i] + 1) i++;
        //         if (i == j)
        //             l.add(""+a[i]);
        //         else {
        //             String cur = "" + a[j] + "->" +  a[i];
        //             l.add(cur);
        //         }
        //         i++;
        //     }
        //     return l;
        // }

        // Stack<Integer>[] s;
        // int idx;
        // public MyQueue() {
        //     s = new Stack[2];
        //     for (int i = 0; i < 2; i++) 
        //         s[i] = new Stack<>();
        //     idx = 0;
        // }
        // public void push(int x) {
        //     if (s[idx].isEmpty()) {
        //         s[idx].push(x);
        //         return;
        //     }
        //     while (!s[idx].isEmpty()) s[1-idx].push(s[idx].pop());
        //     idx = 1 - idx;
        //     s[idx].push(x);
        //     while (!s[idx].isEmpty()) s[1-idx].push(s[idx].pop());
        //     idx = 1 - idx;
        // }
        // public int pop() {
        //     return s[idx].pop();
        // }
        // public int peek() {
        //     return s[idx].peek();
        // }
        // public boolean empty() {
        //     return s[idx].isEmpty();
        // }


        // public boolean isAnagram(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     if (m != n) return false;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     Map<Character, Integer> ms = new HashMap<>();
        //     Map<Character, Integer> mt = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         ms.put(s[i], ms.getOrDefault(s[i], 0) + 1);
        //         mt.put(t[i], mt.getOrDefault(t[i], 0) + 1);
        //     }
        //     if (ms.size() != mt.size()) return false;
        //     for (Map.Entry<Character, Integer> en : ms.entrySet()) {
        //         char k = en.getKey();
        //         int v = en.getValue();
        //         if (!mt.containsKey(k) || mt.get(k) != v) return false;
        //     }
        //     return true;
        // }


        // public int addDigits(int num) {
        //     String s = "" + num;
        //     while (s.length() > 1) {
        //         int v = 0;
        //         for (int i = 0; i < s.length(); i++) 
        //             v += s.charAt(i) - '0';
        //         s = "" + v;
        //     }
        //     return Integer.parseInt(s);
        // }


        // public boolean isUgly(int n) {
        //     if (n <= 0) return false;
        //     if (n <= 5) return true;
        //     int [] p = {2, 3, 5};
        //     while (n > 5 && n % 5 == 0) n /= 5;
        //     while (n > 3 && n % 3 == 0) n /= 3;
        //     while (n > 2 && n % 2 == 0) n /= 2;
        //     return (n == 2 || n == 3 || n == 5);
        // }


        // public int missingNumber(int[] a) {
        //     Set<Integer> s = new HashSet<>();
        //     s.addAll(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     int n = Arrays.stream(a).max().getAsInt();
        //     for (int i = 0; i <= n; i++)
        //         if (!s.contains(i)) return i;
        //     return n+1;
        // }


        // public int hIndex(int[] a) {
        //     if (a.length == 1) return a[0] >= 1 ? 1 : 0;
        //     Arrays.sort(a);
        //     int l = 1, h = a.length;
        //     while (l < h) {
        //         int m = (l + h) / 2, cnt = 0;
        //         for (int i = 0; i < a.length; i++) 
        //             if (a[i] >= m) cnt++;
        //         if (cnt >= m) l = m;
        //         else h = m-1;
        //     }
        //     return l;
        // }

        // public int firstBadVersion(int n) {
        //     int l = 1, r = n;
        //     while (l < r) {
        //         int m = l + (r - l) / 2;
        //         if (isBadVersion(m)) r = m-1;
        //         else l = m + 1;
        //     }
        //     return isBadVersion(l) ? l : l + 1;
        // }

        
        // public void moveZeroes(int[] a) {
        //     int idx = 0;
        //     for (int i = 0; i < a.length; i++) 
        //         if (a[i] != 0) 
        //             a[idx++] = a[i];
        //     for (int i = idx; i < a.length; i++)
        //         a[i] = 0;
        // }

        // public void gameOfLife(int[][] a) {
        //     int [][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        //     int m = a.length, n = a[0].length, cnt = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             cnt = 0;
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //                 if (a[x][y] == 1 || a[x][y] == -1) cnt++;
        //             }
        //             if (a[i][j] == 1 && (cnt < 2 || cnt > 3)) a[i][j] = -1;
        //             else if (cnt == 3 && a[i][j] == 0) a[i][j] = 2;
        //         }
        //     }
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (a[i][j] == -1) a[i][j] = 0;
        //             else if (a[i][j] == 2) a[i][j] = 1;
        // }


        // public boolean wordPattern(String pattern, String ss) {
        //     char [] s = pattern.toCharArray();
        //     String [] t = ss.split("\\s+");
        //     int n = pattern.length(), m = t.length;
        //     if (m != n) return false;
        //     Map<Character, String> map = new HashMap<>();
        //     Set<String> vis = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         if (!map.containsKey(s[i])) {
        //             if (vis.contains(t[i])) return false;
        //             map.put(s[i], t[i]);
        //             vis.add(t[i]);
        //         }
        //         if (!map.get(s[i]).equals(t[i])) return false;
        //     }
        //     return true;
        // }

        // int [] arr, sum;
        // int n;
        // public NumArray(int[] a) {
        //     n = a.length;
        //     arr = Arrays.copyOf(a, n);
        //     sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        // }
        // public int sumRange(int left, int right) {
        //     return sum[right] - (left == 0 ? 0 : sum[left-1]);
        // }

        // int [][] a, sum;
        // int m, n;
        // public NumMatrix(int[][] mat) {
        //     int m = mat.length, n = mat[0].length;
        //     a = new int [m][];
        //     for (int i = 0; i < m; i++)
        //         a[i] = Arrays.copyOf(mat[i], n);
        //     sum = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
        // }
        // public int sumRegion(int i, int j, int x, int y) {
        //     return sum[x+1][y+1] - sum[x+1][j] - sum[i][y+1] + sum[i][j];
        // }

        // public String reverseVowels(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     char [] ow = "aeiouAEIOU".toCharArray();
        //     Set<Character> sc = new HashSet<Character>();
        //     for (Character c : ow) 
        //         sc.add(c);
        //     int i = 0, j = n-1;
        //     while (i < j) {
        //         while (i < j && !sc.contains(s[i])) i++;
        //         while (j > i && !sc.contains(s[j])) j--;
        //         char c = s[i];
        //         s[i] = s[j];
        //         s[j] = c;
        //         i++;
        //         j--;
        //     }
        //     return new String (s);
        // }

        // public int[] intersect(int[] a, int[] b) {
        //     int [] ca = new int [1001];
        //     int [] cb = new int [1001];
        //     for (int i = 0; i < a.length; i++) 
        //         ca[a[i]]++;
        //     for (int i = 0; i < b.length; i++) 
        //         cb[b[i]]++;
        //     for (int i = 0; i < 1001; i++) {
        //         if (ca[i] == 0 && cb[i] == 0) continue;
        //         if (ca[i] != cb[i]) ca[i] = Math.min(ca[i], cb[i]);
        //     }
        //     int sum = Arrays.stream(ca).sum();
        //     int [] ans = new int [sum];
        //     int idx = 0;
        //     for (int i = 0; i < 1001; i++) {
        //         if (ca[i] == 0) continue;
        //         while (ca[i]-- > 0) ans[idx++] = i;
        //     }
        //     return ans;
        // }

        // public boolean isPerfectSquare(int v) {
        //     if (v == 1) return true;
        //     int l = 2, r = v;
        //     while (l < r) {
        //         int m = l + (r - l) / 2;
        //         long tmp = m * m;
        //         if (m * m == (long)v) return true;
        //         if (m * m > (long)v) r = m-1;
        //         else l = m + 1;
        //     }
        //     return l * l == v ? true : false;
        // }

        // private void divideByTwo(int [] a) {
        //     int n = a.length, re = 0;
        //     for (int i = 0; i < n; i++) {
        //         int cur = a[i] + re;
        //         if (cur % 2 == 1) re = 1;
        //         else re = 0;
        //         a[i] = cur / 2;
        //     }
        //     int i = 0;
        //     while (i < n && a[i] == 0) i++;
        //     System.arraycopy(a, 0, a, i, n-i);
        // }
        // public int superPow(int a, int[] b) {
        //     int mod = 1337, n = b.length, idx = n-1;
        //     long ans = 1, base = a;
        //     while (idx >= 0 && b[idx] > 0) {
        //         if (b[idx] % 2 == 1) 
        //             ans = (ans * base) % mod;
        //         while (b[idx] % 2 == 0) {
        //             ans = (ans * base) % (long)mod;
        //             divideByTwo(b);
        //             base *= base;
        //             if (b[idx] == 0) idx -= 1;
        //         }
        //     }
        //     return (int)ans;
        // }


    // Map<Integer, Integer> m;
    // Map<Integer, Integer> n;
    // Set<Integer> s; 
    // Random rand;
    // int idx;
    // public RandomizedSet() {
    //     m = new HashMap<>();
    //     n = new HashMap<>();
    //     s = new HashSet<>();
    //     rand = new Random();
    //     idx = -1;
    // }
    // public boolean insert(int val) {
    //     if (s.add(val)) {
    //         m.put(++idx, val);
    //         n.put(val, idx);
    //         return true;
    //     }
    //     return false;
    // }
    // public boolean remove(int val) {
    //     if (!s.contains(val)) return false;
    //     m.put(n.get(val), m.get(idx));
    //     n.put(m.get(idx), n.get(val));
    //     m.remove(idx);
    //     n.remove(val);
    //     s.remove(val);
    //     --idx;
    //     return true;
    // }
    // public int getRandom() {
    //     if (m.size() == 1) return m.get(0);
    //     int v = rand.nextInt(idx+1);
    //     return m.get(v);
    // }


        // public boolean canConstruct(String ransomNote, String magazine) {
        //     int m = ransomNote.length(), n = magazine.length();
        //     char [] s = ransomNote.toCharArray();
        //     char [] t = magazine.toCharArray();
        //     int [] one = new int [26];
        //     int [] two = new int [26];
        //     for (int i = 0; i < m; i++) 
        //         one[s[i]-'a']++;
        //     for (int i = 0; i < n; i++) 
        //         two[t[i]-'a']++;
        //     for (int i = 0; i < 26; i++) 
        //         if (one[i] > two[i]) return false;
        //     return true;
        // }


        // public int firstUniqChar(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] cnt = new int [26];
        //     int [] idx = new int [26];
        //     Arrays.fill(idx, -1);
        //     for (int i = 0; i < n; i++) {
        //         if (idx[s[i]-'a'] == -1) idx[s[i]-'a'] = i;
        //         cnt[s[i]-'a']++;
        //     }
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < 26; i++) {
        //         if (cnt[i] == -1) continue;
        //         if (cnt[i] == 1 && idx[i] < min) min = idx[i];
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }

        // public char findTheDifference(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [] one = new int [26];
        //     int [] two = new int [26];
        //     for (int i = 0; i < m; i++) 
        //         one[s[i]-'a']++;
        //     for (int i = 0; i < n; i++) 
        //         two[t[i]-'a']++;
        //     for (int i = 0; i < 26; i++) 
        //         if (Math.abs(one[i] - two[i]) == 1)
        //             return (char)('a' + i);
        //     return ' ';
        // }


        // private String processInput(String t) {
        //     char [] s = t.toCharArray();
        //     // 由于第一个和最后一个字符都是#号，且也需要搜索回文，为了防止越界，我们还需要在首尾再加上非#号字符，实际操作时我们还需给开头加上个非#号字符'$'，结尾加一个'@'
        //     String ans = "$#"; // 不论原字符串是奇数还是偶数个，处理之后得到的字符串的个数都是奇数个，这样就不用分情况讨论了
        //     for (int i = 0; i < t.length(); i++) 
        //         ans += s[i] + "#";
        //     ans += "@";
        //     return ans;
        // }
        // private String processInput(String t) {
        //     char [] s = t.toCharArray();
        //     String ans = "$#";
        //     for (int i = 0; i < s.length; i++) 
        //         ans += s[i] + "#";
        //     ans += "@";
        //     return ans;
        // }
        // public int longestPalindrome(String t) { // 马拉车算法： 半生不熟
        //     int m = t.length();
        //     t = processInput(t);
        //     char [] s = t.toCharArray();
        //     int n = s.length;
        //     int r = 0, idx = 0, max = 0, maxIdx = 0;
        //     int [] len = new int [n];
        //     for (int i = 1; i < n-1; i++) {
        //         len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1; // 2*idx-i: j 是i关于idx的对称点坐标 idx-(i-idx)
        //         while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]]) // s[n-1] = '@'
        //             ++len[i];
        //         max = Math.max(max, len[i]);
        //         if (r < len[i] + i) {
        //             r = i + len[i];
        //             idx = i;
        //         }
        //         // System.out.println(Arrays.toString(len));
        //     }
        //     return (max-1) * 2 - 1;
        // }
        // public int longestPalindrome(String t) {
        //     int m = t.length();
        //     t = processInput(t);
        //     char [] s = t.toCharArray();
        //     int n = s.length;
        //     // 如何求 len 数组，需要新增两个辅助变量 r 和 idx，其中 idx 为最大回文子串中心的位置，r 是回文串能延伸到的最右端的位置
        //     int r = 0, idx = 0; // 最大右边界、最大回文串的中心位置
        //     int [] len = new int [n];
        //     for (int i = 1; i < n-1; i++) {
        //         len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1;
        //         while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]])
        //             ++len[i];
        //         if (r < len[i]+i) {
        //             r = len[i] + i;
        //             idx = i;
        //         }
        //     }
        // }
        // public int longestPalindrome(String t) {
        //     int n = t.length();
        //     if (n == 1) return 1;
        //     char [] s = t.toCharArray();
        //     int [] cnt = new int [n];
        //     Arrays.fill(cnt, 1);
        //     int j = 0, k = 0, l = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         System.out.println("s[i]: " + s[i]);
        //         j = i;
        //         k = i+1;
        //         l = 0;
        //         while (j >= 0 && k < n && s[j--] == s[k++]) l += 2;
        //         cnt[i] = Math.max(cnt[i], l);
        //         System.out.println("cnt[i]: " + cnt[i]);
        //         j = i-1;
        //         k = i+1;
        //         l = 1;
        //         while (j >= 0 && k < n && s[j--] == s[k++]) l += 2;
        //         cnt[i] = Math.max(cnt[i], l);
        //         max = Math.max(max, cnt[i]);
        //         System.out.println("cnt[i]: " + cnt[i]);
        //         System.out.println("max: " + max);
        //     }
        //     return max;
        // }
        // public int longestPalindrome(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [][] cnt = new int [2][26];
        //     for (int i = 0; i < n; i++)
        //         if (Character.isLowerCase(s[i]))
        //             cnt[0][s[i]-'a']++;
        //         else cnt[1][s[i]-'A']++;
        //     boolean hasOdd = false;
        //     int ans = 0;
        //     for (int i = 0; i < 2; i++) 
        //         for (int j = 0; j < 26; j++) 
        //             if (cnt[i][j] % 2 == 0) ans += cnt[i][j];
        //             else if (cnt[i][j] > 0 && cnt[i][j] % 2 == 1) {
        //                 hasOdd = true;
        //                 ans += cnt[i][j] - 1;
        //             }
        //     return ans + (hasOdd ? 1 : 0);
        // }

        // public List<String> fizzBuzz(int n) {
        //     List<String> ans = new ArrayList<>();
        //     for (int i = 1; i <= n; i++) {
        //         if (i % 3 == 0 &&  i % 5 == 0) ans.add("FizzBuzz");
        //         else if (i % 3 == 0) ans.add("Fizz");
        //         else if (i % 5 == 0) ans.add("Buzz");
        //         else ans.add(""+i);
        //     }
        //     return ans;
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "abccccdd";
        // String a = "bb";
        String a = "AAAAAA";

        System.out.println("a: " + a);
        
        int r = s.longestPalindrome(a); // getRandom() should return either 1 or 2 randomly.
        System.out.println("r: " + r);
    }
}