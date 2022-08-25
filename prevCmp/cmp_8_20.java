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

        // // 不只修改中间连续的一段，只修改一段连续的未必能够完成，可能需要修改几处连续才能够完成
        // public int minimumRecolors(String tt, int k) {
        //     int n = tt.length(), ans = -1, min = n;
        //     char [] s = tt.toCharArray();
        //     int [] pre = new int [n], suf = new int [n];
        //     pre[0] = (s[0] == 'B' ? 1 : 0);
        //     suf[n-1] = (s[n-1] == 'B' ? 1 : 0);
        //     for (int i = 1; i < n; i++) 
        //         if (s[i] == 'B') pre[i] = pre[i-1] + 1;
        //     for (int i = n-2; i >= 0; i--) 
        //         if (s[i] == 'B') suf[i] = suf[i+1] + 1;
        //     System.out.println(Arrays.toString(pre));
        //     System.out.println(Arrays.toString(suf));
        //     for (int i = 0; i < n; i++) {
        //         if (pre[i] + suf[i] - 1 >= k) return 0;
        //         if (s[i] == 'W') {
        //             int j = i+1;
        //             while (j < n && s[j] == 'W') j++;
        //             if (j < n && pre[i] + suf[j] + j - i - 1 >= k) {
        //                 int cur = j - i - 1;
        //                 if (cur < min) min = cur;
        //                 i = j;
        //                 continue;
        //             }
        //         }
        //     }
        //     return min;
        // }
        
        // public int secondsToRemoveOccurrences(String t) {
        //     n = t.length();
        //     int cnt = 0;
        //     char [] s = t.toCharArray();
        //     while (!noZeroOnes(s)) {
        //         for (int i = 0; i < n; i++) {
        //             if (i < n-1 && s[i] == '0' && s[i+1] == '1') {
        //                 s[i] = '1';
        //                 s[i+1] = '0';
        //                 i++;
        //                 continue;
        //             }
        //         }
        //         cnt++;
        //     }
        //     return cnt;
        // }
        // int n;
        // boolean noZeroOnes(char [] s) {
        //     for (int i = 0; i < n-1; i++) 
        //         if (i < n-1 && s[i] == '0' && s[i+1] == '1') return false;
        //     return true;
        // }

        // public String shiftingLetters(String t, int[][] a) { // TLE TLE TLE
        //     int n = t.length(), m = a.length;
        //     char [] s = t.toCharArray();
        //     int [] cnt = new int [n];
        //     for (int i = 0; i < m; i++) {
        //         // 这里range increase/decrease的情况，可以使用什么segment权 快速的变量:
        //         // 思路是有的，但是现在的电脑用不习惯，会晚点儿再把这个题目写完
        //         for (int j = a[i][0]; j <= a[i][1]; j++) {
        //             if (a[i][2] == 1) cnt[j]++;
        //             else cnt[j]--;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (char)('a' + (s[i]-'a' + 26 + cnt[i] % 26) % 26);
        //     return new String(s);
        // }

        public long[] maximumSegmentSum(int[] a int[] q) {
            int n = a.length, m = q.length, max = Integer.MAX_VALUE;
            int [] ans = new int [n];
// 这仍然显得有点儿笨，应该是有segtree可以从0处自动断开求和的
// 这里是想要记住前面最后一个0的下一个座位；后面第一个0的前一位坐标等，想得不是太清楚            
            int [] pre = new int [n], suf = new int [n];
            Arrays.fill(pre, -1);
            Arrays.fill(suf, -1);
            SumSeg seg = new SumSeg(a);
            for (int i = 0; i < m; i++) {
                int j = q[i];
                if (j == 0) pre[j] = 0;
                else if (j == 0) suf[j] = 0;
                else {
                    // 之前的最后一个0 的idx
                    if (pre[j-1] == -1) pre[j] = j-1;
                    else pre[j] = pre[j-1];
                    // 之后的第一个非零的idx
                    if (suf[j+1] == -1) suf[j] = j+1;
                    else suf[j] = suf[j+1];
                    seg.updateTreeNode(j, 0);
                    int l = seg.query()
                } 
            }
        }
        class SumSeg {
            // limit for array size
            int N = 100000; 
            int n; // array size
            // Max size of tree
            int []tree = new int[2 * N];
      
            // function to build the tree
            void build( int [] arr)  { 
          
                // insert leaf nodes in tree
                for (int i = 0; i < n; i++) 
                    tree[n + i] = arr[i];
          
                // build the tree by calculating
                // parents
                for (int i = n - 1; i > 0; --i) 
                    tree[i] = tree[i << 1] +
                        tree[i << 1 | 1]; 
            }
      
            // function to update a tree node
            void updateTreeNode(int p, int value)  { 
          
                // set value at position p
                tree[p + n] = value;
                p = p + n;
          
                // move upward and update parents
                for (int i = p; i > 1; i >>= 1)
                    tree[i >> 1] = tree[i] + tree[i^1];
            }
      
            // function to get sum on
            // interval [l, r)
            int query(int l, int r)  { 
                int res = 0;
          
                // loop to find the sum in the range
                for (l += n, r += n; l < r;
                     l >>= 1, r >>= 1) {
                    if ((l & 1) > 0) 
                        res += tree[l++];
          
                    if ((r & 1) > 0) 
                        res += tree[--r];
                }
          
                return res;
            }
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();
        String a = "abc";
        int [][] b = new int [][] {{0,1,0},{1,2,1},{0,2,1}};
        String r = s.shiftingLetters(a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
