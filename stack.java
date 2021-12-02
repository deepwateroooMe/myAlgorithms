import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class stack {
    public static class Solution {

        // Stack<Integer> st;
        // int maxSize, cnt;
        // public CustomStack(int maxSize) {
        //     this.maxSize = maxSize;
        //     cnt = 0;
        //     st = new Stack<>();
        // }
        // public void push(int x) {
        //     if (cnt == maxSize) return;
        //     st.push(x);
        //     cnt++;
        // }
        // public int pop() {
        //     if (cnt == 0) return -1;
        //     cnt--;
        //     return st.pop();
        // }
        // public void increment(int k, int val) {
        //     Stack<Integer> t = new Stack<>();
        //     while (!st.isEmpty())
        //         t.push(st.pop());
        //     int cnt = 0;
        //     while (!t.isEmpty() && cnt < k) {
        //         st.push(t.pop() + val);
        //         cnt++;
        //     }
        //     while (!t.isEmpty()) st.push(t.pop());
        // }
        // stack s = new stack();
        // s.next(100); // return 1
        // s.next(80);  // return 1
        // s.next(60);  // return 1
        // int r = s.next(70);  // return 2
        // System.out.println("r: " + r);
        // s.next(60);  // return 1
        // int r1 = s.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        // System.out.println("r1: " + r1);
        // s.next(85);  // return 6


        // public int[] dailyTemperatures(int[] temperatures) {
        //     int n = temperatures.length;
        //     int [] ans = new int [n];
        //     Stack<Integer> s = new Stack<>();
        //     for (int i = 0; i < n; i++) {
        //         s.push(temperatures[i]);
        //         for (int j = i+1; j < n; j++) 
        //             if (arr[j] > arr[i]) {
        //                 ans[i] = j - i;
        //                 break;
        //             }
        //     }
        // }


        // public int [] nextGreaterElements(int [] arr) {
        //     int n = arr.length;
        //     int [] ans = new int [n];
        //     Stack<Integer> s = new Stack<>(); // push arr[i] or idx ?
        //     for (int i = 0; i < n; i++) {
        //         s.push(arr[i]);
        //         for (int j = i+1; j < n; j++) 
        //             if (arr[j] > arr[i]) {
        //                 s.push(arr[j]);
        //                 break;
        //             }
        //         if (!s.isEmpty() && s.peek() > arr[i])
        //             ans[i] = s.peek();
        //     }
        // }


        // public int clumsy(int n) {
        //     Stack<Integer> num = new Stack<>();
        //     Stack<Integer> sn = new Stack<>();
        //     int idx = 0;
        //     for (int i = n; i >= 1; i--) {
        //         num.push(i);
        //         if (sn.size() > 0 && (sn.peek() == 0 || sn.peek() == 1) && num.size() >= 2) { // * /
        //             int b = num.pop(), a = num.pop(), v = 0;
        //             if (sn.peek() == 0) v = a * b;
        //             else if (sn.peek() == 1) v = a / b;
        //             sn.pop();
        //             num.push(v);
        //         }
        //         if (i > 1)
        //             sn.push(idx);
        //         idx = (idx + 1) % 4;
        //     }
        //     while (sn.size() > 0) {
        //         int b = num.pop(), a = num.pop(), v = 0;
        //         int pre = sn.pop();
        //         if (sn.size() == 0 || sn.size() > 0 && sn.peek() == 2) {
        //             if (pre == 2) num.push(a + b);
        //             else num.push(a - b);
        //             if (sn.size() == 0) return num.pop();
        //         } else {
        //             if (pre == 2) num.push(a - b);
        //             else num.push(a + b);
        //         } 
        //     }
        //     return num.pop();
        // }


        // public int[] asteroidCollision(int[] asteroids) { 
        //     int n = asteroids.length, i = 0;
        //     Stack<Integer> s = new Stack<>();
        //     while (i < n) {
        //         while (i < n && (s.isEmpty() || s.peek() < 0) && asteroids[i] < 0) s.push(asteroids[i++]);
        //         if (i == n) break;
        //         while (i < n && !s.isEmpty() && s.peek() > 0 && asteroids[i] < 0) {
        //             if (s.peek() < Math.abs(asteroids[i])) s.pop();
        //             else if (s.peek() == -asteroids[i]) {
        //                 s.pop();
        //                 i++;
        //             } else i++;
        //         }
        //         if (i < n && asteroids[i] > 0)
        //             s.push(asteroids[i++]);
        //     }            
        //     int [] ans = new int [s.size()];
        //     i = s.size()-1;
        //     while (!s.isEmpty()) ans[i--] = s.pop();
        //     return ans;
        // }


        // public String removeKdigits(String num, int k) { // 感觉脑袋好不清醒，这个题需要借鉴好思路，写得很乱
        //     int n = num.length(), cnt = 0;
        //     if (k >= n) return "0";
        //     int idx = num.indexOf('0');
        //     if (idx >= 0) {
        //         if (idx < k) return removeKdigits(num.substring(idx+1).replaceFirst("^0+(?!$)", ""), k-idx);
        //         else if (idx == k) {
        //             String tmp = num.substring(idx+1).replaceFirst("^0+(?!$)", "");
        //             return tmp.length() > 0 ? tmp : "0";
        //         }
        //     }
        //     char [] s = num.toCharArray();
        //     Stack<Character> st = new Stack<>();
        //     for (int i = 0; i < n; i++) {
        //         if (st.isEmpty()) { 
        //             st.push(s[i]);
        //             continue;
        //         }
        //         char c = s[i], top = st.peek();
        //         while (st.size() > 0 && c < top && cnt < k && st.size() > i-k) {
        //             st.pop();
        //             cnt++;
        //             if (st.size() > 0) top = st.peek();
        //         }
        //         if (st.size() > 0)
        //             top = st.peek();
        //         if (st.size() > 0 && c >= top && st.size() == n-k) continue;
        //         if (st.size() > 0 && c < top && st.size() == n-k) 
        //             st.pop();
        //         st.push(c);
        //     }
        //     if (st.isEmpty()) return "0";
        //     StringBuilder sb = new StringBuilder();
        //     while (!st.isEmpty()) sb.append(st.pop());
        //     String tmp = sb.reverse().toString();
        //     if (tmp.startsWith("0")) {
        //         int i = 0, cnttmp = 0;
        //         while (i < tmp.length() && tmp.charAt(i) == '0') {
        //             i ++;
        //             cnttmp ++;
        //         }
        //         return removeKdigits(tmp.substring(i), Math.min(k-cnt, cnttmp));
        //     }
        //     return tmp;
        // }


        // public int[] dailyTemperatures(int[] temperatures) {
        //     int n = temperatures.length;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     int [] ans = new int [n];
        //     s.push(n-1);
        //     for (int i = n-2; i >= 0; i--) {
        //         if (!s.isEmpty() && temperatures[s.peek()] > temperatures[i]) {
        //             ans[i] = 1;
        //             s.push(i);
        //         } else if (!s.isEmpty()) {
        //             while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) s.pop();
        //             if (!s.isEmpty()) 
        //                 ans[i] = s.peek() - i;
        //             s.push(i);
        //         }
        //     }
        //     return ans;
        // }


        // ArrayDeque<Integer> s;
        // Map<Integer, Integer> m = new HashMap<>();
        // int idx;
        // public StockSpanner() {
        //     s = new ArrayDeque<>();
        //     idx = 0;
        // }
        // public int next(int price) {
        //     idx += 1;
        //     m.put(idx, price);
        //     if (s.isEmpty()) {
        //         s.push(idx);
        //         return 1;
        //     }
        //     if (m.get(s.peek()) > price) {
        //         s.push(idx);
        //         return 1;
        //     } else {
        //         while (!s.isEmpty() && m.get(s.peek()) <= price) s.pop();
        //         int v = idx - (s.isEmpty() ? 0 : s.peek());
        //         s.push(idx);
        //         return v;
        //     }
        // }


        // public int[] nextGreaterElements(int[] arr) {
        //     int n = arr.length;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     int [] ans = new int [n];
        //     Arrays.fill(ans, -1);
        //     for (int i = n-2; i >= 0; i--) {
        //         while (!s.isEmpty() && arr[i] >= s.peek()) s.pop();
        //         s.push(arr[i]);
        //     }
        //     while (!s.isEmpty() && arr[n-1] >= s.peek()) s.pop();
        //     ans[n-1] = !s.isEmpty() && arr[n-1] < s.peek() ? s.peek() : -1;
        //     if (s.isEmpty() || arr[n-1] < s.peek()) s.push(arr[n-1]);
        //     for (int i = n-2; i >= 0; i--) {
        //         while (!s.isEmpty() && arr[i] >= s.peek()) s.pop();
        //         if (!s.isEmpty()) 
        //             ans[i] = s.peek();
        //         s.push(arr[i]);
        //     }
        //     return ans;
        // }


        // public int maxWidthRamp(int[] arr) { // 这个思路还有点儿不太清楚
        //     int n = arr.length, max = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && arr[s.peek()] > arr[i]) s.pop();
        //         s.push(i);
        //     }
        //     return s.size()-1;
        // }


        // public int maximumGain(String t, int x, int y) { // ab, x   ba y
        //     int n = t.length(), min = Math.min(x, y), max = Math.max(x, y), ans = 0;
        //     char [] smin = x <= y ? new char [] {'a', 'b'} : new char [] {'b', 'a'};
        //     char [] smax = x <= y ? new char [] {'b', 'a'} : new char [] {'a', 'b'};
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Character> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == smax[1] && !st.isEmpty() && st.peek() == smax[0]) {
        //             st.pop();
        //             ans += max;
        //             continue;
        //         }
        //         st.push(s[i]);
        //     } // 脑袋有点儿昏乎乎的了，需要像第一次去除max字符组一样，把pop出去的字母先存起来，以防需要recursion得分的时候漏掉得分
        //     ArrayDeque<Character> tt = new ArrayDeque<>();
        //     while (!st.isEmpty()) { 
        //         char c = st.pop();
        //         if (!tt.isEmpty() && tt.peek() == smin[1] && c == smin[0]) {
        //             tt.pop();
        //             ans += min;
        //         } else tt.push(c);
        //     }
        //     return ans;
        // }


        // public int maxWidthRamp(int[] arr) {
        //     int n = arr.length, max = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = n-1; j > i; j--) 
        //             if (arr[j] >= arr[i]) {
        //                 max = Math.max(max, j-i);
        //                 break;
        //             }
        //     return max;
        // }


        // static long mod = (int)1e9 + 7;
        // int N = 100001;
        // public int maxSumMinProduct(int[] arr) {
        //     int n = arr.length;
        //     long [] sum = new long [N]; // 构造前缀和
        //     int [] h = new int [N], l = new int [N], r = new int [N], q = new int [N];
        //     for (int i = 1; i <= n; i++) {
        //         sum[i] = sum[i-1] + arr[i-1];
        //         h[i] = arr[i-1];
        //     }  // h[n + 1] 会在求右边第一个比它小时用到。求第n个数右边比它小的数时会访问h[n + 1] 这时候当h[n + 1] = 0 就保证它是最小的
        //     h[0] = h[n+1] = 0; // dummy 点 LC提交上去后，h[n + 1] 对于每个样例输出的结果不同，但不会更新，因此这里手动更新下
        //     q[0] = 0;
        //     int tt= 0; // 找到左边第一个比它小的数的位置
        //     for (int i = 1; i <= n; i++) {
        //         while (h[i] <= h[q[tt]]) tt--;
        //         l[i] = q[tt];
        //         q[++tt] = i;
        //     }
        //     tt = 0;   // 找到右边第一个比它小的数的位置
        //     q[0] = n + 1; // 从右往左起，第n个数h[n]会跟右边的数 h[q[0]] = h[n + 1] 比较
        //     for (int i = n; i >= 1; i--) {
        //         while (h[i] <= h[q[tt]]) tt--;
        //         r[i] = q[tt];
        //         q[++tt] = i;
        //     }
        //     long ans = 0;
        //     for (int i = 1; i <= n; i++) 
        //         ans = Math.max(ans, h[i] * (sum[r[i]-1] - sum[l[i]]));
        //     return (int)(ans % mod);
        // }
        // public int maxSumMinProduct(int[] arr) { // 抄错了，有个bug, 改天再把它找出来
        //     int n = arr.length;
        //     int mod = (int)1e9 + 7;
        //     long [] sum = new long [n];
        //     sum[0] = arr[0];
        //     for (int i = 1; i < n; i++) 
        //         sum[i] = sum[i-1] + arr[i];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     long ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.isEmpty()) s.push(i);
        //         else {
        //             while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        //                 int top = s.pop();
        //                 if (s.isEmpty()) ans = Math.max(ans, sum[i-1] * arr[top]);
        //                 else ans = Math.max(ans, (sum[i-1] - sum[s.peek()]) * arr[top]);
        //             }
        //             s.push(i);
        //         }
        //     }
        //     while (!s.isEmpty()) {
        //         int top = s.pop();
        //         if (s.isEmpty()) ans = Math.max(ans, sum[n-1] * arr[top]);
        //         else ans = Math.max(ans, (sum[n-1] - sum[s.peek()] * arr[top]));
        //     }
        //     return (int)(ans % mod);
        // }
        // public int maxSumMinProduct(int[] nums) {
        //     int mod = (int)1e9 + 7;
        //     int n = nums.length;
        //     int [] arr = new int [n+2];
        //     System.arraycopy(nums, 0, arr, 1, n);
        //     long [] sum = new long [n+2];
        //     sum[1] = arr[1];
        //     for (int i = 2; i < arr.length; i++) 
        //         sum[i] = sum[i-1] + arr[i];
        //     long ans = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
        //             int cur = arr[s.pop()];
        //             int l = s.peek()+1;
        //             int r = i - 1;
        //             ans = Math.max(ans, (sum[r] - sum[l-1]) * cur);
        //         }
        //         s.push(i);
        //     }
        //     return (int)(ans % mod);
        // }

        
        // public int longestWPI(int[] arr) { 
        //     int max = 0, cur = 0;
        //     Map<Integer, Integer> vis = new HashMap<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         cur += arr[i] > 8 ? 1 : -1;
        //         if (cur > 0) max = i+1;
        //         else {
        //             if (!vis.containsKey(cur)) vis.put(cur, i);
        //             if (vis.containsKey(cur-1))
        //                 max = Math.max(max, i - vis.get(cur-1));
        //         }
        //     }
        //     return max;
        // }
        // public int longestWPI(int[] arr) {
        //     int n = arr.length, max = 0, cur = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + (arr[i-1] > 8 ? 1 : -1); // 
        //     for (int i = 0; i <= n; i++) 
        //         if (s.isEmpty() || sum[s.peek()] > sum[i]) s.push(i);
        //     for (int i = n; i >= 0; i--) 
        //         while (!s.isEmpty() && sum[s.peek()] < sum[i]) 
        //             max = Math.max(max, i - s.pop());
        //     return max;
        // }


        // public boolean validateStackSequences(int[] pushed, int[] popped) {
        //     int n = pushed.length, i = 0;
        //     if (n == 1) return true;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int v : pushed) {
        //         s.push(v);
        //         while (!s.isEmpty() && s.peek() == popped[i]) {
        //             s.pop();
        //             i++;
        //         }
        //     }
        //     return s.isEmpty() && i == popped.length;
        // }


        // public int [] exclusiveTime(int n, List<String> logs) { // bug bug bug
        //     int [] ans = new int [n];
        //     List<int []> ll = new ArrayList<>();
        //     for (String str : logs) {
        //         String [] cur = str.split(":");             // start: 0, end : 1
        //         ll.add(new int [] {Integer.parseInt(cur[0]), cur[1].equals("start") ? 0 : 1, Integer.parseInt(cur[2])});
        //     }
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int i = 0; i < ll.size(); i++) {
        //         if (!s.isEmpty()) {
        //             int [] top = ll.get(s.peek());
        //             if (ll.get(i)[0] == top[0] && ll.get(i)[1] == 1 && top[1] == 0) {
        //                 int topIdx = s.pop();
        //                 if (topIdx == i-1)
        //                     ans[top[0]] += ll.get(i)[2] - top[2] + 1;
        //                 else { // 仍然不对，中间还断了一截
        //                     ans[top[0]] += ll.get(i)[2] - ll.get(i-1)[2] + ll.get(topIdx+1)[2] - top[2];
        //                 }
        //                 continue;
        //             }
        //         }
        //         s.push(i);
        //     }
        //     return ans;
        // }
        // 解法：栈，用stack保存当前还在还没结束的function的(id，start)。
        // 遇到是start的log时，计算栈顶函数的时间，然后把当前函数push进stack；
        // 遇到是end的就pop出stack的最近一个元素，并计算此function的运行时间
        // public int [] exclusiveTime(int n, List<String> logs) {
        //     int [] ans = new int [n];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     int pre = 0;
        //     for (String str : logs) {
        //         String [] cur = str.split(":");
        //         if (!s.isEmpty()) ans[s.peek()] += Integer.parseInt(cur[2]) - pre;
        //         pre = Integer.parseInt(cur[2]);
        //         if (cur[1].equals("start")) s.push(Integer.parseInt(cur[0]));
        //         else {
        //             ans[s.pop()]++;
        //             pre++;
        //         }
        //     }
        //     return ans;
        // }

        
        // public int lengthLongestPath(String input) {
        //     int n = input.length();
        //     System.out.println("n: " + n);
        //     char [] s = input.toCharArray();
        //     System.out.println(Arrays.toString(s));
        //     System.out.println("s.length: " + s.length);
        //     ArrayDeque<String> st = new ArrayDeque<>();
        //     int cur = 0, idx = 0, i = 0, max = 0;
        //     i = input.indexOf("\n");
        //     System.out.println("i: " + i);
        //     // while (i < n) {
        //     //     while (i < n && s[i] != '\\') i++; 
        //     // }
        //     return 0;
        // }
        // String a = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        // 单调栈思路：
        // 一个人可以低头看人，也可以抬头看人，抬头只能看见离自己最近的比自己高的，低头看可以看到所有没有被高个子挡住的比自己矮的。
        // 维护一个单调递减的栈，从右往左把人压栈，如果栈顶元素比自己小，说明自己左边的人看不到这些会被自己挡住的人，出栈即可。再看看里面是否有比自己大的人，有的话自己能看到，最后再把自己压栈。
        // public int[] canSeePersonsCount(int[] arr) {
        //      int n = arr.length, cnt = 0;
        //      ArrayDeque<Integer> s = new ArrayDeque<>(); 
        //      int [] ans = new int [n];
        //      s.push(arr[n-1]);
        //      for (int i = n-2; i >= 0; i--) {
        //          while (!s.isEmpty() && s.peek() < arr[i]) {
        //              s.pop();  // 自己会挡住 左边的人看不到的都弹出去
        //              ans[i]++; // 看到所有比自己矮还没被挡住的小人
        //          }
        //          if (!s.isEmpty()) ans[i]++; // 看到最近的比自己高的小人, 题目的意思没能理解对
        //          s.push(arr[i]);
        //      }
        //      return ans;
        // }



        // private Map<Integer, List<Integer>> getMap(int [] arr, int k) { // 被自己写得bug满天飞的代码，自己都不想多看一眼
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(arr[i], i);
        //     Map<Integer, List<Integer>> ma = new HashMap<>(); // key: 1, 2, 3, 4, ... k
        //     TreeSet<Integer> one = new TreeSet<>((x, y)->arr[x] != arr[y] ? arr[x] - arr[y] : x - y); // 不写好会漏掉元素
        //     for (int i = 0; i < n; i++) one.add(i);
        //     if (n > k) {
        //         Set<Integer> idx = new HashSet<>();
        //         while (one.size() > k) idx.add(one.pollFirst());
        //         List<Integer> l = new ArrayList<>();
        //         for (int i = 0; i < n; i++) 
        //             if (!idx.contains(i)) l.add(arr[i]);
        //         ma.put(k, l);
        //     } else ma.put(n, Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //     int key = ma.entrySet().iterator().next().getKey()-1;
        //     boolean removed = false;
        //     while (key >= 0) {
        //         List<Integer> l = new ArrayList<>(ma.get(key+1));
        //         removed = false;
        //         for (int i = 0; i < l.size(); i++) 
        //             if ((i == 0 || i > 0 && l.get(i) < l.get(i-1)) && (i == l.size()-1 || i < l.size()-1 && l.get(i) < l.get(i+1))) {
        //                 one.remove(m.get(l.get(i)));
        //                 l.remove(i);
        //                 removed = true;
        //                 break;
        //             }
        //         if (!removed)
        //             for (int i = l.size()-1; i >= 0; i--)
        //                 if ((i == l.size()-1 || i < l.size()-1 && l.get(i) < l.get(i+1)) && (i == 0 || i > 0 && l.get(i) <= l.get(i-1))) {
        //                     one.remove(m.get(l.get(i)));
        //                     l.remove(i);
        //                     removed = true;
        //                     break;
        //                 }
        //         if (!removed) {
        //             int min = arr[one.pollFirst()];
        //             for (int i = 0; i < l.size(); i++) { // 这一步的贪心好像不对？！！！
        //                 System.out.println("(l.get(i) == min) : " + (l.get(i) == min) );
        //                 if  (l.get(i) == min) {
        //                     l.remove(i);
        //                     break;
        //                 }
        //             }
        //         }
        //         ma.put(key, l);
        //         key --;
        //     }
        //     return ma;
        // }
        // private String getString(List<Integer> l, int k)  {
        //     String ans = "";
        //     for (int i = 0; i < Math.min(l.size(), k); i++) 
        //         ans += "" + l.get(i);
        //     return ans;
        // }
        // private String getString(List<Integer> l, List<Integer> r, int k)  {
        //     if (l.size() == 0 || r.size() == 0) return getString(l.size() == 0 ? r : l, k);
        //     String ans = "";
        //     int i = 0, j = 0, cnt = 0;
        //     while (i < l.size() && j < r.size() && cnt < k) {
        //         if (l.get(i) > r.get(j)) {
        //             ans += "" + l.get(i++);
        //             cnt++;
        //         } else if (l.get(i) < r.get(j)) {
        //             ans += "" + r.get(j++);
        //             cnt++;
        //         } else {
        //             if (i < l.size()-1 && l.get(i+1) > l.get(i) && (j == r.size()-1 || r.get(j+1) < l.get(i+1))) {
        //                 ans += "" + l.get(i++);
        //                 cnt++;
        //             } else if ((j < r.size()-1) && r.get(j+1) > r.get(j)) {
        //                 ans += "" + r.get(j++);
        //                 cnt++;
        //             } else {
        //                 ans += ("" + l.get(i++)).repeat(2);
        //                 cnt += 2;
        //                 j++;
        //             }
        //         }
        //     }
        //     if (i < l.size() && cnt < k) 
        //         while (i < l.size() && cnt < k) {
        //             ans += "" + l.get(i++);
        //             cnt++;
        //         }
        //     if (j < r.size() && cnt < k) 
        //         while (j < r.size() && cnt < k) {
        //             ans += "" + r.get(j++);
        //             cnt++;
        //         }
        //     return ans;
        // }
        // private boolean compare(int [] a, int [] b, int i, int j) { // 这里不知道数组的长短
        //     for (; i < a.length && j < b.length; i++, j++) {
        //         if (a[i] == b[j]) continue;
        //         // if (a[i] < b[j]) return true; // 这里写得不对
        //         return a[i] < b[j];
        //     }
        //     return j < b.length;
        // }
        // private int [] getNum(int [] arr, int k) { // 还分得清是A或是B吗？ m n
        //     if (k == 0) return new int [] {};
        //     int [] ans = new int [k];
        //     int n = arr.length, idx = 0;
        //     for (int i = 0; i < arr.length; i++) { // arr i 后面还有足够多的位数来凑齐 k-idx位
        //         while (idx > 0 && ans[idx-1] < arr[i] && arr.length - i > k - idx) idx--;
        //         if (idx < k) {
        //             ans[idx] = arr[i];
        //             idx++;
        //         }
        //     }
        //     return ans;
        // }
        // private int [] merge(int [] a, int [] b, int i, int j) {
        //     int m = a.length, n = b.length;
        //     int [] ans = new int [m+n];
        //     while (i < m || j < n) {
        //         if (i >= m)
        //             ans[i+j] = b[j++];
        //         else if (j >= n) 
        //             ans[i+j] = a[i++];
        //         else if (compare(a, b, i, j)) 
        //             ans[i+j] = b[j++];
        //         else 
        //             ans[i+j] = a[i++];
        //     }
        //     return ans;
        // }
        // public int[] maxNumber(int[] a, int[] b, int k) {
        //     int [] ans = new int [k];
        //     for (int i = Math.max(0, k - b.length); i <= a.length && i <= k; i++) {
        //         int [] tmp = merge(getNum(a, i), getNum(b, k - i), 0, 0);
        //         if (compare(ans, tmp, 0, 0))
        //             ans = tmp;
        //     }
        //     return ans;
        // }


        // public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) { // queue
        //     int cnt = 0, ans = 0, curWit = 0;
        //     int n = boxes.length, pre = 0;
        //     Queue<int []> q = new LinkedList<>();
        //     for (int i = -1; i < n-1; ) {
        //         cnt = 0;
        //         curWit = 0; // 这又是试图暴力解题，这里有选择优化成分
        //         // 需要意识到：不是每次运送到最多箱子个数和最重，答案就是最优解，而是要找尽可能少的运送次数，所以如果能一次送到同一个码头，就不要再多加其它码头的箱子 
        //         while (i < n-1 && cnt < maxBoxes && curWit + boxes[i+1][1] <= maxWeight) { // i == n-1
        //             q.offer(boxes[i+1]);
        //             cnt++;
        //             curWit += boxes[i++ + 1][1];
        //         }
        //         while (!q.isEmpty()) {
        //             int [] cur = q.poll();
        //             if (cur[0] != pre) {
        //                 ans++;
        //                 pre = cur[0];
        //             }
        //         }
        //         ans++; // go back to storage
        //         pre = 0;
        //     }
        //     return ans;
        // }
        // public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) { // O(N)滑动窗口
        //     int n = boxes.length, j = 0, lastj = 0, cnt = 0;
        //     int [] dp = new int [n+1];
        //     Arrays.fill(dp, Integer.MAX_VALUE / 3); // / 3 to avoid overflow
        //     dp[0] = 0;                              //
        //     for (int i = 0; i < n; ++i) {
        //         while (j < n && maxBoxes > 0 && maxWeight >= boxes[j][1]) {
        //             maxBoxes -= 1;
        //             maxWeight -= boxes[j][1];
        //             if (j == 0 || boxes[j][0] != boxes[j-1][0]) { // if the port is different from the previous port
        //                 lastj = j;
        //                 cnt++;
        //             }
        //             ++j;                        // keep expanding the right pointer when we can
        //             // dp[++j] = 200000;        // equivalent
        //         }
        //         dp[j] = Math.min(dp[j], dp[i] + cnt + 1); // 这里的cnt 相当于是一个快进效果，提速
        //         dp[lastj] = Math.min(dp[lastj], dp[i] + cnt);
        //         // 这里下面三行：像是回溯一样，绕得好昏呀: 感觉是向右滑动，再增加一些空间，向右遍历所有可能性，并保存最优解
        //         maxBoxes += 1;            // now as we move the left pointer i forward (don't put the ith box in this trip), 
        //         maxWeight += boxes[i][1]; // we increase the number of available boxes and available weights
        //         if (i == n-1 || boxes[i][0] != boxes[i+1][0]) cnt--;
        //     }
        //     return dp[n];
        // }
        // public int boxDelivering(int[][] box, int __, int max, int limit) {
        //     int n = box.length;
        //     int[] dp = new int[n+1]; // Minimum trips for first n boxes.
        //     int wit = 0, cost = 2;   // cumulative weight, cumulative cost
        //     int l = 0;                   // left ptr
        //     for (int r = 0; r < n; r++) {// right ptr
        //         wit += box[r][1];
        //         if (r > 0 && box[r][0] != box[r-1][0]) cost++;
        //         /* drop box iff:
        //            - There are too many box (r-l >= max)
        //            - The box are too heavy (weight > limit)
        //            - It is redundant to carry them (dp[l] == dp[l+1]).
        //         */                                 // 送往同一个港口的箱子向右滑动，直到改变消耗的临界点
        //         while (r - l >= max || wit > limit || (l < r && dp[l] == dp[l+1])) { // 滑动窗口：左窗口右移
        //             wit -= box[l][1];
        //             if (box[l+1][0] != box[l][0]) cost--;
        //             l++;
        //         }
        //         dp[r+1] = cost + dp[l]; // 运完下标为 r 的箱子后的最小次数，对应 dp[r+1]
        //     }
        //     return dp[n];
        // }

        // public int[] nextGreaterElement(int[] a, int[] b) {
        //     int m = a.length, n = b.length;
        //     int [] ans = new int [m];
        //     Arrays.fill(ans, -1);
        //     Map<Integer, Integer> idx = new HashMap<>(); // k, v: a[i], idx
        //     for (int i = 0; i < m; i++) 
        //         idx.put(a[i], i);
        //     ArrayDeque<Integer> s = new ArrayDeque<>(); // 单调递减， 头大尾小
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!s.isEmpty() && s.peekLast() < b[i]) s.pollLast();
        //         if (!s.isEmpty() && idx.containsKey(b[i]))
        //             ans[idx.get(b[i])] = s.peekLast();
        //         s.offerLast(b[i]);
        //     }
        //     return ans;
        // }

        // public int[] finalPrices(int[] a) {
        //     int n = a.length;
        //     ArrayDeque<Integer> s = new ArrayDeque<>(); // 单调递减，头大尾小
        //     int [] ans = new int [n];
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!s.isEmpty() && s.peekLast() > a[i]) s.pollLast();
        //         if (!s.isEmpty()) ans[i] = a[i] - s.peekLast();
        //         else ans[i] = a[i];
        //         s.offerLast(a[i]);
        //     }
        //     return ans;
        // }

        //  public int maxDepth(String t) {
        //     int n = t.length(), l = 0, r = 0, max = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '(') l++;
        //         else if (s[i] == ')') r++;
        //         max = Math.max(max, l - r);
        //     }
        //     return max;
        // }

        // public String removeOuterParentheses(String t) {
        //     int n = t.length(), l = 0, r = 0;
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Character> st = new ArrayDeque<>();
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '(') {
        //             l++;
        //             st.offerLast(s[i]);
        //         } else {
        //             r++;
        //             if (l == r) {
        //                 if (st.size() == 1) {
        //                     st.pollLast();
        //                     continue;
        //                 } else {
        //                     st.pollFirst();
        //                     while (!st.isEmpty()) sb.append(st.pollFirst());
        //                 }
        //             } else st.offerLast(s[i]);
        //         }
        //     }
        //     return sb.toString();
        // }

        // public String removeDuplicates(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Character> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (st.isEmpty() || s[i] != st.peekLast())
        //             st.offerLast(s[i]);
        //         else while (!st.isEmpty() && st.peekLast() == s[i]) st.pollLast();
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     while (!st.isEmpty()) sb.append(st.pollFirst());
        //     return sb.toString();
        // }

        // public List<String> buildArray(int[] a, int n) {
        //     List<String> ans = new ArrayList<>();
        //     int idx = 1;
        //     for (int i = 0; i < a.length; i++) {
        //         while (idx != a[i]) {
        //             ans.add("Push");
        //             ans.add("Pop");
        //             idx++;
        //         }
        //         if (a[i] == idx) {
        //             ans.add("Push");
        //             idx++;
        //         }
        //     }
        //     return ans;
        // }

        // public int calPoints(String[] a) {
        //     int n = a.length, sum = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i].equals("+")) {
        //             int last = s.pollLast(), v = s.peekLast() + last;
        //             s.offerLast(last);
        //             s.offerLast(v);
        //         } else if (a[i].equals("D")) {
        //             s.offerLast(s.peekLast() * 2);
        //         } else if (a[i].equals("C"))
        //             s.pollLast();
        //         else s.offerLast(Integer.parseInt(a[i]));
        //     }
        //     while (!s.isEmpty()) sum += s.pollLast();
        //     return sum;
        // }

        // public String makeGood(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Character> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (!st.isEmpty() && (Character.isLowerCase(st.peekLast()) && s[i] == Character.toUpperCase(st.peekLast())
        //                               || Character.isUpperCase(st.peekLast()) && s[i] == Character.toLowerCase(st.peekLast())))
        //             st.pollLast();
        //         else st.offerLast(s[i]);
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     while (!st.isEmpty()) sb.append(st.pollFirst());
        //     return sb.toString();
        // }

        // public int countStudents(int[] std, int[] san) {
        //     ArrayDeque<Integer> st = new ArrayDeque<>();
        //     int n = std.length, cnt = 0, j = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (std[i] == san[j]) {
        //             j++;
        //             continue;
        //         }
        //         st.offerLast(i);
        //     }
        //     boolean bk = false;
        //     while (!st.isEmpty()) {
        //         while (!st.isEmpty() && std[st.peekFirst()] == san[j]) {
        //             j++;
        //             st.pollFirst();
        //         }
        //         if (st.isEmpty()) return 0;
        //         bk = false;
        //         int cur = st.peekFirst();
        //         while (std[st.peekFirst()] != san[j]) {
        //             st.offerLast(st.pollFirst());
        //             if (st.peekFirst() == cur) return st.size();
        //         }
        //     }
        //     return 0;
        // }

        // public int minOperations(String[] a) {
        //     int n = a.length;
        //     ArrayDeque<String> s = new ArrayDeque<>();
        //     for (String v : a) {
        //         if (v.equals("./")) continue;
        //         if (v.equals("../")) {
        //             if (!s.isEmpty()) s.pollLast();
        //         } else s.offerLast(v);
        //     }
        //     return s.size();
        // }






        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String []  a = new String []  {"d1/", "../", "../", "../"};
        String []  a = new String []  {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        
        int r = s.minOperations(a);
        System.out.println("r: " + r);
        
    }
}