// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.math.BigInteger;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
public class mthreeixed {
    public static class Solution {
        // public boolean digitCount(String t) {
        //     int n = t.length(), r [] = new int [10];
        //     char [] s = t.toCharArray();
        //     for (char c : s) 
        //         r[c-'0']++;
        //     for (int i = 0; i < n; i++) 
        //         if (s[i] - '0' != r[i]) return false;
        //     return true;
        // }
        // public int rearrangeCharacters(String s, String target) {
        //     Map<Character, Integer> m = new HashMap<>();
        //     Map<Character, Integer> n = new HashMap<>();
        //     for (char c : s.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);
        //     for (char c : target.toCharArray()) n.put(c, n.getOrDefault(c, 0) + 1);
        //     int r = Integer.MAX_VALUE;
        //     for (Map.Entry<Character, Integer> en : n.entrySet()) {
        //         char k = en.getKey();
        //         int v = en.getValue();
        //         if (!m.containsKey(k)) return 0;
        //         r = Math.min(r, m.get(k) / v);
        //     }
        //     return r;
        // }

        // public int totalSteps(int[] a) {// TODO TODO TODO 糊糊糊。。。。。
        //     int n = a.length, f [] = new int [n], max = 0; // f: dp
        //     Deque<Integer> s = new ArrayDeque<>();
        //     f[0] = 0;
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && a[s.peek()] < a[i]) {
        //             f[i] = Math.max(f[i] + 1, f[s.pollFirst()]);
        //             max = Math.max(max, f[i]);
        //         }
        //         s.offerFirst(i);
        //     }
        //     return max;
        // }

        // public int minimumObstacles(int[][] a) { 
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     int m = a.length, n = a[0].length;
        //     boolean [][] vis = new boolean [m][n];
        //     // Deque<int []> q = new ArrayDeque<>(); // 【优先队列：】当要找一个最XXX 的时候，当要排序的时候，就一定得一定得用优先队列！！！
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
        //     q.offer(new int [] {0, 0});
        //     vis[0][0] = true;
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         int x = cur[0] / n, y = cur[0] % n;
        //         for (int [] d : dirs) {
        //             int i = x + d[0], j = y + d[1];
        //             if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) continue;
        //             if (i == m-1 && j == n-1) return cur[1];
        //             q.offer(new int [] {i*n+j, cur[1] + a[i][j]});
        //             vis[i][j] = true;
        //         }
        //     }
        //     return -1;
        // }

        // public boolean strongPasswordCheckerII(String t) {
        //     int n = t.length(), i = 0;
        //     char [] s = t.toCharArray();
        //     if (n < 8) return false;
        //     boolean lo = false, hi = false, dg = false, sp = false, rp = false;
        //     Set<Character> sc = new HashSet<>("!@#$%^&*()-+".chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
        //     for (char c : s) {
        //         if (Character.isLowerCase(c)) lo = true;
        //         else if (Character.isUpperCase(c)) hi = true;
        //         else if (Character.isDigit(c)) dg = true;
        //         else if (sc.contains(c)) sp = true;
        //         if (i > 0 && s[i] == s[i-1]) rp = true;
        //         i++;
        //     }
        //     return lo && hi && dg && sp && !rp;
        // }

        // public int minOperations(int[] a, int[] b) {
        //     int m = a.length, n = b.length;
        //     int gcd = getGCD(b);
        //     Arrays.sort(a);
        //     for (int i = 0; i < m; i++) 
        //         if (gcd % a[i] == 0) return i;
        //     return -1;
        // }
        // int getGCD(int [] a) {
        //     int g = a[0];
        //     for (int v : a) 
        //         g = gcd(g, v);
        //     return g;
        // }
        // int gcd(int a, int b) {
        //     return b == 0 ? a : gcd(b, a % b);
        // }
    }
    public static void main (String[] args) {
        Solution s  =  new Solution ();

        String a = "IloveLe3tcode!";

        boolean r = s.strongPasswordCheckerII(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);






