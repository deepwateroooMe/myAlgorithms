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

        // public List<String> removeComments(String[] source) {
        //     int n = source.length, j = 0;
        //     List<String> ans = new ArrayList<>();
        //     boolean inblock = false;
        //     for (int i = 0; i < n; i++) {
        //         String s = source[i];
        //         if (s.length() == 0 || inblock && s.indexOf("*/") == -1) continue;
        //         if (s.length() == 1) {
        //             ans.add(s);
        //             continue;
        //         }
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
        //             if (idx == -1) ans.add(s);
        //             else ans.add(s.substring(0, idx));
        //         } else {
        //             int idx = s.indexOf("*/");
        //             if (idx != -1 && idx != 1 && idx <= s.length()-2) {
        //                 source[i] = s.substring(idx + 2);
        //                 --i;
        //                 continue;
        //             } else inblock = true;
        //         }
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


        private boolean isValidTagName(String t) {
            int n = t.length();
            if (n == 0 || n > 9) return false;
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) 
                if (!Character.isUpperCase(s[i]))
                    return false;
            return true;
        }
        private boolean isValid(int x, int y) {
            // System.out.println("\n x: " + x);
            // System.out.println("y: " + y);
            // System.out.println("t.substring(x, y+1): " + t.substring(x, y+1));
            int i = x, j = y;
            if (t.substring(x, y+1).startsWith("<![CDATA[") && t.substring(y-2, y+1).equals("]]>"))
                return hasTag;
            while (i <= y && s[i] != '<') i++;
            // System.out.println("hasTag: " + hasTag);
            // System.out.println(" (i == y): " +  (i == y));
            if (i == y+1) return hasTag;
            while (j >= i && s[j] != '>') j--;
            i++;
            if (s[i] != '!') {
                int k = i + 1;
                while (k < j && s[k] != '>') k++;
                if (k == j) return false;
                String name = t.substring(i, k);
                if (!isValidTagName(name)) return false;
                if (!t.endsWith("</"+name+">")) return false;
                hasTag = true;
                return isValid(k+1, j - (k-i+3));
            }
            return true;
        }
        boolean hasTag = false;
        String t;
        char [] s;
        int n;
        public boolean isValid(String t) {
            this.t = t;
            n = t.length();
            s = t.toCharArray();
            return isValid(0, n-1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "<DIV>  div tag is not closed  <DIV>";
        // String a = "<A>  <B> </A>   </B>";
        // String a = "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>";
        String a = "<A><A>/A></A></A>";

        boolean r = s.isValid(a);
        System.out.println("r: " + r);
    }
}