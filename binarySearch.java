// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;

public class binarySearch {
    public static class Solution {

        // private boolean isSubsequence(String s, String t) {
        //     int n = s.length();
        //     int m = t.length();
        //     if (m > n) return false;
        //     int i = 0, j = 0;
        //     while (j < m) {
        //         while (i < n && j < m && s.charAt(i) == t.charAt(j)) {
        //             ++i;
        //             ++j;
        //         }
        //         if (i == n && j == m) return true;
        //         if (i == n) return false;
        //         if (j == m) return true;
        //         if (t.charAt(j) != s.charAt(i)) ++i;
        //         if (i == n) return false;
        //     }
        //     return true;
        // }
        // private boolean isSubsequence(int [] arr, int v, String s, String t) {
        //     StringBuilder sb = new StringBuilder(s);
        //     List<Integer> l = IntStream.range(0, v).mapToObj(k -> arr[k]).collect(Collectors.toList());
        //     Collections.sort(l, Collections.reverseOrder());
        //     for (int i = 0; i < l.size(); i++) 
        //         sb.deleteCharAt(l.get(i));
        //     return isSubsequence(sb.toString(), t);
        // }
        // private int binarySearch(String s, String t, int [] arr, int l, int h) {
        //     if (l == h) {
        //         if (isSubsequence(arr, l, s, t)) return l;
        //         return 0;
        //     } else if (l == h-1) {
        //         if (isSubsequence(arr, h, s, t)) return h;
        //         if (isSubsequence(arr, l, s, t)) return l;
        //         return 0;
        //     }
        //     int m = l + (h-l)/2;
        //     if (isSubsequence(arr, m, s, t)) return binarySearch(s, t, arr, m, h);
        //     return binarySearch(s, t, arr, l, m-1);
        // }
        // public int maximumRemovals(String s, String t, int[] removable) {
        //     return binarySearch(s, t, removable, 1, removable.length);
        // }


// public boolean find132pattern(int[] arr) {
        //     int n = arr.length;
        //     int l = 0, m = 0, r = 0;
        //     for (int i = 0; i < n-2; i++) {
        //         if (i > 0 && arr[i] == arr[i-1]) continue;
        //         l = arr[i];
        //         for (int j = n-1; j > i; j--) {
        //             if (j < n-1 && arr[j] == arr[j+1]) continue;
        //             if (arr[j] > l) {
        //                 r = arr[j];
        //                 for (int k = i+1; k < j; k++) {
        //                     if (k > i+1 && arr[k] == arr[k-1]) continue;
        //                     if (arr[k] > l && arr[k] > r)
        //                         return true;
        //                 }
        //             }
        //         }
        //     }
        //     return false;
        // }

        
        // private boolean check(int v, int m, int n, int k) {
        //     int res = v / n*n;
        //     if (res >= k) return true;
        //     for (int i = v/n+1; i < Math.min(v, m)+1; i++) {
        //         res += v/i;
        //         if (res >= k) return true;
        //     }
        //     return res >= k;
        // }
        // public int findKthNumber(int m, int n, int k) {
        //     if (m == 1 || n == 1) return k;
        //     if (m > n) return findKthNumber(n, m, k);
        //     int l = 1, r = m*n;
        //     while (l < r) {
        //         int mid = l + (r-l) >> 1;
        //         if (check(mid, m, n, k)) r = mid;
        //         else l = mid + 1;
        //     }
        //     return r;
        // }

       //  private int mergeSortCount(long [] arr, int bgn, int end) {
       //      if (bgn >= end) return 0;
       //      int mid = bgn + (end-bgn)/2;
       //      int cnt = mergeSortCount(arr, bgn, mid) + mergeSortCount(arr, mid+1, end);
       //      for (int i = bgn, j = mid+1; i <= mid; i++) {
       //          while (j <= end && arr[i] > 2*arr[j]) j++;
       //          cnt += j - (mid+1);
       //      }
       //      Arrays.sort(arr, bgn, end+1);
       //      return cnt;
       //  }
       // public int minOperations(int[] target, int[] arr) {
       //      int n = arr.length;
       //      int m = target.length;
       //      Map<Integer, Integer> map = new HashMap<>();
       //      for (int i = 0; i < m; i++) 
       //          map.put(target[i], i);
       //      for (int i = 0; i < n; i++) {
       //          if (map.containsKey(arr[i])) 
       //              arr[i] = map.get(arr[i]);
       //      }
       //      System.out.println("arr.length: " + arr.length);
       //      for (int z = 0; z < arr.length; ++z) 
       //          System.out.print(arr[z] + ", ");
       //      System.out.println("");
       //  }


        // public int findKthNumber(int m, int n, int k) {
        //     int left = 1, right = m * n;
        //     while (left <= right) {
        //         int mid = left + (right - left) / 2;
        //         int cnt = 0;
        //         for (int i = 1; i <= m; i++) 
        //             cnt += Math.min(n, mid / i);
        //         if (cnt < k) left = mid + 1;
        //         else right = mid -1;
        //     }
        //     return left;
        // }


        // private int binarySearch(int [] arr, int n, int v) {
        //     int l = 0, r = n-1;
        //     while (l <= r) {         
        //         int m = l + (r-l)/2;
        //         if (arr[m] < v) l = m+1;
        //         else r = m-1;
        //     }
        //     return l;
        // }
        // private int lengthOfLIS(int [] arr) { 
        //     int n = arr.length, size = 0, j = 0;
        //     int [] dp = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == -1) continue;
        //         j = binarySearch(dp, size, arr[i]);
        //         dp[j] = arr[i];
        //         if (j == size) size++;
        //     }
        //     return size;
        // }
        // public int minOperations(int[] target, int[] arr) {
        //     int n = arr.length;
        //     int m = target.length;
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int i = 0; i < m; i++) 
        //         map.put(target[i], i);
        //     for (int i = 0; i < n; i++) 
        //         if (map.keySet().contains(arr[i])) arr[i] = map.get(arr[i]);
        //         else arr[i] = -1;
        //     return m-lengthOfLIS(arr);
        // }


