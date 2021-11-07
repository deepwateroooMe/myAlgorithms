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
        // public int minMoves(int[] nums, int limit) {
        //     int n = nums.length;
        //     int [] delta = new int [2 * limit + 2]; // 差分数组
        //     for (int i = 0; i < n/2; i++) {
        //         int a = Math.min(nums[i], nums[n-1-i]);
        //         int b = Math.max(nums[i], nums[n-1-i]); // 把各区间所需要的操作简化到五行代码中去了
        //         delta[2] += 2; // dec a, decreasing b [2, a] 区间的和 所需要的变换次数都是 2 次
        //         delta[a+1]--;  // dec a               [a + 1, a+b-1] 区间中的和 所需要变的次数都是1次
        //         delta[a+b]--;  // no operations
        //         delta[a+b+1]++;// inc a               [a+b+1, b+limit] 区间中的和 只需要变动 1 次;
        //         delta[b+limit+1]++; // inc a, inc b
        //     }
        //     int ans = 2 * n, sum = 0;
        //     for (int t = 2; t <= 2 * limit; t++) {
        //         sum += delta[t]; // 差分数组的前缀和等于（共需要的操作次数）
        //         ans = Math.min(ans, sum);
        //     }
        //     return ans;
        // }


        // public int minCharacters(String a, String b) {
        //     // System.out.println("a: " + a);
        //     // System.out.println("b: " + b);
        //     int m = a.length(), n = b.length();
        //     char [] s = a.toCharArray();
        //     char [] t = b.toCharArray();
        //      char as = 'z', al = 'a', bs = 'z', bl = 'a';
        //     int [] one = new int [26], two = new int [26];
        //     for (int i = 0; i < m; i++) {
        //         one[s[i]-'a']++;
        //          as = (char)(Math.min(as - 'a', s[i]-'a') + 'a');
        //          al = (char)(Math.max(al-'a', s[i]-'a') + 'a');
        //     }
        //     for (int i = 0; i < n; i++)  {
        //         two[t[i]-'a']++;
        //          bs = (char)(Math.min(bs-'a', t[i]-'a') + 'a');
        //          bl = (char)(Math.max(bl-'a', t[i]-'a') + 'a');
        //     }
        //     if (al < bs || bl < as || al == as && bl == bs && al == bl) return 0;
        //     int [] pa = Arrays.copyOf(one, 26);
        //     int [] pb = Arrays.copyOf(two, 26);
        //     for (int i = 1; i < 26; i++) 
        //         pa[i] += pa[i-1];
        //     for (int i = 1; i < 26; i++) 
        //         pb[i] += pb[i-1];
        //     // System.out.println(Arrays.toString(pa));
        //     // System.out.println(Arrays.toString(pb));
        //     int min = Math.max(m, n), cur = min;
        //     for (char c = 'a'; c <= 'z'; c++) {
        //         // System.out.println("\n c: " + c);
        //         cur = min;
        //         // if (c < bs)
        //         if (c < 'z')
        //             cur = Math.min(cur, m - one[c-'a'] + pb[c-'a']);
        //         // System.out.println("cur: " + cur);
        //         if (c > 'a')
        //             cur = Math.min(cur, n - two[c-'a'] + pa[al-'a'-1]);
        //         // System.out.println("cur: " + cur);
        //         cur = Math.min(cur, m-one[c-'a'] + n - two[c-'a']);
        //         // System.out.println("cur: " + cur);
        //         min = Math.min(min, cur);
        //         // System.out.println("min: " + min);
        //     }                
        //     return min;
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
        // private boolean isValid(int [][] arr, int i, int j, int x, int y, int d) {
        //     int rval = row[i][y] - row[i][j-1];
        //     for (int k = i+1; k <= x; k++) 
        //         if (row[k][y] - row[k][j-1] != rval) return false;
        //     int cval = col[x][j] - col[i-1][j];
        //     if (cval != rval) return false;
        //     for (int k = j+1; k <= y; k++) 
        //         if (col[x][k] - col[i-1][k] != cval) return false;
        //     int sumA = 0, sumB = 0;
        //     for (int k = 1; k <= d; k++) {
        //         sumA += arr[i+k-1][j+k-1];
        //         sumB += arr[i+k-1][j-k+1];
        //     }
        //     // System.out.println("\n i: " + i);
        //     // System.out.println("j: " + j);
        //     // System.out.println("d: " + d);
        //     // System.out.println("rval: " + rval);
        //     // System.out.println("cval: " + cval);
        //     // System.out.println("sumA: " + sumA);
        //     // System.out.println("sumB: " + sumB);
        //     if (sumA != rval || sumB != rval) return false;
        //     return true;
        // }
        // int [][] row;
        // int [][] col;
        // int m, n;
        // public int largestMagicSquare(int[][] grid) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     row = new int [m+1][n+1];
        //     col = new int [m+1][n+1];
        //     for (int i = 1; i <= m; i++)
        //         for (int j = 1; j <= n; j++)
        //             row[i][j] = row[i][j-1] + grid[i-1][j-1];
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++)
        //             col[i][j] = col[i-1][j] + grid[i-1][j-1];
        //     // System.out.println("row.length: " + row.length);
        //     // for (int z = 0; z < row.length; ++z) 
        //     //     System.out.println(Arrays.toString(row[z]));
        //     // System.out.println("col.length: " + col.length);
        //     // for (int z = 0; z < col.length; ++z) 
        //     //     System.out.println(Arrays.toString(col[z]));
        //     int ans = 1;
        //     for (int d = 2; d <= Math.min(m, n); d++) {
        //     for (int i = 1; i+d <= m+1; i++) 
        //         for (int j = 1; j+d <= n+1; j++) {
        //                 // if (i + d > m || j + d > n) continue;
        //                 int x = i + d -1, y = j + d - 1;
        //                 if (isValid(grid, i, j, x, y, d)) ans = Math.max(ans, d);
        //                 // else break;
        //             }
        //         }
        //     return ans;
        // }


        // public int findMaxLength(int[] a) { 
        //     int n = a.length, max = 0, cur = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         if (a[i] == 0) a[i] = -1;
        //     m.put(0, -1);
        //     for (int i = 0; i < n; i++) {
        //         cur += a[i];
        //         if (m.containsKey(cur))
        //             max = Math.max(max, i - m.get(cur));
        //         else m.put(cur, i);
        //     }
        //     return max;
        // }

        // public int sumOfFlooredPairs(int[] a) { // tle tle tle
        //     int n = a.length, ans = 0;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int i = 0; i < n; i++)
        //         m.put(a[i], m.getOrDefault(a[i], 0) + 1);
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         int k = en.getKey(), v = en.getValue();
        //         Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
        //         while (it.hasNext()) {
        //             Map.Entry<Integer, Integer> e = it.next();
        //             int key = e.getKey(), val = e.getValue();
        //             if (key > k) break;
        //             ans += v * Math.floor(k / key) * val;
        //         }
        //     }
        //     return ans;
        // }
        // 时间复杂度：O(nlogn)
        // 空间复杂度：O(n)
        // public int sumOfFlooredPairs(int[] arr) {
        //     int mod = (int)1e9 + 7;
        //     int N = 100001;
        //     int [] cnt = new int [N]; // 记录每个数出现多少次
        //     for (Integer v : arr) cnt[v]++;
        //     for (int i = 1; i < N; i++) cnt[i] += cnt[i-1];  // 前缀和
        //     long res = 0;
        //     for (int i = 1; i < N; i++) 
        //         for (int j = 1; j*i < N; j++) {
        //             int l = j*i, r = Math.min(N-1, (j+1)*i-1);
        //             int sum = (cnt[r] - cnt[l-1]) * j % mod; // 倍数×区间内的元素总个数 = 元素i在该段区间的函数值总和
        //             res = (res + (long)sum * (cnt[i] - cnt[i-1]) % mod) % mod;
        //         }
        //     return (int)res;
        // }
        // static final int N = (int)1e5;
        // static final int mod = (int)1e9 + 7;
        // public int sumOfFlooredPairs(int[] arr) {
        //     int [] cnt = new int [N+1];
        //     for (Integer v : arr) cnt[v]++;
        //     for (int i = 1; i <= N; i++) cnt[i] += cnt[i-1];
        //     long ans = 0;
        //     for (int i = 1; i <= N; i++) {
        //         if (cnt[i] > cnt[i-1]) {
        //             long sum = 0; // [i * j, i * (j + 1)) would derive a quotient of j
        //             for (int j = 1; j * i <= N; j++) {
        //                 int l = i*j-1, r = i *(j+1) - 1;
        //                 sum += (cnt[Math.min(r, N)] - cnt[l]) * (long)j;
        //             }
        //             ans = (ans + (sum % mod) * (cnt[i] - cnt[i-1])) % mod;
        //         }
        //     }
        //     return (int)ans;
        // }


        // public int bestRotation(int[] a) {
        //     int n = a.length, ans = 0;
        //     int [] change = new int [n];
        //     for (int i = 0; i < n; ++i) change[(i - a[i] + n + 1) % n] -= 1;
        //     for (int i = 1; i < n; ++i) {
        //         change[i] += change[i-1] + 1;
        //         ans = change[i] > change[ans] ? i : ans;
        //     }
        //     return ans;
        // }
        // public int bestRotation(int[] a) { // double check this answer
        //     int n = a.length, ans = 0;
        //     int [] bad = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         //把这里换成差分的形式
        //         //对于A【i】小于等于i是加分的
        //         //那么 i - A[i] + 1 和 i之间是没有分的
        //         //这样就可以转换成left位置没分，right有分
        //         int l = (i - a[i] + n + 1) % n;
        //         int r = (i + 1) % n;
        //         bad[l]--;
        //         bad[r]++;
        //     }
        //     int best = -n, ans = 0, cur = 0;
        //     for (int i = 0; i < n; i++) {
        //         cur += bad[i];
        //         if (cur > best) {
        //             best = cur;
        //             ans = i;
        //         }
        //     }
        //     return ans;
        // }


        public int minSubarray(int[] arr, int p) { 
            int n = arr.length, ans = Integer.MAX_VALUE;
            long [] sum = new long [n];
            sum [0] = arr[0];
            for (int i = 1; i < n; i++) 
                sum[i] = sum[i-1] + arr[i];
            Map<Integer, Integer> m = new HashMap<>(); 
            // map.put(0, 0);
            int rem = (int)(sum[n-1] % p);   //  [0, 1, 2, ... p-1]
            if (rem == 0) return 0;
            for (int i = 0; i < n; i++) {
                // int v = (int)(sum[i] % p), vb = arr[i] % p;
                // if (vb == rem) return 1;
                // if (v == rem || vb == rem) {
                //     if (m.containsKey(0)) ans = Math.min(ans, i - m.get(0) + 1);
                //     else ans = Math.min(ans, i+1);
                // }
                for (int j = 0; j <= i; j++) {
                    if ((sum[i] - (j == 0 ? 0 : sum[j-1])) % p == rem)
                        ans = Math.min(ans, i-j+1);
                }
                m.put(v, i);
            }
            // if (!m.containsKey(rem)) return -1;
            // return n-1-m.get(rem);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {6,3,5,2};
        // int []  a = new int []  {3, 1, 4, 2};
        // int []  a = new int []  {1000000000, 1000000000, 1000000000};

        int r = s.minSubarray(a, 6);
        System.out.println("r: " + r);
    }
}