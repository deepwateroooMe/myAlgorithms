// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class trieC {
    public static class Solution {

        // public class Trie {
        //     private class Node {
        //         public char val;
        //         public boolean isWord;
        //         public TreeMap<Character, Node> next;
        //         public Node(boolean isWord) {
        //             this.isWord = isWord;
        //             next = new TreeMap<>();
        //         }
        //         public Node() {
        //             this(false);
        //         }
        //         public Node(char va) {
        //             this(true);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(String word) {
        //         Node cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (cur.next.get(c) == null) 
        //                 cur.next.put(c, new Node());
        //             cur = cur.next.get(c);
        //         }
        //         if (!cur.isWord) 
        //             cur.isWord = true;
        //     }
        //     public boolean startsWith(String prefix) {
        //         Node cur = root;
        //         for (int i = 0; i < prefix.length(); i++) {
        //             char c = prefix.charAt(i);
        //             if (cur.next.get(c) == null) return false;
        //             cur = cur.next.get(c);
        //         }
        //         return true;
        //     }
        //     public boolean search(String word) {
        //         Node cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (cur.next.get(c) == null)
        //                 return false;
        //             cur = cur.next.get(c);
        //         }
        //         return cur.isWord;
        //     }
        //     HashSet<String> ss = new HashSet<>();
        //     private void traversalTree(Node r, String s) {
        //         if (r == null) return;
        //         if (r.isWord) ss.add(new String(s));
        //         for (Character key : r.next.keySet()) {
        //             traversalTree(r.next.get(key), s+key);
        //         }
        //     }
        //     public int getMaxXOR(int val) {
        //         traversalTree(root, "");
        //         int max = 0;
        //         for (String v : ss) 
        //             max = Math.max(max, Integer.parseInt(v, 2) ^ val);
        //         return max;
        //     }
        // }

        
        // public class Trie {
        //     private class Node {
        //         public char val;
        //         public boolean isWord;
        //         public Node [] next;
        //         public Node(boolean isWord) {
        //             this.isWord = isWord;
        //             next = new Node[26];
        //         }
        //         public Node() {
        //             this(false);
        //         }
        //         public Node(char va) {
        //             this(true);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(String word) {
        //         Node cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (cur.next[c-'a'] == null) 
        //                 cur.next[c-'a'] = new Node();
        //             cur = cur.next[c-'a'];
        //         }
        //         if (!cur.isWord) cur.isWord = true;
        //     }
        //     public boolean startsWith(String prefix) {
        //         Node cur = root;
        //         for (int i = 0; i < prefix.length(); i++) {
        //             char c = prefix.charAt(i);
        //             if (cur.next[c-'a'] == null) return false;
        //             cur = cur.next[c-'a'];
        //         }
        //         return true;
        //     }
        //     public boolean search(String word) {
        //         Node cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (cur.next[c-'a'] == null)
        //                 return false;
        //             cur = cur.next[c-'a'];
        //         }
        //         return cur.isWord;
        //     }
        // }
        // public String longestWord(String[] words) {
        //     int n = words.length;
        //     Arrays.sort(words, new java.util.Comparator<String>() {
        //             @Override public int compare(String s, String t) {
        //                 int comp = s.length() - t.length();
        //                 if (comp != 0) return comp;
        //                 for (int i = 0; i < s.length(); i++) {
        //                     if (s.charAt(i) != t.charAt(i))
        //                         return s.charAt(i) - t.charAt(i);
        //                 }
        //                 return -1; 
        //             }
        //         });
        //     Trie t = new Trie();
        //     StringBuilder res = (words[0].length() == 1) ? new StringBuilder (words[0]) : new StringBuilder();
        //     t.insert(words[0]);
        //     int j = 0, preLength = words[0].length();
        //     for (int i = 1; i < n; i++) {
        //         j = 0;
        //         for ( j = 0; j < words[i].length()-1; j++) {
        //             if (!t.search(words[i].substring(0, j+1))) break;
        //         }
        //         if (j == words[i].length()-1 && words[i].length() > preLength) {
        //             res = new StringBuilder (words[i]);
        //             preLength = words[i].length();
        //         }
        //         t.insert(words[i]);
        //     }
        //     return res.toString();
        // }


        // 我自己的暴力解法，应该是还存在着有bug的
        // public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //     int m = words.length;
        //     int n = puzzles.length;
        //     int [] res = new int [n];
        //     int tmp = 0, cnt = 0, j = 0, o = 0;
        //     HashSet<Integer> s = new HashSet<>();
        //     for (int i = 1; i <= 7; i++) {
        //         tmp |= (1 << i);
        //         s.add(tmp);
        //     }
        //     Set<Character> sc = new HashSet<>();
        //     for (int i = 0; i < n; i++) { // map to res
        //         sc = puzzles[i].chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        //         for (int k = 0; k < m; k++) { // loop all words
        //             tmp = 0;
        //             j = 0;
        //             o = words[k].length();
        //             while (j < o && words[k].charAt(j) != puzzles[i].charAt(0)) ++j;
        //             if (j == o) continue;
        //             j = 0;
        //             while (j < words[k].length() && sc.contains(words[k].charAt(j))) {
        //                 tmp = tmp | (1 << j+1);
        //                 ++j;
        //             } 
        //             if (j == o && s.contains(tmp)) ++cnt;
        //         }
        //         res[i] = cnt;
        //         cnt = 0;
        //         sc.clear();
        //     }
        //     return Arrays.stream(res).boxed().collect(Collectors.toList());
        // }
        // public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //     HashMap<Integer, Integer> map = new HashMap<>();
        //     for (String word : words) {
        //         int key = 0;
        //         for (int i = 0; i < word.length(); i++) 
        //             key |= (1 << word.charAt(i)-'a');
        //         map.put(key, map.getOrDefault(key, 0) + 1);
        //     }
        //     List<Integer> res = new ArrayList<>();
        //     for (int i = 0; i < puzzles.length; i++) {
        //         String puz = puzzles[i];              // 当前谜面
        //         int fstKey = 1 << (puz.charAt(0)-'a');
        //         int cnt = map.getOrDefault(fstKey, 0);
        //         List<Integer> keyList = new ArrayList<>();
        //         for (int j = 1; j < 7; j++) { // puz word chars  // 以下操作为谜面中遍历每种字母组合
        //             List<Integer> l = new ArrayList<>();
        //             int cur = 1 << (puz.charAt(j)-'a') | fstKey;
        //             cnt += map.getOrDefault(cur, 0);
        //             l.add(cur);
        //             for (int va : keyList) {
        //                 int newKey = va | cur;
        //                 cnt += map.getOrDefault(newKey, 0);
        //                 l.add(newKey);
        //             }
        //             keyList.addAll(l);
        //         }
        //         res.add(cnt);
        //     }
        //     return res;
        // }


        // public List<String> removeSubfolders(String[] folder) {
        //     int n = folder.length;
        //     Arrays.sort(folder);
        //     String [] arr = new String [n]; 
        //     List<String> res = new ArrayList<>();
        //     String root = folder[0]+"/";
        //     res.add(folder[0]);
        //     for (int i = 1; i < n; i++) { //
        //         String f = folder[i];
        //         if (f.length() < root.length() || !f.startsWith(root)) {
        //             root = f+"/";
        //             res.add(f);
        //         }
        //     }
        //     return res;
        // }

       // private boolean isMatch(String s, String t, int i, int j) {
       //      int n = s.length();
       //      int m = t.length();
       //      if (j == m) {
       //          while (i < n && Character.isLowerCase(s.charAt(i))) ++i;
       //          if (i == n)
       //              return true;
       //          return false;
       //      }
       //      if (i == n) return false;
       //      if (s.charAt(i) == t.charAt(j)) return isMatch(s, t, i+1, j+1);
       //      if (Character.isLowerCase(s.charAt(i))) return isMatch(s, t, i+1, j);
       //      return false;
       //  }
       //  public List<Boolean> camelMatch(String[] queries, String pattern) {
       //      List<Boolean> res = new ArrayList<>();
       //      for (int i = 0; i < queries.length; i++) {
       //          res.add(isMatch(queries[i], pattern, 0, 0));
       //      }
       //      return res;
       //  }

        // public int minimumLengthEncoding(String[] words) {
        //     int n = words.length;
        //     String [] arr = new String [n];
        //     for (int i = 0; i < n; i++) 
        //         arr[i] = new StringBuilder(words[i]).reverse().toString();
        //     Arrays.sort(arr);
        //     String last = arr[n-1];
        //     int res = arr[n-1].length()+1;
        //     for (int i = n-2; i >= 0; i--) {
        //         if (!last.startsWith(arr[i])) {
        //             res += arr[i].length()+1;
        //             last = arr[i];
        //         }
        //     }
        //     return res;
        // }
        // // 解法II 字典树
        // // 将word倒序后，插入字典树trie
        // // 层次遍历trie，将叶子节点的深度累加即为答案
        // // http://bookshadow.com/weblog/2018/04/22/leetcode-short-encoding-of-words/


        // // 我们需要使用每个字典中的单词去和S比较，看它是否是S的子序列。不过这种比较非常耗费时间，因此我们需要对S进行一下预处理。
        // // 首先定义一个二维数组arr[][]，其中 arr[i][j]代表距离S中第i位字符最近的j字符的位置。
        // // 换句话说，我们需要遍历一边字符串，记录下字符串S每一位上的字符，在它右侧距离它最近的a-z分别在哪。
        // public int numMatchingSubseq(String s, String[] words) {
        //     int n = s.length();
        //     int [][] arr = new int [n][26]; // 预处理用的数组
        //     for (int i = n-2; i >= 0; i--) {// 预处理
        //         arr[i] = Arrays.copyOf(arr[i+1], 26);
        //         arr[i][s.charAt(i+1)-'a'] = i+1;
        //     }
        //     int res = 0, idxAtS = 0, idx = 0, cur = 0;
        //     for (String v : words) {        // 比较每一个单词
        //         idxAtS = 0;                 // 对应S的下标
        //         idx = 0;                    // 当前单词下标
        //         if (v.charAt(0) == s.charAt(0)) { // 如果当前单词首字符等于S首字符
        //             idx ++;                 // 当前单词下标加一
        //             if (v.length() == 1) res++;      // 如果当前单词长度只有1，说明当前单词已经遍历结束，结果加一
        //         }
        //         while (idx < v.length()) {            // 继续比较单词接下来的字符，在S中是否存在
        //             cur = v.charAt(idx) - 'a';
        //             if (arr[idxAtS][cur] == 0) break; // 如果indexAtS之后不存在c，当前单词不合法
        //             idxAtS = arr[idxAtS][cur]; // 将indexAtS更新为c在S中的位置
        //             if (++idx == v.length()) res++;     // index加一, 如果index为单词最后一位，代表单词中所有字符均在S中找到
        //         }
        //     }
        //     return res;
        // }


        // public class Node {
        //     String name;
        //     Map<String, Node> children = new HashMap<>();
        //     private String hashCode = null;
        //     public Node (String name) {
        //         this.name = name;
        //     }
        //     public void add(List<String> path) {
        //         Node cur = this;
        //         for (String file : path) {
        //             if (!cur.children.containsKey(file))
        //                 cur.children.put(file, new Node(file));
        //             cur = cur.children.get(file);
        //         }
        //     }
        //     public String getHashCode() {
        //         if (hashCode == null)
        //             hashCode = compueteHash();
        //         return hashCode;
        //     }
        //     private String compueteHash() {
        //         StringBuilder sb = new StringBuilder();
        //         List<Node> nodes = new ArrayList<>();
        //         for (Node n : children.values()) 
        //             nodes.add(n);
        //         if (nodes.size() == 0) return null;
        //         nodes.sort((a, b) -> a.name.compareTo(b.name));
        //         for (Node n : nodes) {
        //             sb.append('(');
        //             sb.append(n.name + n.getHashCode());
        //             sb.append(')');
        //         }
        //         return sb.toString();
        //     }
        // }
        // private void getGoodFiles(Node node, Map<String, Integer> occurs, List<String> cur, List<List<String>> ans) {
        //     if (occurs.containsKey(node.getHashCode()) && occurs.get(node.getHashCode()) > 1) return;
        //     cur.add(node.name);
        //     ans.add(new ArrayList<>(cur));
        //     for (Node n : node.children.values()) 
        //         getGoodFiles(n, occurs, cur, ans);
        //     cur.remove(cur.size()-1);
        // }
        // private void findOccurs(Node node, Map<String, Integer> occurs) {
        //     String key = node.getHashCode();
        //     if (key != null)
        //         occurs.put(key, occurs.getOrDefault(node.getHashCode(), 0) + 1);
        //     for (Node n : node.children.values()) 
        //         findOccurs(n, occurs);
        // }
        // Node root;
        // public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        //     root = new Node("");
        //     for (List<String> path : paths) 
        //         root.add(path);
        //     Map<String, Integer> occurs = new HashMap<>();
        //     findOccurs(root, occurs);
        //     List<List<String>> ans = new ArrayList<>();
        //     for (Node n : root.children.values()) 
        //         getGoodFiles(n, occurs, new ArrayList<>(), ans);
        //     return ans;
        // }


        // public int countPairs(int[] nums, int low, int high) {
        //     Trie t = new Trie();
        //     for (int i = 0; i < nums.length; i++) 
        //         t.insert(String.valueOf(nums[i]));
        //     int max = 0;
        //     for (int i = 0; i < nums.length; i++)  {
        //         max = Math.max(max, t.getCntsLessThanOrEqualToK(nums[i], high) - t.getCntsLessThanOrEqualToK(nums[i], low));
        //     }
        //     return max;
        // }
        //     private class Pt {
        //         int i;
        //         int j;
        //         public Pt(int a, int b) {
        //             i = a;
        //             j = b;
        //         }
        //     }
        // int cnt = 0;
        //     List<Pt> ll = new ArrayList<>();
        //     int max = -1;
        //     // 根据XOR的特点，这里应该有遍历的时间的步骤栽枝控制： a ^ b == 0还是1的时候，应该需要考虑：要不要再继续往下遍历
        //     private void getCntsLessThanOrEqualToK(Node r, int val, int k, String s) {
        //         if (r.isWord) {
        //             int tmp = Integer.parseInt(s);
        //             if (tmp > k) return;
        //             if (tmp <= k && (tmp ^ val) >= max) {
        //                 max = Math.max(max, (tmp ^ val));
        //                 // ++cnt;
        //                 // Pt cur = new Pt(Math.min(val, tmp), Math.max(val, tmp));
        //                 // if (!ll.contains(cur))
        //                 //     ll.add(cur);
        //                 if (tmp == k) return;
        //             }
        //         }
        //         for (Character key : r.next.keySet()) 
        //             getCntsLessThanOrEqualToK(r.next.get(key), val, k, s + key);
        //     }
        //     private int getCntsLessThanOrEqualToK(int val, int k) { // val: arr[i], k : parseInt(s) <= k
        //         max = -1;
        //         getCntsLessThanOrEqualToK(root, val, k, "");
        //         return max;
        //     }
        // }
        // public int[] maximizeXor(int[] nums, int[][] queries) {
        //     Trie t = new Trie();
        //     for (int i = 0; i < nums.length; i++) 
        //         t.insert(String.valueOf(nums[i]));
        //     // int max = 0;
        //     int [] arr = new int[queries.length];
        //     for (int i = 0; i < queries.length; i++)  {
        //         arr[i] = t.getCntsLessThanOrEqualToK(queries[i][0], queries[i][1]);
        //         // max = Math.max(max, t.getCntsLessThanOrEqualToK(nums[i], high) - t.getCntsLessThanOrEqualToK(nums[i], low));
        //     }
        //     // return max;
        //     return arr;
        // }


        // public class Trie {
        //     private class Node {
        //         public int val;
        //         public boolean isExist;
        //         public Node [] next;
        //         public Node(boolean isExist) {
        //             this.isExist = isExist;
        //             next = new Node[2];
        //             val = 0;
        //         }
        //         public Node() {
        //             this(false);
        //         }
        //         public Node(int va) {
        //             this(true);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(int va) {
        //         Node cur = root;
        //         for (int i = 15; i >= 0; i--) {
        //             int tmp = (va >> i) & 1;
        //             if (cur.next[tmp] == null)
        //                 cur.next[tmp] = new Node();
        //             cur = cur.next[tmp];
        //         }
        //         cur.isExist = true;
        //     }
        //     // // 2 * 10000
        //     // log(2, N) = 14.fkjd
        //     // 想想这种建法怎么遍历数个数
        //     // if (va >= k) 数比k最高位相同，而其它位可同可不同的数的个数
        //     // if (va < k) 数所有的数
        //     public int search(int va, int k) { // k: threshold, 这里的方法是不对的
        //         int max = 0;
        //         Node cur = root;
        //         // int lk = (int)(Math.log(k)/Math.log(2));
        //         // System.out.println("lk: " + lk);
        //         for (int i = 15; i >= 0; i--) {
        //             int t = (va >> i) & 1;
        //             int v = 0;
        //             if (cur.next[t^1] != null) {
        //                 max |= (1 << i);
        //                 cur = cur.next[t^1];
        //             } else 
        //                 cur = cur.next[t&1];
        //         }
        //         return max;
        //     }
        // }
        // public int countPairs(int[] nums, int low, int high) {
        //     int n = nums.length;
        //     Trie t = new Trie();
        //     for (int i = 0; i < n; i++) 
        //         t.insert(nums[i]);
        //     int cnt = 0;
        //     for (int i = 0; i < n/2; i++) {
        //         cnt += t.search(nums[i], high) - t.search(nums[i], low-1);
        //     }
        //     return cnt;
        // }


        // public int distinctEchoSubstrings(String text) {
        //     int n = text.length();
        //     Set<String> s = new HashSet<>();
        //     int j = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int d = 1; d <= n/2 && i+d <= n-d; d++) {
        //             j = i + d;
        //             if (text.substring(i, j).equals(text.substring(j, j+d)))
        //                 s.add(text.substring(i, j));
        //         }
        //     return s.size();
        // }


        // public class Trie {
        //     private class Node {
        //         public int val;
        //         public boolean isExist;
        //         public Node [] next;
        //         public Node(boolean isExist) {
        //             this.isExist = isExist;
        //             next = new Node[2];
        //             val = 0;
        //         }
        //         public Node() {
        //             this(false);
        //         }
        //         public Node(int va) {
        //             this(true);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     public Trie() {
        //         root = new Node();
        //     }
        //     public void insert(int va) {
        //         Node cur = root;
        //         for (int i = 31; i >= 0; i--) {
        //             int tmp = (va >> i) & 1;
        //             if (cur.next[tmp] == null)
        //                 cur.next[tmp] = new Node(tmp);
        //             cur = cur.next[tmp];
        //         }
        //         cur.isExist = true;
        //     }
        //     public int search(int va, int k) { 
        //         int max = 0;
        //         Node cur = root;
        //         for (int i = 15; i >= 0; i--) {
        //             int t = (va >> i) & 1;
        //             int v = 0;
        //             if (cur.next[t^1] != null) {
        //                 max |= (1 << i);
        //                 cur = cur.next[t^1];
        //             } else 
        //                 cur = cur.next[t&1];
        //         }
        //         return max;
        //     }
        // }
        // // 一个比较简单的想法是用Trie，并且在每个节点里还存放一下走到当前路径的所有数的最小值。
        // // 接下来询问的时候，对于每次询问( x , m )，把x xx转为长31的二进制数，
        // // 然后从高位开始遍历，并且从Trie树根向下走，
        // // 优先走与x 当前二进制位不同的那个分支，如果那个分支的最小值是大于m 的，那无解，走不了
        // // （否则就走），则考虑走另一个分支，如果那个分支的最小值也是大于m mm的，则本次询问无解，返回− 1 -1−1（否则就走这个分支）；
        // // 否则就按照上面的原则，走下去。走的同时记录异或的答案即可。
        // public int[] maximizeXor(int[] nums, int[][] queries) {
        //     int [] ans = new int[queries.length];
        //     Arrays.fill(ans, -1);
        //     Arrays.sort(nums);
        //     // Arrays.sort(queries, (a, b) -> (a[2]-b[2]));
        //     Trie t = new Trie();
        //     for (Integer v : nums) 
        //         t.insert(v);
        //     for (int i = 0; i < queries.length; i++)  {
        //         ans[i] = t.getCntsLessThanOrEqualToK(queries[i][0], queries[i][1]);
        //     }
        //     return ans;
        // }  


// 这种原始的写法会超时 TLE TLE TLE
        // public List<String> findAllConcatenatedWordsInADict(String[] words) { 
        //     if (words.length <= 2) return new ArrayList<String>();
        //     Set<String> ss = new HashSet<>(Arrays.asList(words));
        //     List<String> res = new ArrayList<>();
        //     for (String s : words) {
        //         ss.remove(s);
        //         int n = s.length();
        //         if (n == 0) continue;
        //         boolean [] v = new boolean [n+1];
        //         v[0] = true;
        //         for (int i = 0; i <= n; i++) 
        //             for (int j = 0; j < i; j++) 
        //                 if (v[j] && ss.contains(s.substring(j, i-j))) {
        //                     v[i] = true;
        //                     break;
        //                 }
        //         if (v[n]) res.add(s);
        //         ss.add(s);
        //     }
        //     return res;
        // }
        // public class Trie { // Trie with memo, Time: o(m*2^n)
        //     boolean isKey;
        //     Trie [] child;
        //     public Trie() {
        //         this.isKey = false;
        //         child = new Trie[26];
        //     }
        //     public void insert(String s) {
        //         int [] memo = new int [s.length()];
        //         Trie p = this;
        //         char [] sArr = s.toCharArray();
        //         boolean added = false;
        //         for (int i = 0; i < sArr.length; i++) {
        //             char c = sArr[i];
        //             if (p.child[c-'a'] == null)
        //                 p.child[c-'a'] = new Trie();
        //             p = p.child[c-'a'];
        //             if (p.isKey && isConcatenated(s, i+1, 0, memo) && !added) {
        //                 res.add(s);
        //                 added = true;
        //             }
        //         }
        //         p.isKey = true;
        //     }     // 这么看来，我还没能透彻理解dfs深搜中的重复，什么时候应该拥有记忆？！！！
        //     public boolean isConcatenated(String s, int start, int cnt, int [] memo) {
        //         if (start == s.length() && cnt > 0) return true; 
        //         if (memo[start] != 0) return memo[start] == 1;
        //         Trie p = this;
        //         char [] sArr = s.toCharArray();
        //         for (int i = start; i < sArr.length; i++) {
        //             char c = sArr[i];
        //             Trie cur = p.child[c-'a'];
        //             if (cur == null) {
        //                 memo[start] = -1;
        //                 return false;
        //             } else {
        //                 if (cur.isKey && isConcatenated(s, i+1, cnt+1, memo)) {
        //                     memo[start] = 1;
        //                     return true;
        //                 }
        //                 p = cur;
        //             }
        //         }
        //         memo[start] = -1;
        //         return false;
        //     }
        // }
        // // Sort the words based on length
        // // Use trie to store words: while adding, checking if it is concatenated
        // // While checking, use dfs + memo
        // List<String> res = new ArrayList<>();
        // public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //     Arrays.sort(words, (x, y) -> Integer.compare(x.length(), y.length()));
        //     Trie tree = new Trie();
        //     for (String word : words) 
        //         tree.insert(word);
        //     return res;
        // }
// // 切记： dfs 深搜 + 记忆
//         public class Trie { // Trie with memo, Time: o(m*2^n)
//             boolean isWord;
//             Trie [] children;
//             public Trie() {
//                 isWord = false;
//                 children = new Trie[26];
//             }
//         }
//         public void insert(String word) { // 这么写，显得逻辑更为清晰一些
//             Trie cur = root;
//             for (int i = 0; i < word.length(); i++) {
//                 char c = word.charAt(i);
//                 if (cur.children[c-'a'] == null)
//                     cur.children[c-'a'] = new Trie();
//                 cur = cur.children[c-'a'];
//             }
//             cur.isWord = true;
//         }     
//         public boolean isConcatenated(String word, int idx, int cnt, HashMap<Integer, Boolean> memo) {
//             if (memo.containsKey(idx)) return memo.get(idx);
//             if (idx == word.length()) {
//                 memo.put(idx, cnt > 1);
//                 return cnt > 1;
//             }
//             Trie cur = root;
//             for (int i = idx; i < word.length(); i++) {
//                 char c = word.charAt(i);
//                 if (cur.children[c-'a'] == null) {
//                     memo.put(idx, false);
//                     return false;
//                 } else {
//                     cur = cur.children[c-'a'];
//                     if (cur.isWord && isConcatenated(word, i+1, cnt+1, memo)) {
//                         memo.put(idx, true);
//                         return true;
//                     }
//                 }
//             }
//             memo.put(idx, false);
//             return false;
//         }
//         Trie root = new Trie();
//         public List<String> findAllConcatenatedWordsInADict(String[] words) {
//             for (String word : words) 
//                 insert(word);
//             List<String> res = new ArrayList<>();
//             for (String word : words) 
//                 if (isConcatenated(word, 0, 0, new HashMap<Integer, Boolean>()))
//                     res.add(word);
//             return res;
//         }


        public class Trie { 
            boolean isWord;
            int forward; // 0: forward, 1 backward, 2 both
            int [] idx;
            Trie [] children;
            public Trie() {
                isWord = false;
                forward = -1;
                children = new Trie[26];
                idx = new int [2];
            }
        }
        public void insert(String word, int idx, int fd) { 
            System.out.println("\n word: " + word);
            Trie cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.children[c-'a'] == null)
                    cur.children[c-'a'] = new Trie();
                cur = cur.children[c-'a'];
            }
            if (!cur.isWord) {
                cur.isWord = true;
                cur.forward = fd;
                cur.idx[0] = idx;
            } else if (cur.isWord && cur.forward > 0 && fd == 0) {
                cur.forward = 2;
                cur.idx[fd] = idx;
            } else if (cur.isWord && cur.forward == 0 && fd > 0) {
                cur.forward = 2;
                cur.idx[fd] = idx;
            }
            System.out.println("cur.isWord: " + cur.isWord);
            
        }
        private void dfs(Trie r, int idx, StringBuilder s) {
            if (r == null) return;
            System.out.println("\n s.toString(): " + s.toString());
            
            boolean isLeaf = true;
            for (int i = 0; i < 26; i++) 
                if (r.children[i] != null) {
                    isLeaf = false;
                    break;
                }
            System.out.println("isLeaf: " + isLeaf);
            
            if (isLeaf || r.isWord) {
                if (r.isWord && r.forward > 0 && s.toString().equals(s.reverse().toString()) && (r.idx[0] != idx || r.idx[1] != idx)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(idx);
                    l.add(idx == r.idx[0] ? r.idx[1] : r.idx[0]);
                    if (!res.contains(l)) res.add(l);
                }
                if (isLeaf) return;
            }
            for (int i = 0; i < 26; i++) {
                if (r.children[i] == null) continue;
                s.append((char)('a' + i));
                // System.out.println("s: " + s);
                
                dfs(r.children[i], idx, s);
                s.deleteCharAt(s.length()-1);
            }
        }
        List<List<Integer>> res;
        public List<List<Integer>> search(String s, int idx) { // s is the reversed already
            res = new ArrayList<>();
            Trie cur = root;
            System.out.println("cur.isWord: " + cur.isWord);
            if (cur.isWord && s.equals((new StringBuilder(s).reverse()).toString())) {
                if (cur.idx[0] != idx || cur.idx[1] != idx) {
                    List<Integer> l = new ArrayList<>();
                    l.add(idx);
                    l.add(idx == cur.idx[0] ? cur.idx[1] : cur.idx[0]);
                    if (!res.contains(l)) res.add(l);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                cur = cur.children[c-'a'];
            }
            List<Integer> l = new ArrayList<>();
            if (cur.isWord && (cur.forward > 0 && (cur.idx[0] != idx || cur.idx[1] != idx))) {
                l.add(idx);
                l.add(idx == cur.idx[0] ? cur.idx[1] : cur.idx[0]);
                if (!res.contains(l)) res.add(new ArrayList<>(l));
            }
            dfs(cur, idx, new StringBuilder());
            for (List<Integer> li : res) 
                if (!res.contains(li)) res.add(new ArrayList<>(li));
            return res;
        }
        Trie root = new Trie();
        public List<List<Integer>> palindromePairs(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(words[i], i, 0);
                String tmp = (new StringBuilder(words[i]).reverse()).toString();
                insert(tmp, i, 1);
            }
            res = new ArrayList<>();
            List<List<Integer>> ll = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                res.clear();
                
                System.out.println("\n words[i]: " + words[i]);
                if (words[i].length() == 0) dfs(root, i, new StringBuilder());
                else search(words[i], i);                

        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) {
            for (int y = 0; y < res.get(z).size(); y++) 
                System.out.print(res.get(z).get(y) + ", ");
            System.out.print("\n ");
        }
        
                for (List<Integer> l : res) 
                    if (!ll.contains(res)) ll.add(new ArrayList<>(l));
            }
            return ll;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // String []  a = new String []  {"abcd", "dcba", "lls", "s", "sssll"};
        // String []  a = new String []  {"bat", "tab", "cat"};
        // String []  a = new String []  {"a", ""};
        // String []  a = new String []  {"a", "abc", "aba", ""};
        String []  a = new String []  {"a", "b", "c", "ab", "ac", "aa"};

        List<List<Integer>> res = s.palindromePairs(a);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) {
            for (int y = 0; y < res.get(z).size(); y++) 
                System.out.print(res.get(z).get(y) + ", ");
            System.out.print("\n ");
        }
    }
}
