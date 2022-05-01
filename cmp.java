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

        // public String removeDigit(String t, char d) {
        //     String max = "", cur = "";
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] != d) continue;
        //         cur = (i == 0 ? t.substring(i+1) : t.substring(0, i) + (i == n-1 ? "" : t.substring(i+1)));
        //         if (max.equals("") || max.compareTo(cur) < 0) max = cur;
        //     }
        //     return max;
        // }

        // public int minimumCardPickup(int[] a) {
        //     int N = a.length, min = Integer.MAX_VALUE;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < N; i++) {
        //         int v = a[i];
        //         m.computeIfAbsent(v, z -> new ArrayList<>()).add(i);
        //     }
        //     for (List<Integer> l : m.values()) {
        //         int n = l.size(), cur = 0;
        //         if (n == 1) continue;
        //         for (int i = 1; i < n; i++) {
        //             cur = l.get(i) - l.get(i-1) + 1;
        //             if (cur < min) min = cur;
        //         }
        //     }
        //     return min == Integer.MAX_VALUE ? -1 : min;
        // }

        public int countDistinct(int[] nums, int k, int p) {
            return 0;
        }

        public long appealSum(String s) {
            
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        String a = "1231";

        String r = s.removeDigit(a, '1');
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
