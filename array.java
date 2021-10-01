import com.TreeNode;
import com.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class array {
    public static class Solution {

        // public int maximumWealth(int[][] accounts) {
        //     if (accounts.length == 1 && accounts[0].length == 1) return accounts[0][0];
        //     int m = accounts.length;
        //     int n = accounts[0].length;
        //     int [] res =  new int[m];
        //     int wealth = 0, idx = 0;
        //     for (int i = 0; i < m; i++) {
        //         wealth = 0;
        //         for (int j = 0; j < n; j++) {
        //             wealth += accounts[i][j];
        //         }
        //         res[i] = wealth;
        //     }
        //     wealth = 0;
        //     for (int i = 0; i < m; i++) {
        //         if (res[i] > wealth) wealth = res[i];
        //     }
        //     return wealth;
        // }


        // public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean desc) {
        //     List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        //     if (!desc) {
        //         list.sort(Map.Entry.comparingByValue());
        //     } else {
        //         list.sort(Map.Entry.<K, V>comparingByValue().reversed());
        //     }
        //     Map<K, V> result = new LinkedHashMap<>();
        //     for (Map.Entry<K, V> entry : list) {
        //         result.put(entry.getKey(), entry.getValue());
        //     }
        //     return result;
        // }
        // public int[] kWeakestRows(int[][] mat, int k) {
        //     int [] res = new int[k];
        //     int n = mat.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int cnt = 0, min = 0;
        //     for (int i = 0; i < n; i++) {
        //         cnt = 0;
        //         for (int j = 0; j < mat[0].length; j++) {
        //             if (mat[i][j] == 1) {
        //                 ++cnt;
        //             }
        //         }
        //         if (cnt < min) {
        //             min = cnt;
        //         }
        //         m.put(i, cnt);
        //     }
        //     m = sortByValue(m, false);
        //     cnt = 0;
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         if (cnt <= k-1) {
        //             res[cnt] = entry.getKey();
        //             ++cnt;
        //         } 
        //     }
        //     return res;
        // }

        // public int peakIndexInMountaiRecursivenArray(int[] arr, int bgn, int end) {
        //     if (bgn == end) return bgn;
        //     if (bgn == end -1) {
        //         return (arr[bgn] > arr[end] ? bgn : end);
        //     }
        //     int mid = bgn + (end - bgn) / 2;
        //     if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
        //         return peakIndexInMountaiRecursivenArray(arr, mid+1, end);
        //     } else if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
        //         return mid;
        //     } else if (arr[mid] < arr[mid-1]) {
        //         return peakIndexInMountaiRecursivenArray(arr, bgn, mid-1);
        //     }
        //     return -1;
        // }
        // public int peakIndexInMountainArray(int[] arr) {
        //     return peakIndexInMountaiRecursivenArray(arr, 0, arr.length-1);
        // }

        // public int[] buildArray(int[] nums) {
        //     if (nums.length == 1) return nums;
        //     int n = nums.length;
        //     int [] res = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         res[i] = nums[nums[i]];
        //     }
        //     return res;
        // }

        // private int findElementFromSortedArray ( int [] arr, int val, int bgn, int end) {
        //     if (bgn > end) return -1;
        //     if (bgn == end && arr[bgn] == val) return bgn;
        //     int mid = bgn + (end - bgn) / 2;

        //     if (arr[mid] == val) {
        //         while (mid >= bgn && arr[mid] == val) --mid;
        //         mid += 1;
        //         return mid;
        //     }
        //     if (arr[mid] < val) {
        //         return findElementFromSortedArray(arr, val, mid+1, end);
        //     } else {
        //         return findElementFromSortedArray(arr, val, bgn, mid-1);
        //     }
        // }
        // public int[] smallerNumbersThanCurrent(int[] nums) {
        //     if (nums.length == 2) return nums[0] < nums[1] ? new int [] {0, 1} : new int [] {1, 0};
        //     int n = nums.length;
        //     int [] arr = new int [n];
        //     int [] res = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         arr[i] = nums[i];
        //     }
        //     Arrays.sort(arr);
        //     for (int i = 0; i < n; i++) {
        //         res[i] = findElementFromSortedArray(arr, nums[i], 0, n-1);
        //     }
        //     return res;
        // }

        // private int findIdx(int [] arr, int val) {
        //     int n = arr.length;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == val) return i;
        //     }
        //     return -1;
        // }
        // public String restoreString(String s, int[] indices) {
        //     if (s.length() == 1) return s;
        //     int n = indices.length;
        //     StringBuilder res = new StringBuilder();
        //     for (int i = 0; i < n; i++) {
        //         res.append(s.charAt(findIdx(indices, i)));
        //     }
        //     return res.toString();
        // }

        // public int[] decode(int[] encoded, int first) {
        //     if (encoded.length == 1) return new int [] {first, first ^ encoded[0]};
        //     int n = encoded.length + 1;
        //     int [] res = new int [n];
        //     res[0] = first;
        //     for (int i = 1; i < n; i++) {
        //         res[i] = res[i-1] ^ encoded[i-1];
        //     }
        //     return res;
        // }

        // public int[] decompressRLElist(int[] nums) {
        //     List<Integer> l = new ArrayList<>();
        //     int n = nums.length;
        //     int val = 0;
        //     for (int i = 0; i < n; i += 2) {
        //         val = nums[i];
        //         for (int j = i+1; j < n && j > i; j++) {
        //             while (val > 0) {
        //                 l.add(nums[j]);
        //                 --val;
        //             }
        //         }
        //     }
        //     int [] res = new int [l.size()];
        //     for (int i = 0; i < l.size(); i++) {
        //         res[i] = l.get(i);
        //     }
        //     return res;
        // }

        // public int[] createTargetArray(int[] nums, int[] index) {
        //     List<Integer> l = new ArrayList<>();
        //     int n = nums.length;
        //     int val = 0;
        //     for (int i = 0; i < n; i++) {
        //         l.add(index[i], nums[i]);
        //     }
        //     int [] res = new int [l.size()];
        //     for (int i = 0; i < l.size(); i++) {
        //         res[i] = l.get(i);
        //     }
        //     return res;
        // }

        // public int[] countPoints(int[][] points, int[][] queries) {
        //     if (points.length == 1) return new int [] {
        //         Math.pow((points[0][0] - queries[0][0]), 2) + Math.pow((points[0][1] - queries[0][1]), 2) <= queries[0][2] * queries[0][2] ? 1 : 0
        //     };
        //     int n = queries.length;
        //     int m = points.length;
        //     int x = 0;
        //     int y = 0;
        //     int r = 0;
        //     int a = 0, b = 0;
        //     int cnt = 0;
        //     int [] res = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         x = queries[i][0];
        //         y = queries[i][1];
        //         r = queries[i][2];
        //         cnt = 0;
        //         for (int j = 0; j < m; j++) {
        //             a = points[j][0];
        //             b = points[j][1];
        //             if (Math.abs(a - x) > r && Math.abs(b - y) > r) continue;
        //             if (Math.pow((a - x), 2) + Math.pow((b - y), 2) <= r * r) ++cnt;
        //         }
        //         res[i] = cnt;
        //     }
        //     return res;
        // }

        // public int[] minOperations(String boxes) {
        //     if (boxes.length() == 1) return new int [] {0};
        //     int n = boxes.length();
        //     int [] res = new int[n];
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         cnt = 0;
        //         for (int j = 0; j < n; j++) {
        //             if (j == i) continue;
        //             if (boxes.charAt(j) == '1') cnt += Math.abs(j - i);
        //         }
        //         System.out.println("cnt: " + cnt);
        //         res[i] = cnt;
        //     }
        //     return res;
        // }

        // public int maxIncreaseKeepingSkyline(int [][] grid) {
        //     int m = grid.length;
        //     int n = grid[0].length;
        //     int [][] arr = new int [m+1][n+1];
        //     int cnt = 0, max = 0;
            
        //     for (int i = 0; i < m; i++) {
        //         max = grid[i][0];
        //         for (int j = 1; j < n; j++) {
        //             if (grid[i][j] > max) max = grid[i][j];
        //         }
        //         arr[i][n] = max;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         max = grid[0][i];
        //         for (int j = 1; j < m; j++) {
        //             if (grid[j][i] > max) max = grid[j][i];
        //         }
        //         arr[m][i] = max;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             arr[i][j] = Math.min(arr[i][n], arr[m][j]);
        //             cnt += arr[i][j] - grid[i][j];
        //         }
        //     }
        //     return cnt;
        // }

        // public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //     List<Integer> l = new ArrayList<>();
        //     List<List<Integer>> ll = new ArrayList<>();
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     int n = groupSizes.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (groupSizes[i] == 1) {
        //             l = new ArrayList<>();
        //             l.add(i);
        //             ll.add(l);
        //         } else {
        //             if (m.containsKey(groupSizes[i])) {
        //                 l = m.get(groupSizes[i]);
        //                 l.add(i);
        //                 m.put(groupSizes[i], l);
        //             } else {
        //                 l = new ArrayList<>();
        //                 l.add(i);
        //                 m.put(groupSizes[i], l);
        //             }
        //         }
        //     }
        //     int groups = 0;
        //     int numGroups = 0;
        //     int i = 0;
        //     List<Integer> g = new ArrayList<>();
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //         groups = entry.getValue().size() / entry.getKey();
        //         numGroups = 0;
        //         g = entry.getValue();
        //         i = 0;
        //         while (numGroups < groups) {
        //             cnt = 0;
        //             l = new ArrayList<>();
        //             while (cnt < entry.getKey()) {
        //                 l.add(g.get(i));
        //                 ++cnt;
        //                 ++i;
        //             }
        //             ll.add(l);
        //             ++numGroups;
        //         }
        //     }
        //     return ll;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {3,3,3,3,3,1,3}; 
        // int [] a = new int [] {2,1,3,3,3,2}; 

        List<List<Integer>> res = s.groupThePeople(a);
        // System.out.println("res: " + res);
        
        System.out.println("");
        System.out.println("res.size(): " + res.size());
        for (int i = 0; i < res.size(); ++i)  {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j)  + ", ");
            }
            System.out.print("\n");
        }

    }
}
