// import com.UnionFind;

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

        public String shortestPalindrome(String t) { // tle 
            if (t.chars().distinct().count() == 1) return t;
            if (isPalindrome(t)) return t;
            int n = t.length();
            int i = n / 2 + (n % 2 == 1 ? 1 : 0) - 1;
            for (; i >= 0; i--) {
                if (i + i+1 < n && isPalindrome(t.substring(0, i+i+2)))
                    return new StringBuilder (t.substring(i+i+2)).reverse().toString() + t;
                if (isPalindrome(t.substring(0, i+i+1)))
                    return new StringBuilder (t.substring(i+i+1)).reverse().toString() + t;
            }
            return null;
        }
        private boolean isPalindrome(String t) {
            int i = 0, j = t.length() - 1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }

        public int[] maxSlidingWindow(int[] a, int k) { 
            int n = a.length, j = 0, max = Integer.MIN_VALUE, idx = 0;
            ArrayDeque<Integer> s = new ArrayDeque<>(); // max deque: 单调递减
            int [] ans = new int [n-(k-1)];
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && s.peekFirst() <= i-k) s.pollFirst();
                while (!s.isEmpty() && a[s.peekLast()] <= a[i]) s.pollLast();
                s.offerLast(i);
                if (i >= k-1)
                    ans[idx++] = a[s.peekFirst()];
            }
            return ans;
        }

        public List<String> removeInvalidParentheses(String t) { // 自己的乱代码
            n = t.length();
            s = t.toCharArray();
            left = 0;
            right = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == '(') left++;
                else if (s[i] == ')') {
                    if (left > 0) left--;
                    else right++;
                }
            }
            dfs(0, left, right, 0, 0, "");
            return new ArrayList<>(ans);
        }
        Set<String> ans = new HashSet<>();
        char [] s;
        int n, left, right;
        private void dfs(int idx, int l, int r, int lcnt, int rcnt, String ss) {
            if (idx == n) {
                if (l == 0 && r == 0 && ss.length() == n-left-right) 
                   ans.add(new String(ss));
                return ;
            }
            if (s[idx] != '(' && s[idx] != ')') dfs(idx+1, l, r, lcnt, rcnt, ss + s[idx]); // 不是左右括号的
            if (l > 0 && s[idx] == '(') dfs(idx+1, l-1, r, lcnt, rcnt, ss);
            if (r > 0 && s[idx] == ')') dfs(idx+1, l, r-1, lcnt, rcnt, ss);
            if (s[idx] == '(' || s[idx] == ')' && lcnt > rcnt)
                dfs(idx+1, l, r, lcnt + (s[idx] == '(' ? 1 : 0), rcnt+(s[idx] == ')' ? 1 : 0), ss + s[idx]);
        }
        public List<String> removeInvalidParentheses(String t) { // 参考网上大神的改进版
            int l = 0, r = 0;
            for (char c : t.toCharArray()) { // 这样就把代码写得很简洁
                l += (c == '(' ? 1 : 0);
                if (l == 0) r += (c == ')' ? 1 : 0);
                else l -= (c == ')' ? 1 : 0);
            }
            dfs(t, 0, l, r);
            return new ArrayList<>(ans);
        }
        Set<String> ans = new HashSet<>();
        private void dfs(String s, int idx, int l, int r) {
            if (l == 0 && r == 0) {
                if (isValid(s)) ans.add(s);
                return ;
            }
            for (int i = idx; i < s.length(); i++) {
                if (i > idx && s.charAt(i) == s.charAt(i-1)) continue; // 狠重要： 对重复的处理：和前面的一样，前面已经删除过了，就不用再次这里删除了??
                if (l > 0 && s.charAt(i) == '(')
                    dfs(s.substring(0, i) + s.substring(i+1), i, l-1, r);
                if (r > 0 && s.charAt(i) == ')')
                    dfs(s.substring(0, i) + s.substring(i+1), i, l, r-1);
            }
        }
        private boolean isValid(String t) {
            char [] s = t.toCharArray();
            int cnt = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s[i] == '(') cnt++;
                else if (s[i] == ')' && --cnt < 0) return false;
            }
            return cnt == 0;
        }
        public List<String> removeInvalidParentheses(String t) { // 这个思路确实很精炒吧
            List<String> ans = new ArrayList<>();
            char [] s = t.toCharArray();
            Set<String> vis = new HashSet<>(List.of(t));
            Queue<String> q = new LinkedList<>();
            q.offer(t);
            boolean found = false;
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (isValid(cur)) {
                    found = true;
                    ans.add(cur);
                }
                if (found) continue; // 如果已经是有效解，就不能再删除字符了
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                    String tmp = cur.substring(0, i) + cur.substring(i+1);
                    if (!vis.contains(tmp)) {
                        q.offer(tmp);
                        vis.add(tmp);
                    }
                }
            }
            return ans;
        }
        private boolean isValid(String t) {
            int cnt = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < t.length(); i++) 
                if (s[i] == '(') cnt++;
                else if (s[i] == ')' && --cnt < 0) return false;
            return cnt == 0;
        }
        public List<String> removeInvalidParentheses(String s) {
            List<String> ans = new ArrayList<>();
            Set<String> cur = new HashSet<>(List.of(s));
            while (!cur.isEmpty()) {
                Set<String> next = new HashSet<>();
                for (String v : cur) {
                    if (isValid(v)) ans.add(v);
                    if (!ans.isEmpty()) continue;
                    for (int i = 0; i < v.length(); i++) {
                        if (v.charAt(i) != '(' && v.charAt(i) != ')') continue;
                        next.add(v.substring(0, i) + v.substring(i+1));
                    }
                }
                if (!ans.isEmpty()) return ans;
                cur = next;
            }
            return ans;
        }
        private boolean isValid(String t) {
            int cnt = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < t.length(); i++) 
                if (s[i] == '(') cnt++;
                else if (s[i] == ')' && --cnt < 0) return false;
            return cnt == 0;
        }
        public List<String> removeInvalidParentheses(String s) { 
            helper(s, 0, 0, new char [] {'(', ')'});
            return ans;
        }
        List<String> ans = new ArrayList<>();
        void helper(String s, int last_i, int last_j, char [] p) {
            int cnt = 0;
            for (int i = last_i; i < s.length(); i++) {
                if (s.charAt(i) == p[0]) ++cnt;
                else if (s.charAt(i) == p[1]) --cnt;
                if (cnt >= 0) continue; // 右括号没有多余，就不用管它，下一个
                for (int j = last_j; j <= i; j++) // 寻找i及其之前、自上一次删除位置开始、的第一个右括号
                    if (s.charAt(j) == p[1] && (j == last_j || s.charAt(j) != s.charAt(j-1)))
                        helper(s.substring(0, j) + s.substring(j+1), i, j, p);
                return ; // 注意这个for循环结束后要直接返回，因为进这个for循环的都是右括号多的，删到最后最多是删成和左括号一样多，不需要再去翻转删左括号
            }
            String reverse = new StringBuilder (s).reverse().toString();
            if (p[0] == '(') helper(reverse, 0, 0, new char [] {')', '('});
            else ans.add(reverse);
        }

        public List<List<Integer>> palindromePairs(String[] sa) { // tle
            int n = sa.length;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                    if (j == i) continue;
                    if (isPalindrme(sa[i] + sa[j])) ans.add(List.of(i, j));
                }
            return ans;
        }
        boolean isPalindrme(String t) {
            int n = t.length(), i = 0, j = n-1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }
        public List<List<Integer>> palindromePairs(String[] sa) { // 
            Set<List<Integer>> ans = new HashSet<>();
            Map<String, Integer> m = new HashMap<>();
            int n = sa.length;
            for (int i = 0; i < n; i++) m.put(sa[i], i);
            for (int i = 0; i < n; i++) { // 精简的写法
                String s = new StringBuilder (sa[i]).reverse().toString();
                for (int j = 0; j <= s.length(); j++) {
                    String left = s.substring(0, j), right = s.substring(j);
                    if (m.containsKey(left) && isPalindrme(right) && m.get(left) != i)
                        ans.add(List.of(m.get(left), i));
                    if (m.containsKey(right) && isPalindrme(left) && m.get(right) != i)
                        ans.add(List.of(i, m.get(right)));
                }
            }
            // for (int j = 0; j < sa.length; j++) {
            //     String s = sa[j];
            //     for (int i = 1; i <= s.length(); i++) {
            //         if (isPalindrme(s.substring(0, i))) {
            //             String reverse = new StringBuilder (s.substring(i)).reverse().toString();
            //             if (m.containsKey(reverse) && m.get(reverse) != j) ans.add(List.of(m.get(reverse), j));
            //         }
            //         if (isPalindrme(s.substring(i))) {
            //             String reverse = new StringBuilder (s.substring(0, i)).reverse().toString();
            //             if (m.containsKey(reverse) && m.get(reverse) != j) ans.add(List.of(j, m.get(reverse)));
            //         }
            //     }
            //     if (s.length() > 0 && isPalindrme(s) && m.containsKey("")) { // 对“”空串的处理要特别小心
            //         ans.add(List.of(j, m.get("")));
            //         ans.add(List.of(m.get(""), j));
            //     }
            // }
            return new ArrayList<>(ans);
        }
        boolean isPalindrme(String t) {
            int n = t.length(), i = 0, j = n-1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }
        private static class Trie { // bug, 思路还没有理对，todo
            private class Node {
                Node [] next;
                int index;
                List<Integer> list;
                public Node() {
                    next = new Node[26];
                    index = -1;
                    list = new ArrayList<>();
                }
            }
            Node root;
            public Trie() {
                root = new Node();
            }
            public void insert(String t, int idx) { // 插入当前单词的倒序
                char [] s = t.toCharArray();
                for (int i = s.length; i >= 0; i--) {
                    int j = s[i] - 'a';
                    if (root.next[j] == null)
                        root.
                }
            }            
        }
    // https://leetcode.com/problems/palindrome-pairs/discuss/79195/O%28n        
        public List<List<Integer>> palindromePairs(String[] words) { // 这里还没太看懂 336 palindrome pairs
            List<List<Integer>> res = new ArrayList<>();
            Node root = new Node();
            for (int i = 0; i < words.length; i++) 
                addWord(root, words[i], i);
            for (int i = 0; i < words.length; i++) 
                search(words, i, root, res);
            return res;
        }
        private void addWord(Node root, String word, int index) {
            for (int i = word.length() - 1; i >= 0; i--) {
                int j = word.charAt(i) - 'a';
                if (root.next[j] == null) 
                    root.next[j] = new Node();
                if (isPalindrome(word, 0, i)) 
                    root.list.add(index);
                root = root.next[j];
            }
            root.list.add(index);
            root.index = index;
        }
        private void search(String[] words, int i, Node root, List<List<Integer>> res) {
            for (int j = 0; j < words[i].length(); j++) {	
                if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) 
                    res.add(Arrays.asList(i, root.index));
                root = root.next[words[i].charAt(j) - 'a'];
                if (root == null) return;
            }
            for (int j : root.list) {
                if (i == j) continue;
                res.add(Arrays.asList(i, j));
            }
        }
        private boolean isPalindrome(String word, int i, int j) {
            while (i < j) 
                if (word.charAt(i++) != word.charAt(j--)) return false;
            return true;
        }

        public boolean isRectangleCover(int[][] arr) {
            Set<String> s = new HashSet<>();
            int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, sum = 0;
            for (int [] a : arr) {
                i = Math.min(i, a[0]);
                j = Math.min(j, a[1]);
                x = Math.max(x, a[2]);
                y = Math.max(y, a[3]);
                sum += (a[2] - a[0]) * (a[3] - a[1]);
                String bl = a[0] + "-" + a[1], tl = a[2] + "-" + a[1];
                String br = a[0] + "-" + a[3], tr = a[2] + "-" + a[3];
                if (!s.contains(bl)) s.add(bl); else s.remove(bl);
                if (!s.contains(br)) s.add(br); else s.remove(br);
                if (!s.contains(tl)) s.add(tl); else s.remove(tl);
                if (!s.contains(tr)) s.add(tr); else s.remove(tr);
            }
            String a = i + "-" + j, b = i + "-" + y;
            String c = x + "-" + j, d = x + "-" + y;
            if (!s.contains(a) || !s.contains(b) || !s.contains(c) || !s.contains(d) || s.size() != 4)
                return false;
            return sum == (x - i) * (y - j);
        }
        public boolean isRectangleCover(int[][] arr) {
            Map<String, Integer> m = new HashMap<>();
            for (int [] a : arr) 
                for (int i = 0; i < 4; i++) { // [0 1 2 3]四种类型的顶点，第个位置每个类型最多出现一次
                    String cur = a[i / 2 * 2] + "-" + a[i % 2 * 2 + 1]; // 记录从左下角开始逆时针的四个顶点
                    if ((m.getOrDefault(cur, 0) & (1 << i)) > 0) return false; // 同一形状、同一个角型出现了重叠
                    m.put(cur, m.getOrDefault(cur, 0) | (1 << i));
                }
            int cnt = 0;
            for (Map.Entry<String, Integer> en : m.entrySet()) {
                int v = en.getValue();
                if ((v & (v-1)) == 0 && cnt++ > 4) return false; // 只出现一次的顶点最多只有四个
                // if ((v & (v-1)) > 0 && !(v == 15 || v == 10 || v == 12 || v == 5 || v == 3)) // 是test case太弱吗？检测不出来？这样的test case不好设置？
                if ((v & (v-1)) > 0 && !(v == 15 || v == 12 || v == 10 || v == 9 || v == 5 || v == 3)) // 所有合法的子集除外
                    return false;
            }
            return true; // 所有的点都合法了，就不用检测面积了
        }

        public List<List<Integer>> getSkyline(int[][] a) { // O(NlogN)
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Integer>> m = new TreeMap<>(); // bug: TreeMap, 取其根据键的大小自动排序之意, 取得每个操作都在O(logN)的复杂度
            for (int [] v : a) {
                m.computeIfAbsent(v[0], z -> new ArrayList<>()).add(-v[2]);
                m.computeIfAbsent(v[1], z -> new ArrayList<>()).add(v[2]);
            }
            Map<Integer, Integer> his = new TreeMap<>((x, y)->y-x);
            int [] pre = {0, 0};
            for (Integer key : m.keySet()) { 
                List<Integer> ys = m.get(key);
                Collections.sort(ys);
                for (int y : ys) 
                    if (y < 0)
                        his.put(-y, his.getOrDefault(-y, 0) + 1);
                    else {
                        his.put(y, his.getOrDefault(y, 1) - 1);
                        if (his.get(y) == 0) his.remove(y);
                    }
                Integer maxHiCur = 0;
                if (!his.isEmpty()) maxHiCur = his.keySet().iterator().next();
                if (pre[1] != maxHiCur) {
                    pre[0] = key;
                    pre[1] = maxHiCur;
                    // ans.add(List.of(key, maxHiCur)); // 效果都一样
                    ans.add(Arrays.asList(key, maxHiCur));
                }
            }
            return ans;
        }
        public List<List<Integer>> getSkyline(int[][] a) {
            List<Integer> pos = new ArrayList<>();
            for (int [] b : a) {
                pos.add(b[0]);
                pos.add(b[1]);
            }
            Collections.sort(pos);
            List<List<Integer>> ans = new ArrayList<>();
            Queue<int []> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
            int n = a.length, idx = 0;
            for (int v : pos) {
                while (idx < n && a[idx][0] <= v) {
                    q.offer(new int [] {a[idx][1], a[idx][2]});
                    idx++;
                }
                while (!q.isEmpty() && q.peek()[0] <= v) q.poll();
                int maxHiCur = q.isEmpty() ? 0 : q.peek()[1];
                if (ans.size() == 0 || maxHiCur != ans.get(ans.size()-1).get(1))
                    ans.add(Arrays.asList(v, maxHiCur));
            }
            return ans;
        }
        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();
            List<int[]> hite = new ArrayList<>();
            for (int [] v : buildings) {
                hite.add(new int [] {v[0], v[2]});
                hite.add(new int [] {v[1], -v[2]});
            }
            Collections.sort(hite, (a, b)-> b[0] != a[0] ? a[0] - b[0] : b[1] - a[1]);
            Queue<Integer> q = new PriorityQueue<>((a, b)-> b - a);
            q.offer(0);
            int cur = 0, pre = 0;
            for (int [] h : hite) {
                if (h[1] > 0) q.offer(h[1]);
                else q.remove(-h[1]);
                cur = q.peek();
                if (pre != cur) {
                    ans.add(List.of(h[0], cur));
                    pre = cur;
                }
            }
            return ans;
        }
        public List<List<Integer>> getSkyline(int[][] buildings) { // todo; divide and conque代码被我改乱了，bug
            return merge(buildings, 0, buildings.length-1);        // 今天这个题看累了，改天再补这个
        }
        private List<List<Integer>> merge(int[][] buildings, int lo, int hi) {
            List<List<Integer>> res = new LinkedList<>();
            if (lo > hi) {
                return res;
            } else if (lo == hi) {
                res.add(List.of(buildings[lo][0], buildings[lo][2]));
                res.add(List.of(buildings[lo][1], 0));
                return res;
            } 
            int mid = lo+(hi-lo)/2;
            List<List<Integer>> left = merge(buildings, lo, mid);
            List<List<Integer>> right = merge(buildings, mid+1, hi);
            int leftH = 0, rightH = 0;
            while(!left.isEmpty() || !right.isEmpty()) {
                long x1 = left.isEmpty()? Long.MAX_VALUE: left.peekFirst()[0];
                long x2 = right.isEmpty()? Long.MAX_VALUE: right.peekFirst()[0];
                int x = 0;
                if(x1 < x2) {
                    int[] temp = left.pollFirst();
                    x = temp[0];
                    leftH = temp[1];
                } else if(x1 > x2) {
                    int[] temp = right.pollFirst();
                    x = temp[0];
                    rightH = temp[1];
                } else {
                    x = left.peekFirst()[0];
                    leftH = left.pollFirst()[1];
                    rightH = right.pollFirst()[1];
                }
                int h = Math.max(leftH, rightH);
                if(res.isEmpty() || h != res.peekLast()[1])
                    res.add(List.of(x, h));
            }
            return res;
        }

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> t : tickets) 
                m.computeIfAbsent(t.get(0), z -> new PriorityQueue<>()).offer(t.get(1));
            List<String> ans = new ArrayList<>();
            dfs("JFK", ans);
            Collections.reverse(ans);
            return ans;
        }
        Map<String, PriorityQueue<String>> m = new HashMap<>(); // PriorityQueue: 这里面有一个自动升序排序功能
        void dfs(String s, List<String> l) {
            Queue<String> next = m.get(s);
            while (next != null && next.size() > 0)
                dfs(next.poll(), l);
            l.add(s);
        }
        public List<String> findItinerary(String[][] tickets) {
            LinkedList<String> ans = new LinkedList<>();
            for (String[] t : tickets)
                map.computeIfAbsent(t.get(0), z -> new ArrayList<>()).offer(t.get(1));
            dfs("JFK", ans);
            return new ArrayList<String>(ans); // LinkedList最后需要转换成ArrayList
        }
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        void dfs(String airport, LinkedList<String> list) {
            while (map.containsKey(airport) && !map.get(airport).isEmpty())
                dfs(map.get(airport).poll(), l);
            list.offerFirst(airport); // LinkedList可以这么写
        }
        public List<String> findItinerary(List<List<String>> tickets) { // todo: 这个算法还比较陌生
            for (List<String> t : tickets) 
                adj.computeIfAbsent(t.get(0), z -> new ArrayList<>()).add(t.get(1));
            for (List<String> values : adj.values()) Collections.sort(values);
            String u = "JFK";
            ans.add(u);
            fleuryProcess(u);
            return ans;
        }
        Map<String, List<String>> adj = new HashMap<>();
        List<String> ans = new ArrayList<>();
        private void fleuryProcess(String u) {
            if (!adj.containsKey(u)) return ;
            for (int i = 0; i < adj.get(u).size(); i++) {
                String v = adj.get(u).get(i);
                if (isValidNextEdge(u, v)) {
                    ans.add(v);
                    adj.get(u).remove(v);
                    fleuryProcess(v);
                }
            }
        }
        private boolean isValidNextEdge(String u, String v) {
            if (adj.get(u).size() == 1) return true;
            Map<String, Boolean> vis = new HashMap<>(); // vis: visited
            int cnt1 = dfs(u, vis);
            adj.get(u).remove(v);
            vis.clear(); 
            int cnt2 = dfs(v, vis);
            adj.get(u).add(0, v);
            return cnt1 <= cnt2; // 这里比较未访问节点个数
        }
        private int dfs(String u, Map<String, Boolean> vis) {
            vis.put(u, true);
            int cnt = 1;
            if (adj.containsKey(u)) 
                for (String v : adj.get(u)) 
                    if (vis.get(v) == null || (vis.get(v) != null && !vis.get(v))) 
                        cnt += dfs(v, vis);
            return cnt;
        }

        public String crackSafe(int n, int k) {
            N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
            s = new StringBuilder ("0".repeat(n));
            Set<String> ss = new HashSet<>(List.of(s.toString()));
            dfs(ss, n, k);
            return s.toString();
        }
        StringBuilder s;
        int N;
        boolean dfs(Set<String> ss, int n, int k) { // dfs backtracking 的思路，代码比较繁琐
            if (ss.size() == N) return true; // 如果已经遍历了所有的状态，相当于走完了回路，必定有某种状态可以开锁？
            String pre = s.substring(s.length() - (n-1));
            for (int i = 0; i < k; i++) {
                String cur = pre + i;
                if (ss.contains(cur)) continue;
                s.append(i + "");
                ss.add(cur);
                if (dfs(ss, n, k)) return true;
                s.deleteCharAt(s.length()-1);
                ss.remove(cur);
            }
            return false;
        }
        public String crackSafe(int n, int k) {
            int N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
            String s = "0".repeat(n);
            Set<String> ss = new HashSet<>(List.of(s.toString()));
            for (int i = 0; i < N; i++) {
                String pre = s.substring(s.length() - (n-1));
                // for (int j = 0; j < k; j++) { // 这里需要倒回来
                for (int j = k-1; j >= 0; j--) { 
                    String cur = pre + String.valueOf(j);
                    if (!ss.contains(cur)) {
                        ss.add(cur);
                        s += "" + j;
                        break;
                    }
                }
            }
            return s;
        }
        public String crackSafe(int n, int k) {
            N = (int)Math.pow(k, n); // 第个位有k种取值,总共有k^n种不同的状态
            s = "0".repeat(n);
            Set<String> ss = new HashSet<>(List.of(s.toString()));
            dfs(ss, n, k);
            return s;
        }
        String s;
        int N;
        void dfs(Set<String> ss, int n, int k) {
            if (ss.size() == N) return; 
            String pre = s.substring(s.length() - (n-1));
            for (int i = k-1; i >= 0; i--) {
                String cur = pre + i;
                if (ss.contains(cur)) continue;
                s += "" + i;
                ss.add(cur);
                dfs(ss, n, k);
            }
        }
        public String crackSafe(int n, int k) {
            highest = (int) Math.pow(10, n - 1);
            this.k = k;
            dfs(0);
            return ans + "0".repeat(n-1);
        }
        Set<Integer> vis = new HashSet<Integer>();
        StringBuffer ans = new StringBuffer();
        int highest;
        int k;
        public void dfs(int node) {
            for (int i = 0; i < k; i++) {
                int next = node * 10 + i;
                if (!vis.contains(next)) {
                    vis.add(next);
                    dfs(next % highest);
                    ans.append(i); // 这里dfs之后才添加的顺序狠重要
                }
            }
        }

        public int minCost(int[][] g) {
            int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
            int m = g.length, n = g[0].length;
            int [][] d = new int [m][n]; // dist to [0, 0]
            for (int i = 0; i < m; i++) 
                Arrays.fill(d[i], Integer.MAX_VALUE);
            d[0][0] = 0;
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {0, 0});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int i = cur[0], j = cur[1];
                for (int k = 1; k < 5; k++) {
                    int x = i + dirs[k][0], y = j + dirs[k][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int newDist = d[i][j] + (k == g[i][j] ? 0 : 1);
                    if (newDist < d[x][y]) {
                        d[x][y] = newDist;
                        q.offer(new int [] {x, y});
                    }
                }
            }
            return d[m-1][n-1];
        }
        public int minCost(int[][] g) {
            int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
            int m = g.length, n = g[0].length;
            int [][] d = new int [m][n]; 
            for (int i = 0; i < m; i++) 
                Arrays.fill(d[i], Integer.MAX_VALUE);
            d[0][0] = 0;
            boolean [][] in = new boolean [m][n];
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {0, 0});
            in[0][0] = true;
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                int i = cur[0], j = cur[1];
                in[i][j] = false;
                for (int k = 1; k < 5; k++) {
                    int x = i + dirs[k][0], y = j + dirs[k][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int newDist = d[i][j] + (k == g[i][j] ? 0 : 1);
                    if (newDist < d[x][y]) {
                        d[x][y] = newDist;
                        if (!in[x][y]) {
                            q.offer(new int [] {x, y});
                            in[x][y] = true;
                        }
                    }
                }
            }
            return d[m-1][n-1];
        }
        public int minCost(int[][] g) {
            int m = g.length, n = g[0].length;
            int [][] d = new int [m][n]; // dist to [0, 0]
            for (int i = 0; i < m; i++) 
                Arrays.fill(d[i], Integer.MAX_VALUE);
            d[0][0] = 0;
            int [][] dirs = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // [0, 1, 2, 3, 4]
            boolean [][] vis = new boolean [m][n];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offerFirst(0);
            while (!q.isEmpty()) {
                int idx = q.pollFirst();
                int i = idx / n, j = idx % n;
                if (vis[i][j]) continue;
                if (i == m-1 && j == n-1) return d[i][j]; // 终点第一次出队的时候，dist里存的就是最短路距离
                vis[i][j] = true;
                for (int k = 1; k < 5; k++) {
                    int x = i + dirs[k][0], y = j + dirs[k][1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    int cost = k == g[i][j] ? 0 : 1;
                    if (!vis[x][y] && d[x][y] > d[i][j] + cost) {
                        d[x][y] = d[i][j] + cost;
                        if (cost == 0) q.offerFirst(x * n + y);
                        else q.offerLast(x * n + y);
                    }
                }
            }
            return -1;
        }

        public int minSwapsCouples(int[] a) {
            int n = a.length;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 1; i <= n/2; i++) {
                m.put(2 * i - 2, 2 * i - 1);
                m.put(2 * i - 1, 2 * i - 2);
            }
            int cnt = 0, tmp = 0;
            for (int i = 1; i < n; i += 2) 
                if (a[i] != m.get(a[i-1])) {
                    for (int j = 0; j < n; j++) 
                        if (a[j] == m.get(a[i-1])) {
                            tmp = a[i];
                            a[i] = a[j];
                            a[j] = tmp;
                            break;
                        }
                    cnt++;
                }
            return cnt;
        }

        public boolean isPrintable(int[][] a) { 
            int m = a.length, n = a[0].length, max = Math.max(m, n);
            for (int i = 0; i < m; i++)
                max = Math.max(max, Arrays.stream(a[i]).max().getAsInt());
            int N = max + 1;
            int [] up = new int [N], down = new int [N], left = new int [N], right = new int [N];
            Arrays.fill(up, m);
            Arrays.fill(left, n);
            Arrays.fill(down, -1);
            Arrays.fill(right, -1);
            for (int i = 0; i < m; i++) // 界定每一种着色的上下左右边界，以便接下来排序
                for (int j = 0; j < n; j++) {
                    int k = a[i][j];
                    up[k] = Math.min(up[k], i);
                    down[k] = Math.max(down[k], i);
                    left[k] = Math.min(left[k], j);
                    right[k] = Math.max(right[k], j);
                }
            // 根据每种着色的界定范围，建立拓扑排序：这后半部分还有点儿不熟练
            // 当前位置颜色 cur 在某个矩阵 k 中但是不为矩阵 k 的颜色时，建立从 k 到 cur 的边，cur 可以存在于多个矩阵中
            boolean [][] nei = new boolean [N][N];  // neighbours
            List<Integer>[] adj = new ArrayList[N]; // 邻接有向图：按照染色的先后顺序
            int [] ins = new int [N];
            for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++) {
                    int cur = a[i][j]; // 当前格的最终打印着色
                    for (int k = 1; k < N; k++) { // 遍历所有的着色：暴搜当前着色cur是否会在某种着色k之后染色
                        if (k == cur) continue;
                        if (i >= up[k] && i <= down[k] && j >= left[k] && j <= right[k])  // 现着色cur完全处于先前染色k的内部，所以cur是后着色
                            // if (!nei[cur][k]) { // BUG: 是有向图：这里顺序很重要，先染色 是否 与后染色相连/相前后
                            if (!nei[k][cur]) {    // k 先染后， cur 后染色
                                adj[k].add(cur);
                                ins[cur]++;
                                nei[k][cur] = true;
                            }
                    }
                }
            List<Integer> l = new ArrayList<>();
            while (true) { // 寻找入度为 0 的颜色点，减小该点连结的点的入度，直到所有点的入度都为 0
                int i;
                for (i = 1; i < N; i++) 
                    if (ins[i] == 0) {
                        l.add(i);
                        for (int v : adj[i]) ins[v]--;
                        ins[i] = -1;
                        break;
                    }
                if (i == N) break;
            }
            return l.size() == max; // 按照拓扑排序，这所有的染色都可以有序地染出来，那么合法
        }
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

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            depth = new int [n];
            Arrays.fill(depth, -1);
            adj = new ArrayList[n]; // 初始化结构图map[i]代表节点i可以连通哪些节点
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
            for (List<Integer> c : connections) {
                adj[c.get(0)].add(c.get(1));
                adj[c.get(1)].add(c.get(0));
            }
            dfs(0, 0, 0);
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> [] adj;
        int [] depth;
        int dfs(int cur, int pre, int dep) { // 返回值为当前节点所有dfs路径终点的最小深度
            depth[cur] = dep; // 将当前深度存入深度数组
            int res = Integer.MAX_VALUE;
            for (int v : adj[cur]) {
                if (v == pre) continue;
                int endDepth; // dfs终点深度
                if (depth[v] == -1) {
                    endDepth = dfs(v, cur, dep + 1);
                    // 如果深度大于当前深度，说明当前点不在闭环上, 当前点与下一节点i之间的连线为答案之一
                    if (endDepth > dep)
                        ans.add(List.of(cur, v));
                } else endDepth = depth[v];
                res = Math.min(res, endDepth);
            }
            return res;
        }
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> res = new ArrayList<>();
            graph = new ArrayList[n];
            int[] dist = new int[n];
            int[] low = new int[n];
            HashSet<Integer> visited = new HashSet<>();
            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
            for (List<Integer> e : connections){
                graph[e.get(0)].add(e.get(1));
                graph[e.get(1)].add(e.get(0));
            }
            dfs(0, -1 , visited, dist, low, res);
            return res;
        }
        List<Integer>[] graph;
        private int time = 0;
        public void dfs(int cur, int root, HashSet<Integer> visited, int[] dist, int[] low, List<List<Integer>> res) {
            dist[cur] = time++; 
            low[cur] = dist[cur];
            visited.add(cur);
            for (int nei : graph[cur]) {
                if (nei == root) continue;
                //如果没访问过，继续dfs递归下去
                //cur的child的到达的最小的点，也就是cur所能到达的最小的点
                //一路backward返回
                if (!visited.contains (nei)){
                    dfs (nei, cur, visited, dist, low, res);
                    low[cur] = Math.min (low[cur], low[nei]);
                    if (dist[cur] < low[nei])
                        res.add (Arrays.asList (cur, nei));
                } else { // 如果访问过，那就更新cur的low
                    low[cur] = Math.min (low[cur], dist[nei]);
                }
            }
        }

        private class UnionFind {
            int [] id; // parent
            int [] cnt;// size
            public UnionFind (int n) {
                id = new int [n];
                cnt = new int [n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    cnt[i] = 1;
                }
            }
            public int find(int i) {
                while (id[i] != i) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
            public boolean sameGroup(int i, int j) {
                return find(i) == find(j);
            }
            public void union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    id[rootI] = rootJ;
                    cnt[rootJ] += cnt[rootI];
                }
            }
            public Set<Integer> getCompoent(int idx) {
                Set<Integer> si = new HashSet<>();
                int p = find(idx);
                for (int i = 0; i < id.length; i++) find(i);
                for (int i = 0; i < id.length; i++) 
                    if (id[i] == p)
                        si.add(i);
                return si;
            }
        }
        public boolean[] friendRequests(int n, int[][] rs, int[][] req) { // 这里面还有一点逻辑没能理清楚
            UnionFind uf = new UnionFind(n);
            Map<Integer, Set<Integer>> m = new HashMap<>();
            for (int [] v : rs) {
                m.computeIfAbsent(v[0], z -> new HashSet<>()).add(v[1]);
                m.computeIfAbsent(v[1], z -> new HashSet<>()).add(v[0]);
            }
            boolean [] ans = new boolean[req.length];
            for (int i = 0; i < req.length; i++) {
                int [] cur = req[i];
                if (uf.sameGroup(cur[0], cur[1])) {
                    ans[i] = true;
                    continue;
                }
                if (m.get(cur[0]) != null && m.get(cur[0]).contains(cur[1]) || m.get(cur[1]) != null && m.get(cur[1]).contains(cur[0]))
                    ans[i] = false;
                else {
                    Set<Integer> one = uf.getCompoent(cur[0]);
                    Set<Integer> two = uf.getCompoent(cur[1]);
                    boolean flag = false;
                    for (Integer a : one) 
                        for (Integer b : two) 
                            if (m.get(a) != null && m.get(a).contains(b) || m.get(b) != null && m.get(b).contains(a)) {
                                ans[i] = false;
                                flag = true;
                                break;
                            }
                    if (flag) continue;
                    ans[i] = true;
                    uf.union(cur[0], cur[1]);
                }
            }
            return ans;
        }

        public int maxNumEdgesToRemove(int n, int[][] edges) { // n: [1, 2, ..., n]
            Map<Integer, int []> map = new HashMap<>();
            for (int i = 0; i < edges.length; i++) map.put(i, edges[i]);
            Comparator<Map.Entry<Integer, int []>> cmp = new Comparator<Map.Entry<Integer, int []>>() {
                @Override 
                public int compare(Map.Entry<Integer, int []> a, Map.Entry<Integer, int []> b) {
                    int tmp = b.getValue()[0] - a.getValue()[0]; // type: 3, 2, 1
                    if (tmp != 0) return tmp;
                    else return a.getKey().compareTo(b.getKey());
                }
            };
            HashMap<Integer, int []> m = map.entrySet().stream().sorted(cmp)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            HashSet<Integer> s = new HashSet<>();
            HashSet<Integer> sa = new HashSet<>();
            HashSet<Integer> sb = new HashSet<>();
            UnionFind uf = new UnionFind(n+1);
            for (Map.Entry<Integer, int []> en : m.entrySet()) {
                int [] cur = en.getValue();
                if (uf.sameGroup(cur[1], cur[2])) continue;
                uf.merge(cur[1], cur[2]);
                if (cur[0] == 3) s.add(en.getKey()); // 排序的目的是保证先用完所有公共边
                else if (cur[0] == 1) sa.add(en.getKey());
                else sb.add(en.getKey());
            } 
            if (uf.getCnt() > 2 || sa.size() > 0) return -1; // 所有的边都用上了，仍不能强联通，则无解
            if (sb.size() == 0 && uf.getCnt() == 2) return edges.length - s.size(); // 不需要单人走的路，总边数 - 必要边数 ==》多余的边数
            uf = new UnionFind(n+1);
            for (Integer v : s) uf.merge(edges[v][1], edges[v][2]);
            for (Map.Entry<Integer, int []> en : m.entrySet()) {
                int [] cur = en.getValue();
                if (cur[0] == 1) {
                    if (uf.sameGroup(cur[1], cur[2])) continue;
                    uf.merge(cur[1], cur[2]);
                    sa.add(en.getKey());
                    if (uf.getCnt() == 2) break; // 这句话好像根本就没有用呀？？？破代码
                }
            }
            return edges.length - s.size() - sa.size() - sb.size();
        }
        private class UnionFind {
            int [] id; // parent
            int [] cnt;// size
            int cmpCnt;
            public UnionFind (int n) {
                id = new int [n];
                cnt = new int [n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    cnt[i] = 1;
                }
                cmpCnt = n;
            }
            public int find(int i) {
                while (id[i] != i) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
            public boolean sameGroup(int i, int j) {
                return find(i) == find(j);
            }
            public void merge(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    id[rootI] = rootJ;
                    cnt[rootJ] += cnt[rootI];
                }
                --cmpCnt;
            }
            public int getCnt() {
                return cmpCnt;
            }
        }
        public int maxNumEdgesToRemove(int n, int[][] edges) { // 这么写代码就简洁多了呀
            UnionFind ufa = new UnionFind(n);
            UnionFind ufb = new UnionFind(n);
            int ans = 0;
            for (int[] e : edges) { // 节点编号改为从 0 开始
                --e[1];
                --e[2];
            }
            for (int[] e : edges) // 公共边
                if (e[0] == 3) 
                    if (!ufa.unite(e[1], e[2])) {
                        ++ans;
                    } else
                        ufb.unite(e[1], e[2]);
            for (int[] e : edges) // 独占边
                if (e[0] == 1) {  // Alice 独占边
                    if (!ufa.unite(e[1], e[2])) 
                        ++ans;
                } else if (e[0] == 2) 
                    if (!ufb.unite(e[1], e[2])) // Bob 独占边
                        ++ans;
            if (ufa.setCount != 1 || ufb.setCount != 1) 
                return -1;
            return ans;
        }
        public class UnionFind { // 并查集模板
            int[] parent;
            int[] size;
            int n;
            int setCount; // 当前连通分量数目
            public UnionFind(int n) {
                this.n = n;
                this.setCount = n;
                this.parent = new int[n];
                this.size = new int[n];
                Arrays.fill(size, 1);
                for (int i = 0; i < n; ++i) parent[i] = i;
            }
            public int findset(int x) {
                return parent[x] == x ? x : (parent[x] = findset(parent[x]));
            }
            public boolean unite(int x, int y) {
                x = findset(x);
                y = findset(y);
                if (x == y) return false;
                if (size[x] < size[y]) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                parent[y] = x;
                size[x] += size[y];
                --setCount;
                return true;
            }
            public boolean connected(int x, int y) {
                x = findset(x);
                y = findset(y);
                return x == y;
            }
        }

        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) { // 题目理解错了
            List<int []> que = new ArrayList<>();
            for (int i = 0; i < queries.length; i++)
                que.add(new int [] {i, queries[i][0], queries[i][1], queries[i][2]});
            Collections.sort(que, (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
            adj = new ArrayList[n];
            for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
            for (int [] e : edgeList) {
                adj[e[0]].add(new int [] {e[1], e[2]});
                adj[e[1]].add(new int [] {e[0], e[2]});
            }
            boolean [] ans = new boolean [que.size()];
            // d = new int [n];
            for (int i = 0; i < que.size(); i++) {
                int u = que.get(i)[1], v = que.get(i)[2];
                dijkstra(u);
                ans[que.get(i)[0]] = (d[v] < que.get(i)[3]);
                int j = i+1;
                while (j < que.size() && que.get(j)[1] == u) j++;
                for (int k = i+1; k < j; k++) 
                    ans[que.get(k)[0]] = (d[que.get(k)[2]] < que.get(k)[3]);
                i = j-1;
            }            
            return ans;
        }
        List<int []> [] adj;
        int [] d;
        void dijkstra(int u) {
            Arrays.fill(d, Integer.MAX_VALUE);
            d[u] = 0;
            // Set<Integer> vis = new HashSet<>(); // 这里居然又被我画蛇添足了
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] - y[1]); // 最小堆
            q.offer(new int [] {u, 0});
            // vis.add(u);
            while (!q.isEmpty()) {
                int [] top = q.poll();
                if (top[1] > d[top[0]]) continue;
                for (int [] e : adj[top[0]]) 
                    if (top[1] + e[1] < d[e[0]]) {
                        d[e[0]] = top[1] + e[1];
                        // if (!vis.contains(e[0])) {
                            q.offer(new int [] {e[0], d[e[0]]});
                        //     vis.add(e[0]);
                        // }
                    }
            }
        }
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            DSU dsu = new DSU(n);
            Arrays.sort(edgeList, (a, b) -> a[2] - b[2]); // 同样按照weight的升序排列
            int m = queries.length, idx = 0, e = edgeList.length;
            Query [] qarr = new Query[m];
            for (int i = 0; i < m; i++) 
                qarr[i] = new Query(i, queries[i][0], queries[i][1], queries[i][2]);
            Arrays.sort(qarr);
            boolean [] ans = new boolean [m];
            for (int i = 0; i < m; i++) {
                while (idx < e && edgeList[idx][2] < qarr[i].weight) {
                    dsu.union(edgeList[idx][0], edgeList[idx][1]);
                    ++idx;
                }
                ans[qarr[i].idx] = dsu.areConnected(qarr[i].start, qarr[i].end);
            }            
            return ans;
        }
        private class DSU {
            private int N;
            private int [] parent, rank;
            public DSU( int n) {
                this.N = n;
                this.parent = new int [N];
                this.rank = new int [N];
                for (int i = 0; i < N; i++) {
                    this.parent[i] = i;
                    this.rank[i] = 1;
                }
            }
            public boolean areConnected(int u, int v) {
                return find(u) == find(v);
            }
            public void union(int u, int v) { // O(Log(N))
                if (u != v) {
                    int p = find(u);
                    int q = find(v);
                    if (p != q) {
                        if (rank[p] > rank[q]) {
                            parent[q] = p;
                            rank[p] += rank[q];
                        } else {
                            parent[p] = q;
                            rank[q] += rank[p];
                        }
                    }
                }
            }
            private int find(int v) { 
                int x = v;
                while (x != parent[x])
                    x = parent[x];
                parent[v] = x;
                return x;
            }
        }
        class Query implements Comparable<Query> {
            public int idx, start, end, weight;
            public Query(int idx, int bgn, int end, int weight) {
                this.idx = idx;
                this.start = bgn;
                this.end = end;
                this.weight = weight;
            }
            @Override public int compareTo(Query query) { // 按照weight的升序排列
                return this.weight - query.weight;
            }
        }

        public List<List<String>> findLadders(String bgn, String end, List<String> list) { // tle: 我这里好像还是在暴搜所有可能性
            ss = new HashSet<>(list);
            ss.add(bgn);
            if (!ss.contains(end)) return new ArrayList<>();
            for (String s : ss) 
                for (int i = 0; i < s.length(); i++) 
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (s.charAt(i) == c) continue;
                        String tmp = s.substring(0, i) + c + s.substring(i+1);
                        if (ss.contains(tmp))
                            adj.computeIfAbsent(s, z -> new HashSet<>()).add(tmp);
                    }
            return dfs(bgn, end);
        }
        Map<String, Set<String>> adj = new HashMap<>();
        Map<String, List<List<String>>> dp = new HashMap<>(); // 修改后的写法不知道哪里原因暴栈了
        Set<String> ss;
        List<List<String>> dfs(String s, String end) { // 
            List<List<String>> ans = new ArrayList<>();
            if (s.equals(end)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(end);
                ans.add(tmp);
                return ans;
            }
            if (dp.containsKey(s)) return dp.get(s);
            if (adj.get(s) == null) {
                return null;
            }
            for (String next : adj.get(s)) {
                List<List<String>> tmp = dfs(next, end);
                if (tmp == null) continue;
                if (ans.size() == 0 || ans.get(0).size() > tmp.get(0).size())
                    ans = tmp;
            }
            if (ans.size() == 0) {
                dp.put(s, null);
                return null;
            }
            for (int i = 0; i < ans.size(); i++) 
                ans.get(i).add(0, s);
            dp.put(s, ans);
            return ans;
        }        
        public List<List<String>> findLadders(String bgn, String end, List<String> list) { 
            Set<String> ss = new HashSet<>(list);
            if (!ss.contains(end)) return ans;
            ss.remove(bgn);
            // BFS: 第 1 步：广度优先遍历建图
            Map<String, Integer> cnt = new HashMap<>(); // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
            cnt.put(bgn, 0);
            Map<String, List<String>> from = new HashMap<>(); // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
            int step = 1, n = bgn.length();
            boolean found = false;
            Queue<String> q = new LinkedList<>();
            q.offer(bgn);
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    String cur = q.poll();
                    char [] s = cur.toCharArray();
                    for (int i = 0; i < n; i++) {
                        char ori = s[i];
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (s[i] == c) continue; // 
                            s[i] = c;
                            String next = String.valueOf(s);
                            if (cnt.containsKey(next) && step == cnt.get(next)) //
                                from.get(next).add(cur);                        //
                            if (!ss.contains(next)) continue; // 为什么我把这行写前面会少掉答案呢？ //
                            ss.remove(next); // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                            q.offer(next);   // 这一层扩展出的单词进入队列
                            from.computeIfAbsent(next, z -> new ArrayList<>()).add(cur); // 记录 next Word 从 cur Word 而来
                            cnt.put(next, step);
                            if (next.equals(end)) found = true;
                        }
                        s[i] = ori;
                    }
                }
                step++;
                if (found) break;
            }
            // 第 2 步：深度优先遍历找到所有解，从 end 恢复到 bgn ，所以每次尝试操作 path 列表的头部
            if (found) {
                Deque<String> path = new ArrayDeque<>(); 
                path.add(end);
                dfs(from, path, bgn, end);
            }
            return ans;
        }
        List<List<String>> ans = new ArrayList<>();
        void dfs(Map<String, List<String>> from, Deque<String> path, String end, String cur) {
            if (cur.equals(end)) {
                ans.add(new ArrayList<>(path)); // 这个写法学习一下，第一次见
                return ;
            }
            for (String precursor : from.get(cur)) {
                path.offerFirst(precursor);
                dfs(from, path, end, precursor);
                path.pollFirst();
            }
        }
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            // 如果不含有结束单词，直接结束，不然后边会造成死循环
            if (!wordList.contains(endWord)) {
                return ans;
            }
            // 利用 BFS 得到所有的邻居节点,以及每个节点的所在层数
            HashMap<String, Integer> distance = new HashMap<>();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            bfs(beginWord, endWord, wordList, map, distance);
            ArrayList<String> temp = new ArrayList<String>();
            // temp 用来保存当前的路径
            temp.add(beginWord);
            findLaddersHelper(beginWord, endWord, map, distance, temp, ans);
            return ans;
        }
        private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                       HashMap<String, Integer> distance, ArrayList<String> temp, List<List<String>> ans) {
            if (beginWord.equals(endWord)) {
                ans.add(new ArrayList<String>(temp));
                return;
            }
            // 得到所有的下一个的节点
            //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
            ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
            for (String neighbor : neighbors) {
                //判断层数是否符合
                if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                    temp.add(neighbor);
                    findLaddersHelper(neighbor, endWord, map, distance, temp, ans);
                    temp.remove(temp.size() - 1);
                }
            }
        }
        public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map,
                        HashMap<String, Integer> distance) {
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            distance.put(beginWord, 0);
            boolean isFound = false;
            int depth = 0;
            Set<String> dict = new HashSet<>(wordList);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                for (int j = 0; j < size; j++) {
                    String temp = queue.poll();
                    // 一次性得到所有的下一个的节点
                    ArrayList<String> neighbors = getNeighbors(temp, dict);
                    map.put(temp, neighbors);
                    for (String neighbor : neighbors) {
                        if (!distance.containsKey(neighbor)) {
                            distance.put(neighbor, depth);
                            if (neighbor.equals(endWord)) {
                                isFound = true;
                            }
                            queue.offer(neighbor);
                        }
                    }
                }
                if (isFound) {
                    break;
                }
            }
        }
        private ArrayList<String> getNeighbors(String node, Set<String> dict) {
            ArrayList<String> res = new ArrayList<String>();
            char chs[] = node.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                for (int i = 0; i < chs.length; i++) {
                    if (chs[i] == ch)
                        continue;
                    char old_ch = chs[i];
                    chs[i] = ch;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = old_ch;
                }
            }
            return res;
        }
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> ans = new ArrayList<>();
            if (!wordList.contains(endWord)) return ans;
            // 利用 BFS 得到所有的邻居节点
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            bfs(beginWord, endWord, wordList, map);
            ArrayList<String> temp = new ArrayList<String>();
            // temp 用来保存当前的路径
            temp.add(beginWord);
            findLaddersHelper(beginWord, endWord, map, temp, ans);
            return ans;
        }
        private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                       ArrayList<String> temp, List<List<String>> ans) {
            if (beginWord.equals(endWord)) {
                ans.add(new ArrayList<String>(temp));
                return;
            }
            // 得到所有的下一个的节点
            ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
            for (String neighbor : neighbors) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, map, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
// 利用递归实现了双向搜索
        private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
            Set<String> set1 = new HashSet<String>();
            set1.add(beginWord);
            Set<String> set2 = new HashSet<String>();
            set2.add(endWord);
            Set<String> wordSet = new HashSet<String>(wordList);
            bfsHelper(set1, set2, wordSet, true, map);
        }
