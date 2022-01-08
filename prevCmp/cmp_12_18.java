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

        // public String addSpaces(String t, int [] a) {
        //     int n = a.length, m = t.length(), i = 0, j = 0, idx = 0;
        //     char [] s = t.toCharArray();
        //     char [] ans = new char [m + n]; // 比赛的时候只有分配固定长度地址这一点儿没想到就不许过tle，太过分了
        //     while (idx < m + n) {
        //         while (j < n && i < m && i < a[j] || j == n && i < m) 
        //             ans[idx++] = s[i++];
        //         if (i < m && j < n && i == a[j]) {
        //             ans[idx++] = ' ';
        //             ans[idx++] = s[i++];
        //             j++;
        //         }
        //     }
        //     return new String(ans);
        // }

        // public long getDescentPeriods(int[] a) {
        //     int n = a.length, j = 0;
        //     long ans = 0;
        //     for (int i = 0; i < n-1; i++) {
        //         j = i + 1;
        //         if (a[j] != a[i]-1) continue;
        //         while (j < n && a[j] == a[j-1]-1) j++;
        //         ans += (long)(j-i) * (j-i-1) / 2;
        //         i = j-1;
        //     }
        //     return ans + n;
        // }

    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int [] a = new int [] {3, 2, 1, 4};

        long r = s.getDescentPeriods(a);
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
