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

        // public int smallestEqual(int[] a) {
        //     int n = a.length;
        //     for (int i = 0; i < n; i++) 
        //         if (i % 10 == a[i]) return i;
        //     return -1;
        // }

        // public int[] nodesBetweenCriticalPoints(ListNode head) {
        //     int cnt = 0;
        //     ListNode r = head;
        //     while (r != null) {
        //         cnt++;
        //         r = r.next;
        //     }
        //     if (cnt == 2) return new int [] {-1, -1};
        //     List<Integer> idx = new ArrayList<>();
        //     r = head.next; 
        //     ListNode pre = head, next = r.next;
        //     int i = 1;
        //     while (r.next != null) {
        //         if (r.val > pre.val && r.val > next.val
        //             || r.val < pre.val && r.val < next.val)
        //             idx.add(i);
        //         pre = r;
        //         r = r.next;
        //         next = r.next;
        //         i++;
        //     }
        //     if (idx.size() == 0) return new int [] {-1, -1} ;
        //     int min = Integer.MAX_VALUE, max = 0, minVal = idx.get(0);
        //     for ( i = 1; i < idx.size(); i++) {
        //         min = Math.min(min, idx.get(i) - idx.get(i-1));
        //         minVal = Math.min(minVal, idx.get(i));
        //         max = Math.max(max, idx.get(i) - minVal);
        //     }
        //     int a = min == Integer.MAX_VALUE ? -1 : min;
        //     int b = max == 0 ? -1 : max;
        //     return new int [] {a, b};


