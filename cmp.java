import com.TreeNode;

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

        // Set<Integer> v; 
        // int cur = 0, max = 0;
        //     public LUPrefix(int n) {
        //         v = new HashSet<>();
        // }
        // public void upload(int video) {
        //     v.add(video);
        //     if (video > max) max = video;
        //     int i = cur+1;
        //     for (; i <= max; i++) 
        //         if (!v.contains(i)) {
        //             if (i > 1) cur = i-1;
        //             break;
        //         }
        //     if (i == max+1) cur = max;
        // }
        // public int longest() {
        //     int i = cur+1;
        //     for (; i <= max; i++) 
        //         if (!v.contains(i)) {
        //             if (i > 1) cur = i-1;
        //             break;
        //         }
        //     if (i == max+1) cur = max;
        //     return cur;
        // }

        
        // // 要找个规律是说: NN
        // // a00 a01 a02 ..... a0n-1
        // // a10 a11 a12 ..... a1n-1
        // // ...
        // // an-10 an-11 ..... an-1n-1
        // public int xorAllNums(int[] a, int[] b) { 
        //     int m = a.length, n = b.length;
        //     int va = 0, vb = 0;
        //     for (var v : a) va ^= v;
        //     for (var v : b) vb ^= v;
        //     return (m % 2 == 1 ? vb : 0) ^ (n % 2 == 1 ? va : 0);
        // }

        // public boolean equalFrequency(String word) { // 不知道这个题目在说什么
        //     int [] f = new int [26];
        //     for (var c : word.toCharArray()) 
        //         f[c-'a']++;
        //     System.out.println(Arrays.toString(f));
            
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (var v : f)
        //         if (v != 0)
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //         System.out.print(en.getKey() + ", " + en.getValue() + "\n");

        //     if (m.size() == 1) {
        //         Map.Entry<Integer, Integer> en = m.entrySet().iterator().next();
        //         if (en.getKey() == 1) return true;
        //         return false;
        //     } 
        //     // if (!m.values().contains(1) 
        //     //     || m.containsKey(1) && m.get(1) > 1 && (!m.containsKey(2) || m.get(2) != 1)
        //     if (m.containsKey(1) && m.get(1) > 1 && (!m.containsKey(2) || m.get(2) != 1)
        //         || m.size() > 2)
        //         return false;

        //     Map<Integer, Set<Integer>> n = new HashMap<>();
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //         n.computeIfAbsent(en.getValue(), z -> new HashSet<>()).add(en.getKey());

        //     System.out.println("n.size(): " + n.size());
        //     for (Map.Entry<Integer, Set<Integer>> en : n.entrySet()) 
        //         System.out.print(en.getKey() + ", " + en.getValue().size() + "\n");
        //     // return n.size() <= 2 && m.containsKey(1) || n.size() == 1 && n.get(1).size() > 1;
        //     if (n.size() <= 2 && m.containsKey(1)) return true;
        //     if (n.size() == 1 && n.get(1).size() > 1) {
        //         if (n.get(1).size() > 2) return false;
        //         Iterator it = n.get(1).iterator();
        //         int va = (int)it.next(), vb = (int)it.next();
        //         if (Math.abs(va - vb) == 1) return true;
        //     }
        //     return false;
        // }

        public long numberOfPairs(int[] a, int[] b, int d) {
            int n = a.length;
            int [] f = new int [n];
            for (int i = 0; i < n; i++) 
                f[i] = a[i] - b[i];
            // 分情况来找:如果d >= 0的情况,和d < 0的情况
            // i, j, i < j && f[i] - f[j] <= d 可能再涉及到单调栈的使用,这样才能是O(N)数量级的遍历解决
            // if (d >= 0) : 使用单调栈,从右往左遍历,数个数
            ArrayDeque<Integer> s = new ArrayDeque<>(); // 这里有点儿没想透
            int [] cnt = new int [n+1];
            for (int i = n-1; i > 0; i--) {
            }
        }

    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // String a = "aazz";
        // String a = "bac";
        // String a = "adbc";
        // String a = "cbccca";
        // String a = "abcc";
        // String a = "babbdd";
        // String a = "ccccaa";
        // failed for Hidden for this testcase during contest. .....

        // int [] a = new int [] {1, 2};
        // int [] b = new int [] {3, 4};
        int [] a = new int [] {2, 1, 3};
        int [] b = new int [] {10, 2, 5, 0};

        int r = s.xorAllNums(a, b);
        System.out.println("r: " + r); 
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
