import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp_22_2_19_1 {
    public static class Solution {
        
        public int countPairs(int[] a, int k) {
            int n = a.length, cnt = 0;
            Map<Integer, List<Integer>> m = new HashMap<>();
            for (int i = 0; i < n; i++) 
                m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
            for (Integer key : m.keySet()) {
                System.out.println("\n key: " + key);
                List<Integer> l = m.get(key);
                for (int i = 0; i < l.size()-1; i++) {
                    for (int j = i+1; j < l.size(); j++) {
                        if (l.get(i) * l.get(j) % k == 0) {
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }

        public long[] sumOfThree(long num) {
            if (num % 3 != 0) return new long [0];
            long [] ans = new long [3];
            ans[1] = num / 3;
            ans[0] = ans[1] - 1;
            ans[2] = ans[1] + 1;
            return ans;
        }

        // public List<Long> maximumEvenSplit(long finalSum) { // tle once
        //     List<Long> ans = new ArrayList<>();
        //     if (finalSum % 2 == 1) return ans;
        //     if (finalSum == 2) {
        //         ans.add(2l);
        //         return ans;
        //     }
        //     TreeSet<Long> s = new TreeSet<>();
        //     if (finalSum-2 != 2) {
        //         s.add(2l);
        //         s.add(finalSum-2);
        //     } else return ans;
        //     boolean added = false;
        //     Iterator<Long> it = s.descendingIterator();
        //     while (it.hasNext()) {
        //         long v = it.next();
        //         added = false;
        //         for (long i = v-2; i >= 2 && !added; i -= 2) {
        //             if (!s.contains(i) && !s.contains(v-i) && i != v-i) {
        //                 s.remove(v);
        //                 s.add(i);
        //                 s.add(v - i);
        //                 added = true;
        //             }
        //         }
        //         if (added) it = s.descendingIterator();
        //     }
        //     for (long v : s) 
        //         ans.add(v);
        //     return ans;
        // }
        public List<Long> maximumEvenSplit(long f) {
            Set<Long> s = new HashSet<>();
            if (f % 2 == 1) return new ArrayList<>();
            long i = 2;
            while (true) {
                if (s.contains(i)) {
                    i += 2;
                    continue;
                }
                if (f - i == 0 || s.contains(f-i) || i == f-i) {
                    s.add(f);
                    break;
                }
                s.add(i);
                f -= i;
            }
            return new ArrayList<>(s);
        }

        // public long goodTriplets(int[] a, int[] b) { // tle once 
        //     int n = a.length;
        //     // int [][] m = new int[n][2];
        //     // for (int i = 0; i < n; i++) {
        //     //     m[a[i]][0] = i;
        //     // }
        //     // for (int i = 0; i < n; i++)
        //     //     m[b[i]][1] = i;
        //     // Map<Integer, int []> m = new HashMap<>();
        //     Map<Integer, Integer> ma = new HashMap<>();
        //     Map<Integer, Integer> mb = new HashMap<>();
        //     long dp [] = new long [n], cnt [] = new long [n];
        //     if (a[n-1] == b[n-1]) {
        //         dp[n-1] = 1;
        //         // m.computeIfAbsent(a[n-1], z -> new int [2] {n-1, n-1});
        //         ma.put(a[n-1], n-1);
        //         mb.put(a[n-1], n-1);
        //         cnt[n-1] = 1;
        //     } else {
        //         ma.put(a[n-1], n-1);
        //         mb.put(b[n-1], n-1);
        //     }
        //     long ans = 0;
        //     for (int i = n-2; i >= 0; i--) { // 倒序遍历数组a
        //         System.out.println("\n i: " + i);
        //         if (a[i] == b[i]) {
        //             dp[i] = dp[i+1] + 1;
        //             cnt[i] = cnt[i+1];
        //         } else {
        //             if (mb.containsKey(a[i]) || ma.containsKey(b[i])) {
        //                 if (mb.containsKey(a[i])) {
        //                     if (dp[mb.get(a[i])] + 1 >= dp[i]) {
        //                         dp[i] = dp[mb.get(a[i])] + 1;
        //                         cnt[i] += (cnt[mb.get(a[i])] == 0 ? 1 : cnt[mb.get(a[i])]);
        //                     }
        //                     // dp[i] = Math.max(dp[i], dp[mb.get(a[i])] + 1);
        //                 }
        //                 if (ma.containsKey(b[i])) {
        //                     if (dp[ma.get(b[i])] + 1 >= dp[i]) {
        //                         dp[i] = Math.max(dp[i], dp[ma.get(b[i])] + 1);
        //                         cnt[i] += (cnt[ma.get(b[i])] == 0 ? 1 : cnt[ma.get(b[i])]);
        //                     }
        //                 }
        //                 System.out.println("cnt[i]: " + cnt[i]);
        //             } else { // 这里的逻辑还是少了一点儿
        //                 dp[i] = dp[i+1];
        //                 cnt[i] = cnt[i+1];
        //             }
        //         }
        //         System.out.println(Arrays.toString(dp));
        //         System.out.println(Arrays.toString(cnt));
        //         if (dp[i] >= 3) ans += cnt[i];
        //     }
        //     return ans;
        //     // for (Integer k : m.keySet()) { // O(n^3) tle
        //     //     List<Integer> l = m.get(k);
        //     //     for (int i = l.get(0)+1; i < n-1; i++) { // 遍历a数组当前数k之后的所有下标
        //     //         if (m.get(a[i]).get(1) < l.get(1)) continue;
        //     //         List<Integer> ll = m.get(a[i]);
        //     //         for (int j = ll.get(0)+1; j < n; j++) {
        //     //             if (m.get(a[j]).get(1) < ll.get(1)) continue;
        //     //             cnt++;
        //     //         }
        //     //     }
        //     // }
        //     // return cnt;
        // }
        // public long goodTriplets(int[] a, int[] b) { // bug: 这里面还有n多重复
        //     int n = a.length;
        //     Map<Integer, Set<Integer>> pa = new HashMap<>();
        //     Map<Integer, Set<Integer>> pb = new HashMap<>();
        //     pa.computeIfAbsent(a[0], z -> new HashSet<>()).add(a[0]);
        //     pb.computeIfAbsent(b[0], z -> new HashSet<>()).add(b[0]);
            
        //     Map<Integer, Set<Integer>> sa = new HashMap<>();
        //     Map<Integer, Set<Integer>> sb = new HashMap<>();
        //     sa.computeIfAbsent(a[n-1], z -> new HashSet<>()).add(a[n-1]);
        //     sb.computeIfAbsent(b[n-1], z -> new HashSet<>()).add(b[n-1]);
        //     for (int i = n-2; i >= 2; i--) {
        //         sa.computeIfAbsent(a[i], z -> new HashSet<>()).add(a[i]);
        //         sa.get(a[i]).addAll(sa.get(a[i+1]));
        //         sb.computeIfAbsent(b[i], z -> new HashSet<>()).add(b[i]);
        //         sb.get(b[i]).addAll(sb.get(b[i+1]));
        //     }
        //     long ans = 0;
        //     for (int i = 1; i < n-1; i++) { // 这里面还有n多重复
        //         System.out.println("\n i: " + i);
        //         Set<Integer> left = new HashSet<>(pa.get(a[i-1]));
        //         Set<Integer> right = new HashSet<>(sa.get(a[i+1]));
        //         left.retainAll(pb.get(b[i-1]));
        //         right.retainAll(sb.get(b[i+1]));
        //         if (a[i] == b[i]) {
        //             ans += left.size() * right.size();
        //             // } else if (sa.containsKey(b[i])) {
        //         } else if (sb.containsKey(a[i]) || sa.containsKey(b[i])) {
        //             // if (sb.containsKey(a[i]))
        //             //     right.retainAll(sb.get(a[i]));
        //             // else right.retainAll(sa.get(b[i]));
        //             ans += left.size() * right.size();
        //         } else if (pa.containsKey(b[i]) || pb.containsKey(a[i])) {
        //             // if (pa.containsKey(b[i]))
        //             //     left.retainAll(pa.get(b[i]));
        //             // else left.retainAll(pb.get(a[i]));
        //             ans += left.size() * right.size();
        //         }
        //         pa.computeIfAbsent(a[i], z -> new HashSet<>()).add(a[i]);
        //         pa.get(a[i]).addAll(pa.get(a[i-1]));
        //         pb.computeIfAbsent(b[i], z -> new HashSet<>()).add(b[i]);
        //         pb.get(b[i]).addAll(pb.get(b[i-1]));
        //         if (i < n-2) {
        //             sa.remove(a[i+1]);
        //             sb.remove(b[i+1]);
        //         }
        //     }
        //     return ans;
        // }
        // public long goodTriplets(int[] a, int[] b) { // tle
        //     int n = a.length;
        //     Map<Integer, Integer> idx = new HashMap<>(); // for b
        //     for (int i = 0; i < n; i++) 
        //         idx.put(b[i], i);
        //     for (int i = 0; i < n; i++) // 把a替换成b 中相应值的下标
        //         a[i] = idx.get(a[i]);
        //     int cnt = 0;
        //     List<Tree> lt = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i];
        //         for (Tree t : lt) 
        //             cnt += t.addChild(v);
        //         lt.add(new Tree(v));
        //     }
        //     return cnt;
        // }
        // // Tree in which all children are always greater than parent
        // class Tree {
        //     int v;
        //     List<Tree> children = new ArrayList<>(); // 过里也只是个list,没有什么排列顺序吗？没有顺序的话暴力搜索所以children，不是一定会超时吗？
        //     public Tree(int v) {
        //         this.v = v;
        //     }
        //     // Adds the val to children of root or root, id it satisfies tree condition. 
        //     // Checks only 1 level of children, as we need triplet size to be 3
        //     // Returns number of valid triplets added to the tree, i.e. val added to 2nd level
        //     public int addChild(int val) {
        //         int cnt = 0;
        //         for (Tree t : children) {
        //             if (val > t.v) {
        //                 t.children.add(new Tree(val));
        //                 cnt++;
        //             }
        //         }
        //         if (val > v)
        //             this.children.add(new Tree(val));
        //         return cnt;
        //     }
        // }
        public long goodTriplets(int [] a, int [] b) { // 早上的脑袋腾去驾雾，根本就不知道题目说的是什么意思。。。。。。
            int n = a.length;
            int [] idx = new int [n], map = new int [n];  // remap
            for (int i = 0; i < n; i++) idx[a[i]] = i;    // nums1 -> idx
            for (int i = 0; i < n; i++) map[i] = idx[b[i]]; // nums2 -> map   -- could be combined with the loop below, but we keep it separate for clarity
            long ans = 0;
            FenwickTree bit = new FenwickTree(n);
            for (int i = 0; i < n; i++) {
                int lSmaller = bit.ps(map[i] - 1); // nums < map[i] to the left of i
                int lLarger = i - lSmaller;        // nums > map[i] to the left of i
                int larger = n-1 - map[i];          // all nums > map[i]
                int rLarger = larger - lLarger;    // nums > map[i] to the right of i
                ans += (long)lSmaller * rLarger;
                bit.inc(map[i]);
            }
            return ans;
        }
        class FenwickTree {
            int [] bit; // binary index tree, index 0 is not used, so we shift all calls by +1
            int n;
            FenwickTree(int n) {
                this.n = n + 1;
                this.bit = new int [this.n]; 
            }
            // increment count of i
            public void inc(int i) {
                for (i++; i < n; i += Integer.lowestOneBit(i))
                    bit[i]++;
            }
            // prefix sum query i.e. count of nums <= i added so far
            public int ps(int i) {
                int ps = 0;
                for (i++; i != 0; i -= Integer.lowestOneBit(i))
                    ps += bit[i];
                return ps;
            }
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int []  a = new int []  {4, 0, 1, 3, 2};
        int [] b = new int [] {4,1,0,2,3};

        long r = s.goodTriplets(a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
