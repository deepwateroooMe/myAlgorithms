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

		// // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

        // public boolean canBeEqual(String ss, String tt) {
        //     char [] s = ss.toCharArray(), t = tt.toCharArray();
        //     for (int i = 0; i < 4; i++) {
        //         if (s[i] == t[i]) continue;
        //         if (i < 2 && (s[i] == t[i+2] || s[i+2] == t[i])) {
        //             if (s[i] == t[i+2]) 
        //                 t[i+2] = t[i];
        //             else s[i+2] = s[i];
        //             continue;
        //         }
        //         return false;
        //     }
        //     return true;
        // }

        // // 如果改一个可以一样，改另一个也可以一样，所以只弄一个: 这个题目，呆会儿再写
        // public boolean checkStrings(String ss, String tt) {
        //     int n = ss.length();
        //     char [] s = ss.toCharArray(), t = tt.toCharArray();
        //     List<Integer> [] l = new ArrayList [26];
        //     Arrays.stream(l).forEach(z -> Arrays.fill(z, new ArrayList<Integer>()));
        //     for (int i = 0; i < n; i++) 
        //         ls[s[i]-'a'].add(i); // 按字母存
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == t[i]) continue;
        //         int j = s[i]-'a', k = t[i] - 'a';
        //         // 写个暴力的，可能会超时：必须带记忆，状态定义
        //         List<Integer> cur = l[k];
        //         for (int x = 0; x < cur.size(); x++) {
        //             if ((cur.get(x) - i) % 2 != 0) continue;
        //             int idx = cur.get(x);
        //             cur.remove(idx);
        //             l[k]
        //             dfs(i+1, new String())
        //         }
        //     }
        // }
        // Map<String, Boolean> m = new HashMap<>();
        
        // public long maxSum(List<Integer> li, int x, int k) { // x: # pairs 491/767
        //     n = li.size(); this.x = x;
        //     if (n == 1 && k == 1 && x == 1) return li.get(0);
        //     Map<Integer, Integer> m = new HashMap<>();
        //     long ans = 0, sum = 0;
        //     for (int r = 0, l = 0; r < n; r++) {
        //         if (r - l + 1 < k) { // 可以保证子数组的长度，固定为 k
        //             m.put(li.get(r), m.getOrDefault(li.get(r), 0) + 1);
        //             sum += (long)li.get(r);
        //             continue;
        //         }
        //         sum += (long)li.get(r);
        //         if (getCnt(m) >= x) ans = Math.max(ans, sum);
        //         System.out.println("\n r: " + r);
        //         System.out.println("sum: " + sum);
        //         if (r - l + 1 == k) {
        //             sum -= li.get(l);
        //             m.put(li.get(l), m.getOrDefault(li.get(l), 1)-1);
        //             if (m.get(li.get(l)) == 0) m.remove(li.get(l));
        //             l++;
        //         }
        //     }
        //     return ans;
        // }
        // int n, x;
        // int getCnt(Map<Integer, Integer> m) {
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, Integer> en : m.entrySet()) 
        //     //     System.out.print(en.getKey() + ", " + en.getValue() + "\n");
        //     // System.out.println("x: " + x);
        //     // System.out.println("(m.size() == 2 && x > 2): " + (m.size() == 2 && x > 2));
        //     if (m.size() <= 2 && x > 2) return 1;
        //     int r = 0;
        //     for (int k : m.keySet()) {
        //         int v = m.get(k);
        //         r += n - v;
        //     }
        //     System.out.println("(r/2): " + (r/2));
        //     return r == 0 ? 1 : r / 2;
        // }

