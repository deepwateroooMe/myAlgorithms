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

        // public int[] answerQueries(int[] a, int[] q) {
        //     int n = a.length, m = q.length;
        //     Arrays.sort(a);
        //     int [] sum = new int [n], ans = new int [m];
        //     TreeMap<Integer, Integer> mi = new TreeMap<>();
        //     sum[0] = a[0];
        //     mi.put(sum[0], 1);
        //     for (int i = 1; i < n; i++) {
        //         sum[i] = sum[i-1] + a[i];
        //         mi.put(sum[i], i+1);
        //     }
        //     for (int i = 0; i < m; i++) {
        //         int v = q[i];
        //         Integer k = mi.floorKey(v);
        //         if (k != null) ans[i] = mi.get(k);
        //         else ans[i] = 0;
        //     }
        //     return ans;
        // }

        // public String removeStars(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     Deque<Character> st = new ArrayDeque<>();
        //     for (var c : s) {
        //         if (c != '*') { // 从尾巴上加，也要从尾巴上抛
        //             st.offerLast(c);
        //             continue;
        //         }
        //         if (!st.isEmpty()) 
        //             st.pollLast();
        //         continue;
        //     }
        //     StringBuilder r = new StringBuilder();
        //     while (!st.isEmpty()) 
        //         r.append(st.pollFirst());
        //     return r.toString();
        // }

        // public int garbageCollection(String[] a, int[] t) {
        //     int n = a.length, m = t.length;
        //     int [][] cnt = new int [3][n]; // M P G
        //     int [] sum = new int [n];
        //     for (int i = 1; i < n; i++) // 累积时间
        //         sum[i] = t[i-1] + sum[i-1];
        //     int r = 0;
        //     for (int i = 0; i < n; i++) {
        //         r += a[i].length();
        //         for (var c : a[i].toCharArray()) {
        //             if (c == 'M') cnt[0][i]++;
        //             else if (c == 'P') cnt[1][i]++;
        //             else cnt[2][i]++;
        //         }
        //     }
        //     for (int i = 0; i < 3; i++)
        //         for (int j = n-1; j >= 0; j--) {
        //             if (cnt[i][j] > 0) {
        //                 r += sum[j];
        //                 break;
        //             }
        //         }
        //     return r;
        // }

        // public int [] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //     // 组间组内信赖图
        //     List<List<Integer>> groupItem = new ArrayList<>();
        //     List<List<Integer>> groupGraph = new ArrayList<>();
        //     List<Integer> id = new ArrayList<>();        // m+n .....
        //     for (int i = 0; i < m+n; i++) {
        //         id.add(i);
        //         groupItem.add(new ArrayList<Integer>()); // m+n
        //         groupGraph.add(new ArrayList<Integer>());// m+n
        //     }
        //     List<List<Integer>> itemGraph = new ArrayList<>();
        //     for (int i = 0; i < n; i++)                // n items only
        //         itemGraph.add(new ArrayList<Integer>());
        //     int [] insGroup = new int[n+m];     // 组间组内依敕入度级数
        //     int [] insItem = new int[n];
        //     int leftoverId = m;                 // reassign -1 groupped items to be groupped from [m, m+1, m+n)
        //     for (int i = 0; i < n; i++) {
        //         if (group[i] == -1)
        //             group[i] = leftoverId++;    // update group[] data
        //         groupItem.get(group[i]).add(i); // leftoverId i befores to new assigned group[i]
        //     }
        //     for (int i = 0; i < n; i++) {
        //         int curGroupId = group[i];
        //         for (int item : beforeItems.get(i)) {
        //             int befGroupId = group[item];   // ids bef item i belong to which group ?
        //             if (befGroupId == curGroupId) { // 属于同一个组，进行组内排序
        //                 insItem[i] ++;
        //                 itemGraph.get(item).add(i);
        //             } else { // 不属于同一个组：构建组间依赖关系
        //                 if (groupGraph.get(curGroupId).contains(befGroupId)) return new int [0]; // 4 1  {-1, 0, 0, -1}; {{},{0},{1,3},{2}};
        //                 insGroup[curGroupId]++;
        //                 groupGraph.get(befGroupId).add(curGroupId); // group befGroupId goes before group curGroupId
        //             }
        //         }
        //     }
        //     List<Integer> groupTopSort = topSort(insGroup, groupGraph, id);
        //     if (groupTopSort.size() == 0) return new int [0];
        //     int [] ans = new int[n];
        //     int idx = 0;
        //     for (int curGroupId : groupTopSort) {
        //         int size = groupItem.get(curGroupId).size();
        //         if (size == 0) continue;
        //         List<Integer> res = topSort(insItem, itemGraph, groupItem.get(curGroupId));
        //         if (res.size() == 0) return new int [0];
        //         for (int item : res) {
        //             ans[idx++] = item;
        //         }
        //     }
        //     return ans;
        // }
