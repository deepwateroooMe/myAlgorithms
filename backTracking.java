// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class backTracking {
    public static class Solution {

        // List<List<Integer>> res = new ArrayList<List<Integer>>();
        // int n;
        // public void helper(int [] arr, boolean [] used, List<Integer> l) {
        //     if (l.size() == arr.length) {
        //         res.add(new ArrayList<Integer>(l));
        //         return;
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (!used[i]) {
        //             used[i] = true;
        //             l.add(arr[i]);
        //             helper(arr, used, l);
        //             l.remove(l.size() - 1);
        //             used[i] = false;
        //         }
        //     }
        // }
        // public List<List<Integer>> permute(int[] num) {
        //     if (num == null || num.length == 0) return res;
        //     int n = num.length;
        //     boolean [] used = new boolean[n];
        //     helper(num, used, new ArrayList<Integer>());
        //     return res;
        // }

        // List<String> l = new ArrayList<>();
        // private void helper(char [] arr, boolean [] vis, StringBuilder s, int val) {
        //     if (s.length() == val) {
        //         if (!l.contains(s.toString()))
        //             l.add(s.toString());
        //         return;
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             s.append(arr[i]);
        //             helper(arr, vis, s, val);
        //             s.deleteCharAt(s.length()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int numTilePossibilities(String tiles) {
        //     int val = 0;
        //     int n = tiles.length();
        //     char [] arr = tiles.toCharArray();
        //     boolean [] vis = new boolean[n];
        //     StringBuilder s;
        //     for (int i = 1; i <= tiles.length(); i++) {
        //         Arrays.fill(vis, false);
        //         s = new StringBuilder();
        //         helper(arr, vis, s, i);
        //     }
        //     return l.size();
        // }        

        // List<List<Integer>> ll = new ArrayList<>();
        // private void helper(int [] arr, boolean [] vis, List<Integer> l) {
        //     if (l.size() == arr.length) {
        //         if (!ll.contains(l)) // consider repeats
        //             ll.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             helper(arr, vis, l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public List<List<Integer>> permuteUnique(int[] nums) {
        //     boolean [] vis = new boolean[nums.length];
        //     List<Integer> l = new ArrayList<>();
        //     helper(nums, vis, l);
        //     return ll;
        // }

        
        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> lo = new ArrayList<>();
        // boolean [] vis;
        // int t;
        // private boolean diffByOneDigit(int x, int y) { // x > y
        //     if (x < y) return diffByOneDigit(y, x);
        //     String s = Integer.toBinaryString(x);
        //     String t = Integer.toBinaryString(y);
        //     if (t.length() < s.length()) {
        //         StringBuilder tmp = new StringBuilder(t);
        //         while (tmp.length() < s.length()) tmp.insert(0, '0');
        //         t = tmp.toString();
        //     }
        //     int cnt = 0;
        //     for (int i = s.length()-1; i >= 0; i--) {
        //         if (s.charAt(i) != t.charAt(i)) {
        //             ++cnt;
        //             if (cnt >= 2) return false;
        //         }
        //     }
        //     return true;
        // }
        // private void helper(int t, List<Integer> l, int val) {
        //     if (ll.size() == 1) return;
        //     if (l.size() == t && diffByOneDigit(l.get(l.size()-1), l.get(0)) && l.get(0) == val) {
        //         ll.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = 0; i < t && i >= 0; i++) {
        //         if (!vis[lo.get(i)] && (l.size() == 0 || diffByOneDigit(l.get(l.size()-1), lo.get(i)))) {
        //             vis[lo.get(i)] = true;
        //             l.add(lo.get(i));
        //             helper(t, l, val);
        //             l.remove(l.size()-1);
        //             vis[lo.get(i)] = false;
        //         }
        //     }
        // }
        // public List<Integer> circularPermutation(int n, int start) {
        //     t = (int)Math.pow(2, n);
        //     vis = new boolean [t];
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = start; i < t; i++) 
        //         lo.add(i);
        //     for (int i = 0; i < start; i++) 
        //         lo.add(i);
        //     helper(t, l, start);
        //     return ll.get(0);
        // }


        // List<Character> arr = new ArrayList<>();
        // List<String> l = new ArrayList<>();
        // private void helper(StringBuilder s, int n) {
        //     if (s.length() == n) {
        //         l.add(s.toString());
        //         return;
        //     }
        //     for (int i = 0; i < arr.size(); i++) {
        //         if (s.length() == 0 || arr.get(i) != s.charAt(s.length()-1)) {
        //             s.append(arr.get(i));
        //             helper(s, n);
        //             s.deleteCharAt(s.length()-1);
        //         }
        //     }
        // }
        // public String getHappyString(int n, int k) {
        //     StringBuilder s = new StringBuilder();
        //     arr.add('a');
        //     arr.add('b');
        //     arr.add('c');
        //     helper(s, n);
        //     Collections.sort(l);
        //     return k <= l.size() ? l.get(k-1) : "";
        // }


        // int max = Integer.MIN_VALUE;
        // boolean [][] vis;
        // int m, n;
        // private void helper(int [][] arr, int i, int j, int val) {
        //     if (i > 0 && arr[i-1][j] > 0 && !vis[i-1][j]) {
        //         vis[i-1][j] = true;
        //         helper(arr, i-1, j, val + arr[i][j]);
        //         vis[i-1][j] = false;
        //     }
        //     if (i < m-1 && arr[i+1][j] > 0 && !vis[i+1][j]) {
        //         vis[i+1][j] = true;
        //         helper(arr, i+1, j, val + arr[i][j]);
        //         vis[i+1][j] = false;
        //     }
        //     if (j > 0 && arr[i][j-1] > 0 && !vis[i][j-1]) {
        //         vis[i][j-1] = true;
        //         helper(arr, i, j-1, val + arr[i][j]);
        //         vis[i][j-1] = false;
        //     }
        //     if (j < n-1 && arr[i][j+1] > 0 && !vis[i][j+1]) {
        //         vis[i][j+1] = true;
        //         helper(arr, i, j+1, val + arr[i][j]);
        //         vis[i][j+1] = false;
        //     }
        //     if (val + arr[i][j] > max) max = val + arr[i][j];
        // }
        // public int getMaximumGold(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     vis = new boolean[m][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (grid[i][j] > 0) {
        //                 vis[i][j] = true;
        //                 helper(grid, i, j, 0);
        //                 vis[i][j] = false;
        //             }
        //         }
        //     }
        //     return max;
        // }

        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l;
        // boolean [] vis;
        // private void helper(int n, List<Integer> l) {
        //     if (l.size() == n+1) {
        //         ll.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = 1; i <= n; i++) {
        //         if (!vis[i] && ((i >= l.size() && i % l.size() == 0
        //                          || (i < l.size() && l.size() % i == 0))))  {
        //             vis[i] = true;
        //             l.add(i);
        //             helper(n, l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int countArrangement(int n) {
        //     if (n == 1) return 1;
        //     vis = new boolean[n+1];
        //     l = new ArrayList<>();
        //     l.add(0);
        //     helper(n, l);
        //     return ll.size();
        // }

        // List<List<Integer>> ll = new ArrayList<>();
        // int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // List<Integer> l = new ArrayList<>();
        // boolean [] vis;
        // private void helper(int n, int t, List<Integer> l, int val) {
        //     if (l.size() == n && val == t) {
        //         List<Integer> tmp = new ArrayList<>(l);
        //         Collections.sort(tmp);
        //         if (!ll.contains(tmp)) 
        //             ll.add(tmp);
        //         return;
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (l.size() < n && val < t && !vis[i]) {
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             helper(n, t, l, val + arr[i]);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }        
        // public List<List<Integer>> combinationSum3(int k, int n) {
        //     vis = new boolean[arr.length];
        //     helper(k, n, l, 0);
        //     return ll;
        // }

        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // boolean [] vis;
        // int max = Integer.MIN_VALUE;
        // int m, n;
        // private void helperPermutationM(int n, List<Integer> l) {
        //     if (l.size() == n) {
        //         ll.add(new ArrayList<>(l));
        //         return;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(i);
        //             helperPermutationM(n, l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        //     m = students.length;
        //     n = students[0].length;
        //     l = new ArrayList<>();
        //     vis = new boolean[m];
        //     helperPermutationM(m, l);
        //     int sum = 0;
        //     for (int i = 0; i < ll.size(); i++) {
        //         sum = 0;
        //         for (int j = 0; j < m; j++) {
        //             for (int k = 0; k < n; k++) {
        //                 sum += students[j][k] == mentors[ll.get(i).get(j)][k] ? 1 : 0;
        //             }
        //         }
        //         if (sum > max) max = sum;
        //     }
        //     return max;
        // }

        // int min = Integer.MAX_VALUE;
        // private boolean considerable(List<Integer> nee, List<Integer> off) {
        //     for (int i = 0; i < nee.size(); i++) 
        //         if (nee.get(i) < off.get(i)) return false;
        //     return true;
        // }
        // private void helper(List<List<Integer>> ll, List<Integer> li, int val, List<Integer> price) {
        //     for (int i = 0; i < ll.size(); i++) {
        //         // System.out.println("i: " + i);
        //         // System.out.println("(considerable(li, ll.get(i))): " + (considerable(li, ll.get(i))));
        //         if (considerable(li, ll.get(i))) {
        //             List<Integer> l = new ArrayList<>(li);
        //             int cnt = 0;
        //             for (int j = 0; j < l.size(); j++) {
        //                 l.set(j, l.get(j)-ll.get(i).get(j));
        //                 if (l.get(j) == 0) ++cnt;
        //             }
        //             // System.out.println("l.size(): " + l.size());
        //             // for (int z = 0; z < l.size(); ++z) 
        //             //     System.out.print(l.get(z) + ", ");
        //             // System.out.print("\n");
        //             if (cnt == l.size()) {
        //                 if (val + ll.get(i).get(ll.get(i).size()-1) < min)
        //                     min = val + ll.get(i).get(ll.get(i).size()-1);
        //                 return;
        //             }
        //             helper(ll, l, val + ll.get(i).get(ll.get(i).size()-1), price);
        //         }
        //     }
        //     for (int i = 0; i < li.size(); i++) 
        //         val += li.get(i)* price.get(i);
        //     if (val < min) min = val;
        // }
        // public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //     int cnt = 0;
        //     for (int i = 0; i < price.size(); i++) 
        //         if (price.get(i) == 0) ++cnt;
        //     if (cnt == price.size()) return 0;
        //     int n = price.size();
        //     int m = special.size();
        //     helper(special, needs, 0, price);
        //     return min;
        // }
        // int []  a = new int []  {9};
        // int [][] b = new int [][] {{1,10},{2,2}}; 
        // int []  c = new int []  {3}; 

        // List<List<String>> ll = new ArrayList<>();
        // List<String> l = new ArrayList<>();
        // HashSet<String> ss = new HashSet<>();
        // boolean [] vis;
        // private void helper(String s, List<String> l, int idx, HashSet<String> ss) {
        //     System.out.println("idx: " + idx);
            
        //     if (idx == s.length()-1) {
        //         if (!ss.contains(s.substring(idx))) {
        //             l.add(s.substring(idx));
        //             if (!ll.contains(l))
        //                 ll.add(new ArrayList<>(l));
        //             return;
        //         }
        //     }
        //     for (int i = idx; i < s.length()-1; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             for (int j = idx+1; j < s.length(); j++) {
        //                 // System.out.println("i: " + i);
        //                 // System.out.println("j: " + j);
        //                 // if (!vis[j]) {
        //                 //     vis[j] = true;
        //                 if (j < i) break;
        //                 if (!ss.contains(s.substring(i, j))) {
        //                     l.add(s.substring(i, j));
        //                     ss.add(s.substring(i, j));
        //                     helper(s, l, j, ss);
        //                     ss.remove(s.substring(i, j));
        //                     l.remove(l.size()-1);
        //                 }
        //                 // vis[j] = false;
        //             }
        //         }
        //         vis[i] = false;
        //     }
        // }
        // public int maxUniqueSplit(String s) {
        //     int n = s.length();
        //     if (n == 1 || (n == 2 && s.charAt(0) == s.charAt(1))) return 1;
        //     l = new ArrayList<>();
        //     ss = new HashSet<>();
        //     vis = new boolean[n];
        //     helper(s, l, 0, ss);
        //     System.out.println("ll.size(): " + ll.size());
        //     for (int z = 0; z < ll.size(); ++z) {
        //         for (int q = 0; q < ll.get(z).size(); q++) 
        //             System.out.print(ll.get(z).get(q) + ", ");
        //         System.out.print("\n ");
        //     }
        //     return ll.size();
        // }

        
        // public int countNumbersWithUniqueDigits(int n) {
        //     if (n == 0) return 1;
        //     if (n == 1) return 10;
        //     int res = 9;
        //     int [] arr = new int[n+1];
        //     arr[0] = 1;
        //     arr[1] = 10;
        //     for (int i = 2; i <= n; i++) {
        //         res *= 9 - (i-1) + 1;
        //         arr[i] = arr[i-1] + res;
        //     }
        //     return arr[n];
        // }



        // List<Integer> l = new ArrayList<>();
        // char [] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        // boolean [] vis;
        // private void helper(int n, int k, StringBuilder s) {
        //     if (s.length() == n) {
        //         int tmp = Integer.parseInt(new StringBuilder(s).toString());
        //         if (!l.contains(tmp)) {
        //             l.add(tmp);
        //             s = new StringBuilder();
        //             return;
        //         }
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (s.length() == 0 && i == 0) continue;
        //         if (s.length() > 0 && k == 0 && s.length() < n) {
        //             int t = s.length();
        //             while (s.length() < n)
        //                 s.append(s.charAt(0));
        //             int tmp = Integer.parseInt(new StringBuilder(s).toString());
        //             if (!l.contains(tmp) && (n == 1 || tmp != 0)) {
        //                 l.add(tmp);
        //             }
        //             while (s.length() > t) s.deleteCharAt(s.length()-1);
        //             return;
        //         } else if (s.length() > 0 && k > 0 && (Math.abs(arr[i] - s.charAt(s.length()-1)) != k)) continue;
        //         s.append(arr[i]);
        //         helper(n, k, s);
        //         s.deleteCharAt(s.length()-1);
        //     }
        // }
        // public int[] numsSameConsecDiff(int n, int k) {
        //     StringBuilder s = new StringBuilder();
        //     vis = new boolean[arr.length];
        //     helper(n, k, s);
        //     return l.stream().mapToInt(i->i).toArray();
        // }        
        

        // List<List<Integer>> ll = new ArrayList<>();
        // List<Integer> l = new ArrayList<>();
        // boolean [][] vis;
        // int m, n;
        // private void helper(int [][] arr, int i, int j, List<Integer> l, int t) {
        //     if (arr[i][j] == 2) {
        //         if (l.size() == t && !ll.contains(l)) {
        //             ll.add(new ArrayList<>(l));
        //             return;
        //         }
        //     }
        //     if (i > 0 && !vis[i-1][j] && arr[i-1][j] != -1) {
        //         vis[i-1][j] = true;
        //         l.add((i-1)*n+j);
        //         helper(arr, i-1, j, l, t);
        //         l.remove(l.size()-1);
        //         vis[i-1][j] = false;
        //     }
        //     if (i < m-1 && !vis[i+1][j] && arr[i+1][j] != -1) {
        //         vis[i+1][j] = true;
        //         l.add((i+1)*n+j);
        //         helper(arr, i+1, j, l, t);
        //         l.remove(l.size()-1);
        //         vis[i+1][j] = false;
        //     }
        //     if (j > 0 && !vis[i][j-1] && arr[i][j-1] != -1) {
        //         vis[i][j-1] = true;
        //         l.add(i*n+j-1);
        //         helper(arr, i, j-1, l, t);
        //         l.remove(l.size()-1);
        //         vis[i][j-1] = false;
        //     }            
        //     if (j < n-1 && !vis[i][j+1] && arr[i][j+1] != -1) {
        //         vis[i][j+1] = true;
        //         l.add(i*n+j+1);
        //         helper(arr, i, j+1, l, t);
        //         l.remove(l.size()-1);
        //         vis[i][j+1] = false;
        //     }            
        // }        
        // public int uniquePathsIII(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     vis = new boolean[m][n];
        //     int cnt = 0;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i][j] == -1) ++cnt;
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i][j] == 1) {
        //                 l = new ArrayList<>();
        //                 l.add(i*n+j);
        //                 vis[i][j] = true;
        //                 helper(grid, i, j, l, m*n-cnt);
        //                 break;
        //             } 
        //     return ll.size();
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
        //     int n = s.length();
        //     char [] arr = s.toCharArray();
        //     StringBuilder one = new StringBuilder();
        //     for (int i = 0; i < (1 << n); i++) {
        //         one = new StringBuilder();
        //         for (int j = 0; j < n; j++) {
        //             if (arr[j] > '9') {
        //                 if ((i >> j & 1) == 1)
        //                     one.append(Character.toLowerCase(arr[j]));
        //                 else
        //                     one.append(Character.toUpperCase(arr[j]));
        //             } else
        //                 one.append(arr[j]);
        //         }
        //         if (!res.contains(one.toString())) // ???
        //             res.add(one.toString());
        //     }
        //     return res;
        // }

        
        // List<String> ll = new ArrayList<>();
        // boolean [] vis;
        // int max = Integer.MIN_VALUE;
        // int n;
        // private boolean allUnique(String s, String t) {
        //     Set<Character> ss = s.chars()
        //         .mapToObj(e->(char)e).collect(Collectors.toSet());
        //     for (int i = 0; i < t.length(); i++) {
        //         if (ss.contains(t.charAt(i))) return false;
        //         ss.add(t.charAt(i));
        //     }
        //     return true;
        // }
        // private void helper(List<String> ls, StringBuilder s, int val) {
        //     if (val >= 1) {
        //         if (s.length() > max) max = s.length();
        //         ll.add(s.toString());
        //     }
        //     for (int i = 0; i < ls.size(); i++) {
        //         if (!vis[i] && allUnique(ls.get(i), s.toString())) {
        //             vis[i] = true;
        //             StringBuilder t = new StringBuilder(s);
        //             for (int j = 0; j < ls.get(i).length(); j++) 
        //                 t.append(ls.get(i).charAt(j));
        //             helper(ls, t, val+1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int maxLength(List<String> arr) {
        //     n = arr.size();
        //     HashSet<Character> tmp = new HashSet<>();
        //     int j = 0;
        //     Set<String> ss = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         tmp.clear();
        //         j = 0;
        //         for ( j = 0; j < arr.get(i).length(); j++) {
        //             if (!tmp.contains(arr.get(i).charAt(j))) tmp.add(arr.get(i).charAt(j));
        //             else break;
        //         }
        //         if (j < arr.get(i).length()) continue;
        //         ss.add(arr.get(i));
        //     }
        //     if (ss.size() == 0) return 0;
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     int cnt = 0;
        //     for (String va : ss) 
        //         for (int i = 0; i < va.length(); i++) {
        //             m.put(va.charAt(i), m.getOrDefault(va.charAt(i), 0) + 1);
        //             ++cnt;
        //         }
        //     if (m.size() == ss.size() && n == m.size()) return n;
        //     StringBuilder s = new StringBuilder();
        //     vis = new boolean[ss.size()];
        //     List<String> ls = new ArrayList<>();
        //     ls.addAll(ss);
        //     helper(ls, s, 0);
        //     return max;
        // }

        
        // private class Pt {
        //     char i;
        //     char v;
        //     public Pt(char a, char b) {
        //         i = a;
        //         v = b;
        //     }
        // }
        // char [] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        // List<List<Pt>> ll = new ArrayList<>();
        // char [][] arr;
        // int m, n, cnt;
        // boolean res = false;
        // boolean [] vis;
        // private char getMappedChar(List<Pt> l, char val) {
        //     for (int k = 0; k < l.size(); k++) {
        //         if (l.get(k).i == val)
        //             return l.get(k).v;
        //     }
        //     return '0';
        // }
        // List<Integer> lsize; // 3 5 6 8 
        // private boolean isValid(List<Pt> l) {
        //     int res = 0;
        //     int idx = 0;
        //     for (int i = 0; i < lsize.size(); i++) {
        //         if (lsize.get(i) == l.size()) {
        //             idx = i;
        //             break;
        //         }                    
        //     }
        //     if (l.size() == lc.size()) idx = n-1;
        //     StringBuilder [] sb = new StringBuilder [m+1];
        //     for (int i = 0; i < m+1; i++) {
        //         sb[i] = new StringBuilder();
        //         for (int j = n - idx-1; j < n; j++) 
        //             sb[i].append(getMappedChar(l, arr[i][j]));
        //         if (i < m)
        //             res += Integer.parseInt(sb[i].toString());
        //     }
        //     if (l.size() == lc.size()) 
        //         return res == Integer.parseInt(sb[m].toString());
        //     else 
        //         return (int)(res % Math.pow(10, idx+1)) == Integer.parseInt(sb[m].toString());
        // }
        // List<Pt> l = new ArrayList<>();
        // List<Character> lc;
        // private void helper(List<Character> lc, List<Pt> lp) {
        //     if (lsize.contains(lp.size())) {
        //         if (!isValid(lp)) return;
        //         if (lp.size() == lc.size()) {
        //             ll.add(new ArrayList<>(lp));
        //             res = true;
        //             return;
        //         }
        //     }
        //     for (int i = 0; i < digits.length; i++) {
        //         if (!vis[i]) {
        //             if (digits[i] == '0' && fstChar.contains(lc.get(lp.size()))) continue;
        //             vis[i] = true;
        //             lp.add(new Pt(lc.get(lp.size()), digits[i]));
        //             helper(lc, lp);
        //             lp.remove(lp.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // HashSet<Character> fstChar = new HashSet<>();
        // public boolean isSolvable(String[] words, String result) {
        //     m = words.length;
        //     n = words[0].length();
        //     for (int i = 0; i < m; i++) {
        //         n = Math.max(n, words[i].length());
        //         if (words[i].length() > 1)
        //             fstChar.add(words[i].charAt(0));
        //     }
        //     n = Math.max(n, result.length());
        //     if (result.length() > 1)
        //         fstChar.add(result.charAt(0));
        //     String [] wdss = new String [m+1];
        //     System.arraycopy(words, 0, wdss, 0, words.length);
        //     wdss[m] = result;
        //     HashSet<Character> s = new HashSet<>();
        //     for (int i = 0; i < m+1; i++) 
        //         for (int j = 0; j < wdss[i].length(); j++) 
        //             s.add(wdss[i].charAt(j));
        //     cnt = s.size();
        //     arr = new char[m+1][n];
        //     for (int i = 0; i <= m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (j < n - wdss[i].length()) {
        //                 arr[i][j] = '0';
        //             } else {
        //                 arr[i][j] = wdss[i].charAt(j-n+wdss[i].length());
        //             }
        //     lsize = new ArrayList<>();
        //     HashSet<Character> tmp = new HashSet<>();
        //     for (int j = n-1; j >= 0; j--) {
        //         for (int i = 0; i < m+1; i++) {
        //             if (arr[i][j] != '0')
        //                 tmp.add(arr[i][j]);
        //         }
        //         lsize.add(tmp.size());
        //     }
        //     vis = new boolean[digits.length];
        //     List<Pt> t = new ArrayList<>();
        //     lc = new ArrayList<>();
        //     for (int j = n-1; j >= 0; j--) {
        //         for (int i = 0; i < m+1; i++)
        //             if (!lc.contains(arr[i][j]) && arr[i][j] != '0')
        //                 lc.add(arr[i][j]);
        //     }
        //     helper(lc, t);
        //     return res;
        // }



        // HashSet<List<Integer>> ss = new HashSet<>();
        // List<Integer> l = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // private void helper(int t, int [] arr, List<Integer> l) {
        //     if (l.size() == t) {
        //         if (!ss.contains(l)) {
        //             ss.add(new ArrayList<>(l));
        //             return;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && arr[i] < arr[i-1] && l.size() >= 1 && arr[i] < l.get(l.size()-1)) continue;
        //         if (l.size() >= 1 && arr[i] < l.get(l.size()-1)) {
        //             if (l.size() >= 2 && !ss.contains(l)) 
        //                 ss.add(new ArrayList<>(l));
        //             continue;
        //         }
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             helper(t, arr, l);
        //             l.remove(l.size()-1);
        //             if (!decreasing)
        //             vis[i] = false;
        //         }
        //     }
        // }
        // boolean decreasing = false;
        // public List<List<Integer>> findSubsequences(int[] nums) {
        //     n = nums.length;
        //     l = new ArrayList<>();
        //     vis = new boolean[n];
        //     decreasing = false;
        //     int i = 0;
        //     for ( i = 1; i < n; i++) {
        //         if (nums[i] <= nums[i-1]) continue;
        //         break;
        //     }
        //     if (i == n) decreasing = true;
        //     for ( i = 2; i <= n; i++) {
        //         Arrays.fill(vis, false);
        //         helper(i, nums, l);
        //     }
        //     return new ArrayList<List<Integer>>(ss);
        // }


        // List<Integer> l = new ArrayList<>();
        // boolean [] vis;
        // private boolean helper(int [] arr, int t, List<Integer> l, int val) {
        //     if (val % t == 0 && val / t == 4) {
        //         return true;
        //     }
        //     for (int i = 0; i < arr.length; i++) {
        //         if (!vis[i] && val % t + arr[i] <= t) {
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             if (helper(arr, t, l, val + arr[i])) return true;
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        //     return false;
        // }
        // public boolean makesquare(int[] matchsticks) {
        //     int n = matchsticks.length;
        //     int sum = 0, max = 0, min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         sum += matchsticks[i];
        //         max = Math.max(max, matchsticks[i]);
        //         min = Math.min(min, matchsticks[i]);
        //     }
        //     if (sum % 4 != 0 || max > sum / 4 || (max < sum / 4 && max + min > sum / 4)) return false;
        //     int target = sum / 4;
        //     vis = new boolean[n];
        //     l = new ArrayList<>();
        //     // int [] arr = IntStream.rangeClosed(1, matchsticks.length).map(i -> matchsticks[matchsticks.length-i]).toArray();
        //     return helper(matchsticks, target, l, 0);
        // }

        // private boolean canPartitionKSubsetsRecursive(int [] ori, int sum, int k, List<Set<Integer>> ls, Set<Integer> s, int val) {
        //     if (ls.size() == k-1) // 当找到前面k-1个都成立，那么最后一个一定成立
        //         return true;
        //     for (int i = 0; i < ori.length; i++) {
        //         if (s.contains(i)) continue;
        //         boolean contains = false;
        //         for (Set<Integer> si : ls) {
        //             if (si.contains(i)){
        //                 contains = true;
        //                 break;
        //             }
        //         }
        //         if (contains) {
        //             contains = false;
        //             continue;
        //         }
        //         if (val + ori[i] <= sum) {
        //             HashSet<Integer> tmp = new HashSet<>(s);
        //             tmp.add(i);
        //             List<Set<Integer>> tpl = new ArrayList<>(ls);
        //             if (val + ori[i] == sum) {
        //                 tpl.add(new HashSet<>(tmp));
        //                 tmp.clear();
        //             }
        //             if (canPartitionKSubsetsRecursive(ori, sum, k, tpl, tmp, (val+ori[i]) % sum)) return true;
        //         }
        //     }
        //     return false;
        // }
        // public boolean canPartitionKSubsets(int[] arr, int k) {
        //     int n = arr.length;
        //     int sum = 0;
        //     int max = 0, min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         sum += arr[i];
        //         max = Math.max(max, arr[i]);
        //         min = Math.min(min, arr[i]);
        //     }
        //     if (sum % k != 0 || max > sum / k || (max < sum / k && max + min > sum / k)) return false;
        //     Arrays.sort(arr); // 降序
        //     int [] sorted = IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
        //     int target = sum / k;
        //     List<Set<Integer>> ls = new ArrayList<>();
        //     Set<Integer> s = new HashSet<>();
        //     return canPartitionKSubsetsRecursive(sorted, target, k, new ArrayList<Set<Integer>>(), s, 0);
        // }
        // private boolean dfs(int [] arr, int k, int t, int sum, int idx) {
        //     if (k == 1) return true;
        //     if (sum == t) return dfs(arr, k-1, t, 0, 0);
        //     for (int i = idx; i < arr.length; i++) {
        //         if (!vis[i]) {
        //             if (sum + arr[i] <= t) {
        //                 vis[i] = true;
        //                 if (dfs(arr, k, t, sum+arr[i], i+1)) return true;
        //                 vis[i] = false;
        //             }
        //         }
        //     }
        //     return false;
        // }
        // boolean [] vis;
        // public boolean canPartitionKSubsets(int[] arr, int k) {
        //     int n = arr.length;
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum += arr[i];
        //     if (sum % k != 0) return false;
        //     vis = new boolean[n];
        //     return dfs(arr, k, sum / k, 0, 0);
        // }
        // 将k次排列组合法整合成一次，途径是开一个k大小数组，每一个数肯定属于其中一个。
        // visited数组替换成ksum数组和idx控制遍历数组顺序。某一个数肯定是属于ksum数组的任一个，
        // 所有可能性都考虑到，可以求得解。
        // 先对原数组排序，贪心算法可以帮助剪枝，提高算法效率但若不排序的话会得到LTE
        // private boolean dfs(int [] arr, int k, int t, int [] ksum, int idx) {
        //     if (idx == -1) {
        //         for (int v : ksum) // 这个数组纪录K个片各片的和
        //             if (v != t) return false;
        //         return true;
        //     }
        //     for (int i = 0; i < k; i++) {
        //         if (ksum[i] + arr[idx] <= t) {
        //             ksum[i] += arr[idx];
        //             if (dfs(arr, k, t, ksum, idx-1)) return true;
        //             ksum[i] -= arr[idx];
        //         }
        //     }
        //     return false;
        // }
        // public boolean canPartitionKSubsets(int[] arr, int k) {
        //     int n = arr.length;
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum += arr[i];
        //     if (sum % k != 0) return false;
        //     Arrays.sort(arr);
        //     int [] ksum = new int[k];
        //     return dfs(arr, k, sum / k, ksum, arr.length-1);
        // }
        

        // private int getCosts(int [] arr) {
        //     res = 0;
        //     for (Map.Entry<Character, Integer> entry : mm.entrySet()) 
        //         res += arr[entry.getKey()-'a'] * entry.getValue();
        //     return res;
        // }
        // private boolean isValid(List<String> l) {
        //     mm.clear();
        //     for (int i = 0; i < l.size(); i++)
        //         for (int j = 0; j < l.get(i).length(); j++) 
        //             mm.put(l.get(i).charAt(j), mm.getOrDefault(l.get(i).charAt(j), 0) + 1);
        //     for (Map.Entry<Character, Integer> entry : mm.entrySet()) {
        //         if (!map.containsKey(entry.getKey())
        //             || map.get(entry.getKey()) < entry.getValue()) return false;
        //     }
        //     return true;
        // }
        // private int getVal(int [] arr, String s) {
        //     int res = 0;
        //     for (int i = 0; i < s.length(); i++) 
        //         res += arr[s.charAt(i)-'a'];
        //     return res;
        // }
        // private void helperGetPermutations(String [] arr, List<String> l, int idx, int val, int [] cost) {
        //     if (l.size() == arr.length) return;
        //     int tmp = 0;
        //     for (int i = idx; i < m; i++) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(arr[i]);
        //             if (isValid(l)) {
        //                 tmp = getVal(cost, arr[i]);
        //                 if (val + tmp > max) max = val + tmp;
        //                 helperGetPermutations(arr, l, i+1, val+tmp, cost);
        //             }
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // HashMap<Character, Integer> map = new HashMap<>(); // allowed character frequency
        // HashMap<Character, Integer> mm = new HashMap<>();
        // int m, res, max = Integer.MIN_VALUE;
        // List<String> l = new ArrayList<>();
        // boolean [] vis;
        // public int maxScoreWords(String[] words, char[] letters, int[] score) {
        //     for (int i = 0; i < letters.length; i++) 
        //         map.put(letters[i], map.getOrDefault(letters[i], 0) + 1);
        //     m = words.length;
        //     HashSet<Integer> s = new HashSet<>();
        //     for (int i = 0; i < m; i++) {
        //         l.clear();
        //         l.add(words[i]);
        //         if (!isValid(l)) s.add(i);
        //     }
        //     vis = new boolean[m];
        //     if (s.size() == 0) {
        //         helperGetPermutations(words, new ArrayList<String>(), 0, 0, score);
        //         return max == Integer.MIN_VALUE ? 0 : max;
        //     }
        //     String [] arr = new String [m - s.size()];
        //     if (s.size() > 0) {
        //         int idx = 0;
        //         for (int i = 0; i < m; i++) {
        //             if (s.contains(i)) continue;
        //             arr[idx++] = words[i];
        //         }
        //         m = m - s.size();
        //     }
        //     l = Arrays.stream(s.size() == 0 ? words : arr).collect(Collectors.toList());
        //     if (isValid(l)){
        //         max = getCosts(score);
        //         return max;
        //     } 
        //     helperGetPermutations(arr, new ArrayList<String>(), 0, 0, score);
        //     return max == Integer.MIN_VALUE ? 0 : max;
        // }


    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2};
        int []  b = new int []  {4, 3, 4, 3, 3};

boolean res = s.canDistribute(a, b);
        System.out.println("res: " + res);
    }
}