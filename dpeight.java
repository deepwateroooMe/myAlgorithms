import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class dpeight {
    public static class Solution {

        
        public int maxEnvelopes(int[][] a) {
            int n = a.length, max = 1;
            List<int []> ll = new ArrayList<>();
            for (int [] v : a) ll.add (v);
            Collections.sort(ll, (x, y) -> x[0] != y[0] ? x[0]- y[0] : x[1] - y[1]);
            int [] dp = new int [n];
            // dp[0] = 1; // bug: 可以从中间某个位置开始，需要确保中间某个位置的起始值——也同样是——初始化——了的
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                int [] cur = ll.get(i);
                for (int j = 0; j < i; j++) {
                    int [] pre = ll.get(j);
                    if (pre[0] < cur[0] && pre[1] < cur[1])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
 
        public int maxSum(int [] a, int [] b) {
            int mod = (int)1e9 + 7;
            int m = a.length, n = b.length;
            long [] sa = new long [m];
            long [] sb = new long [n];
            for (int i = 0; i < m; i++) 
                sa[i] = (i == 0 ? 0 : sa[i-1]) + a[i];
            for (int i = 0; i < n; i++) 
                sb[i] = (i == 0 ? 0 : sb[i-1]) + b[i];
            int i = 0, j = 0;
            long max = 0;
            List<Integer> ia = new ArrayList<>(); // idx a b 
            List<Integer> ib = new ArrayList<>();
            while (i < m && j < n) {
                while (i < m && j < n && a[i] < b[j]) i++;
                while (i < m && j < n && a[i] > b[j]) j++;
                if (i < m && j < n && a[i] == b[j]) {
                    ia.add(i);
                    ib.add(j);
                    i++;
                    j++;
                }
            }
            if (ia.size() == 0) return (int)(Math.max(sa[m-1], sb[n-1]) % mod);
            for ( i = 0; i < ia.size(); i++) {
                long ca = sa[ia.get(i)] - (i == 0 ? 0 : sa[ia.get(i-1)]);
                long cb = sb[ib.get(i)] - (i == 0 ? 0 : sb[ib.get(i-1)]);
                max += Math.max(ca, cb);
                if (i == ia.size()-1) 
                    max += Math.max(sa[m-1] - sa[ia.get(i)], sb[n-1] - sb[ib.get(i)]);
            }
            return (int)(max % mod);
        }

        public int minimumIncompatibility(int[] a, int k) { // bug
            n = a.length;
            dp = new TreeSet [k];
            for (int i = 0; i < k; i++) 
                dp[i] = new TreeSet<>();
            Arrays.sort(a);
            // System.out.println(Arrays.toString(a));
            dfs(n-1, 0, a, k);
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        TreeSet<Integer> [] dp;
        int n, min = Integer.MAX_VALUE;
        private void dfs(int idx, int sum, int [] a, int k) {
            if (sum >= min) return ; // 裁枝
            if (idx < 0) {
                min = sum;
                return ;
            }
            for (int i = 0; i < k; i++) {
                if (dp[i].contains(a[idx])) continue;
                int last = dp[i].size() > 0 ? dp[i].last() : 0;
                dp[i].add(a[idx]);
                dfs(idx-1, sum + (last == 0 ? 0 : last - a[idx]), a, k);
                dp[i].pollLast();
            }
        }

        public int minAbsDifference(int[] a, int goal) {
            int n = a.length, idx = 0, min = Integer.MAX_VALUE;
            int [] left = Arrays.copyOfRange(a, 0, n/2); // [0, n/2)
            int [] right = Arrays.copyOfRange(a, n/2, n);
            Set<Integer> lsum = new HashSet<>();
            getSum(0, 0, left, lsum);
            Set<Integer> rsum = new HashSet<>();
            getSum(0, 0, right, rsum);
            int [] list = new int [lsum.size()];
            for (Integer v : lsum) list[idx++] = v;
            Arrays.sort(list);
            for (Integer v : rsum) {
                int rv = binarySearch(list, goal - v);
                min = Math.min(min, Math.abs(rv + v - goal));
            }
            return min;
        }
        private int binarySearch(int [] a, int v) { // todo: 这里写得有些乱
            if (v <= a[0]) return a[0];
            if (v >= a[a.length-1]) return a[a.length-1];
            int l = 0, r = a.length-1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (a[m] == v) return a[m];
                if (a[m] < v && m < r && a[m+1] > v)
                    return Math.abs(a[m] - v) < Math.abs(a[m+1] - v) ? a[m] : a[m+1];
                else if (a[m] > v && m > l && a[m-1] < v)
                    return Math.abs(a[m] - v) < Math.abs(a[m-1] - v) ? a[m] : a[m-1];
                else if (a[m] < v) l = m+1;
                else r = m-1;
            }
            return a[l];
        }
        private void getSum(int i, int sum, int [] a, Set<Integer> ss) {
            if (i == a.length) {
                ss.add(sum);
                return ;
            }
            getSum(i+1, sum + a[i], a, ss);
            getSum(i+1, sum, a, ss);
        }

        public String largestMultipleOfThree(int[] d) {
            int [] sorted = Arrays.stream(d).boxed()
                .sorted(Comparator.reverseOrder()) // just use 'sorted()' for ascending order
                .mapToInt(Integer::intValue).toArray();
            System.out.println(Arrays.toString(sorted));
            int sum = Arrays.stream(d).sum();
            return "";
        }

        public int scoreOfStudents(String t, int[] a) {
            int answer = getAns(t);
            n = t.length();
            this.t = t;
            this.s = t.toCharArray();
            dp = new Set[n][n];
            Set<Integer> candi = dfs(0, n-1);
            // Set<Integer> candi = generateAllPossCandiAns(s); // tle
            int ans = 0;
            for (Integer v : a) 
                if (v == answer) ans += 5;
                else if (candi.contains(v)) ans += 2;
            return ans;
        }
        Set<Integer> [][] dp;
        String t;
        char [] s;
        int n;
        private Set<Integer> dfs(int i, int j) {
            if (dp[i][j] != null) return dp[i][j];
            dp[i][j] = new HashSet<>();
            if (i == j) {
                dp[i][j].add(s[i] - '0');
                return dp[i][j];
            }
            // String cur = t.substring(i, j+1); // 这部分可以不要的
            // if (cur.indexOf("+") == -1 && cur.indexOf("*") == -1)
            //     return dp[i][j] = new HashSet<>(List.of(Integer.parseInt(cur)));
            Set<Integer> ans = new HashSet<>();
            for (int k = i+1; k < j; k++) 
                if (s[k] == '+' || s[k] == '*') {
                    Set<Integer> l = dfs(i, k-1);
                    Set<Integer> r = dfs(k+1, j);
                    for (Integer vl : l) 
                        for (Integer vr : r) {
                            int v = s[k] == '+' ? vl + vr : vl * vr;
                            if (v >= 0 && v <= 1000) ans.add(v); // 把题目这个限制条件看丢了 
                        }
                }
            return dp[i][j] = ans;
        }
        private int getAns(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            ArrayDeque<Integer> st = new ArrayDeque<>(); // 原生函数可以优化效率
            for (int i = 0; i < n; i++) {
                if (Character.isDigit(s[i])) {
                    int j = i+1;
                    while (j < n && Character.isDigit(s[j])) j++;
                    st.push(Integer.parseInt(t.substring(i, j)));
                    i = j-1;
                } else if (s[i] == '*') {
                    int j = i+1;
                    while (j < n && Character.isDigit(s[j])) j++;
                    int ans = st.pop() * Integer.parseInt(t.substring(i+1, j));
                    st.push(ans);
                    i = j-1;
                }
            }
            int ans = 0;
            while (!st.isEmpty()) ans += st.pop();
            return ans;
        }
        private Set<Integer> generateAllPossCandiAns(String t) { // 不长记性，木有记忆！！！ 第二次三次》？
            int n = t.length();
            if (n == 0) return new HashSet<>();
            if (t.indexOf("+") == -1 && t.indexOf("*") == -1) return new HashSet<>(List.of(Integer.parseInt(t)));
            char [] s = t.toCharArray();
            Set<Integer> ans = new HashSet<>();
            for (int i = 0; i < n; i++) 
                if (s[i] == '+' || s[i] == '*') {
                    Set<Integer> left = generateAllPossCandiAns(t.substring(0, i));
                    Set<Integer> right = generateAllPossCandiAns(t.substring(i+1));
                    for (Integer l : left) 
                        for (Integer r : right) {
                            if (s[i] == '+') ans.add(l + r);
                            else ans.add(l * r);
                        }
                }
            return ans;
        }

        public boolean splitArraySameAverage(int [] a) {
            int n = a.length, sum = Arrays.stream(a).sum();
            System.out.println("sum: " + sum);
            System.out.println("(double)sum / n: " + (double)sum / n);
            return true;
        }

        public int firstDayBeenInAllRooms(int[] nextVisit) { 
            int mod = (int)1e9 + 7;
            int n = nextVisit.length;
            long [] dp = new long [n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) 
                dp[i] = (2 * dp[i-1] % mod - dp[nextVisit[i-1]] + 2 + mod) % mod; // 这个mod 的地方还是需要稍微小心一下
            return (int)dp[n-1];
        }

        public int integerReplacement(int n) {
            return (int)integerReplacement((long)n);
        }
        private long integerReplacement(long n) {
            if (n == 1) return 0;
            int cnt = 0;
            while (n > 1) {
                while (n > 1 && n % 2 == 0) {
                    n /= 2;
                    cnt++;
                }
                if (n > 1 && n % 2 == 1) 
                    return Math.min(integerReplacement(n+1), integerReplacement(n-1)) + 1 + cnt;
            }
            return cnt;
        }

        public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) { // todo: bitmask写法 不知道哪里写错了,改天再回来写这个题
            int n = req_skills.length, range = 1 << n;;
            Map<String, Integer> m = new HashMap<>(); // k, v: String k, 1 << i
            for (int i = 0; i < n; i++) 
                m.put(req_skills[i], 1 << i); 
            Map<Integer, Set<Integer>> dp = new HashMap<>();
            Map<Integer, Set<Integer>> tmp = new HashMap<>();
            dp.put(0, new HashSet<>());
            int [] cnt = new int [range];
            Arrays.fill(cnt, Integer.MAX_VALUE);
            cnt[0] = 0;
            for (int i = 0; i < people.size(); i++) {
                System.out.println("\n i: " + i);
                int cur = 0;
                for (String s : people.get(i)) 
                    if (m.keySet().contains(s)) cur += m.get(s);
                System.out.println("Integer.toBinaryString(cur): " + Integer.toBinaryString(cur));
                Set<Integer> si = new HashSet<>();
                si.add(i);
                dp.put(cur, si);
                cnt[cur] = 1;
                tmp.clear();
                for (Integer key : dp.keySet())
                    if ((key & cur) == cur && dp.get(key).size() > dp.get(key ^ cur).size() + 1) {
                        Set<Integer> tmpSet = new HashSet<>(dp.get(key ^ cur));
                        tmpSet.add(i);
                        tmp.put(key, tmpSet);
                    }
                // if (!dp.containsKey(key | cur) || dp.get(key | cur).size() > dp.get(key).size() + 1) {
                //     Set<Integer> tmpSet = new HashSet<>(dp.get(key));
                //     tmpSet.add(i);
                //     tmp.put(key | cur, tmpSet);
                // }
                for (Integer key : tmp.keySet()) 
                    dp.put(key, new HashSet<>(tmp.get(key)));
                System.out.println("dp.size(): " + dp.size());
                for (Map.Entry<Integer, Set<Integer>> en : dp.entrySet())  {
                    System.out.print(en.getKey() + ": " + "\n");
                    // System.out.println("en.getValue().size(): " + en.getValue().size());
                    System.out.println(Arrays.toString(en.getValue().toArray()));
                }
            }
            int [] ans = new int [dp.get(range-1).size()];
            int idx = 0;
            for (Integer v : dp.get(range-1)) 
                ans[idx++] = v;
            return ans;
        }
        //  可以用回塑技能2^16，人择优录用,写起来相对复杂, 如同 万能的dfs记忆化搜索, 2^20对回塑来说也是灵丹炒药
         public int [] smallestSufficientTeam(String[] req_skills, List<List<String>> people) { // 原来暂时还是这个思路写起来比较简单
             n = req_skills.length;
             for (int i = 0; i < people.size(); i++) 
                 for (String v : people.get(i))
                     m.computeIfAbsent(v, z -> new ArrayList<>()).add(i);
             ans = new HashSet<>();
             dfs(0, new HashSet<>(), req_skills);
             int [] res = new int [ans.size()];
             int idx = 0;
             for (Integer v : ans) res[idx++] = v;
             return res;
         }
        Map<String, List<Integer>> m = new HashMap<>();
        int n, min = Integer.MAX_VALUE;
        Set<Integer> ans;
        private void dfs(int i, Set<Integer> vis, String [] r) {
            if (vis.size() >= min) return ;
            if (i == r.length) {
                min = vis.size();
                ans.clear();
                ans.addAll(vis);
                return ;
            }
            for (Integer p : m.get(r[i])) {
                boolean added = vis.add(p);
                dfs(i+1, vis, r);
                if (added)
                    vis.remove(p);
            }
        }
        // String []  a = new String []  {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        // String [][] b = new String [][] {{"algorithms","math","java"},{"algorithms","math","reactjs"},{"java","csharp","aws"},{"reactjs","csharp"},{"csharp","math"},{"aws","java"}};
        // // String []  a = new String []  {"java", "nodejs", "reactjs"};
        // // String [][] b = new String [][] {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        // List<List<String>> ll = new ArrayList<>();
        // for (int i = 0; i < b.length; i++) 
        //     ll.add(Arrays.asList(b[i]));
        // int [] r = s.smallestSufficientTeam(a, ll);
        // System.out.println(Arrays.toString(r));

        public int maxHeight(int[][] a) {
            int n = a.length, min = 0, max = 0, c = 0;
            List<int []> ll = new ArrayList<>();
            for (int [] v : a) {
                max = Math.max(v[0], Math.max(v[1], v[2]));
                min = Math.min(v[0], Math.min(v[1], v[2]));
                c = v[0] + v[1] + v[2] - max - min;
                ll.add(new int [] {c, min, max});
            }
            // Collections.sort(ll, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); // bug: 必须写得很清楚
            Collections.sort(ll, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] != y[1] ? x[1] - y [1] : x[2] - y[2]); 
            int [] dp = new int [n];
            for (int i = 0; i < n; i++) {
                int [] cur = ll.get(i);
                if (dp[i] == 0) dp[i] = cur[2];
                for (int j = 0; j < i; j++) {
                    int [] pre = ll.get(j);
                    if (pre[0] <= cur[0] && pre[1] <= cur[1] && pre[2] <= cur[2])
                        dp[i] = Math.max(dp[i], dp[j] + cur[2]);
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }

        public int minStickers(String [] s, String t) { // 记忆化搜索: 写得有点儿不太顺: 可能最开始地题目的理解，或者对答案的理解不够透彻吧
            n = s.length;
            map = new int [n][26];
            for (int i = 0; i < n; i++) 
                for (char c : s[i].toCharArray()) 
                    map[i][c-'a']++;
            // tt = new int [26];
            // for (int i = 0; i < t.length(); i++) tt[t.charAt(i)-'a']++;
            dp.put("", 0); // 药引子
            return dfs(t);
        }
        Map<String, Integer> dp = new HashMap<>(); // 2^50不能用回塑，顶多记忆化搜索
        int [][] map; // 但这个不变的备选库，需要预处理
        // int [] tt; // 因为记忆化搜索、这个搜索的目标会经常变，所以用途不大
        int n;
        private int dfs(String s) {
            if (dp.containsKey(s)) return dp.get(s);
            int ans = Integer.MAX_VALUE;
            int [] cnt = new int [26];
            for (int i = 0; i < s.length(); i++) 
                cnt[s.charAt(i)-'a']++;
            for (int i = 0; i < n; i++) { // 遍历每一个候选单词
                if (map[i][s.charAt(0)-'a'] == 0) continue; // 不合资格的候选单词过滤掉
                StringBuilder next = new StringBuilder();
                for (int j = 0; j < 26; j++) 
                    if (cnt[j] > 0)
                        next.append(String.valueOf((char)(j+'a')).repeat(cnt[j] - Math.min(cnt[j], map[i][j])));
                int tmp = dfs(next.toString());
                if (tmp != -1)
                    ans = Math.min(ans, tmp + 1);
            }
            dp.put(s, ans == Integer.MAX_VALUE ? -1 : ans);
            return dp.get(s);
        }
        public int minStickers(String [] s, String t) { // dp: 以target的每个字母为最小更新单位，遍历各状态，寻求全局最优解
            int m = t.length(), r = 1 << m;
            int [] dp = new int [r];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < r; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue; // 不可到达的状态，跳过
                for (String str : s) { // 遍历每一个候选单词: 只要能够更新一个字母，就算达到优化进展，
                    int cur = i;
                    for (char c : str.toCharArray()) // 遍历候选单词的每个字母
                        for (int j = 0; j < m; j++) {
                            if (t.charAt(j) == c && ((cur >> j) & 1) == 0) { // 如果与候选单词中的字母相同,而且候选字母还没有设置
                                cur |= 1 << j;
                                break; // 能改变一个字母，就break掉
                            }
                        }
                    dp[cur] = Math.min(dp[cur], dp[i] + 1);
                }
            }
            return dp[r-1] == Integer.MAX_VALUE ? -1 : dp[r-1];
        }

        private int getGcd(int i, int j) { // complexity of Euclid's algorithm is O(Log min(n1, n2)) 
            if (j == 0) return i;
            return getGcd(j, i % j);
        }
        public int maxScore(int[] a) { // 现在再来看这个思路：缜缜思维可叹精妙
            int n = a.length, r = 1 << n;
            int [][] gcd = new int [n][n];
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) 
                    gcd[i][j] = getGcd(a[i], a[j]);
            int [] dp = new int [r];
            for (int i = 2; i < r; i++) {
                int cnt = Integer.bitCount(i);
                if (cnt < 2 || cnt % 2 == 1) continue;
                for (int j = 0; j < n; j++) 
                    for (int k = j+1; k < n; k++) {
                        int cur = (1 << j) | (1 << k);
                        if ((i & cur) != cur) continue; // 当前状态中不是两个数字都同时存在的
                        dp[i] = Math.max(dp[i], dp[i - cur] + gcd[j][k] * (cnt / 2));
                    }
            }
            return dp[r-1];
        }
        public int maxScore(int[] a) {
            n = a.length;
            gcd = new int [n][n];
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) 
                    gcd[i][j] = getGcd(a[i], a[j]);
            return dfs(0, 1, a);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        int [][] gcd;
        int n;
        private int dfs(int mask, int ops, int [] a) {
            int cnt = Integer.bitCount(mask);
            if (cnt == n) return 0;
            if (dp.containsKey(mask)) return dp.get(mask);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & 1 << i) == 1 << i) continue; // & << 优先级相等，从左到右运算
                for (int j = i+1; j < n; j++) {
                    if ((mask & 1 << j) == 1 << j) continue;
                    int newMask = mask | 1 << i | 1 << j;
                    ans = Math.max(ans, dfs(newMask, ops + 1, a) + ops * gcd[i][j]);
                }
            }
            dp.put(mask, ans);
            return ans;
        }
        private int getGcd(int i, int j) { // complexity of Euclid's algorithm is O(Log min(n1, n2)) 
            if (j == 0) return i;
            return getGcd(j, i % j);
        }
        public int maxScore(int[] a) { // todo bug tle: 要怎么才能把这个题简化一下呢？
            n = a.length;
            Arrays.sort(a);
            vis = new boolean [n];
            gcd = new int [n][n];
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) 
                    gcd[i][j] = getGcd(a[i], a[j]);
            dfs(a, 0, 0);
            return max;
        }
        int [][] gcd;
        boolean [] vis;
        int n, max = 0;
        private void dfs(int [] a, long cur, int cnt) { 
            if (cnt == n/2) {
                if (cnt == n/2 && cur > max) max = (int)cur;
                return ;
            }
            for (int i = 0; i < n; i++) { // 这里两层循环感觉是有点儿问题的；可暂时还没能想出如何改进
                if (vis[i]) continue;
                vis[i] = true;
                for (int j = 0; j < n; j++) {
                    if (j == i || vis[j]) continue;
                    vis[j] = true;
                    dfs(a, cur + (cnt+1) * (long)gcd[i][j], cnt + 1);
                    vis[j] = false;
                }
                vis[i] = false;
            }
        }
        private int getGcd(int i, int j) { // complexity of Euclid's algorithm is O(Log min(n1, n2)) 
            if (j == 0) return i;
            return getGcd(j, i % j);
        }
        public int maxScore(int[] nums) { // todo: bug, 参考的方法不知道他写得是什么意思
            l = Arrays.stream(nums).boxed().collect(Collectors.toList());
            n  = nums.length;
            a = new int [n/2];
            recursion(l);  
            return max;
        }
        List<Integer> l = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> lli = new ArrayList<>();
        int [] a;
        int n, max = 0;
        private void recursion(List<Integer> l) {
            if (l.size() == 0) {
                lli.add(new ArrayList<>(ll));
                for (int i = 0; i < ll.size(); i += 2) 
                    a[i/2] = getGcd(ll.get(i), ll.get(i+1));
                Arrays.sort(a);
                int sum = 0;
                for (int i = 0; i < a.length; i++) 
                    sum = sum + (i+1) * a[i];
                max = Math.max(max, sum);
                return ;
            }
            List<Integer> one = new ArrayList<>(l); // 4
            List<Integer> two = new ArrayList<>(l); // 5
            ll.add(two.get(0));
            one.remove(0);
            for (int i = 1; i < two.size(); i++) {
                ll.add(two.get(i));
                one.remove(0);
                recursion(one);
                one.add(two.get(i));
                ll.remove(ll.size()-1);
            }
        }
    https://leetcode.com/problems/maximize-score-after-n-operations/discuss/1497609/java-very-easy
        public void recursion(ArrayL<Integer> l)
            {
                if(l.size()==0)
                {
                    l3.add(new ArrayL<Integer>(l2));
                    for(int i=0;i<l2.size();i=i+2)arr[i/2]=gcd(l2.get(i),l2.get(i+1));
                    Arrays.sort(arr);int sum=0;
                    for(int i=0;i<arr.length;i++)sum=sum+(i+1)*arr[i];
                    max=Math.max(sum,max);
                    return;
                }
                ArrayL<Integer>l4=new ArrayL<Integer>(l);
                ArrayL<Integer>l5=new ArrayL<Integer>(l);
    
                l2.add(l5.get(0));l4.remove(0);
                for(int i=1;i<l5.size();i++)
                {
                    l2.add(l5.get(i));l4.remove(0);
                    recursion(l4);l4.add(l5.get(i));
                    l2.remove(l2.size()-1);
                }
                l2.remove(l2.size()-1);  
            }
        ArrayL<ArrayL<Integer>> l3=new ArrayL<ArrayL<Integer>>();
        ArrayL<Integer> l=new ArrayL<Integer>();
        ArrayL<Integer> l2=new ArrayL<Integer>();
        int[] arr;
        int max=0;
        public int maxScore(int[] nums) {
            for(int i=0;i<nums.length;i++)
            {
                l.add(nums[i]);
            }
            arr=new int[nums.length/2]; 
            recursion(l);  
            return max;
        }
        
         public int leastOpsExpressTarget(int x, int target) { 
            if (x == target) return 0;
            if (x > target) return Math.min(target * 2 -1, (x - target) * 2); // 
            int cnt = 0;
            long cur = x;
            while (cur < target) {
                cur *= x;
                cnt++;
            }
            if (cur == target) return cnt;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            if (cur - target < target)
                min = leastOpsExpressTarget(x, (int)(cur - target)) + cnt;
            max = leastOpsExpressTarget(x, (int)(target - (cur / x))) + cnt - 1;
            return Math.min(min, max) + 1;
        }

        public int maxDotProduct(int [] a, int [] b) { // 从尾巴往回倒回来的
            int m = a.length, n = b.length;
            int [][] dp = new int [m][n];
            dp[m-1][n-1] = a[m-1] * b[n-1];
            for (int i = m-2; i >= 0; i--) 
                dp[i][n-1] = Math.max(dp[i+1][n-1], a[i] * b[n-1]);
            for (int j = n-2; j >= 0; j--) 
                dp[m-1][j] = Math.max(dp[m-1][j+1], a[m-1] * b[j]);
            int cur = 0, tmp = 0;
            for (int i = m-2; i >= 0; i--)
                for (int j = n-2; j >= 0; j--) {
                    cur = a[i] * b[j];
                    tmp = Math.max(dp[i+1][j], dp[i][j+1]);
                    tmp = Math.max(tmp, cur);
                    if (dp[i+1][j+1] > 0 && cur > 0)
                        tmp = Math.max(tmp, dp[i+1][j+1] + cur);
                    dp[i][j] = tmp;
                }
            return dp[0][0];
        }
        public int maxDotProduct(int [] a, int [] b) { // 从前往后，自顶向下呢: 换汤不换药，自顶向下、自底向上，只是方向不同而已
            int m = a.length, n = b.length;
            int [][] dp = new int [m][n];
            dp[0][0] = a[0] * b[0];
            for (int i = 1; i < m; i++) 
                dp[i][0] = Math.max(dp[i-1][0], a[i] * b[0]);
            for (int j = 1; j < n; j++) 
                dp[0][j] = Math.max(dp[0][j-1], a[0] * b[j]);
            int cur = 0, tmp = 0;
            for (int i = 1; i < m; i++) 
                for (int j = 1; j < n; j++) {
                    cur = a[i] * b[j];
                    tmp = Math.max(dp[i-1][j], dp[i][j-1]);
                    tmp = Math.max(tmp, cur);
                    if (dp[i-1][j-1] > 0 && cur > 0)
                        tmp = Math.max(tmp, dp[i-1][j-1] + cur);
                    dp[i][j] = tmp;
                }
            return dp[m-1][n-1];
        }

        public boolean canCross(int[] stones) { 
            int n = stones.length;
            Map<Integer, Set<Integer>> jmp = new HashMap<>(); // set里存的是到达当前石头所用的步长
            for (int i = 0; i < n; i++)
                jmp.put(stones[i], new HashSet<>());
            jmp.get(0).add(0);
            for (int i = 0; i < n-1; i++) {
                int idx = stones[i];
                if (jmp.get(idx).size() == 0) continue;
                for (int v : jmp.get(idx)) {
                    for (int j = v-1; j <= v+1; j++) { // [v-1, v, v+1]
                        if (j <= 0) continue;
                        if (jmp.containsKey(idx + j))
                            jmp.get(idx+j).add(j);
                    }
                }
            }
            return jmp.get(stones[n-1]).size() != 0;
        }
        public boolean canCross(int[] stones) {
            int n = stones.length;
            if (n == 1 && stones[0] == 0) return true;
            if (stones[1] != 1) return false;
            boolean [][] dp = new boolean [n][n];
            dp[0][0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int k = stones[i] - stones[j];
                    if (k >= n) continue; // 因为最大的步数就是stones.length
                    dp[i][k] = dp[j][k];
                    if (k -1 >= 0) dp[i][k] |= dp[j][k-1];
                    if (k + 1 < n) dp[i][k] |= dp[j][k+1];
                }
            }
            for (int i = 0; i < n; i++) 
                if (dp[n-1][i]) return true;
            return false;
        }
        暴力解法的问题在于里面存在重复计算：
        例如在a->b->c的过程中，假设b->c跳跃了k步，但是a->b的过程既有可能跳跃了k-1步，也有可能跳跃了k+1步。
        所以b->c跳跃k步的情况就有可能在a->b的递推过程中被重复计算。因此这种算法不能通过所有的测试用例。
        private int getIdx(int [] arr, int v, int l, int r) { 
            if (l == r) return arr[l] == v ? l : -1;
            if (l == r -1) return arr[l] == v ? l : (arr[r] == v ? r : -1);
            int m = l + (r-l)/2;
            if (arr[m] == v) return m;
            if (arr[m] > v) return getIdx(arr, v, l, m-1);
            return getIdx(arr, v, m+1, r);
        }
        private int getIdx(int [] a, int v, int l, int r) {
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (a[m] == v) return m;
                if (a[m] < v) l = m + 1;
                else r = m-1;
            }
            return -1;
        }
        public boolean canCross(int [] s) { // bug: 2个case不过
            n = s.length;
            if (s[1] != 1) return false;
            for (int i = 0; i < n; i++) 
                m.put(s[i], i);
            dp = new Boolean [n][n];
            return dfs(s, 0, n-1, 1);
        }
        Map<Integer, Integer> m = new HashMap<>();
        Boolean [][] dp;
        int n;
        private boolean dfs(int [] a, int i, int j, int k) {
            if (i == j) return true; //
            if (i >= n || k >= n) return false;
            if (dp[i][k] != null) return dp[i][k];
            int cur = a[i];
            for (int x = k+1; x >= Math.max(1, k-1); x--) {
                int next = cur + x;
                if (m.containsKey(next) && dfs(a, m.get(next), j, x)) 
                    return dp[i][k] = true;
            }
            return dp[i][k] = false;
        } // could NOT realize: what is the difference ?
        // int []  a = new int []  {0, 1, 2, 5, 6, 9, 10, 12, 13, 14, 17, 19, 20, 21, 26, 27, 28, 29, 30};
    https://leetcode.com/problems/frog-jump/discuss/1523550/JAVA-Top-Down-DP-%2B-HashMap-with-some-explanations
        int[][] dp;
        public boolean canCrossRecursive(int[] stones, HashMap<Integer, Integer> stoneIndex, int k, int start, int end) {
            if (start == end) return true;
            if (k >= stones.length) return false;
            if (start >= stones.length) return false;
            if (dp[start][k] > 0) return dp[start][k] == 1;
            boolean isSuccess = false; 
            int cur = stones[start];
            for (int i = k + 1; i >= Math.max(1, k - 1); i--) { // jump only when stone exists in hashmap.
                int nxt = cur + i;
                if (stoneIndex.containsKey(nxt)) 
                    isSuccess = isSuccess || canCrossRecursive(stones, stoneIndex, i, stoneIndex.get(nxt), end);
            }   
            if (isSuccess) dp[start][k] = 1;
            else dp[start][k] = 2;
            return isSuccess;
        }
        public boolean canCross(int[] stones) {
            HashMap<Integer, Integer> stoneIndex = new HashMap<Integer, Integer>();
            int n = stones.length;
            for (int i = 0; i < n; i++) 
                stoneIndex.put(stones[i], i);
            int start = 0;
            int end = n - 1;
            // Memorization table based on the stone index and jump size
            dp = new int[n][n];
            return canCrossRecursive(stones, stoneIndex, 0, start, end);
        }
        public boolean canCross(int[] a) { // 这个思路很精致轻巧
            Map<Integer, Set<Integer>> m = new HashMap<>();
            for (int i = 0; i < a.length; i++) 
                m.put(a[i], new HashSet<>());
            m.get(0).add(0);
            for (int i = 0; i < a.length; i++) 
                for (Integer v : m.get(a[i])) 
                    for (int j = Math.max(1, v-1); j <= v+1; j++) 
                        if (m.containsKey(a[i] + j))
                            m.get(a[i]+j).add(j);
            return m.get(a[a.length-1]).size() > 0;
        }

        public List<String> findAllConcatenatedWordsInADict(String[] words) { // tle: 对大量重复字母单词可能需要优化吧 ["a", "aa", "aaaaa", ....]
            t = new Trie();
            for (String s : words)
                if (!s.equals(""))  // 题目描述有问题, 应该补充上连接词至少由两个非空单词组成, 否则如果 words 包含空串, 
                    t.insert(s);    // 那么 words 中的其它所有字符串都是连接词. 这里加上特判就可以了.
            List<String> ans = new ArrayList<>();
            for (String s : words)
                if (t.dfs(s.toCharArray(), 0))
                    ans.add(s);
            return ans;
        }
        Trie t;
        public class Trie {
            private class Node {
                boolean isWord;
                Node [] next;
                public Node() {
                    isWord = false;
                    next = new Node[26];
                }
            }
            Node root;
            public Trie() {
                root = new Node();
            }
            public boolean dfs(char [] s, int bgn) {
                int n = s.length;
                Node r = root;
                for (int i = bgn; i < n; i++) {
                    if (r.next[s[i]-'a'] == null) return false;
                    r = r.next[s[i] - 'a'];
                    if (r.isWord && dfs(s, i+1)) return true;
                }
                return r.isWord && bgn != 0; // bgn != 0 含义即是不能匹配到自己
            }
            public void insert(String t) {
                Node r = root;
                char [] s = t.toCharArray();
                for (int i = 0; i < s.length; i++) {
                    char c = s[i];
                    if (r.next[c-'a'] == null)
                        r.next[c-'a'] = new Node();
                    r = r.next[c-'a'];
                }
                r.isWord = true;
            }
        }
        public List<String> findAllConcatenatedWordsInADict(String[] words) { // tle 
            List<String> ans = new LinkedList<>();
            if(words == null || words.length == 0) return ans;
            Set<String> ss = new HashSet<>();
            int minLen = Integer.MAX_VALUE;
            for (String s : words) 
                if (s.length() > 0) {
                    ss.add(s);
                    minLen = Math.min(minLen, s.length());
                }
            for (String s : words) 
                if (canCompose(s, 0, minLen, ss))
                    ans.add(s);
            return ans;
        }
        private boolean canCompose(String s, int bgn, int minLen, Set<String> ss) {
            for (int i = bgn + minLen; i <= s.length() - minLen; i++)
                if (ss.contains(s.substring(bgn, i)) && (ss.contains(s.substring(i)) || canCompose(s, i, minLen, ss)))
                    return true;
            return false;
        }
        public List<String> findAllConcatenatedWordsInADict(String[] a) {
            List<String> ans = new ArrayList<>();
            Set<String> ss = new HashSet<>(Arrays.asList(a));
            boolean valid = false;
            for (String s : a) {
                boolean [] dp = new boolean [s.length()+1];
                dp[0] = true;
                valid = false;
                for (int i = 0; i < s.length(); i++) 
                    for (int j = i+1; j <= s.length(); j++) 
                        // String []  a = new String []  {"a", "b", "ab", "abc"}; // 注意对ij的限制条件，否则会 false positive
                        if (dp[i] && ss.contains(s.substring(i, j)) && (i > 0 || i == 0 && j != s.length())) {
                            dp[j] = true;
                            if (i > 0) valid = true;
                        }
                if (valid && dp[s.length()]) ans.add(s);
            }
            return ans;
        }

        public int rearrangeSticks(int n, int k) {
            int mod = (int)1e9 + 7;
            long [][] dp = new long [n+1][k+1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) 
                for (int j = 1; j <= k; j++) 
                    dp[i][j] = (dp[i-1][j-1] + (i - 1) * dp[i-1][j]) % mod;
            return (int)dp[n][k];
        }
        public int rearrangeSticks(int n, int k) {
            dp = new long [n+1][k+1];
            return (int)dfs(n, k);
        }
        int mod = (int)1e9 + 7;
        long [][] dp;
        private long dfs(int n, int k) {
            if (n < k || k == 0) return 0;
            if (n == k) return 1;
            if (dp[n][k] != 0) return dp[n][k];
            return dp[n][k] = (dfs(n-1, k-1) + (n - 1) * dfs(n-1, k)) % mod;
        }

        public int minimumDifference(int[] a) { 
            int n = a.length, ans = Integer.MAX_VALUE;
            int [] left = Arrays.copyOfRange(a, 0, n/2);
            int [] right = Arrays.copyOfRange(a, n/2, n);
            Map<Integer, TreeSet<Integer>> lsum = new HashMap<>();
            Map<Integer, TreeSet<Integer>> rsum = new HashMap<>();
            for (int i = 1; i < (1 << (n/2)); i++) { // 这里一次遍历把左右两边的都算出来了
                int sumLeft = 0, sumRight = 0, cnt = 0;
                for (int j = 0; j < n/2; j++) {
                    cnt += (i >> j) & 1;
                    if (((i >> j) & 1) == 1) {
                        sumLeft += left[j];
                        sumRight -= right[j];
                    } else {
                        sumLeft -= left[j];
                        sumRight += right[j];
                    }
                }
                lsum.computeIfAbsent(cnt, z -> new TreeSet<>()).add(sumLeft);
                rsum.computeIfAbsent(cnt, z -> new TreeSet<>()).add(sumRight);
            }
            for (int i = 1; i <= n/2; i++) 
                for (Integer lv : lsum.get(i)) {
                    if (rsum.get(i).contains(-lv)) return 0;
                    Integer ceiling = rsum.get(i).ceiling(-lv);
                    Integer floor = rsum.get(i).floor(-lv);
                    if (ceiling != null)
                        ans = Math.min(ans, Math.abs(ceiling + lv));
                    if (floor != null)
                        ans = Math.min(ans, Math.abs(floor + lv));
                }
                // 暴力匹配会超时
                // for (int i = 1; i < n/2; i++) 
                //     for (int lv : lsum.get(i))
                //         for (int rv : rsum.get(i)) 
                //             ans = Math.min(ans, Math.abs(lv - rv));
            return ans;
        }

        public int makeArrayIncreasing(int[] a, int[] b) {
            b = Arrays.stream(b).distinct().toArray();
            Arrays.sort(b);
            int m = a.length, n = b.length;
            int minCnt = 0, minVal = 0;
            Queue<int []> q = new LinkedList<>();
            q.offer(new int [] {-1, 0}); // 初始化，假想第0位的前一位是-1
            for (int i = 0; i < m; i++) {
                minCnt = Integer.MAX_VALUE;
                for (int size = q.size()-1; size >= 0; size--) {
                    int [] cur = q.poll(); // 取前一位的一个选择
                    if (a[i] > cur[0]) minCnt = Math.min(minCnt, cur[1]); // 先不急将当前选择加入queue中，找到最小的再说
                    minVal = binarySearchMin(b, cur[0]); // 查找一个比前一个数大的最小数
                    if (minVal != -1) q.offer(new int [] {minVal, cur[1] + 1}); // 将这个最小数加入到queue中，操作次数在前一位的基础上加一
                 }
                if (minCnt != Integer.MAX_VALUE) // 如果当前位可以保持不变，将最小次数加入到queue中
                    q.offer(new int [] {a[i], minCnt}); 
            }
            if (q.size() == 0) return -1; // 如果最后一位没有合法的选择方案，返回-1
            int ans = Integer.MAX_VALUE;
            while (!q.isEmpty()) ans = Math.min(ans, q.poll()[1]);
            return ans;
        }
        private int binarySearchMin(int [] arr, int v) {
            int l = 0, r = arr.length-1, m = 0;
            while (l < r) { // l,r: [0, 1]
                m = l + (r-l) / 2;
                if (arr[m] <= v) l = m+1;
                else r = m;
            }
            return arr[l] > v ? arr[l] : -1; // 所以这里要再判断一下
        }
        public int makeArrayIncreasing(int[] a, int[] b) { // todo: java version 根据c++版本改写过来
            b = Arrays.stream(b).distinct().sorted().toArray();
            int n = a.length;
            int [][] dp = new int [n+1][n+1]; // 
            for (int i = 0; i <= n; i++) 
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0][0] = Integer.MIN_VALUE;
            for (int j = 1; j <= n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (a[j-1] > dp[i][j-1]) // 当前数比前一个数大，可以不用替换
                        dp[i][j] = a[j-1];   // 将当前值赋予dp[i][j]
                    if (i > 0) {
                    }
                    if (j == n && dp[i][j] != Integer.MAX_VALUE) return i;
                }
            }
         }
        int makeArrayIncreasing(vector<int>& arr1, vector<int>& arr2) {
            int n = arr1.size();
            if (n == 1) return 0;
            set<int> st(arr2.begin(), arr2.end());
            vector<vector<int>> dp(n + 1, vector<int>(n + 1, INT_MAX));
            dp[0][0] = INT_MIN;
            for (int j = 1; j <= n; ++j) {
                for (int i = 0; i <= j; ++i) {
                    if (arr1[j - 1] > dp[i][j - 1]) {
                        dp[i][j] = arr1[j - 1];
                    }
                    if (i > 0) {
                        auto it = st.upper_bound(dp[i - 1][j - 1]);
                        if (it != st.end()) dp[i][j] = min(dp[i][j], *it);
                    }  
                    if (j == n && dp[i][j] != INT_MAX) return i;
                }
            }
            return -1;
        }
        public int makeArrayIncreasing(int[] a, int[] b) { // todo: 不知道这些写得是什么 
            List<Integer> aList = Arrays.stream(a).boxed().collect(Collectors.toList());
            aList.add(0,-1);
            aList.add(Integer.MAX_VALUE);
            a = aList.stream().mapToInt(i -> i).toArray();
            b = Arrays.stream(b).distinct().sorted().toArray();
            int[] dp = new int[a.length];
            Arrays.fill(dp,Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 0;
            for(int i = 2; i < a.length; i++){
                int cost = 0, j = i-1;
                int cur = a[j], next = a[i], bIdx = b.length-1;
                for(int start = 0; start < bIdx; ) {
                    int mid = (start + bIdx + 1) / 2;
                    if(b[mid] >= next) bIdx = mid -1;
                    else start = mid;
                }
                if (b[bIdx] >= next) bIdx = -1;
                while (true){
                    if(cur < next && dp[j] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[j] + cost);
                    while (bIdx >= 0 && b[bIdx] >= next) bIdx--;
                    if(bIdx < 0) break;
                    cost++;
                    if(--j < 0) break;
                    next = b[bIdx];
                    cur = a[j];
                }
                if(a[i-1] < a[i]) dp[i] = Math.min(dp[i], dp[i-1]);
            }
            return dp[a.length-1] != Integer.MAX_VALUE ? dp[a.length-1] : -1;
        }

        public int mergeStones(int[] s, int k) {
            int n = s.length;
            if ((n - 1) % (k - 1) != 0) return -1;
            int [][][] dp = new int[n + 1][n + 1][k + 1];
            int [] sum = new int[n + 1];
            for (int i = 1; i <= n; ++i) sum[i] = sum[i - 1] + s[i - 1];
            for (int i = 1; i <= n; ++i) {
                for (int j = i; j <= n; ++j) 
                    for (int m = 2; m <= k; ++m) dp[i][j][m] = Integer.MAX_VALUE / 2;
                dp[i][i][1] = 0;
            }
            for (int len = 2; len <= n; ++len) {         // 枚举区间长度
                for (int i = 1; i + len - 1 <= n; ++i) { // 枚举区间起点
                    int j = i + len - 1;
                    for (int m = 2; m <= k; ++m) { // 枚举堆数
                        for (int p = i; p < j; p += k - 1)  // 枚举分界点
                            dp[i][j][m] = Math.min(dp[i][j][m], dp[i][p][1] + dp[p + 1][j][m - 1]);
                    }
                    dp[i][j][1] = dp[i][j][k] + sum[j] - sum[i - 1];
                }
            }
            return dp[1][n][1];
        }
        public int mergeStones(int[] s, int k) {
            int n = s.length;
            if ((n - 1) % (k - 1) != 0) return -1;
            int [][] dp = new int [n+1][n+1];
            int [] sum = new int [n+1];
            for (int i = 1; i <= n; i++)  sum[i] = sum[i-1] + s[i-1];
            for (int len = k; len <= n; len++) // 枚举区间长度
                for (int i = 1; i+len <= n+1; i++) { // 枚举区间起点
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int p = i; p < j; p += k-1) // 枚举分界点
                        dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p+1][j]);
                    if ((j - i) % (k-1) == 0) dp[i][j] += sum[j] - sum[i-1];
                }
            return dp[1][n];
        }

        public int countPalindromicSubsequences(String s) {
            dp = new int [s.length()][s.length()];
            return dfs(s.toCharArray(), 0, s.length()-1);
        }
        int mod = (int)1e9 + 7;
        int [][] dp;
        private int dfs(char [] s, int i, int j) {
            if (i > j) return 0;
            if (i == j) return 1;
            if (dp[i][j] > 0) return dp[i][j];
            if (s[i] != s[j]) // 因为放在上面，下面这一行必须这么写防溢出
                return dp[i][j] = (int)(((dfs(s, i, j-1) + dfs(s, i+1, j)) % mod - dfs(s, i+1, j-1) + mod) % mod); // pay attention to mod
            long ans = 2 * dfs(s, i+1, j-1); // 这个题需要记住空上规律
            int l = i+1, r = j-1;
            while (l <= r && s[l] != s[i]) l++;
            while (l <= r && s[r] != s[j]) r--;
            if (l > r) ans += 2;        // s[i, j]中没有==s[i]==s[j]的字符
            else if (l == r) ans += 1;   // s[i, j]中有且仅有一个s[i]==s[j]的字符
            else ans -= dfs(s, l+1, r-1);// s[i, j]中至少有两个s[i]==s[j]的字符：s[l], s[r]
            // while (l < j && s[l] != s[i]) l++;
            // while (r > i && s[r] != s[j]) r--;                             // 上面的写法更简练一点
            // if (l == j) ans += 2;        // s[i, j]中没有==s[i]==s[j]的字符
            // else if (l == r) ans += 1;   // s[i, j]中有且仅有一个s[i]==s[j]的字符
            // else ans -= dfs(s, l+1, r-1);// s[i, j]中至少有两个s[i]==s[j]的字符：s[l], s[r]
            return dp[i][j] = (int)((ans + mod) % mod);
        }
        public int countPalindromicSubsequences(String t) {
            int n = t.length();
            int mod = (int)1e9 + 7;
            char [] s = t.toCharArray();
            long [][] dp = new long [n][n];
            for (int i = 0; i < n; i++) 
                dp[i][i] = 1;
            for (int len = 1; len <= n; len++) {
                for (int i = 0; i+len < n; i++) {
                    int j = i + len;
                    if (s[i] == s[j]) {
                        dp[i][j] = dp[i+1][j-1] * 2;
                        int l = i+1;
                        int r = j-1;
                        while (l <= r && s[l] != s[i]) ++l;
                        while (l <= r && s[r] != s[i]) --r;
                        if (l > r) dp[i][j] += 2;
                        else if (l == r) dp[i][j] += 1;
                        else dp[i][j] -= dp[l+1][r-1];
                    } else
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
            return (int)dp[0][n-1];
        }

        // https://leetcode-cn.com/problems/the-earliest-and-latest-rounds-where-players-compete/solution/zui-jia-yun-dong-yuan-de-bi-pin-hui-he-b-lhuo/
        // 3种情况是否可以统一呢？
        // 对于最后一种情况，我们有 f+s > n+1f+s>n+1，
        // 而「ff 在中间，ss 在右侧」和「ff 在右侧，ss 在右侧」也恰好满足 f+s > n+1f+s>n+1，
        // 并且所有不需要变换的情况都不满足 f+s > n+1f+s>n+1。
        // 因此我们只需要在 f+s > n+1 时，使用一次变换规则 F(n, f, s) = F(n, n+1-s, n+1-f) 就行
        public int [] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            min = new int [n+1][n+1][n+1];
            max = new int [n+1][n+1][n+1];
            if (firstPlayer < secondPlayer) return dfs(n, firstPlayer, secondPlayer);
            return dfs(n, secondPlayer, firstPlayer);
        }
        int [][][] min, max;
        private int [] dfs(int n, int f, int s) { // f: firstPlayer, // s: secondPlayer
            if (min[n][f][s] > 0) return new int [] {min[n][f][s], max[n][f][s]};
            if (f + s == n+1) return new int [] {1, 1}; // 刚好第一轮就可以碰上
            if (f + s > n + 1) { // 三种特殊情况的变换：
                int [] res = dfs(n, n+1 - s, n+1 - f);
                min[n][f][s] = res[0];
                max[n][f][s] = res[1];
                return res;
            }
            int glbMin = Integer.MAX_VALUE, glbMax = 0;
            int half = (n+1) >> 1;
            if (s <= half) // // 在左侧或者中间
                for (int i = 0; i < f; i++) // f左侧人数
                    for (int j = 0; j < s-f; j++) { // f和s之间的人数
                        int [] res = dfs(half, i+1, i+j+2);
                        glbMin = Math.min(glbMin, res[0]);
                        glbMax = Math.max(glbMax, res[1]);
                    }
            else {// s在右侧
                int s_prime = n + 1 - s;
                int mid = (n - 2 * s_prime + 1) / 2;
                for (int i = 0; i < f; i++) 
                    for (int j = 0; j < s_prime - f; j++) { // s': n+1-s
                        int [] res = dfs(half, i+1, i+j+2 + mid);
                        // int [] res = dfs(half, i+1, i+j+2+(s*2-n-1)/2);
                        glbMin = Math.min(glbMin, res[0]);
                        glbMax = Math.max(glbMax, res[1]); 
                    }
            }
            min[n][f][s] = glbMin + 1;
            max[n][f][s] = glbMax + 1;
            return new int [] {glbMin + 1, glbMax + 1};
        }
        int [][][] min, max;
        public int [] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            min = new int [n+1][n+1][n+1];
            max = new int [n+1][n+1][n+1];
            if (firstPlayer < secondPlayer) return dfs(n, firstPlayer, secondPlayer);
            return dfs(n, secondPlayer, firstPlayer);
        }

        public int countSpecialSubsequences(int[] A) {
            int dp[] = new int[3], mod = 1_000_000_007;
            for (int a: A)
                dp[a] = ((dp[a] + dp[a]) % mod + (a > 0 ? dp[a-1] : 1)) % mod;
            return dp[2];
        }
        static long mod = (int)1e9 + 7;
        public int countSpecialSubsequences(int [] a) {
            long ooo = 0, one = 0, two = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) ooo = (ooo * 2l + 1) % mod;
                else if (a[i] == 1) one = (one * 2l + ooo) % mod;
                else two = (two * 2l + one) % mod;
            }
            return (int)(two % mod);
        }
        public int countSpecialSubsequences(int [] a) {
            int n = a.length;
            long [][] f = new long [2][3];
            f[0][0] = (a[0] == 0 ? 1 : 0);
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 3; j++) 
                    if (a[i] == j) {
                        if (j == 0)
                            f[i%2][j] = (2 * f[(i-1) % 2][j] + 1) % mod;
                        else f[i%2][j] = (2 * f[(i-1) % 2][j] + f[(i-1) % 2][j-1]) % mod;
                    } else f[i%2][j] = f[(i-1) % 2][j];
            return (int)(f[(n-1) % 2][2] % mod);
        }
        public int countSpecialSubsequences(int [] a) {
            int n = a.length;
            long [][] f = new long [n][3];
            f[0][0] = (a[0] == 0 ? 1 : 0);
            for (int i = 1; i < n; i++) 
                for (int j = 0; j < 3; j++) 
                    if (a[i] == j) {
                        if (j == 0)
                            f[i][j] = (2 * f[i-1][j] + 1) % mod;
                        else f[i][j] = (2 * f[i-1][j] + f[i-1][j-1]) % mod;
                    } else f[i][j] = f[i-1][j];
            return (int)(f[n-1][2] % mod);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();


        
        // int []  a = new int []  {0, 1, 2, 2};
        // int [] a = new int [] {2,2,0,0};
        // int [] a = new int [] {0,1,2,0,1,2};
        int []  a = new int []  {2, 0, 0, 1, 2, 0, 2, 1, 2, 2, 2, 2, 2, 2, 1, 0, 2, 0, 2, 2, 1, 1, 2, 1, 1, 0, 1, 0, 2, 1, 2, 0, 1, 2, 1, 2, 0, 0, 2, 0, 2, 1, 0, 0, 0, 1, 1, 0, 1, 2, 1, 2, 2, 0, 1, 2, 0, 0, 1, 2, 1, 1, 2, 0, 1, 2, 1, 0, 1, 0, 1, 1, 2, 0, 0, 0, 1, 1, 1, 2, 1, 0, 0, 0, 0, 2, 2, 1, 1, 1, 2, 1, 2, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 2, 1, 1, 0, 0, 2, 0, 2, 2, 1, 0, 2, 2, 2, 0, 0, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 0, 2, 0, 1, 0, 2, 0, 2, 0, 0, 1, 2, 1, 1, 0, 2, 0, 1, 0, 2, 1, 1, 0, 0, 1, 1, 0, 1, 0, 2, 1, 2, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 0, 2, 2, 2, 1, 0, 0, 0, 1, 1, 0, 2, 1, 1, 2, 1, 0, 1, 0, 0, 2, 1, 0, 2, 1, 1, 1, 0, 2, 2, 2, 1, 1, 0, 2, 1, 0, 1, 0, 0, 2, 1, 2, 0, 0, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 0, 0, 2, 0, 1, 0, 0, 0, 2, 1, 1, 2, 1, 1, 0, 0, 2, 0, 1, 2, 1, 1, 1, 0, 2, 1, 1, 0, 0, 1, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 0, 1, 0, 2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 0, 2, 2, 0, 0, 2, 0, 1, 2, 2, 2, 2, 0, 1, 1, 0, 0, 1, 2, 0, 2, 2, 1, 1, 1, 0, 1, 1, 0, 1, 1, 2, 0, 2, 0, 1, 1, 0, 0, 2, 0, 2, 1, 2, 1, 1, 0, 0, 2, 2, 1, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 1, 1, 1, 1, 2, 0, 1, 1, 0, 0, 0, 1, 0, 2, 1, 0, 2, 0, 1, 0, 2, 0, 1, 1, 2, 2, 0, 1, 0, 0, 2, 1, 1, 2, 1, 1, 2, 2, 0, 1, 2, 0, 2, 2, 0, 0, 2, 0, 0, 2, 2, 2, 2, 2, 0, 1, 2, 0, 1, 0, 1, 1, 0, 1, 1, 2, 1, 0, 1, 2, 1, 2, 1, 1, 1, 2, 2, 1, 0, 1, 1, 2, 2, 2, 0, 0, 1, 2, 1, 2, 2, 1, 1, 0, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 0, 0, 0, 2, 2, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 2, 0};

        int r = s.countSpecialSubsequences(a);
        System.out.println("r: " + r);
    }
}
