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

        // public int minimumSum(int num) {
        //     String t = String.valueOf(num);
        //     char [] s = t.toCharArray();
        //     Arrays.sort(s);
        //     int va = 10 * (s[0] - '0') + (s[3]-'0');
        //     int vb = 10 * (s[1] - '0') + (s[2]-'0');
        //     return va + vb;
        // }

        // public int[] pivotArray(int[] a, int piv) {
        //     int n = a.length, i = 0;
        //     int [] ans = new int [n];
        //     for (int v : a) 
        //         if (v < piv) ans[i++] = v;
        //     for (int v : a) 
        //         if (v == piv) ans[i++] = v;
        //     for (int v : a) 
        //         if (v > piv) ans[i++] = v;
        //     return ans;
        // }

        // public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) { // 这题目出得太恶心人了。。。。。。
        //     this.startAt = startAt;
        //     this.moveCost = moveCost;
        //     this.pushCost = pushCost;
        //     int min = targetSeconds / 60, sec = targetSeconds % 60;
        //     String t = "" + min, tt = "" + sec;
        //     if (t.length() < 2) t = "0".repeat(2 - t.length()) + t;
        //     if (tt.length() < 2) tt = "0".repeat(2 - tt.length()) + tt;
        //     char [] s = t.toCharArray();
        //     char [] ss = tt.toCharArray();
        //     int ans = Integer.MAX_VALUE;
        //     if (s.length < 3)
        //         ans = getVal(s, ss);
        //     if (sec > 39 || min == 0) return ans;
        //     min -= 1;
        //     sec += 60;
        //     t = "" + min;
        //     tt = "" + sec;
        //     if (t.length() < 2) t = "0".repeat(2 - t.length()) + t;
        //     if (tt.length() < 2) tt = "0".repeat(2 - tt.length()) + tt;
        //     s = t.toCharArray();
        //     ss = tt.toCharArray();
        //     int tmp = getVal(s, ss);
        //     return Math.min(ans, tmp);
        // }
        // int startAt, moveCost, pushCost;
        // int getVal(char [] s, char [] ss) {
        //     boolean bgn = false;
        //     int ans = (s[0]-'0' == startAt ? 0 : (s[0] == '0' ? 0 : moveCost)) + (s[0] == '0' ? 0 : pushCost);
        //     if (s[0] != '0') bgn = true;
        //     ans += s[1] == '0' && !bgn ? 0 : (s[1] == s[0] ? pushCost : (s[1]-'0' == startAt && !bgn ? 0 : moveCost) + pushCost);
        //     if (!bgn && ans > 0) bgn = true;
        //     if (s.length > 2)
        //         ans += s[2] == '0' && !bgn ? 0 : (s[2] == s[1] ? pushCost : (s[2]-'0' == startAt && !bgn ? 0 : moveCost) + pushCost);
        //     if (ans > 0) bgn = true;
        //     ans += ss[0] == '0' && !bgn ? 0 : (ss[0] == s[1] ? pushCost : (ss[0]-'0' == startAt && !bgn ? 0 : moveCost) + pushCost);
        //     if (ans > 0) bgn = true;
        //     ans += ss[1] == '0' && !bgn ? 0 : (ss[1] == ss[0] ? pushCost : (!bgn && startAt == ss[1]-'0' ? 0 :  moveCost) + pushCost);
        //     return ans;
        // }

        public long minimumDifference(int[] a) {
            int n = a.length, m = n / 3;
            long sum = 0;
            for (int v : a) 
                sum += v;
            System.out.println("sum: " + sum);
            return 0;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int r = s.minCostSetTime(1, 1, 1, 1);
        // int r = s.minCostSetTime(5, 15, 20, 365);
        // int r = s.minCostSetTime(1, 6044, 6044, 81);
        // int r = s.minCostSetTime(1, 582, 965, 6022);
        int r = s.minCostSetTime(1, 9403, 9402, 6008);
        // int r = s.minCostSetTime(9, 100000, 1, 6039);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
