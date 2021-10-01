import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

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

        
        //  private void helper(int t, long v, int cnt) {
        //     if (v == t) {
        //         if (cnt < min) min = cnt;
        //         return;
        //     }
        //     if (cnt >= min || v == Integer.MAX_VALUE || v <= 0) return;
        //     if (v > t)
        //         helper(t, v-1, cnt+1);
        //     else {
        //         long tmp = 2 * v;
        //         helper(t, tmp, cnt+1);
        //         if (v > t)
        //             helper(t, v-1, cnt+1);
        //     }
        // } 
        // int min;
        // public int brokenCalc(int startValue, int target) {
        //     min = Integer.MAX_VALUE;
        //     if (target < startValue) return startValue - target;
        //     helper(target, (long)startValue, 0);
        //     return min;
        // }
        // // int res = s.brokenCalc(1, 1000000000); // 爆栈，要用到快速幂处理吗，这里还要再想想


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


        // public class MinSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     List<Integer> tidx = new ArrayList<>();
        //     public int minIdx = 0;
        //     int n;
        //     public MinSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) {
        //             tree.add(0);
        //             tidx.add(0);
        //         }
        //         for (int i = 0; i < n; i++) {
        //             tree.add(arr[i]); 
        //             tidx.add(i);
        //         }
        //         for (int i = n-1; i >= 0; i--) { // i >= 0
        //             tree.set(i,  Math.min(tree.get(2*i),  tree.get(2*i+1)));
        //             tidx.set(i, tree.get(2*i) <= tree.get(2*i+1) ? i-1 : i);
        //         }
        //     }
        //     public void update(int idx,  int v) {
        //         idx += n;
        //         tree.set(idx,  v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx,  Math.min(tree.get(2*idx),  tree.get(2*idx+1)));
        //             tidx.set(idx, tree.get(2*idx) <= tree.get(2*idx+1) ? idx-1 : idx);
        //         }
        //     }
        //     public int getMin(int l,  int r) { // [l, r) include left, not included right
        //         l += n;
        //         r += n;
        //         int min = Integer.MAX_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 if (tree.get(l) < min) {
        //                     min = tree.get(l);
        //                     minIdx = tidx.get(l);
        //                 }
        //                 // min = Math.min(min,  tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--; // order matters !!!
        //                 // min = Math.min(min,  tree.get(r));
        //                 if (tree.get(r) < min) {
        //                     min = tree.get(r);
        //                     minIdx = tidx.get(l);
        //                     // minIdx = r;
        //                 }
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return min;
        //     }
        // }
        // public int[] mostCompetitive(int[] nums,  int k) {
        //     int n = nums.length;
        //     if (k == n) return nums;
        //     MinSeg minSeg = new MinSeg(nums);
        //     List<Integer> l = new ArrayList<>();
        //     int min = Integer.MAX_VALUE,  midx = -1;
        //     while (l.size() < k) {
        //         min = minSeg.getMin(midx+1, n-(k-l.size())+1);
        //         System.out.println("min: " + min);
        //         // for (int i = midx+1; i <= n-(k-l.size()); i++) {
        //         //     if (nums[i] < min) {
        //         //         min = nums[i];
        //         //         midx = i;
        //         //     }
        //         // }
        //         l.add(min);
        //         min = Integer.MAX_VALUE;
        //         midx = minSeg.minIdx; // 这里的idx的更新是有问题的，除非要把数组位标随身背着
        //         System.out.println("midx:" + midx);
        //     }
        //     return l.stream().mapToInt(i->i).toArray();
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


        // public int[] rearrangeArray(int[] nums) {
        //     int n = nums.length;
        //     int [] res = new int [n];
        //     Arrays.sort(nums);
        //     int ei = 0, oi = 1; // even idx odd idx
        //     double mid = (n % 2 == 0 ? (nums[n/2] + nums[n/2+1])/2.0 : nums[n/2]);
        //     System.out.println("mid: " + mid);
        //     for (int i = 0; i < n; i++) {
        //         if (nums[i] < mid) {
        //             res[oi] = nums[i];
        //             oi += 2;
        //         } else {
        //             res[ei] = nums[i];
        //             ei += 2 ;
        //         }
        //     }
        //     return res;
        // }
        // int []  a = new int []  {1, 2, 5, 9};


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

        
        // private boolean isPossibleIndex(int [] arr, int l, int r) {
        //     if (r - l < 2) return false;
        //     if (r - l == 2) return arr[r]-arr[r-1] == 1 && arr[r-1]-arr[l] == 1;
        //     int i = l+1;
        //     while (true) {
        //         while (i <= r && arr[i] -arr[i-1] == 1) ++i;
        //         if (i <= r && arr[i] -arr[i-1] != 1 && i-l < 3) return false;
        //         return isPossibleIndex(arr, i, r);
        //     }
        // }
        // public boolean isPossible(int[] nums) {
        //     int n = nums.length;
        //     return isPossibleIndex(nums, 0, n-1);
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

        
        // private int makeZigZag(int [] arr, int idx) {
        //     int cnt = 0;
        //     for (int i = idx; i < n; i += 2) {
        //         // if (i == idx && i+1 < n && arr[i] < arr[i+1]) cnt += arr[i+1] - ((i == n-2 ? arr[i] : Math.min(arr[i], arr[i+2])) - 1);
        //         if (i == idx && i+1 < n && arr[i] < arr[i+1]) {
        //             cnt += arr[i+1] - (arr[i] - 1);
        //             arr[i+1] = arr[i]-1;
        //         }
        //         if ((i > idx || idx%2 ==1) && arr[i] < arr[i-1]) {
        //             cnt += arr[i-1] - (arr[i]-1);
        //             arr[i-1]  = arr[i]-1;
        //         }
        //     }
        //     System.out.println("cnt: " + cnt);
        //     return cnt;
        // }
        // int n;
        // public int movesToMakeZigzag(int[] nums) {
        //     n = nums.length;
        //     int [] s = new int [n];
        //     System.arraycopy(nums, 0, s, 0, n);
        //     int a = makeZigZag(s, 0);
        //     int [] t = new int [n];
        //     System.arraycopy(nums, 0, t, 0, n);
        //     return Math.min(a, makeZigZag(t, 1));
        // }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []   a = new int []   { 1, 2, 3};
        // int []   a = new int []   {9, 6, 1, 6, 2};
        int []   a = new int []   {2, 7, 10, 9, 8, 9};

        int res = s.movesToMakeZigzag(a);
        System.out.println("res: " + res);
    }
}