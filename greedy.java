import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
// import javafx.util.Pair;

import static java.util.stream.Collectors.toMap;

public class greedy {
    public static class Solution {

        // public int balancedStringSplit(String s) {
        //     int n = s.length();
        //     if (n == 1) return 0;
        //     int cnt = 0;
        //     int bal = 1;
        //     int i = 1;
        //     while (i < n) {
        //         if (s.charAt(i) == s.charAt(0)) ++bal;
        //         else --bal;
        //         if (bal == 0) ++cnt;
        //         ++i;
        //     }
        //     return cnt;
        // }

        // public int maximum69Number (int num) {
        //     StringBuilder s = new StringBuilder(Integer.toString(num));
        //     int n = s.length();
        //     if (n == 1) return 9;
        //     int i = 0;
        //     while (i < n && s.charAt(i) == '9') ++i;
        //     if (i == n) return num;
        //     s.setCharAt(i, '9');
        //     return Integer.parseInt(s.toString());
        // }

        // public int minOperations(int[] nums) {
        //     int n = nums.length;
        //     if (n == 1) return 0;
        //     int cnt = 0;
        //     int tmp = 0;
        //     for (int i = 1; i < n; i++) {
        //         if (nums[i] != nums[i-1] + 1) {
        //             tmp = nums[i];
        //             nums[i] = Math.max(nums[i], nums[i-1]+1);
        //             cnt += nums[i] - tmp;
        //         }
        //     }
        //     return cnt;
        // }

       //  public int arrayPairSum(int[] nums) {
       //      Arrays.sort(nums);
       //      int n = nums.length;
       //      if (n == 2) return Math.min(nums[0], nums[1]);
       //      int sum = 0;
       //      for (int i = 1; i < n; i += 2) 
       //          sum += Math.min(nums[i], nums[i-1]);
       //      return sum;
       // }

        // public String largestOddNumber(String num) {
        //     int n = num.length();
        //     if (n == 1) return (num.charAt(0) - '0') % 2 == 1 ? num : "";
        //     if ((num.charAt(0) - '0') % 2 == 1) return num;
        //     int i = 0;
        // }

        // public int longestPalindrome(String s) {
        //     int n = s.length();
        //     if (n == 1) return 1;
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     int max = 0;
        //     int sum = 0;
        //     for (Integer val : m.values()) {
        //         if (val % 2 == 0) sum += val;
        //         else max = Math.max(max, val);
        //     }
        //     return sum += max == 0 ? 0 : max;
        // }

        // public boolean validPalindrome(String s) {
        //     int n = s.length();
        //     if (n == 1) return true;
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     int cnt = 0;
        //     for (Integer val : m.values()) 
        //         if (val % 2 == 1) ++cnt;
        //     return cnt <= 2;
        // }

        // public int minPairSum(int[] nums) {
        //     int n = nums.length;
        //     Arrays.sort(nums);
        //     int sum = 0;
        //     for (int i = 0; i < n/2; i++) 
        //         sum = Math.max(sum, nums[i] + nums[n-1-i]);
        //     return sum;
        // }

        // public List<Integer> partitionLabels(String s) {
        //     List<Integer> l = new ArrayList<>();
        //     int n = s.length();
        //     if (n == 1) {
        //         l.add(1);
        //         return  l;
        //     }
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++)
        //         m.put(s.charAt(i), i);

        //     int i = 0, j = 0;
        //     if (m.get(s.charAt(i)) == i) {
        //         l.add(1);
        //         ++i;
        //     }
        //     j = i;
        //     int right = i;
        //     // while (i < n) {
        //     while (i < n && m.get(s.charAt(i)) > i) {
        //         right = Math.max(m.get(s.charAt(i)), right);
        //         ++i;
        //     }
        //     if (m.get(s.charAt(i)) == i) {
        //         l.add(right - j + 1);
        //         ++i;
        //         if (i == n) return l;
        //     }
        //     List<Integer> li = partitionLabels(s.substring(i));
        //     for ( j = 0; j < li.size(); j++) {
        //         l.add(li.get(j));
        //     }
        //     return l;
        // }

        // public int maxCoins(int[] piles) {
        //     int n = piles.length;
        //     int sum = 0;
        //     Arrays.sort(piles);
        //     for (int i = n/3; i < n; i += 2) 
        //         sum += piles[i];
        //     return sum;
        // }


        // public int minAddToMakeValid(String s) {
        //     int x = 0, y = 0;
        //     for (int i = 0; i < s.length(); i++) {
        //         if (s.charAt(i) == '(') {
        //             ++x;   
        //         } else {
        //             if (x > 0)
        //                 --x;
        //             else
        //                 ++y;
        //         }
        //     }
        //     return x + y;
        // }

        // public int minFlips(String target) {
        //     int n = target.length();
        //     if (n == 1) return target.charAt(0) == '0' ? 0 : 1;
        //     int i = 0;
        //     while (i < n && target.charAt(i) == '0') ++i;
        //     if (i == n) return 0;
        //     else if (i == n-1) return 1;
        //     int cnt = 1;
        //     ++i;
        //     char c = s.charAt(i);
        //     while (i < n) {
        //         while (i < n && target.charAt(i) == c) ++i;
        //     }
        // }

