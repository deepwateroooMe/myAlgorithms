// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class trieProbs {
    public static class Solution {

        public class Trie {
            private class Node {
                public boolean isWord;
                public TreeMap<Character, Node> next;
                public Node(boolean isWord) {
                    this.isWord = isWord;
                    next = new TreeMap<>();
                }
                public Node() {
                    this(false);
                }
            }

            private Node root;
            private int size;
    
            /** Initialize your data structure here. */
            public Trie() {
                root = new Node();
                size = 0;
            }

            /** Inserts a word into the trie. */
            public void insert(String word) {
                Node cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next.get(c) == null) 
                        cur.next.put(c, new Node());
                    cur = cur.next.get(c);
                }
                if (!cur.isWord) {
                    cur.isWord = true;
                    size++;
                }
            }
    
            /** Returns if the word is in the trie. */
            public boolean search(String word) {
                Node cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next.get(c) == null) return false;
                    cur = cur.next.get(c);
                }
                if (!cur.isWord) return false;
                else return true;
            }
    
            /** Returns if there is any word in the trie that starts with the given prefix. */
            public boolean startsWith(String prefix) {
                Node cur = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (cur.next.get(c) == null) return false;
                    cur = cur.next.get(c);
                }
                return true;
            }

            public int getSize() {
                return size;
            }
    
        }

        List<String> l = new ArrayList<>();
        boolean [][] vis;
        Trie trie;
        int m, n;
        public void dfs(char [][] arr, int i, int j, String s) {
            if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
            s += arr[i][j];
            if (!trie.startsWith(s)) return;
            if (trie.search(s) && !l.contains(s)) {
                l.add(s);
            }
            vis[i][j] = true;
            dfs(arr, i-1, j, s);
            dfs(arr, i+1, j, s);
            dfs(arr, i, j-1, s);
            dfs(arr, i, j+1, s);
            vis[i][j] = false;
        }        
        public List<String> findWords(char[][] board, String[] words) {
            m = board.length;
            n = board[n].length;
            trie = new Trie();
            for (int i = 0; i < words.length; i++) 
                trie.insert(words[i]);
            vis = new boolean [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) {
                    dfs(board, i, j, "");
                }
            return l;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // char [][] a = new char [][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}; 
        // String [] b = new String []  {"oath", "pea", "eat", "rain"}; 
        char [] [] a = new char[] [] {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}}; 
        String []  b = new String []  {"oa", "oaa"}; 
        
        List<String> res = s.findWords(a, b);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) 
            System.out.print(res.get(z) + ", ");
        System.out.print("\n");

    }
}