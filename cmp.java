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
		// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】

		// // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目狠简单：就是从右往左，在 m 条 m 个有序链表里，从尾往前移
		// public long maxSpending(int[][] a) {
		// 	int m = a.length, n = a[0].length;
		// 	int [] r = new int [m];
		// 	Arrays.fill(r, n-1);
		// 	System.out.println(Arrays.toString(r));
		// 	Queue<Integer> q = new PriorityQueue<>((x, y)->a[x][r[x]] - a[y][r[y]]);
		// 	for (int i = 0; i < m; i++)
		// 		q.offer(i);
		// 	long ans = 0; int t = 1;
		// 	for (int i = 0; i < m*n; i++) {
		// 		System.out.println("\n i: " + i);
		// 		int j = q.poll(); // m 行的下标
		// 		// System.out.println("j: " + j);
		// 		// System.out.println("a[j][r[j]]: " + a[j][r[j]]);
		// 		ans += (long)a[j][r[j]] * t;
		// 		t++;
		// 		r[j]--;
		// 		if (r[j] >= 0)
		// 			q.offer(j); // 这里，应该会触发优先队列重新排序
		// 	}
		// 	return ans;
		// }

		// // 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int distributeCandies(int n, int k) {// k: limit: 排列组合题，讨厌这个题目，不写这个了。。
		// 	int [][] f = new int [3][k+1];
		// 	int [][] r = new int [3][k+1]; // 先前的累积和
		// 	for (int j = 0; j <= Math.min(n, k); j++) {
		// 		f[0][j] = j;
		// 		r[0][j] = j;
        //     }
		// 	for (int i = 1; i < 3; i++) {
		// 		System.out.println("i: " + i);
		// 		// System.out.println("Math.min(n-r[i-1][j], k): " + Math.min(n-r[i-1][j], k));
		// 		for (int j = 0; j <= Math.min(n-r[i-1][j], k); j++) {
		// 			f[i][j] = j;
		// 			r[i][j] = r[i-1][j] + j;
		// 		}
		// 	}
		// 	int ans = 0;
		// 	for (int i = 0; i <= k; i++)
		// 		ans += f[i][0] * f[i][1] * f[i][2];
		// 	return ans;
		// }
