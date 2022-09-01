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

        
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int []  a = new int []  { 2, 1, 4, 3, 5};

       long r = s.countSubarrays(a, 10);
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