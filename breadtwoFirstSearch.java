import com.UnionFind;
import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
// import javafx.util.Pair;

import static java.util.stream.Collectors.toMap;

public class breadtwoFirstSearch {
    public static class Solution {


        // public int minWastedSpace(int[] packages, int[][] boxes) {
        //     long MOD = (long) (Math.pow(10, 9) + 7);
        //     Arrays.sort(packages);
        //     int len = packages.length;
        //     long sum = 0L;
        //     for (int p : packages) 
        //         sum += p;
        //     long res = Long.MAX_VALUE;
        //     for (int[] sizes : boxes) {
        //         Arrays.sort(sizes);
        //         if (sizes[sizes.length - 1] < packages[len - 1]) 
        //             continue;
        //         int start = 0;
        //         int end = 0;
        //         long waste = 0;
        //         long cost = 0;
        //         for (int size : sizes) {
        //             end = helper(packages, size);
        //             cost += (long) size * (end - start);
        //             start = end;
        //         }
        //         waste = cost - sum;
        //         res = Math.min(res, waste);
        //     }
        //     return res == Long.MAX_VALUE ? -1 : (int) (res % MOD);
        // }
        // private int helper(int[] packages, int size) {
        //     int left = 0;
        //     int right = packages.length;
        //     while (left < right) {
        //         int mid = left + (right - left) / 2;
        //         if (packages[mid] <= size) {
        //             left = mid + 1;
        //         } else {
        //             right = mid;
        //         }
        //     }
        //     return left;
        // }
        // // private int binarySearch(int [] arr, int v, int l, int r) {
        // private int binarySearch(int [] arr, int v) {
        //     int l = 0;
        //     int r = arr.length-1;
        //     while (l < r) {
        //         int m = l + (r-l)/2;
        //         if (arr[m] <= v) l = m+1;
        //         else r = m;
        //     }
        //     return l;
        //     // if (l == r) return l;
        //     // if (l == r -1) return arr[r] <= v ? r : l;
        //     // int m = l + (r-l)/2;
        //     // if (arr[m] <= v) return binarySearch(arr, v, m, r);
        //     // return binarySearch(arr, v, l, m-1);
        // }
        // public int minWastedSpace(int[] packages, int[][] boxes) {
        //     int n = packages.length;
        //     int m = boxes.length;
        //     Arrays.sort(packages);
        //     for (int i = 0; i < boxes.length; i++) 
        //         Arrays.sort(boxes[i]);
        //     int [] pre = new int[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         pre[i] = pre[i-1] + packages[i-1];
        //     List<Integer> tmp = new ArrayList<>();
        //     long min = Long.MAX_VALUE;
        //     long cur = 0;
        //     int k = 0, l = 0;
        //     for (int i = 0; i < boxes.length; i++) {
        //         cur = 0;
        //         if (boxes[i].length == 0 || boxes[i][boxes[i].length-1] < packages[n-1]) continue;
        //         l = 0;
        //         for (int j = 0; j < boxes[i].length; j++) {
        //             if (boxes[i][j] < packages[l]) continue;
        //             // k = binarySearch(packages, boxes[i][j], l, packages.length-1);
        //             k = binarySearch(packages, boxes[i][j]);
        //             cur += (long)(k-l)*boxes[i][j];
        //             l = k;
        //             if (l == packages.length) break;
        //         }
        //         min = Math.min(min, (long)(cur-pre[n]));
        //     }
        //     return min == Long.MAX_VALUE ? -1 : (int)(min % 1000000007);
        // }

        // private int binarySearch(int [][] arr, int [] v, int l, int r) {
        //     // if (v[1] == 15) {
        //     //     System.out.println("\nl: " + l);
        //     //     System.out.println("r: " + r);
        //     // }
        //     if (l == r) return (arr[l][1] >= v[1]) ? l : -1;
        //     else if (l == r-1) {
        //         if (arr[l][1] != arr[r][1]) {
        //             if (arr[l][1] < v[1]) return arr[r][1] >= v[1] ? r : -1;
        //             if (arr[l][1] >= v[1]) {
        //                 if (Math.abs(arr[l][0]-v[0]) <= Math.abs(arr[r][0]-v[0]))
        //                     return l;
        //                 else return r;
        //             }
        //         } else {
        //             if (arr[l][1] >= v[1])
        //                 return Math.abs(arr[l][0]-v[0]) <= Math.abs(arr[r][0]-v[0]) ? l : r;
        //             else return -1;
        //         }
        //     }
        //     int m = l + (r-l)/2;
        //     // if (v[1] == 15) {
        //     //     // System.out.println("\nl: " + l);
        //     //     // System.out.println("r: " + r);
        //     //     System.out.println("m: " + m);
        //     // }
        //     if (arr[m][1] < v[1]) return binarySearch(arr, v, m+1, r);
        //     return binarySearch(arr, v, l, m);
        // }
        // public int[] closestRoom(int[][] rooms, int[][] queries) {
        //     int n = rooms.length;
        //     int m = queries.length;
        //     // Map<Integer, int []> m = new HashMap<>();
        //     // for (int i = 0; i < m; i++) 
        //     //     m.put(i, queries[i]);
        //     // Comparator<Map.Entry<Integer, int[]>> ptimeThenIdx = new Comparator<Map.Entry<Integer, int []>> () {
        //     //     @Override 
        //     //     public int compare(Map.Entry<Integer, int []> a, Map.Entry<Integer, int []> b) {
        //     //         int cmp = (a.getValue())[1] - (b.getValue())[1];
        //     //         if (cmp != 0) {
        //     //             return cmp;
        //     //         } else {
        //     //             return (a.getValue())[0] - (b.getValue())[0];
        //     //         }
        //     //     }
        //     // };
        //     // Map<Integer, int []> map = map.entrySet().stream().sorted(ptimeThenIdx)
        //     //     .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     // System.out.println("map.size(): " + map.size());
        //     // for (Map.Entry<Integer, int []> entry : map.entrySet()) 
        //     //     System.out.print(entry.getKey() + ": (" + entry.getValue()[0] + "," + entry.getValue()[1] + ") \n");
        //     Arrays.sort(rooms, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[1] - b[1];
        //                 if (cmp != 0) return cmp;
        //                 return a[0] - b[0];
        //             }
        //         });
        //     System.out.println("rooms.length: " + rooms.length);
        //     for (int z = 0; z < rooms.length; ++z) {
        //         for (int w = 0; w < rooms[z].length; w++) 
        //             System.out.print(rooms[z][w] + ", ");
        //         System.out.print("\n");
        //     }
        //     int [] res = new int [m];
        //     int idx = 0, minId = 0, minDiff = Integer.MAX_VALUE;
        //     // for (Map.Entry<Integer, int []> entry : map.entrySet()) {
        //     //     idx = binarySearch(rooms, entry.getValue()[1]);
        //     //     if (idx != -1) {
        //     //         // if (Math.abs(idx - entry.getValue()[0]) < )
        //     //     }
        //     // }
        //     int size = 0;
        //     Set<Integer> s = new HashSet<>();
        //     for (int i = 0; i < m; i++) {
        //         size = queries[i][1];
        //         // System.out.println("\nsize: " + size);
        //         // System.out.println("queries[i].length: " + queries[i].length);
        //         // for (int z = 0; z < queries[i].length; ++z) 
        //         //     System.out.print(queries[i][z] + ", ");
        //         // System.out.println("");

