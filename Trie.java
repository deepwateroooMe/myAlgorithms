// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Trie {
    private class Node {
        public char val;
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node() {
            this(false);
        }
        public Node(char va) {
            this(true);
            this.val = va;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) 
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) 
            cur.isWord = true;
    }
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        return true;
    }
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public static class Solution {
        
        Trie trie;
        List<String> l = new ArrayList<>();
        int m, n;
        public void dfs(char [][] arr, boolean [][] vis, int i, int j, String s) {
            if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
            s += arr[i][j];
            System.out.println("s: " + s);
            System.out.println(" " + (""+'c'));
            
            if (!trie.startsWith(s)) return;
            if (trie.search(s)) {
                l.add(s);
                System.out.println("l.size(): " + l.size());
                for (int z = 0; z < l.size(); ++z) 
                    System.out.print(l.get(z) + ", ");
                System.out.print("\n");

            }
            vis[i][j] = true;
            dfs(arr, vis, i-1, j, s);
            dfs(arr, vis, i+1, j, s);
            dfs(arr, vis, i, j-1, s);
            dfs(arr, vis, i, j+1, s);
            vis[i][j] = false;
        }        
        public List<String> findWords(char[][] board, String[] words) {
            trie = new Trie();
            for (String val : words) 
                trie.insert(val);
            // for (int i = 0; i < words.length; i++) 
            //     trie.insert(words[i]);
            boolean [] [] vis = new boolean [m][n];
            l = new ArrayList<>();
            System.out.println("dklfjdkdl: ");
            
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    System.out.println("\ni: " + i);
                    System.out.println("j: " + j);
                    
                    dfs(board, vis, i, j, "");
                }

            System.out.println("l.size(): " + l.size());
            for (int z = 0; z < l.size(); ++z) 
                System.out.print(l.get(z) + ", ");
            System.out.print("\n");

            return l;
        }

    }

// List<Integer> l = new ArrayList<>();
// private void getAllValuesRecursive(Node r, StringBuilder s) {
//     if (r == null) return;
//     if (r.isWord) l.add(Integer.parseInt(s.toString()));
//     if (r.next == null) return;
//     for (Character key : r.next.keySet()) {
//         s.append(key);
//         getAllValuesRecursive(r.next.get(key), s);
//         s.deleteCharAt(s.length()-1);
//     }
// }
// public List<Integer> getAllValues() {
//     l = new ArrayList<>();
//     Node cur = root;
//     if (cur.next.size() == 0) {
//         return l;
//     }
//     StringBuilder s = new StringBuilder();
//     for (Character key : cur.next.keySet()) {
//         s.append(key);
//         getAllValuesRecursive(cur.next.get(key), s); 
//         s.deleteCharAt(s.length()-1);
//     }
//     return l;
// }

    
// public void insert(String word, int va) {
//     Node cur = root;
//     for (int i = 0; i < word.length(); i++) {
//         char c = word.charAt(i);
//         if (cur.next.get(c) == null) 
//             cur.next.put(c, new Node());
//         cur = cur.next.get(c);
//     }
//     if (!cur.isWord) {
//         cur.isWord = true;
//         cur.val = va;
//         size++;
//     } else {
//         cur.val = va;
//     }
// }
// int sum = 0;
// public int sumWithPrefix(String prefix) {
//     Node cur = root;
//     sum = 0;
//     for (int i = 0; i < prefix.length(); i++) {
//         char c = prefix.charAt(i);
//         if (cur.next.get(c) == null) return sum;
//         cur = cur.next.get(c);
//     }
//     getSumWithPrefix(cur);
//     return sum;
// }
// private void getSumWithPrefix(Node r) {
//     if (r == null) return;
//     if (r.isWord) sum += r.val;
//     for (Character key : r.next.keySet()) {
//         getSumWithPrefix(r.next.get(key));
//     }
// }

// public String getAPreWord(String word) {
//     Node cur = root;
//     StringBuilder res = new StringBuilder();
//     for (int i = 0; i < word.length(); i++) {
//         char c = word.charAt(i);
//         if (cur.next.get(c) == null) return word;
//         cur = cur.next.get(c);
//         res.append(c);
//         if (cur.isWord) {
//             return res.toString();
//         }
//     }
//     return word;
// } 
    
