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

        // // 下午写这个题目的时候脑袋昏昏，并没有去debug去看为什么这个test case fail掉了？只凭脑力想了想需要维护些什么相关数据，
        // // 但不曾debug来帮助理解，少维护了什么？
        // // 不知道哪里写错了，等比赛完了再看一下这个题目
        // Map<Integer, Integer> m;
        // Map<Integer, Queue<Integer>> idx;
        // int max = Integer.MAX_VALUE;
        // public NumberContainers() {
        //     // public cmp() {
        //     m = new HashMap<>();
        //     idx = new HashMap<>();
        // }
        // public void change(int index, int number) {
        //     // 先处理更改前的位标数据更新
        //     if (m.containsKey(index)) {
        //         idx.get(m.get(index)).remove((Integer)number);
        //         if (idx.get(m.get(index)).isEmpty()) // 如果数据清空了就清空这个键
        //             idx.remove(m.get(index));
        //     }
        //     m.put(index, number);
        //     idx.computeIfAbsent(number, z -> new PriorityQueue<>());
        //     idx.get(number).add(index);
        // }
        // public int find(int number) {
        //     return idx.containsKey(number) ? idx.get(number).peek() : -1;
        // }
// 好像今天调整输入法,好像把一个什么键弄坏了，改天再调一下，那个输入法好用
        
        // public int smallestEvenMultiple(int n) {
        //     if (n % 2 == 0) return n;
        //     return 2 * n;
        // }

        // public int longestContinuousSubstring(String ss) {
        //     int n = ss.length(), i = 0, j = 0, max = 1;
        //     char [] s = ss.toCharArray();
        //     while (i < n) {
        //         if (i < n-1 && s[i+1] - s[i] == 1) {
        //             j = i+1;
        //             while (j < n-1 && s[j+1] - s[j] == 1) j++;
        //             max = Math.max(max, j-i+1);
        //             i = j+1;
        //         } else i++;
        //     }
        //     return max;
        // }

        // public TreeNode reverseOddLevels(TreeNode root) {
        //     if (root == null || root.left == null && root.right == null) return root;
        //     int cnt = 1;
        //     Deque<TreeNode> q = new ArrayDeque<>();
        //     q.offerFirst(root);
        //     List<Integer> l = new ArrayList<>();
        //     while (!q.isEmpty()) {
        //         int size = q.size();
        //         while (size-- > 0) {
        //             TreeNode r = q.pollLast();
        //             if (cnt % 2 == 0) r.val = l.remove(0);
        //             if (r.left != null) {
        //                 if (cnt % 2 == 1) l.add(0, r.left.val);
        //                 q.offerFirst(r.left);
        //             }
        //             if (r.right != null) {
        //                 if (cnt % 2 == 1) l.add(0, r.right.val);
        //                 q.offerFirst(r.right);
        //             }
        //         }
        //         cnt++;
        //     }
        //     return root;
        // }

        // class Trie {
        //     Trie[] ch = new Trie[26];
        //     int visited = 0;
        // }
        // class Solution {
        //     public int[] sumPrefixScores(String[] words) {
        //         Trie trie = new Trie();
        //         int[] ans = new int[words.length];
        //         int k = 0;
        //         for (String x: words) {
        //             Trie t = trie;
        //             for (int i = 0; i < x.length(); i++) {
        //                 int c = x.charAt(i) - 'a';
        //                 if (t.ch[c] == null) t.ch[c] = new Trie();
        //                 t.ch[c].visited++;
        //                 t = t.ch[c];
        //             }
        //         }
        //         for (String x: words) {
        //             Trie t = trie; int curr = 0;
        //             for (int i = 0; i < x.length(); i++) {
        //                 int c = x.charAt(i) - 'a';
        //                 curr += t.ch[c].visited;
        //                 t = t.ch[c];
        //             }
        //             ans[k++] = curr;
        //         }
        //         return ans;
        //     }
        // }
        // public int[] sumPrefixScores(String[] a) { // TLE: 再想想是为什么？
        //     int n = a.length, cnt = 0;
        //     Trie t = new Trie();
        //     for (var v : a) t.insert(v);
        //     // populate map to remember all the possible counts： 这里遍历一遍可能做多了？
        //     // 这里先遍历一遍，再记住记在字典里，反而不如直接用时遍历一遍来得快？真是想不透呀。。。。。
        //     // t.inOrderTraversal(t, new StringBuilder());
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<String, Integer> en : m.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         String v = a[i];
        //         Trie tc = t;
        //         cnt = 0;
        //         // for (int j = 1; j <= v.length(); j++) 
        //         //     cnt += m.get(v.substring(0, j));
        //         for (int j = 0; j < v.length(); j++) {
        //             int k = v.charAt(j) - 'a';
        //             cnt += tc.n[k].v;
        //             tc = tc.n[k];
        //         }
        //         f[i] = cnt;
        //     }
        //     return f;
        // }
        // Map<String, Integer> m = new HashMap<>();
        // public class Trie {
        //     int v;
        //     Trie [] n;
        //     public Trie() {
        //         v = 0; 
        //         n = new Trie [26];
        //     }
        //     // public void inOrderTraversal(Trie r, StringBuilder s) {
        //     //     for (int i = 0; i < 26; i++) {
        //     //         if (r.n[i] != null) {
        //     //             s.append((char)('a'+i));
        //     //             // System.out.println("s.toString(): " + s.toString() + ": cnt = " + r.v); 
        //     //             m.put(s.toString(), r.n[i].v);
        //     //             inOrderTraversal(r.n[i], s);
        //     //             s.deleteCharAt(s.length()-1);
        //     //         }
        //     //     }
        //     // }
        //     public void insert(String t) {
        //         char [] s = t.toCharArray();
        //         Trie r = this;
        //         for (int i = 0; i < t.length(); i++) {
        //             int j = s[i] - 'a';
        //             if (r.n[j] == null) r.n[j] = new Trie();
        //             r = r.n[j];
        //             r.v++;
        //         }
        //     }
        //     public int getCntStartsWith(String t) {
        //         char [] s = t.toCharArray();
        //         Trie r = this;
        //         for (int i = 0; i < t.length(); i++) {
        //             int j = s[i] - 'a';
        //             if (r.n[j] == null) return 0;
        //             r = r.n[j];
        //         }
        //         return r.v;
        //     }
        // }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // will skis this Saturday evening's contest, but will try to attend morning's contest on Saturday
        // String [] a = new String [] {"abc","ab","bc","b"};
        String [] a = new String [] {"qtcqcmwcin","vkjotbrbzn","eoorlyfche","eoorlyhn","eoorlyfcxk","qfnmjilcom","eoorlyfche","qtcqcmwcnl","qtcqcrpjr"};

        int [] r = s.sumPrefixScores(a);
        System.out.println(Arrays.toString(r));
    }
}





// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
