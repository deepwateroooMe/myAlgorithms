import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

import static java.util.stream.Collectors.toMap;

public class gretwoedy {
    public static class Solution {

        // public int leastInterval(char[] tasks, int n) {
        //     int m = tasks.length;
        //     if (n == 0) return m;
        //     Map<Character, Integer> mm = new HashMap<>();
        //     for (int i = 0; i < m; i++) 
        //         mm.put(tasks[i], mm.getOrDefault(tasks[i], 0) + 1);
        //     Map<Character, Integer> map = mm.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int mcnt = m, cnt = -1; // cnt: ncnt
        //     char k = ' ';
        //     int v = 0;
        //     int res = 0;
        //     Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        //     Map.Entry<Character, Integer> cur = null;
        //     while (map.size() > 0) {
        //         mm = new HashMap<Character, Integer>();
        //         it = map.entrySet().iterator();
        //         while (it.hasNext()) {
        //             cur = it.next();
        //             k = cur.getKey();
        //             v = cur.getValue();
        //             if (v == 0) continue;
        //             mcnt++;
        //             ++cnt;
        //             ++res;
        //             if (v - 1 > 0) mm.put(k, v-1);
        //             if (cnt == n) {
        //                 while (it.hasNext()) {
        //                     cur = it.next();
        //                     mm.put(cur.getKey(), cur.getValue());
        //                 }
        //                 break;
        //             }
        //         }
        //         if (cnt < n && mm.size() > 0) res += n - cnt;
        //         cnt = -1;
        //         map.clear();
        //         Map<Character, Integer> tmp = mm.entrySet().stream()
        //             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //             .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //         map.putAll(tmp);
        //     }
        //     return res;
        // }
        // 都分成了(mx - 1)块，再加上最后面的字母，其中mx为最大出现次数。
        // 模块的次数为任务最大次数减1，模块的长度为n+1，
        // 最后加上的字母个数为出现次数最多的任务，可能有多个并列。
        // public int leastInterval(char[] tasks, int n) {
        //     int n = tasks.length;
        //     int [] arr = new int [26];
        //     for (char v : tasks) 
        //         arr[v-'a']++;
        //     Arrays.sort(arr);
        //     int i = 25;
        //     while (i >= 0 && arr[i] == arr[25]) i--;
        //     return Math.max(n, (arr[25]-1)*(n+1)+25-i);
        // }

        
        // private boolean isValid(int [] a, int [] b, int v) {
        //     int n = a.length;
        //     for (int i = 0; i < n; i++) 
        //         if (a[i] != v && b[i] != v) return false;
        //     return true;
        // } 
        // public int minDominoRotations(int[] tops, int[] bottoms) {
        //     int n = tops.length;
        //     int [] top = new int [7];
        //     int [] bot = new int [7];
        //     for (int i = 0; i < n; i++) {
        //         top[tops[i]]++;
        //         bot[bottoms[i]]++;
        //     }
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < 7; i++) {
        //         if (top[i] + bot[i] >= n && isValid(tops, bottoms, i))
        //             min = Math.min(min, Math.min(n-top[i], n-bot[i]));
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }


        // public int minOperations(int[] nums1, int[] nums2) {
        //     int m = nums1.length;
        //     int n = nums2.length;
        //     int sone = 0, stwo = 0;
        //     for (int i = 0; i < m; i++) 
        //         sone += nums1[i];
        //     for (int i = 0; i < n; i++) 
        //         stwo += nums2[i];
        //     if (sone == stwo) return 0;
        //     if (m > 6*n || n > 6*m || 6*m < n || 6*n < m) return -1;
        //     if (sone > stwo) return minOperations(nums2, nums1); // sone < stwo
        //     int [] ins = new int[6];
        //     int [] des = new int[6];
        //     for (int i = 0; i < m; i++) 
        //         ins[6-nums1[i]]++;
        //     for (int i = 0; i < n; i++) 
        //         des[nums2[i]-1]++;
        //     int i = 5, j = 5, cnt = 0;
        //     while (sone < stwo) {
        //         if (i >= 0 && ins[i] > 0 && i > j) {
        //             sone += i;
        //             ++cnt;
        //             ins[i]--;
        //         } else if (j >= 0 && des[j] > 0 && j >= i) {
        //             stwo -= j;
        //             ++cnt;
        //             des[j]--;
        //         }
        //         if (i >= 0 && ins[i] == 0) --i;
        //         if (j >= 0 && des[j] == 0) --j;
        //     }
        //     return cnt;
        // }


        // public int numRescueBoats(int[] people, int limit) {
        //     int n = people.length;
        //     Arrays.sort(people);
        //     if (n == 1) return 1;
        //     if (n == 2) return people[0]+people[1] > limit ? 2 : 1;
        //     int i = 0, j = n-1, cnt = 0;
        //     int k = 0, sum = 0;
        //     while (i <= j) {
        //         if (people[j] + people[i] > limit) {
        //             ++cnt;
        //             --j;
        //         } else if (people[i] + people[j] <= limit) {
        //             ++cnt;
        //             ++i;
        //             --j;
        //         }
        //     }
        //     return cnt;
        // }

        
        // public String breakPalindrome(String palindrome) {
        //     int n = palindrome.length();
        //     if (n == 1) return "";
        //     StringBuilder s = new StringBuilder(palindrome);
        //     int i = 0;
        //     while (i < n && palindrome.charAt(i) == 'a') ++i;
        //     if (i == n) {
        //         s.setCharAt(n-1, 'b');
        //         return s.toString();
        //     }
        //     int j = n-1;
        //     while (j >= 0 && palindrome.charAt(j) == 'a') --j;
        //     if (j > i)
        //         s.setCharAt(i, 'a');
        //     else 
        //         s.setCharAt(n-1, 'b');
        //     return s.toString();
        // }

        
        // public int findMinArrowShots(int[][] points) {
        //     int n = points.length;
        //     // 负数的时候排序排反了: 所以要特别注意负数符号处理
        //     Arrays.sort(points, (a, b)-> (a[0] != b[0] && (a[0] < 0 || b[0] < 0) ? Integer.signum(a[0]) - Integer.signum(b[0]) : (a[0] != b[0] ? a[0] - b[0] : a[1]- b[1])));
        //     TreeSet<int []> ts = new TreeSet<>((a, b)-> (a[0] != b[0] && (a[0] < 0 || b[0] < 0) ? Integer.signum(a[0]) - Integer.signum(b[0]) : (a[0] != b[0] ? a[0] - b[0] : a[1]- b[1])));
        //     ts.add(points[0]);
        //     System.out.println("ts.size(): " + ts.size());
        //     int [] cur = null, high = null;
        //     for (int i = 1; i < n; i++) {
        //         System.out.println("\ni: " + i);
        //         int nl = points[i][0], nr = points[i][1];
        //         high = new int [] {points[i][1], Integer.MAX_VALUE};
        //         while (true) {
        //             cur = ts.lower(high);
        //             if (cur == null || points[i][0] > cur[1]) break;
        //             if (points[i][0] <= cur[1]) {
        //                 nl = Math.max(points[i][0], cur[0]);
        //                 nr = Math.min(cur[1], points[i][1]);
        //             }
        //             ts.remove(cur);
        //         }
        //         ts.add(new int []{nl, nr}); // 我觉得我在压缩这个大小的时候可能会miss掉一部分，这里有bug
        //     }
        //     return ts.size();
        // }


