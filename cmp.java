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

        // public int countOperations(int a, int b) {
        //     int cnt = 0;
        //     while (a > 0 && b > 0) {
        //         if (a >= b) {
        //             a -= b;
        //             cnt++;
        //         } else {
        //             b -= a;
        //             cnt++;
        //         }
        //     }
        //     return cnt;
        // }

        // public int minimumOperations(int[] a) {
        //     int n = a.length;
        //     Map<Integer, Integer> odd = new HashMap<>();
        //     Map<Integer, Integer> evn = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         if (i % 2 == 0) evn.put(a[i], evn.getOrDefault(a[i], 0) + 1);
        //         else odd.put(a[i], odd.getOrDefault(a[i], 0) + 1);
        //     Queue<Node> od = new PriorityQueue<>((x, y) -> y.f - x.f);
        //     Queue<Node> en = new PriorityQueue<>((x, y) -> y.f - x.f);
        //     for (Map.Entry<Integer, Integer> ent : odd.entrySet()) 
        //         od.offer(new Node(ent.getKey(), ent.getValue()));
        //     for (Map.Entry<Integer, Integer> ent : evn.entrySet()) 
        //         en.offer(new Node(ent.getKey(), ent.getValue()));
        //     while (!od.isEmpty() && !en.isEmpty() && od.peek().v == en.peek().v) {
        //         if (od.peek().f < en.peek().f)
        //             od.poll();
        //         else en.poll();
        //     }
        //     if (n % 2 == 0) return (od.isEmpty() ? n / 2 : n/2 - od.poll().f) + (en.isEmpty() ? n/2 : n/2 - en.poll().f);
        //     else return (od.isEmpty() ? n/2+1 : n/2+1 - od.poll().f) + (en.isEmpty() ? n/2 : n/2 - en.poll().f);
        //     // int vOdd = odd.get(odd.lastKey());
        //     // Integer hi = evn.higherKey(odd.lastKey());
        //     // if (hi != null) max = Math.max(max, vOdd + evn.get(hi));
        //     // else {
        //     //     hi = evn.lowerKey(odd.lastKey());
        //     //     if (hi != null)  max = Math.max(max, vOdd + evn.get(hi));
        //     // }
        //     // int vEvn = evn.get(evn.lastKey());
        //     // hi = odd.higherKey(evn.lastKey());
        //     // if (hi != null) max = Math.max(max, vEvn + odd.get(hi));
        //     // else {
        //     //     hi = odd.lowerKey(evn.lastKey());
        //     //     if (hi != null) max = Math.max(max, vEvn + odd.get(hi));
        //     // }
        //     // return n - max;
        // }
        // class Node {
        //     int f, v;
        //     public Node(int v, int f) {
        //         this.v = v;
        //         this.f = f;
        //     }
        // }
        
        // public int maximumANDSum(int[] a, int N) { // TLE: bitwise 1111 遍历，应该会好一点儿，被他们吵闹没休息好，总是想不透彻，休息好的时候状态会好很多
        //     n = a.length;
        //     this.N = N;
        //     cnt = new ArrayList[N+1];
        //     for (int i = 0; i <= N; i++) 
        //         cnt[i] = new ArrayList<>();
        //     Arrays.sort(a);
        //     // vis = new boolean[n];
        //     helper(n-1, N, 0, a);
        //     return max;
        // }
        // int n, N, max = 0;
        // // boolean [] vis;
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

        // public long minimumRemoval(int[] a) {
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
        public long minimumRemoval(int[] a) { // 57 / 64 tes
            int n = a.length;
            long min = Long.MAX_VALUE;
            Arrays.sort(a);
            long [] sum = new long [n];
            for (int i = 0; i < n; i++) 
                sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];

            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(sum));
            
            for (int i = 0; i < n; i++) {
                long cur = sum[n-1] - a[i] * (n-i);
                // if (cur > min) break;
                min = Math.min(min, cur);
            }
            return min;
        }
    }

    public static void main(String args[]) {
        Solution s = new Solution();

        int [] a = new int [] {2,10,3,2};
        
        long r = s.minimumRemoval(a);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
