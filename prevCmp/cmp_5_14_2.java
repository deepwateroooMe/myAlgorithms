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
    public static class Solution {

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

        // public int largestCombination(int[] candidates) {
        //     return 0;
        // }

        // class Interval {
        //     int l, r;
        //     public Interval(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     public int getLength() {
        //         return r - l + 1;
        //     }
        //     public String toString() {
        //         return "Interval(" + l + "," + r + ")";
        //     }
        // } 
        // class CountIntervals { // tle ? nOO // 因为这道题的测试，每调用一次，你都要数一遍，这是不可以的，你需要一个可以动态随时准备好的数据存储 TLE TLE TLE
        //     TreeSet<Interval> ts;
        //     public CountIntervals() {
        //         // public cmp() {
        //         ts = new TreeSet<>((x, y) -> x.l != y.l ? x.l - y.l : x.r - y.r);
        //     }
        //     public void add(int left, int right) {
        //         int nl = left, nr = right;
        //         Interval hi = new Interval(right, Integer.MAX_VALUE);
        //         while (true) {
        //             Interval r = ts.lower(hi);
        //             if (r == null || r.r < left) break;
        //             if (r.r > right) nr = r.r;
        //             if (r.l < left) nl = r.l;
        //             ts.remove(r);
        //         }
        //         ts.add(new Interval(nl, nr)); // 这里题目根本就没有提任何overlap的情况呀，要如何处理呢？不重复是最高效的
        //     }
        //     public int count() { // 因为这道题的测试，每调用一次，你都要数一遍，这是不可以的，你需要一个可以动态随时准备好的数据存储 TLE TLE TLE
        //         int cnt = 0;
        //         for (Interval v : ts) 
        //             cnt += v.getLength();
        //         return cnt;
        //     }
        // }
        // class CountIntervals { // 也还是需要去想一下 BST 的写法，要不然 BST 会被我忘完了，上个周的惨痛教训还不够么？
        //     TreeMap<Integer, Integer> m;
        //     int cnt = 0;
        //     public CountIntervals() {
        //         m = new TreeMap<>();
        //     }
        //     public void add(int left, int right) {
        //         if (m.floorKey(right) == null || m.get(m.floorKey(right)) < left) { // 想要加进去的与现有的，没有任何交集
        //             m.put(left, right);
        //             cnt += right - left + 1;
        //         } else { // 与某个有交集
        //             int bgn = left, end = right;
        //             while (true) {
        //                 // int l = (m.floorKey(end) != null ? m.floorKey(end) : Integer.MAX_VALUE); // 写出这些就说明没有真正理解，非空
        //                 // int r = (l != 0 ? m.get(l) : 0);
        //                 int l = m.floorKey(end), r = m.get(l);
        //                 bgn = Math.min(bgn, l);
        //                 end = Math.max(end, r);
        //                 m.remove(l);
        //                 cnt -= r - l + 1;
        //                 if (m.floorKey(end) == null || m.get(m.floorKey(end)) < bgn) break;
        //             }
        //             m.put(bgn, end);
        //             cnt += end - bgn + 1;
        //         }
        //     }
        //     public int count() {
        //         return cnt;
        //     }
        // }
// BST的解法：主要是参加别人的，需要改天自己再写一遍；根本就还没有搞明白别人为什么会这么写呢？
        private static class AVL { // AVL: 是什么意思呢？
            private static class Node {
                int l, r;
                int subtreeSize; // 所函盖数字的总结点数
                int balanceFactor, height;
                Node left, right;
                int rangeSize; 
                Node(int l, int r) {
                    this.l = l;
                    this.r = r;
                    subtreeSize = r - l + 1; // 接下来会用rangeSize来更新subtreeSize
                    balanceFactor = 0;
                    height = 0;
                    left = right = null;
                    rangeSize = r - l + 1;
                }
                @Override public String toString() {
                    return "Note{l= " + l + ", r= " + r + ", subtreeSize= " + subtreeSize + "}, rangeSize = " + rangeSize;
                }
            }
            Node root;
            void AVL() {
                root = null;
            }
            public void add(int l, int r) {
                root = insert(root, l, r);
            }
            public int size() {
                if (root == null) return 0;
                return root.subtreeSize;
            }
            private Node insert(Node p, int l, int r) {
                if (l > r) return p;
                if (p == null) return new Node(l, r);
                p.left = insert(p.left, l, Math.min(p.l-1, r));
                p.right = insert(p.right, Math.max(p.r+1, l), r);
                update(p);
                return balance(p);
            }
            private void update(Node r) {
                int leftHeight = r.left == null ? 0 : r.left.height;
                int rightHeight = r.right == null ? 0 : r.right.height;
                r.height = 1 + Math.max(leftHeight, rightHeight);
                r.balanceFactor = rightHeight - leftHeight; // 不知道这里是在做什么呀？？？
                int lss = r.left == null ? 0 : r.left.subtreeSize;
                int rss = r.right == null ? 0 : r.right.subtreeSize;
                r.subtreeSize = r.rangeSize + lss + rss;
            }
            private Node balance(Node r) {
// left heavy HEAVY
                if (r.balanceFactor == -2) { 
                    if (r.left.balanceFactor <= 0) // left left: 这里要把人看哭了，不知道是怎么回事。。。。。
                        return rightRotate(r);
                    else { // left righ
                        r.left = leftRotate(r.left); // 先左转左子树
                        return rightRotate(r);       // 再右转当前节点树
                    } 
// right heavy HEAVY
                } else if (r.balanceFactor == 2) { 
                    if (r.right.balanceFactor >= 0) // right right
                        return leftRotate(r);
                    else { // right left
                        r.right = rightRotate(r.right);
                        return leftRotate(r);
                    }
                }
                return r;
            }
            Node rightRotate(Node A) { // 把 r 节点向右手旋转
                Node B = A.left;
                A.left = B.right;
                B.right = A;
                update(A);
                update(B);
                return B; // 旋转后 B 是根节点
            }
            Node leftRotate(Node B) {
                Node A = B.right;
                B.right = A.left;
                A.left = B;
                update(B); // 先更新子树
                update(A); // 再更新根节点
                return A;  // 返还根节点
            }
            void preOrder(Node r) {
                if (r == null) return ;
                System.out.println("r: " + r); // 这样就可以自动 load toString()了吗？
                preOrder(r.left);
                preOrder(r.right);
            }
        }
        class CountIntervals {
            AVL avl;
            public CountIntervals() {
                // public cmp() {
                avl = new AVL();
            }
            public void add(int left, int right) {
                avl.add(left, right);
            }
            public int count() {
                return avl.size();
            }
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();



        
        int r = s.maxConsecutive(1, 23, a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
