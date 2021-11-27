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

        public int timeRequiredToBuy(int[] t, int k) {
            int n = t.length, sum = Arrays.stream(t).sum();
            int ans = 0, i = -1;
            while (t[k] > 0) {
                i = (i + 1 + n) % n;
                while (t[i] == 0) 
                    i = (i + 1 + n) % n;
                if (t[i] > 0 && t[k] > 0) {
                    ans++;
                    t[i]--;
                    if (i == k && t[k] == 0) return ans;
                }
            }
            return -1;
        }

        private ListNode reverseList(ListNode head) {
            List<Integer> l = new ArrayList<>();
            ListNode r = head;
            while ( r!= null) {
                l.add(r.val);
                r = r.next;
            }
            List<Integer> li = new ArrayList<>();
            for (int i = l.size()-1; i >= 0; i--) 
                li.add(l.get(i));
            r = head;
            int idx = 0;
            while (r != null) {
                r.val = li.get(idx);
                idx++;
                r = r.next;
            }
            return head;
        }
        public ListNode reverseEvenLengthGroups(ListNode head) {
            int idx = 1, cnt = 0, sum = 0, totCnt = 0;
            ListNode r = head,  newHead = head, p = null;
            List<ListNode> arr = new ArrayList<>();
            while (r != null) {
                totCnt++;
                r = r.next;
            }
            r = head;
            while (r != null) {
                while (cnt < idx && r != null) {
                    p = r;
                    r = r.next;
                    cnt++;
                }
                if (cnt == idx) {
                    sum += idx;
                    idx++;
                    cnt = 0;
                    arr.add(newHead);
                    newHead = r;
                    p.next = null;
                }
            }
            if (sum < totCnt) arr.add(newHead);
            ListNode dummy = new ListNode(-1);
            p = dummy;
            for (int i = 0; i < arr.size(); i++) {
                r = arr.get(i);
                if (i % 2 == 0 && (i != arr.size()-1 || i == arr.size()-1 && (totCnt == sum || totCnt != sum && (totCnt - sum) % 2 == 1))
                    || i % 2 == 1 && i == arr.size()-1 && totCnt != sum && (totCnt - sum) % 2 == 1) {
                    p.next = r;
                    while (p.next != null) 
                        p = p.next;
                } else {
                    ListNode cur = reverseList(r);
                    p.next = cur;
                    while (p.next != null) {
                        p = p.next;
                    }
                }
            }
            return dummy.next;
        }

        private class UnionFind {
            int [] id; // parent
            int [] cnt;// size
            public UnionFind (int n) {
                id = new int [n];
                cnt = new int [n];
                for (int i = 0; i < n; i++) {
                    id[i] = i;
                    cnt[i] = 1;
                }
            }
            public int find(int i) {
                while (id[i] != i) {
                    id[i] = id[id[i]];
                    i = id[i];
                }
                return i;
            }
            public boolean sameGroup(int i, int j) {
                return find(i) == find(j);
            }
            public void union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);
                if (rootI != rootJ) {
                    id[rootI] = rootJ;
                    cnt[rootJ] += cnt[rootI];
                }
            }
            public Set<Integer> getCompoent(int idx) {
                Set<Integer> si = new HashSet<>();
                int p = find(idx);
                System.out.println("p: " + p);
                for (int i = 0; i < id.length; i++)  
                    find(i);
                System.out.println(Arrays.toString(id));
                
                for (int i = 0; i < id.length; i++)  {
                    if (id[i] == p)
                        si.add(i);
                }
                return si;
            }
        }
        public boolean[] friendRequests(int n, int[][] rs, int[][] req) { // 这里面还有一点逻辑没能理清楚
            UnionFind uf = new UnionFind(n);
            Map<Integer, Set<Integer>> m = new HashMap<>();
            for (int [] v : rs) {
                m.computeIfAbsent(v[0], z -> new HashSet<>()).add(v[1]);
                m.computeIfAbsent(v[1], z -> new HashSet<>()).add(v[0]);
            }
            boolean [] ans = new boolean[req.length];
            for (int i = 0; i < req.length; i++) {
                int [] cur = req[i];
                if (uf.sameGroup(cur[0], cur[1])) {
                    ans[i] = true;
                    continue;
                }
                if (m.get(cur[0]) != null && m.get(cur[0]).contains(cur[1]) || m.get(cur[1]) != null && m.get(cur[1]).contains(cur[0]))
                    ans[i] = false;
                else {
                    Set<Integer> one = uf.getCompoent(cur[0]);
                    Set<Integer> two = uf.getCompoent(cur[1]);
                    boolean flag = false;
                    for (Integer a : one) 
                        for (Integer b : two) {
                            if (m.get(a) != null && m.get(a).contains(b) || m.get(b) != null && m.get(b).contains(a)) {
                                ans[i] = false;
                                flag = true;
                                break;
                            }
                        }
                    if (flag) continue;
                    ans[i] = true;
                    uf.union(cur[0], cur[1]);
                }
            }
            return ans;
        }

        public String decodeCiphertext(String en, int r) { // 还没有写完，今天太累，实在没有精力去折腾这个该死的字符串
            String [] str = en.split("\\s+");
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (idx < str[0].length()) {
                for (int i = 0; i < str.length; i++) {
                    if (str[i].length() == idx && idx == str[0].length()-1) break;
                    sb.append(str[i].charAt(idx));
                }
                idx++;
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // String a = "ch   ie   pr";
        String a = "iveo    eed   l te   olc";

        String r = s.decodeCiphertext(a, 4);
        System.out.println("r: " + r);
    }
}

