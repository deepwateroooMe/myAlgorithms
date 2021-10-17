// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.stream.Collectors;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import static java.util.stream.Collectors.toMap;

public class recursion {
    public static class Solution {

        // int n;
        // private void helper(char [] arr, int i, int j) {
        //     if (j - i == 1) return;
        //     if (i < j-1) {
        //         char tmp = arr[i];
        //         arr[i] = arr[j-1];
        //         arr[j-1] = tmp;
        //         helper(arr, i+1, j-1);
        //     }
        // }
        // public void reverseString(char[] s) {
        //     n = s.length;
        //     if (n == 1) return;
        //     helper(s, 0, n);
        // }

        // List<String> res = new ArrayList<>();
        // private void dfsHelper(String ori, int idx, StringBuilder s) {
        //     if (idx == ori.length()) {
        //         res.add(s.toString());
        //         return;
        //     }
        //     char c = ori.charAt(idx);
        //     if (Character.isDigit(c)) {
        //         s.append(c);
        //         dfsHelper(ori, idx + 1, s);
        //         s.deleteCharAt(s.length()-1);
        //     } else {
        //         s.append(Character.toLowerCase(c));
        //         dfsHelper(ori, idx + 1, s);
        //         s.deleteCharAt(s.length()-1);
        //         s.append(Character.toUpperCase(c));
        //         dfsHelper(ori, idx + 1, s);
        //         s.deleteCharAt(s.length()-1);
        //     }
        // }
        // public List<String> letterCasePermutation(String s) {
        //     dfsHelper(s, 0, new StringBuilder());
        //     return res;
        // }

        
        // boolean res;
        // private void helper(int [] arr, int i, int j, long va, long vb, boolean aa, List<Integer> l) {
        //     if (i == j) {
        //         if (aa) {
        //             l.add(arr[i]);
        //             va += arr[i];
        //         }
        //         else vb += arr[i];
        //         if (va >= vb) res = true;
        //         return;
        //     }
        //     if (i < j) {
        //         if (aa) {
        //             if (arr[i] > arr[j]) {
        //                  l.add(arr[i]);
        //                  helper(arr, i+1, j, va + arr[i], vb, false, l);
        //             } else {
        //                  l.add(arr[j]);
        //                  helper(arr, i, j-1, va + arr[j], vb, false, l);
        //             }
        //         } else {
        //             if (arr[i] > arr[j])
        //                 helper(arr, i+1, j, va, vb + arr[i], true, l);
        //             else
        //                 helper(arr, i, j-1, va, vb + arr[j], true, l);
        //         }
        //     }
        // }
        // private int helper( int [] arr, int i, int j) {
        //     if (i == j) return arr[i];
        //     else return Math.max(arr[i] - helper(arr, i+1, j), arr[j] - helper(arr, i, j-1));
        // }
        // public boolean PredictTheWinner(int[] nums) {
        //     int n = nums.length;
        //     if (n == 1) return true;
        //     return helper(nums, 0, n-1) >= 0;
        //     // res = false;
        //     // List<Integer> l = new ArrayList<>();
        //     // l.add(nums[0]);
        //     // helper(nums, 1, n-1, nums[0], 0, false, l);
        //     // l = new ArrayList<>();
        //     // l.add(nums[n-1]);
        //     // helper(nums, 0, n-2, nums[n-1], 0, false, l);
        //     // return res;
        // }
        // public boolean PredictTheWinner(int[] nums) {
        //     return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length]) >= 0;
        // }
        // public int helper(int[] nums, int start, int end, Integer[][] dp) {
        //     if(dp[start][end] == null) {
        //         if(start == end) return nums[start];
        //         else return Math.max(nums[start]-helper(nums, start+1,end, dp), nums[end]-helper(nums, start,end-1, dp));
        //     }
        //     return dp[start][end];
        // }


        // public boolean isPowerOfTwo(int n) {
        //     if (n == 1) return true;
        //     if (n == 0 || n % 2 == 1) return false;
        //     while (n % 2 == 0) {
        //         n /= 2;
        //     }
        //     return isPowerOfTwo(n);
        // }
        // public boolean isPowerOfThree(int n) {
        //     if (n == 1) return true;
        //     if (n <= 0 || n % 3 != 0) return false;
        //     while (n % 3 == 0) {
        //         n /= 3;
        //     }
        //     return isPowerOfThree(n);
        // }
        // public boolean isPowerOfFour(int n) {
        //     if (n == 1) return true;
        //     if (n <= 0 || n % 4 != 0) return false;
        //     while (n % 4 == 0) {
        //         n /= 4;
        //     }
        //     return isPowerOfFour(n);
        // }



