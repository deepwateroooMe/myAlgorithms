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
 
        public int countVowelSubstrings(String t) {  // sliding window思路是对的，只是个数数得不对
            System.out.println("t: " + t);
            int n = t.length(), ans = 0, j = 0;
            char [] s = t.toCharArray();
            Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!sc.contains(s[i])) continue;
                System.out.println("\n i: " + i);
                j = i;
                while (j < n && sc.contains(s[j])) {
                    System.out.println("\n j: " + j);
                    System.out.println("s[j]: " + s[j]);

                    m.put(s[j], m.getOrDefault(s[j], 0) + 1);
                    System.out.println("(m.size() == 5) : " + (m.size() == 5) );
                    if (m.size() == 5) ans++;
                    System.out.println("ans: " + ans);
                    j++;
                }
                System.out.println("j: " + j);
                System.out.println("ans: " + ans);
                if (j - i >= 4 || m.size() == 5) {
                    while (i <= j && m.size() == 5) {
                        System.out.println("\n i: " + i);
                        m.put(s[i], m.get(s[i])-1);
                        if (m.get(s[i]) == 0) m.remove(s[i]);
                        i++;
                        System.out.println("(m.size() == 5) : " + (m.size() == 5) );
                        if (m.size() == 5) ans++;
                        else if (m.size() < 5) break;
                        System.out.println("ans: " + ans);
                    }
                }
                m.clear();
                i = j-1;
            }
            return ans;
        }

        public long countVowels(String t) {
            int n = t.length();
            long sum = 0, ans = 0;
            Set<Character> sc = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
            char [] s = t.toCharArray();
            long [] cnt = new long [n];
            for (int i = 0; i < n; i++) { // O(N^2)
            // for (int i = n-1; i >= 0; i--) {
                sum += (sc.contains(s[i]) ? 1 : 0);
                cnt[i] = sum;
            }
            for (int i = 0; i < n; i++) 
                for (int j = i+1; j <= n; j++) 
                    ans += cnt[j-1] - (i == 0 ? 0 : cnt[i-1]);
            return ans;
            // for (int i = 0; i < n; i++) {
            //     if (!sc.contains(s[i])) continue;
            //     ans += n-i;
            // }
            // System.out.println("ans: " + ans);
            // return ans;
        }

        public int minimizedMaximum(int n, int[] a) {
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
            int m = a.length;
            if (m == 1 && n == 1) return a[0];
            if (m == n) return Arrays.stream(a).max().getAsInt();
            if (n % m == 0) return Arrays.stream(a).max().getAsInt() / (n / m);
            int v = n / m, g = n % m;
            System.out.println("v: " + v);
            System.out.println("g: " + g);

            int max = 0, cnt = 0;
            for (int i = m-1; i >= 0; i--) {
                if (cnt < g) {
                    int cur = a[i] / (v+1) + (a[i] % (v+1) == 0 ? 0 : 1);
                    max = Math.max(max, cur);
                    cnt ++;
                } else {
                    int cur = a[i] / v + (a[i] % v == 0 ? 0 : 1);
                    max = Math.max(max, cur);
                }
            }
            return max;
        }

        private void dfs(int idx, int p, int t, int time, Map<Integer, Set<Integer>> map) { // 自顶向下：走到尽可能远的地方，但往返时间不超过限制
            for (int [] next : adj.get(idx)) {
                if (time + next[1] * 2 <= t)
            }
        }
        // 这里对于重复往返多次，应该纪录的信息想得不是很透
        Map<Integer, Map<Integer, Set<Integer>>> ss = new HashSet<>();  // k: node [0, n-1], v map: time and paths nodes 
        Map<Integer, List<int []>> adj = new HashMap<>();
        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) { // 应该算是树形dp的题目，基本只做了一两题：打家劫舍3，和longest zigzai path长度还不算dp
            for (int [] e : edges) {
                int u = e[0], v = e[1], t = e[2];
                adj.computeIfAbsent(u, z -> new ArrayList<>()).add(new int [] {v, t});;
                adj.computeIfAbsent(v, z -> new ArrayList<>()).add(new int [] {u, t});;
            }
            dfs(0, -1, maxTime, 0, new HashMap<>());
            
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

    // String a = "aeiouu";
    // String a = "unicornarihan";
    // String a = "cuaieuouac";
    // String a = "noosabasboosa";
    // String a = "aba";

        int []  a = new int []  {25, 11, 29, 6, 24, 4, 29, 18, 6, 13, 25, 30};

    int r = s.minimizedMaximum(22, a);
System.out.println("r: " + r);

    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
