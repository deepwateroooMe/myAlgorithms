// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javafx.util.Pair;
import static java.util.stream.Collectors.toMap;

public class WordDictionary {

    public class Trie {
        private class Node {
            public int val;
            public boolean isWord;
            public TreeMap<Character, Node> next;
            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }
            public Node() {
                this(false);
            }
            public Node(int va) {
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
            if (!cur.isWord) {
                cur.isWord = true;
            }
        }
        public boolean search(Node cur, String word) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    if (c != '.') return false;
                    for (Character key : cur.next.keySet()) {
                        boolean tmp = search(cur.next.get(key), word.substring(i+1));
                        if (tmp) return true;
                    }
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }
        public boolean search(String s) {
            return search(root, s);
        }
    }
    Trie t;
    public WordDictionary() {
        t = new Trie();
    }
    public void addWord(String word) {
        t.insert(word);
    }
    public boolean search(String word) {
        return t.search(word);
    }

    
    public static void main(String[] args) {
        WordDictionary s = new WordDictionary();
        
        s.addWord("bad");
        s.addWord("dad");
        s.addWord("mad"); // t

        boolean r = s.search("pad");
        System.out.println("r: " + r);

        boolean r1 = s.search("bad");
        System.out.println("r: " + r1);

        boolean r2 = s.search(".ad");
        System.out.println("r: " + r2);

        boolean r3 = s.search("b..");
        System.out.println("r: " + r3);

        // ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //     [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]        
    }
}