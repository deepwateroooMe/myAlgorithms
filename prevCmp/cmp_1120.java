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

        public int maxDistance(int[] a) {
            int n = a.length;
            if (n < 2) return 0;
            if (a[0] != a[n-1]) return n-1;
            int i = 0, j = n-1;
            while (i < n-1 && a[i] == a[i+1]) i++;
            if (i == n) return 0;
            while (j > 0 && a[j-1] == a[j]) j--;
            return Math.max(j-1 - 0, n-1-(i+1));
        }

        public int wateringPlants(int[] p, int cap) {
            int n = p.length, cnt = 0, cur = cap;
            int [] dp = new int [n];
            for (int i = 0; i < n; i++) {
                if (cur >= p[i]) {
                    dp[i] = (i == 0 ? 0 : dp[i-1]) + 1;
                    cur -= p[i];
                } else {
                    dp[i] = dp[i-1] + 2 * (i-1 +1) + 1;
                    cur = cap - p[i];
                }
            }
            return dp[n-1];
        }

    // Map<Integer, Map<Integer, Integer>> m = new HashMap<>(); // tle: 用图的大致思路是对的，但还不够好，不契合题目的要求
    Map<Integer, TreeMap<Integer, Integer>> m = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) 
            m.computeIfAbsent(arr[i], z -> new TreeMap<>()).put(i, m.get(arr[i]).size()); // 这里写得好tricky，考试的时候紧张就想不到！！！
    }
    public int query(int left, int right, int value) {
        if (!m.containsKey(value)) return 0;
        TreeMap<Integer, Integer> map = m.get(value);
        Integer a = map.ceilingKey(left), b = map.floorKey(right);
        if (a == null || b == null) return 0;
        return map.get(b) - map.get(a) + 1;
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) 
            map.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
    }
    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> l = map.get(value);
        int s = Collections.binarySearch(l, left);
        int e = Collections.binarySearch(l, right);
        if (s < 0) s = (s + 1) * (-1);
        if (e < 0) e = (e + 2) * (-1);
        return e - s + 1;
    }
    Map<Integer, List<Integer>> map = new HashMap();
    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            map.computeIfAbsent(arr[i], z -> new ArrayList<>()).add(i);
    }
    public int query(int left, int right, int value) {
        List<Integer> A = map.get(value);
        if (A == null || left > A.get(A.size()-1) || right < A.get(0))
            return 0;
        int i = ceil(A, left), j = floor(A, right);        
        return j-i+1;
    }
    public int ceil(List<Integer> A, int x){
        int left = 0, right = A.size()-1; 
        if (x < A.get(0))
            return 0;
        while (left < right) {
            int mid = (left+right)/2;
            if (A.get(mid) < x)
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
    public int floor(List<Integer> A, int x){
        int left = 0, right = A.size ()-1; 
        if (x > A.get (right))
            return right;
        while (left < right) {
            int mid =  (left+right)/2+1;
            if (A.get (mid) > x)
                right = mid - 1;
            else 
                left = mid;
        }
        return left;
    }
    Map<Integer, Integer>[] freq;
    int n;
    public RangeFreqQuery(int[] arr) {
        n = arr.length;
        freq = new HashMap[4 * n];
        for(int i = 0; i < 4 * n; i++)
            freq[i] = new HashMap<>();
        build(1, 0, n - 1, arr);
    }
    private void build(int id, int start, int end, int[] arr){
        if(start == end)
            freq[id].put(arr[start], 1);
        else{
            int mid = (start + end) / 2, left = 2 * id, right = 2 * id + 1;
            build(left, start, mid, arr);
            build(right, mid + 1, end, arr);
            for(int i : freq[left].keySet())
                freq[id].put(i, freq[id].getOrDefault(i, 0) + freq[left].get(i));
            for(int i : freq[right].keySet())
                freq[id].put(i, freq[id].getOrDefault(i, 0) + freq[right].get(i));
        }
    }
    public int query(int left, int right, int value) {
        return find(1, 0, n - 1, left, right, value);
    }
    private int find(int id, int start, int end, int l, int r, int value){
        if(r < start || end < l)
            return 0;
        else if(start == end)
            return freq[id].getOrDefault(value, 0);
        else if(l <= start && end <= r)
            return freq[id].getOrDefault(value, 0);
        else{
            int mid = (start + end) / 2;
            int left = find(2 * id, start, mid, l, r, value);
            int right = find(2 * id + 1, mid + 1, end, l, r, value);
            return left + right;
        }
    }

        public long kMirror(int k, int n) {
            long ans = 0;
            int len = 1; // 从1位数开始
            while (n > 0) { // 找到n个满足条件的数字为止
                int halfLen = len / 2 + (len % 2 == 0 ? 0 : 1); // 当前数字长度的一半
                int max = (int)Math.pow(10, halfLen);   // 当前长度一半数字的最大值，
                int min = (int)Math.pow(10, halfLen-1); // 当前长度一半数字的最小值
                for (int i = min; i < max; i++) { // 循环范围内的每一个数字
                    long num = i, mirrorNum = i;
                    if (len % 2 == 1) num /= 10;
                    while (num > 0) {
                        mirrorNum = mirrorNum * 10 + num % 10;
                        num /= 10;
                    }
                    if (isMirror(mirrorNum, k)) {
                        ans += mirrorNum;
                        n--;
                        if (n == 0) break;
                    }
                }
                len++;
            }
            return ans;
        }
        private boolean isMirror(long val, int k) {
            long n = val, reverse = 0;
            while (n > 0) {
                reverse = reverse * k + n % k;
                n /= k;
            }
            return reverse == val;
        }
        public long kMirror(int k, int n) {
            int len = 1;
            while (res.size() < n) {
                char [] arr = new char[len];    
                dfs(arr, (k+"").charAt(0), 0);
                len++;
            }
            long sum = 0;
            for (int i = 0; i < n; i++) 
                sum += res.get(i);
            return sum; 
        }   
        List<Long> res = new ArrayList<>();
        private void dfs(char [] arr, char k, int idx) {
            if (idx >= (arr.length+1) / 2) {
                String s = new String(arr);
                long num10 = Long.parseLong(s, k-'0'); // 将字符串parse成以第二个参数为基数的有符号 long。
                String s10 = num10 + "";
                boolean valid = true;
                for (int left = 0, right = s10.length()-1; left < right; left++,right--)
                    if (s10.charAt(left) != s10.charAt(right)) {
                        valid = false;
                        break;
                    }
                if (valid) res.add(num10);
                return ;
            }
            for (char i = '0'; i < k; i++){
                if (idx == 0 && i == '0') continue; // 不算数字0
                arr[idx] = i; // 首尾对称的两个数字同时更新
                arr[arr.length -1 - idx] = i;
                dfs(arr, k, idx+1);
            }
        }
    }
    public static void main (String[] args) {
        Solution s = new Solution ();

        long r = s.kMirror (7, 17);
        System.out.println ("r: " + r);

        // cmp s = new cmp (a);
    }
}

