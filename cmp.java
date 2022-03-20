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

        // public int countHillValley(int[] a) {
        //     int n = a.length, cnt = 0;
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] == a[i-1]) continue;
        //         if (a[i] > a[i-1]) {
        //             int j = i+1;
        //             while (j < n && a[j] == a[i]) j++;
        //             if (j == n) return cnt;
        //             if (a[j] < a[i]) cnt++;
        //             i = j-1;
        //         } else { // a[i] < a[i-1]
        //             int j = i+1;
        //             while (j < n && a[j] == a[i]) j++;
        //             if (j == n) return cnt;
        //             if (a[j] > a[i]) cnt++;
        //             i = j-1;
        //         }
        //     }
        //     return cnt;
        // }

        public int[] longestRepeating(String t, String queryCharacters, int[] idx) { // 感觉思路想得是清淅的，可能想得还不是很彻底吧
            int n = t.length(), k = queryCharacters.length();
            char [] s = t.toCharArray();
            char [] q = queryCharacters.toCharArray();
            int [][] l = new int [n][26], r = new int [n][26];
            int [] ml = new int [n], mr = new int [n];
            l[0][s[0]-'a']++;
            ml[0] = 1;
            for (int i = 1; i < n; i++) {
                l[i][s[i]-'a'] = l[i-1][s[i]-'a'] + 1;
                ml[i] = Math.max(ml[i-1], l[i][s[i]-'a']);
            }
            r[n-1][s[n-1]-'a']++;
            mr[n-1] = 1;
            for (int i = n-2; i >= 0; i--) {
                r[i][s[i]-'a'] = 1 + r[i+1][s[i]-'a'];
                mr[i] = Math.max(mr[i+1], r[i][s[i]-'a']);
            }
            int [] ans = new int [k];
            for (int i = 0; i < k; i++) {
                System.out.println("\n i: " + i);
                char c = s[idx[i]];
                if (q[i] == c) { // 完全相同，没有变化
                    ans[i] = Math.max(ml[i], mr[i]);
                    continue;
                } // 接下来处理替换字母不同的情况：先 首尾两端
                if (idx[i] == 0 || idx[i] == n-1) { // 与前后不同 与前后相同的情况处理
                    if (idx[i] == 0 && q[i] != s[idx[i]+1]) {
                        ans[i] = mr[0];
                    } else if (idx[i] == 0 && q[i] == s[idx[i]+1]) {
                        ans[i] = Math.max(mr[0], ++r[0][q[i]-'a']);
                        if (r[0][q[i]-'a'] > mr[0]) mr[0] = r[0][q[i]-'a'];
                    }
                    else if (idx[i] == n-1 && q[i] != s[idx[i]-1]) ans[i] = ml[n-1];
                    else {
                        ans[i] = Math.max(ml[n-1], ++l[n-1][q[i]-'a']);
                        if (l[n-1][q[i]-'a'] > ml[n-1]) ml[n-1] = l[n-1][q[i]-'a'];
                    }
                    s[idx[i]] = q[i]; // 仍然需要更新
                    continue;
                }
                int j = idx[i];
                if (q[i] != s[j-1] && q[i] != s[j+1]) { // 两边都不等
                    s[j] = q[i]; // 仍然需要更新
                    l[j][s[j]-'a'] = 1; //l[j-1][s[j]-'a'] + 1;
                    r[j][s[j]-'a'] = 1; //r[j+1][s[j]-'a'] + 1;
                    ans[i] = Math.max(ml[j], mr[j]);
                } else if (q[i] == s[j-1] && q[i] == s[j+1]) { // 两边都等
                    if (ml[j] == l[j][s[j]-'a']) ml[j] = ml[j-1];
                    l[j][s[j]-'a'] = 0;
                    s[j] = q[i];
                    l[j][s[j]-'a'] = l[j-1][s[j]-'a'] + 1;
                    int x = j+1;
                    while (x < n && s[x] == s[j]) {
                        ++l[x][s[j]-'a'];
                        ml[x] = Math.max(ml[x-1], l[x][s[j]-'a']);
                        x++;
                    }
                    // while (x < n &&) // 这里仍然要对右边的ml最大值进行更新，这样就可能会超时
                    r[j][s[j]-'a'] = r[j+1][s[j]-'a'] + 1;
                    ml[j] = Math.max(ml[j-1], l[j][s[j]-'a']);
                    mr[j] = Math.max(mr[j+1], r[j][s[j]-'a']);
                    ans[i] = Math.max(Math.max(ml[j], mr[j]), l[j][s[j]-'a'] + r[j][s[j]-'a'] - 1);
                } else if (q[i] == s[j-1]) {
                    s[j] = q[i]; // 仍然需要更新
                    l[j][s[j]-'a'] = l[j-1][s[j]-'a'] + 1;
                    r[j][s[j]-'a'] = 1; //r[j+1][s[j]-'a'] + 1;
                    ml[j] = Math.max(ml[j-1], l[j][s[j]-'a']);
                    ans[i] = Math.max(ml[j], mr[j]);
                } else {
                    s[j] = q[i];
                    l[j][s[j]-'a'] = 1;
                    r[j][s[j]-'a'] = r[j+1][s[j]-'a'] + 1;
                    mr[j] = Math.max(mr[j+1], r[j][s[j]-'a']);
                    ans[i] = Math.max(mr[j], ml[j]);
                }
                System.out.println("l.length: " + l.length);
                for (int z = 0; z < l.length; ++z) 
                    System.out.println(Arrays.toString(l[z]));
                System.out.println("r.length: " + r.length);
                for (int z = 0; z < r.length; ++z) 
                    System.out.println(Arrays.toString(r[z]));
                System.out.println(Arrays.toString(ml));
                System.out.println(Arrays.toString(mr));
            }
            return ans;
        }

        // 1. 从左至右循环一遍字符串，如果当前字符为”.”，记录下他与左边最近的R的距离：（i-RIndex），如果左边还没出现过R，那么距离设为无穷大。如果当前字符为R，记住当前R的下标（ RIndex = i）。如果当前字符为L，更新 RIndex 为无穷大。
        // 2.同理从右至左循环一遍字符串，记录下”.”与右方最近的L的距离。
        // 3.最后再循环一遍字符串，如果当前字符为L或者R，直接加入返回结果。如果当前字符是”.”，查看其距左方的R的距离以及距右方L的距离，如果左方的距离小，将R加入返回结果，反之将L加入返回结果。
        public String pushDominoes(String d) { // todo: multi source BFS, queue<Integer> etc 需要再总结一下
            int n = d.length(), dist = Integer.MAX_VALUE;
            char [] s = d.toCharArray();
            int [] l = new int [n]; // dist pushing to the left, traverse from right to left
            int [] r = new int [n]; // dist pushing to the right, traverse from left to right
            Arrays.fill(l, Integer.MAX_VALUE);
            Arrays.fill(r, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) // pushing to right, fill r[]
                if (s[i] == '.' && dist != Integer.MAX_VALUE)
                    r[i] = i - dist;
                else if (s[i] == 'R')
                    dist = i;
                else dist = Integer.MAX_VALUE;
            dist = Integer.MAX_VALUE;
            for (int i = n-1; i >= 0; i--) // pushing to left, fill l[]
                if (s[i] == '.' && dist != Integer.MAX_VALUE)
                    l[i] = dist - i;
                else if (s[i] == 'L')
                    dist = i;
                else dist = Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s[i] == 'L' || s[i] == 'R') // 它们的状态无法改变，只要记下来就可以了
                    sb.append(s[i]);
                else {
                    if (r[i] < l[i]) sb.append('R'); // 距离它最近的倒下方向是向右，所以它也会倒向右边
                    else if (r[i] == l[i]) sb.append('.');
                    else sb.append('L');
                }
            }
            return sb.toString();
        }
        public int countCollisions(String t) {
            int n = t.length();
            char [] s = t.toCharArray();
            int [] l = new int [n], r = new int [n];
            // left: from right to left
            l[n-1] = s[n-1] == 'L' ? 1 : 0;
            for (int i = n-2; i >= 0; i--) {
                if (s[i] == 'L') l[i] = 1 + l[i+1];
                else l[i] = 0;
            }
            r[0] = s[0] == 'R' ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (s[i] == 'R') r[i] = 1 + r[i-1];
                else r[i] = 0;
            }
            return 0;
        }

        // 很久没有写算法题，居然连bitmask也会忘记了。。。。。。
        public int[] maximumBobPoints(int numArrows, int[] a) { // 这个应该是动态规划的题吧：现在对动态规划的题有点儿陌生了。。。。。。
            int n = a.length;
            int [] b = new int [n];
            for (int i = 0; i < n; i++) 
                b[i] = a[i] + 1;
            int max = 0, mmask = 0, sum = 0, cur = 0;
            for (int i = 1; i < (1 << n); i++) {
                sum = 0;
                cur = 0; // maxScore
                for (int j = 1; j < n; j++) { // 遍历b[j]
                    if (((i >> j) & 1) == 1) {
                        sum += b[j];
                        cur += j;
                    }
                }
                if (sum > numArrows) continue;
                if (cur > max) {
                    max = cur;
                    mmask = i;
                }
            }
            int [] ans = new int [n];
            // for (int i = n-1; i >= 0; i--) {
            //     if (cnt >= a[i]+1) {
            //         ans[i] = a[i]+1;
            //         max += i; // 这不是全局最优解，是可以折分成更小的的
            //         cnt -= a[i]+1;
            //     }
            // }
            for (int i = 0; i < n; i++) 
                if (((mmask >> i) & 1) == 0) 
                    b[i] = 0;
            b[0] = numArrows - Arrays.stream(b).sum();
            return b;
        }


    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // String a = "babacc";
        // String b = "bcb";
        // int [] c = new int [] {1, 3, 3};

        // int [] a = new int [] {1,1,0,1,0,0,2,1,0,1,2,0};
        int []  a = new int []  {3, 2, 28, 1, 7, 1, 16, 7, 3, 13, 3, 5};

        int [] r = s.maximumBobPoints(89, a);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
