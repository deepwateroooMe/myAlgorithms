import com.ListNode;

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
        
        // public boolean checkAlmostEquivalent(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int [] one = new int [26];
        //     int [] two = new int [26];
        //     for (int i = 0; i < m; i++) 
        //         one[s[i]-'a']++;
        //     for (int i = 0; i < n; i++) 
        //         two[t[i]-'a']++;
        //     for (int i = 0; i < 26; i++) 
        //         if (Math.abs(one[i] - two[i]) > 3) return false;
        //     return true;
        // }

        // public int[] maximumBeauty(int[][] it, int[] que) {
        //     int n = it.length, m = que.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         l.add(new int [] {i, que[i]});
        //     Collections.sort(l, (a, b)->a[1] - b[1]);
        //     Arrays.sort(it, (a, b) -> a[0] - b[0]);
        //     Queue<int []> q = new PriorityQueue<>((a, b)->b[1] - a[1]);
        //     int [] ans = new int [m];
        //     int idx = 0;
        //     for (int i = 0; i < m; i++) { // l
        //         int p = l.get(i)[1];
        //         while (idx < n && it[idx][0] <= p) {
        //             q.offer(it[idx]);
        //             idx++;
        //         }
        //         if (!q.isEmpty()) ans[l.get(i)[0]] = q.peek()[1];
        //     }
        //     return ans;
        // }

    // int [][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // tle 
    // int m, n, x, y, g;
    //     int [][] a;
    //     public Robot(int width, int height) {
    //     // public cmp(int width, int height) {
    //         this.m = height;
    //         this.n = width;
    //         a = new int [m][n];
    //         this.x = m-1;
    //         this.y = 0;
    //         this.g = 0;
    //     }
    
    // public void move(int num) {
    //     num %= (2 * n + 2 * m - 4);
    //     int cnt = 0;
    //     int i = 0, j = 0;
    //     i = x + dirs[g][0];
    //     j = y + dirs[g][1];
    //     if  (i < 0 || i >= m || j < 0 || j >= n) {
    //         while (i < 0 || i >= m || j < 0 || j>= n) {
    //             g = (g + 1) % 4;
    //             i = x + dirs[g][0];
    //             j = y + dirs[g][1];
    //         }
    //         x = i;
    //         y = j;
    //         cnt++; // 1
    //     } 
    //     while (cnt < num) {
    //         i = x + dirs[g][0];
    //         j = y + dirs[g][1];
    //         if  (i < 0 || i >= m || j < 0 || j>= n) {
    //             while (i < 0 || i >= m || j < 0 || j>= n) {
    //                 g = (g + 1) % 4;
    //                 i = x + dirs[g][0];
    //                 j = y + dirs[g][1];
    //             }
    //             x = i;
    //             y = j;
    //             cnt++;
    //         } else {
    //             cnt ++;
    //             x = i;
    //             y = j;
    //         }
    //     }
    //     x = i;
    //     y = j;
    // }
    // public int[] getPos() {
    //     return new int [] {y, m-1 - x};
    // }
    // public String getDir() {
    //     return g == 0 ? "East" : (g == 1 ? "North" : (g == 2 ? "West" : "South"));
    // }

        public int maxTaskAssign(int[] t, int[] w, int p, int s) {
            int n = t.length, m = w.length, ans = 0;
            Arrays.sort(t);
            Arrays.sort(w);
            System.out.println(Arrays.toString(t));
            System.out.println(Arrays.toString(w));
            int bgn = 0, end = n-1, i = 0, j = m-1;
            while (end >= 0 && t[end] > w[j] + (p > 0 ? s : 0)) end--;
            while (bgn < m && w[bgn] + (p > 0 ? s : 0) < t[i]) bgn++;
            // int i = 0, j = 0;
            j = bgn;
            System.out.println("end: " + end);
            System.out.println("j: " + j);

            while (i < end && j < m) {
                if (w[j] >= t[i] || (p > 0 && w[j] + s >= t[i])) {
                    ans++;
                    if (w[j] < t[i]) p--; // 什么时候用药丸，有一种选择和策略在里面
                    i++;
                    j++;
                }
                while (j < m && (p == 0 && t[i] > w[j] || p > 0 && t[i] > w[j] + s)) j++;
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {5, 9, 8, 5, 9};
        int []  b = new int []  {1, 6, 4, 2, 6};

        int  r = s.maxTaskAssign(a, b, 1, 5);
        System.out.println("r: " + r);
       
    //     cmp s = new cmp(6, 3); // Initialize the grid and the robot at (0, 0) facing East.
    //     s.move(2);  // It moves two steps East to (2, 0), and faces East.
    //     s.move(2);  // It moves two steps East to (4, 0), and faces East.
    //     int [] r =        s.getPos(); // return [4, 0]
    //     System.out.println(Arrays.toString(r));

    //  String str =   s.getDir(); // return "East"
    //  System.out.println("str: " + str);
     
    //     s.move(2);  // It moves one step East to (5, 0), and faces East.
    //     // Moving the next step East would be out of bounds, so it turns and faces North.
    //     // Then, it moves one step North to (5, 1), and faces North.
    //     s.move(1);  // It moves one step North to (5, 2), and faces North (not West).
    //     s.move(4);  // Moving the next step North would be out of bounds, so it turns and faces West.
    //     // Then, it moves four steps West to (1, 2), and faces West.
    //   int [] b =  s.getPos(); // return [1, 2]
    //   System.out.println(Arrays.toString(b));
      
    //     s.getDir(); // return "West"
    // }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
