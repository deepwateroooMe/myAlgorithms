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

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int maximumLengthSubstring(String t) {
		// 	int n = t.length(), max = 0; char [] s = t.toCharArray();
		// 	int [] r = new int [26];
		// 	for (int i = 0, j = 0; i < n; i++) { // j: left i: right
		// 		r[s[i]-'a']++;
		//  	    if (r[s[i]-'a'] > 2) {
		// 			while (j < i && s[j] != s[i]) {
		// 				r[s[j]-'a']--;
		// 				j++;
		// 			}
		// 			r[s[j]-'a']--;
		// 			j++;
		// 		}
		// 		max = Math.max(max, i - j + 1);
	   	//     }
		// 	return max;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minOperations(int k) {
		// 	return 0;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public long [] mostFrequentIDs(int[] a, int [] b) {
		// 	int n = a.length;
		// 	long curCnt = 0;
		// 	long [] r = new long [n];
		// 	Map<Integer, Long> m = new HashMap<>(); // number freq
		// 	TreeMap<Long, Set<Integer>> f = new TreeMap<Long, Set<Integer>>(); // freq numbers!
		// 	for (int i = 0; i < n; i++) {
		// 		curCnt = m.getOrDefault(a[i], 0l);
		// 		if (curCnt > 0l) {
		// 			f.get(curCnt).remove(a[i]);
		// 			if (f.get(curCnt).size() == 0)
		// 				f.remove(curCnt);
		// 		}
		// 		m.put(a[i], curCnt + (long)b[i]);
		// 		if (curCnt + (long)b[i] != 0l) 
		// 			f.computeIfAbsent(curCnt + (long)b[i], z -> new HashSet<>()).add(a[i]);
		// 		if (f.size() == 0) {
		// 			r[i] = 0;
		// 			continue;
   		// 	    }
		// 	    r[i] = f.lastKey();
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 感觉，这是好大一颗【字典树】！好像，亲爱的表哥的活宝妹、中国大陆妈妈生前故居老宅的、参天皂荚树！
		// public class Trie {
		// 	private class Node {
		// 		public int i; // idx
		// 		public boolean f; // final: isWord
		// 		public Node [] n; // next
		// 		public Node(boolean a) {
		// 			this.f = a;
		// 			n = new Node[26];
		// 			i = -1;
		// 		}
		// 		public Node() {
		// 			this(false);
		// 		}
		// 	}
		// 	private Node root;
		// 	public Trie() {
		// 		root = new Node();
		// 	}
		// 	public void insert(String t, int idx) { 
		// 		int m = t.length(), j = 0; char [] s = t.toCharArray();
		// 		// 把字符串倒一下：忘记高效是怎么倒的了，先手动来一下
		// 		for (int i = 0; i < m/2; i++) {
		// 			char c = s[i];
		// 			s[i] = s[m-1-i];
		// 			s[m-1-i] = c;
		// 		}
		// 		Node r = root;
		// 		for (int i = 0; i < m; i++) {
		// 			j = s[i] - 'a';
		// 			if (r.n[j] == null) 
		// 				r.n[j] = new Node();
		// 			r = r.n[j];
		// 		}
		// 		r.f = true;
		// 		r.i = idx;
		// 	}
		// 	// level-order-traversal 找一个最短、下标最小的。。
		// 	private int levelOrderTraversal(Node root) { // 跟遍历、普通二叉树、是一样的呀，只不过假冒伪劣成、字典树而已。。。
		// 		Deque<Node> q = new ArrayDeque<>();
		// 		q.offerFirst(root);
		// 		int levelSmallestIdx = Integer.MAX_VALUE;
		// 		while (!q.isEmpty()) {
		// 			levelSmallestIdx = Integer.MAX_VALUE;
		// 			for (int i = q.size()-1; i >= 0; i--) {
		// 				Node r = q.pollLast();
		// 				for (int j = 0; j < 26; j++)
		// 					if (r.n[j] != null) {
		// 						if (r.n[j].f) {
		// 							levelSmallestIdx = Math.min(levelSmallestIdx, r.n[j].i);
		// 							continue;
		// 						}
		// 						q.offerFirst(r.n[j]);
		// 					}
		// 			}
		// 			if (levelSmallestIdx != Integer.MAX_VALUE) return levelSmallestIdx;
		// 		}
		// 		return -1;
		// 	}
		// 	private int searchRecursive(char [] s, Node r) {
		// 		int i = 0;
		// 		while (i < s.length && r.n[s[i]-'a'] != null) {
		// 			r = r.n[s[i]-'a'];
		// 			++i;
		// 		}
		// 		// i == != s.length() 不重要
		// 		if (r.f) return r.i;
		// 		// level-order-traversal 找一个最短、下标最小的。。
		// 		return levelOrderTraversal(r);
		// 	}
		// 	public int search(String t) { // 还要最好能写成、相对高效的 recursive-search...
		// 		int m = t.length(), j = 0; char [] s = t.toCharArray();
		// 		// 把字符串倒一下：忘记高效是怎么倒的了，先手动来一下
		// 		for (int i = 0; i < m/2; i++) {
		// 			char c = s[i];
		// 			s[i] = s[m-1-i];
		// 			s[m-1-i] = c;
		// 		}
		// 		return searchRecursive(s, root);
		// 	}
		// }
		// public int[] stringIndices(String[] a, String[] b) {
		// 	Trie t = new Trie();
		// 	Set<String> s = new HashSet<>();
		// 	for (int i = 0; i < a.length; i++) {
		// 		if (s.contains(a[i])) continue;
		// 		s.add(a[i]);
		// 		t.insert(a[i], i);
		//    }
		// 	int [] r = new int [b.length];
		// 	for (int i = 0; i < b.length; i++) 
		// 		r[i] = t.search(b[i]);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 【二分查找法】找每个二分的长短；对每个二分长度，用滑动窗口，找是否存在一个非空数组满足要求
		// // 因为K 取值狠小【n <= 7】应该也是可以暴力的；暴力的结果。。
		// public int minimumSubarrayLength(int[] a, int k) {
		// 	int len = binarySearch(a, k);
		// 	return len == Integer.MAX_VALUE ? -1 : len;
		// }
		// int binarySearch(int [] a, int v) {
		// 	int l = 1, r = a.length;
		// 	int min = Integer.MAX_VALUE;
		// 	while (l <= r) {
		// 		int m = (l + r) / 2;
		// 		if (valid(m, a, v)) {
		// 			min = Math.min(min, m);
		// 			r = m-1;
		// 		} else l = m + 1;
		// 	}
		// 	return min;
		// }
		// boolean valid(int len, int [] a, int v) {
		// 	int [] r = new int [8];
		// 	for (int i = 0, j = 0; i < a.length; i++) { // i: right j: left
		// 		for (int k = 0; k < 8; k++) {
		// 			if (((a[i] >> k) & 1) == 1)
		// 				r[k]++;
		// 		}
		// 		if (i - j < len-1)
		// 				continue;
		// 		int cur = 0;
		// 		for (int x = 0; x < 8; x++) 
		// 			if (r[x] > 0) cur |= (1 << x);
		// 		if (cur >= v) return true;
		// 		for (int k = 0; k < 8; k++) {
		// 			if (((a[j] >> k) & 1) == 1)
		// 				r[k]--;
		// 		}
		// 		j++;
		// 	}
		// 	return false;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumLevels(int[] a) {
		// 	int n = a.length;
		// 	int [] r = new int [n]; // preSum
		// 	for (int i = 0; i < n; i++)
		// 		r[i] = (i == 0 ? 0 : r[i-1]) + (a[i] > 0 ? 1 : -1);
		// 	// 像是，想要从 preSum 数组里，找一个可能存在的中间点，让左边和比右边和大；但是仍然感觉没能读懂这个破烂恶心死人不偿命的鬼题目。。
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，第1 个最简单题目，就把它写出来了吗？
		// // 【二分查找法】找每个二分的长短；对每个二分长度，用滑动窗口，找是否存在一个非空数组满足要求
		// // 因为K 取值狠小【n <= 7】应该也是可以暴力的；暴力的结果。。亲爱的表哥的活宝妹，真的一遍用相对逻辑算法化的解法把最简单的题目给解了。。
		// // 它们 leetcode 的出题目的人，真衰。。。
		// public int minimumSubarrayLength(int[] a, int k) {
		// 	int len = binarySearch(a, k);
		// 	return len == Integer.MAX_VALUE ? -1 : len;
		// }
		// int binarySearch(int [] a, int v) {
		// 	int l = 1, r = a.length;
		// 	int min = Integer.MAX_VALUE;
		// 	while (l <= r) {
		// 		int m = (l + r) / 2;
		// 		if (valid(m, a, v)) {
		// 			min = Math.min(min, m);
		// 			r = m-1;
		// 		} else l = m + 1;
		// 	}
		// 	return min;
		// }
		// boolean valid(int len, int [] a, int v) {
		// 	int [] r = new int [32];
		// 	for (int i = 0, j = 0; i < a.length; i++) { // i: right j: left
		// 		for (int k = 0; k < 32; k++) {
		// 			if (((a[i] >> k) & 1) == 1)
		// 				r[k]++;
		// 		}
		// 		if (i - j < len-1)
		// 			continue;
		// 		int cur = 0;
		// 		for (int x = 0; x < 32; x++) 
		// 		if (r[x] > 0) cur |= (1 << x);
		// 		if (cur >= v) return true;
		// 		for (int k = 0; k < 32; k++) {
		// 			if (((a[j] >> k) & 1) == 1)
		// 				r[k]--;
		// 		}
		// 		j++;
  		//     }
		// 	return false;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，觉得，他们 leetcode 贱鸡、贱畜牲的出题目的贱鸡、贱畜牲们，一定是黔驴技穷了吗？。。
		// // 亲爱的表哥的活宝妹，感觉，这题目出得真笨。。。难点在于，去数：以当前绝对差值、为最小绝对差值的、子序列的、长度为K 的个数，有几个？
		// // 恶心死人不偿命的：排列组合，数可能性的个数。。。真恶！！
		// static final int mod = (int)1e9 + 7;
		// public int sumOfPowers(int[] a, int k) {
		// 	int n = a.length;
		// 	// Arrays.sort(a); // 会：丢掉了数组下标、统计个数的相关信息
		// 	List<int []> l = new ArrayList<>();
		// 	for (int i = 0; i < n; i++)
		// 		l.add(new int [] {a[i], i});
		// 	Collections.sort(l, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
		// 	if (k == n) return l.get(0)[0];// 只有一种情况：全整数组
		// 	// 绝对差值、再排序列
		// 	int [] d = new int [n]; // Math.abs(a) diff array 
		// 	for (int i = 1; i < n; i++)
		// 		d[i] = Math.abs(l.get(i)[0] - l.get(i-1)[0]);
		// 	List<int []> ll = new ArrayList<>();
		// 	for (int i = 0; i < n; i++)
		// 		ll.add(new int [] {d[i], i});
		// 	Collections.sort(ll, (x, y) -> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
		// 	long ans = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		// 现在数个数，数的是：数组总共 n 个元素里，
		// 		// 除去【当前遍历节点的、假定为】最小绝对差值的、当前2 个数，
		// 		// 除去【绝对差值链条、前半头——更小差值的存在】——除去是，每组更小差值的2 个数，可以不同时存在，便不会产生更小差值。。
		// 		// 剩余的数里，能够组成K 个数的，所有可能性的、子序列个数方案数
		// 		// 不想再瓣这种题目了，瓣得恶心吧啦的。。。
		// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 		ans = (ans + (long)ll.get(i)[0] * (k == 2 ? 1 : ))
		// 	}
		// 	return 0;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int sumOfTheDigitsOfHarshadNumber(int x) {
		// 	String a = String.valueOf(x); char [] s = a.toCharArray();
		// 	int r = 0;
		// 	for (char c : s)  r += c -'0';
		// 	return x % r == 0 ? r : -1;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 破烂题目，出得像是小孩子过家家一样，没有半点儿价值，真恶心人类。。。
		// public int maxBottlesDrunk(int v, int e) {
		// 	int r = v, c = 0; // c : current empty bottles
		// 	c += v;
		// 	while (c >= e) {
		// 		r++;
		// 		c -= e;
		// 		e++;
		// 		c += 1;
		// 	}
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 不知道，怎么去想这类题目：【数量级大：N-10^5】；两个轴上的绝对差值的和；求最小可能的值
		// // 【排序】：按一个轴方向上排序，如X 轴升序排列；可以储备2 个轴上的排序，以空间换时间
		// // 【二分查找法】：【0,2*10^8】【NlogN】解法；二分中的任何一个猜测值：评估... 感觉，思路还是没能想透彻
		// public int minimumDistance(int[][] a) {
		// 	int n = a.length, min = Integer.MAX_VALUE;
		// 	List<int []> l = new ArrayList<>();
		// 	TreeMap<Integer, Integer> m = new TreeMap<>();
		// 	for (int i = 0; i < n; i++) {
		// 		l.add(new int [] {a[i][0] - a[i][1], a[i][0] + a[i][1]});
		// 		m.put(a[i][0]-a[i][1], m.getOrDefault(a[i][0]-a[i][1], 0) + 1);
		// 	}
		// 	Collections.sort(l, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]); // y 轴升序排列
		// 	for (int i = 0; i < n; i++) {
		// 		if (m.get(l.get(i)[0]) == 1) m.remove(l.get(i)[0]);
		// 		else m.put(l.get(i)[0], m.get(l.get(i)[0])-1);
		// 		int maxX = m.lastKey() - m.firstKey(); 
		// 		int [] cur = l.remove(i);
		// 		int maxY = 0;
		// 		if (i == 0 || i == n-1)
		// 			maxY = (i == 0 ? l.get(n-2)[1] - l.get(0)[1] : l.get(n-2)[1] - l.get(0)[1]);
		// 		else maxY = l.get(n-2)[1] - l.get(0)[1];
		// 		min = Math.min(min, Math.max(maxX, maxY));
		// 		l.add(i, cur);
		// 		m.put(l.get(i)[0], m.getOrDefault(l.get(i)[0], 0) + 1);
		// 	}
		// 	return min;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这种数个数的题目，快要被亲爱的表哥的活宝妹，永远弃绝了，要亲爱的表哥的活宝妹程序员来数个数，太恶了。。
		// // 改天再写这个破烂题目
		// public long countAlternatingSubarrays(int[] a) {
		// 	int n = a.length;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int longestMonotonicSubarray(int[] a) {
		// 	int n = a.length;
		// 	int [] l = new int [n], r = new int [n]; // l: increasing r: decreasing
		// 	Arrays.fill(l, 1); Arrays.fill(r, 1);
		// 	for (int i = 1; i < n; i++) {
		// 		if (a[i] > a[i-1]) l[i] = l[i-1] + 1;
		// 		else if (a[i] < a[i-1]) r[i] = r[i-1] + 1;
		// 	}
		// 	return Math.max(Arrays.stream(l).max().getAsInt(), Arrays.stream(r).max().getAsInt());
		// }


		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public String getSmallestString(String t, int k) {
		// 	if (k == 0) return t;
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	char [] r = new char [n];
		// 	for (int i = 0; i < n; i++) {
		// 		if (k == 0) {
		// 			for (int j = i; j < n; j++)
		// 				r[j] = s[j];
		// 			return new String(r);
		// 		}
		// 		if (k >= Math.min(s[i] - 'a', 'z' - s[i] + 1)) {
		// 			r[i] = 'a';
		// 			k -= Math.min(s[i] - 'a', 'z' - s[i] + 1);
		// 		}
		// 		else { // a z ?
		// 			r[i] = (char)(s[i] - k);
		// 			for (int j = i+1; j < n; j++)
		// 				r[j] = s[j];
		// 			return new String(r);
		// 		}
		// 	}
		// 	return new String(r);
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 从左往右，与从右往左扫，求最小差值，想得稀里糊涂的。。。好讨厌这类数来数去、恶心死人不偿命的的题目。。。
		// public long minOperationsToMakeMedianK(int[] a, int k) {
		// 	int n = a.length, p = 0;
		// 	Arrays.sort(a);;
		// 	long ans = 0;
		// 	int [] l = new int [n], r = new int [n];
		// 	if (n % 2 == 1) {
		// 		ans += Math.abs(a[n/2] - k);
		// 		l[n/2] = r; r[n/2] = r;
		// 		p = k;
		// 		for (int i = n/2-1; i >= 0; i--) {
		// 			if (a[i] > p) r[i] = a[i] - p;
		// 		}
		// 					}
		// }

// 		// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
// 		// 思路：应该是可以，把树根固定在任何一个节点上, 如 0 节点；求根节点到任何其它节点的最小代价值 d[]；再遍历查询，找两个节点的最近公共祖先，要异或掉祖先节点的部分，就可以了！！
// 		// 还需要考虑：这个题目是，可以有环的
// 		// 对【无向图中、环的处理】：
// 		// 1. 先处理重复边，就是2 相连节点，超过一条直接边，连接他们，先前问题简化
// 		// 上面1: 不一定对： & 需要边所在环的特定数位，上面操作对2 节点小环外，有大环的情况并不适用。。
// 		// 2.求环的 & 值，并用这个【最小值】来 cover 环上任何2 节点间的【最小值】
// 		// 感觉这个难度【求公共祖先】，好像超出了亲爱的表哥的活宝妹，现在的解题能力。。。
// 		public int[] minimumCost(int n, int[][] egs, int[][] qs) {
// 			this.n = n;
// 			g = new ArrayList[n];
// 			Arrays.setAll(g, z -> new ArrayList<int[]>);
// 			for (int [] e : egs) {
// 				int u = e[0], v = e[1];
// 				if (u > v) {
// 					int tmp = u;
// 					u = v;
// 					v = tmp;
// 				}
//     		}
// 			Arrays.sort(egs, (x, y)-> x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
// 			int [] p = egs[0];
// 			for (int i = 1; i < n; i++) {
// 				int u = egs[i][0], v = egs[i][1], cur = Integer.MAX_VALUE;
// 				if (u == p[0] && v == p[1]) { // 假设相邻 2 节点间有多条直接边: 简化2 节点间重复边：求最小值 
// 					cur &= p[2]; //cur &= egs[i][2];
// 					p = egs[i];
// 					int j = i+1;
// 					while (j < n && egs[j][0] == u && egs[j][1] == v) {
// 						// cur &= egs[j][2];
// 						cur &= p[2];
// 						p = egs[j];
// 						j++;
// 					}
// 					cur &= p[2]; //cur &= egs[i][2];
// 					// if (j == n) {
// 					g[u].add(new int [] {v, cur});
// 					g[v].add(new int [] {u, cur});
// 					// }
// 					i = j - 1;
// 					p = new int [] {-1, -1};
// 				} else if (p[0] != -1) { // 
// 					u = p[0]; v = p[1];
// 					g[u].add(new int [] {v, p[2]});
// 					g[v].add(new int [] {u, p[2]});
// 					p = egs[i];
// 				}
// 			}
// 			if (p[0] != -1) {
// 				u = p[0]; v = p[1];
// 				g[u].add(new int [] {v, p[2]});
// 				g[v].add(new int [] {u, p[2]});
// 			}
// // suppose rooted at node 0
// 			dijkstra();
// 			int [] r = new int [qs.length];
// 			Arrays.fill(r, -1);
// 			// 求两个节点的最近公共祖先问题，以前写过，没能完全理解，感觉全忘记了
// 			// 亲爱的表哥的活宝妹，现在得发挥聪明才智，好好回想、边回想、边自己试着理解开窃，来理解这个求有向图上公共祖先的问题
// 		}
// 		int closestSharedGrandRelativeNode(int u, int v) {
// 		}
// 		List<int []> [] g;
// 		int [] d;
// 		int n;
// 		void dijkstra() {
// 			Arrays.fill(d, Integer.MAX_VALUE);
// 			d[0] = Integer.MAX_VALUE;
// 			Deque<int []> q = new ArrayDeque<>();
// 			q.offerFirst(new int [] {-1, 0, 0}); // parent, u, curD
// 			while (!q.isEmpty()) {
// 				int [] r = q.pollLast();
// 				int u = q[1], curD = r[2];
// 				for (int [] n : g[u]) {
// 					if (n[0] == r[0]) continue;// 这里就不对了。。。
// 					if ((curD & n[1]) < d[n[0]]) { // <= ? <
// 						d[n[0]] = (curD & n[1]);
// 						q.offerFirst(new int [] {u, n[0], d[n[0]]});
// 					}
// 				}
// 			 }
// 		}

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
		// public String findLatestTime(String t) {
		// 	char [] s = t.toCharArray();
		// 	for (int i = 0; i < 5; i++) {
		// 		if (i == 2) continue;
		// 		if (s[i] == '?') {
		// 			if (i == 0) {
		// 				if (s[1] == '?' || s[1] - '0' < 2)
		// 					s[i] = '1';
		// 				else s[i] = '0';
		// 			} else if (i == 1) {
		// 				if (s[0] == '0') s[i] = '9';
		// 				else s[i] = '1';
		// 			} else if (i == 3) s[i] = '5';
		// 			else if (i == 4) s[i] = '9';
		// 		}
		// 	}
		// 	return new String(s);
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
		// public int maximumPrimeDifference(int[] a) {
		// 	int n = a.length, l = -1, r = -1;
		// 	Set<Integer> s = new HashSet<>(List.of(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97));
		// 	for (int i = 0; i < n; i++) {
		// 		if (s.contains(a[i])) {
		// 			if (l == -1) l = i;
		// 			else r = i;
		// 		}
		// 	}
		// 	return r == -1 ? 0 : r - l;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个有点儿难想：像是，用什么分解质因子，找公因子的倍数，不怎么喜欢这些偏数字的破烂题目，不是。
		// // 是，2/7/11 三个质数怎么样的，数第几个数的I II 题型，可是实现细节，忘记了
		// // 笨办法：就是当15 条队列。。。然后一个一个数到K, 感觉可能会超时；有其它题型，可以怎么二分查找第K 个之类的，没理解透彻。。
		// public long findKthSmallest(int[] a, int k) { // TLE TLE TLE 亲爱的表哥的活宝妹，笨宝妹！！！
		// 	int n = a.length;
		// 	Arrays.sort(a);
		// 	int [] r = new int [n];
		// 	Arrays.fill(r, 1);
		// 	Queue<Integer> q = new PriorityQueue<>((x, y)-> Long.compare((long)a[x] * (long)r[x], (long)a[y] * (long)r[y]));
		// 	for (int i = 0; i < n; i++)
		// 		q.offer(i);
		// 	long pre = 0;
		// 	Set<Integer> s = new HashSet<>();
		// 	while (k > 0) {
		// 		int i = q.poll();
		// 		s.add(i);
		// 		long curVal = (long)a[i] * (long)r[i];
		// 		while (!q.isEmpty() && (long)a[q.peek()] * (long)r[q.peek()] == curVal)
		// 		s.add(q.poll());
		// 		--k;
		// 		for (int v : s) {
		// 			r[v]++;
		// 			q.offer(v);
		// 		}
		// 		pre = curVal;
		// 		s.clear();
		// 				  }
		// 	return pre;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 这个题目，感觉好一点儿. 【动规】. 【记忆化深搜】可能会超时10^4*10=10^5;
		// // 但是【记忆化深搜】超时的，【动规】不一定会超时。先试写【记忆化深搜】
		// // 亲爱的表哥的活宝妹，成为“伟大”的预言家。。。逼着亲爱的表哥的活宝妹，去写、怎么也写不习惯的破烂【动规】！！
		// // 先放一下，去想另一个题目
		// public int minimumValueSum(int[] a, int[] b) {
		// 	int n = a.length, m = b.length; this.a = a; this.b = b; 
		// 	int [][] f = new int [n][m];
		// 	Arrays.stream(f).forEach(z -> Arrays.fill(z, 1000000));
		// 	for (int i = n-1; i >= 0; i--) {
		// 		for (int j = m-1; j >= 0; j--) {
		// 		}
		// 	}
		// }		
		// public int minimumValueSum(int[] a, int[] b) { // TLE TLE TLE 。。。
		// 	n = a.length; m = b.length; this.a = a; this.b = b; 
		// 	f = new Integer [n][m+1];
		// 	Arrays.stream(f).forEach(z -> Arrays.fill(z, 1000000));
		// 	int r = dfs(0, m); 
		// 	return r >= 1000000 ? -1 : r;
		// }
		// int [] a, b; int m, n;
		// Integer [][] f;
		// int dfs(int i, int j) { // i: idx j: idx subarray
		// 	if (i == n && j == 0) return 0; // 2^14=100000 15 位数字
		// 	if (j <= 0) return 1000000;
		// 	if (f[i][j] != 1000000) return f[i][j];
		// 	int r = 1000000;
		// 	int curAnd = 32767;
		// 	for (int k = i; k < n-j+1; k++) {
		// 		if (k == i) curAnd = a[k];
		// 		else curAnd &= a[k];
		// 		if (curAnd == b[m-j])
		// 			r = Math.min(r, a[k] + dfs(k+1, j-1));
		// 	}
		// 	return f[i][j] = r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！		
		// public int numberOfSpecialChars(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int [] l = new int [26], r = new int [26];
		// 	for (char c : s) {
		// 		if (Character.isLowerCase(c)) l[c-'a']++;
		// 		else r[c-'A']++;
     	// 	 }
		// 	int ans = 0;
		// 	for (int i = 0; i < 26; i++)
		// 		if (l[i] > 0 && r[i] > 0) ans++;
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int numberOfSpecialChars(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int [] l = new int [26], r = new int [26];
		// 	Arrays.fill(l, -1); Arrays.fill(r, -1);
		// 	for (int i = 0; i < n; i++) {
		// 		char c = s[i];
		// 		if (Character.isLowerCase(c)) l[c-'a'] = i;
		// 		else if (Character.isUpperCase(c) && r[c-'A'] == -1) r[c-'A'] = i;
		// 	 }
		// 	int ans = 0;
		// 	for (int i = 0; i < 26; i++)
		// 		if (l[i] >= 0 && r[i] >= 0 && l[i] < r[i]) ans++;
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// 不知道这个破烂题目怎么想。。
		// public int minimumOperations(int[][] a) {
		// 	int m = a.length, n = a[0].length, r = 0;
		// 	int [][] f = new int [m][n];
		// 	for (int j = 0; j < n; j++) {
		// 		for (int i = 1; i < m; i++) {
		// 		}
		// 	}
		// }
		
		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 【最短路径】狠好写，用个队列；可是怎么再倒回去，找最短路径. MLE MLE MLE..它说，某些测试不过，但是它藏起来了。。。
		// public boolean[] findAnswer(int n, int[][] egs) {
		// 	g = new ArrayList[n]; this.n = n;
		// 	Arrays.setAll(g, z -> new ArrayList<int []>());
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1], w = e[2];
		// 		g[u].add(new int [] {v, w});
		// 		g[v].add(new int [] {u, w});
		// 	}
		// 	d = new long [n];
		// 	dijkstra();
		// 	// dfs: 从0 到 n-1 节点，深搜. 忘记得好干净，怎么不重遍遍历呢
		// 	dfs(0, 0l, new ArrayList<Integer>(), new boolean [n]);
		// 	int [][] r = new int [n][n];
		// 	for (List<Integer> l : ll)
		// 		for (int i = 0; i < l.size(); i++) {
		// 			if (i == 0) {
		// 				r[0][l.get(i)]++;
		// 				r[l.get(i)][0]++;
		// 				continue;
		// 			}
		// 			r[l.get(i-1)][l.get(i)]++;
		// 			r[l.get(i)][l.get(i-1)]++;
		// 		}
		// 	boolean [] ans = new boolean [egs.length];
		// 	for (int i = 0; i < egs.length; i++) 
		// 		ans[i] = (r[egs[i][0]][egs[i][1]] > 0 ? true : false);
		// 	return ans;
		// }
		// List<List<Integer>> ll = new ArrayList<>();
		// List<int []> [] g;
		// long [] d; // 最小距离
		// int n;
		// void dfs(int u, long w, List<Integer> l, boolean [] vis) { // 环
		// 	if (u == n-1) {
		// 		if (w == d[n-1]) ll.add(new ArrayList<>(l));
		// 		return ;
		// 	}
		// 	for (int [] e : g[u]) {
		// 		int v = e[0], we = e[1];
		// 		if (vis[v] || (long)w + (long)we > d[n-1]) continue;
		// 		l.add(v);
		// 		vis[v] = true;
		// 		dfs(v, (long)w + (long)we, new ArrayList<>(l), vis);
		// 		l.remove(l.size()-1);
		// 		vis[v] = false;
		// 	}
		// }
		// void dijkstra() {
		// 	Arrays.fill(d, Long.MAX_VALUE);
		// 	d[0] = 0;
		// 	Queue<long []> q = new PriorityQueue<long []>((x, y) -> Long.compare(x[1], y[1]));
		// 	q.offer(new long [] {0, 0, -1});
		// 	while (!q.isEmpty()) {
		// 		long [] cur = q.poll();
		// 		long u = cur[0], dis = cur[1], p = cur[2];
		// 		for (int [] e : g[(int)u]) {
		// 			int v = e[0];
		// 			long w = (long)e[1];
		// 			if (v == p) continue;
		// 			if (dis + w <= d[v]) {
		// 				d[v] = dis + w;
		// 				q.offer(new long [] {(long)v, d[v], (long)u});
		// 			}
		// 		}
		// 	 }
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int scoreOfString(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int r = 0;
		// 	for (int i = 1; i < n; i++)
		// 		r += Math.abs(s[i] - s[i-1]);
		// 	return r;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 【动规】： f[i][j] 用第 i 个矩形， cover 第 j 个点。。。可是这个动规的系统思路，还没能建立起来。。先写别的
		// public int minRectanglesToCoverPoints(int[][] a, int w) {
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 相对于普通题目，它加了个时间参数。这个时间参数，就导致建立好的无向图，随时可能会变形要重建？不需要重新建图，只是遍历时走不走已经消失的节点的问题。图还是传统建法
		// // 没有上面想得那么难，节点消失的时间是固定不变的，那么也就是，可以根据消失时间，根据从无向图根 0 节点出发，如果最短路径能够遍历到它【在它消失之前】。不难不难。。。
		// public int[] minimumTime(int n, int[][] egs, int[] a) { // TLE 531/532 passed 不知道为什么没能过，改天再写这个破烂题目
		// 	if (n == 1) return new int [] {0};
		// 	g = new ArrayList[n]; this.a = a; 
		// 	Arrays.setAll(g, z -> new ArrayList<>());
		// 	// 去掉，所有可能的重复边，只保留时间最短的. 去除这些重复边，怎么可能导致错误答案呢？
		// 	List<int []> l = new ArrayList<>();
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1];
		// 		e[0] = Math.min(u, v);
		// 		e[1] = Math.max(u, v);
		// 		l.add(new int [] {e[0], e[1], e[2]});
		// 	}
		// 	Collections.sort(l, (x, y)-> x[0] != y[0] ? x[0] -y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]));
		// 	for (int i = egs.length-1; i >= 1; i--) 
		// 		if (l.get(i)[0] == l.get(i-1)[0] && l.get(i)[1] == l.get(i-1)[1])
		// 			l.remove(i);
		// 	for (int [] e : egs) {
		// 		int u = e[0], v = e[1], w = e[2];
		// 		g[u].add(new int [] {v, w});
		// 		g[v].add(new int [] {u, w});
     	// 	}
		// 	d = new long [n];
		// 	dijkstra();
		// 	System.out.println(Arrays.toString(d));
		// 	int [] r = new int [n];
		// 	for (int i = 0; i < n; i++)
		// 		if (d[i] == Long.MAX_VALUE) r[i] = -1;
		// 		else r[i] = (int) d[i];
		// 	System.out.println(Arrays.toString(r));
		// 	return r;
		// }
		// List<int []> [] g; int n; int [] a;
		// long [] d;
		// void dijkstra() {
		// 	Arrays.fill(d, Long.MAX_VALUE);
		// 	d[0] = 0l;
		// 	Queue<long []> q = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
		// 	q.offer(new long [] {0, 0, -1}); // u, d, p
		// 	while (!q.isEmpty()) {
		// 		long [] cur = q.poll();
		// 		long u = cur[0], w = cur[1];
		// 		for (int [] e : g[(int)u]) {
		// 			long v = (long)e[0], di = (long)e[1];
		// 			if ((int)v == cur[2]) continue;
		// 			if (di + w < (long)a[(int)v] && di + w <= d[(int)v]) {
		// 				d[(int)v] = di + w;
		// 				q.offer(new long [] {v, d[(int)v], u});
		// 			}
		// 		}
		// 	}
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int addedInteger(int[] a, int[] b) {
		// 	Arrays.sort(a);  Arrays.sort(b); 
		// 	return b[0] - a[0];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 不知道哪里想错了，感觉思路基本都对了，可是就还差那么点儿细节，可能亲爱的表哥的活宝妹，今天总体还是太浮躁了点儿。。没能沉下心来好好写。。。
		// // 数量级极大：【二分查找法】
		// public long minEnd(int n, int x) {
		// 	this.n = n; this.v = x;
		// 	int r1 = (int)Math.pow(2, 27); // 数位是小于 27 位的
		// 	System.out.println("r: " + r1);
		// 	m = Integer.toBinaryString(x).length();
		// 	r = new int [m];
		// 	for (int i = 0; i < Math.min(27, m); i++) 
		// 		if (((x >> i) & 1) == 1)
		// 			r[i] = 1;
		// 	System.out.println(Arrays.toString(r));
		// 	if (m - Integer.bitCount(x) >= n-(x % 2 == 0 ? 0 : 1)) return x;
		// 	int cnts = m - Integer.bitCount(x);
		// 	StringBuilder s = new StringBuilder(Integer.toBinaryString(x));
		// 	for (int i = n-(x % 2 == 0 ? 0 : 1) - cnts; i > 0; i--) 
		// 		s.insert(s.length()-1, '0');
		// 	System.out.println("s.toString(): " + s.toString());
		// 	long ans = 0l;
		// 	for (int i = 0; i < s.length(); i++)
		// 		if (s.charAt(i) == '1')
		// 			ans |= (long)(1 << (s.length()-1-i));
		// 	return ans;
		// 	// return binarySearch(1, Long.MAX_VALUE);
		// }
		// int n, m, v;
		// int [] r; // 标记 x 的数位
		// // 那么，这里检查的就是：数组最大元素 v, 它的非标记位 >=n
		// boolean isValid(long x) {
		// 	int oo = 0, o = Long.toBinaryString(x).length();
		// 	int bgn = Math.min(27, Math.min(o, m));
		// 	if (bgn < m || Long.bitCount(x) < Arrays.stream(r).sum()) return false;
		// 	for (int i = 0; i < bgn; i++) 
		// 		if (r[i] > 0 && ((x >> i) & 1) != 1)
		// 			return false;
		// 		// else if (r[i] == 0 && ((x >> i) & 1) == 0) oo++;
		// 		else if (r[i] == 0) oo++;
		// 	if (oo >= n-1-(v % 2 == 0 ? 0 : 1)) return true;
		// 	for (int i = bgn; i < o; i++) 
		// 		if (((x >> i) & 1) == 0)
		// 			oo++;
		// 	return oo >= n-1;
		// }
		// long binarySearch(long l, long r) {
		// 	long ans = Long.MAX_VALUE;
		// 	while (l <= r) {
		// 		long m = l + (r - l) / 2;
		// 		System.out.println("m: " + m);
		// 		if (isValid(m)) {
		// 			ans = Math.min(ans, m);
		// 			r = m-1;
		// 		} else l = m + 1;
		// 	}
		// 	System.out.println("ans: " + ans);
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，它说傻瓜型的一个一个慢慢瓣，真坑人、坑死人不偿命。。。
		// public int minimumAddedInteger(int[] a, int[] b) {
		// 	n = b.length; this.a = a; this.b = b; 
		// 	d = Arrays.stream(a).sum() - sum; // Sa - x - y - sb = n * v ==> d = nv + x + y
		// 	Arrays.sort(a); Arrays.sort(b);
		// 	m = new HashMap<Integer, Integer>();
		// 	for (int v : a)
		// 		m.put(v, m.getOrDefault(v, 0) + 1);
		// 	sum = Arrays.stream(b).sum();
		// 	System.out.println("sum: " + sum);
		// 	int r = binarySearch(-1000, 0);
		// 	int r1 = binarySearch(0, 1000);
		// 	System.out.println("r: " + r);
		// 	System.out.println("r1: " + r1);
		// 	return r != 1001 ? r / n : -1 * r1 / n;
		// }
		// Map<Integer, Integer> m ;
		// int [] a, b; int n, sum, d;
		// boolean valid(int v) {
		// 	if (d == 0 && m.containsKey(0) && m.get(0) >= 2) return true;
		// 	for (Map.Entry<Integer, Integer> en : m.entrySet()) {
		// 		int k = en.getKey();
		// 		if (m.containsKey(d - v * n - k)) return true; 
		// 	}
		// 	return false;
		// }
		// int binarySearch(int l, int r) {
		// 	int ans = 1001;
		// 	while (l <= r) {
		// 		int mid = (l + r) / 2;
		// 		System.out.println("mid: " + mid);
		// 		if (valid(mid)) {
		// 			ans = Math.min(ans, mid);
		// 			r = mid - 1;
		// 		} else l = mid + 1;
		// 	}
		// 	System.out.println("ans: " + ans);
		// 	return ans;
		// }

		// // 亲爱的表哥的活宝，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public boolean isValid(String t) {
		// 	int n = t.length(), cnts = 0, two = 0;
		// 	char [] s = t.toCharArray();
		// 	if (n < 3) return false;
		// 	Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		// 	Set<Character> not = new HashSet<>(List.of('@', '#', '$'));
		// 	boolean hasDigit = false;
		// 	for (char c : s) {
		// 		if (not.contains(c)) return false;
		// 		if (sc.contains(c)) cnts++;
		// 		else if (Character.isUpperCase(c) || Character.isLowerCase(c)) two++;
		// 	}
		// 	return cnts > 0 && two > 0;
		// }

		// // 亲爱的表哥的活宝，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public int minimumOperationsToMakeKPeriodic(String t, int k) {
		// 	int n = t.length();
		// 	Map<String, Integer> m = new HashMap<>();
		// 	for (int i = 0; i <= n-k; i += k) {
		// 		String cur = t.substring(i, i+k);
		// 		m.put(cur, m.getOrDefault(cur, 0) + 1);
		// 									  }
		// 	System.out.println("(n/k): " + (n/k));
		// 	System.out.println("Collections.max(m.values()): " + Collections.max(m.values()));
		// 	return n/k - Collections.max(m.values());
		// }			

		// // 亲爱的表哥的活宝，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 没过，测试用例隐藏了。。。不知道哪里没想到。。。
		// public int minAnagramLength(String t) {
		// 	int n = t.length(), min = n, max = 0;
		// 	char [] s = t.toCharArray();
		// 	int [] cnts = new int [26];
		// 	// int [] l = new int [26], r = new int [26];
		// 	// Arrays.fill(l, -1);
		// 	// Arrays.fill(r, -1);
		// 	for (int i = 0; i < n; i++) {
		// 		char c = s[i];
		// 		cnts[c-'a']++;
		// 		// if (l[c-'a'] == -1) l[c-'a'] = i;
		// 		// else if (r[c-'a'] == -1) r[c-'a'] = i;
    	// 	}
		// 	// System.out.println(Arrays.toString(cnts));
		// 	max = Arrays.stream(cnts).max().getAsInt();
		// 	for (int i = 0; i < 26; i++)
		// 		if (cnts[i] > 0) min = Math.min(min, cnts[i]);
		// 	// System.out.println("min: " + min);
		// 	// System.out.println("max: " + max);
		// 	// return min == n ? 1 : n / min;
		// 	if (min == n) return 1;
		// 	if (min == 1) return n;
		// 	if (n % min == 0) return n / min;
		// 	int v = n / min;
		// 	while (n % v != 0 && v > 1) {
		// 		v--;
		// 	}
		// 	return v;
		// }

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// // 现在这个思路有个问题：并不是只能取【最大值 max】来取最优解；可能还可以增加 max 成为更大的值。。。
		// static final int mod = (int)1e9 + 7; // 还没有取模
		// public int minCostToEqualizeArray(int[] a, int x, int y) {
		// 	int n = a.length, max = Arrays.stream(a).max().getAsInt();
		// 	if (n == 1) return 0;
		// 	long r = 0, sum = 0;
		// 	for (int v : a) sum += (long)v;
		// 	if (x * 2 <= y) return (int)((long)max * n - sum);
		// 	Arrays.sort(a);
		// 	while (a[0] != max && a[1] != max) {
		// 		for (int i = 0; i < n-1; i++) {
		// 			if (a[i] == max || a[i+1] == max) break;
		// 			r += y * (max - a[i+1]);
		// 			if (a[i] == a[i+1]) {
		// 				a[i] = max;
		// 			} else {
		// 				a[i] = a[i] + (max - a[i+1]);
		// 			}
		// 			a[i+1] = max;
		// 			System.out.println(Arrays.toString(a));
		// 			i++;
		// 		}
		// 		Arrays.sort(a);
		// 	}
		// 	if (a[0] < max) r += x * (max - a[0]);
		// 	return (int)r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int findPermutationDifference(String S, String T) {
		// 	int [] l = new int [26], r = new int [26];
		// 	char [] s = S.toCharArray(); char [] t = T.toCharArray();
		// 	for (int i = 0; i < S.length(); i++) {
		// 		l[s[i]-'a'] = i;
		// 		r[t[i]-'a'] = i;
		// 	}
		// 	int ans = 0;
		// 	for (int i = 0; i < 26; i++) 
		// 		ans += Math.abs(l[i] - r[i]);
		// 	return ans;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 从后往前遍历，从右往左，或者【记忆化深搜】		
		// public int maximumEnergy(int[] a, int k) {
		// 	n = a.length; this.k = k; this.a = a; 
		// 	f = new Integer [n];
		// 	int max = Integer.MIN_VALUE;
		// 	for (int i = 0; i < n; i++) {
		// 		dfs(i);
		// 		max = Math.max(max, f[i]);
		// 	}
		// 	return max;
		// }
		// int n, k; int [] a;
		// Integer [] f;
		// int dfs(int i) {
		// 	if (i >= n) return 0;
		// 	if (f[i] != null) return f[i];
		// 	if (i == n-1) return f[i] = a[i];
		// 	// return f[i] = Math.max(a[i] + dfs(i + k), dfs(i+1));
		// 	return f[i] = a[i] + dfs(i + k);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目，要自己维护：每行、每列的有序排列最大值？
		// public int maxScore(List<List<Integer>> ll) {
		// 	int m = ll.size(), n = ll.get(0).size();
		// 	long [][] f = new long [m+1][n+1];
		// 	Arrays.setAll(f, z -> Long.MIN_VALUE);
		// 	for (int i = 0; i < m; i++) f[i][n] = 0;
		// 	for (int i = 0; i < n; i++) f[m][i] = 0;
		// 	for (int i = m; i > 0; i--) {
		// 		for (int j = n; j > 0; j--) {
		// 		}
		// 	}
		// 	return 0;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // n 的取值狠小【1,14】也就是说，基本可能，暴力也能过？？
		// // 这里，亲爱的表哥的活宝妹，还没能把它转化成【动规思维】： n 个数，用前第几个数。。。之类的
		// public int[] findPermutation(int[] a) { // TLE TLE TLE: 901/939 passed...
		// 	n = a.length; this.a = a; 
		// 	getPerm(0, new boolean [n], new ArrayList<Integer>(), 0);
		// 	int [] r = new int [n];
		// 	for (int i = 0; i < n; i++) 
		// 		r[i] = ll.get(i);
		// 	return r;
		// }
		// List<Integer> ll;
		// int n, min = Integer.MAX_VALUE; int [] a;
		// void getPerm(int i, boolean [] vis, List<Integer> l, int d) {
		// 	if (i == n) {
		// 		if (d <= min) {
		// 			// System.out.println("\nd: " + d);
		// 			// if (ll != null) {
		// 			// 	System.out.println("ll.size(): " + ll.size());
		// 			// 	System.out.println(Arrays.toString(ll.toArray()));
		// 			// }
		// 			// System.out.println("l.size(): " + l.size());
		// 			// System.out.println(Arrays.toString(l.toArray()));
		// 			if (d < min || (d == min && isSmaller(l, ll))) {
		// 				min = d;
		// 				ll = new ArrayList<Integer>(l);
		// 			}
		// 		}
		// 		return ;
		// 	}
		// 	for (int j = 0; j < n; j++) {
		// 		if (vis[j]) continue;
		// 		vis[j] = true;
		// 		l.add(a[j]);
		// 		getPerm(i+1, vis, new ArrayList<Integer>(l), d + (i == 0 ? 0 : (i == n-1 ? Math.abs(a[j] - a[l.get(0)]) : 0) + Math.abs(l.get(l.size()-2) - a[a[j]])));
		// 		l.remove(l.size()-1);
		// 		vis[j] = false;
		// 	}
		// }
		// boolean isSmaller(List<Integer> l, List<Integer> r) {
		// 	for (int i = 0; i < l.size(); i++)
		// 		if (l.get(i) < r.get(i)) return true;
		// 		else if (l.get(i) > r.get(i)) return false;
		// 	return false;
		// }

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public boolean isArraySpecial(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int i = 1; i < n; i++)
		// 		if (a[i] % 2 == a[i-1] % 2) return false;
		// 	return true;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// class Range {
		// 	int left, right;
		// 	// boolean r;
		// 	public Range(int left, int right) {
		// 		this.left = left;
		// 		this.right = right;
		// 		// r = false;
		// 	}
		// }
		// TreeSet<Range> ts;
		// public void addRange(int left, int right) {
		// 	int nl = left, nr = right;
		// 	Range high = new Range(right, Integer.MAX_VALUE);
		// 	while (true) {
		// 		Range r = ts.lower(high);
		// 		if (r == null || r.right < left) break;
		// 		if (r.right > right) nr = r.right;
		// 		if (r.left < left) nl = r.left;
		// 		ts.remove(r);
		// 	 }
		// 	ts.add(new Range(nl, nr));
		// }
		// public boolean queryRange(int left, int right) {
		// 	Range target = ts.floor(new Range(left, Integer.MAX_VALUE));
		// 	return target != null && target.left <= left && target.right >= right;
		// }
		// public void removeRange(int left, int right) {
		// 	Range high = new Range(right, right);
		// 	while (true) {
		// 		Range r = ts.lower(high);
		// 		if (r == null || r.right <= left) break;
		// 		if (r.right > right)
        //         ts.add(new Range(right, r.right));
		// 		if (r.left < left)
        //         ts.add(new Range(r.left, left));
		// 		ts.remove(r);
		// 	}
		// }
		// public boolean[] isArraySpecial(int[] a, int[][] qs) {
		// 	List<int []> l = new ArrayList<>(); // 排序的目的：是为了顺序遍历. 感觉这里像是【线段树？合并区间？】有个各段合并的过程。。
		// 	for (int i = 0; i < qs.length; i++)
		// 		l.add(new int [] {i, qs[i][0], qs[i][1]});
		// 	Collections.sort(l, (x, y) -> x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]);
		// 	boolean [] r = new boolean [qs.length];
		// 	ts = new TreeSet<>((x, y)->(x.left != y.left ? x.left - y.left : x.right - y.right));
		// 	for (int i = 0; i < l.size(); i++) {
		// 		int [] cur = l.get(i);
		// 		if (queryRange(cur[1], cur[2])) { // 那我只记： true 进 ts 
		// 			r[cur[0]] = true;
		// 			continue;
		// 		}
		// 		boolean valid = true;
		// 		for (int j = cur[1]+1; j <= cur[2]; j++) {
		// 			if (a[j] % 2 == a[j-1] % 2) {
		// 				valid = false;
		// 				break;
		// 			}
		// 		}
		// 		if (valid) {
		// 			r[cur[0]] = true;
		// 			ts.add(new Range(cur[1], cur[2]));
		// 		} else r[cur[0]] = false;
   		//     }
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 亲爱的表哥的活宝妹，不知道，这里哪里想得不对，暂时不写这个题目了
		// public long sumDigitDifferences(int[] a) {
		// 	int n = a.length, o = String.valueOf(a[0]).length();
		// 	// int r = (int)Math.pow(2, 29);// 最多 29 个数位
		// 	// System.out.println("r: " + r);
		// 	Map<Integer, Integer> [] m = new HashMap[o];
		// 	Arrays.setAll(m, z -> new HashMap<Integer, Integer>());
		// 	for (int v : a) {
		// 		char [] s = String.valueOf(v).toCharArray();
		// 		for (int i = 0; i < o; i++) 
		// 			m[i].put(s[i]-'0', m[i].getOrDefault(s[i]-'0', 0) + 1);
		// 	}
		// 	long r = 0;
		// 	for (int i = 0; i < o; i++) 
		// 		for (Map.Entry<Integer, Integer> en : m[i].entrySet()) 
		// 			r += (long)(n - en.getValue());
		// 	return r / 2l;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个死题目，读得好费劲，读不懂题目。。。万能的【记忆化深搜】，再写一遍
		// public int waysToReachStair(int k) {
		// 	if (k == 0) return 2;
		// 	n = (int)(Math.log(k) / Math.log(2));
		// 	System.out.println("n: " + n);
		// 	m = new HashMap[n+2][2]; this.v = k;
		// 	for (int i = 0; i <= n+1; i++) 
		// 		for (int j = 0; j < 2; j++) 
		// 			m[i][j] = new HashMap<Integer, Integer>();
		// 	return dfs(k, 0, 0) + dfs(k-1, 0, 1); // 现在是，【自顶往下】深搜
		// }
		// Map<Integer, Integer> [][] m; // 记忆化深搜：用来记忆，曾经得到过的答案
		// int n, v;
		// int dfs(int i, int j, int k) {
		// 	if (i == 0) return 1 + dfs(i + (int)Math.pow(2, j), j+1, 0);
		// 	if (j >= n+2) return 0;
		// 	// if (i > v +1) return 0; // 不知道哪里写错掉了。。细节。。
		// 	System.out.println("j: " + j);
		// 	System.out.println("k: " + k);
		// 	if (m[j][k].containsKey(i)) return m[j][k].get(i);
		// 	int r = 0;
		// 	if (k == 0)
		// 		r += dfs(i-1, j, 1);
		// 	if (i + (int)Math.pow(2, j) <= v + 1)
		// 		r += dfs(i + (int)Math.pow(2, j), j+1, 0);
		// 	m[j][k].put(i, r);
		// 	return r;
	    // }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int numberOfPairs(int[] a, int[] b, int k) {
		// 	int r = 0;
		// 	for (int i = 0; i < a.length; i++)
		// 		for (int j = 0; j < b.length; j++) 
		// 			if (a[i] % (b[j] * k) == 0) r++;
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public String compressedString(String t) {
		// 	int n = t.length(), i = 0, j = 0; char [] s = t.toCharArray();
		// 	StringBuilder r = new StringBuilder("");
		// 	char c = ' ';
		// 	while (i < n) {
		// 		c = s[i];
		// 		j++;
		// 		while (i+1 < n && j < 9 && s[i] == s[i+1]) {
		// 			j++;
		// 			i++;
		// 		}
		// 		if (i == n-1 || s[i] != s[i+1] || j == 9) {
		// 			r.append(j);
		// 			r.append(c);
		// 			i++;
		// 			j = 0;
		// 		}
		// 	}
		// 	return r.toString();
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// static final int mod = (int)1e9 + 7;
		// public int maximumSumSubsequence(int[] a, int[][] qs) {
		// 	n = a.length; int m = qs.length; this.a = a; 
		// 	// // 把 qs 排序一下：按下标【从小到大】处理。 q[i] 序号重要，虽然求总的和，但是改了就不再改了，还得顺序遍历。。
		// 	// List<int []> l = new ArrayList<>();
		// 	// for (int [] v : qs) l.add(v);
		// 	// Collections.sort(l, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
		// 	// 【记忆化深搜】：向两边搜，有个问题就是得标记方向
		// 	f = new Long [n][3]; g = new Long [n][3]; // 只是想少写一个检查 if （j >= 0）用空间换代码简单一点儿
		// 	long ans = 0;
		// 	// int p = 0;
		// 	for (int i = 0; i < m; i++) {
		// 		// int idx = l.get(i)[0], v = l.get(i)[1];
		// 		int idx = qs[i][0], v = qs[i][1];
		// 		// 这里，想要【记忆化深搜】：但是感觉，因为每个 qi 会更改这个下标的值，可能思路不对
		// 		// 并且每个 qi 改变了那个值后，就不再改回去了，所以这个思路，好像不对！！
		// 		// 先分成两个【记忆数组】：带当前下标，与不带当前下标
		// 		// 上面的，可能可以？合并成一个数组？
		// 		long x = dfsG(idx, 2); // 不带当前下标的，最大子序列和
		// 		// 再求：带当前下标的，最大子序列和
		// 		// p = a[idx];
		// 		a[idx] = v;
		// 		long y = dfsF(idx, 2);
		// 		System.out.println("x: " + x);
		// 		System.out.println("y: " + y);
		// 		System.out.println("Math.max(x, y): " + Math.max(x, y));
		// 		ans = (long)(ans + Math.max(x, y)) % mod;
		// 		// ans += Math.max(x, y);
		// 		System.out.println("ans: " + ans);
		// 		// a[idx] = p;
		// 	}
		// 	return (int)ans;
		// }
		// Long [][] f, g;
		// int n; int [] a;
		// long dfsG(int i, int j) { // 不带当前下标的，最大子序列和, g
		// 	if (i < 0 || i >= n) return 0;
		// 	if (g[i][j] != null) return g[i][j];
		// 	if (j == 2)
		// 		return g[i][j] = dfsG(i-1, 0) + dfsG(i+1, 1);
		// 	if (j == 0) // 向左：要当前数＋【i-2】，或是要【i-1】
		// 		return g[i][j] = Math.max(a[i] + dfsG(i-2, 0), dfsG(i-1, 0));
		// 	// j == 1: 向右：要当前数＋【i+2】，或是要【i+1】
		// 	return g[i][j] = Math.max(a[i] + dfsG(i+2, 1), dfsG(i+1, 1));
		// }		
		// long dfsF(int i, int j) { // 带当前下标的【仅只 idx 必须带当前下标】，最大子序列和, f
		// 	if (i < 0 || i >= n) return 0;
		// 	if (f[i][j] != null) return f[i][j];
		// 	if (j == 2)// idx: 当前下标必须带
		// 		return f[i][j] = a[i] + dfsF(i-2, 0) + dfsF(i+2, 1);
		// 	if (j == 0) // 向左：要当前数＋【i-2】，或是要【i-1】
		// 		return f[i][j] = Math.max(a[i] + dfsF(i-2, 0), dfsF(i-1, 0));
		// 	// j == 1: 向右：要当前数＋【i+2】，或是要【i+1】
		// 	return f[i][j] = Math.max(a[i] + dfsF(i+2, 1), dfsF(i+1, 1));
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 好像，这个该死的破烂题目，要【分解质因子】： a[i] 与 b[j]*k 的质因子，再数个数。讨厌这类题目，最后才写它
		// // 只过滤了一遍最简单的，还是超时了TLE TLE TLE
		// public long numberOfPairs(int[] a, int[] b, int k) {
		// 	int n = a.length, o = b.length;
		// 	List<Integer> l = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
		// 											  31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
		// 											  73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
		// 											  127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
		// 											  179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
		// 											  233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
		// 											  283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
		// 											  353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
		// 											  419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
		// 											  467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
		// 											  547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
		// 											  607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
		// 											  661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
		// 											  739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
		// 											  811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
		// 											  877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
		// 											  947, 953, 967, 971, 977, 983, 991, 997));
		// 	Map<Integer, Integer> m = new HashMap<>(); // 统计 K 的质因子个数
		// 	for (int i = 0; i < l.size() && l.get(i) <= k; i++) 
		// 		if (k % l.get(i) == 0) {
		// 			int v = k, cnt = 0;
		// 			while (v % l.get(i) == 0) {
		// 				cnt++;
		// 				v /= l.get(i);
		// 			}
		// 			m.put(l.get(i), cnt);
		// 		}
		// 	if (k == 1) m.put(1, 1);
		// 	long r = 0;
		// 	for (int i = 0; i < n; i++) {
		// 		int v = a[i];
		// 		// 只过滤了一遍最简单的，还是超时了TLE TLE TLE
		// 		boolean valid = true;
		// 		for (Map.Entry<Integer, Integer> en : m.entrySet()) {
		// 			int key = en.getKey(), val = en.getValue();
		// 			if (v % key != 0 || v % ((int)Math.pow(key, val)) != 0) {
		// 				valid = false;
		// 				break;
		// 			}
		// 		}
		// 		if (!valid) continue;
		// 		for (int j = 0; j < o; j++) 
		// 			if (v % (k * b[j]) == 0) 
		// 				r++;
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumChairs(String t) {
		// 	int n = t.length(); char [] s = t.toCharArray();
		// 	int max = 0, l = 0, r = 0; // l: left r: enter
		// 	for (int i = 0; i < n; i++) {
		// 		char c = s[i];
		// 		if (c == 'E') r++;
		// 		else l++;
		// 		max = Math.max(max, r - l);
		// 	}
		// 	return max;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// //days: 数值狠大。但解法仍然狠简单，就是合并交叉会议，数总天数 Range 前几天刚写过 
		// class Range implements Comparable<Range> {
		// 	int left, right;
		// 	public Range(int left, int right) {
		// 		this.left = left;
		// 		this.right = right;
		// 	}
		// 	@Override public int compareTo(Range other) {
        //         return this.left != other.left ? this.left - other.left : this.right - other.right;
		// 	}
		// }
		// TreeSet<Range> ts;
		// public void addRange(int left, int right) {
		// 	int nl = left, nr = right;
		// 	Range high = new Range(right, Integer.MAX_VALUE);
		// 	while (true) {
		// 		Range r = ts.lower(high);
		// 		if (r == null || r.right < left) break;
		// 		if (r.right > right) nr = r.right;
		// 		if (r.left < left) nl = r.left;
		// 		ts.remove(r);
		// 	 }
		// 	ts.add(new Range(nl, nr));
		// }
		// public boolean queryRange(int left, int right) {
		// 	Range target = ts.floor(new Range(left, Integer.MAX_VALUE));
		// 	return target != null && target.left <= left && target.right >= right;
		// }
		// public void removeRange(int left, int right) {
		// 	Range high = new Range(right, right);
		// 	while (true) {
		// 		Range r = ts.lower(high);
		// 		if (r == null || r.right <= left) break;
		// 		if (r.right > right)
        //         ts.add(new Range(right, r.right));
		// 		if (r.left < left)
        //         ts.add(new Range(r.left, left));
		// 		ts.remove(r);
		// 	}
		// }
		// public int countDays(int days, int[][] a) {
		// 	int n = a.length, r = 0;
		// 	Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]); 
		// 	ts = new TreeSet<Range>();
		// 	for (int [] v : a) 
		// 		addRange(v[0], v[1]);
		// 	for (Range v : ts) 
		// 		r += v.right - v.left + 1;
		// 	return days - r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这个题目，题目狠简单，细节狠恶心人。。。
		// public String clearStars(String t) {
		// 	int n = t.length(), cnt = 0, j = 0; char [] s = t.toCharArray();
		// 	for (char c : s) 
		// 		if (c == '*') cnt++;
		// 	char [] r = new char [n - cnt];
		// 	TreeMap<Character, List<Integer>> m = new TreeMap<>();
		// 	for (int i = 0; i < n; i++) {
		// 		if (s[i] != '*') {
		// 			r[j] = s[i];
		// 			m.computeIfAbsent(s[i], z -> new ArrayList<>()).add(j++);
		// 		} else { // s[i] == '*'
		// 			List<Integer> l = m.firstEntry().getValue();
		// 			int idx = l.remove(l.size()-1);
		// 			r[idx] = ' '; // 作个标记就可以了
		// 			if (l.size() == 0)
		// 				m.pollFirstEntry();
		// 	    }
		// 	}
		// 	System.out.println(Arrays.toString(r));
		// 	int i = 0; j = 0;
		// 	while (i < n - cnt * 2 && j < n - cnt) {
		// 		if (i < n - cnt*2 && r[i] != ' ') {
		// 			if (j == i) j++;
		// 			i++;
		// 		} else {
		// 			while (j < n-cnt && r[j] == ' ') j++;
		// 			// System.out.println("\n i: " + i);
		// 			// System.out.println("j: " + j);
		// 			if (i < n-cnt*2 && j < n - cnt) {
		// 				r[i++] = r[j];
		// 				r[j] = ' ';
		// 				j++;
		// 			}
		// 		}			
   		//     }
		// 	System.out.println(Arrays.toString(r));
		// 	char [] tmp = Arrays.copyOf(r, n - cnt * 2);
		// 	return new String(tmp);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 破烂题目：不知道怎么去想？有想法，但想得不一定对！参考一下它的提示，再写！！
		// //a[i] 取值在 [1,10^9] 所以一定【012...31】遍历数位，就是每个 a[i] 用一个30 位 mask 表示；
		// // 下面2 点：亲爱的表哥的活宝妹，想得不对
		// // 【子数组、位和】：【10^5】线段树，保存区间子数组的位和
		// // 再找最小差值，可能【二分查找法】——感觉这里可能想得不对
		// // 它用一个稍微简化的动规思路，可以试写一下
		// public int minimumDifference(int[] a, int k) {
		// 	// int r = (int)Math.pow(2, 30); // 最多 30 个数位
		// 	// System.out.println("r: " + r);
		// 	int n = a.length, min = Math.max(k, Arrays.stream(a).max().getAsInt());
		// 	Set<Integer> [] s = new HashSet[n];
		// 	Arrays.setAll(s, z -> new HashSet<Integer>());
		// 	s[0].add(a[0]);
		// 	min = Math.min(min, Math.abs(k - a[0]));
		// 	for (int i = 1; i < n; i++) {
		// 		s[i].add(a[i]); // 一个元素的【子数组】
		// 		min = Math.min(min, Math.abs(k - a[i]));
		// 		// for (int j = i-1; j >= 0; j--) {  // 亲爱的表哥的活宝妹的木头脑袋，真不转。。。
		// 			for (int v : s[i-1]) {
		// 				int cur = (v & a[i]);
		// 				if (s[i].add(cur))
		// 					min = Math.min(min, Math.abs(k - cur));
		// 			}
		// 		// }
		// 	}
		// 	return min;
		// }
		// 亲爱的表哥的活宝妹，第一次，轻轻松松，全写对了！！！除了最后一题目看了一下提示！！！

		// // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
		// public String clearDigits(String t) {
		// 	int n = t.length(), r = 0; char [] s = t.toCharArray();
		// 	ArrayDeque<Integer> q = new ArrayDeque<>();
		// 	for (int i = 0; i < n; i++) {
		// 		if (Character.isDigit(s[i])) {
		// 			r++;
		// 			s[i] = ' ';
		// 			s[q.pollLast()] = ' ';
		// 		} else q.offerLast(i);
		// 	}
		// 	char [] tp = new char [n-2 * r];
		// 	int j = 0;
		// 	for (int i = 0; i < n; i++) 
		// 		if (s[i] != ' ') tp[j++] = s[i];
		// 	return new String (tp);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，这个题目是【滑动窗口】相关的思路，可遇想得不透，后面再写. 先用最笨的办法，试写一下
		// public int findWinningPlayer(int[] a, int k) { // 571/684 passed 暂时不写这个题目了
		// 	int n = a.length, p = -1, max = Arrays.stream(a).max().getAsInt();
		// 	if (k > n)
		// 		k %= n; // 这里想当然，不对！！
		// 	System.out.println("k: " + k);
		// 	ArrayDeque<Integer> q = new ArrayDeque<>(); // idx
		// 	if (k == 0) {
		// 		for (int i = 0; i < n; i++)
		// 		if (a[i] == max) return i;
		// 	}
		// 	for (int i = 1; i < n && k > 0; i++) {
		// 		if (p == -1) {
		// 			if (a[i] > a[i-1]) {
		// 				p = i;
		// 				q.offerLast(i-1);
		// 			} else {
		// 				p = i-1;
		// 				q.offerLast(i);
		// 			}
		// 		} else if (a[i] > a[p]) {
		// 			q.offerLast(p);
		// 			p = i;
		// 		} else { // a[i] < a[p]
		// 			q.offerLast(i);
		// 		}
		// 		--k;
		// 	}
		// 	if (k == 0) return p;
		// 	while (k > 0) {
		// 		if (a[q.peekFirst()] > a[p]) {
		// 			q.offerLast(p);
		// 			p = q.pollFirst();
		// 		} else {
		// 			q.offerLast(q.pollFirst());
		// 		}
		// 		--k;
		// 	}
		// 	return p;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 这些题目，最近的这些题目——包括上周的最后最难一题目，都成为训练【动规】思维的基本功题目了。。。
		// public int maximumLength(int[] a, int k) {
		// 	int n = a.length;
		// 	List<int []> l = new ArrayList<>();
		// 	for (int i = 0; i < n; i++) 
		// 		l.add(new int [] {i, a[i]});
		// 	Collections.sort(l, (x, y)->x[1] - y[1]);
		// 	for (int i = 0; i < n; i++) {
		// 		int [] r = l.get(i);
		// 		a[r[1]] = r[0]; // [0,n-1] 按其值升序排列
		// 	}
		// 	return 0;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int numberOfChild(int n, int k) {
		// 	if (k < n) return k;
		// 	int d = k / (n - 1);
		// 	if (d % 2 == 0) return k % (n-1);
		// 	return n-1 - k % (n-1);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// static final int mod = (int)1e9 + 7;
		// public int valueAfterKSeconds(int n, int k) {
		// 	int [] f = new int [n];
		// 	Arrays.fill(f, 1);
		// 	for (int i = 1; i <= k; i++) {
		// 		for (int j = 1; j < n; j++) 
		// 			f[j] = (f[j-1] + f[j]) % mod;
		// 	}
		// 	return f[n-1];
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int maxTotalReward(int[] a) {
		// 	int n = a.length;
		// 	TreeSet<Integer> s = new TreeSet<>();
		// 	for (int v : a) s.add(v);
		// 	int [] b = new int [s.size()];
		// 	int i = 0;
		// 	for (int v : s) {
		// 		b[i] = v;
		// 		i++;
		// 	}
		// 	TreeSet<Integer> [] f = new TreeSet[b.length];
		// 	Arrays.setAll(f, z -> new TreeSet<Integer>((x, y)->y-x)); // 降序排列
		// 	f[0].add(b[0]);
		// 	for (i = 1; i < b.length; i++) {
		// 		f[i].add(b[i]);// 当前数
		// 		for (int v : f[i-1]) {
		// 			f[i].add(v);
		// 			if (v >= b[i]) continue;
		// 			f[i].add(v + b[i]);
		// 		}
		// 	}
		// 	int max = 0;
		// 	for (i = 0; i < b.length; i++)
		// 		max = Math.max(max, f[i].first());
		// 	return max;
		// }

		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// 亲爱的表哥的活宝妹，想要直接搬上一题目的解法，但显然 TLE TLE TLE 呵呵呵呵呵。。。。
		// 亲爱的表哥的活宝妹，看它的提示，感觉看得狠飘渺。。。看不懂它的提示说的是什么意思，明天再写
		public int maxTotalReward(int[] a) { // TLE TLE TLE ... 572/580 passed...
			int n = a.length;
			TreeSet<Integer> s = new TreeSet<>();
			for (int v : a) s.add(v);
			int [] b = new int [s.size()];
			int i = 0;
			for (int v : s) {
				b[i] = v;
				i++;
			}
			// 感觉，这里需要、必须要保存的，可以不是，所有可能的数，只要某个范围内、能够保证正确答案的数，就可以了。。。
			// 是这么想的：去看下它的提示！！
			TreeSet<Integer> f = new TreeSet<>((x, y)->y-x), g = new TreeSet<>((x, y)->y-x);
			f.add(b[0]);
			for (i = 1; i < b.length; i++) {
				g = (TreeSet)f.clone();
				g.add(b[i]);// 当前数
				for (int v : f) {
					if (v >= b[i]) continue;
					g.add(v + b[i]);
				}
				f.clear();
				f = (TreeSet)g.clone();
				g.clear();
			}
			return f.first();
			// int max = 0;
			// for (i = 0; i < b.length; i++)
			// 	max = Math.max(max, f[i].first());
			// return max;
		}

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int countCompleteDayPairs(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int i = 0; i < n; i++) 
		// 		for (int j = i + 1; j < n; j++) 
		// 			if ((a[i] + a[j]) % 24 == 0) r++;
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public long countCompleteDayPairs(int[] a) {
		// 	int n = a.length;
		// 	List<Integer> [] f = new ArrayList[24];
		// 	Arrays.setAll(f, z -> new ArrayList<Integer>());
		// 	for (int i = 0; i < n; i++) 
		// 		f[a[i] % 24].add(i);
		// 	long r = 0;
		// 	for (int i = 0; i < 24; i++) { // 遍历 mod 余数
		// 		System.out.println("\n i: " + i);
		// 		System.out.println("r: " + r);
		// 		if (i == 0 || i == 12) {
		// 			r += (long)f[i].size() * (long)(f[i].size()-1) / 2;
		// 		} else {
		// 			for (int j = 0; j < f[i].size(); j++) {
		// 				int v = binarySearch(f[24-i], f[i].get(j));
		// 				if (v != -1)
		// 					r += f[24-i].size() - v;
		// 			}
		// 		}
		// 	}
		// 	return r;
		// }
		// int binarySearch(List<Integer> li, int i) { // i: idx 感觉快要把【二分查找忘记光了】这里这个方法，被自己写得有点儿问题，晚点儿再写
		// 	if (li.size() == 0) return -1;
		// 	// if (i <= li.get(0) || i >= li.get(li.size()-1)) return -1;
		// 	if (i >= li.get(li.size()-1)) return -1;
		// 	int l = 0, r = li.size()-1;
		// 	while (l <= r) {
		// 		int m = (l + r) / 2;
		// 		if (li.get(m) == i) return m + 1;
		// 		if (li.get(m) == i+1) return m; // 短路吗？
		// 		if (li.get(m) < i) l = m + 1;
		// 		else r = m-1;
		// 	}
		// 	return -1;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【动规思路】：－2-1-0+1+2 后面2 个数，好像考虑不全. 先看后面的
		// public long maximumTotalDamage(int[] b) {
		// 	int n = b.length, i = 0;
		// 	TreeMap<Integer, Integer> m = new TreeMap<>();
		// 	for (int v : b) m.put(v, m.getOrDefault(v, 0) + 1);

		// 	Map<Integer, Integer> o = new HashMap<>();
		// 	int [][] a = new int [m.size()][2];
		// 	for (TreeMap.Entry<Integer, Integer> en : m.entrySet()) {
		// 		int k = en.getKey(), v = en.getValue();
		// 		a[i][0] = k; a[i][1] = v;
		// 		o.put(k, i); // 帮助记下标的
		// 		i++;
		// 	}
		// 	// Arrays.sort(a, (x, y)->x[0] - y[0]);
		// 	long [][] f = new long [m.size()][2];
		// 	f[0][0] = 0; f[0][1] = (long)a[0][0] * a[0][1];
		// 	// f[1][0] = f[0][1];
		// 	// f[1][1] = (long)a[1][0] * a[1][1];
		// 	for (int i = 1; i < a.length; i++) {
		// 		Integer lo = m.lowerKey(a[i][0]); // v-1
		// 		if (lo == null || a[i][0] - lo > 2) {
		// 			f[i][0] = f[o.get(lo)][1];
		// 			f[i][1] = (long)a[i][0] * a[i][1] + f[o.get(lo)][1];	
		// 		} else {
		// 			f[i][0] = f[o.get(lo)][1];
		// 			f[i][1] = (long)a[i][0] * a[i][1] + f[o.get(lo)][1];	
		// 		}
		// 	}
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumOperations(int[] a) {
		// 	int n = a.length, r = 0;
		// 	for (int v : a) {
		// 		if (v % 3 == 0) continue;
		// 		r += Math.min(3 - v % 3, v % 3);
		// 	}
		// 	return r;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 不知道这里说，最少次数是什么意思？什么情况下可以取得最小次数？只考虑从头开始，或从尾开始，能保证最优解吗？
		// // 讨厌这种题，亲爱的表哥的活宝妹，都没想明白是怎么回事，就一次写过了。。。写完了写过了，也没什么收获！！
		// public int minOperations(int[] b) {
		// 	int n = b.length, r = 0, l = 0;
		// 	int [] a = new int [n];
		// 	a = Arrays.copyOf(b, n);
		// 	for (int i = 0; i+2 < n; i++) {
		// 		if (a[i] == 1) continue;
		// 		l++;
		// 		for (int j = i; j <= i+2; j++) 
		// 			a[j] = 1 - a[j];
		// 	}
		// 	if (a[n-2] == 0 || a[n-1] == 0) l = n;
		// 	a = Arrays.copyOf(b, n);
		// 	for (int i = n-1; i >= 2; i--) {
		// 		if (a[i] == 1) continue;
		// 		r++;
		// 		for (int j = i; j >= i-2; j--) 
		// 			a[j] = 1 - a[j];
		// 	}
		// 	if (a[0] == 0 || a[1] == 0) r = n;
		// 	if (l == n && r == n) return -1;
		// 	return Math.min(l, r);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，这个II 像是更简单，因为一定、一定、一定？得从最从侧开始？
		// // 应用有测试用例，是说，某左侧 a【0】可能一定得操作，但不一定是先操作，或需要等到它右侧加工到什么程度，才再翻左侧？
		// // 还是，不知道，这个题目是，怎么回事。。。
		// public int minOperations(int[] a) {
		// 	int n = a.length;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 【动规】：一定是动规思路！可是，亲爱的表哥的活宝妹，从每周的四个题目，或是每两周的共十二个题目里，训练动规思维，不习惯、写不习惯。。。。。
		// // 【TODO】：这个题目，亲爱的表哥的活宝妹，没想透彻，今天或是必天需要：查网、看视频、看它人讲解，想透彻想明白。。。
		// // 亲爱的表哥的活宝妹，知道一定是【动规】，可是自己不会想，参照提示来写。。。
		// // 亲爱的表哥的活宝妹，感觉，基本，能够把提示看懂，就自己试试写写看。。动规、动规、令人深恶痛绝的动规！！！
		// // 提示2 没有看懂：【动规】的最重要的递推关系，没看懂。。所以，亲爱的表哥的活宝妹，还是不知道这个题目，是肿么回事。。。。。
		// // 上面，递推关系，用了【记忆化深搜】来进行的
		// static final int mod = (int)1e9 + 7;
		// Integer [][] f; // 跟下面的字典合并就可以了, 不行！！对列也有要求
		// // Map<Integer, Integer> m;
		// int dfs(int i, int j) {
		// 	if (j < 0) return 0;
		// 	if (f[i][j] != null) return f[i][j];
		// 	if (i == 0) return f[i][j] = (j == 0 ? 1 : 0); // 不用记忆：可能且仅可能出现1 次；读呢？被读多少次？
		// 	int r = 0;
		// 	for (int k = 0; k <= i; k++) 
		// 		r = (r + dfs(i-1, j-k)) % mod;
		// 	return f[i][j] = r;
		// }
 		// public int numberOfPermutations(int n, int[][] a) {
		// 	int o = a.length, max = 0; // , i = 0
		// 	// for (int [] v : a)
		// 	// 	max = Math.max(max, v[1]);
		// 	// f = new Integer [n+1][max+1]; // 跟下面的字典合并就可以了, 不行！！对列也有要求
		// 	f = new Integer [n][n * (n-1) / 2 + 1]; // 跟下面的字典合并就可以了, 不行！！对列也有要求
		// 	Arrays.sort(a, (x, y)->x[0] - y[0]); // 下标：升序排列
		// 	// m = new HashMap<>();
		// 	// for (int [] v : a)
		// 	// 	m.put(v[0], v[1]);
		// 	for (int [] v : a) {
		// 		if (dfs(v[0], v[1]) == 0) return 0;
		// 		for (int i = 0; i < f[v[0]].length; i++) // 我认为这句没用，哪里没想明白 
		// 			if (i != v[1])
		// 				f[v[0]][i] = 0;
		// 	}
		// 	return f[n-1][a[o-1][1]]; // n-1
		// // 	if (a[i][0] == 0 && a[i][1] != 0) return 0;
		// // 	m.put(0, 1);
		// // 	while (i < o) {
		// // 		if (a[i][0] == 0 && a[i][1] != 0) return 0; // 应该不存在这种情况
		// // 		if (a[i][0] == 0) {
		// // 			// m.put(0, 1);// 这里数个数，记了个 1 ？？？
		// // 			i++;
		// // 			continue;
		// // 		}
		// // 		// for (int j = i-1; j >= 0; j--) {
		// // 		// 	if (a[j] > a[i]) {
		// // 		// 		if (m.containsKey(a[j][0])) 
		// // 		// 			f[i][a[i][1]] = (m.get(a[j][0]) + f[i][a[i][1]]) % mod;
		// // 		// 	}
		// // 		// }
		// // 		if (m.containsKey(a[i][0]) && m.containsKey(a[i][0]-1)) {
		// // 			// f[i][a[i][1]] = m.get(a[i][0]-1);
		// // 			// m.put(a[i][0], f[i][a[i][1]]);
		// // 			m.put(a[i][0], m.get(a[i][0]-1));
		// // 		}
		// // 		i++;
		// // 	}
		// // 	// return f[n-1][m.get(n-1)];
		// // 	return m.get(n-1);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public double minimumAverage(int[] a) {
		// 	int n = a.length, j = 0;
		// 	List<Integer> l = new ArrayList<>();
		// 	for (int v : a) l.add(v);
		// 	Collections.sort(l);
		// 	double [] r = new double [n/2];
		// 	double min = 50;
		// 	for (int i = 0; i < n/2; i++) {
		// 		r[j] = (double)(l.get(0) + l.get(l.size()-1)) / 2.0;
		// 		l.remove(l.size()-1);
		// 		l.remove(0);
		// 		min = Math.min(min, r[j]);
		// 		j++;
		// 	}
		// 	return min;
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumArea(int[][] a) {
		// 	int m = a.length, n = a[0].length;
		// 	int [] r = new int [2], c = new int [2];
		// 	Arrays.fill(r, -1); Arrays.fill(c, -1);
		// 	for (int i = 0; i < m; i++) {
		// 		if (Arrays.stream(a[i]).sum() == 0) {
		// 			if (r[0] == -1) continue;
		// 			if (r[1] == -1) r[1] = i-1;
		// 		} else {
		// 			if (r[0] == -1) r[0] = i;
		// 			else r[1] = i;
		// 			for (int j = 0; j < n; j++) {
		// 				if (a[i][j] == 1) {
		// 					if (c[0] == -1 || j < c[0]) c[0] = j;
		// 					if (c[1] == -1 || j > c[1]) c[1] = j;
		// 				}
		// 			}
		// 		}
		// 	}
		// 	return (r[1] == -1 ? 1 : r[1] - r[0] + 1) * (c[1] == -1 ? 1 : c[1] - c[0] + 1);
		// }

		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// // 感觉，这个死题目狠简单——想的是几乎万能的【记忆化深搜，N=10^5 一定会超时】
		// // 实际可能不得不【动规！——动规，是有可能不超时的】可是亲爱的表哥的活宝妹，没能想过，动规为什么可能会不超时？先 【记忆化深搜，N=10^5 可能会超时】写一遍
		// // 为什么Acceptance Rate 只有26.1% ？？
		// // 但是去想的话，应该还是【万变不离其踪的、稍微变更与必要的优化步骤】。数组里的【负数相关】。亲爱的表哥的活宝妹，过会儿再想这个题目
		// public long maximumTotalCost(int[] a) {
		// 	int n = a.length;
		// }
		// Long [][] f; // 二维记忆数组：N*N=10^10 一定会超时！！

// 		// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 		// 亲爱的表哥的活宝妹，切【苹果蛋糕——先前的动规题型】——所有的苹果，要极尽可能地，分布在总面积最小的三块蛋糕上
// 		// 变形变型的【记忆化深搜】？657/661 passed !!! TLE TLE TLE !!! 感觉这里，亲爱的表哥的活宝妹，应该还可以再优化一些不必的重复过的边角检测之类的小细节。。
		// // 写出这个题目，感觉亲爱的表哥的活宝妹，真强大！！用实际题目来证明：只要亲爱的表哥的活宝妹，能够自己相得明白，亲爱的表哥的活宝妹，就能够把代码写出来、实现出来！！
		// // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
		// public int minimumSum(int[][] a) {
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
// 				r = Math.min(r, Math.min(Math.min(dfs(i, j, ii, y, 0) + dfs(ii+1, j, x, y, k), // 行：上半1 ＋下半 k-1
// 												  dfs(i, j, ii, y, 1) + dfs(ii+1, j, x, y, k-1)), // 行：上半1 ＋下半 k-1
// 										 Math.min(dfs(i, j, ii, y, 1) + dfs(ii+1, j, x, y, k-1), // 行：上半1 ＋下半 k-1
// 												  dfs(i, j, ii, y, 2) + dfs(ii+1, j, x, y, k-2)))); // 行：上半2 ＋下半 k-2
// 			}
// // 遍历，先行列: 行切至当前列，包括当前列
// 			for (int jj = j; jj < y; jj++) {
// 				int s = sum[x+1][jj+1] - sum[i+1][j] - sum[i][j+1] + sum[i][j];
// 				if (s == 0) continue;
// 				r = Math.min(r, Math.min(Math.min(dfs(i, j, x, jj, 0) + dfs(i, jj+1, x, y, k),
// 												  dfs(i, j, x, jj, 1) + dfs(i, jj+1, x, y, k-1)),
// 										 Math.min(dfs(i, j, x, jj, 1) + dfs(i, jj+1, x, y, k-1),
// 												  dfs(i, j, x, jj, 2) + dfs(i, jj+1, x, y, k-2))));
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

}
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！
    public static void main (String[] args) {
		Solution s = new Solution ();
		int [][] a = new int [][] {{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0}};

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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
	// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】