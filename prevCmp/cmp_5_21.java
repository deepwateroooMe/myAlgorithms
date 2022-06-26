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

public class cmp { // 不喜欢今天的题目，去做自己的项目吧；will NOT attend next next long weekend due to long trip driving during long weekend.........
    public static class Solution {

        // public int percentageLetter(String s, char letter) {
        //     int n = s.length(), cnt = 0;
        //     for (char c : s.toCharArray()) 
        //         if (c == letter) cnt++;
        //     return (int)Math.floor((float) 100.0 * cnt / n);
        // }

        // public int maximumBags(int[] max, int[] cur, int more) {
        //     int cnt = 0;
        //     int n = max.length;
        //     Integer [] dif = new Integer [n];
        //     for (int i = 0; i < n; i++) {
        //         if (cur[i] == max[i]) cnt++;
        //         dif[i] = (Integer)(max[i] - cur[i]);
        //     }
        //     if (cnt == n) return n;
        //     Arrays.sort(dif);
        //     int i = 0;
        //     while (i < n && dif[i] == 0) i++;
        //     while (i < n && more >= 0) {
        //         if (dif[i] > 0 && more < dif[i]) return cnt;
        //         more -= dif[i];
        //         cnt++;
        //         i++;
        //     }
        //     return cnt;
        // }

        // public int minimumLines(int[][] a) { // 这里面好像是有个精度问题，暂时不写这个题了。。。。。
        //     int n = a.length, cnt = 1;
        //     if (n == 1) return 0;
        //     Arrays.sort(a, (x, y)-> x[0] - y[0]); // 时间上的升序排列
        //     double pre = Integer.MAX_VALUE, cur = Integer.MAX_VALUE;
        //     for (int i = 1; i < n; i++) {
        //         if (i >= 2) pre = cur;
        //         cur = getAngle(a[i-1], a[i]);
        //         if (i >= 2 && cur != pre) cnt++;
        //         // if (i == 1) cnt = 1;
        //     }
        //     return cnt;
        // }
        // float getAngle(int [] a, int [] b) {
        //     return (b[1] - a[1]) / (b[0] - a[0]);
        // }
        // int getAngle(int [] a, int [] b) {
        //     int dx = Math.abs(a[0] - b[0]);
        //     int dy = Math.abs(a[1] - b[1]);
        //     double dz = Math.sqrt(dx * dx + dy * dy);
        //     int angle = Math.round((float)(Math.asin(dy / dz) / Math.PI * 180));
        //     return angle;
        // }

        static final int mod = (int)1e9 + 7;
        public int totalStrength(int[] a) {
            int n = a.length, ans = 0; // [1, 100,000]
            for (int v : a) // subLength = 1; [2, n] tle tle tle
                ans = (ans + getPPAftMod(v)) % mod;
            long [] s = new long [n]; // prefix sum
            s[0] = a[0];
            for (int i = 1; i < n; i++) 
                s[i] = s[i-1] + a[i];
            // N = 100000, 只能用 O(NlogN) 的解法，应该是需要用一个 Stack or ArrayDeque 之类的数据结构来简化，可是这里还是有点儿没想透，需要再总结一下
            // 午休睡着过后的黄金时间，我还是去看自己的项目比较好，对今天的题目木有兴趣。。。。。。
        }
        int getPPAftMod(int v) {
            return (long)(v * v) % mod;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{83,35},{79,51},{61,48},{54,87},{44,93},{22,5},{87,28},{64,8},{89,78},{62,83},{58,72},{48,7},{97,16},{27,100},{65,48},{11,31},{29,76},{93,29},{72,59},{73,74},{9,90},{66,81},{12,8},{86,80},{84,43},{36,63},{80,45},{81,88},{95,5},{40,59}};
        
        int r = s.minimumLines(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