        // public int closestToTarget(int[] arr, int target) { // 暴力解，现在过不了了
        //     int n = arr.length;
        //     if (n == 1) return Math.abs(target - arr[0]);
        //     int minDiff = Integer.MAX_VALUE;
        //     int v = 0;
        //     for (int i = 0; i < n; i++) {
        //         v = arr[i];
        //         if (i > 0 && v == arr[i-1]) continue;
        //         for (int j = i; j < n; j++) {
        //             v &= arr[j];
        //             minDiff = Math.min(minDiff, Math.abs(v - target));
        //             if (target - v >= minDiff) break;
        //         }
        //     }
        //     return minDiff;
        // }
        // public int closestToTarget(int[] arr, int target) {
        //     int ans = Math.abs(arr[0] - target);
        //     int n = arr.length;
        //     HashSet<Integer> now = new HashSet();
        //     Set<Integer> tmp = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         for (int v : now) 
        //             tmp.add(v & arr[i]);
        //         tmp.add(arr[i]);
        //         for (int v : tmp)
        //             ans = Math.min(ans, Math.abs(v - target));
        //         now.clear();
        //         now.addAll(tmp);
        //         tmp.clear();
        //     }
        //     return ans;
        // }

        // private long numberOfTrailingZeros(long v) {
        //     long cnt = 0;
        //     for (; v > 0; v /= 5) 
        //         cnt += v / 5;
        //     return cnt;
        // }
        // public int preimageSizeFZF(int k) {
        //     long left = 0, right = 5l * (k + 1);
        //     while (left < right) {
        //         long mid = left + (right - left) / 2;
        //         long cnt = numberOfTrailingZeros(mid);
        //         if (cnt == k) return 5;
        //         if (cnt < k) left = mid + 1;
        //         else right = mid;
        //     }
        //     return 0;
        // }
        // public int preimageSizeFZF(int k) {
        //     long left = 0, right = 5l * (k + 1);
        //     while (left < right) {
        //         long mid = left + (right - left) / 2, cnt = 0;
        //         for (long i = 5; mid / i > 0; i *= 5) 
        //             cnt += mid / i;
        //         if (cnt == k) return 5;
        //         if (cnt < k) left = mid + 1;
        //         else right = mid;
        //     }
        //     return 0;
        // }
        // public int preimageSizeFZF(int k) {
        //     if (k < 5) return 5;
        //     int base = 1;
        //     while (base * 5 + 1 <= k) 
        //         base = base * 5 + 1;
        //     if (k / base == 5) return 0;
        //     return preimageSizeFZF(k % base);
        // }


        // public int minimumSize(int[] arr, int maxOperations) {
        //     int n = arr.length;
        //     int l = 1, r = Arrays.stream(arr).max().getAsInt(), m = 0, cnt = 0;
        //     while (l < r) {
        //         cnt = 0;
        //         m = l + (r - l)/2;
        //         for (int v : arr) 
        //             cnt += (v - 1) / m;
        //         if (cnt <= maxOperations)
        //             r = m;
        //         else l = m + 1;
        //     }
        //     return l;
        // }

        
        // private boolean possible(int [] arr, int m, int v) {
        //     int i = 1, p = arr[0]; --m;
        //     while (i < n) {
        //         while (i < n && arr[i]- p < v) ++i;
        //         if (i == n && m > 0) return false;
        //         else if (i == n) return true;
        //         --m;
        //         p = arr[i];
        //         ++i;
        //     }
        //     return m <= 0;
        // }
        // private int binarySearchinSortedArray(int [] arr, int m, int l, int h) {
        //     if (l == h) return h;
        //     if (l == h-1) {
        //         if (possible(arr, m, h)) return h;
        //         return l;
        //     }
        //     int mid = l + (h-l)/2;
        //     if (possible(arr, m, mid)) return binarySearchinSortedArray(arr, m, mid, h);
        //     else return binarySearchinSortedArray(arr, m, l, mid-1);
        // }
        // int n;
        // public int maxDistance(int[] position, int m) {
        //     n = position.length;
        //     Arrays.sort(position);
        //     int min = Integer.MAX_VALUE, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             min = Math.min(min, position[j] - position[i]);
        //             max = Math.max(max, position[j] - position[i]);
        //         }
        //     }
        //     if (m == n) return min;
        //     if (m == 2) {
        //         if (n == 2) return (int)Math.abs(position[0]-position[1]);
        //         else return max;
        //     }
        //     return binarySearchinSortedArray(position, m, min, max);
        // }

        
        // 怎么才能在这个里面用binarySearch呢？
        // 找子数绒组和为特定值的最大子数组长度 range [0, n] ??? 思路错到了千里之外：我这是在背题么？！！！
        // public int minOperations(int[] arr, int x) {
        //     int n = arr.length, max = 0;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + arr[i-1];
        //     if (x == sum[n]) return n;
        //     for (int i = 0; i < n; i++) // 有了前缀和，别人一次遍历O(N)就能找到特定和的最长子数组，我硬是把它变成了O(N^2)，真该死！！！
        //         for (int j = 0; j <= i; j++) 
        //             if (sum[i+1] - sum[j] == sum[n]-x)
        //                 max = Math.max(max, i-j+1);
        //     return max == 0 ? -1 : n - max;
        // }
        // public int minOperations(int[] nums, int x) { // C++
        //     3         int target = -x;
        //     4         int len = nums.length;
        //     5         for (int num : nums) {
        //         6             target += num;
        //         7         }
        //     8         // corner case
        //         9         if (target == 0) {
        //         10             return len;
        //         11         }
        //     12         // normal case
        //         13         int res = Integer.MIN_VALUE;
        //     14         int sum = 0;
        //     15         HashMap<Integer, Integer> map = new HashMap<>();
        //     16         map.put(0, -1);
        //     17         for (int i = 0; i < len; i++) {
        //         18             sum += nums[i];
        //         19             if (map.containsKey(sum - target)) {
        //             20                 res = Math.max(res, i - map.get(sum - target));
        //             21             }
        //         22             map.put(sum, i);
        //         23         }
        //     24         return res == Integer.MIN_VALUE ? -1 : len - res;
        //     25     }
        // public int minOperations(int[] arr, int x) {
        //     int n = arr.length, sum = Arrays.stream(arr).sum()-x, max = -1, cur = 0;
        //     for (int l = 0, r = 0; r < n; r++) {
        //         cur += arr[r];
        //         while (l <= r && cur - arr[l] >= sum) cur -= arr[l++];
        //         if (cur == sum) max = Math.max(max, r-l+1);
        //     }
        //     return max == -1 ? -1 : n - max;
        // }