// // 这个题目没有写完        
//         public int[][] buildMatrix(int k, int[][] row, int[][] col) {
//             int m = row.length, n = col.length;
//             int [] r = new int [k+1], c = new int [k+1]; // ins
//             List<Integer> [] rg = new ArrayList [k+1], cg = new ArrayList [k+1];
//             Arrays.setAll(rg, z -> new ArrayList<>()); 
//             Arrays.setAll(cg, z -> new ArrayList<>());
//             Set<Integer> ri = new HashSet<>();
//             Set<Integer> ci = new HashSet<>();
//             for (var a : row) {
//                 int u = a[0], v = a[1];
//                 r[v]++;
//                 rg[u].add(v);
//                 ri.add(u);
//                 ri.add(v);
//             }
//             for (var a : col) {
//                 int u = a[0], v = a[1];
//                 c[v]++;
//                 cg[u].add(v);
//                 ci.add(u);
//                 ci.add(v);
//             }
//             List<Integer> rr = topologicalSort(r, rg, ri); // 排得不准，只列出了一种情况，不是所有情况
//             List<Integer> cc = topologicalSort(c, cg, ci);
//             // System.out.println("rr.size(): " + rr.size());
//             // System.out.println(Arrays.toString(rr.toArray()));
//             // System.out.println("cc.size(): " + cc.size());
//             // System.out.println(Arrays.toString(cc.toArray()));
//             int [][] ans = new int [k][k];
// // 接下来应该是用gready算法一个一个往里面塞，可是感觉还是没想透，暂时不做了
//             return ans;
//         }
//         List<Integer> topologicalSort(int [] ins, List<Integer> [] g, Set<Integer> vals) {
//             ArrayDeque<Integer> q = new ArrayDeque<>();
//             for (var v : vals) 
//                 if (ins[v] == 0) q.offerLast(v);
//             List<Integer> r = new ArrayList<>();
//             while (!q.isEmpty()) {
//                 int cur = q.pollFirst();
//                 r.add(cur);
//                 for (var v : g[cur]) 
//                     if (--ins[v] == 0) q.offerLast(v);
//             }
//             return r;
//         }