        // public boolean checkIfCanBreak(String s1, String s2) {
        //     int n = s1.length();
        //     char [] s = s1.toCharArray();
        //     char [] t = s2.toCharArray();
        //     Arrays.sort(s);
        //     Arrays.sort(t);
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s[i] >= t[i]) {
        //             if (s[i] > t[i])
        //                 ++cnt;
        //             continue;
        //         }
        //         if (s[i] <= t[i] && cnt == 0) {
        //             return checkIfCanBreak(s2, s1);
        //         } else if (s[i] < t[i] && cnt > 0) return false;
        //     }
        //     return true;
        // }

        // int min = Integer.MAX_VALUE;
        // boolean [] vis;
        // private void helper(List<Integer> ori, List<Integer> l, int t, int v) {
        //     if (l.size() > min) return;
        //     if (v == t) {
        //         if (l.size() < min) min = l.size();
        //         return;
        //     }
        //     for (int i = ori.size()-1; i >= 0; --i) {
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(ori.get(i));
        //             helper(ori, l, t, v + ori.get(i));
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // public int findMinFibonacciNumbers(int k) {
        //     List<Integer> dp = new ArrayList<>();
        //     dp.add(1);
        //     dp.add(1);
        //     int i = 2;
        //     while (dp.get(i-1) + dp.get(i-2) <= k) {
        //         dp.add(dp.get(i-1) + dp.get(i-2));
        //         ++i;
        //     }
        //     if (dp.get(dp.size()-1) == k) return 1;
        //     int sum = 0;
        //     List<Integer> l = new ArrayList<>();
        //     for ( i = dp.size()-1; i >= 0; i--) {
        //         if (sum + dp.get(i) <= k) {
        //             l.add(0, dp.get(i));
        //             sum += dp.get(i);
        //             if (sum == k) return l.size();
        //         }
        //     }
        //     return -1;
        // }

        // public String getSmallestString(int n, int k) {
        //     if (n == 1) return new StringBuilder((char)(k-1+'a')).toString();
        // }

        // int n;
        // public String getNextLargerNum(String s) {
        //     char [] arr = s.toCharArray();
        //     int i = n-1;
        //     StringBuilder res = new StringBuilder(s);
        //     if (arr[i] > arr[i-1]) {
        //         char c = arr[i];
        //         res.setCharAt(i, arr[i-1]);
        //         res.setCharAt(i-1, c);
        //         return res.toString();
        //     }
        //     while (i >= 0 && arr[i-1] > arr[i]) --i;
        //     char c = arr[i-1];
        //     arr[i-1] = arr[i];
        //     arr[i] = c;
        //     Arrays.sort(arr, i, n);
        //     for (int j = i; j < n; j++) 
        //         res.setCharAt(j, arr[j]);
        //     return res.toString();
        // }
        // private void swap(char [] arr, int i, int j) {
        //     char tmp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = tmp;
        //     // return arr;
        // }
        // public int getMinSwaps(String num, int k) {
        //     n = num.length();
        //     String s = num;
        //     int cnt = 0;
        //     while (cnt < k) {
        //         s = getNextLargerNum(s);
        //         ++cnt;
        //     }
        //     char [] a = num.toCharArray();
        //     char [] b = s.toCharArray();
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] == b[i]) continue;
        //         for (int j = i+1; j < n; j++) {
        //             if (a[j] == b[i]) {
        //                 swap(a, i, j);
        //                 ++cnt;
        //                 break;
        //             }
        //         }
        //     }
        //     return cnt;
        // }

        // public boolean canConstruct(String s, int k) {
        //     int n = s.length();
        //     if (n < k) return false;
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     int cnt = 0;
        //     for (Map.Entry<Character, Integer> entry : m.entrySet()) 
        //         if (entry.getValue() % 2 == 1) ++cnt;
        //     if (cnt > k) return false;
        //     return true;
        // }

        // public int matrixScore(int[][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int res = (1 << n-1)*m;
        //     int cnt = 0;
        //     for (int j = 1; j < n; j++) {
        //         cnt = 0;
        //         for (int i = 0; i < m; i++) 
        //             cnt += (grid[i][j] == grid[i][0] ? 1 : 0);
        //         res += (1 << n-1-j)*Math.max(cnt, m-cnt);
        //     }
        //     return res;
        // }

        // public List<Integer> partitionLabels(String s) {
        //     int [] arr = new int [26];
        //     int n = s.length();
        //     for (int i = 0; i < n; i++) 
        //         arr[s.charAt(i)-'a'] = i;
        //     List<Integer> res = new ArrayList<>();
        //     int max = Integer.MIN_VALUE, bgn = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[s.charAt(i)-'a'] == i && (i == 0 || max == i || max == Integer.MIN_VALUE)) {
        //             res.add(i-bgn+1);
        //             bgn = i+1;
        //             max = Integer.MIN_VALUE;
        //             continue;
        //         } else 
        //             max = Math.max(max, arr[s.charAt(i)-'a']);
        //     }
        //     if (bgn == n-1) res.add(1);
        //     return res;
        // }


        // private boolean allEven(int [] arr) {
        //     for (int i = 0; i < arr.length; i++) 
        //         if (arr[i] % 2 == 1) return false;
        //     return true;
        // }
        // private boolean isFinal(int [] arr) {
        //     int i = 0;
        //     for ( i = 0; i < arr.length; i++) 
        //         if (arr[i] != 0) break;
        //     return i == arr.length;
        // }
        // private void dividedByTwo(int [] arr) {
        //     for (int i = 0; i < arr.length; i++) {
        //         arr[i] /= 2;
        //     }
        // }
        // private int reduceByOne(int [] arr) {
        //     int cnt = 0;
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] % 2 == 1) {
        //             ++cnt;
        //             --arr[i];
        //         }
        //     }
        //     return cnt;
        // }
        // public int minOperations(int[] arr) {
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     int res = 0, tmp = 0;
        //     while (true) {
        //         while (allEven(arr) && !isFinal(arr)) {
        //             dividedByTwo(arr);
        //             ++res;
        //         }
        //         if (isFinal(arr)) return res;
        //         tmp = reduceByOne(arr);
        //         res += tmp;
        //         if (tmp == 0 && isFinal(arr)) return res;
        //     }
        // }

        // public int maxIceCream(int[] costs, int coins) {
        //     int n = costs.length;
        //     Arrays.sort(costs);
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (coins >= costs[i]) {
        //             ++res;
        //             coins -= costs[i];
        //         } else return res;
        //     }
        //     return res;
        // }

        // public String getSmallestString(int n, int k) {
        //     StringBuilder s = new StringBuilder();
        //     for (int i = n-1; i >= 0; i--) {
        //         if (k - 26 > i) {
        //             s.insert(0, 'z');
        //             k -= 26;
        //         } else {
        //             s.insert(0, (char)('a'+k-i-1));
        //             for (int j = 0; j < i; j++) 
        //                 s.insert(0, 'a');
        //             return s.toString();
        //         }
        //     }
        //     return "";
        // }

        // public int minPartitions(String n) {
        //     int max = 0;
        //     for (int i = 0; i < n.length(); i++) 
        //         max = Math.max(max, n.charAt(i)-'0');
        //     return max;
        // }

        // public int findLeastNumOfUniqueInts(int[] arr, int k) {
        //     int n = arr.length;
        //     Map<Integer, Integer> map = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        //     if (k == 0) return map.size();
        //     Map<Integer, Integer> m = map.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue()) // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int cnt = k;
        //     Set<Integer> s = new HashSet<>();
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         if (en.getValue() == 1) {
        //             --cnt;
        //             s.add(en.getKey());
        //             if (cnt == 0) return m.size()-s.size();
        //             continue;
        //         } else if (en.getValue() <= cnt) {
        //             cnt -= en.getValue();
        //             s.add(en.getKey());
        //             if (cnt == 0) return m.size()-s.size();
        //             continue;
        //         } else 
        //             return m.size() - s.size();
        //     }
        //     return -1;
        // }

        // public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //     int n = arr.length;
        //     Arrays.sort(arr);
        //     int max = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             if (arr[i] != 1) {
        //                 arr[i] = 1;
        //             }
        //             max = Math.max(max, arr[i]);
        //             continue;
        //         }
        //         if (arr[i] - arr[i-1] > 1)
        //             arr[i] = arr[i-1]+1;
        //         max = Math.max(max, arr[i]);
        //     }
        //     return max;
        // }


        // public int minSwaps(String s) {
        //     int n = s.length();
        //     int i = 0, j = n-1;
        //     int l = 0, r = 0;
        //     int il = 0, ir = 0;
        //     String a = "]]][[[";
        // }

        // private boolean isValid(boolean [] vis) {
        //     for (int i = 0; i < 3; i++) 
        //         if (!vis[i]) return false;
        //     return true;
        // }
        // public boolean mergeTriplets(int[][] triplets, int[] target) {
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> b[0]-a[0]);
        //     int n = triplets.length;
        //     int max = 0, tmax = 0;
        //     for (int i = 0; i < n; i++) {
        //         max = triplets[i][0];
        //         for (int j = 1; j < 3; j++) 
        //             max = Math.max(max, triplets[i][j]);
        //         q.add(new int []{max, triplets[i][0], triplets[i][1], triplets[i][2]});
        //     }
        //     for (int i = 0; i < 3; i++) {
        //         if (target[i] > q.peek()[0]) return false;
        //         tmax = Math.max(tmax, target[i]);
        //     }
        //     boolean [] vis = new boolean[3];
        //     int [] cur = null;
        //     boolean poss = false;
        //     int [] cp = Arrays.copyOf(target, 3);
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         if (cur[0] > tmax) continue;
        //         if (cur[1] > target[0] || cur[2] > target[1] || cur[3] > target[2]) continue;
        //         for (int i = 0; i < 3; i++) {
        //             if (cur[i+1] < target[i]) continue;
        //             else if (cur[i+1] > target[i]) {
        //                 break;
        //             }
        //             poss = false;
        //             if (cur[i+1] == target[i]) {
        //                 vis[i] = true;
        //                 if (isValid(vis)) return true;
        //             }
        //         }
        //         if (poss) continue;
        //     }
        //     return false;
        // }

        // private int binarySearch(List<Integer> si, int v, int l, int h) {
        //     if (l == h) return si.get(l) == v ? l : -1;
        //     if (l == h-1) return si.get(l) == v ? l : (si.get(h) == v ? h : -1);
        //     int m = l + (h-l)/2;
        //     if (si.get(m) == v) return m;
        //     else if (si.get(m) < v) return binarySearch(si, v, m+1, h);
        //     return binarySearch(si, v, l, m-1);
        // }
        // public boolean isPossibleDivide(int[] arr, int k) {
        //     int n = arr.length;
        //     if (n % k != 0) return false;
        //     Arrays.sort(arr);
        //     List<List<Integer>> ll = new ArrayList<>();
        //     List<Integer> s = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //     List<Integer> l = new ArrayList<>();
        //     int cur = 0, cIdx = 0;
        //     while (s.size() > k) {
        //         l.add(s.get(0));
        //         s.remove(0);
        //         for (int i = 1; i < k; i++) {
        //             cIdx = binarySearch(s, l.get(i-1)+1, 0, s.size()-1);
        //             if (cIdx == -1) return false;
        //             l.add(s.get(cIdx));
        //             s.remove(cIdx);
        //         }
        //         ll.add(new ArrayList<>(l));
        //         l.clear();
        //     }
        //     for (int i = 1; i < k; i++) 
        //         if (s.get(i)-s.get(i-1) != 1) return false;
        //     return true;
        // }

        // private int binarySearch(List<Integer> si, int v, int l, int h) {
        //     if (l == h) return si.get(l) == v ? l : -1;
        //     if (l == h-1) return si.get(l) == v ? l : (si.get(h) == v ? h : -1);
        //     int m = l + (h-l)/2;
        //     if (si.get(m) == v) return m;
        //     else if (si.get(m) < v) return binarySearch(si, v, m+1, h);
        //     return binarySearch(si, v, l, m-1);
        // }
        // public boolean isNStraightHand(int[] arr, int k) {
        //     int n = arr.length;
        //     if (n % k != 0) return false;
        //     Arrays.sort(arr);
        //     List<List<Integer>> ll = new ArrayList<>();
        //     List<Integer> s = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //     List<Integer> l = new ArrayList<>();
        //     int cur = 0, cIdx = 0;
        //     while (s.size() > k) {
        //         l.add(s.get(0));
        //         s.remove(0);
        //         for (int i = 1; i < k; i++) {
        //             cIdx = binarySearch(s, l.get(i-1)+1, 0, s.size()-1);
        //             if (cIdx == -1) return false;
        //             l.add(s.get(cIdx));
        //             s.remove(cIdx);
        //         }
        //         ll.add(new ArrayList<>(l));
        //         l.clear();
        //     }
        //     for (int i = 1; i < k; i++) 
        //         if (s.get(i)-s.get(i-1) != 1) return false;
        //     return true;
        // }

        // public int numRabbits(int[] arr) {
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     int k = 0, v = 0, res = 0;
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         k = en.getKey();
        //         v = en.getValue();
        //         if (v > k + 1) res += (k+1)*(v / (k+1) + (v%(k+1) == 0 ? 0 : 1));
        //         else res += k+1;
        //     }
        //     return res;
        // }

        // public int minDifference(int[] arr) {
        //     int n = arr.length;
        //     if (n <= 4) return 0;
        //     int min = Integer.MAX_VALUE;
        //     Arrays.sort(arr);
        //     min = arr[n-1] - arr[3];
        //     min = Math.min(min, arr[n-4]-arr[0]);
        //     min = Math.min(min, arr[n-2]-arr[2]);
        //     min = Math.min(min, arr[n-3]-arr[1]);
        //     return min;
        // }

        // int res = 0;
        // private int getSmallestK(int [] arr, int idx) {
        //     if (arr[idx] == idx) return idx;
        //     int max = arr[idx];
        //     int min = arr[idx];
        //     Set<Integer> s = new HashSet<>();
        //     s.add(arr[idx]);
        //     for (int i = idx+1; i < arr.length; i++) {
        //         max = Math.max(max, arr[i]);
        //         min = Math.min(min, arr[i]);
        //         s.add(arr[i]);
        //         int cnt = 0;
        //         for (int j = idx; j <= i; j++) 
        //             if (s.contains(j)) ++cnt;
        //         if (cnt == s.size()) return i;
        //     }
        //     return -1;
        // }
        // private void maxChunksToSortedRecursive(int [] arr, int idx) {
        //     int k = getSmallestK(arr, idx);
        //     res += 1;
        //     if (k == arr.length-1) return;
        //     maxChunksToSortedRecursive(arr, k+1);
        // }
        // public int maxChunksToSorted(int[] arr) {
        //     int n = arr.length;
        //     int i = 0, j = 0;
        //     res = 0;
        //     maxChunksToSortedRecursive(arr, 0);
        //     return res;
        // }


        // private int getIdx(int [] arr, int [] b, int idx) {
        //     int n = arr.length;
        //     if (n - idx < b.length) return -1;
        //     int j = 0;
        //     for (int i = idx; i < n; i++) {
        //         if (arr[i] == b[0]) {
        //             for ( j = 1; j < b.length; j++) 
        //                 if (i+j >= n || b[j] != arr[i+j]) break;
        //             if (j < b.length) continue;
        //             return i;
        //         }
        //     }
        //     return -1;
        // }
        // public boolean canChoose(int[][] groups, int[] arr) {
        //     int n = groups.length;
        //     if (arr.length < n) return false;
        //     int cur = 0, pre = 0;
        //     for (int i = 0; i < n; i++) {
        //         cur = getIdx(arr, groups[i], pre);
        //         if (cur == -1) return false;
        //         pre = cur + groups[i].length;
        //     }
        //     return true;
        // }


        // private boolean isValid(int [] a, int [] b) {
        //     for (int i = 0; i < a.length; i++) 
        //         if (a[i] <= b[i]) return false;
        //     return true;
        // }
        // private int [] recoverBackToOrder(int [] arr, int [] b, Map<Integer, Integer> m) {
        //     int n = arr.length;
        //     int [] res = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         res[m.get(b[i])] = arr[i];
        //     return res;
        // }
        // private void shiftArrToLeft(int [] arr, int idx) {
        //     int n = arr.length;
        //     int [] tmp = new int [idx+1];
        //     System.arraycopy(arr, 0, tmp, 0, idx+1);
        //     System.arraycopy(arr, idx+1, arr, 0, n-1-idx);
        //     System.arraycopy(tmp, 0, arr, n-idx-1, idx+1);
        // }
        // public int[] advantageCount(int[] arr, int[] b) {
        //     int n = arr.length;
        //     if (arr[0] > b[0] && arr[n-1] > b[n-1]) {
        //         if (isValid(arr, b)) return arr;
        //     }
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(b[i], i); // 当有重复的时候没办法恢复原位，这里要改进一下，改天再写
        //     Arrays.sort(b);
        //     Arrays.sort(arr);
        //     // System.out.println("arr.length: " + arr.length);
        //     // for (int z = 0; z < arr.length; ++z) 
        //     //     System.out.print(arr[z] + ", ");
        //     // System.out.println("");
        //     // System.out.println("b.length: " + b.length);
        //     // for (int z = 0; z < b.length; ++z) 
        //     //     System.out.print(b[z] + ", ");
        //     // System.out.println("");
        //     if (arr[0] > b[0] && arr[n-1] > b[n-1]) 
        //         if (isValid(arr, b)) return recoverBackToOrder(arr, b, m);
        //     int i = 0;
        //     while (i < n && arr[i] <= b[i]) ++i;
        //      // System.out.println("i: " + i);
        //      // System.out.println("arr.length: " + arr.length);
        //      // for (int z = 0; z < arr.length; ++z) 
        //      //     System.out.print(arr[z] + ", ");
        //      // System.out.println("");
        //     if (i < n)
        //         shiftArrToLeft(arr, i-1);
        //     else
        //         shiftArrToLeft(arr, 0);
        //     // System.out.println("arr.length: " + arr.length);
        //     //  for (int z = 0; z < arr.length; ++z) 
        //     //      System.out.print(arr[z] + ", ");
        //     //  System.out.println("");
        //     //  System.out.println("b.length: " + b.length);
        //     //  for (int z = 0; z < b.length; ++z) 
        //     //      System.out.print(b[z] + ", ");
        //     //  System.out.println("");
        //     return recoverBackToOrder(arr, b, m);
        // }

        // public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        //     int m = rowSum.length;
        //     int n = colSum.length;
        //     int [][] arr = new int [m][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             arr[i][j] = Math.min(rowSum[i], colSum[j]);
        //             rowSum[i] -= arr[i][j];
        //             colSum[j] -= arr[i][j];
        //         }
        //     }
        //     return arr;
        // }


        // private int updateIdx(int [][] arr, Set<Integer> s) {
        //     for (int i = 0; i < arr.length; i++) 
        //         if (!s.contains(i)) return i;
        //     return -1;
        // }
        // private int cntNoShorter(int [][] arr, int v, int idx) {
        //     int cnt = 0;
        //     for (int i = 0; i <= idx; i++) 
        //         if (arr[i][0] >= v) ++cnt;
        //     return cnt;
        // }
        // public int[][] reconstructQueue(int[][] people) {
        //     int m = people.length;
        //     int n = people[0].length;
        //     Arrays.sort(people, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[0]  - b[0];
        //                 if (cmp != 0) return cmp;
        //                 return a[0]-b[0];
        //             }        
        //         });
        //     List<int []> l = Arrays.stream(people).collect(Collectors.toList());
        //     int [][] res = new int[m][n];
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(res[i], -1);
        //     int [] cur = null;
        //     int idx = 0;
        //     Set<Integer> s = new HashSet<>();
        //     Queue<int []> st = new LinkedList<int []>(); 
        //     while (l.size() > 0) {
        //         cur = l.get(0);
        //         idx = updateIdx(res, s);
        //         if ( idx == 0 || (cur[1] == 0 && (idx == 0 || res[idx-1][0] == -1 || cur[0] > res[idx-1][0]))) {
        //             if (idx == 0) {
        //                 System.arraycopy(cur, 0, res[cur[1]], 0, n);
        //                 s.add(cur[1]);
        //             } else {
        //                 System.arraycopy(cur, 0, res[idx], 0, n);  
        //                 s.add(idx);
        //             } 
        //             idx = updateIdx(res, s);
        //             while (st.size() > 0 && st.peek()[1] == cntNoShorter(res, st.peek()[0], idx)) {
        //                 cur = st.poll();
        //                 System.arraycopy(cur, 0, res[idx], 0, n);
        //                 s.add(idx);
        //                 idx = updateIdx(res, s);
        //             }
        //         } else if (idx > 0 && cur[0] >= res[idx-1][0] && (cur[0] == res[idx-1][0] ? cur[1] > res[idx-1][1] : cur[1] > 0))
        //             st.add(cur);
        //         l.remove(0);
        //     }
        //     while (st.size() > 0) {
        //         idx = updateIdx(res, s);
        //         cur = st.poll();
        //         System.arraycopy(cur, 0, res[idx], 0, n);
        //     }
        //     return res;
        // }
        // public int[] createTargetArray(int[] arr, int[] index) {
        //     List<Integer> l = new ArrayList<>();
        //     int n = arr.length;
        //     for (int i = 0; i < n; i++) 
        //         l.add(index[i], arr[i]);
        //     int [] res = new int[l.size()];
        //     return l.stream().mapToInt(i->i).toArray();
        // }
        // public int[][] reconstructQueue(int[][] people) {
        //     int m = people.length;
        //     int n = people[0].length;
        //     // Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        //     Arrays.sort(people, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = b[0]  - a[0];
        //                 if (cmp != 0) return cmp;
        //                 return a[1]-b[1];
        //             }        
        //         });
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < m; i++) 
        //         l.add(people[i][1], people[i]);
        //     int [][] res = new int[m][n];
        //     l.toArray(res);
        //     return res;
        // }

        
        // private void swap(int [] arr, int idx) {
        //     int [] tmp = IntStream.rangeClosed(0, idx).map(i->arr[idx-i]).toArray();
        //     System.arraycopy(tmp, 0, arr, 0, idx+1);
        // }
        // public List<Integer> pancakeSort(int[] arr) {
        //     int n = arr.length;
        //     List<Integer> l = new ArrayList<>();
        //     int idx = 0, max = -1, j = -1;
        //     for (int i = n; i > 0; i--) {
        //         idx = -1;
        //         max = -1;
        //         j = -1;
        //         for ( j = 0; j < i; j++) {
        //             if (arr[j] > max) {
        //                 max = arr[j];
        //                 idx = j;
        //             }
        //         }
        //         if (idx == i) continue;
        //         System.out.println("idx: " + idx);
        //         swap(arr, idx);
        //         System.out.println("arr.length: " + arr.length);
        //         for (int z = 0; z < arr.length; ++z) 
        //             System.out.print(arr[z] + ", ");
        //         System.out.println("");
        //         swap(arr, idx+1);
        //         l.add(idx);
        //         l.add(idx+1);
        //     }
        //     return l;
        // }
        // public void reverseK(int k, int[] arr) {
        //     for (int i = 0; i < k / 2; i++) {
        //         int tem = arr[i];
        //         arr[i] = arr[k - i - 1];
        //         arr[k - i - 1] = tem;
        //     }
        // }
        // public List<Integer> pancakeSort(int[] arr) {
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = arr.length; i > 0; i--) {
        //         int index = -1, maxValue = -1, j = -1;
        //         for (j = 0; j < i; j++) {
        //             if (arr[j] > maxValue) {
        //                 maxValue = arr[j];
        //                 index = j;
        //             }
        //         }
        //         if (index == i - 1) continue;// 最大值已经排到了最后，不需要反转
        //         reverseK(index + 1, arr);
        //         reverseK(i, arr);
        //         ans.add(index + 1);
        //         ans.add(i);
        //     }
        //     return ans;
        // }


        // public int minDeletions(String s) {
        //     int n = s.length();
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     Map<Character, Integer> map = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int cnt = 0, v = 0;
        //     Set<Integer> sv = new HashSet<>();
        //     for (Map.Entry<Character, Integer> en : m.entrySet()) {
        //         v = en.getValue();
        //         if (!sv.contains(v)) {
        //             sv.add(v);
        //             continue;
        //         } else if (sv.contains(v)) {
        //             while (v > 0 && sv.contains(v)) {
        //                 ++cnt;
        //                 --v;
        //             }
        //             sv.add(v);
        //             continue;
        //         }
        //     }
        //     return cnt;
        // }

        


        // public int[] prevPermOpt1(int[] arr) { // 这里面有bug，改天自己把它找出来
        //     int n = arr.length;
        //     if (n == 1 || (n == 2 && arr[0] < arr[1])) return arr;
        //     int tmp = 0;
        //     if (arr[n-1] < arr[n-2]) {
        //         tmp = arr[n-2];
        //         arr[n-2] = arr[n-1];
        //         arr[n-1] = tmp;
        //         return arr;
        //     }
        //     int j = n-2;
        //     while (j > 0 && arr[j-1] <= arr[j]) --j;
        //     if (j == 0) return arr;
        //     if (arr[j-1] > arr[n-1]) {
        //         tmp = arr[j-1];
        //         arr[j-1] = arr[n-1];
        //         arr[n-1] = tmp;
        //     } else if (arr[j-1] == arr[n-1]) {
        //         int i = n-2;
        //         while (i > j && arr[i-1] == arr[i]) --i;
        //         tmp = arr[i];
        //         arr[i] = arr[j-1];
        //         arr[j-1] = tmp;
        //     }
        //     return arr;
        // }
        // public int[] prevPermOpt1(int[] arr) {
        //     int n = arr.length;
        //     int max = -1;
        //     int maxIdx = 0;
        //     for (int i = n-1; i >= 0; i--) {
        //         max = -1;
        //         maxIdx = i;
        //         for (int j = i+1; j < n; j++) {
        //             if (arr[j] < arr[i] && arr[j] > max) {
        //                 max = arr[j];
        //                 maxIdx = j;
        //             }
        //         }
        //         if (max != -1) {
        //             arr[maxIdx] = arr[maxIdx] ^ arr[i];
        //             arr[i] = arr[maxIdx] ^ arr[i];
        //             arr[maxIdx] = arr[maxIdx] ^ arr[i];
        //             break;
        //         }
        //     }
        //     return arr;
        // }
        
        
        // public class Pt {
        //     int v;
        //     int l;
        //     int r;
        //     public Pt (int a, int b, int c) {
        //         v = a;
        //         l = b;
        //         r = c;
        //     }
        //     public void setR(int c) {
        //         r = c;
        //     }
        // } 
        // public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //     int n = values.length; 
        //     TreeSet<Pt> ts = new TreeSet<>((a, b)-> (b.v != a.v ? b.v - a.v : a.l - b.l));
        //     Pt cur = null, r = null;
        //     int res = 0;
        //     boolean rm = false;
        //     for (int i = 0; i < n; i++) {
        //         r = new Pt(values[i], labels[i], 1);
        //         rm = false;
        //         res = 0;
        //         cur = ts.floor(r);
        //         if (cur != null) {
        //             if (cur.v == values[i] && cur.l == labels[i]) {
        //                 res = cur.r;
        //                 rm = true;
        //                 ts.remove(cur);
        //             }
        //         }
        //         ts.add(new Pt(values[i], labels[i], (rm ? res+1 : 1)));
        //     }
        //     Map<Integer, Integer> cnt = new HashMap<>();
        //     int numCnt = 0, k = 0, v = 0, tmpCnt;
        //     Iterator it = ts.iterator();
        //     res = 0;
        //     while (it.hasNext() && numCnt < numWanted) {
        //         cur = (Pt)it.next();
        //         k = cur.v;
        //         v = cur.l;
        //         if (numCnt < numWanted) {
        //             tmpCnt = 0;
        //             while (cnt.getOrDefault(v, 0) < useLimit && tmpCnt < cur.r && numCnt < numWanted) {
        //                 res += k;
        //                 cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        //                 ++numCnt;
        //                 ++tmpCnt;
        //             }
        //         }
        //     }
        //     return res;
        // }


        // private int calcDays(int [] arr, int capacity) {
        //     int cnt = 1;
        //     int sum = 0;
        //     for (int v: arr) {
        //         if (sum + v > capacity) {
        //             ++cnt;
        //             sum = v;
        //         } else sum += v;
        //     }
        //     return cnt;
        // }
        // public int shipWithinDays(int[] weights, int days) {
        //     int n = weights.length;
        //     int low = 0, high = 0, mid = 0;
        //     for (int v : weights) {
        //         high += v;
        //         low = Math.max(low, v);
        //     }
        //     while (low < high) {
        //         mid = low + (high - low) / 2;
        //         int middays = calcDays(weights, mid);
        //         if (middays <= days) high = mid; // 五天的活儿三天干完，每天做太多了，每天少做一点儿以求满足要求
        //         else low = mid+1;             // 要三天你五天才干完，那就必须得每天多干一点儿
        //     }            
        //     return low;
        // }


        // public int minimumSwap(String s, String t) {
        //     int n = s.length();
        //     // 统计哪些位不匹配
        //     boolean [] invalid = new boolean[n]; 
        //     int errorCnt = 0; // 统计不匹配位置的总个数
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) != t.charAt(i)) {
        //             invalid[i] = true; // 标记当前位为不匹配
        //             errorCnt++;        // 不匹配个数增加
        //         }
        //     }
        //     if (errorCnt % 2 == 1) return -1; // 如果不匹配个数为奇数，返回-1
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (!invalid[i]) continue; 
        //         for (int j = i+1; j < n; j++) { // 寻找下一个不匹配字条
        //             // 同为不匹配，并且用来替换的目标字符与当前字符不同
        //             if (invalid[j] && s.charAt(i) != t.charAt(j)) {
        //                 res += 1;
        //                 invalid[j] = false; // 打标记认为他们已经实施了交换，是有效的
        //                 errorCnt -= 2;
        //                 break;
        //             }
        //         }
        //     }
        //     if (errorCnt == 2) res += 2;
        //     return res;
        // }
        // 交换有如下两种情况
        // (1)xx和yy进行交换得到s1 = "xy", s2 = "xy" 需要 1 次交换即可
        // (2)xy和yx交换得到s1 = "xy", s2 = "xy"需要 2 次交换
        //     那么我们只需要统计xy的对数xCnt和yx的对数yCnt, 推出xCnt + yCnt的和必须为2的倍数，否则不能完成交换返回-1。对于xCnt + yCnt存在如下两种情况：
        //      - 如果xCnt为偶数，yCnt也是偶数 那么只需要交换(xCnt + yCnt)／2次（示例1）交换
        //      - 如果xCnt为奇数，yCnt也是奇数 那么只需要交换(xCnt -1)/2 + ( yCnt - 1)／2 + 2次交换 注：除了一次示例二交换 其他的全部是示例一交换
        // public int minimumSwap(String s, String t) {
        //     int n = s.length();
        //     if (n != t.length()) return -1;
        //     int xcnt = 0, ycnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) == 'x' && t.charAt(i) == 'y') xcnt++; // 记录xy的对数
        //         if (s.charAt(i) == 'y' && t.charAt(i) == 'x') ycnt++; // 记录yx的对数
        //     }
        //     // 如果总对数是基数 则有一对无法交换 不能完成两个字符串相等
        //     if ((xcnt + ycnt) % 2 == 1) return -1;
        //     return xcnt % 2 == 0 ? (xcnt+ycnt)/2 : (xcnt + ycnt)/2+1;
        // }


        // public int largestSubmatrix(int[][] matrix) {
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int [][] arr = new int [m][n];
        //     System.arraycopy(matrix[0], 0, arr[0], 0, n);
        //     for (int j = 0; j < n; j++) {
        //         for (int i = 1; i < m; i++) {
        //             if (matrix[i][j] == 1) 
        //                 arr[i][j] =  arr[i-1][j] + 1;
        //         }
        //     }
        //     for (int i = 0; i < m; i++) 
        //         Arrays.sort(arr[i]);
        //     // System.out.println("arr.length: " + arr.length);
        //     // for (int z = 0; z < arr.length; ++z) {
        //     //     for (int w = 0; w < arr[z].length; w++) 
        //     //         System.out.print(arr[z][w] + ", ");
        //     //     System.out.print("\n");
        //     // }
        //     // 最后一点右小角算面积最大的长方形，仍然是一个动态过程
        //     int j = n-1, bot = 0, max = arr[m-1][j];
        //     while (j >= 0 && arr[m-1][j] > 0) {
        //         --j;
        //         if (j >= 0)
        //             max = Math.max(max, (n-j)*arr[m-1][j]);
        //     }
        //     return max;
        // }
        // int [][] a = new int [][] {{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,0,1,0,1,0,1,1,0},{0,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},{1,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1},{1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1},{1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1},{1,1,1,0,0,1,1,0,1,1,1,0,1,0,1,1,0,1,1,1,1,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,1,0}};
        // System.out.println("a.length: " + a.length);
        // for (int z = 0; z < a.length; ++z) {
        //     for (int w = 0; w < a[z].length; w++) 
        //         System.out.print(a[z][w] + ", ");
        //     System.out.print("\n");
        // }


        // public int getMaximumConsecutive(int[] coins) {
        //     int n = coins.length;
        //     Arrays.sort(coins);
        //     if (n == 1) return coins[0] == 1 ? 2 : 1;
        //     Set<Integer> s = new HashSet<>();
        //     s.add(0);
        //     int sum = 0, pre = 0, tmp = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (coins[i] <= max + 1) {
        //             for (int j = max+1; j <= max+coins[i]; j++) 
        //                 s.add(j);
        //             max += coins[i];
        //             continue;
        //         }
        //         sum += coins[i];
        //         if (coins[i] == pre + 1 || sum == pre + 1) {
        //             if (coins[i] == pre+1)
        //                 s.add(coins[i]);
        //             else s.add(sum);
        //             pre = (coins[i] == pre+1 ? coins[i] : sum);
        //         }
        //         max = Math.max(max, pre);
        //     }
        //     return s.size();
        // } // reported out of memory, but run fine locally
        // 因为可构造的整数范围是连续的，在构造范围为 [0, range] 的情况下，添加值为 coins[i] 的硬币：
        //   - 若 coins[i] - range > 1，说明值 range + 1 无法得到，range 即为可构造的最大连续整数；
        //   - 否则，[0, range] 范围内的任意值 + coins[i] 此时都可以得到，其构造范围可直接更新为 [0, range + coins[i]]。
        // 为尽量避免出现无法构造的 range + 1，可先对 coins 进行排序，从小到大使用硬币进行构造。
        // public int getMaximumConsecutive(int[] coins) {
        //     int n = coins.length;
        //     Arrays.sort(coins);
        //     int range = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (coins[i] - range > 1) return range + 1;
        //         else range += coins[i];
        //     }
        //     return range + 1;
        // }

        
        // public int minIncrementForUnique(int[] nums) { 
        //     int n = nums.length;
        //     Arrays.sort(nums);
        //     int cnt = 0;
        //     for (int i = 1; i < n; i++) {
        //         if (nums[i] == nums[i-1]) {
        //             ++cnt;
        //             ++nums[i];
        //         } else if (nums[i] < nums[i-1]) {
        //             cnt += nums[i-1]+1-nums[i];
        //             nums[i] = nums[i-1]+1;
        //         }
        //     }
        //     return cnt;
        // }


        // private String swap(String t, int i, int j) { // j < i
        //     StringBuilder s = new StringBuilder(t);
        //     char tmp = s.charAt(i);
        //     s.setCharAt(i, s.charAt(j));
        //     s.setCharAt(j, tmp);
        //     char [] tpp = t.substring(i+1).toCharArray();
        //     Arrays.sort(tpp);
        //     return s.substring(0, i+1) + new String(tpp);
        // }
        // private String getNext(String s) {
        //     System.out.println("s: " + s);
        //     int n = s.length();
        //     int i = n-1;
        //     if (s.charAt(i-1) < s.charAt(i)) return swap(s, i, i-1);
        //     while (i > 0 && s.charAt(i-1) >= s.charAt(i)) --i;
        //     if (i == 0) return s;
        //     // System.out.println("i: " + i);
        //     // System.out.println("s.charAt(i): " + s.charAt(i));
        //     int j = i;
        //     while (s.charAt(j) > s.charAt(i)+1) ++j;
        //     // System.out.println("j: " + j);
        //     // System.out.println("s.charAt(j): " + s.charAt(j));
        //     return swap(s, i-1, j);
        //     // return swap(s, i, (i == 0 ? s.length()-1 : i-1));
        // }
        // private int cnt(String ss, String t) {
        //     int n = ss.length();
        //     int i = 0, j = 0;
        //     StringBuilder s = new StringBuilder(ss);
        //     int cnt = 0;
        //     while (i < n) {
        //         while (i < n && s.charAt(i) == t.charAt(i)) ++i;
        //         if (i == n) break;
        //         s = new StringBuilder(swap(s.toString(), s.toString().indexOf(t.charAt(i)), i));
        //         ++i;
        //         ++cnt;
        //     }
        //     return cnt;
        // }
        // public int getMinSwaps(String num, int k) {
        //     int n = num.length();
        //     int cnt = 0;
        //     String s = num;
        //     while (cnt < k) {
        //         s = getNext(s);
        //         System.out.println("s 0: " + s);
        //         ++cnt;
        //     }
        //     return cnt(num, s);
        // }


        // public String smallestSubsequence(String s) {
        //     int n = s.length();
        //     Map<Character, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     Stack<Character> st = new Stack<>();
        //     Set<Character> used = new HashSet<>();
        //     for (char ch : s.toCharArray()) {
        //         if (used.contains(ch)) {
        //             m.put(ch, m.get(ch)-1); // 推入或推出的时候单向计数就可以
        //             continue;
        //         }
        //         while (!st.isEmpty() && ch < st.peek() && m.get(st.peek()) > 1) {
        //             char peek = st.pop();
        //             m.put(peek, m.get(peek)-1);
        //             used.remove(peek);
        //         }
        //         st.push(ch);
        //         used.add(ch);
        //     }
        //     StringBuilder t = new StringBuilder();
        //     while (!st.isEmpty())
        //         t.append(st.pop());
        //     return t.reverse().toString();
        // }  
        // public String smallestSubsequence(String text) {
        //     int[] count = new int[26];       // 定义一个用于计算字符出现次数的数组
        //     for(int i=0;i<text.length();i++) 
        //         count[text.charAt(i)-'a']++; // 更新每种字符出现的次数
        //     Stack<Character> stack = new Stack<>(); 
        //     for (int i=0;i<text.length();i++) { 
        //         char c = text.charAt(i); // 取得当前字符
        //         count[c-'a']--;        // 更新当前字符剩余个数
        //         if (stack.contains(c)) // 如果当前字符已经存在于Stack中，直接跳过
        //             continue;
        //         if (!stack.isEmpty()){ // 当Stack不为空
        //             char p = stack.peek(); // 取得Stack中最后一个元素
        //             // 如果当前字符小于这个元素，并且这个元素还有剩余
        //             while (c < p && count[p-'a']>0){
        //                 stack.pop();         // 将最后一个元素踢出栈
        //                 if (stack.isEmpty()) // 当Stack为空，结束循环
        //                     break;
        //                 p = stack.peek(); // 重新取得Stack中最后一个元素，继续循环比较
        //             }
        //         }
        //         stack.push(c); 
        //     }
        //     String res=""; 
        //     while (!stack.isEmpty()) 
        //         res = stack.pop() + res;
        //     return res;
        // }


        // class Pt {
        //     char c;
        //     int v;
        //     public Pt (char a, int v) {
        //         this.c = a;
        //         this.v = v;
        //     }
        // }
        // public String longestDiverseString(int a, int b, int c) {
        //     Queue<Pt> q = new PriorityQueue<>((x, y) -> y.v - x.v);
        //     if (a > 0) q.offer(new Pt('a', a));
        //     if (b > 0) q.offer(new Pt('b', b));
        //     if (c > 0) q.offer(new Pt('c', c));
        //     Pt cur = null, next = null;
        //     String res = "";
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         next = null;
        //         res += Character.toString(cur.c);
        //         if (cur.v >= 2)
        //             res += Character.toString(cur.c);
        //         if (q.size() > 0) {
        //             next = q.poll();
        //             res += Character.toString(next.c);
        //             if (next.v >= 2)
        //                 res += Character.toString(next.c);
        //         } else return res;
        //         if (cur.v > 2) q.offer(new Pt(cur.c, cur.v-2));
        //         if (next != null && next.v > 2) q.offer(new Pt(next.c, next.v-2));
        //     }
        //     return res;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        String res = s.longestDiverseString(2, 2, 1);
        System.out.println("res: " + res);
    }
}