        //         idx = binarySearch(rooms, queries[i], 0, rooms.length-1);
        //         // System.out.println("idx: " + idx);

        //         if (idx == -1) {
        //             res[i] = -1;
        //             continue;
        //         }
        //         if (idx == rooms.length-1) minId = rooms[idx][0];
        //         s.clear();
        //         s = IntStream.range(idx, rooms.length).map(k->rooms[k][0]).boxed().collect(Collectors.toSet());
        //         // System.out.println("s.size(): " + s.size());
        //         // for (Integer z : s)
        //         //     System.out.print(z + ", ");
        //         // System.out.print("\n");
                         
        //         if (idx < rooms.length-1) {
        //             if (s.contains(queries[i][0])) {
        //                 res[i] = queries[i][0];
        //                 // System.out.println("res[i]: " + res[i]);
        //                 continue;
        //             }
        //             minId = rooms[idx][0];
        //             minDiff = Integer.MAX_VALUE;
        //             for (Integer v : s) {
        //                 if (Math.abs(v-queries[i][0]) < minDiff) {
        //                     minDiff = Math.abs(v-queries[i][0]);
        //                     minId = v;
        //                 }
        //             }
        //         }
        //         res[i] = minId;
        //         // System.out.println("res[i]: " + res[i]);
        //     }
        //     return res;
        // }
        // 需要对两个 input 数组排序，尽量把 roomSize 大的房间分配给需求大的人，同时我也把roomSize大的房间尽量放在前面。
        // 这时候我还需要一个 treeset，同时开始遍历 queries。
        // 对于每一个 query，只有当房间size满足当前这个人的 minSize，我才把 roomId 加入treeset。
        // 这样当我把满足当前这个人的 minSize 的所有房间 ID 都记录好之后，我再利用treeset的函数去找到往上和往下最接近 preferredId 的房间号。
        // 时间O(nlogn)
        //     空间O(n)
        // public int[] closestRoom(int[][] rooms, int[][] queries) {
        //     int[] res = new int[queries.length];
        //     int[][] qs = new int[queries.length][];
        //     for (int i = 0; i < queries.length; i++) {
        //         // { preferredID, minSize, i }
        //         qs[i] = new int[] { queries[i][0], queries[i][1], i };
        //     }
        //     // 按room size从大到小排序10
        //     Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        //     // 按minSize从大到小排序12
        //     Arrays.sort(qs, (a, b) -> b[1] - a[1]);
        //     int i = 0;
        //     TreeSet treeset = new TreeSet<>();
        //     for (int[] q : qs) {
        //         for (; i < rooms.length && rooms[i][1] >= q[1]; i++) {
        //             treeset.add(rooms[i][0]);
        //         }
        //         Integer ans1 = (Integer)treeset.floor(q[0]);
        //         Integer ans2 = (Integer)treeset.ceiling(q[0]);
        //         if (ans1 != null && ans2 != null) {
        //             res[q[2]] = q[0] - ans1 <= ans2 - q[0] ? ans1 : ans2;
        //         } else {
        //             res[q[2]] = ans1 == null && ans2 == null ? -1 : ans1 == null ? ans2 : ans1;
        //         }
        //     }
        //     return res;
        // }


        // private int binarySearch(MountainArray arr, int l, int r) {
        //     if (l == r) return l;
        //     if (l == r-1) return arr.get(l) > arr.get(r) ? l : r;
        //     int m = l + (r-l)/2;
        //     if (arr.get(m-1) < arr.get(m) && arr.get(m) > arr.get(m+1)) return m;
        //     if (arr.get(m-1) < arr.get(m) && arr.get(m) < arr.get(m+1)) return binarySearch(arr, m, r);
        //     return binarySearch(arr, l, m-1);
        // }
        // private int binarySearchTargetIncreasing(MountainArray arr, int v, int l, int r) {
        //     if (l == r) return arr.get(l) == v ? l : -1;
        //     if (l == r-1) return arr.get(l) == v ? l : (arr.get(r) == v ? r : -1);
        //     int m = l +(r-l)/2;
        //     if (arr.get(m) == v) return m;
        //     if (arr.get(m) < v) return binarySearchTargetIncreasing(arr, v, m+1, r);
        //     return binarySearchTargetIncreasing(arr, v, l, m-1);
        // }
        // private int binarySearchTargetDecreasing(MountainArray arr, int v, int l, int r) {
        //     if (l == r) return arr.get(l) == v ? l : -1;
        //     if (l == r-1) return arr.get(l) == v ? l : (arr.get(r) == v ? r : -1);
        //     int m = l +(r-l)/2;
        //     if (arr.get(m) == v) return m;
        //     if (arr.get(m) < v) return binarySearchTargetIncreasing(arr, v, l, m-1);
        //     return binarySearchTargetIncreasing(arr, v, m+1, r);
        // }
        // public int findInMountainArray(int target, MountainArray mountainArr) {
        //     int n = mountainArr.length();
        //     int idx = binarySearch(mountainArr, 0, n-1);
        //     int left = binarySearchTargetIncreasing(mountainArr, target, 0, idx);
        //     if (left != -1) return left;
        //     return binarySearchTargetDecreasing(mountainArr, target, idx, n-1);
        // }