//         public long distinctNames(String[] a) {
//             int n = a.length, N = 26;
//             Set<String> s = new HashSet<>(Arrays.asList(a));
//             List<String> [] ls = new ArrayList [N];
//             Arrays.setAll(ls, z -> new ArrayList<>()); 
//             for (var v : a) {
//                 char c = v.charAt(0);
//                 ls[c-'a'].add(v);
//             }
//             long r = 0;
// // 这几层嵌套的循环下来，big O ?            
//             for (int i = 0; i < N-1; i++) { // 26
//                 if (ls[i].size() == 0) continue;
//                 char ca = ls[i].get(0).charAt(0);
//                 for (var sa : ls[i]) { // 
//                     for (int j = i+1; j < N; j++) { // 26
//                         if (ls[j].size() == 0) continue;
//                         char cb = ls[j].get(0).charAt(0);
//                         for (var sb : ls[j]) { // 
//                             if (!s.contains(cb + sa.substring(1)) && !s.contains(ca + sb.substring(1)))
//                                 r++;
//                         }
//                     }
//                 }
//             }
//             return r * 2;
//         }
        // https://ssg.leetcode-cn.com/problems/naming-a-company/solution/by-endlesscheng-ruz8/
        // 上面还有几种方法也需要看一下
        // 定义cnt[i][j] 表示组中首字母不包含 ii 但包含 jj 的组的个数。
        // 枚举每个组，统计cnt，同时枚举该组的首字母 ii 和不在该组的首字母 jj，答案即为 cnt[i][j] 的累加值。
        // 简单来说就是「有 ii 无 jj」可以和「无 ii 有 jj」的字符串互换。// <<<<<<<<<< // <<<<<<<<<<<<<<<<<<<< 
        // 由于我们是一次遍历所有组，没有考虑两个字符串的顺序，最后需要把答案乘 22，表示 A+B 和 B+A 两种字符串的组合。
        // public long distinctNames(String[] a) {
        //     // [k, v]: [ a[i].substring(1), mask of all contained a[i].charAt(0) ]
        //     Map<String, Integer> m = new HashMap<>();
        //     for (var v : a) {
        //         String k = v.substring(1);
        //         m.put(k, m.getOrDefault(k, 0) | 1 << (v.charAt(0) - 'a'));
        //     }
        //     int [][] cnt = new int [26][26]; // cnt[i][j] 表示组中首字母不包含 ii 但包含 jj 的组的个数
        //     long r = 0l;
        //     for (var mask : m.values())  // 遍历所有的分组的mask首字母集合
        //         for (int i = 0; i < 26; i++) 
        //             if ((mask >> i & 1) == 0) { // 当前mask不包含 i首字母
        //                 for (int j = 0; j < 26; j++) 
        //                     if ((mask >> j & 1) > 0) // 当前mask包含j首字母
        //                         ++cnt[i][j];
        //             } else { // 当前mask包含 i首字母
        //                 for (int j = 0; j < 26; j++) 
        //                     if ((mask >> j & 1) == 0) // 当前mask包含j首字母
        //                         r += cnt[i][j];
        //             }
        //     return r * 2;
        // }

        // public boolean matchReplacement(String ss, String st, char[][] a) {
        //     n = ss.length();
        //     m = st.length();
        //     if (n < m) return false;
        //     for (var v : a) {
        //         Set<Character> set = map.get(v[0]);
        //         if (set == null) {
        //             set = new HashSet<>();
        //             map.put(v[0], set);
        //         }
        //         set.add(v[1]);
        //     }
        //     char [] s = ss.toCharArray();
        //     char [] t = st.toCharArray();
        //     Set<Character> bgn = map.getOrDefault(t[0], new HashSet<>()); // <<<<<<<<<<<<<<<<<<<< 
        //     for (int i = 0; i+m <= n; i++) {
        //         // if (s[i] != st.charAt(0) && (!map.containsKey(t[0]) || !map.get(t[0]).contains(s[i]))) continue;
        //         // if (s[i] != st.charAt(0) && !bgn.contains(s[i])) continue;
        //         if ((s[i] == t[0] || bgn.contains(s[i])) && isMatch(i, ss, st)) return true;
        //     }
        //     return false;
        // }
        // Map<Character, Set<Character>> map = new HashMap<>();
        // int m, n;
        // boolean isMatch(int idx, String ss, String tt) {
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     for (int i = idx+1; i < idx+m && i < n; i++) 
        //         if (s[i] != t[i-idx] && (!map.containsKey(t[i-idx]) || !map.get(t[i-idx]).contains(s[i]))) return false;
        //     return true;
        // }

        // public long countSubarrays(int[] a, long k) {
        //     long sum = 0, cnt = 0;
        //     for (int l = 0, r = 0; r < a.length; r++) {
        //         sum += a[r];
        //         while (sum * (r - l + 1) >= k) 
        //             sum -= a[l++];
        //         cnt += r - l + 1; 
        //     }                
        //     return cnt;
        // }

        // // 这个题其实就是所有的0都不影响数值的大小；可以全部包括
        // // 为了取得最大长度，从右往左数的1里，能加多少个就加多少个，加到最大长度
        // public int longestSubsequence(String ss, int k) {
        //     int cnt = 0, p = 1, v = 0; // count number of 1s
        //     char [] s = ss.toCharArray();
        //     for (int i = ss.length()-1; i >= 0 && v+p <= k; i--) {
        //         if (s[i] == '1') {
        //             cnt ++;
        //             v += p;
        //         }
        //         p *= 2;
        //     }
        //     return (int)ss.chars().filter(c -> c == '0').count() + cnt; // 所有0的个数 + 尽可能多1的个数
        // }

        // public static long getHeaviestPackage(List<Integer> l) {
        //     ArrayDeque<Long> s = new ArrayDeque<>();
        //     int n = l.size();
        //     long max = 0l, cur = 0l;
        //     for (int i = n-1; i >= 0; i--) {
        //         System.out.println("\n i: " + i);
        //         if (s.isEmpty() || l.get(i) < s.peekLast()) {
        //             s.offerLast((long)l.get(i) + (s.isEmpty() ? 0 : s.pollLast()));
        //             continue;
        //         }
        //         if (l.get(i) >= s.peekLast())
        //             s.offerLast((long)l.get(i));
        //         else if (i == 0 || l.get(i) <= l.get(i-1)) {
        //             cur = l.get(i);
        //             while (!s.isEmpty() && cur < s.peekLast()) {
        //                 cur += s.pollLast();
        //             }
        //             max = Math.max(max, cur);
        //             s.offerLast(cur);
        //         }
        //     }
        //     for (var v : s) 
        //         max = Math.max(max, v);
        //     return max;
        // }
        
        // public int findMaximumSustainableClusterSize(List<Integer> pl, List<Integer> bl, long pmax) {
        //     p = pl.stream().mapToInt(Integer::intValue).toArray();
        //     b = bl.stream().mapToInt(Integer::intValue).toArray();
        //     n = p.length;
        //     s = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         s[i] = (i == 0 ? 0 : s[i-1]) + p[i];
        //     int l = 1, r = n, ans = 0;
        //     while (l <= r) { // O(NlogN) sliding window for maximum O(N)
        //         int m = l + (r - l) / 2;
        //         System.out.println("\n m: " + m);
        //         System.out.println("l: " + l);
        //         System.out.println("r: " + r);
        //         if (isPossible(m, pmax)) {
        //             ans = m;
        //             l = m + 1;
        //             System.out.println("ans: " + ans);
        //         } else r = m-1;
        //     }
        //     return ans;
        // }
        // int [] p, b, s;
        // int n;
        // boolean isPossible(int v, long limit) { // sliding window to find a matched one
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 好像是双端队列，可排序的，升序排列吧(那就是一个最大堆，但是比堆效率高O(N)而不是堆的O(NlogN))
        //     for (int l = 0, r = 0; r < n; r++) { // left right
        //         while (!q.isEmpty() && r - q.peekFirst() >= v) 
        //             q.pollFirst(); // 左出不在窗口内的(最大)值
        //         if (q.isEmpty() || b[r] > b[q.peekLast()]) // 保证升序排列
        //             q.offerLast(r); // 当前入列
        //         while (r > l + v -1) l++;
        //         if (r == l + v - 1) {
        //             if ((long)((s[r] - (l == 0 ? 0 : s[l-1])) * v + b[q.peekLast()]) <= limit)
        //                 return true;
        //         }
        //     }
        //     return false;
        // }
        
        // public int mostFrequentEven(int[] a) {
        //     int n = a.length, ans = -1, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (var v : a) {
        //         if (v % 2 == 0) {
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //             if (m.get(v) >= max) {
        //                 if (m.get(v) == max)
        //                     ans = Math.min(ans, v);
        //                 else ans = v;
        //                 max = m.get(v);
        //             }
        //         }
        //     }
        //     return ans;
        // }

        // public int partitionString(String t) {
        //     int n = t.length(), cnt = 0;
        //     char [] s = t.toCharArray();
        //     Set<Character> m = new HashSet<>();
        //     for (int l = 0, i = 0; i < n; i++) { // i: right
        //         if (!m.contains(s[i])) {
        //             m.add(s[i]);
        //             continue;
        //         } else {
        //             m.clear();
        //             cnt++;
        //             m.add(s[i]);
        //         }
        //     }
        //     return cnt + 1;
        // }

        // TreeSet<Range> ts;
        // public RangeModule() {
        //     ts = new TreeSet<>((a, b) -> a.l != b.l ? a.l - b.l : a.r - b.r);
        // }
        // public void addRange(int left, int right) {
        //     int l = left, r = right;
        //     Range hi = new Range(r, Integer.MAX_VALUE);
        //     while (true) { // 相当于是合并有交集的子集
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r < l) break;
        //         if (lower.r > r) r = lower.r;
        //         if (lower.l < l) l = lower.l;
        //         ts.remove(lower);
        //     }
        //     ts.add(new Range(l, r));
        // }
        // // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
        // // ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
        // public boolean queryRange(int left, int right) {
        //     Range cur = ts.floor(new Range(left, Integer.MAX_VALUE));
        //     return cur != null && cur.l <= left && cur.r >= right;
        // }
        // public void removeRange(int left, int right) {
        //     Range hi = new Range(right, right);
        //     while (true) {
        //         Range lower = ts.lower(hi);
        //         if (lower == null || lower.r <= left) break;
        //         if (lower.r > right) ts.add(new Range(right, lower.r));
        //         if (lower.l < left) ts.add(new Range(lower.l, left));
        //         ts.remove(lower);
        //     }
        // }
        // // 不知道哪里写错了
        // class Range implements Comparable<Range> {
        //     int l, r;
        //     public Range(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     @Override public int compareTo(Range other) {
        //         return this.l - other.l;
        //     }
        // }
        // boolean vis = false;
        // public int minGroups(int[][] a) {
        //     int n = a.length;
        //     List<TreeSet<Range>> l = new ArrayList<>();
        //     for (var i : a) {
        //         Range r = new Range(i[0], i[1]);
        //         vis = false;
        //         for (var ts : l) {
        //             Range lower = ts.floor(r);
        //             Range higher = ts.ceiling(r);
        //             if ((lower == null || lower.r < r.l) && (higher == null || higher.l > r.r)) {
        //                 ts.add(r);
        //                 vis = true;
        //                 break;
        //             }
        //         }
        //         if (!vis) {
        //             TreeSet<Range> s = new TreeSet<>(); // 升序排列
        //             s.add(r);
        //             l.add(s);
        //         }
        //     }
        //     return l.size();
        // }
        // int [][] a = new int [][] {{229966,812955},{308778,948377},{893612,952735},{395781,574123},{478514,875165},{766513,953839},{460683,491583},{133951,212694},{376149,838265},{541380,686845},{461394,568742},{804546,904032},{422466,467909},{557048,758709},{680460,899053},{110928,267321},{470258,650065},{534607,921875},{292993,994721},{645020,692560},{898840,947977},{33584,330630},{903142,970252},{17375,626775},{804313,972796},{582079,757160},{785002,987823},{599263,997719},{486500,527956},{566481,813653},{211239,863969},{808577,883125},{21880,516436},{264747,412144},{327175,772333},{984807,988224},{758172,916673},{23583,406006},{954674,956043},{379202,544291},{688869,785368},{841735,983869},{99836,916620},{332504,740696},{740840,793924},{896607,920924},{868540,922727},{125849,550941},{433284,685766}};

        // public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
        //     int n = a.length, max = 1;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1); // 初始化
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] > a[i] && a[j] - a[i] <= k) {
        //                 if (f[i] + 1 > f[j]) {
        //                     f[j] = f[i] + 1;
        //                     max = Math.max(max, f[j]);
        //                 }
        //             }
        //         }
        //     return max;
        // }
        public int lengthOfLIS(int[] a, int k) { // N: [1, 10^5] 有个贪心的O(NlogN)算法，但是一时半会儿想不起来了
            int n = a.length, max = 1, N = Arrays.stream(a).max().getAsInt() + 1;
            // List<Integer>[] ll = new ArrayList[N];
            // Arrays.setAll(ll, z -> new ArrayList<>());
            // ll[a[0]].add(a[0]);
            int [][] f = new int [N][2];
            for (var v : a) {
                f[v][0] = v; // 队尾的值 
                f[v][1] = 1; // 初始化，以当前值为头的最大长度
            }
            // System.out.println("f.length: " + f.length);
            // for (int z = 0; z < f.length; ++z) 
            //     System.out.println(Arrays.toString(f[z]));

            for (int i = 1; i < n; i++) {
                System.out.println("\n i: " + i);
                for (int j = a[i]-1; j >= Math.max(1, a[i]-k); j--) {
                    System.out.println("j: " + j); 
                    if (f[j][1] > 0 && f[j][0] >= a[i] - k && f[j][1] + 1 >= f[i][1]) {
                        if (f[j][1] + 1 > f[i][1]) {
                            f[i][1] = f[j][1] + 1;
                            max = Math.max(max, f[i][1]);
                            System.out.println("max: " + max); 
                        } // 没想明白其它情况下要如何再优化一下
                    }
                }
                // if (a[i] > l.get(l.size()-1) && a[i] - l.get(l.size()-1) <= k) {
                //     l.add(a[i]);
                //     max = l.size();
                // } else {
                //     int bgn = 0, end = l.size()-1, m = -1;
                //     while (bgn <= end) {
                //         int mid = bgn + (end - bgn) / 2;
                //         if (a[i] <= l.get(mid)) {
                //             m = mid;
                //             end = mid - 1;
                //         } else bgn =  mid + 1;
                //     }
                //     if (m != -1 && l.get(m) > a[i]) // 贪心法：总是填最小可能的值在一个位置上
                //         l.set(m, a[i]);
                // }
                System.out.println("max: " + max); 
            }
            return max;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // int [] a = new int [] {4,2,1,4,3,4,5,8,15};
        // int [] a = new int [] {7,4,5,1,8,12,4,7};
        int []  a = new int []  {1, 3, 3, 4};
        System.out.println(Arrays.toString(a));
        
        int r = s.lengthOfLIS(a, 1);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);


// long weekend long trip plan, not attending this weekend's two contests. will join the next weekend's.