        // private int getNewSum(int [] arr, int v) {
        //     int sum = 0;
        //     for (int i = 0; i < arr.length; i++) 
        //         if (arr[i] <= v) sum += arr[i];
        //         else sum += v;
        //     return sum;
        // }
        // private int binarySearch(int [] arr, int v, int l, int r) {
        //     if (l == r) return l;
        //     if (l == r-1) return Math.abs(getNewSum(arr, l)-v) <= Math.abs(getNewSum(arr, r)-v) ? l : r;
        //     int m = l + (r-l)/2;
        //     if (getNewSum(arr, m) >= v) return binarySearch(arr, v, l, m);
        //     return binarySearch(arr, v, m, r); // 因为要找最相近的答案，这里不要把范围缩得太小了
        // }
        // public int findBestValue(int[] arr, int target) {
        //     int n = arr.length, min = Arrays.stream(arr).min().getAsInt();
        //     while (target < min * n) min /= 2;
        //     return binarySearch(arr, target, min, Arrays.stream(arr).max().getAsInt());
        // }


        // public int chalkReplacer(int[] chalk, int k) {
        //     int n = chalk.length;
        //     long sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum += chalk[i];
        //     k = (int)(k % sum);
        //     int i = 0;
        //     while (i < n && chalk[i] <= k) {
        //         k -= chalk[i];
        //         ++i;
        //     }
        //     return i;
        // }


        // // 法一：暴力TreeMap---O(n^2logn)
        // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int i = 0; i < difficulty.length; i++) 
        //         m.put(difficulty[i], i);
        //     int res = 0, idx;
        //     Integer low;
        //     for (int i = 0; i < worker.length; i++) {
        //         low = m.floorKey(worker[i]); // 使用treemap排序的特长
        //         if (low == null) continue;
        //         idx = m.get(low);
        //         for (int j = 0; j < difficulty.length; j++) 
        //             if (difficulty[j] <= low && profit[j] >= profit[idx])
        //                 idx = j;
        //         res += profit[idx];
        //     }
        //     return res;
        // }
        // // 法二：优化的TreeMap---O(nlogn)
        // // 如果TreeMap里面保存的是每个difficulty[i] 对应的最大的profit，则就可以直接找floorKey对应的value就是对应的要找的value;
        // // 那么只需要再遍历一次TreeMap，将最大的到目前key位置最大的value放进去就行了
        // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     for (int i = 0; i < difficulty.length; i++) 
        //         m.put(difficulty[i], Math.max(m.getOrDefault(difficulty[i], 0), profit[i]));
        //     int max = 0;
        //     for (Integer key : m.keySet()) { 
        //         max = Math.max(max, m.get(key));
        //         m.put(key, max); //将最大的到目前key位置最大的value放进去
        //     }
        //     int res = 0;
        //     Integer low;
        //     for (int i = 0; i < worker.length; i++) {
        //         low = m.floorKey(worker[i]); // 使用treemap排序的特长
        //         if (low == null) continue;
        //         res += m.get(low);
        //     }
        //     return res;
        // }
        // // 法三：Sort + 双指针---O(nlogn)
        // // 思路就是先将 difficulty[]和profit组成pair，然后再将list和worker[]从小到大排序，然后遍历worker，更新tempMaxProfit，得到总的maxProfit
        // public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //     List<int[]> list = new ArrayList<>();
        //     for (int i = 0; i < difficulty.length; i++) 
        //         list.add(new int[] {difficulty[i], profit[i]});
        //     Collections.sort(list, (a, b) -> {return a[0] - b[0];});
        //     Arrays.sort(worker);
        //     int res = 0, tmpMaxProfit = 0;
        //     // i, j同向双指针移动，更新到目前的tmpMaxProfit
        //     for (int i = 0, j = 0; i < worker.length; i++) {
        //         while (j < list.size() && list.get(j)[0] <= worker[i]) {
        //             tmpMaxProfit = Math.max(tmpMaxProfit, list.get(j)[1]);
        //             j++;
        //         }
        //         //此时tmpMaxProfit是前面所有difficulty小于worker[i]的最大的proifit
        //         res += tmpMaxProfit;
        //     }
        //     return res;
        // }


