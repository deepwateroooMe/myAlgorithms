import com.ListNode;

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

        // public boolean checkValid(int[][] a) {
        //     n = a.length;
        //     for (int i = 0; i < n; i++) { // rows
        //         autoFil();
        //         for (int j = 0; j < n; j++) {
        //             if (s.contains(a[i][j]))
        //                 s.remove(a[i][j]);
        //         }
        //         if (s.size() > 0) return false;
        //     }
        //     for (int j = 0; j < n; j++) {
        //         autoFil();
        //         for (int i = 0; i < n; i++) {
        //             if (s.contains(a[i][j]))
        //                 s.remove(a[i][j]);
        //         }
        //         if (s.size() > 0) return false;
        //     }
        //     return true;
        // }
        // int n;
        // Set<Integer> s = new HashSet<>();
        // void autoFil() {
        //     s.clear();
        //     for (int i = 1; i <= n; i++) 
        //         s.add(i);
        // }

        // public int minSwaps(int[] a) { // BUG 
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     int i = 0, j = n-1;
        //     while (i < n && a[i] == 0) i++;
        //     while (j >= 0 & a[j] == 0) j--;
        //     int befAft = i + n-1-j;
        //     int mid = n - (n-1-j+i) - sum; // 中间的
        //     if (mid <= befAft) return mid;
        //     // 首尾两个=1 or a[0] = 1 a[n-1] = 0 or a[0] = 0 a[n-1] = 1 ....
        //     return Math.min(n-(i+n-1-j)-sum, 0);
        //     // 首尾相连起来的情况再想一下
        // }
        // public int minSwaps(int[] a) { // BUG
        //     int n = a.length, cnt = 0, sum = Arrays.stream(a).sum();
        //     int [] bef = new int [n];
        //     int [] aft = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         if (a[i] == 0) bef[i] = ++cnt;
        //     cnt = 0;
        //     for (int i = n-1; i >= 0; i--) 
        //         if (a[i] == 0) aft[i] = ++cnt;
        //     int i = 0, j = n-1;
        //     while (i < n && a[i] == 0) i++;
        //     while (j >= 0 & a[j] == 0) j--;
        //     int befAft = i + n-1-j;
        //     int mid = n - (n-1-j+i) - sum; // 中间的
        //     int ans = Math.min(befAft, mid), ones = 0, before = 0, after = 0;
        //     for (int k = i; k <= j; k++) {
        //         ones += a[i];
        //         before = ones;
        //         after = ones;
        //         int x = j;
        //         while (x >= 0 && after < sum) {
        //             after += a[x];
        //             x--;
        //         } 
        //         ans = Math.min(ans, Math.min(x-k, k+1-ones+(n-1-x-(sum-ones))));
        //     }
        //     // if (mid <= befAft) return mid;
        //     // // 首尾两个=1 or a[0] = 1 a[n-1] = 0 or a[0] = 0 a[n-1] = 1 ....
        //     //     return Math.min(n-(i+n-1-j)-sum, 0);
        //     return ans;
        // }
        // public int minSwaps(int[] arr) { // 大致的思路都是有的，只是环形数组，把自己复制一遍贴在后面，考的时候没有想到
        //     int n = arr.length * 2, sum = Arrays.stream(arr).sum(), j = 0, ans = n, cnt = 0;
        //     int [] a = new int [n];
        //     System.arraycopy(arr, 0, a, 0, n/2);
        //     System.arraycopy(arr, 0, a, n/2, n/2);
        //     System.out.println(Arrays.toString(a));
        //     for (int i = 0; i < sum; i++) 
        //         cnt += 1-a[i];
        //     ans = Math.min(ans, cnt);
        //     j = 0;
        //     for (int i = sum; i < n; i++) {
        //         cnt += 1 - a[i];
        //         cnt -= 1 - a[j++];
        //         ans = Math.min(ans, cnt);
        //     }
        //     return ans;
        // }

        // public int earliestFullBloom(int[] pt, int[] gt) {
        //     int n = pt.length, t = 0, d = 0;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> y[2]-x[2]);
        //     for (int i = 0; i < n; i++) 
        //         q.offer(new int [] {pt[i], gt[i], pt[i]+gt[i]});
        //     while (!q.isEmpty()) {
        //         int [] cur = q.poll();
        //         t += cur[0]; // 对于生长等待期，也需要记录一下是否所有的都开花了，最长剩余生长期天数
        //         t = Math.max(t, cur[0])
        //     }            
        // }

        // // 这个最开始的还算比较好的思路，就叫行百里者，半于九十！！！
        // public int wordCount(String[] bgn, String[] end) { // tle: 91 / 93 test cases passed.
        //     int m = bgn.length, n = end.length, ans = 0;
        //     Set<Integer> si = new HashSet<>();
        //     Map<Integer, Set<Integer>> map = new HashMap<>();
        //     for (String s : bgn) 
        //         map.computeIfAbsent(s.length(), z -> new HashSet<>()).add(getMask(s));
        //     // Arrays.sort(end, (a, b)->Integer.compare(a.length(), b.length())); // 这些排序在这里都是没用的
        //     for (String s : end) {
        //         int len = s.length();
        //         Integer lower = map.lowerKey(len);
        //         if (lower == null || lower < len-1) continue;
        //         int cur = getMask(s);
        //         for (Integer mask : map.get(lower)) {
        //             int tmp = cur ^ mask;
        //             if (Integer.bitCount(tmp) == 1) {
        //                 ans++;
        //                 // bk = true;
        //                 break;
        //             }
        //         }
        //     }
        //     return ans;
        // }
        // int getMask(String t) {
        //     int n = t.length();
        //     int mask = 0;
        //     for (char c : t.toCharArray()) 
        //         mask |= 1 << (c - 'a');
        //     return mask;
        // }
        // // 跟我最开始bitmask的思路好像，可是别人用了array to string作为hashSet的值,确实比我用bitmask的高率
        // public int wordCount(String[] bgn, String[] end) {  // 参考别人的答案
        //     Map<Integer, Set<String>> m = new HashMap<>();
        //     for (String w : bgn) {
        //         char [] ca = new char[26];
        //         for (char c : w.toCharArray()) {
        //             ++ca[c - 'a'];
        //         }
        //         m.computeIfAbsent(w.length(), s -> new HashSet<>()).add(String.valueOf(ca));
        //     }
        //     int cnt = 0;
        // outer: // 这个标记，这次需要学会了！！！
        //     for (String w : end) {
        //         char[] ca = new char[26];
        //         for (char c : w.toCharArray()) 
        //             ++ca[c - 'a'];
        //         for (char c : w.toCharArray()) {
        //             --ca[c - 'a'];
        //             int sz = w.length() - 1;
        //             if (m.containsKey(sz) && m.get(sz).contains(String.valueOf(ca))) {
        //                 ++cnt;
        //                 continue outer;
        //             }
        //             ++ca[c - 'a'];
        //         }
        //     }
        //     return cnt;
        // }
        public int wordCount(String[] bgn, String[] end) { // tle: 91 / 93 test cases passed.
            Map<Integer, Set<String>> m = new HashMap<>();
            for (String s : bgn) {
                char [] cnt = new char [26]; // 为什么char []会比 char [] 快那么多呢？
                for (char c : s.toCharArray()) 
                    cnt[c-'a']++;
                m.computeIfAbsent(s.length(), z -> new HashSet<>()).add(Arrays.toString(cnt));
            }
            char ans = 0;
        outer:
            for (String s : end) {
                char [] cnt = new char [26];
                for (char c : s.toCharArray()) 
                    cnt[c-'a']++;
                for (char c : s.toCharArray()) {
                    cnt[c-'a']--;
                    int k = s.length()-1;
                    if (m.containsKey(k) && m.get(k).contains(Arrays.toString(cnt))) {
                        ans++;
                        continue outer;
                    }
                    cnt[c-'a']++;
                }
            }
            return ans;
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        String [] a = new String [] {"ant","act","tack"};
        String [] b = new String [] {"tack","act","acti"};

        int r = s.wordCount(a, b);
        System.out.println("r: " + r);
    }
}

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

 // ListNode r = s.deleteMiddle(head);
 // r.printList(r);

 // TreeNode root = new TreeNode(a[0]);
 // root.buildTree(root, a);
 // root.levelPrintTree(root);
        
 // String r = s.getDirections(root, 2, 1);
 // System.out.println("r: " + r);
