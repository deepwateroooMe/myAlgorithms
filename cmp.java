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

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int r = s.minStartingIndex(a, b);
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