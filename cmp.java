import com.TreeNode;
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
    // public static class Solution {

    //     public int convertTime(String current, String correct) {
    //         int cur = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
    //         int tar = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));
    //         int dif = tar - cur;
    //         return dif / 60 + (dif % 60) / 15 + dif % 60 % 15 / 5 + dif % 60 % 15 % 5;
    //     }

    //     public List<List<Integer>> findWinners(int[][] matches) {
    //         int n = 100001;
    //         int [] win = new int [n], tt = new int [n], lose = new int [n];// count && total
    //         for (int [] v : matches) {
    //             tt[v[0]]++;
    //             tt[v[1]]++;
    //             win[v[0]]++;
    //             lose[v[1]]++;
    //         }
    //         List<Integer> winAll = new ArrayList<>();
    //         List<Integer> loseOne = new ArrayList<>();
    //         for (int i = 0; i < n; i++) {
    //             if (tt[i] == 0) continue;
    //             if (tt[i] == win[i]) winAll.add(i);
    //             else if (lose[i] == 1 && tt[i] == win[i] + 1) loseOne.add(i);
    //         }
    //         List<List<Integer>> ans = new ArrayList<>();
    //         ans.add(winAll);
    //         ans.add(loseOne);
    //         return ans;
    //     }

    //     public int maximumCandies(int[] a, long k) { // k: [1, 10^12]
    //         n = a.length; // [1, 10^5]
    //         Arrays.sort(a);
    //         int l = 1, r = a[n-1], ans = 0;
    //         while (l <= r) {
    //             int m = l + (r - l) / 2;
    //             long cnt = getCnt(m, a);
    //             if (cnt >= k) {
    //                 ans = Math.max(ans, m);
    //                 l = m+1;
    //             } else r = m-1;
    //         }
    //         return ans;
    //     }
    //     int n;
    //     long getCnt(long v, int [] a) {
    //         int idx = 0;
    //         long cnt = 0;
    //         while (idx < n) {
    //             while (idx < n && a[idx] < v) idx++;
    //             cnt += a[idx] / v;
    //             idx++;
    //         }
    //         return cnt;
    //     }

        // class Encrypter {

     Map<Character, String> map = new HashMap<>();
    // Map<String, List<Integer>> idx = new HashMap<>();
    Map<String, List<Character>> inv = new HashMap<>();
    Set<String> ss = new HashSet<>();
    Trie trie;
    public Encrypter(char[] keys, String[] values, String[] dic) {
    // public cmp(char[] keys, String[] values, String[] dic) {
        for (int i = 0; i < keys.length; i++) 
            map.put(keys[i], values[i]);
        ss.addAll(Arrays.asList(values)); // 存在的长度为2的字符串
        for (int i = 0; i < values.length; i++) {
            // idx.computeIfAbsent(values[i], z -> new ArrayList<>()).add(i);
            inv.computeIfAbsent(values[i], z -> new ArrayList<>()).add(keys[i]);
        }
        trie = new Trie();
        for (String s : dic) 
            trie.insert(s);
    }
    
    public String encrypt(String word1) {
        String ans = "";
        for (char c : word1.toCharArray()) 
            ans += map.get(c);
        return ans;
    }
    
    public int decrypt(String t) { // 这里关于下标的处理还有点儿没有做完: 185/203 爱表哥，爱生活~~
        int n = t.length();
        char [] s = t.toCharArray();
        ans = new HashSet<>();
        String upto = "";
        for (int i = 0; i < n-1; i += 2) {
            String cur = t.substring(i, i+2);
            if (ss.contains(cur)) {
                String tmp = upto;
                for (char c : inv.get(cur)) {
                    tmp += c;
                    if (!trie.startWith(tmp)) continue;
                    decrypt(t, i+2, upto+c);
                }
            } else return 0;
        }
        System.out.println("ans.size(): " + ans.size());
        System.out.println(Arrays.toString(new ArrayList<>(ans).toArray()));

        return ans.size();
    }
    Set<String> ans;
    void decrypt(String t, int idx, String bgn) {
        if (idx == t.length()) {
            ans.add(bgn);
            return ;
        }
        // for (int i = idx; i < t.length(); i += 2) {
            String cur = t.substring(idx, idx+2);
            if (ss.contains(cur)) {
                String tmp = bgn;
                for (char c : inv.get(cur)) {
                    tmp += c;
                    if (!trie.startWith(tmp)) continue;
                    decrypt(t, i+2, tmp);
                }
            } else return;
        // }
    }
    public class Trie {
        private class Node {
            public boolean end;
            public Node [] next;
            public Node() {
                this.end = false;
                next = new Node[26];
            }
        }
        private Node root;
        public Trie() { root = new Node(); }
        public void insert(String t) {
            Node r = root;
            int n = t.length();
            char [] s = t.toCharArray();
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (r.next[j] == null) 
                    r.next[j] = new Node();
                r = r.next[j];
            }
            r.end = true;
        }
        public boolean startWith(String t) {
            int n = t.length();
            if (n == 0) return false;
            char [] s = t.toCharArray();
            Node r = root;
            for (int i = 0; i < n; i++) {
                int j = s[i] - 'a';
                if (r.next[j] == null) return false;
                r = r.next[j];
            }
            return true;
        }
        // public int search(int va) {
        //     int max = 0;
        //     Node cur = root;
        //     for (int i = 31; i >= 0; i--) {
        //         int t = (va >> i) & 1;
        //         if (cur.next[t^1] != null) {
        //             max += (1 << i);
        //             cur = cur.next[t^1];
        //         } else cur = cur.next[t&1];
        //     }
        //     return max;
        // }
        // public void insert(int va) {
        //     Node cur = root;
        //     for (int i = 31; i >= 0; i--) {
        //         int tmp = (va >> i) & 1;
        //         if (cur.next[tmp] == null)
        //             cur.next[tmp] = new Node();
        //         cur = cur.next[tmp];
        //     }
        //     cur.isExist = true;
        // }
    }
    // }
    public static void main(String args[]) {
        // Solution s = new Solution();

        char [] a = new char [] {'a', 'b', 'c', 'd'}; 
        String [] b = new String [] {"ei", "zf", "ei", "am"};
        String [] c = new String [] {"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};

        cmp s = new cmp(a, b, c);

        String r = s.encrypt("abcd"); // return "eizfeiam". 
        System.out.println("r: " + r);
        
        // 'a' maps to "ei", 'b' maps to "zf", 'c' maps to "ei", and 'd' maps to "am".
        int r1 = s.decrypt("eizfeiam"); // return 2. 
        System.out.println("r1: " + r1);
        
        // "ei" can map to 'a' or 'c', "zf" maps to 'b', and "am" maps to 'd'. 
        // Thus, the possible strings after decryption are "abad", "cbad", "abcd", and "cbcd". 
        // 2 of those strings, "abad" and "abcd", appear in dictionary, so the answer is 2.        
        
        // int r = s.maximumCandies(a, 4);
        // System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
