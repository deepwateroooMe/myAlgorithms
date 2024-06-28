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

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 亲爱的表哥的活宝妹，切【苹果蛋糕——先前的动规题型】——所有的苹果，要极尽可能地，分布在总面积最小的三块蛋糕上
		// 变形变型的【记忆化深搜】？657/661 passed !!! TLE TLE TLE !!!
		// 写出这个题目，感觉亲爱的表哥的活宝妹，真强大！！用实际题目来证明：只要亲爱的表哥的活宝妹，能够自己相得明白，亲爱的表哥的活宝妹，就能够把代码写出来、实现出来！！
		// 感觉这里，亲爱的表哥的活宝妹，应该还可以再优化一些不必的重复过的边角检测之类的小细节。。现在，再来试写一下，为什么会有最后几个测试、不过？？？
		// 写出这个题目，感觉亲爱的表哥的活宝妹，真强大！！亲爱的表哥的活宝妹，只要还想用点儿力写，就能自己、独立，把它写过！！！
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		public int minimumSum(int[][] a) {
			m = a.length; n = a[0].length; this.a = a; 
			f = new Integer [m][n][m][n][4];
			sum = new int [m+1][n+1]; // 数组和，预处理，备用
			for (int i = 1; i <= m; i++) 
				for (int j = 1; j <= n; j++) 
					sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + a[i-1][j-1];
			int r = dfs(0, 0, m-1, n-1, 3);
			return r;
		}
		Integer [][][][][] f; // 得有【起点】与【终点】与【要的块数】
		int [][] a, sum;
		int m, n;
		int dfs(int i, int j, int x, int y, int k) {
			if (i < 0 || j < 0 || x < 0 || y < 0 || i >= m || j >= n || x >= m || y >= n || k < 0 || k > 3) return 1000;
			if (k == 0) {
				int s = sum[x+1][y+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
				return f[i][j][x][y][k] = (s == 0 ? 0 : 1000);
			}
			if (f[i][j][x][y][k] != null) return f[i][j][x][y][k];
			if (i == x && j == y && k == 1) return f[i][j][x][y][k] = 1;
			// 遍历：行切、列切、并减少1 块. 这里要再想深一点儿：【3 块的行列分布、等细节】
			if (k == 1) 
				return f[i][j][x][y][k] = minimumArea(i, j, x, y);
			// k = [2 || 3] 少考虑了一种情况 0 因为行、列可能是空行
			int r = 1000;
// 遍历，先行切: 行切至当前行，包括当前行
			for (int ii = i; ii < x; ii++) {
				int s = sum[ii+1][y+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
				if (s == 0) continue;
				r = Math.min(r, Math.min(dfs(i, j, ii, y, 1) + dfs(ii+1, j, x, y, k-1), // 行：上半1 ＋下半 k-1
										 dfs(i, j, ii, y, 2) + dfs(ii+1, j, x, y, k-2))); // 行：上半2 ＋下半 k-2
			}
// 遍历，先行列: 行切至当前列，包括当前列
			for (int jj = j; jj < y; jj++) {
				int s = sum[x+1][jj+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
				if (s == 0) continue;
				r = Math.min(r, Math.min(dfs(i, j, x, jj, 1) + dfs(i, jj+1, x, y, k-1),
										 dfs(i, j, x, jj, 2) + dfs(i, jj+1, x, y, k-2)));
			}
			return f[i][j][x][y][k] = r;
		}
		public int minimumArea(int ii, int jj, int x, int y) {
			int [] r = new int [2], c = new int [2];
			Arrays.fill(r, -1); Arrays.fill(c, -1);
			for (int i = ii; i <= x; i++) {
				int sum = 0;
				for (int j = jj; j <= y; j++) 
					sum += a[i][j];
				if (sum == 0) {
					if (r[0] == -1) continue;
					if (r[1] == -1) r[1] = i-1;
				} else {
					if (r[0] == -1) r[0] = i;
					else r[1] = i;
					for (int j = jj; j <= y; j++) {
						if (a[i][j] == 1) {
							if (c[0] == -1 || j < c[0]) c[0] = j;
							if (c[1] == -1 || j > c[1]) c[1] = j;
						}
					}
				}
			}
			return (r[1] == -1 ? 1 : r[1] - r[0] + 1) * (c[1] == -1 ? 1 : c[1] - c[0] + 1);
		}
}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		int []  a = new int []  {1, 6, 4, 3, 2};

		int r = s.maxTotalReward(a);
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