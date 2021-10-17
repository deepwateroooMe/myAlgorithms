import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

public class heap {
    public static class Solution {

        // public int maxProduct(int[] nums) {
        //     int n = nums.length;
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if ((nums[i]-1)*(nums[j]-1) > max)
        //                 max = (nums[i]-1)*(nums[j]-1);
        //         }
        //     }
        //     return max;
        // }       

        // public int lastStoneWeight(int[] stones) {
        //     Queue<Integer> q = new PriorityQueue<Integer>(stones.length,new Comparator<Integer>(){
        //             @Override
        //             public int compare(Integer o1, Integer o2) {
        //                 return o2 - o1;
        //             }
        //         });
        //     for (int i = 0; i < stones.length; i++) 
        //         q.add(stones[i]);
        //     int x = 0, y = 0;
        //     while (q.size() > 1) {
        //         x = q.poll();
        //         y = q.poll();
        //         if (x != y)
        //             q.add(x - y);
        //     }
        //     return q.size() == 1 ? (int)q.poll() : 0;
        // }

        // public String[] findRelativeRanks(int[] score) {
        //     int n = score.length;
        //     String [] res = new String[n];
        //     int [] arr = new int [n];
        //     if (n == 1) {
        //         res = new String [] {"Gold Medal"};
        //         return res;
        //     }
        //     Queue<Integer> q = new PriorityQueue<>(n, new Comparator<Integer>() {
        //             @Override public int compare(Integer x, Integer y) {
        //                 return y - x;
        //             }
        //         });
        //     for (int i = 0; i < n; i++) 
        //         q.add(score[i]);
        //     int val = 0;
        //     int idx = 1;
        //     while (!q.isEmpty()) {
        //         val = q.poll();
        //         for (int i = 0; i < n; i++) 
        //             if (score[i] == val) arr[i] = idx;
        //         idx++;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == 1) res[i] = "Gold Medal";
        //         else if (arr[i] == 2) res[i] = "Silver Medal";
        //         else if (arr[i] == 3) res[i] = "Bronze Medal";
        //         else res[i] = Integer.toString(arr[i]);
        //     }
        //     return res;
        // }

        // public int minSetSize(int[] arr) {
        //     int n = arr.length;
        //     HashSet<Integer> s = new HashSet<>();
        //     int cnt = 0;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (m.containsKey(arr[i])) {
        //             cnt = m.get(arr[i]);
        //             m.put(arr[i], cnt+1);
        //         } else m.put(arr[i], 1);
        //     }
        //     Map<Integer, Integer> sorted = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //         // .limit(10)
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     // Map<Integer, Integer> sorted = m.entrySet().stream()
        //     //     .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
        //     //     .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> { throw new AssertionError(); }, LinkedHashMap::new));
        //     // System.out.println("sorted.size(): " + sorted.size());
        //     // for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) 
        //     //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //     int half = (int)Math.ceil(n / 2.0);
        //     System.out.println("half: " + half);
        //     cnt = 0;
        //     for (Integer key : sorted.keySet()) {
        //         if (cnt < half) {
        //             s.add(key);
        //             cnt += m.get(key);
        //         }
        //     }
        //     return s.size();
        // }

        // public int[][] kClosest(int[][] points, int k) {
        //     int n = points.length;
        //     List<int []> l = new ArrayList<>();
        //     HashSet<int []> s = new HashSet<>();
        //     Queue<int []> q = new PriorityQueue<int []>(k, new Comparator<int []>(){
        //             @Override public int compare(int [] a, int [] b) {
        //                 return (int)(Math.pow(a[0], 2) + Math.pow(a[1], 2) - (Math.pow(b[0], 2) + Math.pow(b[1], 2)));
        //             }
        //         });
        //     for (int i = 0; i < n; i++) {
        //         if (!s.contains(points[i])) q.add(points[i]);
        //     }
        //     int cur = 0;
        //     while (!q.isEmpty() && cur < k) {
        //         l.add(q.poll());
        //         ++cur;
        //     }
        //     int [][] arr = new int[k][];
        //     l.toArray(arr);
        //     return arr;
        // }

