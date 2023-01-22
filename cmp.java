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

        // public boolean haveConflict(String[] s, String[] t) {
        //     int a = getVal(s[0]), b = getVal(s[1]);
        //     int c = getVal(t[0]), d = getVal(t[1]);
        //     if (a <= c) {
        //         if (b < c) return false;
        //         return true;
        //     } else return haveConflict(t, s);
        // }
        // int getVal(String t) {
        //     char [] s = t.toCharArray();
        //     return Integer.parseInt(t.substring(0, 2)) * 60 + Integer.parseInt(t.substring(3));
        // }

        // class Item implements Comparable<Item> {
        //     int v, f;
        //     public Item(int v, int f) {
        //         this.v = v;
        //         this.f = f;
        //     }
        //     @Override public int compareTo(Item other) { // 想要按值降序排列
        //         return this.v != other.v ? other.v - this.v : other.f - this.f;
        //     }
        //     public void print() {
        //         System.out.println("[v: " + v + ", f: " + f + "]"); 
        //     }
        // }
//         public long makeSimilar(int[] a, int[] b) {
//             int n = a.length, N = 1000001;
//             int [] cnt = new int [N];
//             for (var v : b) cnt[v]++;
//             TreeMap<Integer, Integer> ma = new TreeMap<>(Collections.reverseOrder());
//             TreeMap<Integer, Integer> mb = new TreeMap<>(Collections.reverseOrder());
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sb.add(new Item(i, cnt[i]));
//                     mb.put(i, cnt[i]);
//             Arrays.fill(cnt, 0);
//             for (var v : a) cnt[v]++;
//             for (int i = 1; i < N; i++) 
//                 if (cnt[i] > 0)
//                     // sa.add(new Item(i, cnt[i]));
//                     ma.put(i, cnt[i]);
//             System.out.println("ma.size(): " + ma.size());
//             for (Map.Entry<Integer, Integer> en : ma.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");
//             System.out.println("mb.size(): " + mb.size());
//             for (Map.Entry<Integer, Integer> en : mb.entrySet()) 
//                 System.out.print(en.getKey() + ", " + en.getValue() + "\n");

//             Set<Integer> ka = ma.keySet();
//             Set<Integer> kb = mb.keySet();
//             ka.retainAll(kb);
//             for (var v : ka) {
//                 int va = ma.get(v), vb = mb.get(v);
//                 if (va == vb) {
//                     ma.remove(v);
//                     mb.remove(v);
//                 } else if (va < vb)
//                     mb.put(v, vb - va);
//                 else 
//                     ma.put(v, va - vb);
//             }
//             long f = 0;
//             for (Map.Entry<Integer, Integer> en : ma.entrySet()) {
//                 int k = en.getKey(), v = en.getValue();
// // returns the least key greater than or equal to the given key or null if the such a key is absent.
//                 Integer hi = mb.ceilingKey(k);
//                 if (hi == null) {
//                     Integer lo = mb.floorKey(k);
//                 }
//             }
//             return 0;
//         }
        // public long makeSimilar(int[] a, int[] b) {
        //     int n = a.length, N = 1000001, min = 0;
        //     int [] ca = new int [N];
        //     int [] cb = new int [N];
        //     for (var v : a) ca[v]++;
        //     for (var v : b) cb[v]++;
        //     long f = 0;
        //     for (int i = N-1; i >= 0; i--) {
        //         if (ca[i] == cb[i]) continue;
        //         min = Math.min(ca[i], cb[i])
        //     }
        //     return 0;
        // }

