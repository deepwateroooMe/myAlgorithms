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

        public int countOperations(int a, int b) {
            int cnt = 0;
            while (a > 0 && b > 0) {
                if (a >= b) {
                    a -= b;
                    cnt++;
                } else {
                    b -= a;
                    cnt++;
                }
            }
            return cnt;
        }

        public int minimumOperations(int[] a) {
            int n = a.length;
            Map<Integer, Integer> odd = new HashMap<>();
            Map<Integer, Integer> evn = new HashMap<>();
            for (int i = 0; i < n; i++) 
                if (i % 2 == 0) evn.put(a[i], evn.getOrDefault(a[i], 0) + 1);
                else odd.put(a[i], odd.getOrDefault(a[i], 0) + 1);
            Queue<Node> od = new PriorityQueue<>((x, y) -> y.f - x.f);
            Queue<Node> en = new PriorityQueue<>((x, y) -> y.f - x.f);
            for (Map.Entry<Integer, Integer> ent : odd.entrySet()) 
                od.offer(new Node(ent.getKey(), ent.getValue()));
            for (Map.Entry<Integer, Integer> ent : evn.entrySet()) 
                en.offer(new Node(ent.getKey(), ent.getValue()));
            while (!od.isEmpty() && !en.isEmpty() && od.peek().v == en.peek().v) {
                if (od.peek().f < en.peek().f)
                    od.poll();
                else en.poll();
            }
            if (n % 2 == 0) return (od.isEmpty() ? n / 2 : n/2 - od.poll().f) + (en.isEmpty() ? n/2 : n/2 - en.poll().f);
            else return (od.isEmpty() ? n/2+1 : n/2+1 - od.poll().f) + (en.isEmpty() ? n/2 : n/2 - en.poll().f);
            // int vOdd = odd.get(odd.lastKey());
            // Integer hi = evn.higherKey(odd.lastKey());
            // if (hi != null) max = Math.max(max, vOdd + evn.get(hi));
            // else {
            //     hi = evn.lowerKey(odd.lastKey());
            //     if (hi != null)  max = Math.max(max, vOdd + evn.get(hi));
            // }
            // int vEvn = evn.get(evn.lastKey());
            // hi = odd.higherKey(evn.lastKey());
            // if (hi != null) max = Math.max(max, vEvn + odd.get(hi));
            // else {
            //     hi = odd.lowerKey(evn.lastKey());
            //     if (hi != null) max = Math.max(max, vEvn + odd.get(hi));
            // }
            // return n - max;
        }
        class Node {
            int f, v;
            public Node(int v, int f) {
                this.v = v;
                this.f = f;
            }
        }
        
        // public long minimumRemoval(int[] a) { // tle tle tle 
        //     int n = a.length, min = Integer.MAX_VALUE, max = 0, ans = Integer.MAX_VALUE;
        //     long sum = 0;
        //     TreeMap<Integer, Integer> cnt = new TreeMap<>();
        //     for (int v : a) {
        //         sum += v;
        //         min = Math.min(min, v);
        //         max = Math.max(max, v);
        //         cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        //     }
        //     // System.out.println("sum: " + sum);
        //     // System.out.println("min: " + min);
        //     // System.out.println("max: " + max);
        //     if (min == max) return 0;
        //     int l = min, r = max, lv = getVal(l, cnt), rv = getVal(r, cnt);
        //     while (l < r) {
        //         // System.out.println("\n l: " + l);
        //         // System.out.println("r: " + r);
        //         int m = l + (r - l) / 2;
        //         System.out.println("m: " + m);
        //         if (getVal(m, cnt) > getVal(m+1, cnt)) // 这里的逻辑还是有点儿不太对：并不是严格的单调递减，再单调递增
        //             l = m + 1;
        //         else r = m;
        //     }
        //     return getVal(l, cnt);
        //     // System.out.println("cnt.size(): " + cnt.size());
        //     // for (Map.Entry<Integer, Integer> en : cnt.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     // for (Integer key : cnt.keySet()) {
        //     //     ans = Math.min(ans, getVal(key, cnt));
        //     //     System.out.println("ans: " + ans);
        //     // }
        //     // return ans;
        // }
        // int getVal(int v, TreeMap<Integer, Integer> m) { // 每个袋都留这么多
        //     int cnt = 0;
        //     for (Integer key : m.keySet()) {
        //         if (key < v) cnt += key * m.get(key);
        //         else if (key > v) cnt += (key - v) * m.get(key);
        //     }
        //     return cnt;
        // }
        public long minimumRemoval(int[] a) {
            int n = a.length;
            long min = Long.MAX_VALUE;
            Arrays.sort(a);
            long [] sum = new long [n];
            for (int i = 0; i < n; i++) 
                sum[i] = (i == 0 ? 0 : sum[i-1]) + (long)a[i];
            for (int i = 0; i < n; i++) {
                long cur = sum[n-1] - (long)a[i] * (n-i);
                // if (cur > min) break; // BUG: 把这个遍历完
                min = Math.min(min, cur);
            }
            return min;
        }

        // 考场上当时的自己，就只能想出一个遍历所有可能性的回塑的解
        // public int maximumANDSum(int[] a, int N) { // TLE: bitwise 1111 遍历，应该会好一点儿，被他们吵闹没休息好，总是想不透彻，休息好的时候状态会好很多
        //     n = a.length; 
        //     this.N = N;
        //     cnt = new ArrayList[N+1];
        //     for (int i = 0; i <= N; i++) 
        //         cnt[i] = new ArrayList<>();
        //     Arrays.sort(a);
        //     helper(n-1, N, 0, a);
        //     return max;
        // }
        // int n, N, max = 0;
        // List<Integer>[] cnt;
        // void helper(int idx, int j, int sum, int [] a) {
        //     if (idx == -1) {
        //         if (sum > max) max = sum;
        //         return ;
        //     }
        //     int max = 0, maxI = -1;
        //     // for (int i = 1; i <= N; i++) {
        //     for (int i = j; i >= 0; i--) {
        //         int k = i;
        //         while (k >= 0) { // 这个应该是整个只遍历一遍
        //             int cur = a[idx] & k;
        //             if (cur > max) {
        //                 max = cur;
        //                 maxI = k;
        //             } else if (max > 0 && cur < max) break;
        //         }
        //         if (cnt[i].size() < 2) {
        //             cnt[i].add(a[idx]);
        //             helper(idx-1, sum + (a[idx] & i), a);
        //             cnt[i].remove(cnt[i].size()-1);
        //         }
        //     }
        // }
        public int maximumANDSum(int[] a, int N) {
            int n = a.length, idx = 0, m = N * 2, max = 0;
            int [] cnt = new int [m]; // slots的编号取值
            for (int i = 1; i <= N; i++) {
                cnt[idx++] = i;
                cnt[idx++] = i;
            }
            int [][] dp = new int [n+1][1 << m]; // 前i个数的情况下，所以分分布可能的遍历中的最优解
            for (int i = 1; i <= n; i++) // 遍历数组中的每个元素 a[i]
                for (int j = 0; j < (1 << m); j++)  // 遍历了所有可能子状态下的最优解
                    if (Integer.bitCount(j) == i-1) // 如果当前bitmask代表一个有效子状态（由前 i 个数组成的有效分布子状态）
                        for (int k = 0; k < m; k++) {
                            if ((j & (1 << k)) == 0) // 如果slot的这个位置还空着，那么就可以试着把当前遍历的数组元素a[i-1]放在这里，遍历所有可能性，试取最优解
                                dp[i][j | (1 << k)] = Math.max(dp[i][j | (1 <<k)], dp[i-1][j] + (cnt[k] & a[i-1]));
                        }
            for (int j = 0; j < (1 << m); j++) 
                max = Math.max(max, dp[n][j]);
            return max;
        }
        public int maximumANDSum(int[] a, int N) {
            int n = a.length, idx = 0, m = N * 2, max = 0;
            int [] cnt = new int [m];
            for (int i = 1; i <= N; i++) {
                cnt[idx++] = i;
                cnt[idx++] = i;
            }
            int [][] dp = new int [n+1][1 << m]; // n+1的便利在于方便corner case的处理
            for (int i = 1; i <= n; i++) 
                for (int j = 0; j < (1 << m); j++) 
                    if (Integer.bitCount(j) == i-1) 
                        for (int k = 0; k < m; k++) 
                            if ((j & (1 << k)) == 0)
                                dp[i][j | (1 << k)] = Math.max(dp[i][j | (1 << k)], dp[i-1][j] + (a[i-1] & cnt[k]));
            for (int j = 0; j < (1 << m); j++) 
                max = Math.max(max, dp[n][j]);
            return max;
        }

        public int minimumTime(String t) {
            int n = t.length(), min = Integer.MAX_VALUE;
            char [] s = t.toCharArray();
            int preSum = 0, preBest = 0;
            for (int i = 0; i < n; i++) {
                preBest = Math.min(preBest, i - 2 * preSum); // 截止目前为止的局部最优解，j <= i-1
                preSum += (s[i] - '0');
                min = Math.min(min, preBest + 2 * preSum - i);
            }
            return Math.min(min + n-1, n);
        }
        public int minimumTime(String t) {
            int n = t.length(), min = Integer.MAX_VALUE;
            char [] s = t.toCharArray();
            int [] pre = new int [n];
            pre[0] = s[0] - '0';
            int [] dp = new int [n];
            Arrays.fill(dp, n);
            dp[0] = pre[0] + n-1;
            for (int i = 1; i < n; i++) {
                pre[i] = Math.min(pre[i-1] + 2 * (s[i] - '0'), i+1); // 感觉现场的时候是这句话读不明白。。。
                dp[i] = Math.min(dp[i], pre[i] + n-1 - i);
            }
            return Arrays.stream(dp).min().getAsInt();
        }
        public int minimumTime(String t) {
            int n = t.length(), min = Integer.MAX_VALUE, pre = 0;
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                pre = Math.min(pre + (s[i] - '0') * 2, i+1);
                min = Math.min(min, pre + n-1 - i);
            }
            return min;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();

        // int [] a = new int [] {2,10,3,2};
        int [] a = new int [] {1,3,10,4,7,1};

        int r = s.maximumANDSum(a, 9);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);



