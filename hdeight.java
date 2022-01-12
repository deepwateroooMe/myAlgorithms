import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class hdeight {
    public static class Solution {

        // public double [] getCollisionTimes(int[][] a) {
        //     int n = a.length;
        //     double [] ans = new double [n];
        //     ArrayDeque<Integer> s = new ArrayDeque<>();
        //     Arrays.fill(ans, -1.0);
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!s.isEmpty()) {
        //             if (a[s.peekLast()][1] >= a[i][1] // 栈顶车速比当前车速快
        //                 // 栈顶车速慢，但当前车与栈顶车相遇前，栈顶车早已经与其它车合并过了
        //                 || (ans[s.peekLast()] > 0 && (double)(a[s.peekLast()][0] - a[i][0]) / (a[i][1] - a[s.peekLast()][1]) > ans[s.peekLast()]))
        //                 s.pollLast();
        //             else break;
        //         }
        //         if (!s.isEmpty())
        //             ans[i] = (double)(a[s.peekLast()][0] - a[i][0]) / (a[i][1] - a[s.peekLast()][1]);
        //         s.offerLast(i);
        //     }
        //     return ans;
        // }

        public int[] minInterval(int[][] intervals, int[] que) {
            int m = intervals.length, n = que.length;
            int [][] q = new int [n][2];
            for (int i = 0; i < n; i++) 
                q[i] = new int [] {i, que[i]};
            Arrays.sort(q, (x, y) -> x[1] - y[1]);
            Arrays.sort(intervals, (x, y) -> ); // 这里的排序，
            

            System.out.println("q.length: " + q.length);
            for (int z = 0; z < q.length; ++z) 
                System.out.println(Arrays.toString(q[z]));
            
            int [] ans = new int [n];
            
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{2,3},{2,5},{1,8},{20,25}};
        int [] b = new int [] {6,9,7,22};

        int [] r = s.minInterval(a, b);
        System.out.println(Arrays.toString(r));
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);