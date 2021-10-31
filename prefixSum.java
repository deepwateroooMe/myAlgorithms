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


        // public int findMaxLength(int[] arr) {
        //     int n = arr.length;
        //     int [] sum = Arrays.copyOf(arr, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     int max = 0, j = 0;
        //     for (int i = 0; i < n; i++) { // 左右两端是怎么移动来着？
        //         int v = sum[i] - (j == 0 ? 0 : sum[j-1]);
        //         if (i-j+1 == v * 2) max = Math.max(max, i-j+1);
        //     }
        // }

        // public int largestAltitude(int[] gain) {
        //     int n = gain.length, max = 0;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) {
        //         sum[i] = sum[i-1]+ gain[i-1];
        //         max = Math.max(max, sum[i]);
        //     }
        //     return max;
        // }

        // public int minStartValue(int[] a) {
        //     int n = a.length, min = Integer.MAX_VALUE, sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         sum += a[i];
        //         min = Math.min(min, sum);
        //     }
        //     return min >= 1 ? 1 : 1 - min;
        // }

        // public int findMiddleIndex(int[] a) {
        //     int n = a.length, idx = 0;
        //     int [] sum = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) 
        //         sum[i] += sum[i-1];
        //     for (int i = 0; i < n; i++) {
        //         int left =  (i == 0 ? 0 : sum[i-1]);
        //         int right = (i == n-1 ? 0 : sum[n-1] - sum[i]);
        //         if (left == right) return i;
        //     }
        //     return -1;
        // }

        // public boolean isCovered(int[][] ranges, int left, int right) {
        //     int [] cnt = new int [51];
        //     for (int [] r : ranges) 
        //         for (int i = r[0]; i <= r[1]; i++) 
        //             cnt[i]++;
        //     for (int i = left; i <= right; i++) 
        //         if (cnt[i] == 0) return false;
        //     return true;
        // }

        // public int pivotIndex(int[] a) {
        //     int n = a.length;
        //     int [] sum = Arrays.copyOf(a, n);
        //     for (int i = 1; i < n; i++) sum[i] += sum[i-1];
        //     for (int i = 0; i < n; i++) {
        //         int left = i == 0 ? 0 : sum[i-1];
        //         int right = i == n-1 ? 0 : sum[n-1] - sum[i];
        //         if (left == right) return i;
        //      }
        //     return -1;
        // }

        // private boolean isValid(int [][] arr, int i, int j, int x, int y) {
        //     int rval = row[i][y] - (j == 0 ? 0 : row[i][j-1]);
        //     for (int k = i+1; k <= x; k++) 
        //         if (row[k][y] - (j == 0 ? 0 : row[k][j-1]) != rval) return false;
        //     int cval = col[x][y] - (i == 0 ? 0 : col[i-1][j]);
        //     if (cval != rval) return false;
        //     for (int k = j+1; k <= y; k++) 
        //         if (col[x][k] - (i == 0 ? 0 : col[i-1][k]) != cval) return false;
        //     int sumA = 0, sumB = 0;
        //     for (int k = i; k <= x; k++)
        //         sumA += arr[i][k-(i >= j ? i-j : j-i)]; // 这里好像写得有点儿问题
        //     if (sumA != rval) return false;
        //     sum = 0;
        // }
        // int [][] row;
        // int [][] col;
        // int m, n;
        // public int largestMagicSquare(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     row = new int [m][n];
        //     col = new int [m][n];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++) 
        //             row[i][j] = (j == 0 ? 0 : row[i][j-1]) + grid[i][j];
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             col[i][j] = (i == 0 ? 0 : col[i-1][j]) + grid[i][j];
        //     for (int d = 1; d <= Math.min(m, n); d++) {
        //         for (int i = 0; i+d <= m; i++) {
        //             for (int j = 0; j+d <= n; j++) {
        //                 int x = i + d -1, y = j + d - j;


    // int [] arr;
    // double [] probs;
    // TreeMap<Double, Integer> map = new TreeMap<>();
    // Random rand;
    // int n, sum;
    // public Solution(int[] w) {
    // // public prefixSum(int [] w) {
    //     this.arr = w;
    //     for (int i = 1; i < n; i++) 
    //         arr[i] += arr[i-1];
    //     n = w.length;
    //     sum = Arrays.stream(w).sum();
    //     probs = new double[n];
    //     for (int i = 0; i < n; i++) {
    //         probs[i] = (double)arr[i] / (double)sum;
    //         map.put(probs[i], arr[i] - (i == 0 ? 0 : arr[i-1]));
    //     }
    //     rand = new Random();
    // }
    
    // public int pickIndex() {
    //     if (n == 1) return 0;
    //     double p = rand.nextDouble();
    //     Double v = map.floorKey(p);
    //     if (v != null) return map.get(v);
    //     else return arr[0];
    // }


        // // Input:         [[1,4,5],[1,4,7],[4,7,1],[4,7,11]]
        // // Output:        [[1,7,12]]
        // // Expected:      [[1,4,12],[4,7,12]]
        // public List<List<Long>> splitPainting(int[][] segments) { // 上面的情况：不知道怎么把它分成两半
        //     // Arrays.sort(segments, (a,b)-> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        //     int n = segments.length, N = 100001;
        //     // int n = segments.length, N = 20;
        //     long [] sum = new long [N];
        //     for (int [] v : segments) {
        //         int l = v[0], r = v[1];
        //         for (int i = l; i < r; i++) 
        //             sum[i] += v[2];
        //     }
        //     System.out.println(Arrays.toString(sum));
        //     List<List<Long>> ans = new ArrayList<>();
        //     int i = 0, j = 0;
        //     while (i < N && sum[i] == 0) i++;
        //     j = i; // j: bgn
        //     while (i < N) {
        //         while (i < N-1 && sum[i] == sum[i+1]) i++;
        //         if (i >= j) ans.add(List.of((long)j, (long)(i+1), sum[i]));
        //         j = i+1;
        //         i += 1;
        //         while (i < N && sum[i] == 0) i++;
        //         j = i;
        //     }
        //     return ans;
        // }
        // int [][] a = new int [][] {{1,4,5},{1,4,7},{4,7,1},{4,7,11}};
        // List<List<Long>> r = s.splitPainting(a);
        // System.out.println("r.size(): " + r.size());
        // for (int z = 0; z < r.size(); ++z) 
        //     System.out.println(Arrays.toString(r.get(z).toArray()));


        // public int findMaxLength(int[] a) {
        //     int n = a.length, ca = 0, cb = 0;
        //     int [] one = new int [n];
        //     int [] zoo = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == 1) ca++;
        //         else cb++;
        //         one[i] = ca;
        //         zoo[i] = cb;
        //     }
        //     int j = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (one[i] == zoo[i]) {
        //             max = Math.max(max, i+1);
        //             continue;
        //         } else if (one[i] - (j == 0 ? 0 : one[j-1]) == zoo[i] - (j == 0 ? 0 : zoo[j-1])) {
        //             max = Math.max(max, i-j+1);
        //         }
        //         ca = one[i];
        //         cb = zoo[i];
        //         while (ca > cb && a[j] == 1 && j < i
        //                || ca < cb && a[j] == 0 && j < i) {
        //             if (a[j] == 1) ca--;
        //             else cb--;
        //             j++;
        //         }
        //         if (ca == cb && j < i)
        //             max = Math.max(max, i-j+1);
        //     }
        //     return max;
        // }
        // public int findMaxLength(int[] a) {
        //     int n = a.length, j = 0, max = 0, cnt = 0;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + a[i-1];
        //     // System.out.println(Arrays.toString(a));
        //     // System.out.println(Arrays.toString(sum));
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (i+1 == sum[i+1] * 2) {
        //             max = Math.max(max, i+1);
        //             continue;
        //         }
        //         while (sum[i+1] - sum[j] < i-j - (sum[i+1] - sum[j]) && j < i && a[j] == 0
        //                || sum[i+1] - sum[j] > i-j - (sum[i+1] - sum[j]) && j < i && a[j] == 1) j++;
        //         if (sum[i+1]-sum[j] * 2 == i-j)
        //             max = Math.max(max, i-j+1);
        //     }
        //     return max;
        // }

        // public static int minMoves(int[] nums,int limit) {
        //     int n = nums.length , lessStep = Integer.MAX_VALUE;
        //     // 所有可能的结果是[2,limit * 2] , steps[i] 表示将 所有的数对 和 置为 i 时 所需要 移动的次数;
        //     int[] steps = new int[limit * 2 + 1];
        //     // 差分数组,diff[i] 表示 step[i - 1] 与 step[i] 的差异性， 即 step[i - 1] - step[i]
        //     int[] diff = new int[limit * 2 + 2];
        //     /**
        //      * 循环计算对于每个数对，假设改为 x 所需要的 改动次数
        //      * 使用差分数组 降低 遍历 x 所需要的时间复杂度
        //      * 最终 diff[i] 中 记录了 把所有数对设置为 i 所需要的变动次数
        //      * */
        //     for (int i = 0 , j = n - 1; i < j ;i++,j--) {
        //         int min = Math.min(nums[i],nums[j]) , max = Math.max(nums[i],nums[j]);
        //         // [2,min]区间的和 所需要的变换次数都是 2 次
        //         diff[2] += 2;
        //         diff[min + 1] -= 2;
        //         // [min + 1,min + max - 1]区间中的和 所需要变的次数都是1次
        //         diff[min + 1] += 1;
        //         diff[min + max] -= 1;
        //         // [min + max] 和正好符合不需要改动
        //         // [min + max + 1,max + limit]区间中的和 只需要变动 1 次;
        //         diff[min + max + 1] += 1;
        //         diff[max + limit + 1] -= 1;
        //         // [max + limit + 1,limit * 2] 区间中的和 ，需要改动两次;
        //         diff[max + limit + 1] += 2;
        //         diff[limit * 2 + 1] -= 2;
        //     }
        //     // 将差分数组付到原来数组上,合并操作
        //     for (int i = 1;i < steps.length;i++) 
        //         steps[i] = steps[i - 1] + diff[i];
        //     // 求出最小改动次数
        //     for (int i = 2;i <= limit * 2;i++) 
        //         lessStep = Math.min(lessStep, steps[i]);
        //     return lessStep;
        // }
        public int minMoves(int[] nums, int limit) {
            int n = nums.length;
            int [] delta = new int [2 * limit + 2]; // 差分数组
            for (int i = 0; i < n/2; i++) {
                int a = Math.min(nums[i], nums[n-1-i]);
                int b = Math.max(nums[i], nums[n-1-i]); // 把各区间所需要的操作简化到五行代码中去了
                delta[2] += 2; // dec a, decreasing b [2, a] 区间的和 所需要的变换次数都是 2 次
                delta[a+1]--;  // dec a               [a + 1, a+b-1] 区间中的和 所需要变的次数都是1次
                delta[a+b]--;  // no operations
                delta[a+b+1]++;// inc a               [a+b+1, b+limit] 区间中的和 只需要变动 1 次;
                delta[b+limit+1]++; // inc a, inc b
            }
            int ans = 2 * n, sum = 0;
            for (int t = 2; t <= 2 * limit; t++) {
                sum += delta[t]; // 差分数组的前缀和等于（共需要的操作次数）
                ans = Math.min(ans, sum);
            }
            return ans;
        }


        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {1, 2, 4, 3};

        int r = s.minMoves(a, 4);
        System.out.println("r: " + r);
    }
}