        // // 动态规划
        // public int maxEnvelopes(int[][] envelopes) {
        //     int m = envelopes.length;
        //     Arrays.sort(envelopes, (x, y) -> x[0]-y[0]);
        //     int [] dp = new int[envelopes.length];
        //     Arrays.fill(dp, 1);
        //     int max = 0;
        //     for (int i = 1; i < envelopes.length; i++) {
        //         for (int j = 0; j < i; j++) {
        //             if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
        //                 dp[i] = Math.max(dp[i], dp[j]+1);
        //         }
        //         max = Math.max(max, dp[i]);
        //     }
        //     return max;
        // }
        // // 这个二分查找在这里的应用还不是很清楚，要再想一下
        // public int maxEnvelopes(int[][] envelopes) {
        //     Arrays.sort(envelopes, new Comparator<int []>() {
        //             @Override public int compare(int [] a, int [] b) {
        //                 int cmp = a[0] - b[0];
        //                 if (cmp != 0) return cmp;
        //                 return b[1]-a[1];
        //             }
        //         });
        //     // System.out.println("envelopes.length: " + envelopes.length);
        //     // for (int z = 0; z < envelopes.length; ++z) {
        //     //     for (int w = 0; w < envelopes[z].length; w++) 
        //     //         System.out.print(envelopes[z][w] + ", ");
        //     //     System.out.print("\n");
        //     // }
        //     int cnt = 0;
        //     int [][] arr = new int [envelopes.length][2];
        //     for (int i = 0; i < envelopes.length; i++) {
        //         int left = 0;
        //         int right = cnt;
        //         while (left < right) {
        //             int mid = left + (right - left) / 2;
        //             if (arr[mid][1] >= envelopes[i][1]) right = mid;
        //             else left = mid + 1;
        //         }
        //         // System.out.println("left: " + left);
        //         arr[left] = envelopes[i];
        //         if (left == cnt) cnt++;
        //     }
        //     return cnt;
        // }

        
        // public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        //     int m = arr1.length;
        //     int n = arr2.length;
        //     int [] snd = IntStream.range(0, arr2.length).map(i->arr2[i]).distinct().toArray();
        //     Arrays.sort(snd);
        //     System.out.println("snd.length: " + snd.length);
        //     for (int z = 0; z < snd.length; ++z) 
        //         System.out.print(snd[z] + ", ");
        //     System.out.println("");
        //     int [][] dp = new int [m][n];
        //     for (int i = 1; i < m; i++) {
        //         if (arr1[i] > )
        //     }
        //     return 0;
        // }
        // int []  a = new int []  {1, 5, 3, 6, 7};
        // int []  b = new int []  {1, 3, 2, 4};

