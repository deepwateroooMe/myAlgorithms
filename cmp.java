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

        // public int countHillValley(int[] a) {
        //     int n = a.length, cnt = 0;
        //     for (int i = 1; i < n; i++) {
        //         if (a[i] == a[i-1]) continue;
        //         if (a[i] > a[i-1]) {
        //             int j = i+1;
        //             while (j < n && a[j] == a[i]) j++;
        //             if (j == n) return cnt;
        //             if (a[j] < a[i]) cnt++;
        //             i = j-1;
        //         } else { // a[i] < a[i-1]
        //             int j = i+1;
        //             while (j < n && a[j] == a[i]) j++;
        //             if (j == n) return cnt;
        //             if (a[j] > a[i]) cnt++;
        //             i = j-1;
        //         }
        //     }
        //     return cnt;
        // }

        // // 很久没有写算法题，居然连bitmask也会忘记了。。。。。。
        // public int[] maximumBobPoints(int numArrows, int[] a) { // 这个应该是动态规划的题吧：现在对动态规划的题有点儿陌生了。。。。。。
        //     int n = a.length;
        //     int [] b = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         b[i] = a[i] + 1;
        //     int max = 0, mmask = 0, sum = 0, cur = 0;
        //     for (int i = 1; i < (1 << n); i++) {
        //         sum = 0;
        //         cur = 0; // maxScore
        //         for (int j = 1; j < n; j++) { // 遍历b[j]: 这里下标0不得分，所以暂时就不用考虑
        //             if (((i >> j) & 1) == 1) {
        //                 sum += b[j];
        //                 cur += j;
        //             }
        //         }
        //         if (sum > numArrows) continue;
        //         if (cur > max) {
        //             max = cur;
        //             mmask = i;
        //         }
        //     }
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         if (((mmask >> i) & 1) == 0) 
        //             b[i] = 0;
        //     b[0] = numArrows - Arrays.stream(b).sum();
        //     return b;
        // }

        // public int countCollisions(String t) {
        //     int n = t.length(), ans = 0;
        //     char [] s = t.toCharArray();
        //     Deque<Character> st = new ArrayDeque<>();
        //     st.offerLast(s[0]);
        //     for (int i = 1; i < n; i++) {
        //         char c = s[i];
        //         if (!st.isEmpty() && st.peekLast() == 'R' && c == 'L') {
        //             ans += 2;
        //             st.pollLast();
        //             c = 'S'; // 相撞了之后会变成这个样子的
        //         } else if (!st.isEmpty() && st.peekLast() == 'S' && c == 'L') {
        //             ans += 1;
        //             c = 'S'; // 相撞了之后会变成这个样子的
        //         }
        //         while (!st.isEmpty() && st.peekLast() == 'R' && c == 'S') {
        //             ans += 1;
        //             st.pollLast();
        //         }
        //         st.offerLast(c); // 最终的最新状态入栈
        //     }
        //     return ans;
        // }

        // public int[] longestRepeating(String t, String queryCharacters, int[] idx) { // 感觉思路想得是清淅的，可能想得还不是很彻底吧
        //     int n = t.length(), k = queryCharacters.length();
        //     char [] s = t.toCharArray();
        //     char [] q = queryCharacters.toCharArray();
        //     int [][] l = new int [n][26], r = new int [n][26];
        //     int [] ml = new int [n], mr = new int [n];
        //     l[0][s[0]-'a']++;
        //     ml[0] = 1;
        //     for (int i = 1; i < n; i++) {
        //         l[i][s[i]-'a'] = l[i-1][s[i]-'a'] + 1;
        //         ml[i] = Math.max(ml[i-1], l[i][s[i]-'a']);
        //     }
        //     r[n-1][s[n-1]-'a']++;
        //     mr[n-1] = 1;
        //     for (int i = n-2; i >= 0; i--) {
        //         r[i][s[i]-'a'] = 1 + r[i+1][s[i]-'a'];
        //         mr[i] = Math.max(mr[i+1], r[i][s[i]-'a']);
        //     }
        //     int [] ans = new int [k];
        //     for (int i = 0; i < k; i++) {
        //         System.out.println("\n i: " + i);
        //         char c = s[idx[i]];
        //         if (q[i] == c) { // 完全相同，没有变化
        //             ans[i] = Math.max(ml[i], mr[i]);
        //             continue;
        //         } // 接下来处理替换字母不同的情况：先 首尾两端
        //         if (idx[i] == 0 || idx[i] == n-1) { // 与前后不同 与前后相同的情况处理
        //             if (idx[i] == 0 && q[i] != s[idx[i]+1]) {
        //                 ans[i] = mr[0];
        //             } else if (idx[i] == 0 && q[i] == s[idx[i]+1]) {
        //                 ans[i] = Math.max(mr[0], ++r[0][q[i]-'a']);
        //                 if (r[0][q[i]-'a'] > mr[0]) mr[0] = r[0][q[i]-'a'];
        //             }
        //             else if (idx[i] == n-1 && q[i] != s[idx[i]-1]) ans[i] = ml[n-1];
        //             else {
        //                 ans[i] = Math.max(ml[n-1], ++l[n-1][q[i]-'a']);
        //                 if (l[n-1][q[i]-'a'] > ml[n-1]) ml[n-1] = l[n-1][q[i]-'a'];
        //             }
        //             s[idx[i]] = q[i]; // 仍然需要更新
        //             continue;
        //         }
        //         int j = idx[i];
        //         if (q[i] != s[j-1] && q[i] != s[j+1]) { // 两边都不等
        //             s[j] = q[i]; // 仍然需要更新
        //             l[j][s[j]-'a'] = 1; //l[j-1][s[j]-'a'] + 1;
        //             r[j][s[j]-'a'] = 1; //r[j+1][s[j]-'a'] + 1;
        //             ans[i] = Math.max(ml[j], mr[j]);
        //         } else if (q[i] == s[j-1] && q[i] == s[j+1]) { // 两边都等
        //             if (ml[j] == l[j][s[j]-'a']) ml[j] = ml[j-1];
        //             l[j][s[j]-'a'] = 0;
        //             s[j] = q[i];
        //             l[j][s[j]-'a'] = l[j-1][s[j]-'a'] + 1;
        //             int x = j+1;
        //             while (x < n && s[x] == s[j]) {
        //                 ++l[x][s[j]-'a'];
        //                 ml[x] = Math.max(ml[x-1], l[x][s[j]-'a']);
        //                 x++;
        //             }
        //             // while (x < n &&) // 这里仍然要对右边的ml最大值进行更新，这样就可能会超时：到这里就终于知道这个题目仍然是思路不通了。。。。。。
        //             r[j][s[j]-'a'] = r[j+1][s[j]-'a'] + 1;
        //             ml[j] = Math.max(ml[j-1], l[j][s[j]-'a']);
        //             mr[j] = Math.max(mr[j+1], r[j][s[j]-'a']);
        //             ans[i] = Math.max(Math.max(ml[j], mr[j]), l[j][s[j]-'a'] + r[j][s[j]-'a'] - 1);
        //         } else if (q[i] == s[j-1]) {
        //             s[j] = q[i]; // 仍然需要更新
        //             l[j][s[j]-'a'] = l[j-1][s[j]-'a'] + 1;
        //             r[j][s[j]-'a'] = 1; //r[j+1][s[j]-'a'] + 1;
        //             ml[j] = Math.max(ml[j-1], l[j][s[j]-'a']);
        //             ans[i] = Math.max(ml[j], mr[j]);
        //         } else {
        //             s[j] = q[i];
        //             l[j][s[j]-'a'] = 1;
        //             r[j][s[j]-'a'] = r[j+1][s[j]-'a'] + 1;
        //             mr[j] = Math.max(mr[j+1], r[j][s[j]-'a']);
        //             ans[i] = Math.max(mr[j], ml[j]);
        //         }
        //     }
        //     return ans;
        // }
        // Store the span of each letter in a TreeMap
        // Also use a second TreeMap to record the frequency of each span length
        // On each query, update both TreeMaps
        public int[] longestRepeating(String t, String qchar, int[] idx) { 
            int n = t.length(), k = qchar.length();
            char [] s = t.toCharArray();
            char [] q = qchar.toCharArray();
            int [] ans = new int [k];
            TreeMap<Integer, Integer> len = new TreeMap<>(), span = new TreeMap<>(); // 两个升序排列的字典：单一字符序列首尾下标对
            // Stores span of each letter in the TreeMap
            for (int i = 0, j = 1; j <= n; j++)
                if (j == n || s[i] != s[j]) {
                    len.put(j-i, len.getOrDefault(j-i, 0) + 1);
                    span.put(i, j-1);
                    i = j;
                }
            // Update span on each query and find the max length
            for (int i = 0; i < k; i++) {
                int j = idx[i];
                if (s[j] != q[i]) {
                    // Remove the span that has the character to be updated
                    int l = span.floorKey(j), r = span.remove(l), length = r - l + 1;
                    if (len.get(length) == 1) len.remove(length);
                    else len.put(length, len.get(length)-1);
                    // if the character is going to be different from its neighbors, break the span 当前的不同字符将原序列折成了几段: 需要左右更新
                    if (l < j) { 
                        span.put(l, j-1);
                        len.put(j-l, len.getOrDefault(j-l, 0) + 1);
                    }
                    if (r > j) {
                        span.put(j+1, r);
                        len.put(r-j, len.getOrDefault(r-j, 0) + 1);
                    }
                    s[j] = q[i];
                    l = j;
                    r = j;
                    // if the character is going to be same as its neighbors, merge the span
                    if (j > 0 && s[j] == s[j-1]) {
                        l = span.floorKey(j);
                        length = span.remove(l) - l + 1;
                        if (len.get(length) == 1) len.remove(length);
                        else len.put(length, len.get(length)-1);
                    }
                    if (j < n-1 && s[j] == s[j+1]) {
                        int key = span.ceilingKey(j);
                        r = span.remove(key);
                        length = r - key + 1;
                        if (len.get(length) == 1) len.remove(length);
                        else len.put(length, len.get(length)-1);
                    }
                    span.put(l, r);
                    len.put(r-l+1, len.getOrDefault(r-l+1, 0) + 1);
                }
                ans[i] = len.lastKey();
            }
            return ans;
        }
        // public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        //     char[] arr = s.toCharArray();
        //     int m = arr.length, n = queryIndices.length;
        //     int[] output = new int[n];
        //     TreeMap<Integer, Integer> lengths = new TreeMap<>(), span = new TreeMap<>();
        //     for (int i = 0, j = 1; j <= m; j++) if (j == m || arr[i] != arr[j]) {
        //             lengths.put(j - i, lengths.getOrDefault(j - i, 0) + 1);
        //             span.put(i, j - 1);
        //             i = j;
        //         }
        //     for (int i = 0; i < queryIndices.length; i++) {
        //         int j = queryIndices[i];
        //         if (arr[j] != queryCharacters.charAt(i)) {
        //             int l = span.floorKey(j), r = span.remove(l), length = r - l + 1;
        //             if (lengths.get(length) == 1) lengths.remove(length);
        //             else lengths.put(length, lengths.get(length) - 1);
        //             if (l < j) {
        //                 span.put(l, j - 1);
        //                 lengths.put(j - l, lengths.getOrDefault(j - l, 0) + 1);
        //             }
        //             if (r > j) {
        //                 span.put(j + 1, r);
        //                 lengths.put(r - j, lengths.getOrDefault(r - j, 0) + 1);
        //             }
        //             arr[j] = queryCharacters.charAt(i);
        //             l = j;
        //             r = j;
        //             if (j > 0 && arr[j] == arr[j - 1]) {
        //                 l = span.floorKey(j);
        //                 length = span.remove(l) - l + 1;
        //                 if (lengths.get(length) == 1) lengths.remove(length);
        //                 else lengths.put(length, lengths.get(length) - 1);
        //             }
        //             if (j < m - 1 && arr[j] == arr[j + 1]) {
        //                 int key = span.ceilingKey(j);
        //                 r = span.remove(key);
        //                 length = r - key + 1;
        //                 if (lengths.get(length) == 1) lengths.remove(length);
        //                 else lengths.put(length, lengths.get(length) - 1);
        //             }
        //             span.put(l, r);
        //             lengths.put(r - l + 1, lengths.getOrDefault(r - l + 1, 0) + 1);
        //         }
        //         output[i] = lengths.lastKey();
        //     }
        //     return output;
        // }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        String a = "babacc";
        String b = "bcb";
        int [] c = new int [] {1, 3, 3};

        int [] r = s.longestRepeating(a, b, c);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
