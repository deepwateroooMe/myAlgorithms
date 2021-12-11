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

 // public int[] maxSubsequence(int[] a, int k) {
 //            n = a.length;
 //            if (k == n) return a;
 //            helper(0, 0, new ArrayList<>(), a, k);
 //            int [] res = new int [k];
 //            for (int i = 0; i < k; i++) 
 //                res[i] = ans.get(i);
 //            return res;
 //        }
 //        List<Integer> ans = new ArrayList<>();
 //        int max = Integer.MIN_VALUE, n;
 //        void helper(int idx, int sum, List<Integer> l, int [] a, int k) {
 //            if (l.size() > k) return ;
 //            if (l.size() == k && sum < max) return ;
 //            if (idx == n) {
 //                if (l.size() == k) 
 //                    if (sum > max) {
 //                        max = sum;
 //                        ans = new ArrayList<>(l);
 //                    }
 //                return ;
 //            }
 //            helper(idx+1, sum, l, a, k);
 //            // List<Integer> tmp = new ArrayList<>(l);
 //            // tmp.add(a[idx]);
 //            l.add(a[idx]);
 //            helper(idx+1, sum + a[idx], l, a, k);
 //            l.remove(l.size()-1);
 //        }

        // public List<Integer> goodDaysToRobBank(int[] a, int t) {
        //     int n = a.length;
        //     int [] up = new int [n], dn = new int [n];
        //     List<Integer> tmp = new ArrayList<>();
        //     // ArrayDeque<Integer> up = new ArrayDeque<>();
        //     // ArrayDeque<Integer> dn = new ArrayDeque<>();
        //     int j = 0;
        //     for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算
        //         for ( j = i-1; j >= 0; j--)
        //             if (a[j] >= a[j+1])
        //                 dn[i] = dn[i+1]
        //         //     if (a[j] < a[j+1]) break;
        //         // dn[i] = i - j-1;
        //     }
        //     for (int i = 0; i < n-1; i++) {
        //         if (a)
        //         for ( j = i+1; j < n; j++) 
        //             if (a[j] < a[j-1]) break;
        //         up[i] = j - i- 1;
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (up[i] >= t && dn[i] >= t) tmp.add(i);
        //     System.out.println(Arrays.toString(dn));
        //     System.out.println(Arrays.toString(up));
        //     return tmp;
        // public List<Integer> goodDaysToRobBank(int[] a, int t) {
        //         int n = a.length;
        //         int [] up = new int [n], dn = new int [n];
        //         List<Integer> tmp = new ArrayList<>();
        //         // ArrayDeque<Integer> up = new ArrayDeque<>();
        //         // ArrayDeque<Integer> dn = new ArrayDeque<>();
        //         int j = 0;
        //         for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算
        //             if (i > 0 && a[i] <= a[i-1])
        //                 dn[i] = dn[i-1] + 1;
        //         }
        //         // for (int i = 0; i < n-1; i++) { // 把它们换成动规的行式避免重复计算
        //         //     for ( j = i-1; j >= 0; j--)
        //         //         if (a[j] < a[j+1]) break;
        //         //     dn[i] = i - j-1;
        //         // }
        //         for (int i = n-2; i >= 0; i--) {
        //             if (a[i] <= a[i+1])
        //                 up[i] = up[i+1] + 1;
        //         }

        //         // for (int i = 0; i < n-1; i++) {
        //         //     for ( j = i+1; j < n; j++) 
        //         //         if (a[j] < a[j-1]) break;
        //         //     up[i] = j - i- 1;
        //         // }
        //         for (int i = 0; i < n; i++) 
        //             if (up[i] >= t && dn[i] >= t) tmp.add(i);
        //         System.out.println(Arrays.toString(dn));
        //         System.out.println(Arrays.toString(up));
        //         return tmp;
            
            // List<Integer> ans = new ArrayList<>();
            // if (n == 1) {
            //     if (t == 0) {
            //         ans.add(0);
            //         return ans;
            //     }
            //     return ans;
            // }
            // while (k < n-1 && a[k] < a[k+1]) k++;
            // while (j > 0 && a[j-1] > a[j]) j--;
            // while (k <= j) {
            //     System.out.println("\n k: " + k);
            //     i = k;
            //     cnt = 0;
            //     while (i < n-1 && a[i] >= a[i+1]) {
            //         i++;
            //         cnt++;
            //         if (cnt >= t && a[i] == a[i+1]) cb++;
            //     }
            //     System.out.println("i: " + i);
            //     can = i-1;
            //     // cb = (i > 0 && a[i] == a[i-1] ? cnt : 0);
            //     // cb = 0;
            //     while (i < n-1 && a[i] <= a[i+1]) {
            //         i++;
            //         cb++;
            //     }
            //     if (cnt >= t && cb >= t) ans.add(can);
            //     k++;
            // }
            // return ans;
        // }

        public int maximumDetonation(int[][] a) {
            int n = a.length, maxCnt = 0;
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j < n; j++) {
                    int [] p = a[i], c = a[j];
                    if ((long)Math.pow(p[0]-c[0], 2) + (long)Math.pow(p[1]-c[1], 2) < (long)Math.pow(p[2]+c[2], 2)) {
                        System.out.println("\n i: " + i);
                        System.out.println("j: " + j);
                        System.out.println(Arrays.toString(p));
                        System.out.println(Arrays.toString(c));
                        

                        m.computeIfAbsent(i, z -> new ArrayList<>()).add(j);
                        m.computeIfAbsent(j, z -> new ArrayList<>()).add(i);
                    }
                }
            System.out.println("m.size(): " + m.size());
            for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
                System.out.print(en.getKey() + ": ");
                System.out.println(Arrays.toString(en.getValue().toArray()));
            }
            
            for (int i = 0; i < n; i++) 
                maxCnt = Math.max(maxCnt, m.getOrDefault(i, new ArrayList<>()).size());
            if (maxCnt == n-1) return n;
            for (int i = 0; i < n; i++) 
                dfs(i, -1, 1);
            return max;
        }
        Map<Integer, List<Integer>> m = new HashMap<>();
        int max = 0;
        void dfs(int idx, int p, int cnt) {
            if (!m.containsKey(idx) || m.get(idx).size() == 1 && m.get(idx).get(0) == p) {
                if (cnt > max) max = cnt;
                return ;
            }
            for (Integer next : m.get(idx)) {
                if (next == p) continue;
                dfs(next, idx, cnt+1);
            }
        }


    }

    public static void main (String[] args) {
        Solution s = new Solution ();

        // int []  a = new int []  {-76, -694, 44, 197, 357, -833, -277, 358, 724, -585, -960, 214, 465, -593, -431, 625, -83, 58, -889, 31, 765, 8, -17, 476, 992, 803, 863, 242, 379, 561, 673, 526, -447};
        int [][] a = new int [][] {{54,95,4},{99,46,3},{29,21,3},{96,72,8},{49,43,3},{11,20,3},{2,57,1},{69,51,7},{97,1,10},{85,45,2},{38,47,1},{83,75,3},{65,59,3},{33,4,1},{32,10,2},{20,97,8},{35,37,3}};

      int r = s.maximumDetonation(a);
      System.out.println("r: " + r);
    }
}
// cmp s = new cmp (a);

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
