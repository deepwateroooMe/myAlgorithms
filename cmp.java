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

        // // 这个题目感觉很简单，可是里面可能还是有很多死角吧，暂时不想写了: 为什么好好的题目就被自己写出这么多的死角来了呢。。。哈哈哈
        // public boolean matchReplacement(String s, String sub, char[][] a) {
        //     int n = s.length();
        //     Map<Character, List<Character>> m = new HashMap<>();
        //     for (var v : a) // 其实这里不用遍历完，只遍历有效值(这里因为没有第一时间精简，给后面造成麻烦)
        //         m.computeIfAbsent(v[0], z -> new ArrayList<>()).add(v[1]);
        //     if (sub.length() == 1 && (m.containsKey(sub.charAt(0)) || s.indexOf(""+sub.charAt(0)) != -1)) return true;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < s.length(); i++)
        //         if (s.charAt(i) == sub.charAt(0) || m.containsKey(sub.charAt(0)) && m.get(sub.charAt(0)).contains(s.charAt(0))) l.add(i);
        //     return isSub(s, sub, l, m);
        // }
        // boolean isSub(String ss, String tt, List<Integer> l, Map<Character, List<Character>> m) {
        //     char [] s = ss.toCharArray();
        //     char [] t = tt.toCharArray();
        //     int i = 0;
        //     for (var v : l) {
        //         if (v + tt.length() > ss.length()) return false;
        //         for (i = v+1; i < v + tt.length(); i++) {
        //             if (s[i] == t[i-v]) continue;
        //             boolean matched = false;
        //             if (s[i] != t[i-v] && !m.containsKey(t[i-v])) break;
        //             if (s[i] != t[i-v] && m.containsKey(t[i-v])) {
        //                 for (var c : m.get(t[i-v])) 
        //                     if (s[i] == c) {
        //                         matched = true;
        //                         break;
        //                     }
        //             }
        //             if (s[i] != t[i-v] && !matched) break;
        //         }
        //         if (i == v + tt.length()) return true;
        //     }
        //     return false;
        // } 
        // public boolean matchReplacement(String ss, String st, char[][] a) { // 正确答案
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
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // String a = "eeeegeeeegeeeegeeeegeeeegeeeegeeeeg";
        // String b = "eeeee";
        // char [][] c = new char [][] {{'e','a'},{'e','b'},{'e','c'},{'e','d'},{'e','f'},{'e','h'},{'e','i'},{'e','j'},{'e','k'},{'e','l'},{'e','m'},{'e','n'},{'e','o'},{'e','p'},{'e','q'},{'e','r'},{'e','s'},{'e','t'},{'e','u'},{'e','v'},{'e','w'},{'e','x'},{'e','y'},{'e','z'},{'e','0'},{'e','1'},{'e','2'},{'e','3'},{'e','4'},{'e','5'},{'e','6'},{'e','7'},{'e','8'},{'e','9'},{'g','a'},{'g','b'},{'g','c'},{'g','d'},{'g','f'},{'g','h'},{'g','i'},{'g','j'},{'g','k'},{'g','l'},{'g','m'},{'g','n'},{'g','o'},{'g','p'},{'g','q'},{'g','r'},{'g','s'},{'g','t'},{'g','u'},{'g','v'},{'g','w'},{'g','x'},{'g','y'},{'g','z'},{'g','0'},{'g','1'},{'g','2'},{'g','3'},{'g','4'},{'g','5'},{'g','6'},{'g','7'},{'g','8'},{'g','9'}}; 
        
        // String a = "9314o85hn6gc0amwqxipx4lgqokxlobgbhkcp6oyamuols1f2w65il0mm4i28omxq2occg7trfm6sx7o5zkoq4po5uzmuet";
        // String b = "kcp6oyamuols1f2w65il0mm4i28omx";
        // char [][] c = new char [][] {{'a','4'}}; 

        // String a = "hfk28rigw1mwpjc5nea9ilae79kwszbdfab2n33tdzb1i9f11x95j16h0c1os4gnbh2yopgdwjx81dph66e2azkbshex2xg9gnwt13nfxmzbilicjkpodvs85q89bf3m06qxfx351zxi7t2yr7zy558q4do4xpkkw5cht23yjtfavehuhooqt6nq3dote4cl0d8";                      
        // String b = "yhbaxrc5x1cqba2j2pvn6t8s9hqq05ed6sisib2rypq8rzx0ghro4u4dfwhzxvo";
        // char [][] c = new char [][] {{'h','u'},{'r','2'},{'8','l'},{'e','r'},{'8','i'},{'h','w'},{'a','j'},{'h','o'},{'p','d'}}; 

        // String a = "27awmey8ooynp9usl9q2gg2co2eclhw3wk2uwje4m4tp71qr5s9xrieroj12hy4l6jfx01oxekipt96vqpjbfl4v686mdppgo722y1r6jk0iaeq1nd7tq1s8hr4pk0z906ntxyjtqgyzfbxmkp63x970sbjezlnvwj37bdkrrxth2x7z30oazq8dnq103ntswp2nzeef8rj89kd0it9mlj3pyw5qpggcdmsg49nz55gik6yavx2nrqt8m23i5r3p3b7nb6h46z2xbq2qrp9xo60uqioz02d54roqka2fzhk0kh4pnaofvbz";
        // String b = "ibhqq947tqqsdur0pk9r906ngxyjtqgyzzyxm6pf3l9k9nylhzl9q2l37ydkrrlthcl7z39obzqd4nqq939gnwpc9zhefdrldfkd0itfmxj3py29qpygl4msy";
        // char [][] c = new char [][] {{'c','2'},{'a','h'},{'j','h'},{'q','1'},{'l','5'},{'f','9'},{'x','l'},{'r','z'},{'b','0'},{'b','c'},{'1','5'},{'e','6'},{'v','8'},{'h','u'},{'n','i'},{'a','7'},{'g','j'},{'c','b'},{'n','e'},{'f','u'},{'j','5'},{'9','n'},{'q','w'},{'x','k'},{'e','j'},{'5','t'},{'2','w'},{'v','0'},{'m','a'},{'3','e'},{'k','7'},{'j','e'},{'y','g'},{'8','o'},{'w','v'},{'5','m'},{'5','8'},{'0','x'},{'y','b'},{'q','v'},{'h','e'},{'8','c'},{'f','6'},{'b','a'},{'d','8'},{'u','f'},{'l','x'},{'l','c'},{'u','i'},{'6','k'},{'n','s'},{'9','5'},{'z','f'},{'g','t'},{'4','d'},{'0','4'},{'l','j'},{'u','h'},{'9','0'}}; 

        String a = "f178d2vdlwpycfmqgzd55fvfyamxx3owptoik8q52uy5ssteeboauki5x3zcl4gax53lurcpvs2jdju14a9115dk9q8adb7j31a07leiy4af57szw4xqwdnpcq8qj5nrkeb30lasl80kewhn987fvorke2rwg98bntfu2cxwkte509h8iweq85s3l47ayywf8dgesoy23e4qpjmrosmh0za6heoxd6fp8onv2dgumk6vkxy72cjwzkq139qecvnvihczb29uhsv0be7ftuxtzjetgfej0ijmnoej627z0vad5ghu22hnzhpyfasuy5l9kub2bmye2qxa4k4lnt15l7i916rilgbhbcifpjn3";
        String b = "iu14at1j5dk9a8a3bzj3jb07leiycb0qzszw4xqr35omawaj5nzkjv3flb6l8fuerhnt8z0v1zkj2zwgt8vno0u2c1wuoj5f9hwireq8qs3ac7ay9wfw3sj61y23e4aojpz1";
        char [][] c = new char [][] {{'r','4'},{'z','r'},{'5','c'},{'t','y'},{'f','0'},{'3','8'},{'7','1'},{'j','1'},{'s','u'},{'o','e'},{'f','l'},{'7','g'},{'5','x'},{'o','d'},{'k','u'},{'x','w'},{'z','c'},{'8','j'},{'s','x'},{'j','p'},{'9','8'},{'h','k'},{'o','p'},{'w','8'},{'i','j'},{'c','s'},{'r','5'},{'1','x'},{'i','k'},{'u','s'},{'q','m'},{'j','l'},{'k','e'},{'i','4'},{'a','q'},{'1','3'},{'d','i'},{'w','a'},{'0','3'},{'4','v'},{'p','m'},{'s','c'},{'c','i'},{'e','w'},{'m','f'},{'0','f'},{'6','w'},{'i','v'},{'z','7'},{'8','a'},{'o','c'},{'a','l'},{'s','g'},{'r','b'},{'o','t'},{'n','a'},{'v','c'},{'5','n'},{'i','c'},{'p','d'},{'9','y'},{'u','k'},{'j','e'},{'3','d'},{'q','5'},{'m','c'},{'1','o'},{'r','w'},{'u','6'},{'b','a'},{'t','9'},{'6','s'},{'v','b'},{'1','i'},{'c','4'}}; 

        boolean r = s.matchReplacement(a, b, c);
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