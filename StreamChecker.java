// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class StreamChecker {
    public class Node {
        public char val;
        public boolean isWord;
        public Node [] next;
        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }
        public Node() {
            this(false);
        }
        public Node(char va) {
            this(true);
            this.val = va;
        }
    }
    public class Trie {
        public Trie() {
            root = new Node();
        }
        private Node root;
        private Node cur, pre;
        
        public void insert(String word) {
            cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c-'a'] == null) {
                    cur.next[c-'a'] = new Node();
                }
                cur = cur.next[c-'a'];
            }
            if (!cur.isWord) cur.isWord = true;
            cur = null;
        }
        public boolean query(char c) {
            if (pre != null) cur = pre;
            if (cur == null && root.next[c-'a'] != null)  {
                cur = root.next[c-'a'];
                return cur.isWord;
            } else if (cur != null && cur.next[c-'a'] != null) {
                cur = cur.next[c-'a'];
                return cur.isWord;
            }
            // if (cur != null) return cur.isWord; // ???
            pre = cur;
            cur = null;
            return false;
        }
    }
    Trie t;
    public StreamChecker(String[] words) {
        int n = words.length;
        t = new Trie();
        for (int i = 0; i < n; i++) 
            t.insert(words[i]);
    }
    
    public boolean query(char letter) {
        return t.query(letter);
    }

    public static void main(String[] args) {
        // Solution b = new Solution();

        String []   a = new String []   {"ab", "ba", "aaab", "abab", "baa"};
        StreamChecker s = new StreamChecker(a);

        // [[],["a"],["a"],["a"],["a"],["a"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["b"],["b"],["b"],["a"],["b"],["a"],["b"],["a"],["a"],["a"],["b"],["a"],["a"],["a"]]
        s.query('a');
        s.query('a');
        s.query('a');
        s.query('a');
        
        boolean r = s.query('a');
        System.out.println("r: " + r);

        s.query('b'); // return False
        boolean r0 =        s.query('b'); // return False
        System.out.println("r0: " + r0);

        boolean r1 =        s.query('a'); // return True, because 'cd' is in the wordlist
        System.out.println("r1: " + r1);

        // s.query('e'); // return False
        // boolean r2 =        s.query('f'); // return True, because 'f' is in the wordlist
        // System.out.println("r2: " + r2);

        // s.query('g'); // return False
        // s.query('h'); // return False
        // s.query('i'); // return False
        // s.query('j'); // return False
        
        // boolean r4 =         s.query('k'); // return False
        // System.out.println("r4: " + r4);

        // boolean r3 =        s.query('l'); // return True, because 'kl' is in the wordlist
        // System.out.println("r3: " + r3);

    }
}