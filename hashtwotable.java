import com.ListNode;

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



    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};

        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < a.length; i++) 
            ll.add(Arrays.stream(a[i]).boxed().collect(Collectors.toList()));
        
        int r = s.leastBricks(ll);
        System.out.println("r: " + r);
    }
}