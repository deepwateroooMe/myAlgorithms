import com.TreeNode;            

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
        
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，今天下午，或是傍晚，再来爬这恶心吧啦的、破烂算法题目
		// public int maxPossibleScore(int [] a, int d) {
		// 	n = a.length; this.a = a; this.d = d; 
		// 	Arrays.sort(a);
		// 	System.out.println(Arrays.toString(a));
		// 	int minDif = a[1]-a[0];
		// 	for (int i = 2; i < n; i++) 
		// 		minDif = Math.min(minDif, a[i] - a[i-1]);
		// 	int l = minDif, r = a[n-1]+d-a[0], ans = 0;
		// 	if (n == 2) return r;
		// 	// 【二分查找】：并判断、解的、正确性
		// 	while (l <= r) {
		// 		int m = (l + r ) / 2;
		// 		if (valid(m)) {
		// 			ans = Math.max(ans, m);
		// 			l = m + 1;
		// 		} else
		// 			r = m-1;
		// 	}
		// 	return ans;
		// }
		// int [] a; int n, d;
		// boolean valid(int v) {
		// 	int [] f = Arrays.copyOf(a, n);
		// 	int i = 1;
		// 	for (int j = 0; j <= d; j++) { // 感觉，这个 d, 可能也需要【二分查找】？ TLE TLE TLE 615/686-passed
		// 		f = Arrays.copyOf(a, n);;
		// 		f[0] = a[0] + j;
		// 		for (i = 1; i < n; i++) {
		// 			// if (f[i-1] + v < f[i] || f[i-1] + v > f[i] + d) // 活宝妹，早上喝汤了的亲爱的表哥的活宝妹，一早上脑袋就在团团棉花混呀混。。。
		// 			if (f[i-1] + v > f[i] + d)  
		// 				break;
		// 			// if (f[i-1] + v <= f[i] + d) {
		// 				f[i] = Math.max(f[i], f[i-1] + v);
		// 			// }
		// 		}
		// 		if (i == n) return true;
		// 	}
		// 	return false;
		// }

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，鬼才知道，现在哪里写错了呢？这么大的数据，要怎么 debug ？【TODO】：
		// public long findMaximumScore(List<Integer> l) { // 579/626-passed  
		// 	int n = l.size();
		// 	// It can be proven that from each index i, the optimal solution is to jump to the nearest index j > i such that nums[j] > nums[i]
		// 	// 亲爱的表哥的活宝妹，怎么才能，观察得到、总结得出：上面的规律来呢？有了上面的规律，还是不知道，怎么排序，怎么遍历？
		// 	// 先，排序，带下标
		// 	List<int []> li = new ArrayList<>();
		// 	for (int i = 0; i < n; i++)
		// 		li.add(new int [] {i, l.get(i)});
		// 	Collections.sort(li, (x, y)-> x[1] - y[1]);
		// 	int [] f = new int [n];
		// 	ArrayDeque<int []> s = new ArrayDeque<>(), t = new ArrayDeque<>(); // 两个，可以滚动
		// 	s.offerFirst(li.get(0));// 下标
		// 	// 【从小到大的、数值】遍历: 预处理 f[] 数组
		// 	for (int i = 1; i < n; i++) {
		// 		// 把下标、不合法的、滚动到另一个缓存里
		// 		while (!s.isEmpty() && s.peekFirst()[0] > li.get(i)[0]) 
		// 			t.offerFirst(s.pollFirst()); // S: 升序； t: 降序
		// 		if (!s.isEmpty())
		// 			f[s.peekFirst()[0]] = li.get(i)[0]; // 它，右边，第1 个比它值大的下标
		// 		// 把 t 缓存里，存放过的下合法下标，滚动回来
		// 		int nextIdx = (i == n-1 ? n : li.get(i+1)[0]);
		// 		while (!t.isEmpty() && t.peekFirst()[0] < nextIdx)
		// 			s.offerFirst(t.pollFirst());
		// 		// 添加，当前下标的值
		// 		s.offerFirst(li.get(i));
		// 	} 
		// 	System.out.println(Arrays.toString(f));
		// 	long [] g = new long [n];
		// 	// g[0] = l.get(0); // 【写错了】：初始化，这里没有分、不得分
		// 	for (int i = 0; i < n-1; i++) {
		// 		if (f[i] == 0)
		// 			g[n-1] = Math.max(g[n-1], g[i] + (long)(n-1 - i) * l.get(i));
		// 		// else
		// 		g[f[i]] = Math.max(g[f[i]], g[i] + (long)l.get(i) * (f[i] - i));
		// 	}
		// 	System.out.println(Arrays.toString(g));
		// 	return g[n-1];
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long findMaximumScore(List<Integer> l) { // 579/626-passed  
		// 	int n = l.size(), p = l.get(0), pi = 0;
		// 	long f = 0l;
		// 	for (int i = 1; i < n; i++) {
		// 		if (l.get(i) > p) {
		// 			f += (long)(i - pi) * p;
		// 			p = l.get(i);
		// 			pi = i;
		// 		} else if (i == n-1)
		// 			f += (long)(i - pi) * p;
		// 	}
		// 	return f;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long findMaximumScore(List<Integer> l) { // 579/626-passed
		// 	int n = l.size(), max = 0;
		// 	long f = 0;
		// 	for (int i = 0; i < n - 1; i++) {
		// 		max = Math.max(max, l.get(i));
		// 		f += max;
		// 	}
		// 	return f;
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 亲爱的表哥的活宝妹，写其它题目可能没思路，写【记忆化深搜】从来都手到擒来，能够想到、想清、想透彻 90% 左右的思路
// 		// 亲爱的表哥的活宝妹，觉得，这类题目写狠多，这个题目，像是不太难的样子_???
// 		// 当马每移动一次，都需要再动态更新，最大最小。。！！！
// 		// 怎么会只有 29% Hard ？数据规模，倒是不大
// 		// 先写【暴力方法】：遍历所有可能性，TLE 才再去想其它解法。。亲爱的表哥的活宝妹的思路，几乎都是完整正确的，除了BFS 写成了DFS, 其它都对！！
// 		int [][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
// 						 {2, -1}, {2, 1}, {1, -2}, {1, 2}};
// 		public int maxMoves(int kx, int ky, int[][] a) {
// 			n = 50; m = a.length;
// 			int i = 0;
// 			for (int [] v : a) l.add(new int [] {v[0], v[1]});
// 			l.add(new int [] {kx, ky});
// 			f = new HashMap<Integer, Integer>();
// 			g = new Integer [n][n][m];
// 			vis = new boolean [m];
// 			v = new boolean [n][n];
// 			// int idx = 2;
// 			// int vv = ddfs(l.get(idx)[0], l.get(idx)[1], 1);
// 			// System.out.println("\n v Bob: " + vv);
// 			return dfs(0, 0);
// 		}
// 		List<int []> l = new ArrayList<>();
// // 记：每个小兵，到其它所有小兵的【最大距离、最小距离】的小兵号
// 		// 记：奇偶 player 的最佳得分。。
// 怎么，亲爱的表哥的活宝妹，写着写着、脑袋绕呀绕呀，把【记忆化深搜】的记忆数组、定义，都快写忘记了？！！
		// 亲爱的表哥的活宝妹，用字典当记忆数组，是因为，感觉，几乎从来？好久没有写过【n】【1<<n】这么大的数组了，怕空间不足，所以用字典省空间。。。
// 		Map<Integer, Integer> f; 
// 		Integer [][][] g; 
// 		int m, n;
// 		boolean [] vis;
// 		boolean [][] v;
// 		int dfs(int i, int j) {
// 			if (j == m) return 0;
// 			// 【写错了】：亲爱的表哥的活宝妹，这里的状态定义，仍然是不对的！错误局部解，会、可能会、覆盖掉全局最优解！！
// 			// 可是，亲爱的表哥的活宝妹，定义的状态里，漏掉了什么呢？漏掉了，小兵们的状态[vis 标记？]！！哪些小兵，还可以打斗，哪些小兵，被灭了呢？用个 mask 标记，用字典就可以了！！还要记：马所在的位置，最前四位，用来记位置
// 			// if (f[i][j%2] != null) return f[i][j%2]; // 状态定义是完整的，不会覆盖其它未定义的交叉状态
// 			if (f.containsKey(i)) return f.get(i);
// 			int r = (j % 2  == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE), val = 0, idx = (i == 0 ? m : (i & 15)), ii = (i == 0 ? 0 : (i >> 4));
// 			if (j % 2 == 0) { // 求最大值
// 				for (int k = 0; k < m; k++) {
// 					if (((ii >> k) & 1) == 1) continue;
// 					val = ddfs(l.get(idx)[0], l.get(idx)[1], k);
// 					if (val >= Integer.MAX_VALUE / 2) continue;
// 					r = Math.max(r, val + dfs(((ii | (1 << k)) << 4) | k , j + 1));
// 				}
// 			} else { // 求最小值
// 				for (int k = 0; k < m; k++) {
// 					if (((ii >> k) & 1) == 1) continue;
// 					val = ddfs(l.get(idx)[0], l.get(idx)[1], k);
// 					if (val >= Integer.MAX_VALUE / 2) continue;
// 					r = Math.min(r, val + dfs(((ii | (1 << k)) << 4) | k, j + 1));
// 				}
// 			}
// 			f.put(i, r);
// 			return r;
// 		}
// 		// 马[x,y]到，小兵 i的，[最少步数】。感觉，这步，或可以优化，预处理＋动态更新、之类的
// 		// 【x,y】到、马 idx 的最小步数: 【TODO】：这个方法，哪里写得不对，今天不写了，改天再写这个细节。。。。
// 		// 【最小步数】【最小距离】【最大、最小、最值】：好像都该是 BFS 而不是DFS 。。。
// 		int ddfs(int x, int y, int idx) { // 两个固定格、之间，【最多步数】与【最小步数】解相同，唯一吗？题目要求最少步数
// 			if (x < 0 || x >= n || y < 0 || y >= n || v[x][y])
// 				return Integer.MAX_VALUE / 2;
// 			if (x == l.get(idx)[0] && y == l.get(idx)[1]) 
// 				return 0;
// 			if (g[x][y][idx] != null) return g[x][y][idx];
// 			v[x][y] = true;
// 			int r = Integer.MAX_VALUE / 2;
// 			for (int [] d : dirs) {
// 				// int i = x + d[0], j = y + d[1];
// 				// if (i < 0 || i >= n || j < 0 || j >= n || v[i][j]) continue;
// 				// v[i][j] = true;
// 				r = Math.min(r, 1 + ddfs(x+d[0], y+d[1], idx));
// 				// v[i][j] = false;
// 			}
// 			v[x][y] = false;
// 			return g[x][y][idx] = r;
// 		}
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，今天不想再写这个了。。明明思路几乎正确、可是考场上不过，让亲爱的表哥的活宝妹、愤愤不平、、、觉得它们的破烂题目狠恶心人。。。
		// int [][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
		// 				 {2, -1}, {2, 1}, {1, -2}, {1, 2}};
		// public int maxMoves(int kx, int ky, int[][] a) {
		// 	m = 50; n = a.length; this.kx = kx; this.ky = ky; this.a = a; 
		// 	// 【预处理】数据：用来存储各种点【x,y】到【马可能出现的任何位置】的最小步数。预处理，就是批量先处理、后需要数据时拿来直用
		// 	g = new int [n+1][m][m]; // 每个小兵的位置，到任何位置的【最小步数】
		// 	for (int i = 0; i < n; i++) 
		// 		for (int j = 0; j < m; j++)  
		// 			Arrays.fill(g[i][j], -1); // 【初始化】：为－1
        //     List<int []> l = new ArrayList<>();
		// 	for (int i = 0; i <= n; i++) {
        //         int px = (i == n ? kx : a[i][0]), py = (i == n ? ky : a[i][1]); // 每个起始位置
        //         l.clear();
		// 		l.add(new int [] {px, py}); // 【BUG：】是由这个 ; 号引起、产生的. 改天再弄这个 bug
        //         for (int step = 1; !l.isEmpty(); step++) {
        //             List<int []> tmp = l;
		// 			l = new ArrayList<>();
        //             for (int [] cur : tmp) {
        //                 int x = cur[0], y = cur[1];
        //                 for (int [] d : dirs) {
        //                     int ii = x + d[0], jj = y + d[1];
        //                     if (ii < 0 || ii >= m || jj < 0 || jj >= m) continue;
        //                     if (g[i][ii][jj] == -1) { // 应该是：只更新一次，相当于是 vis 数组。没有重复遍历的可能性
        //                         g[i][ii][jj] = step;
        //                         l.add(new int [] {ii, jj});
        //                     }
        //                 }
        //             }
        //         }
		// 	}
        //     // 【记忆化深搜】：求解
        //     f = new Integer [n+1][1 << n];
        //     return dfs(n, (1 << n)-1);
        // }
        // int m, n, kx, ky; int [][] a;
        // int [][][] g;
        // Integer [][] f;
        // int dfs(int i, int j) { // 马在位置 i
        //     if (j == 0) return 0;
        //     if (f[i][j] != null) return f[i][j];
        //     int r = 0;
        //     // , px = (i == n ? kx : a[i][0]), py = (i == n ? ky : a[i][1]);
        //     // 区分玩家：是第0 第 1 玩家？
        //     if (Integer.bitCount(((1 << n)-1) ^ j) % 2 == 0) { // 0 的个数是偶数，第 0 玩家，求最大值 
        //         for (int k = 0; k < n; k++) 
        //             if (((j >> k) & 1) == 1)
        //                 r = Math.max(r, g[i][a[k][0]][a[k][1]] + dfs(k, j ^ (1 << k)));
        //     } else { // 第 1 玩家，求最小值
        //         r = Integer.MAX_VALUE;
        //         for (int k = 0; k < n; k++) 
        //             if (((j >> k) & 1) == 1)
        //                 r = Math.min(r, g[i][a[k][0]][a[k][1]] + dfs(k, j ^ (1 << k)));
        //     }
        //     System.out.println("\ni: " + i + " " + "j: " + j);
        //     System.out.println("Integer.toBinaryString(j): " + Integer.toBinaryString(j) + " r: " + r);
        //     // System.out.println("r: " + r);
        //     return f[i][j] = r;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 真是不服呀：就 java-mode 里一个破烂 ; 它是怎么，一个空行，与二个空行，之间，就产生了那种 indentation 的差异。。。没搞明白

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean reportSpam(String[] sa, String[] sb) {
        //     Set<String> s = new HashSet<>();
        //     for (String si : sb) s.add(si);
        //     int f = 0;
        //     for (String si : sa) {
        //         if (s.contains(si)) f++;
        //         if (f == 2) return true;
        //     }
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minNumberOfSeconds(int h, int[] a) {
        //     n = a.length; this.h = h; this.a = a; 
        //     Arrays.sort(a); 
        //     System.out.println(Arrays.toString(a));
        //     // 【二分查找】的总思路，是对的。只是查找的【变量】，不对
        //     long l = 1, r = (long)h * (h+1) / 2 * a[n-1], min = r;
        //     if (n == 1) return r;
        //     while (l <= r) {
        //        long m = (l + r) / 2;
        //        if (valid(m)) {
        //            min = m;
        //            r = m-1;
        //        } else l = m + 1;
        //     }
        //     return min;
        // }
        // int h, n;
        // int [] a;
        // boolean valid(long s) {
        //     int hh = h;
        //     for (int i = 0; i < n; i++) {
        //         int hi = (int)Math.sqrt(2 * s / a[i]);
        //         while (hi * (hi + 1) / 2 * a[i] - s > 0) hi--;
        //         hh -= hi;
        //         if (hh <= 0) return true;
        //     }
        //     return false;
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，使用【滑动窗口+ 双指针】遍历，26 个字符的、总思路，也是对的
        // // 亲爱的表哥的活宝妹，只是昨天状态不够的时候，就脑袋昏昏，会各种小细节上出错。。。
        // // 亲爱的表哥的活宝妹，狠久没有写【滑动窗口+ 双指针】了，感觉【滑动窗口】的题型，还记得有思路，【双指针】已经忘记该何时、如何移动了。。
        // // 还有，它们的贱鸡、贱畜牲，无限挑战、亲爱的表哥的活宝妹的、【数个数】——亲爱的表哥的活宝妹、笨宝妹，感觉永远不知道怎么去数那破烂的个数。。。
        // // 亲爱的表哥的活宝妹，惊叹：亲爱的表哥的活宝妹，强大的解题、第一直觉——思路都是对的。。真强大！！可就是，【脑袋昏昏】状态下，想得不够彻底、写不完整。。
        // public long validSubstringCount(String S, String T) {
        //     int m = T.length(), n = S.length(), mask = 0;
        //     if (n < m) return 0;
        //     char [] t = T.toCharArray(); char [] s = S.toCharArray();
        //     int [] f = new int [26]; // T 里的、字符频率
        //     for (char c : t) 
        //         f[c-'a']++;
        //     System.out.println(Arrays.toString(f));
        //     // 最好是：一次，【从左向右遍历】。一边遍历，一边求解？
        //     int l = 0, charDiffCnts = 0; // 统计窗口内有多少个字母的出现次数比 t 的少
        //     for (int v : f) 
        //         if (v > 0) charDiffCnts++;
        //     long ans = 0;
        //     // for (int i = 0; i < n; i++) {
        //     for (char c : s) { // 一次，【从左向右遍历】。一边遍历，一边求解？
        //         // int j = s[i] - 'a';
        //         // f[j]++;
        //         // curMask |= (g[j] > 0 && f[j] >= g[j] ? (1 << j) : 0); // 当前字符 s[i] 满足条件了吗？
        //         // if ((curMask ^ mask) > 0) continue; // 不合法：右端点，继续右移

        //         // 下面，如果 S 子串中，T 串中存在的特定字符，超数了，那么 f[c-'a] < 0
        //         // 窗口内 c 的出现次数和 t 一样
        //         if (--f[c-'a'] == 0) --charDiffCnts; // T 串里存在，且S 子串满足要求了

        //         // // 当前【窗口、子串】：是否合乎标准，判断
        //         // // 现在的算法不对，左端点，还要尽可能地右移到，【最小、合法、窗口】：这个思路，也是对的！
        //         // j = s[l] - 'a';
        //         // while (l < i && (g[j] == 0 || g[j] > 0 && f[j] > g[j])) {
        //         //     f[j]--;
        //         //     l++;
        //         //     j = s[l] - 'a';
        //         // }
        //         while (charDiffCnts == 0) { // 左端点，还要尽可能地右移到，【最小、合法、窗口】：这个思路，也是对的！
        //             // s[left] 移出窗口后，窗口内 s[left] 的出现次数比 t 的少。
        //             // if (f[s[l++]-'a']++ == 0) // 左端点，右移。【右移】，自动视作，T 串中，存在该字符？
        //             //     charDiffCnts++;
        //             // 上面的2 行，初看看不懂，效果等同，如下：细小的地方，亲爱的表哥的活宝妹昨天无意中想到，但是总忘记改掉
        //             if (f[s[l]-'a'] == 0) // 左端点，右移。当前【左端点 l】移出窗口后，窗口不再合法！！
        //                 charDiffCnts++; // 如果是，不出现在 T 串的字符呢？ f[s[l]-'a'] 会 <0, 不会 ==0
        //             f[s[l]-'a']++;
        //             l++;
        //         }
        //         // // 【写错了】：下面，就是亲爱的表哥的活宝妹，笨宝妹，永远数不清楚的、破烂数数题目。。。
        //         // // 以 i 为【右端点】子串、个数                    
        //         // ans += (l + 1);
        //         // // 以 l 为【左端点】子串、个数
        //         // ans += n - i;
        //         // 只统计：以【当前下标，当前字符 c 为右端点】有、子串的个数。而不是如笨宝妹，两边都数，也会数错
        //         ans += l; 
        //     }
        //     // 【TODO】：最后的【左端点】不是还要再往右移的吗？ 
        //     // 上面，想得不对。
        //     // 当【右端点】到了最右端，【最小合法窗口】总原则，已经保证了【左端点】移到了、极尽可能的最右端。
        //     // 所以，不再需要、任何额外的、【左端点】继续右移的、步骤。。。
        //     return ans;
        // }
        // 亲爱的表哥的活宝妹，换回 emacs 28.2 版本，那个出现在 29.1 里的贱鸡、贱畜牲们折腾的版本，【BUG：】自动消失了！！他们的贱鸡、贱畜牲，真贱！！！

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 时间复杂度：O(k*k+nk)，其中 n 是 nums 的长度。注意创建大小为 k的二维数组需要 O(k*k) 的时间。
        // 空间复杂度：O(k*k)。
        public int maximumLength(int[] a, int k) {
            int n = a.length, r = 0;
            int [][] f = new int [k][k]; // 初始化值都为 0
            for (int j : a) {
                j %= k;
                for (int i = 0; i < k; i++) {
                    f[j][i] = f[i][j] + 1; // 感觉，都没有想，就假装，它们都已经处理过了？
                    r = Math.max(r, f[j][i]);
                }
            }
            return r;
        }
        // 问：如何理解这个递推？它和记忆化搜索的区别是什么？
        // 答：对比二者的【计算顺序】。
        // 如果用记忆化搜索来做，需要单独计算「最左（或者最右）两项模 k 分别为 x 和 y 的子序列」的长度，这是「单线程」，必须查找下一个元素的位置。
        // 而递推的计算顺序是，（假设我们先遍历到了元素 2，然后遍历到了元素 4，两个元素属于不同的子序列）一会计算一下「最后两项模 k 分别为 y 和 2 的子序列」，一会又计算一下「最后两项模 k 分别为 y 和 4 的子序列」，这是「多线程」，没有查找元素位置的过程，遇到谁就处理谁。
        // 【破烂题解】：讲不清楚，说了跟没说一样。鬼知道，它这一个算法题目里面，说【单线程】【多线程】，这里是什么意思？？？
        // 如果用【记忆化搜索】来做，需要单独计算「最左（或者最右）两项模 k 分别为 x 和 y 的子序列」的长度，这是「单线程」，必须查找下一个元素的位置。如果它【破烂题解】说查找，如果二维每维每个模值，都需要【暴力查找、所有N 个数】＋【记忆数组——记查找过的结论，不做第二次】，那么就需要定义 f[k][k][n][n] 为【记忆化深搜】的记忆数组，复杂度就变成为O(kkNN), 所以，【记忆化深搜】，总是狠容易就超时
        // 而【递推】的计算顺序是，（假设我们先遍历到了元素 2，然后遍历到了元素 4，两个元素属于不同的子序列）一会计算一下「最后两项模 k 分别为 y 和 2 的子序列」，一会又计算一下「最后两项模 k 分别为 y 和 4 的子序列」，这是「多线程」，【没有查找元素位置的过程】，遇到谁就处理谁。
        // 上面，【递推】【没有查找元素位置的过程】，应该也就是说，【顺序遍历】。先前遍历过、得出的结果，成为后续遍历的、递推的基础。只需要一次【自左向右】或是【自右向左】的一次顺序遍历，遍历N 个数值，内嵌套遍历 K 个模值，复杂度就变成为O(NK).
        // 它说是【递推】，它不就是【动规】吗？所以，亲爱的表哥的活宝妹，先前傻傻、永远【记忆化深搜】总是一不小心就超时；但【递推】【动规】就不容易超时
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minElement(int [] a) {
        //     int n = a.length, cur = 0, f = Integer.MAX_VALUE;
        //     for (int v : a) {
        //         cur = 0;
        //         for (char c : String.valueOf(v).toCharArray()) {
        //             cur += c - '0';
        //         }
        //         f = Math.min(f, cur);
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maximumTotalSum(int [] a) { // TLE: 怎么还会超时呢？想不明白
        //     int n = a.length, p = 0; Arrays.sort(a); // 升序排列
        //     System.out.println(Arrays.toString(a));
        //     int [] f = new int [n];
        //     long ans = 0;
        //     ans += (long)a[n-1];
        //     // TreeSet<Integer> s = new TreeSet<>();
        //     // s.add(a[n-1]);
        //     p = a[n-1];
        //     for (int i = n-2; i >= 0; i--) {
        //         // Integer lo = s.floor(Math.min(p, a[i]));
        //         // while (lo != null && lo == Math.min(p, a[i])) {
        //         //     a[i]--;
        //         //     lo = s.floor(Math.min(p, a[i]));
        //         // }
        //         // while (a[i] >= p) a[i]--;
        //         a[i] = Math.min(a[i], p-1);
        //         if (a[i] <= 0) return -1;
        //         p = a[i];
        //         ans += a[i];
        //         // s.add(a[i]);
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public char kthCharacter(int k) {
        //     StringBuilder s = new StringBuilder("a");
        //     while (s.length() < k) {
        //         int n = s.length();
        //         for (int i = 0; i < n; i++) 
        //             s.append((char)((s.charAt(i)-'a'+1) % 26 + 'a'));
        //     }
        //     return s.charAt(k-1);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countOfSubstrings(String word, int k) {
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【滑动窗口＋双指针】：那天刚写的，亲爱的表哥的活宝妹不会的、不知道【左右指针】怎么滑动的、破烂题目。。。又见【滑动窗口＋双指针】。。。
        // // 他们的贱鸡、贱畜牲，真贱！！！
        // // 感觉，哪里，想得还不对，现在不想再写个题目了，晚点儿再写。。。722/815-passed
        // public int countOfSubstrings(String S, int k) {
        //     int m = 5, n = S.length(), ans = 0, i = 0, j = 0, mask = 0, cnt = 0; char [] f = S.toCharArray();
        //     Map<Character, Integer> map = new HashMap<>(), mii = new HashMap<>();
        //     map.put('a', 0); map.put('e', 1); map.put('i', 2); map.put('o', 3); map.put('u', 4); 
        //     for ( i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         // 处理当前下标的【字符】
        //         if (map.containsKey(f[i])) {
        //             mask |= (1 << map.get(f[i]));
        //             mii.put(f[i], mii.getOrDefault(f[i], 0) + 1);
        //         } else cnt++;
        //         // while (cnt > k) {
        //         if (cnt > k) {
        //             // 【左端点】右移：是在当前为【辅音】时发生的。。。处理：右端点在【i-1】时，【左端点 j：极尽可能在右移】
        //             while (mask == 31 && j < n && map.containsKey(f[j])) {
        //                 mii.put(f[j], mii.get(f[j])-1);
        //                 if (mii.get(f[j]) == 0)
        //                     mask ^= (1 << map.get(f[j]));
        //                 if (mask == 31) ans++;
        //                 j++;
        //             }
        //             if (map.containsKey(f[j])) { 
        //                 mii.put(f[j], mii.get(f[j])-1);
        //                 if (mii.get(f[j]) == 0)
        //                     mask ^= (1 << map.get(f[j]));
        //             } else cnt--;
        //             j++;
        //         }
        //         System.out.println("Integer.toBinaryString(mask): " + Integer.toBinaryString(mask));
        //         // 1 个【合法窗口】: 可能还有多个！！
        //         // if (cnt == k && mask == 31) ans++;
        //         // if (cnt == k) {
        //         if (cnt == k && mask == 31) { 
        //             ans++;
        //             // while (mask == 31 && j < n && map.containsKey(f[j])) {
        //             //     mii.put(f[j], mii.get(f[j])-1);
        //             //     if (mii.get(f[j]) == 0)
        //             //         mask ^= (1 << map.get(f[j]));
        //             //     if (mask == 31) ans++;
        //             //     j++;
        //             // }
        //         }
        //         // }
        //         System.out.println("ans: " + ans + " " + "j: " + j);
        //     }
        //     System.out.println("j: " + j);
        //     int jj = j;
        //     //  【左端点】右移：极尽可能地右移，添加、可能合法个数
        //     while (j < n-(5+k) && map.containsKey(f[j]) && mask == 31) {
        //         if (map.containsKey(f[j])) { 
        //             mii.put(f[j], mii.get(f[j])-1);
        //             if (mii.get(f[j]) == 0) {
        //                 mii.put(f[j], mii.get(f[j])+1);
        //                 // mask ^= (1 << map.get(f[j]));
        //                 if (jj == j) break;
        //                 //  【右端点】左移：极尽可能地左移，添加、可能合法个数
        //                 // --i;
        //                 i = n-1;
        //                 while (i >= j+(5+k) && mask == 31 && cnt == k && map.containsKey(f[i])) {
        //                     if (map.containsKey(f[i])) { 
        //                         mii.put(f[i], mii.get(f[i])-1);
        //                         if (mii.get(f[i]) == 0)
        //                             mask ^= (1 << map.get(f[i]));
        //                     } else cnt--;
        //                     if (cnt == k && mask == 31) ans++;
        //                     i--;
        //                     System.out.println("ans: " + ans + " " + "i: " + i);
        //                 }
        //                 break;
        //             }
        //         } else cnt--;
        //         if (cnt == k && mask == 31) ans++;
        //         j++;
        //         System.out.println("ans: " + ans + " " + "j: " + j);
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【解题思路】：用【贪心思路】，应该不会超时！！
        // public int [] validSequence(String S, String T) { // 750/907 passed
        //     int m = S.length(), n = T.length(), i = 0, j = 0, p = -1, pi = -1; char [] s = S.toCharArray(); char [] t = T.toCharArray();
        //     int [] f = new int [n]; // 找：【下标】的最小数组
        //     // g: 用来存 S 中【az】依次出现的下标
        //     List<Integer> [] g = new ArrayList[26];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for ( i = 0; i < m; i++) 
        //         g[s[i]-'a'].add(i);
        //     boolean useOnce = false;
        //     for ( i = 0; i < n; i++) { // 遍历 T 串
        //         if (s[j] == t[i] || !useOnce) {
        //             f[i] = j; // j: 标记S 串下标
        //             if (s[j] != t[i] && !useOnce) { // 在这里使用了这次、全局最贪心 j
        //                 useOnce = true;
        //                 p = j; // 做记号：
        //                 pi = i;
        //             }
        //             j++;
        //         } else {
        //             // while (j < m && s[j] != t[i]) j++;  // TLE 会超时
        //             // 【二分查找】：链条中，第一个，比 j 大的下标
        //             if (j < m && s[j] != t[i])
        //                 j = binarySearch(g[t[i]-'a'], j+1);
        //             if (j == m || j == -1) {
        //                 j = p+1;// TLE: 这里，可能会超时
        //                 i = pi-1;
        //                 useOnce = false;
        //                 continue;
        //             } else {
        //                 f[i] = j++; // j: 标记S 串下标
        //             }
        //         }
        //         if (j == m) { // 【TODO】：这里的细节，还要再改。【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        //             if (pi < n) {
        //                 i = pi-1;
        //                 j = p+1;
        //             }
        //         }
        //     }
        //     return i == n ? f : new int [0];
        // }
        // int binarySearch(List<Integer> li, int idx) {
        //     int n = li.size(), l = 0, r = n-1; // 双开区间
        //     if (n == 0 || li.get(n-1) <= idx) return -1;
        //     while (l < r) {
        //         int m = (l + r) / 2;
        //         if (li.get(m) < idx)
        //             l = m + 1;
        //         else r = m;
        //     }
        //     return l == -1 ? -1 : li.get(l);
        //     // return r == n ? -1 : li.get(r);
        // }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 破烂题目，被推荐、建议：得先去写一个破烂难题。。
//         public int minimumScore(String S, String T) {
//             int m = T.length(), n = S.length(), j = m-1;
//             char [] s = S.toCharArray(); char [] t = T.toCharArray();
// // f[i]: 对应于 S[i:] 后缀的、T 串最长【后缀、子序列】的【开始下标】
//             int [] f = new int [n+1];
//             f[n] = m;
//             for (int i = n-1; i >= 0; i--) { //f[i] 数据预处理: 从后向前、处理后缀数组
//                 if (s[i] == t[j])
//                     j--;
//                 if (j < 0) // T 是S 的【子序列】：什么也不用删除，0 消耗
//                     return 0;
//                 f[i] = j+1;
//             }
//             int r = f[0]; // 删除 t[:suf[0]]
//             // 【从前向后】：处理【前缀数组】——这里隐了。。同步优化求解
//             j = 0;
//             for (int i = 0; i < n; i++) 
//                 if (s[i] == t[j]) { // 这个条件下： j 才是对应于 S[:i] 前缀的、T 串【最长、前缀、子序列】的【结束下标】
//                     // 前面，判断了 t 是 s 子序列的情况，上面的 j, 不会越界
//                     j++;
//                     // r = Math.min(r, f[i+1]-1 - (j-1+1) + 1); // 删除 t[j:suf[i+1]]
//                     r = Math.min(r, f[i+1] - j); // 删除 t[j:suf[i+1]]
//                 }
//             return r;
//         }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 它们的贱鸡、贱畜牲，好贱！！
        // // 把这么难一个题目，伪装成，中等难度。。。
        // public int [] validSequence(String S, String T) {
        //     int m = T.length(), n = S.length(), j = m-1, k = 0;
        //     char [] s = S.toCharArray(); char [] t = T.toCharArray();
        //     int [] f = new int [n+1];
        //     f[n] = m;
        //     for (int i = n-1; i >= 0; i--) {
        //         if (s[i] == t[j])
        //             j--;
        //         f[i] = j+1;
        //         if (j < 0) // T 是S 的子序列
        //             break; //f[0-i]==0
        //     }
        //     int [] g = new int [m];
        //     j = 0;
        //     boolean useOnce = false; // 仅能修改一次
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] == t[j] || !useOnce && f[i+1] <= j+1) {
        //             if (s[i] != t[j]) // 这里：作了1 次修改
        //                 useOnce = true;
        //             g[j++] = i;
        //             if (j == m) return g;
        //         }
        //     }
        //     return new int [0];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥，他们的贱鸡、贱畜牲，真贱！！同一场比赛里，连出2 题、同一个思路、同样难受的难题，还伪装一个假装它不难。。。
        // // 亲爱的表哥的活宝妹，为什么要套：【子序列】的解题思路、而不是、未必适合【子串】的思路？这就是，【没能消化、理解透彻的、胡乱乱套思路】。。根本就不对
        // // 亲爱的表哥的活宝妹，【看了提示】之后，亲爱的表哥的活宝妹，能把这个、破烂题目、瓣出来了吗？亲爱的表哥的活宝妹，把思路看懂了，可是KMP? 不会写。。
        // // 那个什么狗屁【KMP? O(N) 线性、算法】，是什么意思呢？上次，看它的题解，以为看懂了、可以自己写了；现在看来，还是没能理解透彻，思路不透彻写不出来。。
        // int [] calcZ(String S) { // 【TODO】：没有看懂，要去找、去翻，它先前的某个讲解。。。
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] f = new int [n];
        //     int boxL = 0, boxR = 0; // z-box 左右边界
        //     for (int i = 1; i < n; i++) { // 遍历：以当前下标 i 为中心点【奇、偶中心】的、左右扩展、最大单侧长度
        //         if (i <= boxR) // 两边的、最小长度、作为 f[i] 涨长的起点大小
        //             f[i] = Math.min(f[i-boxL], boxR - i + 1);
        //         while (i + f[i] < n && s[f[i]] == s[i + f[i]]) {
        //             boxL = i;
        //             boxR = i + f[i];
        //             f[i]++; // 一个个字符涨长的。。
        //         }
        //     }
        //     return f;
        // }
        // public int minStartingIndex(String S, String T) {
        //     int m = T.length(), n = S.length();
        //     char [] s = S.toCharArray(); char [] t = T.toCharArray();
        //     int [] f = calcZ(T + S);
        //     // 下面的数组，是倒序的
        //     int [] g = calcZ(new StringBuilder(T).reverse().toString() + new StringBuilder(S).reverse().toString());
        //     for (int i = m; i <= n; i++) {
        //         // 回到原问题，我们枚举 i = 0,1,⋯, n−m，那么当前需要匹配的子串为 s[i..i+m−1]，对应的 Z 数组元素为 preZ[i+m] 和 sufZ[i+m−1]。
        //         //     如果preZ[i+m] + sufZ[i+m−1] ≥ m−1
        //         //     那么答案为 i。
        //         //     代码实现时，也可以枚举 i = m, m+1,⋯,n，这样上面的式子可以简化为
        //         //     preZ[i] + sufZ[i−1] ≥ m−1
        //         //     答案为 i−m。
        //         if (f[i] + g[g.length -i] >= m-1)
        //             // if (f[i] + g[m+n-1-i] >= m-1) // 【写错了】
        //             return i-m;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【滑动窗口】：被他们的贱鸡、贱畜牲，永远风吹草动的时候，就官宣、真恨人。。。
        // public long countOfSubstrings(String S, int k) {
        //     char [] s = S.toCharArray();
        //     return getCnts(s, k) - getCnts(s, k+1);
        // }
        // int n;
        // long getCnts(char [] s, int k) {
        //     Map<Character, Integer> m = new HashMap<>();
        //     long f = 0; int j = 0, cnt = 0;
        //     for (char c : s) {
        //         if ("aeiou".indexOf(c) >= 0) 
        //             m.merge(c, 1, Integer::sum);
        //         else cnt++;
        //         while (m.size() == 5 && cnt >= k) {
        //             if ("aeiou".indexOf(s[j]) >= 0) {
        //                 if (m.merge(s[j], -1, Integer::sum) == 0)
        //                     // m.merge(c, -1, Integer::sum);  // 这两行，同上面一行，效果等同
        //                     // if (m.get(s[j]) == 0)
        //                     m.remove(s[j]);
        //             } else --cnt;
        //             j++;
        //         }
        //         // if (m.size() == 5) // 【写错了】添加这个条件，答案不对！为什么，可以不要这个限制条件？
        //         // 即使，出 while(){} 后，m.size()==4 了，
        //         // 当m.size()==4 时， j 要么 j=0; 要么添加 s[j-1] 元音后， m.size()==5, 即当前 i 右端点时， j 个新子串产生。。
        //         // j: 要么停留在 j=0 狠久，因为子串不合要求；要么，就一定停在、特定的位置：添加 j 个子串
        //             f += j;
        //     }
        //     return f;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countOfSubstrings(String S, int k) { // 这个，还没有测试
        //     char [] s = S.toCharArray();
        //     return getCnts(s, k) - getCnts(s, k+1);
        // }
        // int n;
        // long getCnts(char [] s, int k) {
        //     final int mask = 1065233; // 鬼会去算，这什么狗屁的数字吗？ 1<<('a'-'a')|1 << ('e'-'a')|1<<('i'-'a')|1<<('o'-'a')|1<<('u'-'a')
        //     long ans = 0;
        //     int [] r = new int ['u'-'a'+1];
        //     int f = 0, g = 0, j = 0; //f: 元音种类 g: 辅音个数
        //     for (char c : s) {
        //         c -= 'a';
        //         if ((mask >> c & 1) == 1) {
        //             if (r[c]++ == 0) f++;
        //         } else g++;
        //         while (f == 5 && g >= k) {
        //             if ((mask >> (s[j]-'a') & 1) == 1) {
        //                 if (--r[s[j]-'a'] == 0) --f;
        //             } else --g;
        //             j++;
        //         }
        //         ans += j;
        //     }
        //     return ans;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这哪里，还是什么狗屁、三指针、滑动窗口呢？【双、双指针、滑动窗口】：对同一个【右端点】，对应两个不同的【左端点】
        // public long countOfSubstrings(String S, int k) {
        //     char [] s = S.toCharArray();
        //     final int mask = 1065233; // 鬼会去算，这什么狗屁的数字吗？ 1<<('a'-'a')|1 << ('e'-'a')|1<<('i'-'a')|1<<('o'-'a')|1<<('u'-'a')
        //     int [] r = new int ['u'-'a'+1], rr = new int ['u'-'a'+1];
        //     int f = 0, g = 0, ff = 0, gg = 0, j = 0, jj = 0;
        //     long ans = 0;
        //     for (char c : s) {
        //         c -= 'a';
        //         if ((mask >> c & 1) == 1) {
        //             // 看下面：
        //             if (r[c]++ == 0)
        //                 f++;
        //             if (rr[c]++ == 0)
        //                 ff++;
        //         } else {
        //             g++;
        //             gg++;
        //         }
        //         while (f == 5 && g >= k) {
        //             if ((mask >> (s[j]-'a') & 1) == 1) {
        //                 if (--r[s[j]-'a'] == 0) --f;
        //             } else --g;
        //             j++;
        //         }
        //         while (ff == 5 && gg >= k+1) {
        //             if ((mask >> (s[jj]-'a') & 1) == 1) {
        //                 if (--rr[s[jj]-'a'] == 0) --ff;
        //             } else --gg;
        //             jj++;
        //         }
        //         ans += j - jj;
        //     }
        //     return ans;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 亲爱的表哥的活宝妹，写第1 题时，就讨厌这个题目；现在，终于又崩出这么个破烂题目，恶心死人不偿命。。。讨厌这类题目。。。世界上最恶心死人不偿命的破烂题目，抄抄过了就扔了，破烂题目。。
        // public char kthCharacter(long k, int [] f) { // 亲爱的表哥的活宝妹，笨宝妹，永远讨厌这些破烂掰掰掰、用完十个手指头也掰不清楚的破烂题目！！！
        //     int m = f.length, j = 0;
        //     StringBuilder s = new StringBuilder("a"); // StringBuilder 的最大长度为： Integer.MAX_VALUE
        //     while (s.length() < k) {
        //         int n = s.length();
        //         if (f[j++] == 0)
        //             s.append(new String(s));
        //             // for (int i = 0; i < n; i++) 
        //             //     s.append((char)((s.charAt(i)-'a'+1) % 26 + 'a'));
        //         else {
        //             for (int i = 0; i < n; i++) 
        //                 s.append((char)((s.charAt(i)-'a'+1) % 26 + 'a'));
        //         }
        //     }
        //     return s.charAt((long)(k-1));
        // }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         public char kthCharacter(long k, int [] a) {
//             return recursion(k, a, 64 - Long.numberOfLeadingZeros(k-1) -1); // 从 k-1 的二进制长度、减一、开始。 k-1 中 -1 是因为字符串从 0 开始 index 
//         }
//         char recursion(long k, int [] a, int i) {
//             if (i < 0) // i: 当前 n-1, 即 n ＝ 0 时 Alice 手上仅只 'a'
//                 return 'a';
// // 在【左半边】，可以舍弃最后一个操作, 变成 i-1
//             if (k <= (1L << i)) 
//                 return recursion(k, a, i-1);
// // 在【右半边】：继续、努力，缩小1 个操作、通过变换, 变成一个【更小量级的、左右半边、子问题】
//             // if (k > (1L << i)) { 
//             char c = recursion(k - (1L << i), a, i-1); // 变成【i-1】子问题后：【左右半边】，加不加1? 加与不加，是受第 i 次操作类型决定的
//             return (char)('a' + (c - 'a' + a[i]) % 26); // 所以，返回后，再、加不加1
//             // }
//         }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public char kthCharacter(long k, int [] a) {
        //     int f = 0;
        //     for (int i = 64 - Long.numberOfLeadingZeros(k-1)-1; i >= 0; i--) 
        //         if (k > (1L << i)) {
        //             f += a[i];
        //             k -= (1L << i);
        //         }
        //     return (char)('a' + f % 26);
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public char kthCharacter(long k, int [] a) {
        //     int f = 0;
        //     --k; // 这里，一定把 k 给变了。。写起来方便
        //     for (int i = 64 - Long.numberOfLeadingZeros(k) - 1; i >= 0; i--) 
        //         if (((k >> i) & 1) == 1)
        //             f += a[i];
        //     return (char)('a' + f % 26);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
        // // 亲爱的表哥的活宝妹，笨宝妹，现在，再写这些破烂题目，狠简单了吗。。
        // public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        //     int d = diameter(edges1), dd = diameter(edges2);
        //     return Math.max(Math.max(d, dd), (d + 1) / 2 + (dd + 1) / 2 + 1);
        // }
        // int diameter;
        // int diameter(int [][] f) {
        //     // 【构建】：无向图
        //     List<Integer> [] g = new ArrayList[f.length+1];
        //     // Arrays.stream(g).forEach(z -> Arrays.fill(z, new ArrayList<Integer>())); // asf
        //     Arrays.setAll(g, z -> new ArrayList<Integer>()); // asa
        //     for (int [] e : f) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     // 求：无向图、树的直径
        //     diameter = 0; // 全局，【最大直径】
        //     dfs(0, -1, g); // 【DFS 深搜】：求最大、单侧、伪半径
        //     return diameter;
        // }
        // int dfs(int u, int p, List<Integer> [] g) {
        //     int max = 0; // 最大、单侧、伪半径
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         int subLen = dfs(v, u, g) + 1; // 当前、或【次大】：单侧、伪半径
        //         diameter = Math.max(diameter, max + subLen);
        //         max = Math.max(max, subLen);
        //     }
        //     return max;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 什么乌龟王八蛋的、破烂题目。。。
        // public long maximumPoints(int [] f, int v) {
        //     int min = Integer.MAX_VALUE;
        //     long s = 0;
        //     for (int vv : f) {
        //         min = Math.min(min, vv);
        //         s += (long)vv;
        //     }
        //     if (v < min) return 0;
        //     return (long)((long)v + s - (long)min) / (long)min;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countAlternatingSubarrays(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     Arrays.fill(f, 1); // 每个下标元素、自己：都是一个【子数组】
        //     long s = 1;
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] != a[i-1])
        //             // a[i] 可以单独成1 个【子数组】；也可以连前边的数组，成为最后一个元素
        //             f[i] = 1 + f[i-1];
        //         s += (long)f[i];
        //     }
        //     return s;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，这里的思路，还是想得太幼稚，呵呵呵。。。
        // public int numberOfAlternatingGroups(int[] a, int k) {
        //     int n = a.length, ans = 0;
        //     // 现在的亲爱的表哥的活宝妹，笨宝妹，努力适应去写【动规】：先，按【动规、数组】的写法、慢慢掰。。等写习惯了，数组可以变成一个变量，就可以了
        //     int [] f = new int [n * 2];
        //     Arrays.fill(f, 1);
        //     // for (int i = 1; i < n; i++) {
        //     //     if (a[i] != a[i-1])
        //     //         f[i] = f[i-1] + 1;
        //     //     if (f[i] >= k) ans++;
        //     // }
        //     // 把数组复制一份拼接起来，和 3101 题一样，遍历数组的同时，维护以 i 为右端点的交替子数组的长度 cnt。
        //     //     如果 i≥n 且 cnt≥k，那么 i 就是一个长为 k 的交替子数组的右端点，答案加一。注意这里要判断 i≥n，从而避免重复统计。
        //     //     代码实现时，不需要复制数组，而是用 imodn 的方式取到对应的值。
        //     for (int i = 0; i < n * 2; i++) {
        //         if (i > 0 && a[i % n] != a[(i-1) % n])
        //             f[i] += f[i-1];
        //         if (i >= n && f[i] >= k) ans++;
        //     }
        //     // // 【环形数组】：首尾相连的、特殊处理，这里脑袋昏昏，不知道是怎么回事了。。。写错了
        //     // if (a[0] != a[n-1]) {
        //     //     for (int i = 0; i < k - f[n-1]; i++) {
        //     //         f[i] += f[n-1];
        //     //         if (f[i] >= k) ans++;
        //     //     }
        //     //     // for (int i = k-f[n-1]-1; i >= 0; i--) {
        //     //     //     f[i] += f[n-1];
        //     //     //     if (f[i] >= k) ans++;
        //     //     //     else break;
        //     //     // }
        //     // }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minimumCost(int m, int n, int[] h, int[] v) {
        //     int i = m-2, j = n-2, hcnts = 1, vcnts = 1;
        //     long r = 0;
        //     Arrays.sort(h); Arrays.sort(v);  // 倒序遍历
        //     while (i >= 0 || j >= 0) {
        //         // 先横切，再后序。也包括了， j<0 时仅剩下的横切
        //         if (j < 0 || i >= 0 && h[i] >= v[j]) {
        //             r += (long)h[i--] * hcnts;
        //             vcnts++;
        //         } else { // 先竖切、再后序。。
        //             r += (long)v[j--] * vcnts;
        //             hcnts++;
        //         }
        //     }
        //     return r;
        // }
        // // cntH 和 cntV 这两个变量可以省略，因为从上面的过程可以发现，cntH=j+1, cntV=i+1。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minimumCost(int m, int n, int[] h, int[] v) {
        //     int i = m-2, j = n-2;
        //     long r = 0;
        //     Arrays.sort(h); Arrays.sort(v);  // 倒序遍历
        //     while (i >= 0 || j >= 0) {
        //         // 先横切，再后序。也包括了， j<0 时仅剩下的横切
        //         if (j < 0 || i >= 0 && h[i] >= v[j]) 
        //             r += (long)h[i--] * (n-1-j); // hcnts=(n-2 － j ＋ 1)
        //         else // 先竖切、再后序。。
        //             r += (long)v[j--] * (m-1 - i); // vcnts=(m-2 － i ＋ 1)
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹、笨宝妹、活宝木头妹，就是不动脑子呀。。。
		// public int minChanges(int [] a, int k) {
        //     int n = a.length, ans = n;
        //     // 【差分数组】：一次遍历数组，预处理2 个差分数组的数据
        //     // 亲爱的表哥的活宝妹，笨宝妹，这里是用的是，【差分数组】吗？？？
        //     int [] f = new int [k+1], r = new int [k+1];
        //     for (int i = 0; i < n/2; i++) {
        //         int x = a[i], y = a[n-1-i];
        //         if (x > y) { // x <= y
        //             int tmp = x;
        //             x = y; y = tmp;
        //         }
        //         f[y-x]++; // 【Math.abs(x,y)】所有可能的取值、出现的频率
        //         r[Math.max(y, k-x)]++; // 【Math.max(y, k-x)】所有可能的取值、出现的频率
        //     }
        //     int sum = 0;
        //     for (int i = 0; i <= k; i++) { // 遍历：【0,k】所有可能的取值
        //         ans = Math.min(ans, n/2 - f[i] + sum);
        //         sum += r[i];
        //     }
        //     return ans;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minChanges(int [] a, int k) {
        //     int n = a.length, ans = n;
        //     // 【差分数组】
        //     int [] f = new int [k+2];
        //     // 遍历一次数组：填充【差分数组】里的数据
        //     for (int i = 0; i < n/2; i++) {
        //         int x = a[i], y = a[n-1-i];
        //         if (x > y) {
        //             int tmp = x;
        //             x = y; y = tmp;
        //         }
        //         int xx = y - x, mx = Math.max(y, k-x);
        //         // 分段、分情况讨论：分段、填充【差分数组】
        //         // 【0,xx-1】：只需要修改一次
        //         f[0]++;
        //         f[xx]--;
        //         // 【xx+1,mx】：只需要修改一次
        //         f[xx+1]++;
        //         f[mx+1]--;
        //         // 【mx+1,k】：需要修改2 次
        //         f[mx+1] += 2;
        //     }
        //     // 遍历：【差分数组】，求全局最优解
        //     int s = 0;
        //     for (int i = 0; i < k+1; i++) {
        //         s += f[i];
        //         ans = Math.min(ans, s);
        //     }
        //     return ans;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹、不动脑袋的亲爱的表哥的活宝妹、笨宝妹。。。
		// public int minFlips(int[][] f) {
        //     int m = f.length, n = f[0].length, r = 0, dif = 0, cnt = 0;
        //     for (int i = 0; i < m/2; i++) 
        //         for (int j = 0; j < n/2; j++) {
        //             cnt = f[i][j] + f[m-1-i][j] + f[m-1-i][n-1-j] + f[i][n-1-j];
        //             r += Math.min(cnt, 4 - cnt);
        //         }
        //     if (m % 2 > 0 && n % 2 > 0)
        //         r += f[m/2][n/2];
        //     cnt = 0;
        //     if (m % 2 > 0) // 特殊处理：奇数、最中间一行
        //         for (int j = 0; j < n/2; j++) {
        //             if (f[m/2][j] != f[m/2][n-1-j])
        //                 dif++;
        //             else cnt += f[m/2][j] * 2;
        //         }
        //     if (n % 2 > 0) // 特殊处理：奇数、最中间一列
        //         for (int i = 0; i < m/2; i++) {
        //             if (f[i][n/2] != f[m-1-i][n/2])
        //                 dif++;
        //             else cnt += f[i][n/2] * 2;
        //         }
        //     return r + (dif > 0 ? dif : cnt % 4);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxGoodNumber(int[] a) {
        //     int n = a.length;
        //     String s = Integer.toBinaryString(a[0]), t = Integer.toBinaryString(a[1]), v = Integer.toBinaryString(a[2]);
        //     int aaa = Integer.parseInt(s + t+v, 2), aa = Integer.parseInt(t + s+v, 2);
        //     int b = Integer.parseInt(s + v+t, 2), bb = Integer.parseInt(v + s+t, 2);
        //     int c = Integer.parseInt(t + v+s, 2), cc = Integer.parseInt(v + t+s, 2);
        //     int x = Math.max(aaa, aa), y = Math.max(b, bb), z = Math.max(c, cc);
        //     return Math.max(Math.max(x, y), z);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 破烂题目，说的是什么破烂意思，读不懂。。。，亲爱的表哥的活宝妹，看它人题解后，觉得，这个题目就是，破烂描述不清，亲爱的表哥的活宝妹读不懂题目 
        // // 有向图：入度、图有几个组群？有没有环. 亲爱的表哥的活宝妹自己想的，比解题本题目所要求的，还要多、还要复杂。。。
        // // 比赛的时候，破烂题目读不懂，是他们的贱鸡、贱畜牲破烂题目，出得最没意思的。。。
        // public List<Integer> remainingMethods(int n, int k, int [][] a) {
        //     g = new ArrayList [n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : a) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //     }
        //     // 标记：所有 k 方法，或是其后续方法，它们都可能存在 bug 
        //     boolean [] vis = new boolean [n];
        //     dfs(k, vis);
        //     // System.out.println(Arrays.toString(vis));
        //    List<Integer> l = new ArrayList<>();
        //     // 遍历边：如果不可编译，直接返回 
        //     for (int [] e : a) {
        //         int u = e[0], v = e[1];
        //         if (!vis[u] && vis[v]) {
        //             for (int i = 0; i < n; i++)
        //                 l.add(i);
        //             return l;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (!vis[i]) l.add(i);
        //     return l;
        // }
        // List<Integer> [] g;
        // int n;
        // void dfs(int k, boolean [] vis) {
        //     vis[k] = true;
        //     for (int v : g[k]) {
        //         if (vis[v]) continue;
        //         dfs(v, vis);
        //     }
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 破烂题目：感觉，还是与【入度】相关的，可是，亲爱的表哥的活宝妹，把图忘记得几乎是干干净净的了。。。。
        // // 这个难题，亲爱的表哥的活宝妹，自己想得有点儿接近了。。。可是，亲爱的表哥的活宝妹，自己想得，钻进了一个小牛角尖里去了。。。接下去就不知道怎么写了。。。
        // public int [][] constructGridLayout(int n, int [][] egs) {
        //     int [] f = new int [n]; this.n = n; 
        //     g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         f[u]++;
        //         f[v]++;
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     System.out.println(Arrays.toString(f));
        //     int [] r = new int [5];
        //     for (int v : f) 
        //         r[v]++;
        //     System.out.println(Arrays.toString(r));
        //     int [][] ans;
        //     int u = -1; // 遍历入口
        //     // 一条链：
        //     if (r[1] == 2 && Arrays.stream(r).sum() == r[1] + r[2]) {
        //         ans = new int [1][n];
        //         List<Integer> l = new ArrayList<Integer>();
        //         for (int i = 0; i < n; i++) 
        //             if (f[i] == 1) {
        //                 u = i;
        //                 break;
        //             }
        //         dfs(u, -1, l);
        //         for (int i = 0; i < n; i++) 
        //             ans[0][i] = l.get(i);
        //         return ans;
        //     }
        //     // 其它：相对复杂的，数个数：数 2 3 4 的个数，来确定数组维度 m 与 n
        //     if (r[2] == 4) {  // 应该，所有的，都是这种情况：可以把 m 与 n 确定下来，可是不会写
        //         // m*n=r3 ＋ r4 + 4 
        //         // 2(m+n)=r3+8
        //         int m = (r[3] + 8 + (int)Math.sqrt((int)Math.pow(r[3]+8, 2) - 16 * (r[3] + r[4] + 8))) / 4;
        //         int nn = (r[3] + r[4] + 4) / m;
        //         ans = new int [m][nn];
        //         for (int i = 0; i < m; i++)
        //             Arrays.fill(ans[i], -1);
        //         System.out.println("m: " + m + " " + "n: " + nn);
        //         // 一个特殊的遍历、填空数组。。【TODO】：                
        //         for (int i = 0; i < n; i++) 
        //             if (f[i] == 2) { // 找一个角，作为入口
        //                 u = i;
        //                 break;
        //             }
        //         dfsdfs(u, -1, f, ans);
        //         return ans;
        //     }
        //     return new int [0][];
        // }
        // List<Integer> [] g;
        // int n;
        // void dfsdfs(int u, int p, int [] f, int [][] a) { // 【TODO】：怎么填空呢？
        //     if (f[u] == 2 && a[0][0] == -1) a[0][0] = u;
        // }
        // void dfs(int u, int p, List<Integer> f) {
        //     f.add(u);
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         dfs(v, u, f);
        //     }
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 怎么看看别人是肿么分析的，再、亲爱的表哥的活宝妹自己写，它也没那么难了嘛。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int [][] constructGridLayout(int n, int [][] egs) {
        //     // 【建图】：无向图
        //     List<Integer> [] g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     // 入度：【0,4】每个入度，去找和标记，一个该入度的节点，就可以了。答案的不唯一性
        //     int [] f = new int [5];
        //     Arrays.fill(f, -1); // 便于：后结区分，是否存在【0,4] 入度的节点
        //     for (int i = 0; i < n; i++) 
        //         f[g[i].size()] = i;
        //     // 构建：结果数组的【第一行】
        //     List<Integer> l = new ArrayList<>();
        //     if (f[1] != -1) { // 【入度为1】：仅只一列
        //         l.add(f[1]); // 前面，纪录过，入度为1 的节点、中的一个 f[1], 就用这个
        //     } else if (f[4] == -1) { // 【入度：最大为 3】：仅只2 列
        //         l.add(f[2]); // 添加：纪录过的【入度为 2】的节点、作为，一个角
        //         for (int v : g[f[2]])  // 遍历：此角节点的、所有邻居，寻找另一个【入度为2 的、角节点】
        //             if (g[v].size() == 2) {
        //                 l.add(v);
        //                 break;
        //             }
        //     } else { // 最少三列【至少：三行三列】：构建【第一行】
        //         l.add(f[2]); // 添加：纪录过的【入度为 2】的节点、作为，一个角
        //         int pre = f[2], x = g[f[2]].get(0); // 【至少：三行三列】随便任意一邻居，入度都为3
        //         while (g[x].size() == 3) {
        //             l.add(x);
        //             for (int y : g[x]) // 遍历：每个连线节点，找一个【入度为 3】的邻居，连一条边
        //                 // if (y != pre && g[y].size() == 3) { // 【写错了】：这里只需要 == 3 || ==2
        //                 if (y != pre && g[y].size() < 4) {
        //                     pre = x;
        //                     x = y;
        //                     break; // break 掉的是：内嵌 for-loop
        //                 }
        //         }
        //         l.add(x); // 退出 while 前的、最后一个 for 内嵌 x, 它的 g[x].size()==2 ，是第一行边的【另一个角】，要加上
        //     }
        //     int nn = l.size(), m = n / nn;
        //     int [][] a = new int [m][nn];
        //     boolean [] vis = new boolean [n];
        //     for (int i = 0; i < nn; i++) {
        //         a[0][i] = l.get(i);
        //         vis[l.get(i)] = true;
        //     }
        //     for (int i = 1; i < m; i++) // 遍历：填充，剩余的行
        //         for (int j = 0; j < nn; j++) { // 遍历：列
        //             for (int v : g[a[i-1][j]]) // 对于：此格的【此列正上方一格 a[i-1][j]】：其【左上右】三个邻居全填过了
        //                 if (!vis[v]) { // 如果，没有遍历过，就填它！
        //                     vis[v] = true;
        //                     a[i][j] = v;
        //                     break;
        //                 }
        //         }
        //     return a;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] gcdValues(int[] a, long[] qs) {
        //     int n = a.length, m = qs.length, max = Arrays.stream(a).max().getAsInt();
        //     int [] g = new int [max + 1]; // 每个数字：出现频率
        //     for (int v : a)
        //         g[v]++;
        //     long [] f = new long [max + 1];
        //     for (int i = max; i > 0; i--) {
        //         int c = 0;
        //         for (int j = i; j <= max; j += i) { // i,2i,3i,4i,5i,...
        //             c += g[j];
        //             f[i] -= f[j]; // 虽然 j 从 i 开始 j=i, 但 f[i] -= f[j] 时 f[j=i]=0 没有关系
        //         }
        //         f[i] += (long)c * (c-1) / 2;
        //     }
        //     for (int i = 2; i <= max; i++) // 原地：求【前缀和】
        //         f[i] += f[i-1];
        //     int [] r = new int [m];
        //     for (int i = 0; i < m; i++) 
        //         r[i] = upperBound(f, qs[i]);
        //     return r;
        // }
        // int upperBound(long [] f, long v) {
        //     int l = -1, r = f.length; // （开区间）（l,r）
        //     while (l + 1 < r) {       // 开区间：非空
        //         int m = (l + r) >>> 1;
        //         if (f[m] > v)
        //             r = m;
        //         else l = m;
        //     }
        //     return r; // 亲爱的表哥的活宝妹，怎么有时候，分不清楚：到底返回，哪个端点： l or r ？
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         void morris(TreeNode root) {
//             TreeNode cur = root;
//             while (cur != null) {
//                 System.out.println("cur.val: " + cur.val);
// // 下面这个分支：曾经被搜索到、作为过 rightMost 【叶子节点、其右节点不再为空】的，会被链接到、其先前 cur 的节点！！！
//                 if (cur.left == null) {
//                     cur = cur.right; 
//                     continue;
//                 }
//                 // 找到当前节点的左子树的最右节点
//                 TreeNode rightMost = cur.left;
//                 // 寻找 rightMost.l 子树里，最右的节点，将其 right 指针，指向【当前节点】
// // 【写错了】：遍历到：【左子树的：最右、非空、右节点】如此，才能保证：遍历完【左子树】去遍历【右子树】
//                 // while (rightMost.right != null)  
//                 while (rightMost.right != null && rightMost.right != cur)  // 遍历到：【左子树的：最右、非空、右节点】如此，才能保证：遍历完【左子树】去遍历【右子树】
//                     rightMost = rightMost.right;
//                 // 有【前后】 2 次：遍历当前节点 rightMost
//                 if (rightMost.right == null) { // 第一次遍历到：赋值，将其 right 指针，指向【当前节点 cur】
//                     // 遍历中搭建：【临时指针】，指向，当前父节点
//                     System.out.println("rightMost.val: " + rightMost.val);
//                     rightMost.right = cur;
//                     cur = cur.left; // 当前节点：向左移动
//                 } else { // 【TODO】：什么情况下，会走到这个分支的？？？
//                     // 如果最右节点的right指针指向当前节点，说明左子树已经遍历完毕，进入右子树
//                     rightMost.right = null;
//                     cur = cur.right; // 当前节点：向右移动.
//                 }
//             }
//         }

        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // int querykth(TreeNode f, int k) {
        //     if (f == null) return -1;
        //     if (f.l != null) {
        //         if (f.l.size >= k)
        //             return querykth(f.l, k);
        //         if (f.l.size + f.count >= k)
        //             return f.val;
        //     } else {
        //         if (k == 1)
        //             return f.val;
        //     }
        //     return querykth(f.r, k - (f.l == null ? 0 : f.l.size) - f.count);
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】】
//         // 亲爱的表哥的活宝妹，没弄懂BIT 线段树，中午吃太多骨头汤，下午的脑袋，真笨呀。。。
//         class SegNode {
//             int lo, hi, cnt; // lo, hi: 数据集中后，对应的下标索引
//             SegNode l, r;    // left right children
//             public SegNode(int lo, int hi) {
//                 this.lo = lo; this.hi = hi;
//                 cnt = 0;
//                 l = null; r = null;
//             }
//         }
// // 这个方法，是怎么计个数的？这里，还没填充数据，仅只分配了【尽可能、短长度】的【集中处理】了的数据的个数
//         SegNode build(int lo, int hi) { 
//             SegNode f = new SegNode(lo, hi);
//             if (lo == hi)
//                 return f;
//             int m = (lo + hi) / 2;
//             f.l = build(lo, m);
//             f.r = build(m+1, hi);
//             return f;
//         }
//         void insert(SegNode f, int v) { // 真正添加，才开始计数
//             f.cnt++; // 【自顶向下】的、所有、父节点：个数增加
//             if (f.lo == f.hi) return ; // 叶子节点
//             int m = (f.lo + f.hi) / 2;
//             if (v <= m)
//                 insert(f.l, v);
//             else
//                 insert(f.r, v);
//         }
//         int count(SegNode f, int l, int r) {
//             if (r < f.lo || f.hi < l)   // 破烂【BUG：】方向写反了。。
//                 return 0;
//             if (l <= f.lo && f.hi <= r) // 即： f[lo,hi] 是，想要查询区间【l,r】的子集
//                 return f.cnt;
//             return count(f.l, l, r) + count(f.r, l, r);
//         }
//         // 题解思路：
//         // 我们从左到右扫描前缀和数组。
//         // 每遇到一个数 preSum[j]，我们就在线段树中查询区间 [preSum[j]−upper,preSum[j]−lower] 内的整数数量，
//         // 随后，将 preSum[j] 插入到线段树当中。
//         public int countRangeSum(int [] a, int lo, int hi) { 
//             int n = a.length, ans = 0;
//             long [] f = new long [n+1]; // preSum 数组：机关： f[0]=0 【客观存在】！！
//             for (int i = 1; i <= n; i++) 
//                 f[i] = f[i-1] + (long)a[i-1];
//             System.out.println(Arrays.toString(f));
//             // 对【离散化数据】【集中】处理：
//             Set<Long> s = new TreeSet<>(); // 排序：单调升序
//             for (long v : f) { // preSum 数组：机关： f[0]=0 【客观存在】！！
//                 s.add(v);
//                 s.add(v-hi);
//                 s.add(v-lo);
//             }
//             int idx = 0; // idx: 对【离散化数据】【集中】处理, 映射关系、存字典，标记下标、记号
//             Map<Long, Integer> m = new HashMap<>();
//             for (long v : s)
//                 m.put(v, idx++);
//             SegNode root = build(0, m.size()-1); // 闭区间：【0, m.size()-1】所有下标，全包括了
//             for (long v : f) {
//                 int l = m.get(v-hi), r = m.get(v-lo); // 计算：左右端点值、对应的下标 idx  
//                 ans += count(root, l, r);             // 数：【线段树】中，此【l,r】区间的元素个数
//                 // 添加：【当前下标 i 的前缀和 v】
//                 insert(root, m.get(v));
//             }
//             return ans;
//         }
//         // BIT 方法：亲爱的表哥的活宝妹，几乎、、、就要想到了，可是还差那么一点儿，自己没能想透彻。。。
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         class BIT {
//             int [] f; // 明数组：长度【1,n】下，各下标（或其映射）【0,1】出现与否
//             int n;
//             public BIT(int n) {
//                 this.n = n;
//                 f = new int [n+1]; // 下标：从1 开始，【1,N】因为2^0=1
//             }
//             int lowBit(int x) {
//                 return x & -x;
//             }
//             void update(int i, int v) { // 【自底向上】：把 f[i] 及其、所有层级向上的、父节点、都全部更新
//                 while (i <= n) {
//                     f[i] += v; 
//                     i += lowBit(i);
//                 }
//             }
//             int query(int i) { // 【TODO】：这个过程，还有点儿糊涂。。。
//                 int ans = 0;
//                 while (i > 0) {
//                     ans += f[i];
//                     i = i - lowBit(i); // 【自顶向下】：从树的、某根节点，【自顶向下】，遍历到【最底层、某特定叶子节点】
//                 }
//                 return ans;
//             }
//          }
//         // 题解思路：
//         // 我们从左到右扫描前缀和数组。
//         // 每遇到一个数 preSum[j]，我们就在线段树中查询区间 [preSum[j]−upper,preSum[j]−lower] 内的整数数量，
//         // 随后，将 preSum[j] 插入到线段树当中。
//         public int countRangeSum(int [] a, int lo, int hi) { 
//             int n = a.length, ans = 0;
//             long [] f = new long [n+1]; // preSum 数组：机关： f[0]=0 【客观存在】！！
//             for (int i = 1; i <= n; i++) 
//                 f[i] = f[i-1] + (long)a[i-1];
//             System.out.println(Arrays.toString(f));
//             // 对【离散化数据】【集中】处理：
//             Set<Long> s = new TreeSet<>(); // 排序：单调升序。去重。。。
//             for (long v : f) { // preSum 数组：机关： f[0]=0 【客观存在】！！
//                 s.add(v);
//                 s.add(v-hi);
//                 s.add(v-lo);
//             }
//             int idx = 0; // idx: 对【离散化数据】【集中】处理, 映射关系、存字典，标记下标、记号
//             Map<Long, Integer> m = new HashMap<>();
//             for (long v : s)
//                 m.put(v, idx++);
//             // BIT 方法：查询方法，与【线段树】相比，稍微不同
//             BIT bit = new BIT(m.size());
//             for (long v : f) {
//                 int l = m.get(v-hi), r = m.get(v-lo); // 计算：左右端点值、对应的下标 idx  
// // 数：【BIT 树状数组】中，此【l,r】区间的元素总个数
//                 ans += bit.query(r+1) - bit.query(l);
//                 // 添加：【当前下标 i 的前缀和 v】
//                 bit.update(m.get(v)+1, 1); // 将 bit 中【m.get(v)+1】下标的元素，更新出现为 1. 有重复元素，会怎么样呢？？？【TODO】：想一想
//             }
//             return ans;
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // TreeNode rotateLeft(TreeNode root) {
        //     TreeNode newRoot = root.r; // 新：根节点
        //     root.r = newRoot.l; // 原根节点、右子节点：
        //     newRoot.l = root;
        //     // 更新相关节点的信息
        //     updateHeight(root);
        //     updateHeight(newRoot);
        //     return newRoot;  // 返回新的根节点
        // }
        // TreeNode rotateRight(TreeNode root) {
        //     TreeNode newRoot = root.l; // 新：根节点
        //     root.l = newRoot.r;
        //     newRoot.r = root;
        //     // 更新相关节点的信息
        //     updateHeight(root);
        //     updateHeight(newRoot);
        //     return newRoot;  // 返回新的根节点
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         Random rand = new Random();
//         class Node {
//             // Node l, r; // 左右子节点
//             Node [] n;  // 左右子节点
//             int v, rn, r, s; // 值 val; rank; repeat_cnts; size 以当前节点为根的子树大小
//             public Node(int v) {
//                 n[0] = n[1] = null;
//                 this.v = v;
//                 r = 1; s = 1; // 1 个重复、1 个节点
//                 rn = rand.nextInt(1000);
//             }
//             void updateSize() {
//                 // 用于旋转和删除过后，重新计算 siz 的值
//                 s = r;
//                 if (n[0] != null) s += n[0].s;
//                 if (n[1] != null) s += n[1].s;
//             }
//         }
//         // enum rttype { // 反着写：是有原因的！！
//         //     RT, // 0
//         //     LF  // 1
//         // }
//         int RT = 0, LF = 1;
//         void _rotate(Node r, int dir) {
//             // dir参数代表旋转的方向 0为右旋，1为左旋
//             // 注意传进来的 cur 是指针的引用，也就是改了这个
//             // cur，变量是跟着一起改的，如果这个 cur 是别的 树的子节点，根据 ch
//             // 找过来的时候，也是会找到这里的

//             // 以下的代码解释的均是【左旋】时的情况
//             Node t = r.n[dir]; // t: 临时、节点指针，指向成为【新的根节点】
//             /* 【左旋】：也就是让【右子节点】变成【根节点】
//              *         A <-- r           C
//              *        / \               / \
//              *       B  C <-- t  ==>   A   E
//              *         / \            / \
//              *        D   E          B   D
//              */
//             r.n[dir] = t.n[1-dir]; // 让 A 的右子节点变成 D
//             t.n[1-dir] = r;        // 让 C 的左子节点变成 A
//             r.updateSize(); // 更新大小信息
//             t.updateSize(); // 最后把临时储存 C 树的变量赋值到当前根节点上（注意 r 是引用）
//             r = t;
//         }
//         // 【插入】：同【普通二叉搜索树】，多维护【优先级、最小堆】的步骤
//         void _insert(Node r, int v) {
//             if (r == null) // 没这个节点直接新建
//                 r = new Node(v);
//             else if (r.v == v) {
//                 // 如果有这个值相同的节点，就把重复数量加一
//                 r.r ++; // 重复数＋＋
//                 r.s ++; // 树大小＋＋
//             } else if (v < r.v) {
//                 // 维护搜索树性质，val 比当前节点小就插到左边，反之亦然
//                 _insert(r.n[0], v); // 普通【二叉搜索树】插入
//                 if (r.n[0].rn < r.rn) 
//                     // 【小根堆】中，上面节点的优先级一定更小
//                     // 因为新插的左子节点比父节点小，现在需要让左子节点变成父节点
//                     _rotate(r, RT); // 注意前面的旋转性质，要把左子节点转上来，需要右旋
//                 r.updateSize(); // 插入之后大小会变化，需要更新
//             } else { // r.v < v
//                 _insert(r.n[1], v);
//                 if (r.n[1].rn < r.rn)
//                     _rotate(r, LF);
//                 r.updateSize(); // 插入之后大小会变化，需要更新
//             }
//         }
//         // 【删除】：
//         void _del(Node r, int v) {
//             if (r == null) return ; // 根：空
//             if (r.n[0] != null && v <= r.n[0].v) { // 【左子节点】
//                 _del(r.n[0], v);
//                 r.updateSize();
//             } else if (r.n[1] != null && r.n[1].v <= v) {  // 【右子节点】
//                 _del(r.n[1], v);
//                 r.updateSize();
//             } else if (r.r > 1) { // 根节点：有重复，只降个数
//                 r.r--;
//                 r.s--;
//             } else { // 根节点：无重复. 【最复杂】：分情况讨论
//                 int state = ((r.n[0] != null ? 1 : 0) | (r.n[1] == null ? 0 : (1 << 1)));
//                 switch (state) {
//                 case 0:
//                     r = null;
//                     break;
//                 case 1: // 有左无右
//                     r = r.n[0];
//                     break ;
//                 case 2: // 有右无左: 删除根节点 r, 变【右子节点】为根节点
//                     r = r.n[1];
//                     break ;
//                 case 3: // 有左有右: 选择【优先级小的、作根节点】、删除【原根节点、现在 r.n[d] 子节点】???
//                     Node t = r;
//                     // r = r.n[0];
//                     int d = (r.n[0].rn < t.n[1].rn ? RT : LF); // dir 是 rank 更小的那个儿子
//                     _rotate(r, d); // 这里的旋转可以把优先级更小的儿子转上去，rt 是 0，
//                                    // 而 lf 是 1，刚好跟实际的子树下标【反过来】
//                     _del(r.n[1-d], v); // 旋转完成后原来的根节点就在旋方向那边，所以需要
//                     // 继续把这个原来的根节点删掉
//                     // 如果说要删的这个节点是在整个树的「上层的」，那我们会一直通过这【TODO】：这些破烂，没读懂。。。
//                     // 这里的旋转操作，把它转到没有子树了（或者只有一个），再删掉它。
//                     r.updateSize(); // 删除会造成大小改变
//                 }
//             }
//         }
//         // 根据值查询排名
//         // 操作含义：查询以 cur 为根节点的子树中，val 这个值的大小的排名（该子树中小于 val 的节点的个数 + 1）
//         int _query_rank(Node r, int v) {
//             int lesCnts = (r.n[0] == null ? 0 : r.n[0].s);
//             if (r.v == v) // 根节点
//                 return lesCnts + 1;
//             if (v < r.v) { // 左子节点
//                 if (r.n[0] == null)
//                     return 1; // 【左子树、空】：比当前最小节点【根节点】小， rn=1
//                 return _query_rank(r.n[0], v);
//             }
//             // 右子节点
//             if (r.n[1] == null)
//                 // 没有右子树的话直接整个树 + 1 相当于 less_siz + cur->rep_cnt + 1
//                 return r.s + 1;
//             // 如果要查的值比这个节点大，那这个节点的【左子树】以及这个【节点自身】肯定都比要查的值小
//             // 所以要加上这两个值，再加上往右边找的结果
//             // （以右子树为根的子树中，val 这个值的大小的排名）
//             return lesCnts + r.r + _query_rank(r.n[1], v);
//         }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 根据排名查询值
//         // 要根据排名查询值，我们首先要知道如何判断要查的节点在树的哪个部分：
//         int _query_val(Node r, int rn) {
//             int lesCnts = (r.n[0] == null ? 0 : r.n[0].s);
//             if (rn <= lesCnts)
//                 return _query_rank(r.n[0], rn);
//             if (rn <= lesCnts + r.r)
//                 return r.v;
//             return _query_rank(r.n[1], rn - lesCnts - r.r);
//         }
//         // 查询第一个比 val 小的节点
//         // 注意这里使用了一个类中的全局变量，q_prev_tmp。
//         // 这个值是只有在 val 比当前节点值大的时候才会被更改的，所以返回这个变量就是返回 val 最后一次比当前节点的值大，之后就是更小了。
//         int q_prev_tmp;
//         int _query_prev(Node r, int v) {
//             if (v <= r.v) {
//                 if (r.n[0] != null) // 左子节点：非空，才存在解；否则无解
//                     return _query_prev(r.n[0], v);
//             } else { // r.v < v
//                 q_prev_tmp = r.v;
//                 if (r.n[1] != null)
//                     _query_prev(r.n[1], v); // 递归调用时，可能再次、多次更新 q_prev_tmp 全局变量
//                 return q_prev_tmp;
//             }
//             return -1; // 无解
//         }
//         // 查询第一个比 val 大的节点
//         // 跟前一个很相似，只是大于小于号换了一下。
//         int q_nex_tmp;
//         int _query_nex(Node r, int v) {
//             if (r.v <= v) {
//                 if (r.n[1] != null)
//                     return _query_nex(r.n[1], v);
//             } else { // v < r.v
//                 q_nex_tmp = r.v;
//                 if (r.n[0] != null)
//                     _query_nex(r.n[0], v);
//                 return q_nex_tmp;
//             }
//             return -1;
//         }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 按值分裂
//         Node [] split(Node r, int v) {
//             if (r == null) return new Node [] {null, null};
// ;            if (r.v <= v) { // 分裂：右子节点
//                 Node [] rr = split(r.n[1], v);
//                 r.n[1] = rr[0];
//                 r.updateSize(); // 不要忘记、这点。。。
//                 return new Node [] {r, rr[1]};
//             } else {  // 分裂：左子节点
//                 Node [] ll = split(r.n[0], v);
//                 r.n[0] = ll[1];
//                 r.updateSize();
//                 return new Node [] {ll[0], r};
//             }
//         }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//          Node [] split_by_rk(Node r, int rn) {
//              if (r == null) return new Node [] {null, null, null};
//              int lesCnts = (r.n[0] == null ? 0 : r.n[0].s);
//              if (rn <= lesCnts) {
//                  Node [] ll = split_by_rk(r.n[0], rn);
//                  r.n[0] = ll[2];
//                  r.updateSize();
//                  return new Node [] {ll[0], ll[1], r};
//              }
//              if (rn <= lesCnts + r.r) {
//                  Node ll = r.n[0], rr = r.n[1];
//                  r.n[0] = r.n[1] = null;
//                  // r.updateSize(); // 把这一步、极度简化
//                  r.s = r.r;
//                  return new Node [] {ll, r, rr};
//              }
//              Node [] rr = split_by_rk(r.n[1], rn);
//              r.n[1] = rr[0];
//              r.updateSize();
//              return new Node [] {r, rr[1], rr[2]};
//          }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         Node merge(Node f, Node g) {
//             if (f == null && g == null) return null;
//             if (f == null && g != null) return g;
//             if (f != null && g == null) return f;
//             if (f.rn < g.rn) { // f 根结点
//                 f.n[1] = merge(f.n[1], g);
//                 f.updateSize();
//                 return f;
//             } else { // g 根节点
//                 g.n[0] = merge(f, g.n[0]);
//                 g.updateSize();
//                 return g;
//             }
//         }
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 亲爱的表哥的活宝妹，后续的：
//         // 插入、删除、建树、区间操作等，今天写得太 boring, 今天不再写了，找几个题目、应用着、写写玩玩儿。。。

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        public class BT { // BT: BalancedTree
            private class Node {
                long v, sd; // 值、种子
                int rr, s;  // 重复、大小
                Node l, r;  // 左右子节点
                Node (long v, long sd) {
                    this.v = v; this.sd = sd;
                    rr = 1; s = 1;
                    l = r = null;
                }
                Node leftRotate() { // 抄答案不带脑子。。。
                    int prevSize = size; // 以 this 为根节点的树：大小 
                    // 当前节点 this 【左旋转】后的、【左中右】节点的、总数目 
                    int size = (l == null ? 0 : l.s) + (r.l == null ? 0 : r.l.s) + rr;
                    Node root = r;
                    this.r = r.l;
                    root.l = this;
                    this.s = size; // 旋转后，作为【根左节点】的子树根，子树的新大小
                    root.s = prevSize; // 不管谁是【根节点】，树的总大小不变
                    return root;
                }
                Node rightRotate() {
                    int prevSize = size; // 这些大小，这里，傻傻拎不清楚。。。
                    // 数：当前节点 this 的【左中右】总数目 
                    int size = (r == null ? 0 : r.s) + (l.r == null ? 0 : l.r.s) + rr;
                    Node root = l;
                    this.l = l.r;
                    root.r = this;
                    this.s = size;
                    root.s = prevSize;
                    return root;
                }
            }
            private Node root;
            private int size;
            private Random rand;
            public BT() {
                root = null;
                size = 0;
                rand = new Random();
            }
            public long getSize() {
                return size;
            }
            public void insert(long v) {
                ++size;
                root = insert(root, v);
            }
            // 【TODO】：亲爱的表哥的活宝妹，下面【三个方法】，写得不对！！！
            long minEqualOrGreaterThan = Long.MAX_VALUE;
            public long lowerBound(long v) { // 【自平衡树 treap】中查找：最小，大于等于 v 的值 
                Node r = root;
                if (r == null) return Integer.MIN_VALUE;
                if (r.v == v) return v;
                while (r != null && v < r.v) {
                    minEqualOrGreaterThan = r.v;
                    r = r.l;
                }
                return minEqualOrGreaterThan;
                // r.v < v
                return r.r.lowerBound(v);
            }
            long minLargerThan = Long.MAX_VALUE;
            public long upperBound(long v) { // 【自平衡树 treap】中查找：最小，大于 v 的值 
                Node r = root;
                if (r == null) return Integer.MIN_VALUE;
                if (r.v <= v)
                    return r.r.upperBound(v);
                // v < r.v
                minLargerThan = r.v;
                r.l.upperBound(v);
                return minLargerThan;
            }
            public int [] rank(long v) { // 为什么：它要返回2 个、计数？
                Node r = root;
                // 下面：极特殊情况，应该不用考虑
                if (r == null) return new int [] {1, 1};
                int lesCnts = (r.l == null ? 0 : r.l.s);
                if (v == r.v)
                    return new int [] {lesCnts+1, lesCnts + r.rr};
                if (v < r.v) {
                }
                return new int [] {Integer.MIN_VALUE, Integer.MAX_VALUE}; // 不知道，为什么、需要、返回这些极值。。
            }
            private Node insert(Node r, long v) { // 这个方法，应该写得是对的！！
                if (r == null) {
                    r = new Node(v, rand.nextInt(131427));
                    // 上面： r.s=1 是缺省自添加的
                    return r;
                }
e                r.s++;  // 【自顶向下】：自根节点，向叶子节点、路径上的、每个节点，都自增。叶子节点自动处理了
                // 维护【平衡二叉树的、自平衡】：当作一个【sd最大堆】来写。。是用 sd 来维护【自平衡】的
                if (v < r.v) {
                    r.l = insert(r.l, v);
                    if (r.l.sd > r.sd)
                        r.rightRotate();
                } else if (r.v < v) {
                    r.r = insert(r.r, v);
                    if (r.r.sd > r.sd)
                        r.leftRotate();
                } else // r.v == v
                    r.rr++;
                return r;
            }
        }
        // 题解思路：
        // 我们从左到右扫描前缀和数组。
        // 每遇到一个数 preSum[j]，我们就在线段树中查询区间 [preSum[j]−upper,preSum[j]−lower] 内的整数数量，
        // 随后，将 preSum[j] 插入到线段树当中。
        public int countRangeSum(int [] a, int lo, int hi) { 
            int n = a.length, ans = 0;
            long [] f = new long [n+1]; // preSum 数组：机关： f[0]=0 【客观存在】！！
            for (int i = 1; i <= n; i++) 
                f[i] = f[i-1] + (long)a[i-1];
            BT treap = new BT();
            for (long v : f) {
                long numLeft = treap.lowerBound(v - hi); // 【平衡树中】：最小 >= (v-hi) 的、最小数值
                // 最小数值：树中最小排行
                int rankLeft = (numLeft == Integer.MAX_VALUE ? treap.getSize()+1 : treap.rank(numLeft)[0]);
                long numRight = treap.upperBound(v - lo); // 【平衡树中】：最小 > (v-lo) 的、最小数值
                // 最小数值：最小树中、排行
                int rankRight = (numRight == Integer.MAX_VALUE ? treap.getSize() : treap.rank(numRight)[0]-1);
                ans += rankRight - rankLeft + 1;
            }
            return ans;
        }        
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int []  a = new int []  {-2, 5, -1};
        System.out.println(Arrays.toString(a));

        int r = s.countRangeSum(a, -2, 2);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】