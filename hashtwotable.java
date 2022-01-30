// import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class hashtwotable {
    public static class Solution {

        // public List<List<String>> displayTable(List<List<String>> orders) {
        //     TreeSet<String> ts = new TreeSet<>();
        //     for (List<String> l : orders) 
        //         ts.add(l.get(2));
        //     List<String> top = new ArrayList<>();
        //     top.addAll(ts);
        //     Map<String, Integer> m = new HashMap<>();
        //     for (int i = 0; i < top.size(); i++) 
        //         m.put(top.get(i), i);
        //     Map<Integer, List<Integer>> res = new HashMap<>();
        //     for (List<String> l : orders) {
        //         List<Integer> cur = res.computeIfAbsent(Integer.parseInt(l.get(1)), z -> Arrays.asList(new Integer[top.size()]));
        //         int idx = m.get(l.get(2));
        //         cur.set(idx, cur.get(idx) == null ? 1 : cur.get(idx) + 1);
        //     }
        //     List<List<String>> ans = new ArrayList<>();
        //     top.add(0, "Table");
        //     ans.add(top);
        //     Map<Integer, List<Integer>> tmp = res.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey())  // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     Iterator it = tmp.entrySet().iterator();
        //     while (it.hasNext()) {
        //         Map.Entry<Integer, List<Integer>> en = (Map.Entry)it.next();
        //         List<String> cur = new ArrayList<>();
        //         cur.add("" + en.getKey());
        //         for (Integer v : en.getValue()) cur.add( v == null ? "0" : ""+v);
        //         ans.add(cur);
        //     }
        //     return ans;
        // }

        
        // Map<Integer, List<Integer>> m = new HashMap<>();
        // Random rand = new Random();
        // public Solution(int[] arr) {
        //     for (int i = 0; i < arr.length; i++) 
        //         m.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
        // }
        // public int pick(int target) {
        //     int idx = rand.nextInt(m.get(target).size());
        //     return m.get(target).get(idx);
        // }

        
        // public int leastBricks(List<List<Integer>> wall) { // 要换个思路再接着写
        //     for (int i = 0; i < wall.size(); i++) {
        //         List<Integer> l = wall.get(i);
        //         for (int j = 1; j < l.size(); j++) 
        //             l.set(j, l.get(j) + l.get(j-1));
        //     }
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int max = 0, limit = wall.get(0).get(wall.get(0).size()-1);
        //     for (List<Integer> li : wall) 
        //         for (Integer v : li) {
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //             if (v != limit)
        //                 max = Math.max(max, m.get(v));
        //         }
        //     System.out.println("max: " + max);
        //     return wall.size()-max;
        // }

        // public int flipgame(int[] front, int[] back) { // Bug: 没有考虑很多数位一起换情况下的最优解
        //     int n = front.length, ans = 2000;
        //     Map<Integer, Integer> mf = new HashMap<>();
        //     Map<Integer, Integer> mb = new HashMap<>();
        //     Map<Integer, List<Integer>> map = new HashMap<>();
        //     for (int v : front) mf.put(v, mf.getOrDefault(v, 0) + 1);
        //     for (int v : back) mb.put(v, mb.getOrDefault(v, 0) + 1);
        //     for (int i = 0; i < n; i++)
        //         map.computeIfAbsent(back[i], z -> new ArrayList<>()).add(i);
        //     for (Integer key : mb.keySet()) {
        //         int v = mb.get(key);
        //         if (!mf.containsKey(key)) {
        //             ans = Math.min(ans, key);
        //         }
        //         if (key != front[map.get(key).get(0)]) {
        //             if (mf.get(front[map.get(key).get(0)]) == 1) {
        //                 ans = Math.min(ans, front[map.get(key).get(0)]);
        //                 map.get(key).remove(0);
        //             }
        //         }
        //         System.out.println("ans: " + ans);
        //     }
        //     return ans == 2000 ? 0 : ans;
        // }

        // public int smallestRepunitDivByK(int k) { // bug: 超出long范围的，就没法再进行了
        //     if (k % 2 == 0 || k % 5 == 0) return -1;
        //     if (k == 1) return 1;
        //     String s = "11";
        //     int ans = -1, m = String.valueOf(Long.MAX_VALUE).length();
        //     long v = Integer.parseInt(s);
        //     while (v % k != 0) {
        //         s += "1";
        //         if (s.length() <= m) {
        //             v = Long.parseLong(s);
        //             if (v % k == 0) return s.length();
        //         } else break;
        //     }
        //     if (v % k == 0) return s.length();
        //     return ans;
        // }
        // // 需要迭代的数字为：1, 11, 111, 1111, 11111, ...，又根据公式(10 * n + 1) % K = (10 * (n % K) + 1) % K，得出迭代方程为：n = (n * 10 + 1) % K
        // public int smallestRepunitDivByK(int k) { 
        //     for (int i = 1, n = 0; i <= k; i++) {
        //         n = ((n * 10) + 1) % k;
        //         if (n == 0) return i;
        //     }
        //     return -1;
        // }

    // TreeMap<Integer, Integer> map = new TreeMap<>(); // 用数组比用这个快
    // CusMap m;
    // int n;
    // public TopVotedCandidate(int[] persons, int[] times) {
    //     n = persons.length;
    //     m = new CusMap();
    //     for (int i = 0; i < n; i++) {
    //         m.put(persons[i], m.getOrDefault(persons[i], 0) + 1);
    //         map.put(times[i], m.win);
    //     }
    // }
    // public int q(int t) {
    //     Integer k = map.floorKey(t);
    //     if (k != null) {
    //         return map.get(k);
    //     }
    //     return -1;
    // }
    // class CusMap { // 这层包装可以略过，只从左到右扫描数组的时候记下累积最佳候选就可以了
    //     public int win = -1;
    //     int maxCnt = 0;
    //     Map<Integer, Integer> m = new HashMap<>();
    //     public CusMap() {
    //         m = new HashMap<>();
    //         win = -1;
    //         maxCnt = 0;
    //     }
    //     void put(int i, int v) {
    //         m.put(i, v);
    //         if (v >= maxCnt) {
    //             if (v > maxCnt)
    //                 maxCnt = v;
    //             win = i;
    //         }
    //     }
    //     int getOrDefault(int k, int v) {
    //         if (!m.containsKey(k)) return v;
    //         return m.get(k);
    //     }
    // }

        // public int numPairsDivisibleBy60(int[] t) { // 从左到右扫一遍，边扫边建立累积
        //     int [] cnt = new int [60];
        //     int ans = 0;
        //     for (int v : t) {
        //         if (v % 60 == 0)
        //             ans += cnt[0];
        //         else ans += cnt[60 - v%60];
        //         cnt[v%60]++;
        //     }
        //     return ans;
        // }
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {30,20,150,100,40};
        // int []  a = new int []  {439, 407, 197, 191, 291, 486, 30, 307, 11};

        int r = s.numPairsDivisibleBy60(a);
        System.out.println("r: " + r);
    }
}