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

        public int minOperations(int[] a, int[] b) {
            int n = a.length, m = b.length;
            // 对数组 A 的处理：有重复，统计了出现次数的 PriorityQueue
            Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
            Map<Integer, Integer> m = new HashMap<>();
            for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
            for (Integer key : m.keySet()) 
                q.offer(new int [key, m.get(key)]);
            // 对数组 B 的处理：应该是去找最小公约数，或是最小公共质因子 ？？？这后半部分思路不清楚，暂时不做了
        }
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        String [] a = new String [] {"102","473","251","814"};
        int [][] b = new int [][] {{1,1},{2,3},{4,2},{1,2}};

        int [] r = s.smallestTrimmedNumbers(a, b);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