        // public int maximumScore(int a, int b, int c) {
        //     Queue<Integer> q = new PriorityQueue<>(3, new Comparator<Integer>() {
        //             @Override public int compare(Integer a, Integer b) {
        //                 return b - a;
        //             }
        //         });
        //     q.add(a);
        //     q.add(b);
        //     q.add(c);
        //     int res = 0;
        //     int x = 0, y = 0;
        //     while (q.size() >= 2) {
        //         x = q.poll();
        //         y = q.poll();
        //         if (x > 0 && y > 0) ++res;
        //         --y;
        //         if (y > 0) q.add(y);
        //         --x;
        //         if (x > 0) q.add(x);
        //     }
        //     return res;
        // }

        // public String frequencySort(String s) {
        //     int n = s.length();
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (m.containsKey(s.charAt(i))) {
        //             cnt = m.get(s.charAt(i));
        //             m.put(s.charAt(i), cnt+1);
        //         } else m.put(s.charAt(i), 1);
        //     }
        //     Map<Character, Integer> sorted = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     StringBuilder res = new StringBuilder();
        //     for (Character key : sorted.keySet()) {
        //         for (int i = 0; i < sorted.get(key); i++) {
        //             res.append((char)key);
        //         }
        //     }
        //     return res.toString();
        // }

        // public int[] topKFrequent(int[] nums, int k) {
        //     int n = nums.length;
        //     HashMap<Integer, Integer> m = new HashMap<>();
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (m.containsKey(nums[i])) {
        //             cnt = m.get(nums[i]);
        //             m.put(nums[i], cnt+1);
        //         } else m.put(nums[i], 1);
        //     }
        //     Map<Integer, Integer> sorted = m.entrySet().stream()
        //         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     cnt = 0;
        //     int [] arr = new int[k];
        //     for (Integer key : sorted.keySet()) {
        //         if (cnt < k)
        //             arr[cnt++] = key;
        //         else break;
        //     }
        //     return arr;
        // }

        // public int findKthLargest(int[] nums, int k) {
        //     int n = nums.length;
        //     Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
        //             @Override public int compare(Integer a, Integer b) {
        //                 return b - a;
        //             }
        //         });
        //     for (int i = 0; i < n; i++) 
        //         q.add(nums[i]);
        //     int val = 0, cnt = 0;
        //     while (!q.isEmpty() && cnt < k) {
        //         val = q.poll();
        //         ++cnt;
        //     }
        //     return val;
        // }


        // public List<String> topKFrequent(String[] words, int k) {
        //     int n = words.length;
        //     Map<String, Integer> map = new HashMap<String, Integer>();
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (!map.containsKey(words[i]))
        //             map.put(words[i], 1);
        //         else {
        //             cnt = map.get(words[i]);
        //             map.put(words[i], cnt+1);
        //         }
        //     }
        //     Comparator<Map.Entry<String, Integer>> c = new Comparator<Map.Entry<String, Integer>>() {
        //         @Override 
        //         public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        //             int cmp1 = b.getValue().compareTo(a.getValue());
        //             if (cmp1 != 0) {
        //                 return cmp1;
        //             } else {
        //                 return a.getKey().compareTo(b.getKey());
        //             }
        //         }
        //     };
        //     HashMap<String, Integer> m = map.entrySet().stream().sorted(c)
        //             .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        //     cnt = 0;
        //     List<String> res = new ArrayList<>();
        //     for (String key : m.keySet()) {
        //         if (cnt < k) {
        //             res.add(key);
        //             ++cnt;
        //         }
        //     }
        //     return res;
        // }

        
        // public int minimumEffortPath(int[][] heights) {
        //     m = heights.length;
        //     n = heights[0].length;
        //     if (m == 1 && n == 1) return 0;
        //     int [] [] arr = new int [m][n];
        //     int [] [] ami = new int [m][n];
        //     arr[0][0] = 0;
        //     int min = Integer.MAX_VALUE;
        //     int max = Integer.MIN_VALUE;
        //     pos = false;
        //     for (int i = 1; i < m; i++) {
        //         arr[i][0] = Math.abs(heights[i][0] - heights[i-1][0]);
        //         ami[i][0] = Math.abs(heights[i][0] - heights[i-1][0]);
        //     }
        //     for (int j = 1; j < n; j++) {
        //         arr[0][j] = Math.abs(heights[0][j] - heights[0][j-1]);
        //         ami[0][j] = Math.abs(heights[0][j] - heights[0][j-1]);
        //     }
        //     for (int i = 1; i < m; i++) 
        //         for (int j = 1; j < n; j++) {
        //             arr[i][j] = Math.max(Math.abs(heights[i][j] - heights[i-1][j]), Math.abs(heights[i][j] - heights[i][j-1]));
        //             ami[i][j] = Math.min(Math.abs(heights[i][j] - heights[i-1][j]), Math.abs(heights[i][j] - heights[i][j-1]));
        //         }
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (ami[i][j] < min) min = ami[i][j];
        //             if (arr[i][j] > max) max = arr[i][j];
        //         }
        //     }
        //     if (m == 1 || n == 1) return max;
        //     vis = new boolean[m][n];
        //     System.out.println("min: " + min);
        //     System.out.println("max: " + max);
        //     int res = findTheKVal(min, max, heights);
        //     return res;
        // }
        // boolean pos;
        // int m, n;
        // boolean [][] vis = new boolean[m][n];
        // private void isPossible(int val, int i, int j, int [][] arr) {
        //     System.out.println("val: " + val);
        //     if (i == m-1 && j == n-1) {
        //         pos = true;
        //         return;
        //     }
        //     vis[i][j] = true;
        //     if (i >= 1 && val >= Math.abs(arr[i][j] - arr[i-1][j]) && !vis[i-1][j]) isPossible(val, i-1, j, arr);
        //     if (i < m-1 && val >= Math.abs(arr[i][j] - arr[i+1][j]) && !vis[i+1][j]) isPossible(val, i+1, j, arr);
        //     if (j >= 1 && val >= Math.abs(arr[i][j] - arr[i][j-1]) && !vis[i][j-1]) isPossible(val, i, j-1, arr);
        //     if (j < n-1 && val >= Math.abs(arr[i][j] - arr[i][j+1]) && !vis[i][j+1]) isPossible(val, i, j+1, arr);
        // }
        // private int findTheKVal(int x, int y, int [][] arr) {
        //     if (x == y) return y;
        //     if (y - x == 1) {
        //         for (int i = 0; i < m; i++) {
        //             for (int j = 0; j < n; j++) {
        //                 vis[i][j] = false;
        //             }
        //         }
        //         isPossible(x, 0, 0, arr);
        //         if (pos) return x;
        //         else return y;
        //     }
        //     while (x < y - 1) {
        //         int mid = x + (y-x)/2;
        //         for (int i = 0; i < m; i++) {
        //             for (int j = 0; j < n; j++) {
        //                 vis[i][j] = false;
        //             }
        //         }
        //         isPossible(mid, 0, 0, arr);
        //         if (!pos) {
        //             return findTheKVal(mid + 1, y, arr);
        //         } else {
        //             pos = false;
        //             return findTheKVal(x, mid, arr);
        //         }
        //     }
        //     return -1;
        // }

        
        // private class Node {
        //     int i;
        //     int r;
        //     int v;
        //     public Node(int x, int y, int z) {
        //         i = x;
        //         r = y;
        //         v = z;
        //     }
        // }
        // public int[] findDiagonalOrder(List<List<Integer>> nums) {
        //     int m = nums.size();
        //     Queue<Node> q = new PriorityQueue<Node>((x, y) -> (x.i - y.i == 0 ? y.r - x.r : x.i - y.i));
        //     int cnt = 0;
        //     Node val = null;
        //     for (int i = 0; i < nums.size(); i++) {
        //         for (int j = 0; j < nums.get(i).size(); j++) {
        //             val = new Node(i+j, i, nums.get(i).get((j)));
        //             q.add(val);
        //             ++cnt;
        //         }
        //     }
        //     int [] res = new int[cnt];
        //     int i = 0;
        //     while (!q.isEmpty()) {
        //         val = q.poll();
        //         res[i++] = val.v;
        //     }
        //     return res;
        // }

        // public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //     int n = arr.length;
        //     List<Integer> res = new ArrayList<>();
        //     if (k == n) return Arrays.stream(arr).boxed().collect(Collectors.toList());
        //     Queue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
        //             @Override
        //             public int compare(Integer a, Integer b) {
        //                 int res = Math.abs(a-x) - Math.abs(b-x);
        //                 if (res == 0) return a - b;
        //                 else return res;
        //             }
        //         });
        //     for (int i = 0; i < n; i++) {
        //         q.add(arr[i]);
        //     }
        //     while (k > 0) {
        //         res.add(q.poll());
        //         --k;
        //     }
        //     Collections.sort(res);
        //     return res;
        // }


        // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //     List<List<Integer>> ll = new ArrayList<>();
        //     List<Integer> l = new ArrayList<>();
        //     if (k == 1) {
        //         l.add(nums1[0]);
        //         l.add(nums2[0]);
        //         ll.add(l);
        //         return ll;
        //     }
        //     int m = nums1.length;
        //     int n = nums2.length;
        //     // Queue<Integer> p = new PriorityQueue<>(m, (a, b) -> a - b);
        //     // Queue<Integer> q = new PriorityQueue<>(n, (a, b) -> a - b);
        //     for (int i = 0; i < m; i++) 
        //         p.add(nums1[i]);
        //     for (int i = 0; i < n; i++) 
        //         q.add(nums2[i]);
        //     int x = 0, y = 0;
        //     x = p.poll();
        //     y = q.poll();
        //     while (!p.isEmpty() && !q.isEmpty() && k > 0) {
        //         if (x < y) {
        //             l = new ArrayList<>();
        //             l.add(x);
        //             l.add(y);
        //             ll.add(l);
        //             while (p.peek() < y.peek) {
        //             }
        //         }
        //     }
        // }

        
        // int res = 0;
        // private int findTheK(int [] arr, int val, int i, int j) {
        //     // if (i == j)
        //     //     if (j - i == 1)
        //     if (j - i > 1) {
        //         int m = i + (j-i)/2;
        //         int cnt = 0;
        //         for (int x = m; x <= j; x++) {
        //             if (arr[x] < )
        //             cnt += arr[x]
        //         }
        //     }
        // }
        // public int maxProfit(int[] inventory, int orders) {
        //     int n = inventory.length;
        //     long res = 0;
        //     Arrays.sort(inventory);
        //     if (n == 1) {
        //         for (int i = 0; i < orders; i++) {
        //             res += inventory[0] % 1000000007;
        //             --inventory[0];
        //         }
        //         return (int)(res % 1000000007);
        //     }
        //     int k = findTheK(inventory, orders, 0, n-1);
        // }


        // public int kthSmallest(int[][] matrix, int k) {
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int [] arr = new int [m * n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             arr[i * n + j] = matrix[i][j];
        //         }
        //     }
        //     Arrays.sort(arr);
        //     return arr[k-1];
        // }


        // public int longestSubarray(int[] nums, int limit) {
        //     int n = nums.length;
        //     int i = 0, int j = 1;
        //     int res = Integer.MIN_VALUE;
        //     int min = nums[0];
        //     int max = nums[0];
        //     while (j < n && Math.abs(min - max) < limit) {
        //         if (nums[j] > max) max = nums[j];
        //         if (nums[j] < min) min = nums[j];
        //         ++j;
        //     }
        // }

        // // public int longestSubarray(int[] nums, int limit) {
        // public int longestSubarray(int[] arr, int limit) {
        //     int n = arr.length;
        //     int i = 0, j = i + 1;
        //     int max = arr[0], min = arr[0], res = 0;
        //     while (j < n) {
        //         System.out.println("\ni: " + i);
        //         System.out.println("j: " + j);
        //         while (j < n && max - min < limit) {
        //             if (arr[j] < min) min = arr[j];
        //             else if (arr[j] > max) max = arr[j];
        //             j++;
        //         }
        //         if (j - i > 1 && j - i > res) res = j - i;
        //         if (j == n) return res;
        //         // System.out.println("i: " + i);
        //         // System.out.println("j: " + j);
        //         while (i < j && max - min > limit) {
        //             min = arr[i];
        //             max = arr[i];
        //             for (int x = i+1; x <= j; x++) {
        //                 if (arr[x] < min) min = arr[x];
        //                 else if (arr[x] > max) max = arr[x];
        //             }
        //             i++;
        //         }
        //         if (j - i > res) res = j - i;
        //     }
        //     return res;
        // }


        // List<List<Integer>> res = new ArrayList<>();
        // int m, n;
        // public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //     m = nums1.length;
        //     n = nums2.length;
        //     int i = 0;
        //     int j = 0;
        //     if (nums1[i] < nums2[j]) {
        //         for (int x = 0; x < n; x++) {
        //             if (nums2[x] + nums1[i] <= nums2[j] + nums1[0]) {
        //                 l = new ArrayList<>();
        //                 l.add(nums1[i]);
        //                 l.add(nums2[x]);
        //                 res.add(l);
        //             } else {
        //                 ++i;
        //                 break;   
        //             }
        //         }
        //     } else {
        //         // for (int x = 0; x < n; x++) {
        //         //     if (nums2[x] + nums1[i] <= nums2[j] + nums1[0]) {
        //         //         l = new ArrayList<>();
        //         //         l.add(nums1[i]);
        //         //         l.add(nums2[x]);
        //         //         res.add(l);
        //         //     } else {
        //         //         ++i;
        //         //         break;   
        //         //     }
        //         // }
        //     }
        // }        


        // public int minStoneSum(int[] piles, int k) {
        //     int n = piles.length;
        //     Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        //     for (int v : piles) q.offer(v);
        //     int cur = 0, res = Arrays.stream(piles).sum();
        //     while (k > 0 && !q.isEmpty()) {
        //         cur = q.poll();
        //         res -= (int)Math.floor(cur / 2);
        //         q.offer(cur - (int)Math.floor(cur / 2));
        //         --k;
        //     }
        //     return res;
        // }


        // public void dijkstra(int x) {
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        //     q.add(new int [] {x, 0});
        //     Arrays.fill(dist, Integer.MAX_VALUE);
        //     dist[x] = 0;
        //     int [] cur = null;
        //     int u = 0, t = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         u = cur[0];
        //         t = cur[1];
        //         if (dist[u] < t) continue; 
        //         if (ll.get(u).size() > 0) {
        //             for (int [] v : ll.get(u)) {
        //                 if (dist[v[0]] > dist[u] + v[1]) { 
        //                     dist[v[0]] = dist[u] + v[1];
        //                     q.offer(new int [] {v[0], dist[v[0]]});
        //                 }
        //             }
        //         }
        //     }
        // }
        // List<List<int []>> ll = new ArrayList<>();
        // int [] dist;
        // public int networkDelayTime(int[][] times, int n, int k) {
        //     Arrays.sort(times, (a, b) -> (a[2] != b[2] ? a[2] - b[2] : a[0] - b[0]));
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n+1; i++) {
        //         l = new ArrayList<>();
        //         ll.add(l);
        //     }
        //     for (int i = 0; i < times.length; i++)
        //         ll.get(times[i][0]).add(new int [] {times[i][1], times[i][2]});
        //     dist = new int [n+1];
        //     dijkstra(k);
        //     int max = 0;
        //     boolean poss = true;
        //     for (int i = 1; i <= n; i++)
        //         if (dist[i] != Integer.MAX_VALUE)
        //             max = Math.max(max, dist[i]);
        //         else {
        //             poss = false;
        //             break;
        //         }
        //     return poss ? max : -1;
        // }


        // public String kthLargestNumber(String[] arr, int k) {
        //     int n = arr.length;
        //     Arrays.sort(arr, new Comparator<String> () {
        //             @Override public int compare(String s, String t) {
        //                 if (s.length() != t.length()) return t.length() - s.length();
        //                 for (int i = 0; i < s.length(); i++) {
        //                     if (s.charAt(i) != t.charAt(i))
        //                         return t.charAt(i) - s.charAt(i);
        //                 }
        //                 return 0;
        //             }
        //         });
        //     return arr[k-1];
        // }


        // public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        //     int m = a.length;
        //     int n = b.length;
        //     List<List<Integer>> ll = new ArrayList<>();
        //     int i = 0, j = 0;
        //     while (k > 0) {
        //     }
        // }

        
        // public int strongPasswordChecker(String password) {
        //     int n = password.length();
        //     if (n < 6 || n > 20) return Math.min(Math.abs(n-6), Math.abs(n-20)); // 这里应该还需要进一步检测
        // }


        // public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //     int n = heights.length; // 先用砖头，没有砖头了，用梯子换砖头
        //     if (n == 1) return 0;
        //     int i = 0;
        //     if (bricks == 0 && ladders == 0) {
        //         while  (i < n-1 && heights[i] >= heights[i+1]) i++;
        //         return i;
        //     }
        //     Queue<Integer> q = new PriorityQueue<>((x, y) -> y-x);
        //     while (i < n-1 && (bricks > 0 || ladders > 0)) {
        //         while (i < n-1 && heights[i] >= heights[i+1]) i++;
        //         while (i < n-1 && heights[i] < heights[i+1]) {
        //             int dif = heights[i+1] - heights[i];
        //             if (bricks >= dif) {
        //                 q.offer(dif);
        //                 bricks -= dif;
        //                 i++;
        //             } else { //  (bricks < dif) {
        //                 if (ladders <= 0) return i;
        //                 ladders--;
        //                 i++;
        //                 if (!q.isEmpty() && dif < q.peek()) {
        //                     bricks += q.poll() - dif;
        //                     q.offer(dif);
        //                 }
        //             }
        //         }
        //     }
        //     return n-1;
        // }


        // public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) { // still bug here
        //     int m = a.length;
        //     int n = b.length;
        //     int [] next = new int [m]; // match to m rows
        //     Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
        //             public int compare(Integer x, Integer y) {
        //                 return a[x] + b[next[x]] - (a[y]+b[next[y]]);
        //             }
        //         });
        //     for (int i = 0; i < m; i++) q.offer(i);
        //     List<List<Integer>> ans = new ArrayList<>();
        //     while (k > 0 && !q.isEmpty()) {
        //         int idx = q.poll();
        //         ans.add(List.of(a[idx], b[next[idx]]));
        //         next[idx] += 1;
        //         if (next[idx] < n) q.offer(idx);
        //         --k;
        //     }
        //     return ans;
        // }


        // public int[] getOrder(int[][] tasks) {
        //     int n = tasks.length;
        //     List<int []> tass = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         tass.add(new int [] {i, tasks[i][0], tasks[i][1]}); // [idx, enQTime, processTime]
        //     Queue<int []> q = new PriorityQueue<>((a, b) -> (a[2] != b[2] ? a[2]-b[2] : a[0]-b[0]));   // idx sorting ???
        //     Collections.sort(tass, (a, b)->(a[1]-b[1])); // enq time
        //     int [] res = new int [n];
        //     int idx = 0, i = 0, now = 0;
        //     while (idx < n) {
        //         if (q.isEmpty()) 
        //             now = Math.max(now, tass.get(i)[1]);
        //         while (i < n && tass.get(i)[1] <= now) q.offer(tass.get(i++));
        //         int [] cur = q.poll();
        //         res[idx++] = cur[0];
        //         now += cur[2];
        //     }
        //     return res;
        // }

        
    
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{1,2},{2,4},{3,2},{4,1}};
        // int [][] a = new int [][] {{7,10},{7,12},{7,5},{7,4},{7,2}};
        int [][] a = new int [][] {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};

        int [] res = s.getOrder(a);
        System.out.println(Arrays.toString(res));
    }
}