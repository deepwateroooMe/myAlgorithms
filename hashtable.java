// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class hashtable {
    public static class Solution {

        // public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        //     int [][] arr = new int [n][n];
        //     boolean [][] vis = new boolean[n][n];
        //     for (int i = 0; i < lamps.length; i++) 
        //         for (int j = 0; j < lamps[i].length; j++) {
        //             arr[lamps[i][0]][lamps[i][1]] = 1;
        //             vis[lamps[i][0]][lamps[i][1]] = true;
        //         }
        //     for (int i = 0; i < lamps.length; i++) {
        //         for (int j = 0; j < lamps[i].length; j++) {
        //             if (arr[i][j] == 1 && vis[i][j]) {
        //                 for (int x = 0; x < n; x++) {
        //                     arr[i][x] = 1;
        //                     arr[x][j] = 1;
        //                     arr
        //                 }
        //             } 
        //         }
        //     }
        // }

        
        // public double[] medianSlidingWindow(int[] nums, int k) {
        //     TreeMap<Integer, Integer> ma = new TreeMap<>();
        //     TreeMap<Integer, Integer> mb = new TreeMap<>();
        //     for (int i = 0; i < k; i++) {
        //         if (i % 2 == 0) {
        //             mb.put(nums[i], mb.getOrDefault(nums[i], 0) + 1);
        //             int n = mb.firstKey();
        //             if (mb.get(n) == 1) mb.remove(n);
        //             else mb.put(n, mb.get(n) - 1);
        //             ma.put(n, ma.getOrDefault(n, 0) + 1);
        //         } else {
        //             ma.put(nums[i], ma.getOrDefault(nums[i], 0) + 1);
        //             int n = ma.lastKey();
        //             if (ma.get(n) == 1) ma.remove(n);
        //             else ma.put(n, ma.get(n) - 1);
        //             mb.put(n, mb.getOrDefault(n, 0) + 1);
        //         }
        //     }
        //     double [] res = new double[nums.length-k+1];
        //     if (k % 2 == 1) res[0] = ma.lastKey();
        //     else res[0] =  (double)(((long)(ma.lastKey()) + (long)(mb.firstKey())) / 2.0);
        //     for (int i = 0; i + k < nums.length; i++) {
        //         ma.put(nums[i+k], ma.getOrDefault(nums[i+k], 0) + 1);
        //         int n = ma.lastKey();
        //         if (ma.get(n) == 1) ma.remove(n);
        //         else ma.put(n, ma.get(n) - 1);
        //         mb.put(n, mb.getOrDefault(n, 0) + 1);
        //         if (ma.containsKey(nums[i])) {
        //             if (ma.get(nums[i]) == 1) ma.remove(nums[i]);
        //             else ma.put(nums[i], ma.get(nums[i]) - 1);
        //             int v = mb.firstKey();
        //             if (mb.get(v) == 1) mb.remove(v);
        //             else mb.put(v, mb.get(v) - 1);
        //             ma.put(v, ma.getOrDefault(v, 0) + 1);
        //         } else {
        //             if (mb.get(nums[i]) == 1) mb.remove(nums[i]);
        //             else mb.put(nums[i], mb.get(nums[i]) - 1);
        //         }
        //         if (k % 2 == 1) res[i+1] = ma.lastKey();
        //         else res[i+1] = (double)(((long)(ma.lastKey()) + (long)(mb.firstKey())) / 2.0);
        //     }
        //     return res;
        // }


        // public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //     Map<Integer, Set<Integer>> m = new HashMap<>();
        //     for (int [] arr : logs) 
        //         m.computeIfAbsent(arr[0], w -> new HashSet<>()).add(arr[1]);
        //     int [] ans = new int [k];
        //     for (Map.Entry<Integer, Set<Integer>> en : m.entrySet()) {
        //         int v = en.getValue().size();
        //         if (v <= k) ans[v-1]++;
        //     }
        //     return ans;
        // }

        // private int cntTarget(int [] arr, int target) {
        //     int cnt = 0, sum = 0;
        //     Map<Integer, Integer> cntMap = new HashMap<>();
        //     cntMap.put(0, 1);
        //     for (int i = 0; i < arr.length; i++) {
        //         sum += arr[i];
        //         cnt += cntMap.getOrDefault(sum - target, 0);
        //         cntMap.compute(sum, (k, v) -> { // 
        //                 if (v == null) v = 0;
        //                 return v+1;
        //             });
        //         return cnt;
        //     }
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length, cur = 0;
        //     int [][] sum = new int [m][n]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         cur = 0;
        //         for (int j = 0; j < n; j++) {
        //             cur += matrix[i][j];
        //             sum[i][j] = cur;
        //         }
        //     }
        //     int cnt = 0;
        //     for (int j = 0; j < n; j++) {
        //         for (int k = j; k < n; k++) {
        //             int [] tmp = new int [m];
        //             for (int i = 0; i < m; i++) 
        //                 tmp[i] = sum[i][k] - (j == 0 ? 0 : sum[i][j-1]);
        //             int oneCnt = cntTarget(tmp, target);
        //             cnt += oneCnt;
        //         }
        //     }
        //     return cnt;
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length, rowSum = 0;
        //     int [][] sum = new int [m][n]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         rowSum = 0;
        //         for (int j = 0; j < n; j++) {
        //             rowSum += matrix[i][j];
        //             sum[i][j] = rowSum + (i == 0 ? 0 : sum[i-1][j]);
        //         }
        //     }
        //     int cnt = 0, cur = 0;
        //     for (int j = 0; j < n; j++)     // col1
        //         for (int k = j; k < n; k++) {// col2
        //             Map<Integer, Integer> map = new HashMap<>(); // 用于记录前缀和个数
        //             for (int i = 0; i < m; i++) {
        //                 cur = sum[i][k] - (j == 0 ? 0 : sum[i][j-1]);
        //                 if (cur == target) ++cnt;
        //                 cnt += map.getOrDefault(cur - target, 0);
        //                 map.put(cur, map.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return cnt;
        // }
        // public int numSubmatrixSumTarget(int[][] matrix, int target) {
        //     int m = matrix.length, n = matrix[0].length;
        //     int [][] sum = new int [m][n+1]; // sums of row sum only
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) 
        //             sum[i][j+1] = sum[i][j] + matrix[i][j];
        //     }
        //     int cnt = 0, cur = 0;
        //     for (int j = 0; j < n; j++)      // col1
        //         for (int k = j; k < n; k++) {// col2
        //             cur = 0;
        //             Map<Integer, Integer> map = new HashMap<>(); // 用于记录前缀和个数
        //             map.put(0, 1);
        //             for (int i = 0; i < m; i++) {
        //                 cur += sum[i][k+1] - sum[i][j];
        //                 cnt += map.getOrDefault(cur - target, 0);
        //                 map.put(cur, map.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return cnt;
        // }

        // public int numSubmatrixSumTarget(int [][] matrix, int target) {
        //     int res = 0, m = matrix.length, n = matrix[0].length;
        //     int [][] sum = new int [m+1][n+1];
        //     for (int i = 1; i <= m; ++i) 
        //         for (int j = 1; j <= n; ++j) 
        //             sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
        //     for (int i = 1; i <= m; ++i) 
        //         for (int j = 1; j <= n; ++j) 
        //             for (int p = 1; p <= i; ++p) 
        //                 for (int q = 1; q <= j; ++q) {
        //                     int t = sum[i][j] - sum[i][q - 1] - sum[p - 1][j] + sum[p - 1][q - 1];
        //                     if (t == target) ++res;
        //                 }
        //     return res;
        // }
        // public int numSubmatrixSumTarget(int [][] matrix, int target) {
        //     int res = 0, m = matrix.length, n = matrix[0].length;
        //     for (int i = 0; i < m; ++i) 
        //         for (int j = 1; j < n; ++j) 
        //             matrix[i][j] += matrix[i][j - 1];
        //     for (int i = 0; i < n; ++i) 
        //         for (int j = i; j < n; ++j) {
        //             Map<Integer, Integer> cntMap = new HashMap<>();
        //             cntMap.put(0, 1);
        //             int cur = 0;
        //             for (int k = 0; k < m; ++k) {
        //                 cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
        //                 res += cntMap.getOrDefault(cur-target, 0);
        //                 cntMap.put(cur, cntMap.getOrDefault(cur, 0) + 1);
        //             }
        //         }
        //     return res;
        // }


        public int maxEqualFreq(int[] arr) {
            int n = arr.length, ans = 1;
            int maxLoc = 1;
            Map<Integer, Integer> m = new HashMap<>();
            int [] max = new int [n];
            int [] min = new int [n];
            for (int i = 0; i < n; i++) {
                m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
                maxLoc = Math.max(maxLoc, m.get(arr[i]));
                max[i] = maxLoc;
                min[i] = Collections.min(m.values());
                if (min[i] == 1) // 并且只有一个这样的数： 几种可能的情况分情况讨论一下
            }
            // System.out.println(Arrays.toString(arr));
            // System.out.println(Arrays.toString(min));
            // System.out.println(Arrays.toString(max));
            return 0;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {2, 2, 1, 1, 5, 3, 3, 5};
        
        int res = s.maxEqualFreq(a);
        System.out.println("res: " + res);
    }
}