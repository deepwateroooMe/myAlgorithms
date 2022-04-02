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

        public int minBitFlips(int start, int goal) {
            String sb = Integer.toBinaryString(start);
            String se = Integer.toBinaryString(goal);
            return cntDiff(sb, se);
        }
        int cntDiff(String ss, String tt) {
            int m = ss.length(), n = tt.length();
            if (m < n) 
                ss = "0".repeat(n-m) + ss;
            else if (m > n)
                tt = "0".repeat(m-n) + tt;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            int cnt = 0;
            for (int i = 0; i < Math.max(m, n); i++) 
                if (s[i] != t[i]) cnt++;
            return cnt;
        }

        public int triangularSum(int[] a) {
            int n = a.length, idx = 0, m = n-1;
            if (n == 1) return a[0];
            int [] cur = new int [m];
            System.out.println(Arrays.toString(a));
            while (m >= 1) {
                System.out.println("\n m: " + m);
                idx = 0;
                while (idx < m) {
                    cur[idx] = (a[idx] + a[idx+1]) % 10;
                    idx++;
                }
                System.arraycopy(cur, 0, a, 0, m);
                --m;
            }
            return cur[0];
        }

        public long numberOfWays(String t) { // 010 + 101: 分这两种情况来考虑
            int n = t.length();
            long ans = 0;
            if (n < 3) return 0;
            char [] s = t.toCharArray();
            // if (s[0] == s[n-1] && t.chars().distinct().count() == 1) return 0; // 把下面的思路理清楚后，就不用太专注于这种特殊情况了，特殊处理会浪费时间
            // if (s[0] != s[n-1]) {
            //     int i = 1, j = n-2;
            //     while (i < n && s[i] == s[i-1]) i++;
            //     while (j >= i && s[j] == s[j+1]) j--;
            //     if (j == i-1) return 0;
            // }
            // 010: 从右往左娄和，统计当前坐标及其之后0 和 1 的个数
            long [] one = new long [n], zoo = new long [n];
            long cone = 0, czoo = s[n-1] == '0' ? 1 : 0;
            zoo[n-1] = czoo;
            for (int i = n-2; i >= 0; i--) {
                if (s[i] == '0') {
                    zoo[i] = ++czoo;
                    one[i] = one[i+1];
                } else {
                    one[i] = one[i+1] + zoo[i+1];
                    zoo[i] = zoo[i+1];
                }
            }
            for (int i = 0; i < n-2; i++) 
                if (s[i] == '0' && one[i] > 0) ans += one[i];
// 101:
            Arrays.fill(one, 0);
            Arrays.fill(zoo, 0);
            cone = s[n-1] == '1' ? 1 : 0;
            czoo = 0;
            one[n-1] = cone;
            for (int i = n-2; i >= 0; i--) {
                if (s[i] == '1') {
                    one[i] = ++cone;
                    zoo[i] = zoo[i+1];
                } else { // 0
                    zoo[i] = zoo[i+1] + one[i+1];
                    one[i] = one[i+1];
                }
            }
            for (int i = 0; i < n-2; i++) 
                if (s[i] == '1' && zoo[i] > 0) ans += zoo[i];
            return ans;
        }

        public long sumScores(String t) { // 这里面有个什么longest prefix sum, longest suffix sum之类的提速算法在里面，要好好考虑一下
            n = t.length();
            s = t.toCharArray();
            long ans = 0;
            for (int i = n-1; i >= 0; i--) {
                if (s[i] != s[0]) continue;
                
            }

            return 0;
        }
        char [] s;
        int n;
        int [] getIdxLongestSuffix() {
            int [] lps = new int [n];
            return lps;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        String a = "001101";

        long r = s.numberOfWays(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
