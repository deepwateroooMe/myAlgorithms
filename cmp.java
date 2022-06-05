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
    public static class Solution {

        public int minMaxGame(int[] a) {
            int n = a.length;
            while (n > 1) {
                for (int i = 0; i < n/2; i++) {
                    if (i % 2 == 0)
                        a[i] = Math.min(a[2 * i], a[2 * i + 1]);
                    else 
                        a[i] = Math.max(a[2 * i], a[2 * i + 1]);
                }
                n /= 2;
            }
            return a[0];
        }

        public int partitionArray(int[] a, int k) {
            int n = a.length, cnt = 1;
            Arrays.sort(a);
            int min = a[0], max = a[0], i = 0;
            while (i < n) {
                max = Math.max(max, a[i]);
                if (max - min > k) {
                    cnt++;
                    min = max = a[i];
                }
                i++;
            }
            return cnt;
        }

        public int[] arrayChange(int[] a, int[][] b) {
            Map<Integer, Integer> m = new HashMap<>();
            int n = a.length;
            for (int i = 0; i < n; i++) 
                m.put(a[i], i);
            for (int [] c : b) {
                int u = c[0], v = c[1];
                m.put(v, m.get(u));
                m.remove(u);
            }
            for (Map.Entry<Integer, Integer> en : m.entrySet()) {
                int v = en.getKey(), i = en.getValue();
                a[i] = v;
            }
            return a;
        }

        class TextEditor {
            StringBuilder s;
            int i; 
            public TextEditor() {
                s = new StringBuilder();
                i = 0;
            }
            public void addText(String text) {
                s.insert(i, text); 
                i += text.length();
            }
            public int deleteText(int k) {
                int cnt = 0;
                for (int j = i-1; j >= 0 && k > 0; j--, k--, i--) {
                    s.deleteCharAt(j);
                    cnt++;
                }
                return cnt;
            }
            public String cursorLeft(int k) {
                while (k > 0 && i > 0) {
                    i--;
                    k--;
                }
                return s.substring((i >= 10 ? i-10 : 0), i).toString();
            }
            public String cursorRight(int k) {
                while (k > 0 && i < s.length()) {
                    k--;
                    i++;
                }
                return s.substring((i >= 10 ? i-10 : 0), i).toString();
            }
        }
    }
    public static void main(String args[]) {
        // Solution s = new Solution();
        cmp s = new cmp(); // The current text is "|". (The '|' character represents the cursor)

        s.addText("leetcode"); // The current text is "leetcode|".

        int r = s.deleteText(4); // return 4
        System.out.println("r: " + r);
        // The current text is "leet|". 
        // 4 characters were deleted.

        s.addText("practice"); // The current text is "leetpractice|". 

        String r1 = s.cursorRight(3); // return "etpractice"
        System.out.println("r1: " + r1);
        // The current text is "leetpractice|". 
        // The cursor cannot be moved beyond the actual text and thus did not move.
        // "etpractice" is the last 10 characters to the left of the cursor.

        String r3 = s.cursorLeft(8); // return "leet"
        System.out.println("r3: " + r3);
        // The current text is "leet|practice".
        // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.

        int r2 = s.deleteText(10); // return 4
        System.out.println("r2: " + r2);
        
        // The current text is "|practice".
        // Only 4 characters were deleted.
        String r4 = s.cursorLeft(2); // return ""
        System.out.println("r4: " + r4);
        // The current text is "|practice".
        // The cursor cannot be moved beyond the actual text and thus did not move. 
        // "" is the last min(10, 0) = 0 characters to the left of the cursor.

        String r5 = s.cursorRight(6); // return "practi"
        System.out.println("r5: " + r5);
        // The current text is "practi|ce".
        // "practi" is the last min(10, 6) = 6 characters to the left of the cursor.

        // int [] a = new int [] {1,3,5,2,4,8,2,2};

        // int r = s.minMaxGame(a);
        // System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