        // List<String> ls = new ArrayList<>();
        // int max = Integer.MIN_VALUE;
        // boolean [] vis;
        // int n;
        // private boolean isValid(String s, HashSet<String> ss) {
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     HashMap<Character, Integer> ms = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     for (String val : ss) {
        //         for (int i = 0; i < val.length(); i++) 
        //             ms.put(val.charAt(i), ms.getOrDefault(val.charAt(i), 0) + 1);
        //     }
        //     for (Map.Entry<Character, Integer> entry : m.entrySet()) 
        //         if (entry.getValue() != ms.get(entry.getKey())) return false;
        //     return true;
        // }
        // private void helper(String ori, HashSet<String> s, int va, int idx) {
        //     if (va == n) {
        //         if (isValid(ori, s)) {
        //             if (s.size() > max) {
        //                 ls = new ArrayList<>();
        //                 for (String val : s) ls.add(val);
        //                 max = s.size();
        //             }
        //         }
        //         return;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i] || i < idx) continue;
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             String tmp = ori.substring(idx, i+1);
        //             if (!s.contains(tmp)) {
        //                 s.add(tmp);
        //                 helper(ori, s, va + tmp.length(), i+1);
        //                 s.remove(tmp);
        //             } else {
        //                 idx = i;
        //                 helper(ori, s, va, i);
        //             }
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int maxUniqueSplit(String s) {
        //     n = s.length();
        //     vis = new boolean [n];
        //     helper(s, new HashSet<String>(), 0, 0);
        //     return max == Integer.MIN_VALUE ?  -1 : max;
        // }


        // List<String> res;
        // public void generate(int n, StringBuffer tmp, int left, int right) {
        //     if (left == n) {
        //         for (int i = 0; i < n - right; i++) 
        //             tmp.append(')');
        //         res.add(tmp.toString());
        //         return;
        //     } 
        //     generate(n, new StringBuffer(tmp).append("("), left+1, right);
        //     if (right < left)
        //         generate(n, new StringBuffer(tmp).append(")"), left, right+1);
        // }
        // public List<String> generateParenthesis(int n) {
        //     res = new ArrayList<String>();
        //     if (n > 0) 
        //         generate(n, new StringBuffer(), 0, 0);
        //     return res;
        // }


        // public String decodeString(String s) {
        //     int n = s.length();
        //     int i = 0;
        //     while (i < n && Character.isLetter(s.charAt(i))) ++i;
        //     if (i == n) return s;
        //     if (Character.isDigit(s.charAt(i))) {
        //         int idx = i+2;
        //         int x = 1, y = 0, j = 0;
        //         for (j = idx; j < n; j++) {
        //             if (s.charAt(j) == '[') ++x;
        //             else if (s.charAt(j) == ']') {
        //                 if (x > 0) {
        //                     --x;
        //                     if (x == 0) break;
        //                 } else ++y;
        //             }
        //         }
        //         String tmp = decodeString(s.substring())
        //     }
        // }

        
        // List<Integer> li = new ArrayList<>();
        // List<String> ls = new ArrayList<>();
        // private boolean isValid(StringBuilder ori) {
        //     int x = 0, y = 0;
        //     for (int i = 0; i < ori.length(); i++) {
        //         if (ori.charAt(i) == '(') {
        //             ++x;   
        //         }
        //         if (ori.charAt(i) == ')'){
        //             if (x > 0)
        //                 --x;
        //             else
        //                 ++y;
        //         }
        //     }
        //     return x == 0 && y == 0;
        // }
        // private void helper(String ori, StringBuilder s, int cnt, int x, int y, int idx, boolean mk) { // t : n
        //     if ((x == cnt && y == cnt)
        //         || (idx == ori.length() && (s.length() > 0 && (Character.isDigit(s.charAt(s.length()-1))) || (s.charAt(s.length()-1) == ')')))) {
        //         if (s.length() != ori.length() + cnt * 2) return;
        //         if (isValid(s) && !ls.contains(s.toString()))
        //             ls.add(s.toString());
        //         return;
        //     }
        //     for (int i = idx; i < ori.length(); i++) {
        //         char c = ori.charAt(idx);
        //         if (!Character.isDigit(c)) { // marks + - * / ( )
        //             if (!Character.isDigit(s.charAt(s.length()-1)) && s.charAt(s.length()-1) != '(' && s.charAt(s.length()-1) != ')') {
        //                 continue;
        //             }
        //             s.append(c);
        //             if (!mk) mk = true;
        //             helper(ori, s, cnt, x, y, i+1, mk);
        //             s.deleteCharAt(s.length()-1);
        //             continue;
        //         } 
        //         if (x >= y && x < cnt) {
        //             StringBuilder tmp = new StringBuilder(s);
        //             tmp.append('(');
        //             // al = true;
        //             helper(ori, tmp, cnt, x+1, y, i, mk);
        //             tmp.append(c);
        //             if (mk) mk = false;
        //             helper(ori, tmp, cnt, x+1, y, i+1, mk);
        //             tmp.deleteCharAt(tmp.length()-1);
        //         } else 
        //         if (y < x) {
        //             if (mk) {
        //                 StringBuilder tmp = new StringBuilder(s);
        //                 tmp.append(c);
        //                 tmp.append(')');
        //                 mk = false;
        //                 helper(ori, tmp, cnt, x, y+1, i+1, mk);
        //             } else {
        //                 s.append(c);
        //                 helper(ori, s, cnt, x, y, i+1, mk);
        //                 s.deleteCharAt(s.length()-1);
        //             }
        //         }
        //     }
        // }
        // public List<String> diffWaysToCompute(String expression) {
        //     int n = expression.length();
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (!Character.isDigit(expression.charAt(i))) ++cnt;
        //     if (cnt > 0)
        //         helper(expression, new StringBuilder(), cnt, 0, 0, 0, false);
        //     return ls;
        // }

        // public List<Integer> diffWaysToCompute(String expression) {
        //     List<Integer> res = new ArrayList<>();
        //     for (int i = 0; i < expression.length(); i++) {
        //         if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
        //             List<Integer> left = diffWaysToCompute(expression.substring(0, i));
        //             List<Integer> right = diffWaysToCompute(expression.substring(i+1));
        //             for (int j = 0; j < left.size(); j++) {
        //                 for (int k = 0; k < right.size(); k++) {
        //                     if (expression.charAt(i) == '+') res.add(left.get(j) + right.get(k));
        //                     else if (expression.charAt(i) == '-') res.add(left.get(j) - right.get(k));
        //                     else // if (expression.charAt(i) == '*')
        //                         res.add(left.get(j) * right.get(k));
        //                 }
        //             }
        //         }
        //     }
        //     if (res.size() == 0) 
        //         res.add(Integer.parseInt(expression));
        //     return res;
        // }



        // public List<Integer> grayCode(int n) {
        //     List<Integer> res = new ArrayList<Integer>();
        //     int bnd = (int)Math.pow(2.0, n);
        //     int tmp, one;
        //     for (int i = 0; i < bnd; i++) {
        //         tmp = i;
        //         one = tmp ^ (tmp >>> 1);
        //         res.add(one);
        //     }
        //     return res;
        // }
        // public List<Integer> circularPermutation(int n, int start) {
        //     List<Integer> l = grayCode(n);
        //     int i = 0;
        //     int tmp = 0;
        //     while (l.get(i) != start) {
        //         tmp = l.get(i);
        //         l.remove(0);
        //         l.add(tmp);
        //     }
        //     return l;
        // }


        // public String decodeString(String s) {
        //     int n = s.length();
        //     int i = 0;
        //     int j = 0;
        //     int k = 0;
        //     int l = 0, r = 0;
        //     String res = "";
        //     while (i < n) {
        //         while (i < n && Character.isLetter(s.charAt(i))) {
        //             res += s.charAt(i);
        //             ++i;
        //         }
        //         if (i == n) return res;
        //         if (Character.isDigit(s.charAt(i))) {
        //             j = i;
        //             while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //             int tmp = Integer.parseInt(s.substring(i, j));
        //             if (s.charAt(j) == '[') {
        //                 k = j;
        //                 while (k < n) {
        //                     if (s.charAt(k) == '[') ++l;
        //                     else if (s.charAt(k) == ']') {
        //                         if (l > 0) --l;
        //                         else ++r;
        //                     }
        //                     if (l == r) break;
        //                     ++k;  // k: ]
        //                 }
        //                 String tr = decodeString(s.substring(j+1, k));
        //                 StringBuilder t = new StringBuilder();
        //                 while (tmp > 0) {
        //                     res += tr;
        //                     --tmp;
        //                 }
        //                 System.out.println("res: " + res);
        //             }
        //             i = k+1;
        //         }
        //         if (i == n) return res;
        //     }
        //     return res;
        // }


        // private int getMatchedRIdx(String s, int idx) { // get matched ')' idx
        //     int l = 0, r = 0;
        //     int i = idx;
        //     for ( i = idx; i < s.length(); i++) {
        //         if (s.charAt(i) == '(') ++l;
        //         else if (s.charAt(i) == ')') {
        //             if (l > 0) --l;
        //             else ++r;
        //         }
        //         if (l == r) break;
        //     }
        //     return i;
        // }
        // private Set<String> helperParse(String s) { // expr1,expr2,...
        //     int n = s.length();
        //     int i = 0;
        //     char c = s.charAt(i);
        //     while (i < n && (c != '!' && c != '|' && c != '&' && c != '(' && c != ')')) {
        //         ++i;
        //         if (i < n) c = s.charAt(i);
        //     }
        //     Set<String> ss = new HashSet<>();
        //     if (i > 0) {
        //         ss = Stream.of(s.substring(0, i).trim().split("\\s*,\\s*"))
        //             .collect(Collectors.toSet());
        //     }
        //     if (i == n) return ss;
        //     int j = i+1; // i: ! | &
        //     while (j < n) {
        //         c = s.charAt(j);
        //         if (c == '!' || c == '|' || c == '&') {
        //             j = i+1;
        //             c = s.charAt(j);
        //         }
        //         while (j < n && c != '!' && c != '|' && c != '&' && c != '(' && c != ')') { // j: t or f; j+1: ,
        //             if (c == ',') {
        //                 ++j;
        //                 i = j;
        //                 c = s.charAt(j);
        //                 continue;
        //             }
        //             ss.add(s.substring(i, j+1));
        //             ++j;
        //             if (j == n) return ss;
        //             c = s.charAt(j);
        //         }
        //         if (c == '(') {
        //             int k = getMatchedRIdx(s, j);
        //             ss.add(s.substring(i, k+1));
        //             i = k+1;
        //             if (i == n) return ss;
        //         }
        //         if (s.charAt(i) == ',') ++i;
        //         j = i;
        //     }
        //     return ss;
        // }
        // private boolean parseNot(String s) {
        //     return !parseBoolExpr(s.substring(2, s.length()-1));
        // }
        // private boolean parseOr(String s) { // |(expr1,expr2,...)
        //     Set<String> ss = helperParse(s.substring(2, s.length()-1));
        //     boolean res = false;
        //     for (String val : ss) 
        //         res = res || parseBoolExpr(val);
        //     return res;
        // }
        // private boolean parseAnd(String s) { // &(expr1,expr2,...) may have > 2 elemnets
        //     Set<String> ss = helperParse(s.substring(2, s.length()-1));
        //     boolean res = true;
        //     for (String val : ss) 
        //         res = res && parseBoolExpr(val);
        //     return res;
        // }
        // public boolean parseBoolExpr(String expression) {
        //     char c = expression.charAt(0);
        //     if (expression.length() == 1) return c == 't' ? true : false;
        //     if (c == '!') return parseNot(expression.substring(0));
        //     else if (c == '&') return parseAnd(expression.substring(0));
        //     else return parseOr(expression.substring(0));
        // }

        
        // public int calculate(String s) {
        //     int res = 0;
        //     int n = s.length();
        //     if (n == 1) return Integer.parseInt(s);

        //     StringBuilder t = new StringBuilder(s);
        //     int i = 0;
        //     while (i < t.length()) {
        //         while (i < t.length() && Character.isWhitespace(t.charAt(i))) 
        //             t.deleteCharAt(i);
        //         while (i < t.length() && (Character.isDigit(t.charAt(i))
        //                          || t.charAt(i) == '(' || t.charAt(i) == ')'
        //                          || t.charAt(i) == '+' || t.charAt(i) == '-')) ++i;
        //     }
        //     s = t.toString();
        //     n = s.length();
        //     i = 0;
        //     while (i < n && Character.isDigit(s.charAt(i))) ++i;
        //     int l = 1, r = 0, bgn = 0;
        //     int j = i+1;
        //     if (i == n) return Integer.parseInt(s);
        //     else if (s.charAt(i) == '+') {
        //         l = calculate(s.substring(0, i));
        //         r = calculate(s.substring(i+1));
        //         if (s.charAt(i) == '+') 
        //             return l + r;
        //         else return l - r;
        //     } else if (s.charAt(i) == '-') {
        //         l = calculate(s.substring(0, i));
        //         j = i + 1;
        //         while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //         if (j == n) return l - Integer.parseInt(s.substring(i+1, j));
        //         if (s.charAt(j) == '+') 
        //             return l - Integer.parseInt(s.substring(i+1, j)) + calculate(s.substring(j+1));
        //         else { // '-'
        //             l -= Integer.parseInt(s.substring(i+1, j));
        //             bgn = 0;
        //             while (j < n && s.charAt(j) == '-') {
        //                 ++j;
        //                 bgn = j;
        //                 while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //                 if (j == n) return l - Integer.parseInt(s.substring(bgn, j));
        //                 if (s.charAt(j) == '+') 
        //                     return l - Integer.parseInt(s.substring(i+1, j)) + calculate(s.substring(j+1));
        //                 l -= Integer.parseInt(s.substring(bgn, j));
        //             }
        //         }
        //     } else if (s.charAt(i) == '(') {
        //         j = i;
        //         l = 0;
        //         r = 0;
        //         for (j = i; j < n; j++) {
        //             if (s.charAt(j) == '(') ++l;
        //             else if (s.charAt(j) == ')') {
        //                 if (l > 0) --l;
        //                 else {
        //                     ++r;
        //                 }
        //             }
        //             if (l == r) break;
        //         }
        //         l = calculate(s.substring(i+1, j));
        //         if (s.charAt(j+1) == '+') {
        //             r = calculate(s.substring(j+2));
        //             return l + r;
        //         } else { // - j+1
        //            bgn = j+2;
        //             if (s.charAt(j+2) == '(') return l - calculate(s.substring(j+2));
        //             j += 2;
        //             while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //             if (j == n) return l - Integer.parseInt(s.substring(i+1, j));
        //             if (s.charAt(j) == '+') 
        //                 return l - Integer.parseInt(s.substring(bgn, j)) + calculate(s.substring(j+1));
        //             else { // '-'
        //                 l -= Integer.parseInt(s.substring(bgn, j));
        //                  bgn = 0;
        //                 while (j < n && s.charAt(j) == '-') {
        //                     ++j;
        //                     bgn = j;
        //                     while (j < n && Character.isDigit(s.charAt(j))) ++j;
        //                     if (j == n) return l - Integer.parseInt(s.substring(bgn, j));
        //                     if (s.charAt(j) == '+') 
        //                         return l - Integer.parseInt(s.substring(bgn, j)) + calculate(s.substring(j+1));
        //                     l -= Integer.parseInt(s.substring(bgn, j));
        //                 }
        //             }
        //         }
        //     }
        //     return -1;
        // }
        // public int calculate(String s) {
        //     Stack<Integer> stack = new Stack<>();
        //     int res = 0;
        //     int cur = 0;
        //     int sign = 1;
        //     for (int i = 0; i < s.length(); i++) {
        //         char c = s.charAt(i);
        //         if (Character.isDigit(c)) {
        //             cur = (int)(c - '0');
        //             while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
        //                 cur = cur * 10 + s.charAt(i+1) - '0';
        //                 i++;
        //             }
        //             res += cur * sign;
        //         } else if (c == '(') {
        //             stack.push(res);
        //             stack.push(sign);
        //             res = 0;
        //             sign = 1;
        //         } else if (c == ')') {
        //             res = res * stack.pop();
        //             res = res + stack.pop();
        //         } else if (c == '-') sign = -1;
        //         else if (c == '+') sign = 1;
        //         cur = 0;
        //     }
        //     return res;
        // }
        // public int calculate(String s) {
        //     Stack<Integer> stack = new Stack<>();
        //     int cur = 0;
        //     int sign = '+';
        //     for (int i = 0; i < s.length(); i++) {
        //         char c = s.charAt(i);
        //         if (Character.isDigit(c)) 
        //             cur = cur * 10 + c - '0';
        //         if (!Character.isDigit(c) && c != ' ' || i == s.length()-1) {
        //             if (sign == '+') stack.push(cur);
        //             else if (sign == '-') stack.push(-cur);
        //             else if (sign == '*') stack.push(stack.pop() * cur);
        //             else if (sign == '/') stack.push(stack.pop() / cur);
        //             sign = c;
        //             cur = 0;
        //         }
        //     }
        //     int res = 0;
        //     while (!stack.isEmpty())
        //         res += stack.pop();
        //     return res;
        // }


        // private String switchN(int n) {
        //     String res = "";
        //     switch (n) {
        //     case 0: res += "Zero"; return res;
        //     case 1: res += "One"; return res;
        //     case 2: res += "Two"; return res;
        //     case 3: res += "Three"; return res;
        //     case 4: res += "Four"; return res;
        //     case 5: res += "Five"; return res;
        //     case 6: res += "Six"; return res;
        //     case 7: res += "Seven"; return res;
        //     case 8: res += "Eight"; return res;
        //     case 9: res += "Nine"; return res;
        //     }
        //     return res;
        // }
        // private String switchNN(int n) {
        //     String res = "";
        //     switch (n) { // 10 11 12 .... 19
        //     case 0: res += "Ten"; return res;
        //     case 1: res += "Eleven"; return res;
        //     case 2: res += "Twelve"; return res;
        //     case 3: res += "Thirteen"; return res;
        //     case 4: res += "Fourteen"; return res;
        //     case 5: res += "Fifteen"; return res;
        //     case 6: res += "Sixteen"; return res;
        //     case 7: res += "Seventeen"; return res;
        //     case 8: res += "Eighteen"; return res;
        //     case 9: res += "Nineteen"; return res;
        //     }
        //     return res;
        // }
        // private String switchN1N(int n) {
        //     String res = "";
        //     switch (n) { // 10 11 12 .... 19
        //     case 2: res += "Twenty"; return res;
        //     case 3: res += "Thirty"; return res;
        //     case 4: res += "Forty"; return res;
        //     case 5: res += "Fifty"; return res;
        //     case 6: res += "Sixty"; return res;
        //     case 7: res += "Seventy"; return res;
        //     case 8: res += "Eighty"; return res;
        //     case 9: res += "Ninety"; return res;
        //     }
        //     return res;
        // }
        // public String numberToWords(int num) {
        //     String s = String.valueOf(num);
        //     int n = s.length();
        //     String res = "";
        //     if (n == 1) {
        //         return switchN(num);
        //     }
        //     if (n == 2) { // 20
        //         if (s.equals("00")) return "";
        //         if (s.charAt(1) == '0') {
        //             if (s.charAt(0) == '1') return "Ten";
        //             else return switchN1N(Integer.parseInt(Character.toString(s.charAt(0))));
        //         } else {
        //             if (s.charAt(0) - '0' > 1) {
        //                 res += switchN1N(Integer.parseInt(Character.toString(s.charAt(0)))) + " " + switchN(Integer.parseInt(Character.toString(s.charAt(1))));
        //             } else if (s.charAt(0) == '1') {
        //                 res += switchNN(Integer.parseInt(Character.toString(s.charAt(1))));
        //                 return res;
        //             }
        //         }
        //     } else if (n == 3) { // 这里逻辑还不彻底清晰，改天再理吧
        //         if (s.charAt(1) != '0')
        //             res += switchN(Integer.parseInt(Character.toString(s.charAt(0)))) + " Hundred " + numberToWords(Integer.parseInt(s.substring(1, 3)));
        //         else { // s.charAt(1) == '0' : 101 - 909
        //             System.out.println("(s.charAt(2) != '0'): " + (s.charAt(2) != '0'));

        //             if (s.charAt(2) != '0')
        //                 res += switchN(Integer.parseInt(Character.toString(s.charAt(0)))) + " Hundred " + switchN(Integer.parseInt(Character.toString(s.charAt(2))));
        //             else  // 100 200
        //                 res += switchN(Integer.parseInt(Character.toString(s.charAt(0)))) + " Hundred";
        //         }
        //         return res;
        //     } else if (n <= 6) {
        //         if (!s.substring(n-3).equals("000"))
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-3))) + " Thousand " + numberToWords(Integer.parseInt(s.substring(n-3)));
        //         else
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-3))) + " Thousand";
        //         return res;
        //     } else if (n <= 9) {
        //         if (!s.substring(n-6).equals("000000"))
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-6))) + " Million " + numberToWords(Integer.parseInt(s.substring(n-6)));
        //         else
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-6))) + " Million";
        //         return res;
        //     } else if (n <= 12) {
        //         if (!s.substring(n-9).equals("000000000"))
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-9))) + " Billion " + numberToWords(Integer.parseInt(s.substring(n-9)));
        //         else
        //             res += numberToWords(Integer.parseInt(s.substring(0, n-9))) + " Billion";
        //         return res;
        //     }
        //     return res;
        // }
        

        // private boolean isValid(StringBuilder s) {
        //     int n = s.length();
        //     if (n == 1) return true;
        //     if (n == 2 && s.charAt(0) == '0') return false; // 0X
        //     if (n > 2 && s.charAt(0) == '0' && s.charAt(1) != '.') return false; // 00
        //     if (n >= 3) { // 100
        //         if (s.charAt(s.length()-1) == '0') {
        //             if (s.charAt(s.length()-2) == '.') return false; // 1.0
        //             int i = n-1; // .00
        //             for ( i = n-1; i >= 0; i--) {
        //                 if (s.charAt(i) == '0') continue;
        //                 else if (s.charAt(i) == '.') break;
        //             }
        //             if (i < s.length()-1 && i >= 0 && s.charAt(i) == '.') return false;
        //         }
        //     }
        //     return true;
        // }
        // public List<String> ambiguousCoordinatesHelper(StringBuilder s) { // parse to be one number
        //     List<String> l = new ArrayList<>();
        //     int n = s.length();
        //     if (n == 1) {
        //         l.add(s.toString());
        //         return l;
        //     }
        //     if (n == 2) {
        //         if (isValid(s)) l.add(s.toString());
        //         s.insert(1, '.');
        //         if (isValid(s))
        //             l.add(new StringBuilder(s).toString());
        //         s.deleteCharAt(1);
        //         return l;
        //     }
        //     for (int i = 0; i < s.length(); i++) {
        //         if (i < s.length()-1) {
        //             s.insert(i+1, '.');
        //             if (isValid(s)) l.add(new StringBuilder(s).toString());
        //             s.deleteCharAt(i+1);
        //         } else if (isValid(s)) l.add(s.toString());
        //     }
        //     return l;
        // }
        // public List<String> ambiguousCoordinates(String s) {
        //     int n = s.length();
        //     List<String> res = new ArrayList<>();
        //     if (n == 4) {
        //         StringBuilder t = new StringBuilder(s);
        //         t.insert(2, ',');
        //         t.insert(3, ' ');
        //         res.add(t.toString());
        //         return res;
        //     }
        //     List<String> l = new ArrayList<>();
        //     List<String> r = new ArrayList<>();
        //     for (int i = 2; i < n-1; i++) {
        //         l = ambiguousCoordinatesHelper(new StringBuilder(s.substring(1, i)));
        //         r = ambiguousCoordinatesHelper(new StringBuilder(s.substring(i, n-1)));
        //         if (l.size() == 0 || r.size() == 0) continue;
        //         for (int j = 0; j < l.size(); j++) {
        //             for (int k = 0; k < r.size(); k++) {
        //                 res.add("(" + l.get(j) + ", " + r.get(k) + ")");
        //             }
        //         }
        //     }
        //     return res;
        // }

        
        // // 快速幂计算
        // private long pow(int base, int exp, int mod) {
        //     long res = 1l, curBase = base;
        //     while (exp > 0) {
        //         if ((exp & 1) == 1) // 最后残余的一次乘法
        //             res = res * curBase % mod;
        //         exp >>= 1;
        //         curBase = (long)curBase * curBase % mod;
        //     }
        //     return res;
        // }
        // public int maxNiceDivisors(int primeFactors) {
        //     if (primeFactors == 1) return 1;
        //     int mod = 1000000007;
        //     int k = primeFactors % 3;
        //     if (k == 1) return (int)(pow(3, primeFactors / 3 -1, mod) * 4 % mod);
        //     if (k == 2) return (int)(pow(3, primeFactors / 3, mod) * 2 % mod);
        //     return (int)(pow(3, primeFactors / 3, mod) % mod);
        // }

        // private int countOnes(int v) {
        // }
        // public int countDigitOne(int n) {
        //     for (int i = 0; i <= n; i++) 
        //         t.insert(String.valueOf(i));
        //     return t.countOnes();
        // }


        // private boolean isValid(String s) { // 还需要debug一下，暂时不想再写这个题了
        //     int n = s.length();
        //     if (n == 0) return true;
        //     if (!Character.isDigit(s.charAt(0))) return false;
        //     int i = 0;
        //     while (i < n && Character.isDigit(s.charAt(i))) ++i;  // + - *
        //     if (i == n && (n == 1 || s.charAt(0) != '0')) return true;
        //     else if (i == n) return false;
        //     if (s.charAt(i+1) == '0' && i+1 != n-1 && Character.isDigit(s.charAt(i+2))) return false;
        //     return true;
        // }   //                                                                       prev v ,   cur Sum
        // private void addOperatorsHelper(String s, int k, String t, int idx, int cnt, long lv, long cur, int pre, int pp) { // lv: last val
        //     if (!isValid(t)) return;
        //     if (idx == n) {
        //         if (t.length() < n+cnt) return; // try to remove this one
        //         if (k == cur && !ss.contains(t)) 
        //             ss.add(new String(t));
        //         return;
        //     }
        //     for (int i = idx; i < n; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             long v = 0;
        //             if (i == 0 && t.length() == 0) {
        //                 v = Long.parseLong(Character.toString(s.charAt(i)));
        //                 addOperatorsHelper(s, k, t+Character.toString(s.charAt(i)), i+1, cnt, v, cur-lv+v, pre, pp);
        //                 continue;
        //             }
        //             if ((String.valueOf(lv) + Character.toString(s.charAt(i))).length() < String.valueOf(Long.MAX_VALUE).length())
        //                 v = Long.parseLong(String.valueOf(lv) + Character.toString(s.charAt(i)));
        //             if (pre == 0) {
        //                 addOperatorsHelper(s, k, t+Character.toString(s.charAt(i)), i+1, cnt, v, cur-lv+v, pre, pp);
        //             } else {
        //                 if (pp != 0 && (String.valueOf(lv) + Character.toString(s.charAt(i))).length() < String.valueOf(Long.MAX_VALUE).length()) {
        //                     v = (lv / pp) * Long.parseLong(String.valueOf(lv)+Character.toString(s.charAt(i)));
        //                     addOperatorsHelper(s, k, t+Character.toString(s.charAt(i)), i+1, cnt, v, cur-lv+v, pre, (int)Long.parseLong(String.valueOf(lv)+Character.toString(s.charAt(i))));
        //                 }
        //             }
        //             for (int j = 0; j < op.length; j++) {
        //                 if (!vip[j]) {
        //                     if (op[j] == '+' || op[j] == '-' || (op[j] == '*' && pre == 1)) {
        //                         if (op[j] != '*') {
        //                             v = Long.parseLong(Character.toString(op[j]) + Character.toString(s.charAt(i)));
        //                             addOperatorsHelper(s, k, t+Character.toString(op[j])+Character.toString(s.charAt(i)), i+1, cnt+1, v, cur+v, 0, (int)v);
        //                         } else {
        //                             v = lv*Long.parseLong(Character.toString(s.charAt(i)));
        //                             addOperatorsHelper(s, k, t+Character.toString(op[j])+Character.toString(s.charAt(i)), i+1, cnt+1, v, cur-lv+v, 0,
        //                                                (int)Long.parseLong(Character.toString(s.charAt(i))));
        //                         }
        //                     } else { // * (+ -)
        //                         v = lv*Long.parseLong(Character.toString(s.charAt(i)));
        //                         addOperatorsHelper(s, k, t+Character.toString(op[j])+Character.toString(s.charAt(i)), i+1, cnt+1, v, cur-lv+v, 1,
        //                                            (int)Long.parseLong(Character.toString(s.charAt(i))));
        //                     }
        //                 }
        //             }
        //             vis[i] = false;
        //         }
        //     }
        // }
        // Set<String> ss = new HashSet<>();
        // boolean [] vis;
        // boolean [] vip;
        // char [] op = {'+', '-', '*'};
        // int n;
        // public List<String> addOperators(String num, int target) {
        //     n = num.length();
        //     if (n == 1) {
        //         ss.add(num);
        //         return new ArrayList<String>(ss);
        //     }
        //     vis = new boolean[n];
        //     vip = new boolean[3];
        //     addOperatorsHelper(num, target, "", 0, 0, 0, 0, 0, 0);
        //     return new ArrayList<String>(ss);
        // }
    // 我们需要用一个变量记录乘法当前累乘的值，直到累乘完了，遇到下一个加号或减号再将其算入计算结果中。这里有两种情况:
    //     乘号之前是加号或减号，例如2+3*4，我们在2那里算出来的结果，到3的时候会加上3，计算结果变为5。在到4的时候，因为4之前我们选择的是乘号，这里3就应该和4相乘，而不是和2相加，所以在计算结果时，要将5先减去刚才加的3得到2，然后再加上3乘以4，得到2+12=14，这样14就是到4为止时的计算结果。
    //         另外一种情况是乘号之前也是乘号，如果2+3*4*5，这里我们到4为止计算的结果是14了，然后我们到5的时候又是乘号，这时候我们要把刚才加的3*4给去掉，然后再加上3*4*5，也就是14-3*4+3*4*5=62。这样5的计算结果就是62。
    //         因为要解决上述几种情况，我们需要这么几个变量，一个是记录上次的计算结果currRes，一个是记录上次被加或者被减的数prevNum，一个是当前准备处理的数currNum。当下一轮搜索是加减法时，prevNum就是简单换成currNum，当下一轮搜索是乘法时，prevNum是prevNum乘以currNum。
    //         注意
    //         第一次搜索不添加运算符，只添加数字，就不会出现+1+2这种表达式了。
    //         我们截出的数字不能包含0001这种前面有0的数字，但是一个0是可以的
        // 时间复杂度 O(n)，空间复杂度 O(n)
