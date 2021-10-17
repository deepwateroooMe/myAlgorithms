import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;


public class twoPointers {
    public static class Solution {

        // public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //     List<int []> res = new ArrayList<>();
        //     int m = firstList.length;
        //     int n = secondList.length;
        //     if (m == 0 || n == 0) return new int [0][0];
        //     int i = 0, j = 0;
        //     int [] a = null, b = null;
        //     while (i < m && j < n) {
        //         a = firstList[i];
        //         b = secondList[j];
        //         if (a[1] < b[0]) i++;
        //         else if (a[0] > b[1]) j++; // no intersections
        //         else if (a[0] <= b[0] && a[1] >= b[1]) { // a includes b
        //             res.add(b);
        //             j++;
        //         } else if (b[0] <= a[0] && b[1] >= a[1]) { // b includes a
        //             res.add(a);
        //             i++;
        //         } else if (a[1] >= b[1] && a[0] <= b[1]) { 
        //             res.add(new int [] {a[0], b[1]});
        //             j++;
        //         } else { 
        //             res.add(new int [] {b[0], a[1]});
        //             i++;
        //         }
        //     }
        //     int [][] ans = new int [res.size()][2];
        //     for ( i = 0; i < res.size(); i++) 
        //         ans[i] = res.get(i);
        //     return ans;
        // }


        // public char[][] rotateTheBox(char[][] box) {
        //     int m = box.length;
        //     int n = box[0].length, idx = n-1, bot = n-1;
        //     char [][] ans = new char [n][m];
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < m; j++) 
        //             ans[i][j] = box[m-1-j][i];
        //     System.out.println("ans.length: " + ans.length);
        //     for (int z = 0; z < ans.length; ++z) 
        //         System.out.println(Arrays.toString(ans[z]));
        //     for (int j = 0; j < m; j++) { // looping cols
        //         System.out.println("\n j: " + j);
        //         if ((new String(box[m-1-j])).indexOf('*') != -1) {
        //             idx = n-1; bot = n-1;
        //             while (idx > 0 && ans[idx][j] != '*' && ans[idx][j] != '#') --idx;
        //             if (ans[idx][j] == '#') {
        //                 while (idx > 0 && ans[idx][j] != '*') {
        //                     ans[bot][j] = '#';
        //                     ans[idx][j] = '.';
        //                     --idx;
        //                     --bot;
        //                 } 
        //             }
        //             System.out.println("idx: " + idx);
        //             int cnt = 0, k = idx-1, bcnt = 0, scnt = 0;
        //             while (k >= 0) {
        //                 while (k >= 0 && ans[k][j] != '*') {
        //                     if (ans[k][j] == '#') ++cnt;
        //                     else if (ans[k][j] == '*') ++bcnt;
        //                     --k;
        //                 }
        //                 System.out.println("k: " + k);
        //                 System.out.println("idx: " + idx);
        //                 if (k < 0 && cnt + bcnt == idx) break;
        //                 if (scnt > 0) {
        //                     bot = idx-1;
        //                     --idx;
        //                 } else if (scnt == 0) {
        //                     bot = k-1;
        //                     idx = k-1;
        //                 }
        //                 k--;
        //                 while (idx >= 0) {
        //                     if (ans[idx][j] == '#') {
        //                         ans[bot][j] = '#';
        //                         ans[idx][j] = '.';
        //                         --bot;
        //                     }
        //                     --idx;
        //                 }
        //             } 
        //             if (idx > 0) continue;
        //         } else {
        //             bot = n-1;
        //             idx = n-1;
        //             while (idx >= 0) {
        //                 if (ans[idx][j] == '#') {
        //                     ans[bot][j] = '#';
        //                     ans[idx][j] = '.';
        //                     --bot;
        //                 }
        //                 --idx;
        //             } 
        //         }
        //     }
        //     return ans;
        // }


        // public int numSubarrayBoundedMax(int[] arr, int left, int right) {
        //     int n = arr.length, ans = 0, j = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     for (int i = 0; i < n; i++) {
        //         // while (!q.isEmpty() && q.peekLast() < arr[i]) q.pollLast();
        //     }
        // }

        // public String findLongestWord(String s, List<String> dictionary) {
        //     int n = s.length();
        //     int m = dictionary.size(), i, j;
        //     String res = "", cur;
        //     for (int k = 0; k < m; k++) {
        //         i = 0; j = 0;
        //         cur = dictionary.get(k);
        //         while (i < n && j < cur.length()) {
        //             while (i < n && j < cur.length() && s.charAt(i) == cur.charAt(j)) {
        //                 i++;
        //                 j++;
        //             }
        //             if (i < n && j < cur.length() && s.charAt(i) != cur.charAt(j)) i++;
        //         }
        //         if (j == cur.length() && (cur.length() > res.length() || cur.length() == res.length() && res.compareTo(cur) > 0))
        //             res = cur;
        //     }
        //     return res;
        // }


        // public int expressiveWords(String s, String[] words) {
        //     int m = words.length;
        //     int n = s.length(), i, ans = 0;
        //     int [] cnt = new int [n];
        //     Arrays.fill(cnt, -1);
        //     int i = 0, idx = 0;
        //     while (i < n) {
        //     }
        //     for ( i = 0; i < n; i++) 
        //         cnt[s.charAt(i)]++;
        //     int [] cur = new int [128];
        //     for (String t : words) {
        //         Arrays.fill(cur, 0);
        //         for ( i = 0; i < t.length(); i++) 
        //             cur[t.charAt(i)]++;
        //         for ( i = 0; i < 128; i++) 
        //             if (cur[i] - cnt[i] > 0 || cnt[i] < 3 && cur[i] < cnt[i] || cnt[i] > 0 && cur[i] == 0) break;
        //         if (i < 128) continue;
        //         ++ans;
        //     }
        //     return ans;
        // }


        // public String lastSubstring(String s) {
        //     int n = s.length();
        //     TreeSet<String> ts = new TreeSet<>();
        //     for (int i = n-1; i >= 0; i--) 
        //         ts.add(s.substring(i));
        //     return ts.last();
        // }


    }   
    public static void main(String[] args) {
        Solution s = new Solution();

        String a = "leetcode";

        String r = s.lastSubstring(a);
        System.out.println("r: " + r);
    }
}

