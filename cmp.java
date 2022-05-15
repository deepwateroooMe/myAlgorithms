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

public class cmp { // will attend coming weekend, will NOT attend next next long weekend due to long trip driving.........
    // public static class Solution {

    // public List<String> removeAnagrams(String[] a) {
    //     int n = a.length;
    //     List<String> ss = new ArrayList<>();
    //     ss.add(a[0]);
    //     for (int i = 1; i < n; i++) {
    //         System.out.println("\n i: " + i);
    //         if (isSamiliar(a[i], ss.get(ss.size()-1))) {
    //             continue;
    //         } else ss.add(a[i]);
    //     }
    //     return ss;
    // }
    // boolean isSamiliar(String a, String b) {
    //     if (a.length() != b.length()) return false;
    //     Map<Character, Integer> m = new HashMap<>();
    //     Map<Character, Integer> n = new HashMap<>();
    //     for (char c : a.toCharArray()) 
    //         m.put(c, m.getOrDefault(c, 0) + 1);
    //     for (char c : b.toCharArray()) 
    //         n.put(c, n.getOrDefault(c, 0) + 1);
    //     for (Character key : m.keySet()) {
    //         if (!n.containsKey(key)) return false;
    //         if (n.get(key) != m.get(key)) return false;
    //     }
    //     return true;
    // }

    // public int largestCombination(int[] candidates) {
    // }

    // class Range {
    //     int left, right;
    //     public Range(int left, int right) {
    //         this.left = left;
    //         this.right = right;
    //     }
    //     public String toString() {
    //         return "Range(" + left + "," + right + ")";
    //     }
    // }
    // TreeSet<Range> ts;
    // public int maxConsecutive(int l, int r, int[] a) { // 今天的脑袋不够清醒，再也不想继续debug这个了。。。。。。
    //     int n = a.length;
    //     ts = new TreeSet<>((x, y)->(x.left != y.left ? x.left - y.left : x.right - y.right));
    //     ts.add(new Range(l, r));
    //     // Map<Integer, Integer> m = new HashMap<>();
    //     // m.put(r-l+1, 1);
    //     for (int v : a) {
    //         System.out.println("\n v: " + v);
    //         Range hi = new Range(v, r);
    //         Range rg = ts.lower(hi);
    //         if (rg != null)
    //             System.out.println("rg.toString(): " + rg.toString());
    //         if (rg != null && rg.right >= v) {
    //             System.out.println("rg.toString(): " + rg.toString());
    //             if (rg.left == v && rg.right == v) {
    //                 removeRange(v-1, v+1);
    //                 // for (Range x : ts) 
    //                 //     System.out.println("v.toString(): " + x.toString());
    //             } else {
    //                 int tmp = rg.right;
    //                 if (rg.left < v)
    //                     // addRange(rg.left, v-1);
    //                     rg.right = v-1;
    //                 if (tmp > v)
    //                     addRange(v+1, tmp);
    //                 // removeRange(rg.left-1, rg.right + 1);
    //             }
    //         }
    //         Range lo = new Range(l, v);
    //         rg = ts.higher(lo);
    //         if (rg != null)
    //         System.out.println("rg.toString(): " + rg.toString());
    //         if (rg != null && rg.left <= v) {
    //             System.out.println("rg.toString(): " + rg.toString());
    //             if (rg.left == v && rg.right == v) {
    //                 removeRange(v-1, v+1);
    //                 // for (Range x : ts) 
    //                 //     System.out.println("v.toString(): " + x.toString());
    //             } else {
    //                 int tmp = rg.right;
    //                 if (rg.left < v && rg.right >= v) {
    //                     // addRange(rg.left, v-1);
    //                     rg.right = v-1;
    //                     if (rg.right > v)
    //                         addRange(v+1, tmp);
    //                     // removeRange(rg.left-1, rg.right + 1);
    //                 } else if (rg.left == v) {
    //                     if (rg.right == v) removeRange(v-1, v+1);
    //                     else rg.left = v+1;
    //                 }
    //             }
    //         }
    //         for (Range x : ts) 
    //             System.out.println("v.toString(): " + x.toString());
    //     }
    //     int max = 0, cur = 0;
    //     System.out.println("ts.size(): " + ts.size());
    //     for (Range v : ts) {
    //         System.out.println("v.toString(): " + v.toString());
    //         cur = v.right - v.left + 1;
    //         max = Math.max(max, cur);
    //     }
    //     return max;
    // }
    // public void addRange(int left, int right) {
    //     int nl = left, nr = right;
    //     Range high = new Range(right, Integer.MAX_VALUE);
    //     while (true) {
    //         Range r = ts.lower(high);
    //         if (r == null || r.right < left) break;
    //         if (r.right > right) nr = r.right;
    //         if (r.left < left) nl = r.left;
    //         ts.remove(r);
    //     }
    //     ts.add(new Range(nl, nr));
    // }
    // public void removeRange(int left, int right) {
    //     Range high = new Range(right, right);
    //     while (true) {
    //         Range r = ts.lower(high);
    //         if (r == null || r.right <= left) break;  // <= left
    //         if (r.right > right)
    //             ts.add(new Range(right, r.right));
    //         if (r.left < left)
    //             ts.add(new Range(r.left, left));
    //         ts.remove(r);
    //     }
    // }

    class Interval {
        int l, r;
        public Interval(int l, int r) {
            this.l = l;
            this.r = r;
        }
        public int getLength() {
            return r - l + 1;
        }
        public String toString() {
            return "Interval(" + l + "," + r + ")";
        }
    } 
    class CountIntervals { // tle ? nOO
        TreeSet<Interval> ts;
        public CountIntervals() {
            // public cmp() {
            ts = new TreeSet<>((x, y) -> x.l != y.l ? x.l - y.l : x.r - y.r);
        }
        public void add(int left, int right) {
            int nl = left, nr = right;
            Interval hi = new Interval(right, Integer.MAX_VALUE);
            while (true) {
                Interval r = ts.lower(hi);
                if (r == null || r.r < left) break;
                if (r.r > right) nr = r.r;
                if (r.l < left) nl = r.l;
                ts.remove(r);
            }
            ts.add(new Interval(nl, nr)); // 这里题目根本就没有提任何overlap的情况呀，要如何处理呢？不重复是最高效的
        }
        public int count() {
            int cnt = 0;
            for (Interval v : ts) 
                cnt += v.getLength();
            return cnt;
        }
    }
// }
public static void main(String args[]) {
    // Solution s = new Solution();

    cmp s = new cmp(); // initialize the object with an empty set of intervals. 
    s.add(2, 3);  // add [2, 3] to the set of intervals.
    s.add(7, 10); // add [7, 10] to the set of intervals.
    int r = s.count();    // return 6
    System.out.println("r: " + r);

    // the integers 2 and 3 are present in the interval [2, 3].
    // the integers 7, 8, 9, and 10 are present in the interval [7, 10].
    s.add(5, 8);  // add [5, 8] to the set of intervals.
    int r1 =s.count();    // return 8
    System.out.println("r1: " + r1);
        
    // the integers 2 and 3 are present in the interval [2, 3].
    // the integers 5 and 6 are present in the interval [5, 8].
    // the integers 7 and 8 are present in the intervals [5, 8] and [7, 10].
    // the integers 9 and 10 are present in the interval [7, 10].

    // int [] a = new int [] {21, 1};

    // int r = s.maxConsecutive(1, 23, a);
    // System.out.println("r: " + r);
}
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
