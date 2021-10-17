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
        // } // 自己写的，很笨啊
        
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
        //     if (index == num.length()) return true; // 如果只有两个数是有效的！！！
        //     long sum = Long.parseLong(first) + Long.parseLong(second);
        //     if (num.startsWith(sum + "", index))    // 间接检测第三个数
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
        //     int range = 1 << n;    //二进制状态压缩
        //     int [] dp = new int [range];
        //     for (int i = 0; i < range; i++) {
        //         int cnt = count(i); //计算二进制中1的个数
        //         if ((cnt & 1) == 1) //选取了奇数个数，不符合条件，直接跳过
        //             continue;
        //         for (int j = 0; j < n; j++) {
        //             for (int k = j+1; k < n; k++) {
        //                 int state = (1 << j) | (1 << k);
        //                 if ((state & i) != state) //这2个数不全在当前状态选择范围内，跳过
        //                     continue;
        //                 dp[i] = Math.max(dp[i], dp[i-state] + getgcd(nums[j], nums[k]) * (cnt >> 1));
        //             }
        //         }
        //     }
        //     return dp[range-1];
        // }

        
//         List<String> ls = new ArrayList<>();
//         int cnt;
//         int n;
//         private void helper(int [] arr, int k, int va, int idx, String s, int cn) {
//             if (idx == n && cn == n) {
//                 if (va == k && !ls.contains(s)) {
//                     ++cnt;
//                     ls.add(new String(s));
//                 }
//                 return;
//             }
//             for (int i = idx; i < n; i++) {
//                 helper(arr, k, va+arr[i], i+1, s+"+"+arr[i], cn+1);
//                 helper(arr, k, va-arr[i], i+1, s+"-"+arr[i], cn+1);
//             }
//         }
//         public int findTargetSumWays(int[] nums, int target) {
//             n = nums.length;
//             cnt = 0;
//             helper(nums, target, 0, 0, "", 0);
//             return cnt;
//         }
//         直接递归复杂度太高了， 会有很多重复的子问题， 所以可以用一个map来做记忆化递归, 也就是动态规划的top down模式
//         private int helper(int [] arr, int k, int idx) {
//             if (idx == arr.length) {
//                 if (k == 0) return 1;
//                 else return 0;
//             }
//             return helper(arr, k-arr[idx], idx+1) + helper(arr, k+arr[idx], idx+1);
//         }        
//          public int findTargetSumWays(int[] nums, int target) {
//              return helper(nums, target, 0);
//         }
//         dfs+memorization的代码
//         public int findTargetSumWays(int[] nums, int S) {
//             HashMap<Integer, Map<Integer, Integer>> m = new HashMap<>();
//             // return find(nums, 0, S, new HashMap<Integer, Map<Integer, Integer>>());
//             int tmp =  find(nums, 0, S, m);
//             // System.out.println("m.size(): " + m.size());
//             // for (Map.Entry<Integer, Map<Integer, Integer>> entry : m.entrySet()) {
//             //     System.out.println("entry.getKey()): " + entry.getKey());
//             //     Map<Integer, Integer> map = entry.getValue();
//             //     System.out.println("map.size(): " + map.size());
//             //     for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) 
//             //         System.out.print(entry2.getKey() + ", " + entry2.getValue() + "\n");
//             // }
//             return tmp;
//         }
//         // 这个图纪录得很没有参考价值，最好就不用了，不直观不实用没意义
//         public int find(int[] nums, int idx, int sum, Map<Integer, Map<Integer, Integer>> map) {
//             if(idx == nums.length) {
//                 if (sum == 0) return 1;
//                 else return 0;
//             }
//             Map<Integer, Integer> sumMap = map.get(idx);
//             if (sumMap != null) {
//                 if (sumMap.containsKey(sum)) {
//                     return sumMap.get(sum);
//                 }
//             } else {
//                 sumMap = new HashMap<>();
//                 map.put(idx, sumMap);
//             }
//             int count = find(nums, idx+1, sum-nums[idx], map) + find(nums, idx+1, sum+nums[idx], map);
//             sumMap.put(sum, count);
//             return count;
//         }        
//         动态规划的解法， 再想一想
//         bottom up的动态规划解法
//         因为所有数的和不会超过1000， 所以在表格向上平移了1000
//         dp的基本递推关系如下
//         dp[i][j+nums[i]] += dp[i-1][j];
//         dp[i][j-nums[i]] += dp[i-1][j];
//         public int findTargetSumWays(int[] nums, int S) {
//             int n = nums.length;
//             int [][] dp = new int[n][2001];
//             for (int i = 0; i < n; i++) {
//                 if (i == 0) {
//                     dp[i][1000+nums[i]] += 1;
//                     dp[i][1000-nums[i]] += 1;
//                 } else {
//                     for (int j = 0; j < dp[i].length; j++) {
//                         if (dp[i-1][j] > 0) {
//                             if (j + nums[i] < dp[i].length)
//                                 dp[i][j+nums[i]] += dp[i-1][j];
//                             if (j - nums[i] >= 0)
//                                 dp[i][j-nums[i]] += dp[i-1][j];
//                         }
//                     }
//                 }
//             }
//             if (S > 1000) return 0;
//             return dp[n-1][1000+S];
//         }
//         由于每个数的状态都只和前面一个数的状态有关， 所以，可以在空间上把二维降到一维
//         public int findTargetSumWays(int[] nums, int k) {
//             int n = nums.length;
//             if (k > 1000) return 0;
//             int [] dp = new int[2001];
//             dp [1000] = 1;
//             for (int va : nums) {
//                 int [] next = new int[2001];
//                 for (int i = dp.length-1-va; i >= va; i--) {
//                     next[i+va] += dp[i];
//                     next[i-va] += dp[i];
//                 }
//                 dp = next;
//             }
//             return dp[k+1000];
//         }
//         public int findTargetSumWays(int[] nums, int S) {
//             Map<Integer, Integer> cntMap = new HashMap<>();
//             cntMap.put(0, 1);
//             for (int num: nums) {
//                 Map<Integer, Integer> next = new HashMap<>();
//                 for (Map.Entry<Integer, Integer> entry: cntMap.entrySet()) {
//                     int v = entry.getKey();
//                     int cnt = entry.getValue();
//                     next.put(v+num, next.getOrDefault(v + num, 0) + cnt);
//                     next.put(v-num, next.getOrDefault(v - num, 0) + cnt);
//                 }
//                 cntMap = next;
//             }
//             return cntMap.getOrDefault(S, 0);
//         }
// sum[p] + sum[n] = sum[nums];
// sum[p] - sum[n] = S;
// 2sum[p] = sum[nums] + S
// sum[p] = (sum[nums] +S) / 2
//         public int findTargetSumWays(int[] nums, int S) {
//             int sum = 0;
//             for (int val : nums)  sum += val;
//             // 如果和小于S，说明无法得到解，返回false。（注意S有可能为负）
//             if (S > 0 && sum < S || S < 0 && -sum > S) return 0;
//             // 如果计算出的target不是整数，返回false。
//             if ((sum + S) % 2 != 0) return 0;
//             // 根据推导公式，计算出target
//             int target = (sum + S) / 2;
//             // dp[i]表示在原数组中找出一些数字，并且他们的和为下标i的可能有多少种。
//             int[] dp = new int[target + 1];
//             // 初始化dp[0]为1
//             dp[0] = 1;
//             // 循环数组中所有数字
//             for (int val : nums) {
//                 // 从0循环到target - n。
//                 for (int i = target - val; i >= 0; i--) {
//                     // dp[i]大于0说明，存在dp[i]种组合，其和为i的可能性
//                     if (dp[i] > 0) {
//                         // 既然存在和为i的可能，那么i加上当前数字的和也是存在的
//                         dp[i + val] += dp[i];
//                     }
//                 }
//             }
//             return dp[target];
//         }


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
        //             l.remove(l.size()-1); // 这里会弄丢一段序列，所以一定有问题
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
        //         if (val > Integer.MAX_VALUE) return false;         // 超出范围了
        //         // 数组里有两个以上的数，判断这个数能不能符合要求
        //         if (l.size() >= 2 && val > l.get(l.size()-1) + l.get(l.size()-2)) return false;
        //         // 还不到两个数，或者符合要求，添加进去，继续往前走
        //         if (l.size() < 2 || val == l.get(l.size()-1) + l.get(l.size()-2)) {
        //             l.add((int)val);
        //             if (dfs(s, l, i+1)) return true;
        //             // 删除刚加进去的，回头
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
        

        // public boolean splitString(String s) {
        //     int n = s.length();
        //     if (n < 2) return false;
        //     if (n == 2) return s.charAt(0) > s.charAt(1);
        //     for (int i = 1; i <= s.length() >> 1; i++)
        //         for (int j = 1; j + i <= s.length(); j++)  {
        //             System.out.println("\ni: " + i);
        //             System.out.println("j: " + j);
        //             System.out.println("s.substring(0, i): " + s.substring(0, i));
        //             System.out.println("s.substring(i, i + j): " + s.substring(i, i + j));
        //             if (isValid(s, s.substring(0, i), s.substring(i, i + j), i + j)) return true;
        //         }
        //     return false;
        // }
        // private boolean isValid(String s, String first, String second, int index) {
        //     if (first.length() == 1 && first.equals("0")) return false;
        //     long sum = Long.parseLong(first) - Long.parseLong(second);
        //     if (index == s.length() && sum == 1) return true; 
        //     long third = Long.parseLong(second) -1;
        //     System.out.println("third: " + String.valueOf(third));
        //     System.out.println("s: " + s);

        //     // int j = 0;
        //     // if (s.charAt(index) != (third+"").charAt(0) && s.charAt(index) == '0') {
        //     //    j = index;
        //     //     while (j < s.length() && s.charAt(j) == '0') ++j;
        //     // }
        //     // System.out.println("(s.startsWith(third + '', index) || String.valueOf(Long.parseLong(s.substring(index))).startsWith(third+'', 0)): " + (s.startsWith(third + "", index) || String.valueOf(Long.parseLong(s.substring(index))).startsWith(third+"", 0)));
            

        //     if (s.startsWith(third + "", index) || String.valueOf(Long.parseLong(s.substring(index))).startsWith(third+"", 0)) {
        //         int i = index;
        //         if (!s.startsWith(third + "", index)) {
        //             while (s.charAt(i) == '0') ++i;
        //         }
        //         // System.out.println("index: " + index);
        //         // System.out.println("i: " + i);
        //         // System.out.println("s.charAt(i): " + s.charAt(i));
        //         // System.out.println("(i + (third +: " + (i + (third + "").length()));
        //         // System.out.println("(isValid(s, second, third  " + (isValid(s, second, third + "", i + (third + "").length())));
        //         if (isValid(s, second, third + "", i + (third + "").length())) return true;
        //     }  
        //     return false;
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
        //         //  这里思路很清晰：只要是无效的（l>0 or r>0），就可以删除
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
        //     // 关于求有重复数字的全排列的: 首先要给原数组排序，使得重复的数字相邻，便于跳过。
        //     //         在递归数组中，记得要跳过重复数字，
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


        // * 注意点：
        // *  以下代码进行了两个部分的剪枝操作。
        // *      剪枝操作1：因为如果有相同颜色珠子连在一起的话，插在它们中任意位置效果都是相同的，
        // *      所以我们统一规定插在相同颜色珠子串的最后一个位置。
        // *      剪枝操作2：只对插入后会被消去的地方进行插入操作。即：如果本轮操作后，无法消去一段
        // *      那么该位置就不进行插入操作。
        // *  而本题存在问题的也正是上述的这两个剪枝操作！很明显这是一个贪心的做法，但是这个贪心的策略是错误的。
        // *  正确的做法应该是每个位置，都需要进行一遍试探性的插入才行。
        // *  举个例子:
        // *      board = "RRWWRRBBRR", hand = "WB"
        //     *  如果按照上述的做法，我们会在 [W] 或者 [B] 的后面插入手中的珠子，但是这样肯定会剩下 [RR] 没法消除
        //     *  因此会返回 -1. 当其实这个局面是有办法全部消去的，策略如下：
        //     *      RRWWRRBBRR -> RRWWRRBBR[W]R -> RRWWRRBB[B]RWR -> RRWWRRRWR -> RRWWWR -> RRR -> empty
        //     *  因此这里的剪枝（贪心）策略是错误的。
        //     *
        //     * 大家可能会有疑问，为什么错的还要这么做呢？
        //     * 因为...这题的标程都是错的啊！！！而且不贪心剪枝的话还过不去！！！坑爹啊！！！
        //     * 这也能解释为啥这么多人踩这道题目了...
        // private String shrink(String board) { // 消除当前 board 中所有可以消除的珠子串
        //     int i = 0, j;
        //     while (i < board.length()) {
        //         j = i+1;
        //         Character color = board.charAt(i);
        //         while (j < board.length() && color == board.charAt(j)) ++j;
        //         if (j - i >= 3) {
        //             board = board.substring(0, i) + board.substring(j);
        //             // 当进行成功消除后，记得将 i 重置回 0 位置，重新进行检查（因为可能发生连锁反应）
        //             i = 0;
        //         } else i++;
        //     }
        //     return board;
        // }
        // // 返回全部清楚当前board所需要的最少珠子，如果无法全部清除返回-1
        // private int dfs(String board, Map<Character, Integer> balls) {
        //     if (board == null || board.length() == 0) return 0;
        //     int res = Integer.MAX_VALUE;
        //     int i = 0, j = 0;
        //     while (i < board.length()) {
        //         Character color = board.charAt(i);
        //         j = i+1;
        //         // j一直向后移动，直到 j 越界 或者 指向的珠子颜色与 i 的不同
        //         while (j < board.length() && color == board.charAt(j)) j++;
        //         // 需要插入多少颗珠子才能消掉 i ~ j-1 的珠子
        //         int costBalls = 3 - (j - i);
        //         // 手中剩余足够的珠子可供插入
        //         if (balls.containsKey(color) && balls.get(color) >= costBalls) {
        //             // 消去 i ~ j-1 段的珠子，同时因为消去该段会导致两边的两段的珠子碰到一起
        //             // 可能会引发连续的消除反应，因此实现了 shrink() 来实现这点
        //             String newBoard = shrink(board.substring(0, i) + board.substring(j));
        //             // 减去花费掉的珠子数
        //             balls.put(color, balls.get(color) - costBalls);
        //             // 进行 DFS 调用子过程，求解全部消去剩下珠子需要的最少珠子数
        //             int subRes = dfs(newBoard, balls);
        //             if (subRes >= 0)
        //                 // 如果可以被顺利全部消除的话，取最小值即可
        //                 res = Math.min(res, costBalls + subRes);
        //             // Backtracking 加上之前消耗掉的珠子，进行回溯操作
        //             balls.put(color, balls.get(color) + costBalls);
        //         }
        //         i = j;
        //     }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }
        // public int findMinStep(String board, String hand) {
        //     if (board == null || board.length() == 0) return 0;
        //     Map<Character, Integer> balls = new HashMap<>();
        //     // 为了方便查询，我们需要统计手中珠子的信息（本题中我们可以发射手中的任意一颗珠子）
        //     for (char c : hand.toCharArray()) 
        //         balls.put(c, balls.getOrDefault(c, 0)+1);
        //     return dfs(board, balls);
        // }
        // private String getHashCode(String board, int[] count, char[] array) { // 这种方法是可以过的
        //     StringBuilder sb = new StringBuilder(board);
        //     for (int i = 0; i < array.length; i++) {
        //         sb.append("_" + array[i] + "_" + count[array[i] - 'A']);
        //     } // 面板上剩下的，和手里剩下的个数 一起作为状态 比较
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
        // private boolean noUsableBallsInHand(int[] count) { // 判断： 手里没有可用的珠子了
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
        // //在这里用的缓存 有技术 虽然有两个变量 board count 但是吧 如果board一样的话 count的值也会相等 这个结论是否正确呢？
        // private int process(String board, int[] count, HashMap<String, Integer> cache) {
        //     String hashCode = getHashCode(board, count, array);
        //     if (cache.containsKey(hashCode))
        //         return cache.get(hashCode);
        //     if (isSame(board))  return 0;
        //     if (board.length() == 0) return 0;
        //     if (noUsableBallsInHand(count)) return Integer.MAX_VALUE;

        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < board.length(); i++) {   // 遍历面板
        //         for (int j = 0; j < array.length; j++) { // 遍历手上可用的珠子 暴力查找
        //             int cur = array[j] - 'A';
        //             if (count[cur] > 0) {
        //                 count[cur]--;
        //                 StringBuilder sb = new StringBuilder(board);
        //                 sb.insert(i + 1, array[j]);
        //                 String res = getStr(board, i, array[j]); // 进行消除工作 必要的数据更新
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
        // private String getProcess1(String s) {  // 接下来的这两种方法没有看，可以参考一下
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
