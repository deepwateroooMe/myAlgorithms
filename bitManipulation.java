import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
// import javafx.util.Pair;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class bitManipulation {
    public static class Solution {

        // public int[] xorQueries(int[] arr, int[][] queries) {
        //     int n = arr.length;
        //     int [] pre = new int [n+1];
        //     for (int i = 0; i < n; i++) 
        //         pre[i+1] = pre[i] ^ arr[i];
        //     int [] res = new int[queries.length];
        //     for (int i = 0; i < queries.length; i++) 
        //         res [i] = pre[queries[i][1]+1] ^ pre[queries[i][0]];
        //     return res;
        // }

        // public int countTriplets(int[] arr) {
        //     int n = arr.length;
        //     int [] pre = new int[n+1];
        //     for (int i = 0; i < n; i++) 
        //         pre[i+1] = pre[i] ^ arr[i];
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if ((pre[j+1] ^ pre[i]) == 0)
        //                 res += j-i;
        //         }
        //     }
        //     return res;
        // }

        // public int[] singleNumber(int[] nums) {
        //     int n = nums.length;
        //     int [] pre = new int[n+1];
        //     for (int i = 0; i < n; i++) 
        //         pre[i+1] = pre[i] ^ nums[i];
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if ((nums[i] ^ nums[j]) == pre[n])
        //                 return new int [] {nums[i], nums[j]};
        //         }
        //     }
        //     return new int[0];
        // }


        // public int findDuplicate(int[] nums) {
        //     int n = nums.length;
        //     if (n == 2) return nums[0];
        //     int [] pre = new int[n+1];
        //     int stt = 0;
        //     for (int i = 0; i < n; i++) {
        //         pre[i+1] = pre[i] ^ nums[i];
        //         if (i != n-1)
        //             stt ^= i+1;
        //     }
        //     return stt ^ pre[n];
        // }


        // public int kthLargestValue(int[][] matrix, int k) {
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int [][] arr = new int [m][n];
        //     arr[0][0] = matrix[0][0];
        //     for (int j = 1; j < n; j++) 
        //         arr[0][j] = matrix[0][j] ^ arr[0][j-1];
        //     for (int i = 1; i < m; i++) 
        //         arr[i][0] = matrix[i][0] ^ arr[i-1][0];
        //     for (int i = 1; i < m; i++) 
        //         for (int j = 1; j < n; j++) 
        //             arr[i][j] = arr[i-1][j-1] ^ arr[i-1][j] ^ arr[i][j-1] ^ matrix[i][j]; 
        //     int [] ans = new int [m*n];
        //     int idx = 0;
        //     for (int i = 0; i < m; i++) 
        //         System.arraycopy(arr[i], 0, ans, idx + n*i, n);
        //     Arrays.sort(ans);
        //     return ans[n*m-k];
        // }


        // public int minFlips(int a, int b, int c) {
        //     int cnt = 0;
        //     while (c > 0) {
        //         System.out.println("(c|0): " + (c|0));
        //         if ((c | 0) == 0) { // 0 想得不对，值或0结果不对
        //             if ((a | 0) == 0 || (b|0) == 0)
        //                 cnt += ((a|0) == 0 && (b|0) == 0 ? 0 : 1);
        //             else  cnt += 2;
        //         } else {
        //             if ((a|0) == 0 && (b|0) == 0) cnt += 1;
        //         }
        //         c >>= 1;
        //         a >>= 1;
        //         b >>= 1;
        //         System.out.println("cnt: " + cnt);
        //     }
        //     while (a > 0 || b > 0) {
        //         while (a > 0 && b > 0) {
        //             if ((a|0) == 1 || (b|0) == 1)  {
        //                 if ((a|0) == 1 && (b|0) == 1)
        //                     cnt += 2;
        //                 else cnt += 1;
        //             }
        //             a >>= 1;
        //             b >>= 1;
        //         }
        //         a = Math.max(a, b);
        //         while (a > 0) {
        //             if ((a | 0) == 1) cnt += 1;
        //             a >>= 1;
        //         }
        //     }
        //     return cnt;
        // }


        // public int findDuplicate(int[] nums) {
        //     int slow = nums[0];
        //     int fast = nums[nums[0]];
        //     while (slow != fast) {
        //         slow = nums[slow];
        //         fast = nums[nums[fast]];
        //     }
        //     fast = 0;
        //     while (slow != fast) {
        //         slow = nums[slow];
        //         fast = nums[fast];
        //     }
        //     return slow;
        // }


        // public int maxProduct(String[] words) {
        //     int n = words.length;
        //     int [] arr = new int [n];
        //     int cur = 0;
        //     for (int i = 0; i < n; i++) {
        //         cur = 0;
        //         for (int j = 0; j < words[i].length(); j++) 
        //             cur |= (1 << words[i].charAt(j)-'a');
        //         arr[i] = cur;
        //     }
        //     int max = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             if ((arr[i] & arr[j]) == 0)
        //                 max = Math.max(max, words[i].length() * words[j].length());
        //     return max;
        // }
        

        // private long power(int n) {
        //     long res = 1, m = 2;
        //     while (n != 0) {
        //         if ((n & 1) == 1) res = res * m % mod;
        //         m = m * m % mod;
        //         n >>= 1;
        //     }
        //     return res;
        // }
        // int mod = (int)1e9 + 7;
        // public int concatenatedBinary(int n) {
        //     int [] len = new int [n+1];
        //     for (int i = 1; i <= n; i++)
        //         len[i] = Integer.toBinaryString(i).length();
        //     for (int i = n-1; i >= 1; i--) 
        //         len[i] += len[i+1];
        //     long res = n;
        //     for (int i = n-1; i >= 1; i--) 
        //         res = (res + i * (long)power(len[i+1]) % mod) % mod;
        //     return (int)res;
        // }

        // public int totalHammingDistance(int[] arr) {
        //     int n = arr.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) 
        //             cnt += Integer.countBit(a ^ b);
        //     return cnt;
        // }

        // private String add(String s) {
        //     int n = s.length();
        //     if (s.charAt(n-1) == '0')
        //         return s.substring(0, n-1) + "1";
        //     int j = n-2;
        //     while (j >= 0 && s.charAt(j) == '1') --j;
        //     if (j < 0) return "1" + "0".repeat(n);
        //     return s.substring(0, j) + "1" + (j == n-1 ? "" : s.substring(j+1));
        // }
        // public int numSteps(String s) {
        //     int cnt = 0;
        //     while (s.length() > 1) {
        //         if (((s.charAt(s.length()-1)-'0') & 1) == 0) 
        //             s = s.substring(0, s.length()-1);
        //         else s = add(s);
        //         ++cnt;
        //     }
        //     if (s.charAt(0) == '0') return cnt + 1;
        //     return cnt;
        // }

        
        // public int rangeBitwiseAnd(int left, int right) {
        //     int ans = left;
        //     for (int i = left+1; i <= right; i++) 
        //         ans &= i;
        //     return ans;
        // }


        // public int maxNumberOfFamilies(int n, int[][] reservedSeats) { // memory limit exceeded: last 6 test cases !!!
        //     Arrays.sort(reservedSeats, (a, b) -> (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));
        //     int [] arr = new int [n];
        //     int idx = 0, i = 0, cur = reservedSeats[i][0], mask = 0;
        //     while (i < reservedSeats.length) {
        //         mask = 0;
        //         while (i < reservedSeats.length && reservedSeats[i][0] == cur) {
        //             mask |= (1 << (reservedSeats[i][1]-1));
        //             ++i;
        //         }
        //         arr[idx++] = mask;
        //         if (i < reservedSeats.length)
        //             cur = reservedSeats[i][0];
        //     }
        //     int mtwo = 0b0111111110;
        //     int [] masks = {0b0000011110, 0b0111100000, 0b0001111000};
        //     int res = 0;
        //     for ( i = 0; i < n; i++) {
        //         if (arr[i] > 0) {
        //             if ((arr[i] & mtwo) == 0) res += 2;
        //             else if ((arr[i] & masks[0]) == 0 || (arr[i] & masks[1]) == 0 || (arr[i] & masks[2]) == 0) res += 1;
        //         } else res += 2;
        //     }
        //     return res;
        // }
        // public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int[] seat : reservedSeats) 
        //         map.put(seat[0], map.getOrDefault(seat[0], 0) | 1 << (10 - seat[1]));
        //     int res = (n - map.size()) * 2;;
        //     for (int row : map.keySet()) {
        //         int seats = map.get(row);
        //         if ((seats & 0b0111111110) == 0)
        //             res += 2;
        //         else if ((seats & 0b0111100000) == 0 || (seats & 0b0001111000) == 0 || (seats & 0b0000011110) == 0)
        //             res += 1;
        //     }
        //     return res;
        // }


        // public int minFlips(int a, int b, int c) { 
        //     a |= b; // 想得不对，a b 的每个位都需要处理
        //     int cnt = 0;
        //     while (a > 0 && c > 0) {
        //         if ((a & b & 1) == 0) { // a & b == 0
        //             if ((a ^ b ^ 0) == 1) // a ^ b == 1
        //                 ++cnt;
        //         }
        //         a >>= 1;
        //         c >>= 1;
        //     }
        //     cnt += a > 0 ? Integer.bitCount(a) : Integer.bitCount(c);
        //     return cnt;
        // }
 
          
        // public int getSum(int a, int b) {
        //     if (b == 0) return a;
        //     int sum = a ^ b;
        //     int carry = (a & b) << 1;
        //     return getSum(sum, carry);
        // }
        // public int getSum(int a, int b) { 
        //     if (b == 0) return a;
        //     int carryOver = 0;
        //     while (b != 0) { // while (b > 0) (-1, 1) 过不了
        //         carryOver = (a & b);
        //         a = a ^ b;
        //         b = (carryOver << 1);
        //     }
        //     return a;
        // }


        // public int rangeBitwiseAnd(int left, int right) {
        //     if (left == 0) return 0;
        //     if (left == 1 && right == Integer.MAX_VALUE) return 0;
        //     if (Integer.toBinaryString(left).length() != Integer.toBinaryString(right).length()) return 0;
        //     if (left == right) return left;
        //     int ans = left;
        //     for (int i = left+1; i <= right; i++) {
        //         ans &= i;
        //         if (ans == 0 || i == Integer.MAX_VALUE) return ans;
        //     }
        //     return ans;
        // }


        // public boolean hasAllCodes(String s, int k) { 
        //     int n = s.length();
        //     if (k > n) return false;
        //     StringBuilder sb = new StringBuilder(s.substring(0, k));
        //     Set<String> set = new HashSet<>();
        //     set.add(sb.toString());
        //     for (int i = k; i < n; i++) {
        //         sb.deleteCharAt(0).append(s.charAt(i));
        //         set.add(sb.toString());
        //     }
        //     return set.size() == (1 << k);
        // }
        // public boolean hasAllCodes(String s, int k) { 
        //     int n = s.length();
        //     if (k > n) return false;
        //     Set<String> set = new HashSet<>();
        //     for (int i = 0; i <= n-k; i++) 
        //         set.add(s.substring(i, i+k));
        //     return set.size() == (1 << k);
        // }


        // private boolean isValid(int [] arr, int val) {
        //     int pre = -1;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if (((val >> i) & 1) == 1) {
        //             if (pre == -1) pre = arr[i];
        //             else if (arr[i] < pre) return false;
        //             l.add(arr[i]);
        //         }
        //     }
        //     if (!res.contains(l)) res.add(l);
        //     return true;
        // }
        // private void generatgSequence(int [] arr, int v) {
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         if (((v >> i) & 1) == 1) 
        //             l.add(arr[i]);
        //     if (!res.contains(l)) res.add(l);
        // }
        // List<List<Integer>> res = new ArrayList<>();
        // int n;
        // public List<List<Integer>> findSubsequences(int[] arr) {
        //     n = arr.length;
        //     int [] sort = arr.clone();
        //     Arrays.sort(sort);
        //     if (Arrays.equals(arr, sort)) {
        //         for (int i = 1; i < (1<<n); i++) {
        //             if (Integer.bitCount(i) == 1) continue;
        //             generatgSequence(arr, i);
        //         }
        //         return res;
        //     }
        //     boolean [] vis = new boolean [1<<n];
        //     for (int i = 1; i < 1<<n; i++) {
        //         if (Integer.bitCount(i) == 1) continue;
        //         isValid(arr, i);
        //     }
        //     return res;
        // }


        // private void dfs(int [] arr, int idx, List<Integer> l) {
        //     if (l.size() >= 2)
        //         res.add(new ArrayList<>(l));
        //     Set<Integer> vis = new HashSet<>();
        //     for (int i = idx; i < arr.length; i++) {
        //         if (vis.contains(arr[i])) continue;
        //         if (l.size() == 0 || arr[i] >= l.get(l.size()-1)) {
        //             vis.add(arr[i]);
        //             l.add(arr[i]);
        //             dfs(arr, i+1, l);
        //             l.remove(l.size()-1);
        //         }
        //     }
        // }
        // List<List<Integer>> res = new ArrayList<>();
        // public List<List<Integer>> findSubsequences(int[] arr) {
        //     if (arr == null || arr.length == 0) return res;
        //     dfs(arr, 0, new ArrayList<Integer>());
        //     return res;
        // }


        // // Think about (a&b) ^ (a&c). Can you simplify this expression?
        // // It is equal to a&(b^c).
        // // Then, (arr1[i]&arr2[0])^(arr1[i]&arr2[1]).. = arr1[i]&(arr2[0]^arr2[1]^arr[2]...).
        // // Let arr2XorSum = (arr2[0]^arr2[1]^arr2[2]...),
        // // arr1XorSum = (arr1[0]^arr1[1]^arr1[2]...) so the final answer is
        // // (arr2XorSum&arr1[0]) ^ (arr2XorSum&arr1[1]) ^ (arr2XorSum&arr1[2]) ^ ... = arr2XorSum & arr1XorSum.
        // public int getXORSum(int[] a, int[] b) {
        //     int m = a.length;
        //     int n = b.length;
        //     int aXorSum = a[0], bXorSum = b[0];
        //     for (int i = 1; i < m; i++) 
        //         aXorSum ^= a[i];
        //     for (int i = 1; i < n; i++) 
        //         bXorSum ^= b[i];
        //     return aXorSum & bXorSum;
        // }


        // //  ‘平生不识 TwoSum，刷尽 LeetCode 也枉然’ 还好不至于哭死呀。。。。。。
        // public int countTriplets(int[] arr) { 
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int v = 0, res = 0;
        //     for (int i = 0; i < arr.length; i++) 
        //         for (int j = 0; j < arr.length; j++) {
        //             v = arr[i] & arr[j];
        //             m.put(v, m.getOrDefault(v, 0) + 1);
        //         }
        //     for (int i = 0; i < arr.length; i++) 
        //         for (int k : m.keySet()) 
        //             if ((arr[i] &  k) == 0) res += m.get(k);
        //     return res;
        // }
        // public int countTriplets(int[] arr) { // 这种方法执行起来效率更高一点儿
        //     int res = 0, v = 0;
        //     int [] cnt = new int [1 << 16];
        //     Arrays.fill(cnt, -1);
        //     for (int a : arr) 
        //         for (int b : arr) {
        //             v = a & b;
        //             if (cnt[v] == -1) {
        //                 cnt[v] = 0;
        //                 for (int c : arr) 
        //                     if ((v & c) == 0) ++cnt[v];
        //             }
        //             res += cnt[v];
        //         }
        //     return res;
        // }


        // public int maximumRequests(int n, int[][] requests) {
        //     int m = requests.length, range = 1 << m;
        //     Map<Integer, Integer> mfrom = new HashMap<>(); // from
        //     Map<Integer, Integer> mto = new HashMap<>();   // to
        //     int cur = 0, max = 0;
        //     boolean invalid = false;
        //     for (int i = 1; i < range; i++) {
        //         invalid = false;
        //         cur = i;
        //         mfrom.clear();
        //         mto.clear();
        //         for (int j = 0; j < m; j++) 
        //             if (((cur >> j) & 1) == 1) {
        //                 mfrom.put(requests[j][0], mfrom.getOrDefault(requests[j][0], 0) + 1);
        //                 mto.put(requests[j][1], mto.getOrDefault(requests[j][1], 0) + 1);
        //             }
        //         if (mfrom.size() != mto.size()) continue;
        //         for (int k : mfrom.keySet()) {
        //             if (!mto.containsKey(k) || mto.get(k) != mfrom.get(k)) {
        //                 invalid = true;
        //                 break;
        //             }
        //         }
        //         if (!invalid) max = Math.max(max, Integer.bitCount(i));
        //     }
        //     return max;
        // }


        // public int findMaximumXOR(int[] nums) {
        //     int n = nums.length;
        //     int mask = 0, max = 0;
        //     HashSet<Integer> s = new HashSet<>();
        //     for (int i = 31; i >= 0; --i) { // i == 31
        //         mask = mask | 1 << i;
        //         for (int va : nums) 
        //             s.add(va & mask);
        //         int tmp = max | (1 << i);
        //         for (Integer va : s) {
        //             if (s.contains(va ^ tmp)) {
        //                 max = tmp;
        //                 break;
        //             }
        //         }
        //         s.clear();
        //     }
        //     return max;
        // }


        // // 不管是backTracking or dp，这个题的思路都还不够清楚
        // private void backTracking(int [] arr, int idx) { // traversal hats ids
        //     if (idx == l.size()) {
        //         // how to get result
        //         return;
        //     }
        //     for (int i = 0; i < n; i++) { // backtracking people
        //     }
        // }
        // List<Integer> l = new ArrayList<>(); // hats ids
        // int n, res = 0, mod = (int)1e9 + 7;
        // public int numberWays(List<List<Integer>> hats) {
        //     n = hats.size();
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         s.addAll(hats.get(i));
        //     for (Integer v : s) l.add(v);
        // }


        // public int findTheLongestSubstring(String s) { 
        //     int n = s.length(), idx, mask = 0, max = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     String vo = "aeiou";
        //     for (int i = 0; i < n; i++) {
        //         idx = vo.indexOf(s.charAt(i)); 
        //         if (idx != -1) mask ^= (1 << idx);
        //         if (mask == 0) max = i+1;
        //         if (m.containsKey(mask))
        //             max = Math.max(max, i-m.get(mask));
        //         else m.put(mask, i);
        //     }
        //     return max;
        // }

        
        // private int dfsBackTracking(int [] cnt, int batchSize, int lastGroup, int leftOverGroups) { // DFS+记忆化搜索求最多开心组数
        //     if (leftOverGroups == 0) return 0;
        //     String key = Arrays.toString(cnt); // 剩余组情况生成String作为哈希表的键, this is so called HASHING
        //     if (dp.containsKey(key)) return dp.get(key);
        //     int res = 0;
        //     for (int i = 1; i < batchSize; i++) {
        //         if (cnt[i] == 0) continue;
        //         --cnt[i]; 
        //         res = Math.max(res, dfsBackTracking(cnt, batchSize, lastGroup+i, leftOverGroups-1) + (lastGroup % batchSize == 0 ? 1 : 0));
        //         ++cnt[i]; 
        //     }
        //     dp.put(key, res);
        //     return res;
        // }
        // Map<String, Integer> dp;
        // int n;
        // public int maxHappyGroups(int batchSize, int[] groups) { // group size 30 is too large for backtracking WITHOUT modifications
        //     n = groups.length;
        //     int [] cnt = new int [batchSize];
        //     for (int v : groups) 
        //         cnt[v % batchSize]++;
        //     dp = new HashMap<>();
        //     return dfsBackTracking(cnt, batchSize, 0, n-cnt[0]) + cnt[0];
        // }
        // private int dfsBackTracking(int [] cnt, int batchSize, int lastGroup, int leftOverGroups) { // DFS+记忆化搜索求最多开心组数
        //     if (leftOverGroups == 0) return 0;
        //     String key = Arrays.toString(cnt); // 剩余组情况生成String作为哈希表的键, this is so called HASHING
        //     if (dp.containsKey(key)) return dp.get(key);
        //     int res = 0;
        //     for (int i = 1; i < batchSize; i++) {
        //         if (cnt[i] == 0) continue;
        //         --cnt[i]; 
        //         res = Math.max(res, dfsBackTracking(cnt, batchSize, lastGroup+i, leftOverGroups-1) + (lastGroup % batchSize == 0 ? 1 : 0));
        //         ++cnt[i]; 
        //     }
        //     dp.put(key, res);
        //     return res;
        // }
        // Map<String, Integer> dp;
        // int n;
        // public int maxHappyGroups(int batchSize, int[] groups) { // group size 30 is too large for backtracking WITHOUT modifications
        //     n = groups.length;
        //     int [] cnt = new int [batchSize];
        //     for (int v : groups) 
        //         cnt[v % batchSize]++;
        //     // take out the 2 remainder's min groups if their sum is batchSize.
        //     // it still works but slow without this step
        //     // Note: < batchSize / 2 to avoid when i is batchSize / 2 it will subtract itself
        //     int res = cnt[0], min = 0;
        //     for (int i = 1; i < batchSize/2; i++) {
        //         min = Math.min(cnt[i], cnt[batchSize-i]);
        //         cnt[i] -= min;
        //         cnt[batchSize-i] -= min;
        //         res += min;
        //     }
        //     dp = new HashMap<>();
        //     return res + dfsBackTracking(cnt, batchSize, 0, n-cnt[0]);
        // }
        // public int maxHappyGroups(int batchSize, int[] groups) { // TLE
        //     int n = groups.length;
        //     int [] dp = new int [1 << n];
        //     int s = 0;
        //     for (int mask = 0; mask < 1 << n; mask++) { 
        //         s = 0;
        //         for (int i = 0; i < n; i++) 
        //             if ((mask & (1 << i)) >= 1)
        //                 s = (s + groups[i]) % batchSize;
        //         for (int i = 0; i < n; i++) 
        //             if ((mask & (1 << i)) == 0)
        //                 dp[mask | (1<<i)] = Math.max(dp[mask | (1<<i)], dp[mask] + (s == 0 ? 1 : 0));
        //     }            
        //     return dp[(1 << n) -1];
        // }
        // private int dfsBackTracking(int [] cnt, int batchSize, int s) { // DFS+记忆化搜索
        //     String key = Arrays.toString(cnt); 
        //     if (dp.containsKey(key)) return dp.get(key);
        //     int res = 0;
        //     for (int i = 1; i < batchSize; i++) {
        //         if (cnt[i] == 0) continue;
        //         --cnt[i]; 
        //         res = Math.max(res, dfsBackTracking(cnt, batchSize, (s+i) % batchSize) + (s == 0 ? 1 : 0));
        //         ++cnt[i]; 
        //     }
        //     dp.put(key, res);
        //     return res;
        // }
        // Map<String, Integer> dp;
        // int n;
        // public int maxHappyGroups(int batchSize, int[] groups) { 
        //     n = groups.length;
        //     int [] cnt = new int [batchSize];
        //     for (int v : groups) 
        //         cnt[v % batchSize]++;
        //     int res = cnt[0], min = 0;
        //     for (int i = 1; i < batchSize/2; i++) {
        //         min = Math.min(cnt[i], cnt[batchSize-i]);
        //         cnt[i] -= min;
        //         cnt[batchSize-i] -= min;
        //         res += min;
        //     }
        //     dp = new HashMap<>();
        //     return res + dfsBackTracking(cnt, batchSize, 0);
        // }


        // public List<String> findRepeatedDnaSequences(String s) {
        //     List<String> res = new ArrayList<>();
        //     int n = s.length();
        //     for (int i = 0; i+10 <= n; i++) {
        //         String left = s.substring(i, i+10);
        //         for (int j = i+1; j+10 <= n; j++) {
        //             String right = s.substring(j, j+10);
        //             if (left.equals(right) && !res.contains(left)) res.add(left);
        //         }
        //     }
        //     return res;
        // }


        // private static int hashCode(String s) {
        //     int hash = 0;
        //     for (int i = 0; i < s.length(); i++) 
        //         hash = hash << 2 | mapInteger(s.charAt(i));
        //     return hash;
        // }
        // private static int mapInteger(char c) {
        //     switch (c) {
        //     case 'A': return 0;
        //     case 'C': return 1;
        //     case 'G': return 2;
        //     case 'T': return 3;
        //     default: return 0;
        //     }
        // }
        // public List<String> findRepeatedDnaSequences(String s) {
        //     List<String> res = new ArrayList<>();
        //     if (s == null || s.length() == 0) return res;
        //     Set<Integer> si = new HashSet<>();
        //     for (int i = 0; i <= s.length()-10; i++) {
        //         String substr = s.substring(i, i+10);
        //         Integer key = hashCode(substr);
        //         if (si.contains(key) && !res.contains(substr))
        //             res.add(substr);
        //         else si.add(key);
        //     }
        //     return res;
        // }


        // public int[] decode(int[] encoded) {
        //     int n = encoded.length + 1;
        //     int xor = 0, vFrom2 = 0;
        //     for (int i = 1; i < n-1; i += 2) //记录第2到n个数的异或值
        //         vFrom2 = vFrom2 ^ encoded[i]; // (a[1]^a[2])^(a[3]^a[4])^...^(a[n-2]^a[n-1])
        //     for (int i = 1; i <= n; i++)      // a[0]^a[1]^a[2]^...^a[n-1]
        //         xor ^= i;
        //     int [] arr = new int [n];
        //     arr[0] = xor ^ vFrom2;
        //     for (int i = 1; i < n; i ++)
        //         arr[i] = arr[i-1] ^ encoded[i-1];
        //     return ans;
        // }


        // public int[] prisonAfterNDays(int[] arr, int n) {
        //     int m = 8, cnt = 0;
        //     int [] tmp = arr.clone();
        //     while (cnt < (n % 14 == 0 ? 14 : n % 14)) { // 应该是找到某个重复的规律，今天不想再看这题了
        //         Arrays.fill(tmp, 0);
        //         for (int i = 1; i < m-1; i++) 
        //             tmp[i] = 1- (arr[i-1] ^ arr[i+1]);
        //         arr = tmp.clone();
        //         ++cnt;
        //     }
        //     return arr;
        // }
        // public int[] prisonAfterNDays(int[] cells, int N) {
        //     HashMap<Integer, Integer> seen = new HashMap<>();
        //     boolean isFastForwarded = false;
        //     // step 1). convert the cells to bitmap
        //     int stateBitmap = 0x0;
        //     for (int cell : cells) {
        //         stateBitmap <<= 1;
        //         stateBitmap = (stateBitmap | cell);
        //     }
        //     // step 2). run the simulation with hashmap
        //     while (N > 0) {
        //         if (!isFastForwarded) {
        //             if (seen.containsKey(stateBitmap)) {
        //                 // the length of the cycle is seen[state_key] - N
        //                 N %= seen.get(stateBitmap) - N;
        //                 isFastForwarded = true;
        //             } else
        //                 seen.put(stateBitmap, N);
        //         }
        //         // check if there is still some steps remained,
        //         // with or without the fast forwarding.
        //         if (N > 0) {
        //             N -= 1;
        //             stateBitmap = this.nextDay(stateBitmap);
        //         }
        //     }
        //     // step 3). convert the bitmap back to the state cells
        //     int ret[] = new int[cells.length];
        //     for (int i = cells.length - 1; i >= 0; i--) {
        //         ret[i] = (stateBitmap & 0x1);
        //         stateBitmap = stateBitmap >> 1;
        //     }
        //     return ret;
        // }
        // protected int nextDay(int stateBitmap) {
        //     stateBitmap = ~(stateBitmap << 1) ^ (stateBitmap >> 1);
        //     // set the head and tail to zero
        //     stateBitmap = stateBitmap & 0x7e;
        //     return stateBitmap;
        // }

        
        // public long wonderfulSubstrings(String word) {
        //     int n = word.length(), mask = 0, cur = 0;
        //     long res = 0, cnt = 0;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(0, 1);
        //     for (int i = 0; i < n; i++) {
        //         mask ^= (1 << (word.charAt(i)-'a'));
        //         res += m.getOrDefault(mask, 0);
        //         m.put(mask, m.getOrDefault(mask, 0) + 1);
        //         for (int j = 0; j < 10; j++) {
        //             cur = mask ^ (1 << j);
        //             res += m.getOrDefault(cur, 0);
        //         }
        //     }
        //     return res;
        // }
        // public long wonderfulSubstrings(String word) {
        //     long [] hashMap = new long[1 << 'j'-'a'+1];  //store count of all faced bitmask combinations from 0b0000000000 to 0b1111111111
        //     long res = 0;
        //     int bitMask = 0;
        //     hashMap[0]=1;
        //     for(char ch : word.toCharArray()){
        //         bitMask ^= 1 << ch-'a'; //reverse corresponding bit with respect to the faced character
        //         //if we faced  the same bitmask once, that means substring between prev. bitmask and curr. bitmask contains only even number of changes for all characters 'a' through 'j'
        //         //if we faced the same bitmask two or more times, then let's add all substrings started in prev. occurrences and finished at curr. occurrence
        //         //finally, increment bitmask we have just faced
        //         res += hashMap[bitMask]++;  
        //         //in the same manner, check all faced occurrences of bitmasks with just one odd bit difference
        //         //and count corresponding substrings started there and finished with current bitmask
        //         for(char c = 'a';c< = 'j';c++)
        //             res += hashMap[bitMask ^ 1 << c-'a'];
        //     }
        //     return res;
        // }


        // private String dfs(int n) {
        //     if (n == 1) return "0";
        //     if (n <= 3) return "01";
        //     if (dp[n] != null) return dp[n];
        //     String pre = dfs(n-1);
        //     StringBuilder s = new StringBuilder();
        //     for (int i = 0; i < pre.length(); i++) {
        //         if (pre.charAt(i) == '0') {
        //             s.append('0');
        //             s.append('1');
        //         } else {
        //             s.append('1');
        //             s.append('0');
        //         }
        //     }
        //     return dp[n] = s.toString();
        // }
        // String [] dp;
        // public int kthGrammar(int n, int k) {
        //     dp = new String [n+1];
        //     String tmp = dfs(n);
        //     if (k <= tmp.length()) return tmp.charAt(k-1)-'0';
        //     else return 1 - (tmp.charAt(k - tmp.length()-1)-'0');
        // }
        // 基本可以看出规律了：每一行前面一半是和上一行完全一样的，后一半是和上一行完全相反的。
        // 所以，求解的方法就是计算第K个数是在第N行的前面一半还是后面一半，计算方式是K和2^(N - 2)比较，即K <= (1 << (N - 2))。如果在前半部分，那么在上一行中寻找第K个数；如果在后半部分，那么在上一行中寻找第K - (1 << (N - 2))个数。
        //     用递归实现的终止条件是当K == 1，或者N == 1，返回0.
        //     时间复杂度是O(N)，空间复杂度是O(1)的变量空间，O(N)的栈空间.
        // public int kthGrammar(int n, int k) {
        //     if (k == 1) return 0;
        //     if (k <= (1 << (n-2)))
        //         return kthGrammar(n-1, k);
        //     else return 1 - kthGrammar(n-1, k-(1 << (n-2)));
        // }


        // public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //     int n = s.length();
        //     int m = queries.length, mask = 0, cnt = 0;
        //     int [] arr = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         mask ^= (1 << s.charAt(i)-'a');
        //         arr[i] = mask;
        //     }
        //     List<Boolean> ans = new ArrayList<>();
        //     for (int i = 0; i < m; i++) {
        //         cnt = Integer.bitCount(arr[queries[i][1]] ^ (queries[i][0] == 0 ? 0 : arr[queries[i][0]-1]));
        //         ans.add(cnt == 1 ? true : cnt / 2 <= queries[i][2]); // bug: 只有一位奇数的特殊情况需要考虑到
        //     }
        //     return ans;
        // }


        // private static int hashCode(String s) {
        //     int hash = 0;
        //     for (int i = 0; i < s.length(); i++)
        //         hash = hash << 3 | mapInteger(s.charAt(i));
        //     return hash;
        // }
        // private static int mapInteger(char c) {
        //     switch (c) {
        //     case 'A': return 1;
        //     case 'B': return 2;
        //     case 'C': return 3;
        //     case 'D': return 4;
        //     case 'E': return 5;
        //     case 'F': return 6;
        //     default: return 0;
        //     }
        // }
        // private void generateLayerMask(List<Set<Integer>> ll, int idx, int v, Set<Integer> next) {
        //     if (idx == ll.size()) {
        //         next.add(v);
        //         return;
        //     }
        //     if (idx > 0) v <<= 3;
        //     for (Integer val : ll.get(idx)) {
        //         v |= val;
        //         generateLayerMask(ll, idx+1, v, next);
        //         v ^= val;
        //     }
        // }
        // private boolean dfs(int v) {
        //     if (dp.containsKey(v)) return dp.get(v);
        //     if (v <= 6) return true;
        //     List<Integer> l = new ArrayList<>();
        //     int cur = v;
        //     while (cur > 0) {
        //         l.add(0, cur & ((1 << 3)-1));
        //         cur >>= 3;
        //     }
        //     int bottom = l.get(0), mask = 0;
        //     List<Set<Integer>> ll = new ArrayList<>();
        //     for (int i = 0; i < l.size()-1; i++) 
        //         ll.add(new HashSet<Integer>());
        //     for (int i = 1; i < l.size(); i++) {
        //         bottom <<= 3;
        //         bottom |= l.get(i);
        //         if (map.containsKey(bottom))
        //             ll.get(i-1).addAll(map.get(bottom));
        //         bottom = l.get(i);
        //     }
        //     for (int i = 0; i < ll.size(); i++) 
        //         if (ll.get(i).size() == 0) {
        //             dp.put(v, false);
        //             return false;
        //         }
        //     Set<Integer> next = new HashSet<>();
        //     generateLayerMask(ll, 0, 0, next);
        //     if (next.size() == 0) {
        //         dp.put(v, false);
        //         return false;
        //     }
        //     for (Integer val : next) {
        //         if (dfs(val)) {
        //             dp.put(v, true);
        //             return true;
        //         }
        //     }
        //     dp.put(v, false);
        //     return false;
        // }
        // Map<Integer, List<Integer>> map = new HashMap<>();
        // Map<Integer, Boolean> dp = new HashMap<>();
        // public boolean pyramidTransition(String bottom, List<String> allowed) {
        //     int hash = 0;
        //     for (int i = 0; i < allowed.size(); i++) {
        //         hash = hashCode(allowed.get(i).substring(0, 2));
        //         map.computeIfAbsent(hash, k -> new ArrayList<>());
        //         map.get(hash).add(mapInteger(allowed.get(i).charAt(2)));
        //     }
        //     return dfs(hashCode(bottom));
        // }


        // public class Trie {
        //     boolean isVal;
        //     Trie [] next;
        //     public Trie() {
        //         this.isVal = false;
        //         this.next = new Trie[2];
        //     }
        // }
        // public void insert(int va) {
        //     Trie cur = root;
        //     for (int i = 31; i >= 0; i--) {
        //         int tmp = (va >> i) & 1;
        //         if (cur.next[tmp] == null)
        //             cur.next[tmp] = new Trie();
        //         cur = cur.next[tmp];
        //     }
        //     cur.isVal = true;
        // }
        // public int search(int va) {
        //     int max = 0;
        //     Trie cur = root;
        //     for (int i = 31; i >= 0; i--) {
        //         int t = (va >> i) & 1;
        //         if (cur == null) return -1;
        //         if (cur.next[t^1] != null) {
        //             max += (1 << i);
        //             cur = cur.next[t^1];
        //         } else
        //             cur = cur.next[t&1];
        //     }
        //     return max;
        // }
        // private Trie root;
        // public int[] maximizeXor(int[] nums, int [][] queries) {
        //     Arrays.sort(nums);
        //     List<List<Integer>> list = new ArrayList<>();
        //     for (int i = 0; i < queries.length; i++)
        //         list.add(List.of(i, queries[i][0], queries[i][1]));
        //     Collections.sort(list, (a, b) -> (a.get(2) - b.get(2)));
        //     int [] arr = new int[queries.length];
        //     int preIdx = 0;
        //     root = new Trie();
        //     for (int i = 0; i < list.size(); i++) {
        //         for (int j = preIdx; j < nums.length; j++) {
        //             if (nums[j] > list.get(i).get(2)) {
        //                 preIdx = j;
        //                 break;
        //             }
        //             insert(nums[j]);
        //         }
        //         arr[list.get(i).get(0)] = search(list.get(i).get(1));
        //     }
        //     return arr;
        // }


        // 可以从根节点开始，对整棵树进行一次深度优先遍历，即：
        // 当我们第一次遍历到某一节点 ii 时，我们将 ii 放入「数据结构」中；
        // 当我们遍历完所有节点 ii 的子节点，即将回溯到 ii 的父节点前，我们将 ii 从「数据结构」中移除。
        // 这样一来，我们就可以通过「离线」的思想将每一个询问在遍历到节点 \textit{val}_ival 时进行求解。这是因为，如果当前正在遍历节点 \textit{val}_ival
        // 那么数据结构中就存放着所有从根节点到节点 \textit{val}_ival 的路径上的所有节点。
        // 此时，我们只需要找出数据结构中使得 p_i \oplus \textit{val}_ip 达到最大值的节点 p_ip 即可。
        // 而深度优先搜索过程中，当前入队的部分正是该节点及其所有层级的父节点，因此可结合 DFS 方法进行离线搜索。
        // 对最大异或值的计算，可结合字典树方法进行。
        // 本题需涉及对字典树中数值的删除操作，为简化代码，可在字典树的节点中设计一个计数器，记录当前该节点对应的数字个数，从而避免删除实际节点。
        // public class Trie {
        //     static final int H = 18; // 树高度，本题val<=2*10^5<2^18
        //     Trie [] next;
        //     int cnt;                 // 当前节点对应的数值个数，简化删除操作
        //     public Trie() {
        //         this.next = new Trie[2];
        //         this.cnt = 0;
        //     }
        //     public void insert(int va) { // 插入数值
        //         Trie r = this;
        //         for (int i = H-1; i >= 0; i--) {
        //             int bit = (va >> i) & 1;
        //             if (r.next[bit] == null) 
        //                 r.next[bit] = new Trie();
        //             r = r.next[bit];
        //             r.cnt++;
        //         }
        //     }
        //     private void removeVal(int v) { // 删除数值
        //         Trie r = this;
        //         for (int i = H-1; i >= 0; i--) {
        //             int bit = (v >> i) & 1;
        //             r = r.next[bit];
        //             r.cnt--;
        //         }
        //     }
        //     public int search(int va) { // 针对数值查询当前字典树对应的最大异或值
        //         Trie r = this;
        //         int max = 0;
        //         for (int i = H-1; i >= 0; i--) {
        //             int bit = (va >> i) & 1 ^ 1;
        //             if (r == null) return -1;
        //             if (r.next[bit] != null && r.next[bit].cnt > 0) {
        //                 max += (1 << i);
        //                 r = r.next[bit];
        //             } else
        //                 r = r.next[bit ^ 1];
        //         }
        //         return max;
        //     }
        // }
        // private void dfs(int idx) { // 深度优先搜索
        //     trie.insert(idx);       // 当前节点加入字典树
        //     if (queVal.containsKey(idx)) // 处理针对当前节点的查询
        //         for (int i = 0; i < queVal.get(idx).size(); i++) 
        //             ans[queId.get(idx).get(i)] = trie.search(queVal.get(idx).get(i));
        //     if (tree.containsKey(idx))   // 当前节点存在子节点
        //         for (int n : tree.get(idx)) 
        //             dfs(n);
        //     trie.removeVal(idx);         // 从字典树中删除当前节点
        // }
        // Map<Integer, List<Integer>> tree;  // 树中各个节点对应的子节点
        // Map<Integer, List<Integer>> queVal;// 树中各个节点对应的查询值
        // Map<Integer, List<Integer>> queId; // 树中各个节点对应的queries下标
        // Trie trie;                         // 字典树根节点
        // int [] ans;
        // public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        //     int n = parents.length, m = queries.length, root = -1;
        //     this.tree = new HashMap<>();
        //     for (int i = 0; i < n; i++) { // 记录树中各个节点对应的子节点
        //         if (parents[i] != -1) {   // Note: 当作有向树图来处理 !!!
        //             tree.computeIfAbsent(parents[i], k -> new ArrayList<>());
        //             tree.get(parents[i]).add(i);
        //         } else root = i;  
        //     }
        //     this.queVal = new HashMap<>();
        //     this.queId = new HashMap<>();
        //     for (int i = 0; i < m; i++) {
        //         int nid = queries[i][0], val = queries[i][1];
        //         queVal.computeIfAbsent(nid, k -> new ArrayList<>());
        //         queId.computeIfAbsent(nid, k -> new ArrayList<>());
        //         queVal.get(nid).add(val);
        //         queId.get(nid).add(i);
        //     }
        //     this.ans = new int [m];
        //     this.trie = new Trie();
        //     dfs(root);
        //     return ans;
        // }


        // public boolean validUtf8(int[] arr) {
        //     int n = arr.length;
        //     int ma = 0, mb = 0, cnt = 0, v = 0;
        //     for (int i = 0; i < n; i++) {
        //         v = arr[i];
        //         ma = 1 << 7;
        //         mb = 1 << 6;
        //         if (cnt > 0 && !((ma & v) == ma && (mb & v) == 0)) return false;
        //         if ((v & ma) == 0 && cnt > 0) return false;
        //         if ((v & ma) == ma) {
        //             if ((mb & v) == 0) --cnt;
        //             else if ((mb & v) == mb) {
        //                 while ((mb & v) == mb) {
        //                     ++cnt;
        //                     if (cnt > 3) return false;
        //                     mb = mb >> 1;
        //                 }
        //             }
        //         }
        //     }
        //     return cnt == 0;
        // }


        // public int movesToChessboard(int[][] bd) { // bd: board
        //     int n = bd.length, rowSum = 0, colSum = 0, rowDif = 0, colDif = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j < n; j++)
        //             if ((bd[0][0] ^ bd[i][0] ^ bd[0][j] ^ bd[i][j]) > 0) return -1;
        //     for (int i = 0; i < n; i++) {
        //         rowSum += bd[0][i];
        //         colSum += bd[i][0];
        //         rowDif += bd[i][0] == i % 2 ? 1 : 0; // 
        //         colDif += bd[0][i] == i % 2 ? 1 : 0; // 
        //     }
        //     if (rowSum < n/2 || rowSum > (n+1)/2) return -1;
        //     if (colSum < n/2 || colSum > (n+1)/2) return -1;
        //     if (n % 2 == 1) {
        //         if (rowDif % 2 == 1) rowDif = n - rowDif;
        //         if (colDif % 2 == 1) colDif = n - colDif;
        //     } else {
        //         rowDif = Math.min(rowDif, n - rowDif);
        //         colDif = Math.min(colDif, n - colDif);
        //     }
        //     return (rowDif + colDif) / 2;
        // }
        // public int movesToChessboard(int[][] board) {
        //     int N = board.length;
        //     // count[code] = v, where code is an integer
        //     // that represents the row in binary, and v
        //     // is the number of occurrences of that row
        //     Map<Integer, Integer> count = new HashMap();
        //     for (int[] row: board) {
        //         int code = 0;
        //         for (int x: row)
        //             code = 2 * code + x;
        //         count.put(code, count.getOrDefault(code, 0) + 1);
        //     }
        //     int k1 = analyzeCount(count, N);
        //     if (k1 == -1) return -1;
        //     // count[code], as before except with columns
        //     count = new HashMap();
        //     for (int c = 0; c < N; ++c) {
        //         int code = 0;
        //         for (int r = 0; r < N; ++r)
        //             code = 2 * code + board[r][c];
        //         count.put(code, count.getOrDefault(code, 0) + 1);
        //     }
        //     int k2 = analyzeCount(count, N);
        //     return k2 >= 0 ? k1 + k2 : -1;
        // }
        // public int analyzeCount(Map<Integer, Integer> count, int N) {
        //     // Return -1 if count is invalid
        //     // Otherwise, return number of swaps required
        //     if (count.size() != 2) return -1;
        //     List<Integer> keys = new ArrayList(count.keySet());
        //     int k1 = keys.get(0), k2 = keys.get(1);
        //     // If lines aren't in the right quantity
        //     if (!(count.get(k1) == N/2 && count.get(k2) == (N+1)/2) &&
        //         !(count.get(k2) == N/2 && count.get(k1) == (N+1)/2))
        //         return -1;
        //     // If lines aren't opposite
        //     if ((k1 ^ k2) != (1<<N) - 1)
        //         return -1;
        //     int Nones = (1 << N) - 1;
        //     int ones = Integer.bitCount(k1 & Nones); // bitCount统计二进制中1的个数
        //     int cand = Integer.MAX_VALUE;
        //     if (N%2 == 0 || ones * 2 < N) // zero start
        //         cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);
        //     if (N%2 == 0 || ones * 2 > N) // ones start
        //         cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);
        //     return cand;
        // }


        // public int countPairs(int[] arr, int low, int high) { // TLE TLE TLE
        //     int n = arr.length, v = 0, res = 0;
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             v = arr[i] ^ arr[j];
        //             if (v >= low && v <= high) {
        //                 ++res;
        //             }
        //         }
        //     System.out.println("res: " + res);
        //     return res;
        // }
        // public int countPairs(int[] arr, int low, int high) { 
        //     int [] freq = new int [20002];
        //     for (int v : arr)
        //         freq[v]++;
        //     int val = 0, res = 0;
        //     for (int v : arr) {
        //         for (int i = low; i <= high; i++) {
        //             val = v ^ i;
        //             if (val <= 20000)
        //                 res += freq[val];
        //         }
        //         freq[v]--;
        //     }
        //     return res;
        // }
        // public class Trie {
        //     static final int H = 14; // 2^15=32768，15位二进制足够计算
        //     int cnt;
        //     Trie [] next;
        //     public Trie() {
        //         this.cnt = 0;
        //         this.next = new Trie[2];
        //     }
        //     public void insert(int va) { // 插入数值
        //         Trie r = this;
        //         for (int i = H; i >= 0; i--) {
        //             int bit = (va >> i) & 1;
        //             if (r.next[bit] == null)
        //                 r.next[bit] = new Trie();
        //             r = r.next[bit];
        //             r.cnt++;
        //         }
        //     } 
        //     public int search(Trie r, int digit, int v, int range) { // 搜索和 v 异或值在[0,range]范围内的数字num2的个数
        //         if (r == null) return 0;
        //         if (digit < 0) return r.cnt;
        //         int vb = (v >> digit) & 1;    // v 和 range 在该位的值
        //         int vr = (range >> digit) & 1;
        //         if (vr == 1) {   // range在该位为1
        //             if (vb == 0) // num 在该位为0，num2该位为0的部分全部满足，为1的部分继续判断
        //                 return (r.next[0] == null ? search(r.next[1], digit-1, v, range) : r.next[0].cnt + search(r.next[1], digit-1, v, range));
        //             else         // v 在该位为1，num2该位为1的部分全部满足，为0的部分继续判断
        //                 return (r.next[1] == null ? search(r.next[0], digit-1, v, range) : r.next[1].cnt + search(r.next[0], digit-1, v, range));
        //         }
        //         return search(r.next[vb], digit-1, v, range); // range在该位 vr 为0，num2该位必须和num一致
        //     }
        // }
        // private Trie root;
        // public int countPairs(int[] arr, int low, int high) {
        //     int n = arr.length, maxHeight = 14; // 2^15=32768，15位二进制足够计算
        //     int res = 0;
        //     root = new Trie();
        //     for (int v : arr) {
        //         res += root.search(root, maxHeight, v, high) - root.search(root, maxHeight, v, low-1); // 这里的脑袋好难转呀。。。
        //         root.insert(v);
        //     }
        //     return res;
        //     // for (int v : arr) 
        //     //     root.insert(v);
        //     // for (int v : arr) 
        //     //     res += root.search(root, maxHeight, v, high) - root.search(root, maxHeight, v, low-1);
        //     // return res / 2; // 如果按这种写法，就得 / 2，智商呢？！！！
        // }

        
        // private boolean backTracking(int [] arr, int [] quantity, int idx) {
        //     if (idx < 0) return true;
        //     Set<Integer> vis = new HashSet<>();
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] < quantity[idx] || vis.contains(arr[i])) continue; // 去杂去重
        //         vis.add(arr[i]);
        //         arr[i] -= quantity[idx];
        //         if (backTracking(arr, quantity, idx-1)) return true;
        //         arr[i] += quantity[idx];
        //     }
        //     return false;
        // }
        // public boolean canDistribute(int[] nums, int[] quantity) {
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (Integer v : nums) 
        //         map.put(v, map.getOrDefault(v, 0) + 1);
        //     int [] arr = new int [map.size()];
        //     int i = 0;
        //     for (Integer val : map.values()) arr[i++] = val;
        //     Arrays.sort(quantity); // decreasing frequency: 是一种裁枝优化
        //     return backTracking(arr, quantity, quantity.length-1);
        // }
        // public boolean canDistribute(int[] nums, int[] quantity) {
        //     int [] counts = new int[1001]; // compress the states first
        //     int n = 0;
        //     for(int i: nums) {
        //         counts[i] ++;
        //         if (counts[i] == 1) n++;
        //     }
        //     nums = new int[n];
        //     int j = 0;
        //     for (int i: counts) 
        //         if (i > 0) nums[j++] = i;
        //     return distribute(nums, quantity, 0);
        // }
        // private boolean distribute(int[] nums, int[] quantity, int idx) {
        //     if (i == quantity.length) return true;
        //     int q = quantity[idx];
        //     Set<Integer> used = new HashSet<>();
        //     for(int j = 0; j < nums.length; j++) {
        //         int k = nums[j];
        //         if (k < q || used.contains(k)) continue;
        //         nums[j] -= q;
        //         used.add(k); // Avoid duplicates. TLE without it.
        //         if (distribute(nums, quantity, i+1)) return true;
        //         nums[j] += q;
        //     }
        //     return false;
        // }


        // private boolean helper(int [] arr, int i, int xor) { // xor: the current leftover array xor result
        //     if (i == n) return (i % 2 == 0);
        //     if (dp[i] != null) return dp[i];
        //     if (xor == 0) return (i % 2 == 0); // to be noted
        //     int tmp = 0;
        //     if (i % 2 == 0) { // alice's turn
        //         for (int j = 0; j < n; j++) {
        //             if (arr[j] == -1) continue;
        //             if ((arr[j] ^ xor) == 0) continue;
        //             tmp = arr[j];
        //             arr[j] = -1;
        //             if (helper(arr, i+1, xor^tmp)) return dp[i] = true;
        //             arr[j] = tmp;
        //         }
        //         return dp[i] = false;
        //     } else { // bob's turn
        //         for (int j = 0; j < n; j++) {
        //             if (arr[j] == -1) continue;
        //             if ((arr[j] ^ xor) == 0) continue;
        //             tmp = arr[j];
        //             arr[j] = -1;
        //             if (!helper(arr, i+1, xor^tmp)) return dp[i] = false;
        //             arr[j]= tmp;
        //         }
        //         return dp[i] = true;
        //     }
        // }
        // Boolean [] dp; // alice win states
        // int n;
        // public boolean xorGame(int[] arr) {
        //     n = arr.length;
        //     dp = new Boolean [n];
        //     int [] xor = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         xor[i] = (i == 0 ? 0 : xor[i-1]) ^ arr[i];
        //     return helper(arr, 0, xor[n-1]); // i: turn
        // }

        // public boolean xorGame(int[] nums) {
        //     int xor = 0 ;
        //     for (int i : nums) 
        //         xor = xor ^ i ;
        //     if (xor == 0 || ( nums.length & 1 ) == 0 )
        //         return true ;
        //     return false ;
        // }


        // public int shortestPathAllKeys(String[] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length();
        //     int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        //     Queue<int []> q = new LinkedList<>(); // pos + mask
        //     Set<String> vis = new HashSet<>();
        //     int keyCnt = 0;     
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             if (grid[i].charAt(j) == '@') {
        //                 q.offer(new int [] {i*n+j, 0});
        //                 vis.add(String.valueOf(i*n+j) + "_0");
        //             } else if (Character.isLowerCase(grid[i].charAt(j))) 
        //                 ++keyCnt;
        //     int i = 0, j = 0, k = 0, cnt = 0, mask = 0;
        //     int [] cur = null;
        //     while (!q.isEmpty()) {
        //         for (int w = q.size(); w > 0; w--) {
        //             cur = q.poll();
        //             if (cur[1] == (1 << keyCnt) - 1) return cnt;
        //             for (int [] d : dirs) {
        //                 i = cur[0] / n + d[0];
        //                 j = cur[0] % n + d[1];
        //                 k = i * n + j;
        //                 mask = cur[1]; // 。。。。。。一不小心就。。。。。
        //                 if (i < 0 || i >= m || j < 0 || j >= n) continue;
        //                 char c = grid[i].charAt(j);
        //                 if (c == '#') continue;
        //                 if (c >= 'A' && c <= 'F' && ((cur[1] >> (c - 'A')) & 1) == 0) continue;
        //                 if (c >= 'a' && c <= 'f') mask |= (1 << (c - 'a'));
        //                 String tmp = k + "_" + mask;
        //                 if (!vis.contains(tmp)) {
        //                     vis.add(tmp);
        //                     q.offer(new int [] {k, mask});
        //                 }
        //             }
        //         }
        //         ++cnt;
        //     }
        //     return -1;
        // }

        // public int bitwiseComplement(int n) {
        //     if (n == 0) return 1;
        //     int r = 0, i = 0;
        //     while (n > 0) {
        //         if ((n & 1) == 0) 
        //             r |= (1 << i);
        //         i++;
        //         n /= 2;
        //     }
        //     return r;
        // }

        // public int[] findErrorNums(int[] a) { // 最笨的办法：跟位操作有什么关系呢？
        //     boolean [] vis = new boolean [10001];
        //     int [] r = new int [2];
        //     for (int v : a) {
        //         if (!vis[v]) vis[v] = true;
        //         else r[0] = v;
        //     }
        //     for (int i = 1; i < 10001; i++) 
        //         if (!vis[i]) {
        //             r[1] = i;
        //             break;
        //         }
        //     return r;
        // }

        // public int largestCombination(int[] candidates) {
        //     int n = 25; // [ 爱表哥，一定要嫁给偶亲爱的表哥！！！ ]
        //     int [] r = new int [n];
        //     int i = 0;
        //     for (int v : candidates) {
        //         i = 0;
        //         while (v > 0) {
        //             if ((v & 1) == 1) 
        //                 r[i]++;
        //             v /= 2;
        //             i++;
        //         }
        //     }
        //     return Arrays.stream(r).max().getAsInt();
        // }

        // // TLE TLE TLE : 不想再写这个题目了。。。53/65
        // public int longestNiceSubarray(int[] a) { // 滑动窗口：找一个最长的数组片段，里面的每个元素位上不重样
        //     int n = a.length, m = 30, j = 0, idx = 0, max = 1, mv = 0, i = 0; // j : left
        //     int [] r = new int [m];
        //     boolean valid = true;
        //     for (i = 0; i < n; i++) { // i: right
        //         // System.out.println("\n i: " + i);
        //         List<Integer> l = getBitList(a[i]);
        //         valid = true;
        //         for (int v : l) {
        //             if (r[v] > 0)
        //                 valid = false; // 当前数的位没有录进去
        //             r[v]++;
        //             idx++;
        //         }
        //         System.out.println(Arrays.toString(r));
        //         if (!valid) {
        //             max = Math.max(max, i - j);
        //             while (j < i) {
        //                 mv = 0;
        //                 List<Integer> lj = getBitList(a[j]);
        //                 for (int v : lj) {
        //                     r[v]--;
        //                     mv = Math.max(mv, r[v]);
        //                 }
        //                 System.out.println(Arrays.toString(r));
        //                 System.out.println("mv: " + mv);
        //                 if (mv == 1 && Arrays.stream(r).max().getAsInt() == 1) { // 不知道这里算是个什么神逻辑 ....TLE TLE TLE......
        //                     // if (mv == 1) { // 不知道这里算是个什么神逻辑 ....
        //                     max = Math.max(max, i - j);
        //                     // System.out.println("max: " + max);
        //                     j++;
        //                     break;
        //                 }
        //                 j++;
        //             }                    
        //         }
        //         // System.out.println(Arrays.toString(r));
        //         // System.out.println("max: " + max);
        //         // System.out.println("j: " + j);
        //     }
        //     // System.out.println("(i-j): " + (i-j));
        //     // System.out.println("valid: " + valid);
        //     return Math.max(max, (valid ? i-j : 0));
        // }
        // List<Integer> getBitList(int v) {
        //     List<Integer> l = new ArrayList<>();
        //     int i = 0;
        //     while (v > 0) {
        //         if ((v & 1) == 1)
        //             l.add(i);
        //         i++;
        //         v /= 2;
        //     }
        //     return l;
        // }

        // public int longestSubarray(int[] a) { // 不知道这里是错到哪里去了???。。。【同一个数组里最大值不止出现在一个片段中，可以出现在几个不同的片段】
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), idx = 0;
        //     int i = 0;
        //     for (i = 0; i < n; i++) {
        //         if (a[i] == max) {
        //             idx = i;
        //             while (i < n && a[i] == max) i++;
        //             break;// 这里不对：舍弃掉了可能正确答案 .【同一个数组里最大值不止出现在一个片段中，可以出现在几个不同的片段】
        //         }
        //     }
        //     while (idx >= 0 && a[idx] == max) idx--;
        //     return i - idx - 1;
        //  }
        // public int longestSubarray(int[] a) {
        //     int n = a.length, max = Arrays.stream(a).max().getAsInt(), r = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == max) {
        //             int j = i+1;
        //             while (j < n && a[j] == max) j++;
        //             r = Math.max(r, j - i);
        //             i = j-1;
        //         }
        //     }
        //     return r;
        // }

        // public int[] smallestSubarrays(int[] a) {/// TODO TODO TODO
        //     int n = a.length;
        //     int [] r = new int [n], s = new int [n], b = new int [n]; // 糊糊脑袋。。。
        //     for (int i = 0; i < n; i++) // XOR 数组
        //         s[i] = (i == 0 ? 0 : s[i-1]) | a[i];
        //     for (int i = n-1; i >= 0; i--) 
        //         b[i] = (i == n-1 ? 0 : b[i+1]) | a[i];
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0)
        //             for (int j = i; j < n; j++) 
        //                 s[j] = (s[i-1] & d[j]);
        //         r[i] = getMaxLen(s, i);
        //     }
        //     return r;
        // }
        // int getMaxLen(int [] r, int idx) {
        //     int max = r[idx], ml = 1;
        //     for (int i = idx+1; i < r.length; i++) 
        //         if (r[i] > max) {
        //             max = r[i];
        //             ml = i - idx+1;
        //         }
        //     return ml;
        // }

        // int getBitsCnts(int v) { // 有个函数 Integer.bitCount(int v) 是专门做这事的。。。
        //     int r = 0;
        //     while (v > 0) {
        //         if ((v & 1) == 1)
        //             r++;
        //         v /= 2;
        //     }
        //     return r;
        // }