// // 想得太简单了:要对每个元素分解质因子,统计每个质因子的个数
// // 因为每个数值可能会狠大,要用[1, 30]?内的质因素怎么样的.......
// // 这个题感觉有点儿像1735,但是今天头比较昏,数值也很大[1, 1000000000],想不清楚这个题要怎么分解每个数
//         public int subarrayGCD(int[] a, int k) {
//             Set<Integer> st = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
//             if (!st.contains(k)) return 0;
//             int n = a.length, f = 0, j = 0, l = 0, r = 0;
//             boolean [] vis = new boolean[n];
//             for (int i = 0; i < n; i++) 
//                 if (a[i] % k == 0) vis[i] = true;
//             for (int i = 0; i < n; i++) {
//                 if (a[i] != k) continue;
//                 System.out.println("\n i: " + i);
//                 j = i-1;
//                 while (j >= 0 && vis[j]) j--;
//                 l = (i == 0 ? 1 : i - j);
//                 j = i + 1;
//                 while (j < n && vis[j]) j++;
//                 r = j - i;
//                 System.out.println("l: " + l); 
//                 System.out.println("r: " + r); 
//                 f += l * r;
//                 System.out.println("f: " + f); 
//             }
//             return f;
//         }

         
// // 用TreeMap<Integer, TreeSet<Integer>> 会比下面的效率高吗?        
//         // Map<Integer, Queue<Integer>> idx; // [num, Queue[idx1 idx1 ....]] 为什么我会用这种相对奇怪的数据结构呢?
//         Map<Integer, Integer> m;          // [idx, num]
//         Map<Integer, TreeSet<Integer>> idx;
//         public NumberContainers() {
//         // public cmp() {
//             m = new HashMap<>();
//             idx = new HashMap<>();
//         }
//         public void change(int index, int number) {
//             // 这里,因为没有从idx中移除,所以下次取的时候就需要遍历一下            
//             m.put(index, number);
//             idx.computeIfAbsent(number, z -> new TreeSet<>()).add(index);
//             // // 先处理更改前的位标数据更新
//             // if (m.containsKey(index)) {
//             //     // idx.get(m.get(index)).remove((Integer)number);
//             //     idx.get(m.get(index)).remove((Integer)index);
//             //     if (idx.get(m.get(index)).isEmpty()) // 如果数据清空了就清空这个键
//             //         idx.remove(m.get(index));
//             // }
//             // m.put(index, number);
//             // idx.computeIfAbsent(number, z -> new PriorityQueue<>());
//             // idx.get(number).add(index);
//         }
//         public int find(int number) {
//             // return idx.containsKey(number) ? idx.get(number).peek() : -1;
//             if (!idx.containsKey(number)) return -1;
//             for (var v : idx.get(number))  // idx 从小到大遍历,当某个是合法值
//                 if (m.get(v) == number)
//                     return v;
//             return -1;
//         }
 
        // public long countExcellentPairs(int[] a, int k) { // >= k 不是 == k
        //     int n = a.length;
        //     Integer [] f = new Integer [n];
        //     // TreeMap<Integer, Integer> m = new TreeMap<>();
        //     TreeSet<Integer> m = new TreeSet<>();
        //     for (int i = 0; i < n; i++) {
        //         f[i] = Integer.bitCount(a[i]);
        //         // m.put(f[i], m.getOrDefault(f[i], 0) + 1);
        //         m.add(f[i]);
        //     }
        //     Arrays.sort(f);
        //     int [] s = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         s[i] = s[i-1] + f[i-1];
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(s));
        //     Set<Integer> vis = new HashSet<>();
        //     long ans = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (vis.contains(f[i])) continue;
        //         Integer hi = m.ceiling(k - f[i]); // ceilingKey() floorKey()
        //         if (hi != null && hi != f[i]) ans += Math.min(m.get(f[i]), m.get(hi)) * 2;
        //         else if (hi != null) ans += 1;
        //         vis.add(f[i]);
        //     }
        //     return ans;
        // }

        // public int AlternateDigitSum(int n) {
        //     if (n < 10) return n;
        //     int cnt = 0;
        //     int v = n;
        //     int [] p = new int [10];
        //     p[0] = 1;
        //     while (v >= 10) {
        //         cnt++;
        //         v /= 10;
        //         p[cnt] = 10 * p[cnt-1];
        //     } 
        //     int r = 0, s = 1;
        //     while (cnt > 0) {
        //         r += s * n / (p[cnt]) % 10;
        //         s *= -1;
        //         cnt--;
        //     }
        //     r += s * n % 10;
        //     return r;
        // }

        // public int[][] sortTheStudents(int[][] a, int k) { 
        //     int m = a.length, n = a[0].length;
        //     List<int []> l = new ArrayList<>();
        //     for (int [] v : a) 
        //         l.add(v);
        //     Collections.sort(l, new Comparator<int []>() {
        //             @Override
        //             public int compare(int [] o1, int [] o2) {
        //                 return o2[k] - o1[k];
        //             }
        //         });
        //     int idx = 0;
        //     for (int [] v : l) 
        //         a[idx++] = v;
        //     return a;
        // }

//  感觉这个题目没有想透，有很多犄角旮旯没想透彻        
        public boolean makeStringsEqual(String ss, String tt) {
            int n = ss.length(), i = 0, j = n-1, k = 0, x = 0;
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            while (i <= j && s[i] == t[i]) i++;
            if (i == n) return true;
            // while (j > i && s[j] == t[j]) j--;
            // if (j < 0 || i == j && s[i] == t[j]) return true;
            while (i < n) {
                while (i < j && s[i] == t[i]) i++;
                if (i == n) return true;
                
                System.out.println("\n i: " + i);
                k = n-1;
                while (k > i && s[k] == '0') k--; // 找个1
                // System.out.println(Arrays.toString(s));
                x = 0;
                while (x < i && s[x] == '0') x++;
                System.out.println("k: " + k);
                System.out.println("x: " + x);

                // if (k == i) return false;
                // if (k == i && x == i) {
                //     return false;
                // }
                if (k == n-1 && x == 0) return false;
                if (s[i] == '1') { // 从尾巴找个1
                    s[i] = '0';
                    // s[k] = 1;
                    if (k == i && x == i) {
                        if (i < n-1) s[i+1] = 1;
                        else s[x-1] = 1;
                    }
                } else { // [0, 1]
                    s[i] = '1';
                }
                i++;
                // System.out.println(Arrays.toString(s));
                System.out.println("i: " + i);
            }
            if (i == j) return s[i] == t[j];
            if (i == n) return true;
            return false;
        }

// 区间型动态规划
       Long [][] dp;
       long minCost(int [] a, int x, int y, int k) {
            if (dp[x][y] != null) return dp[x][y];
            if (x == y) return dp[x][y] = (long)k; // 长度为1个元素
            // 不划分，作为一个整体
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = x; i <= y; i++) 
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
            long base = k, min = Long.MAX_VALUE;
            for (Integer val : m.values()) 
                if (val > 1) base += val; // 不划分，作为一个整体
            min = base;
            // 从不同的地方划分，取最优解
            for (int i = x; i < y; i++) { // 在它后面划分
               long cur = minCost(a, x, i, k) + minCost(a, i+1, y, k);
                min = Math.min(min, cur);
            }
            return dp[x][y] = min;
        } 
        public int minCost(int[] a, int k) { // TLE: 什么地方没有优化好？
            int n = a.length; // [1, 1000]
            dp = new Long [n][n];
            return (int)minCost(a, 0, n-1, k);
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        int [] a = new int [] {1,2,1,2,1,3,3};
        
        int r = s.minCost(a, 2);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