// }

        // private List<String> parsesur(String t) {
        //     int n = t.length();
        //     char [] s = t.toCharArray();
        //     List<String> l = new ArrayList<>();
        //     int i = 0, j = 0;
        //     while (i < n) {
        //         while (i < n && Character.isLowerCase(s[i])) i++;
        //         if (i > j) l.add(t.substring(j, i));
        //         if (i == n) return l;
        //         j = i;
        //         while (i < n && Character.isDigit(s[i])) i++;
        //         l.add(t.substring(j, i));
        //         j = i;
        //     }
        //     return l;
        // }
        // Set<Integer> parseIntString(String s) {
        //     int n = s.length();
        //     Set<Integer> set = new HashSet<>();
        //     for (int d = 1; d <= n; d++) 
        //         for (int i = 0; i+d <=  n; i++) 
        //             set.add(Integer.parseInt(s.substring(i, i+d)));
        //     return set;
        // }
        // List<Set<Integer>> parseInt(List<String> l) {
        //     List<Set<Integer>> ans = new ArrayList<>();
        //     int cnt = 0;
        //     for (int i = 0; i < l.size(); i++) 
        //         if (Character.isDigit(l.get(i).charAt(0)))
        //             ans.add(parseIntString(l.get(i)));
        //         else cnt += l.get(i).length();
        //     Set<Integer> len = new HashSet<>();
        //     len.add(cnt);
        //     ans.add(0, len);
        //     return ans;
        // }
        // private void getLenSet(List<Set<Integer>> ls, int i, Set<Integer> vis) {
        //     if (i == 1) {
        //         vis.addAll(ls.get(i));
        //         return ;
        //     }
        //     Set<Integer> next = new HashSet<>();
        //     // next.addAll(ls.get(i));
        //     for (Integer v : vis) 
        //         for (Integer vi : ls.get(i)) 
        //             next.add(v + vi);
        //     vis.addAll(next);
        // }
        // Set<Integer> res;
        // Set<Integer> getLength(List<Set<Integer>> ls) {
        //     if (ls.size() == 2) return ls.get(1);
        //     res = new HashSet<>();
        //     getLenSet(ls, 1, res);
        //     return new HashSet<>(res);
        // }
        // private boolean equals(Map<Character, Integer> m, Map<Character, Integer> n) {
        //     if (m.size() != n.size()) return false;
        //     for (char key : m.keySet()) 
        //         if (!n.containsKey(key) || n.get(key) != m.get(key)) return false;
        //     return true;
        // }
        // private boolean leftOrRightMatches(String s, String t) { // 这个corner case不知道该如何填坑了
            
        // }
        // public boolean possiblyEquals(String ss, String tt) {
        //     int m = ss.length(), n = tt.length();
        //     Map<Character, Integer> ma = new HashMap<>();
        //     Map<Character, Integer> mb = new HashMap<>();
        //     for (char c : ss.toCharArray()) 
        //         if (Character.isLowerCase(c))
        //             ma.put(c, ma.getOrDefault(c, 0) + 1);
        //     for (char c : tt.toCharArray()) 
        //         if (Character.isLowerCase(c))
        //             mb.put(c, mb.getOrDefault(c, 0) + 1);
        //     List<String> a = parsesur(ss);
        //     List<String> b = parsesur(tt);
        //     // System.out.println("a.size(): " + a.size());
        //     // System.out.println(Arrays.toString(a.toArray()));
        //     // System.out.println("b.size(): " + b.size());
        //     // System.out.println(Arrays.toString(b.toArray()));
        //     List<Set<Integer>> aa = parseInt(a);
        //     List<Set<Integer>> bb = parseInt(b);
        //     // System.out.println("aa.get(0).size(): " + aa.get(0).size());
        //     // System.out.println(Arrays.toString(aa.get(0).toArray()));
        //     // System.out.println("bb.get(0).size(): " + bb.get(0).size());
        //     // System.out.println(Arrays.toString(bb.get(0).toArray()));
        //     // System.out.println("bb.get(1).size(): " + bb.get(1).size());
        //     // System.out.println(Arrays.toString(bb.get(1).toArray()));
        //     Set<Integer> tmp = new HashSet<>();
        //     tmp.add(0);
        //     if (aa.size() < 2) aa.add(tmp);
        //     if (bb.size() < 2) bb.add(tmp);
        //     Set<Integer> left = getLength(aa);
        //     Set<Integer> right = getLength(bb);
        //     for (Integer va : left) 
        //         for (Integer vb : right) 
        //             if (aa.get(0).iterator().next() + va == bb.get(0).iterator().next() + vb)
        //                 return true;
        //     return false;
        // }
        // // "a5b"
        // // "c5b"



        public int minimumOperations(int[] a, int start, int goal) {
            if (start == goal) return 0;
            int n = a.length;
            if (start < 0 || start > 1000) return -1;
            // Queue<int []> q = new PriorityQueue<>((a, b) -> Math.abs(a-goal) - Math.abs(b-goal));
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            Set<Integer> vis = new HashSet<>();
            vis.add(start);
            int cnt = 0;
            while (!q.isEmpty()) {
                for (int size = q.size()-1; size >= 0; size--) {
                    int cur = q.poll();
                    for (int v : a) {
                        if (cur+v == goal || cur-v == goal || (cur^v) == goal) return cnt + 1;
                        if (!vis.contains(cur + v)) {
                            if (cur +v  >=0 && cur + v <= 1000) {
                                q.offer(cur + v);
                                vis.add(cur+v);
                            }
                        }
                        if (!vis.contains(cur - v)) {
                            if (cur -v  >=0 && cur - v <= 1000) {
                                q.offer(cur - v);
                                vis.add(cur - v);
                            }
                        }
                        if (!vis.contains(cur^v)) {
                            if ((cur ^v)  >=0 && (cur ^ v) <= 1000) {
                                q.offer(cur ^ v);
                                vis.add(cur^v);
                            }
                        }
                    }
                }
                cnt++;
            }
            return -1;
        }
        // public int minimumOperations(int[] a, int start, int goal) { // 
        //     if (start == goal) return 0;
        //     int n = a.length;
        //     if (start < 0 || start > 1000) return -1;
        //     Queue<int []> q = new PriorityQueue<>((c, b) -> Math.abs(c-goal) - Math.abs(b-goal));
        //     // Queue<Integer> q = new LinkedList<>();
        //     q.offer(new int [] {start, 0});
        //     Set<Integer> vis = new HashSet<>();
        //     vis.add(start);
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         for (int size = q.size()-1; size >= 0; size--) {
        //             int [] cur = q.poll();
        //             for (int v : a) {
        //                 if (cur[0]+v == goal || cur[0]-v == goal || (cur[0]^v) == goal) return cur[1] + 1;
        //                 if (!vis.contains(cur[0] + v)) {
        //                     // if (cur[0] + v == goal) return cnt + 1;
        //                     if (cur[0] +v  >=0 && cur[0] + v <= 1000)
        //                         q.offer(new int [] {cur[0] + v, cur[1] + 1});
        //                     vis.add(cur[0]+v);
        //                 }
        //                 if (!vis.contains(cur[0] - v)) {
        //                     // if (cur[0] - v == goal) return cnt - 1;
        //                     if (cur[0] -v  >=0 && cur[0] - v <= 1000)
        //                         q.offer(new int [] {cur[0] - v, cur[1] - 1});
        //                         // q.offer(cur[0] - v);
        //                     vis.add(cur[0] - v);
        //                 }
        //                 if (!vis.contains(cur[0]^v)) {
        //                     // if ((cur[0] ^ v) == goal) return cnt ^ 1;
        //                     if ((cur[0] ^v)  >=0 && (cur[0] ^ v) <= 1000)
        //                         q.offer(new int [] {cur[0] ^ v, cur[1] ^ 1});
        //                         // q.offer(cur[0] ^ v);
        //                     vis.add(cur[0]^v);
        //                 }
        //             }
        //         }
        //         cnt++;
        //     }
        //     return -1;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "a5b";
        String b = "c5b";

        // String a = "internationalization";
        // String b = "i18n";

        boolean r = s.possiblyEquals(a, b);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
