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

        public boolean divideArray(int[] a) {
            int n = 501;
            int [] cnt = new int [n];
            for (int v : a) 
                cnt[v]++;
            for (int i = 1; i < n; i++) 
                if (cnt[i] % 2 != 0) return false;
            return true;
        }

        public int halveArray(int[] a) {
            int n = a.length, cnt = 0;
            Arrays.sort(a);
            long sum = 0;
            Queue<Double> q = new PriorityQueue<>((x, y)->Double.compare(y, x));
            for (int v : a) {
                sum += v;
                q.offer((double)v);
            }
            double cur = (double)sum;
            System.out.println("sum: " + sum);
            while (cur > (double)sum / 2.0) {
                double top = q.poll();
                cur -= top / 2.0;
                q.offer(top / 2.0);
                cnt++;
            }
            return cnt;
        }

        public long maximumSubsequenceCount(String text, String t) { 
            text = " " + text + " ";
            int n = text.length();
            char [] s = t.toCharArray();
            char [] ti = text.toCharArray();
            int [] ca = new int [n], cb = new int [n];
            for (int i = 0; i < n; i++) {    // 从前往后数第一个字母出现的次数
                if (ti[i] == s[0]) ca[i] = (i == 0 ? 1 : ca[i-1] + 1);
                else ca[i] = (i == 0 ? 0 : ca[i-1]);
            }
            for (int i = n-1; i >= 0; i--) { // 从后往前数第二个字母出现的次数
                if (ti[i] == s[1]) cb[i] = (i == n-1 ? 1 : cb[i+1] + 1);
                else cb[i] = (i == n-1 ? 0 : cb[i+1]);
            }
            long ans = 0, cur = 0;
            for (int i = 0; i < n; i++) 
                if (ti[i] == s[0]) cur += s[0] != s[1] ? (long)cb[i] : (long)cb[i]-1;
            ans = cur;
            for (int i = 0; i < n-1; i++) { // 在当前字母的后面加一个字母
                // 添加a：填加cb[i]个；添加b：填加ca[i]个；
                long v = Math.max(cb[i], ca[i]);
                ans = Math.max(ans, cur + v);
            }
            return ans;
        }

        // public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) { // BUG 思路不通：需要用 dp ?
        //     int n = floor.length();
        //     List<List<Integer>> [] len = new List[n];
        //     for (int i = 0; i < n; i++) 
        //         len.add(new ArrayList<>());
        //     // Queue<List<Integer>> q = new PriorityQueue<>((x, y) -> );
        //     char [] s = floor.toCharArray();
        //     int [] cnt = new int [n];
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s[i] == '0') {
        //             cnt[i] = (i == n-1 ? 0 : cnt[i+1]);
        //             if (i < n-1)
        //                 len[i].addAll(len[i+1]);
        //         } else {
        //             cnt[i] = (i == n-1 ? 1 : cnt[i+1] + 1);
        //             if (i < n-1)
        //                 len[i].addAll(len[i+1]);
        //             len[i].add(0, i);
        //         }
        //     }
        //     if (numCarpets * carpetLen >= n) return 0; // 关于重复的部分：想不透
        //     System.out.println(Arrays.toString(cnt));
        //     // int [][] ct = new int [n][n];
        //     int max = 0, maxIdx = -1, ct = 0;
        //     boolean [] vis = new boolean [n];
        //     while (ct < numCarpets) {
        //         for (int v : cnt) {
        //             if (v <= carpetLen) {
        //                 if (v >)
        //             }
        //         }
        //     }
        //     return 0;
        // }
        public int minimumWhiteTiles(String floor, int num, int le) {
            int n = floor.length();
            char [] s = floor.toCharArray();
            int [][] f = new int [num+1][n];
            f[0][0] = s[0] % 2; // (s[0]-'0') % 2 ??? 
            for (int i = 1; i < n; i++) // 初始化不用任何毯子的时候的最大值
                f[0][i] = f[0][i-1] + s[i] % 2;
            for (int i = 1; i <= num; i++) { // 遍历使用地毯的数量
                // j < carpetLen （le） 的 f[i][j] 均为 0
                for (int j = le; j < n; j++) {
                    // 分用第i块地毯，并盖至j-1的情况，以及用第i块地毯，i-1盖至j-len的情况，两种情况取最小值
                    f[i][j] = Math.min(f[i][j-1] + s[j] % 2, f[i-1][j-le]);
                }
            }
            return f[num][n-1];
        }

    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // String a = "abdcdbc";
        // String b = "ac";
        // String a = "aabb";
        // String b = "ab";
        // String a = "fwymvreuftzgrcrxczjacqovduqaiig";
        // String b = "yy";
        String a = "vnedkpkkyxelxqptfwuzcjhqmwagvrglkeivowvbjdoyydnjrqrqejoyptzoklaxcjxbrrfmpdxckfjzahparhpanwqfjrpbslsyiwbldnpjqishlsuagevjmiyktgofvnyncizswldwnngnkifmaxbmospdeslxirofgqouaapfgltgqxdhurxljcepdpndqqgfwkfiqrwuwxfamciyweehktaegynfumwnhrgrhcluenpnoieqdivznrjljcotysnlylyswvdlkgsvrotavnkifwmnvgagjykxgwaimavqsxuitknmbxppgzfwtjdvegapcplreokicxcsbdrsyfpustpxxssnouifkypwqrywprjlyddrggkcglbgcrbihgpxxosmejchmzkydhquevpschkpyulqxgduqkqgwnsowxrmgqbmltrltzqmmpjilpfxocflpkwithsjlljxdygfvstvwqsyxlkknmgpppupgjvfgmxnwmvrfuwcrsadomyddazlonjyjdeswwznkaeaasyvurpgyvjsiltiykwquesfjmuswjlrphsdthmuqkrhynmqnfqdlwnwesdmiiqvcpingbcgcsvqmsmskesrajqwmgtdoktreqssutpudfykriqhblntfabspbeddpdkownehqszbmddizdgtqmobirwbopmoqzwydnpqnvkwadajbecmajilzkfwjnpfyamudpppuxhlcngkign";
        String b = "rr";
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        long r = s.maximumSubsequenceCount(a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