        // private boolean valid(int [] a, int [] b, long v) {
        //     int i = 0, j = 0;
        //     while (i < n && j < m) {
        //         if (b[j] > a[i]) {
        //             if (a[i] < b[j] - v) return false;
        //             while (i < n && a[i] <= b[j] + v) ++i;
        //             ++j;
        //         } else {  // b[j] <= a[i]
        //             if (b[j] + v < a[i]) ++j;
        //             else {
        //                 while (i < n && a[i] <= b[j] + v) ++i;
        //                 ++j;
        //             }
        //         }
        //     }
        //     if (j == m && i < n) return false;
        //     return true;
        // }
        // private int binarySearch(int [] a, int [] b, long l, long r) {
        //     if (l == r) return valid(a, b, l) ? (int)l : -1;
        //     if (l == r-1) return valid(a, b, l) ? (int)l : (valid(a, b, r) ? (int)r : -1);
        //    long m = l + (r-l)/2;
        //     if (valid(a, b, m)) return binarySearch(a, b, l, m);
        //     return binarySearch(a, b, m+1, r);
        // }
        // int m, n;
        // public int findRadius(int[] houses, int[] heaters) {
        //     n = houses.length;
        //     m = heaters.length;
        //     long sum = 0;
        //     for (int v : houses) sum += v;
        //     Arrays.sort(houses);
        //     Arrays.sort(heaters);
        //     return binarySearch(houses, heaters, 0, heaters[m-1] > houses[n-1] ? (long)heaters[m-1] : (long)sum);
        // }


        // private boolean poss(int n, int idx, int sum, int target) {
        // }
        // private int binarySearch(int n, int idx, int sum, int l, int r) {
        //     if (l == r) return l;
        //     if (l == r-1) return ;
        // }
        // public int maxValue(int n, int index, int maxSum) {
        //     return binarySearch(n, index, maxSum, 0, n-1);
        // }


// public int findLatestStep(int[] arr, int m) { // 上下两个方法都是有bug的
        //     int n = arr.length;
        //     if (m == n) return n;
        //     Map<Integer, Set<String>> map = new HashMap<>();
        //     map.computeIfAbsent(n, k->new HashSet<>()).add("1".repeat(n));
        //     for (int i = n; i > 0; i--) { // index has problems
        //         System.out.println("\n i: " + i);
        //         System.out.println("map.get(i).size(): " + map.get(i).size());
        //         System.out.println(Arrays.toString(new ArrayList<>(map.get(i)).toArray()));
        //         if (map.get(i) == null) return -1;
        //         for (String s : map.get(i)) 
        //             if (s.length() == m) return i;
        //         for (String s : map.get(i)) {
        //             if (s.length() < arr[arr[i-1]-1]) continue; // a[i-1]-1+1
        //             String one = s.substring(0, arr[arr[i-1]-1]-1);
        //             if (one.length() > 0)
        //                 map.computeIfAbsent(i-1, k->new HashSet<>()).add(one);
        //             if (arr[arr[i-1]-1]-1 < s.length()-1) {
        //                 String two = s.substring(arr[arr[i-1]-1]);
        //                 map.computeIfAbsent(i-1, k->new HashSet<>()).add(two);
        //             }
        //         }
        //     }
        //     return -1;
        // }
        // public int findLatestStep(int[] arr, int m) {
        //     int n = arr.length;
        //     if (m == n) return n;
        //     Map<Integer, Set<String>> map = new HashMap<>();
        //     map.computeIfAbsent(n, k->new HashSet<>()).add("1".repeat(n));
        //     for (int i = n; i > 0; i--) { // index has problems
        //         System.out.println("\n i: " + i);
        //         System.out.println("map.get(i).size(): " + map.get(i).size());
        //         System.out.println(Arrays.toString(new ArrayList<>(map.get(i)).toArray()));
        //         if (map.get(i) == null) return -1;
        //         for (String s : map.get(i)) 
        //             if (s.length() == m) return i;
        //         for (String s : map.get(i)) {
        //             if (s.length() < arr[i-1]) continue; // a[i-1]-1+1
        //             String one = s.substring(0, arr[i-1]-1);
        //             if (one.length() > 0)
        //                 map.computeIfAbsent(i-1, k->new HashSet<>()).add(one);
        //             if (arr[i-1]-1 < s.length()-1) {
        //                 String two = s.substring(arr[i-1]);
        //                 map.computeIfAbsent(i-1, k->new HashSet<>()).add(two);
        //             }
        //         }
        //     }
        //     return -1;
        // }


        // public int reachNumber(int target) { // 结果：是个数学问题！！！
        //     target = Math.abs(target);
        //     int cnt = 0, sum = 0;
        //     while (sum < target) sum += (++cnt);
        //     int d = sum - target;
        //     if (d % 2 == 0) return cnt;
        //     return cnt + 1 + (cnt % 2);
        // }


        // private boolean canReach(int [] arr, int v, double target) {
        //     double res = 0;
        //     for (int i = 0; i < arr.length-1; i++) 
        //         res += Math.ceil((double)arr[i] / (double)v);
        //     res += (double)arr[arr.length-1] / (double)v;
        //     return res <= target;
        // }
        // public int minSpeedOnTime(int[] dist, double hour) {
        //     int l = 1, r = 10000000, m;
        //     int res = -1;
        //     while (l <= r) {
        //         m = l + (r-l)/ 2;
        //         if (canReach(dist, m, hour)) {
        //             res = m; // 把当下最优结果先记下来
        //             r = m-1; // 同时继续缩短一个，以避免死循环
        //         } else l = m+1;
        //     }
        //     return res;
        // }

