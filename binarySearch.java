// import com.UnionFind;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
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

        // public int minAbsoluteSumDiff(int[] aa, int[] bb) {
        //     int n = aa.length;
        //     int sumDiff = 0, maxDiff = 0;
        //     int maxVal = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (Math.abs(aa[i] - bb[i]) > maxDiff) {
        //             maxDiff = Math.abs(aa[i] - bb[i]);
        //             maxVal = bb[i];
        //         }
        //         sumDiff += Math.abs(aa[i]-bb[i]);
        //     }
        //     if (sumDiff == 0) return 0;
        //     int minDiff = Integer.MAX_VALUE;
        //     for (int v : aa) 
        //         if (Math.abs(v-maxVal) < minDiff) 
        //             minDiff = Math.abs(v-maxVal);
        //         return sumDiff - (maxDiff - minDiff);
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

        
        // private int finishHours(int [] arr, int v) {
        //     int res = 0;
        //     for (int val : arr)
        //         if (val >= v)
        //             res += val / v + (val % v == 0 ? 0 : 1);
        //         else res += 1;
        //     // System.out.println("res: " + res);
        //     return res;
        // }
        // private int binarySearch(int [] arr, int k, int l, int r) {
        //     if (l == r) return finishHours(arr, l) == k ? l : -1;
        //     if (l == r-1) return finishHours(arr, l) == k ? l : (finishHours(arr, r) == k ? r : -1);
        //     int m = l + (r-l) / 2;
        //     // System.out.println("m: " + m);
        //     // if (finishHours(arr, m) == k) return m;
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

        // public int numSubseq(int[] arr, int target) {
        //     Arrays.sort(arr);
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length, res = 0, mod = (int)1e9+7, j = 0;
        //     for (int i = 0; i < n; i++) {
        //         j = i+1;
        //         while (j < n && arr[i] + arr[j] <= target) {
        //             res = (res + 1) % mod;
        //             j++;
        //         }
        //         res += (j-i+1)*(j-i)/2; // 这里加得不对
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


        // public boolean find132pattern(int[] arr) {
        //     int n = arr.length;
        //     int [] min = new int [n];
        //     int [] max = new int [n];
        //     min[0] = arr[0];
        //     max[0] = 0;;
        //     int mav = arr[0];
        //     for (int i = 1; i < n; i++) {
        //         min[i] = Math.min(min[i-1], arr[i]);
        //         if (arr[i] > mav) {
        //             mav = i;
        //             max[i] = i;
        //         } else max[i] = max[i-1];
        //     }
        //     System.out.println("min.length: " + min.length);
        //     for (int z = 0; z < min.length; ++z) 
        //         System.out.print(min[z] + ", ");
        //     System.out.println("");
        //     System.out.println("max.length: " + max.length);
        //     for (int z = 0; z < max.length; ++z) 
        //         System.out.print(max[z] + ", ");
        //     System.out.println("");
        //     for (int i = 0; i < n; i++) {
        //         // System.out.println("\n i: " + i);
        //         // System.out.println("(min[i] < arr[max[i]] && max[i] < n-1) : " + (min[i] < arr[max[i]] && max[i] < n-1) );
        //         if (min[i] < arr[max[i]] && max[i] < n-1) 
        //             for (int j = max[i]+1; j < n; j++) {
        //                 // System.out.println("j: " + j);
        //                 // System.out.println("(arr[j] > min[i]): " + (arr[j] > min[i]));
        //                 // System.out.println("(arr[j] < arr[max[i]]): " + (arr[j] < arr[max[i]]));
        //                 // System.out.println(" (arr[j] > min[i] && arr[j] < arr[max[i]]): " +  (arr[j] > min[i] && arr[j] < arr[max[i]]));
        //                 if (arr[j] > min[i] && arr[j] < arr[max[i]])
        //                     return true;
        //             }
        //     }
        //     return false;
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


        // public int binarySearchHigh(int [] arr, int sum, int n, int l, int r) { // sum: right sum; n: right most available idx
        //     int ridx = n;
        //     while (l <= r) {
        //         int m = l + (r-l)/2;
        //         int mid = arr[n] - arr[m];
        //         if (arr[m] <= mid && mid <= sum) {
        //             ridx = m;
        //             l = m+1;
        //         } else if (arr[m] <= mid)
        //             l = m+1;
        //         else // arr[m] > mid
        //             r = m-1;
        //     }
        //     return ridx;
        // }
        // public int binarySearchLow(int [] arr, int sum, int n, int l, int r) { // sum: right sum; n: right most available idx
        //     int lidx = n;
        //     while (l <= r) {
        //         int m = l + (r-l)/2;
        //         int mid = arr[n] - arr[m];
        //         if (arr[m] <= mid && mid <= sum) {
        //             lidx = m;
        //             r = m-1;
        //         } else if (arr[m] <= mid)
        //             l = m+1;
        //         else r = m-1;
        //     }
        //     return lidx;
        // }
        // public int waysToSplit(int[] arr) { // bug bug bug: 不知道哪里错了
        //     int mod = (int)1e9 + 7;
        //     int n = arr.length;
        //     if (n == 3) return (arr[0] <= arr[1] && arr[1] <= arr[2]) ? 1 : 0;
        //     int [] sum = new int[n];
        //     sum[0] = arr[0];
        //     for (int i = 1; i < n; i++) 
        //         sum[i] = sum[i-1] + arr[i];
        //     int left = 0, mid = 0, right = 0;
        //     int jlo = 0, jhi;
        //     long res = 0;
        //     for (int i = n-1; i >= 2; i--) { // 在第i位的前面树最右边的墙
        //         right = sum[n-1] - sum[i-1];
        //         if (right < sum[n-1] / 3) continue;
        //         jlo = binarySearchLow(sum, right, i-1, 0, i-1);
        //         jhi = binarySearchHigh(sum, right, i-1, 0, i-1);
        //         if (jlo >= 0 && jlo < i-1 || jhi >= 0 && jhi < i-1)
        //             res = (res + jhi - jlo + 1) % mod;
        //     }
        //     return (int)res;
        // }

        
    }
    
    public static void main(String[] args) {
        Solution s = new Solution(); 

        // int []  a = new int []  {2, 3, 5, 10};
        int [] a = new int [] {1,2,2,2,5,0};

        int res = s.waysToSplit(a);
        System.out.println("res: " + res);
    }
}