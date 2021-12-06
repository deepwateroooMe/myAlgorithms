import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class hardOne {
    public static class Solution {

        // public String shortestPalindrome(String t) { // tle 
        //     if (t.chars().distinct().count() == 1) return t;
        //     if (isPalindrome(t)) return t;
        //     int n = t.length();
        //     int i = n / 2 + (n % 2 == 1 ? 1 : 0) - 1;
        //     for (; i >= 0; i--) {
        //         if (i + i+1 < n && isPalindrome(t.substring(0, i+i+2)))
        //             return new StringBuilder (t.substring(i+i+2)).reverse().toString() + t;
        //         if (isPalindrome(t.substring(0, i+i+1)))
        //             return new StringBuilder (t.substring(i+i+1)).reverse().toString() + t;
        //     }
        //     return null;
        // }
        // private boolean isPalindrome(String t) {
        //     int i = 0, j = t.length() - 1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }

        // public int[] maxSlidingWindow(int[] a, int k) { 
        //     int n = a.length, j = 0, max = Integer.MIN_VALUE, idx = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>(); // max deque: 单调递减
        //     int [] ans = new int [n-(k-1)];
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && s.peekFirst() <= i-k) s.pollFirst();
        //         while (!s.isEmpty() && a[s.peekLast()] <= a[i]) s.pollLast();
        //         s.offerLast(i);
        //         if (i >= k-1)
        //             ans[idx++] = a[s.peekFirst()];
        //     }
        //     return ans;
        // }

        // public List<String> removeInvalidParentheses(String t) { // 自己的乱代码
        //     n = t.length();
        //     s = t.toCharArray();
        //     left = 0;
        //     right = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == '(') left++;
        //         else if (s[i] == ')') {
        //             if (left > 0) left--;
        //             else right++;
        //         }
        //     }
        //     dfs(0, left, right, 0, 0, "");
        //     return new ArrayList<>(ans);
        // }
        // Set<String> ans = new HashSet<>();
        // char [] s;
        // int n, left, right;
        // private void dfs(int idx, int l, int r, int lcnt, int rcnt, String ss) {
        //     if (idx == n) {
        //         if (l == 0 && r == 0 && ss.length() == n-left-right) 
        //            ans.add(new String(ss));
        //         return ;
        //     }
        //     if (s[idx] != '(' && s[idx] != ')') dfs(idx+1, l, r, lcnt, rcnt, ss + s[idx]); // 不是左右括号的
        //     if (l > 0 && s[idx] == '(') dfs(idx+1, l-1, r, lcnt, rcnt, ss);
        //     if (r > 0 && s[idx] == ')') dfs(idx+1, l, r-1, lcnt, rcnt, ss);
        //     if (s[idx] == '(' || s[idx] == ')' && lcnt > rcnt)
        //         dfs(idx+1, l, r, lcnt + (s[idx] == '(' ? 1 : 0), rcnt+(s[idx] == ')' ? 1 : 0), ss + s[idx]);
        // }
        // public List<String> removeInvalidParentheses(String t) { // 参考网上大神的改进版
        //     int l = 0, r = 0;
        //     for (char c : t.toCharArray()) { // 这样就把代码写得很简洁
        //         l += (c == '(' ? 1 : 0);
        //         if (l == 0) r += (c == ')' ? 1 : 0);
        //         else l -= (c == ')' ? 1 : 0);
        //     }
        //     dfs(t, 0, l, r);
        //     return new ArrayList<>(ans);
        // }
        // Set<String> ans = new HashSet<>();
        // private void dfs(String s, int idx, int l, int r) {
        //     if (l == 0 && r == 0) {
        //         if (isValid(s)) ans.add(s);
        //         return ;
        //     }
        //     for (int i = idx; i < s.length(); i++) {
        //         if (i > idx && s.charAt(i) == s.charAt(i-1)) continue; // 狠重要： 对重复的处理：和前面的一样，前面已经删除过了，就不用再次这里删除了？？
        //         if (l > 0 && s.charAt(i) == '(')
        //             dfs(s.substring(0, i) + s.substring(i+1), i, l-1, r);
        //         if (r > 0 && s.charAt(i) == ')')
        //             dfs(s.substring(0, i) + s.substring(i+1), i, l, r-1);
        //     }
        // }
        // private boolean isValid(String t) {
        //     char [] s = t.toCharArray();
        //     int cnt = 0;
        //     for (int i = 0; i < t.length(); i++) {
        //         if (s[i] == '(') cnt++;
        //         else if (s[i] == ')' && --cnt < 0) return false;
        //     }
        //     return cnt == 0;
        // }
        // public List<String> removeInvalidParentheses(String t) { // 这个思路确实很精炒吧
        //     List<String> ans = new ArrayList<>();
        //     char [] s = t.toCharArray();
        //     Set<String> vis = new HashSet<>(List.of(t));
        //     Queue<String> q = new LinkedList<>();
        //     q.offer(t);
        //     boolean found = false;
        //     while (!q.isEmpty()) {
        //         String cur = q.poll();
        //         if (isValid(cur)) {
        //             found = true;
        //             ans.add(cur);
        //         }
        //         if (found) continue; // 如果已经是有效解，就不能再删除字符了
        //         for (int i = 0; i < cur.length(); i++) {
        //             if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
        //             String tmp = cur.substring(0, i) + cur.substring(i+1);
        //             if (!vis.contains(tmp)) {
        //                 q.offer(tmp);
        //                 vis.add(tmp);
        //             }
        //         }
        //     }
        //     return ans;
        // }
        // private boolean isValid(String t) {
        //     int cnt = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < t.length(); i++) 
        //         if (s[i] == '(') cnt++;
        //         else if (s[i] == ')' && --cnt < 0) return false;
        //     return cnt == 0;
        // }
        // public List<String> removeInvalidParentheses(String s) {
        //     List<String> ans = new ArrayList<>();
        //     Set<String> cur = new HashSet<>(List.of(s));
        //     while (!cur.isEmpty()) {
        //         Set<String> next = new HashSet<>();
        //         for (String v : cur) {
        //             if (isValid(v)) ans.add(v);
        //             if (!ans.isEmpty()) continue;
        //             for (int i = 0; i < v.length(); i++) {
        //                 if (v.charAt(i) != '(' && v.charAt(i) != ')') continue;
        //                 next.add(v.substring(0, i) + v.substring(i+1));
        //             }
        //         }
        //         if (!ans.isEmpty()) return ans;
        //         cur = next;
        //     }
        //     return ans;
        // }
        // private boolean isValid(String t) {
        //     int cnt = 0;
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < t.length(); i++) 
        //         if (s[i] == '(') cnt++;
        //         else if (s[i] == ')' && --cnt < 0) return false;
        //     return cnt == 0;
        // }
        // public List<String> removeInvalidParentheses(String s) { 
        //     helper(s, 0, 0, new char [] {'(', ')'});
        //     return ans;
        // }
        // List<String> ans = new ArrayList<>();
        // void helper(String s, int last_i, int last_j, char [] p) {
        //     int cnt = 0;
        //     for (int i = last_i; i < s.length(); i++) {
        //         if (s.charAt(i) == p[0]) ++cnt;
        //         else if (s.charAt(i) == p[1]) --cnt;
        //         if (cnt >= 0) continue; // 右括号没有多余，就不用管它，下一个
        //         for (int j = last_j; j <= i; j++) // 寻找i及其之前、自上一次删除位置开始、的第一个右括号
        //             if (s.charAt(j) == p[1] && (j == last_j || s.charAt(j) != s.charAt(j-1)))
        //                 helper(s.substring(0, j) + s.substring(j+1), i, j, p);
        //         return ; // 注意这个for循环结束后要直接返回，因为进这个for循环的都是右括号多的，删到最后最多是删成和左括号一样多，不需要再去翻转删左括号
        //     }
        //     String reverse = new StringBuilder (s).reverse().toString();
        //     if (p[0] == '(') helper(reverse, 0, 0, new char [] {')', '('});
        //     else ans.add(reverse);
        // }

        // public List<List<Integer>> palindromePairs(String[] sa) { // tle
        //     int n = sa.length;
        //     List<List<Integer>> ans = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if (isPalindrme(sa[i] + sa[j])) ans.add(List.of(i, j));
        //         }
        //     return ans;
        // }
        // boolean isPalindrme(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }
        // public List<List<Integer>> palindromePairs(String[] sa) { // 
        //     Set<List<Integer>> ans = new HashSet<>();
        //     Map<String, Integer> m = new HashMap<>();
        //     int n = sa.length;
        //     for (int i = 0; i < n; i++) m.put(sa[i], i);
        //     for (int i = 0; i < n; i++) { // 精简的写法
        //         String s = new StringBuilder (sa[i]).reverse().toString();
        //         for (int j = 0; j <= s.length(); j++) {
        //             String left = s.substring(0, j), right = s.substring(j);
        //             if (m.containsKey(left) && isPalindrme(right) && m.get(left) != i)
        //                 ans.add(List.of(m.get(left), i));
        //             if (m.containsKey(right) && isPalindrme(left) && m.get(right) != i)
        //                 ans.add(List.of(i, m.get(right)));
        //         }
        //     }
        //     // for (int j = 0; j < sa.length; j++) {
        //     //     String s = sa[j];
        //     //     for (int i = 1; i <= s.length(); i++) {
        //     //         if (isPalindrme(s.substring(0, i))) {
        //     //             String reverse = new StringBuilder (s.substring(i)).reverse().toString();
        //     //             if (m.containsKey(reverse) && m.get(reverse) != j) ans.add(List.of(m.get(reverse), j));
        //     //         }
        //     //         if (isPalindrme(s.substring(i))) {
        //     //             String reverse = new StringBuilder (s.substring(0, i)).reverse().toString();
        //     //             if (m.containsKey(reverse) && m.get(reverse) != j) ans.add(List.of(j, m.get(reverse)));
        //     //         }
        //     //     }
        //     //     if (s.length() > 0 && isPalindrme(s) && m.containsKey("")) { // 对“”空串的处理要特别小心
        //     //         ans.add(List.of(j, m.get("")));
        //     //         ans.add(List.of(m.get(""), j));
        //     //     }
        //     // }
        //     return new ArrayList<>(ans);
        // }
        // boolean isPalindrme(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }
        // private static class Trie { // bug, 思路还没有理对，todo
        //     private class Node {
        //         Node [] next;
        //         int index;
        //         List<Integer> list;
        //         public Node() {
        //             next = new Node[26];
        //             index = -1;
        //             list = new ArrayList<>();
        //         }
        //     }
        //     Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(String t, int idx) { // 插入当前单词的倒序
        //         char [] s = t.toCharArray();
        //         for (int i = s.length; i >= 0; i--) {
        //             int j = s[i] - 'a';
        //             if (root.next[j] == null)
        //                 root.
        //         }
        //     }            
        // }
    // https://leetcode.com/problems/palindrome-pairs/discuss/79195/O%28n        
        // public List<List<Integer>> palindromePairs(String[] words) { // 这里还没太看懂 336 palindrome pairs
        //     List<List<Integer>> res = new ArrayList<>();
        //     Node root = new Node();
        //     for (int i = 0; i < words.length; i++) 
        //         addWord(root, words[i], i);
        //     for (int i = 0; i < words.length; i++) 
        //         search(words, i, root, res);
        //     return res;
        // }
        // private void addWord(Node root, String word, int index) {
        //     for (int i = word.length() - 1; i >= 0; i--) {
        //         int j = word.charAt(i) - 'a';
        //         if (root.next[j] == null) 
        //             root.next[j] = new Node();
        //         if (isPalindrome(word, 0, i)) 
        //             root.list.add(index);
        //         root = root.next[j];
        //     }
        //     root.list.add(index);
        //     root.index = index;
        // }
        // private void search(String[] words, int i, Node root, List<List<Integer>> res) {
        //     for (int j = 0; j < words[i].length(); j++) {	
        //         if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) 
        //             res.add(Arrays.asList(i, root.index));
        //         root = root.next[words[i].charAt(j) - 'a'];
        //         if (root == null) return;
        //     }
        //     for (int j : root.list) {
        //         if (i == j) continue;
        //         res.add(Arrays.asList(i, j));
        //     }
        // }
        // private boolean isPalindrome(String word, int i, int j) {
        //     while (i < j) 
        //         if (word.charAt(i++) != word.charAt(j--)) return false;
        //     return true;
        // }

        // public boolean isRectangleCover(int[][] arr) {
        //     Set<String> s = new HashSet<>();
        //     int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, sum = 0;
        //     for (int [] a : arr) {
        //         i = Math.min(i, a[0]);
        //         j = Math.min(j, a[1]);
        //         x = Math.max(x, a[2]);
        //         y = Math.max(y, a[3]);
        //         sum += (a[2] - a[0]) * (a[3] - a[1]);
        //         String bl = a[0] + "-" + a[1], tl = a[2] + "-" + a[1];
        //         String br = a[0] + "-" + a[3], tr = a[2] + "-" + a[3];
        //         if (!s.contains(bl)) s.add(bl); else s.remove(bl);
        //         if (!s.contains(br)) s.add(br); else s.remove(br);
        //         if (!s.contains(tl)) s.add(tl); else s.remove(tl);
        //         if (!s.contains(tr)) s.add(tr); else s.remove(tr);
        //     }
        //     String a = i + "-" + j, b = i + "-" + y;
        //     String c = x + "-" + j, d = x + "-" + y;
        //     if (!s.contains(a) || !s.contains(b) || !s.contains(c) || !s.contains(d) || s.size() != 4)
        //         return false;
        //     return sum == (x - i) * (y - j);
        // }
        // public boolean isRectangleCover(int[][] arr) {
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int [] a : arr) 
        //         for (int i = 0; i < 4; i++) { // [0 1 2 3]四种类型的顶点，第个位置每个类型最多出现一次
        //             String cur = a[i / 2 * 2] + "-" + a[i % 2 * 2 + 1]; // 记录从左下角开始逆时针的四个顶点
        //             if ((m.getOrDefault(cur, 0) & (1 << i)) > 0) return false; // 同一形状、同一个角型出现了重叠
        //             m.put(cur, m.getOrDefault(cur, 0) | (1 << i));
        //         }
        //     int cnt = 0;
        //     for (Map.Entry<String, Integer> en : m.entrySet()) {
        //         int v = en.getValue();
        //         if ((v & (v-1)) == 0 && cnt++ > 4) return false; // 只出现一次的顶点最多只有四个
        //         // if ((v & (v-1)) > 0 && !(v == 15 || v == 10 || v == 12 || v == 5 || v == 3)) // 是test case太弱吗？检测不出来？
        //         if ((v & (v-1)) > 0 && !(v == 15 || v == 12 || v == 10 || v == 9 || v == 5 || v == 3)) // 所有合法的子集除外
        //             return false;
        //     }
        //     return true; // 所有的点都合法了，就不用检测面积了
        // }

        // public List<List<Integer>> getSkyline(int[][] a) { // O(NlogN)
        //     List<List<Integer>> ans = new ArrayList<>();
        //     Map<Integer, List<Integer>> m = new TreeMap<>(); // bug: TreeMap, 取其根据键的大小自动排序之意
        //     for (int [] v : a) {
        //         m.computeIfAbsent(v[0], z -> new ArrayList<>()).add(-v[2]);
        //         m.computeIfAbsent(v[1], z -> new ArrayList<>()).add(v[2]);
        //     }
        //     Map<Integer, Integer> his = new TreeMap<>((x, y)->y-x);
        //     int [] pre = {0, 0};
        //     for (Integer key : m.keySet()) { 
        //         List<Integer> ys = m.get(key);
        //         Collections.sort(ys);
        //         for (int y : ys) 
        //             if (y < 0)
        //                 his.put(-y, his.getOrDefault(-y, 0) + 1);
        //             else {
        //                 his.put(y, his.getOrDefault(y, 1) - 1);
        //                 if (his.get(y) == 0) his.remove(y);
        //             }
        //         Integer maxHiCur = 0;
        //         if (!his.isEmpty()) maxHiCur = his.keySet().iterator().next();
        //         if (pre[1] != maxHiCur) {
        //             pre[0] = key;
        //             pre[1] = maxHiCur;
        //             // ans.add(List.of(key, maxHiCur));
        //             ans.add(Arrays.asList(key, maxHiCur));
        //         }
        //     }
        //     return ans;
        // }
        // public List<List<Integer>> getSkyline(int[][] a) {
        //     List<Integer> pos = new ArrayList<>();
        //     for (int [] b : a) {
        //         pos.add(b[0]);
        //         pos.add(b[1]);
        //     }
        //     Collections.sort(pos);
        //     List<List<Integer>> ans = new ArrayList<>();
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        //     int n = a.length, idx = 0;
        //     for (int v : pos) {
        //         while (idx < n && a[idx][0] <= v) {
        //             q.offer(new int [] {a[idx][1], a[idx][2]});
        //             idx++;
        //         }
        //         while (!q.isEmpty() && q.peek()[0] <= v) q.poll();
        //         int maxHiCur = q.isEmpty() ? 0 : q.peek()[1];
        //         if (ans.size() == 0 || maxHiCur != ans.get(ans.size()-1).get(1))
        //             ans.add(Arrays.asList(v, maxHiCur));
        //     }
        //     return ans;
        // }
        // public List<List<Integer>> getSkyline(int[][] buildings) {
        //     List<List<Integer>> ans = new ArrayList<>();
        //     List<int[]> hite = new ArrayList<>();
        //     for (int [] v : buildings) {
        //         hite.add(new int [] {v[0], v[2]});
        //         hite.add(new int [] {v[1], -v[2]});
        //     }
        //     Collections.sort(hite, (a, b)-> b[0] != a[0] ? a[0] - b[0] : b[1] - a[1]);
        //     Queue<Integer> q = new PriorityQueue<>((a, b)-> b - a);
        //     q.offer(0);
        //     int cur = 0, pre = 0;
        //     for (int [] h : hite) {
        //         if (h[1] > 0) q.offer(h[1]);
        //         else q.remove(-h[1]);
        //         cur = q.peek();
        //         if (pre != cur) {
        //             ans.add(List.of(h[0], cur));
        //             pre = cur;
        //         }
        //     }
        //     return ans;
        // }
        // public List<List<Integer>> getSkyline(int[][] buildings) { // todo; divide and conque代码被我改乱了
        //     return merge(buildings, 0, buildings.length-1);        // 今天这个题看累了，改天再补这个
        // }
        // private List<List<Integer>> merge(int[][] buildings, int lo, int hi) {
        //     List<List<Integer>> res = new LinkedList<>();
        //     if (lo > hi) {
        //         return res;
        //     } else if (lo == hi) {
        //         res.add(List.of(buildings[lo][0], buildings[lo][2]));
        //         res.add(List.of(buildings[lo][1], 0));
        //         return res;
        //     } 
        //     int mid = lo+(hi-lo)/2;
        //     List<List<Integer>> left = merge(buildings, lo, mid);
        //     List<List<Integer>> right = merge(buildings, mid+1, hi);
        //     int leftH = 0, rightH = 0;
        //     while(!left.isEmpty() || !right.isEmpty()) {
        //         long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
        //         long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
        //         int x = 0;
        //         if(x1 < x2) {
        //             int[] temp = left.pollFirst();
        //             x = temp[0];
        //             leftH = temp[1];
        //         } else if(x1 > x2) {
        //             int[] temp = right.pollFirst();
        //             x = temp[0];
        //             rightH = temp[1];
        //         } else {
        //             x = left.peekFirst()[0];
        //             leftH = left.pollFirst()[1];
        //             rightH = right.pollFirst()[1];
        //         }
        //         int h = Math.max(leftH, rightH);
        //         if(res.isEmpty() || h != res.peekLast()[1])
        //             res.add(List.of(x, h));
        //     }
        //     return res;
        // }

        // public List<String> findItinerary(List<List<String>> tickets) {
        //     for (List<String> t : tickets) 
        //         m.computeIfAbsent(t.get(0), z -> new PriorityQueue<>()).offer(t.get(1));
        //     List<String> ans = new ArrayList<>();
        //     dfs("JFK", ans);
        //     Collections.reverse(ans);
        //     return ans;
        // }
        // Map<String, PriorityQueue<String>> m = new HashMap<>(); // PriorityQueue: 这里面有一个自动升序排序功能
        // void dfs(String s, List<String> l) {
        //     Queue<String> next = m.get(s);
        //     while (next != null && next.size() > 0)
        //         dfs(next.poll(), l);
        //     l.add(s);
        // }
        // public List<String> findItinerary(String[][] tickets) {
        //     LinkedList<String> ans = new LinkedList<>();
        //     for (String[] t : tickets)
        //         map.computeIfAbsent(t.get(0), z -> new ArrayList<>()).offer(t.get(1));
        //     dfs("JFK", ans);
        //     return new ArrayList<String>(ans); // LinkedList最后需要转换成ArrayList
        // }
        // HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        // void dfs(String airport, LinkedList<String> list) {
        //     while (map.containsKey(airport) && !map.get(airport).isEmpty())
        //         dfs(map.get(airport).poll(), l);
        //     list.offerFirst(airport); // LinkedList可以这么写
        // }
        // public List<String> findItinerary(List<List<String>> tickets) { // todo: 这个算法还比较陌生
        //     for (List<String> t : tickets) 
        //         adj.computeIfAbsent(t.get(0), z -> new ArrayList<>()).add(t.get(1));
        //     for (List<String> values : adj.values()) Collections.sort(values);
        //     String u = "JFK";
        //     ans.add(u);
        //     fleuryProcess(u);
        //     return ans;
        // }
        // Map<String, List<String>> adj = new HashMap<>();
        // List<String> ans = new ArrayList<>();
        // private void fleuryProcess(String u) {
        //     if (!adj.containsKey(u)) return ;
        //     for (int i = 0; i < adj.get(u).size(); i++) {
        //         String v = adj.get(u).get(i);
        //         if (isValidNextEdge(u, v)) {
        //             ans.add(v);
        //             adj.get(u).remove(v);
        //             fleuryProcess(v);
        //         }
        //     }
        // }
        // private boolean isValidNextEdge(String u, String v) {
        //     if (adj.get(u).size() == 1) return true;
        //     Map<String, Boolean> vis = new HashMap<>(); // vis: visited
        //     int cnt1 = dfs(u, vis);
        //     adj.get(u).remove(v);
        //     vis.clear(); 
        //     int cnt2 = dfs(v, vis);
        //     adj.get(u).add(0, v);
        //     return cnt1 <= cnt2; // 这里比较未访问节点个数
        // }
        // private int dfs(String u, Map<String, Boolean> vis) {
        //     vis.put(u, true);
        //     int cnt = 1;
        //     if (adj.containsKey(u)) 
        //         for (String v : adj.get(u)) 
        //             if (vis.get(v) == null || (vis.get(v) != null && !vis.get(v))) 
        //                 cnt += dfs(v, vis);
        //     return cnt;
        // }

        // public String crackSafe(int n, int k) {
        //     N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
        //     s = new StringBuilder ("0".repeat(n));
        //     Set<String> ss = new HashSet<>(List.of(s.toString()));
        //     dfs(ss, n, k);
        //     return s.toString();
        // }
        // StringBuilder s;
        // int N;
        // boolean dfs(Set<String> ss, int n, int k) { // dfs backtracking 的思路，代码比较繁琐
        //     if (ss.size() == N) return true; // 如果已经遍历了所有的状态，相当于走完了回路，必定有某种状态可以开锁？
        //     String pre = s.substring(s.length() - (n-1));
        //     for (int i = 0; i < k; i++) {
        //         String cur = pre + i;
        //         if (ss.contains(cur)) continue;
        //         s.append(i + "");
        //         ss.add(cur);
        //         if (dfs(ss, n, k)) return true;
        //         s.deleteCharAt(s.length()-1);
        //         ss.remove(cur);
        //     }
        //     return false;
        // }
        // public String crackSafe(int n, int k) {
        //     int N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
        //     String s = "0".repeat(n);
        //     Set<String> ss = new HashSet<>(List.of(s.toString()));
        //     for (int i = 0; i < N; i++) {
        //         String pre = s.substring(s.length() - (n-1));
        //         // for (int j = 0; j < k; j++) { // 这里需要倒回来
        //         for (int j = k-1; j >= 0; j--) { 
        //             String cur = pre + String.valueOf(j);
        //             if (!ss.contains(cur)) {
        //                 ss.add(cur);
        //                 s += "" + j;
        //                 break;
        //             }
        //         }
        //     }
        //     return s;
        // }
        // public String crackSafe(int n, int k) {
        //     N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
        //     s = "0".repeat(n);
        //     Set<String> ss = new HashSet<>(List.of(s.toString()));
        //     dfs(ss, n, k);
        //     return s;
        // }
        // String s;
        // int N;
        // void dfs(Set<String> ss, int n, int k) {
        //     if (ss.size() == N) return; 
        //     String pre = s.substring(s.length() - (n-1));
        //     for (int i = k-1; i >= 0; i--) {
        //         String cur = pre + i;
        //         if (ss.contains(cur)) continue;
        //         s += "" + i;
        //         ss.add(cur);
        //         dfs(ss, n, k);
        //     }
        // }
        // public String crackSafe(int n, int k) {
        //     highest = (int) Math.pow(10, n - 1);
        //     this.k = k;
        //     dfs(0);
        //     return ans + "0".repeat(n-1);
        // }
        // Set<Integer> vis = new HashSet<Integer>();
        // StringBuffer ans = new StringBuffer();
        // int highest;
        // int k;
        // public void dfs(int node) {
        //     for (int i = 0; i < k; i++) {
        //         int next = node * 10 + i;
        //         if (!vis.contains(next)) {
        //             vis.add(next);
        //             dfs(next % highest);
        //             ans.append(i); // 这里dfs之后才添加的顺序狠重要
        //         }
        //     }
        // }

        // public int minCost(int[][] g) {
        //     int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
        //     int m = g.length, n = g[0].length;
        //     int [][] d = new int [m][n]; // dist to [0, 0]
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(d[i], Integer.MAX_VALUE);
        //     d[0][0] = 0;
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {0, 0});
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int i = cur[0], j = cur[1];
        //         for (int k = 1; k < 5; k++) {
        //             int x = i + dirs[k][0], y = j + dirs[k][1];
        //             if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //             int newDist = d[i][j] + (k == g[i][j] ? 0 : 1);
        //             if (newDist < d[x][y]) {
        //                 d[x][y] = newDist;
        //                 q.offer(new int [] {x, y});
        //             }
        //         }
        //     }
        //     return d[m-1][n-1];
        // }
        // public int minCost(int[][] g) {
        //     int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
        //     int m = g.length, n = g[0].length;
        //     int [][] d = new int [m][n]; 
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(d[i], Integer.MAX_VALUE);
        //     d[0][0] = 0;
        //     boolean [][] in = new boolean [m][n];
        //     Queue<int []> q = new LinkedList<>();
        //     q.offer(new int [] {0, 0});
        //     in[0][0] = true;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int i = cur[0], j = cur[1];
        //         in[i][j] = false;
        //         for (int k = 1; k < 5; k++) {
        //             int x = i + dirs[k][0], y = j + dirs[k][1];
        //             if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //             int newDist = d[i][j] + (k == g[i][j] ? 0 : 1);
        //             if (newDist < d[x][y]) {
        //                 d[x][y] = newDist;
        //                 if (!in[x][y]) {
        //                     q.offer(new int [] {x, y});
        //                     in[x][y] = true;
        //                 }
        //             }
        //         }
        //     }
        //     return d[m-1][n-1];
        // }
        // public int minCost(int[][] g) {
        //     int m = g.length, n = g[0].length;
        //     int [][] d = new int [m][n]; // dist to [0, 0]
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(d[i], Integer.MAX_VALUE);
        //     d[0][0] = 0;
        //     int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // [0, 1, 2, 3, 4]
        //     boolean [][] vis = new boolean [m][n];
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     q.offerFirst(0);
        //     while (!q.isEmpty()) {
        //         int idx = q.pollFirst();
        //         int i = idx / n, j = idx % n;
        //         if (vis[i][j]) continue;
        //         if (i == m-1 && j == n-1) return d[i][j]; // 终点第一次出队的时候，dist里存的就是最短路距离
        //         vis[i][j] = true;
        //         for (int k = 1; k < 5; k++) {
        //             int x = i + dirs[k][0], y = j + dirs[k][1];
        //             if (x < 0 || x >= m || y < 0 || y >= n) continue;
        //             int cost = k == g[i][j] ? 0 : 1;
        //             if (!vis[x][y] && d[x][y] > d[i][j] + cost) {
        //                 d[x][y] = d[i][j] + cost;
        //                 if (cost == 0) q.offerFirst(x * n + y);
        //                 else q.offerLast(x * n + y);
        //             }
        //         }
        //     }
        //     return -1;
        // }

        // public int minSwapsCouples(int[] a) {
        //     int n = a.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 1; i <= n/2; i++) {
        //         m.put(2 * i - 2, 2 * i - 1);
        //         m.put(2 * i - 1, 2 * i - 2);
        //     }
        //     int cnt = 0, tmp = 0;
        //     for (int i = 1; i < n; i += 2) 
        //         if (a[i] != m.get(a[i-1])) {
        //             for (int j = 0; j < n; j++) 
        //                 if (a[j] == m.get(a[i-1])) {
        //                     tmp = a[i];
        //                     a[i] = a[j];
        //                     a[j] = tmp;
        //                     break;
        //                 }
        //             cnt++;
        //         }
        //     return cnt;
        // }

        // public boolean isPrintable(int[][] a) { 
        //     int m = a.length, n = a[0].length, max = Math.max(m, n);
        //     for (int i = 0; i < m; i++)
        //         max = Math.max(max, Arrays.stream(a[i]).max().getAsInt());
        //     int N = max + 1;
        //     int [] up = new int [N], down = new int [N], left = new int [N], right = new int [N];
        //     Arrays.fill(up, m);
        //     Arrays.fill(left, n);
        //     Arrays.fill(down, -1);
        //     Arrays.fill(right, -1);
        //     for (int i = 0; i < m; i++) // 界定每一种着色的上下左右边界，以便接下来排序
        //         for (int j = 0; j < n; j++) {
        //             int k = a[i][j];
        //             up[k] = Math.min(up[k], i);
        //             down[k] = Math.max(down[k], i);
        //             left[k] = Math.min(left[k], j);
        //             right[k] = Math.max(right[k], j);
        //         }
        //     // 根据每种着色的界定范围，建立拓扑排序：这后半部分还有点儿不熟练
        //     // 当前位置颜色 cur 在某个矩阵 k 中但是不为矩阵 k 的颜色时，建立从 k 到 cur 的边，cur 可以存在于多个矩阵中
        //     boolean [][] nei = new boolean [N][N];  // neighbours
        //     List<Integer>[] adj = new ArrayList[N]; // 邻接有向图：按照染色的先后顺序
        //     int [] ins = new int [N];
        //     for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) {
        //             int cur = a[i][j]; // 当前格的最终打印着色
        //             for (int k = 1; k < N; k++) { // 遍历所有的着色：暴搜当前着色cur是否会在某种着色k之后染色
        //                 if (k == cur) continue;
        //                 if (i >= up[k] && i <= down[k] && j >= left[k] && j <= right[k])  // 现着色cur完全处于先前染色k的内部，所以cur是后着色
        //                     // if (!nei[cur][k]) { // BUG: 是有向图：这里顺序很重要，先染色 是否 与后染色相连/相前后
        //                     if (!nei[k][cur]) {    // k 先染后， cur 后染色
        //                         adj[k].add(cur);
        //                         ins[cur]++;
        //                         nei[k][cur] = true;
        //                     }
        //             }
        //         }
        //     List<Integer> l = new ArrayList<>();
        //     while (true) { // 寻找入度为 0 的颜色点，减小该点连结的点的入度，直到所有点的入度都为 0
        //         int i;
        //         for (i = 1; i < N; i++) 
        //             if (ins[i] == 0) {
        //                 l.add(i);
        //                 for (int v : adj[i]) ins[v]--;
        //                 ins[i] = -1;
        //                 break;
        //             }
        //         if (i == N) break;
        //     }
        //     return l.size() == max; // 按照拓扑排序，这所有的染色都可以有序地染出来，那么合法
        // }
        public boolean isPrintable(int[][] a) { 
            int m = a.length, n = a[0].length;
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++)
                    col.add(a[i][j]);
            for (Integer c : col) {
                int fi = -1, fj = Integer.MAX_VALUE, li = -1, lj = -1;  // f: first, f row, f col, l: last, l row, l col
                for (int i = 0; i < m; i++)
                    for (int j = 0; j < n; j++)
                        if (a[i][j] == c) {
                            if (fi == -1) fi = i; // 只记最早出现的第一次
                            fj = Math.min(fj, j);
                            li = i;
                            lj = Math.max(lj, j);
                        }
                for (int i = fi; i <= li; i++) 
                    for (int j = fj; j <= lj; j++) 
                        if (a[i][j] != c) // a[i][j]是会在当前染色c之后染色的
                            adj.computeIfAbsent(c, z -> new HashSet<>()).add(a[i][j]);
            }
            Set<Integer> vis = new HashSet<>(); // visiting: 只保证先染的着色不会在后染的着色里再次出现
            for (Integer c : col) 
                if (!topologicalSort(vis, c)) return false;
            return true;
        }
        Map<Integer, Set<Integer>> adj = new HashMap<>(); // 在key之后染色的着色集合
        private boolean topologicalSort(Set<Integer> vis, int c) { // 这种写法好陌生
            if (vis.contains(c)) return false;
            vis.add(c);
            for (Integer nei : adj.getOrDefault(c, Collections.emptySet()))
                if (!topologicalSort(vis, nei)) return false;
            vis.remove(c);
            return true;
        }
   }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,1,1,1},{1,2,2,1},{1,2,2,1},{1,1,1,1}};
        // int [][] a = new int [][] {{1,2,1},{2,1,2},{1,2,1}};
        int [][] a = new int [][] {{1,1,1,1},{1,2,2,1},{1,2,2,1},{1,1,1,1}};

        boolean r = s.isPrintable(a);
        System.out.println("r: " + r);
    }
}