/*        private void helper(String s, int target, String tmp, long curRes, long preVal) {
            if (curRes == target && s.length() == 0) { // 如果计算结果等于目标值，且所有数都用完了，则是有效结果
                String tpp = new String(tmp);
                res.add(tpp);
                return;
            }
            for (int i = 1; i <= s.length(); i++) { // 搜索所有可能的拆分情况
                String curStr = s.substring(0, i);
                if (curStr.length() > 1 && curStr.charAt(0) == '0') return;  // 对于前导为0的数予以排除
                long curVal = Long.parseLong(curStr); // 得到当前截出的数
                String next = s.substring(i);         // 去掉当前的数，得到下一轮搜索用的字符串
                if (tmp.length() != 0) {
                    helper(next, target, tmp+"*"+curVal, (curRes-preVal)+preVal*curVal, preVal*curVal); // 乘法
                    helper(next, target, tmp+"+"+curVal, curRes+curVal, curVal);
                    helper(next, target, tmp+"-"+curVal, curRes-curVal, -curVal);
                } else
                    helper(next, target, curStr, curVal, curVal);  // 第一个数
            }
        }
        List<String> res;
        public List<String> addOperators(String num, int target) {
            res = new ArrayList<>();
            helper(num, target, "", 0, 0);
            return res;
        }  */
        // 时间复杂度：这个和我最初的想法比较像，但是我总是代码越写越复杂。。。。。。
        // 在这一过程的每一步中，我们都会考虑 4 种不同的选择或 4 种不同的递归路径。基本情况是当索引值达到 NN 时，即 nums 数组的长度。因此，我们的复杂性将是O(4^n)O(4^n)。
        // 对于基本情况，我们在 Java 中使用了 StringBuilder::toString 函数和在 Python 中使用了 .join() 函数花费了 O(N)O(N) 时间。这里 NN 表示了表达式的长度。在最坏的情况下，每个数字都是一个操作数，我们有 NN 个数字和 N-1N−1 个运算符。所以 O(N)O(N)是对于一个表达式。在最坏的情况下，我们可以有 O(4^n)O(4^n) 有效表达式。
        // 空间复杂度：
        // 对于 Python 和 Java 实现，我们有一个列表数据结构，我们只在有效的表达式中更新，我们创建一个新的字符串并添加到我们的答案数组中。因此，中间列表所占的空间将是 O(n)O(n) ,因为在最坏的情况下，表达式将从所有数字中构建为操作数。
        //     由于递归堆栈的大小由索引的值决定，因此递归堆栈占用的空间也将为 O(n)O(n) 并且从 00 一直到 NN 不等。
        public ArrayList<String> answer;
        public String digits;
        public long target;
        public void recurse(
            int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops) {
            String nums = this.digits;
            // Done processing all the digits in num
            if (index == nums.length()) {
                // If the final value == target expected AND
                // no operand is left unprocessed
                if (value == this.target && currentOperand == 0) {
                    StringBuilder sb = new StringBuilder();
                    ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                    this.answer.add(sb.toString());
                }
                return;
            }
            // Extending the current operand by one digit
            currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
            String current_val_rep = Long.toString(currentOperand);
            int length = nums.length();
            // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
            // valid operand. Hence this check
            if (currentOperand > 0) {
                // NO OP recursion
                recurse(index + 1, previousOperand, currentOperand, value, ops);
            }
            // ADDITION
            ops.add("+");
            ops.add(current_val_rep);
            recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
            if (ops.size() > 0) {
                // SUBTRACTION
                ops.add("-");
                ops.add(current_val_rep);
                recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);
                // MULTIPLICATION
                ops.add("*");
                ops.add(current_val_rep);
                recurse(
                    index + 1,
                    currentOperand * previousOperand,
                    0,
                    value - previousOperand + (currentOperand * previousOperand),
                    ops);
                ops.remove(ops.size() - 1);
                ops.remove(ops.size() - 1);
            }
        }
        public List<String> addOperators(String num, int target) {
            if (num.length() == 0) {
                return new ArrayList<String>();
            }
            this.target = target;
            this.digits = num;
            this.answer = new ArrayList<String>();
            this.recurse(0, 0, 0, 0, new ArrayList<String>());
            return this.answer;
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "232";

       List<String> r = s.addOperators(a, 8);
       System.out.println("r.size(): " + r.size());
       for (int z = 0; z < r.size(); ++z) 
           System.out.print(r.get(z) + ", ");
       System.out.print("\n");
    }
}
