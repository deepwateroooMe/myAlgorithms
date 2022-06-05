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

        Iterator<Integer> it;
        Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            this.it = iterator;
            if (it.hasNext())
                next = it.next();
        }
        public Integer peek() {
            return next;
        }
        @Override
        public Integer next() {
            Integer res = next;
            next = it.hasNext() ? it.next() : null;
            return res;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }


        int [] arr;
        int idx;
        public RLEIterator(int[] encoding) {
            idx = 0;
            this.arr = Arrays.copyOf(encoding, encoding.length);
        }
        public int next(int n) {
            int cnt = 0;
            while (cnt < n) {
                while (idx < arr.length-1 && cnt < n) {
                    if (arr[idx] >= n-cnt) {
                        arr[idx] -= n-cnt;
                        return arr[idx+1];
                    } else {
                        cnt += arr[idx];
                        arr[idx] = 0;
                        idx += 2;
                    }
                }
                if (idx == arr.length) break;
            }
            return -1;
        }

        
        public boolean sumGame(String t) {
            int n = t.length(), m = n / 2, ca = 0, cb = 0, sa = 0, sb = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < m; i++) 
                if (s[i] != '?') sa += s[i] - '0';
                else ca++;
            for (int i = m; i < n; i++) 
                if (s[i] != '?') sb += s[i] - '0';
                else cb++;
            System.out.println("sa: " + sa);
            System.out.println("ca: " + ca);
            System.out.println("sb: " + sb);
            System.out.println("cb: " + cb);
            if (ca == 0 && cb == 0) return sa != sb; // 这个里面的策略还要再想一想
            if (ca == 0 || cb == 0) {
                if (ca == 0) {
                    if (sa < sb) return true;
                }
            }
            return true;
        } 


        private boolean dfs(int i, int cnt) { // memory limit reached
            if (dp[i][cnt] != null) return dp[i][cnt];
            if (cnt == 0) return i == 1;
            if (i == 0) { // my turn
                for (int j = 1; j <= Math.min(3, cnt); j++) 
                    if (dfs(1-i, cnt-j)) return dp[i][cnt] = true;
                return  dp[i][cnt] = false;
            } else {
                for (int j = 1; j <= Math.min(3, cnt); j++) 
                    if (!dfs(1-i, cnt-j)) return dp[i][cnt] = false;
                return dp[i][cnt] = true;
            }
        }
        Boolean [][] dp;
        public boolean canWinNim(int n) {
            dp = new Boolean [2][n+1];
            return dfs(0, n);
        }
        public boolean canWinNim(int n) { // 终于该要学习动态规划，以及空间压缩了。。。。。。 
            // if (n == 0) return false;
            // if (n < 4) return true;
            // boolean [] dp = new boolean[6];
            // dp[0] = false;
            // for (int i = 1; i <= 3; i++) 
            //     dp[i] = true;
            // for (int cur = 4; cur <= n; cur++) {
            //     int i = 1;
            //     for (i = 1; i <= 3; i++) //依次尝试拿走 1,2,3 个
            //         if (dp[(cur-i-1) % 6] && dp[(cur-i-2) % 6] && dp[(cur-i-3) % 6]) { //对方拿走 1 个，2 个，3 个, 你都有稳赢的策略
            //             dp[cur % 6] = true;
            //             break;
            //         } // 数组在循环使用，所以如果内层的 for 循环尝试了所有情况都不行的话，我们要将当前值置为 false ，因为它之前可能是 true。
            //     if (i == 4) dp[cur % 6] = false; // 因为压缩空间带来的问题
            // }
            // return dp[n % 6];
            return n % 4 != 0;
        }


        public int reverseBits(int n) { // bug
            String t = "" + n;
            char [] s = t.toCharArray();
            String ans = "";
            for (int i = 0; i < s.length; i++) 
                ans += "" + ((char)(1 - s[i]-'0') + '0');
            return new BigInteger(ans, 2).intValue();
        }

        public int hammingWeight(int n) {
            int cnt = 0;
            for (int i = 31; i >= 0; i--) 
                if (((n >> i) & 1) == 1) cnt++;
            return cnt;
        }


        public boolean isHappy(int n) {
            int v = 0, cnt = 1000;
            while (n > 0 && cnt > 0) {
                while (n > 0) {
                    v += (n % 10) * (n % 10);
                    n /= 10;
                }
               cnt--;
                if (v == 1) return true;
                n = v;
                v = 0;
            }
            return false;
        }


        public boolean isIsomorphic(String ss, String tt) {
            int n = ss.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            Set<Character> chs = new HashSet<>();
            Map<Character, Character> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!m.containsKey(s[i]) && !chs.contains(t[i])) {
                    m.put(s[i], t[i]);
                    chs.add(t[i]);
                } else if (!m.containsKey(s[i]) && chs.contains(t[i]))
                    return false;
                if (m.get(s[i]) == t[i]) continue;
                if (m.get(s[i]) != t[i])
                    return false;
             }
            return true;
        }


        public boolean containsDuplicate(int[] arr) {
            int n = arr.length;
            Set<Integer> s = new HashSet<>();
            for (Integer v : arr) 
                if (!s.add(v)) return true;
            return false;
        }


        public boolean containsNearbyDuplicate(int[] arr, int k) {
            int n = arr.length;
            Map<Integer, List<Integer>> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                m.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
                int v = m.get(arr[i]).size();
                if (v >= 2 && i - m.get(arr[i]).get(v-2) <= k)
                    return true;
            }
            return false;
        }


        public int computeArea(int ai, int aj, int bi, int bj, int xi, int xj, int yi, int yj) {
            if (bi < xi || yi < ai || yj < aj || bj < xj) { // no overlap, left right up down
                return (bi - ai) * (bj - aj) + (yi - xi) * (yj - xj);
            } else if (xi >= ai && xj >= aj && yi <= bi && yj <= bj // one inside the other
                       || xi <= ai && xj <= aj && bi <= yi && bj <= yj) {
                if (ai <= xi && yj <= bj) 
                    return (bi - ai) * (bj - aj);
                return (yi - xi) * (yj - xj);
            } else { // overlaps
            }
        }

        ArrayDeque<Integer> s;
        public MyStack() {
            s = new ArrayDeque<>();
        }
        public void push(int x) {
            s.push(x);
        }
        public int pop() {
            return s.pop();
        }
        public int top() {
            return s.peek();
        }
        public boolean empty() {
            return s.isEmpty();
        }


        public List<String> summaryRanges(int[] a) {
            List<String> l = new ArrayList<>();
            int n = a.length, j = 0, i = 0;
            if (n == 0) return l;
            while (i < n) {
                j = i;
                while (i < n-1 && a[i+1] == a[i] + 1) i++;
                if (i == j)
                    l.add(""+a[i]);
                else {
                    String cur = "" + a[j] + "->" +  a[i];
                    l.add(cur);
                }
                i++;
            }
            return l;
        }

        Stack<Integer>[] s;
        int idx;
        public MyQueue() {
            s = new Stack[2];
            for (int i = 0; i < 2; i++) 
                s[i] = new Stack<>();
            idx = 0;
        }
        public void push(int x) {
            if (s[idx].isEmpty()) {
                s[idx].push(x);
                return;
            }
            while (!s[idx].isEmpty()) s[1-idx].push(s[idx].pop());
            idx = 1 - idx;
            s[idx].push(x);
            while (!s[idx].isEmpty()) s[1-idx].push(s[idx].pop());
            idx = 1 - idx;
        }
        public int pop() {
            return s[idx].pop();
        }
        public int peek() {
            return s[idx].peek();
        }
        public boolean empty() {
            return s[idx].isEmpty();
        }


        public boolean isAnagram(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            if (m != n) return false;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            Map<Character, Integer> ms = new HashMap<>();
            Map<Character, Integer> mt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                ms.put(s[i], ms.getOrDefault(s[i], 0) + 1);
                mt.put(t[i], mt.getOrDefault(t[i], 0) + 1);
            }
            if (ms.size() != mt.size()) return false;
            for (Map.Entry<Character, Integer> en : ms.entrySet()) {
                char k = en.getKey();
                int v = en.getValue();
                if (!mt.containsKey(k) || mt.get(k) != v) return false;
            }
            return true;
        }


        public int addDigits(int num) {
            String s = "" + num;
            while (s.length() > 1) {
                int v = 0;
                for (int i = 0; i < s.length(); i++) 
                    v += s.charAt(i) - '0';
                s = "" + v;
            }
            return Integer.parseInt(s);
        }


        public boolean isUgly(int n) {
            if (n <= 0) return false;
            if (n <= 5) return true;
            int [] p = {2, 3, 5};
            while (n > 5 && n % 5 == 0) n /= 5;
            while (n > 3 && n % 3 == 0) n /= 3;
            while (n > 2 && n % 2 == 0) n /= 2;
            return (n == 2 || n == 3 || n == 5);
        }


        public int missingNumber(int[] a) {
            Set<Integer> s = new HashSet<>();
            s.addAll(Arrays.stream(a).boxed().collect(Collectors.toList()));
            int n = Arrays.stream(a).max().getAsInt();
            for (int i = 0; i <= n; i++)
                if (!s.contains(i)) return i;
            return n+1;
        }


        public int hIndex(int[] a) {
            if (a.length == 1) return a[0] >= 1 ? 1 : 0;
            Arrays.sort(a);
            int l = 1, h = a.length;
            while (l < h) {
                int m = (l + h) / 2, cnt = 0;
                for (int i = 0; i < a.length; i++) 
                    if (a[i] >= m) cnt++;
                if (cnt >= m) l = m;
                else h = m-1;
            }
            return l;
        }

        public int firstBadVersion(int n) {
            int l = 1, r = n;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (isBadVersion(m)) r = m-1;
                else l = m + 1;
            }
            return isBadVersion(l) ? l : l + 1;
        }

        
        public void moveZeroes(int[] a) {
            int idx = 0;
            for (int i = 0; i < a.length; i++) 
                if (a[i] != 0) 
                    a[idx++] = a[i];
            for (int i = idx; i < a.length; i++)
                a[i] = 0;
        }

        public void gameOfLife(int[][] a) {
            int [][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            int m = a.length, n = a[0].length, cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cnt = 0;
                    for (int [] d : dirs) {
                        int x = i + d[0], y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) continue;
                        if (a[x][y] == 1 || a[x][y] == -1) cnt++;
                    }
                    if (a[i][j] == 1 && (cnt < 2 || cnt > 3)) a[i][j] = -1;
                    else if (cnt == 3 && a[i][j] == 0) a[i][j] = 2;
                }
            }
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    if (a[i][j] == -1) a[i][j] = 0;
                    else if (a[i][j] == 2) a[i][j] = 1;
        }


        public boolean wordPattern(String pattern, String ss) {
            char [] s = pattern.toCharArray();
            String [] t = ss.split("\\s+");
            int n = pattern.length(), m = t.length;
            if (m != n) return false;
            Map<Character, String> map = new HashMap<>();
            Set<String> vis = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(s[i])) {
                    if (vis.contains(t[i])) return false;
                    map.put(s[i], t[i]);
                    vis.add(t[i]);
                }
                if (!map.get(s[i]).equals(t[i])) return false;
            }
            return true;
        }

        int [] arr, sum;
        int n;
        public NumArray(int[] a) {
            n = a.length;
            arr = Arrays.copyOf(a, n);
            sum = Arrays.copyOf(arr, n);
            for (int i = 1; i < n; i++) 
                sum[i] += sum[i-1];
        }
        public int sumRange(int left, int right) {
            return sum[right] - (left == 0 ? 0 : sum[left-1]);
        }

        int [][] a, sum;
        int m, n;
        public NumMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            a = new int [m][];
            for (int i = 0; i < m; i++)
                a[i] = Arrays.copyOf(mat[i], n);
            sum = new int [m+1][n+1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
        }
        public int sumRegion(int i, int j, int x, int y) {
            return sum[x+1][y+1] - sum[x+1][j] - sum[i][y+1] + sum[i][j];
        }

        public String reverseVowels(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            char [] ow = "aeiouAEIOU".toCharArray();
            Set<Character> sc = new HashSet<Character>();
            for (Character c : ow) 
                sc.add(c);
            int i = 0, j = n-1;
            while (i < j) {
                while (i < j && !sc.contains(s[i])) i++;
                while (j > i && !sc.contains(s[j])) j--;
                char c = s[i];
                s[i] = s[j];
                s[j] = c;
                i++;
                j--;
            }
            return new String (s);
        }

        public int[] intersect(int[] a, int[] b) {
            int [] ca = new int [1001];
            int [] cb = new int [1001];
            for (int i = 0; i < a.length; i++) 
                ca[a[i]]++;
            for (int i = 0; i < b.length; i++) 
                cb[b[i]]++;
            for (int i = 0; i < 1001; i++) {
                if (ca[i] == 0 && cb[i] == 0) continue;
                if (ca[i] != cb[i]) ca[i] = Math.min(ca[i], cb[i]);
            }
            int sum = Arrays.stream(ca).sum();
            int [] ans = new int [sum];
            int idx = 0;
            for (int i = 0; i < 1001; i++) {
                if (ca[i] == 0) continue;
                while (ca[i]-- > 0) ans[idx++] = i;
            }
            return ans;
        }

        public boolean isPerfectSquare(int v) {
            if (v == 1) return true;
            int l = 2, r = v;
            while (l < r) {
                int m = l + (r - l) / 2;
                long tmp = m * m;
                if (m * m == (long)v) return true;
                if (m * m > (long)v) r = m-1;
                else l = m + 1;
            }
            return l * l == v ? true : false;
        }

        private void divideByTwo(int [] a) {
            int n = a.length, re = 0;
            for (int i = 0; i < n; i++) {
                int cur = a[i] + re;
                if (cur % 2 == 1) re = 1;
                else re = 0;
                a[i] = cur / 2;
            }
            int i = 0;
            while (i < n && a[i] == 0) i++;
            System.arraycopy(a, 0, a, i, n-i);
        }
        public int superPow(int a, int[] b) {
            int mod = 1337, n = b.length, idx = n-1;
            long ans = 1, base = a;
            while (idx >= 0 && b[idx] > 0) {
                if (b[idx] % 2 == 1) 
                    ans = (ans * base) % mod;
                while (b[idx] % 2 == 0) {
                    ans = (ans * base) % (long)mod;
                    divideByTwo(b);
                    base *= base;
                    if (b[idx] == 0) idx -= 1;
                }
            }
            return (int)ans;
        }


    Map<Integer, Integer> m;
    Map<Integer, Integer> n;
    Set<Integer> s; 
    Random rand;
    int idx;
    public RandomizedSet() {
        m = new HashMap<>();
        n = new HashMap<>();
        s = new HashSet<>();
        rand = new Random();
        idx = -1;
    }
    public boolean insert(int val) {
        if (s.add(val)) {
            m.put(++idx, val);
            n.put(val, idx);
            return true;
        }
        return false;
    }
    public boolean remove(int val) {
        if (!s.contains(val)) return false;
        m.put(n.get(val), m.get(idx));
        n.put(m.get(idx), n.get(val));
        m.remove(idx);
        n.remove(val);
        s.remove(val);
        --idx;
        return true;
    }
    public int getRandom() {
        if (m.size() == 1) return m.get(0);
        int v = rand.nextInt(idx+1);
        return m.get(v);
    }


        public boolean canConstruct(String ransomNote, String magazine) {
            int m = ransomNote.length(), n = magazine.length();
            char [] s = ransomNote.toCharArray();
            char [] t = magazine.toCharArray();
            int [] one = new int [26];
            int [] two = new int [26];
            for (int i = 0; i < m; i++) 
                one[s[i]-'a']++;
            for (int i = 0; i < n; i++) 
                two[t[i]-'a']++;
            for (int i = 0; i < 26; i++) 
                if (one[i] > two[i]) return false;
            return true;
        }


        public int firstUniqChar(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] cnt = new int [26];
            int [] idx = new int [26];
            Arrays.fill(idx, -1);
            for (int i = 0; i < n; i++) {
                if (idx[s[i]-'a'] == -1) idx[s[i]-'a'] = i;
                cnt[s[i]-'a']++;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == -1) continue;
                if (cnt[i] == 1 && idx[i] < min) min = idx[i];
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public char findTheDifference(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int [] one = new int [26];
            int [] two = new int [26];
            for (int i = 0; i < m; i++) 
                one[s[i]-'a']++;
            for (int i = 0; i < n; i++) 
                two[t[i]-'a']++;
            for (int i = 0; i < 26; i++) 
                if (Math.abs(one[i] - two[i]) == 1)
                    return (char)('a' + i);
            return ' ';
        }


        private String processInput(String t) {
            char [] s = t.toCharArray();
            // 由于第一个和最后一个字符都是#号，且也需要搜索回文，为了防止越界，我们还需要在首尾再加上非#号字符，实际操作时我们还需给开头加上个非#号字符'$'，结尾加一个'@'
            String ans = "$#"; // 不论原字符串是奇数还是偶数个，处理之后得到的字符串的个数都是奇数个，这样就不用分情况讨论了
            for (int i = 0; i < t.length(); i++) 
                ans += s[i] + "#";
            ans += "@";
            return ans;
        }
        private String processInput(String t) {
            char [] s = t.toCharArray();
            String ans = "$#";
            for (int i = 0; i < s.length; i++) 
                ans += s[i] + "#";
            ans += "@";
            return ans;
        }
        public int longestPalindrome(String t) { // 马拉车算法： 半生不熟
            int m = t.length();
            t = processInput(t);
            char [] s = t.toCharArray();
            int n = s.length;
            int r = 0, idx = 0, max = 0, maxIdx = 0;
            int [] len = new int [n];
            for (int i = 1; i < n-1; i++) {
                len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1; // 2*idx-i: j 是i关于idx的对称点坐标 idx-(i-idx)
                while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]]) // s[n-1] = '@'
                    ++len[i];
                max = Math.max(max, len[i]);
                if (r < len[i] + i) {
                    r = i + len[i];
                    idx = i;
                }
                // System.out.println(Arrays.toString(len));
            }
            return (max-1) * 2 - 1;
        }
        public int longestPalindrome(String t) {
            int m = t.length();
            t = processInput(t);
            char [] s = t.toCharArray();
            int n = s.length;
            // 如何求 len 数组，需要新增两个辅助变量 r 和 idx，其中 idx 为最大回文子串中心的位置，r 是回文串能延伸到的最右端的位置
            int r = 0, idx = 0; // 最大右边界、最大回文串的中心位置
            int [] len = new int [n];
            for (int i = 1; i < n-1; i++) {
                len[i] = r > i ? Math.min(len[2*idx-i], r-i) : 1;
                while (i + len[i] < n-1 && i - len[i] >= 0 && s[i+len[i]] == s[i-len[i]])
                    ++len[i];
                if (r < len[i]+i) {
                    r = len[i] + i;
                    idx = i;
                }
            }
        }
        public int longestPalindrome(String t) {
            int n = t.length();
            if (n == 1) return 1;
            char [] s = t.toCharArray();
            int [] cnt = new int [n];
            Arrays.fill(cnt, 1);
            int j = 0, k = 0, l = 0, max = 0;
            for (int i = 0; i < n; i++) {
                System.out.println("\n i: " + i);
                System.out.println("s[i]: " + s[i]);
                j = i;
                k = i+1;
                l = 0;
                while (j >= 0 && k < n && s[j--] == s[k++]) l += 2;
                cnt[i] = Math.max(cnt[i], l);
                System.out.println("cnt[i]: " + cnt[i]);
                j = i-1;
                k = i+1;
                l = 1;
                while (j >= 0 && k < n && s[j--] == s[k++]) l += 2;
                cnt[i] = Math.max(cnt[i], l);
                max = Math.max(max, cnt[i]);
                System.out.println("cnt[i]: " + cnt[i]);
                System.out.println("max: " + max);
            }
            return max;
        }
        public int longestPalindrome(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [][] cnt = new int [2][26];
            for (int i = 0; i < n; i++)
                if (Character.isLowerCase(s[i]))
                    cnt[0][s[i]-'a']++;
                else cnt[1][s[i]-'A']++;
            boolean hasOdd = false;
            int ans = 0;
            for (int i = 0; i < 2; i++) 
                for (int j = 0; j < 26; j++) 
                    if (cnt[i][j] % 2 == 0) ans += cnt[i][j];
                    else if (cnt[i][j] > 0 && cnt[i][j] % 2 == 1) {
                        hasOdd = true;
                        ans += cnt[i][j] - 1;
                    }
            return ans + (hasOdd ? 1 : 0);
        }

        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 &&  i % 5 == 0) ans.add("FizzBuzz");
                else if (i % 3 == 0) ans.add("Fizz");
                else if (i % 5 == 0) ans.add("Buzz");
                else ans.add(""+i);
            }
            return ans;
        }

        public int thirdMax(int[] a) {
            int max = Integer.MIN_VALUE, sec = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
            Set<Integer> vis = new HashSet<>();
            boolean imi = false;
            for (int i = 0; i < a.length; i++) {
                // System.out.println("\n a[i]: " + a[i]);
                if (vis.contains(a[i])) continue;
                if ( a[i] > max) {
                    if (sec == Integer.MIN_VALUE) {
                        sec = max;
                    } else if (ans == Integer.MIN_VALUE) {
                        ans = sec;
                        sec = max;
                        if (ans == Integer.MIN_VALUE) imi = true;
                    } 
                    max = a[i];
                } else if (a[i] > sec) {
                    ans = sec;
                    sec = a[i];
                } else if (a[i] > ans) ans = a[i];
                vis.add(a[i]);
                // System.out.println("max: " + max);
                // System.out.println("sec: " + sec);
                // System.out.println("ans: " + ans);
            }
            return ans == Integer.MIN_VALUE && !imi ? max : ans;
        }


        public String addStrings(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i = m-1, j = n-1, cur = 0, cri = 0;
            while (i >= 0 && j >= 0) {
                cur = s[i] - '0' + t[j] - '0' + cri;
                sb.append((char)(cur % 10 + '0'));
                cri = cur / 10;
                i--;
                j--;
            }
            if (i >= 0) 
                while (i >= 0) {
                    cur = s[i] - '0' + cri;
                    sb.append((char)(cur % 10 + '0'));
                    cri = cur / 10;
                    i--;
                } 
            else if (j >= 0) 
                while (j >= 0) {
                    cur = t[j] - '0' + cri;
                    sb.append((char)(cur % 10 + '0'));
                    cri = cur / 10;
                    j--;
                }
            if (cri > 0) sb.append((char)(cri + '0'));
            return sb.reverse().toString();
        }

        
        private boolean isValid(char [] s) {
            int n = s.length, cl = 0, cu = 0, cd = 0;
            for (char c : s) {
                if (Character.isLowerCase(c)) cl++;
                else if (Character.isDigit(c)) cd++;
                else if (Character.isUpperCase(c)) cu++;
            }
            if (cl == 0 || cd == 0 || cu = 0) return false;
            int cnt = 1, i = 0, j  = 0;
            while (i < n) {
                if (i < n-1 && s[i] == s[i+1]) {
                    cnt = 1;
                    while (i < n-1 && s[i] == s[i+1]) {
                        cnt++;
                        if (cnt == 3) return false;
                        i++;
                    }
                    if (i == n-1) return true;
                }
                while (i < n-1 && s[i] != s[i+1]) i++;
            }
            return true;
        }
        public int strongPasswordChecker(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            if (n >= 6 && n <= 20 && isValid(s)) return 0;
            if (n < 3) return 6-n;
            if (n >= 3 && n < 6) {
            }
        }

        public int countSegments(String s) {
            s = s.replaceFirst("^\\s*", "");
            if (s == null || s.length() == 0) return 0;
            return s.split("\\s+").length;
        }

        public int arrangeCoins(int n) {
            int ans = 0, cnt = n, i = 1;
            while (cnt >= i) {
                cnt -= i;
                ans++;
                i++;
            }
            return ans;
        }

        public List<Integer> findDisappearedNumbers(int[] a) {
            List<Integer> l = new ArrayList<>();
            Arrays.sort(a);
            int cur = 1;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == cur) {
                    cur++;
                    continue;
                } else if (a[i] > cur) {
                    for (int j = cur; j < a[i]; j++) 
                        l.add(j);
                    cur = a[i] + 1;
                } 
            }
            if (cur <= a.length) 
                for (int i = cur; i <= a.length; i++) 
                    l.add(i);
            return l;
        }

        public boolean isSelfCrossing(int [] d) {
            int n = d.length;
            if (n < 4) return false;
            for (int i = 3; i < n; i++) { // 4 >= 2 && 1 >= 3
                // if (i % 3 == 0 && d[i] >= d[i-2] && d[i-3] >= d[i-1]) return true; 
                // else if (i % 4 == 0 && d[i-1] == d[i-3] && d[i] >= d[i-2] - d[i-4]) return true; // 2 == 4 && 5 >= 3-1
                // else if (i % 5 == 0 && d[i-2] >= d[i-4] && d[i-3] >= d[i-1] && d[i-1] >= d[i-3] - d[i-5] && d[i] >= d[i-2] - d[i-4])
                    if (d[i] >= d[i-2] && d[i-3] >= d[i-1]) return true; 
                    else if (i >= 4 && d[i-1] == d[i-3] && d[i] >= d[i-2] - d[i-4]) return true; // 2 == 4 && 5 >= 3-1
                    else if (i >= 5 && d[i-2] >= d[i-4] && d[i-3] >= d[i-1] && d[i-1] >= d[i-3] - d[i-5] && d[i] >= d[i-2] - d[i-4])
                    return true;
                // else if (i % 6 == 0 && d[i-4] + d[i] >= d[i-2] && d[i-1] <= d[i-3] && d[i-5] + d[i-1] >= d[i-3]) return true; // 这个条件不对
            }
            return false;
        }

        public boolean isRectangleCover(int[][] rectangles) { // bug
            int ai = Integer.MAX_VALUE, aj = Integer.MAX_VALUE, bx = 0, by = 0, sum = 0;
            int li = 0, lj = 0, rx = 0, ry = 0;
            for (int [] a : rectangles) {
                System.out.println(Arrays.toString(a));
                int i = a[0], j = a[1], x = a[2], y = a[3];
                int ti = x, tj = j, tx = i, ty = y;
                if (ti <= li && tj >= lj) {
                    li = ti;
                    lj = tj;
                }
                if (tx <= rx && ty >= ry) {
                    rx = tx;
                    ry = ty;
                }
                sum += (x - i) * (y - j);
                if (i <= ai && j <= aj) {
                    ai = i;
                    aj = j;
                }
                if (x >= bx && y >= by) {
                    bx = x;
                    by = y;
                }
            }
            return sum == (bx - ai) * (by - aj) && li == bx && lj == aj && rx == ai && ry == by;
        }
        public boolean isRectangleCover(int[][] rectangles) {
            Map<String, Integer> m = new HashMap<>();
            for (int [] a : rectangles) 
                for (int i = 0; i < 4; i++) {
                    String tmp = Integer.toString(a[i/2*2]) + "," + Integer.toString(a[i % 2 * 2 + 1]); // 
                    if ((m.getOrDefault(tmp, 0) & (1 << i)) > 0) return false;
                    m.put(tmp, m.getOrDefault(tmp, 0) | (1 << i));
                }
            int cntCorner = 0;
            for (Map.Entry<String, Integer> en : m.entrySet()) {
                int v = en.getValue();
                if ((v & (v -1)) == 0 && cntCorner++ > 4) return false;
                if ((v & (v-1)) > 0 && !(v == 3 || v == 12 || v == 5 || v == 10 || v ==  15))
                    return false;
            }
            return true;
        }
        public boolean isRectangleCover(int[][] rectangles) {
            Set<String> st = new HashSet<>();
            int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, sum = 0;
            for (int [] a : rectangles) {
                i = Math.min(i, a[0]);
                j = Math.min(j, a[1]);
                x = Math.max(x, a[2]);
                y = Math.max(y, a[3]);
                sum += (a[2] - a[0]) * (a[3] - a[1]); 
                String e = a[0] + "_" + a[1]; // bot - left
                String b = a[0] + "_" + a[3]; // top - left
                String c = a[2] + "_" + a[3]; // top - right
                String d = a[2] + "_" + a[1]; // bot - right
                if (st.contains(e)) st.remove(e); else st.add(e);
                if (st.contains(b)) st.remove(b); else st.add(b);
                if (st.contains(c)) st.remove(c); else st.add(c);
                if (st.contains(d)) st.remove(d); else st.add(d);
            }
            String a = i + "_" + j;
            String b = i + "_" + y;
            String c = x + "_" + y;
            String d = x + "_" + j;
            if (!st.contains(a) || !st.contains(b) || !st.contains(c) || !st.contains(d) || st.size() != 4)
                return false;
            return sum == (y - j) * (x - i);
        }

        public List<Integer> fallingSquares(int[][] p) {
            List<Integer> ans = new ArrayList<>();
            int n = p.length, cur = 0;
            int [] hi = new int [n];
            for (int i = 0; i < n; i++) {
                int len = p[i][1], l = p[i][0], r = l + len;
                hi[i] += len;
                for (int j = i+1; j < n; j++) { // 采用brute force的思想，对于每个一个下落的方块，我们都去看和后面将要落下的方块有没有重叠
                    int ll = p[j][0], rr = ll + p[j][1]; // 有的话，和后面将要落下的方块的位置相比较，取二者中较大值为后面要落下的方块位置高度heights[j]
                    // [[6,1],[9,2],[2,4]] 因为不能保证是从左往下延x轴顺序掉落，所以加上l < rr 也狠重要 确保不管左右边有交叠
                    if (ll < r && l < rr) // 判读两个方块是否重叠的方法是如果方块2的左边界小于方块1的右边界，并且方块2点右边界大于方块1点左边界
                        hi[j] = Math.max(hi[j], hi[i]); // 这里提前检查是否重叠，是为后来的更新打下base,再接下来遍历i时直接累加就可以了
                }
            }
            for (int v : hi) {
                cur = Math.max(cur, v);
                ans.add(cur);
            }
            return ans;
        }
        class SegTree {  // 实现一下带懒标记的线段树: 这棵树好强大
            class Node { // v是[l, r]区间的最大值，lazy是懒标记
                int l, r, v, lazy;
                public Node(int l, int r) {
                    this.l = l;
                    this.r = r;
                }
            }
            private Node [] tr;
            public SegTree(int size) {
                tr = new Node[size << 2]; // * 4
                build(1, 0, size - 1);
            }
            public void build(int u, int l, int r) { // 下标从1开始 自顶向下
                tr[u] = new Node(l, r);
                if (l == r) return;
                int mid = l + r >> 1; // / 2
                build(u << 1, l, mid);         // 分别构建左右子树
                build(u << 1 | 1, mid + 1, r);
            }
            private void pushup(int u) { // 最大树： 当前节点的值为左右子节点的最大值
                tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
            }
            private void pushdown(int u) { // 下传懒标记 
                int c = tr[u].lazy;
                if (c != 0) {
                    tr[u].lazy = 0;
                    tr[u << 1].v = tr[u << 1 | 1].v = c; // 根据父节点的值，懒标记下传一层，更新左右子树的值，并更新下传而来的标记
                    tr[u << 1].lazy = tr[u << 1 | 1].lazy = c;
                }
            }
            public void update(int u, int l, int r, int c) {
                // for (int i = 1; i < tr.length; i++)
                //     if (tr[i] != null)
                //         System.out.println("[" + tr[i].l + "," + tr[i].r + "], v: " + tr[i].v + ", lazy: " + tr[i].lazy);

                if (l <= tr[u].l && tr[u].r <= r) { // 任务不需要下发，可以用懒标记懒住
                    tr[u].v = tr[u].lazy = c;       // 整棵树落在左右区间内，可以发懒，暂不下传
                    // System.out.println("[" + tr[u].l + "," + tr[u].r + "], v: " + tr[u].v + ", lazy: " + tr[u].lazy);
                    return;
                }
                pushdown(u); // 任务不得不下发，则先下发给两个孩子
                int mid = tr[u].l + tr[u].r >> 1;
                if (l <= mid) update(u << 1, l, r, c); // 回归调用，下传更新至左右子节点
                if (mid + 1 <= r) update(u << 1 | 1, l, r, c);
                pushup(u); // 孩子完成了任务，再修改自己的值
            }
            public int query(int u, int l, int r) {
                if (l <= tr[u].l && tr[u].r <= r) return tr[u].v;
                pushdown(u);
                int res = 0, mid = tr[u].l + tr[u].r >> 1;
                if (l <= mid) res = Math.max(res, query(u << 1, l, r));
                if (mid + 1 <= r) res = Math.max(res, query(u << 1 | 1, l, r));
                return res;
            }
            public int query() {
                return tr[1].v;
            }
        }
        public List<Integer> fallingSquares(int[][] positions) {
            List<Integer> xs = new ArrayList<>();
            for (int[] p : positions) {
                int a = p[0], b = a + p[1];
                xs.add(a * 2);
                xs.add(b * 2);
                xs.add(a + b);
            }
            xs = unique(xs); // 排序并去重
            SegTree segTree = new SegTree(xs.size());
            List<Integer> res = new ArrayList<>();
            for (int [] p : positions) {
                int a = p[0], b = a + p[1];
                a = get(a * 2, xs);
                b = get(b * 2, xs);
                int h = segTree.query(1, a + 1, b - 1);
                segTree.update(1, a, b, h + p[1]);
                res.add(segTree.query());
            }
            return res;
        }
        private int get(int x, List<Integer> xs) { // 找到x在离散化之后的值是多少，其实就是求xs里x的下标，可以二分来找到
            int l = 0, r = xs.size() - 1;
            while (l < r) {
                int m = l + r >> 1;
                if (xs.get(m) >= x) 
                    r = m;
                else 
                    l = m + 1;
            }
            return l;
        }
        private List<Integer> unique(List<Integer> list) { // 将list排序后去重
            list.sort(Integer::compareTo);
            int j = 0;
            for (int i = 0; i < list.size(); i++) 
                if (i == 0 || list.get(j - 1) != list.get(i)) 
                    list.set(j++, list.get(i));
            return list.subList(0, j); // subList()
        }

        public boolean circularArrayLoop(int[] a) {
            int n = a.length;
            boolean [] vis = new boolean [n];
            for (int i = 0; i < n; i++) {
                if (vis[i]) continue;
                vis[i] = true;
                Map<Integer, Integer> m = new HashMap<>();
                int cur = i;
                while (true) {
                    // int next = (cur + a[cur] + n) % n; // a[cur] < 0; n可能会比|a[cur]|小，如果是负数==》cur+a[cur]+n仍可能是负数
                    int next = ((cur + a[cur]) % n + n) % n; // why not (cur + a[cur] + n) % n ?
                    if (next == cur || a[next] * a[cur] < 0) break; // 符号不同，或者长度太小
                    if (m.containsKey(next)) return true;
                    m.put(cur, next);
                    cur = next;
                    vis[next] = true;
                }
            }
            return false;
        }
        bool circularArrayLoop(vector<int>& nums) {
            int n = nums.size();
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) continue;
                int slow = i, fast = getNext(nums, i), val = nums[i];
                while (val * nums[fast] > 0 && val * nums[getNext(nums, fast)] > 0) {
                    if (slow == fast) {
                        if (slow == getNext(nums, slow)) break;
                        return true;
                    }
                    slow = getNext(nums, slow);
                    fast = getNext(nums, getNext(nums, fast));
                }
                slow = i;
                while (val * nums[slow] > 0) {
                    int next = getNext(nums, slow);
                    nums[slow] = 0;
                    slow = next;
                }
            }
            return false;
        }
        public boolean circularArrayLoop(int[] a) {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int slow = i, fast = getNext(a, i), val = a[i];
                while (val * a[fast] > 0 && val * a[getNext(a, fast)] > 0) {
                    if (slow == fast) {
                        if (slow == getNext(a, slow)) break;
                        return true;
                    }
                    slow = getNext(a, slow);
                    fast = getNext(a, getNext(a, fast));
                }
                slow = i;
                while (val * a[slow] > 0) {
                    int next = getNext(a, slow);
                    a[slow] = 0;
                    slow = next;
                }
            }
            return false;
        }
        private int getNext(int [] a, int i) {
            int n = a.length;
            return (((a[i] + i) % n) + n) % n;
        }

        public int superpalindromesInRange(String left, String right) {
            long l = Long.parseLong(left), r = Long.parseLong(right);
            helper("", l, r);
            for (char c = '0'; c <= '9'; c++) 
                helper(""+c, l, r);
            return ans;
        }
        int ans = 0;
        private void helper(String s, long l, long r) {
            if (s.length() > 9) return ;
            if (!s.isEmpty() && s.charAt(0) != '0') {
                long val = Long.parseLong(s);
                val *= val;
                // if (val > r || val < l) return ; // BUG: 这里看似写得逻辑清晰，实则埋着bug。当val < l时，是不应该return的
                if (val > r) return ;               // BUG: 这里看似写得逻辑清晰，实则埋着bug。当val < l时，是不应该return的
                if (val >= l && isPalindrome(String.valueOf(val)))
                    ans++;
            }
            for (char i = '0'; i <= '9'; i++) 
                helper(String.valueOf(i) + s + String.valueOf(i), l, r);
        }
        private boolean isPalindrome(String t) {
            int n = t.length(), i = 0, j = n-1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }
        public int superpalindromesInRange(String sL, String sR) {
            long L = Long.valueOf(sL);
            long R = Long.valueOf(sR);
            int MAGIC = 100000;
            int ans = 0;
            // count odd length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 2; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
            // count even length;
            for (int k = 1; k < MAGIC; ++k) {
                StringBuilder sb = new StringBuilder(Integer.toString(k));
                for (int i = sb.length() - 1; i >= 0; --i)
                    sb.append(sb.charAt(i));
                long v = Long.valueOf(sb.toString());
                v *= v;
                if (v > R) break;
                if (v >= L && isPalindrome(v)) ans++;
            }
            return ans;
        }
        public boolean isPalindrome(long x) {
            return x == reverse(x);
        }
        public long reverse(long x) {
            long ans = 0;
            while (x > 0) {
                ans = ans * 10 + x % 10;
                x /= 10;
            }
            return ans;
        }
        超级回文数的开方每个数字不会超过2(除了数字3).所以减少搜索范围,判断在L和R的开方值之内的所有每一位不超过3的数字的平方是否为回文数,若是,则计数器加一.
            实现很简单,将10进制数转为3进制即可(但还是以10位来计算).
        public int superpalindromesInRange(String L, String R) { // todo: 这个没怎么看懂，不知道说的是什么意思
            long lNum = (long)Math.sqrt(Long.parseLong(L));
            long rNum = (long)Math.sqrt(Long.parseLong(R));
            int ans = 0;
            if (lNum <= 3 && rNum >= 3)
                ans++;
            long i = 0;
            while (true){
                i++;
                long temp = changeRadix (i,10,3);
                if (temp>rNum)
                    break;
                if (temp> = lNum&&isPalindrome (temp)&&isPalindrome (temp*temp))
                    ans++;
            }
            return ans;
        }
        public long changeRadix (long in, int source, int to){
            long re = 0L;
            long t = 1;
            do {
                re +=  (in % to) * t;
                t *= source;
                in /= to;
            } while  (in>0);
            return re;
        }
        public boolean isPalindrome (long l) {
            long temp = 0;
            long temp2 = l;
            while  (temp2>0) {
                temp += temp2%10;
                temp2 /= 10;
                if (temp2 > 0)
                    temp *=  10;
            }
            if (temp == l)
                return true;
            return false;
        }

        public int[] threeEqualParts(int[] a) {
            int n = a.length, j = n-1, sum = Arrays.stream(a).sum(), cnt = 0, i = 0;
            if (sum == 0) return new int [] {0, n-1} ;
            if (sum % 3 != 0) return new int [] {-1, -1} ;
            while (cnt < sum / 3 && j >= 0) {
                if (a[j] == 1) cnt++;
                j--;
            }
            j += 1; // a[j] == 1, cnt = sum / 3 第三个片段第一个1的位置，前面可以有数个前导0
            int k = j;
            while (i < n && a[i] == 0) i++; // 去除前导0
            while (k < n && a[i] == a[k]) { // 比较第一个片段与第三个片段序列一致
                i++;
                k++;
            }
            if (k < n) return new int [] {-1, -1} ;
            int left = i; // 第二个片段第一个位置，可以是0
            while (i < j && a[i] == 0) i++; // 去除第二个片段前导0
            k = j;
            while (k < n && a[i] == a[k]) { // 比较第二个片段与第三个片段序列一致
                i++;
                k++;
            }
            if (k < n) return new int [] {-1, -1} ;
            return new int [] {left-1, i} ; // 第一个片段尾的位置、第二个片段尾的位置
        }

        public int mostWordsFound(String[] sa) {
            int ans = 0, cnt = 0;
            for (String s : sa) {
                if (s.length() == 0) continue;
                int i = 0;
                cnt = 0;
                while (i < s.length()) {
                    while (i < s.length() && s.charAt(i) != ' ') i++;
                    if (i < s.length() && s.charAt(i) == ' ') {
                        cnt++;
                        i++;
                    }
                }
                ans = Math.max(ans, cnt + 1);
            }
            return ans;
        }

        public boolean isSameAfterReversals(int v) {
            if (v >= 10 && v % 10 == 0) return false;
            return true;
        }

        public int[] executeInstructions(int n, int[] startPos, String s) {
            int m = s.length();
            this.n = n;
            int [] ans = new int [m];
            dir.put('U', new int [] {-1, 0});
            dir.put('D', new int [] {1, 0});
            dir.put('L', new int [] {0, -1});
            dir.put('R', new int [] {0, 1});
            for (int i = 0; i < m; i++) 
                ans[i] = getCnt(startPos[0], startPos[1], s.substring(i));
            return ans;
        }
        Map<Character, int []> dir = new HashMap<>();
        int n;
        int getCnt(int x, int y, String t) {
            int m = t.length(), cnt = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < m; i++) {
                int [] d = dir.get(s[i]);
                x += d[0];
                y += d[1];
                if (x < 0 || x >= n || y < 0 || y >= n) return cnt;
                cnt++;
            }
            return cnt;
        }

        public long[] getDistances(int[] a) { // tle 
            int n = a.length;
            long tmp = 0;
            Map<Integer, List<Integer>> m = new HashMap<>();
            for (int i = 0; i < n; i++) 
                m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
            long [] ans = new long [n];
            for (int i = 0; i < n; i++) {
                if (m.get(a[i]).size() == 1) continue;
                List<Integer> idx = m.get(a[i]);
                for (int j = 0; j < idx.size(); j++) { // O(N^2) tle
                    tmp = 0;
                    for (int k = 0; k < idx.size(); k++) {
                        if (j == k) continue;
                        tmp += Math.abs(idx.get(j) - idx.get(k));
                    }
                    ans[idx.get(j)] = tmp;
                }
            }
            return ans;
        }

        public boolean checkString(String t) {
            int n = t.length(), i = 0;
            char [] s = t.toCharArray();
            while (i < n && s[i] == 'a') i++;
            if (i == n) return true;
            while (i < n && s[i] == 'b') i++;
            if (i == n) return true;
            return false;
        }

        public int numberOfBeams(String[] sa) {
            int m = sa.length, n = sa[0].length(), idx = -1, cnt = 0;
            Map<Integer, List<Integer>> map = new HashMap<>();
            boolean added = false;
            for (int i = 0; i < m; i++) {
                added = false;
                for (int j = 0; j < sa[i].length(); j++) 
                    if (sa[i].charAt(j) == '1') {
                        if (!added) {
                            idx++;
                            added = true;  
                        } 
                        map.computeIfAbsent(idx, z -> new ArrayList<>()).add(j);
                    }
            }
            if (map.size() == 1) return cnt;
            for (int i = 0; i < map.size()-1; i++) 
                cnt += map.get(i).size() * map.get(i+1).size();
            return cnt;
        }

        public boolean asteroidsDestroyed(int mass, int[] a) {
            int n = a.length;
            Arrays.sort(a);
            long sum = mass;
            for (int i = 0; i < n; i++) {
                if (sum < (long)a[i]) return false;
                sum += (long)a[i];
            }
            return true;
        }

        public List<String> findAllRecipes(String[] rec, List<List<String>> ing, String[] sup) {
            int n = res.length, j = 0;
            Trie t = new Trie();
            for (String s : sup) // 应该加的是原材料才对 
                t.insert(s);
            Map<String, Integer> idx = new HashMap<>();
            for (int i = 0; i < n; i++) 
                idx.put(rec[i], i);
            // Map<String, Set<String>> adj = new HashMap<>();
            Map<Integer, List<Integer>> adj = new HashMap<>();
            Set<String> ss = new HashSet<>(Arrays.asList(rec));
            for (int i = 0; i < ing.size(); i++) {
                List<Integer> res = ing.get(i);
                for (String v : res) 
                    if (ss.contains(v))
                        // adj.computeIfAbsent(v, z -> new HashSet<>()).add(rec[i]);
                        adj.computeIfAbsent(idx.get(v), z -> new HashSet<>()).add(i);
            }
            ss.clear();
            for (int i = 0; i < ing.size(); i++) {
                List<Integer> res = ing.get(i);
                for (j = 0; j < ls.size(); j++) 
                    if (!t.search(ls.get(j))) break;
                if (j == ls.size()) {
                    ss.add(rec[i]);
                    t.insert(rec[i]);
                    List<Integer> tmp = adj.get(i);
                    for (int k : tmp) { // 这里还是把自己绕昏了。。。。。。
                        int x = 0;
                        for (x = 0; x < ing.get(k).size(); x++) 
                            if (!t.search(ing.get(k).get(x))) break;
                    }
                }
            }
            Set<Integer> mis = new HashSet<>();
            for (int i = 0; i < ing.size(); i++) {
                List<String> ls = ing.get(i);
                for (j = 0; j < ls.size(); j++) 
                    if (!t.search(ls.get(j))) break;
                if (j == ls.size()) {
                    ss.add(rec[i]);
                    t.insert(rec[i]);
                } else mis.add(i);
            }
            for (int i : mis) { // 这里的逻辑没有想清楚，不是重复一遍的问题，而是是否应该深度优先搜索的问题，几个周没写算法题，手好生 
                List<String> ls = ing.get(i);
                for (j = 0; j < ls.size(); j++) 
                    if (!t.search(ls.get(j))) break;
                if (j == ls.size()) {
                    ss.add(rec[i]);
                    t.insert(rec[i]);
                } else mis.add(i);
                
            }
        }
        class Trie {
            public boolean search(String t) {
                int n = t.length();
                char [] s = t.toCharArray();
                Node r = root;
                for (int i = 0; i < n; i++) {
                    int j = s[i] - 'a';
                    if (r.next[j] == null) return false;
                    r = r.next[j];
                }
                return r.f;
            }
            public void insert(String t) {
                int n = t.length();
                char [] s = t.toCharArray();
                Node r = root;
                for (int i = 0; i < n; i++) {
                    int j = s[i] - 'a';
                    if (r.next[j] == null)
                        r.next[j] = new Node();
                    r = r.next[j];
                }
                r.f = true;
            }
            Node root;
            public Trie() {
                root = new Node();
            }
            class Node {
                boolean f;
                Node [] next;
                public Node() {
                    f = false;
                    next = new Node[26];
                }
            }
        }

        class Trie { // 想错了，解题的思路不对
            public boolean search(String t) {
                int n = t.length();
                char [] s = t.toCharArray();
                Node r = root;
                for (int i = 0; i < n; i++) {
                    int j = s[i] - 'a';
                    if (r.next[j] == null) return false;
                    r = r.next[j];
                }
                return r.f;
            }
            public void insert(String t) {
                int n = t.length();
                char [] s = t.toCharArray();
                Node r = root;
                for (int i = 0; i < n; i++) {
                    int j = s[i] - 'a';
                    if (r.next[j] == null)
                        r.next[j] = new Node();
                    r = r.next[j];
                }
                r.f = true;
            }
            Node root;
            public Trie() {
                root = new Node();
            }
            class Node {
                boolean f;
                Node [] next;
                public Node() {
                    f = false;
                    next = new Node[26];
                }
            }
        }
        // https://leetcode-cn.com/problems/find-all-possible-recipes-from-given-supplies/solution/cong-gei-ding-yuan-cai-liao-zhong-zhao-d-d02i/
        // 大方向的思路有了，还得再想一想
        public List<String> findAllRecipes(String[] re, List<List<String>> ing, String[] sup) { // 菜谱 菜谱原材料 食材 BUG BUG BUG
            Map<String, Set<String>> adj = new HashMap<>();    // 每种材料可以做成的菜的 清单
            Map<String, Integer> ins = new HashMap<>();        // 每种材料或是菜谱的 入度
            for (int i = 0; i < re.length; i++) 
                for (String it : ing.get(i)) {
                    adj.computeIfAbsent(it, z -> new HashSet<>()).add(re[i]);
                    ins.put(re[i], ins.getOrDefault(re[i], 0) + 1);
                }
            List<String> ans = new ArrayList<>();
            Deque<String> q = new ArrayDeque<>();
            for (String s : sup) q.offerLast(s); // 把初始的原材料放入队列
            while (!q.isEmpty()) { // 拓扑排序
                String cur = q.pollFirst();
                if (adj.containsKey(cur)) 
                    for (String one : adj.get(cur)) { // 遍历某种原材料可以做成的所有的菜，其入度是否为0
                        ins.put(one, ins.get(one)-1); // 入度 ins--
                        if (ins.get(one) == 0) {
                            ans.add(one);
                            q.offerLast(one);
                        }
                    }
            }
            return ans;
        }

        public int maximumInvitations(int[] a) { // a: favorite
            // 统计入度，便于进行拓扑排序
            int n = a.length, ins [] = new int [n];
            for (int v : a) ins[v]++;
            boolean vis [] = new boolean [n];
            int f [] = new int [n];
            Arrays.fill(f, 1);
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) 
                if (ins[i] == 0) q.offerLast(i); 
            while (!q.isEmpty()) {
                int u = q.pollFirst();
                vis[u] = true;
                int v = a[u];
                f[v] = Math.max(f[v], f[u] + 1); // 动态规划： 能够到达 v 的最长链的长度
                --ins[v];
                if (ins[v] == 0) q.offerLast(v);
            }
            // ring 表示最大的环的大小
            // total 表示所有环大小为 2 的「基环内向树」上的最长的「双向游走」路径之和
            int ring = 0, total = 0;
            for (int i = 0; i < n; i++) {
                if (!vis[i]) {
                    int j = a[i];
                    if (a[j] == i) { // 说明环的大小为 2
                        total += f[i] + f[j]; // 局部二元环可以叠加
                        vis[i] = vis[j] = true;
                    } else { // 否则环的大小至少为 3，我们需要找出环
                        int u = i, cnt = 0;
                        do { // 至少执行一次，evaluate after execute
                            ++cnt;
                            u = a[u];
                            vis[u] = true;
                        } while (u != i); // 再达到达这一点，说明转了一圈，又回到了起点
                        ring = Math.max(ring, cnt); // 找出一个节点数目最多的环
                    }
                }
            }
            return Math.max(ring, total);
        }

        public int kIncreasing(int[] a, int k) { // todo
            int n = a.length, ans = 0;
            for (int i = 0; i < k; i++) {
                int size = 1, max = 0; // 最长递增子序列长度......
                // DP 会超时，使用 贪心 + 二分 计算 max
                // 这个数组太大也会超时，长度取 arr.length / k + 1
                int [] d = new int [n / k + 1];
                d[max++] = a[i];
                for (int j = i+k; j < n; j += k) {
                    size++;
                    if (a[j] >= d[max-1])
                        d[max++] = a[j];
                    else {
                        int l = 0, r = max-1;
                        while (l < r) {
                            int m = l + (r - l) / 2;
                            if (d[m] <= a[j])
                                l = m + 1;
                            else r = m;
                        }
                        d[r] = a[j];
                    }
                }
                ans += size - max;
            }
            return ans;
        }

        public boolean canBeValid(String tt, String ss) {
            int n = tt.length(), cnt = 0;
            char [] s = tt.toCharArray();
            char [] t = ss.toCharArray();
            if (n % 2 == 1) return false;
            for (int i = 0; i < n; i++) {
                if (t[i] == '0' || s[i] == '(') cnt++;
                else cnt--;
                if (cnt < 0) return false; // 这是一个过程检查，过程中任何时候都需要 cnt >= 0
            }
            cnt = 0;
            for (int i = n-1; i >= 0; i--) {
                if (t[i] == '0' || s[i] == ')') cnt++;
                else cnt--;
                if (cnt < 0) return false; // 这是一个过程检查，过程中任何时候都需要 cnt >= 0
            }
            return true;
        }

        public boolean canConvertString(String ss, String tt, int k) {
            if (ss.length() != tt.length()) return false;
            int n = ss.length();
            char [] s = ss.toCharArray(), t = tt.toCharArray();
            int [] cnt = new int [26];
            for (int i = 0; i < n; i++) {
                int dif = t[i] - s[i];
                if (dif < 0) dif += 26;
                cnt[dif] ++;
            }
            for (int i = 1; i < 26; i++) {
                int maxCnt = i + 26 * (cnt[i] - 1);
                if (maxCnt > k) return false;
                // k -= maxCnt; // BUG
            }
            return true;
            // while (i < n && s[i] == t[i]) i++;
            // if (i == n) return true;
            // if (Math.abs(s[i] - t[i]) > k) return false;
            // while (i < n) { // 这里可能也不一定是顺序遍历，应该还需要排序一下
            //     while (i < n && s[i] == t[i]) i++;
            //     if (i == n) return true;
            //     if (s[i] > t[i]) 
            //         v = s[i] - t[i] + 26;
            //     else v = t[i] - s[i];
            //     if (v > k || vis.contains(v) && v + 26 > k) return false;
            //     k -= v;
            //     vis.add(v);
            //     i++;
            // }
            // return true;
        }

        public void wiggleSort(int[] a) {
            int n = a.length, ei = n/2-(n % 2 == 0 ? 1 : 0), i = ei, j = n-1, k = 0;
            Arrays.sort(a);
            int [] tmp = Arrays.copyOf(a, n);
            while (i >= 0 || j > ei) {
                if (i >= 0)
                    a[k++] = tmp[i--];
                if (j > ei)
                    a[k++] = tmp[j--];
            }
        }
        // https://leetcode-cn.com/problems/wiggle-sort-ii/solution/bai-dong-pai-xu-ii-jie-ti-bao-gao-shi-jian-fu-za-d/
        public void wiggleSort(int[] a) { // 这里没看懂 todo: O(N) space O(1)
            int n = a.length, mid = (n - 1) / 2;
            getKth(a, mid);
            // reverse index [0, 2, 4, 6, ...]
            for (int p = 0, q = mid; p < q; p++, q--)
                swap(a, ni(n, p), ni(n, q));
            // reverse index [1, 3, 5, 7, ...]
            for (int p = mid + 1, q = n - 1; p < q; p++, q--)
                swap(a, ni(n, p), ni(n, q));
        }
        //  three-way partition, O(n)-average time, O(1)-space, k starts from index 0
        int getKth(int[] a, int k) {
            int n = a.length, start = 0, end = n - 1;
            while (true) {
                // [start, p) < pivot, [p, q) == pivot, [q, i) > pivot
                int pivot = a[ni(n, end)], p = start, q = p;
                for (int i = start; i < end; i++)
                    if (a[ni(n, i)] <= pivot) {
                        swap(a, ni(n, q++), ni(n, i));
                        if (a[ni(n, q - 1)] < pivot)
                            swap(a, ni(n, p++), ni(n, q - 1));
                    }
                swap(a, ni(n, q++), ni(n, end));
                if (k < p - start)
                    end = p - 1;
                else if (k < q - start)
                    return pivot;
                else {
                    k -= q - start;
                    start = q;
                }
            }
        }
        // virtual mapping to new index
        // e.g. n = 8, [a, b, c, d, e, f, g, h] -> [a, e, b, f, c, g, d, h]
        // e.g. n = 9, [a, b, c, d, e, f, g, h, i] -> [a, f, b, g, c, h, d, i, e]
        int ni(int n, int i) {
            return i <= (n - 1) / 2 ? i * 2 : (i - (n + 1) / 2) * 2 + 1;
        }
        void swap(int[] a, int p, int q) {
            int tmp = a[p];
            a[p] = a[q];
            a[q] = tmp;
        }

        
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        // int [] a = new int [] {1,5,1,1,6,4};
        int [] a = new int [] {1,3,2,2,3,1};

        
        s.wiggleSort(a);
        // boolean r = s.canConvertString(a, b, 24); 
        // System.out.println("r: " + r);
    }
}


