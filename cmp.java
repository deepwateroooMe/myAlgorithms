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

public class cmp {
    public static class Solution {

		// // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，想要直接搬上一题目的解法，但显然 TLE TLE TLE 呵呵呵呵呵。。。。
		// // 这个题目，参考别人的题解，把它真正理解透彻、自己写一遍，掌握解题思路
		// public int maxTotalReward(int[] a) { // TLE TLE TLE ... 572/580 passed...
		// 	int n = a.length;
		// 	TreeSet<Integer> s = new TreeSet<>();
		// 	for (int v : a) s.add(v);
		// 	int [] b = new int [s.size()];
		// 	int i = 0;
		// 	for (int v : s) {
		// 		b[i] = v;
		// 		i++;
		// 	}
		// 	// 感觉，这里需要、必须要保存的，可以不是，所有可能的数，只要某个范围内、能够保证正确答案的数，就可以了。。。
		// 	// 是这么想的：去看下它的提示！！
		// 	TreeSet<Integer> f = new TreeSet<>((x, y)->y-x), g = new TreeSet<>((x, y)->y-x);
		// 	f.add(b[0]);
		// 	for (i = 1; i < b.length; i++) {
		// 		g = (TreeSet)f.clone();
		// 		g.add(b[i]);// 当前数
		// 		for (int v : f) {
		// 			if (v >= b[i]) continue;
		// 			g.add(v + b[i]);
		// 		}
		// 		f.clear();
		// 		f = (TreeSet)g.clone();
		// 		g.clear();
		// 	}
		// 	return f.first();
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxTotalReward(int[] a) {
		// 	// 【优化一】:
		// 	// 设 m=max(rewardValues)，如果数组中包含 m−1，则答案为 2m−1（因为这是答案的上界），无需计算 DP
		// 	// 【优化二】: 如果有两个不同元素之和等于 m−1，也可以直接返回 2m−1。
		// 	// 由于在随机数据下，几乎 100% 的概率有两数之和等于 m−1，而力扣又喜欢出随机数据，所以在大多数情况下，本题就是一道 1. 两数之和。
		// 	Set<Integer> s = new HashSet<>();
		// 	int max = Arrays.stream(a).max().getAsInt();
		// 	for (int v : a) {
		// 		if (s.contains(v)) continue; // 重复数，不用再处理
		// 		if (v == max - 1 || s.contains(max-1 - v)) return 2 * max -1;
		// 		s.add(v);
		// 	}
		// 	BigInteger f = BigInteger.ONE; // 1
		// 	for (int v : Arrays.stream(a).distinct().sorted().toArray()) { // 遍历：无重复、升序数组、中的每个值，f 累积 
		// 		BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE); // 制造一个：有V 个数位、每个数位都是 1 的大数 mask
		// 		// 【重点】：这个大数的位操作，就是感觉挫呀挫。。。
		// 		// 这可以解决周赛第三题，但第四题范围很大，需要去掉第一个维度，并用 bitset 优化（也可以用 bigint）。
		// 		// 用一个二进制数 f 保存状态，二进制从低到高第 j 位为 1 表示 f[j]=true，为 0 表示 f[j]=false。
		// 		// 对于上面的转移方程 f[i][j] = f[i−1][j]∨f[i−1][j−v]，其中 0≤j−v<v，相当于取 f 的低 v 位，再左移 v 位，然后与 f 取按位或。【这里想明白了】
		// 		// 初始值 f=1。
		// 		f = f.or(f.and(mask).shiftLeft(v)); // 取 f 的低 v 位、再左移 v 位；与 f 相或
		// 	}
		// 	return f.bitLength() - 1; // 这个大数 f 的最高位， f 的长度－1,就是 v 的最大、可能有效取值
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，切【苹果蛋糕——先前的动规题型】——所有的苹果，要极尽可能地，分布在总面积最小的三块蛋糕上
// 		// 变形变型的【记忆化深搜】？657/661 passed !!! TLE TLE TLE !!!
// 		// 写出这个题目，感觉亲爱的表哥的活宝妹，真强大！！用实际题目来证明：只要亲爱的表哥的活宝妹，能够自己相得明白，亲爱的表哥的活宝妹，就能够把代码写出来、实现出来！！
// 		// 感觉这里，亲爱的表哥的活宝妹，应该还可以再优化一些不必的重复过的边角检测之类的小细节。。现在，再来试写一下，为什么会有最后几个测试、不过？？？
// 		// 写出这个题目，感觉亲爱的表哥的活宝妹，真强大！！亲爱的表哥的活宝妹，只要还想用点儿力写，就能自己、独立，把它写过！！！
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		public int minimumSum(int[][] a) {
// 			m = a.length; n = a[0].length; this.a = a; 
// 			f = new Integer [m][n][m][n][4];
// 			sum = new int [m+1][n+1]; // 数组和，预处理，备用
// 			for (int i = 1; i <= m; i++) 
// 				for (int j = 1; j <= n; j++) 
// 					sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + a[i-1][j-1];
// 			int r = dfs(0, 0, m-1, n-1, 3);
// 			return r;
// 		}
// 		Integer [][][][][] f; // 得有【起点】与【终点】与【要的块数】
// 		int [][] a, sum;
// 		int m, n;
// 		int dfs(int i, int j, int x, int y, int k) {
// 			if (i < 0 || j < 0 || x < 0 || y < 0 || i >= m || j >= n || x >= m || y >= n || k < 0 || k > 3) return 1000;
// 			if (k == 0) {
// 				int s = sum[x+1][y+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
// 				return f[i][j][x][y][k] = (s == 0 ? 0 : 1000);
// 			}
// 			if (f[i][j][x][y][k] != null) return f[i][j][x][y][k];
// 			if (i == x && j == y && k == 1) return f[i][j][x][y][k] = 1;
// 			// 遍历：行切、列切、并减少1 块. 这里要再想深一点儿：【3 块的行列分布、等细节】
// 			if (k == 1) 
// 				return f[i][j][x][y][k] = minimumArea(i, j, x, y);
// 			// k = [2 || 3] 少考虑了一种情况 0 因为行、列可能是空行
// 			int r = 1000;
// // 遍历，先行切: 行切至当前行，包括当前行
// 			for (int ii = i; ii < x; ii++) {
// 				int s = sum[ii+1][y+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
// 				if (s == 0) continue;
// 				r = Math.min(r, Math.min(dfs(i, j, ii, y, 1) + dfs(ii+1, j, x, y, k-1), // 行：上半1 ＋下半 k-1
// 										 dfs(i, j, ii, y, 2) + dfs(ii+1, j, x, y, k-2))); // 行：上半2 ＋下半 k-2
// 			}
// // 遍历，先行列: 行切至当前列，包括当前列
// 			for (int jj = j; jj < y; jj++) {
// 				int s = sum[x+1][jj+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
// 				if (s == 0) continue;
// 				r = Math.min(r, Math.min(dfs(i, j, x, jj, 1) + dfs(i, jj+1, x, y, k-1),
// 										 dfs(i, j, x, jj, 2) + dfs(i, jj+1, x, y, k-2)));
// 			}
// 			return f[i][j][x][y][k] = r;
// 		}
// 		public int minimumArea(int ii, int jj, int x, int y) {
// 			int [] r = new int [2], c = new int [2];
// 			Arrays.fill(r, -1); Arrays.fill(c, -1);
// 			for (int i = ii; i <= x; i++) {
// 				int sum = 0;
// 				for (int j = jj; j <= y; j++) 
// 					sum += a[i][j];
// 				if (sum == 0) {
// 					if (r[0] == -1) continue;
// 					if (r[1] == -1) r[1] = i-1;
// 				} else {
// 					if (r[0] == -1) r[0] = i;
// 					else r[1] = i;
// 					for (int j = jj; j <= y; j++) {
// 						if (a[i][j] == 1) {
// 							if (c[0] == -1 || j < c[0]) c[0] = j;
// 							if (c[1] == -1 || j > c[1]) c[1] = j;
// 						}
// 					}
// 				}
// 			}
// 			return (r[1] == -1 ? 1 : r[1] - r[0] + 1) * (c[1] == -1 ? 1 : c[1] - c[0] + 1);
// 		}
		// 上面，亲爱的表哥的活宝妹，强大的亲爱的表哥的活宝妹，想得清思路，就能够实现出来；想利透彻的边边角角、写多余的不必要步骤，都能一一裁剪掉，自己独立解决、写过、写过，100% 过，所有测试用例，全过！！
		// 可是，也仍然只是 32% 的能写过里面的 bottom 5% ！！还是需要学习、训练、和适应、写【动规】！！
		// 现在的亲爱的表哥的活宝妹，狠强大了！狠多动规题目，都能够自己努力、尝试、独立去想，和解决动规思路。这次，现在的亲爱的表哥的活宝妹，感觉真心强大、能够掌握和征服【动规】！！
		// 参考一个99.99%? 的动规思路，可是就是感觉预处理的步骤，繁琐得像一团乱麻、、、亲爱的表哥的活宝妹自己的 5 维记忆数组，反而思路极度清晰、简洁！！
		// 参考一个99.99%? 的动规思路，可是就是感觉预处理的步骤，繁琐得像一团乱麻、、、还是改天遇到题目，再偿试写它，极度繁琐、一团乱麻。。。

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxHeightOfTriangle(int red, int blue) {
		// 	int l = Math.min(red, blue), r = Math.max(red, blue), a = 0, b = 0, n = 1;
		// 	int f = 0;// flag: 0: l 1:r 轮次：红的、蓝的？
		// 	while (f == 0 && l >= n || f == 1 && r >= n) {
		// 		if (f == 0) {
		// 			l -= n;
		// 		} else {
		// 			r -= n;
		// 		}
		// 		n++; // 每行要的个数
		// 		a++;
		// 		f = 1 - f;
		// 	}
		// 	l = Math.max(red, blue); r = Math.min(red, blue);
		// 	f = 0; n = 1;
		// 	while (f == 0 && l >= n || f == 1 && r >= n) {
		// 		if (f == 0) {
		// 			l -= n;
		// 		} else {
		// 			r -= n;
		// 		}
		// 		n++; // 每行要的个数
		// 		b++;
		// 		f = 1 - f;
		// 	}
		// 	return Math.max(a, b);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maximumLength(int[] a) {
		// 	int n = a.length, l = 1, r = 0, ans = 2, p = a[0] % 2;
		// 	for (int i = 0; i < n; i++) a[i] %= 2;
		// 	if (Arrays.stream(a).distinct().count() == 1) return n;
		// 	for (int i = 1; i < n; i++) {
		// 		if (a[i] == p) continue;
		// 		l++;
		// 		p = a[i];
		// 	}
		// 	int sum = Arrays.stream(a).sum();
		// 	int i = 1;
		// 	while (i < n && a[i] == a[0]) i++;
		// 	if (i == n) return Math.max(Math.max(sum, n - sum), l);
		// 	r++;
		// 	p = a[i];
		// 	i++;
		// 	for (; i < n; i++) {
		// 		if (a[i] == p) continue;
		// 		r++;
		// 		p = a[i];
		// 	}
		// 	return Math.max(Math.max(sum, n - sum),
		// 					Math.max(l, r));
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，现在的同一个问题、连出、并添加难度：似在训练思维。。。
		// // 可是，亲爱的表哥的活宝妹，有时候，还是看不懂，它在考什么。。。如这题当 k 在【1,1000】范围内，就不知道算是在考什么。。。
		// // 不知道哪里细节没想对，不喜欢这类乱题目，没意思，先写难的。。
		// int getKeyCnts(int v, int idx) {
		// 	int r = 1, p = a[idx];
		// 	for (int i = idx+1; i < a.length; i++) {
		// 		if (a[i]%k != k-(p == 0 || k == p + p ? 1 : 0) - p) continue;
		// 		r++;
		// 		p = a[i]%k;
		// 	}
		// 	System.out.println("r: " + r);
		// 	return Math.max(2, r);
		// }
		// int [] a; int k;
		// public int maximumLength(int[] a, int k) {
		// 	int n = a.length, ans = 2; this.a = a; this.k = k; 
		// 	TreeMap<Integer, List<Integer>> m = new TreeMap<>(), o = new TreeMap<>();
		// 	for (int i = 0; i < n; i++) {
		// 		// a[i] %= k;
		// 		m.computeIfAbsent(a[i] % k, z -> new ArrayList<>()).add(i);
		// 	}
		// 	for (Map.Entry<Integer, List<Integer>> en : m.entrySet()) {
		// 		int key = en.getKey();
		// 		System.out.println("\n key: " + key);
		// 		List<Integer> l = en.getValue();
		// 		if (o.containsKey(k - key)) continue;
		// 		ans = Math.max(ans, getKeyCnts(key, l.get(0)));
		// 		System.out.println("ans: " + ans);
		// 	}
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumDiameterAfterMerge(int[][] ea, int[][] eb) {
		// 	n = ea.length+1; m = eb.length+1;
		// 	f = new ArrayList[n]; g = new ArrayList[m];
		// 	Arrays.setAll(f, z -> new ArrayList<>());
		// 	Arrays.setAll(g, z -> new ArrayList<>());
		// 	if (n > 1) buildTree(ea, f);
		// 	if (m > 1) buildTree(eb, g);
		// 	// assume 根节点在 0 节点：求最大、次大深度
		// 	l = new int [2]; r = new int [2];
		// 	Arrays.fill(l, -1); Arrays.fill(r, -1);
		// 	maxDepth(f, l, 0, 0, -1); maxDepth(g, r, 0, 0, -1);
		// 	System.out.println(Arrays.toString(l));
		// 	System.out.println(Arrays.toString(r));
		// 	if (l[1] == -1) l[0] = l[0] / 2 + l[0] % 2;
		// 	if (r[1] == -1) r[0] = r[0] / 2 + r[0] % 2;
		// 	return l[0] + 1 + r[0]; // 这里还有点儿机关，没想透彻。。。
		// }
		// List<Integer> [] f, g;
		// int m, n;
		// int [] l, r;
		// void maxDepth(List<Integer> [] f, int [] l, int d, int u, int p) {
		// 	int cnt = 0;
		// 	for (int v : f[u]) {
		// 		if (v == p) continue;
		// 		cnt++;
		// 		maxDepth(f, l, d+1, v, u);
		// 	}
		// 	if (cnt == 0) {
		// 		if (l[0] == -1) l[0] = d;
		// 		else if (d >= l[0]) {
		// 			if (d != l[0])
		// 				l[1] = l[0];
		// 			if (d > l[0])
		// 				l[0] = d;
		// 		} else if (d > l[1])
		// 			l[1] = d;
		// 	}
		// }
		// void buildTree(int [][] a, List<Integer> [] f) {
		// 	for (int [] e : a) {
		// 		int u = e[0], v = e[1];
		// 		f[u].add(v);
		// 		f[v].add(u);
		// 	}
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int numberOfAlternatingGroups(int[] a) {
		// 	int n = a.length, r = 0;

		// 	for (int i = 0; i < n; i++) {
		// 		if (i < n-1 && a[i] == a[i+1] || i == n-1 && a[i] == a[0]) continue;
		// 		if (i == 0 && a[i] != a[n-1] || i != 0 && a[i] != a[i-1]) r++;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 想不明白，这个破烂题目算是怎么回事，晚点儿再写这个
		// public long maximumPoints(int[] a, int v) {
		// 	int n = a.length; Set<Integer> s = new HashSet<>(); // marked idx
		// 	long r = 0;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，知道昨天早上的这组题目，都是什么狗屁的、大数 BigInteger 等的【位操作】，
		// // 可是亲爱的表哥的活宝妹，这几天身体困顿、休息受限，思路基本都对，感觉就是想不透彻。。
		// public long countSubarrays(int[] a, int k) {
		// 	int n = a.length, mk = 0, r [] = new int [n], cur = 0;
		// 	for (int i = 0; i < 31; i++)
		// 		if ((k & (1 << i)) > 0) mk |= (1 << i);
		// 	for (int i = 0; i < n; i++) {
		// 		cur = 0;
		// 		for (int j = 0; j < 31; j++)
		// 			if ((a[i] & (1 << j)) > 0)
		// 				cur |= (1 << j);
		// 		r[i] = cur;
		// 	}
		// 	// 数组的长短，不受限制，可以任意长度；只是要数个数
		// 	// 先去解决：最有可能解决掉的、前一个问题
		// }

		
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		public int numberOfAlternatingGroups(int[] a, int k) {
// 			// BigInteger 要实现【位操作】：参考细节：
// // //      2^63-1= 9223372036854775807;
// // 			BigInteger tempVal = new BigInteger("3"); // 2049
// // 			BigInteger divide = new BigInteger("2");
// // 			BigInteger compareNum=new BigInteger("1");
// // 			ArrayList<Byte> ResultArray = new ArrayList<Byte>();
// // 			// 位遍历 算出第几位不为1的编码
// // 			for (Byte i = 0;; i++) {
// // 				// 判断是否除尽
// // 				// BigInteger的equals方法参数类型为Object，
// // 				// 但是这个类型必须是BigInteger类型才可以比较
// // 				if (!tempVal.equals(compareNum)) {
// // 					// 取整数和余数 
// // 					BigInteger[] bigIntegers = tempVal.divideAndRemainder(divide);
// // 					System.out.println(Arrays.toString(bigIntegers)); // 
// // 					if (bigIntegers[1].equals(compareNum)) {
// // 						ResultArray.add(i);
// // 					}
// // 					tempVal=bigIntegers[0];
// // 				} else {
// // 					ResultArray.add(i);
// // 					break;
// // 				}
// // 			}
// // 			System.out.println("ResultArray.size(): " + ResultArray.size());
// // 			System.out.println(Arrays.toString(ResultArray.toArray()));
// 			int n = a.length, j = 0, r = 0; // j: 右端点
// 			// 【滑动窗口】：O(NK), 得用上次刚学到的，那什什么狗屁大数 BigInteger 标记位
// 			List<Integer> cur = new ArrayList<>();
// 			// BigInteger cur = (a[0] == 1 ? BigInteger.ONE : BigInteger.ZERO);
// 			cur.add(a[0]);
// 			for (j = 1; j < k; j++) {
// 				// cur.shiftLeft(1);
// 				// if (a[j] == 1) cur.add(BigInteger.ONE);
// 				cur.add(a[j]);
// 			}
// 			// BigInteger tmp = BigInteger.valueOf(0);
// 			// BigInteger mask = BigInteger.ONE.shiftLeft(k).subtract(BigInteger.ONE); // 制造一个：有V 个数位、每个数位都是 1 的大数 mask
// 			// tmp = cur;
// 			// if (tmp.shiftLeft(1).and(cur) == BigInteger.ZERO) r++;
// 			if (custLiiAnd(cur)) r++;
// 			for (int i = 1; i+k <= n+1; i++, j++) {
// 				// System.out.println("\n i: " + i);
// 				// System.out.println("cur: " + cur);
// 				// cur.shiftLeft(1);
// 				// cur = cur.and(mask);
// 				cur.remove(0);
// 				if (i == n-(k-1)) j = 0; // 仅只发生一次： i==n-(k-1) && j==n
// 				// cur.add(a[j] == 1 ? BigInteger.ONE : BigInteger.ZERO);
// 				cur.add(a[j]);
// 				// System.out.println("cur: " + cur);
// 				// tmp = cur;
// 				// if (tmp.shiftLeft(1).and(cur) == BigInteger.ZERO) r++;
// 				if (custLiiAnd(cur)) r++;
// 			}
// 			return r;
// 		}
// 		boolean custLiiAnd(List<Integer> l) { // 感觉，这个方法也写得有问题。。。今天上午不想再写了。。。
// 			System.out.println("l.size(): " + l.size());
// 			System.out.println(Arrays.toString(l.toArray()));
// 			List<Integer> t = new ArrayList<>(l);
// 			t.remove(0);
// 			t.add(0);
// 			int r = 0;
// 			for (int i = 0; i < l.size()-1; i++)
// 				if ((l.get(i) ^ t.get(i)) == 1) r++;
// 			return r == l.size() + l.get(l.size()-1);
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public String getEncryptedString(String S, int k) {
		// 	int n = S.length(), j = k % n;
		// 	char [] s = S.toCharArray(), t = new char [n];
		// 	for (int i = 0; i < n; i++, j++) {
		// 		if (j == n) j = 0;
		// 		t[i] = s[j];
		// 	 }
		// 	return new String(t);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public List<String> validStrings(int n) {
		// 	l = new ArrayList<>(); this.n = n; 
		// 	backtracing(0, -1, new StringBuilder(""));
		// 	return l;
		// }
		// List<String> l; int n;
		// void backtracing(int idx, int p, StringBuilder s) {
		// 	if (idx == n) {
		// 		if (!l.contains(new String(s)))
		// 			l.add(new String(s));
		// 		return ;
		// 	}

		// 	for (int j = 0; j < 2; j++) {
		// 		if (j != p || j == p && j == 1) {
		// 			s.append(j);
		// 			backtracing(idx+1, j, s);
		// 			s.deleteCharAt(s.length()-1);
		// 		}
		// 	}
		// }		

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int numberOfSubmatrices(char[][] a) {
		// 	int m = a.length, n = a[0].length, r = 0;
		// 	int [][] f = new int [m+1][n+1]; // preSum of matrix
		// 	boolean [][] g = new boolean [m+1][n+1]; // boolean flag appearance of X
		// 	for (int i = 1; i <= m; i++) 
		// 		for (int j = 1; j <= n; j++) {
		// 			f[i][j] = f[i-1][j] + f[i][j-1] - f[i-1][j-1] + (a[i-1][j-1] == 'X' ? 1 : (a[i-1][j-1] == 'Y' ? -1 : 0));
		// 			if (a[i-1][j-1] == 'X' || g[i-1][j] || g[i][j-1])
		// 				g[i][j] = true;
		// 			if (g[i][j] && f[i][j] == 0) r++;
		// 		}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉是，狗屁的【记忆化深搜＋字典树】？遍历【目标字符串】＋遍历【dfs 深搜字典树】，【记忆化深搜】找最小代价。。。702/803 passed ...
		// // 【记忆化深搜】思路写不过的时候，永远要先去想，进一步的优化，首先去想：【动规】！！这一次，想忘记了。。。
		// // 上面不对：Deque<Integer> [26] q  = new ArrayDeque[26]; 用来记S 里【ab...z】的所有下标
		// // 上面想得不对，题目内嵌套了一个【字符串哈希】。。亲爱的表哥的活宝妹，当年写这个嵌套类型，永远写不对。。。
		// public class Trie {
		// 	public  class Node {
		// 		char c;
		// 		boolean f;
		// 		int i; // 用来记：串的长度
		// 		Node [] n;
		// 		public Node(char c, boolean f) {
		// 			this.c = c; this.f = f;
		// 			n = new Node[26];
		// 			i = -1;
		// 		}
		// 	}
		// 	Node r;
		// 	public Trie() {
		// 		r = new Node(' ', false);
		// 	}
		// 	public void insert(String S) {
		// 		int n = S.length();
		// 		char [] s = S.toCharArray();
		// 		Node f = r;
		// 		for (int i = 0; i < n; i++) {
		// 			int j = s[i] - 'a';
		// 			if (f.n[j] == null)
		// 				f.n[j] = new Node(s[i], false);
		// 			f = f.n[j];
		// 		}
		// 		f.f = true;
		// 		f.i = S.length();
		// 	}
		// 	List<Integer> searchAllLength(int i) { // 遍历【字典树】：找 s[] 从下标 i 开始，所有匹配的字符串的下标
		// 		List<Integer> l = new ArrayList<>();
		// 		Node f = r;
		// 		int j = i;
		// 		while (j < s.length && f.n[s[j]-'a'] != null) {
		// 			if (f.n[s[j]-'a'].f) l.add(f.n[s[j]-'a'].i);
		// 			f = f.n[s[j]-'a'];
		// 			j++;
		// 		}
		// 		return l;
		// 	}
		// }
		// public int minimumCost(String S, String[] sa, int[] a) {
		// 	n = S.length(); this.sa = sa; this.a = a; this.S = S; 
		// 	t = new Trie(); ss = new Trie();
		// 	s = S.toCharArray();
		// 	q = new ArrayDeque[26];
		// 	Arrays.setAll(q, z -> new ArrayDeque<Integer>());
		// 	for (int i = 0; i < n; i++)
		// 		q[s[i]-'a'].offerLast(i);
		// 	for (int i = 0; i < sa.length; i++) {
		// 		if (!isSubString(i)) continue;
		// 		if (ms.containsKey(sa[i])) {
		// 			ms.put(sa[i], Math.min(ms.get(sa[i]), a[i]));
		// 			continue;
		// 		}
		// 		if (sa[i].length() <= n)
		// 		t.insert(sa[i]);
		// 		ms.put(sa[i], a[i]);
		// 	}
		// 	f = new Integer [n];
		// 	int r = dfs(0); 
		// 	return r >= Integer.MAX_VALUE / 2 ? -1 : r;
		// }
		// boolean isSubString(int i) { // i:idx in sa
		// 	boolean valid = true;
		// 	Deque<Integer> sq = q[sa[i].charAt(0)-'a'];
		// 	for (int j : sq) {
		// 		valid = true;
		// 		for (int k = j; k < j+sa[i].length(); k++) 
		// 			if (s[k] != sa[i].charAt(k-j)) {
		// 				valid = false;
		// 				break;
		// 			}
		// 		if (valid)
		// 			return true;
		// 	}
		// 	return false ;
		// }
		// Trie ss, t;
		// int n; String [] sa; int [] a; char [] s; String S;
		// Deque<Integer> [] q = new ArrayDeque[26];
		// Map<String, Integer> ms = new HashMap<>(); // 如果：记另外字典里，就需要【字典树返回长度。。】
		// Integer [] f;
		// int dfs(int i) {
		// 	if (i == n) return 0;
		// 	List<Integer> l = t.searchAllLength(i);
		// 	if (l.size() == 0) return f[i] = Integer.MAX_VALUE / 2;
		// 	int r = Integer.MAX_VALUE / 2;
		// 	for (int j : l) 
		// 		r = Math.min(r, ms.get(S.substring(i, i+j)) + dfs(i+j));
		// 	return f[i] = r;
		// }
		// // 重新写：参照别人的思路来写，但是写懂写会。。。
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumCost(String S, String[] sa, int[] a) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	// 【子串哈希值】：这个题型和算法，感觉是亲爱的表哥的活宝妹，第1 或是第2 次接触，不熟悉。。。这次写会。。。
		// 	// 多项式字符串哈希（方便计算子串哈希值）
		// 	// 哈希函数 hash(s) = s[0] * base^(n-1) + s[1] * base^(n-2) + ... + s[n-2] * base + s[n-1]
		// 	final int mod = 1_627_777_777; // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】 
		// 	final int base = (int) 2e7 + new Random().nextInt((int) 1e7); // 随机 base，防止 hack
		// 	int [] p = new int [n+1]; // powBase[i] = base^i 这个是【预处理，备用】：过会儿算子串会用到的
		// 	int [] ph = new int [n+1];// 前缀哈希值 preHash[i] = hash(target[0] 到 target[i-1]) ：这个是S 的如【前缀和】般的【前缀哈希值】，备用后用的计算小段。。
		// 	p[0] = 1;
		// 	for (int i = 1; i <= n; i++) {
		// 		p[i] = (int)((long)p[i-1] * base % mod); 
		// 		ph[i] = (int)(((long)ph[i-1] * base + s[i-1]) % mod);
		// 	}
		// 	int [] f = new int [n+1]; // 动态规划：
		// 	Map<Integer, Integer> m = new HashMap<>(); // 记录：组里的【字符串，最小代价】对
		// 	HashSet<Integer> si = new HashSet<>(); // 记录：组里的、所有可能的长度. 【动规】时只遍历、可能的长度就可以了
		// 	long h = 0;
		// 	for (int i = 0; i < sa.length; i++) {
		// 		si.add(sa[i].length()); // 记录：组里的、所有可能的长度
		// 		h = 0;
		// 		for (char c : sa[i].toCharArray()) 
		// 			h = (h * base + c) % mod;
		// 		m.merge((int)h, a[i], Integer::min); // 合并项：取小的！！
		// 	}
		// 	int [] lens = new int [si.size()]; int j = 0;
		// 	for (int v : si) lens[j++] = v;
		// 	Arrays.sort(lens); 
		// 	// 【动规】解题：
		// 	Arrays.fill(f, Integer.MAX_VALUE / 2);
		// 	f[0] = 0;
		// 	for (int i = 1; i <= n; i++) {
		// 		for (int len : lens) { // 遍历：S 当前下标 i 下：所有优化子集、所有可能的子串的、长度选项. 优化到了：只遍历可能的、有限的几个长度
		// 			if (len > i) break;
		// 			// 新题型：计算【子串哈希值】: 像是，填一个长度为 len 的空后缀一样，作差，算出【子串哈希值】
		// 			// h = (int)((long)ph[i] - (long)ph[i - len] * p[len] % mod + mod) % mod; // 【TODO】：这里写错了？？？
		// 			h = (((ph[i] - (long)ph[i - len] * p[len]) % mod + mod) % mod);
		// 			f[i] = Math.min(f[i], f[i - len] + m.getOrDefault((int)h, Integer.MAX_VALUE / 2));
		// 		}
		// 	}
		// 	return f[n] >= Integer.MAX_VALUE / 2 ? -1 : f[n];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long countSubarrays(int[] a, int k) {
		// 	int n = a.length;
		// 	long r = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		int v = a[i];
		// 		for (int j = i-1; j >= 0 && (a[j] & v) != a[j] ; j--)
		// 			a[j] &= v;
		// 		r += lowerBound(a, i+1, k+1) - lowerBound(a, i+1, k);
		// 	}
		// 	return r;
		// }
		// int lowerBound(int [] a, int r, int k) { // 感觉，这类破烂【二分查找】左开右开区间之类的，还是不太会写。。。
		// 	int l = -1; // 左开右开 (l,r) 区间
		// 	while (l + 1 < r) { // 非空
		// 		// 循环不变量：
		// 		// nums[left] < target
		// 		// nums[right] >= target
		// 		int m = l + (r - l) / 2;
		// 		if (a[m] < k) // 范围缩小到 (mid, right)
		// 			l = m;
		// 		else r = m; // 范围缩小到 (left, mid)
		// 	}
		// 	return r;
		// }
		// // 方法二：三指针
		// // 由于元素值只会减少，所以当 i 增大时，left 和 right 不会减少，有了单调性的保证，上面的二分查找可以改成 滑动窗口：
		// // 当 left≤i 且 nums[left]<k 时，把 left 加一。
		// // 当 right≤i 且 nums[right]≤k 时，把 right 加一。
		// // 把左闭右开区间的长度 right−left 加入答案。
		// public long countSubarrays(int[] a, int k) {
		// 	long ans = 0;
		// 	int l = 0, r = 0; // 左闭右开区间【l,r）
		// 	for (int i = 0; i < a.length; i++) {
		// 		int v = a[i];
		// 		for (int j = i-1; j >= 0 && (a[j] & v) != a[j]; j--)
		// 			a[j] &= v;
		// 		while (l <= i && a[l] < k) l++;
		// 		while (r <= i && a[r] <= k) r++;
		// 		ans += r - l;
		// 	}
		// 	return ans;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long countSubarrays(int[] a, int k) {
		// 	long r = 0;
		// 	int cumulativeCounts = 0; // 注意这个【累积效应】的变量： cumulativeCounts
		// 	for (int i = 0; i < a.length; i++) {
		// 		int v = a[i];
		// 		cumulativeCounts += (v == k ? 1 : 0);
		// 		for (int j = i-1; j >= 0 && (a[j] & v) != a[j]; j--) {
		// 			cumulativeCounts -= (a[j] == k ? 1 : 0);
		// 			a[j] &= v;
		// 			cumulativeCounts += (a[j] == k ? 1 : 0);
		// 		}
		// 		r += cumulativeCounts;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【动规】：应该就是一个简单的、线性一维动规，就可以了 
		// public long maxTaxiEarnings(int n, int[][] a) {
        //     Arrays.sort(a, (x, y) ->  x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
        //     long [] f = new long [n+1];
		// 	// 需要记：遍历当前下标 i 时，先前所有经历过的终点【1,a[i][0]-1】的最大利润
		// 	// TreeMap<Integer, Integer> m = new TreeMap<>(); // 可以按：【终点】升序排列. 遍历字典 it，不是狠方便
		// 	// 优先队列，就得用2 个，才能方便滚动；
		// 	// 要么，就该写自己的 List<int []> l = new ArrayList<>(); 自己手动维护终点升序排列，可以只用一条链
		// 	// 还有就是【线段树】：随时O(1) 更新？
		// 	Queue<long []> p = new PriorityQueue<>((x, y) -> -1 * Long.compare(x[1], y[1])); // 利润最大堆 
		// 	Queue<long []> q = new PriorityQueue<long []>((x, y)->Long.compare(x[0], y[0])); // 终点升序,备用滚动的
		// 	long u, v, r, max = 0;
		// 	for (int i = 0; i < a.length; i++) {
		// 		System.out.println(Arrays.toString(a[i]));
		// 		u = (long)a[i][0]; v = (long)a[i][1]; r = (long)a[i][2];
		// 		while (!p.isEmpty() && q.peek()[0] > u) q.offer(p.poll());
		// 		while (!q.isEmpty() && q.peek()[0] <= u) {
		// 			if (q.peek()[1] == f[(int)q.peek()[0]])
		// 				p.offer(q.poll());
		// 			else q.poll(); // 过滤：把先前的、同一终点的、非最优解，扔掉
		// 		}
		// 		f[(int)v] = Math.max(f[(int)v], (p.isEmpty() ? v - u + r : p.peek()[1] + v - u + r));
		// 		max = Math.max(max, f[(int)v]);
		// 		q.offer(new long [] {v, f[(int)v]});
		// 	}
		// 	return max;
        // }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，上面的破烂题目，被亲爱的表哥的活宝妹自己，想得一团乱麻一样。。实际思路可以狠简洁。。。
		// public long maxTaxiEarnings(int n, int[][] a) {
        //     Arrays.sort(a, (x, y) ->  x[1] - y[1]); // 【终点：升序】
		// 	int m = a.length;
		// 	long [] f = new long [m+1];
		// 	for (int i = 0; i < m; i++) {
		// 		int j = binarySearch(a, i, a[i][0]);
		// 		f[i+1] = Math.max(f[i], f[j] + a[i][1] -  a[i][0] + a[i][2]);
		// 	}
		// 	return f[m];
		// }
		// int binarySearch(int [] a, int h, int v) {
		// 	int l = 0; // 这是，左开右开区间吗（l,h）
		// 	while (l < h) {
		// 		int m = l + (h - l) / 2;
		// 		if (a[m][1] > v)
		// 			h = m; // 右开区间
		// 		else l = m + 1;
		// 	}
		// 	return l;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，上面的破烂题目，被亲爱的表哥的活宝妹自己，想得一团乱麻一样。。实际思路可以狠简洁。。。
		// public long maxTaxiEarnings(int n, int[][] a) {
        //     Arrays.sort(a, (x, y) ->  x[1] - y[1]); // 【终点：升序】
		// 	Map<Integer, List<int []>> m = new HashMap<>();
		// 	for (int [] r : a) 
		// 		m.computeIfAbsent(r[1], z -> new ArrayList<>()).add(r);
		// 	long [] f = new long [n+1];

		// 	for (int i = 1; i <= n; i++) {
		// 		f[i] = f[i-1]; // 初始化成：这站不接客；前一站的最大值 
		// 		for (int [] r : m.getOrDefault(i, new ArrayList<int []>()))
		// 			f[i] = Math.max(f[i], f[r[0]] + r[1] - r[0] + r[2]);
		// 	}
		// 	return f[n];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，就是那么瓣，也算是把它给瓣过去了。。。。
		// public int longestMountain(int[] a) {
        //     int n = a.length, ans = 0, r = 1;
		// 	int up = -1;
		// 	for (int i = 1; i < n; i++) {
		// 		if (a[i] > a[i-1] && up != 0 || up == 0 && a[i] < a[i-1]) {
		// 			if (up == -1) up = 1;
		// 			r++;
		// 		} else if (up > 0 && a[i] < a[i-1]) {
		// 			up = 0;
		// 			++r;
		// 		} else {
		// 			if (r > 2 && up == 0)
		// 				ans = Math.max(ans, r);
		// 			r = (a[i] > a[i-1] ? 2 : 1);
		// 			up = (a[i] > a[i-1] ? 1 : -1);
		// 		}
		// 	}
		// 	if (up == 0) ans = Math.max(ans, r);
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【二分查找】：思路，亲爱的表哥的活宝妹是清楚的；对上界的界定，不太清楚
		// // 【数位 DP】：感觉是掌握了的、但是忘记得差不多了... 说的是【数位DP】，亲爱的表哥的活宝妹的活宝脑袋里，永远是，改装版本的、万变不离其踪的【记忆化深搜】
		// // 这个题目，就是简单复习一下【数位DP】＋【二分查找】
		// public long findMaximumNumber(long k, int x) {
		// 	this.x = x;
		// 	// 开区间二分: 左开右开都开？
		// 	long left = 0, right = (k+1) << x; // 【TODO】：亲爱的表哥的活宝妹，看不懂这里写的是，什么意思
		// 	// System.out.println("right: " + right); // 亲爱的表哥的活宝妹，搞不懂，它上面写得是什么意思。。。
		// 	while (left + 1 < right) {
		// 		long mid = (left + right) >>> 1; // 就是 /  2 的意思
		// 		if (countDigitOne(mid) <= k)
		// 			left = mid;
		// 		else
		// 			right = mid;
		// 	}
		// 	return left;
		// }
		// Long [][] f; // 记忆数组, 只记非 limit 状态下的相应组值，就压缩掉了不必要记忆的、一维数组
		// int x;
		// long v;
		// long countDigitOne(long v) {
		// 	this.v = v;
		// 	int m = 64 - Long.numberOfLeadingZeros(v);
		// 	f = new Long [m][m+1];
		// 	return dfs(m-1, 0, true);
		// }
		// long dfs(int i, int j, boolean isLimit) { // isLimit: 标记，是否匹配 v 的原数位？？
		// 	if (i < 0) return j;
		// 	if (!isLimit && f[i][j] != null) return f[i][j];
		// 	int upperBound = isLimit ? (int)(v >> i & 1) : 1; // 当前数位【m-1-i】下，可以取值的高值上限，是0/1?
		// 	long r = 0;
		// 	for (int k = 0; k <= upperBound; k++) {
		// 		// 感觉，下面，亲爱的表哥的活宝妹，写得还是比较混。。。
		// 		r += dfs(i-1, j + (k == 1 && (i+1) % x == 0 ? 1 : 0), isLimit && k == upperBound);
		// 	}
		// 	if (!isLimit) f[i][j] = r;
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，昨天晚上暴食暴饮面包吃多了、夜间极热夜里醒2 遍、今天上午极度头痛；午餐前约 1.5 小时，看能写出几个破烂题目
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，可怜的亲爱的表哥的活宝妹，下午的脑袋真疆，看似看懂提醒思路，就是写不对，改天上午再写。。。
		// // 亲爱的表哥的活宝妹，看不懂，它破烂网站上说得不清不楚的提示，不知道它写的是什么意思。。。
		// public int lengthOfLongestSubsequence(List<Integer> li, int t) { // 【TODO】：不明天这里初始化与动规传递推理逻辑。。。
		// 	int n = li.size();
		// 	// Set<Integer> s = new HashSet<>(li);
		// 	Integer [][] f = new Integer [n+1][t+1];
		// 	f[0][0] = 0; // 初始化 
		// 	for (int i = 1; i <= t; i++)
		// 		// if (s.contains(i))
		// 		f[0][i] = 0;
		// 	for (int i = 1; i <= n; i++) {
		// 		System.out.println("\n i: " + i);
		// 		// f[i][li.get(i-1)] = 1;
		// 		for (int j = li.get(i-1); j <= t; j++) 
		// 			// for (int j = t; j - li.get(i-1) >= 0; j--)
		// 			if (f[i-1][j - li.get(i-1)] != null && (i == 1 || f[i-1][j - li.get(i-1)] > 0))
		// 				// f[i][j] = Math.max(Math.max(f[i][j], f[i-1][j]), 1 + f[i-1][j - li.get(i-1)]);
		// 				f[i][j] = Math.max(f[i-1][j], (j > li.get(i-1) ? 1 : 0) + f[i-1][j - li.get(i-1)]);
		// 			else continue;
		// 		System.out.println("f.length: " + f.length);
		// 		for (int z = 0; z < f.length; ++z) 
		// 			System.out.println(Arrays.toString(f[z]));
		// 	}
		// 	return f[n][t] == 0 ? -1 : f[n][t];
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，如果不受限它破烂写得不清不楚的提示，直接自己写0-1 背包一维动规，感觉能够写得出来的。。。。
		// public int lengthOfLongestSubsequence(List<Integer> li, int t) {
		// 	int n = li.size(), s = 0;
		// 	int [] f = new int [t+1]; // 求最大值，一般不用改这里什么，但因为可能存在无解，将其初始化到 Integer.MIN_VALUE
		// 	Arrays.fill(f, Integer.MIN_VALUE);
		// 	f[0] = 0;
		// 	for (int v : li) {
		// 		s = Math.min(s+v, t); // 【优化】：不必从【t】递减，从当前最大和递减就可以了
		// 		for (int j = s; j >= v; j--) {
		// 			if (f[j-v] != Integer.MIN_VALUE) //f[j-v] 有合法解，就是前面的数，可以合理合并到 j-v 这个目标值 
		// 				f[j] = Math.max(f[j], f[j-v] + 1);
		// 		}
		// 	}
		// 	return f[t] == Integer.MIN_VALUE ? -1 : f[t];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxOperations(int[] a) {
		// 	n = a.length; this.a = a; 
		// 	// 【记忆化深搜】：先写万能的记忆化深搜
		// 	// f = new Integer [n][n][3]; // 8*10^9 感觉，有可能会超时？应该不会，k 只有最多3 种可能取值，就降至O(12,000,000) 应该不会超时
		// 	f.put(a[0] + a[1], new int [n][n]);
		// 	f.put(a[n-2] + a[n-1], new int [n][n]);
		// 	f.put(a[0] + a[n-1], new int [n][n]);
		// 	int i = dfs(0, n-1, a[0]+a[1]);
		// 	int j = dfs(0, n-1, a[n-2] + a[n-1]);
		// 	int k = dfs(0, n-1, a[0] + a[n-1]);
		// 	return Math.max(Math.max(i, j), k);
		// }
		// // 还有一种省空间的，就是 dfs(i,j) 执行3 遍，就可以不用字典了
		// Map<Integer, int [][]> f = new HashMap<>();
		// int n; int [] a;
		// int dfs(int i, int j, int k) {
		// 	if (i >= j) return 0;
		// 	if (f.get(k)[i][j] > 0) return f.get(k)[i][j];
		// 	int r = 0;
		// 	if (a[i] + a[i+1] == k)
		// 		r = Math.max(r, 1 + dfs(i+2, j, k));
		// 	if (a[i] + a[j] == k)
		// 		r = Math.max(r, 1 + dfs(i+1, j-1, k));
		// 	if (a[j-1] + a[j] == k)
		// 		r = Math.max(r, 1 + dfs(i, j-2, k));
		// 	f.get(k)[i][j] = r;
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，感觉今年的亲爱的表哥的活宝妹的脑袋，终于可以想一想、试着自己去解决一些动规问题。
		// // 感觉其实不少的动规题型，亲爱的表哥的活宝妹，只要自己稍微有点儿思路，能够自己想得明白，亲爱的表哥的活宝妹，是可以做到、完全100% 自己独立写出来的！！
		// // 感觉，像是，戴帽子动规：给多少个人戴不同的帽子。。。
		// public List<String> getWordsInLongestSubsequence(String[] sa, int[] gs) {
		// 	Set<Integer> s = new HashSet<>(Arrays.stream(gs).boxed().collect(Collectors.toList()));
		// 	int n = sa.length, max = 0, gmax = 1, idx = 0, r [] = new int [n]; Arrays.fill(r, -1);
		// 	int [] f = new int [n];
		// 	f[0] = 1; r[0] = 0;
		// 	for (int i = 1; i < n; i++) {
		// 		f[i] = 1;
		// 		max = 1;
		// 		for (int j = i-1; j >= 0; j--) {
		// 			if (gs[j] == gs[i] || !withinOne(sa[i], sa[j])) continue;
		// 			if (f[j] + 1 > f[i]) {
		// 				f[i] = f[j] + 1;
		// 				max = f[i];
		// 				r[i] = j; // 记的是：取得当前下标 i 最大可能值的、前一个字符的下标 j
		// 			}
		// 		}
		// 		if (f[i] > gmax) {
		// 			gmax = f[i];
		// 			idx = i;
		// 		}
		// 	}
		// 	List<String> l = new ArrayList<>();
		// 	l.add(sa[idx]);
		// 	if (idx == 0) return l;
		// 	while (r[idx] >= 0) {
		// 		idx = r[idx];
		// 		l.add(0, sa[idx]);
		// 		if (idx == 0) break;
		// 	} 
		// 	return l;
		// }
		// boolean withinOne(String S, String T) {
		// 	if (S.length() != T.length()) return false;
		// 	int r = 0;
		// 	for (int i = 0; i < S.length(); i++) {
		// 		if (S.charAt(i) != T.charAt(i)) r++;
		// 		if (r > 1) return false;
		// 	}
		// 	return true;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public String getSmallestString(String S) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	char c = ' ';
		// 	for (int i = 0; i+1 < n; i++) {
		// 		if (s[i] > s[i+1] && (s[i]-'0') % 2 == (s[i+1]-'0') % 2) {
		// 			c = s[i];
		// 			s[i] = s[i+1];
		// 			s[i+1] = c;
		// 			break;
		// 		}
		// 	}
		// 	return new String(s);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目狠简单，用个最笨的办法，快点儿把它写过
		// public ListNode modifiedList(int[] nums, ListNode h) {
		// 	Set<Integer> s = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		// 	ListNode f = h, p = null, pp = null, r = null;
		// 	List<Integer> l = new ArrayList<>();
		// 	while (f != null) {
		// 		if (!s.contains(f.val)) l.add(f.val);
		// 		f = f.next;
		// 	}
		// 	r = new ListNode(l.get(0));
		// 	f = r;
		// 	for (int i = 1; i < l.size(); i++) {
		// 		f.next = new ListNode(l.get(i));
		// 		f = f.next;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // MN[1,20] 应该是：暴力所有可能性，取最优是可以过的。那么最简单的写法就是：万能的【记忆化深搜】！！
		// public int minimumCost(int m, int n, int[] h, int[] v) {
		// 	this.m = m; this.n = n; this.h = h; this.v = v;
		// 	f = new int [m][n][m][n];
		// 	for (int i = 0; i < m; i++) 
		// 		for (int j = 0; j < n; j++) 
		// 			for (int k = 0; k < m; k++) 
		// 				Arrays.fill(f[i][j][k], Integer.MAX_VALUE / 2);
		// 	return dfs(0, 0, m-1, n-1);
		// }
		// int m, n, h[], v[];
		// int [][][][] f;
		// int dfs(int i, int j, int x, int y) {
		// 	if (i > x || j > y) return Integer.MAX_VALUE / 2;
		// 	if (i == x && j == y) return f[i][j][x][y] = 0;
		// 	if (f[i][j][x][y] < Integer.MAX_VALUE / 2) return f[i][j][x][y];
		// 	int r = Integer.MAX_VALUE / 2;
		// 	for (int ii = i; ii < x; ii++) 
		// 		r = Math.min(r, h[ii] + dfs(i, j, ii, y) + dfs(ii+1, j, x, y));
		// 	for (int jj = j; jj < y; jj++) 
		// 		r = Math.min(r, v[jj] + dfs(i, j, x, jj) + dfs(i, jj+1, x, y));
		// 	return f[i][j][x][y] = r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // m/n[1,100000] 数量级升级后，感觉，亲爱的表哥的活宝妹，有个规律，没能找到、想到，不知道怎么才能写过。。。
		// public long minimumCost(int m, int n, int [] h, int [] v) {
		// 	this.m = m; this.n = n; this.h = h; this.v = v;
		// }
		// int m, n, h[], v[];
		// int [][][][] f;

		// // 亲爱的表哥的活宝妹，把它想得太复杂了：说明【这个题型，亲爱的表哥的活宝妹是掌握了的！！】这个题目狠简单。。
		// public String losingPlayer(int x, int y) {
		// 	// this.x = x; this.y = y;
		// 	// f = new Integer [x+1][y+1][2];
		// 	// int v = dfs(x, y, 0);
		// 	// return v == 1 ? "Alice" : "Bob";
		// 	while (x >= 2 && y >= 8) {
		// 		x -= 2;
		// 		y -= 8;
		// 	}
		// 	return x >= 1 && y >= 4 ? "Alice" : "Bob";
		// }
		// // Integer [][][] f;
		// // int x, y;
		// // int dfs(int i, int j, int k) {
		// // 	if (i <= 0 || j < 4) return f[i][j][k] = -1;
		// // 	if (f[i][j][k] != null) return f[i][j][k];
		// // 	int canWin = false;
		// // 	if (k == 0) { // Alice's turn
		// // 	}			
		// // }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumLength(String S) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int [] r = new int [26];
		// 	for (char c : s) r[c-'a']++;
		// 	int f = 0;
		// 	System.out.println(Arrays.toString(r));
		// 	for (int i = 0; i < 26; i++) 
		// 		if (r[i] > 0 && r[i] % 2 == 0) f += 2;
		// 		else if (r[i] % 2 === 1) f += 1;
		// 	return f;
		// }
		
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，看丢了一个限制条件：改变的值只能是在【0,k】。 K >= Arrays.stream(a).max().getAsInt() 
		// // 就是，亲爱的表哥的活宝妹现有的思路，不能保证最优解。。没有思路，晚点儿再写这个
		// public int minChanges(int[] a, int k) {
		// 	int n = a.length;
		// 	TreeMap<Integer, Integer> m = new TreeMap<>();
		// 	for (int i = 0; i < n/2; i++) {
		// 		int v = Math.abs(a[i] - a[n-1-i]);
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	}
		// 	return n/2 - m.firstEntry().getValue();
		// }
 		
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minChanges(int n, int k) {
		// 	int r = 0;
		// 	for (int i = 0; i < 27; i++) {
		// 		if (((n >> i) & 1) == 0 && ((k >> i) & 1) == 1) return -1;
		// 		if ((((n >> i) & 1) ^ ((k >> i) & 1)) == 1) r++;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public boolean doesAliceWin(String S) {
		// 	int n = S.length(), r = 0; char [] s = S.toCharArray();
		// 	List<Character> l = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));
		// 	for (char c : s) 
		// 		if (l.contains(c)) r++;
		// 	if (r <= 0) return false;
		// 	if (r % 2 == 0 && r >= 2 && n > r || r % 2 == 1 && n > r) return true;
		// 	return false;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxOperations(String S) {
		// 	int n = S.length(), i = 0, j = n-1, k = 0, r = 0; char [] s = S.toCharArray();
		// 	int [] f = new int [n+1];
		// 	while (j >= 0 && s[j] == '1') j--;// s[j]=0
		// 	while (i < n && s[i] == '0') i++; // s[i]=1
		// 	if (i > j) return 0;
		// 	f[j] = 1;
		// 	k = j-1;
		// 	while (k >= 0) {
		// 		while (k >= 0 && s[k] == '0') {
		// 			f[k] = f[k+1];
		// 			k--;
		// 		}
		// 		while (k >= 0 && s[k] == '1') {
		// 			f[k] = f[k+1];
		// 			k--;
		// 		}
		// 		if (k >= 0 && s[k] == '0') {
		// 			f[k] = f[k+1] + 1;
		// 			--k;
		// 		}
		// 	}
		// 	k = 0;
		// 	while (i <= j) {
		// 		while (i < n && s[i] == '1') {
		// 			k++;
		// 			i++; // s[i]=1
		// 		}
		// 		if (i == j) return r + k * f[i];
		// 		r += k * f[i];
		// 		while (i < j && s[i] == '0') i++;
		// 		k = 0;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目，亲爱的表哥的活宝妹，没有思路，不熟悉这个题型，感觉比较难一点儿
		// // 看下提示，再试着看：能否启动，接着写？亲爱的表哥的活宝妹，不喜欢这类乱题目，不写了。。。
		// public long minimumOperations(int[] a, int[] b) {
		// 	int n = a.length;
		// 	long r = Long.MAX_VALUE;
		// 	int [] r = new int [n];// diff Arrays
		// 	for (int i = 0; i < n; i++)
		// 		r[i] = a[i] - b[i];
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 【动规】：应该是这个思路。数据规模不大，能写出来，就应该能够过！！另外，也可能是【贪心】解法，毕竟列的和，这里作用狠大。。
// 		// 【列、和、预处理】：列、【自顶向下】的和
// 		// 可怜的亲爱的表哥的活宝妹，还是得要再修练修练。。才能写【动规】成仙。。。
// 		// 亲爱的表哥的活宝妹，哏赤哏赤写了个O[NNNNN] 的解法，超时
// 		// 亲爱的表哥的活宝妹，却没能想到一个维度的优化，使用一点点儿贪心思想，就能把某个维度从【N】优化到【2】成O[NNNN2] 就能过。。。
// 		// 亲爱的表哥的活宝妹，自己写出来的：三维动规，跟它们传统三维动规不一样，只是答案也对但超时；
// 		// 自己的解法，距离，再加一步【贪心优化】把三维动规O[NNN-N] 转化为O[NNN-2], 感觉就没有思路
// 		// 网络上的题解、不超时的题解，看起来像是看懂了，实际上没看懂。。亲爱的表哥的活宝妹的三维动规，怎么才能【贪心】优化成O[NNN-2], 得好好想一想把它写出来。。
// 		// 看了网络上的分析后，想：亲爱的表哥的活宝妹当天的解，为什么没有，没出现统计结果上的偏差？是亲爱的表哥的活宝妹真写对了，还是它们的测试用例太有限了？越看越糊涂。。
// 		// 看来，亲爱的表哥的活宝妹，就不得不，自己再手写一遍，把它想透，才能真正搞明白。。。
// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		public long maximumScore(int[][] a) { // TLE TLE TLE: 790/795
// 			n = a.length;
// 			r = new Long [n][n]; // r:colSum
// 			for (int j = 0; j < n; j++) 
// 				r[0][j] = (long)a[0][j];
// 			for (int j = 0; j < n; j++)
// 				for (int i = 1; i < n; i++) 
// 					r[i][j] = r[i-1][j] + a[i][j];
// 			f = new Long [n+1][n][n+1]; // 【前一列涂色与否、与涂到 i 行】【当前列索引 j】【前一列收集与否、或收集过收集到 k 行】
// 			return dfs(n, 0, n);
// 		}
// 		Long [][][] f;
// 		Long [][] r;
// 		int n;  //i:[0,n]  j:colIdx k:j-1,collect/NOT 某一维，需要优化成N->2
// 		long dfs(int i, int j, int k) { // i: black or not k: prev collected or not
// 			if (j == n) return 0l; //f[i][j][k] = 0l;
// 			if (f[i][j][k] != null) return f[i][j][k];
// 			long ans = 0;
// 			if (j == 0) {// j == 0
// 				// 遍历：当前列0,从【0,n-1】格，最优解
// 				for (int x = 0; x < n; x++) 
// 					ans = Math.max(ans, dfs(x, j+1, n));
// // 当前列0: 不涂
// 				ans = Math.max(ans, dfs(n, j+1, n));
// 				return f[i][j][k] = ans;
// 			}
// 			if (i != n) {// 前一列：涂黑了, 前一列涂至【0,i】行
// 				// 当前列 j: 不涂, 收集 j 列 i
// 				ans = Math.max(ans, dfs(n, j+1, i) + r[i][j]);
// 				// 当前列，也涂
// 				for (int x = 0; x < n; x++)  // 统计入了偏差: 前一列的，或是当前列的
// 					ans = Math.max(ans, dfs(x, j+1, (x >= i ? n : i)) +
// 								   (k == n ? (x >= i ? r[x][j-1] - r[i][j-1] : r[i][j] - r[x][j])
// 									: 
// 									(x >= k ? r[x][j-1] - r[k][j-1] : (x < i ? r[i][j] - r[x][j] : 0)))); 
// 			} else { // 前一列：没涂 i ＝＝ n
// 				// 当前列 j: 不涂
// 				ans = Math.max(ans, dfs(n, j+1, n));
// 				// 当前列，涂
// 				for (int x = 0; x < n; x++)  // 统计入了偏差
// 					ans = Math.max(ans, dfs(x, j+1, n)
// 								 // 前一列：收集了吗？多添少补前一列的
// 								   + (k == n ? r[x][j-1] : (x >= k ? r[x][j-1] - r[k][j-1] : 0)));
// 			}
// 			return f[i][j][k] = ans;
// 		}
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，根据网络题解，自己再试着写一次。。。
// // 【TODO】：破烂题解，文言能力有限，一个思路讲不通、讲不透，读者亲爱的表哥的活宝妹看不懂！！！
// 		public long maximumScore(int[][] a) { // TLE TLE TLE: 790/795
// 			n = a.length;
// 			r = new long [n+1][n]; // r:colSum 每列的前缀和（从上到下）: 列 +1就是【初始化】的时候，稍微方便一点儿而已，破烂题解写晦涩难懂。。
// 			for (int i = 1; i <= n; i++)
// 				for (int j = 0; j < n; j++)
// 					r[i][j] = r[i-1][j] + a[i-1][j];
// 			f = new Long [n-1][n+1][2]; // 【当前列号 i】【后一列 i+1 列黑格个数【0,N】】【 i+1 列黑格数，是否小于 i+2 列黑格个数？0:否；1:是】
// 			long ans = 0;
// 			for (int j = 0; j <= n; j++) 
// 				ans = Math.max(ans, dfs(n-2, j, 0));
// 			return ans;
// 		}
// 		Long [][][] f;
// 		long [][] r;
// 		int n;  // i:[ 当前列下标 i:0,n-1] j: 后一列i+1 的黑格数[0,N] k:[0,1]
// 		long dfs(int i, int j, int k) { 
// 			if (i < 0) return 0;
// 			if (f[i][j][k] != null) return f[i][j][k];
// 			long ans = 0;
// 			for (int x = 0; x <= n; x++) { // 遍历：当前列 i 列，所有可能的黑格个数【0,N】个
// 				if (x == j) // 【第一种情况】：当前列 i 与后一列 i+1 列，两列黑格数完全一样，不产生【新增收集】，直接递归深搜。。
// 					ans = Math.max(ans, dfs(i-1, j, 0));
// 				else if (x < j) // 【第二种情况】：【右边黑格多】当前列 i 列，黑格个数 < 后一列 i+1 列黑格个数：计入当前列【新增收集】
// 					// 引入、收集、当前列的【x-cur,j-prev）计入总分数
// 					ans = Math.max(ans, dfs(i-1, x, 1) + r[j][i] - r[x][i]);
// 				// x > j:
// 				// 【TODO】：下面仅只【贪心遍历：贪心地，仅只考虑 x=0 唯一一种、极度贪心、快速解】？？？
// 				// 亲爱的表哥的活宝妹，上面理解得不对，要怎么测试一下这个理解。。。。【TODO】：
// 				else if (k == 0) // 【第三种、贪心跳跃情况】：当前列 i 黑格数大于后一列 i+1 列黑格数；i+1 列黑格大不小于 i+2 列黑格数
// 					// 当，当前列 i 列黑格数大于后一列 i+1 列黑格数时，后一列 i+1 列，（pre,cur】新增加的收集，计入总分数
// 					ans = Math.max(ans, dfs(i-1, x, 0) + r[x][i+1] - r[j][i+1]);
// // 亲爱的表哥的活宝妹，少考虑了下面的一种情况：【TODO】：破烂题解，文言能力有限，一个思路讲不通、讲不透，读者亲爱的表哥的活宝妹看不懂！！！
// 				else if (j == 0) // 【第四种：（凹形）：cur > pre < 第 j+2 列的黑格个数】
// 					// 此时第 j+2 列全黑最优（递归过程中一定可以枚举到这种情况）
// 					// 第 j+1 列全白是最优的，所以只需考虑 pre=0 的情况
// 					// 由于第 j+1 列在 dfs(j+1) 的情况二中已经统计过，这里不重复统计
// 					ans = Math.max(ans, dfs(i-1, x, 0));
// 			}
// 			return f[i][j][k] = ans;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public boolean canAliceWin(int[] a) {
		// 	int n = a.length, l = 0, r = 0;
		// 	for (int v : a)
		// 		if (v < 10) l += v;
		// 		else r += v;
		// 	return l != r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 破烂题目：跟什么狗屁的质数、分解质因子相关
		// // 这个破烂题目：极度恶心人。一个数，如果它只有1 和它的开平方根两个合数，也就是说，这个数必须是某个【质数】的平方
		// // 这个破烂题目：就转化为是，数【1,r】里，有多少个数y是，某质数的平方；数【1,l-1】里，有多少个数x是，某质数的平方；结果为 y-x
		// // 这个破烂题目：数【1,10^9】里，平方上限为 10^9 的最大质数是 31622;
		// // 31622 以下的质数，共有 3401 个。。。破烂题目，不写！！
		// public int nonSpecialCount(int l, int r) {
		// 	int v = (int)Math.sqrt((int)Math.pow(10, 9));
		// 	System.out.println("v: " + v);
		// 	return 0;
		// }

		// // 亲爱的表哥的活宝妹，感觉，这个破烂死题目，太难了，鬼知道，圆圈里的点，是怎么数的？看下提示才再写。。。
		// // 【提示】：思路比较巧妙，把数学问题，转化成【图形问题】，就比较好解。试写一下
		// boolean canReachCorner(int ll, int rr, int [][] lli) {
		// 	n = lli.length; this.lli = lli; this.ll = ll; this.rr = rr; 
		// 	// 先把 n 个圆圈：按【最左端点、X 轴、升序】【最底端点、Y 轴、升序】【半径、升序】排列
		// 	Arrays.sort(lli, (a, b) -> a[0] - a[2] != b[0] - b[2] ? a[0] - a[2] - (b[0] - b[2]) :
		// 				(a[1] - a[2] != b[1] - b[2] ? a[1] - a[2] - (b[1] - b[2]) : a[2] - b[2])); 
		// 	System.out.println("lli.length: " + lli.length);
		// 	for (int z = 0; z < lli.length; ++z) 
		// 		System.out.println(Arrays.toString(lli[z]));
		// 	// 【建图】：N+4 个顶点、可变数的边的个数
		// 	// 【N+4 个顶点的、图】：图，这里是什么？把它转化成一个可以编程的东西
		// 	g = new ArrayList[n+4];
		// 	Arrays.setAll(g, z -> new ArrayList<Integer>());
		// 	// 【建图】：遍历 n 个圆：同步检测，与四边、和前序圆的、交差情况
		// 	int x = 0, y = 0, r = 0, xx = 0, yy = 0, rp = 0, pj = -1;// pj: 可以记住，全程只遍历一遍？！！！
		// 	for (int i = 0; i < n; i++) {
		// 		// System.out.println("\n i: " + i);
		// 		// System.out.println(Arrays.toString(lli[i]));
		// 		x = lli[i][0]; y = lli[i][1]; r = lli[i][2];
		// 		// 【预处理】：排除不合法解: 跟左下角0 或右上角（ll,rr）有交差，直接返假
		// 		if ((int)Math.pow(x, 2) + (int)Math.pow(y, 2) <= r * r
		// 			|| (int)Math.pow(x-ll, 2) + (int)Math.pow(y-rr, 2) <= r * r) return false;
		// 		// 遍历：【前序圆】，建立可 reachable 的有效连接边，直到，不可能再有任何交差
		// 		// 先，检测与【四边】的交差情况
		// 		// 上, n
		// 		if (y + r >= rr) {
		// 			g[n].add(i);
		// 			g[i].add(n);
		// 		}
		// 		// 右: n+1
		// 		if (x + r >= ll) {
		// 			g[n+1].add(i);
		// 			g[i].add(n+1);
		// 		}
		// 		// 下: n+2
		// 		if (y - r <= 0) {
		// 			g[n+2].add(i);
		// 			g[i].add(n+2);
		// 		}
		// 		// 左: n+3
		// 		if (x - r <= 0) {
		// 			g[n+3].add(i);
		// 			g[i].add(n+3);
		// 		}
		// 		// 再，【前序圆】，建立可 reachable 的有效连接边，直到，不可能再有任何交差
		// 		// for (int j = i-1; j >= 0 && j > pj; j--) {
		// 			for (int j = i-1; j >= 0; j--) {
		// 			xx = lli[j][0]; yy = lli[j][1]; rp = lli[j][2];
		// 			// 与前面的所有圈，完全无交差，不再遍历. pj可以记住，全程只遍历一遍？！！！
		// 			if (xx + rp < x - r && (yy + rp < y - r || yy - rp > y + r)) { // Y 轴上：可在上，也可以在下
		// 				// pj = j;
		// 				break;
		// 			}
		// 			// 当前圆圈 i 与前圆圈 j 有交差，建立交差边
		// 			// 这里，亲爱的表哥的活宝妹，可能有考虑不周，判断不准的情况，再精确一点儿：
		// 			if ((int)Math.pow(x-xx, 2) + (int)Math.pow(y-yy, 2) <= (int)Math.pow(r+rp, 2)) {
		// 				g[i].add(j);
		// 				g[j].add(i);
		// 			}
		// 		}
		// 	}
		// 	// 【打印图】：
		// 	for (int i = 0; i < n+4; i++)
		// 		if (g[i].size() > 0)
		// 			System.out.println(g[i].size() + Arrays.toString(g[i].toArray()));
		// 		else 
		// 			System.out.println("i: " + i + "empty");
		// 	// 【求解】：检查四边的可达情况：转化为一种 dfs(u, v): u v 两顶点，可达吗？
		// 	boolean a = dfs(n, -1, n+2, BigInteger.ZERO);
		// 	System.out.println("a: " + a);
		// 	if (a) return false;
		// 	boolean b = dfs(n+1, -1, n+3, BigInteger.ZERO);
		// 	System.out.println("b: " + b);
		// 	if (b) return false;
		// 	boolean c = dfs(n, -1, n+1, BigInteger.ZERO);
		// 	System.out.println("c: " + c);
		// 	if (c) return false;
		// 	boolean d = dfs(n+2, -1, n+3, BigInteger.ZERO);
		// 	System.out.println("d: " + d);
		// 	if (d) return false;
		// 	// if (dfs(n, -1, n+2) || dfs(n+1, -1, n+3) || dfs(n, -1, n+1) || dfs(n+2, -1, n+3)) return false;
		// 	// if (a || b || c || d) return false;
		// 	return true;
		// }
		// int n, ll, rr;
		// int [][] lli;
		// List<Integer> [] g;
		// // 如果图中可能存在环，N[1,1000] 遍历过一次与否的标记，又得使用狗屁BigInteger 好烦人。。
		// // 亲爱的表哥的活宝妹，不知道，这里哪里想错了，为什么会 StackOverflowError, 改天约几天或是一周后再回来看这题目。。
		// boolean dfs(int u, int p, int V, BigInteger mask) { // 不知道哪里写错了，java.lang.StackOverflowError... 也就是说，图中可能存在环
		// 	if (u == V) return true;
		// 	// 下面一行：仅用作参考
		// 	// BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE); // 制造一个：有V 个数位、每个数位都是 1 的大数 mask
		// 	// 下面，换种写法
		// 	// if (mask.shiftRight(u).and(BigInteger.ONE) == BigInteger.ONE) return false;
		// 	if (mask.compareTo(BigInteger.ZERO) > 0 && mask.and(BigInteger.ONE.shiftLeft(u)) == BigInteger.ONE.shiftLeft(u)) return false; // 说明：有环
		// 	mask = mask.add(BigInteger.ONE.shiftLeft(u));
		// 	// if (g[u].size() == 0) return false;
		// 	for (int v : g[u]) {
		// 		if (v == p) continue;// 无向图，不要重复遍历
		// 		if (dfs(v, u, V, mask)) return true;
		// 	}
		// 	return false;
		// }
		// // 亲爱的表哥的活宝妹，还是把上面的题目，想得复杂了一点儿。看看别人的思路、再想想、简单轻松呀。。亲爱的表哥的活宝妹，得学会自己想思路。。。
		// // 亲爱的表哥的活宝妹，希望有人列出亲爱的表哥的活宝妹上面的解法，因为现在的亲爱的表哥的活宝妹，不知道上面写错哪里了。。。
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// class Uf { // UnionFind
		// 	int [] f;
		// 	public  Uf(int n) {
		// 		f = new int [n];
		// 		for (int i = 1; i < n; i++) // 真正有效的是从：下标 1 开始的, 还是从 0 开始的？？【TODO】：
		// 			f[i] = i;
		// 	}
		// 	int find(int i) { // 【TODO】：忘记，这个的底层原理了
		// 		if (f[i] != i)
		// 			f[i] = find(f[i]);
		// 		return f[i];
		// 	}
		// 	void union(int i, int j) {
		// 		// if (f[i] != f[j]) // 【写错了】：这里 f[i] 与 f[j] 未必是实时更新了的，必须检查确保一下
		// 		// 	f[i] = find(f[j]); // 随便偏向哪边
		// 		f[find(i)] = find(j); // 【TODO】：亲爱的表哥的活宝妹，需要再次消化理解一遍，把这些破烂弄懂弄透彻。。
		// 	}
		// }
		// public boolean canReachCorner(int ll, int rr, int[][] a) {
		// 	int n = a.length, x = 0, y = 0, r = 0, xx = 0, yy = 0, rp = 0;
		// 	Uf uf = new Uf(n+2);
		// 	// 填充【并查集】
		// 	for (int i = 0; i < n; i++) {
		// 		x = a[i][0]; y = a[i][1]; r = a[i][2];
		// 		if (x - r <= 0 || y + r >= rr) // 与【左上】有连接 
		// 			uf.union(i, n);
		// 		if (x + r >= ll || y - r <= 0) // 与【右下】有连接
		// 			uf.union(i, n+1);
		// 		for (int j = 0; j < i; j++) {
		// 			xx = a[j][0]; yy = a[j][1]; rp = a[j][2];
		// 			// 两个圆：【相交】或是【相切】
		// 			if ((long)Math.pow(x - xx, 2) + (long)Math.pow(y - yy, 2) <= (long)Math.pow(r + rp, 2))
		// 				uf.union(i, j);
		// 		}
		// 	}
		// 	if (uf.find(n) != uf.find(n+1)) return true;
		// 	return false;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // N:[1,10^4] 应该是【动规】解法，可是思路。。O(NN=10^8) 不知道，能不能过 TLE ？
		// // 这个【动规】题目，其实狠难，是周赛里通过率最低的一个题目，只有9.0% 通过率
		// // 亲爱的表哥的活宝妹，不知道，哪里想错、数错了。。。晚点儿再写这个
		// public int numberOfSubstrings(String S) {
		// 	int n = S.length(), x = 0, y = 0; char [] s = S.toCharArray();
		// 	int [] r = new int [n+1]; // 1 的前缀和
		// 	for (int i = 0; i < n; i++) 
		// 		r[i+1] = r[i] + s[i] - '0';
		// 	boolean oneDom = r[n] > n-r[n];
		// 	int [] f = new int [n+1]; // 定义为 f[i]：以 i 为结尾的、S 的前缀、合法子串的个数
		// 	// 暴力＋部分【动规】解法
		// 	for (int i = 0; i < n; i++) { // 遍历下标：O(N)
		// 		f[i+1] += (!oneDom ? s[i] - '0' : 1-(s[i]-'0'));
		// 		// 当前数是‘1’：狠简单
		// 		if (!oneDom && s[i] - '0' == 1 && (i > 0 && s[i-1]-'0' == 1)
		// 			|| oneDom && s[i] - '0' == 0 && (i > 0 && s[i-1]-'0' == 0)) {
		// 			f[i+1] += f[i] * 2;
		// 			continue;
		// 		}
		// 		// 当前数是 '0': 比较复杂、繁琐： x=0 y = 1:
		// 		// 首先：当前 s[i]='0', 子串可以不以当前的’0' 为结尾，那么 f[i+1] 的基数、初始化为 f[i], 就是前一个下标的最多个数
		// 		f[i+1] += (!oneDom && s[i]-'0' == 0 || oneDom && s[i] == '1' ? f[i] : 0);
		// 		// 其次，以当前s[i]='0', 子串、以、当前的’0' 为结尾，新增的个数，数出来。。弱弱亲爱的表哥的活宝妹，滚去数吧。。。
		// 		// 去找、倒序遍历 j, 最大的 j, 使S.substring(j,i+1) 是一个最短的？、以 i 为结尾的合法字符串
		// 		for (int j = i-1; j >= 0; j--) {
		// 			y = r[i+1] - r[j]; // Sum of 1 [j, i]
		// 			x = i-j+1 - y;     // sum of 0 [j, i]
		// 			if (!oneDom && y >= (int)Math.pow(x, 2)
		// 				|| oneDom && y < (int)Math.pow(x, 2)) {
		// 				f[i+1] += f[j] + 1;
		// 			}
		// 		}
		// 	}
		// 		return !oneDom ? f[n] : n * (n+1) / 2 - f[n];
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这种狗屁破烂思路，考试的时候，怎么想得到？
		// public int numberOfSubstrings(String S) {
		// 	int n = S.length(), m = 0, i = 0, r = 0; char [] s = S.toCharArray();
		// 	int [] idx = new int [n+1]; // 记：每个0 所在的下标索引
		// 	for (int j = 0; j < n; j++)
		// 		if (s[j] == '0') idx[m++] = j;
		// 	idx[m] = n; // 【哨兵】；什么意思？
		// 	int ttOne = n - m, cntZero = 0, cntOne; // 1 的总个数
		// 	// 枚举：所有子串的【左端点】
		// 	for (int left = 0; left < n; left++) {
		// 		if (s[left] == '1') // 不包含任何0 的子串的个数: 下一个‘0’会出现在 a[i] 下标
		// 			r += idx[i] - left;
		// 		// 枚举：以 left 为【左端点】的任何子串里，所有可能的 0 的个数，最多为 sqrt(n) 个 0
		// 		for (int j = i; j < m; j++) {
		// 			cntZero = j - i + 1; // [left,a[j]] 之间，0 的总个数
		// 			if (cntZero * cntZero > ttOne) break;
		// 			// cntOne = a[j]+1 - left - cntZero;
		// 			// cntOne = a[j]+1 - left - (j - i + 1);
		// 			cntOne = idx[j] - left - (j - i);
		// 			// 【精减】：下面的判断条件可以去掉，因为不满足条件时，就是取值 0
		// 			// if (a[j]+1 - left - cntZero >= (int)Math.pow(cntZero, 2))
		// 				// 【left,a[j]】片段，仅只精确 j+1 个0, 可以延展到的最右端下标为 a[j+1]-1, 计算这个可延展片段长度，即子串个数
		// 			r += Math.max(0, idx[j+1]-1+1 - idx[j] - Math.max(0, cntZero * cntZero - cntOne));
		// 		}
		// 		// 每遍历过一个’0', 这个0 以后就不会再遍历到了
		// 		if (left == idx[i]) i++; // 跟下面的条件，等价，写哪个都行
		// 		// if (s[left] == '0') i++;
		// 	}
		// 	return r;
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 【差分数组】的解法：这些基础知道，都快要忘光了。。
// 		public long minimumOperations(int[] a, int[] b) {
// 			int n = a.length;
// // r:ans s:sum 至当前下标，【差分数组】操作、所累积的、可以免费【反方向】操作的次数
// 			long s = b[0] - a[0], k = 0, r = Math.abs(b[0] - a[0]); 
// 			for (int i = 1; i < n; i++) { // 遍历：【差分数组】的下标
// 				k = (b[i] - b[i-1]) - (a[i] - a[i-1]); // 当前下标下：两差分数组的差值，务必需要调整的大小
// 				if (k >= 0)
// 					r += s >= 0 ? k : Math.max(s + k, 0);
// 				else // k <= 0
// 					// r += s <= 0 ? -1 * k : -1 * Math.min(s + k, 0);
// 					r -= s <= 0 ? k : Math.min(s + k, 0);
// 				s += k;
// 			}
// 			return r;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【记忆化深搜：】一定会超时？O(N=10^5*3?) 可是写不到动规，就先深搜一遍，启蒙一下。。。再改动规。。。改天再写 1955
        // public int countSpecialSubsequences(int[] a) { // 【TODO】：亲爱的表哥的活宝妹，没想明白，这里怎么会数少了的？明明算法，能够所括所有情况。。明天再想这个题目
        //     n = a.length; this.a = a;
        //     g = new ArrayList [3]; Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int i = 0; i < n; i++)
        //         g[a[i]].add(i);
        //     f = new Integer [n][3][2]; // 最后一维，用来标记：是否一定填 j (k=0), 能不能,增加 j 的大小(k=1 时可以)？
        //     return dfs(0, 0, 0);
        // }
        // static final int mod = (int)1e9 + 7; int [] a;
        // List<Integer> [] g;
        // Integer [][][] f;
        // int n; 
        // int dfs(int i, int j, int k) { // 【TODO】：少数了几种，重复数字的情况
        //     if (i == n) return j == 2 && k == 1 ? 1 : 0; // 消灭掉了【假阳性】
		// 	if (j > 2) return 0;
		// 	if (f[i][j][k] != null) return f[i][j][k];
        //     long ans = 0;
		// 	// 任何情况下：都可以，先填一个、在下标 g[j].get(x) 的值为j 时 、被要求的 j
		// 	for (int x = 0; x < g[j].size(); x++) {
		// 		if (g[j].get(x) < i) continue;
		// 		// 【不要，不取、当前下标的 j 值 , 去取下一个可能的 j 值】：
		// 		// if (x < g[j].size()-1) // 限制条件：不影响结果
		// 		if (k == 0)
		// 			ans = (ans + (long)dfs(g[j].get(x)+1, j, 0)) % mod;
		// 		// 【要，取、当前下标的 j 值 】：
		// 		ans = (ans + (long)dfs(g[j].get(x) + 1, j, 1)) % mod;
		// 	}
		// 	if (k == 1)
		// 		ans = (ans + (long)dfs(i, j+1, 0)) % mod;
        //     return f[i][j][k] = (int)ans;
        // }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int winningPlayerCount(int n, int[][] a) {
		// 	int [][] f = new int [n][11]; // 每个人，不同颜色球的个数
		// 	for (int [] v : a)
		// 		f[v[0]][v[1]]++;
		// 	int ans = 0;
		// 	boolean win = false;
		// 	for (int i = 0; i < n; i++) {
		// 		win = false;
		// 		for (int j = 0; j < 11; j++) 
		// 			if (f[i][j] >= i+1) {
		// 				win = true;
		// 				break;
		// 			}
		// 		if (win) 
		// 			ans++;
		// 	}
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minFlips(int[][] a) {
		// 	int m = a.length, n = a[0].length;
		// 	int [] r = new int [m], c = new int [n];
		// 	for (int i = 0; i < m; i++)
		// 		for (int j = 0; j < n/2; j++) {
		// 			if (a[i][j] != a[i][n-1-j])
		// 				r[i]++;
		// 		}
		// 	for (int j = 0; j < n; j++)
		// 		for (int i = 0; i < m/2; i++)
		// 			if (a[i][j] != a[m-1-i][j]) c[j]++;
		// 	return Math.min(Arrays.stream(r).sum(), Arrays.stream(c).sum());
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minFlips(int[][] a) { // 399/661 passed 再不想写这么恶心人的题目了。。。
		// 	int m = a.length, n = a[0].length;
		// 	int ss = 0;
		// 	for (int i = 0; i < m; i++) 
		// 		ss += Arrays.stream(a[i]).sum();
		// 	if (m * n < 4) return ss;
		// 	if (m * n == 4) return Math.min(ss, 4 - ss);
		// 	int [][] f = new int [m/2+m%2][n/2+n%2];
		// 	int r = 0, cnt = 0;
		// 	for (int i = 0; i < m/2+m%2; i++) 
		// 		for (int j = 0; j < n/2+n%2; j++) {
		// 			r = 0; cnt = 1; 
		// 			r += a[i][j];
		// 			if (m-1-i != i) {
		// 				r += a[m-1-i][j];
		// 				cnt++;
		// 			}
		// 			if (n-1-j != j) {
		// 				r += a[i][n-1-j];
		// 				cnt++;
		// 			}
		// 			if (m-1-i != i && n-1-j != j) {
		// 				r += a[m-1-i][n-1-j];
		// 				cnt++;
		// 			}
		// 			f[i][j] = Math.min(r, cnt - r);
		// 			if (cnt <= 2 && m != 1 && n != 1) f[i][j] = Math.max(f[i][j], r == 0 ? 0 : r);
		// 		}
		// 	// System.out.println("f.length: " + f.length);
		// 	// for (int z = 0; z < f.length; ++z) 
		// 	// 	System.out.println(Arrays.toString(f[z]));
		// 	int sum = 0;
		// 	for (int i = 0; i < m/2+m%2; i++) 
		// 		sum += Arrays.stream(f[i]).sum();
		// 	return Math.min(sum, m * n - ss);
		// }

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 这个题目，亲爱的表哥的活宝妹，可以回想起先前一个【类似】，求以不同节点为【根节点】的，什么和之类的题型，感觉类似
		public int[] timeTaken(int[][] egs) {
			n = egs.length + 1;
			g = new ArrayList [n];
			Arrays.setAll(g, z -> new ArrayList<Integer>());
			for (int [] e : egs) {
				int u = e[0], v = e[1];
				g[u].add(v);
				g[v].add(u);
			}
// 重新建立树？还是说，【动规】，只要记住状态就可以了，未必一定需要一棵【物理树】！
			// 感觉，这里，亲爱的表哥的活宝妹，需要一个【数据结构：DFS 深搜】来标记深度等
			// 设定：【以0 为根节点】: 建立【无向图、树的、基础数据】
			//f[i][j][k][x]: 以 i 为根节点的，子树的、距离根节点0 的[2:Deptth-odd/even-Cnts];
			// 以 i 为根节点的，子树的、最深叶子【奇数叶子】【偶数叶子】的【深度记录】
			int [][] f = new int [n][6]; // [2:Deptth-odd/even-Cnts][2:maxDepth-ODD[odd/even]][2:maxDepth-EVEN[odd/even]]
			ans = new int [n];
			Arrays.fill(ans, 2 * n);
			ans[0] = 0;
			// 同步计算：0 为根节点，ans[0] 时，各节点的更新时间，在 ans 数组里
			dfs(0, -1, new int [2], 0);     //  [0,1]                  Odd: [2,3]                 Even:[4,5]
			// 最后精确：与其它任何节点非0 节点为【根节点】，所存在的、与以0 为根节点的【时间出入、误差校正】
			// 这部分最难：但感觉，不是不能攻克的！！先写前一题，再回来写这里
		}
		List<Integer> [] g;
		int [] ans;
		int n;
		void dfs(int u, int p, int [] depth, int t) {
			// 笨宝妹：叶子节点，拎不清楚，提出来，单独考虑
			if (g[u].size() == 1 && g[u].get(0) == p) { // 叶子节点
				if (u % 2 == 1) { // 奇
					// f[u][0] = f[u][2] = 1; // 以 i 为根节点的，子树的、距离根节点0 的[2:Deptth-odd/even-Cnts];
					// f[u][1] = f[u][3] = 0;
					f[u][2] = 1; // 以 i 为根节点的，子树的、距离根节点0 的[2:Deptth-odd/even-Cnts];
					f[u][3] = 0;
				} else {         // 偶
					// f[u][0] = f[u][4] = 0;
					// f[u][1] = f[u][5] = 1; // 
					f[u][4] = 0;
					f[u][5] = 1; // 
				}   
			}
			if (p != -1) {
				t += 2 - u % 2;
				ans[u] = t;
			}
			if (u % 2 == 0) depth[1]++;// 亲爱的表哥的活宝妹，这里把奇偶写得反一点儿了。。。
			else depth[0]++; // 记入当前节点 u 奇偶性深度
			f[u][0] = depth[0]; // 以 i 为根节点的，子树的、距离根节点0 的/ 自已所在深度的 [2:Deptth-odd/even-Cnts] 计数
			f[u][1] = depth[1]; // [0,1] 是自0 为根节点，【自顶向下】纪录 
			for (int v : g[u]) {
				if (v == p) continue;
				dfs(v, u, depth);
				// 根据子节点：累积当前【根节点U】的【最大深度、奇数】【最大深度、偶数】
				// 【2,3】【4,5】是自叶子向上，【自底向上】纪录的
				// 取所有叶子节点的最大值 
				// if (f[v][2] >= f[u][2]) {
					// f[u][2] = f[v][2];
					f[u][2] = Math.max(f[u][2], f[v][2]); // 这个不同步更新，会造成什么结果灾难吗？总之，记的是最大深度。。
					f[u][3] = Math.max(f[u][3], f[v][3]); // 这个不同步更新，会造成什么结果灾难吗？总之，记的是最大深度。。
				// }
				// if (f[v][5] >= f[u][5]) {
					// f[u][5] = f[v][5];
					f[u][4] = Math.max(f[u][4], f[v][4]);
					f[u][5] = Math.max(f[u][5], f[v][5]);
				// }
			}
			// 累加当前节点的深度信息
			if (u % 2 == 1) {
				f[u][2]++;
				f[u][4]++;
			} else {
				f[u][3]++;
				f[u][5]++;
			}
		}
	}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		// int [][] a = new int [][] {{1,0,0},{0,1,0},{0,0,1}};
		// int [][] a = new int [][] {{0,1},{0,1},{0,0}};
		// int [][] a = new int [][] {{1},{1},{1},{0}};
		// int [][] a = new int [][] {{1,0,0},{0,0,1},{0,0,1}};
		// int [][] a = new int [][] {{0},{1},{0},{1},{1}};
		// int [][] a = new int [][] {{0,1,1,0}};
		int [][] a = new int [][] {{0},{1},{1},{1},{1}};

		System.out.println("a.length: " + a.length);
		for (int z = 0; z < a.length; ++z) 
			System.out.println(Arrays.toString(a[z]));

		int r = s.minFlips(a);
		System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a0]); 
// head.buildList(head, a);
// head.printList(head);
// Tree [N de rr = new [] TreeNode(a0);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】