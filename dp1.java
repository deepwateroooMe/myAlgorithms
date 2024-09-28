import com.ListNode;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;

public class dp1 {
    public static class Solution {

		// // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public List<String> getLongestSubsequence(String[] s, int[] a) {
		// 	int n = a.length, l = 0, r = 0, i = 0, p = -1; // l:0 r:1
		// 	List<String> ll = new ArrayList<>(), rr = new ArrayList<>();
		// 	// 数一遍：0 打头的
		// 	while (i < n && a[i] == 1) i++;
		// 	if (i == n) return new ArrayList<String>(List.of(s[0]));
		// 	l++;
		// 	ll.add(s[i]);
		// 	p = 0;
		// 	while (i < n) {
		// 		if (a[i] == 1 - p) {
		// 			l++;
		// 			p = 1 - p;
		// 			ll.add(s[i]);
		// 		}
		// 		i++;
		// 	}
		// 	// 再数一遍：1 打头的
		// 	i = 0;
		// 	while (i < n && a[i] == 0) i++;
		// 	if (i == n) return new ArrayList<String>(List.of(s[0]));
		// 	r++;
		// 	rr.add(s[i]);
		// 	p = 1;
		// 	while (i < n) {
		// 		if (a[i] == 1 - p) {
		// 			r++;
		// 			p = 1 - p;
		// 			rr.add(s[i]);
		// 		}
		// 		i++;
		// 	}
		// 	return l >= r ? ll : rr;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这里，【从头向尾巴】遍历，要数，从0 下标开始，累积翻转过的次数
		// public int minOperations(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		if (a[i] == 1 && r % 2 == 0 || a[i] == 0 && r % 2 == 1) continue;
		// 		r++;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 改天再写这类狗屁数数的破烂题目。。
		// public int numberOfArithmeticSlices(int[] a) {
        //     int n = a.length, i = 1, j = 0, r = 0, d = a[1] - a[0];
        //     if (n < 3) return 0;
		// 	for (; i < n-1; i++) { // i:right j:left r:ans
		// 		if (a[i+1] - a[i] == d) continue;
		// 		// 这里，怎么数个数呢？不知道怎么数的【TODO】：
		// 	}
        //     // while (i < n) {
        //     //     while (i < n-1 && a[i+1] - a[i] == d) i++;
        //     //     r++; // 这么写，显然不对！！
        //     //     ++i;
        //     //     if (i == n) return r;
        //     //     d = a[i] - a[i-1];
        //     // }
        //     return r;
        // }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minDistance(String S, String T) {
        //     int m = S.length(), n = T.length();
		// 	if (m * n == 0) return m + n;
        //     char [] s = S.toCharArray();
        //     char [] t = T.toCharArray();
        //     int [][] f = new int [m+1][n+1];
		// 	// 先前，像是根本就不会、不知道，该如何去想这类问题
		// 	for (int i = 0; i <= n; i++)
		// 		f[0][i] = i;
		// 	for (int i = 0; i <= m; i++)
		// 		f[i][0] = i;
		// 	for (int i = 1; i <= m; i++) 
		// 		for (int j = 1; j <= n; j++) {
		// 			if (s[i-1] == t[j-1])
		// 				f[i][j] = 1 + Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1]-1);
		// 			else
		// 				f[i][j] = 1 + Math.min(Math.min(f[i-1][j], f[i][j-1]), f[i-1][j-1]);
		// 		}
		// 	return f[m][n];
        // }

