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

        // 不是每一天的脑袋都会清醒,但是会记住亲爱的表哥提醒过的期待:不管是好的一天,不好的一天,坚持每天尽到最大的努力都会有所收获.所以要坚持,要加油.....
        // public char repeatedCharacter(String s) {
        //     int [] cnt = new int [26];
        //     for (char c : s.toCharArray()) {
        //         cnt[c-'a']++;
        //         if (cnt[c-'a'] == 2)
        //             return c;
        //     }
        //     return 'a';
        // }

        // public int equalPairs(int[][] a) {
        //     n = a.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (isSame(i, j, a))
        //                 cnt++;
        //     return cnt;
        // }
        // int n;
        // boolean isSame(int i, int j, int [][] a) {
        //     for (int k = 0; k < n; k++) 
        //         if (a[i][k] != a[k][j]) return false;
        //     return true;
        // }

    // class P implements Comparable {
    //     String v;
    //     int r;
    //     public P(String v, int r) {
    //         this.v = v;
    //         this.r = r;
    //     }
    //     @Override // 这里昨时报佛脚,从网上搜的,可是还是有点儿迷迷糊糊.......
    //         // public int compareTo(P tmp) {
    //         public int compareTo(Object o) {
    //         return 0;
    //         // return this.r != tmp.r ? tmp.r - this.r : this.v.compareTo(tmp.v);
    //     }
    // }
    // Map<String, Queue<P>> m;
    // Map<String, P> s = new HashMap<>();
    // Map<String, P> ref = new HashMap<>();
    // public FoodRatings(String[] f, String[] c, int[] r) {
    //     m = new HashMap<>();
    //     int n = f.length;
    //     for (int i = 0; i < n; i++) {
    //         if (!m.containsKey(c[i])) {
    //             m.put(c[i], new PriorityQueue<P>((x, y) -> x.r != y.r ? y.r - x.r : x.v.compareTo(y.v)));
    //         }
    //         P tmp = new P(f[i], r[i]);
    //         ref.put(f[i], tmp);
    //         m.get(c[i]).offer(tmp);
    //         s.put(f[i], new P(c[i], r[i]));
    //     }
    // }
    // public void changeRating(String food, int newRating) {
    //     String ci = s.get(food).v;
    //     boolean tp = m.get(ci).remove(ref.get(food));
    //     System.out.println("tp: " + tp);
    //     ref.remove(food);
    //     // boolean tmp = m.get(ci).remove(new P(food, s.get(food).r));
    //     // System.out.println("tmp: " + tmp);
    //     P tmp = new P(food, newRating);
    //     ref.put(food, tmp);
    //     m.get(ci).offer(tmp);
    //     s.put(food, new P(ci, newRating));
    // }
    // public String highestRated(String cuisine) {
    //     return m.get(cuisine).peek().v;
    // }

        public long countExcellentPairs(int[] a, int k) {
            int n = a.length; // [1, 100000] 必须要至少找到一个O(NlogN)的解法,感觉还是没有思路

        }        
    }
    public static void main(String args[]) { 
        Solution s = new Solution();

        int r = s.(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
