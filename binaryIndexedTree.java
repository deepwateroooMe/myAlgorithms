// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class binaryIndexedTree {
    public static class Solution {

        // private void helperSwap(List<Integer> l, int i) {
        //     int tmp = l.get(i);
        //     l.remove(i);
        //     l.add(0, tmp);
        // }
        // public int[] processQueries(int[] queries, int m) {
        //     int n = queries.length;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 1; i <= m; i++) 
        //         l.add(i);
        //     int [] arr = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < m; j++) {
        //             if (l.get(j) == queries[i]) {
        //                 helperSwap(l, j);
        //                 arr[i] = j;
        //                 break;
        //             }
        //         }
        //     }
        //     return arr;
        // }

        // private class Bit {
        //     private long sum(int i) {
        //         long res = 0;
        //         while (i > 0) {
        //             res += tree[i];
        //             i -= lowBit(i);
        //         }
        //         return res;
        //     }
        //     private void update(int i, int val) { //logn i - 0 based
        //         int diff = val - arr[i+1];
        //         arr[i+1] = val;
        //         i += 1; // tree中下标从1开始
        //         while(i+1 < arr.length){
        //             tree[i+1] += diff;
        //             i += lowBit(i);
        //         }            
        //     }
        //     int size;
        //     int [] arr;
        //     long [] tree; // sum
        //     int [][] cnt; 
        //     HashSet<HashSet<Integer>> ss = new HashSet<>();

        //     public Bit(int size) {
        //         this.size = size;
        //         this.tree = new long[size];
        //         this.cnt = new int [size][2]; // [lower][higher]
        //     }
        //     public Bit(int [] arr) {
        //         this.size = arr.length+1;
        //         this.tree = new long[size];
        //         this.arr = new int[size];
        //         for (int i = 0; i < arr.length; i++) {
        //             update(i, arr[i]);
        //         }
        //     }
        //     public int sumRange(int i, int j) {
        //         return (int)(sum(j+1) - sum(i));
        //     }
        //     private int lowBit(int n) {
        //         return n & (-n); 
        //     }
        //     public int findLower(int rank) {
        //         int lowerRank = 0;
        //         while (rank > 0) {
        //             lowerRank = Math.max(lowerRank, tree[rank]);
        //             rank -= lowBit(rank);
        //         }
        //         System.out.println("rank: " + rank);
        //         return lowerRank;
        //     }
        //     public int findHigher(int rank) {
        //         int higherRank = rank;
        //         while (rank < size) {
        //             higherRank = Math.min(higherRank, tree[rank]);
        //             rank += lowBit(rank); // 这里是朝父节点还是子节点呢？
        //         }
        //         System.out.println("rank: " + rank);
        //         return higherRank;
        //     }
        //     public int update(int rank) { // rank: rank of nums[i]
        //         // NOT find(n), due to the requirement of *strictly* increasing sequence
        //         // int l = find(rank - 1) + 1; // 更新所有的父————接下来的节点
        //         System.out.println("tree.length: " + tree.length);
        //         for (int z = 0; z < tree.length; ++z) 
        //             System.out.print(tree[z] + ", ");
        //         System.out.println("");






        // private class Bit {
        //      int size;
        //      int [] arr;
        //      long [] tree; // sum
        //      public Bit(int size) {
        //          this.size = size;
        //          this.tree = new long[size+1];
        //      }
        //      public Bit(int [] arr) {
        //          this.size = arr.length+1;
        //          this.tree = new long[size];
        //          this.arr = new int[size];
        //          for (int i = 0; i < arr.length; i++) {
        //              update(i, arr[i]);
        //          }
        //      }
        //      private long sum(int i) {
        //          long res = 0;
        //          while (i > 0) {
        //              res += tree[i];
        //              i -= lowBit(i);
        //          }
        //          return res;
        //      }
        //      private void update(int i, int val) { //logn i - 0 based
        //          int diff = val - arr[i+1];
        //          arr[i+1] = val;
        //          i += 1; // tree中下标从1开始
        //          while(i+1 < arr.length){
        //              tree[i+1] += diff;
        //              i += lowBit(i);
        //          }            
        //      }
        //      public int sumRange(int i, int j) {
        //          return (int)(sum(j+1) - sum(i));
        //      }
        //      private int lowBit(int n) {
        //          return n & (-n); 
        //      }
        //      public int find(int rank) {
        //          int lowerRank = 0;
        //          while (rank > 0) {
        //              lowerRank = (int)Math.max(lowerRank, tree[rank]);
        //              rank -= lowBit(rank);
        //          }
        //          System.out.println("rank: " + rank);
        //          return lowerRank;
        //      }
        //      public int update(int rank) { // rank: rank of nums[i]
        //          // NOT find(n), due to the requirement of *strictly* increasing sequence
        //          // int l = find(rank - 1) + 1; // 更新所有的父————接下来的节点
        //          System.out.println("tree.length: " + tree.length);
        //          for (int z = 0; z < tree.length; ++z) 
        //              System.out.print(tree[z] + ", ");
        //          System.out.println("");
        //          int val = find(rank-1) + 1; // 更新所有的父————接下来的节点
        //          while (rank <= size && tree[rank] < val) {
        //              tree[rank] = val;
        //              rank += lowBit(rank);
        //          }
        //          System.out.println("tree.length: " + tree.length);
        //          for (int z = 0; z < tree.length; ++z) 
        //              System.out.print(tree[z] + ", ");
        //          System.out.println("");
        //          return val;
        //      }
        // }
        // private int mergeSortCount(long [] arr, int bgn, int end) {
        //     if (bgn >= end) return 0;
        //     int mid = bgn + (end-bgn)/2;
        //     int cnt = mergeSortCount(arr, bgn, mid) + mergeSortCount(arr, mid+1, end);
        //     for (int i = bgn, j = mid+1; i <= mid; i++) {
        //         while (j <= end && arr[i] > 2*arr[j]) j++;
        //         cnt += j - (mid+1);
        //     }
        //     Arrays.sort(arr, bgn, end+1);
        //     return cnt;
        // }
        // public int reversePairs(int[] nums) {
        //     int n = nums.length;
        //     return mergeSortCount(Arrays.stream(nums).mapToLong(i -> i).toArray(), 0, n-1);
        // }
// bit 的解法： https://www.cnblogs.com/grandyang/p/6657956.html


        // public int createSortedArray(int[] instructions) {
        //     int n = instructions.length;
        //     if (n == 1) return 0;
        //     int [] arr = Arrays.copyOf(instructions, n);
            
        //     Arrays.sort(arr);
        //     int rank = 0;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for (int val : arr) {
        //         if (!m.containsKey(val))
        //             m.put(val, ++rank);
        //     }
        //     // Construct the binary-indexed tree according to the rank
        //     Bit bit = new Bit(rank);
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\ni: " + i);
        //         System.out.println("instructions[i]: " + instructions[i]);
                
        //         int r = m.get(instructions[i]);
        //         res += bit.update(r);
        //         System.out.println("res: " + res);
        //     }
        //     return res;
        // }
        
        // public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        //     int n = obstacles.length;
        //     if (n == 1) return new int [] {1};
        //     int [] arr = Arrays.copyOf(obstacles, n);
        //     Arrays.sort(arr);
        //     int rank = 0;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for (int val : arr) {
        //         if (!m.containsKey(val))
        //             m.put(val, ++rank);
        //     }
        //     // Construct the binary-indexed tree according to the rank
        //     Bit bit = new Bit(rank);
        //     int [] res = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         int r = m.get(obstacles[i]);
        //         res[i] = bit.update(r);
        //     }
        //     return res;
        // }

        // public int findNumberOfLIS(int[] nums) {
        //     int n = nums.length;
        //     int [] arr = Arrays.copyOf(nums, n);
        //     Arrays.sort(arr);
        //     int rank = 0;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for (int val : arr) {
        //         if (!m.containsKey(val))
        //             m.put(val, ++rank);
        //     }
        //     System.out.println("m.size(): " + m.size());
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) 
        //         System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     // Construct the binary-indexed tree according to the rank
        //     Bit bit = new Bit(rank);
        //     for (int i = 0; i < n; i++) {
        //         int r = m.get(nums[i]);
        //         bit.update(r);
        //     }
        //     // Get the longest increasing sequence under the highest rank
        //     return bit.find(rank);
        // }
        // public int findNumberOfLIS(int[] nums) { // dynamic programming
        //     int n = nums.length;
        //     int [][] arr = new int[n][2];
        //     int maxLength = 1;
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(arr[i], 1);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if (nums[j] > nums[i]) {
        //                 if (arr[i][0] + 1 > arr[j][0]) {
        //                     arr[j][0] = arr[i][0] +1;
        //                     arr[j][1] = arr[i][1];
        //                     maxLength = Math.max(maxLength, arr[j][0]);
        //                 } else if (arr[i][0] + 1 == arr[j][0])
        //                     arr[j][1] += arr[i][1];
        //             }
        //          }
        //     }
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (arr[i][0] == maxLength) cnt += arr[i][1];
        //     return cnt;
        // }

        // // https://blog.csdn.net/qq_28033719/article/details/112506925
        // private static int N = 100001;
        // private static int [] tree = new int [N]; // 拿元素值作为 key 对应 tree 的下标值
        // public int lowbit(int i) {
        //     return i & -i;
        // }
        // public void update(int i, int v) { // 更新父节点
        //     while (i <= N) {
        //         tree[i] += v;
        //         i += lowbit(i);
        //     }
        // }
        // public int getSum(int i) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, i]的和，1-based
        //     int ans = 0;
        //     while (i > 0) {
        //         ans += tree[i];
        //         i -= lowbit(i);
        //     }
        //     return ans;
        // }
        // public int createSortedArray(int[] instructions) {
        //     int n = instructions.length;
        //     long res = 0;
        //     Arrays.fill(tree, 0);
        //     for (int i = 0; i < n; i++) {
        //         //              严格小于此数的个数 严格大于此数的个数： 为总个数（不含自己） - 小于自己的个数
        //         res += Math.min(getSum(instructions[i]-1), i-getSum(instructions[i])); 
        //         update(instructions[i], 1);
        //     }
        //     return (int)(res % ((int)Math.pow(10, 9) + 7));
        // }


        // private void addRectange(List<int[]> l, int [] arr, int idx) {
        //     if (idx >= l.size()) {
        //         l.add(arr);
        //         return;
        //     }
        //     int [] r = l.get(idx);
        //     // 新增矩形 处在 左 右 上 下 四侧完全不重叠的区域
        //     if (arr[2] <= r[0] || arr[0] >= r[2] || arr[1] >= r[3] || arr[3] <= r[1]) { 
        //         addRectange(l, arr, idx+1);
        //         return;
        //     }
        //     if (arr[0] < r[0]) // 新增矩形 左侧 有交叠
        //         addRectange(l, new int[]{arr[0], arr[1], r[0], arr[3]}, idx+1);
        //     if (arr[2] > r[2]) // 新增矩形 右侧 也可以有 交叠
        //         addRectange(l, new int[]{r[2], arr[1], arr[2], arr[3]}, idx+1);
        //     if (arr[1] < r[1]) // 新增矩形 下侧 也可以有 交叠： 注意左侧、右侧前面已经加进去了，现在只加中间部分，不要重复计算
        //         addRectange(l, new int[]{Math.max(arr[0], r[0]), arr[1], Math.min(arr[2], r[2]), r[1]}, idx+1);
        //     if (arr[3] > r[3]) // 新增矩形 上侧 也可以有 交叠： 注意左侧、右侧、下侧 前面已经加进去了，现在只加中间部分，不要重复计算
        //         addRectange(l, new int[]{Math.max(arr[0], r[0]), r[3], Math.min(arr[2], r[2]), arr[3]}, idx+1);
        // }
        // public int rectangleArea(int[][] rectangles) {
        //     int mod = (int)Math.pow(10, 9)+7;
        //     long res = 0;
        //     List<int[]> rlist = new ArrayList<>();
        //     for (int [] val : rectangles) 
        //         addRectange(rlist, val, 0);
        //     for (int [] arr : rlist) 
        //         res = (res + ((long)(arr[2]-arr[0])*(long)(arr[3]-arr[1]))) % mod;
        //     return (int)res % mod;
        // }


        // public int numTeams(int[] rating) {
        //     int n = rating.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             for (int k = j+1; k < n; k++) {
        //                 if (((rating[i] < rating[j] && rating [j] < rating[k]) || (rating[i] > rating[j]  && rating[j] > rating[k]))) 
        //                     ++cnt;
        //             }
        //         }
        //     }
        //     return cnt;
        // }
        // public int numTeams(int[] rating) {
        //     int n = rating.length;
        //     int l = 0, r = 0;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         l = 0;
        //         r = 0;
        //         for (int j = 0; j < n; j++) {
        //             if (j < i && rating[j] < rating[i]) ++l;
        //             if (j > i && rating[j] > rating[i]) ++r;
        //         }
        //         cnt += l * r; // 以i为中位，左小右大，升序排列个数
        //         cnt += (i - l) * (n - 1 - i - r); // 以i为中位，左大右小，降序排列个数
        //     }
        //     return cnt;
        // }

        
        // private class Bit {
        //      int size;
        //      int [] arr;
        //      long [] tree; // sum
        //      public Bit(int size) {
        //          this.size = size;
        //          this.tree = new long[size+1];
        //      }
        //      public Bit(int [] arr) {
        //          this.size = arr.length+1;
        //          this.tree = new long[size];
        //          this.arr = new int[size];
        //          for (int i = 0; i < arr.length; i++) {
        //              update(i, arr[i]);
        //          }
        //      }
        //      private long sum(int i) {
        //          long res = 0;
        //          while (i > 0 && i < size) {
        //              res += tree[i];
        //              i -= lowBit(i);
        //          }
        //          return res;
        //      }
        //      private void update(int i, int val) { //logn i - 0 based
        //          int diff = val - arr[i+1];
        //          arr[i+1] = val;
        //          i += 1; // tree中下标从1开始
        //          while(i+1 < arr.length){
        //              tree[i+1] += diff;
        //              i += lowBit(i);
        //          }            
        //      }
        //      public int sumRange(int i, int j) { // sum [i, j]
        //          return (int)(sum(j+1) - sum(i));
        //      }
        //      private int lowBit(int n) {
        //          return n & (-n); 
        //      }
        //      public int find(int rank) {
        //          int lowerRank = 0;
        //          while (rank > 0) {
        //              lowerRank = (int)Math.max(lowerRank, tree[rank]);
        //              rank -= lowBit(rank);
        //          }
        //          // System.out.println("rank: " + rank);
        //          return lowerRank;
        //      }
        //      public int update(int rank) { // rank: rank of nums[i]
        //          // NOT find(n), due to the requirement of *strictly* increasing sequence
        //          // int l = find(rank - 1) + 1; // 更新所有的父————接下来的节点
        //          // System.out.println("tree.length: " + tree.length);
        //          // for (int z = 0; z < tree.length; ++z) 
        //          //     System.out.print(tree[z] + ", ");
        //          // System.out.println("");
        //          int val = find(rank-1) + 1; // 更新所有的父————接下来的节点
        //          while (rank <= size && tree[rank] < val) {
        //              tree[rank] = val;
        //              rank += lowBit(rank);
        //          }
        //          // System.out.println("tree.length: " + tree.length);
        //          // for (int z = 0; z < tree.length; ++z) 
        //          //     System.out.print(tree[z] + ", ");
        //          // System.out.println("");
        //          return val;
        //      }
        // }
        // public int countRangeSum(int[] nums, int lower, int upper) {
        //     int n = nums.length;
        //     if (n == 1) return nums[0] <= upper && nums[0] >= lower ? 1 : 0;
        //     // else if (n == 2)
        //     //     return (nums[0] <= upper && nums[0] >= lower ? 1 : 0)
        //     //         + (nums[1] <= upper && nums[1] >= lower ? 1 : 0)
        //     //         + (nums[0]+nums[1] <= upper && nums[0] + nums[1] >= lower ? 1 : 0);
        //     Bit bit = new Bit(nums);
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             long sum = bit.sumRange(i+1, j+1);
        //             if (sum >= lower && sum <= upper) ++cnt;
        //         }
        //     }
        //     return cnt;
        // }

        // private int mergeAnalyse(long [] arr, int lower, int upper, int l, int r) {
        //     if (r - l <= 1) return 0;
        //     int mid = l + (r-l)/2;
        //     int m = mid, n = mid, ans = 0;
        //     ans = mergeAnalyse(arr, lower, upper, l, mid) + mergeAnalyse(arr, lower, upper, mid, r); // mid r ???
        //     for (int i = l; i < mid; i++) { // 通过遍历寻找当前范围中符合要求的个数            
        //         while (m < r && arr[m] - arr[i] < lower) m++;
        //         while (n < r && arr[n] - arr[i] <= upper) n++;
        //         ans += n - m;
        //     }
        //     Arrays.sort(arr, l, r);
        //     return ans;
        // }
        // public int countRangeSum(int[] nums, int lower, int upper) {
        //     int n = nums.length;
        //     long [] arr = new long[n+1];
        //     for (int i = 0; i < n; i++) 
        //         arr[i+1] = arr[i] + nums[i];
        //     return mergeAnalyse(arr, lower, upper, 0, n+1);
        // }


        // private class Bit {
        //      int size;
        //      int [] arr;
        //      long [] tree; // sum
        //      public Bit(int size) {
        //          this.size = size;
        //          this.tree = new long[size+1];
        //      }
        //      public Bit(int [] arr) {
        //          this.size = arr.length+1;
        //          this.tree = new long[size];
        //          this.arr = new int[size];
        //          for (int i = 0; i < arr.length; i++) {
        //              update(i, arr[i]);
        //          }
        //      }
        //      private long sum(int i) {
        //          long res = 0;
        //          while (i > 0 && i < size) {
        //              res += tree[i];
        //              i -= lowBit(i);
        //          }
        //          return res;
        //      }
        //      private void update(int i, int val) { //logn i - 0 based
        //          int diff = val - arr[i+1];
        //          arr[i+1] = val;
        //          i += 1; // tree中下标从1开始
        //          while(i+1 < arr.length){
        //              tree[i+1] += diff;
        //              i += lowBit(i);
        //          }            
        //      }
        //      public int sumRange(int i, int j) { // sum [i, j]
        //          return (int)(sum(j+1) - sum(i));
        //      }
        //      private int lowBit(int n) {
        //          return n & (-n); 
        //      }
        //      public int find(int rank) {
        //          int lowerRank = 0;
        //          while (rank > 0) {
        //              lowerRank = (int)Math.max(lowerRank, tree[rank]);
        //              rank -= lowBit(rank);
        //          }
        //          // System.out.println("rank: " + rank);
        //          return lowerRank;
        //      }
        //      public int update(int rank) { // rank: rank of nums[i]
        //          // NOT find(n), due to the requirement of *strictly* increasing sequence
        //          // int l = find(rank - 1) + 1; // 更新所有的父————接下来的节点
        //          // System.out.println("tree.length: " + tree.length);
        //          // for (int z = 0; z < tree.length; ++z) 
        //          //     System.out.print(tree[z] + ", ");
        //          // System.out.println("");
        //          int val = find(rank-1) + 1; // 更新所有的父————接下来的节点
        //          while (rank <= size && tree[rank] < val) {
        //              tree[rank] = val;
        //              rank += lowBit(rank);
        //          }
        //          // System.out.println("tree.length: " + tree.length);
        //          // for (int z = 0; z < tree.length; ++z) 
        //          //     System.out.print(tree[z] + ", ");
        //          // System.out.println("");
        //          return val;
        //      }
        // }

        // private static int N = 1000000001;
        // private static int [] tree = new int [N]; // 拿元素值作为 key 对应 tree 的下标值
        // public int lowbit(int i) {
        //     return i & -i;
        // }
        // public void update(int i, int v) { // 更新父节点
        //     while (i <= N) {
        //         tree[i] += v;
        //         i += lowbit(i);
        //     }
        // }
        // public int getSum(int i) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, i]的和，1-based
        //     int ans = 0;
        //     while (i > 0) {
        //         ans += tree[i];
        //         i -= lowbit(i);
        //     }
        //     return ans;
        // }
        // public int createSortedArray(int[] instructions) {
        //     int n = instructions.length;
        //     long res = 0;
        //     Arrays.fill(tree, 0);
        //     for (int i = 0; i < n; i++) {
        //         //              严格小于此数的个数 严格大于此数的个数： 为总个数（不含自己） - 小于自己的个数
        //         res += Math.min(getSum(instructions[i]-1), i-getSum(instructions[i])); 
        //         update(instructions[i], 1);
        //     }
        //     return (int)(res % ((int)Math.pow(10, 9) + 7));
        // }


    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {9, 12, 3, 7, 15}; 

        int res = s.closestToTarget(a, 5);
        System.out.println("res: " + res);
    }
}         