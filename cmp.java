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

        public int[] sumPrefixScores(String[] a) { // TLE: failed on a too big test case that emacs is NOT able to handle, will solve this problem later
            int n = a.length, ccnt = 0;
            Map<String, List<Integer>> idx = new HashMap<>();
            for (int i = 0; i < n; i++)
                idx.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
            Arrays.sort(a, (x, y)-> x.length() != y.length() ? x.length() - y.length() : x.compareTo(y));
            // System.out.println(Arrays.toString(a));
            Map<String, Integer> cnt = new HashMap<>();
            for (var v : a) cnt.put(v, cnt.getOrDefault(v, 0) + 1); // 没有说有没有重复，所以需要考虑重复的情况
            Map<String, Integer> m = new HashMap<>();
            int [] f = new int [n];
            for (int i = 0; i < n; i++) {
                String v = a[i];
                ccnt = 0;
                for (int j = 1; j <= v.length(); j++) {
                    String cur = v.substring(0, j);
                    if (m.containsKey(cur)) {
                        ccnt += m.get(cur);
                        continue;
                    }
                    int cnter = 0;
                    for (String k : cnt.keySet()) 
                        if (k.startsWith(cur)) cnter += cnt.get(k);
                    m.put(cur, cnter);
                    ccnt += cnter;
                    if (cnter == 0) break;
                }
                for (var z : idx.get (a[i])) 
                    f[z] = ccnt;
            }
            return f;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

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
