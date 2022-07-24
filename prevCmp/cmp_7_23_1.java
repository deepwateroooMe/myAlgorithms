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

    // public String bestHand(int[] a, char[] b) {
    //     if (isFlush(b)) return "Flush";
    //     Queue<int []> q = new PriorityQueue<>((x, y) -> (x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]));
    //     Map<Integer, Integer> m = new HashMap<>();
    //     for (int v : a)
    //         m.put(v, m.getOrDefault(v, 0) + 1);
    //     for (Map.Entry<Integer, Integer> en : m.entrySet()) 
    //         q.offer(new int [] {en.getKey(), en.getValue()});
    //     if (q.peek()[1] >= 3) return "Three of a Kind";
    //     else if (q.peek()[1] == 2) return "Pair";
    //     else return "High Card";
    // }
    // boolean isFlush(char [] a) {
    //     char cur = a[0];
    //     for (int i = 1; i < a.length; i++) 
    //         if (a[i] != cur) return false;
    //     return true;
    // }

    // public long zeroFilledSubarray(int[] nums) {
    // }

    // // class NumberContainers { // 今天早上的脑袋很酱,暂时想不出来更好的办法了
    // Map<Integer, Queue<Integer>> m;
    // Map<Integer, Integer> idx;

    // public NumberContainers() {
    // // public cmp() {
    //     m = new HashMap();
    //     idx = new HashMap<>();
    // }
    // public void change(int index, int number) {
    //     if (!idx.containsKey(index)) {
    //         if (!m.containsKey(number)) {
    //             m.put(number, new PriorityQueue<>());
    //             m.get(number).offer(index);
    //         } else {
    //             m.get(number).offer(index);
    //         }
    //         idx.put(index, number);
    //     } else {
    //         int v = idx.get(index);
    //         m.get(v).remove(index); // <<<<<<<<<<==========
    //         idx.put(index, number);
    //         if (!m.containsKey(number)) {
    //             m.put(number, new PriorityQueue<>());
    //             m.get(number).offer(index);
    //         } else {
    //             m.get(number).offer(index);
    //         }
    //         idx.put(index, number);
    //     }
    // }
    // public int find(int number) {
    //     if (!m.containsKey(number) || m.get(number).size() == 0) return -1;
    //     return m.get(number).peek();
    // }

        public int shortestSequence(int[] rolls, int k) {
        
        }
    }
    public static void main(String args[]) { 
        // Solution s = new Solution();
        cmp s = new cmp();

        s.change(1, 10);

        int r = s.find(10);
        System.out.println("r: " + r);
        
        s.change(1, 20);
        int r1 = s.find(10);
        System.out.println("r1: " + r1);

        int r2 = s.find(20);
        System.out.println("r2: " + r2);

        int r3 = s.find(30);
        System.out.println("r3: " + r3);

    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
