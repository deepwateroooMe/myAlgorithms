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

        public int prefixCount(String[] words, String pref) {
            int cnt = 0;
            for (String s : words) 
                if (s.startsWith(pref)) cnt++;
            return cnt;
        }

        public int minSteps(String ss, String tt) {
            int [] cs = new int [26], ct = new int [26];
            char [] s = ss.toCharArray();
            char [] t = tt.toCharArray();
            for (char c : s) 
                cs[c-'a']++;
            for (char c : t) 
                ct[c-'a']++;
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (cs[i] == ct[i]) continue;
                ans += Math.abs(cs[i] - ct[i]);
            }
            return ans;
        }

        public long minimumTime(int[] time, int totalTrips) {
            int n = time.length;
            Arrays.sort(time);
            long l = 1, r = (long)totalTrips * time[n-1];
            while (l < r) {
                long m = l + (r - l) / 2;
                if (getCnt(time, m) >= (long)totalTrips) {
                    // ans = m;
                    // System.out.println("ans: " + ans);
                    // r = m - 1;
                    r = m;
                } else l = m + 1;
            }
            return l;
            // return ans;
        }
        long getCnt(int [] time, long val) {
            long cnt = 0;
            for (int v : time) {
                // if (v > val) continue;
                cnt += val / (long)v;
            }
            return cnt;
        }

        public int mostFrequent(int[] a, int key) {
            int max = 0, maxVal = 0;
            Map<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] == key) {
                    m.put(a[i+1], m.getOrDefault(a[i+1], 0) + 1);
                    if (m.get(a[i+1]) >= max) {
                        maxVal = a[i+1];
                        max = m.get(a[i+1]);
                    }
                }
            }
            return maxVal;
        }

        public int[] sortJumbled(int[] m, int[] a) {
            int n = a.length;
            List<int []> l = new ArrayList<>();
            for (int v : a) 
                l.add(new int [] {v, getMappedVal(v, m)});
            Collections.sort(l, (x, y)->x[1] - y[1]);
            for (int i = 0; i < a.length; i++)
                a[i] = l.get(i)[0];
            return a;
        }
        int getMappedVal(int v, int [] m) {
            int ans = 0, cur = 1;
            if (v == 0) return m[v];
            while (v > 0) {
                ans += m[v % 10] * cur;
                cur *= 10;
                v /= 10;
            }
            return ans;
        }

        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            Map<Integer, Set<Integer>> adj = new HashMap<>(); // 每个Node的直接父结点链表
            Map<Integer, List<Integer>> m = new HashMap<>();
            int [] ins = new int [n];
            for (int [] e : edges) {
                adj.computeIfAbsent(e[0], z -> new HashSet<>()).add(e[1]);
                m.computeIfAbsent(e[1], z -> new ArrayList<>()).add(e[0]);
                ins[e[1]]++;
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) 
                if (ins[i] == 0) q.offerLast(i);
            List<List<Integer>> ans = new ArrayList<>(n);
            for (int i = 0; i < n; i++) 
                ans.add(new ArrayList<>());
            while (!q.isEmpty()) {
                int cur = q.pollLast();
                if (adj.get(cur) != null) {
                    for (int v : adj.get(cur)) {
                        if (--ins[v] == 0)
                            q.offerLast(v);
                    }
                }
                Set<Integer> s = new HashSet<>();
                if (m.get(cur) == null) continue;
                for (int v : m.get(cur)) 
                    s.addAll(ans.get(v));
                s.addAll(m.get(cur));
                ans.get(cur).addAll(s);
                Collections.sort(ans.get(cur));
            }
            return ans;
        }

        public int minMovesToMakePalindrome(String s) {
            int cnt = 0;
            while (s.length() > 2) {
                char bgn = s.charAt(0);
                int n = s.length();
                char end = s.charAt(n-1);
                if (bgn == end) {
                    s = s.substring(1, n-1);
                    continue;
                }
                int idx1 = s.lastIndexOf(bgn);
                int idx2 = s.indexOf(end);
                int cnt1 = n - idx1 - 1;
                int cnt2 = idx2;
                StringBuilder sb = new StringBuilder();
                if (cnt1 > cnt2) {
                    cnt += cnt2;
                    sb.append(s.substring(0, idx2));
                    sb.append(s.substring(idx2+1, n-1));
                } else {
                    cnt += cnt1;
                    sb.append(s.substring(1, idx1));
                    sb.append(s.substring(idx1 + 1));
                }
                s = sb.toString();
            }
            return cnt;
        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};

        List<List<Integer>> r = s.getAncestors(8, a);
        System.out.println("r.size(): " + r.size());
        for (int z = 0; z < r.size(); ++z) 
            System.out.println(Arrays.toString(r.get(z).toArray()));
        
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);


