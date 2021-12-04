import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class hardOne {
    public static class Solution {

        // public String shortestPalindrome(String t) { // tle 
        //     if (t.chars().distinct().count() == 1) return t;
        //     if (isPalindrome(t)) return t;
        //     int n = t.length();
        //     int i = n / 2 + (n % 2 == 1 ? 1 : 0) - 1;
        //     for (; i >= 0; i--) {
        //         if (i + i+1 < n && isPalindrome(t.substring(0, i+i+2)))
        //             return new StringBuilder (t.substring(i+i+2)).reverse().toString() + t;
        //         if (isPalindrome(t.substring(0, i+i+1)))
        //             return new StringBuilder (t.substring(i+i+1)).reverse().toString() + t;
        //     }
        //     return null;
        // }
        // private boolean isPalindrome(String t) {
        //     int i = 0, j = t.length() - 1;
        //     char [] s = t.toCharArray();
        //     while (i < j) 
        //         if (s[i++] != s[j--]) return false;
        //     return true;
        // }

        // public int[] maxSlidingWindow(int[] a, int k) { 
        //     int n = a.length, j = 0, max = Integer.MIN_VALUE, idx = 0;
        //     ArrayDeque<Integer> s = new ArrayDeque<>(); // max deque: 单调递减
        //     int [] ans = new int [n-(k-1)];
        //     for (int i = 0; i < n; i++) {
        //         while (!s.isEmpty() && s.peekFirst() <= i-k) s.pollFirst();
        //         while (!s.isEmpty() && a[s.peekLast()] <= a[i]) s.pollLast();
        //         s.offerLast(i);
        //         if (i >= k-1)
        //             ans[idx++] = a[s.peekFirst()];
        //     }
        //     return ans;
        // }

        public List<String> removeInvalidParentheses(String t) { // backtracking
            n = t.length();
            s = t.toCharArray();
            int l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                if (s[i] == )
            }
        }
        List<String> ans = new ArrayList<>();
        char [] s;
        int n;
        private void dfs(int idx, int l, int r, )
   }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {1,3,-1,-3,5,3,6,7};

        int [] r = s.maxSlidingWindow(a, 3);
        System.out.println(Arrays.toString(r));
    }
}
