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


        // public String minInteger(String s, int k) { // tle tle tle 当你总是使蛮力去挪动它们的时候，你就是在暴力求解，必将tle tle tle 
        //     if (getSorted(s).equals(s)) return s;
        //     int n = s.length(), i = 0;
        //     Queue<Integer> [] q = new LinkedList[10];
        //     for (i = 0; i < 10; i++) 
        //         q[i] = new LinkedList<>();
        //     for (i = 0; i < n; i++) 
        //         q[s.charAt(i)-'0'].offer(i);
        //     i = 0;
        //     while (k > 0 && i < n) 
        //         for (int j = 0; j < 10; j++) 
        //             if (!q[j].isEmpty() && q[j].peek() > i && q[j].peek() < i + k && s.charAt(i)-'0' > j) {
        //                 int idx = q[j].poll();
        //                 s = s.substring(0, i) + (char)(j + '0') + minInteger(s.substring(i, idx) + s.substring(idx + 1), k - idx + i);
        //                 return s;
        //             }
        //     return s;
        // }
        // private String getSorted(String s) {
        //     char [] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     return new String(arr);
        // }

        
        // class BIT { // 开一个树状数组类，维护每个位置的字符的向右的偏移量 ? 向左偏移量
        //     private int size;
        //     private int [] arr;
        //     public BIT(int size) {
        //         this.size = size;
        //         this.arr = new int [size+1]; // 初始值都是0
        //     }
        //     public void add(int idx, int v) { // 只有发生偏移，才移动某段区间的值
        //         while (idx <= size) {
        //             arr[idx] += v;
        //             idx += lowbit(idx); //
        //         }
        //     }
        //     public int sum(int idx) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, idx]的和，1-based
        //         int res = 0;
        //         while (idx > 0) {
        //             res += arr[idx];
        //             idx -= lowbit(idx);
        //         }
        //         return res;
        //     }
        //     private int lowbit(int x) {
        //         return x & -x; // 这个细节要再复习一下
        //     }
        // }
        // public String minInteger(String t, int k) { // 感觉这个题目还没有想透，要再多想一下
        //     int n = t.length();
        //     t = " " + t; // 树状数组从1开始，所以字符串下标也要从1开始比较方便
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Integer>[] q = new ArrayDeque[10]; // 开10个队列，将每个数各自出现在什么位置存进去,稍微优化只需开9个队列，因为我们不会主动挪9
        //     for (int i = 1; i <= n; i++) {
        //         int v = s[i] - '0';
        //         if (q[v] == null) q[v] = new ArrayDeque<>();
        //         q[v].offer(i);
        //     }
        //     BIT bit = new BIT(n);
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 0; j < 10; j++) {
        //             if (q[j] == null || q[j].isEmpty()) continue;
        //             int top = q[j].peek(), pos = top + bit.sum(top); // pos是最优解的位置，最优解的位置是原来的位置加上偏移量
        //             // int top = q[j].peek(), pos = bit.sum(top);    // pos是最优解的位置，最优解的位置是原来的位置加上偏移量
        //             // if ((char)(j+'0') == s[i]) break; // 这么写不对！！！
        //             // if (pos == i) break;              // 这么写不对！！！
        //             if (pos - i <= k) {
        //                 k -= pos - i;
        //             // if (top - i <= k) { // 如果k还够让j挪到开头的话，按照贪心选择，就挪
        //             //     k -= top - i;
        //                 sb.append(j);
        //                 q[j].poll();
        //                 bit.add(1, 1);  // 更新[1, t)这段的值每个加1，即向右偏移1位.为什么要 从1开始更新：假装每次都移动到最前端，方便计算
        //                 bit.add(top, -1);
        //                 break;
        //             }
        //         }
        //     }
        //     return sb.toString();
        // }
        
        // // 【最基本的数据结构的解法】：归并排序。整个过程是一个自底向上，不断求值与归并的过程
        // public int countRangeSum(int[] a, int lo, int hi) {
        //     int n = a.length;
        //     long [] s = new long [n+1]; // 用来求和 prefixSum
        //     for (int i = 0; i < n; i++) s[i+1] = s[i] + a[i]; // 不一定是：升序排列 
        //     return countRangeSumRecursive(s, lo, hi, 0, n);
        // }
        // int countRangeSumRecursive(long [] sum, int lo, int hi, int l, int r) { // l: 左下标， r: 右下标
        //     if (l == r) return 0;
        //     int m = (l + r) / 2;
        //     // 【首先，递归，分别解决左右半部分的问题】：分别解决了左右部分之后，左右部分分别是有序排列的片段
        //     int n1 = countRangeSumRecursive(sum, lo, hi, l, m);
        //     int n2 = countRangeSumRecursive(sum, lo, hi, m+1, r);
        //     int ans = n1 + n2;
        //     // 【再来解决归并相关】
        //     // 首先统计下标对的数量
        //     int i = l, left = m+1, right = m+1;
        //     while (i <= m) {
        //         while (left <= r && sum[left] - sum[i] < lo) left++; // 左边界右移，直到达标【 lo, 。。。
        //         right = left; // 可要可不要，要了可以少遍历上面的过程。。。
        //         while (right <= r && sum[right] - sum[i] <= hi) right++; // 右边界右移，直到不达标越界。。。 hi-1 】 hi...
        //         ans += right - left;
        //         i++;
        //     }
        //     // 随后合并两个排序数组
        //     long [] sorted = new long [r - l + 1];
        //     int x = l, y = m+1, z = 0; //x,y,z: 分别为左右两个片段的遍历下标，以及合并数组的遍历下标
        //     while (x <= m || y <= r) 
        //         if (x > m) sorted[z++] = sum[y++];
        //         else if (y > r) sorted[z++] = sum[x++];
        //         else if (sum[x] < sum[y]) sorted[z++] = sum[x++];
        //         else sorted[z++] = sum[y++];
        //     // 再把这个排序好的数组，更新同步到累积和数组里去
        //     for (int j = 0; j < sorted.length; j++) 
        //         sum[l+j] = sorted[j];
        //     return ans;
        // }
        // public int countRangeSum(int[] a, int lower, int upper) { // 这个merge sort的思维很奇特: 二分，O(NlogN)
        //     long [] sum = new long[a.length+1];
        //     for (int i = 0; i < a.length; i++)
        //         sum[i+1] = sum[i] + a[i];
        //     return mergeAnalyse(sum, 0, a.length+1, lower, upper);
        // }
        // int mergeAnalyse(long [] a, int l, int r, int lo, int hi) { // l, r: 寻找【l, r）范围内和为【lower, upper】的片段的个数
        //     if (r - l <= 1) return 0;
        //     int m = l + (r - l) / 2;
        //     // int mid = l + (r - l) / 2;
        //     // int m = mid, n = mid, ans = 0;
        //     int ans = mergeAnalyse(a, l, m, lo, hi) + mergeAnalyse(a, m, r, lo, hi);
        //     int x = m, y = m;
        //     for (int i = l; i < m; i++) { // 遍历[l, r)的半段长度： pivot 右移，滑动窗口，寻找合法窗口 // 通过遍历寻找当前范围中符合要求的个数，
        //         while (x < r && a[x] - a[i] < lo) x++; // 左端点右移，直到找到合法（sum >= lo）的解：m合法
        //         y = x; // 可要可不要。。。
        //         while (y < r && a[y] - a[i] <= hi) y++; // 右端点右移，直到右端点右移至不再合法（sum > hi）, n 不合法 
        //         ans += y - x; // 对于[l, r)范围内的当前i来说，满足要求的总个数为 n - m
        //     }
        //     Arrays.sort(a, l, r); // 将 【l, r）片段排序，本地排序
        //     return ans;
        // }
//         // 【方法二：求和 sum 线段树】
// // 最基本的【求和 sum 线段树】：将前缀和数值中的取值范围，分布到Bit 的数组上来，可能需要必要的取值偏移【不是偏移，用个策略！！！】，以保证 bit 每个元素取值 >= 1
//         // 这里还是来参考别人更为精典的解决办法 
//         public int countRangeSum(int[] a, int lo, int hi) {
//             int n = a.length;
//             long [] s = new long [n+1];
//             for (int i = 0; i < n; i++) s[i+1] = s[i] + a[i];
//             // Set<Long> allNumbers = new HashSet<>(); // 考量：去重作用【BUGGLY CODING:】没有考虑到这里的排序作用。。。
//             Set<Long> allNumbers = new TreeSet<>();    // 考量：去重作用【BUGGLY CODING:】没有考虑到这里的排序作用。。。
//             for (long v : s) {
//                 allNumbers.add(v);
//                 allNumbers.add(v - lo);
//                 allNumbers.add(v - hi);
//             }
//             // 利用哈希表进行离散化：这里离散化的本质是：将离散的取值，重新序列化为【0,n-1】下标的值序列片段！！！
//             // 注意到整数的范围可能很大，故需要利用哈希表将所有可能出现的整数，映射到连续的整数区间内。
//             // 【前面的离散长整形数据，如果不排列，映射到连续片段的下标计数，没有意义。。。】
//             Map<Long, Integer> values = new HashMap<>();
//             int idx = 0;
//             for (long v : allNumbers) 
//                 values.put(v, idx++); // 【只有 allNumbers 排序过】：映射过来的 idx 的取值才能正确反映离散值在线段树中所处的正确位置。。。
//             Node root = build(0, values.size()-1);
//             int ans = 0;
//             for (long v : s) {
//                 int l = values.get(v - hi), r = values.get(v - lo);
//                 ans += count(root, l, r); // 【理解困难的地方：】第一次的数个数，是什么时候，这个时候调用，会更新哪些？
//                 insert(root, values.get(v)); // 这里就添加了【0,n-1】下标范围内的某个下标，把离散的值连续化到一个有效片段，最小区间求和 sum 线段树
//             }
//             return ans;
//         }
//         // 求和 sum 线段树：三个最基本的方法：构建线段树，更新（插入一个值）线段树，查询区间内的个数
//         public Node build(int lo, int hi) { // 【lo,hi】：问题是，创建树的时候，没有，不曾数过、更新过每个区间的元素个数和？？？
//             Node r = new Node(lo, hi);
//             if (lo == hi) return r;
//             int m = (hi + lo) / 2; 
//             r.left = build(lo, m);
//             r.right = build(m+1, hi);
//             // r.s = r.left.s + r.right.s; // 父节点的个数 = 左右子树节点个数的和【为什么它这里没有更新？】
//             return r;
//         }
//         public int count(Node r, int left, int right) { // 求和线段树：是否与BST 一样，右边节点计数大于左边与根节点呢？
//             // 因为下面这一行的处理：区间外完全不用考虑，返回0
//             if (left > r.r || right < r.l) return 0; // 查询区间，当前区间节点，完全不用考虑
//             if (left <= r.l && r.r <= right) return r.s; // 【我是什么时候，才来更新这个计数 s 的？】
//             // 所以，这里就可以直接调用，递归左右子数，求计数和
//             return count(r.left, left, right) + count(r.right, left, right);
//         }
//         public void insert(Node r, int v) { // 这里可以理解为：动态更新，过程中随机增加一个元素
//             r.s++; // 这个时候，才知道，计数，计算区间内元素个数，原来是如此精炒地完成的。。。
//             if (r.l == r.r) return ; // 叶子节点 
//             int m = (r.l + r.r) / 2;
//             if (v <= m) insert(r.left, v);
//             else insert(r.right, v);
//         }
        // class Node {
        //     long l, r; // 区间值的范围【l, r】
        //     int s;
        //     Node left, right; 
        //     public Node(long left, long right) {
        //         l = left;
        //         r = right;
        //         s = 0;
        //         this.left = null;
        //         this.right = null;
        //     }
        // }
        // // 【方法三：动态添加元素的线段树】
        // public int countRangeSum(int[] a, int lo, int hi) {
        //     int n = a.length;
        //     long [] s = new long [n+1];
        //     for (int i = 0; i < n; i++) s[i+1] = s[i] + a[i];
        //     // 可以不实用哈希表进行映射，而是只在线段树的插入操作过程中动态地增加树中的节点。
        //     // 而当我们进行查询操作时，如果到达一个空节点，那么说明对应的区间中暂时还没有值，就可以直接返回 0
        //     long lowrBound = Long.MAX_VALUE, highBound = Long.MIN_VALUE;
        //     for (long v : s) {
        //         lowrBound = Math.min(Math.min(lowrBound, v), Math.min(v - lo, v - hi));
        //         highBound = Math.max(Math.max(highBound, v), Math.max(v - lo, v - hi));
        //     }
        //     Node root = new Node(lowrBound, highBound);
        //     int ans = 0;
        //     for (long v : s) {
        //         ans += count(root, v - hi, v - lo); // 【理解困难的地方：】第一次的数个数，是什么时候，这个时候调用，会更新哪些？
        //         insert(root, v); // 这里就添加了【0,n-1】下标范围内的某个下标，把离散的值连续化到一个有效片段，最小区间求和 sum 线段树
        //     }
        //     return ans;
        // }
        // // 求和 sum 线段树：这里精简成了，两个方法。。。因为不曾分步构建过树，所以必要的时候，必须先判断是否为空，添加节点 
        // public long count(Node r, long left, long right) { // 求和线段树：是否与BST 一样，右边节点计数大于左边与根节点呢？
        //     if (r == null) return 0;
        //     // 因为下面这一行的处理：区间外完全不用考虑，返回0
        //     if (left > r.r || right < r.l) return 0; // 查询区间，当前区间节点，完全不用考虑
        //     if (left <= r.l && r.r <= right) return r.s; // 【我是什么时候，才来更新这个计数 s 的？】
        //     // 所以，这里就可以直接调用，递归左右子数，求计数和
        //     return count(r.left, left, right) + count(r.right, left, right);
        // }
        // public void insert(Node r, long v) { // 这里可以理解为：动态更新，过程中随机增加一个元素
        //     r.s++; // 这个时候，才知道，计数，计算区间内元素个数，原来是如此精炒地完成的。。。
        //     if (r.l == r.r) return ; // 叶子节点 
        //     // int m = (r.l + r.r) / 2;
        //     long m = (r.l + r.r) >> 1;
        //     if (v <= m) {
        //         if (r.left == null)
        //             r.left = new Node(r.l, m);
        //         insert(r.left, v);
        //     } else {
        //         if (r.right == null)
        //             r.right = new Node(m+1, r.r);
        //         insert(r.right, v);
        //     }
        // }
        // // 【方法四：】树状数组。好像我前面没能区分，线段树，与树状数组的区别？
        // public int countRangeSum(int[] a, int lo, int hi) {
        //     int n = a.length;
        //     long [] s = new long [n+1];
        //     for (int i = 0; i < n; i++) s[i+1] = s[i] + a[i];
        //     Set<Long> allNumbers = new TreeSet<>();
        //     for (long v : s) {
        //         allNumbers.add(v);
        //         allNumbers.add(v - lo);
        //         allNumbers.add(v - hi);
        //     }            
        //     // 利用哈希表进行离散化
        //     Map<Long, Integer> values = new HashMap<Long, Integer>();
        //     int idx = 0;
        //     for (long v : allNumbers)
        //         values.put(v, idx++);
        //     int ans = 0;
        //     BIT bit = new BIT(values.size());
        //     for (int i = 0; i < s.length; i++) {
        //         int left = values.get(s[i] - hi), right = values.get(s[i] - lo);
        //         ans += bit.query(right + 1) - bit.query(left);
        //         bit.update(values.get(s[i]) + 1, 1);
        //     }
        //     return ans;
        // }
        // class BIT {
        //     int [] tree; 
        //     int n;
        //     public BIT(int n) {
        //         this.n = n;
        //         this.tree = new int[n+1];
        //     }
        //     public static int lowbit(int x) {
        //         return x & (-x); 
        //     }
        //     public void update(int idx, int d) {
        //         while (idx <= n) {
        //             tree[idx] += d;
        //             idx += lowbit(idx);
        //         }
        //     }
        //     public int query(int x) {
        //         int ans = 0;
        //         while (x != 0) {
        //             ans += tree[x];
        //             x -= lowbit(x);
        //         }
        //         return ans;
        //     }
        // }
        // // 【方法五：平衡二叉搜索树】
        // class Solution {
        //     public int countRangeSum(int[] a, int lo, int hi) {
        //         long [] s = new long [a.length+1];
        //         for (int i = 0; i < a.length; i++) s[i+1] = s[i] + a[i];
        //         BT tr = new BT();
        //         int ans = 0;
        //         for (long v : s) {
        //             long numLeft = tr.lowerBound(v - hi);
        //             int rankLeft = (numLeft == Long.MAX_VALUE ? (int)(tr.getSize()+1) : tr.rank(numLeft)[0]);
        //             long numRight = tr.upperBound(v - lo);
        //             int rankRight = (numRight == Long.MAX_VALUE ? (int)tr.getSize() : tr.rank(numRight)[0]-1);
        //             ans += rankRight - rankLeft + 1;
        //             tr.insert(v);
        //         }
        //         return ans;
        //     }
        // }
        // class BT {
        //     private class Node {
        //         long v, s;
        //         int cnt, size;
        //         Node l, r;
        //         Node(long val, long seed) {
        //             v = val;
        //             s = seed; // 为什么要这个种子？伪随机数吗？
        //             cnt = 1;
        //             size = 1;
        //             l = null; r = null;
        //         }
        //         //   this         r <== root
        //         //  /    \      /    \
        //         // l      r   this   r.r(root.r)
        //         //           /    \
        //         //          l     r.l(root.l)
        //         Node leftRotate() { // 左旋：当前根this 变成左子节点；先前右变成根
        //             int prevSize = size;
        //             int currSize = (l != null ? l.size : 0) + (r.l != null ? r.l.size : 0) + cnt; // 左右子树的 size ＋当前根节点的 cnt
        //             Node root = r; // 这里先把 root 当作 r 的另一个索引指针
        //             r = root.l;
        //             root.l = this;
        //             root.size = prevSize; // 【没看明白：】是怎么变过来的？
        //             size = currSize;
        //             return root;
        //         }
        //         //       this         l <== root
        //         //      /    \      /    \
        //         //     l      r   l.l    this
        //         //   /    \             /    \
        //         // l.l    l.r         l.r     r
        //         Node rightRotate() {
        //             int prevSize = size;
        //             int currSize = (r != null ? r.size : 0) + (l.r != null ? l.r.size : 0) + cnt;
        //             Node root = l;
        //             l = root.r;
        //             root.r = this;
        //             root.size = prevSize; // 【没看明白：】是怎么变过来的？
        //             size = currSize;
        //             return root;
        //         }
        //     }
        //     private Node root;
        //     private int size;
        //     private Random rand;
        //     public BT() {
        //         this.root = null;
        //         this.size = 0;
        //         this.rand = new Random();
        //     }
        //     public long getSize() {
        //         return size;
        //     }
        //     public void insert(long v) {
        //         ++size;
        //         root = insert(root, v);
        //     }
        //     public long lowerBound(long v) { // 这是找，最小的一个不小于 v 【 >＝ v】的值吗？
        //         Node r = root;
        //         long ans = Long.MAX_VALUE;
        //         while (r != null) {
        //             if (v == r.v) return v;
        //             if (v < r.v) {
        //                 ans = r.v;
        //                 r = r.l;
        //             } else r = r.r;
        //         }
        //         return ans;
        //     }
        //     public long upperBound(long v) { // 找一个最大的【 <= v】的值
        //         Node r = root;
        //         long ans = Long.MAX_VALUE;
        //         while (r != null) {
        //             if (v < r.v) {
        //                 ans = r.v;
        //                 r = r.l;
        //             } else r = r.r;
        //         }
        //         return ans;
        //     }
        //     public int [] rank(long v) {
        //         Node r = root;
        //         int ans = 0;
        //         while (r != null) {
        //             if (v < r.v) r = r.l;
        //             else { // v >= r.v
        //                 ans += (r.l != null ? r.l.size : 0) + r.cnt;
        //                 if (v == r.v)
        //                     return new int [] {ans - r.cnt + 1, ans};
        //                 r = r.r;
        //             }
        //         }
        //         return new int [] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        //     }
        //     private Node insert(Node r, long v) {
        //         if (r == null) return new Node(v, rand.nextInt());
        //         ++r.size;
        //         if (v < r.v) { // 左子树
        //             r.l = insert(r.l, v);
        //             if (r.l.s > r.s) // 这里有步检查是否平衡的步骤？
        //                 r = r.rightRotate();
        //         } else if (v > r.v) { // 右子树
        //             r.r = insert(r.r, v);
        //             if (r.r.s > r.s)
        //                 r = r.leftRotate();
        //         } else ++r.cnt; // 当前根节点
        //         return r;
        //     }
        // }

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String a =  "9438957234785635408";

        String res = s.minInteger(a, 23);
        System.out.println("res: " + res);
    }
}