// 早上懒得写上面的题

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maximumStrongPairXor(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int i = 0; i < n; i++)
		// 		for (int j = 0; j < n; j++)
		// 			if (Math.abs(a[i] - a[j]) <= Math.min(a[i], a[j]))
		// 				r = Math.max(r, a[i] ^ a[j]);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public List<String> findHighAccessEmployees(List<List<String>> lli) {
		// 	List<String> r = new ArrayList<>();			
		// 	Map<String, List<String>> m = new HashMap<>();
		// 	for (List<String>  l : lli) 
		// 		m.computeIfAbsent(l.get(0), z -> new ArrayList<>()).add(l.get(1));
		// 	for (Map.Entry<String, List<String>> en : m.entrySet()) {
		// 		String k = en.getKey();
		// 		List<String> v = en.getValue();
		// 		if (v.size() < 3) continue;
		// 		Collections.sort(v);
		// 		boolean valid = false;
		// 		for (int j = 1; j+1 < v.size(); j++) {
		// 			if (valid(v.get(j-1), v.get(j)) && valid(v.get(j), v.get(j+1)) && valid(v.get(j-1), v.get(j+1))) {
		// 				valid = true;
		// 				break;
		// 			}
		// 		}
		// 		if (valid) r.add(k);
		// 	}
		// 	return r;
		// } // 感觉，写这种乱题目，是浪费亲爱的表哥的活宝妹的生命！！
		// boolean valid(String s, String t) {
		// 	int ha = Integer.parseInt(s.substring(0,2)), hb = Integer.parseInt(t.substring(0,2));
		// 	int x = ha * 60 + Integer.parseInt(s.substring(2));
		// 	int y = hb * 60 + Integer.parseInt(t.substring(2));
		// 	return y - x < 60 && (ha != 23 || hb != 00);
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minOperations(int[] a, int[] b) {
		// 	int m = a.length, n = b.length;
		// }

// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		public int maximumStrongPairXor(int[] a) { // 二分查找，O(NlogN)
// 			int n = a.length;
// 			for (int v : a) {
// 				for (int j = 0; j < 20; j++) 
// 					if (((v >> j) & 1) == 1)
// 						m.computeIfAbsent(j, z -> new HashSet<>()).add(v);
// 			int l = 1, r = (int)(Math.pow(2, 20)-1), max = 0;
// 			for (int v : a) s.add(v);
// 			while (l <= r) {
// 				int m = l + (r - l) / 2;
// 				if (valid(m, a)) {
// 					max = Math.max(max, m);
// 					l = m+1;
// 				} else r = m-1;
// 			}
// 			return max;
// 		}
// 		Set<Integer> s = new HashSet<>();
// 		Map<Integer, Set<Integer>> m = new HashMap<>(); // 记每个位，存在的数，还是多 
// 		// 这个方法，要写得巧一点儿：就是遍历 v 的所有的数位, 那么这个题目就成了，选课I II 题型。。可是亲爱的表哥的活宝妹，忘记细节了。。
// 		// 选课题是：一个学期最多选几个学分，20 个数位里，哪些组合，出有效存在数，如何巧妙遍历等
// // 这个方法太复杂了，今天晚上不想写这个了：前面某个两根梯子支撑什么的题型，亲爱的表哥的活宝妹，要怎么才能写出那么所有数位的所有可能的数值？？
// 		boolean valid(int v, int [] a) { // 先把前面的题目，至少得解决一个掉，再想这个相对难一点儿的
// 			for (int i = 0; i < 20; i++) { // 这么遍历的规模还是太大了，感觉。。
// 				if (((v >> i) & 1) == 1) {
// 					for (int j : m.get(i)) {
// 						if ()
// 					}
// 				}
// 			}
// 			// for (int i = v; i >= 0; i = (i & (i-1))) { // 没有考虑，可能存在相同位的情况: 所以还要考虑，所有补位（20-bitCnt）位中，所有可能情况，两数同时存在的情况。。
// 			// 	if (s.contains(i) && s.contains(v ^ i) && Math.abs(v-(v^i)) <= Math.min(v, v^i)) return true;
// 			// 	for (int j = 0; j < 20; j++) {
// 			// 		if (r[j] > 0) continue;
// 			// 	}
// 			return false;
// 		}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int findMinimumOperations(String s, String t, String o) {
		// 	if (s.length() == 1 && t.length() == 1 && o.length() == 1 && s.charAt(0) == t.charAt(0) && t.charAt(0) == o.charAt(0)) return 0;
		// 	if (!s.substring(0,1).equals(t.substring(0, 1)) || !t.substring(0, 1).equals(o.substring(0, 1))) return -1;
		// 	int m = s.length(), n = t.length(), x = o.length();
		// 	int i = 0, min = Math.min(m, Math.min(n, x));
		// 	while (i < min) {
		// 		if (s.charAt(i) != t.charAt(i) || t.charAt(i) != o.charAt(i)) break;
		// 		i++;
		// 	}
		// 	return s.length() - i + t.length() -i + o.length()-i;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 从右往左遍历，是个暴力死计算题。。。
		// public long minimumSteps(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	ArrayDeque<Integer> q = new ArrayDeque<>(); // 升序排列
		// 	int i = n-1;
		// 	long r = 0;
		// 	while (i > -1 && s[i] == '1') i--;
		// 	if (i < 0) return 0;
		// 	while (i > -1) {
		// 		// 这里，认为， s[i]=0
		// 		while (i > -1 && s[i]-'0' == 0) {
		// 			q.offerFirst(i); // 从头，从左边添加
		// 			i--;
		// 		}
		// 		if (i < 0) return r;
		// 		if (s[i] == '1' && !q.isEmpty()) {
		// 			r += (long)(q.pollLast() - i);
		// 			q.offerFirst(i);
		// 		}
		// 		i--;
		// 	}
		// 	return r;
		// }

// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 这个题目狠简单，感觉暴力遍历所有可能性都是可以的? n=[0,50]
// 		// 找两个数的 most-significant 位的下标
// 		static final int mod = (int)1e9 + 7; 
// 		public int maximumXorProduct(long a, long b, int idx) {
// 			int m = 64 - Long.numberOfLeadingZeros(a), n = 64 - Long.numberOfLeadingZeros(b);
// 			System.out.println("m: " + m);
// 			System.out.println("n: " + n);
// 			int [] r = new int [50];
// 			long base = 0l, mask = 0l; // mask 不能要
// 			for (int i = 49; i >= 0; i--) {// fd
// 				if (((a >> i) & 1) == 1 && ((b >> i) & 1) == 1)
// 					// r[i] = 1;
// 					mask |= (1 << i);
// 				else if (((a >> i) & 1) + ((b >> i) & 1) == 1) // 两个数这个位上不同
// 					r[i] = 1;
// 				// else if (idx > i) // 这个位上可以有1: 但是这不一定是最优解，它还需要把 ab 聚合收敛，以便乘积最大
// 				else if (idx > i && (i >= Math.max(m, n) || ((a >> i) & 1) == 0 && ((b >> i) & 1) == 0)) // 这个位上可以有1: 但是这不一定是最优解，它还需要把 ab 聚合收敛，以便乘积最大
// 					base += (long)(1 << i);
// 			}
// 			int o = Arrays.stream(r).sum();// 想把它收敛一下，遍历所有（1<o）种可能性，可是会超时。。
// // 感觉，这里最差情况 o=50, 除非是暴力，再从右往左数多少个位强制为1, 亲爱的表哥的活宝妹，这会儿想不出来了，改天再写
// 			return (int)((base ^ a) * (base ^ b) % mod);
// 		}

// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		public List<Integer> findWordsContaining(String[] words, char x) {
// 			List<Integer> l = new ArrayList<>();
// 			for (int i = 0; i < words.length; i++) 
// 				if (words[i].indexOf(x) != -1)
// 					l.add(i);
// 			return l;
// 		}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumCoins(int[] a) { // 这不是，【记忆化深搜】吗？
		// 	n = a.length; this.a = a; 
		// 	f = new Integer [n][n];
		// 	return dfs(0, -1);
		// }
		// Integer [][] f; int [] a;
		// int n;
		// int dfs(int i, int j) { // j: previous Paid idx
		// 	if (i >= n) return 0;
		// 	if (j > -1 && f[i][j] != null) return f[i][j];
		// 	int r = Integer.MAX_VALUE;
		// 	r = a[i] + dfs(i+1, i);// pay for ith item
		// 	if (j == -1 || i > j + j + 1) { // have to pay for this item
		// 		if (j > -1) f[i][j] = r;
		// 		return r;
		// 	}
		// 	for (int k = i; k <= j + j + 1 && k < n; k++) 
		// 		r = Math.min(r, Math.min(dfs(i+1, j), a[i] + dfs(i+1, i)));
		// 	if (j > -1) f[i][j] = r;
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 有点儿像【区间型动规】，可是感觉没有思路。先滚回去写那个烦死人不偿命的。。		
		// public int findMaximumLength(int[] nums) {
		// }
		
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这是个，什么把二维数组上的最大区间和，转化为一维最大区间和，之类的题型。。
		// public int maximizeSquareHoleArea(int n, int m, int[] a, int[] b) {
		// 	int x = a.length, y = b.length, ans = 0;
		// 	int [] r = new int [x+2], c = new int [y+2];
		// 	r[0] = 1; r[x+1] = n+2;
		// 	c[0] = 1; c[y+1] = m+2;
		// 	// // 这个死题狠怪异，倒序排列，要求先去除后面的。。可是题目没有说清楚。所以题目比较坑人。。。
		// 	// Arrays.sort(a); Arrays.sort(b);
		// 	for (int i = 0; i < a.length; i++) r[i+1] = a[i]; // 复制过去
		// 	for (int i = 0; i < b.length; i++) c[i+1] = b[i];
		// 	System.out.println(Arrays.toString(r));
		// 	System.out.println(Arrays.toString(c));
		// 	// 遍历：一个维度上的。对这个维度上的每个可能取值，遍历另一维度上的所有可能性
		// 	TreeMap<Integer, Integer> t = new TreeMap<>();
		// 	t.put(r[0], 0);
		// 	int one = 0;
		// 	for (int i = 1; i < x+2; i++) {
		// 		for (Map.Entry<Integer, Integer> en : t.entrySet()) {
		// 			int k = en.getKey(), v = en.getValue();
		// 			one = r[i] - k;
		// 			if (one < 0) continue;
		// 			System.out.println("\n one: " + one);
		// 			if (one * one > ans) { // 在比先前的解，可能会优的前提下，才检查有效性. 横边一定有效，只检查竖边
		// 				// 同样的方式遍历竖边，是否存在一组可能的和为 one 边长的
		// 				if (valid(one, c)) {// 找到的第一个有效值，一定当前下标 i下，最优
		// 					ans = one * one;
		// 					System.out.println("ans: " + ans);
		// 					found = true;
		// 					break;
		// 				}
		// 			}
		// 		}
		// 		t.put(r[i], i); // 把当前横边点加进去
		// 	}
		// 	return ans;
		// }
		// boolean valid(int v, int [] r) {
		// 	int n = r.length;
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	m.put(r[0], 0);
		// 	for (int i = 1; i < n; i++) {
		// 		if (m.containsKey(r[i] - v)) return true;
		// 		m.put(r[i], i);
		// 	}
		// 	return false;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，讨厌这个恶心死人不偿命的题目。。。这个思路不太对，讨厌今天的恶心死人不偿命的题目，今天晚上的跳过不写了
		// public boolean areSimilar(int[][] a, int k) {
		// 	int m = a.length, n = a[0].length;
		// 	k = k % n; this.k = k; 
		// 	if (n == 1 || k == 0) return true;
		// 	if (n % k != 0 && k != 1) return false;
		// 	o = n / k;
		// 	for (int i = 0; i < m; i++)
		// 		if (!kEleSubs(a[i])) return false;
		// 	return true;
		// }
		// int k, o;
		// boolean kEleSubs(int [] a) {
		// 	for (int i = 0; i < k; i++) {
		// 		int v = a[i];
		// 		for (int j = 1; j < o; j++)
		// 			if (a[i + k * j] != a[i]) return false;
		// 	}
		// 	return true;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int beautifulSubstrings(String t, int k) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	List<Integer> l = new ArrayList<>();
		// 	Set<Character> s = new HashSet<>(List.Of('a', 'e', 'i', 'o', 'u'));
		// 	for (int i = 0; i < n; i++)
		// 		if (s.contains(s[i])) l.add(i);
		// 	// 然后就是扫这个链条。今天的题目太恶心人了，不想写了
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public List<Integer> findPeaks(int[] a) {
		// 	int n = a.length;
		// 	List<Integer> r = new ArrayList<>();
		// 	for (int i = 1; i < n-1; i++) 
		// 		if (a[i] > a[i-1] && a[i] > a[i+1])
		// 			r.add(i);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 看懂这个题目的提示思路了，可是还是不知道排序后，怎么算出各种和。。。
		// public int minimumAddedCoins(int[] a, int k) {
		// 	n = a.length; this.a = a; this.k = k; 
		// 	Arrays.sort(a);
		// }
		// int [] a;
		// int n, k;
		// int binarySearch(int v) {// 有重复
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 不喜欢最后一题，不是程序员的题目。。亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int numberOfSequence(int n, int[] sick) {
		// }

// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		public int countCompleteSubstrings(String t, int v) {
// 			int n = t.length(); char [] s = t.toCharArray();
// 			int ans = 0, j = 0; // j: left i: right
// 			Map<Character, Integer> m = new HashMap<>(); // 统计频率
// 			int dif;
// 			Queue<int []> q = new PriorityQueue<>((x, y) -> y[0] - x[0]); // 最大堆 [dif, idx]
// 			boolean valid = true;
// 			for (int k = 1; k <= 26 && k * v <= n; k++) { // 26 种可能的片段长度
// 				q.clear();
// 				m.clear();
// 				j = 0;
// 				for (int i = 0; i < n; i++) { // 亲爱的表哥的活宝妹，快要忘记，【滑动窗口】题型，是怎么滑的了。。。
// 					if (i > 0) {// dif:
// 						dif = Math.abs(s[i] - s[i-1]);
// 						while (!q.isEmpty() && q.peek()[1] <= i - v * k) q.poll();// 扔出所有不合法——非本窗口的最大值 
// 						q.offer(new int [] {dif, i});
// 					}
// 					m.put(s[i], m.getOrDefault(s[i], 0) + 1);
// 					if (i - j > v * k -1) {
// 						m.put(s[j], m.get(s[j])-1);
// 						if (m.get(s[j]) == 0)
// 							m.remove(s[j]);
// 						++j;
// 					}
// 					if (i - j == v * k-1 && m.size() == k) {
// 						valid = true;
// 						for (int val : m.values()) // 这也是一个循环呀。。。昨天晚上就没想明白，大肉肥油蒙了脑袋。。。
// 							if (val != v) {
// 								valid = false;
// 								break; // 这里仍会执行下面的 while 呀。。
// // 亲爱的表哥的活宝妹，昨天傍晚吃了三根排骨炒葫萝卜，太油腻，昨天晚上的脑袋不转，今天早上还多睡了1.5 小时... 大肉好吃，可是也会慢性杀人。。。
// 							}
// 						while (!q.isEmpty() && q.peek()[1] <= i - v * k + 1) q.poll();// 扔出所有不合法——非本窗口的最大值 
// 						if (valid && (q.isEmpty() || q.peek()[0] <= 2)) 
// 							ans++;
// 					}
// 				}
// 			}
// 			return ans;
// 		}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int[] findIntersectionValues(int[] a, int[] b) {
		// 	int m = a.length, n = b.length;
		// 	Set<Integer> sa = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
		// 	Set<Integer> sb = new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList()));
		// 	int [] r = new int [2];
		// 	for (int i = 0; i < m; i++) 
		// 		if (sb.contains(a[i])) r[0]++;
		// 	for (int i = 0; i < n; i++) 
		// 		if (sa.contains(b[i])) r[1]++;
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int removeAlmostEqualCharacters(String t) {
		// 	int n = t.length(), r = 0; char [] s = t.toCharArray();
		// 	int [][] f = new int [n][2];
		// 	Arrays.stream(f).forEach(z -> Arrays.fill(z, n));
		// 	f[0][0] = 0;
		// 	f[0][1] = 1;
		// 	for (int i = 1; i < n; i++) {
		// 		System.out.println("\n i: " + i);
		// 		r = Math.abs(s[i] - s[i-1]); // 这里，前一个字符是，可能变化了的！！
		// 		System.out.println("r: " + r);
		// 		// f[i][0] = f[i-1][0] + (r < 2 ? 1 : 0)
		// 		if (r < 2) {
		// 			// i-1, i: 一定至少有一个要变
		// 			f[i][0] = Math.min(f[i][0], f[i-1][1]);
		// 			f[i][1] = Math.min(f[i][1], Math.min(f[i-1][0], f[i-1][1]) + 1);
		// 		} else { // >= 2
		// 			f[i][0] = Math.min(f[i-1][0], f[i-1][1]);
		// 			f[i][1] = Math.min(f[i-1][0], f[i-1][1]) + 1;
		// 		}
		// 	}
		// 	return Math.min(f[n-1][0], f[n-1][1]);
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 最短距离题。今天不写这个题型了，改天这个题型也好好，如昨天晚上写【滑动窗口】般写一遍！！亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int numberOfSets(int n, int maxDistance, int[][] roads) {}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 不想再写这个题目了，瓣得好烦人。。。就是感觉思路是清晰透彻的，可是爱吃大肉的亲爱的表哥的活宝妹，昨天傍晚、今天中午吃了大肉，就是瓣不清楚呀。。呜呜呜。。。
		// public int maxSubarrayLength(int[] a, int k) {
		// 	int n = a.length, ans = 1, j = 0; // j: right
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	for (int i = -1; i + ans <= n; i++) { // 遍历左端点；但是右端点J ，对所有的 i 仅自左向右遍历一次. 遍历到只可能＝最长长度，就可以停止了
		// 		System.out.println("\n i: " + i);
		// 		if (i >= 0 && i <= j) // 不需要清除：就是 m 可能有 (a[i], 0) 条目
		// 			m.put(a[i], m.get(a[i]) -1);
		// 		System.out.println("j 0: " + j);
		// 		while (j < n && m.getOrDefault(a[j], 0) + 1 <= k) {
		// 			m.put(a[j], m.getOrDefault(a[j], 0) + 1);
		// 			j++;
		// 		}
		// 		System.out.println("j: " + j);
		// 		ans = Math.max(ans, j-i-(j == n ? 1 : 0));
		// 		System.out.println("ans: " + ans);
		// 		if (j < n) {
		// 			m.put(a[j], m.get(a[j])-1);
		// 			--j;
		// 		}
		// 	}
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int countTestedDevices(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		if (a[i] <= 0) continue;
		// 		r++;
		// 		for (int j = i+1; j < n; j++) {
		// 			if (a[j] == 0) continue;
		// 			a[j]--;
		// 		}
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public List<Integer> getGoodIndices(int[][] arr, int target) {
		// 	int n = arr.length, i = 0;
		// 	List<Integer> l = new ArrayList<>();
		// 	for (int [] v : arr) {
		// 		int a = v[0], b = v[1], c = v[2], d = v[3];
		// 		if (fastPowModM(fastPowModM(a, b, 10), c, d) == target)
		// 			l.add(i);
		// 		i++;
		// 	}
		// 	return l;
		// }
		// int fastPowModM(int base, int p, int mod) { // x^y%m: 先前有个快速幂，这里忘记了
		// 	long r = 1l;
		// 	while (p > 0) {
		// 		if (p % 2 == 1) 
		// 			r = r * base % mod;
		// 		base = base * base % mod;
		// 		p >>= 1;
		// 	}
		// 	return (int)r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public long countSubarrays(int[] a, int k) {
		// 	int n = a.length, max = Arrays.stream(a).max().getAsInt();
		// 	List<Integer> l = new ArrayList<>();
		// 	for (int i = 0; i < n; i++) 
		// 		if (a[i] == max) l.add(i);
		// 	if (l.size() < k) return 0;
		// 	int j = 0, m = l.size();
		// 	long r = 0;
		// 	for (int i = k-1; i < m; i++) {
		// 		r += (long)((i == m-1 ? n : l.get(i+1)) - l.get(i)) * (l.get(j) == 0 ? 1 : l.get(j)+1);
		// 		j++;
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int numberOfGoodPartitions(int[] a) {
		// 	int n = a.length;
		// 	Map<Integer, int []> m = new HashMap<>();
		// 	for (int i = 0; i < n; i++) {
		// 		int [] r = new int [] {-1, -1};
		// 		if (m.containsKey(a[i]))
		// 			r = m.get(a[i]);
		// 		if (r[0] == -1) r[0] = i;
		// 		else r[1] = i;
		// 		m.put(a[i], r);
		// 	}
		// 	// System.out.println("m.size(): " + m.size());
		// 	// for (Map.Entry<Integer, int []> en : m.entrySet()) {
		// 	// 	System.out.print(en.getKey() + ": ");
		// 	// 	System.out.println(Arrays.toString(en.getValue()));
		// 	// }
		// 	// 然后，应该是个什么【动规】的思路，可是今天不想再写这些题目了，今天写得太多了。。。
		// 	return 0;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int[] findMissingAndRepeatedValues(int[][] a) {
		// 	int n = a.length;
		// 	int [] r = new int [n * n + 1];
		// 	for (int [] b : a) 
		// 		for (int v : b) 
		// 			r[v]++;
		// 	int [] ans = new int [2];
		// 	Arrays.fill(ans, -1);
		// 	for (int i = 1; i <= n * n; i++) {
		// 		if (r[i] == 2) ans[0] = i;
		// 		else if (r[i] == 0) ans[1] = i;
		// 		if (ans[0] != -1 && ans[1] != -1) return ans;
		// 	}
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int[][] divideArray(int[] a, int k) {
		// 	int n = a.length, j = 0;
		// 	if (n % 3 != 0) return new int [0][];
		// 	int [][] r = new int [n/3][3];
		// 	TreeMap<Integer, Integer> m = new TreeMap<>(); // 按键升序排列
		// 	for (int v : a) 
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	j = 0;
		// 	for (Map.Entry<Integer, Integer> en : m.entrySet()) {
		// 		int key = en.getKey(), val = en.getValue();
		// 		if (j-1 >= 0 && j % 3 > 0 && key - r[(j-1)/3][0] > k) {
		// 			System.out.println("key: " + key);
		// 			return new int [0][];
		// 		}
		// 		while (val > 0) {
		// 			r[j/3][j%3] = key;
		// 			++j;
		// 			--val;
		// 		}
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，不喜欢这个题目，先写后面更好玩儿的题目
		// public long minimumCost(int[] a) {
		// 	int n = a.length, max = Arrays.stream(a).max().getAsInt();
		// 	long sum = 0;
		// 	for (int v : a) sum += (long)v;
		// 	// to MIN(abx * n - sum) find a abx
		// 	int bot = (int)(sum / n), top = bot + 1;
		// 	return 0l;
		// }
		// int nextP(int v) { // 127 ==> 131
		// }
		// int belowP(int v) { // 139 ==> 131; 107 ==> 101; 100 ==> 99 10 ==> 9
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maxFrequencyScore(int[] a, long k) {
		// 	n = a.length; 
		// 	Arrays.sort(a); this.a = a; this.k = k;
		// 	r = new long [n+1];
		// 	for (int i = 1; i <= n; i++) r[i] = r[i-1] + (long)a[i-1];
		// 	return binarySearch(1, n);
		// }
		// int [] a; long k; int n;
		// long [] r;
		// int binarySearch(int l, int r) { // 排序数组中，最多 K 次，搜索：能够使各元素相同的最长子片段的，长度
		// 	int ans = 1;
		// 	while (l <= r) {
		// 		int m = l + (r-l) / 2;
		// 		if (valid(m)) { 
		// 			ans = Math.max(ans, m)
		// 			l = m + 1; 
		// 		} else r = m-1;
		// 	}
		// 	return ans;
		// }
		// boolean valid(int l) { // 在排序数组 a 中，找一个长度为 l 的子片段，满足最多K 次，各元素可以相等
		// 	long r = 0; // curr cnts
		// 	for (int i = 0; i < n; i++) {
		// 		// 亲爱的表哥的活宝妹，昨天晚上又被亲爱的表哥的活宝妹住处的、楼上楼下贱鸡、贱畜牲、
		// 		// 破烂猪皮肥肉、千斤器嚣鼎、万斤秤砣之流的死肥猪、猪八戒、贱鸡、贱畜牲
		// 		// 之流的一再、故意、恶意、吵了一夜，亲爱的表哥的活宝妹的脑袋，现在就是糊糊想不清楚。。。傍晚再回来写这一两个题目
		// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 	}
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public long largestPerimeter(int[] a) {
		// 	int n = a.length;
		// 	Arrays.sort(a);
		// 	long [] r = new long [n+1];
		// 	long ans = -1;
		// 	for (int i = 1; i <= n; i++) r[i] = r[i-1] + (long)a[i-1];
		// 	for (int i = 2; i < n; i++) 
		// 		if ((long)a[i] < r[i]) ans = Math.max(ans, r[i+1]);
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个题目，相对好写，亲爱的表哥的活宝妹，可以努力把它瓣出来。。【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目根本不难，就是睡眠不民的亲爱的表哥的活宝妹，在无数小细节上耽误了不少时间。。亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public long [] placedCoins(int[][] egs, int[] a) {
		// 	n = a.length; this.a = a; 
		// 	g = new ArrayList[n];
		// 	Arrays.setAll(g, z -> new ArrayList<Integer>());
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1];
		// 		g[u].add(v);
		// 		g[v].add(u);
		// 	 }
		// 	f = new int [n][6]; //[3]: childCnts 累计计算
		// 	r = new long [n];
		// 	dfs(0, -1); // 亲爱的表哥的活宝妹，不知道这里、哪里细节写错了。。。
		// 	return r;
		// }
		// List<Integer> [] g;
		// int [][] f;
		// long [] r;
		// int n; int [] a;
		// void dfs(int u, int p) { // 【树状动规】：一边遍历，一边填充【f】动规数组，和答案 r[]
		// 	int childCnts = 0;
		// 	if (a[u] > 0) f[u][0] = a[u]; // 比较：取最大3 个数（正或负），或最小 2 个负数
		// 	else f[u][4] = a[u]; // (a[u] < 0)
		// 	f[u][5]++;
		// 	for (int v : g[u]) {
		// 		if (v == p) continue;
		// 		dfs(v, u); // <<<<<<<<<<<<<<<<<<<< 先遍历子节点，再比较
		// 		f[u][5] = f[u][5] + f[v][5];
		// 		// 比较：取最大3 个数（正或负），或最小 2 个负数: 这里不对，不仅只【直接子节点】，还包括所有子节点的所有可能的子节点。。。
		// 		int min = Math.min(f[u][4], f[v][4]);
		// 		int minSec = Math.min(Math.min(f[u][3], f[v][3]), Math.max(f[u][4], f[v][4]));
		// 		f[u][4] = min;
		// 		f[u][3] = minSec;
		// 		int max = Math.max(f[u][0], f[v][0]);
		// 		minSec = Math.max(Math.max(f[u][1], f[v][1]), Math.min(f[u][0], f[v][0])); // 中间大的
		// 		f[u][2] = getThirdMax(f[u][0], f[u][1], f[u][2], f[v][0], f[v][1], f[v][2]);
		// 		f[u][0] = max;
		// 		f[u][1] = minSec;
		// 		System.out.println(Arrays.toString(f[u]));
		// 	}
		// 	if (f[u][5] < 3) 
		// 		r[u] = 1;
		// 	else {
		// 		long max = (long)f[u][4] * (long)f[u][3] * (long)f[u][0];
		// 		long pos = (long)f[u][1] * (long)f[u][2] * (long)f[u][0];
		// 		if (pos >= max)
		// 			r[u] = pos;
		// 		else r[u] = max;
		// 	}
		// }
		// int getThirdMax(int a, int b, int c, int x, int y, int z) {
		// 	int max = Math.max(a, x);
		// 	int mid = Math.max(Math.max(b, y), Math.min(a, x)); 
		// 	int r = 0;
		// 	if (max == a) {
		// 		if (mid == b)
		// 			r = Math.max(c, x); 
		// 		else // mid = x
		// 			r = Math.max(b, y);
		// 	} else { // max = x
		// 		if (mid == y)
		// 			r = Math.max(z, a);
		// 		else // mid == a
		// 			r = Math.max(b, y);
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，不喜欢这个题目，最后才写
		// public int incremovableSubarrayCount(int[] a) {
		// 	int n = a.length;
		// 	return 0;
		// }

// 亲爱的表哥的活宝妹，每个周六只瓣出一个相对难题，就算进步呀。。亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，不喜欢这个题目，早上它一下子就出了两个？！！
		// public long incremovableSubarrayCount(int[] a) {
		// 	int n = a.length;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int[] numberGame(int[] a) {
		// 	int n = a.length;
		// 	int [] r = new int [n];
		// 	Arrays.sort(a);
		// 	for (int i = 0; i < n; i ++) {
		// 		if (i % 2 == 0)
		// 			r[i] = a[i+1];
		// 		else r[i] = a[i-1];
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这不是上次，把亲爱的表哥的活宝妹卡死的破烂题目吗？它又出一遍？该死的乌龟王八蛋。。。。想起来了，上次那个死题目，不能排序，说也没说清楚。。。
		// // 还是不知道，它的狗屁答案是怎么崩出来的。。。。
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 【二分查找法】：
		// public int maximizeSquareArea(int m, int n, int[] h, int[] v) {
		// 	this.m = m; this.n = n; this.h = h; this.v = v;
		// 	int r = binarySearch(1, Math.min(m, n));
		// 	return r == -1 ? -1 : r * r;
		// }
		// int [] h, v;
		// int m, n;
		// int binarySearch(int l, int r) {
		// 	int ans = -1;
		// 	while (l <= r) {
		// 		int m = l + (r - l) / 2;
		// 		System.out.println("\n m: " + m);
		// 		if (valid(m)) {
		// 			ans = Math.max(ans, m);
		// 			l = m + 1;
		// 		} else r = m-1;
		// 	}
		// 	return ans;
		// }
		// boolean valid(int x) {
		// 	int cnter = 0;
		// 	// 【竖直】查找：
		// 	Set<Integer> s = new HashSet<>();
		// 	s.add(1);
		// 	for (int i = 0; i < v.length; i++) {
		// 		if (s.contains(v[i] - x)) {
		// 			cnter ++;
		// 			break;
		// 		}
		// 		s.add(v[i]);
		// 	}
		// 	if (s.contains(n-x)) cnter++;
		// 	if (cnter == 0) return false;
		// 	s.clear();
		// 	s.add(1);
		// 	for (int i = 0; i < h.length; i++) {
		// 		if (s.contains(h[i] - x)) {
		// 			System.out.println("x: " + x);
		// 			return true;
		// 		}
		// 		s.add(h[i]);
		// 	}
		// 	if (s.contains(m-x)) return true;
		// 	return false;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 死题目：中间还要、还可以牵线搭桥来连的。。。 a==>c==>b 。。
		// // 把它想复杂了，像是【出发点】到【目的地】的最小代价问题，不管中转多少次。。【最短距离】与【最小代价】问题，就是一个固定算法
		// // 亲爱的表哥的活宝妹，今天不想写了，改天再写。。。感觉思路是清楚的，今天没耐心再写它了。。。
		// public long minimumCost(String S, String T, char[] u, char[] v, int[] c) {
		// 	n = S.length(); s = S.toCharArray(); t = T.toCharArray();
		// 	m = new HashMap[26];
		// 	Arrays.setAll(m, z -> new HashMap<Character, Integer>());
		// 	for (int i = 0; i < u.length; i++) {
		// 		char key = u[i];
		// 		m[key-'a'].put(v[i], Math.min(m[key-'a'].getOrDefault(v[i], 0), c[i]));
		// 	}
		// 	long r = 0;
		// 	d = new long [26];
		// 	for (int i = 0; i < n; i++) {
		// 		if (s[i] == t[i]) continue;
		// 		Arrays.fill(d, Long.MAX_VALUE);
		// 		d[s[i]-'a'] = 0;
		// 		long cur = minCost(s[i], t[i]);
		// 		System.out.println(Arrays.toString(d));
		// 		if (cur == Long.MAX_VALUE) return -1;
		// 		r += cur;
		// 	}
		// 	return r;
		// }
		// Map<Character, Integer> [] m;
		// long [] d;
		// char [] s, t;
		// int n;
		// long minCost(char uu, char v) {
		// 	Queue<long []> q = new PriorityQueue<long []>((x, y) -> x[1] != y[1] ? (int)(x[1] - y[1]) : (int)(x[0] - y[0]));
		// 	q.offer(new long [] {uu -'a', 0});
		// 	while (!q.isEmpty()) {
		// 		long [] cur = q.poll();
		// 		long u = cur[0], dist = cur[1];
		// 		if ((int)u == v-'a') return dist;
		// 		for (char c = 'a'; c <= 'z'; c++) {
		// 			if (c == u+'a' || !m[(int)u].containsKey(c)) continue;
		// 			if (dist + m[(int)u].get(c) < d[c-'a']) {
		// 				d[c-'a'] = dist + m[(int)u].get(c);
		// 				q.offer(new long [] {c-'a', d[c-'a']});
		// 			}
		// 		}
		// 	 }
		// 	return Long.MAX_VALUE;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public boolean hasTrailingZeros(int[] a) {
		// 	int n = a.length, cnt = 0;
		// 	for (int v : a) {
		// 		if (v % 2 == 0) cnt++;
		// 		if (cnt == 2) return true;
		// 	}
		// 	return false;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maximumLength(String S) {
		// 	n = S.length(); max = 1; s = S.toCharArray(); this.S = S; 
		// 	m = new HashMap<>();
		// 	map = new HashMap<>();
		// 	for (int i = 0; i < n; i++) {
		// 		char c = s[i];
		// 		map.put(c, map.getOrDefault(c, 0) + 1);
		// 		m.computeIfAbsent(c, z -> new ArrayList<>()).add(i);
		// 	}
		// 	if (Collections.max(map.values()) < 3) return -1;
		// 	r = new int [26];
		// 	return binarySearch(1, n);
		// }
		// Map<Character, Integer> map;
		// Map<Integer, List<Integer>> m = new HashMap<>();
		// char [] s; String S;
		// int n, max;
		// int [] r;
		// int binarySearch(int l, int r) {
		// 	int ans = 1;
		// 	while (l <= r) {
		// 		int m = (l + r) / 2;
		// 		if (check(m)) {
		// 			ans = Math.max(ans, m);
		// 			l = m + 1;
		// 		} else r = m - 1;
		// 	}
		// 	return ans;
		// }
		// boolean check(int l) { // l: length 这几天休息不够，感觉不难，可是脑袋糊糊的，晚点儿再写这个繁琐细节的。。。
		// 	boolean valid = true;
		// 	for (int i = 0; i <= n - 3 * l; i++) {
		// 		valid = true;
		// 		Arrays.fill(r, 0);
		// 		for (int j = i; j < i+l; j++) {
		// 			if (map.get(s[j]) < 3 || m.get(s[j]).size()-r[s[j]-'a']-1 < 2) {
		// 				valid = false;
		// 				break;
		// 			}
		// 			// r[s[j]-'a'] = // 遍历有序【升序】下标链条，查找。。
		// 		}
		// 		if (S.substring(i, i+l).chars().distinct().count != l) continue;
		// 		// 接下来，就是：建立一个 Map<Integer, List<Integer>> m = new HashMap<>();
		// 		// 把每个字符，所在下标记下来
		// 		// 确保第一个片段：每个字符仅只出现一次；每个字符都至少剩余频次 >=3
		// 		// 继续查找，下两个可能存在的同【子串】
		// 	}
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
		// }

		// // 亲爱的表哥的活宝妹，真讨厌他们的死题目，一出来就是两个一样的。。。死鬼，要死不得活的！！！
		// public int areaOfMaxDiagonal(int[][] a) {
		// 	int r = 0, max = 0;
		// 	for (int [] v : a)
		// 		if (v[0] * v[0] + v[1] * v[1] > r) {
		// 			r = v[0] * v[0] + v[1] * v[1];
		// 			max = v[0] * v[1];
		// 		} else if (v[0] * v[0] + v[1] * v[1] == r)
		// 			max = Math.max(max, v[0] * v[1]);
		// 	return max;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，读不懂这个破题目：说的是什么意思？
		// // 两个子，可以动，一个不动。找【两个源头的、最短距离问题】Multiple-source BFS
		// // 可是，不懂，那两个字，可以，怎么动，破烂题目。。。
		// public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个题目的表述是清楚的：可是思路不透彻
		// public int maximumSetSize(int[] a, int[] b) {
		// 	int n = a.length / 2;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maxPartitionsAfterOperations(String s, int k) {
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maxFrequencyElements(int[] a) {
		// 	int n = a.length, max = 0, cnt = 0;
		// 	int [] r = new int [101];
		// 	for (int v : a) {
		// 		r[v]++;
		// 		if (r[v] > max) {
		// 			max = r[v];
		// 			cnt = 1;
		// 		} else if (r[v] == max)
		// 			cnt++;
		// 	}
		// 	return max * cnt;
		// }

		// // // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个题目：现在，数据规模狠小，随便瓣瓣，能够出来；当数据规模大的时候，就得考虑算法了
		// public List<Integer> beautifulIndices(String s, String a, String b, int k) {
		// 	int n = s.length();
		// 	int x = a.length(), y = b.length();
		// 	List<Integer> l = new ArrayList<>();
		// 	// 因为 j 不变化，所以，可以【预处理】：把结果存起来备用
		// 	// List<Integer> lj = new ArrayList<>(); // index of j for b
		// 	// 为【避免，自己手写二分查找法】使用 TreeSet 数据结构，帮助减少和精确，二分查找的结果
		// 	TreeSet<Integer> lj = new TreeSet<>();
		// 	for (int i = 0; i+y <= n; i++) 
		// 		if (s.substring(i, i+y).equals(b))
		// 			lj.add(i);
		// 	for (int i = 0; i+x <= n; i++) 
		// 		if (s.substring(i, i+x).equals(a)) {
		// 			Integer lo = lj.lower(i), hi = lj.higher(i); // 严格，小于，或是大于，不等于。【特殊情况得考虑】
		// 			if (lo != null && Math.abs(i - lo) <= k || hi != null && Math.abs(i - hi) <= k || lj.contains(i))
		// 				l.add(i);
		// 		}
		// 	return l;
		// }

		// // // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 感觉，这个题目的思路，有点儿跳级：【K 数量级大，二分查找法】；
		// // 可是，是【1,x】的代价总和，这个总和，就不知道，怎么计算，就是，数与数之间，当以【从右往左的数位为单位遍历】，代价和的计算方法，总结规律，不懂
		// public long findMaximumNumber(long k, int x) {
		// }

	// 	// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
	// 	// 【优化改进、包括】：
	// 	// 查找、不变的、S 中B 子片段的下标，不能O(ny) 一定超时, 得用一个什么狗屁【primeNumber/Mod 数/ 算法】来实现 O(N) 线性扫描
	// 	// 查找、不变的、S 中A 子片段的下标，不能O(nx) 一定超时, 得用一个什么狗屁【primeNumber/Mod 数/ 算法】来实现 O(N) 线性扫描
	// 	// 不知道，细节哪里写错了，改天再重写这个题型
	// 	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 	public List<Integer> beautifulIndices(String s, String a, String b, int k) {
	// 		int n = s.length(), y = b.length(), x = a.length();
	// 		TreeSet<Integer> li = new TreeSet<>();
	// 		TreeSet<Integer> lj = new TreeSet<>();
	// 		scanBinSinONTime(s, a, li);
	// 		// 【既然上面的结果、已经有了】：下面，不扫描所有下标？不行！受限于算法，仍然每下标依次扫，才能够实现O(N) 线性扫一遍！
	// 		scanBinSinONTime(s, b, lj);
	// 		List<Integer> l = new ArrayList<>();
	// 		for (int i : li) {
	// 			Integer lo = lj.lower(i), hi = lj.higher(i); // 严格，小于，或是大于，不等于。【特殊情况得考虑】
	// 			if (lo != null && Math.abs(i - lo) <= k || hi != null && Math.abs(i - hi) <= k || lj.contains(i))
	// 			l.add(i);
	// 		 }
	// 		return l;
	// 	}
	// 	static final int mod = (int)1e9 + 7; // 这个数，可以可以换一个其它的。。。
	// // 亲爱的表哥的活宝妹，忘记这个算法是什么了，大致原理明白记得【每向后移动一个字符，递推关系】，可是写的细节不懂
	// 	TreeSet<Integer> scanBinSinONTime(String S, String T, TreeSet<Integer> lj) { 
	// 		char [] s = S.toCharArray(), t = T.toCharArray();
	// 		int base = 101;
	// 		long [] p = new long [T.length()]; // 用来，计算，快速幂？
	// 		p[0] = 1;
	// 		for (int i = 1; i < T.length(); i++)
	// 			p[i] = p[i-1] * base % mod;
	// 		long id = 0, cur;
	// 		for (int i = 0; i < T.length(); i++) // 【基片段、长度固定为 y】：算法的，标记值
	// 			id = (id + (long)(s[i] - 'a') * p[i]) % mod;
	// 		cur = id; // previous
	// 		for (int i = 1; i+T.length() <= S.length(); i++) {
	// 			cur = (cur + mod - (s[i-1] - 'a') + (long)(s[i] - 'a') * p[T.length()-1]) % mod;
	// 			if (cur == id) lj.add(i);
	// 		}
	// 		return lj;
	// 	}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumPushes(String S) {
		// 	int n = S.length(), r = 0, i = 1, cnt = 1;
		// 	while (i <= n) {
		// 		r += cnt;
		// 		if (i % 8 == 0) cnt++;
		// 		i++;
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 跟前一题相比，把长长字符串的字符频率考虑进去，就可以了，这个不难
		// public int minimumPushes(String S) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	Map<Integer, Integer> m = new HashMap<>();
		// 	List<int []> l = new ArrayList<>();
		// 	for (int i = 0; i < n; i++)
		// 		m.put(s[i]-'a', m.getOrDefault(s[i]-'a', 0) + 1);
		// 	for (Map.Entry<Integer, Integer> en : m.entrySet()) 
		// 		l.add(new int [] {en.getKey(), en.getValue()});
		// 	Collections.sort(l, (x, y)->y[1] != x[1] ? y[1] - x[1] : x[0] - y[0]);

		// 	int ans = 0, i = 1, cnt = 1;
		// 	while (i <= l.size()) {
		// 		ans += cnt * l.get(i-1)[1];
		// 		if (i % 8 == 0) cnt++;
		// 		i++;
		// 	}
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个题目好奇怪，亲爱的表哥的活宝妹，居然是读不懂！
		// // 它们是有规律的，中间只短路了两个房子，直接连通，可是要怎么数呢？这里，尝试来写这个题目，亲爱的表哥的活宝妹，感觉，只能先瓣手指头、来遍历每种情况地数。。破题目！！
		// // 不喜欢这个题目，下一个写不能写了。。。改天再写它
		// public int[] countOfPairs(int n, int x, int y) {
		// 	int [] r = new int [n];
		// 	if (x == y) {
		// 		r[0] = (n-1) * 2;
		// 		for (int i = 1; i < n; i++) 
		// 		r[i] = Math.max(0, (n-1-i) * 2);
		// 	} else {
		// 		r[0] = n * 2;
		// 		for (int i = 1; i < n; i++) { // 这里，要把一排分成三段来数？
					
		// 		}
		// 	}
		// 	return new int [0];
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumCost(int[] a) {
		// 	int n = a.length, r = 267;
		// 	for (int j = 1; j < n-1; j++) 
		// 		for (int k = j+1; k < n; k++) 
		// 			r = Math.min(r, a[0] + a[j] + a[k]);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public boolean canSortArray(int[] a) { // 982/999 passed: 太 tidious 了，不想写了，破烂题目，出得不好！！
		// 	int n = a.length;
		// 	int [] b = Arrays.copyOf(a, n);
		// 	Arrays.sort(b); // 【排序好】：然后比对，能从 a 变成 b 吗？感觉这个思路，有点儿难实现。要想简单一点儿的思路
		// 	// if (identicalArrays(a, b, 0, n-1)) return true;
		// 	boolean valid = true;
		// 	// 当一个片段：可能可以重新排，可以从 a[j] 找到下标 j, 使 a[j] ＝ b[i] 且，过程中 bits 数相同
		// 	System.out.println(Arrays.toString(a));
		// 	System.out.println(Arrays.toString(b));
		// 	for (int i = 0; i < n; i++) {
		// 		if (a[i] == b[i]) continue;
		// 		System.out.println("\n i: " + i);
		// 		int bitsCnt = Integer.bitCount(b[i]);
		// 		System.out.println("bitsCnt: " + bitsCnt);
		// 		valid = false;
		// 		for (int j = i; j < n; j++) {
		// 			System.out.println("j: " + j);
		// 			if (Integer.bitCount(a[j]) != bitsCnt) return false;
		// 			System.out.println("identicalArrays(a, b, i, j): " + identicalArrays(a, b, i, j));
		// 			if (a[j] == b[i] && identicalArrays(a, b, i, j)) {
		// 				i = j;
		// 				valid = true;
		// 				break;
		// 			} else if (Integer.bitCount(a[j]) == bitsCnt) continue;
		// 			else return false;
		// 		}
		// 		if (valid) continue;
		// 	}
		// 	return true;
		// }
		// boolean identicalArrays(int [] a, int [] b, int x, int y) {
		// 	int [] c = Arrays.copyOf(a, a.length);
		// 	Arrays.sort(c, x, y+1);
		// 	for (int i = x; i <= y; i++)
		// 		if ((c[i] ^ b[i]) > 0) return false;
		// 	return true;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个破烂题目，不知道，怎么去想，一堆破烂的、恶心得不能再恶心的破烂数学题目。。。坑死人不偿命！！
		// public int minimumArrayLength(int[] a) {
		// 	int n = a.length, min = Arrays.stream(a).min().getAsInt(), cnt = 0;
		// 	for (int i = 0; i < n; i++) if (a[i] == min) cnt++;
		// 	if (cnt == 1) return 1;
		// 	for (int i = 0; i < n; i++)
		// 		if (a[i] > min && a[i] % min != 0) return 1;
		// 	return cnt / 2 + (cnt % 2);
		// }

// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 【机械化题型】：要么，万用的【记忆化深搜】;要么，前者超时，继续优化为【动规】！
// 		// 难度在于：数据规模极大，没有二维数据结构，能，不超时、且不暴内存？
// 		// 它只要求：【最后一片段，起始点】－【第二个片段，起始点】 <= dist 就可以了，其它也是【动规？，算最小和，叮叮咣咣】呀。。
// 		public long minimumCost(int[] a, int k, int dist) {
// 			int n = a.length;
// 			long r = Long.MAX_VALUE, curSum = 0; // 再累加： k-1 个【满足要求的】数，的【最小和】
// 			// 像一个【滑动窗口】，窗口有【最大宽度】：求【窗口内 k-1 个数的最小和】
// // 【数据结构，优化】：这里，用两个数据结构，狠麻烦，且浪费时间。这里无论如何，要用2 个！！一定实现不了！！
// 			// 要【自己维护一个，可以方便（二分查找、下标）的链条】来用
// 			// ArrayDeque<Integer> q = new ArrayDeque<>(); // 【双端队列】：降序排列，要怎么排序？
// 			List<Integer> q = new ArrayList<>(); // 【双端队列】：降序排列，且方便【二分查找，与二分随需要插入元素】！
// 			// Stack<Integer> s = new Stack<>(); // 【栈，优化】：效率低，自己维护二分查找、下标？链条。就又成 pqi[idx] K-1 个下标，的二分查找
// 			// Queue<Integer> q = new PriorityQueue<>((x, y) -> y-x); // 往外扔的时候，捡大的扔掉
// 			for (int i = 1; i < n; i++) {
// 				// 先扔，所有不合法、窗口外的，前片段下标. 【问题是：最大堆，留下来的堆内元素，怎么保证，它们都合法？】
// 				while (!q.isEmpty() && q.get(0) < i - dist) { // 假定：下标升序？
// 					curSum -= (long)a[q.get(0)];
// 					q.remove(0);
// 				}
// 				if (a[i] < a[q.get(0)]) { // 【当前数，可以构造、当前，最优解】当前数据结构不够用，多用一个栈！！
// 					// 扔掉一个最大数
// 					curSum -= (long)a[q.get(0)];
// 					q.remove(0);
// 					// 把当前数放进，正确的位置：怎么，高效实现，两条特性呢？最大值 , 与当前数插入大小正确的位置？  // <<<<<<<<<<<<<<<<<<<< 
// 					// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 					// 不想写了，什么时候写它呢？今天不想写它了。。昨天晚上少休息一个周期，脑袋打转结团。。。
// 					// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 				}
// 				if (q.size() == k-1) { // 【取解】：扔且，一次仅扔出去一个. 【这里取的不是、不一定是最优化解，没比较 a[i]】
// 					r = Math.min(r, curSum); // <<<<<<<<<<<<<<<<<<<< 
// 					curSum -= (long)a[q.peek()];
// 					q.remove(0);
// 				}
// 				curSum += (long)a[i];
// 				// 二分插入 i? 。。。脑袋还在糊糊。。。
				
// 			}
// 		}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int countKeyChanges(String S) {
		// 	int n = S.length(); char [] s = S.toCharArray();
		// 	int r = 0;
		// 	if (Character.isLowerCase(s[0]))
		// 		s[0] = (char)('A' + (s[0] - 'a'));
		// 	char p = s[0];
		// 	for (int i = 1; i < n; i++) {
		// 		if (Character.isLowerCase(s[i]))
		// 			s[i] = (char)('A' + s[i] - 'a');
		// 		if (s[i] != p) {
		// 			r ++;
		// 			p = s[i];
		// 		}
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public long flowerGame(int n, int m) {
		// 	if (m == 1 && n == 1) return 0;
		// 	long r = 0;
		// 	if (m == 1 || n == 1)
		// 		return (m == 1 ? n / 2 : m / 2);
		// 	r += (long)n / 2 * (long)(m / 2 + m % 2); // 【偶 + 奇】
		// 	r += (long)(n / 2 + n % 2) * (m / 2);         // 【奇 + 偶】
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maximumLength(int[] a) { // 【接龙型记忆化深搜】
		// 	int n = a.length, r = 0, base = 1;
		// 	m = new HashMap<>(); f = new HashMap();
		// 	for (int v : a) 
		// 		m.put((long)v, m.getOrDefault((long)v, 0) + 1);
		// 	System.out.println("m.size(): " + m.size());
		// 	for (Map.Entry<Long, Integer> en : m.entrySet()) 
		// 		System.out.print(en.getKey() + ", " + en.getValue() + "\n");
		// 	for (int v : a)  // 这里需要，遍历每个数吗？
		// 		if (v > 1)
		// 			dfs((long)v);
		// 		else if (!f.containsKey((long)v))
		// 			f.put((long)v, (m.get((long)v) % 2 == 0 ? m.get((long)v)-1 : m.get((long)v)));
		// 	System.out.println("f.size(): " + f.size());
		// 	for (Map.Entry<Long, Integer> en : f.entrySet()) 
		// 		System.out.print(en.getKey() + ", " + en.getValue() + "\n");
		// 	return Collections.max(f.values());
		// }
		// Map<Long, Integer> m;
		// Map<Long, Integer> f;
		// int max = 1;
		// int dfs(long i) {
		// 	if (f.containsKey(i)) return f.get(i);
		// 	if (!m.containsKey(i)) return 0;
		// 	if (m.get(i) == 1) {
		// 		f.put(i, 1);
		// 		return 1;
		// 	}
		// 	int next = dfs((long)i * i);
		// 	int r = 2 + (next == 0 ? -1 : next);
		// 	f.put(i, r);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 感觉有点儿没有思路：
		// // 从【最大数往最小数遍历】，从最高位往最低位遍历，想要移除 most-significant bits firstly
		// // 有点儿像【区间型动规】：可是亲爱的表哥的活宝妹，现在想不明白，每两个数变成了一个数，长度缩短了要怎么处理？
		// public int minOrAfterOperations(int[] a, int k) {
		// 	int n = a.length, ansBits = a[0], mask = 0, orr = a[0], cur = -1, cnt = 0;
		// 	for (int i = 1; i < n; i++) { 
		// 		ansBits = (ansBits & a[i]); // 结果里面一定会包含的数位，是 mission-impossible to remove any bits it includes
		// 		orr = (orr | a[i]);
		// 	}
		// 	for (int i = 29; i >= 0; i--) {
		// 		if (((orr > i) & 1) == 0) continue; // 数组中，没有这个数位
		// 		if ((ansBits & (1 << i)) > 0) continue; // 这个数位是，mission-impossible to remove any bits it includes 直接跳过，不动不用考虑它
		// 		// 【评估】：当前数位 i, 要多少个操作【<=k】可以把，这个数位移除？
		// 		mask |= (1 << i);
		// 		cnt = k;
		// 		cur = -1;
		// 		for (int j = 0; j < n-1; j++) {
		// 			if ((mask & a[i]) > 0) {
		// 				cnt--;
		// 				if (cur == -1) cur = a[j];
		// 				else cur = (cur & (a[j] & a[j+1]));
		// 				j++; // 把下个数跳过
		// 			}
		// 			else {
		// 				if (cur == -1) cur = a[j];
		// 				else cur = (cur & a[j]);
		// 			} 
		// 		}
		// 		if (cur == 0 && cnt >= 0) { // 这个位可以移除？
		// 			k -= cnt;
		// 			mask ^= (1 << i);
		// 			continue;
		// 		} else {
		// 			ansBits |= (1 << i);
		// 		}
		// 	}
		// 	return ansBits;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public String triangleType(int[] A) {
		// 	int n = A.length, a = A[0], b = A[1], c = A[2];
		// 	if (a == b && b == c) return "equilateral";
		// 	if (a + b > c && a + c > b && b + c > a && (a == b || b == c || a == c)) return "isosceles";
		// 	if (a + b > c && a + c > b && b + c > a) return "scalene";
		// 	return "none";
		// }

// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 这个题目极其恶心贱恶，没什么意思，不用写。。。
// 		public int numberOfPairs(int[][] points) {
// 		}

		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 这个题目是老生常谈，写得笔头都烂了，还在出。。。数组里有负数
		// 这里要个【转化】：把含有负数的数组，转化为每个元素非负，也就是数组里的每个元素，添加 |min|
		// 那么求最大和的时候，要根据长度，减掉添加过的部分, 不用！！
		// 数据规模大【N=10^5】，O(NN) 一定会超时，还要字典快速查找，转化为O(N)
// TLE: 770/782 passed !! 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 还应该怎么优化呢？
		public long maximumSubarraySum(int[] a, int val) { 
			System.out.println(Arrays.toString(a));
			int n = a.length, min = Arrays.stream(a).min().getAsInt(), ma = Arrays.stream(a).max().getAsInt();
			Map<Integer, List<Integer>> m = new HashMap<>();// 没有说，数组没有重复，就得考虑重复元素
			if (min < 0) 
				for (int i = 0; i < n; i++) 
					a[i] += -min;
			for (int i = 0; i < n; i++) 
				m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
			long [] r = new long [n+1];
			for (int i = 1; i <= n; i++) r[i] = r[i-1] + (long)a[i-1];
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(r));
			// O(N) 把数组扫一遍，应该就能够求出结果了
			// 为了方便，可以数组排序，只单方向【从小到大，或是从大到小，扫单方向】扫就可以了
			// long max = (ma >= 0 ? Long.MIN_VALUE : ma);
			long max = Long.MIN_VALUE;
			Arrays.sort(a);
			System.out.println(Arrays.toString(a));
			for (int i = 0; i < n-1; i++) {
				if (m.containsKey((Integer)a[i] + val))
					for (int j : m.get(a[i] + val))
						for (int k : m.get(a[i]))
							// if (max == null) max = 
							max = Math.max(max, j > k ? r[j+1] - r[k] + (min < 0 ? (long)(j-k+1) * (long)min : 0) : r[k+1] - r[j] + (min < 0 ? (long)(k-j+1)*(long)min : 0));
			}
			return max == Long.MIN_VALUE ? 0 : max;
		}

		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		public int numberOfPairs(int[][] points) { // 不喜欢前面一个题目，所以这个也没兴趣写了。。
		}
	}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();

		// int []  a = new int []  {-1, 3, 2, 4, 5};
		// int [] a = new int [] {1,2,3,4,5,6};
		int [] a = new int [] {1, 5};

		long r = s.maximumSubarraySum(a, 2);
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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