        // public int minSwaps(String t) {
        //     int n = t.length();
        //     Stack<Character> st = new Stack<>();
        //     int i = 0, cnt = 0, j = n-1;
        //     StringBuilder s = new StringBuilder(t);
        //     while (i < n) {
        //         if (s.charAt(i) == '[') st.push('[');
        //         else if (s.charAt(i) == ']' && !st.isEmpty() && st.peek() == '[') st.pop();
        //         else {
        //             ++cnt;
        //             // while (j >= 0 && s.charAt(j) == ']') --j; // 可以不用换，直接数就可以了
        //             // s.setCharAt(i, '[');
        //             // s.setCharAt(j, ']');
        //             // --j;
        //             st.push('[');
        //         }
        //         ++i;
        //     }
        //     return cnt;
        // }
        // 首先我创建一个变量 size 记录需要swap的括号个数。
        // 我们还是照着配对的原则，
        // 如果当前我遇到一个左括号，我就 size++，意思是我需要找一个配对；
        // 如果我遇到一个右括号，同时当前 size 大于0的话（意思是前面有单独的左括号可供配对），我就 size--，这样就能配对了。
        // 最后返回的是需要配对的半括号 / 2。
        // public int minSwaps(String t) {
        //     int n = t.length();
        //     int i = 0, cnt = 0;
        //     for (char c : t.toCharArray()) {
        //         if (c == '[') ++cnt;
        //         else {
        //             if (cnt > 0) --cnt;
        //         }
        //     }
        //     return (cnt+1) / 2;
        // }


        // public int maximumSwap(int val) {
        //     if (val <= 10) return val;
        //     String s = String.valueOf(val);
        //     int n = s.length();
        //     int i = 1, j = 0;
        //     StringBuilder t = new StringBuilder(s);
        //     char tmp = ' ';
        //     int [] arr = new int[10];
        //     Arrays.fill(arr, -1);
        //     for ( i = 0; i < n; i++) 
        //         arr[s.charAt(i)-'0'] = i;
        //     i = 1;
        //     if (arr[s.charAt(0)-'0'] == 0) arr[s.charAt(0)-'0'] = -1;
        //     while (true) {
        //         while (i < n && s.charAt(i) <= s.charAt(i-1)) {
        //             if (arr[s.charAt(i)-'0'] == i) arr[s.charAt(i)-'0'] = -1;
        //             ++i;
        //             if (i == n) return val;
        //         }
        //         for ( j = 9; j >= 0; j--) {
        //             if (arr[j] != -1) { // 后续最大值 以及位置
        //                 if (j > s.charAt(0)-'0') {
        //                     tmp = s.charAt(0);
        //                     t.setCharAt(0, (char)(j+'0'));
        //                     t.setCharAt(arr[j], tmp);
        //                 } else {
        //                     int k = 1;
        //                     while (k < i && t.charAt(k)-'0' >= j) ++k;
        //                     tmp = s.charAt(k);
        //                     t.setCharAt(k, (char)(j+'0'));
        //                     t.setCharAt(arr[j], tmp);
        //                 }
        //                 return Integer.parseInt(t.toString());
        //             }
        //         }
        //         if (i < n && s.charAt(i) > s.charAt(i-1)) {
        //             for ( j = 9; j >= 0; j--) {
        //                 if (arr[j] != -1) {
        //                     tmp = s.charAt(i-1);
        //                     t.setCharAt(i-1, (char)(j+'0'));
        //                     t.setCharAt(arr[j], tmp);
        //                     return Integer.parseInt(t.toString());
        //                 }
        //             }
        //         }
        //     }
        // }