        // public int findNthDigit(int n) {
        //     int digit = 1;     // 该范围内所有实际数字都占用了digit个单数字
        //     long totDigit = 0; // 该范围之前的所有实际数字已经占用了totalDigit个单数字
        //     while (true) {     // 先查出区间范围
        //         long top = totDigit + digit * 9 * (long)Math.pow(10, digit-1);
        //         if (n >= totDigit && n <= top) break;
        //         totDigit = top;
        //         digit++;
        //     }
        //     // 根据范围算出具体的值
        //     int bgn = (int)Math.pow(10, digit-1);
        //     int res = 0;
        //     totDigit += 1;
        //     // 第n个digit在哪个具体的实际数字上
        //     int val = bgn + (n - (int)totDigit) / digit;
        //     res = Integer.toString((int)val).charAt((int)((n- totDigit) % digit)) - '0';
        //     return res;
        // }


        // public int waysToSplit(int[] arr) { // O(N) solution
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length;
        //     int [] sum = new int [n+1];
        //     for (int i = 1; i <= n; i++)
        //         sum[i] = sum[i-1] + arr[i-1];
        //     long res = 0;
        //     int j = 1, k = 2;
        //     for (int i = 0; i < n-2; i++) { // 最后至少留两个数权当两段， 最左板的位置
        //         int left = sum[i+1];
        //         int target = (sum[n] - sum[i+1]) / 2;
        //         if (target < left) break;  // sum of arr[i+1, j] inclusive
        //         while (j <= i || j < n-1 && sum[j+1] - sum[i+1] < left) j++;              // 中间和要比左边的大, 合理的最左侧板
        //         while (k < j || k < n-1 && sum[k+1] - sum[i+1] <= sum[n] - sum[k+1]) k++; // 右边的和要比中间的大， 合理的最右侧板
        //         res = (res + k - j) % mod;
        //     }
        //     return (int)res;
        // }
        // int binarySearchHigh(int [] arr, int i) { // 初步偿试写while简洁版代码,没有写recursion得心应手
        //     int l = 1, h = i;
        //     while (l < h) {
        //         int m = l + (h - l + 1) / 2; // 边界向右靠拢
        //         int sa = arr[m-1];
        //         int sb = arr[i] - arr[m-1];
        //         if (sa > sb) h = m - 1; // 确保的是左段比中间段小
        //         else l = m;
        //     }
        //     return arr[l-1] <= arr[i] - arr[l-1] ? l : -1;
        // }
        int binarySearchLow(int [] arr, int i) {
            int l = 1, h = i;
            while (l < h) {
                int m = l + (h - l) / 2;
                int sa = arr[i] - arr[m-1];
                int sb = arr[arr.length-1] - arr[i];
                if (sa > sb) l = m + 1; // 确保的是中间段比右段小
                else h = m;
            } // 寻找左边界：返回的永远是左边界 
            return arr[i] - arr[l-1] <= arr[arr.length-1] - arr[i] ? l : -1;
        }
        // public int waysToSplit(int[] arr) { 
        //     int mod = (int)1e9 + 7, res = 0;
        //     for (int i = 1; i < arr.length; i++)
        //         arr[i] += arr[i-1];
        //     for (int i = 1; i < arr.length-1; i++) { // i位置右侧树右墙
        //         int l = binarySearchLow(arr, i);
        //         int r = binarySearchHigh(arr, i);
        //         if (l != -1 && r != -1 && l <= r)
        //             res = (res + r - l + 1) % mod;
        //     }
        //     return res;
        // }


        // int getSum(int [] arr, int idx, int v) {
        //     Arrays.fill(arr, 0);
        //     arr[idx] = v;
        //     for (int i = idx-1; i >= 0; i--) 
        //         arr[i] = v + (idx-i);
        //     for (int i = idx+1; i < arr.length; i++) 
        //         arr[i] = v-(i-idx); // [1,2,2,1] 这种数组并不是按提示的方法生成的 ？？？
        //     int sum = 0; // 算和的方法不是这么算的，换个方法，按它的提示写，改天再接着写
        //     for (int cur : arr) 
        //         sum += cur;
        //     return sum;
        // }
        // public int maxValue(int n, int idx, int maxSum) {
        //     int [] arr = new int [n];
        //     int l = 0, r = n-1, res = 0;
        //     while (l < r) { // when exit: l == r
        //         System.out.println("\n l: " + l);
        //         System.out.println("r: " + r);
        //         int m = l + (r - l) / 2;
        //         if (getSum(arr, idx, m) <= maxSum) {
        //             // res = m;
        //             l = m;
        //         } else r = m-1;
        //     }
        //     System.out.println("l: " + l);
        //     System.out.println("res: " + res);
        //     return getSum(arr, idx, l) <= maxSum ? l : -1; // so shoult double check if l is valid here in theory......
        // }