		// // 【亲爱的表哥的活宝妹，任何时候亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	    // // 【TODO】：这里，亲爱的表哥的活宝妹，就是还没能想明白：到底哪里写错了，为什么两个数组，算出来的值是一样的，叶子的处理不对？
		// public long maximumScoreAfterOperations(int[][] egs, int[] a) {
		// 	n = a.length + 1; this.a = a; 
		// 	f = new long [n]; 
		// 	s = new long [n];
		// 	g = new ArrayList[n];
		// 	Arrays.setAll(g, z -> new ArrayList<>());
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1];
		// 		g[u].add(v);
		// 		g[v].add(u);
		// 	}
		// 	// 遍历树：求以每个节点为根节点的子树的和
		// 	dfs(0, -1);
		// 	System.out.println(Arrays.toString(f));
		// 	System.out.println(Arrays.toString(s));
		// 	return f[0];
		// }
		// int n; int [] a;
		// List<Integer> [] g;
		// long [] f;  // dp
		// long [] s; // sum of subtree
		// // 感觉，这里，哪里，亲爱的表哥的活宝妹，写得顺序不对！所以算得结果不对！可是亲爱的表哥的活宝妹的脑袋，今天不怎么转，要改天再回来想这个问题。。
		// void dfs(int u, int p) {
		// 	long sum = 0; // dp sum of children
		// 	for (int v : g[u]) {
		// 		if (v == p) continue;
		// 		dfs(v, u);
		// 		s[u] += s[v];
		// 		sum += f[v];
		// 	}
		// 	f[u] = Math.max(s[u], (long)a[u] + sum);
		// 	s[u] += a[u];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 解法一：暴力【记忆化深搜】：知道了采用这个思路，亲爱的表哥的活宝妹，应该能够把它写得出来了，才对！！
		// // 亲爱的表哥的活宝妹，写出来的【记忆化深搜】的答案，简直就是标准答案！！
		// public int minimumOperations(int[][] a) {
		// 	m = a.length; n = a[0].length;
		// 	// 统计记忆：每列，【0-9】出现的频率
		// 	r = new int [n][10];
		// 	for (int j = 0; j < n; j++)
		// 		for (int i = 0; i < m; i++) 
		// 			r[j][a[i][j]]++;
		// 	f = new int [n][11];
		// 	Arrays.stream(f).forEach(z -> Arrays.fill(z, -1));
		// 	dfs(n-1, 10);
		// 	return m * n - Arrays.stream(f[n-1]).max().getAsInt();
		// }
		// int [][] r;
		// int [][] f;
		// int m, n;
		// int dfs(int i, int j) {
		// 	if (i < 0) return 0;
		// 	if (f[i][j] != -1) return f[i][j];
		// 	int ans = 0;
		// 	for (int k = 0; k < 10; k++) {
		// 		if (k == j) continue;
		// 		ans = Math.max(ans, r[i][k] + dfs(i-1, k));
		// 	}
		// 	return f[i][j] = ans;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 方法二：递推 + 优化。亲爱的表哥的活宝妹，感觉源码看得懂，也写得出来，可是没能想透：它为什么，可以保障拿到最优化的解？？？
		// // 能这么一列一列递推过去，原因是背后埋藏着【贪心、逻辑】！所以更严格地说，应该是【贪心解法＋必要的优化】
		// public int minimumOperations(int[][] a) {
		// 	int m = a.length, n = a[0].length;
		// 	int pre = -1, f = 0, ff = 0; // f:best result ff:sec best result 
		// 	int [] r = new int [10];
		// 	// 遍历：每一列，递推至最后一列
		// 	for (int j = 0; j < n; j++) {
		// 		// 统计：每一列中【0-9】各数字出现的频次
		// 		Arrays.fill(r, 0);
		// 		for (int [] row : a)
		// 			r[row[j]]++;
		// 		int max = 0, sec = 0, v = -1;
		// 		for (int i = 0; i < 10; i++) {
		// 			int cur = (i == pre ? ff : f) + r[i];
		// 			if (cur > max) {
		// 				sec = max;
		// 				max = cur;
		// 				v = i;
		// 			} else if (cur > sec)
		// 				sec = cur;
		// 		}
		// 		f = max;
		// 		ff = sec;
		// 		pre = v;
		// 	}
		// 	return m * n - f;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹呀，一年前的亲爱的表哥的活宝妹，解题，肿么，就这么不着边际呢？！！
		// // 【记忆化深搜】：f[m][n][m+n]=100*100*200 = O(2*10^6) 应该也还、不至于超时！！
		// // 【记忆化深搜】存在的问题是：不曾记忆，S 与SS 各自、所拆分的小串的个数 xy 并且保障 Math.abs(x-y)<=1
		// // 以及【双、三、指针法】都存在上面的问题：不曾记忆，两个串里拆分过的次数。。
        // public boolean isInterleave(String S, String SS, String T) { 
        //     int m = S.length(), n = SS.length();
        //     if (m + n != T.length()) return false;
		// 	s = S.toCharArray();
		// 	t = SS.toCharArray();
		// 	u = T.toCharArray();
		// 	f = new Boolean [m][n][m+n];
		// 	return dfs(0, 0, 0);
        // }
		// Boolean [][][] f;
		// int m, n;
		// char [] s, t, u;
		// boolean dfs(int i, int j, int k) {
		// 	if (i == m && j == n && k == m +n) return true;
		// 	if (f[i][j][k] != null) return f[i][j][k];
		// 	if (s[i] != u[k] && t[j] != u[k]) return false;
		// 	boolean ans = false;
		// 	if (s[i] == u[k] && dfs(i+1, j, k+1)) return f[i][j][k] = true;
		// 	if (t[j] == u[k] && dfs(i, j+1, k+1)) return f[i][j][k] = true;
		// 	return f[i][j][k] = false;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【动规】解法：可是，这个题目，与没有数两个串，所曾拆分的细小个数呀。。。没想明白。。。
		// // 关键，不是在数个数？而是在，移动双指针，可是记忆化深搜时，是否遍历过了、所有可能的解，而不是漏掉可能性？可是假阳性返真呢？感觉这里还是没想明白。。。【TODO】：
        // public boolean isInterleave(String S, String SS, String T) { 
        //     int m = S.length(), n = SS.length();
		// 	if (m + n != T.length()) return false;
		// 	char [] s = S.toCharArray(), t = SS.toCharArray(), o = T.toCharArray();
		// 	// if (s[0] != o[0] && t[0] != o[0]) return false; // 这个特殊情况，可以被后面的笼罩到。。
		// 	boolean [][] f = new boolean [m+1][n+1];
		// 	f[0][0] = true;// 初始化
		// 	for (int i = 0; i <= m; i++) 
		// 		for (int j = 0; j <= n; j++) {
		// 			if (i > 0)
		// 				f[i][j] = f[i][j] || (s[i-1] == o[i+j-1] && f[i-1][j]);
		// 			if (j > 0)
		// 				f[i][j] = f[i][j] || (t[j-1] == o[i+j-1] && f[i][j-1]);
		// 		}
		// 	return f[m][n];
		// }
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 上面【动规】：【滚动数组】空间优化
//         public boolean isInterleave(String S, String SS, String T) { 
//             int m = S.length(), n = SS.length();
// 			if (m + n != T.length()) return false;
// 			char [] s = S.toCharArray(), t = SS.toCharArray(), o = T.toCharArray();
// 			boolean [] f = new boolean [n+1]; // 这里，滚动的 S 的行，把行的这一维去掉；所以永远以列【j】来更新
// 			f[0] = true;
// 			for (int i = 0; i <= m; i++)
// 				for (int j = 0; j <= n; j++) {
// 					int k = i + j - 1;
// 					if (i > 0) 
// 						// f[i] = f[i-1] && s[i-1] == o[k]; // 重置、更新：这里写错了！！！
// // 需要满足： s[i-1] == o[k] && f[i-1][j] 但 i-1 这个行、这个行维度、从记忆数组优化掉了，就必须 f[j] == true 才会为真，所以是【新一行滚动时的重置值】！！
// 						f[j] = f[j] && s[i-1] == o[k]; 
// 					if (j > 0)
// 						f[j] = f[j] || t[j-1] == o[k] && f[j-1]; // 累加效果
// 				}
// 			return f[n];
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maximizeTheProfit(int n, List<List<Integer>> ll) {
		// 	// 【滚动、最大堆】：能合并成一个吗？
		// 	Queue<int []> p = new PriorityQueue<>((x, y) -> (x[1] != y[1] ? y[1] - x[1] : y[0] - x[0])); // 利率最大堆
		// 	Queue<int []> q = new PriorityQueue<>((x, y) -> (x[0] - y[0])); // 尾结点、最小堆
		// 	int [] f = new int [n];
		// 	Collections.sort(ll, (x, y)->x.get(0) != y.get(0) ? x.get(0) - y.get(0) : x.get(1) - y.get(1));
		// 	int r = 0;
		// 	for (int i = 0; i < ll.size(); i++) {
		// 		List<Integer> l = ll.get(i); // s e v 
		// 		int s = l.get(0), e = l.get(1), v = l.get(2);
		// 		// 不符合条件的、交叉：放回至待用
		// 		while (!p.isEmpty() && p.peek()[0] > s)
		// 			q.offer(p.poll());
		// 		// 符合条件的待用：重新添加至、合法有效最大堆
		// 		while (!q.isEmpty() && q.peek()[0] < s) p.offer(q.poll());
		// 		// 取最优解
		// 		f[e] = Math.max(f[e], (p.isEmpty() ? 0 : p.peek()[1]) + v);
		// 		q.offer(new int [] {e, f[e]});
		// 		r = Math.max(r, f[e]);
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，现在看这个题目，就是个最简单的 dp, 为什么先前不会写呢？
		// // 【动规】：这个题目，最主要就是，设计动规的【记忆数组】？第一维：N=[1,10^5] 第二维：leet 要数四个东西，可不可以【4<<1】用几个数位来表示，应该也不会超时
		// // 亲爱的表哥的活宝妹，笨宝妹，还是先写【记忆化深搜】
		// static final int mod = (int)1e9 + 7;
		// public int stringCount(int n) {
		// 	m.put('l', 3); m.put('t', 2); m.put('e', 1); this.n = n; 
		// 	s.addAll(List.of('l', 't', 'e'));
		// 	f = new Long [n][1 << 4]; // l t e e
		// 	return (int)dfs(0, 0);
		// }
		// Map<Character, Integer> m = new HashMap<>();
		// Set<Character> s = new HashSet<>();
		// int n;
		// Long [][] f;
		// long dfs(int i, int j) { // j: 几个必需要字符的、包含情况 mask
		// 	if (i == n) return j == 15 ? 1 : 0;
		// 	if (j > 15) return 0;
		// 	if (f[i][j] != null) return f[i][j];
		// 	long r = 0;
		// 	for (int k = 0; k < 26; k++) {
		// 		char c = (char)(k + 'a');
		// 		if (s.contains(c)) { // l t e
		// 			// 如果是 l, t, 1st e
		// 			if (((j >> m.get(c)) & 1) == 0) 
		// 				r = (r + dfs(i+1, j | (1 << m.get(c)))) % mod;
		// 			// else if (c == 'e') // 2nd e: 这里限制条件：没能、足够精确、到位. 这里写错了！！！
		// 			else if (c == 'e' && (j & 1) == 0) // 2nd e: 这里限制条件：没能、足够精确、到位
		// 				r = (r + dfs(i+1, j|1)) % mod;
		// 			else // 其它的：第3 第 4 第567 个 e
		// 				r = (r + dfs(i+1, j)) % mod;
		// 		} else // 其它，任何普通字符
		// 			r = (r + dfs(i+1, j)) % mod;
		// 	}
		// 	return f[i][j] = r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【记忆化深搜】：
        // public int minimumBeautifulSubstrings(String S) {
        //     n = S.length(); this.t = S; 
        //     s = S.toCharArray();
		// 	if (s[n-1] == '0') return -1;
        //     f = new int [n];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
		// 	int r = dfs(0); 
		// 	System.out.println("r: " + r);
        //     return r >= Integer.MAX_VALUE / 2 ? -1 : r;
        // }
        // int [] f;
        // int n; char [] s; String t;
        // int dfs(int i) {
        //     if (i == n) return 0;
        //     if (f[i] != Integer.MAX_VALUE / 2) return f[i];
        //     if (s[i] == '0') return f[i] = Integer.MAX_VALUE / 2 + 1; // 记忆
		// 	// 下面， s[i]=='1'
        //     int r = Integer.MAX_VALUE / 2;
        //     // for (j = n; j >= i+1; j--) {
		// 	for (int j = i+1; j <= n; j++) {
		// 		// 【写错了】：下面，判断一个数是否是5 的N 次幂，不能如下。。
        //         // if (j - i >= 3 && t.substring(j-3, j).equals("101")) {
		// 		int v = Integer.parseInt(t.substring(i, j), 2);
		// 		System.out.println("v: " + v);
		// 		while (v > 1 && v % 5 == 0) v /= 5;
		// 		if (v == 1) 
        //             r = Math.min(r, 1 + dfs(j));
        //     }
        //     return f[i] = r;
        // }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long maximumValueSum(int[] a, int k, int[][] egs) {
		// 	n = a.length; this.k = k; this.a = a; 
		// 	g = new ArrayList [n];
		// 	Arrays.setAll(g, z -> new ArrayList<Integer>());
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1];
		// 		g[u].add(v);
		// 		g[v].add(u);
		// 	}
		// 	f = new Long [n][2];
		// 	return dfs(0, -1)[0];
		// }
		// List<Integer> [] g;
		// int n, k; int [] a;
		// Long [][] f; // 一次DFS O(N) 深搜，可以不用记忆。。
		// long [] dfs(int uu, int p) {
		// 	long fi = 0, fj = Long.MIN_VALUE; // f[uu][0] f[uu][1]
		// 	// f[uu][0] = 0l;
		// 	// f[uu][1] = Long.MIN_VALUE;
		// 	for (int v : g[uu]) {
		// 		if (v == p) continue;
		// 		long [] r = dfs(v, uu);
		// 		// // 情况一，不操作 x 和 y：
		// 		// long r0 = Math.max(f[v][0] + a[v], f[v][1] + (a[v] ^ k));
		// 		// long r1 = Math.max(f[v][1] + a[v], f[v][0] + (a[v] ^ k));
		// 		// // 【写错了】：就像置换两个数，需要借助一个第三方变量。。当 f[uu][0] 先更新，再后面再使用更新了的 f[uu][0] 就不对！！
		// 		// fi = Math.max(fi + r0, fj + r1);
		// 		// fj = Math.max(fj + r0, fi + r1);
		// 		long tmp = Math.max(fj + r[0], fi + r[1]); // new fj
		// 		fi = Math.max(fi + r[0], fj + r[1]);
		// 		fj = tmp;
		// 	}
		// 	// return new long [] {fi, fj}; // 【写错了。。】
		// 	return new long [] {
		// 		Math.max(fi + a[uu], fj + (a[uu] ^ k)),
		// 		Math.max(fj + a[uu], fi + (a[uu] ^ k))
		// 					   };
		// }

	}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		char [][] a = new char [][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}; 

		int r = s.maximalRectangle(a);
		System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】