        // public int minInsertions(String s) {
        //     Stack<Character> st = new Stack<>();
        //     int cnt = 0;
        //     int n = s.length();
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) == '(') {
        //             st.push('(');
        //         } else { // ')'
        //             if (i == n-1 && !st.isEmpty() && st.peek() == '(') {
        //                 ++cnt;
        //                 st.pop();
        //             } else if (i == n-1 && st.isEmpty()) cnt += 2;
        //             else if (i+1 < n && s.charAt(i+1) == ')') { // two ))
        //                 if (!st.isEmpty()) {
        //                     st.pop();
        //                 } else cnt ++;
        //                 i += 1;
        //             } else if (i+1 < n && s.charAt(i+1) == '(') {
        //                 if (!st.isEmpty()) {
        //                     st.pop();
        //                     cnt += 1;
        //                 } else {
        //                     cnt += 2;
        //                 }
        //             }
        //         }
        //     }
        //     if (!st.isEmpty()) {
        //         while (!st.isEmpty()) {
        //             st.pop();
        //             cnt += 2;
        //         }
        //     }
        //     return cnt;
        // }


        // public String maximumBinaryString(String binary) {
        //     int n = binary.length();
        //     StringBuilder s = new StringBuilder(binary);
        //     if (n == 1) return binary;
        //     if (n == 2) return binary.equals("00")  ? "10" : binary;
        //     int i = 1, cnt = 2; // cnt 0s
        //     while (cnt > 1) {
        //         cnt = 0;
        //         for (int j = n-1; j-1 > 0; j--) { // 从右往左
        //             if (s.charAt(j-1) == '1' && s.charAt(j) == '0') {
        //                 s.setCharAt(j-1, '0');
        //                 s.setCharAt(j, '1');
        //                 ++cnt;
        //                 j -= 1;
        //             }
        //         }
        //         for ( i = 0; i < n-1; i++) { // 从左往右数,找个中间的停止条件
        //             if (s.charAt(i) == '0' && s.charAt(i+1) == '0') {
        //                 s.setCharAt(i, '1');
        //                 cnt += 1; // 这个值数得不太对
        //                 i += 1;
        //             }
        //         }
        //         // System.out.println("s.toString(): " + s.toString());
        //         // System.out.println("cnt: " + cnt);
        //     }
        //     return s.toString();
        // }


        // public int maxNonOverlapping(int[] nums, int target) {
        //     int n = nums.length;
        //     int [] pre = new int [n+1];
        //     for (int i = 0; i < n; i++) 
        //         pre[i+1] = pre[i]+nums[i];
        //     System.out.println("pre.length: " + pre.length);
        //     for (int z = 0; z < pre.length; ++z) 
        //         System.out.print(pre[z] + ", ");
        //     System.out.println("");
        //     int cnt = 0, i = 1, j = 0;
        //     while (i <= n) { // 从左往右扫一遍，这个扫的过程是如何比较的
        //         while (pre[i]-pre[j] < target) ++i;
        //         if (pre[i] == target) {
        //             ++cnt;
        //             j = i;
        //             ++i;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) {
        //         // System.out.println("i: " + i);
        //         // System.out.println("nums[i]: " + nums[i]);
        //         // System.out.println("pre[i+1]: " + pre[i+1]);
        //         // System.out.println("j: " + j);
        //         if (pre[i+1] == target || i > 0 && pre[i+1]-pre[j] == target) {
        //             ++cnt;
        //             j = i;
        //         } else {
        //             for (int k = j+1; k < i; k++) {
        //                 if (pre[i+1] - pre[k] == target) {
        //                     ++cnt;
        //                     j = k;
        //                 }
        //             }
        //         }
        //         // System.out.println("cnt: " + cnt);
        //     }
        //     return cnt;
        // }

        
        // public int minFlips(String s) {
        //     int n = s.length();
        //     int i = 0, cnt = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) == '0') ++i;
        //         if (i == n) return cnt;
        //         ++cnt; // i: 1
        //         while (i < n && s.charAt(i) == '1') ++i;
        //         if (i == n) return cnt;
        //         ++cnt; // i : 0
        //     }
        //     return cnt;
        // }


    //     int res = 0;
    //     private boolean isSame(Map<Integer, Integer> m, Map<Integer, Integer> n) {
    //         if (m.size() != n.size()) return false;
    //         for (Integer key : m.keySet()) 
    //             if (!n.containsKey(key) || n.containsKey(key) && (int)m.get(key) != (int)n.get(key)) return false;
    //         return true;
    //     }
    //     private int getSmallestK(int [] arr, int idx) {
    //         Map<Integer, Integer> m = new HashMap<>();
    //         Map<Integer, Integer> n = new HashMap<>();
    //         int i = 0;
    //         for (i = idx; i < arr.length; i++) {
    //             m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
    //             n.put(sorted[i], n.getOrDefault(sorted[i], 0) + 1);
    //             if (isSame(m, n)) return i;
    //         }
    //         return i;
    //     }
    //     private void maxChunksToSortedRecursive(int [] arr, int idx) {
    //         int k = getSmallestK(arr, idx);
    //         res += 1;
    //         if (k >= arr.length-1) return;
    //         maxChunksToSortedRecursive(arr, k+1);
    //     }
    //     int [] sorted;
    //     public int maxChunksToSorted(int[] arr) {
    //         int n = arr.length;
    //         System.out.println("n: " + n);
    //         sorted = Arrays.copyOf(arr, n);
    //         Arrays.sort(sorted);
    //         res = 0;
    //         maxChunksToSortedRecursive(arr, 0);
    //         return res;
    //     }


        // private String sort(String s) {
        //     char [] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     return new String(arr);
        // }
        // private int getNextIdx(String s, char v, int idx) {
        //     for (int i = idx+1; i < s.length(); i++) 
        //         if (s.charAt(i) == v) return i;
        //     return -1;
        // }
        // private int getPreIdx(String s, char v, int idx) {
        //     for (int i = idx-1; i >= 0; i--) 
        //         if (s.charAt(i) == v) return i;
        //     return -1;
        // }
        // public boolean isTransformable(String s, String t) { // tle tle tle
        //     int n = t.length();
        //     int i = 0, j = 0;
        //     String ori = new String(s);
        //     while (i < n) {
        //         while (i < n && j < n && t.charAt(i) == s.charAt(j)) {
        //             i++;
        //             j++;
        //         }
        //         if (i == n) return true;
        //         int k = getNextIdx(s, t.charAt(i), j);
        //         if (k == -1) return false;
        //          s = s.substring(0, j) + sort(s.substring(j, k+1)) + s.substring(k+1);
        //          if (t.charAt(i) != s.charAt(j)) break;
        //         i++;
        //         j++;
        //     }
        //     i = n-1;
        //     j = n-1;
        //     s = ori;
        //     while (i >= 0) {
        //         while (i >= 0 && j >= 0 && t.charAt(i) == s.charAt(j)) {
        //             i--;
        //             j--;
        //         }
        //         if (i == -1) return true;
        //         int k = getPreIdx(s, t.charAt(i), j);
        //         s = s.substring(0, k) + sort(s.substring(k, j+1)) + s.substring(j+1);
        //         if (t.charAt(i) != s.charAt(j)) return false;
        //         i--;
        //         j--;
        //     }
        //     return true;
        // }        
        // public boolean isTransformable(String s, String t) { 
        //     ArrayDeque<Integer> [] q = new ArrayDeque[10];
        //     for (int i = 0; i < 10; i++) 
        //         q[i] = new ArrayDeque<Integer>();
        //     for (int i = 0; i < s.length(); i++) 
        //         q[s.charAt(i)-'0'].offerLast(i);
        //     for (char c : t.toCharArray()) {
        //         int d = c - '0';
        //         if (q[d].isEmpty()) return false;
        //         for (int i = 0; i < d; i++) 
        //             if (!q[i].isEmpty() && q[i].peekFirst() < q[d].peekFirst())
        //                 return false;
        //         q[d].pollFirst();
        //     }
        //     return true;
        // }


        // public int findMinMoves(int[] machines) {
        //     int n = machines.length, sum = Arrays.stream(machines).sum(), avg = sum / n;
        //     if (sum % n != 0) return -1;
        //     return Arrays.stream(machines).max().getAsInt() - avg;
        // }

    // // https://leetcode.com/problems/reverse-subarray-to-maximize-array-value/discuss/489968/O(n)-Java-with-Mathematical-Proof
    //     int Min = -1000000000;
    //     public int maxValueAfterReverse(int[] a) { // 讨厌这个题
    //         int n = a.length, base = 0;
    //         for (int i = 0; i < n-1; i++) 
    //             base += abs(a[i] - a[i+1]);
    //         int best = 0;
    //         int [][] dp = new int [n][4];
    //         for (int i = 0; i < n; i++) 
    //             Arrays.fill(dp[i], Min);
    //         for (int i = 0; i < n-1; i++) {
    //             int aad = abs(a[i] - a[i+1]); // |b-c|
    //             if (i - 2 >= 0) { // |a-d |
    //                 int v1 = a[i] - a[i + 1] - aad; // c<a, b<=a-2
    //                 int c1 = dp[i - 2][0];  // (a-d)- |a-d|
    //                 int v2 = -(a[i] + a[i + 1]) - aad;
    //                 int c2 = dp[i - 2][1]; // -(a+d)-|a-d|
    //                 int v3 = a[i] + a[i + 1] - aad;
    //                 int c3 = dp[i - 2][2]; // (a+d)- |a-d |
    //                 int v4 = -(a[i] - a[i + 1]) - aad;
    //                 int c4 = dp[i - 2][3]; // -(a-d) - |a-d
    //                 int m1 = v1 + c1;
    //                 int m2 = v2 + c2;
    //                 int m3 = v3 + c3;
    //                 int m4 = v4 + c4;
    //                 int cmax = max(m1, max(m2, max(m3, m4)));
    //                 best = max(best, cmax);
    //             }
    //             dp[i][0] = max((i == 0 ? Min : dp[i - 1][0]), -(a[i] - a[i + 1]) - aad); // -(b-c)- |b-c|
    //             dp[i][1] = max((i == 0 ? Min : dp[i - 1][1]), (a[i] + a[i + 1]) - aad);  // (b+c)- |b-c|
    //             dp[i][2] = max((i == 0 ? Min : dp[i - 1][2]), -(a[i] + a[i + 1]) - aad); // (-(b+c) - |b-c|
    //             dp[i][3] = max((i == 0 ? Min : dp[i - 1][3]), (a[i] - a[i + 1] - aad));  // (b-c)- |b-c|
    //         }
    //         // to cover reversing on the two ends
    //         for (int i = 1; i + 1 < n; i++) {
    //             int m1 = abs(a[0] - a[i + 1]) - abs(a[i] - a[i + 1]);
    //             int m2 = abs(a[n - 1] - a[i - 1]) - abs(a[i] - a[i - 1]);
    //             int cmax = max(m1, m2);
    //             best = max(best, cmax);
    //         }
    //         return base + best;
    //     }
        // public int maxValueAfterReverse(int[] a) { 
        //     int n = a.length, base = 0, ans = 0, sum = 0;
        //     if (n == 1) return 0;
        //     for (int i = 0; i < n-1; i++)
        //         sum += abs(a[i] - a[i+1]);
        //     // 交换的区间左端点是数组的左边界
        //     for (int i = 0; i < n-1; i++) 
        //         ans = max(ans, sum + abs(a[i+1]-a[0]) - abs(a[i+1] - a[i]));
        //     // 交换的区间右端点是数组的右边界
        //     for (int i = n-1; i > 0; i--)
        //         ans = max(ans, sum + abs(a[n-1] - a[i-1]) - abs(a[i] - a[i-1]));
        //     // 交换区间左右端点在数组内部
        //     int l = 1; // 1. 找出左端点
        //     for (int i = 2; i < n; i++) {
        //         int ia = min(a[i], a[i-1]), ib = max(a[i], a[i-1]);
        //         if (max(a[i], a[i-1]) < max(a[l], a[l-1])) l = i;
        //     }
        //     int r = 0; // 2. 找出右端点
        //     for (int i = 1; i < n-1; i++) 
        //         if (min(a[i], a[i+1]) > min(a[r], a[r+1])) r = i;
        //     ans = max(ans, sum + 2 * (min(a[r], a[r+1]) - max(a[l], a[l-1])));
        //     return ans;
        // }

        
        // public int brokenCalc(int startValue, int target) { // 思路基本到位了，bug还要慢慢修改
        //     if (target < startValue) return startValue - target;
        //     if (target == startValue) return 0;
        //     int cnt = 0, cntb = 0, va = startValue, vb = target;
        //     while (va < target) {
        //         va *= 2;
        //         ++cnt;
        //     }
        //     if (va == target) return cnt;
        //     if (vb % 2 == 0 && vb > startValue) {
        //         vb /= 2;
        //         return brokenCalc(vb, target) + 1;
        //         // ++cntb;
        //     }
        //     // System.out.println("cnt + va - target: " + (cnt + va - target));
        //     if (vb < startValue)
        //         return Math.min(cnt + va - target, startValue - vb + cntb);
        //     return cnt + va - target;
        // }


        // public int[] rearrangeArray(int[] arr) {
        //     int n = arr.length;
        //     int [] res = new int [n];
        //     Arrays.sort(arr);
        //     int ei = 0, oi = 1; // even idx odd idx
        //     double mid = (n % 2 == 0 ? (arr[n/2] + arr[n/2-1])/2.0 : arr[n/2]);
        //     for (Integer v : arr) {
        //         if ((double)v < mid) {
        //             res[oi] = v;
        //             oi += 2;
        //         } else {
        //             res[ei] = v;
        //             ei += 2 ;
        //         }
        //     }
        //     return res;
        // }


        // public int[] mostCompetitive(int[] arr,  int k) {
        //     int n = arr.length;
        //     int [] ans = new int [k];
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             l.add(arr[i]);
        //             continue;
        //         }
        //         if (arr[i] > l.get(l.size()-1) && l.size() < k) l.add(arr[i]);
        //         else if (arr[i] < l.get(l.size()-1)) {
        //             if (l.size() < k && l.size() + n-i == k) {
        //                 int idx = 0;
        //                 for (Integer v : l) 
        //                     ans[idx++] = v;
        //                 System.arraycopy(arr, i, ans, idx, n-i);
        //                 return ans;
        //             } else {
        //                 l.remove(l.size()-1);
        //                 while (l.size() > 0 &&  l.size() + n-i > k && l.get(l.size()-1) > arr[i]) l.remove(l.size()-1);
        //                 l.add(arr[i]);
        //             }
        //         } else if (l.get(l.size()-1) == arr[i] && l.size() < k) l.add(arr[i]);
        //     }
        //     int idx = 0;
        //     for (Integer v : l) 
        //         ans[idx++] = v;
        //     return ans;
        // }


        // public int monotoneIncreasingDigits(int n) {
        //     String t = "" + n;
        //     char [] s = t.toCharArray();
        //     int m = t.length();
        //     String tmp = (s[0] == '1' ? "" : ""+(s[0]-'0'-1)) + "9".repeat(m-1);
        //     if (t.equals(""+s[0]+"0".repeat(m-1))) return Integer.parseInt(tmp); // [1-9]000000
        //     int i = 0;
        //     while (i < m-1 && s[i] <= s[i+1]) ++i;
        //     if (i == m-1) return n;
        //     i = 0;
        //     while (i < m-1 && s[i] >= s[i+1]) ++i;
        //     if (i == m-1) return Integer.parseInt(tmp);
        //     return 0; // 其它的情况再遍历改写
        // }


 
        
        // private int makeZigZag(int [] arr, int idx) { // 0, 1
        //     int cnt = 0, min = Integer.MAX_VALUE;
        //     for (int i = idx; i < n; i += 2) {
        //         if (i == 0 || i == n-1) {
        //             min = (i == 0 ? arr[1] : arr[i-1]) - 1;
        //             if (arr[i] > min)
        //                 cnt += arr[i] - min;
        //             continue;
        //         }
        //         min = Math.min(arr[i-1], arr[i+1]) -1;
        //         if (arr[i] > min)
        //             cnt += arr[i] - min;
        //     }
        //     return cnt;
        // }
        // int n;
        // public int movesToMakeZigzag(int[] arr) {
        //     n = arr.length;
        //     if (n == 1) return 0;
        //     return Math.min(makeZigZag(arr, 0), makeZigZag(arr, 1));
        // }


        // public int maxDiff(int num) {
        //     String t = "" + num;
        //     char [] s = t.toCharArray();
        //     int n = t.length(), min = Integer.MAX_VALUE, max = 0;
        //     for (char c = '0'; c <= '9'; c++) {
        //         if (t.indexOf(c) == -1) continue;
        //         for (int i = 0; i <= 9; i++) {
        //             char [] tmp = Arrays.copyOf(s, n);
        //             System.out.println("i: " + i);
        //             for (int j = 0; j < n; j++) 
        //                 if (tmp[j] == c) tmp[j] = (char)('0' + i);
        //             if (tmp[0] == '0' || new String(tmp).equals("0".repeat(n))) continue;
        //             int v = Integer.parseInt(new String(tmp));
        //             max = Math.max(v, max);
        //             min = Math.min(v, min);
        //         }            
        //     }
        //     return max - min;
        // }


        // public long maxMatrixSum(int[][] mat) { // 如果是同一行里面，找最大的两个乘积
        //     int n = mat.length;
        // }

        
        // public int addRungs(int[] rungs, int dist) {
        //     int n = rungs.length, cur = 0, cnt = 0, i = 0;
        //     while (i < n) {
        //         while (cur + dist < rungs[i]) {
        //             int v = (rungs[i] - cur) / dist - ((rungs[i] - cur) % dist == 0 ? 1 : 0); 
        //             cnt += v;
        //             cur = cur + v * dist;
        //         }
        //         if (cur + dist >= rungs[i]) {
        //             cur = rungs[i];
        //             i++;
        //         }
        //     }
        //     return cnt;
        // }


        // public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        //     int n = colsum.length, cnt = 0;
        //     int [][] arr = new int [2][n];
        //     for (int i = 0; i < n; i++) 
        //         if (colsum[i] == 0) {
        //             continue;
        //         } else if (colsum[i] == 2) {
        //             arr[0][i] = 1;
        //             arr[1][i] = 1;
        //             ++cnt;
        //         }
        //     if (cnt > upper) return new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         if (colsum[i] == 1)
        //             if (cnt < upper) {
        //                 arr[0][i] = 1;
        //                 ++cnt;
        //             } else 
        //                 arr[1][i] = 1;
        //     int sum = Arrays.stream(arr[1]).sum();
        //     if (sum != lower) return new ArrayList<>();
        //     List<List<Integer>> res = new ArrayList<>();
        //     for (int i = 0; i < 2; i++) 
        //         res.add(Arrays.stream(arr[i]).boxed().collect(Collectors.toList()));
        //     return res;
        // }


        // public boolean increasingTriplet(int[] arr) {
        //     int n = arr.length;
        //     TreeSet<Integer> l = new TreeSet<>();
        //     TreeMap<Integer, Integer> r = new TreeMap<>();
        //     for (int i = n-1; i >= 2; i--) 
        //         r.put(arr[i], r.getOrDefault(arr[i], 0) + 1);
        //     l.add(arr[0]);
        //     for (int i = 1; i < n-1; i++) {
        //         l.add(arr[i]);
        //         Integer lower = l.lower(arr[i]);
        //         if (lower == null) continue;
        //         Integer higher = r.higherKey(arr[i]);
        //         if (higher != null) return true;
        //         if (i < n-2) {
        //             r.put(arr[i+1], r.get(arr[i+1])-1);
        //             if (r.get(arr[i+1]) == 0) r.remove(arr[i+1]);
        //         }
        //     }
        //     return false;
        // }


        //   public int minElements(int [] arr, int limit, int goal) { // bug: overflow, 负数取模的问题
        //      int n = arr.length;
        //      // System.out.println("n: " + n);
        //      long sum = 0;
        //      for (Integer v : arr) sum += v;
        //      System.out.println("sum: " + sum);
        //      if (sum == (long)goal) return 0;
        //      if ((long)goal > sum) return (int)((long)goal - sum) / limit + (int)(((long)goal - sum) % limit == 0 ? 0 : 1);
        //      else if (goal < sum && goal > 0) return (int)((sum - (long)goal) / limit) + (int)((sum - goal) % limit == 0 ? 0 : 1);
        //      else 
        //          return -1*(int)((long)goal - sum) / limit + (int)((long)(sum - goal) % limit == 0 ? 0 : 1);
        // }


        // public String strWithout3a3b(int a, int b) {
        //     int x = Math.min(a, b), y = Math.max(a, b);
        //     String max = x == a ? "b" : "a", min = x == a ? "a" : "b";
        //     String ans = "";
        //     while (y > 0 && x > 0) {
        //         while (y > x) {
        //             ans += max.repeat(2);
        //             y -= 2;
        //             ans += min;
        //             x --;
        //         }
        //         ans += max; // 昨晚邻居老黑半夜还在大声放音乐，晚上休息不好，现在的脑袋不是很好转，改天再接着写这个
        //         y--;
        //     }
        //     return ans;
        // }


        // public int eliminateMaximum(int[] dist, int[] speed) {
        //     int n = dist.length;
        //     double [] time = new double[n];
        //     for (int i = 0; i < n; i++) 
        //         time[i] = (double)dist[i] / speed[i];
        //     System.out.println(Arrays.toString(time));
        //     List<Double> ins = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ins.add(time[i]);
        //     Collections.sort(ins, (a, b)->Double.compare(a, b));
        //     int cnt = 0, cur = 0;
        //     for (int i = 0; i < ins.size(); i++) {
        //         double v = ins.get(i);
        //         if (Double.compare(cur, v) < 0) {
        //             cnt++;
        //             cur += 1; 
        //         } else return cnt;
        //     }
        //     return cnt;
        // }


        // public int maxSumRangeQuery(int[] nums, int[][] requests) {
        //     int mod = (int)1e9 + 7;
        //     int [] cnt = new int [100001];
        //     for (int [] v : requests) 
        //         for (int i = v[0]; i <= v[1]; i++)
        //             cnt[i]++;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < 100001; i++)
        //         if (cnt[i] > 0)
        //             l.add(cnt[i]);
        //     Collections.sort(l, (a, b)->b-a);
        //     Arrays.sort(nums);
        //     int idx = nums.length - 1;
        //     long ans = 0;
        //     for (int i = 0; i < l.size(); i++) 
        //         ans = (ans + l.get(i) * nums[idx--]) % mod;
        //     return (int)ans;
        // }
        // public int maxSumRangeQuery(int[] nums, int[][] requests) { // 差分数组 + 前缀和
        //     int mod = (int)1e9 + 7, n = nums.length;
        //     int [] cnt = new int [n];
        //     for (int [] v : requests) {
        //         cnt[v[0]]++;
        //         if (v[1] + 1 < n) cnt[v[1]+1]--;
        //     }
        //     for (int i = 1; i < n; i++) 
        //         cnt[i] += cnt[i-1];
        //     Arrays.sort(cnt);
        //     Arrays.sort(nums);
        //     long ans = 0;
        //     for (int i = n-1, j = n-1; i >= 0 && j >= 0; i--) 
        //         ans = (ans + (long)nums[j--] * cnt[i]) % mod;
        //     return (int)ans;
        // }


        // public long numberOfWeeks(int[] milestones) { // 差分数组 + 前缀和,可能还是跟前一题有些类似的地方，怎么把那些东西都减掉  
        //     int n = milestones.length, ans = 0;
        //     Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a); // tle tle tle 
        //     for (Integer v : milestones) q.offer(v);
        //     int cur = 0, top = 0, pre = 0;
        //     while (q.size() > 1) {
        //         cur = q.poll();
        //         if (cur == pre) {
        //             top = q.poll();
        //             ans++;
        //             if (top > 1) q.offer(top-1)
        //         }
        //     }
        // }

        // private void getSums(int [] arr, int idx, int sum, Set<Integer> s) {
        //     if (idx == arr.length) {
        //         s.add(sum);
        //         return ;
        //     }
        //     getSums(arr, idx+1, sum + arr[idx], s);
        //     getSums(arr, idx+1, sum, s);
        // }
        // public int minPatches(int[] nums, int n) {  // tle tle tle tle
        //     Set<Integer> vis = new HashSet<>();
        //     getSums(nums, 0, 0, vis);
        //     vis.remove(0);
        //     int cnt = 0;
        //     Set<Integer> s = new HashSet<>(vis);
        //     for (int i = 1; i <= n; i++) {
        //         if (!vis.contains(i)) {
        //             vis.add(i);
        //             cnt++;
        //             for (Integer v : s)
        //                 vis.add(v + i);
        //         }
        //         s.addAll(vis);
        //     }
        //     return cnt;
        //  }
        // public int minPatches(int[] nums, int n) {
        //     long sum = 1;
        //     int cnt = 0, idx = 0;
        //     while (sum <= n) {
        //         if (idx >= nums.length || sum < nums[idx]) {
        //             sum *= 2;
        //             cnt++;
        //         } else sum += nums[idx++];
        //     }
        //     return cnt;
        // }


        
        // public List<String> maxNumOfSubstrings(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int [] bgn = new int [26], end = new int [26];
        //     Arrays.fill(bgn, -1);
        //     Arrays.fill(end, -1);
        //     for (int i = 0; i < n; i++) {
        //         int v = s[i] - 'a';
        //         if (bgn[v] == -1) {
        //             bgn[v] = i;
        //             end[v] = i;
        //         } else end[v] = i;
        //     }
        //     TreeSet<String> ts = new TreeSet<>((a, b)->(a.length() != b.length() ? a.length() - b.length() : a.compareTo(b)));
        //     for (int i = 0; i < 26; i++) {
        //         if (bgn[i] == -1) continue;
        //         String sub = t.substring(bgn[i], end[i]+1);
        //          int l = n, r = 0, pl = n, pr = 0;
        //         for (char c : sub.toCharArray()) {
        //             l = Math.min(l, bgn[c-'a']);
        //             r = Math.max(r, end[c-'a']);
        //         }
        //         if (l != r) 
        //             while (pl != l || pr != r) {
        //                 pl = l;
        //                 pr = r;
        //                 for (int j = l; j <= r; j++) 
        //                     if (bgn[s[j] -'a'] != -1) {
        //                         l = Math.min(l, bgn[s[j]-'a']);
        //                         r = Math.max(r, end[s[j]-'a']);
        //                     }
        //             }
        //         ts.add(t.substring(l, r+1));
        //     }
        //     List<String> ans = new ArrayList<>();
        //     Iterator it = ts.iterator();
        //     Set<Character> vis = new HashSet<>();
        //     boolean valid = true;
        //     while (it.hasNext()) {
        //         String cur = (String)it.next();
        //         Set<Character> chars = new HashSet<>();
        //         for (char c : cur.toCharArray()) chars.add(c);
        //         valid = true;
        //         for (char c : chars) 
        //             if (vis.contains(c)) {
        //                 valid = false;
        //                 break;
        //             }
        //         if (valid) {
        //             ans.add(cur);
        //             vis.addAll(chars);
        //         }
        //     }
        //     return ans;
        // }


            // public String smallestSubsequence(String t, int k, char letter, int repetition) { // bug bug bug
            //     int n = t.length(), cnt = 0; // 感觉思路是清楚的，可是细节实现是还是有很多bug
            //     char [] s = t.toCharArray(); 
            //     if (n == k) return t;
            //     if (k == repetition) return (""+letter).repeat(repetition);
            //     Stack<Character> st = new Stack<>();
            //     for (char c : s)
            //         if (c == letter) cnt++;
            //     st.push(s[0]);
            //     int ins = s[0] == letter ? 1 : 0;
            //     for (int i = 1; i < n; i++) {
            //         System.out.println("\n i: " + i);
            //         System.out.println("s[i]: " + s[i]);
            //         char c = s[i], top = st.peek();
            //         if (c < top) {
            //             int av = cnt - ins;
            //             while (!st.isEmpty() && st.size()-1 + n-i >= k && (top != letter || top == letter && av + ins -1 >= repetition)) {
            //                 st.pop();
            //                 if (top == letter)
            //                     ins -= 1;
            //                 if (!st.isEmpty())
            //                     top = st.peek();
            //             }
            //             if (top == letter && av + ins -1 < repetition) {
            //                 st.push(c);
            //                 if (c == letter) ins++;
            //                 continue;
            //             }
            //         }
            //         if (c == letter && ins < repetition) {
            //             while (st.size() > k - (repetition-ins) && st.peek() != letter)
            //                 st.pop();
            //         if (st.size() < k) {
            //             st.push(c);
            //             if (c == letter) ins++;
            //         }
            //     }
            //     StringBuilder ans = new StringBuilder();
            //     while (!st.isEmpty()) ans.append(st.pop());
            //     return ans.reverse().toString();
            // }
        // public String smallestSubsequence(String t, int k, char letter, int repetition) {
        //     int n = t.length(), cnt = 0; 
        //     char [] s = t.toCharArray();
        //     for (char c : s)  cnt += c == letter ? 1 : 0;
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < n; cnt -= s[i++] == letter ? 1 : 0) { // 当前字符是更优选择，所以删除次优字符
        //         while (sb.length() + n-i > k && sb.length() > 0 && s[i] < sb.charAt(sb.length()-1) // 后面的长度足以构成k长的序列
        //                && (sb.charAt(sb.length()-1) != letter || cnt != repetition)) {
        //             repetition += sb.charAt(sb.length()-1) == letter ? 1 : 0;
        //             sb.deleteCharAt(sb.length()-1);
        //         } // s[i] >= sb最后一个字符
        //         if (k - sb.length() > Math.max(0, s[i] == letter ? 0 : repetition)) { // s[i] == letter,t只要有位置就放；其它字符，只有满足前提条件有空位才可
        //             sb.append(s[i]);
        //             repetition -= s[i] == letter ? 1 : 0;
        //         }
        //     }
        //     return "" + sb;
        // }
//         public String smallestSubsequence(String s, int k, char letter, int repetition) {
//             int n = s.length(), cnt = 0, dcnt = 0; // cnt: totalLetterNum, dcnt: deleted all letters cnt
//             ArrayDeque<Character> q = new ArrayDeque<>();
//             for (int i = 0; i < n; i++) cnt += s.charAt(i) == letter ? 1 : 0;
//             for (int i = 0; i < n; i++) {
//                 char c = s.charAt(i); // len-k>del 表示能否继续删除元素 如果len-k==del , 则剩余的元素都该入队列 否则最终队列元素的个数会小于k个
//                 while (!q.isEmpty() && n-dcnt > k && q.size()+n-i > k && c < q.getLast()) { // 当前字符比栈顶元素小，更优解
//                     if (q.getLast() == letter) {
//                         if (cnt > repetition) {
//                             q.removeLast();
//                             cnt--;
//                             dcnt++; // 如果剩余的letter的个数>repetition 则表明可以删除队列尾元素letter ，否则跳出循环
//                         } else if (cnt == repetition) break;
//                     } else if (q.getLast() != letter) {
//                         q.removeLast();
//                         dcnt++;
//                     }
//                 }
// // 之前想到用各种条件来限制元素是否该入队列
// // 但是后来转念一想 不管什么情况都可以先入队列  在最后的for循环中判断 该不该计入返回的字符串中即可
// // 比如用例  "eabe" k=3 letter="e" repetition=2
// // 按照常理来说，如果没有题干限制 队列中的元素应该是 "abe", 但是因为有题干限制e的个数至少为2。
// // 所以第一个e应当保留，同时，a也应当入队列，在最后的for循环中再来决定是否保留
// //            if(deque.isEmpty()) deque.add(c);
// //            else if(c==letter) deque.add(c);
// //            else if(deque.getLast()!=letter) deque.add(c);
// //            else if(len-k==dcnt) deque.add(c);
// //            else if(totalLetterNum>=repetition && deque.getLast()==letter && c>deque.getLast()) deque.add(c);
//                 q.offer(c);
//             }
//             StringBuilder sb = new StringBuilder();
//             while (!q.isEmpty() && sb.length() < k) {
//                 Character c = q.poll();
//                 //队头元素如果是letter 直接append, 因为此处有两种可能性
//                 // 1. 最终队列中 letter的个数刚好等于repetition ，那么此时只要碰到letter就append
//                 // 2. 最终队列中letter的个数大于repetition， 因为此时队列根据题干条件保持了单调性 此时letter也应该append
//                 if (c == letter) {
//                     sb.append(c);
//                     repetition--;
//                 } else if (k - sb.length() > repetition) // 如果队头元素不是letter，而且此时还有剩余位置给除了letter之外的其他元素
//                     sb.append(c);
//             }
//             return sb.toString();
//         }


        private Map<Integer, List<Integer>> getMap(int [] arr, int k) {
            int n = arr.length;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) 
                m.put(arr[i], i);
            Map<Integer, List<Integer>> ma = new HashMap<>(); // key: 1, 2, 3, 4, ... k
            TreeSet<Integer> one = new TreeSet<>((x, y)->arr[x] != arr[y] ? arr[x] - arr[y] : x - y); // 不写好会漏掉元素
            for (int i = 0; i < n; i++) one.add(i);
            if (n > k) {
                Set<Integer> idx = new HashSet<>();
                while (one.size() > k) idx.add(one.pollFirst());
                List<Integer> l = new ArrayList<>();
                for (int i = 0; i < n; i++) 
                    if (!idx.contains(i)) l.add(arr[i]);
                ma.put(k, l);
            } else ma.put(n, Arrays.stream(arr).boxed().collect(Collectors.toList()));
            int key = ma.entrySet().iterator().next().getKey()-1;
            boolean removed = false;
            while (key >= 0) {
                List<Integer> l = new ArrayList<>(ma.get(key+1));
                removed = false;
                for (int i = 0; i < l.size(); i++) 
                    if ((i == 0 || i > 0 && l.get(i) < l.get(i-1)) && (i == l.size()-1 || i < l.size()-1 && l.get(i) < l.get(i+1))) {
                        one.remove(m.get(l.get(i)));
                        l.remove(i);
                        removed = true;
                        break;
                    }
                if (!removed)
                    for (int i = l.size()-1; i >= 0; i--)
                        if ((i == l.size()-1 || i < l.size()-1 && l.get(i) < l.get(i+1)) && (i == 0 || i > 0 && l.get(i) <= l.get(i-1))) {
                            one.remove(m.get(l.get(i)));
                            l.remove(i);
                            removed = true;
                            break;
                        }
                if (!removed) {
                    int min = arr[one.pollFirst()];
                    for (int i = 0; i < l.size(); i++) { // 这一步的贪心好像不对？！！！
                        System.out.println("(l.get(i) == min) : " + (l.get(i) == min) );
                        if  (l.get(i) == min) {
                            l.remove(i);
                            break;
                        }
                    }
                }
                ma.put(key, l);
                key --;
            }
            return ma;
        }
        private String getString(List<Integer> l, int k)  {
            String ans = "";
            for (int i = 0; i < Math.min(l.size(), k); i++) 
                ans += "" + l.get(i);
            return ans;
        }
        private String getString(List<Integer> l, List<Integer> r, int k)  {
            if (l.size() == 0 || r.size() == 0) return getString(l.size() == 0 ? r : l, k);
            String ans = "";
            int i = 0, j = 0, cnt = 0;
            while (i < l.size() && j < r.size() && cnt < k) {
                if (l.get(i) > r.get(j)) {
                    ans += "" + l.get(i++);
                    cnt++;
                } else if (l.get(i) < r.get(j)) {
                    ans += "" + r.get(j++);
                    cnt++;
                } else {
                    if (i < l.size()-1 && l.get(i+1) > l.get(i) && (j == r.size()-1 || r.get(j+1) < l.get(i+1))) {
                        ans += "" + l.get(i++);
                        cnt++;
                    } else if ((j < r.size()-1) && r.get(j+1) > r.get(j)) {
                        ans += "" + r.get(j++);
                        cnt++;
                    } else {
                        ans += ("" + l.get(i++)).repeat(2);
                        cnt += 2;
                        j++;
                    }
                }
            }
            if (i < l.size() && cnt < k) 
                while (i < l.size() && cnt < k) {
                    ans += "" + l.get(i++);
                    cnt++;
                }
            if (j < r.size() && cnt < k) 
                while (j < r.size() && cnt < k) {
                    ans += "" + r.get(j++);
                    cnt++;
                }
            return ans;
        }
        public int[] maxNumber(int[] a, int[] b, int k) { 
            int m = a.length, n = b.length;
            Map<Integer, List<Integer>> ma = getMap(a, k);
            Map<Integer, List<Integer>> mb = getMap(b, k);
            int [] ans = new int [k];
            String res = "", cur = "";
            for (int i = 0; i <= k; i++) {
                System.out.println("\n i: " + i);
                if (i == 0 && mb.get(k) != null)
                    cur = getString(mb.get(k), k);
                else if (i == k && ma.get(k) != null)
                    cur = getString(ma.get(k), k);
                else if ((i == 0 || i == k) && (ma.get(k) == null || mb.get(k) == null)
                         || (ma.get(i) == null || mb.get(k-i) == null)) continue;
                cur = getString(ma.get(i), mb.get(k-i), k);
                if (cur.compareTo(res) > 0) res = cur;
            }
            for (int i = 0; i < res.length(); i++) 
                ans[i] = res.charAt(i) - '0';
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "leetcode";

        String r = s.smallestSubsequence(a, 4, 'e', 2);
        System.out.println("r: " + r);
    }
}