        // int binarySearch(int [] arr, int v) { // 我记得这种题目以前都写疯了，现在再写居然还在犯迷糊。。。。。。
        //     if (v < arr[0]) return arr[0];
        //     if (v > arr[arr.length-1]) return arr[arr.length-1];
        //     int l = 0, r = arr.length, m = 0;
        //     while (l < r) { // when exit: l == r
        //         m = l + (r - l) / 2;
        //         if (arr[m] == v) return arr[m];
        //         if (v < arr[m]) {
        //             if (m > 0 && v > arr[m-1])
        //                 return Math.abs(arr[m]-v) <= Math.abs(v-arr[m-1]) ? arr[m] : arr[m-1];
        //             r = m-1;
        //         } else { // arr[m] < v
        //             if (m < arr.length-1 && v < arr[m+1])
        //                 return Math.abs(arr[m+1]-v) <= Math.abs(arr[m]-v) ? arr[m+1] : arr[m];
        //             l = m+1;
        //         }
        //     }
        //     return l >= 0 && l < arr.length ? arr[l] : -1;  // needs double check here
        // }
        // public int minAbsoluteSumDiff(int[] aa, int[] bb) { // binarySearch cloest val to a target
        //     int mod = (int)1e9 + 7;
        //     int n = aa.length;
        //     long sumDiff = 0;
        //     for (int i = 0; i < n; i++) 
        //         sumDiff += Math.abs(aa[i]-bb[i]);
        //     int [] arr = Arrays.copyOf(aa, n);
        //     Arrays.sort(arr);
        //     int maxDiff = Integer.MIN_VALUE, locDif = Integer.MIN_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         int v = binarySearch(arr, bb[i]);
        //         locDif = Math.abs(aa[i] - bb[i]) - Math.abs(v - bb[i]);
        //         maxDiff = Math.max(maxDiff, locDif);
        //     }
        //     return (int)((sumDiff - maxDiff) % mod);
        // }

        
        // public int maximumScore(int[] arr, int k) {
        //     int n = arr.length, maxScore = 0;
        //     List<Integer> leftMinIdx = new ArrayList<>();
        //     List<Integer> rightMinIdx = new ArrayList<>();
        //     leftMinIdx.add(k);
        //     rightMinIdx.add(k);
        //     for (int i = k-1; i >= 0; i--) 
        //         if (arr[i] < arr[leftMinIdx.get(leftMinIdx.size()-1)])
        //             leftMinIdx.add(i);
        //     for (int i = k+1; i < n; i++) 
        //         if (arr[i] < arr[rightMinIdx.get(rightMinIdx.size()-1)])
        //             rightMinIdx.add(i);
        //     int i = 0, j = 0, nleft = leftMinIdx.size(), nright = rightMinIdx.size(); // 这里的下标-1有点儿绕
        //     while (i < nleft || j < nright) {
        //         int l = (i == nleft - 1) ? -1 : leftMinIdx.get(i+1); // 当前左侧最小值对应的左边界
        //         int r = (j == nright -1) ? n  : rightMinIdx.get(j+1);// 当前右侧最小值对应的右边界
        //         maxScore = Math.max(maxScore, Math.min(arr[leftMinIdx.get(i)], arr[rightMinIdx.get(j)]) * (r - l - 1));
        //         if (i == nleft -1 && j == nright -1) break;
        //         else if (i == nleft - 1) j++;   // 左单调栈已到达边界
        //         else if (j == nright - 1) i++;  // 右单调栈已到达边界
        //         else if (arr[l] <= arr[r]) j++; // 选取左、右区间中下一个较大的最小值，若相等则任意选取
        //         else i++;
        //     }
        //     return maxScore;
        // }
        // 1.Start l, r at k and set min = nums[k].
        // 2.Extend l and r as far as possible until nums[l - 1] < min and nums[r + 1] < min.
        //   The reason for this is that any subarrays of nums[i, j] should be dominated by current min
        //   and we are guaranteed the length is maximum which lead to best score so far.
        // 3.We need to pick a new minimum value at this stage. Pick max(nums[l - 1], nums[r + 1]) as the new min to ensure not losing any candidates.
        // 4.Repeat above steps until l,r hit bounds.
        // public int maximumScore(int[] arr, int k) {  // O(N) Two Pointers
        //     int n = arr.length, maxScore = arr[k];
        //     int l = k, r = k, min = arr[k];
        //     while (true) {
        //         while (r+1 < n && arr[r+1] >= min) r++;
        //         while (l-1 >= 0 && arr[l-1] >= min) l--;
        //         maxScore = Math.max(maxScore, min*(r - l + 1));
        //         if (l == 0 && r == n-1) break;
        //         if (l == 0) min = arr[r+1];
        //         else if (r == n-1) min = arr[l-1];
        //         else min = Math.max(arr[r+1], arr[l-1]);
        //     }
        //     return maxScore;
        // }
        // public int maximumScore(int[] arr, int k) {  // Monotonic Increasing subsequence with stack O(N)
        //     Stack<Integer> st = new Stack<>();
        //     for (int i = 0; i <= k; i++) {
        //         while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
        //         st.push(i);
        //     }
        //     int res = 0;
        //     for (int i = k+1; i < arr.length; i++) 
        //         if (arr[st.peek()] > arr[i]) {
        //             while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
        //                 int pos = st.pop();
        //                 int n = st.isEmpty() ? i : i - st.peek() - 1;
        //                 res = Math.max(res, arr[pos]*n);
        //             }
        //             st.push(i);
        //         }
        //     while (!st.isEmpty()) {
        //         int pos = st.pop();
        //         int n = st.isEmpty() ? arr.length : arr.length - st.peek() - 1;
        //         res = Math.max(res, arr[pos]*n);
        //     }
        //     return res;
        // }
        // monotonic stack based on LC84
        // public int maximumScore(int[] nums, int k) {
        //     Stack<Integer> stack = new Stack<>();
        //     int res = 0;
        //     for (int i = 0; i < nums.length; i++) {
        //         while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        //             int currIndex = stack.pop();
        //             int leftBound = -1;
        //             if (!stack.isEmpty()) leftBound = stack.peek();
        //             int area = (i - leftBound - 1) * nums[currIndex];
        //             if (leftBound + 1 <= k && i - 1 >= k) res = Math.max(res, area);
        //         }
        //         stack.push(i);
        //     }
        //     while (!stack.isEmpty()) {
        //         int currIndex = stack.pop();
        //         int leftBound = -1;
        //         if (!stack.isEmpty()) leftBound = stack.peek();
        //         int area = (nums.length - leftBound - 1) * nums[currIndex];
        //         if (leftBound <= k) res = Math.max(res, area);
        //     }
        //     return res;
        // }


