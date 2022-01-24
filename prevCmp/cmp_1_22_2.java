// import com.ListNode;

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

        public int countElements(int[] a) {
            int n = a.length, ans = 0;
            TreeMap<Integer, Integer> m = new TreeMap<>();
            for (int v : a)
                m.put(v, m.getOrDefault(v, 0) + 1);
            for (Integer key : m.keySet()) {
                Integer lo = m.lowerKey(key), hi = m.higherKey(key);
                if (lo != null && hi != null)
                    ans += m.get(key);
            }
            return ans;
        }

        public int[] rearrangeArray(int[] a) {
            int n = a.length, i = 0, j = 0, k = 0;
            int [] ans = new int [n];
            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();
            for (int v : a) {
                if (v > 0) pos.add(v);
                else neg.add(v);
            }            
            while (k < n) {
                if (k % 2 == 0) ans[k++] = pos.get(i++);
                else ans[k++] = neg.get(j++);
            }
            return ans;
        }

        public List<Integer> findLonely(int[] a) {
            int n = a.length;
            TreeMap<Integer, Integer> m = new TreeMap<>();
            for (int v : a) m.put(v, m.getOrDefault(v, 0) + 1);
            List<Integer> ans = new ArrayList<>();
            for (Integer key : m.keySet()) {
                if (m.get(key) > 1) continue;
                if (!m.containsKey(key-1) && !m.containsKey(key+1))
                    ans.add(key);
            }
            return ans;
        }

        public List<List<Integer>> subsets(int[] a) { // 这种应该是最简单最快的了
            int n = a.length, r = (1 << n);
            List<List<Integer>> ll = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                List<Integer> l = new ArrayList<>();
                if (i == 0) {
                    ll.add(l);
                    continue;
                }
                for (int j = 0; j < n; j++) 
                    if (((i >> j) & 1) == 1) l.add(a[j]);
                ll.add(l);
            }
            return ll;
        }
        public List<List<Integer>> subsets(int[] a) { // 在后面的动态规划中也会常用到，还是需要熟悉一下
            int n = a.length, r = (1 << n);
            List<List<Integer>> ll = new ArrayList<>();
            ll.add(new ArrayList<>());
            for (int v : a) {
                List<List<Integer>> tmp = new ArrayList<>();
                for (List<Integer> l : ll)
                    tmp.add(new ArrayList<>(l) {{ add(v); }}); // 这种写法，见过一次，上次找了半天也没能找出来
                for (List<Integer>  l : tmp) 
                    ll.add(l);
            }
            return ll;
        }
        public List<List<Integer>> subsets(int[] a) { // 这个最原始的、回溯的写法被我忘记了。。。。。。
            n = a.length;
            vis = new boolean [n];
            getASubset(new ArrayList<>(), 0, a);
            return ll;
        }
        List<List<Integer>> ll = new ArrayList<>();
        boolean [] vis;
        int n;
        void getASubset(List<Integer> l, int idx, int [] a) {
            if (idx == n) {
                ll.add(new ArrayList<>(l));
                return ;
            }
            getASubset(l, idx+1, a);
            l.add(a[idx]);
            getASubset(l, idx+1, a);
            l.remove(l.size()-1);
        }

        public int maximumGood(int[][] a) {
            int n = a.length, ans = 0;
            for (int i = 1 << n; i < 1 << (n+1); i++) {
                String perm = Integer.toBinaryString(i).substring(1);
                if (valid(perm, a, n)) {
                    int cnt = Integer.bitCount(Integer.parseInt(perm, 2)); // base 2
                    ans = Math.max(ans, cnt);
                }
            }
            return ans;
        }
        boolean valid(String t, int [][] a, int n) {
            // int v = Integer.parseInt(t, 2); // base 2: 狠重要
            char [] s = t.toCharArray(); // 这么着更快; 对于base就没有那么多顾虑了
            for (int i = 0; i < n; i++) {
                if (s[i] == '0') continue; // 这一位是0 bad,它有可能是在撒谎，暂时不管，到时检查冲突就可以了
                // if (((v >> i) & 1) == 0) continue; 
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == 2) continue; // 是自己或其它没有评价
                    if (a[i][j] == 1 && s[j] == '0' || a[i][j] == 0 && s[j] == '1') // i已经检查过了，现在就是检查j了
                    // if (a[i][j] == 1 && ((v >> j) & 1) == 0 || a[i][j] == 0 && ((v >> j) & 1) == 1)
                        return false;
                }
            }
            return true;
        }
    }   
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [][] a = new int [][] {{2,1,2},{1,2,2},{2,0,2}};
        // int [][] a = new int [][] {{2,0},{0,2}};
        int [][] a = new int [][] {{2,1,1,1},{1,2,1,1},{1,1,2,1},{1,1,1,2}};

        int r = s.maximumGood(a);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
