// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class strthreeing {
    public static class Solution {

        // public int countHomogenous(String s) { // bug bug bug
        //     int n = s.length();
        //     int mod = (int)1e9 + 7;
        //     int j = 0, i = 0, cnt = 1;
        //     long ans = 0;
        //     while (i < n) {
        //         while (i < n-1 && s.charAt(i) == s.charAt(i+1)) {
        //             i++;
        //             cnt++;
        //         }
        //         ans = (ans + (cnt+1)*cnt / 2 % mod + mod) % mod;
        //         cnt = 1;
        //         i++;
        //     }
        //     return (int)ans;
        // }
        // public int countHomogenous(String t) {
        //     int mod = (int)1e9 + 7;
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int cnt = 1, ans = 0;
        //     for (int i = 1; i < n; i++) {
        //         if (s[i] == s[i-1]) cnt++;
        //         else cnt = 1;
        //         ans = (ans + cnt) % mod;
        //     }
        //     return ans;
        // }

        // public int strongPasswordChecker(String password) { // 这个是照抄的，这个细节实现题还是需要改天再好好写一下 top 5 difficult ?
        //     boolean num = false, lower = false, upper = false;
        //     int bgn = 0, end = 0, n = password.length(), mod = 0, cnt [] = new int []{0, 0, 0}, c = 0, len = 0, need = 0, rmv = 0;
        //     while (end < n) {
        //         c = password.charAt(end);
        //         if (c >= '0' && c <= '9') num = true;
        //         else if (c >= 'a' && c <= 'z') lower = true;
        //         else if (c >= 'A' && c <= 'Z') upper = true;
        //         while (end < n && password.charAt(end) == c) ++end;
        //         len = end - bgn;
        //         if (len > 2) {
        //             mod += len / 3;
        //             ++cnt[len % 3];
        //         }
        //         bgn = end;
        //     }
        //     need = (num ? 0 : 1) + (lower ? 0 : 1) + (upper ? 0 : 1);
        //     if (n < 6) return Math.max(6-n, need);
        //     if (n <= 20) return Math.max(mod, need);
        //     rmv = n - 20;
        //     n -= 20;
        //     if (rmv < cnt[0]) return Math.max(mod - rmv, need) + n;
        //     rmv -= cnt[0];
        //     mod -= cnt[0];
        //     if (rmv < (cnt[1] << 1)) return Math.max(mod - (rmv >> 1), need) + n;
        //     rmv -= (cnt[1] << 1);
        //     mod -= cnt[1];
        //     return Math.max(mod - rmv / 3, need) + n;
        // }


        // public String nearestPalindromic(String s) { 
        //     long n = s.length(), num = Long.parseLong(s), ans = 0, minDif = Long.MAX_VALUE;
        //     Set<Long> ss = new HashSet<>();
        //     ss.add((long)Math.pow(10, n) + 1);
        //     ss.add((long)Math.pow(10, n-1) - 1);
        //     long curPre = Long.parseLong(s.substring(0, (int)(n+1)/2)); // left
        //     for (long i = -1; i <= 1; i++) {
        //         String pre = "" + (curPre + i);
        //         String str = pre + (new StringBuilder (pre)).reverse().toString().substring((int)n & 1); // left + "mod" + reversed precised left
        //         ss.add(Long.parseLong(str));
        //     }
        //     ss.remove(num);
        //     for (long v : ss) {
        //         long dif = Math.abs(v - num);
        //         if (dif < minDif) {
        //             minDif = dif;
        //             ans = v;
        //         } else if (dif == minDif)
        //             ans = Math.min(ans, v);
        //     }
        //     return "" + ans;
        // }


        // public int evaluate(String t) {
        //     return eval(t, new HashMap<>());
        // }
        // private int eval(String s, Map<String, Integer> p) { // parent scope
        //     if (s.charAt(0) != '(') { // just a number or a symbol
        //         if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
        //             return Integer.parseInt(s);
        //         return p.get(s); // 索要某个变量的值
        //     }
        //     Map<String, Integer> m = new HashMap<>(); // child map, cur scope
        //     m.putAll(p); // create a new scope, add add all the parent values to it
        //     List<String> tokens = parse(s.substring(s.charAt(1) == 'm' ? 6 : 5, s.length()-1)); // 去掉了左右括号和keyword的子表达式，并分情况讨论得结果
        //     if (s.startsWith("(a"))      // (add x y)
        //         return eval(tokens.get(0), m) + eval(tokens.get(1), m);
        //     else if (s.startsWith("(m")) // (mult x y)
        //         return eval(tokens.get(0), m) * eval(tokens.get(1), m);
        //     else { // (let x1 v1 x2 v2 ... exp)
        //         for (int i = 0; i <= tokens.size()-3; i += 2) 
        //             m.put(tokens.get(i), eval(tokens.get(i+1), m));
        //         return eval(tokens.get(tokens.size()-1), m);
        //     }
        // }
        // private List<String> parse(String t) { // parse exps to be List.of(x1, v1, x2, v2, (exp))
        //     List<String> ans = new ArrayList<>(); // seperate the values between two parentheses
        //     char [] s = t.toCharArray();
        //     int cnt = 0;
        //     StringBuilder sb = new StringBuilder();
        //     for (char c : s) {
        //         if (c == '(') cnt++;
        //         if (c == ')') cnt--;
        //         if (cnt == 0 && c == ' ') {
        //             ans.add(new String(sb));
        //             sb = new StringBuilder();
        //         } else sb.append(c);
        //     }
        //     if (sb.length() > 0) ans.add(new String(sb));
        //     return ans;
        // }


        // public boolean isValid(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     ArrayDeque<String> st = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && st.isEmpty()) return false;
        //         if (t.substring(i, Math.min(n, i+9)).equals("<![CDATA[")) { // parse cdata
        //             int j = i+9;
        //             i = t.indexOf("]]>", j);
        //             if (i == -1) return false;
        //             i += 2;
        //         } else if (t.substring(i, Math.min(n, i+2)).equals("</")) { // ending tag
        //             int j = i + 2;
        //             i = t.indexOf(">", j);
        //             String tmp = t.substring(j, i);
        //             if (st.isEmpty() || !tmp.equals(st.peekLast()))
        //                 return false;
        //             st.pollLast();
        //         } else if (s[i] == '<') { // starting tag
        //             int j = i + 1;
        //             i = t.indexOf(">", j);
        //             if (i < 0 || i == j || i-j > 9)
        //                 return false;
        //             for (int k = j; k < i; k++) 
        //                 if (!Character.isUpperCase(s[k]))
        //                     return false;
        //             String tmp = t.substring(j, i);
        //             st.offerLast(tmp);
        //         }
        //     }
        //     return st.isEmpty();
        // }


        // public boolean isRationalEqual(String s, String t) {
        //     return Double.compare(stodJava(s), stodJava(t)) == 0;
        // }
        // private double stodJava(String t) {
        //     int n = t.length();
        //     String s = "";
        //     if (t.charAt(n-1) == ')') {
        //         int i = t.indexOf("(");
        //         s = t.substring(0, i) + t.substring(i+1, n-1).repeat(20);
        //     } else s = t;
        //     return Double.parseDouble(s);
        // }
        // public boolean isRationalEqual(String S, String T) {
        //     Fraction f1 = convert(S);
        //     Fraction f2 = convert(T);
        //     return f1.n == f2.n && f1.d == f2.d;
        // }
        // public Fraction convert(String S) {
        //     int state = 0; //whole, decimal, repeating
        //     Fraction ans = new Fraction(0, 1);
        //     int decimal_size = 0;
        //     for (String part: S.split("[.()]")) {
        //         state++;
        //         if (part.isEmpty()) continue;
        //         long x = Long.valueOf(part);
        //         int sz = part.length();
        //         if (state == 1) { // whole
        //             ans.iadd(new Fraction(x, 1));
        //         } else if (state == 2) { // decimal
        //             ans.iadd(new Fraction(x, (long) Math.pow(10, sz)));
        //             decimal_size = sz;
        //         } else { // repeating
        //             long denom = (long) Math.pow(10, decimal_size);
        //             denom *= (long) (Math.pow(10, sz) - 1);
        //             ans.iadd(new Fraction(x, denom));
        //         }
        //     }
        //     return ans;
        // }
        // class Fraction {
        //     long n, d;
        //     Fraction(long n, long d) {
        //         long g = gcd(n, d);
        //         this.n = n / g;
        //         this.d = d / g;
        //     }
        //     public void iadd(Fraction other) {
        //         long numerator = this.n * other.d + this.d * other.n;
        //         long denominator = this.d * other.d;
        //         long g = Fraction.gcd(numerator, denominator);
        //         this.n = numerator / g;
        //         this.d = denominator / g;
        //     }
        //     static long gcd(long x, long y) {
        //         return x != 0 ? gcd(y % x, x) : y;
        //     }
        // }


        // public boolean splitString(String t) {
        //     n = t.length();
        //     this.t = t;
        //     if (n < 2) return false;
        //     if (n == 2) return t.charAt(0) > t.charAt(1);
        //     char [] s = t.toCharArray();
        //     return dfs(0, new ArrayList<>());
        // }
        // String t;
        // char [] s;
        // int n;
        // private boolean dfs(int idx, List<Long> l) {
        //     if (l.size() >= 2) 
        //         if (l.get(l.size()-2) - l.get(l.size()-1) != 1) return false;
        //     if (idx == n) {
        //         if (l.size() >= 2) 
        //             return true;
        //         return false;
        //     }
        //     for (int i = idx; i < n; i++) {
        //         String cur = t.substring(idx, i+1);
        //         if (cur.length() == 20 || cur.length() == 19 && cur.compareTo(String.valueOf(Long.MAX_VALUE)) >= 0) continue;
        //         long tmp = Long.parseLong(t.substring(idx, i+1));
        //         l.add(tmp);
        //         if (dfs(i+1, l)) return true;
        //         l.remove(l.size()-1);
        //     }
        //     return false;
        // }
        // public boolean splitString(String t) {
        //     long start = 0;
        //     long INF = (long)1e10; // 子串对应数值的上限
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n - 1 && start < INF; ++i) { // 枚举第一个子字符串对应的初始值, 第一个子字符串不能包含整个字符串
        //         start = start * 10 + (s[i] - '0');
        //         long preVal = start; // 循环验证当前的初始值是否符合要求
        //         long curVal = 0;
        //         int cidx = i + 1;
        //         for (int j = i + 1; j < n && curVal < INF; ++j){
        //             if (preVal == 1) { // 如果上一个值为 1，那么剩余字符串对应的数值只能为 0
        //                 if (t.substring(j).compareTo(String.valueOf(Long.MAX_VALUE)) >= 0) break;
        //                 if (Long.parseLong(t.substring(j)) == 0) return true;
        //                 break;
        //             }
        //             curVal = curVal * 10 + (s[j] - '0');
        //             if (curVal > preVal - 1){
        //                 // 不符合要求，提前结束
        //                 break;
        //             } else if (curVal == preVal - 1){
        //                 if (j + 1 == n) // 已经遍历到末尾
        //                     return true;
        //                 preVal = curVal;
        //                 curVal = 0;
        //                 cidx = j + 1;
        //             }
        //         }
        //     }
        //     return false;
        // }

        // public String fractionAddition(String expression) {
        //     Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        //     int A = 0, B = 1;
        //     while (sc.hasNext()) {
        //         int a = sc.nextInt(), b = sc.nextInt();
        //         A = A * b + a * B;
        //         B *= b;
        //         int g = gcd(A, B);
        //         A /= g;
        //         B /= g;
        //     }
        //     return A + "/" + B;
        // }
        // private int gcd(int a, int b) {
        //     return a != 0 ? gcd(b % a, a) : Math.abs(b);
        // }
        // public String fractionAddition(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<Character> sn = new ArrayList<>(); // sign
        //     for (int i = 1; i < n; i++) 
        //         if (s[i] == '+' || s[i] == '-')
        //             sn.add(s[i]);
        //     List<Integer> up = new ArrayList<>();
        //     List<Integer> dn = new ArrayList<>();
        //     for (String sub : t.split("\\+")) 
        //         for (String subsub : sub.split("-")) 
        //             if (subsub.length() > 0) {
        //                 String [] fra = subsub.split("/");
        //                 up.add(Integer.parseInt(fra[0]));
        //                 dn.add(Integer.parseInt(fra[1]));
        //             }
        //     if (s[0] == '-')
        //         up.set(0, -up.get(0));
        //     int lcm = 1; // 求所有分母的最小公倍数
        //     for (int x : dn) lcm = lcm_(lcm, x);
        //     int ans = lcm / dn.get(0) * up.get(0);
        //     for (int i = 1; i < up.size(); i++) 
        //         if (sn.get(i-1) == '+')
        //             ans += lcm / dn.get(i) * up.get(i);
        //         else ans -= lcm / dn.get(i) * up.get(i);
        //     int g = gcd(Math.abs(ans), Math.abs(lcm));
        //     return (ans / g) + "/" + (lcm / g);
        // }
        // public int lcm_(int a, int b) { // 求最小公倍数
        //     return a * b / gcd(a, b);
        // }
        // public int gcd(int a, int b) { // 求最大公约数
        //     while (b != 0) {
        //         int t = b;
        //         b = a % b;
        //         a = t;
        //     }
        //     return a;
        // }

        // public String maximumBinaryString(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     StringBuilder sb = new StringBuilder(t);
        //     int cnt = 0, one = 0;
        //     boolean meetZero = false;
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == '1') {
        //             cnt++; // cnt: cnt all 1s
        //             if (!meetZero) one++;
        //         } else meetZero = true;
        //     return "1".repeat(one) + (n - cnt > 0 ? "1".repeat(n-cnt-1)+"0" : "") + "1".repeat(cnt-one);
        // }
        // public String maximumBinaryString(String t) {
        //     int l = 0;
        //     char [] s = t.toCharArray();
        //     while (l < s.length && s[l] == '1') l++; // 扫过最开始连续是1的片段： s[l] = '0';
        //     int r = l + 1;
        //     for (; l < t.length(); l++) {
        //         if (s[l] == '1')  continue;
        //         while (r < t.length() && s[r] == '1') r++;
        //         if (r == t.length()) break;
        //         s[l] = '1';
        //         s[r] = '1';
        //         s[l + 1] = '0'; // for() 逐步地将s[l] = '0'后移至s[l+1] = '0'
        //         r++;
        //     }
        //     return new String(s);
        // }

        // public String getHint(String ss, String tt) {
        //     int n = ss.length(), cnt = 0, sum = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     Map<Character, Integer> ms = new HashMap<>();
        //     Map<Character, Integer> mt = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == t[i]) cnt++;
        //         else {
        //             ms.put(s[i], ms.getOrDefault(s[i], 0) + 1);
        //             mt.put(t[i], mt.getOrDefault(t[i], 0) + 1);
        //         }
        //     for (Character key : mt.keySet()) 
        //         if (ms.containsKey(key))
        //             sum += Math.min(ms.get(key), mt.get(key));
        //     return cnt + "A" + sum + "B";
        // }
        // public String getHint(String ss, String tt) {
        //     int n = ss.length(), cnt = 0, sum = 0;
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] == t[i]) cnt++;
        //         else {
        //             if (m.getOrDefault(s[i], 0) < 0) sum++;
        //             if (m.getOrDefault(t[i], 0) > 0) sum++;
        //             m.put(s[i], m.getOrDefault(s[i], 0) + 1);
        //             m.put(t[i], m.getOrDefault(t[i], 0) - 1);
        //         }
        //     return cnt + "A" + sum + "B";
        // }

        // public boolean repeatedSubstringPattern(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n-1; i++) 
        //         if (s[i] == s[n-1]) l.add(i);
        //     for (int i = 0; i < l.size(); i++) {
        //         int j = l.get(i) + 1;
        //         String cur = t.substring(0, j);
        //         if (n % cur.length() == 0 && t.equals(cur.repeat(n / cur.length())))
        //             return true;
        //     }
        //     return false;
        // }

        // public int numWays(String t) {
        //     int mod = (int)1e9 + 7;
        //     int n = t.length(), cnt = 0;
        //     System.out.println("n: " + n);
        //     for (char c : s)
        //         cnt += c-'0';
        //     if (cnt % 3 != 0) return 0;
        //     if (cnt == 0) return (int)(((long)n-1l) * ((long)n-2l) / 2 % mod);
        //     char [] s = t.toCharArray();
        //     int i = 0, j = n-1, ca = 0, cb = 0, target = cnt / 3;
        //     while (i < n && ca < target) {
        //         if (s[i] == '1') ++ca;
        //         i++;
        //     }
        //     while (j >= 0 && cb < target) {
        //         if (s[j] == '1') ++cb;
        //         j--;
        //     }
        //     int x = i, y = j;
        //     while (x < j && s[x] == '0') ++x;
        //     while (y > i && s[y] == '0') --y;
        //     return (int)(((long)x - i + 1) * ((long)j - y + 1) % mod);
        // }
        // public int numWays(String s) {
        //     final int mod = 1000000007;
        //     List<Integer> ones = new ArrayList<Integer>();
        //     int n = s.length();
        //     for (int i = 0; i < n; i++) 
        //         if (s.charAt(i) == '1') 
        //             ones.add(i);
        //     int m = ones.size();
        //     if (m % 3 != 0) return 0;
        //     if (m == 0) {
        //         long ways = (long) (n - 1) * (n - 2) / 2;
        //         return (int) (ways % mod);
        //     } else {
        //         int index1 = m / 3, index2 = m / 3 * 2;
        //         int count1 = ones.get(index1) - ones.get(index1 - 1);
        //         int count2 = ones.get(index2) - ones.get(index2 - 1);
        //         long ways = (long) count1 * count2;
        //         return (int) (ways % mod);
        //     }
        // }


        // public int minCharacters(String a, String b) {
        //     int m = a.length(), n = b.length();
        //     char [] s = a.toCharArray();
        //     char [] t = b.toCharArray();
        //     char as = 'z', al = 'a', bs = 'z', bl = 'a';
        //     int [] one = new int [26], two = new int [26];
        //     for (int i = 0; i < m; i++) {
        //         one[s[i]-'a']++;
        //         as = (char)Math.min(as, s[i]);
        //         al = (char)Math.max(al, s[i]);
        //     }
        //     for (int i = 0; i < n; i++)  {
        //         two[t[i]-'a']++;
        //         bs = (char)Math.min(bs, t[i]);
        //         bl = (char)Math.max(bl, t[i]);
        //     }
        //     if (al < bs || bl < as || al == as && bl == bs && al == bl) return 0;
        //     int [] pa = Arrays.copyOf(one, 26);
        //     int [] pb = Arrays.copyOf(two, 26);
        //     for (int i = 1; i < 26; i++) 
        //         pa[i] += pa[i-1];
        //     for (int i = 1; i < 26; i++) 
        //         pb[i] += pb[i-1];
        //     int min = m+n, cur = min;
        //     for (char c = 'a'; c <= 'z'; c++) {
        //         cur = min;
        //         if (c < 'z') {
        //             cur = Math.min(cur, m - pa[c-'a'] + pb[c-'a']);      // as smallest in a
        //             cur = Math.min(cur, n - pb[c-'a'] + pa[c-'a']);
        //         }
        //         cur = Math.min(cur, m-one[c-'a'] + n - two[c-'a']);
        //         min = Math.min(min, cur);
        //     }                
        //     return min;
        // }

        // public String solveEquation(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     int idx = t.indexOf("=");
        //     helper(t.substring(0, idx), true);
        //     helper(t.substring(idx+1), false);
        //     if (a == 0 && a == b) return "Infinite solutions";
        //     if (a == 0 && a != b) return "No solution";
        //     return "x=" + String.valueOf(b / a);
        // }
        // int a = 0, b = 0;
        // private void helper(String t, boolean left) {
        //     int sn = 1, val = -1;
        //     t += "+";
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < t.length(); i++) {
        //         if (s[i] == '-' || s[i] == '+') {
        //             val = (val == -1 ? 0 : val * sn);
        //             b += left ? -val : val;
        //             val = -1;
        //             sn = (s[i] == '+' ? 1 : -1);
        //         } else if (s[i] >= '0' && s[i] <= '9') {
        //             if (val == -1) val = 0;
        //             val = val * 10 + s[i] - '0';
        //         } else if (s[i] == 'x') {
        //             val = (val == -1 ? sn : val * sn);
        //             a += left ? val : -val;
        //             val = -1;
        //         }
        //     }
        // }

        // public boolean isRobotBounded(String ins) {
        //     int x = 0, y = 0, i = 0, d [][] = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        //     for (int j = 0; j < ins.length(); ++j)
        //         if (ins.charAt(j) == 'R')
        //             i = (i + 1) % 4;
        //         else if (ins.charAt(j) == 'L')
        //             i = (i + 3) % 4;
        //         else {
        //             x += d[i][0]; y += d[i][1];
        //         }
        //     return x == 0 && y == 0 || i > 0;
        // }
        
        // public int minDeletionSize(String[] ss) {
        //     int m = ss.length, n = ss[0].length(), cnt = 0, i = 0;
        //     boolean [] vis = new boolean [m-1];
        //     for (int j = 0; j < n; j++) {
        //         for ( i = 0; i < m-1; i++) 
        //             if (!vis[i] && ss[i].charAt(j) > ss[i+1].charAt(j)) {
        //                 cnt++;
        //                 break;
        //             }
        //          if (i < m-1) continue;
        //          for ( i = 0; i < m-1; i++)
        //              vis[i] |= ss[i].charAt(j) < ss[i+1].charAt(j); // BUG: <=, 若当前位相等,还需要下一位继续比大小，所以还不能设置为true yet
        //      }   
        //     return cnt;
        // }

        // public List<String> removeComments(String[] source) { // bug: 有空行，不想再改这个bug了
        //     int n = source.length, j = 0;
        //     List<String> ans = new ArrayList<>();
        //     boolean inblock = false, half = false;
        //     for (int i = 0; i < n; i++) {
        //         String s = source[i];
        //         if (s.length() == 0 || inblock && s.indexOf("*/") == -1) continue;
        //         if (inblock) {
        //             int v = s.indexOf("*/");
        //             if (v != -1 && v != 1 && v <= s.length()-2) {
        //                 source[i] = s.substring(v+2);
        //                 --i;
        //                 inblock = false;
        //                 continue;
        //             }
        //         }
        //         if (s.indexOf("/*") == -1) {
        //             int idx = s.indexOf("//");
        //             if (idx == -1) {
        //                 if (half) {
        //                     ans.set(ans.size()-1, ans.get(ans.size()-1)+s);
        //                     half = false;
        //                 } else
        //                     ans.add(s);
        //             } else ans.add(s.substring(0, idx));
        //         } else {
        //             int idx = s.indexOf("/*");
        //             if (idx > 0) {
        //                 String tmp = s.substring(0, idx);
        //                 if (tmp.trim().length() > 0) {
        //                     ans.add(s.substring(0, idx));
        //                     half = true;
        //                 }
        //                 inblock = true;
        //             }
        //             idx = s.indexOf("*/");
        //             if (idx != -1 && idx != 1 && idx <= s.length()-2) {
        //                 source[i] = s.substring(idx + 2);
        //                 inblock = false;
        //                 --i;
        //                 continue;
        //             } else inblock = true;
        //         }
        //     }
        //     return ans;
        // }
        // public List<String> removeComments(String[] s) {
        //     List<String> ans = new ArrayList<>();
        //     StringBuilder sb = new StringBuilder();
        //     int i = 0, j = 0; // i: row, j : col
        //     boolean comment = false;
        //     while (i < s.length) {
        //         if (comment) { // comment如果为true，表明当前行前面有/*
        //             int idx = s[i].indexOf ("*/", j); // 找到代码中*/的位置，并将该位置放在idx变量中
        //             if (idx == -1) { // 如果idx = -1说明当前行没有*/，则将行数i+1，将下一行的起始下标置0
        //                 i ++;
        //                 j = 0;
        //             } else { // 如果idx的值不为-1，则说明当前行找到了*/ 则将代码行的有效代码下标置为idx+2。及那个comment置为false
        //                 comment = false;
        //                 j = idx + 2;
        //             }                   
        //         } else {
        //             int idx1 = s[i].indexOf ("/*", j); // 获取当前行/*的下标
        //             int idx2 = s[i].indexOf ("//", j); // 获取当前行// 的下标
        //             if (idx1 == -1) // 如果idx1 = -1说明，当前行没有/*，则正行都是有效代码，将其长度放在idx1中
        //                 idx1 = s[i].length();
        //             if (idx2 == -1) // 如果idx2 = -1说明，当前行没有// ，则正行都是有效代码，将其长度放在idx2中
        //                 idx2 = s[i].length();
        //             // 把非评论部分放入
        //             for (int k = j; k < Math.min(idx1, idx2); k++) 
        //                 sb.append (s[i].charAt (k));
        //             // 这里比较// 和/*第一次出现的位置，如果// 在/*前面出现，就说明该行是被// 注释的，否则是被/*注释的
        //             if (idx2 <= idx1) {
        //                 if (sb.length() > 0) {
        //                     ans.add (new String (sb));
        //                     sb.setLength(0);
        //                 }
        //                 i ++;
        //                 j = 0;
        //             } else {
        //                 comment = true;
        //                 j = idx1 +2;
        //             }
        //         }
        //     }
        //     return ans;        
        // }
        // public List<String> removeComments(String[] ss) {
        //     List<String> ans = new ArrayList();
        //     StringBuilder sb = new StringBuilder();
        //     boolean inBlock = false;
        //     for (String str : ss) {
        //         int i = 0;
        //         char [] s = str.toCharArray();
        //         if (!inBlock) sb = new StringBuilder();
        //         while (i < s.length) {
        //             if (!inBlock && i+1 < s.length && s[i] == '/' && s[i+1] == '*') { // need forward 2 chars
        //                 inBlock = true;
        //                 i++;
        //             } else if (inBlock && i+1 < s.length && s[i] == '*' && s[i+1] == '/') {  // need forward 2 chars
        //                 inBlock = false;
        //                 i++;
        //             } else if (!inBlock && i+1 < s.length && s[i] == '/' && s[i+1] == '/')
        //                 break;
        //             else if (!inBlock)
        //                 sb.append(s[i]);
        //             i++;
        //         }
        //         if (!inBlock && sb.length() > 0) // sb.length() > 0 
        //             ans.add(new String(sb));
        //     }
        //     return ans;
        // }

        // public String decodeCiphertext(String t, int m) {
        //     if (m == 1) return t;
        //     int len = t.length(), n = len / m, i = 0, j = 0;
        //     char [] s = t.toCharArray();
        //     char [][] a = new char [m][n];
        //     int idx = 0;
        //     while (idx < len) {
        //         i = idx / n;
        //         j = idx % n;
        //         a[i][j] = s[idx++];
        //     }
        //     StringBuilder sb = new StringBuilder(); // 这里最后字符串什么地方结尾有点儿没有思路
        //     for ( j = 0; j <= n-(m-1); j++) 
        //         for ( i = 0; i < m && j+i < n; i++) 
        //             if (a[i][j+i] != 'A')
        //                 sb.append(a[i][j+i]);
        //     return sb.toString().replaceAll("\\s+$", ""); // 其实只要把字符串尾巴上的空格去掉就可以了
        // }
        // public String decodeCiphertext(String t, int m) { // tle ? todo: 找一个官方题解java版的
        //     if (m == 1) return t;
        //     int len = t.length(), n = len / m;
        //     char [] s = t.toCharArray();
        //     String ans = "";
        //     for (int i = 0; i < n; i++) {
        //         int r = 0, c = i;
        //         while (r < m && c < n) {
        //             ans += s[r * n + c];
        //             ++r;
        //             ++c;
        //         }
        //     }
        //     return ans.replaceAll("\\s+$", ""); // 删去末尾空格
        // }

        // public int minFlips(String t) {
        //     String tt = t + t;
        //     char [] s = tt.toCharArray();
        //     int n = s.length, len = t.length(), ans = Integer.MAX_VALUE;
        //     int [] odd = new int [n+1], evn = new int [n+1]; // odd: 010101, evn: 101010
        //     for (int i = 0; i < n; i++) 
        //         if ((i & 1) == s[i] - '0') { // 奇数位为1
        //             odd[i+1] = odd[i];
        //             evn[i+1] = evn[i] + 1;
        //         } else {
        //             evn[i+1] = evn[i];
        //             odd[i+1] = odd[i] + 1;
        //         }
        //     for (int i = len; i <= n; i++) { 
        //         ans = Math.min(ans, odd[i] - odd[i-len]);
        //         ans = Math.min(ans, evn[i] - evn[i-len]);
        //     }
        //     return ans;
        // }





        
        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        String a = "111000";

        int r = s.minFlips(a);
        System.out.println ("r: " + r);
    }
}