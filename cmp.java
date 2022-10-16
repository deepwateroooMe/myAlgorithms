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

        // public int findMaxK(int[] a) {
        //     int n = a.length, max = -1;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     Set<Integer> p = new HashSet<>();
        //     for (var v : a) {
        //         p.add(Math.abs(v));
        //         if (s.contains(v) && s.contains(-v))
        //             max = Math.max(max, Math.abs(v));
        //     }
        //     return max;
        // }

        // public int countDistinctIntegers(int[] a) {
        //     int n = a.length, cur = 0;
        //     Set<Integer> s = new HashSet<>();
        //     for (var v : a) {
        //         s.add(v);
        //         s.add(getReverse(v));
        //     }
        //     return s.size();
        // }
        // int getReverse(int v) {
        //     String s = String.valueOf(v);
        //     String t = new StringBuilder(s).reverse().toString();
        //     return Integer.valueOf(t);
        // }

        // public boolean sumOfNumberAndReverse(int v) {
        // }

        public long countSubarrays(int[] a, int min, int max) {
            int n = a.length, l = 0, r = 0;
            long f = 0;
            // boolean visL = false, visR = false;
            int visL = 0, visR = 0;
            while (l < n && (a[l] < min || a[l] > max)) l++; // 先移左边界,到符合条件
            if (l == n) return 0;
            if (a[l] == min) visL = 1;
            if (a[l] == max) visR = 1;
            
            while (r < n) {
                System.out.println("\n r: " + r);
                if (a[r] >= min && a[r] <= max) {
                    // }
                    if (a[r] == min) visL++;
                    if (a[r] == max) visR++;
                    if (visL > 0 && visR > 0) {
                        int k = r+1;
                        while (k < n && a[k] >= min && a[k] <= max) {
                            if (a[r] == min) visL++;
                            if (a[r] == max) visR++;
                            k++;
                        }
                        System.out.println("k: " + k); 
                        f += (min != max ? k - r : (k - r) * (k-r+1) / 2l);
                        // if (k >= n-1) return f; // 这里不光是要右边界右移,也需要左边界左移
                        if (visL == 1 && visR == 1) {
                            visL = 0;
                            visR = 0;
                            l = k + 1;
                        }
                    } else {
                        r++;
                        System.out.println("f: " + f); 
                        continue;
                    }
                } 
                while (l < n && (a[l] < min || a[l] > max)) l++; // 先移左边界,到符合条件
                r = l + 1;
                System.out.println("f: " + f); 
            }
            if (r == n && l < n && visL && visR) f += n - l;
            return f;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [] a = new int [] {1,3,5,2,7,5};
        // int []  a = new int []  {1, 1, 1, 1};
        int []  a = new int []  {35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913};

        System.out.println(Arrays.toString(a));
        
        long r = s.countSubarrays(a, 35054, 945315);
        System.out.println("r final: " + r); 
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
