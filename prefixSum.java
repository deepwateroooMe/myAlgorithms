// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class prefixSum {
    public static class Solution {
        // public int sumOddLengthSubarrays(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return arr[0];
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if ((j-i+1) % 2 == 1) {
        //                 for (int k = i; k <= j; k++) 
        //                     sum += arr[k];
        //             }
        //         }
        //     }
        //     return sum;
        // }

        // public int[] getMaximumXor(int[] nums, int maximumBit) {
        //     int n = nums.length;
        //     int max = (int)Math.pow(2, maximumBit)-1;
        //     int [] arr = new int [n];
        //     int [] res = new int [n];
        //     arr[0] = nums[0];
        //     for (int i = 1; i < n; i++) 
        //         arr[i] = arr[i-1] ^ nums[i];
        //     for (int i = n-1; i >= 0; i--) 
        //         res[n-1-i] = arr[i] ^ max;
        //     return res;
        // }

        // public int[][] matrixBlockSum(int[][] mat, int k) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     if (m == 1 && n == 1) return mat;
        //     int [][] arr = new int[m][n];
        //     int val = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             val = 0;
        //             for (int x = i-k; x <= i+k; x++) {
        //                 if (x < 0 || x >= m) continue;
        //                 for (int y = j-k; y <= j+k; y++) {
        //                     if (y < 0 || y >= n) continue;
        //                     val += mat[x][y];
        //                 }
        //             }
        //             arr[i][j] = val;
        //         }
        //     }
        //     return arr;
        // }
        // public int[][] matrixBlockSum(int[][] mat, int k) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int [][] arr = new int[m][n]; // presum matrix
        //     int sum = 0;
        //     for (int i = 0; i < m; i++) {
        //         sum = 0;
        //         for (int j = 0; j < n; j++) {
        //             sum += mat[i][j];
        //             arr[i][j] = sum;
        //             if (i > 0) arr[i][j] += arr[i-1][j];
        //         }
        //     }
        //     int [][] res = new int[m][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             // 计算出对于该点存在的合理子矩阵范围
        //             int minR = Math.max(0, i-k);  // min Row
        //             int maxR = Math.min(m-1, i+k);// max Row
        //             int minC = Math.max(0, j-k);  // min Column
        //             int maxC = Math.min(n-1, j+k);  // max Column
        //             // 利用前缀和数组计算该子矩阵内所有数字和 (x1, y1)表示左上角坐标， (x2, y2)表示右下角坐标
        //                // sum([x1,y1],[x2,y2]) = presum[x2][y2]
        //                                 //     - presum[x1-1][y2]
        //                                 //     - presum[x2][y1-1]
        //                                 //     + presum[x1-1][y1-1];
        //             res[i][j] = arr[maxR][maxC];
        //             if (minR > 0) res[i][j] -= arr[minR-1][maxC];
        //             if (minC > 0) res[i][j] -= arr[maxR][minC-1];
        //             if (minR > 0 && minC > 0) res[i][j] += arr[minR-1][minC-1];
        //         }
        //     }
        //     return res;
        // }

        // public int[] productExceptSelf(int[] arr) {
        //     int n = arr.length;
        //     int [] res = new int[n];
        //     res[0] = 1;
        //     int cum = 1;
        //     for (int i = 1; i < n; i++) 
        //         res[i] = res[i-1] * arr[i-1];
        //     for (int i = n-2; i >= 0; i--) {
        //         cum *= arr[i+1];
        //         res[i] *= cum;
        //     }
        //     return res;
        // }

        // public int[] corpFlightBookings(int[][] bookings, int n) {
        //     int m = bookings.length;
        //     int [] arr = new int[n];
        //     for (int [] val : bookings) {
        //         for (int i = val[0]-1; i <= val[1]-1; i++) 
        //             arr[i] += val[2];
        //     }
        //     return arr;
        // }

        // public int largestMagicSquare(int[][] arr) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        //     int sum = 0, tmp = 0;
        //     int [] row = new int [m];
        //     int [] col = new int[n];
        //     for (int k = n; k >= 1; k--) {
        //         sum = 0;
        //         for (int j = 0; j + k-1 <= n-1; j++) { // col
        //             tmp = 0;
        //             for (int i = 0; i < m; i++) { // row
        //                 tmp += arr[i][j];
        //             }
        //             col[j] = tmp;
        //             if (j > 0 && col[j] != col[j-1]) break;
        //             tmp = 0;
        //         }
        //     }
        // }


        // public int[] getSumAbsoluteDifferences(int[] arr) {
        //     int n = arr.length;
        //     int [] pre = new int [n];
        //     int [] suf = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         pre[i] = (i == 0 ? 0 : pre[i-1]) + arr[i];
        //     for (int i = n-1; i >= 0; i--) 
        //         suf[i] = (i == n-1 ? 0 : suf[i+1]) + arr[i];
        //     int [] ans = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         ans[i] = arr[i]*i - (i == 0 ? 0 : pre[i-1]) + (i == n-1 ? 0 : suf[i+1] - arr[i]*(n-1-i));
        //     return ans;
        // }


        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {1, 4, 6, 8, 10};

        int[] res = s.getSumAbsoluteDifferences(a);
        System.out.println(Arrays.toString(res));
    }
}