// // The important point to realize is that the sum of OR and AND is just the sum of bits of two numbers.
// // We dedup the input array, and count numbers containing n bits (where n is [1..29]);
// // Then, we pick any combination of bits i and j, such that i + j >= k.
// // If i != j, the number of pairs is cnt[i] * cnt[j] * 2; numbers for i and j are different, so they form two pairs.
// // If i == j, the number of pairs is cnt[i] * cnt[i]. This is different from above, so that pairs with the same number are counted once.
//         public long countExcellentPairs(int[] a, int k) {
//             int n = a.length;
//             // 找数对：两个值 [x, y] ==> getBitsCnts(x) + getBitsCnts(y) >= k 但是对这里数数没兴趣了。。。。。
//             long ans = 0l, r [] = new long [30];
//             for (int v : Arrays.stream(a).distinct().toArray())
//                 ++r[Integer.bitCount(v)];
//             // for (int v : a) // 看不懂：上面的是为什么要多一步？
//             //     ++r[Integer.bitCount(v)];
//             for (int i = 1; i < 30; i++) 
//                 for (int j = Math.max(i, k-i); j < 30; j++) 
//                     ans += r[i] * r[j] * (i == j ? 1 : 2);
//             return ans;
//         }

        // public long sumScores(String s) {// 这个题目没有看懂
        //     final int n = s.length();
        //     int[] z = new int[n];
        //     // [l, r] := indices of the rightmost segment match
        //     int l = 0;
        //     int r = 0;
        //     for (int i = 1; i < n; ++i) {
        //         if (i <= r)
        //             z[i] = Math.min(r - i + 1, z[i - l]);
        //         while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
        //             ++z[i];
        //         if (i + z[i] - 1 > r) {
        //             l = i;
        //             r = i + z[i] - 1;
        //         }
        //     }
        //     return Arrays.stream(z).sum().getAsInt() + n;
        // }

        // public int findClosestNumber(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     if (a[0] >= 0) return a[0];
        //     int i = 0;
        //     for ( i = 0; i < n-1; i++) {
        //         if (a[i] < 0 && a[i+1] <= 0) continue;
        //         if (a[i] == 0) return 0;
        //         if (a[i] < 0) {
        //             if (Math.abs(a[i]) < a[i+1]) return a[i];
        //             else return a[i+1];
        //         } 
        //     }
        //     return a[i] <= 0 ? a[i] : -1;
        // }

        // public long waysToBuyPensPencils(int t, int x, int y) { // t x y
        //     long r = 0l;
        //     int n = t / x;
        //     for (int i = 0; i <= n; i++) 
        //         r += (long)((t - x * i) / y + 1l);
        //     return r;
        // }

        // public int minImpossibleOR(int[] a) { 
        //     Set<Integer> s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     int r = 1;
        //     while (s.contains(r)) r *= 2;
        //     return r;
        // }
        }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {2,3,3,2,2};
        int [] a = new int [] {1,2,3,4};

        int r = s.countDistinct(a, 4, 1);
        System.out.println("r: " + r);
    }
}
