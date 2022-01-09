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

        // public int minSwaps(int[] a) {
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
        // public int minSwaps(int[] a) {
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
        // public int minSwaps(int[] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum(), i = 0, j = 0;
        //     while (i < n && a[i] == 0) i++;
        //     while (j >= 0 && a[j] == 0) j--;
        //     int befAft = i + n-1-j;
        //     int mid = n - (n-1-j+i) - sum; // 中间的
        //     int ans = Math.min(befAft, mid), pre = 0;
        //     for ( ; i <= j; i++) { // 扫一遍中间的，还是有bug, 这里
        //         // pre = i;
        //         while (i < n && a[i] == 1) i++;
        //         pre = i;
        //         while (i < n && a[i] == 0) i++;
        //         ans = Math.min(ans, Math.min(i-pre-1, n-sum-(i-pre-1)));
        //     }
        //     return ans;
        // }

        // public int wordCount(String[] bgn, String[] end) { // tle
        //     int m = bgn.length, n = end.length, ans = 0;
        //     Set<Integer> si = new HashSet<>();
        //     TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        //     for (String s : bgn) 
        //         map.computeIfAbsent(s.length(), z -> new HashSet<>()).add(getMask(s));
        //     Arrays.sort(end, (a, b)->Integer.compare(a.length(), b.length()));
        //     // boolean bk = false;
        //     for (String s : end) {
        //         // bk = false;
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
        //         // if (bk) continue;
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

        public int earliestFullBloom(int[] pt, int[] gt) {
            int n = pt.length, t = 0, d = 0;
            Queue<int []> q = new PriorityQueue<>((x, y) -> y[2]-x[2]);
            for (int i = 0; i < n; i++) 
                q.offer(new int [] {pt[i], gt[i], pt[i]+gt[i]});
            while (!q.isEmpty()) {
                int [] cur = q.poll();
                t += cur[0]; // 对于生长等待期，也需要记录一下是否所有的都开花了，最长剩余生长期天数
                
                t = Math.max(t, cur[0])
            }            
            

        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        // int [] a = new int [] {1,1,0,0,1};
        int [] a = new int [] {0,1,1,1,0,0,1,1,0};

        int r = s.minSwaps(a);
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
