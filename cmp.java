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

        // public int largestInteger(int v) { // 把偶数及其下标存在一起，把寄数及其下标存在一起： 昨晚没休息好，这次比赛会比较差一点儿
        //     String t = String.valueOf(v);
        //     int n = t.length(), max = v;
        //     char [] s = t.toCharArray();
        //     Set<Integer> so = new HashSet<>();// idx odd
        //     Set<Integer> se = new HashSet<>();// even
        //     HashMap<Character, Integer> mo = new HashMap<>();
        //     HashMap<Character, Integer> me = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if ((s[i]-'0') % 2 == 0) {
        //             se.add(i);
        //             me.put(s[i], me.getOrDefault(s[i], 0) + 1);
        //         } else {
        //             so.add(i);
        //             mo.put(s[i], mo.getOrDefault(s[i], 0) + 1);
        //         }
        //     }
        //     TreeMap<Character, Integer> rmo = new TreeMap<>(Collections.reverseOrder());
        //     TreeMap<Character, Integer> rme = new TreeMap<>(Collections.reverseOrder());
        //     rmo.putAll(mo);
        //     rme.putAll(me);
        //     for (int i = 0; i < n; i++) {
        //         if (se.contains(i)) {
        //             s[i] = rme.firstKey();
        //             if (rme.firstEntry().getValue() == 1) rme.pollFirstEntry();
        //             else rme.put(rme.firstKey(), rme.firstEntry().getValue()-1);
        //         } else {
        //             s[i] = rmo.firstKey();
        //             if (rmo.firstEntry().getValue() == 1) rmo.pollFirstEntry();
        //             else rmo.put(rmo.firstKey(), rmo.firstEntry().getValue()-1);
        //         }
        //     }                
        //     return Integer.parseInt(new String(s));
        // }

        // static final int mod = (int)1e9 + 7;
        // public int maximumProduct(int[] a, int k) {
        //     int n = a.length, idx = 0;
        //     Arrays.sort(a);
        //     Queue<Integer> q = new PriorityQueue<>();
        //     for (int v : a) 
        //         q.offer(v);
        //     while (k > 0) {
        //         int v = q.poll();
        //         q.offer(++v);
        //         --k;
        //     }
        //     long ans = 1;
        //     while (!q.isEmpty()) {
        //         ans *= q.poll();
        //         ans %= mod;
        //     }
        //     return (int)ans;
        // }

        public String minimizeResult(String t) { // dfs: 记忆化搜索吗？感觉还是有点儿昏头昏脑的。。。。。。 112/125 passed
            n = t.length();
            s = t.toCharArray();
            ans = "(" + t + ")";
            int idx = t.indexOf('+');
            System.out.println("idx: " + idx);
            min = Integer.parseInt(t.substring(0, idx)) + Integer.parseInt(t.substring(idx+1));
            if (idx == 1) {
                for (int j = idx+1; j < n-1; j++) {
                    int cur = Integer.parseInt(t.substring(j+1)) * (Integer.parseInt(t.substring(0, 1)) + Integer.parseInt(t.substring(idx+1, j+1)));
                    if (cur < min) {
                        min = cur;
                        ans = "(" + t.substring(0, j+1) + ")" + t.substring(j+1);
                    }
                }
                return ans;
            } else if (idx == n-2) {
                for (int i = 0; i < idx-1; i++) {
                    int cur = Integer.parseInt(t.substring(0, i+1)) * (Integer.parseInt(t.substring(i+1, idx)) + Integer.parseInt(t.substring(idx+1)));
                    if (cur < min) {
                        min = cur;
                        ans = t.substring(0, i+1) + "(" + t.substring(i+1) + ")";
                    }
                }
                return ans;
            }
            for (int i = 0; i < idx; i++) {
                for (int j = idx+1; j < n; j++) {
                    int cur = (i == 0 ? 1 : Integer.parseInt(t.substring(0, i))) * (j == n-1 ? 1 : Integer.parseInt(t.substring(j+1))) * (Integer.parseInt(t.substring(i, idx)) + Integer.parseInt(t.substring(idx+1, j+1)));
                    if (cur < min) {
                        min = cur;
                        ans = (i == 0 ? "" : t.substring(0, i)) + "(" + t.substring(i, j+1) + ")" + (j == n-1 ? "" : t.substring(j+1));
                    }
                }
            }
            return ans;
        }
        int n, min;
        char [] s;
        String ans;
        
        public long maximumBeauty(int[] a, long avl, int t, int f, int p) {
            Arrays.sort(a);
            int n = a.length, j = n-1, cnt = 0;
            while (j >= 0 && a[j] >= t) {
                cnt++;
                j--;
            }
            if (j < 0) return (long)n*f;
            
            return 0;
        }

    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // String a = "247+38";
        // String a = "12+34";
        // String a = "5+22";
        String a = "236+1841";

        String r = s.minimizeResult(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