        // public int[] kthSmallestPrimeFraction(int [] arr, int k) { // 每行从左到右降序、每列从底向上降序
        //     int n = arr.length;
        //     double l = 0, r = 1.0;
        //     while (l < r) {
        //         double m = (l + r) / 2;
        //         double maxF = 0;  // 小于m 的当前最大元素，因为我们要找第k小的元素
        //         int total = 0, p = 0, q = 0;
        //         for (int i = 0, j = 1; i < n-1; i++) {        // i 从上往下遍历n-1行
        //             while (j < n && arr[i] > m * arr[j]) ++j; // 找到第一个arr[i] / arr[j]小于 m 的j的位置，i, j两层循环是O(N)
        //             if (j == n) break;                        // j 继续第i-1行的搜索结果继续往右搜索
        //             total += n - j;
        //             double f = (double)arr[i] / arr[j]; // 这里double转化总是要单个的转化，加括号是错的！！！XXX_ (double)(a[i]/a[j]) _XXX
        //             if (f > maxF) {
        //                 p = i;
        //                 q = j;
        //                 maxF = f;
        //             }
        //         } // 当找到K个最小元素，那么就返回K小里面的最大元素
        //         if (total == k) return new int [] {arr[p], arr[q]};
        //         else if (total > k) r = m;
        //         else l = m; 
        //     }
        //     return  new int [0];
        // }

 
        // public List<List<Integer>> findSolution(CustomFunction customfunction, int z) { // 这个比较快
        //     List<List<Integer>> res = new ArrayList<>();
        //     for (int i = 1; i <= 1000; i++) {
        //         if (i > z) break; // 如果i大于z，说明之后所有i乘j均大于z
        //         for (int j = 1; j <= 1000; j++) {
        //             int tmp = customfunction.f(i, j);
        //             if (tmp == z) 
        //                 res.add(List.of(i, j));
        //             if (tmp >= z) break;
        //         }
        //     }
        //     return res;
        // }
        // public List<List<Integer>> findSolution(CustomFunction customfunction, int z) { // 这个反而慢
        //     List<List<Integer>> res = new ArrayList<>();
        //     int i = 1, j = 1000;
        //     while (i <= 1000 && j >= 1) {
        //         int v = customfunction.f(i, j);
        //         if (v > z) j -= 1;
        //         else if (v < z) i += 1;
        //         else {
        //             res.add(List.of(i, j));
        //             i += 1;
        //         }
        //     }
        //     return res;
        // }


        // private int finishHours(int [] arr, int v) { // bug bug bug
        //     int res = 0; 
        //     for (int val : arr)
        //         if (val >= v)
        //             res += val / v + (val % v == 0 ? 0 : 1);
        //         else res += 1;
        //     return res;
        // }
        // private int binarySearch(int [] arr, int k, int l, int r) {
        //     if (l == r) return finishHours(arr, l) == k ? l : -1;
        //     if (l == r-1) return finishHours(arr, l) == k ? l : (finishHours(arr, r) == k ? r : -1);
        //     int m = l + (r-l) / 2;
        //     if (finishHours(arr, m) <= k) return binarySearch(arr, k, l, m);
        //     return binarySearch(arr, k, m+1, r);
        // }
        // int n;
        // public int minEatingSpeed(int[] piles, int h) {
        //     n = piles.length;
        //     if (h == n) return Arrays.stream(piles).max().getAsInt();
        //     if (n == 1) return piles[0] / h + (piles[0] % h == 0 ? 0 : 1);
        //     return binarySearch(piles, h, Arrays.stream(piles).min().getAsInt(), Arrays.stream(piles).max().getAsInt());
        // }
        // public int minEatingSpeed(int[] piles, int h) {
        //     int max = Arrays.stream(piles).max().getAsInt();
        //     int bgn = 1, end = max;
        //     while (bgn < end) {
        //         int mid = bgn + (end - bgn) / 2;
        //         int tt = 0;
        //         for (int i = 0; i < piles.length; i++) {
        //             int v = (int)Math.ceil(piles[i] * 1.0 / mid);
        //             tt += v;
        //         }
        //         if (tt <= h) end = mid;
        //         else if (tt >= h) bgn = mid + 1;
        //     }
        //     return bgn;
        // }


