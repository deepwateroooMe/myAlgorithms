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

    // public class Node {
    //     boolean isWord;
    //     Node [] next;
    //     public Node() {
    //         this.isWord = false;
    //         next = new Node[26];
    //     }
    // }
    // StringBuilder sb;
    // Node root;
    // public StreamChecker(String[] words) {
    //     root = new Node();
    //     sb = new StringBuilder();
    //     for (String s : words) {
    //         Node r = root;
    //         for (int i = s.length()-1; i >= 0; i--) {
    //             int idx = s.charAt(i) - 'a';
    //             if (r.next[idx] == null)
    //                 r.next[idx] = new Node();
    //             r = r.next[idx];
    //         }
    //         r.isWord = true;
    //     }
    // }
    // public boolean query(char letter) {
    //     int idx = letter - 'a';
    //     sb.append(letter);
    //     int n = sb.length()-1;
    //     Node r = root;
    //     if (r.next[idx] != null) {
    //         r = r.next[idx];
    //         if (r.isWord) return true;
    //     A : while (true) {        // 这种写法：这个弱弱看得也是醉了。。。。。。
    //             int childIdx = 0;
    //             if (n != 0) childIdx = sb.charAt(--n) - 'a';
    //             else break;
    //             for (int i = 0; i < 26; i++) {
    //                 Node node = r.next[i];
    //                 if (node != null && childIdx == i) {
    //                     if (node.isWord) return true;
    //                     r = r.next[i];
    //                     continue A; // 这种写法：这个弱弱看得也是醉了。。。。。。
    //                 }
    //             }
    //             break;
    //         }
    //     }
    //     return false;
    // }
    public class Node {
        boolean isWord;
        Node [] next;
        public Node() {
            this.isWord = false;
            next = new Node[26];
        }
    }
    StringBuilder sb = new StringBuilder();;
    Node root = new Node();;
    public StreamChecker(String[] words) {
        for (String  word : words) 
            insert(word);
    }
    public boolean query(char letter) {
        sb.append(letter);
        return hasWord(sb);
    }
    private void insert(String s) {
        Node r = root;
        for (int i = s.length()-1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (r.next[idx] == null)
                r.next[idx] = new Node();
            r = r.next[idx];
        }
        r.isWord = true;
    }
    private boolean hasWord(StringBuilder s) {
        Node r = root;
        for (int i = s.length()-1; i >= 0; i--) {
            int idx = sb.charAt(i) - 'a';
            if (r.next[idx] == null) return false;
            if (r.next[idx].isWord) return true;
            r = r.next[idx];
        }
        return false;
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