//         // 感觉，这个死题目是骗人的，说得也不清楚，什么 k 1 <= k <= s.length, 不该是 k 在【1,26】范围内吗？骗人。。。
//         static final int mod = (int)1e9 + 7;
//         public int countKSubsequencesWithMaxBeauty(String S, int k) { // 不知道哪里写错了，改天再检查
//             int n = S.length(); char [] s = S.toCharArray();
//             int [] r = new int [26]; // frequency
//             for (int i = 0; i < n; i++) r[s[i]-'a']++;
//             // int [] f = new int [1 << k]; // 1 << 26 因为这个长度有限，数据离散，不能用这个
//             Map<Integer, Integer> m = new HashMap<>();
//             for (int i = 0; i < 26; i++) // 【初始化】：一个字符的 mask, 频率
//                 m.put((1 << i), r[i]);
//             System.out.println(Arrays.toString(r));
//             // 【动规】：动规, 就是，遍历过程中，动态更新和，与频率的过程
//             // Set<Integer> sk = new HashSet<>(); // K 长的 mask 集合
//             long ans = 0;
//             for (int i = 1; i < (1 << Math.min(n, 26)); i++) { // 遍历策略：每增加一个 bit位，只在增加这个位之前的【基】的基础上，作更新
//                 int bcnt = Integer.bitCount(i);
//                 if (bcnt == 1) continue; // 这个，我忆经初始化了
//                 for (int j = 0; j < 26; j++) { // 遍历 26 个数位，消除掉当前数位，先前有解过吗？有，就在那个基础上作更新
//                     // if ((i & (1 << j)) > 0 && m.containsKey(i - (1 << j)))
//                     if (((i >> j) & 1) == 1 && m.containsKey(i - (1 << j)))
//                         // m.put(i, m.getOrDefault(i, 0) + (r[i] * m.get(i - (1 << j)) + mod) % mod);
//                         m.put(i, (r[j] * m.get(i - (1 << j)) + mod) % mod);
//                 }
//                 if (bcnt == k) ans = (ans + m.get(i)) % mod;
//             }
//             return (int)ans;
// // int [] getSum(int v) {
//         //    int rr = 0;
//         //     long f = 1;
//         //     for (int i = 0; i < 26; i++)
//         //         if ((v & (1 << i)) > 0) {
//         //             rr = rr + r[i];
//         //             f = (f * r[i] + mod) % mod;
//         //         }
//         //     return new int [] {rr, (int)f};
//         }

        // public int countSymmetricIntegers(int l, int h) {
        //     int r = 0;
        //     for (int i = l; i <= h; i++)
        //         if (valid(i)) r++;
        //     return r;
        // }
        // boolean valid(int v) {
        //     char [] s = String.valueOf(v).toCharArray();
        //     int n = s.length;
        //     if (n % 2 == 1) return false;
        //     int r = 0;
        //     for (int i = 0; i < n/2; i++) r += s[i] - '0';
        //     for (int i = n/2; i < n; i++) r -= s[i] - '0';
        //     return r == 0;
        // }

        // public int minimumOperations(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     if (t.endsWith("00") || t.endsWith("25") || t.endsWith("50") || t.endsWith("75")) return 0;
        //     if (n == 1) return s[0] == '0' ? 0 : 1;
        //     if (n == 2) return s[0] == '0' || s[1] == '0' ? 1 : 2;
        //     // 从尾巴往前找，找两遍，数据规模小，随便写写都能过
        //     int ans = n;
        //     int [] r = new int [2]; Arrays.fill(r, -1);

        //     for (int i = n-1; i >= 0; i--) {
        //         System.out.println("\n i: " + i);
        //         if (s[i] == '0' && r[0] == -1) {
        //             r[0] = i;
        //             continue;
        //         } else if (s[i] == '5' && r[0] >= 0)
        //             return n - i - 2;
        //         else if (s[i] == '5' && r[1] == -1) {
        //             r[1] = i;
        //             continue;
        //         } else if (r[0] >= 0 && (s[i] == '0' || s[i] == '5')
        //                    || r[1] >= 0 && (s[i] == '2' || s[i] == '7')) {
        //             return n - i - 2;
        //         }
        //     }
        //     return n - (r[0] != -1 ? 1 : 0);
        // }

        // // 过会儿再写这个题目【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countInterestingSubarrays(List<Integer> li, int m, int k) {
        //     n = li.size(); this.m = m; this.k = k; 
        //     long r = 0;
        //     for (int i = 0; i * m + k <= n; i++) {
        //         System.out.println("(i * m + k): " + (i * m + k));
        //         long one = calcCnt(li, i * m + k);
        //         System.out.println("one: " + one);
        //         r += one;
        //     }
        //     return r;
        // }
        // int m, n, k;
        // long calcCnt(List<Integer> li, int cnt) {
        //     long ans = 0;
        //     int cur = 0, l = 0, r = 0;
        //     for (; r < n; r++) {
        //         System.out.println("\n r: " + r);
        //         if (li.get(r) % m == k) cur++;
        //         // 这里，右端点，还可以往右移
        //         if (cur == cnt && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         // boolean again = false;
        //         // if (cur > cnt) again = true;
        //         while (cur > cnt) {
        //             // again = true;
        //             if (li.get(l) % m == k) --cur;
        //             l++;
        //         }
        //         // if (cur == cnt && again && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         if (cur == cnt && (cnt != 0 || cnt == 0 && li.get(r) % m != k)) ans++;
        //         System.out.println("ans: " + ans);
        //     }
        //     System.out.println("ans: " + ans);
        //     System.out.println("cur: " + cur);
        //     while (l <= r && cur >= cnt) {
        //         while (cur >= cnt) {
        //             if (li.get(l) % m == k) --cur;
        //         }
        //         if (cur == cnt) ans++;
        //         l++;
        //     }
        //     System.out.println("ans: " + ans);
        //     return ans;
        // }

        // // 怎么感觉，这是个像是【最大值、最小值】线段树（还有【sum 线段树】），或是求出现次数最多元素的线段树一样。。。
        // // 最有效的帮助信息 W 【1,26】要怎么使用这个参数呢？
        // public int[] minOperationsQueries(int n, int[][] egs, int[][] qs) {
        //     g = new ArrayList [n];
        //     Arrays.stream(g).forEach(z -> Arrays.fill(z, new ArrayList<int []>()));
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].add(new int [] {v, w});
        //         g[v].add(new int [] {u, w});
        //     }
        //     // 感觉，这个题，可能可以当＝【有向图】来处理，就是随便选哪个作为【根结点】，结果都一样
        //     // 随机选定一个【根节点】预处理，建立【1,26】词频表
        //     // 动规解题, 就是先前的什么树状动规？
        //     f = new int [n][26];
        //     // 选【0】作为根结点
        //     dfs(0, -1);
        // }
        // List<int []> [] g;
        // int [][] f;
        // void dfs(int u, int p) {
        //     for (int [] v : g[u]) { // 遍历每个子节点
        //         if (v[0] == p) continue;
        //         f[u][v[1]]++; // 统计词频
        //         dfs(v[0], u);
        //     }
        // }

        // public int numberOfPoints(List<List<Integer>> ll) {
        //     int n = ll.size();
        //     int [] r = new int [102];
        //     for (List<Integer> l : ll) {
        //         r[l.get(0)]++;
        //         r[l.get(1)+1]--;
        //     }
        //     int cnt = (r[1] > 0 ? 1 : 0);
        //     for (int i = 2; i < 102; i++) {
        //         r[i] += r[i-1];
        //         if (r[i] > 0) cnt++;
        //     }
        //     return cnt;
        // }

        // // 不光能走横的、竖的，还能走斜的, 呆会儿再写这个题目
        // // 最讨厌这种破题目：就在那里瓣呀瓣，没什么意思。。。又不能提高算法能力，是专门用来折磨活宝妹的。。。讨厌他们贱鸡、贱畜牲。。。
        // public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        //     int a = Math.abs(fx - sx), b = Math.abs(fy - sy);
        //     if (a == 0 && b == 0 && t == 1) return false;
        //     if (t > a + b) {
        //         int v = t - (Math.min(a, b) + Math.abs(a - b));
        //         return  v % 2 == 0 || v % 3 == 0 || v % 5 == 0 || t - (a+b) == 1
        //             || (v-1) % 2 == 0 || (v-1) % 3 == 0 || (v-1) % 5 == 0;
        //     }
        //     return Math.min(a, b) + Math.abs(a - b) <= t && t <= a + b;
        // }

        // // 562/611: 算法不完美。【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 知道这个题狠 tricky, 可是还没有狠好的思路。。放着不写了
        // 不喜欢这个题目，瓣来瓣去狠没意思。。。
        // int [][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        // int [][] dd = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // public int minimumMoves(int[][] a) {
        //     return Math.min(minimumMovesOne(a), minimumMovesOtherDirection(a));
        // }
        // int minimumMovesOtherDirection(int[][] a) {
        //     int n = 3, cnt = 0, nn = 0;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = n-1; i >= 0; i--) 
        //         for (int j = n-1; j >= 0; j--) {
        //             if (a[i][j] == 0) continue;
        //             if (a[i][j] > 1) {
        //                 for (int[] d : dd) {
        //                     int x = i + d[0], y = j + d[1];
        //                     if (x < 0 || x >= n || y < 0 || y >= n || a[x][y] > 0) continue;
        //                     a[x][y] = 1;
        //                     ++cnt;
        //                     --a[i][j];
        //                     if (a[i][j] == 1) break;
        //                 }
        //             }
        //             if (a[i][j] > 1) l.add(new int [] {i, j});
        //         }
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             if (a[i][j] == 0) {
        //                 int [] r = l.get(0);
        //                 --a[r[0]][r[1]];
        //                 cnt += Math.abs(r[0] - i) + Math.abs(r[1] - j);
        //                 if (a[r[0]][r[1]] == 1) l.remove(0);
        //             }
        //     return cnt;
        // }
        // int minimumMovesOne(int[][] a) {
        //     int n = 3, cnt = 0, nn = 0;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++) {
        //             if (a[i][j] == 0) continue;
        //             if (a[i][j] > 1) {
        //                 System.out.println("\n i: " + i);
        //                 System.out.println("j: " + j);
        //                 for (int[] d : dirs) {
        //                     int x = i + d[0], y = j + d[1];
        //                     if (x < 0 || x >= n || y < 0 || y >= n || a[x][y] > 0) continue;
        //                     a[x][y] = 1;
        //                     ++cnt;
        //                     --a[i][j];
        //                     if (a[i][j] == 1) break;
        //                     System.out.println("cnt: " + cnt);
        //                 }
        //             }
        //             if (a[i][j] > 1) l.add(new int [] {i, j});
        //         }
        //     // System.out.println("a.length: " + a.length);
        //     // for (int z = 0; z < a.length; ++z) 
        //     //     System.out.println(Arrays.toString(a[z]));
        //     // System.out.println("cnt: " + cnt);
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             if (a[i][j] == 0) {
        //                 int [] r = l.get(0);
        //                 --a[r[0]][r[1]];
        //                 cnt += Math.abs(r[0] - i) + Math.abs(r[1] - j);
        //                 if (a[r[0]][r[1]] == 1) l.remove(0);
        //             }
        //     return cnt;
        // }

        // public int numberOfWays(String s, String t, long k) {
        //     return 0;
        // }

		// public String maximumOddBinaryNumber(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int r = 0;
		// 	for (int i = 0; i < n; i++)
		// 		if (s[i] == '1') r++;
		// 	int i = 0;
		// 	while (r > 1) {
		// 		s[i] = '1';
		// 		i++;
		// 		r--;
		// 	}
		// 	while (i < n-1) {
		// 		s[i] = '0';
		// 		i++;
		// 	}
		// 	s[i] = '1';
		// 	return new String(s);
		// }

		// // 暂时，先把它当贪心算法来写. 感觉这个思路想得不是狠清楚，今天晚上不写了，弄 emacs-configuration
		// public long maximumSumOfHeights(List<Integer> li) {
		// 	int n = li.size();
		// 	int max = 0, idx = -1;
		// 	for (int i = 0; i < n; i++) {
		// 		int v = li.get(i);
		// 		if (v > max) {
		// 			max = v;
		// 			idx = i;
		// 		}
		// 	}
		// 	long sum = max;
		// 	int i = idx -1, prev = max;
		// 	while (i >= 0) {
		// 		int v = li.get(i);
		// 		if (v > prev) sum += prev;
		// 		else {
		// 			sum += v;
		// 			prev = v;
		// 		}
		// 		--i;
		// 	}
		// 	i = idx + 1;
		// 	prev = max;
		// 	while (i < n) {
		// 		int v = li.get(i);
		// 		if (v > prev) sum += prev;
		// 		else {
		// 			sum += v;
		// 			prev = v;
		// 		}
		// 		i++;
		// 	}
		// 	return sum;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long maximumTripletValue(int[] a) {
		// 	int n = a.length;
		// 	long max = 0, r = 0;
		// 	for (int i = 0; i+2 < n; i++) 
		// 		for (int j = i+1; j+1 < n; j++) 
		// 			for (int k = j+1; k < n; k++) 
		// 				r = Math.max(r, (long)(a[i] - a[j]) * a[k]);
		// 	return r < 0 ? 0 : r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long maximumTripletValue(int[] a) {
		// 	int n = a.length;
		// 	int [] l = new int [n], r = new int [n];
		// 	Arrays.fill(l, -1); 
		// 	Arrays.fill(r, -1);
		// 	ArrayDeque<Integer> s = new ArrayDeque<>();
		// 	for (int i = n-1; i >= 0; i--) { // 从右往左：弟减
		// 	while (!s.isEmpty() && s.peekFirst() <= a[i] && s.size() > 1) s.pollFirst();
		// 		if (!s.isEmpty()) r[i] = s.peekLast();
		// 		if (!s.isEmpty() && s.peekFirst() <= a[i]) s.pollFirst();
		// 		s.addFirst(a[i]);
        //     }
		// 	s.clear();
		// 	for (int i = 0; i < n; i++) {
		// 		while (!s.isEmpty() && s.peekLast() <= a[i] && s.size() > 1) s.pollLast();
		// 		if (!s.isEmpty()) l[i] = s.peekFirst();
		// 		if (!s.isEmpty() && s.peekLast() <= a[i]) s.pollLast();
		// 		s.addLast(a[i]);
		// 	}
		// 	System.out.println(Arrays.toString(l));
		// 	System.out.println(Arrays.toString(r));
		// 	long ans = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		if (l[i] == -1 || r[i] == -1) continue;
		// 		ans = Math.max(ans, (long)(l[i] - a[i]) * r[i]);
		// 	}
		// 	return ans;
		// }
		
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minSizeSubarray(int[] nums, int target) {
		// 	return 0;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目好难，见过，忘记了：。。
		// // 亲爱的表哥的活宝妹，也是半个小天才。。
		// // 会被贱鸡、贱畜牲的破烂XX 给毁掉，可是人造灵魂的工程师，却可以打造灵魂与艺术杰作。。。亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！
		// public int[] countVisitedNodes(List<Integer> es) {
		// 	Arrays.stream(g).forEach(z -> Arrays.fill(z, new ArrayList<Integer>()));
		// 	int n = es.size();
		// 	for (int i = 0; i < n; i++)
		// 		g[i].add(es.get(i));
		// 	d = new int [n]; // 可是，感觉忘记这个算法了。。。
		// 	f = new int [n]; // d: bgn f: end
		// 	int [] r = new int [n];
		// 	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// }
		// List<Integer> [] g;
		// int [] d, f;

		// public int differenceOfSums(int n, int m) {
		// 	int r = 0;
		// 	for (int i = 1; i <= n; i++)
		// 		if (i % m == 0) r += i;
		// 	return (n * (n + 1) / 2 - r) - r;
		// }

		// // 二分查找：
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minProcessingTime(List<Integer> t, List<Integer> li) {
		// 	n = t.size();
		// 	Collections.sort(t);  // 这个，可以排序，没有关系
		// 	Collections.sort(li);
		// 	int l = t.get(0) + li.get(3);
		// 	int r = t.get(n-1) + li.get(4 * (n-1) + 3);
		// 	int ans = r;
		// 	while (l <= r) {
		// 		System.out.println("\n l: " + l);
		// 		System.out.println("r: " + r);
		// 		int m = (r - l) / 2 + l;
		// 		System.out.println("m: " + m);
		// 		if (check(m, t, li)) {
		// 			ans = Math.min(ans, m);
		// 			System.out.println("ans: " + ans);
		// 			r = m-1;
		// 		} else l = m + 1;
		// 	}
		// 	return ans;
		// }
		// int n;
		// boolean check(int v, List<Integer> t, List<Integer> li) {
		// 	System.out.println("v: " + v);
		// 	int i = 0, j = 4*(n-1)+3, r = 0, cnt = 0, curMax = 0;
		// 	while (i <= j) {
		// 		int x = t.get(r);
		// 		if (x + li.get(j) > v) return false;
		// 		j -= 4;
		// 		r++;
		// 	}
		// 	return true;
		// }

		// // 这个死题目，忘记得好干净，感觉像该是【动规】，可是亲爱的表哥的活宝妹，现在还是先从【记忆化深搜】来写。。
		// public int minOperations(String S, String T, int x) { // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 	n = S.length(); this.x = x; 
		// 	s = S.toCharArray(); t = T.toCharArray();
		// 	f = new Integer [n][4];
		// 	int v = dfs(0, 0); 
		// 	return v >= Integer.MAX_VALUE / 2 ? -1 : v;
		// }
		// char [] s, t;
		// int n, x;
		// Integer [][] f;
		// int dfs(int i, int j) { // i: idx; j: 0-1 假定前面的都弄好了。。
		// 	System.out.println("\n i: " + i);
		// 	System.out.println("j: " + j);
		// 	if (i == n) return (j == 0 ? 0 : Integer.MAX_VALUE / 2);
		// 	if (f[i][j] != null) return f[i][j];
		// 	if (s[i] == t[i] && j < 2)
		// 		return f[i][j] = dfs(i+1, j);
		// 	else if (s[i] == t[i]) // 2 3: 要么连续，要么不连续＋1
		// 		return f[i][j] = Math.min(1 + dfs(i+1, j), dfs(i+1, 1-(j-2)) + (j == 3 ? 0 : x));
		// 	if (s[i] != t[i] && j >= 2) // 2 3
		// 		return f[i][j] = dfs(i+1, j-2);
		// 	else if (s[i] != t[i] && j == 1)
		// 		return f[i][j] = Math.min(dfs(i+1, 0), 1 + dfs(i+1, 3));
		// 	f[i][j] = Math.min(x + dfs(i+1, 1), 1 + dfs(i+1, 2));
		// 	return f[i][j];
		// }

		// public int[] findIndices(int[] a, int idxdiff, int valdiff) {
		// 	int n = a.length;
		// 	for (int i = 0; i < n; i++)
		// 		for (int j = i + idxdiff; j < n; j++) {
		// 			if (Math.abs(a[i] - a[j]) >= valdiff)
		// 				return new int [] {i, j};
		// 		}
		// 	return new int [] {-1, -1};				
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public String shortestBeautifulSubstring(String t, int k) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int [] r = new int [n+1];
		// 	for (int i = 0; i < n; i++)
		// 		r[i+1] = r[i] + (s[i] == '1' ? 1 : 0);
		// 	String ans = "";
		// 	int min = n;
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	m.put(0, -1);
		// 	for (int i = 0; i < n; i++) {
		// 		System.out.println("\n i: " + i);
		// 		if (m.containsKey(r[i+1] - k)) {
		// 			int j = m.get(r[i+1] - k);
		// 			int len = i - j;
		// 			String cur = t.substring(j+1, i+1);
		// 			if (len <= min || ans.equals("")) {
		// 				if (ans.equals("") || len < min || len == min && cur.compareTo(ans) < 0)
		// 					ans = cur;
		// 				if (len < min) min = len;
		// 			}
		// 		}
		// 		m.put(r[i+1], i);
        //     }
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个思路有点儿问题：保留最大值，可能不能保证 idx 
		// public int [] findIndices(int [] a, int idxdiff, int valdiff) {
		// 	int n = a.length;
		// 	int [] l = new int [n], r = new int [n];
		// 	Arrays.fill(l, -1);
		// 	Arrays.fill(r, -1);
		// 	ArrayDeque<Integer> s = new ArrayDeque<>();
		// 	// 从右往左，递减
		// 	s.offerFirst(n-1);
		// 	for (int i = n-2; i >= 0; i--) {
		// 		while (s.size() > 1 && a[i] >= a[s.peekFirst()]) s.pollFirst();
		// 	    if (s.peekLast() - i >= idxdiff)
		// 			r[i] = s.peekLast(); // 记的是：右边第一个比当前数大的下标
		// 		if (a[i] > a[s.peekFirst()]) s.pollFirst();
		// 		if (s.isEmpty() || a[s.peekFirst()] > a[i])
		// 			s.offerFirst(i);
		// 	}			
		// 	s.clear();
		// 	// 从左往右，递减
		// 	s.offerFirst(0);
		// 	for (int i = 1; i < n; i++) {
		// 		while (s.size() > 1 && a[s.peekLast()] <= a[i]) s.pollLast();
		// 		if (i - s.peekLast() >= idxdiff)
		// 			l[i] = s.peekFirst();
		// 		if (a[s.peekLast()] < a[i]) s.pollLast();
		// 		if (s.isEmpty() || a[s.peekLast()] > a[i])
		// 			s.offerLast(i);
		// 	}
		// 	System.out.println(Arrays.toString(l));
		// 	System.out.println(Arrays.toString(r));
		// 	for (int i = 0; i < n; i++) { // 遍历，以当前数为最小值 
		// 		if (l[i] != -1 && Math.abs(l[i] - i) >= idxdiff && Math.abs(a[l[i]] - a[i]) >= valdiff)
		// 			return new int [] {l[i], i};
		// 		if (r[i] != -1 && Math.abs(r[i] - i) >= idxdiff && Math.abs(a[r[i]] - a[i]) >= valdiff)
		// 			return new int [] {i, r[i]};
		// 	}
		// 	if (n == 1 && idxdiff == 0 && valdiff == 0) return new int [] {0, 0};
		// 	return new int [] {-1, -1};
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 不知道这个题目，说的是什么意思。。。
		// static final int mod = 12345;
		// public int[][] constructProductMatrix(int[][] a) {
		// 	int m = a.length, n = a[0].length, cnt = 0;
		// 	long r = 1;
		// 	boolean hasZero = false;
		// 	for (int i = 0; i < m; i++)
		// 		for (int j = 0; j < n; j++)
		// 			if (a[i][j] % mod == 0) {
		// 				a[i][j] = 0;
		// 				hasZero |= true;
		// 				cnt++;
		// 			} else r = (r * (long)a[i][j]) % (long)mod;
		// 	System.out.println("r: " + r);
		// 	int [][] ans = new int [m][n];
		// 	if (cnt == m*n) r = 0;
		// 	for (int i = 0; i < m; i++)
		// 		for (int j = 0; j < n; j++)
		// 			if (a[i][j] == 0) 
		// 				ans[i][j] = (int)r;
		// 			else if (hasZero) ans[i][j] = 0;
		// 			else ans[i][j] = (int)(r / a[i][j] + mod) % mod;
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumSum(int[] a) {
		// 	int n = a.length, r = 151;
		// 	for (int i = 0; i < n; i++)
		// 		for (int j = i+1; j+1 < n; j++)
		// 			for (int k = j+1; k < n; k++) 
		// 				if (a[i] < a[j] && a[j] > a[k])
		// 					r = Math.min(r, a[i] + a[j] + a[k]);
		// 	return r == 151 ? -1 : r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumSum(int[] a) {
		// 	int n = a.length, ans = Integer.MAX_VALUE;
		// 	ArrayDeque<Integer> s = new ArrayDeque<>();
		// 	int [] l = new int [n], r = new int [n];
		// 	Arrays.fill(l, -1); Arrays.fill(r, -1);
		// 	s.offerFirst(a[0]);
		// 	for (int i = 1; i < n; i++) {
		// 		while (!s.isEmpty() && s.peekLast() >= a[i]) s.pollLast();
		// 		if (!s.isEmpty()) l[i] = s.peekFirst();
		// 		s.offerLast(a[i]);
		// 	}
		// 	s.clear();
		// 	s.offerFirst(a[n-1]);
		// 	for (int i = n-2; i >= 0; i--) {
		// 		while (!s.isEmpty() && s.peekFirst() >= a[i]) s.pollFirst();
		// 		if (!s.isEmpty()) r[i] = s.peekLast();
		// 		s.offerFirst(a[i]);
		// 	}
		// 	System.out.println(Arrays.toString(l));
		// 	System.out.println(Arrays.toString(r));
		// 	for (int i = 1; i < n-1; i++) 
		// 		if (l[i] != -1 && r[i] != -1)
		// 			ans = Math.min(ans, l[i] + a[i] + r[i]);
		// 	return ans == Integer.MAX_VALUE ? -1 : ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minGroupsForValidAssignment(int[] a) {
		// 	int n = a.length, r = 0;
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	for (int v : a)
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	int min = Collections.min(m.values());// 一个最小的组，次数。这里面还涉及【最小公约数】的问题？6, 14%6=2 etc 
		// 	for (int v : m.values()) {
		// 			}
		// }

		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 这个题目好难，只能【动规】：也不是，应该也是可以【记忆化深搜】的！！！
		public int minimumChanges(String t, int k) {// [2,200] [1,n/2]
			n = t.length(); s = t.toCharArray();
			a = new int [n][n];
			Arrays.stream(p).forEach(z -> Arrays.fill(z, n));// 【初始化】：为 n
			prep(); // preprocessing a[i][j]
			f = new Integer [n][k+1];
			return dfs(0, k);
		}
		char [] s;
		int n;
		Integer [][] f;
		int [][] a; // pre-processing: cost of [i,j] to be semi-palindrome
		int dfs(int i, int j) {
			if (i == n-1) return Integer.MAX_VALUE / 2; // 特殊：可以不用记住在 f[i][j] 里，并且 j<0? 是可能的？
			if (i == n) return j == 0 ? 0 : Integer.MAX_VALUE / 2;
			if (f[i][j] != null) return f[i][j];
			int r = n-i - (j-1)*2, idx = (j == 1 ? n-1 :  n - (j-1) * 2 -1);// 最后一个可能的下标
			for (int k = i+2; k <= idx; k++)// 遍历一段：所有可能的，当前片段的最大长度范围，取全局最小值  
				if (a[i][k] < k-i) r = Math.min(r, a[i][k] + dfs(k, j-1));
			return f[i][j] = r;
		}
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 这里，可能还涉及字符串的预处理：[i,j] 变成 semi-palindrome 的最小代价，预处理一下就可以了O(1) 拿到结果
	// 2: aa
	// 3: aba
	// 4: ab-ab aaaa
	// 5: aaaaa
	// 6: abxyab abcabc
	// 7: aaaaaa
	// 8: abababab abcdabcd aaaa-aaaa
	// 9: abcxyzabc aaa-aaa-aaa
	// 10:
		int prep() {// 这个【预处理】：还有【动规】的机关吗？题目的重点，就落到这里来了
			for (int i = 0; i < n; i++)
				for (int j = i+2; j < n; j++) {
					int m = j - i;
					a[i][j] = j - i;// 真正【初始化】为，片段长度
					for (int k = m-1; k >= 1; k--) { // 这个暴力解法 N[1,200] 不知道是否会超时。。
						if (m % k != 0) continue;
						// 【机关来了】：长度为 k 的片段，的 m%k 次重复：比较两个字符串，是否一样？，有个算法。。
						// 【机关来了】：上面不仅仅是是否一样，而是动规，算最小修改代价。。这个细节，本身是个【动规】算法题目。。忘记细节了：数组、长度相等的连续子数组，某些要求。。
					}						
				}
		}
		// boolean isSemiPalindrome(int i, int j) { // s[bgn,end) 【关，尾）
		// 	if (j - i <= 1) return false;
		// 	if (j - i == 2) return s[i] == s[i+1];
		// 	int n = j - i;
		// }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

		int [] a = new int [] {2, 3, 2, 1};
		System.out.println(Arrays.toString(a));

		int r = s.minimumSum(a);
		System.out.println("r: " + r);
    }

}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】