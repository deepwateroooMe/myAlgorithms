// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class backtwoTracking {
    public static class Solution {   


        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // int [] arr;
        // private void helper(HashMap<Integer, Integer> m, int n, int val, List<Integer> l) {
        //     // System.out.println("\nl.size(): " + l.size());
        //     // for (int z = 0; z < l.size(); ++z) 
        //     //     System.out.print(l.get(z) + ", ");
        //     // System.out.print("\n");
        //     if (l.size() == 2*n-1) {
        //         if (!ll.contains(l)) {
        //             ll.add(new ArrayList<>(l));
        //             return;
        //         }
        //     }
        //     for (int i = 1; i <= n; i++) {
        //         if ((arr[i] == 1 && m.containsKey(arr[i]) && m.get(arr[i]) == 1)
        //             || (arr[i] > 1 && m.containsKey(arr[i]) && m.get(arr[i]) == 2)) continue;
        //         // System.out.println("\ni: " + i);
        //         // System.out.println("arr[i]: " + arr[i]);
        //         if (l.size() < 2) {
        //             if (l.size() == 1 && arr[i] == l.get(0)) continue;
        //             l.add(arr[i]);
        //             HashMap<Integer, Integer> map = new HashMap<>(m);
        //             map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        //             helper(map, n, val+1, l);
        //             l.remove(l.size()-1);
        //         } else {
        //             boolean fixed = false;
        //             for (int j = 0; j < l.size(); j++) {
        //                 // System.out.println("j: " + j);
        //                 // System.out.println("l.get(j): " + l.get(j));
        //                 // System.out.println("(l.get(j) > 1 && m.get(l.get(j)) == 1 && j + l.get(j) == l.size()): " + (l.get(j) > 1 && m.get(l.get(j)) == 1 && j + l.get(j) == l.size()));
        //                 if (l.get(j) > 1 && m.get(l.get(j)) == 1 && j + l.get(j) == l.size()) {
        //                     fixed = true;
        //                     l.add(l.get(j));
        //                     HashMap<Integer, Integer> map = new HashMap<>(m);
        //                     map.put(l.get(j), 2);
        //                     helper(map, n, val+1, l);
        //                 } else if (l.get(j) > 1 && m.get(l.get(j)) == 1 && j + l.get(j) > l.size() && arr[i] == l.get(j)) {
        //                     ++i;
        //                     continue;
        //                 }
        //             }
        //             // System.out.println("arr[i]: " + arr[i]);
        //             // System.out.println("m.get(arr[i]): " + m.get(arr[i]));
        //             if (fixed) {
        //                 fixed = false;
        //                 continue;
        //             }
        //             System.out.println("i: " + i);
        //             // if (i > n) {
        //             //     i = 1;
        //             //     continue;
        //             // }
        //             l.add(arr[i]);
        //             HashMap<Integer, Integer> map = new HashMap<>(m);
        //             map.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //             helper(map, n, val+1, l);
        //             l.remove(l.size()-1);
        //         }
        //     }
        // }
        // public int[] constructDistancedSequence(int n) {
        //     arr = new int[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         arr[i] = n-i+1;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     l = new ArrayList<>();
        //     helper(m, n, 0, l);
        //     System.out.println("ll.size(): " + ll.size());
        //     for (int z = 0; z < ll.size(); ++z) {
        //         for (int q = 0; q < ll.get(z).size(); q++) 
        //             System.out.print(ll.get(z).get(q) + ", ");
        //         System.out.print("\n ");
        //     }
        //     return ll.size() > 0 ? ll.get(0).stream().mapToInt(i->i).toArray() : null;
        // }

        
        // List<List<String>> lls = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // private boolean isValid(StringBuilder s) {
        //     int n = s.length();
        //     if (n > 1 && s.charAt(0) == '0') return false;
        //     return true;
        // }
        // private boolean isValid(List<String> l) {
        //     for (int i = 2; i < l.size(); i++) 
        //         if (Integer.parseInt(l.get(i-2)) + Integer.parseInt(l.get(i-1)) != Integer.parseInt(l.get(i))) return false;
        //     return true;
        // }
        // private void helper(String s, List<String> l, StringBuilder t, int idx) {
        //     if (!isValid(t)) return;
        //     if (l.size() >= 3 && !isValid(l)) return;
        //     if (idx == vis.length) {
        //         if (isValid(l) && !lls.contains(l))
        //             lls.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = idx; i < vis.length; i++) {
        //         char c = s.charAt(i);
        //         t.append(c);
        //         // if (!vis[i]) {
        //         //     vis[i] = true;
        //             l.add(t.toString());
        //             t = new StringBuilder();
        //             helper(s, new ArrayList<>(l), new StringBuilder(t), idx+1);
        //             t = new StringBuilder(l.get(l.size()-1));
        //             l.remove(l.size()-1);
        //         //     vis[i] = false;
        //         // }
        //     }
        // }
        // public boolean isAdditiveNumber(String num) {
        //     n = num.length();
        //     if (n < 3) return false;
        //     vis = new boolean [n];
        //     helper(num, new ArrayList<String>(), new StringBuilder(), 0);
        //     return lls.size() > 0;
        // } // ????????????????????????
        
        // public boolean isAdditiveNumber(String num) {
        //     int n = num.length();
        //     if (n < 3) return false;
        //     for (int i = 1; i <= num.length() >> 1; i++)
        //         for (int j = 1; j + i < num.length(); j++)  
        //             if (isValid(num, num.substring(0, i), num.substring(i, i + j), i + j)) return true;
        //     return false;
        // }
        // private boolean isValid(String num, String first, String second, int index) {
        //     if (first.length() > 1 && first.startsWith("0") 
        //         || second.length() > 1 && second.startsWith("0")) return false;
        //     if (index == num.length()) return true; // ??????????????????????????????????????????
        //     long sum = Long.parseLong(first) + Long.parseLong(second);
        //     if (num.startsWith(sum + "", index))    // ????????????????????????
        //         if (isValid(num, second, sum + "", index + (sum + "").length())) return true;
        //     return false;
        // }
        

        // private int getgcd(int x, int y) {
        //     while (x != y) {
        //         if(x > y) x = x - y;
        //         else y = y - x;
        //     }
        //     return x;
        // }
        // private int count(int val) {
        //     int cnt = 0;
        //     while (val > 0) {
        //         val = val & (val-1);
        //         cnt++;
        //     }
        //     return cnt;
        // }
        // public int maxScore(int[] nums) {
        //     int n = nums.length;
        //     int [][] arr = new int [n][n];
        //     int mask = 1;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             arr[i][j] = getgcd(nums[i], nums[j]);
        //         }
        //     }
        //     int range = 1 << n;    //?????????????????????
        //     int [] dp = new int [range];
        //     for (int i = 0; i < range; i++) {
        //         int cnt = count(i); //??????????????????1?????????
        //         if ((cnt & 1) == 1) //??????????????????????????????????????????????????????
        //             continue;
        //         for (int j = 0; j < n; j++) {
        //             for (int k = j+1; k < n; k++) {
        //                 int state = (1 << j) | (1 << k);
        //                 if ((state & i) != state) //???2???????????????????????????????????????????????????
        //                     continue;
        //                 dp[i] = Math.max(dp[i], dp[i-state] + getgcd(nums[j], nums[k]) * (cnt >> 1));
        //             }
        //         }
        //     }
        //     return dp[range-1];
        // }

        
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> res = new ArrayList<>();
        // int n;
        // private boolean isValid(List<String> l) { 
        //     if (l.size() < 3) return false;
        //     for (int i = 1; i < l.size(); i++)
        //         if (l.get(i).length() < l.get(i-1).length()) return false;
        //     for (int i = 2; i < l.size(); i++) {
        //         int tmp = 0, tt = 0;
        //         if (l.get(i).length() == l.get(i-1).length())
        //             tmp = Integer.parseInt(l.get(i));
        //         else tmp = Integer.parseInt(l.get(i).substring(l.get(i-1).length()));
        //         if (l.get(i-1).length() == l.get(i-2).length())
        //             tt = Integer.parseInt(l.get(i-1));
        //         else tt = Integer.parseInt(l.get(i-1).substring(l.get(i-2).length()));
        //         if (tmp != tt + Integer.parseInt(l.get(i-2))) return false;
        //     }
        //     return true;
        // }
        // private void helper(String s, List<String> l, StringBuilder t, int idx) {
        //     if (l.size() >= 3 && !isValid(l)) return;
        //     if (idx == s.length()) {
        //         if (isValid(l)) {
        //             res = new ArrayList<>();
        //             res.add(Integer.parseInt(l.get(0)));
        //             for (int i = 1; i < l.size(); i++) {
        //                 res.add(Integer.parseInt(l.get(i).substring(l.get(i-1).length())));
        //             }
        //             ll.add(res);
        //         }
        //         return;
        //     }
        //     for (int i = idx; i < n; i++) {
        //         char c = s.charAt(i);
        //         if (i == 0 || t.length() == 0) {
        //             t.append(c);
        //             helper(s, l, new StringBuilder(t), i+1);
        //             t.deleteCharAt(t.length()-1);
        //         } else {
        //             t.append(c);
        //             helper(s, l, new StringBuilder(t), i+1);
        //             t.deleteCharAt(t.length()-1);
        //             l.add(t.toString());
        //             t = new StringBuilder ();
        //             t.append(c);
        //             helper(s, new ArrayList<>(l), t, i+1);
        //             t = new StringBuilder (l.get(l.size()-1));
        //             l.remove(l.size()-1); // ???????????????????????????????????????????????????
        //             t.deleteCharAt(t.length()-1);
        //         }
        //     }
        // }
        // public List<Integer> splitIntoFibonacci(String num) {
        //     n = num.length();
        //     res = new ArrayList<>();
        //     helper(num, new ArrayList<String>(), new StringBuilder(), 0);
        //     return ll.get(0);
        // }
        // private boolean dfs(String s, List<Integer> l, int idx) {
        //     if (s.length() == idx && l.size() >= 3) return true;
        //     for (int i = idx; i < s.length(); i++) {
        //         if (s.charAt(idx) == '0' && i > idx) return false; // 012
        //         long val = Long.parseLong(s.substring(idx, i+1));
        //         if (val > Integer.MAX_VALUE) return false;         // ???????????????
        //         // ?????????????????????????????????????????????????????????????????????
        //         if (l.size() >= 2 && val > l.get(l.size()-1) + l.get(l.size()-2)) return false;
        //         // ????????????????????????????????????????????????????????????????????????
        //         if (l.size() < 2 || val == l.get(l.size()-1) + l.get(l.size()-2)) {
        //             l.add((int)val);
        //             if (dfs(s, l, i+1)) return true;
        //             // ??????????????????????????????
        //             l.remove(l.size()-1);
        //         }
        //     }
        //     return false;
        // }
        // public List<Integer> splitIntoFibonacci(String num) {
        //     int n = num.length();
        //     List<Integer> res = new ArrayList<>();
        //     dfs(num, res, 0);
        //     return res;
        // }
        

        // private boolean isValid(String ori) {
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
        // List<String> res = new ArrayList<>();
        // int n;
        // private void dfs(String s, int idx, int l, int r) {
        //     if ((l == 0 && r == 0)) {
        //         if (isValid(s) && !res.contains(s))
        //             res.add(s);
        //         return;
        //     }
        //     for (int i = idx; i < s.length(); i++) {
        //         char c = s.charAt(i);
        //         //  ?????????????????????????????????????????????l>0 or r>0?????????????????????
        //         if (c == '(' && l > 0) {
        //             StringBuilder t = new StringBuilder(s);
        //             t.deleteCharAt(i);
        //             dfs(t.toString(), i, l-1, r);
        //         }
        //         if (c == ')' && r > 0) {
        //             StringBuilder t = new StringBuilder(s);
        //             t.deleteCharAt(i);
        //             dfs(t.toString(), i, l, r-1);
        //         } 
        //     }
        // }
        // public List<String> removeInvalidParentheses(String s) {
        //     n = s.length();
        //     int left = 0, right = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) == '(') {
        //             ++left;   
        //         } else if (s.charAt(i) == ')') {
        //             if (left > 0) --left;
        //             else ++right;
        //         }
        //     }
        //     res = new ArrayList<>();
        //     dfs(s, 0, left, right);
        //     return res;
        // }

        // private void helper(int m, int n, int cnt, int jidx) { // m <= n
        //     if (m == 1 && n == 1) return;
        //     if (v > n)  return;
        //     for (int i = m; i >= 1; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             for (int j = idx; j < m; j++) {
        //             }
        //             vis[i] = false;
        //         }
        //     }
        // }
        // int min = 0;
        // int [][] arr;
        // boolean [] vis;
        // public int tilingRectangle(int m, int n) {
        //     if (m == 1 && n == 1) return 1;
        //     min = 0;
        //     m = Math.min(m, n);
        //     n = Math.max(m, n);
        //     arr = new int[m][n];
        //     vis = new int[n];
        //     helper(m, n, 0, 0);
        //     return min;
        // }


        // int n;
        // public boolean judgePoint24(int[] arr) {
        //     n = 4;
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum *= arr[i];
        //     if ()
        // }

        // public class Item implements Comparable<Item> {
        //     int coeff;
        //     private ArrayList<String> factors;
        //     public Item (String factor, int coeff) {
        //         this.factors = new ArrayList<String>();
        //         this.factors.add(factor);
        //         this.coeff = coeff;
        //     }
        //     public Item(int coeff) {
        //         this.factors = new ArrayList<>();
        //         this.coeff = coeff;
        //     }
        //     public Item() {
        //         this.factors = new ArrayList<>();
        //         this.coeff = 0;
        //     }
        //     @Override public int compareTo(Item item) {
        //         if (this.factors.size() == item.factors.size()) {
        //             int idx = 0;
        //             while (idx < this.factors.size() && this.factors.get(idx).equals(item.factors.get(idx))) idx ++;
        //             return (idx == factors.size()) ? 0 : this.factors.get(idx).compareTo(item.factors.get(idx));
        //         } else return item.factors.size() - this.factors.size();
        //     }
        //     @Override public String toString() {
        //         StringBuilder s = new StringBuilder();
        //         s.append(coeff);
        //         for (String factor : factors) {
        //             s.append("*").append(factor);
        //         }
        //         return s.toString();
        //     }
        //     public Item mul(Item item) {
        //         Item res = new Item();
        //         res.coeff = this.coeff * item.coeff;
        //         res.factors.addAll(this.factors);
        //         res.factors.addAll(item.factors);
        //         res.factors.sort(String::compareTo);
        //         return res;
        //     }
        // }
        // public class Expr {
        //     private ArrayList<Item> items;
        //     public Expr(Item item) {
        //         this.items = new ArrayList<>();
        //         this.items.add(item);
        //     }
        //     public void add(Expr expr) {
        //         items.addAll(expr.items);
        //         items.sort(Item::compareTo);
        //         clean();
        //     }
        //     public void mul(Expr expr) {
        //         ArrayList<Item> result = new ArrayList<>();
        //         for (Item item1 : items) {
        //             for (Item item2 : expr.items) 
        //                 result.add(item1.mul(item2));
        //         }
        //         items = result;
        //         items.sort(Item::compareTo);
        //         clean();
        //     }
        //     public void clean() {
        //         for (int i = 0; i < items.size(); i++) {
        //             while (i + 1 < items.size() && items.get(i).compareTo(items.get(i + 1)) == 0) {
        //                 items.get(i).coeff += items.get(i + 1).coeff;
        //                 items.remove(i + 1);
        //             }
        //             if (i < items.size() && items.get(i).coeff == 0) {
        //                 items.remove(i--);
        //             }
        //         }
        //     }
        //     public Expr operate(Expr expr, String op) {
        //         switch (op) {
        //         case "+": add(expr); break;
        //         case "-":
        //             for (Item item : expr.items) 
        //                 item.coeff *= -1;
        //             add(expr);
        //             break;
        //         case "*": mul(expr); break;
        //         }
        //         return this;
        //     }
        // }
        // public List<String> basicCalculatorIV(String expr, String[] evalvars, int[] evalints) {
        //     HashMap<String, Integer> map = new HashMap<>();
        //     for (int i = 0; i < evalvars.length; i++) 
        //         map.put(evalvars[i], evalints[i]);
        //     LinkedList<Expr> mainStack = new LinkedList<>();  // number eval(x)-ed val
        //     LinkedList<String> symStack = new LinkedList<>(); // symbol Stack: ( + - * 
        //     int idx = 0;
        //     while (idx < expr.length()) {
        //         if (expr.charAt(idx) == ' ') {
        //             idx ++;
        //         } else if (expr.charAt(idx) >= '0' && expr.charAt(idx) <= '9') { // numbers vals
        //             int x = 0;
        //             while (idx < expr.length() && expr.charAt(idx) >= '0' && expr.charAt(idx) <= '9') 
        //                 x = x * 10 + expr.charAt(idx++) - '0';
        //             mainStack.push(new Expr(new Item(x)));
        //         } else if (expr.charAt(idx) >= 'a' && expr.charAt(idx) <= 'z') { // alphabet
        //             StringBuilder sb = new StringBuilder();
        //             while (idx < expr.length() && expr.charAt(idx) >= 'a' && expr.charAt(idx) <= 'z') 
        //                 sb.append(expr.charAt(idx++));
        //             String factor = sb.toString();
        //             if (map.containsKey(factor)) {
        //                 mainStack.push(new Expr(new Item(map.get(factor))));
        //             } else mainStack.push(new Expr(new Item(sb.toString(), 1)));
        //         } else if (expr.charAt(idx) == '(') {
        //             symStack.push("(");
        //             idx ++;
        //         } else if (expr.charAt(idx) == ')') {
        //             while (!symStack.isEmpty() && !symStack.peek().equals("(")) {
        //                 Expr expr2 = mainStack.pop();
        //                 Expr expr1 = mainStack.pop();
        //                 mainStack.push(expr1.operate(expr2, symStack.pop()));
        //             }
        //             symStack.pop(); // pop out last (  // ) does not go inside symbol stack, nor any stack
        //             idx ++;
        //         } else if (expr.charAt(idx) == '*') { // * ??????
        //             while (!symStack.isEmpty() && symStack.peek().equals("*")) { // a * b * c * c while parsing combining into one expr only
        //                 Expr expr2 = mainStack.pop();
        //                 Expr expr1 = mainStack.pop();
        //                 mainStack.push(expr1.operate(expr2, symStack.pop()));    // into mainStack
        //             }
        //             symStack.push("*");
        //             idx ++;
        //         } else { // 
        //             while (!symStack.isEmpty() && (symStack.peek().equals("+") || symStack.peek().equals("-") || symStack.peek().equals("*"))) {
        //                 Expr expr2 = mainStack.pop();
        //                 Expr expr1 = mainStack.pop();
        //                 mainStack.push(expr1.operate(expr2, symStack.pop()));
        //             }
        //             symStack.push((expr.charAt(idx) == '+') ? "+" : "-");
        //             idx ++;
        //         }
        //     }
        //     while (!symStack.isEmpty()) {
        //         Expr expr2 = mainStack.pop();
        //         Expr expr1 = mainStack.pop();
        //         mainStack.push(expr1.operate(expr2, symStack.pop()));
        //     }
        //     ArrayList<String> result = new ArrayList<>();
        //     Expr exp = mainStack.pop();
        //     exp.clean();
        //     for (Item item : exp.items) {
        //         result.add(item.toString());
        //     }
        //     return result;
        // }

        // boolean res;
        // private void helper(List<int []> l) {
        //     if (l.size() == 1 || res) {
        //         int [] arr = l.get(0);
        //         if (arr[1] != 0 && arr[0] / arr[1] == 24 && arr[0] % arr[1] == 0)
        //             res = true;
        //         return;
        //     }
        //     int res = 0, x = 0, y = 0, a = 0, b = 0;
        //     for (int i = 0; i < l.size()-1; i++) {
        //         x = l.get(i)[0];
        //         y = l.get(i)[1];
        //         for (int j = 0; j < l.size(); j++) {
        //             if (j == i) continue;
        //             a = l.get(j)[0];
        //             b = l.get(j)[1];
        //             List<int []> li = new ArrayList<>();
        //             for (int k = 0; k < l.size(); k++) 
        //                 if (k != i && k != j) li.add(l.get(k));
        //             li.add(new int[] {x*b + a*y, y*b}); // +
        //             helper(li);
        //             li.remove(li.size()-1);
        //             li.add(new int[] {x*b - a*y, y*b}); // -
        //             helper(li);
        //             li.remove(li.size()-1);
        //             li.add(new int[] {x*a, y*b}); // *
        //             helper(li);
        //             li.remove(li.size()-1);
        //             li.add(new int[] {x*b,  a*y}); // /
        //             helper(li);
        //         }
        //     }
        // }
        // public boolean judgePoint24(int[] cards) {
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < cards.length; i++) 
        //         l.add(new int[] {cards[i], 1});
        //     res = false;
        //     helper(l);
        //     return res;
        // }


        // private boolean checkPerfectSquare(double number) {   
        //     double sqrt=Math.sqrt(number);   
        //     return ((sqrt - Math.floor(sqrt)) == 0);   
        // }   
        // private boolean isValid(List<Integer> l) {
        //     for (int i = 1; i < l.size(); i++) 
        //         if (!checkPerfectSquare(l.get(i) + l.get(i-1))) return false;
        //     return true;
        // }
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // private void helper(int [] arr, List<Integer> l) {
        //     if (l.size() > 1 && !isValid(l)) return;
        //     if (l.size() == n) {
        //         if (isValid(l) && !ll.contains(l)) 
        //              ll.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = 0; i < n; i++) {
        //     // ???????????????????????????????????????: ???????????????????????????????????????????????????????????????????????????
        //     //         ???????????????????????????????????????????????????
        //         if (vis[i] || (i > 0 && arr[i] == arr[i-1] && vis[i-1])) continue;
        //         vis[i] = true;
        //         l.add(arr[i]);
        //         helper(arr, l);
        //         l.remove(l.size()-1);
        //         vis[i] = false;
        //     }
        // }
        // public int numSquarefulPerms(int[] nums) {
        //     n = nums.length;
        //     if (n == 1) return 0;
        //     if (nums[0] == 2) {
        //         int i = 0;
        //         while (i < n && nums[i] == 2) ++i;
        //         if (i == n) return 1;
        //     }
        //     if (n == 2) return checkPerfectSquare(nums[0] + nums[1]) ? 1 : 0;
        //     l = new ArrayList<>();
        //     vis = new boolean[n];
        //     helper(nums, l);
        //     return ll.size();
        // }


        // * ????????????
        // *  ???????????????????????????????????????????????????
        // *      ????????????1????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // *      ???????????????????????????????????????????????????????????????????????????
        // *      ????????????2????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // *      ??????????????????????????????????????????
        // *  ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        // *  ???????????????????????????????????????????????????????????????????????????????????????
        // *  ????????????:
        // *      board = "RRWWRRBBRR", hand = "WB"
        //     *  ?????????????????????????????????????????? [W] ?????? [B] ???????????????????????????????????????????????????????????? [RR] ????????????
        //     *  ??????????????? -1. ??????????????????????????????????????????????????????????????????
        //     *      RRWWRRBBRR -> RRWWRRBBR[W]R -> RRWWRRBB[B]RWR -> RRWWRRRWR -> RRWWWR -> RRR -> empty
        //     *  ??????????????????????????????????????????????????????
        //     *
        //     * ???????????????????????????????????????????????????????????????
        //     * ??????...?????????????????????????????????????????????????????????????????????????????????????????????????????????
        //     * ???????????????????????????????????????????????????...
        // private String shrink(String board) { // ???????????? board ?????????????????????????????????
        //     int i = 0, j;
        //     while (i < board.length()) {
        //         j = i+1;
        //         Character color = board.charAt(i);
        //         while (j < board.length() && color == board.charAt(j)) ++j;
        //         if (j - i >= 3) {
        //             board = board.substring(0, i) + board.substring(j);
        //             // ???????????????????????????????????? i ????????? 0 ???????????????????????????????????????????????????????????????
        //             i = 0;
        //         } else i++;
        //     }
        //     return board;
        // }
        // // ????????????????????????board?????????????????????????????????????????????????????????-1
        // private int dfs(String board, Map<Character, Integer> balls) {
        //     if (board == null || board.length() == 0) return 0;
        //     int res = Integer.MAX_VALUE;
        //     int i = 0, j = 0;
        //     while (i < board.length()) {
        //         Character color = board.charAt(i);
        //         j = i+1;
        //         // j??????????????????????????? j ?????? ?????? ???????????????????????? i ?????????
        //         while (j < board.length() && color == board.charAt(j)) j++;
        //         // ??????????????????????????????????????? i ~ j-1 ?????????
        //         int costBalls = 3 - (j - i);
        //         // ???????????????????????????????????????
        //         if (balls.containsKey(color) && balls.get(color) >= costBalls) {
        //             // ?????? i ~ j-1 ????????????????????????????????????????????????????????????????????????????????????
        //             // ?????????????????????????????????????????????????????? shrink() ???????????????
        //             String newBoard = shrink(board.substring(0, i) + board.substring(j));
        //             // ???????????????????????????
        //             balls.put(color, balls.get(color) - costBalls);
        //             // ?????? DFS ????????????????????????????????????????????????????????????????????????
        //             int subRes = dfs(newBoard, balls);
        //             if (subRes >= 0)
        //                 // ????????????????????????????????????????????????????????????
        //                 res = Math.min(res, costBalls + subRes);
        //             // Backtracking ???????????????????????????????????????????????????
        //             balls.put(color, balls.get(color) + costBalls);
        //         }
        //         i = j;
        //     }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }
        // public int findMinStep(String board, String hand) {
        //     if (board == null || board.length() == 0) return 0;
        //     Map<Character, Integer> balls = new HashMap<>();
        //     // ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        //     for (char c : hand.toCharArray()) 
        //         balls.put(c, balls.getOrDefault(c, 0)+1);
        //     return dfs(board, balls);
        // }
        // private String getHashCode(String board, int[] count, char[] array) { // ???????????????????????????
        //     StringBuilder sb = new StringBuilder(board);
        //     for (int i = 0; i < array.length; i++) {
        //         sb.append("_" + array[i] + "_" + count[array[i] - 'A']);
        //     } // ????????????????????????????????????????????? ?????????????????? ??????
        //     return sb.toString();
        // }
        // private boolean isSame(String board) {
        //     int count = 0;
        //     for (int i = 0; i < board.length(); i++) { // ????
        //         if (i != 0 && board.charAt(i) != board.charAt(i - 1))
        //             return false;
        //         count++;
        //     }
        //     return count >= 3;
        // }
        // private boolean noUsableBallsInHand(int[] count) { // ????????? ??????????????????????????????
        //     for (int i = 0; i < count.length; i++) {
        //         if (count[i] != 0)
        //             return false;
        //     }
        //     return true;
        // }
        // public String getStr(String s, int idx, char c) {
        //     int i = idx, j = idx + 1;
        //     int n1 = 0, n2 = 0, n3 = 1;
        //     while (i >= 0 && j < s.length()) {
        //         while (i >= 0 && s.charAt(i) == c) {
        //             n1++;
        //             i--;
        //         }
        //         while (j < s.length() && s.charAt(j) == c) {
        //             n2++;
        //             j++;
        //         }
        //         if (n1 + n2 + n3 >= 3) {
        //             n1 = 0;
        //             n2 = 0;
        //             n3 = 0;
        //             if (i >= 0) {
        //                 c = s.charAt(i);
        //             }
        //         } else break;
        //     }
        //     String s1 = "", s2 = "";
        //     i += n1;
        //     j -= n2;
        //     if (i >= 0) s1 = s.substring(0, i + 1);
        //     if (j < s.length()) s2 = s.substring(j, s.length());
        //     return n3 == 1 ? s1 + c + s2 : s1 + s2;
        // }
        // //????????????????????? ????????? ????????????????????? board count ????????? ??????board???????????? count?????????????????? ??????????????????????????????
        // private int process(String board, int[] count, HashMap<String, Integer> cache) {
        //     String hashCode = getHashCode(board, count, array);
        //     if (cache.containsKey(hashCode))
        //         return cache.get(hashCode);
        //     if (isSame(board))  return 0;
        //     if (board.length() == 0) return 0;
        //     if (noUsableBallsInHand(count)) return Integer.MAX_VALUE;

        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < board.length(); i++) {   // ????????????
        //         for (int j = 0; j < array.length; j++) { // ??????????????????????????? ????????????
        //             int cur = array[j] - 'A';
        //             if (count[cur] > 0) {
        //                 count[cur]--;
        //                 StringBuilder sb = new StringBuilder(board);
        //                 sb.insert(i + 1, array[j]);
        //                 String res = getStr(board, i, array[j]); // ?????????????????? ?????????????????????
        //                 int ans = process(res, count, cache);
        //                 min = Math.min(min, ans != Integer.MAX_VALUE ? ans + 1 : Integer.MAX_VALUE);
        //                 count[cur]++;
        //             }
        //         }
        //     }
        //     cache.put(hashCode, min);
        //     return min;
        // }
        // char[] array = new char[]{'R', 'W', 'B', 'Y', 'G'};
        // public int findMinStep(String board, String hand) {
        //     if (board.length() == 0) return 0;
        //     if (hand.length() == 0) return -1;
        //     int[] count = new int[26];
        //     int all = 0;
        //     for (int i = 0; i < hand.length(); i++) {
        //         count[hand.charAt(i) - 'A']++;
        //         all++;
        //     }
        //     HashMap<String, Integer> cache = new HashMap<>();
        //     int ans = process(board, count, cache);
        //     return ans == Integer.MAX_VALUE ? -1 : ans;
        // }
        // private String getProcess1(String s) {  // ?????????????????????????????????????????????????????????
        //     Stack<Character> stack = new Stack<>();
        //     Stack<Character> temp = new Stack<>();
        //     for (int i = 0; i < s.length(); ) {
        //         temp = new Stack<>();
        //         if (stack.isEmpty() || s.charAt(i) == stack.peek()) {
        //             stack.push(s.charAt(i));
        //             i++;
        //         } else {
        //             char cur = stack.pop();
        //             temp.push(cur);
        //             while (!stack.isEmpty() && cur == stack.peek()) {
        //                 temp.push(stack.pop());
        //             }
        //             if (temp.size() < 3) {
        //                 while (!temp.isEmpty())
        //                     stack.push(temp.pop());
        //                 stack.push(s.charAt(i));
        //                 i++;
        //             }
        //         }
        //     }
        //     temp = new Stack<>();
        //     if (!stack.isEmpty()) {
        //         char cur = stack.pop();
        //         temp.push(cur);
        //         while (!stack.isEmpty() && cur == stack.peek()) {
        //             temp.push(stack.pop());
        //         }
        //         if (temp.size() < 3) {
        //             while (!temp.isEmpty())
        //                 stack.push(temp.pop());
        //         }
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     while (!stack.isEmpty()) {
        //         sb.append(stack.pop());
        //     }
        //     return sb.reverse().toString();
        // }
        // private String getProcess(String s) {
        //     int count = 0;
        //     int i = 0;
        //     boolean flag = false;
        //     for (i = 0; i <= s.length() - 1; i++) {
        //         if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
        //             count++;
        //         } else if (count >= 3) {
        //             flag = true;
        //             break;
        //         } else count = 1;
        //     }
        //     flag = flag || (count >= 3);
        //     if (!flag) return s;
        //     StringBuilder sb = new StringBuilder();
        //     for (int j = 0; j < s.length(); j++) {
        //         if (j >= i || j < i - count)
        //             sb.append(s.charAt(j));
        //     }
        //     String ans = sb.toString();
        //     return getProcess(ans);
        // }


    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {12, 13, 14, 17, 25};

        int res = s.minimumTimeRequired(a, 3);
        System.out.println("res: " + res);
    }
}
