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
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，现在【不再贫血？】的亲爱的表哥的活宝妹，能够把这些、先前、搞不明白的难题，这次都弄明白了。。
		// // 对照着【题解】来写，但把【每个细节】都弄懂，弄明白！！！
		// // BIT 的【两个操作】： i += i & -i 和 i &= i-1    原理，忘记了。。【TODO】：是一样的吗？
		// // BIT 的【两个操作】： i += i & -i 和 i -= i & -i 原理，忘记了。。【TODO】：
		// class BIT {
		// 	// 这里需要用到 2 个，直接使用一个数组了
		// 	private final int [][] f;
		// 	public BIT (int n) {
		// 		// 【0】: 频次计数；每个有效长度，所出现的次数
		// 		// 【1】：值与频次、乘积、累积和。
		// 		f = new int [n+1][2]; 
		// 	}
		// 	// op =  1，添加一个 size
		// 	// op = -1，移除一个 size
		// 	public void update(int size, int op) { // 包括了：添加与删除、增加与减少，两种效果的操作。这也是一种归纳。。 
		// 		for (int i = f.length-size; i < f.length; i += i & -i) {
		// 			f[i][0] += op;// 统计个数
		// 			f[i][1] += op * size; // 累积效果：片段长度大小与频率的、累积和
		// 		}
		// 	}
		// 	// 返回 >= size 的元素个数，元素和
		// 	public int[] query(int size) {
		// 		int cnt = 0, sum = 0;
		// 		for (int i = f.length-size; i > 0; i &= i-1) {
		// 			cnt += f[i][0];
		// 			sum += f[i][1];
		// 		}
		// 		return new int [] {cnt, sum};
		// 	}
		// }
		// // op =  1，【添加】一个结束位置 i
		// // op = -1，【移除】一个结束位置 i
		// void update(int i, int op) {
		// 	// 【有序集合】查询：《 i 的【前一个、结束位置】
		// 	Integer pre = ts.floor(i);
		// 	if (pre == null)
		// 		pre = ts.last();
		// 	// 【有序集合】查询：> i 的【下一个、结束位置】
		// 	Integer next = ts.ceiling(i);
		// 	if (next == null)
		// 		next = ts.first();
		// 	// 【先】：反操作，【结束位置 i】有无之前的、反操作
		// 	f.update((next - pre + n - 1) % n + 1, -op); // 移除/添加旧长度
		// 	// 【再】：【结束位置 i】相关的，两片段操作
		// 	f.update((i - pre + n) % n, op); // 添加/移除新长度
		// 	f.update((next - i + n) % n, op);// 添加/移除新长度
		// }
		// // 添加一个结束位置 i
		// void add(int i) {
		// 	if (ts.isEmpty())
		// 		f.update(n, 1); // ???
		// 	else
		// 		update(i, 1);
		// 	ts.add(i);
		// }
		// // 移除一个结束位置 i
		// void delete(int i) {
		// 	ts.remove(i); // 【删除】：要求的结束位置 i
		// 	if (ts.isEmpty()) // 撤销：先前添加过的，长度为 n 的一个片段
		// 		f.update(n, -1);
		// 	else
		// 		update(i, -1);
		// }
		// TreeSet<Integer> ts;
		// BIT f;
		// int n;
		// public List<Integer> numberOfAlternatingGroups(int [] a, int[][] qs) {
		// 	n = a.length;
		// 	ts = new TreeSet<>();
		// 	f = new BIT(n);
		// 	// 【扫数组】：纪录【结束位置】预处理等
		// 	for (int i = 0; i < n; i++)
		// 		if (a[i] == a[(i+1) % n]) // 【环形数组】：a[n-1] == a[0] 等
		// 			add(i); // 添加，一个结束位置 i
		// 	List<Integer> ans = new ArrayList<>();
		// 	for (int [] q : qs) {
		// 		if (q[0] == 1) {
		// 			if (ts.isEmpty())
		// 				ans.add(n); // 每个长为 size 的子数组都符合要求,
		// 			// 是因为【整个数组】、不存在、任何中断点，每个下标，都可以作为所要求的、任意长度片段的起点
		// 			else { // 数组中存在，中断点，【环形数组】【固定长度】的累计和
		// 				int [] res = f.query(q[1]);
		// 				ans.add(res[1] - res[0] * (q[1] - 1));
		// 			}
		// 		} else { // 要：修改数组某个下标的值。这种操作，不求答案，只有后续影响
		// 			int i = q[1];
		// 			if (a[i] == q[2]) continue; // 没有影响
		// 			int pre = (i - 1 + n) % n;
		// 			int next = (i + 1) % n;
		// 			// 修改前，先去掉结束位置
		// 			if (a[pre] == a[i])
		// 				delete(pre);
		// 			if (a[i] == a[next])
		// 				delete(i);
		// 			// 【修改 a[i] 】
		// 			a[i] ^= 1;
		// 			// 修改后，添加新的结束位置
		// 			if (a[pre] == a[i])
		// 				add(pre);
		// 			if (a[i] == a[next])
		// 				add(i);
		// 		}
		// 	}
		// 	return ans;
		// }
		// 【TODO】：亲爱的表哥的活宝妹，改天会把这个仔细 debug 出来的。。
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，上次写，几乎是看着它人的源码分析，几乎照抄
// 		// 亲爱的表哥的活宝妹，【好背题目。。】今天这会儿、再自己背一遍，看能背出来吗？
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，现在【不再贫血？】的亲爱的表哥的活宝妹，能够把这些、先前、搞不明白的难题，这次都弄明白了。。
// 		// BIT 的【两个操作】： i += i & -i 和 i &= i-1    原理，忘记了。。【TODO】：是一样的吗？
// 		// BIT 的【两个操作】： i += i & -i 和 i -= i & -i 原理，忘记了。。【TODO】：
// 		class BIT { // 主要适用：【区间】查询 queries, 求和 preSum O(logN)
// 			// 本题特例：需要2 个，用个数组. 为什么需要2 个呢？
// 			// 一个【0】：纪录，每个长度在【0,N】范围内、任何长度的、片段的【出现频率】
// 			// 一个【1】：纪录，每个长度在【0,N】范围内、【区间的【0,M】、长度计数、频率累积和？】，像是求【数组的 preSum】
// 			int [][] f; // 下标从1 开始
// 			int n;
// 			public BIT(int n) {
// 				this.n = n;
// 				f = new int [n+1][2];
// 			}
// 			// op: 如【游戏橱架里，网络异步调用、操作符】自定义不同操作，这里两种
// 			// -1: 【删除】一个长度为 i 的片段 
// 			// +1: 【添加】一个长度为 i 的片段 
// 			public void update(int i, int op) { // 添加、删除：一个长度为 i 的片段, 频次为 1
// 				// 【TODO】：【树状数组】里，当下标【1,N】视作【片段长度1-N】，怎么更新这个
// 				// 【TODO】：亲爱的表哥的活宝妹，这里一定写错了，因为，还没能【参透：树状数组，下标的遍历原理】。。。
// 				// for 。。。这里需要一个：树状数组的、极特殊【遍历】：遍历到，下标 i ，在树状数组里，被计入 partial-preSum 的每个下标节点
// 				// 【TODO】：亲爱的表哥的活宝妹，下面真像是在【背答案】：为什么倒着遍历，怎么会倒着遍历到 i 的最高1 数位？
// 				// f[i][0]: f[i] 定义为：片段长度在【0,i】范围内的、所有片段的频率累积和。亲爱的表哥的活宝妹的、这个理解，对吗？【TODO】：
// 				// 当把 f[i] 定义为【区间和】, 那么更新长度为 i 的片段，就该仅只影响【前缀和、树装数组】f[i] 的【i,N】区间的下标
// 				for (int j = i; j <= n; j += (j & -j)) {
// 				// for (int j = n; j >= i; j -= (j & -j)) {
// 					f[j][0] = f[j][0] + op * 1; // 【0】：只计数，只计频次
// 					f[j][1] = f[j][1] + op * i; // [1]: 这里像是写错了，为什么会 *i? 片段的长短，是答案的一个成分，需要累积求和
// 				}
// 				// f[i][0] = f[i][0] + op * 1; // 【0】：只计数，只计频次
// 			}
// 			// 求：片段长度在【i,N】范围内的、所有可能长度、各长度出现计数的【累积和】
// 			// 那么，这里【查询】的，就是 f[i][2] 里的【区间】【累积和】，像是【数组的 preSum】
// 			public int [] query(int i) {
// 				int totCnts = f[n][0] - f[i-1][0]; // 把它理解成了 preSum 数组，求【区间和】
// 				int ttLenFreq = f[n][1] - f[i-1][1];
// 				return new int [] {totCnts, ttLenFreq};
// 			}
// 		}
// 		TreeSet<Integer> ts; // 纪录：所有的结束点下标
// 		BIT f;
// 		int n;
// 		// void add(int i, int op) { // 【TODO】：哪里，调用这个方法了？
// 		void add(int i) { // 【TODO】：哪里，调用这个方法了？
// 			if (ts.isEmpty()) // 【初始化】：添加一个长度为N 的片段，1 次
// 				f.update(n, 1); // BIT 里先【添加哨兵】
// 			f.update(i, 1);
// 			ts.add(i); // 记下这个【结束下标】
// 		}
// 		// 【撤销 op=-1】或是【添加 op=1】：1 个长度为 i 的片段。包括 ts 与 BIT 两数据结构里的操作
// 		void update(int i, int op) {
// 			f.update(i, op);
// 			ts.remove(i);
// 			if (ts.isEmpty()) {
// 				f.update(n, 1); // 【添加一个：长度为 n 片段哨兵】
// 			}
// 		}
// 		public List<Integer> numberOfAlternatingGroups(int [] a, int[][] qs) {
// 			n = a.length;
// 			ts = new TreeSet<Integer>();
// 			f = new BIT(n);
// 			// 【预处理】数据：扫一遍数组，纪录所有【结束点】，必要的【树状数组】初始化
// 			for (int i = 0; i < n; i++) // 【环形数组】：每个下标，都需要考虑
// 				if (a[i] == a[(i+1) % n]) { // 当前数，与它后面的一个数，相同：当前下标，是一个【结束点】
// 					// 单列这个：像是【哨兵】，有个特殊【长度为N 片段的、初始化、般的添加】。
// 					// 因为【反操作时】若撤销掉最后一个结束点，该是不存在结束点的长度为 N 的片段
// 					add(i); // 添加一个【片段结束点】
// 				}
// 			System.out.println("ts.size(): " + ts.size());
// 			System.out.println(Arrays.toString(ts.toArray()));
// 			// 解答案：
// 			List<Integer> ans = new ArrayList<>();
// 			int oo = 0;
// 			for (int [] q : qs) {
// 				System.out.println("\n oo: " + oo);
// 				System.out.println(Arrays.toString(q));
// // 【求解】：长度为 q[1] 的片段总个数：所有、长度 >= q[1] 的【累积和】－【不符合、条件要求】的计数
// 				if (q[0] == 1) {
// 					int [] r = f.query(q[1]); // 2 个【树状数组】：所返回的【区间长度、累积频率】与【区间长度、累积Sum（长度×该长度频次）】
// 					ans.add(r[1] - r[0] * (q[1] - 1));
// 				} else {
// 					if (a[q[1]] == q[2]) continue; // 更原数组是一样的，无效跳过
// 					// 修改、某个下标的颜色值：它会影响【拆分一个片段为二、或是、合并二个片段为一】
// 					// 找：当前下标 q[1], 之前、和之后的、最近结束点
// 					// 【TODO】：下面，两种取值方法，原因原理？
// 					Integer pre = ts.lower(q[1]);
// 					if (pre == null) pre = ts.last();
// 					// The ceiling() method of java.util.TreeSet<E> class is used to return the least element in this set greater than or equal to the given element
// 					// Integer next = ts.higher(q[1]); // 【TODO】：感觉这里写错了，当前下标 i 的下一个结束点，是可能为 i 的
// 					Integer next = ts.ceiling(q[1]);
// 					if (next == null) next = ts.first();
// 					System.out.println("pre: " + pre);
// 					System.out.println("next: " + next);
// 					// 把【修改】定义为：在2 种可能的动态变化下，概括抽象为，【先执行，相反的操作；再执行，更新后的需要操作】
// 					// 为什么呢？因为【树状数组】是【O(logN) 前缀和数组】，以【片段长度】为下标的计量单位，合并与拆分，涉及几个不同的片段长度，务必先反操作
// 					// 区分：修改当前下标后，是【合并】还是【拆分】，2 种操作里的哪一种
// 					if (a[q[1]-1] != q[2]) { // 先前是一样的、先前是分开的2 片段，现在执行【合并操作】：合并【pre,next】片段
// 						// 【撤销】：先前分开的 2 个片段、相关
// 						update((q[1] - pre + n) % n, -1);
// 						update((next - q[1] + n) % n, -1);
// 						// 执行：【合并】成1 个片段的、更新
// 						update((next - pre + n) % n, 1);
// 					} else { // 先前不一样，是一个片段；现在【拆分】成为了2 个片段 
// 						update((next - pre + n) % n, -1);
// 						update((q[1] - pre + n) % n, 1);
// 						update((next - q[1] + n) % n, 1);
// 					}
// 				}
// 			}
// 			return ans;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
		// public int finalPositionOfSnake(int n, List<String> l) {
		// 	Map<String, Integer> m = new HashMap<>();
		// 	m.put("DOWN", 0);
		// 	m.put("RIGHT", 1);
		// 	m.put("LEFT", 2);
		// 	m.put("UP", 3);
		// 	int r = 0;
		// 	for (int i = 0; i < l.size(); i++) {
		// 		int [] d = dirs[m.get(l.get(i))];
		// 		int x = r / n, y = r % n;
		// 		r = (x + d[0]) * n + (y + d[1]);
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，感觉这个题目，狠简单，数据规模极小，感觉狠容易过才对，为什么只有几个人写过了？？？
		// // 想简单了，【动规】的维数：【下标长度N】【每个下标取值范围51】【某一个数组的前一个数。。】
		// // 亲爱的表哥的活宝妹，先写、几乎万能的【记忆化深搜】！！
		// static final int mod = (int)1e9 + 7;
		// public int countOfPairs(int[] a) {
		// 	// 亲爱的表哥的活宝妹，这个题目，是可能过的，再稍微优化一下，不必要的遍历，不做；前合法性，不自己制造不合法和后续检测
		// 	n = a.length; m = Arrays.stream(a).max().getAsInt(); this.a = a; 
		// 	f = new Long [n][m+1][m+1];
		// 	// 遍历 j: A 数组的 a[0] 取值范围
		// 	for (int i = 0; i <= a[0]; i++) 
		// 		dfs(0, i, 0);
		// 	long r = 0;
		// 	for (int i = 0; i <= a[0]; i++) 
		// 		r = (r + f[0][i][0]) % mod;
		// 	return (int)r;
		// }
		// Long [][][] f;
		// int m, n; int [] a;
		// long dfs(int i, int j, int k) { // J: i 下标的当前取值 K: i-1 下标的 A 数组取值
		// 	if (f[i][j][k] != null) return f[i][j][k];
		// 	// 检查【合法性】：当前下标 i, 是否 a[i-1] <= a[i] && b[i-1] >= b[i] ？也可以不用检查，先过滤，仅只取合法范围内的值
		// 	if (i == 0 && n > 1 && (j > a[1] || a[0]-j < 0)) return f[i][j][k] = 0l;
		// 	if (i > 0 && a[i-1] - k < a[i] - j) return f[i][j][k] = 0l;
		// 	if (i == n-1) return f[i][j][k] = 1l;
		// 	// 遍历？当前下标 i, A 数组取值为 j, A 数组 i-1 下标取值为 k 时， i+1 下标， A 数组的取值范围
		// 	long r = 0;
		// 	for (int x = j; x <= a[i+1]; x++) 
		// 		r = (r + dfs(i+1, x, j)) % mod;
		// 	return f[i][j][k] = r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，今天没带本子回来，先去写别的，再回来看这个题目
		// public int countGoodNodes(int[][] egs) {
		// 	n = egs.length + 1;
		// 	g = new ArrayList [n];
		// 	Arrays.setAll(g, z -> new ArrayList<>());
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1];
		// 		g[u].add(v);
		// 		g[v].add(u);
		// 	}
		// 	f = new int [n];
		// 	a = new Boolean [n];
		// 	dfs(0, -1);
		// 	int ans = 0;
		// 	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 	// 亲爱的表哥的活宝妹，上面、这里、理解错了，不是说，所有【子树】相同大小，而是，所有的、【子树的子树】，都是合格好树！！
		// 	// 中间【隔了一代子树】！题型，像是，那个【小偷、树型偷东西】
		// 	// 【小偷、树型偷东西】：那个题型，也狠经典，可是亲爱的表哥的活宝妹，把它弄忘记了，一时想不起来，是如何隔代隔层偷东西的？
		// 	// 亲爱的表哥的活宝妹，这么简单的题目，周六傍晚没能写出来，仅只因为，那天，亲爱的表哥的活宝妹，没有带本子回住处
		// 	// 对于写错了的 test-case, 没能画出树图来分析和 debug 而已。但是亲爱的表哥的活宝妹只要想写，就一定写得出来！！
		// 	for (int i = 0; i < n; i++) 
		// 		if (a[i] != null && a[i]) ans++;
		// 	return ans;
		// }
		// List<Integer> [] g;
		// int [] f;     // total  nodes count 
		// Boolean [] a; // balanced or not 重新定义为：是否，所有的、以该根节点的、任何【子节点】为根的子树，都是合格好树
		// int n;
		// void dfs(int u, int p) {
		// 	// if (g[u].size() == 1) {  // 【写错了】：特例，0 根节点
		// 	if (g[u].size() == 1 && g[u].get(0) == p) {
		// 		f[u] = 1;
		// 		a[u] = true; // 【叶子节点】一定是全格的
		// 		return ;
		// 	}
		// 	int val = 0, cnt = 0, ttCnt = 0;
		// 	// 以【子节点】的子节点为根的、树的大小，也是严格标准
		// 	for (int v : g[u]) {
		// 		if (v == p) continue;
		// 		dfs(v, u);
		// 		if (val == 0) 
		// 			val = f[v];
		// 		else if (f[v] != val)  // 【写错了】：题目要求中间隔一代。。
		// 			a[u] = false;
		// 		ttCnt += f[v];
		// 		// if (a[v]) cnt++; // 【写错了】：这相标准，不对！！
		// 		// 重定标准：所有、子节点为根的子树，都合法的、子节点统计
		// 		// // 先定义不合法的：这里写得也不对
		// 		// if (!a[v]) a[u] = false;
		// 		// if (a[v] || f[v] == val) cnt++;
		// 		// if (a[v])
		// 		cnt++;
		// 	}
		// 	if (a[u] == null && cnt == g[u].size()-(p == -1 ? 0 : 1)) a[u] = true;
		// 	else a[u] = false;
		// 	f[u] = ttCnt + 1;
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 【数据规模变大了】：【N=2000,a[i]=1000,preA[i]=1000】，上个写法，一定超时！！
// 		// 【亲爱的表哥的活宝妹，今天还不能写这个题目，读不懂。。明天上午再写这个题目】
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 【记忆化深搜】就不用再想了，如上题解法的【记忆化深搜】也一定超时！！
// 		// 【动规】：亲爱的表哥的活宝妹，可以试写。但感觉，这个数据规模的【动规】，仅只改写【记忆化深搜】为【动规】，亲爱的表哥的活宝妹感觉，【动规】，也还会超时！！
// 		// 【动规】＋必要的【优化】：什么狗屁【树状数组】【O(logN) 级别的、区间求和】优化，用起来，或许能过, 解法为O(N*M*log(M)) 应该能过
// 		// 【动规】＋必要的【优化】：也可以从，对【原数组 A 的、数据预处理】方面考虑，优化。也就是，将每个下标 i 的【合法、取值范围】极尽可能地缩小，缩小到，不TLE
// 		// 这么看，这个题目，也仅仅只是，亲爱的表哥的活宝妹，还没能民习惯写【动规】而已。。
// 		// 习惯了写【自尾向头】的【记忆化深搜】，亲爱的表哥的活宝妹，还需要也应该适应，写【自头向尾】的【动规】！！
// 		static final int mod = (int)1e9 + 7;
// 		public int countOfPairs(int[] a) {
// 			int n = a.length, m = Arrays.stream(a).max().getAsInt();
// 			int [][] f = new int [n][m+1]; // 不再用，这个常规打开方式。。。
// 			// 【记忆化深搜】：亲爱的表哥的活宝妹，总是【自尾向头】来解决子下标的结果；
// 			// 【动规】：它们的题解，都是【自头向尾】来解决子下标的结果。。
// // The range to be filled extends from index fromIndex, inclusive, to index toIndex, exclusive.
// 			Arrays.fill(f[0], 0, a[0]+1, 1); // [fromIndex_Inclusive, toIndex_Exclusive)
// 			long s = 0l; // 【每个下标、都初始化】的、每个下标的、前缀和
// 			int maxK = 0;
// 			// 遍历：下标【1,n-1】求解
// 			for (int i = 1; i < n; i++) {
// 				s = 0l;
// 				maxK = Math.min(0, a[i-1] - a[i]);
// 				for (int j = 0; j <= m; j++) {
// 					if (j + maxK < 0) f[i][j] = 0;
// 					else {
// 						s += f[i-1][j + maxK];
// 						f[i][j] = (int)(s % mod);
// 					}
// 				}
// 			}
// 			s = 0l;
// 			for (int i = 0; i <= a[n-1]; i++) 
// 				s = (s + f[n-1][i]) % mod;
// 			return (int) s;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int[] resultsArray(int[] a, int k) {
		// 	int n = a.length, j = 0;
		// 	int [] r = new int [n-k+1];
		// 	Arrays.fill(r, -1);
		// 	boolean valid = false;
		// 	for (int i = 0; i < n-k+1; i++) {
		// 		valid = true;
		// 		for (j = i+1; j < i+k; j++) {
		// 			if (j == i+1 && a[j] != a[i] + 1
		// 				|| j > i+1 && a[j] != a[j-1]+1) {
		// 				valid = false;
		// 				break;
		// 			} 
		// 		}
		// 		if (valid) r[i] = a[j-1];
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int[] resultsArray(int[] a, int k) {
		// 	int n = a.length, j = 0;
		// 	int [] f = new int [n];// counts the # of consecutive increasing length
		// 	Arrays.fill(f, 1);
		// 	for (int i = 1; i < n; i++) 
		// 		if (a[i] == a[i-1] + 1)
		// 			f[i] = f[i-1] + 1;
		// 	int [] r = new int [n-k+1];
		// 	Arrays.fill(r, -1);
		// 	for (int i = k-1; i < n; i++) 
		// 		if (f[i] >= k) r[j++] = a[i];
		// 		else j++;
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int countKConstraintSubstrings(String S, int k) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int ans = 0, l = 0, r = 0, ll = 0, rr = 0;// l r 0 1
		// 	for (int i = 0; i < n; i++) {
		// 		if (i > 0) {
		// 			if (s[i-1] == '0') l--;
		// 			else r--;
		// 		}
		// 		if (s[i] == '0') l++;
		// 		else r++;
		// 		for (int j = i; j < n; j++) {
		// 			if (j == i) {
		// 				ll = l; rr = r;
		// 			} else {
		// 				if (s[j] == '0') ll++;
		// 				else rr++;
		// 			}
		// 			if (ll <= k || rr <= k) ans++;
		// 		}
		// 	}
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long maxEnergyBoost(int[] a, int[] b) {
		// 	int n = a.length;
		// 	long [][][] f = new long [n][2][2]; // 【最后一维】：前一个小时，喝的是哪种？0: a 1:b
		// 	Arrays.fill(f[0][0], (long)a[0]);
		// 	Arrays.fill(f[0][1], (long)b[0]);
		// 	for (int i = 1; i < n; i++) {
		// 		// 【本小时】：喝继上，同一种
		// 		f[i][0][0] = Math.max(f[i-1][0][0], f[i-1][0][1]) + a[i];
		// 		f[i][1][1] = Math.max(f[i-1][1][1], f[i-1][1][0]) + b[i];
		// 		// 【本小时】：喝不同种: 这里，感觉亲爱的表哥的活宝妹，写得稀里糊涂它就过了。。。
		// 		f[i][0][1] = f[i-1][1][1];
		// 		// f[i][0][1] = Math.max(f[i-1][1][1], f[i-1][1][0] + a[i]);
		// 		f[i][1][0] = f[i-1][0][0];
		// 		// f[i][1][0] = Math.max(f[i-1][0][0], f[i-1][0][1] + b[i]);
		// 	}
		// 	long r = 0l;
		// 	for (int i = 0; i < 2; i++) 
		// 		for (int j = 0; j < 2; j++) 
		// 			r = Math.max(r, f[n-1][i][j]);
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【数据规模】有点儿大，如果【暴力O(10000*10000*10000)】应该会超时, 数量级在【O(N=10000*10000)】可能可以过，不超时
		// // 忘记一个因素：【前状态，需要记忆】。第一个、第二个的摆放位置，需要记住。需要重新定义【记忆、数据结构】 
		// // 可能需要结合【贪心思路】来只遍历、最优解可能性的部分位置
		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 【数据规模】有点儿大，如果【暴力O(10000*10000*10000)】应该会超时, 数量级在【O(N=10000*10000)】可能可以过，不超时
		// 忘记一个因素：【前状态，需要记忆】。第一个、第二个的摆放位置，需要记住。需要重新定义【记忆、数据结构】 
		// 可能需要结合【贪心思路】来只遍历、最优解可能性的部分位置
		// public long maximumValueSum(int[][] a) { // TLE: 725/843 passed
		// 	m = a.length; n = a[0].length; this.a = a; 
		// 	// Integer [] rank = IntStream.range(0, m*n).boxed().toArray(Integer[]::new);			
		// 	// Arrays.sort(rank, (x, y)->a[y/n][y%n] - a[x/n][x%n]); // 按值大小，降序排列
		// 	long max = Long.MIN_VALUE;
		// 	f = new HashMap<>();
		// 	for (int i = 0; i < m*n; i++) {
		// 		String [] s = new String [3];
		// 		// s[0] = String.valueOf(rank[i]);
		// 		// long ans = a[rank[i]/n][rank[i]%n] + dfs(rank[i]/n, rank[i] % n, s);
		// 		s[0] = String.valueOf(i);
		// 		long ans = a[i/n][i%n] + dfs(i/n, i % n, s);
		// 		max = Math.max(max, ans);
		// 		// if (ans < a[rank[0]/n][rank[0]%n]) break;
		// 								  }
		// 	return max;
		// }
		// int [][] a;
		// Map<String, Long> f;
		// int m, n;
		// long dfs(int i, int j, String [] s) {
		// 	String key = String.valueOf(i * n + j) + "-" + s[0] + (s[1] == null ? "" : "-" + s[1] + (s[2] == null ? "" :  "-" + s[2]));
		// 	if (f.containsKey(key)) return f.get(key);
		// 	long r = Long.MIN_VALUE;
		// 	Set<Integer> si = new HashSet<>(), sj = new HashSet<>();
		// 	TreeSet<Integer> ts = new TreeSet<>();
		// 	for (int x = 0; x < 3; x++) 
		// 		if (s[x] != null) {
		// 			si.add(Integer.parseInt(s[x]) / n);
		// 			sj.add(Integer.parseInt(s[x]) % n);
		// 			ts.add(Integer.parseInt(s[x]));
		// 		}
		// 	if (ts.size() == 3) return 0;
		// 	StringBuilder sb = new StringBuilder();
		// 	Iterator it;
		// 	int jj = 0;
		// 	for (int x = 0; x < m; x++) {
		// 		if (si.contains(x)) continue;
		// 		for (int y = 0; y < n; y++) {
		// 			if (sj.contains(y)) continue;
		// 			ts.add(x * n + y); // 添加【当前数】
		// 			sb.setLength(0);
		// 			it = ts.iterator();
		// 			if (it.hasNext()) {
		// 				sb.append(String.valueOf(ts.first()));
		// 				s[0] = String.valueOf(ts.first());
		// 				it.next();
		// 				jj = 0;
		// 			}
		// 			while (it.hasNext()) { 
		// 				int v = (int)it.next();
		// 				sb.append("-");
		// 				sb.append(String.valueOf(v));
		// 				s[++jj] = String.valueOf(v);
		// 			}
		// 			String [] ss = new String [3];
		// 			for (int zz = 0; zz < 3; zz++) 
		// 				ss[zz] = s[zz];
		// 			r = Math.max(r, (long)a[x][y] + (s[2] == null ? dfs(x, y, ss) : 0l));
		// 			ts.remove(x * n + y); // 移除【当前数】
		// 		}
		// 	}
		// 	sb.setLength(0);
		// 	it = ts.iterator();
		// 	if (it.hasNext()) {
		// 		sb.append(String.valueOf(ts.first()));
		// 		it.next();
		// 	}			
		// 	while (it.hasNext()) { 
		// 		sb.append('-');
		// 		sb.append(it.next());
		// 	} 
		// 	f.put(sb.toString(), r);
		// 	return r;
		// }
		// // 【亲爱的表哥的活宝妹，换个 long 作键，结果把这个题目写疆了。。。再不想写它了，看答案写。。。】
		// public long maximumValueSum(int[][] a) { // TLE: 725/843 passed
		// 	m = a.length; n = a[0].length; this.a = a; 
		// 	long max = Long.MIN_VALUE;
		// 	f = new HashMap<>();
		// 	for (int i = 0; i < m*n; i++) {
		// 		long ans = a[i/n][i%n] + dfs(i/n, i % n, i+1);
		// 		max = Math.max(max, ans);
		// 		// if (ans < a[rank[0]/n][rank[0]%n]) break;
		// 	}
		// 	return max;
		// }
		// int [][] a;
		// Map<Integer, Long> f = new HashMap<>(); 
		// int m, n;
		// long dfs(int i, int j, int k) {
		// 	// System.out.println("\n k: " + k);
		// 	if (f.containsKey(k)) return f.get(k);
		// 	long r = Long.MIN_VALUE;
		// 	Set<Integer> si = new HashSet<>(), sj = new HashSet<>();
		// 	Set<Integer> st = new HashSet<>();
		// 	int key = (k & ((1 << 14)-1));
		// 	int cnter = 0;
		// 	while (key > 0) {
		// 		System.out.println("key: " + key);
		// 		++cnter;
		// 		st.add(key);
		// 		si.add((key -1) / n);
		// 		sj.add((key -1) % n);
		// 		key = (key >> 14);
		// 	}
		// 	int [] tmp = new int [cnter+1];
		// 	for (int x = 0; x < m; x++) {
		// 		if (si.contains(x)) continue;
		// 		for (int y = 0; y < n; y++) {
		// 			if (sj.contains(y)) continue;
		// 			// System.out.println("(x * n + y + 1): " + (x * n + y + 1));
		// 			st.add(x * n + y + 1);
		// 			int ii = 0;
		// 			for (int v : st) 
		// 				tmp[ii++] = v;
		// 			Arrays.sort(tmp);
		// 			System.out.println(Arrays.toString(tmp));
		// 			key = tmp[0];
		// 			// for (int xx = 1; xx < tmp.length; xx++) {
		// 			for (int xx = 1; xx < 2; xx++) {
		// 				// key <<= 14;
		// 				key = (key << 14);
		// 				key |= tmp[xx];
		// 			}
		// 			// System.out.println("key: " + key);
		// 			r = Math.max(r, (long)a[x][y] + (cnter == 2 ? 0l : dfs(x, y, key)));
		// 			st.remove(x * n + y + 1);
		// 		}
		// 								}
		// 	tmp = new int [st.size()];
		// 	int ii = 0;
		// 	for (int v : st) 
		// 		tmp[ii++] = v;
		// 	Arrays.sort(tmp);
		// 	key = 0;
		// 	for (int v : tmp) {
		// 		key = (key << 14);
		// 		key |= v;
		// 	}
		// 	f.put(key, r);
		// 	return r;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【破烂题解】：思路讲得狠清楚、代码【注释不清】——读【注释不清楚】的源码，像读天书一样。。。浪费无数查题解的【码工亲爱的表哥的活宝妹们】的时间。。。
		// // 【直角三角形】：攻举中间情况
		// public long maximumValueSum(int[][] a) { 
		// 	m = a.length; n = a[0].length;
		// 	// 仅先【倒序遍历一次】：预处理【后缀】；前缀处理，与求解同时遍历更新
		// 	s = new int [m][3][2]; // 最后一维【2】：0, 最大、次大、第三大的【取值】；1: 三个不同取值所用的对应【列号】
		// 	p = new int [3][2];
		// 	for (int [] pi : p) // 【前缀】初始化：最小值
		// 		pi[0] = Integer.MIN_VALUE;
		// 	// 预处理：【后缀】最大、次大、第三大的【取值】与，对应取值时、所用的【列号】
		// 	// 替代【前缀】预处理 p 数组空间一用。。。
		// 	for (int i = m-1; i > 1; i--) { // 【倒序、后缀遍历行】：行结果、临时写入 p 数组
		// 		update(a[i], p); 
		// 		for (int j = 0; j < 3; j++) {  // 行结果、存入 s数组
		// 			s[i][j][0] = p[j][0];
		// 			s[i][j][1] = p[j][1];
		// 		}
		// 	}
		// 	long r = (long)Long.MIN_VALUE;
		// 	// 【写错了】：忽略掉了细节， p 被借用过，填写过脏数据，这里要重新【初始化！】
		// 	for (int [] pi : p) { // 【前缀】初始化：最小值
		// 		pi[0] = Integer.MIN_VALUE;
		// 		pi[1] = 0; // 列的脏数据，也得清除干净。。
		// 	}
		// 	// // 【精简代码】： a【0】行的处理，也可以放进【遍历中间值、中间车】的遍历逻辑里，就可以合并只写一遍
		// 	// update(a[0], p); // 预处理a[0] 存入 p. 【写错了】：忽略掉了细节， p 被借用过，填写过脏数据，这里要重新【初始化】之后，才处理 a[0] 行！！！
		// 	// 求解：【遍历中间值】的合法【行】范围（0,m-1）【假定：前车，在 i 行之前；后车，在 i 行之后。这样当前中间车，可值所有列值】；同步累积处理【前缀 p】
		// 	for (int i = 1; i < m-1; i++) { // 【遍历中间车、行】
		// 		update(a[i-1], p);
		// 		// 遍历：中间车，可能位于的所有的合法列【0,n-1】
		// 		for (int j = 0; j < n; j++) { // 【遍历中间车、列】
		// 			// // 【优化】：优先考虑，全局——本行最优解；最早裁枝。效果：看似优化及及时裁枝，可能实际多此一举。。。
		// 			// if (p[0][1] != j && j != s[i+1][0][1]) {// 三车：全【最大解】且都不同列，直接取所有三车【最大值】
		// 			// 	r = Math.max(r, (long)a[i][j] + (long)p[0][0] + (long)s[i+1][0][0]);
		// 			// 	// 同取【三车、最优解】，就一定会是【本行、全局最优解】，不用再遍历后序 j 了
		// 			// 	break;
		// 			// }
		// 			// 【暴力求解】：当中间车在【i,j】位置，前后两车、可能位置的所有情况
		// 			for (int [] fst : p) // 遍历，前车，三种较优解
		// 				for (int [] trd : s[i+1]) // 遍历：后车，三种较优解 
		// 					if (fst[1] != j && trd[1] != j && fst[1] != trd[1]) // 三车不同列
		// 						r = Math.max(r, (long)a[i][j] + (long)fst[0] + (long)trd[0]);
		// 			// for (int x = 0; x < 3; x++) { // 攻举：前车，三种解【最大、次大、第三大】所有【优解列】
		// 			// 	if (p[x][1] == j) // 前车，与 j 同列，不考虑
		// 			// 		continue;
		// 			// 	for (int y = 0; y < 3; y++) { // 攻举：后车，三种解【最大、次大、第三大】所有【优解列】，不与前车、当前中间车，同列
		// 			// 		if (s[i+1][y][1] == j || s[i+1][y][1] == p[x][1]) continue;
		// 			// 		r = Math.max(r, (long)a[i][j] + (long)p[x][0] + (long)s[i+1][y][0]);
		// 			// 	}
		// 			// }
		// 		}
		// 		// // 同步处理【前缀】：【更新，当前行 i, 入前缀 p 处理】。与 a[0] 行处理，共同合并到，遍历逻辑开始的地方了
		// 		// update(a[i], p);
		// 	}
		// 	return r;
		// }
		// int m, n;
		// int [][] p;  // pre 预处理 
		// int [][][] s;// suffix 预处理
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 处理 a 数组里，最大、次大、第三大的【取值】与所用对应的【列号】，存入【反复擦写】数组 f 里
		// void update(int [] a, int [][] f) {
		// 	for (int j = 0; j < a.length; j++) { // 遍历【列】：
		// 		// 【前缀】【后缀】累积更新的原则是：【最大】【次大】【第三大】不同列；同列只占据三种解中的一种
		// 		// 【写错了】：亲爱的表哥的活宝妹，写下面更新的时候，细节一定，有什么地方，写错了
		// 		if (a[j] > f[0][0]) { // 比，最大值，大，也同时意味着： j != f[0][1]
		// 			if (j != f[0][1]) { // 取过值的情况下，进这里。f[0-2][0] 缺省都为 0. 与【最优】解，不同列
		// 				if (j != f[1][1])  // 【TODO】：感觉这里，三车不同列，什么时候不能换。。傻傻瓣不清楚。。。改天再看这个细节
		// 					f[2] = f[1]; // 这么写，最简单，就是重新索引一下数组行。。
		// 				f[1] = f[0];
		// 			}
		// 			f[0] = new int [] {a[j], j}; // 因为前面的【重新索引】，这里就要重新分配空间，写新数组
		// 		} else if (a[j] > f[1][0] && j != f[0][1]) { // 比，次大，大; 第【前车】不同列
		// 			if (j != f[1][1]) // 可以合法更新 f[1]
		// 				f[2] = f[1]; // 这么写，最简单，就是重新索引一下数组行。。
		// 			f[1] = new int [] {a[j], j};
		// 	    } else if (a[j] > f[2][0] && j != f[1][1] && j != f[0][1]) // 比，第三大，大, 三个不同列【合法有效】存解
		// 		    f[2] = new int [] {a[j], j};
		// 	}
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目还是有点儿难，晚点儿再去想：昨天的四个难题。。。早上的一两个难题目，好恶心人。。。浪费亲爱的表哥的活宝妹宝贵的青春。。。
		// public long [] countKConstraintSubstrings(String S, int k, int[][] q) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int [] f = new int [n]; // left [] 数组: 【有序、升序】排列，单调递增
		// 	long [] a = new long [n+1]; // preSum 以每个下标为【右端点】的合法个数
		// 	int [] cnt = new int [2];
		// 	int l = 0; // 【自左向右】遍历一次，预处理 f[] 数组
		// 	for (int i = 0; i < n; i++) {
		// 		cnt[s[i] & 1]++;
		// 		while (cnt[0] > k && cnt[1] > k) // 当前下标 i 下，不合法，就左端点 l 右移
		// 			cnt[s[l++] & 1]--;
		// 		f[i] = l;
		// 		a[i+1] = a[i] + (long)(i - l + 1); // 计算 i-left[i]+1 的前缀和
		// 	}
		// 	long [] ans = new long [q.length];
		// 	for (int i = 0; i < q.length; i++) {
		// 		int ll = q[i][0], rr = q[i][1];
		// 		if (f[rr] <= ll) {
		// 			ans[i] = (long)(rr - ll + 1) * (rr - ll + 2) / 2l;
		// 			continue;
		// 		}
		// 		int j = lower_bound(f, ll-1, rr+1, ll); // f[j] >= ll
		// 		ans[i] = (long)(j - ll) * (j - ll + 1) / 2l + a[rr+1] - a[j];
		// 	}
		// 	return ans;
		// }
		// // 返回在开区间 (left, right) 中的最小的 j，满足 nums[j] >= target
		// // 如果没有这样的数，返回 right
		// int lower_bound(int [] f, int l, int r, int t) { 
		// 	while (l + 1 < r) { // 遍历范围：只要非空，就得遍历
		// 		int m = l + (r - l) / 2;
		// 		if (f[m] < t)
		// 			l = m;
		// 		else r = m;
		// 	}
		// 	return r;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目还是有点儿难，晚点儿再去想：昨天的四个难题。。。早上的一两个难题目，好恶心人。。。浪费亲爱的表哥的活宝妹宝贵的青春。。。
		// public long [] countKConstraintSubstrings(String S, int k, int[][] q) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int [] f = new int [n]; // right [] 数组: 【有序、升序】排列，单调递增
		// 	long [] a = new long [n+1]; // preSum 以每个下标为【右端点】的合法个数
		// 	int [] cnt = new int [2];
		// 	int l = 0; // 【自左向右】遍历一次，预处理 f[] 数组
		// 	for (int i = 0; i < n; i++) {
		// 		cnt[s[i] & 1]++;
		// 		while (cnt[0] > k && cnt[1] > k) { // 当前下标 i 下，不合法，就左端点 l 右移
		// 			cnt[s[l] & 1]--;
		// 			f[l++] = i;
		// 		}
		// 		a[i+1] = a[i] + (long)(i - l + 1); // 计算 i-right[i]+1 的前缀和
		// 	}
		// 	// 【写错了】：后面没填充的，要【哨兵】 n
		// 	Arrays.fill(f, l, n, n); // 往下标段【l,n-1】里填 n
		// 	long [] ans = new long [q.length];
		// 	for (int i = 0; i < q.length; i++) {
		// 		int ll = q[i][0], rr = q[i][1];
		// 		int j = Math.min(f[ll], rr+1); // f[j] right[j] > LL
		// 		ans[i] = a[rr+1] - a[j] + (long)(j-1 - ll + 1) * (j - ll + 1) / 2;
		// 	}
		// 	return ans;
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，感觉这个题目的思路是清晰的、可以想明白，感觉想得几乎是透彻的。因为是回文，按【数位动规】或说【数位深搜】N/2+1? 的字符串长度，检测合法性
// 		// 但是N 在【1,10^5】数量级大，不知道，是不是又得用狗屁 BigInteger, 狠烦人，先去写其它的
// 		// k 的取值范围【1,9】：仍然搞不清楚，要写 9 个不同的方法来处理不同的、是否能被 k 整除吗？考场上想到这些，就不想再写了。。。
// 		// 亲爱的表哥的活宝妹，上次看题解就看不懂，昨天晚上因为。。昨天晚上极晚才勉强入睡、今天状态狠差，可是今天却看懂了。。。
// 		// 【记忆化深搜】传统解法的【贪心思想】改装版本：仍然记忆状态，状态是 true-false...
// 		public String largestPalindrome(int n, int k) {
// 			m = (n + 1) / 2; this.n = n; this.k = k; 
// 			f = new boolean [m+1][k];
// 			a = new int [n]; // 【预处理】：× 10 % k
// 			a[0] = 1;
// 			for (int i = 1; i < n; i++)
// 				a[i] = a[i-1] * 10 % k;
// 			r = new char [n];
// 			dfs(0, 0);
// 			return new String(r);
// 		}
// 		int m, n, k;
// 		int [] a;
// 		boolean [][] f; // vis 数组
// 		char [] r;
// 		boolean dfs(int i, int j) { // 当前状态：【i,j】；图下一个节点状态：【i+1,jj】
// 			// 【终止条件】：i=[0,m-1]
// 			if (i == m) return j == 0; // 确保，％ k==0 
// 			int jj = k; // 填位【i,j】后的、新余数
// 			f[i][j] = true; // 标记：【i,j】遍历过了。永远只遍历一次，并记结果???
// // 【贪心思路】：【从大到小】往每个位 i 填数字
// 			for (int ii = 9; ii >= 0; ii--) {
// 				if (n % 2 == 1 && i == m-1) // 最中间一位数字
// 					jj = (j + ii * a[i]) % k;
// 				else
// 					jj = (j + ii * (a[i] + a[n-1-i])) % k;
// 				if (!f[i+1][jj] && dfs(i+1, jj)) {
// 					// 【贪心】地把、数位 i 与数位 n-1-i 填上、最大可能的数字。就是这一两个数位上的最优解
// 					r[i] = r[n-1-i] = (char)('0' + ii);
// 					return true;
// 				}
// 			}
// 			return false;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int[] getFinalState(int[] a, int k, int m) {
		// 	int n = a.length;
		// 	int [] f = new int [n];
		// 	Queue<Integer> q = new PriorityQueue<>((x, y) -> a[x] != a[y] ? a[x] - a[y] : x - y);
		// 	for (int i = 0; i < n; i++) q.offer(i);
		// 	for (int i = 0; i < k; i++) {
		// 		int j = q.poll();
		// 		a[j] = m * a[j];
		// 		q.offer(j);
		// 	}
		// 	f = Arrays.copyOf(a, n);
		// 	return f;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int countPairs(int[] f) { // 比赛的时候，亲爱的表哥的活宝妹自己写的，没想透细节的破烂代码。。
		// 	int n = f.length, r = 0;
		// 	for (int i = 0; i < n-1; i++) {
		// 		for (int j = i+1; j < n; j++) {
		// 			if (f[i] == f[j] || Math.max(f[i], f[j]) == Math.min(f[i], f[j]) * 10) r++;
		// 			if (almostEqual(f[i], f[j]))
		// 				r++;
		// 		}
		// 	}
		// 	return r;
		// }
		// boolean almostEqual(int ii, int jj) {
		// 	String S = String.valueOf(Math.max(ii, jj)), T = String.valueOf(Math.min(ii, jj));
		// 	if (S.length() != T.length()) return false;
		// 	// if (Math.abs(S.length() - T.length()) > 1) return false;
		// 	char [] s = S.toCharArray(), t = T.toCharArray();
		// 	int r = 0;
		// 	for (int i = 0; i < s.length; i++) {
		// 		if (s[i] == t[i]) continue;
		// 		for (int j = i+1; j < S.length(); j++) {
		// 			if (s[j] == t[i] && t[j] == s[i]) {
		// 				r++;
		// 				s[j] = s[i];
		// 				break;
		// 			}
		// 		}
		// 	}
		// 	return r == 1;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int countPairs(int[] a) {
		// 	int n = a.length, r = 0;
		// 	// 字典：是【数个数】的经典方法
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	Set<Integer> si = new HashSet<>();
		// 	Arrays.sort(a); 
		// 	for (int v : a) {
		// 		si.clear();
		// 		si.add(v);
		// 		char [] s = String.valueOf(v).toCharArray();
		// 		// 把人恶心死不偿命的【暴力交换】: 当前数 V 只交换一次，可能产生的、所有数
		// 		for (int i = 0; i < s.length; i++) 
		// 			for (int j = i+1; j < s.length; j++) {
		// 				swap(s, i, j);
		// 				si.add(Integer.parseInt(new String(s)));
		// 				swap(s, i, j);
		// 			}
		// 		// 数：数组里，有多少对，符合要求
		// 		for (int vi : si) 
		// 			r += m.getOrDefault(vi, 0);
		// 		// 把当前数计入：
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	}
		// 	return r;
		// }
		// void swap(char [] s, int i, int j) {
		// 	char c = s[i];
		// 	s[i] = s[j];
		// 	s[j] = c;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，肿么知道，它们的破烂题目，要那么恶心死人不偿命地【暴力交换】？真恶心人。。。
		// // 亲爱的表哥的活宝妹，被提示一下，不是也轻轻松松、写过了？。。。破烂题目，狠恶心人！！！
		// // 题解说，还有种O(1) 算出交换后的值的解法，但是，亲爱的表哥的活宝妹，今天看不懂、懒得看，今天暂时不看它了。。。太恶心人了。。。改天再看这个细节
		// public int countPairs(int[] a) {
		// 	int n = a.length, r = 0;
		// 	// 字典：是【数个数】的经典方法
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	Set<Integer> si = new HashSet<>(), sj = new HashSet<>();
		// 	Arrays.sort(a); 
		// 	System.out.println(Arrays.toString(a));
		// 	for (int v : a) {
		// 		si.clear();
		// 		sj.clear();
		// 		char [] s = String.valueOf(v).toCharArray();
		// 		// 把人恶心死不偿命的【暴力交换】: 当前数 V 只交换一次，可能产生的、所有数
		// 		// 下面，亲爱的表哥的活宝妹，把【不交换0 交换的 v】＋【暴力交换一次、所有可能产生的数的、集合】＋【暴力交换两次、所有可能产生的数的、集合】
		// 		// 分两次遍历、分得狠清楚。也可以，【一次遍历，把一次交换、与第二次交换、循环嵌套、写进一次遍历里】，如下
		// 		// 【暴力交换】：只一次，可能产生的，所有可能的数
		// 		for (int i = 0; i < s.length-1; i++) 
		// 			for (int j = i+1; j < s.length; j++) {
		// 				swap(s, i, j);
		// 				si.add(Integer.parseInt(new String(s)));
		// 				// 也可以，【一次遍历，把一次交换、与第二次交换、循环嵌套、写进一次遍历里】，如下
		// 				// 【区分 j 与 x】：主要是，暴力后，方便恢复
		// 				for (int x = i+1; x < s.length-1; x++) // 这里，从 i+1 开始
		// 					for (int y = x+1; y < s.length; y++) {
		// 						swap(s, x, y);
		// 						si.add(Integer.parseInt(new String(s)));
		// 						swap(s, x, y);
		// 					}
		// 				swap(s, i, j);
		// 			}
		// 		// // 【暴力交换】：第二次，可能产生的，所有可能的数
		// 		// for (int vi : si) {
		// 		// 	char [] t = String.valueOf(vi).toCharArray();
		// 		// 	for (int i = 0; i < t.length-1; i++) 
		// 		// 		for (int j = i+1; j < t.length; j++) {
		// 		// 			swap(t, i, j);
		// 		// 			sj.add(Integer.parseInt(new String(t)));
		// 		// 			swap(t, i, j);
		// 		// 		}
		// 		// }
		// 		// si.addAll(sj);
		// 		// 【暴力交换】：0次，就是 v 本身
		// 		si.add(v);
		// 		// 数：数组里，有多少对，符合要求
		// 		for (int vi : si) 
		// 			r += m.getOrDefault(vi, 0);
		// 		// 把当前数计入：
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	}
		// 	return r;
		// }
		// void swap(char [] s, int i, int j) {
		// 	char c = s[i];
		// 	s[i] = s[j];
		// 	s[j] = c;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，【快速幂】的思路都有，就是那【核心观察】观察不到、不会想。。。
		// static final int mod = (int)1e9 + 7;
		// public int[] getFinalState(int[] a, int k, int m) { // 526/692 passed 
		// 	int n = a.length;
		// 	long [] f = new long [n];
		// 	Queue<Integer> q = new PriorityQueue<>((x, y)->f[x] != f[y] ? Long.compare(f[x], f[y]) : x - y);
		// 	for (int i = 0; i < n; i++) {
		// 		f[i] = (long)a[i];
		// 		q.offer(i);
		// 	}
		// 	// 当 k>n, 想要去想： a[n] 数组， k 次乘最小数，数组中，每个数，乘的次数，有没有什么周期性重复？可是，这个周期性的规律，要怎么找、怎么想呢？？？
		// 	// 感觉，就是上面的重点想不清楚，写不出、这几个周、它们的贱鸡、贱畜牲，越来越挑战亲爱的表哥的活宝妹，出的题目越来越发疯犯贱、越来越恶心死人不偿命的破烂题目。。。
		// 	long mm = 1l;
		// 	if (k > n) // 这里细节，有什么地方写错了。。。
		// 		mm = (long)quickMul((long)m, k / n);
		// 	System.out.println("mm: " + mm);
		// 	if (k > n) k %= n;
		// 	for (int i = 0; i < k; i++) {
		// 		int j = q.poll();
		// 		f[j] = f[j] * (long)m;
		// 		if (n <= k) f[j] %= mod;
		// 		q.offer(j);
		// 	}
		// 	for (int i = 0; i < n; i++) {
		// 		f[i] = f[i] * mm % mod;
		// 		a[i] = (int)f[i]; 
		// 	}
		// 	return a;
		// }
		// int quickMul(long b, int p) { // 快速幂
		// 	long r = 1;
		// 	while (p > 0) {
		// 		if ((p & 1) == 1) {
		// 				r *= b;
		// 				r %= mod;
		// 		}
		// 		b *= b;
		// 		b %= mod;
		// 		p >>= 1;
		// 	}
		// return (int)r;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// static final int mod = (int)1e9 + 7;
		// public int[] getFinalState(int[] a, int k, int m) { // 526/692 passed 
		// 	int n = a.length, idx = 0, max = a[0];
		// 	if (m == 1) return a;
		// 	// if (n == 1) {
		// 	// 	a[0] = (int)(((long)a[0] * (long)quickMul((long)m, k)) % mod);
		// 	// 	return a;
		// 	// } 
		// 	long [] f = new long [n];
		// 	Queue<Integer> q = new PriorityQueue<>((x, y)->f[x] != f[y] ? Long.compare(f[x], f[y]) : x - y);
		// 	for (int i = 0; i < n; i++) {
		// 		f[i] = (long)a[i];
		// 		q.offer(i);
		// 								}
		// 	for (int i = 1; i < n; i++) 
		// 		if (a[i] > max) {
		// 			max = a[i];
		// 			idx = i;
		// 		}
		// 	// 【手动、人工、人力、寻找： k > n 时，可能循环到 a-max 的、循环规律】！！
		// 	for (; k > 0 && q.peek() != idx; --k) {
		// 		int i = q.poll();
		// 		f[i] = f[i] * m;
		// 		q.offer(i);
		// 	}
		// 	// 设此时还剩下 k 次操作，那么：
		// 	// 	对于前 kmodn 小的数，还可以再操作 ⌊n/k⌋+1 次。
		// 	// 	其余元素，还可以再操作 ⌊n/k⌋ 次。
		// 	for (int i = 0; i < n; i++) {
		// 		// 【写错了】：数组的顺序，是优先队列，帮维护的。亲爱的表哥的活宝妹笨宝妹、下面的写法，就又【想当然成、升序数组了。。。】
		// 		// a[i] = (int)(f[i] * (long)quickMul(m, k/n + (i < k % n ? 1 : 0)) % mod);
		// 		int j = q.poll();
		// 		// 【写错了】：下面，
		// 		// a[j] = (int)(f[j] * (long)quickMul(m, k / n + (i < k % n  ? 1 : 0)) % mod);
		// 		a[j] = (int)(f[j] % mod * (long)quickMul(m, k / n + (i < k % n  ? 1 : 0)) % mod);
		// 	}
		// 	return a;
		// }
		// int quickMul(long b, int p) {
		// 	long r = 1l;
		// 	for ( ; p > 0; p /= 2) {
		// 		if ((p & 1) == 1)
		// 			r = r * b % mod;
		// 		b = b * b % mod;
		// 	}
		// 	return (int)r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int generateKey(int i, int j, int k) {
		// 	char [][] f = new char [3][4];
		// 	for (int x = 0; x < 3; x++) 
		// 		Arrays.fill(f[x], '0');

		// 	for (int x = 3; x >= 0; x--) {
		// 		f[0][x] += i % 10;
		// 		f[1][x] += j % 10;
		// 		f[2][x] += k % 10;
		// 		i /= 10; j /= 10; k /= 10;
		// 	}
		// 	char [] r = new char [4];
		// 	for (int x = 0; x < 4; x++) 
		// 		r[x] = (char)Math.min((char)Math.min(f[0][x], f[1][x]), Math.min(f[0][x], f[2][x]));
		// 	return Integer.parseInt(new String(r));
		// }
		
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public String stringHash(String S, int k) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int [] a = new int [n+1];
		// 	for (int i = 1; i <= n; i++) 
		// 		a[i] = a[i-1] + s[i-1]-'a';
		// 	char [] f = new char [n/k];
		// 	int j = 0;
		// 	for (int i = 0; i+k <= n; i += k) 
		// 		f[j++] = (char)('a' + (a[i+k] - a[i]) % 26);
		// 	return new String(f);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public boolean checkTwoChessboards(String S, String T) {
		// 	char [] s = S.toCharArray(); char [] t = T.toCharArray();
		// 	return (s[0]-'a') % 2 == (t[0]-'a') % 2
		// 		? (s[1] - '1') % 2 == (t[1] - '1') % 2
		// 		: (s[1] - '1') % 2 != (t[1] - '1') % 2;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 在两倍大小N[1,2*10^5] 个点中，找相对较小，第 K[1,10^5] 小的单点，数据规模比较大，并且 query 顺序相关，无法【离线处理】
		// // 根据N 与K 的大小，选择使用【最小堆】或是【最大堆】。但是当K 无限接近 N/2, 占用空间比较大
		// public int[] resultsArray(int[][] q, int k) {
		// 	int n = q.length, kk, x = 0, y = 0;
		// 	int [] f = new int [n];
		// 	Arrays.fill(f, -1);
		// 	if (n < k) return f;
		// 	TreeMap<Integer, Integer> s, t; // = new TreeMap<>();
		// 	s = new TreeMap<>((o, oo)-> oo-o); // 【最大堆】 k or k-1
		// 	t = new TreeMap<>((o, oo)-> o-oo); // 【最小堆】 n-k+1
		// 	boolean minQueue = true;
		// 	if (k > n/2 + n%2) {
		// 		minQueue = false;
		// 		kk = n - k + 1;
		// 	}
		// 	for (int i = 0; i < k; i++) {
		// 		int key = Math.abs(q[i][0]) + Math.abs(q[i][1]);
		// 		s.put(key, s.getOrDefault(key, 0) + 1);
		// 		x++;
		// 	}
		// 	f[k-1] = s.firstEntry().getKey();
		// 	for (int i = k; i < n; i++) {
		// 		// 先添加，如果超出个数，再扔一个，进另一个滚动里:
		// 		int cur = Math.abs(q[i][0]) + Math.abs(q[i][1]);
		// 		// 最小工作量：存放方法？
		// 		int l = s.firstEntry().getKey(), r = -1;
		// 		if (!t.isEmpty())
		// 			r = t.firstEntry().getKey();
		// 		// 放：左边【最大堆】
		// 		if (cur >= l && (r == -1 || cur < r) || cur < l) {
		// 			s.put(cur, s.getOrDefault(cur, 0) + 1);
		// 			x++;
		// 		} else if (r != -1 && cur >= r) { // 放：右边【最小堆】
		// 			t.put(cur, t.getOrDefault(cur, 0) + 1);
		// 			y++;
		// 		}
		// 		// 滚动，确定当前结果
		// 		while (minQueue && x > k || !minQueue && x > k-1) { // 从左往右放
		// 			int cnt = s.firstEntry().getValue();
		// 			if (minQueue && x - cnt >= k || !minQueue && x - cnt >= k-1) {
		// 				t.put(s.firstEntry().getKey(), s.firstEntry().getValue());
		// 				s.remove(s.firstEntry().getKey());
		// 				x -= cnt;
		// 				y += cnt;
		// 			} else if (minQueue && x - cnt < k || !minQueue && x - cnt < k-1) {
		// 				f[i] = s.firstEntry().getKey();
		// 				break;
		// 			}
		// 		}
		// 		if (f[i] == -1) {
		// 			if (minQueue && x == k) f[i] = s.firstEntry().getKey();
		// 			else if (!minQueue && x == k-1) f[i] = t.firstEntry().getKey();
		// 		}
		// 		// 从右往左放
		// 		while (f[i] == -1 && (minQueue && x < k || !minQueue && x < k-1)) {
		// 			int cnt = t.firstEntry().getValue();
		// 			if (minQueue && x + cnt <= k || !minQueue && x + cnt <= k-1) {
		// 				s.put(t.firstEntry().getKey(), t.firstEntry().getValue());
		// 				t.remove(t.firstEntry().getKey());
		// 				x += cnt;
		// 				y -= cnt;
		// 			} else if (minQueue && x + cnt > k || !minQueue && x + cnt > k-1) {
		// 				f[i] = t.firstEntry().getKey();
		// 				break;
		// 			}
		// 		}
		// 		if (f[i] == -1) {
		// 			if (minQueue && x == k) f[i] = s.firstEntry().getKey();
		// 			else if (!minQueue && x == k-1) f[i] = t.firstEntry().getKey();
		// 		}
		// 	}
		// 	return f;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【离线处理】：这个 m[1,10^5] 可以离线处理，升序处理
		// // N[1,2000], M[1,10^5] 数组【XOR预处理】，效果极显著！！
		// // 两个思路：
		// // 一个：前几天，刚学，什么狗屁【从右往左】【从左往右】双端XOR 预处理？什么先只处理【从右往左】，求解同步处理【从左往右】，没想透彻。。
		// // 一个：XOR 最值线段树？亲爱的表哥的活宝妹，今天想试写这个，回想这个【最值、求和Sum 线段树】写写试试看
		// // 【线段树】：解决的是，实时更新数组，求和 Sum O(logN) 的问题，可是同步用到【数组片段 Seg XOR】吗？感觉，这里没有想透彻。。
		// // 感觉，上面，亲爱的表哥的活宝妹，还需要理解得再透彻一点儿。。。
        // class Range implements Comparable<Range> { // 【重要：】只有这样，才可以借助 TreeSet 等数据结构简单查询，就不用自己再写二分搜索了。。。
        //     public int l, r;
        //     public Range(int l, int r) {
        //         this.l = l;
        //         this.r = r;
        //     }
        //     @Override public int compareTo(Range other) { 
        //         return this.l != other.l ? this.l - other.l : this.r - other.r;
        //     }
        // }
        // TreeSet<Range> s = new TreeSet<>();
		// class Node {
		// 	int lo, hi, m;
		// 	// ll, rr; // low high, XOR-max, low-idx hi-idx
		// 	// TreeSet<Range>.... 越弄越复杂了。。
		// 	TreeSet<Range> s;
		// 	Node l, r;
		// 	public Node(int left, int right) {
		// 		lo = left; hi = right;
		// 		m = 0;
		// 		l = null; r = null;
		// 	}
		// }
		// public insert(Node r, int i) { // 想以，下标索引 idx 的形式，求【线段、片段、最大值 XOR】
		// 	if (r.lo == r.hi) {
		// 		r.m = f[r.lo]; // 想以，下标索引 idx 的形式，求【线段、片段、最大值 XOR】
		// 		r.s.add(new Range(i, i));
		// 		return ;
		// 	}
		// 	int mid = (r.lo + r.hi) / 2;
		// 	if (i <= mid)
		// 		insert(r.l, i);
		// 	else insert(r.r, i);
		// 	// 想以，下标索引 idx 的形式，求【线段、片段、最大值 XOR】
		// 	// 可是，如果，左、右、各出现一个同等最大值，要怎么办纪录呢。。
		// 	if (r.l.m == r.r.m) { // 左右最值、一样
		// 		// 左右最值，区间，左右端点连续吗？可以合并吗？
		// 		// 写到这里，亲爱的表哥的活宝妹，感觉，思路，可能想偏了，弄太复杂了，想其它思路。。。
		// 	}
		// 	if (r.l.m > r.r.m) {
		// 		r.m = r.l.m;
		// 		r.ll = r.l.ll;
		// 		r.rr = r.l.rr;
		// 	} else if (r.l.m > r.r.m) {
		// 	}
		// 	r.m = Math.max(r.l.m, r.r.m);
		// 	// if (r.l.rr + 1 == r.r.ll) {
		// 	// }
		// 	r.m = Math.max(r.m, r.l.m ^ r.r.m)
		// }
		// int [] f;
		// public int[] maximumSubarrayXor(int[] a, int[][] qs) {
		// 	int n = a.length, m = qs.length; this.f = a; 
		// 	int [] r = new int [n+1];
		// 	for (int i = 1; i <= n; i++) 
		// 		r[i] = r[i-1] ^ a[i-1];
		// 	System.out.println(Arrays.toString(r));
		// 	List<int []> l = new ArrayList<>();
		// 	for (int i = 0; i < m; i++) 
		// 		l.add(new int [] {i, qs[i][0], qs[i][1]});
		// 	Collections.sort(l, (x, y)-> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]); // 起止点，升序排列
		// 	int [] f = new int [m];
		// 	return new int [0];
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，解这些题目的难点，就是，【观察不到】那些规律。。若不是看它人分析，亲爱的表哥的活宝妹自己，想不出、找不到、找不出，那些规律来。。。
		// public int[] maximumSubarrayXor(int[] nums, int[][] q) {
		// 	int n = nums.length, m = q.length;
		// 	int [][] f = new int [n][n], a = new int [n][n];// a: max
		// 	// 预处理【初始化】
		// 	for (int i = n-1; i >= 0; i--) {
		// 		f[i][i] = nums[i];
		// 		a[i][i] = nums[i];
		// 		for (int j = i+1; j < n; j++) {
		// 			f[i][j] = f[i][j-1] ^ f[i+1][j]; 
		// 			a[i][j] = Math.max(f[i][j], Math.max(a[i+1][j], a[i][j-1]));
		// 		}
		// 	}
		// 	int [] r = new int [m];
		// 	for (int i = 0; i < m; i++) 
		// 		r[i] = a[q[i][0]][q[i][1]];
		// 	return r;
		// }


		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 数据规模狠小：感觉，亲爱的表哥的活宝妹，只要把思路想通，哪怕是弄个【dfs 记忆化深搜】都能过！！
		// // 【dfs 记忆化深搜】：这里的难点是，怎么定义、方便、好用的【记忆化、数据结构】？
		// // mask = 0; // 标记：【行、行的组合】Integer
		// // curSum: 标记，当前最大和值， Integer
		// // hsi 标记，当前用过的数字。。 Set<Integer> s = new HashSet<>();
		// class Node implements Comparable<Node> {
		// 	int i, j; // i: mask, j: sum
		// 	Set<Integer> s = new HashSet<>();
		// 	public Node(int i, int j, Set<Integer> s) {
		// 		this.i = i; this.j = j; this.s = s; 
  		//     }
		// 	@Override public int compareTo(Node other) { 
		// 		return this.j != other.j ? this.j - other.j : this.i - other.i;
		// 	}
		// }
		// public int maxScore(List<List<Integer>> lli) {
		// 	m = lli.size(); n = lli.get(0).size(); max = 0; this.lli = lli; 
		// 	for (List<Integer> l : lli) 
		// 		Collections.sort(l, (x, y)->y - x);
		// 	r = new int [m];
		// 	q = new PriorityQueue<>((x, y) -> lli.get(y).get(r[y]) - lli.get(x).get(r[x]));
		// 	for (int i = 0; i < m; i++) q.offer(i);
		// 	Set<Integer> s = new HashSet<>();
		// 	f = new HashMap<>();
		// 	int mask = 0; // 标记：【行、行的组合】Integer
		// 	int sum = 0;
		// 	// for (int i = 0; i < m; i++) {
		// 	while (!q.isEmpty()) {
		// 		int i = q.poll();
		// 		mask |= (1 << i);
		// 		sum += lli.get(i).get(r[i]);
		// 		s.add(lli.get(i).get(r[i]));
		// 		r[i]++;
		// 		dfs(new Node(mask, sum, s), r);
		// 		r[i]--;
		// 		mask ^= (1 << i);
		// 		sum -= lli.get(i).get(r[i]);
		// 		s.remove(lli.get(i).get(r[i]));
		// 		q.offer(i);
		// 	}
		// 	return max;
		// }
		// List<List<Integer>> lli = new ArrayList<>();
		// Map<Node, Integer> f;
		// int [] r;
		// Queue<Integer> q;
		// int m, n, max;
		// void dfs(Node ro, int [] r) {
		// 	if (f.containsKey(ro)) return; // f.get(ro);
		// 	int mask = ro.i, sum = ro.j;
		// 	Set<Integer> s = ro.s;
		// 	if (s.size() == m && mask == (1 << m)-1) {
		// 		max = Math.max(max, sum);
		// 		f.put(ro, sum);
		// 		return ;
		// 	}
		// 	// 优化：剪枝
		// 	// if (100 * )
		// 	// 暴力：全局最优解
		// 	// while (!q.isEmpty() && (mask >> q.peek() & 1) == 0)) {
		// 	int cur = sum;// 呵呵呵哈哈哈：亲爱的表哥的活宝妹，如同几年前写二叉树， dfs 深搜，自顶向下自底向上，两个方向又、双、写混杂了。。。
		// 	while (!q.isEmpty()) {
		// 		int i = q.poll();
		// 		// if (mask >> idx & 1 == 0)
		// 		mask |= (1 << i);
		// 		sum += lli.get(i).get(r[i]);
		// 		s.add(lli.get(i).get(r[i]));
		// 		r[i]++;
		// 		dfs(new Node(mask, sum, s), r);
		// 		r[i]--;
		// 		mask ^= (1 << i);
		// 		sum -= lli.get(i).get(r[i]);
		// 		s.remove(lli.get(i).get(r[i]));
		// 		q.offer(i);
		// 	}
		// 	// f.put(ro, )// 呵呵呵哈哈哈：亲爱的表哥的活宝妹，如同几年前写二叉树， dfs 深搜，自顶向下自底向上，两个方向又、双、写混杂了。。。
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，看了提示，感觉，就会写这个题目了
		// // 可是，这个题目的思路，亲爱的表哥的活宝妹，可能没有想透，先写其它2 个；晚点儿再回来写这个。。。
		// // 亲爱的表哥的活宝妹自己，也排序了，但是限制在排每行的序；只要整个数组排序，就可以，把它变成【一维、线性动规】就狠好解题目了。。。脑袋一根筋。。。
		// // 变型的【记忆化深搜】：定义【记忆数据结构】
		// // 亲爱的表哥的活宝妹，少分析了一个要求：数字不能重复。少考虑了一个因素 Set<Integer> s = new HashSet<>();
		// public int maxScore(List<List<Integer>> ll) {
		// 	m = ll.size(); n = ll.get(0).size(); kk = 0;
		// 	l = new ArrayList<int []>();
		// 	Set<Integer> s = new HashSet<>();
		// 	for (int i = 0; i < m; i++) {
		// 		s.clear();
		// 		for (int j = 0; j < n; j++) {
		// 			if (!s.contains(ll.get(i).get(j))) {
		// 				l.add(new int [] {i, ll.get(i).get(j)});
		// 				s.add(ll.get(i).get(j));
		// 				kk++;
		// 			}
		// 		}
		// 	}
		// 	Collections.sort(l, (x, y)-> x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]);
		// 	f = new HashMap[kk];
		// 	Arrays.fill(f, new HashMap<Integer, Integer>());
		// 	r = 0;
		// 	for (int i = 0; i < kk; i++) 
		// 		dfs(i, 0, -1);
		// 	return r; 
		// }
		// Map<Integer, Map<Integer, Integer>> [] f;// 状态没有定义对，存在【此错误状态下，多个子状态、全局最优解漏掉了】
		// // Map<Integer, Integer> [] f;// 状态没有定义对，存在【此错误状态下，多个子状态、全局最优解漏掉了】
		// List<int []> l;
		// int m, n, kk, r;
		// int dfs(int i, int j, int v) { // i: idx from l; j: mask; v: 前一个用过的最小数字
		// 	if (i == kk || j == ( 1 << m)-1)
		// 		return 0;
		// 	if (f[i].containsKey(j) && f[i].get(j).containsKey(v)) return f[i].get(j).get(v);
		// 	// // 【暴力】就容易【超时】；这里要想【优化】——尽早裁枝, 或是，使用，【贪心】思路，来缩短时间
		// 	// if (Integer.bitCount(j) >= m / 2 && )
		// 	int ans = 0;
		// 	// 【自头向尾】：单方向遍历，暴力所有可能性
		// 	int bgn = (((j >> l.get(i)[0]) & 1) == 1 ? i+1 : (v == -1 || l.get(i)[1] < v ? i : i+1));
		// 	for (int k = bgn; k < kk; k++) {
		// 		ans = Math.max(ans, (k == i ? l.get(i)[1] : 0) + dfs(k + (k == i ? 1 : 0), k == i ? j | (1 << l.get(i)[0]) : j, k == i ? l.get(i)[1] : v)); 
		// 		// // 【写错了】：裁枝要裁得精确，不能漏掉【全局最优解】
		// 		// int cnt = Math.min(m - Integer.bitCount(j), kk - k);
		// 		// // if (cnt * (cnt + 1) / 2 * l.get(k)[1] < r) break;
		// 		// if (v > 0 && cnt * (cnt + 1) / 2 * v < r) break;
		// 	}
		// 	Map<Integer, Integer> mm;
 		// 	if (!f[i].containsKey(j)) 
		// 		mm = new HashMap<Integer, Integer>();
		// 	else mm = f[i].get(j);
		// 	mm.put(v, ans);
		// 	r = Math.max(r, ans);
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这些，都是亲爱的表哥的活宝妹，思路没能想透时的。。。。
		// public long minDamage(int v, int [] d, int [] a) {
		// 	int n = d.length;
		// 	// Queue<int []> l = new PriorityQueue<>((x, y) -> x[0] != y[0] ? y[0] - x[0] : x[1] - y[1]);
		// 	Queue<int []> l = new PriorityQueue<>((x, y) -> -1 * Long.compare((long)x[0] * (long)(x[1] / v + (x[1] % v > 0 ? 1 : 0)), 
		// 	(long)y[0] * (long)(y[1] / v + (y[1] % v > 0 ? 1 : 0))));
		// 	long r = 0l, t = 0l, min = 0l;
		// 	for (int i = 0; i < n; i++) {
		// 		r += d[i]; // 总伤害
		// 		l.offer(new int [] {d[i], a[i]});
		// 		t += a[i] / v + (a[i] % v > 0 ? 1 : 0); // 总时间 
		// 	}
		// 	// 【动规】：倒序遍历
		// 	while (!l.isEmpty()) {
		// 		// 【贪心】地认为：两个武力最接近的邻居之间，可以取最优解。但这个思路，能保证总局，最小值吗？？？
		// 		int [] cur = l.poll(), top;
		// 		if (!l.isEmpty()) {
		// 			top = l.peek();
		// 			int ct = cur[1] / v + (cur[1] % v > 0 ? 1 : 0), tt = top[1] / v + (top[1] % v > 0 ? 1 : 0);
		// 			long ctt = r * ct + (r - cur[0]) * (t - ct);
		// 			long ttt = r * tt + (r - top[0]) * (t - tt);
		// 			// System.out.println("ctt: " + ctt + " " + "ttt: " + ttt);
		// 			if (ctt >= ttt) {
		// 				min += r * tt;
		// 				r -= top[0];
		// 				t -= tt;
		// 				l.poll(); // 把更大伤害的 top, 先杀掉
		// 				l.offer(cur);
		// 			} else {
		// 				min += r * ct;
		// 				r -= cur[0];
		// 				t -= ct;
		// 			}
		// 		} else {
		// 			int ct = cur[1] / v + (cur[1] % v > 0 ? 1 : 0);
		// 			min += r * ct;
		// 		}
		// 	}
		// 	return min;
		// }
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long minDamage(int v, int [] d, int [] h) {
		// 	int n = d.length;
		// 	int [][] f = new int [n][2];
		// 	for (int i = 0; i < n; i++) {
		// 		f[i][0] = (h[i] - 1) / v + 1;
		// 		f[i][1] = d[i];
		// 	}
		// 	Arrays.sort(f, (x, y) -> x[0] * y[1] - x[1] * y[0]); 
		// 	long s = 0l, r = 0l;
		// 	for (int [] fi : f) {
		// 		s += fi[0];
		// 		r += s * fi[1];
		// 	}
		// 	return r;
		// }

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		public long countGoodIntegers(int n, int k) {
// 			int [] f = new int [n+1]; // factorial
// 			f[0] = 1;
// 			for (int i = 1; i <= n; i++) 
// 				f[i] = f[i-1] * i;
// 			long ans = 0;
// 			int cur = 0;
// 			int base = (int)Math.pow(10, (n-1)/2);
// 			Set<String> si = new HashSet<>();
// 			int [] r = new int [10];
// // 枚举：这个范围内的所有的数字，一个一个数个数
// 			for (int i = base; i < 10 * base; i++) {
// 				String s = String.valueOf(i) + new StringBuilder(String.valueOf(i)).reverse().substring(n % 2).toString();
// 				// 【写错了】：下面，没排序 S 的话，是数得会有重复的！！
// 				// if (Long.parseLong(s) % k > 0 || !si.add(Long.parseLong(s))) // 这个数字，出现过了
// 				// 	continue;
// 				if (Long.parseLong(s) % k > 0) // 这个数字，出现过了
// 					continue;
// 				char [] sortedS = s.toCharArray();
// 				Arrays.sort(sortedS);
// 				// 【写错了】：
// 				// if (!si.add(sortedS.toString())) // 【TODO】：。。。
// 				if (!si.add(new String(sortedS)))
// 					continue;
// 				Arrays.fill(r, 0);
// 				for (char c : sortedS) 
// 					r[c-'0']++;
// 				cur = (n - r[0]) * f[n-1];
// 				for (int v : r) 
// 					cur /= f[v];
// 				ans += cur;
// 			}
// 			return ans;
// 		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public String convertDateToBinary(String S) {
		// 	String [] s = S.split("-", 3);
		// 	String [] t = new String [3];
		// 	StringBuilder sb = new StringBuilder();
		// 	for (int i = 0; i < 3; i++) {
		// 		t[i] = Integer.toBinaryString(Integer.parseInt(s[i]));
		// 		sb.append(t[i]);
		// 		if (i < 2)
		// 		sb.append("-");
		// 								}
		// 	return sb.toString();
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxPossibleScore(int [] a, int d) { // 684/685 passed 测试数据太大了，本地运行不了
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
		// 	boolean one = false;
		// 	for (int i = 1; i < n; i++) {
		// 		if (f[i-1] + v <= f[i] + d) {
		// 			f[i] = Math.max(f[i-1]+v, f[i]);
		// 			if (f[i] == f[i-1]+v && !one)
		// 				one = true;
		// 		} else return false;
		// 	}
		// 	return one;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // N:[1,10^5] a[i]:[1,10^5]
		// // 数据规模比较大，亲爱的表哥的活宝妹，不知道，怎么想这个题目。。。
		// public long findMaximumScore(List<Integer> l) {
		// 	int n = l.size();
		// 	long [] f = new long [n];
		// 	// long [] r = new long [n];
		// 	// for (int i = n-2; i >= 0; i--) {
		// 	// 	r[i] = 				
		// 	// }
		// 	f[1] = l.get(0);
		// 	for (int i = 2; i < n; i++) {
		// 		f[i] = Math.max(f[i-1] + l.get(i-1), b)
		// 	}
		// 	return 0;
		// }

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 亲爱的表哥的活宝妹，觉得，这类题目写狠多，这个题目，像是不太难的样子_???
		// 当马每移动一次，都需要再动态更新，最大最小。。！！！
		// 怎么会只有 29% Hard ？数据规模，倒是不大
		// 先写【暴力方法】：遍历所有可能性，TLE 才再去想其它解法。。
		// 亲爱的表哥的活宝妹，今天下午不想再写了、、晚点儿、晚一两天才再写这几个破烂题目。。。
		int [][] dirs = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
						 {2, -1}, {2, 1}, {1, -2}, {1, 2}};
		public int maxMoves(int kx, int ky, int[][] a) {
			n = 50; m = a.length;
			int i = 0;
			for (int [] v : a) l.add(new int [] {v[0], v[1], i++});
			l.add(new int [] {kx, ky, i});
			f = new Integer [m+1][2];
			g = new Integer [n][n][m];
			vis = new boolean [m];
			v = new boolean [n][n];
			return dfs(m, 0);
		}
		List<int []> l = new ArrayList<>();
// 记：每个小兵，到其它所有小兵的【最大距离、最小距离】的小兵号
		// 记：奇偶 player 的最佳得分。。
		Integer [][] f; 
		Integer [][][] g; 
		int m, n;
		boolean [] vis;
		boolean [][] v;
		int dfs(int i, int j) {
			if (j == m) return 0;
			if (f[i][j%2] != null) return f[i][j%2];
			int r = (j % 2  == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
			if (j % 2 == 0) { // 求最大值
				for (int k = 0; k < m; k++) {
					if (vis[k]) continue;
					vis[k] = true;
					int v = ddfs(l.get(i)[0], l.get(i)[1], k);
					System.out.println("v: " + v);
					if (v <= 0) continue;
					// r = Math.max(r, ddfs(l.get(i)[0], l.get(i)[1], k) + dfs(k, j++));
					r = Math.max(r, v + dfs(k, j++));
					System.out.println("r0: " + r);
					vis[k] = false;
				}
			} else { // 求最小值
				for (int k = 0; k < m; k++) {
					if (vis[k]) continue;
					vis[k] = true;
					r = Math.min(r, ddfs(l.get(i)[0], l.get(i)[1], k) + dfs(k, j++));
					vis[k] = false;
				}
			}
			System.out.println("r: " + r);
			return f[i][j%2] = r;
		}
		// 马[x,y]到，小兵 i的，[最少步数】。感觉，这步，或可以优化，预处理＋动态更新、之类的
		int ddfs(int x, int y, int idx) {
			// System.out.println("x: " + x + " " + "y: " + y);
			// System.out.println("l.get(idx)[0]: " + l.get(idx)[0] + " " + "l.get(idx)[1]: " + l.get(idx)[1]);
			if (x < 0 || x >= n || y < 0 || y >= n || v[x][y]) return Integer.MAX_VALUE;
			if (x == l.get(idx)[0] && y == l.get(idx)[1]) return 0;
			if (g[x][y][idx] != null) return g[x][y][idx];
			v[x][y] = true;
			int r = Integer.MAX_VALUE / 2;
			for (int [] d : dirs)
				r = Math.min(r, 1 + ddfs(x + d[0], y + d[1], idx));
			v[x][y] = false;
			return g[x][y][idx] = r;
		}
 	} 
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		int [][] a = new int [][] {{0,0}};

		int r = s.maxMoves(1, 1, a);
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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