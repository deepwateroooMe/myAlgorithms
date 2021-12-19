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

        // public String firstPalindrome(String[] sa) {
        //     for (String v : sa) 
        //         if (isPal(v)) return v;
        //     return "";
        // }
        // boolean isPal(String t) {
        //     int n = t.length(), i = 0, j = n-1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }

        // public long getDescentPeriods(int[] a) {
        //     int n = a.length, ans = 0;
        //     if (n == 1) return 1;
        //     ArrayDeque<Integer> s = new ArrayDeque<>(); // ---
        //     for (int i = 0; i < n; i++) {
        //          System.out.println("\n i: " + i);
                
        //         if (s.isEmpty() || !s.isEmpty() && a[i] == a[s.peekLast()] - 1) {
        //             s.offerLast(i);
        //             continue;
        //         }
        //         if (!s.isEmpty()) {
        //             int len = i - s.pollFirst();
                    
        //             ans += len * (len+1) / 2;
        //             s.clear();
        //         } else ans += 1;
        //          System.out.println("ans: " + ans);
                
        //         s.offerLast(i);
        //     }
        //     System.out.println("ans: " + ans);
            
        //     if (s.size() > 1) {
        //         int len = n - s.pollFirst();
        //         ans += len * (len+1) / 2;
        //     } else ans += 1;
        //     return ans;
        // }

        public String addSpaces(String t, int [] a) {
            int n = a.length, m = t.length();
            if (n == 0) return t;
            return addSpacesR(t, a, n-1);
            // StringBuilder sb = new StringBuilder(t);
            // for (int i = n-1; i >= 0; i--) 
            //     sb.insert(a[i], ' ');
            // return sb.toString();
        }
        String addSpacesR(String t, int [] a, int i) {
            if (i < 0) return t.substring(0, a[0]);
            return addSpacesR(t, a, i-1) + " " + t.substring(a[i], i == a.length-1 ? t.length() : a[i+1]);
        }
        // public int kIncreasing(int[] a, int k) {
        //     int n = a.length;
        // }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        String a = "icodeinpython";
        int [] b = new int [] {1, 5, 7, 9};

        String r = s.addSpaces(a, b);
        System.out.println("r: " + r);
    }
}

 // ListNode head = new ListNode(a[0]);
 // head.buildList(head, a);
 // head.printList(head);

 // ListNode r = s.deleteMiddle(head);
 // r.printList(r);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
        
 // String r = s.getDirections(root, 2, 1);
 // System.out.println("r: " + r);
