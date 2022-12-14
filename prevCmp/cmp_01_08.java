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

        public String capitalizeTitle(String title) {
            String [] tmp = title.split(" ");
            char [] ans =  new char [title.length()];
            int idx = 0;
            for (int i = 0; i < tmp.length; i++) {
                String s = tmp[i];
                if (s.length() < 3)
                    for (char c : s.toCharArray()) 
                        ans[idx++] = Character.toLowerCase(c);
                else {
                    ans[idx++] = Character.toUpperCase(s.charAt(0));
                    for (int j = 1; j < s.length(); j++) 
                        ans[idx++] = Character.toLowerCase(s.charAt(j));
                }
                if (i < tmp.length-1) ans[idx++] = ' ';
            }
            return new String(ans);
        }

        public int pairSum(ListNode head) {
            int n = 0, idx = 0, max = 0, i = 0, j;
            ListNode r = head;
            while (r != null) {
                n++;
                r = r.next;
            }
            int [] a = new int [n];
            r = head;
            while (r != null) {
                a[idx++] = r.val;
                r = r.next;
            }
            j = n-1;
            while (i < j) {
                max = Math.max(a[i] + a[j], max);
                i++;
                j--;
            }
            return max;
        }

        public int longestPalindrome(String[] sa) { // 题目没有注明，是需要考虑是否含有重复的: cc cl cc
            Map<String, Integer> m = new HashMap<>();
            Set<String> ss = new HashSet<>();
            for (String s : sa) {
                m.put(s, m.getOrDefault(s, 0) + 1);
                ss.add(s);
            }
            int ans = 0, max = 0;
            for (String k : m.keySet()) {
                if (!ss.contains(k)) continue;
                if (isPalindrome(k)) {
                    ans += 4 * (m.get(k) / 2);
                    max = Math.max(max, 2 * (m.get(k) % 2));
                    continue;
                }
                String re = new StringBuilder (k).reverse().toString();
                if (m.containsKey(re)) {
                    ans += 4 * Math.min(m.get(k), m.get(re));
                    ss.remove(re);
                }
                ss.remove(k);
            }
            return ans + max;
        }
        boolean isPalindrome(String t) {
            int n = t.length(), i = 0, j = n-1;
            char [] s = t.toCharArray();
            while (i < j) 
                if (s[i++] != s[j--]) return false;
            return true;
        }

        int getCnt(char [] s, char [] t, int idx) { // 数这个是干什么用的呢？
            int cnt = 0;
            for (int i = idx; i < idx + s.length; i++) {
                if (t[i] == '*') continue;
                t[i] = '*';
                cnt++;
            }
            return cnt;
        }
        boolean canReplace(char [] s, char [] t, int idx) { // s[0, m-1] t[idx, idx+m-1]在t[i] !='*'的前提下是否一致
            for (int i = idx; i < s.length + idx; i++) 
                if (t[i] != '*' && t[i] != s[i-idx]) return false; // 这个序列的章不能盖上去
            return true;
        }
        public int[] movesToStamp(String ss, String tt) { // todo: 这里还有一点儿没有想明白
            int m = ss.length(), n = tt.length(), cnt = 0;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            List<Integer> l = new ArrayList<>();
            boolean [] vis = new boolean [n];
            while (cnt < n) { // 对于序列 t 来说，最多只能更改n次？
                boolean done = false;
                for (int i = 0; i <= n-m && cnt < n; i++) { // 从前往后、从头向尾遍历
                    if (!vis[i] && canReplace(s, t, i)) {
                        done = true;
                        vis[i] = true;
                        cnt += getCnt(s, t, i);
                        l.add(i);
                    }
                }
                if (!done) return new int [0];
            }
            int [] ans = new int [l.size()];
            int idx = 0;
            for (int i = l.size()-1; i >= 0; i--) // 真正答案的顺序要从尾向头开始盖章
                ans[idx++] = l.get(i);
            return ans;
        }
        // 上面一维的是那种解法，但升级到二维数组，就应该有更高效的解法，而不是直接套用上面的，并升级到二维,会TLE
        public boolean possibleToStamp(int[][] a, int r, int c) { // TLE TLE TLE r: stampHeight c: stampWidth  tle TLE TLE
            m = a.length;
            n = a[0].length;
            int cnt = 0, i = 0, j = 0, sum = 0;
            for (int [] v : a) 
                sum += Arrays.stream(v).sum();
            boolean [][] vis = new boolean [m][n];
            while (cnt < m * n-sum) {
                boolean done = false;
                for ( i = 0; i+r <= m && cnt < m*n-sum; i++) 
                    for ( j = 0; j+c <= n && cnt < m*n-sum; j++) {
                        if (a[i][j] == 1 || vis[i][j]) continue;
                        if (!vis[i][j] && canReplace(i, j, a, r, c)) {
                            done = true;
                            vis[i][j] = true;
                            cnt += getCnt(i, j, a, r, c);
                        }
                    }
                if (!done) return false;
            }
            return true;
        }
        int m, n;
        int getCnt(int ii, int jj, int [][] a, int r, int c) {
            int cnt = 0;
            for (int i = ii; i < ii+r; i++) 
                for (int j = jj; j < jj+c; j++) {
                    if (a[i][j] == -1) continue;
                    a[i][j] = -1;
                    cnt++;
                }
            return cnt;
        }
        boolean canReplace(int ii, int jj, int [][] a, int r, int c) {
            if (ii + r > m || jj + c > n) return false;
            for (int i = ii; i < ii+r; i++) 
                for (int j = jj; j < jj+c; j++) 
                    if (a[i][j] == 1) return false;
            return true;
        }
        public boolean possibleToStamp(int[][] a, int r, int c) { // prefix sum ups and downs, 从上往下、从左往右贴邮票，贴过了就直接pass扫过的宽度
            int m = a.length, n = a[0].length;
            int u [][] = new int [m][n], d [][] = new int [m][n]; // preSum Up Down of 0s
            for (int j = 0; j < n; j++) {
                u[0][j] = 1 - a[0][j];
                for (int i = 1; i < m; i++)
                    if (a[i][j] == 1) u[i][j] = 0;
                    else u[i][j] = u[i-1][j] + 1;
            }
            for (int j = 0; j < n; j++) {
                d[m-1][j] = 1 - a[m-1][j];
                for (int i = m-2; i >= 0; i--)
                    if (a[i][j] == 1) d[i][j] = 0;
                    else d[i][j] = d[i+1][j] + 1;
            }
            boolean [][] vis = new boolean [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 1 || vis[i][j]) continue; // 以每一个当前是0的位置，进行检测
                    int up = Integer.MAX_VALUE, dn = Integer.MAX_VALUE, end = j;
                    for (int k = j; k < n && a[i][k] != 1; k++) { // 向右、向上、向下扩展，寻找一个可以cover住当前位置的合理邮票 
                        vis[i][k] = true;
                        end = k;
                        up = Math.min(u[i][k], up);
                        dn = Math.min(d[i][k], dn);
                    }
                    int w = end - j + 1, h = up + dn - 1;
                    if (w < c || h < r) return false;
                }
            return true;
        }
        
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        boolean r = s.possibleToStamp(a, 4, 3);
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