        // private int binaarySearch(List<Integer> li, int v, int l, int r) {
        //     while (l < r) {
        //         int m = l + (r-l)/2;
        //         if (li.get(m) < v) l = m+1;
        //         else r = m;
        //     }
        //     return l;
        // }
        // private int findLongestIncreasingSequence(List<Integer> l) {
        //     List<Integer> li = new ArrayList<>();
        //     li.add(l.get(0));
        //     for (int i = 1; i < l.size(); i++) {
        //         if (l.get(i) > li.get(li.size()-1)) li.add(l.get(i));
        //         else if (l.get(i) == li.get(li.size()-1)) continue;
        //         else {
        //             int idx = binaarySearch(li, l.get(i), 0, li.size()-1);
        //             li.set(idx, l.get(i));
        //         }
        //     }
        //     return li.size();
        // }
        // public int minimumMountainRemovals(int[] nums) {
        //     int n = nums.length;
        //     if (n == 3) return 0;
        //     int [] left = new int[n];
        //     int [] right = new int [n];
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 1; i < n-1; i++) {
        //         System.out.println("i: " + i);
        //         for (int j = 0; j < i; j++) {
        //             List<Integer> l = IntStream.rangeClosed(0, i).map(k->nums[k]).boxed().collect(Collectors.toList());
        //             // System.out.println("l.size(): " + l.size());
        //             // for (int z = 0; z < l.size(); ++z) 
        //             //     System.out.print(l.get(z) + ", ");
        //             // System.out.print("\n");
        //             left[i] = findLongestIncreasingSequence(l);
        //             int [] tmp = IntStream.rangeClosed(i, n-1).map(k->nums[n-1-k]).toArray();
        //             List<Integer> r = new ArrayList<>();
        //             for (int k = tmp.length-1; k >= 0; k--) 
        //                 r.add(tmp[k]);
        //             // System.out.println("r.size(): " + r.size());
        //             // for (int z = 0; z < r.size(); ++z) 
        //             //     System.out.print(r.get(z) + ", ");
        //             // System.out.print("\n");
        //             right[i] = findLongestIncreasingSequence(r);
        //             // System.out.println("left[i]: " + left[i]);
        //             // System.out.println("right[i]: " + right[i]);
        //             min = Math.min(min, n-(left[i] + right[i] -1));
        //             // System.out.println("min: " + min);
        //         }
        //     }
        //     return min;
        // }
        // public int minimumMountainRemovals(int[] nums) {
        //     int n = nums.length;
        //     int [] ldp = new int[n];
        //     int [] rdp = new int[n];
        //     Arrays.fill(ldp, 1);
        //     Arrays.fill(rdp, 1);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             if (nums[j] < nums[i])
        //                 ldp[i] = Math.max(ldp[i], ldp[j]+1);
        //         }
        //     }
        //     for (int i = n-1; i >= 0; i--) {
        //         for (int j = i+1; j < n; j++) {
        //             if (nums[j] < nums[i])
        //                 rdp[i] = Math.max(rdp[i], rdp[j]+1);
        //         }
        //     }
        //     int min = n;
        //     for (int i = 1; i < n-1; i++) {
        //         if (ldp[i] == 1 || rdp[i] == 1) continue;
        //         min = Math.min(min, n - (ldp[i] + rdp[i] - 1));
        //     }
        //     return min;
        // }

        // private class St {
        //     int i;
        //     int j;
        //     int h;
        //     int v;
        //     public St(int a, int b, int c, int d) {
        //         i = a;
        //         j = b;
        //         h = c;
        //         v = d;
        //     }
        //     public boolean equals(int a, int b, int c, int d) {
        //         return i == a && j == b && h == c && v == d;
        //     }
        // }
        // boolean isRightValid (int [][] arr, int x, int y, int h) { // 这些检查不够严格，需要改进
        //     return ((h == 0 && y+2 < n && arr[x][y+1] != 1 && arr[x][y+2] != 1)
        //             || (h == 1 && y+1 < n && x+1 < n && arr[x][y+1] != 1 && arr[x+1][y+1] != 1));
        // }
        // boolean isDownValid (int [][] arr, int x, int y, int h) {
        //     return (x+1 < n && arr[x+1][y] != 1 && (h == 1 || arr[x+1][y+1] != 1));
        // }
        // boolean isClockValid (int [][] arr, int x, int y, int h) {
        //     return (h == 0 && x+1 < n && arr[x+1][y] != 1 && y+1 < n && arr[x+1][y+1] != 1);
        // }
        // boolean isAntiClockValid (int [][] arr, int x, int y, int h) {
        //     return (h == 1 && y+1 < n && arr[x][y+1] != 1 && x+1 < n && arr[x+1][y+1] != 1);
        // }
        // private int bfs(int [][] arr, int x, int y) { // hor: 0 horizontal, 1 vertical
        //     Queue<St []> q = new LinkedList<>();
        //     St cur = null, pre = null;
        //     int i = 0, j = 0;
        //     Set<St []> ss = new HashSet<>();
        //     Set<St []> next = new HashSet<>();
        //     ss.add(new St [] {new St(x, y, 0, 0), new St(x, y, 0, 0)});
        //     int cnt = 0;
        //     while (true) {
        //         for (St[] sts : ss)  // cur, pre combination
        //             q.add(sts);
        //         ss.clear();
        //         while (!q.isEmpty()) {
        //             cur = q.peek()[0];
        //             pre = q.poll()[1];
        //             i = cur.i;
        //             j = cur.j;
        //             if (cur.h == 0 && (j+1 >= n || arr[i][j] == 1 || arr[i][j+1] == 1)) continue;
        //             else if (cur.h == 1 && (i+1 >= n ||  arr[i][j] == 1 || arr[i+1][j] == 1)) continue;
        //             if (vis[i][j][cur.h == 0 ? i : i+1]) continue;
        //             if (i == n-1 && j == n-2 && cur.h == 0) return cnt;
        //             if (isRightValid(arr, i, j, cur.h) && !pre.equals(i, j+1, cur.h, cur.v-1)) next.add(new St[]{new St(i, j+1, cur.h, cur.v+1), cur});
        //             if (isDownValid(arr, i, j, cur.h) && !pre.equals(i+1, j, cur.h, cur.v-1)) next.add(new St[] {new St(i+1, j, cur.h, cur.v+1), cur});
        //             if (isClockValid(arr, i, j, cur.h) && !pre.equals(i, j, 1, cur.v-1)) next.add(new St[] {new St(i, j, 1, cur.v+1), cur});
        //             if (isAntiClockValid(arr, i, j, cur.h) && !pre.equals(i, j, 0, cur.v-1)) next.add(new St[] {new St(i, j, 0, cur.v+1), cur});
        //             vis[i][j][cur.h == 0 ? i : i+1] = true;
        //         }
        //         ++cnt;
        //         if (next.size() > 0)
        //         ss.addAll(next);
        //         else return -1;
        //         next.clear();
        //     } 
        // }
        // boolean [][][] vis;
        // int n;
        // public int minimumMoves(int[][] grid) {
        //     n = grid.length;
        //     vis = new boolean [n][n][n];
        //    return bfs(grid, 0, 0);
        // }

        // private int[][] copyArray(int [][] arr) {
        //     int [][] res = new int[m][n];
        //     for (int i = 0; i < m; i++) 
        //         System.arraycopy(arr[i], 0, res[i], 0, n);
        //     return res;
        // }
        // private boolean isFinal(int [][] arr) {
        //     int i = 0;
        //     while (i < m*n-1 && arr[i/n][i%n] == i+1) ++i;
        //     return (i == 5 && arr[1][2] == 0);
        // }
        // private class St {
        //     int [][] arr;
        //     int v; // pre
        //     public St(int [][] a, int b) {
        //         arr = a;
        //         v = b;
        //     }
        //     public boolean equals(St b) {
        //         for (int i = 0; i < b.arr.length; i++) 
        //             for (int j = 0; j < b.arr[0].length; j++) 
        //                 if (arr[i][j] != b.arr[i][j]) return false;
        //         return true;
        //     }
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // private int bfs(int [][] arr) {
        //     Queue<St> q = new LinkedList<>();
        //     Set<St> sc = new HashSet<>(); // s of cur
        //     Set<St> sn = new HashSet<>(); // s of next
        //     sc.add(new St(arr, -1));
        //     int step = 0;
        //     St cur = null;
        //     int t = 0;
        //     while (sc.size() > 0) {
        //         for (St a : sc) 
        //             q.add(a);
        //         for (int x = 0; x < sc.size(); x++) {
        //             cur = q.poll();
        //             if (isFinal(cur.arr)) return step;
        //             // if (cur.equals(new St(arr, -1))) return -1;
        //             for (int i = 0; i < m; i++) {
        //                 for (int j = 0; j < n; j++) {
        //                     if (cur.arr[i][j] == 0) {
        //                         int [][] tmp = copyArray(cur.arr);
        //                         for (int [] d : dirs) {
        //                             if (i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n && cur.v != cur.arr[i+d[0]][j+d[1]]) {
        //                                 tmp[i][j] = cur.arr[i+d[0]][j+d[1]];
        //                                 tmp[i+d[0]][j+d[1]] = 0;
        //                                 sn.add(new St(copyArray(tmp), cur.arr[i+d[0]][j+d[1]]));
        //                                 tmp[i+d[0]][j+d[1]] = tmp[i][j];
        //                                 tmp[i][j] = 0;
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ++step;
        //     }
        //     return -1;
        // }
        // int m, n;
        // public int slidingPuzzle(int[][] board) {
        //     m = board.length;
        //     n = board[0].length;
        //     return bfs(board);
        // }  

        // public int slidingPuzzle(int[][] board) {
        //     int m = board.length;
        //     int n = board[0].length;
        //     StringBuilder s = new StringBuilder();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             s.append(board[i][j]);
        //     String t = s.toString();
        //     Queue<String> q = new LinkedList<>();
        //     q.add(t);
        //     Set<String> ss = new HashSet<>();
        //     ss.add(t);
        //     int [][] dirs = {
        //         {1,3},  // idx 0 can to 1 and 3
        //         {0,2,4},
        //         {1,5},
        //         {0,4},
        //         {1,3,5},
        //         {2,4}
        //     };
        //     int cnt = 0;
        //     // Queue<String> p = new LinkedList<>(); // next queue
        //     String cur = "";
        //     int idx = 0;
        //     while (!q.isEmpty()) {
        //         Queue<String> p = new LinkedList<>(); 
        //         // p.clear();
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             if ("123450".equals(cur)) return cnt;
        //             idx = cur.indexOf('0');
        //             for (int v : dirs[idx]) {
        //                 char [] arr = cur.toCharArray();
        //                 arr[idx] = arr[v];
        //                 arr[v] = '0';
        //                 String next = new String(arr);
        //                 if (!ss.contains(next)) {
        //                     ss.add(next);
        //                     p.add(next);
        //                 }
        //             }
        //         }
        //         q = p;
        //         ++cnt;
        //     }
        //     return -1;
        // }  


        // private boolean bfs(int bgn, int end) {
        //     Set<Integer> sn = new HashSet<>();
        //     Set<Integer> sc = new HashSet<>(ll.get(bgn));
        //     // Queue<Integer> q = new LinkedList<>();
        //     while (sc.size() > 0) {
        //         for (Integer v : sc) 
        //             if (v == end) return true;
        //         for (Integer v : sc) {
        //             for (Integer next : ll.get(v)) {
        //                 if (ll.get(bgn).contains(next)) continue;
        //                 if (!sn.contains(next)) sn.add(next);
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //     }
        //     return false;
        // }
        // List<List<Integer>> ll;
        // public boolean validPath(int n, int[][] edges, int start, int end) {
        //     if (start == end) return true;
        //     ll = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ll.add(new ArrayList<>());
        //     for (int i = 0; i < edges.length; i++) {
        //         ll.get(edges[i][0]).add(edges[i][1]);
        //         ll.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     return bfs(start, end);
        // }


        // private int bfsCuttingTrees(List<List<Integer>> ll, int c, int pre) {
        //     int ti = c / n, tj = c % n;
        //     Set<Integer> ss = new HashSet<>(); // visited
        //     Set<Integer> sc = new HashSet<>(); // cur 
        //     Set<Integer> sn = new HashSet<>(); // next
        //     sc.add(pre);
        //     Queue<Integer> q = new LinkedList<>();
        //     int cnt = 0, cur = 0;
        //     int i = 0, j = 0;
        //     while (sc.size() > 0) {
        //         for (Integer v : sc) 
        //             q.add(v);
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             i = cur / n;
        //             j = cur % n;
        //             if (i == ti && j == tj) return cnt;
        //             for (int [] d : dirs) {
        //                 if (i+d[0] >= 0 && i+d[0] < m && j+d[1] >= 0 && j+d[1] < n
        //                     && !ss.contains((i+d[0])*n+j+d[1]) && ll.get(i+d[0]).get(j+d[1]) != 0) {
        //                     sn.add((i+d[0])*n+j+d[1]);
        //                     ss.add((i+d[0])*n+j+d[1]);
        //                 }
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ++cnt;
        //     }
        //     return -1;
        // }
        // Map<Integer, Integer> map = new HashMap<>();
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int m, n;
        // public int cutOffTree(List<List<Integer>> forest) {
        //     m = forest.size();
        //     n = forest.get(0).size();
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) {
        //             if (forest.get(i).get(j) != 0)
        //                 map.put(forest.get(i).get(j), i*n+j);
        //         }
        //     Map<Integer, Integer> ms = map.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey()) // Comparator.reverseOrder()
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     int res = 0, pre = 0, k = 0, v = 0, tmp = 0;
        //     for (Map.Entry<Integer, Integer> en : ms.entrySet()) {
        //         k = en.getKey();
        //         v = en.getValue();
        //         if (k == 1) continue;
        //         if (en.getValue() == pre) {
        //             forest.get(v/n).set((v%n), 1);
        //             continue;
        //         }
        //         tmp = bfsCuttingTrees(forest, v, pre);
        //         if (tmp == -1) return -1;
        //         res += tmp;
        //         pre = v;
        //     }
        //     return res;
        // }
        

        // private String swap(String s, int i, int j) { // 这个里面还有bug，现在不想找它了，二刷的时候再仔细去想去找吧
        //     char [] arr = s.toCharArray();
        //     char tmp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = tmp;
        //     return new String(arr);
        // }
        // public int kSimilarity(String s, String t) {
        //     if (s.equals(t)) return 0;
        //     Queue<String> q = new LinkedList<>();
        //     Set<String> ss = new HashSet<>();
        //     q.add(s);
        //     ss.add(s);
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         cnt++;
        //         for (int x = q.size(); x > 0; x--) {
        //             String cur = q.remove();
        //             int j = 0;
        //             while (s.charAt(j) == t.charAt(j)) j++;
        //             for (int i = j+1; i < s.length(); i++) {
        //                 if (cur.charAt(i) == t.charAt(i) || cur.charAt(i) != t.charAt(j)) continue;
        //                 String tmp = swap(cur, i, j);
        //                 if (tmp.equals(t)) return cnt;
        //                 if (ss.add(tmp)) q.add(tmp);
        //             }
        //         }
        //     }
        //     return cnt;
        // }
        // private void swap(char [] arr, int i, int j) { // 这个方法和结果都是对的
        //     char tmp = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = tmp;
        // }
        // public List<String> neighbours(String s, String t) {
        //     List<String> ans = new ArrayList<>();
        //     int i = 0;
        //     for (; i < s.length(); ++i) 
        //         if (s.charAt(i) != t.charAt(i)) break;
        //     char [] sarr = s.toCharArray();
        //     for (int j = i+1; j < s.length(); j++) {
        //         if (s.charAt(j) == t.charAt(i)) {
        //             swap(sarr, i, j);
        //             ans.add(new String(sarr));
        //             swap(sarr, i, j);
        //         }
        //     }
        //     return ans;
        // }
        // // 我们可以使用广度优先搜索遍历所有的状态。
        // // 当我们把基础图 G 拆分为环并进行截断操作时，我们可以每次截断从左到右第一个 A[i] != B[i] 对应的那条边。
        // //     即在字符串 A 和 B 中，我们每次找到最左侧满足 A[i] != B[i] 的 i，并搜索满足 j > i 且 A[j] == B[i] 的 j。
        // public int kSimilarity(String s, String t) {
        //     Queue<String> q = new ArrayDeque();
        //     q.offer(s);
        //     Map<String, Integer> dist = new HashMap<>();
        //     dist.put(s, 0);
        //     while (!q.isEmpty()) {
        //         String cur = q.poll();
        //         if (cur.equals(t)) return dist.get(cur);
        //         for (String ss : neighbours(cur, t)) {
        //             if (!dist.containsKey(ss)) {
        //                 dist.put(ss, dist.get(cur) + 1);
        //                 q.offer(ss);
        //             }
        //         }
        //     }
        //     throw null;
        // }
        // 对于一个环, 我们可以用一个 01 数组表示每条边是否出现，例如对于环 a -> b -> d -> e -> a，它有 4 条边 a -> b，b -> d，d -> e 和 e -> a，那么它对应的数组中，有 4 个位置（这 4 条边对应的位置）的值为 1，其它值为 0。同样地，基础图 GG 也可以用这种方式来表示。
        // 因此我们可以使用动态规划来解决这个问题，令 numCycles(G) 表示基础图 GG 最多拆分的环的数目。我们枚举环 CC，检查 CC 是否包含于 GG。状态转移方程为 numCycles(G) = max{1 + numcycles(G - C)}
        // String [] alphabet = new String [] {"a", "b", "c", "d", "e", "f"};
        // Map<String, Integer> memo = new HashMap<>();
        // public int kSimilarity(String s, String t) {
        //     if (s.equals(t)) return 0;
        //     int n = s.length();
        //     memo = new HashMap<>();
        //     int ans = 0;
        //     int [] cnt = new int[alphabet.length * alphabet.length];
        //     for (int i = 0; i < n; i++) 
        //         if (s.charAt(i) != t.charAt(i)) {
        //             cnt[alphabet.length*(s.charAt(i)-'a') + t.charAt(i)-'a']++;
        //             ans++;
        //         }
        //     List<int []> possibles = new ArrayList<>();
        //     for (int size = 2; size <= alphabet.length; size++)   // Enumerate over every cycle
        //     search: for (String cycle: permutations(alphabet, 0, size)) {
        //             for (int i = 1; i < size; i++) 
        //                 if (cycle.charAt(i) < cycle.charAt(0))
        //                     continue search;
        //             int [] row = new int [cnt.length];
        //             for (int i = 0; i < size; i++) {
        //                 int u = cycle.charAt(i) - 'a';
        //                 int v = cycle.charAt((i+1) % size) - 'a';
        //                 row[alphabet.length*u + v]++;
        //             }
        //             possibles.add(row);
        //         }
        //     int [] ZERO = new int [cnt.length];
        //     memo.put(Arrays.toString(ZERO), 0);
        //     return ans - numCycles(possibles, cnt);
        // }
        // public int numCycles(List<int[]> possibles, int[] count) {
        //     String countS = Arrays.toString(count);
        //     if (memo.containsKey(countS)) return memo.get(countS);
        //     int ans = Integer.MIN_VALUE;
        // search: for (int[] row: possibles) {
        //         int[] count2 = count.clone();
        //         for (int i = 0; i < row.length; ++i) {
        //             if (count2[i] >= row[i])
        //                 count2[i] -= row[i];
        //             else continue search;
        //         }
        //         ans = Math.max(ans, 1 + numCycles(possibles, count2));
        //     }
        //     memo.put(countS, ans);
        //     return ans;
        // }
        // public List<String> permutations(String[] alphabet, int used, int size) {
        //     List<String> ans = new ArrayList();
        //     if (size == 0) {
        //         ans.add(new String(""));
        //         return ans;
        //     }
        //     for (int b = 0; b < alphabet.length; ++b)
        //         if (((used >> b) & 1) == 0)
        //             for (String rest: permutations(alphabet, used | (1 << b), size - 1))
        //                 ans.add(alphabet[b] + rest);
        //     return ans;
        // }


        public int shortestPath(int[][] grid, int k) {
            int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int m = grid.length;
            int n = grid[0].length;
            int [][] vis = new int [m][n];
            Queue<int []> q = new LinkedList<>();
            q.add(new int [] {0, 0, k});
            int [] cur = null;
            int cnt = 0, r = 0, c = 0, size = 0;
            while (!q.isEmpty()) {
                size = q.size();
                while (size > 0) {
                    --size;
                    cur = q.poll();
                    if (cur[0] == m-1 && cur[1] == n-1) return cnt;
                    for (int [] d : dirs) {
                        r = cur[0] + d[0];
                        c = cur[1] + d[1];
                        if (r >= 0 && r < m && c >= 0 && c < n) {
                            // 1.当前格子为非障碍物时，普通路径可以走访问状态为0的格子，走过后，访问状态更新为1
                            // 3.当前格子为非障碍物时，普通路径可以走访问状态为2的格子，走过后，访问状态更新为1
                            if (grid[r][c] == 0 && (vis[r][c] == 0 || vis[r][c] == 2 && cur[2] == k)) {
                                if (vis[r][c] == 0) 
                                    // 2.当前格子为非障碍物时，穿越路径可以走访问状态为0的格子，走过后，访问状态更新为2 
                                    vis[r][c] = (cur[2] == k ? 1 : 2);
                                else // if (vis[r][c] == 2 && v == k)
                                    vis[r][c] = 1;
                                q.offer(new int []{r, c, cur[2]});
                                // 4.当前格子为障碍物时，如果还保有穿越次数，并且该格子的访问状态为0时，所有路径可以通过此处，
                                //     通过后，该路径变为穿越路径，并且当前格子访问状态更新为1（更新为2也无所谓）                                
                            } else if (grid[r][c] == 1 && vis[r][c] == 0 && cur[2] > 0) {
                                vis[r][c] = 2;
                                q.offer(new int []{r, c, cur[2]-1});
                            }
                        }
                    }
                }
                ++cnt;
            }
            return -1;
        }
        // // 其实本题同样可以采用dfs，时间复杂度与bfs相同，但由于dfs中不需要使用Queue，因此执行效率略优于bfs。实现的核心逻辑与bfs完全相同
        // // int [][] a = new int [][] {{0,0},{1,0},{1,0},{1,0},{1,0},{1,0},{0,0},{0,1},{0,1},{0,1},{0,0},{1,0},{1,0},{0,0}};
        // // int r = s.shortestPath(a, 4);
        // private int dfs(int [][] arr, int x, int y, int z) { // 存在bug，暂时最好还是用bfs比较稳妥
        //     if (x == m-1 && y == n-1) return 0;
        //     int res = Integer.MAX_VALUE;
        //     int i = 0, j = 0, tmp = 0;
        //     for (int [] d : dirs) {
        //         i = x + d[0];
        //         j = y + d[1];
        //         if (i >= 0 && i < m && j >= 0 && j < n) {
        //             if (arr[i][j] == 0) {
        //                 if (vis[i][j] == 0) {
        //                     vis[i][j] = (z == k ? 1 : 2);
        //                     tmp = dfs(arr, i, j, z);
        //                     if (tmp != -1)
        //                         res = Math.min(res, tmp+1);
        //                 } else if (vis[i][j] == 2 && z == k) {
        //                     vis[i][j] = 1;
        //                     tmp = dfs(arr, i, j, z);
        //                     if (tmp != -1)
        //                         res = Math.min(res, tmp+1);
        //                 }
        //             } else if (z > 0 && vis[i][j] == 0) {
        //                 vis[i][j] = 2;
        //                 tmp = dfs(arr, i, j, z-1);
        //                 if (tmp != -1)
        //                     res = Math.min(res, tmp+1);
        //             }
        //         }
        //     }
        //     return res == Integer.MAX_VALUE ? -1 : res;
        // }
        // int [][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // int [][] vis;
        // int m, n, k;
        // public int shortestPath(int[][] grid, int kk) {
        //     m = grid.length;
        //     n = grid[0].length;
        //     k = kk;
        //     vis = new int [m][n];
        //     return dfs(grid, 0, 0, k);
        // }


        // // 基本的模式套路大家都懂得, 注意使用原始BFS后的优化：用空间换时间
        // // 用图存等于基本个元素的所有下标，以及设置连续相等数值的中间段为不可用提时
        // public int minJumps(int[] arr) {
        //     int n = arr.length;
        //     if (n == 1) return 0;
        //     boolean [] vis = new boolean [n];
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) {
        //         if (i-1 >= 0 && arr[i-1] == arr[i] && i+1 < n && arr[i] == arr[i+1]) {
        //             vis[i] = true;
        //             continue;
        //         }
        //         if (!m.containsKey(arr[i])) m.put(arr[i], new ArrayList<>());
        //         m.get(arr[i]).add(i);
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     Set<Integer> sc = new HashSet<>();
        //     Set<Integer> sn = new HashSet<>();
        //     sc.add(0);
        //     int cur = 0, cnt = 0;
        //     while (sc.size() > 0) {
        //         for (int v : sc) 
        //             q.offer(v);
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             if (cur == n-1) return cnt;
        //             vis[cur] = true;
        //             if (cur < n-1 && !vis[cur+1]) sn.add(cur+1);
        //             if (cur > 0 && !vis[cur-1]) sn.add(cur-1);
        //             // 注意这里原始的 BFS 会超时，应该注意优化：连续 [7,7,7,7,7] 之类其实只有首尾两个位置是有用的；同一个任意门只有第一次跳转是有用的。
        //             // map: for speed improvement, space exchange for time
        //             for (int v : m.get(arr[cur])) {
        //                 if (vis[v] || v == cur) continue;
        //                 if (v == n-1) return cnt+1;
        //                 sn.add(v);
        //             }
        //             m.put(arr[cur], new ArrayList<>());
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ++cnt;
        //     }
        //     return -1;
        // }


        // private double dfs(int n, int target, int idx, int t) {
        //     if (t < 0 || idx < 1 || idx > n) return 0;
        //     if (idx == target && t == 0) return 1.0; // 中间途经，从这里路过，t == 0
        //     if (dp[idx][t] != null) return dp[idx][t];
        //     vis[idx] = true;
        //     double res = 0;
        //     int cur = 0, cnt = 0;
        //     for (int i = 0; i < ll.get(idx).size(); i++) {
        //         cur = ll.get(idx).get(i);
        //         if (vis[cur]) continue;
        //         res += dfs(n, target, cur, t-1);
        //         ++cnt;
        //     }
        //     if (cnt == 0 && idx == target) return dp[idx][t] = 1.0; // 没有其它出路了，永远在这里跳
        //     return dp[idx][t] = cnt == 0 ? 0 : (double)(res/cnt);
        // }
        // List<List<Integer>> ll;
        // Double [][] dp;
        // boolean [] vis;
        // public double frogPosition(int n, int[][] edges, int t, int target) {
        //     ll = new ArrayList<>();
        //     for (int i = 0; i <= n; i++) 
        //         ll.add(new ArrayList<Integer>());
        //     for (int i = 0; i < edges.length; i++) {
        //         ll.get(edges[i][0]).add(edges[i][1]);
        //         ll.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     vis = new boolean [n+1];
        //     dp = new Double[n+1][t+1];
        //     dfs(n, target, 1, t);
        //     return dp[1][t];
        // }


        // public int numBusesToDestination(int[][] routes, int source, int target) {
        //     if (source == target) return 0;
        //     int n = routes.length, cnt = 0, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         Arrays.sort(routes[i]);
        //         max = Math.max(max, routes[i][routes[i].length-1]);
        //     }
        //     if (target > max) return -1;
        //     for (int i = 1; i < n; i++) 
        //         if (routes[i][0] == routes[i-1][routes[i-1].length-1]) ++cnt;
        //     if (cnt == n-1 && target == routes[n-1][routes[n-1].length-1]) return n;
        //     Set<Integer> sc = new HashSet<>();
        //     boolean [] vis = new boolean [n];
        //     for (int i = 0; i < n; i++) {
        //         if (!Arrays.stream(routes[i]).boxed().collect(Collectors.toList()).contains(source)) continue;
        //         for (int j = 0; j < routes[i].length; j++) 
        //             if (!sc.contains(routes[i][j])) sc.add(routes[i][j]);
        //         vis[i] = true;
        //     }
        //     Queue<Integer> q = new LinkedList<>();
        //     Set<Integer> ss = new HashSet<>(); // visited, 与vis[n]两者会重复吗: 应该是两者都有必要 
        //     ss.addAll(sc);
        //     Set<Integer> sn = new HashSet<>(); // next
        //     int cur = 0, step = 1;
        //     while (sc.size() > 0) {
        //         for (int v : sc) 
        //             q.offer(v);
        //         while (!q.isEmpty()) {
        //             cur = q.poll();
        //             if (cur == target) return step;
        //             for (int i = 0; i < n; i++) {
        //                 if (vis[i] || !Arrays.stream(routes[i]).boxed().collect(Collectors.toList()).contains(cur)) continue;
        //                 for (int j = 0; j < routes[i].length; j++) {
        //                     if (!ss.contains(routes[i][j]))
        //                         sn.add(routes[i][j]);
        //                 }
        //             }
        //         }
        //         sc.clear();
        //         sc.addAll(sn);
        //         sn.clear();
        //         ss.addAll(sc);
        //         ++step;
        //     }
        //     return -1;
        // }


        // public int[] findRedundantDirectedConnection(int[][] edges) { // bug bug bug to be found
        //     int n = edges.length;
        //     int[] one = {-1, -1}; // two ans candidates
        //     int[] two = {-1, -1};
        //     int [] par = new int [n + 1]; // parent array
        //     for (int i = 0; i < n; i++) { // 筛选出答案的两个candidate
        //         int [] e = edges[i];
        //         if (par[e[1]] == 0) par[e[1]] = e[0];
        //         else { // 当前节点e[1]有两个父节点: 有向图中，如果存在indegree(v) == 2的点，要删除的一定是这个点的某条有向边(u -> v)
        //             two = e;                           // 当前父节点边
        //             one = new int [] {par[e[1]], e[1]};// 另一条纪录过的构成父节点的边
        //             e[1] = 0;
        //         }
        //     }
        //     for (int i = 0; i < n; i++) par[i] = i;
        //     for (int i = 0; i < n; i++) {
        //         if (edges[i][1] == 0) continue;
        //         int kid = edges[i][1], far = edges[i][0];
        //         if (getParent(par, far) == kid) { // 检测到环的存在
        //             if (one[0] == -1) return edges[i]; // 不存在indegree(v) == 2 的点，那么直接删去最后一个造成环存在的有向边即可
        //             return one; // 入度为2有环：为什么删除的一定是先出现的那条构成父节点的入度边？？？
        //         }
        //         par[kid] = far;
        //     }
        //     return two;
        // }
        // int getParent(int [] par, int i) {
        //     while (i != par[i]) {
        //         par[i] = par[par[i]];
        //         i = par[i];
        //     }
        //     return i;
        // }
        class UnionFind {
            int[] parent;
            int[] rank;
            int size;
            public UnionFind(int size) {
                this.size = size;
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) parent[i] = i;
            }
            public int find(int x) {
                if (parent[x] != x) 
                    parent[x] = find(parent[x]);
                return parent[x];
            }
            public boolean union(int x, int y) { // return true if x, y has same parent
                int xp = find(x);
                int yp = find(y);
                if (xp == yp) return false;
                if (rank[xp] > rank[yp]) 
                    parent[yp] = xp;
                else if (rank[xp] < rank[yp]) 
                    parent[xp] = yp;
                else {
                    parent[yp] = xp;
                    rank[xp]++;
                }
                return true;
            }
        }
        // 对于有向图中，如果存在indegree(v) == 2的点，那么要删除的一定是这个点的某条有向边(u -> v)
        //    因为题目最后保证是一个rooted tree（every node has exactly one parent），具体看第一段定义；
        // 如果不存在indegree(v) == 2的点，那么直接删去最后一个造成环存在的有向边即可。
        // 现在存在三种情况：
        // （1）有向图中只有环。这种情况就简单将两个节点具有共同根节点的边删去就好。
        // （2）有向图中没有环，但有个节点有两个父节点。这种情况就将第二次出现不同父节点的边删去就好。
        // （3）有向图中既有环，而且有个节点还有两个父节点。这时就检测当除去第二次出现父节点的边后，剩余边是不是合法的，如果不合法证明应该删掉的是另一个父节点的边。
        public int[] findRedundantDirectedConnection(int[][] edges) {
            Set<Integer> points = new HashSet<>();
            Map<Integer, Integer> parent = new HashMap<>();
            List<int[]> candidates = new ArrayList<>();
            for (int[] edge: edges) { // u --> v 
                int u = edge[0];
                int v = edge[1];
                points.add(u);
                points.add(v);
                if (!parent.containsKey(v)) { // parent.putIfAbsent(v, u);
                    parent.put(v, u);
                    continue;
                }
                candidates.add(new int[] {parent.get(v), v}); // if a node has two parents, add to candidates list
                candidates.add(new int[] {u, v});
                edge[1] = -1; // invalidate the second edge
            }
            UnionFind uf = new UnionFind(points.size());
            for (int[] edge: edges) {
                if (edge[1] == -1) continue; // skip invalidated edge
                int u = edge[0] - 1;
                int v = edge[1] - 1;
                if (!uf.union(u, v)) {
// if we have invalidated the second edge
// yet still have a cycle
// we either just formed a cycle with this edge
// or there still exists a node with two parents
// which is the first edge stored in candidates.get(0)
                    if (candidates.isEmpty()) return edge; // 不存在indegree(v) == 2的点，直接删去最后一个造成环存在的有向边即可
                    return candidates.get(0); // 这里就是有点儿想不通: 应该是构成环的边一定是后于入度为2中的那条先出现的该返回同时构成环和入度的入度边
                }
            }
// no cycle found, meaning the redundant edge
            // is the second edge in the candidates
            return candidates.get(1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{1,2},{1,3},{2,3}};
        // int [][] a = new int [][] {{1,2},{2,3},{3,4},{4,1},{1,5}};

        int [] r = s.findRedundantDirectedConnection(a);

        System.out.println("r.length: " + r.length);
        for (int z = 0; z < r.length; ++z) 
            System.out.print(r[z] + ", ");
        System.out.println("");
    }
}