// public boolean search(String word) {
//     Node cur = root;
//     for (int i = 0; i < word.length(); i++) {
//         char c = word.charAt(i);
//         if (cur.next.get(c) == null)
//             return false;
//         cur = cur.next.get(c);
//     }
//     if (!cur.isWord) return false;
//     else return true;
// }
// public int getSize() {
//     return size;
// }
// public boolean startsWith(String prefix) {
//     Node cur = root;
//     for (int i = 0; i < prefix.length(); i++) {
//         char c = prefix.charAt(i);
//         if (cur.next.get(c) == null) return false;
//         cur = cur.next.get(c);
//     }
//     return true;
// }
// public List<String> getThreeRecom(String prefix) {
//     l = new ArrayList<>();
//     Node cur = root;
//     for (int i = 0; i < prefix.length(); i++) {
//         char c = prefix.charAt(i);
//         if (cur.next.get(c) == null) return l;
//         cur = cur.next.get(c);
//     }
//     findThreeHelper(cur, new StringBuilder(prefix), 3);
//     return l;
// }
// public List<String> l;
// private void findThreeHelper(Node r, StringBuilder s, int k) {
//     if (r == null) return;
//     if (r.isWord && l.size() < k) {
//         l.add(s.toString());
//         if (l.size() == k) return;
//     }
//     if (r.next == null) return;
//     for (Character key : r.next.keySet()) {
//         if (l.size() < k) {
//             StringBuilder t = new StringBuilder(s);
//             t.append(key);
//             findThreeHelper(r.next.get(key), t, k);
//         }
//     }
// }
    
// public static class Solution {
// Trie t;
// public MapSum() {
//     t = new Trie();
// }
// public void insert(String key, int val) {
//     t.insert(key, val);
// }
// public int sum(String prefix) {
//     return t.sumWithPrefix(prefix);
// }
        

// public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//     Trie tri = new Trie();
//     for (int i = 0; i < products.length; i++) 
//         tri.insert(products[i]);
//     List<List<String>> ll = new ArrayList<>();
//     List<String> l = new ArrayList<>();
//     for (int i = 0; i < searchWord.length(); i++) {
//         l = new ArrayList<>();
//         l = tri.getThreeRecom(searchWord.substring(0, i+1));
//         ll.add(l);
//     }
//     return ll;
// }

// public String replaceWords(List<String> dictionary, String sentence) {
//     Trie t = new Trie();
//     for (int i = 0; i < dictionary.size(); i++) 
//         t.insert(dictionary.get(i));
//     String [] arr = sentence.split(" ");
//     List<String> l = new ArrayList<>();
//     for (int i = 0; i < arr.length; i++) {
//         String pre = t.getAPreWord(arr[i]);
//         l.add(pre);
//     }
//     StringBuilder s = new StringBuilder(l.get(0));
//     for (int i = 1; i < l.size(); i++) {
//         s.append(' ');
//         s.append(l.get(i));
//     }
//     return s.toString();
// }

// public List<Integer> lexicalOrder(int n) {
//     Trie t = new Trie();
//     for (int i = 1; i <= n; i++) 
//         t.insert(String.valueOf(i));
//     return t.getAllValues();
// }

// public class Trie {
//     private class Node {
//         public int val;
//         public boolean isWord;
//         public TreeMap<Character, Node> next;
//         public Node(boolean isWord) {
//             this.isWord = isWord;
//             next = new TreeMap<>();
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
//     private int size;
//     public Trie() {
//         root = new Node();
//         size = 0;
//     }
//     public void insert(String word) {
//         Node cur = root;
//         for (int i = 0; i < word.length(); i++) {
//             char c = word.charAt(i);
//             if (cur.next.get(c) == null) 
//                 cur.next.put(c, new Node());
//             cur = cur.next.get(c);
//         }
//         if (!cur.isWord) {
//             cur.isWord = true;
//             size++;
//         }
//     }
//     List<Integer> l = new ArrayList<>();
//     private void getAllValuesRecursive(Node r, StringBuilder s) {
//         if (r == null) return;
//         if (r.isWord) l.add(Integer.parseInt(s.toString()));
//         if (r.next == null) return;
//         for (Character key : r.next.keySet()) {
//             s.append(key);
//             getAllValuesRecursive(r.next.get(key), s);
//             s.deleteCharAt(s.length()-1);
//         }
//     }
//     public List<Integer> getAllValues() {
//         l = new ArrayList<>();
//         Node cur = root;
//         if (cur.next.size() == 0) {
//             return l;
//         }
//         StringBuilder s = new StringBuilder();
//         for (Character key : cur.next.keySet()) {
//             s.append(key);
//             getAllValuesRecursive(cur.next.get(key), s); 
//             s.deleteCharAt(s.length()-1);
//         }
//         return l;
//     }
// }

        
// }

    public static void main(String[] args) {
        Solution s = new Solution();

        char [][] a = new char [][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}; 
        String [] b = new String []  {"oath", "pea", "eat", "rain"};

        System.out.println("a.length: " + a.length);
        for (int z = 0; z < a.length; ++z) {
            for (int w = 0; w < a[z].length; w++) 
                System.out.print(a[z][w] + ", ");
            System.out.print("\n");
        }

        System.out.println("b.length: " + b.length);
        for (int z = 0; z < b.length; ++z) 
            System.out.print(b[z] + ", ");
        System.out.println("");



        List<String> res = s.findWords(a, b);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) 
            System.out.print(res.get(z) + ", ");
        System.out.print("\n");

    }
}