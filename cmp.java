import com.TreeNode;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
public class cmp {
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minQueenMoves(int[] a, int[] b) {
        //     if (a[0] == b[0] && a[1] == b[1]) return 0;
        //     if (a[0] == b[0] || a[1] == b[1]) return 1;
        //     if (Math.abs(a[0] - b[0]) == Math.abs(a[1] - b[1])) return 1;
        //     return 2;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 636/640 passed... 亲爱的表哥的活宝妹，看不懂 failed 掉的案例，是什么意思。。。
        // public boolean canTransform(int[] a, int[] b) {
        //     int n = a.length;
        //     if (b.length != n) return false;
        //     List<int []> l = new ArrayList<>();
        //     List<int []> ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == b[i]) continue;
        //         l.add(new int [] {a[i], b[i], i});
        //         ll.add(new int [] {a[i] - b[i], i});
        //     }
        //     // 按【Ai: 升序排列】方便 O(logN) 二分查找
        //     Collections.sort(l, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     Collections.sort(ll, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1])); // 按〇升序排列
        //     Arrays.sort(a);Arrays.sort(b);
        //     boolean valid = true;
        //     long r = 0l, rr = 0l;
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] != b[i]) //{
        //             valid = false;
        //             // break;
        //         // }
        //         r += (long)a[i];
        //         rr += (long)b[i];
        //     }
        //     if (valid) return true;
        //     if (r == rr) return true;
        //     int m = l.size();
        //     boolean [] f = new boolean [n];
        //     for (int i = 0; i < m; i++) {
        //         if (f[l.get(i)[2]]) continue;
        //         // if (a[i] > b[i]) return false;
        //         Comparator<int[]> arrayComparator = (x, y) -> Integer.compare(x[0], y[0]);
        //         int [] key = new int [] {b[i] - a[i], 0};
        //         int j = Collections.binarySearch(ll, key, arrayComparator);
        //         // System.out.println("i: " + i + " " + "j: " + j);
        //         System.out.println("l.get(i)[2]: " + l.get(i)[2] + " " + "j: " + j);
        //        if (j < 0) return false;
        //        while (j < m && f[ll.get(j)[1]]) j++;
        //         if (j == m) return false;
        //         f[ll.get(j)[1]] = true;
        //     }
        //     return true;
        // }
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 636/640 passed... 亲爱的表哥的活宝妹，看不懂 failed 掉的案例，是什么意思。。。
        public boolean canTransform(int[] a, int[] b) {
            int n = a.length;
            int [] f = new int [n];
            Arrays.fill(f, Integer.MIN_VALUE / 2);
            for (int i = 0; i < n-1; i++) {
                int v = (f[i] == Integer.MIN_VALUE / 2 ? a[i] : f[i]);
                if (v == b[i]) continue;
                f[i+1] = (int)((long)v + (long)a[i+1] - (long)b[i]);
                f[i] = v + a[i+1] - f[i+1];
            }
            System.out.println(Arrays.toString(f));
            return (f[n-1] == Integer.MIN_VALUE / 2 && a[n-1] == b[n-1] || f[n-1] == b[n-1]);
        }
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int []  a = new int []  {1000000000, 1000000000, 1000000000, 1000000000, 294967296};
        int [] b = new int [] {0,0,0,0,0};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        boolean r = s.canTransform(a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a0]);   
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】