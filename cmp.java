// import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {

        // public int countElements(int[] a) {
        //     int n = a.length, ans = 0;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int v : a)
        //         m.put(v, m.getOrDefault(v, 0) + 1);
        //     for (Integer key : m.keySet()) {
        //         Integer lo = m.lowerKey(key), hi = m.higherKey(key);
        //         if (lo != null && hi != null)
        //             ans += m.get(key);
        //     }
        //     return ans;
        // }

        // public int[] rearrangeArray(int[] a) {
        //     int n = a.length, i = 0, j = 0, k = 0;
        //     int [] ans = new int [n];
        //     List<Integer> pos = new ArrayList<>();
        //     List<Integer> neg = new ArrayList<>();
        //     for (int v : a) {
        //         if (v > 0) pos.add(v);
        //         else neg.add(v);
        //     }            
        //     while (k < n) {
        //         if (k % 2 == 0) ans[k++] = pos.get(i++);
        //         else ans[k++] = neg.get(j++);
        //     }
        //     return ans;
        // }

        // public List<Integer> findLonely(int[] a) {
        //     int n = a.length;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
        //     List<Integer> ans = new ArrayList<>();
        //     for (Integer key : m.keySet()) {
        //         if (m.get(key) > 1) continue;
        //         if (!m.containsKey(key-1) && !m.containsKey(key+1))
        //             ans.add(key);
        //     }
        //     return ans;
        // }

        public int maximumGood(int[][] a) { // 这个题完全没有思路，我还是去做别的，看看我的书吧，改天再回来看这个
            int n = a.length;
            b = new HashMap<>();
            g = new HashMap<>();
            for (int i = 0; i < n; i++) 
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 0) {
                        b.computeIfAbsent(i, z -> new ArrayList<>()).add(j);
                        b.computeIfAbsent(j, z -> new ArrayList<>()).add(i);
                    } else if (a[i][j] == 1) {
                        g.computeIfAbsent(i, z -> new ArrayList<>()).add(j);
                        g.computeIfAbsent(j, z -> new ArrayList<>()).add(i);
                    }
                }
        }
        Map<Integer, List<Integer>> b, g;
    }   
    public static void main (String[] args) {
        Solution s = new Solution ();

        int []  a = new int []  {10, 6, 5, 8};

        List<Integer> r = s.findLonely(a);
        System.out.println("r.size(): " + r.size());
        System.out.println(Arrays.toString(r.toArray()));
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
