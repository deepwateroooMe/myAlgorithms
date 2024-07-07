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

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 感觉是，狗屁的【记忆化深搜＋字典树】？遍历【目标字符串】＋遍历【dfs 深搜字典树】，【记忆化深搜】找最小代价。。。702/803 passed ...
		// TLE 的情况下：亲爱的表哥的活宝妹，就得去想，字典树，可能加反了。。。加S 的所有子串，或至少另一棵字典树，加S 的所有子串，用来提速。。。
		// 上面不对：Deque<Integer> [26] q  = new ArrayDeque[26]; 用来记S 里【ab...z】的所有下标
		public class Trie {
			public  class Node {
				char c;
				boolean f;
				int i; // 用来记：串的长度
				Node [] n;
				public Node(char c, boolean f) {
					this.c = c; this.f = f;
					n = new Node[26];
					i = -1;
				}
			}
			Node r;
			public Trie() {
				r = new Node(' ', false);
			}
			public void insert(String S) {
				int n = S.length();
				char [] s = S.toCharArray();
				Node f = r;
				for (int i = 0; i < n; i++) {
					int j = s[i] - 'a';
					if (f.n[j] == null)
						f.n[j] = new Node(s[i], false);
					f = f.n[j];
				}
				f.f = true;
				// f.i = (f.i == -1 || f.i > k ? k : f.i);
				f.i = S.length();
			}
			List<Integer> searchAllLength(int i) { // 遍历【字典树】：找 s[] 从下标 i 开始，所有匹配的字符串的下标
				List<Integer> l = new ArrayList<>();
				Node f = r;
				int j = i;
				while (j < s.length && f.n[s[j]-'a'] != null) {
					if (f.n[s[j]-'a'].f) l.add(f.n[s[j]-'a'].i);
					f = f.n[s[j]-'a'];
					j++;
				}
				return l;
			}
		}
		public int minimumCost(String S, String[] sa, int[] a) {
			n = S.length(); this.sa = sa; this.a = a; this.S = S; 
			t = new Trie(); ss = new Trie();
			s = S.toCharArray();
			q = new ArrayDeque[26];
			Arrays.setAll(q, z -> new ArrayDeque<Integer>());
			for (int i = 0; i < n; i++)
				q[s[i]-'a'].offerLast(i);
			for (int i = 0; i < sa.length; i++) {
				if (!isSubString(i)) continue;
				if (ms.containsKey(sa[i])) {
					ms.put(sa[i], Math.min(ms.get(sa[i]), a[i]));
					continue;
				}
				if (sa[i].length() <= n)
				t.insert(sa[i]);
				ms.put(sa[i], a[i]);
			}
			f = new Integer [n];
			int r = dfs(0); 
			return r >= Integer.MAX_VALUE / 2 ? -1 : r;
		}
		boolean isSubString(int i) { // i:idx in sa
			boolean valid = true;
			Deque<Integer> sq = q[sa[i].charAt(0)-'a'];
			for (int j : sq) {
				valid = true;
				for (int k = j; k < j+sa[i].length(); k++) 
					if (s[k] != sa[i].charAt(k-j)) {
						valid = false;
						break;
					}
				if (valid)
					return true;
			}
			return false ;
		}
		Trie ss, t;
		int n; String [] sa; int [] a; char [] s; String S;
		Deque<Integer> [] q = new ArrayDeque[26];
		Map<String, Integer> ms = new HashMap<>(); // 如果：记另外字典里，就需要【字典树返回长度。。】
		Integer [] f;
		int dfs(int i) {
			if (i == n) return 0;
			List<Integer> l = t.searchAllLength(i);
			if (l.size() == 0) return f[i] = Integer.MAX_VALUE / 2;
			int r = Integer.MAX_VALUE / 2;
			for (int j : l) 
				r = Math.min(r, ms.get(S.substring(i, i+j)) + dfs(i+j));
			return f[i] = r;
		}
}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		String a = "xmjpkowhuefntanqvygzukqlxrrpsbuscjesdxilsjodkjjzhfrzymiaeedjsfpquiu";
		String [] b = new String []  {"u","m","i","d","busc","z","j","s","huefntanqvygzuk","d","qlxrrpsbuscjesdxilsjodkjj","nqvygzukqlxrrpsbuscjesdxilsjodkjjzhfrzymiaee","h","c","o","s","l","sjodkjjzhfrzymi","aeedjsfpqu","i","u","kowhue","pkowhuefntanqvygzukqlxrrpsbus","x","j","djsfpquiu","dxilsjodkjjzhfrzymiaeedjsfpqu","j","jodkjjzhfrzymia","xrrpsbuscjesdxilsj","r","f","iu","k","frzymiaeedjsf","zymiaee","djsf","j","mjpkowh","d","j","x","i","miaeed","fntanqvygzukqlxrrpsbuscjesdxilsjodkjjzhfrzymiaeedjsfpq","lxrrpsbuscjesdxilsjod","jsfpqu","e"};
		int []  c = new int []  {41,2,23,44,1,2,31,12,4,43,17,16,19,34,36,36,16,17,30,19,34,5,43,28,43,31,1,21,26,2,23,10,48,24,7,44,1,46,26,25,24,31,23,13,7,13,24,41};

		int r = s.minimumCost(a, b, c);
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