        // public boolean find132pattern(int[] arr) {
        //     int n = arr.length;
        //     TreeSet<Integer> left = new TreeSet<>();
        //     TreeMap<Integer, Integer> right = new TreeMap<>();
        //     for (int i = n-1; i >= 2; i--) 
        //         right.put(arr[i], right.getOrDefault(arr[i], 0) + 1);
        //     left.add(arr[0]);
        //     for (int i = 1; i < n; i++) {
        //         Integer lower = left.first();
        //         Entry<Integer, Integer> lowerTwo = right.lowerEntry(arr[i]);
        //         if (lower != null && lowerTwo != null && lowerTwo.getKey() > lower && lowerTwo.getKey() < arr[i]) return true;
        //         left.add(arr[i]);
        //         if (i + 1 < n) {
        //             right.put(arr[i+1], right.get(arr[i+1])-1);
        //             if (right.get(arr[i+1]) == 0) right.remove(arr[i+1]);
        //         }
        //     }
        //     return false;
        // }

        
        // private static long INF = (long)1e10;
        // public long kthSmallestProduct(int[] a, int[] b, long k) { 
        //     int m = a.length, n = b.length;
        //     long lo = -INF-1, hi = INF + 1;
        //     while (lo < hi) {
        //         long mid = lo + (hi - lo) / 2, cnt = 0;
        //         for (int  i : a) { // 对于数组a中的每一个数与b中元素的乘积，数<=mid的个数，二分搜索
        //             if (i >= 0) {
        //                 int l = 0, r = n-1, p = 0;
        //                 while (l <= r) {
        //                     int c = l + (r - l) / 2;
        //                     long mul = i * (long)b[c];
        //                     if (mul <= mid) {
        //                         p = c + 1;
        //                         l = c + 1;
        //                     } else r = c - 1;
        //                 }
        //                 cnt += p;
        //             } else { // i < 0
        //                 int l = 0, r = n-1, p = 0;
        //                 while (l <= r) {
        //                     int c = l + (r - l) / 2;
        //                     long mul = i * (long)b[c];
        //                     if (mul <= mid) {
        //                         p = n - c; // i < 0, 数右边<= mid的个数
        //                         r = c - 1;
        //                     } else l = c + 1;
        //                 }
        //                 cnt += p;
        //             }
        //         }
        //         if (cnt >= k) hi = mid;
        //         else lo = mid + 1l;
        //     }
        //     return lo;
        // }
        // private static long INF = (long)1e10;
        // public long kthSmallestProduct(int[] a, int[] b, long k) { 
        //     long lo = -INF, hi = INF;
        //     while (lo < hi) {
        //         long mid = lo + hi + 1 >> 1;
        //         if (f(a, b, mid) < k) lo = mid;
        //         else hi = mid - 1;
        //     }
        //     return lo;
        // }
        // private long f(int [] a, int [] b, long mid) {
        //     long cnt = 0;
        //     for (int v : a) {
        //         int l = 0, r = b.length;
        //         if (v < 0) {
        //             while (l < r) {
        //                 int m = l + r >> 1;
        //                 if ((long)v * b[m] >= mid) l = m + 1;
        //                 else r = m;
        //             }
        //             cnt += b.length - l;
        //         } else { // v >= 0
        //             while (l < r) {
        //                 int m = l + r >> 1;
        //                 if ((long)v * b[m] < mid) l = m + 1;
        //                 else r = m;
        //             }
        //             cnt += l;
        //         }
        //     }
        //     return cnt;
        // }


        // public int minimumBoxes(int n) {
        //     long base = (long)Math.cbrt(6 * (long)n);
        //     if (base * (base + 1) * (base + 2) / 6 > n) base--;
        //     long blockBase = base * (base + 1) / 2;
        //     n = n - (int)(base * (base + 1) * (base + 2) / 6);
        //     long extra = (long)Math.sqrt(2 * (long)n);
        //     if (extra * (extra + 1) / 2 >= n)
        //         return (int)(blockBase + extra);
        //     else return (int)(blockBase + extra + 1);
        // }
        
       
        // public int smallestDistancePair(int[] arr, int k) { // memory limit exceeded
        //     int n = arr.length;                             
        //     Arrays.sort(arr);
        //     Queue<int []> q = new PriorityQueue<>((a, b)->Math.abs(a[0]-a[1])-Math.abs(b[0]-b[1]));
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             q.offer(new int [] {arr[i], arr[j]});
        //     int ans = 0;
        //     while (k > 0 && !q.isEmpty()) {
        //         int [] cur = q.poll();
        //         ans = Math.abs(cur[0] - cur[1]);
        //         k--;
        //     }
        //     return ans;
        // }
        // private int getLessThanCnt(int [] arr, int v) { // <= v
        //     int j = 0, ans = 0;
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] - arr[j] > v) 
        //             while (j < i && arr[i] - arr[j] > v) j++;
        //         ans += i - j;
        //     }
        //     return ans;
        // }
        // public int smallestDistancePair(int[] arr, int k) { 
        //     int n = arr.length;                             
        //     Arrays.sort(arr);
        //     int l = 0, r = Math.abs(arr[n-1] - arr[0]), cnt = 0, m = 0;
        //     while (l < r) { // when l == r infinite loop when l == r
        //         m = l + (r - l) / 2;
        //         cnt = 0; 
        //         for (int i = 0, j = 0; i < n; i++) {
        //             while (j < i && arr[i] - arr[j] > m) j++;
        //             cnt += i - j;
        //         }
        //         // cnt = getLessThanCnt(arr, m);
        //         if (cnt < k) l = m + 1;
        //         else r = m; //
        //     }
        //     return l;
        // }
        // public int smallestDistancePair(int[] arr, int k) { // try to avoid infinite loop
        //     int n = arr.length;                             
        //     Arrays.sort(arr);
        //     int l = 0, r = arr[n-1] - arr[0], cnt = 0, m = 0, j = 0;
        //     while (l <= r) { // when l == r infinite loop when l == r
        //         m = l + (r - l) / 2;
        //         cnt = 0;
        //         j = 0;
        //         for (int i = 0; i < n; i++) {
        //             while (j < n && arr[j] - arr[i] <= m) ++j;
        //             cnt += j - i - 1;
        //         }
        //         if (cnt < k) l = m + 1;
        //         else r = m - 1; //
        //     }
        //     return l;
        // }
   }
    public static void main(String[] args) {
        Solution s = new Solution(); 

        // int [] a = new int [] {1, 3, 1};
        int []  a = new int []  {1, 6, 1};

        int res = s.smallestDistancePair(a, 5);
        System.out.println("res: " + res);
    }
}