// direction 为 true 代表向下扩展，false 代表向上扩展
        private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet, boolean direction,
                                  HashMap<String, ArrayList<String>> map) {
            // set1 为空了，就直接结束
            // 比如下边的例子就会造成 set1 为空
            /*	"hot"
                "dog"
                ["hot","dog"]*/
            if (set1.isEmpty()) return false;
            // set1 的数量多，就反向扩展
            if (set1.size() > set2.size()) 
                return bfsHelper(set2, set1, wordSet, !direction, map);
            // 将已经访问过单词删除
            wordSet.removeAll(set1);
            wordSet.removeAll(set2);
            boolean done = false;
            // 保存新扩展得到的节点
            Set<String> set = new HashSet<String>();
            for (String str : set1) {
                // 遍历每一位
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    // 尝试所有字母
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if(chars[i] == ch) continue;
                        chars[i] = ch;
                        String word = new String(chars);
                        // 根据方向得到 map 的 key 和 val
                        String key = direction ? str : word;
                        String val = direction ? word : str;
                        ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
                        // 如果相遇了就保存结果
                        if (set2.contains(word)) {
                            done = true;
                            list.add(val);
                            map.put(key, list);
                        }
                        // 如果还没有相遇，并且新的单词在 word 中，那么就加到 set 中
                        if (!done && wordSet.contains(word)) {
                            set.add(word);
                            list.add(val);
                            map.put(key, list);
                        }
                    }
                }
            }
            // 一般情况下新扩展的元素会多一些，所以我们下次反方向扩展  set2
            return done || bfsHelper(set2, set, wordSet, !direction, map);
        }

        public List<String> findWords(char[][] a, String[] sa) {
            m = a.length;
            n = a[0].length;
            Trie t = new Trie();
            for (String s : sa) t.insert(s);
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    dfs(i, j, t, a);
            return new ArrayList<>(ans);
        }
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> ans = new HashSet<>();
        int m, n;
        void dfs(int i, int j, Trie t, char [][] a) { // 这里加入Trie t变量，相当于每次调用从上一个字母开始，而不需要从树根开始
            if (a[i][j] == '#' || t.next[a[i][j]-'a'] == null) return ;
            char ori = a[i][j];
            t = t.next[a[i][j] - 'a'];
            if (!t.word.equals("")) ans.add(t.word);
            a[i][j] = '#';
            for (int [] d : dirs) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                dfs(x, y, t, a);
            }
            a[i][j] = ori;
        }
        class Trie {
            String word;
            Trie [] next;
            public Trie() {
                word = "";
                next = new Trie [26];
            }
            public void insert(String t) {
                char [] s = t.toCharArray();
                Trie r = this;
                for (int i = 0; i < t.length(); i++) {
                    if (r.next[s[i]-'a'] == null)
                        r.next[s[i]-'a'] = new Trie();
                    r = r.next[s[i]-'a'];
                }
                r.word = t;
            }
        }
    }

    public static void main (String[] args) {
        Solution s = new Solution ();

        char [][] a = new char [][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}; 
        String [] b = new String [] {"oath","pea","eat","rain"};
// char [][] a = new char [][] {{'a'}}; 
// String [] b = new String [] {"a"};

        List<String> r = s.findWords(a, b);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
   }
}
