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

        public List<String> addOperators(String num, int target) {
            
        }
   }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        List<List<Integer>> r = s.getSkyline(a);
        System.out.println("r.size(): " + r.size());
        for (int z = 0; z < r.size(); ++z) 
            System.out.println(Arrays.toString(r.get(z).toArray()));
        
    }
}
