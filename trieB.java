// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class trieB {
    public static class Solution {
        Trie t;
        public MapSum() {
            t = new Trie();
        }
        public void insert(String key, int val) {
            t.insert(key, val);
        }
        public int sum(String prefix) {
            return t.sumWithPrefix(prefix);
        }
        
        List<String> l = new ArrayList<>();
        boolean [][] vis;
        Trie trie;
        int m, n;
        public void dfs(char [][] arr, int i, int j, String s) {
            if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
            s += arr[i][j];
            System.out.println("s: " + s);
            if (!trie.startsWith(s)) return;
            System.out.println(" (trie.search(s)): " +  (trie.search(s)));
            if (trie.search(s)) {
                l.add(s);
                // return;
            }
            vis[i][j] = true;
            dfs(arr, i-1, j, s);
            dfs(arr, i+1, j, s);
            dfs(arr, i, j-1, s);
            dfs(arr, i, j+1, s);
            vis[i][j] = false;
        }        
        public List<String> findWords(char[][] board, String[] words) {
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

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Trie tri = new Trie();
            for (int i = 0; i < products.length; i++) 
                tri.insert(products[i]);
            List<List<String>> ll = new ArrayList<>();
            List<String> l = new ArrayList<>();
            for (int i = 0; i < searchWord.length(); i++) {
                l = new ArrayList<>();
                l = tri.getThreeRecom(searchWord.substring(0, i+1));
                ll.add(l);
            }
            return ll;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            Trie t = new Trie();
            for (int i = 0; i < dictionary.size(); i++) 
                t.insert(dictionary.get(i));
            String [] arr = sentence.split(" ");
            List<String> l = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                String pre = t.getAPreWord(arr[i]);
                l.add(pre);
            }
            StringBuilder s = new StringBuilder(l.get(0));
            for (int i = 1; i < l.size(); i++) {
                s.append(' ');
                s.append(l.get(i));
            }
            return s.toString();
        }

        public List<Integer> lexicalOrder(int n) {
            Trie t = new Trie();
            for (int i = 1; i <= n; i++) 
                t.insert(String.valueOf(i));
            return t.getAllValues();
        }




        public class Trie {
            private class Node {
                public String val;
                public boolean mark;
                public TreeMap<String, Node> next;
                public Node(boolean mark) {
                    this.mark = mark;
                    next = new TreeMap<>();
                }
                public Node() {
                    this(false);
                    next = new TreeMap<>();
                }
                public Node(String va) {
                    this(false);
                    this.val = va;
                }
            }
            private Node root;
            private int size;
            public Trie() {
                root = new Node();
                size = 0;
            }
        }
        public int numMatchingSubseq(String s, String[] words) {
        }

        
        boolean res;
        public void searchDiffByOneRecursive(Node r, String word, StringBuilder s, boolean mod) {
            if (r == null) {
                if (s.length() < word.length()) return;
                else return;
            }
            if (r.isWord && s.length() == word.length()) {
                res = true;
                return;
            }
            for (int i = s.length(); i < word.length(); i++) {
                char c = word.charAt(i);
                if (r.next.get(c) == null) return;
                s.append(c);
                r = r.next.get(c);
            }
            if (r.isWord) 
                res = true;
        }
        public boolean searchDiffByOne(String word) {
            Node cur = root;
            StringBuilder s = new StringBuilder();
            res = false;
            char c = ' ';
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                if (cur.next.get(c) == null) {
                    if (word.length() == 1 && cur.next.size() > 0) {
                        res = true;
                        return res;
                    }
                    for (Character key : cur.next.keySet()) {
                        StringBuilder t = new StringBuilder(s);
                        t.append(key);
                        searchDiffByOneRecursive(cur.next.get(key), word, t, true);
                        if (res) return res;
                    }
                } else {
                    for (Character key : cur.next.keySet()) {
                        if (key == c) continue;
                        StringBuilder t = new StringBuilder(s);
                        t.append(key);
                        searchDiffByOneRecursive(cur.next.get(key), word, t, true);
                        if (res) return res;
                    }
                    s.append(c);
                    cur = cur.next.get(c);
                }
            }
            if (cur.isWord) {
                res = false;
            }
            return res;
        }
        }
        Trie t;
        public MagicDictionary() {
            t = new Trie();
        }
        public void buildDict(String[] dictionary) {
            for (int i = 0; i < dictionary.length; i++) 
                t.insert(dictionary[i]);
        }
        public boolean search(String searchWord) {
            return t.searchDiffByOne(searchWord);
        }

        
        
         * 两棵trie + dfs
         * <p>
         * 准备两棵前缀树,一棵是prefixTrie,一棵是suffixTrie
         * 把words中的每一个单词先插入到prefixTrie中,然后把words中的每一个单词插入suffixTrie中;
         * 准备两个list,分别对两棵树进行深搜,找到具有prefix的所有的单词序号和具有suffix的所有的单词序号,分别放入两个list中;
         * 然后从两个list中选择公共的最大序号即可;
         * <p>
         * 优化版:去掉深搜,
         * prefixTrie中插入words中的每个单词的前缀;(ps:具体实现时并不是要把一个单词word截取出word.length()个前缀)
         * suffixTrie中插入words中的每个单词的后缀;
         * 在前缀树中,还需要一个set来记录当前节点下有哪一些单词,这样就不需要深搜找单词序号了;
         * <p>
         * 其实这就是官方题解中方法1了:
         * 方法一：单词查找树 + 集合交集 [超出时间限制]
         * 算法：
         * 我们使用两个单词查找树找出所有前缀匹配的单词和后缀匹配的单词。再通过取集合的交集找到其中权值最大的单词，并返回权重。
         * 然而，集合的元素可能会过大，导致超出时间限制。
         * <p>
        public class WordFilter {
            private class Node {
                public int val; 
                public TreeMap<Character, Node> next;
                public Node() {
                    this.val = -1;
                    next = new TreeMap<>();
                }
                public Node(int val) {
                    this.val = val;
                    next = new TreeMap<>();
                }
            }
            private Node root;
            public void insert(String word, int idx) {
                Node cur = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (cur.next.get(c) == null) {
                        Node tmp = new Node(idx);
                        cur.next.put(c, tmp);
                    }
                    cur = cur.next.get(c);
                    cur.val = Math.max(cur.val, idx);
                }
            }
            public int search(String word) {
                Node r = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (r.next.get(c) == null) return -1;
                    r = r.next.get(c);
                }
                return r.val;
            }
            public WordFilter(String[] words) {
                root = new Node();
                for (int i = 0; i < words.length; i++) {
                    String s = words[i];
                    String key = '{' + s;
                    insert(key, i);
                    for (int j = s.length()-1; j >= 0; j--) {
                        key = s.charAt(j) + key;
                        insert(key, i);
                    }
                }
            }
            public int f(String prefix, String suffix) {
                return search(suffix + '{' + prefix);
            }
        }


        public int numSplits(String s) {
            int n = s.length();
            if (n == 1) return 0;
            if (n == 2) return 1;
            HashMap<Character, Integer> l = new HashMap<>();
            HashMap<Character, Integer> r = new HashMap<>();
            int idx = 1;
            int cnt = 0;
            int lcnt = 0, rcnt = 0;
            while (idx <= n-1) {
                if (idx == 1) {
                    for (int i = 0; i < idx; i++) 
                        l.put(s.charAt(i), l.getOrDefault(s.charAt(i), 0) + 1);
                    for (int j = idx; j < n; j++) 
                        r.put(s.charAt(j), r.getOrDefault(s.charAt(j), 0) + 1);
                } else {
                    l.put(s.charAt(idx-1), l.getOrDefault(s.charAt(idx-1), 0) + 1);
                    r.put(s.charAt(idx-1), r.getOrDefault(s.charAt(idx-1), 1) - 1);
                    if (r.get(s.charAt(idx-1)) == 0) r.remove(s.charAt(idx-1));
                }
                if (l.size() == r.size()) ++cnt;
                ++idx;
            }
            return cnt;
        }


        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int [][] dp = new int[n][n];
            dp[0][0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                }
            }
        }


        public class Trie {
            private class Node {
                public char val;
                public boolean isWord;
                public TreeMap<Character, Node> next;
                public Node(boolean mark) {
                    this.isWord = mark;
                    this.next = new TreeMap<>();
                }
                public Node() {
                    isWord = false;
                    next = new TreeMap<>();
                }
                public Node(char va) {
                    this.val = va;
                    next = new TreeMap<>();
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
                cur.isWord = true;
            }
            List<String> res = new ArrayList<>();
            private void traversal(Node r, StringBuilder s, boolean con, List<String> l) {
                if (r.isWord && !con && r.next.size() > 0) {
                    con = true;
                    if (s.length() > 0)
                        l.add(new StringBuilder(s).toString()); 
                } else if (r.isWord && con) {
                    l.add(new StringBuilder(s).toString());
                    if (r.next.size() == 0) {

                        System.out.println("l.size(): " + l.size());
                        for (int z = 0; z < l.size(); ++z) 
                            System.out.print(l.get(z) + ", ");
                        System.out.print("\n");

                        // if (l.size() == 2) {
                        //     if (search(l.get(1).substring(l.get(0).length()))) {
                        //         res.add(l.get(1));
                        //     }
                        //     return;
                        // }

                        for (int i = l.size()-1; i > 0; i--) {
                            for (int j = 0; j < i; j++) {
                                System.out.println("l.get(i).substring(l.get(j).length())): " + l.get(i).substring(l.get(j).length()));
                                if (search(l.get(i).substring(l.get(j).length()))) {
                                    // if (!res.contains(l.get(i)))
                                        res.add(l.get(i));
                                }
                            }
                        }
                        // int i = 0;
                        // for ( i = 0; i < l.size()-1; i++) {
                        //     if (search(l.get(l.size()-1).substring(l.get(i).length()))) break;
                        // }
                        // if (i < l.size())
                        //     res.add(l.get(l.size()-1));
                        return;
                    }
                }
                for (Character key : r.next.keySet()) {
                    StringBuilder t = new StringBuilder(s);
                    t.append(key);
                    traversal(r.next.get(key), t, con, new ArrayList<>(l));
                }
            }
            public List<String> getCondWords() {
                res = new ArrayList<>();
                traversal(root, new StringBuilder(), false, new ArrayList<String>());
                return res;
            }
            public boolean searchRecursive(Node r, String word) {
                int i = 0;
                char c = word.charAt(i);
                while (i < word.length() && r.next.get(c) != null && !r.next.get(c).isWord) {
                    ++i;
                    c = word.charAt(i);
                }
                if (r.next.get(c).isWord) {
                    if (searchRecursive(root, word.substring(i+1))) return true;
                    else { // 这种情况要再好好考虑一下，还是重新再理一下这个题的解题思路
                        ++i;
                        c = word.charAt(i);
                        while (i < word.length() && r.next.get(c) != null && !r.next.get(c).isWord) {
                            ++i;
                            c = word.charAt(i);
                        }
                        if (r.next.get(c).isWord) {
                            if (searchRecursive(root, word.substring(i+1))) return true;
                        }
                    }
                }
                return false;
            }



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
        }

        
        HashSet<String> ss = new HashSet<>();
        Trie trie;
        boolean [][] vis;
        int m, n;
        public void dfs(char [][] arr, int i, int j, String s) {
            if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
            s += arr[i][j];
            if (!trie.startsWith(s)) return;
            if (trie.search(s)) ss.add(s);
            vis[i][j] = true;
            dfs(arr, i-1, j, s);
            dfs(arr, i+1, j, s);
            dfs(arr, i, j-1, s);
            dfs(arr, i, j+1, s);
            vis[i][j] = false;
        }        
        public List<String> findWords(char[][] board, String[] words) {
            m = board.length;
            n = board[0].length;
            trie = new Trie();
            for (String val : words) 
                trie.insert(val);
            vis = new boolean [m][n];
            for (int i = 0; i < m; i++) 
                for (int j = 0; j < n; j++) 
                    dfs(board, i, j, "");
            return new ArrayList<String>(ss);
        }

        
        public class Trie {
            private class Node {
                public char val;
                public boolean isWord;
                public TreeMap<Character, Node> next;
                public Node(boolean mark) {
                    this.isWord = mark;
                    this.next = new TreeMap<>();
                }
                public Node() {
                    isWord = false;
                    next = new TreeMap<>();
                }
                public Node(char va) {
                    this.val = va;
                    next = new TreeMap<>();
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
                cur.isWord = true;
            }
            public boolean search(String word) {
                Node r = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (r.next.get(c) == null)
                        return false;
                    r = r.next.get(c);
                }
                return r.isWord;
            }
        }
        public int countSubstrings(String s, String t) { // 这个字符串的题还有那么一点儿问题
            int m = s.length();
            int n = t.length();
            if (m == 1 && n == 1) return s.charAt(0) == t.charAt(0) ? 0 : 1;
            if (m > n) return countSubstrings(t, s); // default: m <= n
            Trie tri = new Trie();
            Map<String, Integer> map = new HashMap<>(); // t substrings , has repeats
            String tmp = "";
            for (int k = 1; k <= n; k++) {
                for (int i = 0; i+k <= n; i++) {
                    tmp = t.substring(i, i+k);
                    map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                }
            }
            int cnt = 0;
            StringBuilder tb = new StringBuilder();
            for (int k = 1; k <= m; k++) {
                for (int i = 0; i+k <= m; i++) {
                    tmp = s.substring(i, i+k);
                    for (int x = 0; x < tmp.length(); x++) {
                        for (int y = 0; y < 26; y++) {
                            tb = new StringBuilder(tmp);
                            if (tmp.charAt(x) == (char)(y+'a')) continue;
                            tb.setCharAt(x, (char)(y+'a'));
                            if (map.containsKey(tb.toString())) {
                                cnt += map.get(tb.toString());
                                continue;
                            }
                        }
                    }
                }
            }
            return cnt;
        }


        public int countDigitOne(int n) {
            if (n == 0) return 0;
            int res = 0;
            long d = 1;
            while (n / d != 0) {
                long low = n % d;
                long cur = (n/d) % 10;
                long high = n / (d * 10);
                if (cur == 0)
                    res += high * d;
                else if (cur == 1)
                    res += high * d + low + 1;
                else
                    res += (high + 1) * d;
                d *= 10;
            }
            return (int)res;
        }
        public int countDigitOne(int n) {
            if (n == 0) return 0;
            if (n < 10) return 1;
            int based = (int)Math.pow(10, String.valueOf(n).length()-1);
            int v = n % based;
            int cfirst = n / based;
            if (cfirst == 1) // 1729 = 729+1+f(999) + f(729)
                return v+1+ countDigitOne(v) + countDigitOne(based - 1);
            else // 3520 = 1000 + f(520) + f(999)*3
                return based + countDigitOne(v) + countDigitOne(based -1)*cfirst;
        }
        public int find(String s, int from, int [] dp) {
            if (from == s.length()-1)
                return s.charAt(from) == '0' ? 0 : 1;
            int remain = Integer.valueOf(s.substring(from+1));
            int first = (int)(s.charAt(from)-'0');
            if (first == 0)
                return find(s, from+1, dp);
            else if (first == 1) // 1725 = 
                return remain + 1 + dp[s.length()-from-1] + find(s, from+1, dp);
            else                 // 3420
                return (int)Math.pow(10, s.length()-from-1) + first * dp[s.length()-from-1] + find(s, from+1, dp);
        }
        public int countDigitOne(int n) {
            if (n == 0) return 0;
            String s = String.valueOf(n);
            // dp[i] is the count of digit one for max number of length i
            // dp[1] = number of digit one for 9 = 1
            // dp[2] = number of digit one for 99 = dp[0] * 10 + 10
            // dp[3] = number of digit one for 999 = dp[1] * 10 + 100
            // dp[4] = number of digit one for 9999 = dp[2] * 10 + 100
            int[] dp = new int[s.length()+1]; 
            for (int i = 0; i < dp.length; i++) 
                dp[i] = dp[i-1]*10+(int)Math.pow(10, i-1);
            return find(s, 0, dp);
        }


        public class Trie {
            private class Node {
                boolean isNum;
                int cnt; // 加上cnt来记录每个根结点下子结点的个数，以空间换时间
                Node [] next;
                public Node() {
                    this.isNum = false;
                    next = new Node [10];
                    cnt = 1;
                }
            }
            private Node root;
            public Trie() {
                root = new Node();
            }
            public void insert(String word) {
                Node cur = root;
                char [] s = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char c = s[i];
                    if (cur.next[c-'0'] == null) {
                        cur.next[c-'0'] = new Node();
                        cur.cnt++;
                    }
                    cur = cur.next[c-'0'];
                }
                if (!cur.isNum) cur.isNum = true;
            }
            int cnt = 0;
            int res = 0;
            private boolean preOrderTraversal(Node r, StringBuilder s, int k, int cur) { // pre-order traversal
                if (r == null) return false;
                if (r.cnt )
                if (r.isNum) {
                    cnt++;
                    if (cnt == k) {
                        res = Integer.parseInt(s.toString());
                        return true;
                    }
                }
                if (r.next == null) return false;
                for (int i = 0; i < 10; i++) {
                    s.append((char)(i + '0'));
                    if (preOrderTraversal(r.next[i], s, k)) return true;
                    s.deleteCharAt(s.length()-1);
                }
                return false;
            }
            public int getKthSmallestNumber(int k) {
                cnt = 0;
                res = 0;
                preOrderTraversal(root, new StringBuilder(), k, 0);
                return res;
            }
        }
        public int findKthNumber(int n, int k) {
            if (n == 1 && k == 1) return 1;
            Trie t = new Trie();
            for (int i = 1; i <= n; i++) 
                t.insert(String.valueOf(i));
            return t.getKthSmallestNumber(k);
        }
        // 就像dfs时当我们需要两个字符串，遍历字符串，我们并不需要看的去遍历字符串，我们只要移动下标就可以了
        // 这里我们并不需要真的去建和遍历这样一个字典，我们只要理清数字个数之间的关系就可以了
        // 还要一个典型案例，把它找出来。。。。 todo
        private int calSteps(int n, long n1, long n2) { // n1 和 n2得是long类型的, int会产生溢出, 不能通过这个案例: 输入n=681692778, k=351251360, 预期结果=416126219
            int steps = 0;
            while (n1 <= n) {
                steps += Math.min(n2, n+1) - n1;
                n1 *= 10;
                n2 *= 10;
            }
            return steps;
        }
        public int findKthNumber(int n, int k) {
            int cur = 1; //根据题意, 第一个数是1
            --k;         //第一个是1, 所以再找出k-1个数后就知道第k个数是多少了
            while (k > 0) {
                int steps = calSteps(n, cur, cur+1);
                if (steps <= k) { //横向扩展, 相当于+steps,
                    cur += 1;
                    k -= steps;
                } else {          //steps > k; 纵向扩展, 相当于+1
                    cur *= 10;
                    k -= 1;
                }
            }
            return cur;
        }
            
            int cur = 1;
            k = k-1;
            while(k>0){
                int steps = calSteps(n, cur, cur+1);
                if(steps<=k){
                    cur +=1 ;
                    k -= steps;
                }
                else{
                    cur *= 10;
                    k-=1;
                }
            }
            return cur;
        }
        private int calSteps(int n, long n1, long n2){
            int steps = 0;
            while(n1<=n){
                steps += Math.min(n2, n+1) - n1;
                n1 *= 10;
                n2 *= 10;
            }
            return steps;
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int res = s.findKthNumber(681692778, 351251360);
        System.out.println("res: " + res);
    }
}
