// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

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


    }

    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {100, -23, -23, 404, 100, 23, 23, 23, 3, 404}; 
        // int []  a = new int []  {7, 6, 9, 6, 9, 6, 9, 7}; 
        int []  a = new int []  {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}; 

        int res = s.minJumps(a);
        System.out.println("res: " + res);
    }
}