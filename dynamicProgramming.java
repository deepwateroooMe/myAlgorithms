import com.TreeNode;
// import com.MapUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class dynamicProgramming {
    public static class Solution {

        // public int fib(int n) {
        //     if (n == 1) return 0;
        //     if (n == 2) return 1;
        //     int [] arr = new int [n+1];
        //     if (n > 2) {
        //         arr[0] = 0;
        //         arr[1] = 1;
        //     }
        //     for (int i = 2; i < n+1; i++) {
        //         arr[i] = arr[i-1] + arr[i-2];
        //     }
        //     return arr[n];
        // }

        // public int[] countBits(int n) {
        //     if (n == 0) return new int [] {0};
        //     int [] res = new int [n+1];
        //     int cnt = 0;
        //     for (int i = 1; i < n+1; i++) {
        //         while (i >= 0) {
        //             if (i % 2 == 1) ++cnt;
        //             i = i >> 1;
        //         }
        //         res[i] = cnt;
        //         cnt = 0;
        //     }
        //     return res;
        // }

        // private int switchN (int n) {
        //     if (n < 2) return 0;
        //     else if (n >= 2 && n < 5) return 1;
        //     else if (n >= 5 && n < 6) return 2;
        //     else if (n >= 6 && n < 9) return 3;
        //     else return 4;
        // }
        // public int rotatedDigits(int n) {
        //     if (n == 1) return 0;
        //     if (n < 10) {
        //         if (n < 2) return 0;
        //         else if (n >= 2 && n < 5) return 1;
        //         else if (n >= 5 && n < 6) return 2;
        //         else if (n >= 6 && n < 9) return 3;
        //         else return 4;
        //     } else if (n >= 10 && n < 100) {
        //         n = n / 10;
        //         return 4 *  switchN(n) + rotatedDigits(n % 10);
        //     } else if (n >= 100 && n < 1000) {
        //         n = n / 100;
        //         return 16 * switchN(n) + rotatedDigits(n % 100);
        //     } else {
        //         n = n / 1000;
        //         return  64 * switchN(n) + rotatedDigits(n % 1000);
        //     }
        // }

        // public int tribonacci(int n) {
        //     if (n == 0) return 0;
        //     if (n == 1 || n == 2) return 1;
        //     int [] res = new int [n+1];
        //     res[0] = 0;
        //     res[1] = 1;
        //     res[2] = 1;
        //     for (int i = 3; i < n+1; i++) {
        //         res[i] = res[i-1] + res[i-2] + res[i-3];
        //     }
        //     return res[n];
        // }

        // public int minCostClimbingStairs(int[] cost) {
        //     if (cost.length == 2) return Math.min(cost[0], cost[1]);
        //     int n = cost.length;
        //     int [] res = new int [n];
        //     // res[0] = 0;
        //     res[0] = cost[0];
        //     res[1] = cost[1];
        //     for (int i = 2; i < n; i++) {
        //         res[i] = cost[i] + Math.min(res[i-1], res[i-2]);
        //     }
        //     return Math.min(res[n-1], res[n-2]);
        // }

        // public int getMaximumGenerated(int n) {
        //     if (n == 0) return 0;
        //     if (n <= 2) return 1;
        //     int [] res = new int [n+1];
        //     res[0] = 0;
        //     res[1] = 1;
        //     int max = 0;
        //     for (int i = 2; i < n+1; i++) {
        //         if (i % 2 == 0) {
        //             res[i] = res[i / 2];
        //         } else {
        //             res[i] = res[i / 2] + res[i / 2 + 1];
        //             if (res[i] > max) max = res[i];
        //         }
        //     }
        //     return max;
        // }

        // public boolean isSubsequence(String s, String t) {
        //     if (s == null && t == null) return true;
        //     if (s.length() > t.length()) return false;
        //     int m = s.length();
        //     int n = t.length();
        //     int i = 0, j = 0, idx = 0;
        //     for ( j = 0; j < n && i < m; j++) {
        //         if (t.charAt(j) == s.charAt(i)) ++i;
        //     }
        //     if (i == m) return true;
        //     return false;
        // }
        // HashMap<Character, Integer> map = new HashMap<>();;
        // public boolean isSubsequence(String s, String t) {
        //     if (s == null && t == null) return true;
        //     if (s.length() > t.length()) return false;
        //     int m = s.length();
        //     int n = t.length();
        //     int i = 0, j = 0, idx = 0;
        //     if (map != null && map.size() > 0) {
        //         while (map.containsKey(s.charAt(i))) ++i;
        //     }
        //     j = i > 0 ? map.get(s.charAt(i-1))+1 : 0;
        //     for ( ; j < n && i < m; j++) {
        //         if (t.charAt(j) == s.charAt(i)) {
        //             if (!map.containsKey(s.charAt(i))) {
        //                 map.put(s.charAt(i), j);
        //             }
        //             ++i;
        //         }
        //     }
        //     if (i == m) return true;
        //     return false;
        // }

        // public int countVowelStrings(int n) {
        //     if (n == 1) return 5;
        //     if (n == 2) return 15;
        //     int [] res = new int [n];
        //     res[0] = 5;
        //     res[1] = 15;
        //     for (int i = 2; i < n; i++) {
        //         res[i] = res[i-1] + 
        //     }
        // }

        // public int countSquares(int[][] matrix) {
        //     if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] = 1 ? 1 : 0;
        //     int m = matrix.length;
        //     int n = matrix[0].length;
        //     int res = 0;
        //     int [][] res = new int[m][n];
        //     res[0][0] = matrix[0][0];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //         }
        //     }
        // }

        // public int numTeams(int[] rating) { // rating
        //     int n = rating.length;
        //     if (n == 3) return ((rating[0] < rating[1] && rating[1] < rating[2]) || (rating[0] > rating[1] && rating[1] > rating[2])) ? 1 : 0;
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n && j > i; j++) {
        //             for (int k = j+1; k < n && k > j; k++) {
        //                 if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) ++res;
        //             }
        //         }
        //     }
        //     return res;
        // }

        // public int getKth(int lo, int hi, int k) {
        //     if (lo == hi && k == 1) return lo;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     int [] res = new int [hi+1];
        //     res[0] = 0;
        //     res[1] = 3;
        //     res[2] = 1;
        //     int cnt = 0, val = 0;
        //     for (int i = 3; i <= hi; i++) {
        //         cnt = 0;
        //         val = i;
        //         while (val != 1) {
        //             if (val % 2 == 0) {
        //                 val = val / 2;
        //                 ++cnt;
        //                 if (val < i) {
        //                     cnt += res[val];
        //                     break;
        //                 }
        //             } else {
        //                 val = val * 3 + 1;
        //                 ++cnt;
        //             }
        //         }
        //         res[i] = cnt;
        //         if (i >= lo && i <= hi) {
        //             m.put(i, res[i]);
        //         }
        //     }
        //     if (lo < 3) {
        //         if (lo >= 2) {
        //             m.put(2, 1);
        //         } else {
        //             m.put(1, 3);
        //             m.put(2, 1);
        //         }
        //     }
        //     m = MapUtil.sortByValue(m, false);
        //     cnt = 0;
        //     Iterator hmIterator = m.entrySet().iterator();
        //     int resa = 0;
        //     while (cnt < k && hmIterator.hasNext()) {
        //         Map.Entry mapElement = (Map.Entry)hmIterator.next();
        //         resa = (int)mapElement.getKey();
        //         ++cnt;
        //     }
        //     return resa;
        // }

        // public boolean stoneGameRecursive(int[] arr, int i, int j, boolean val, int suma, int sumb) {
        //     int n = j - i + 1;
        //     // int suma = 0, sumb = 0;
        //     while (i < j) {
        //         // if (arr[i] > arr[j]) {
        //         //     if (val) {
        //         //         suma += arr[i];
        //         //     } else {
        //         //         sumb += arr[i];
        //         //     }
        //         //     ++i;
        //         // } else if (arr[i] < arr[j]) {
        //         //     if (val) {
        //         //         suma += arr[j];
        //         //     } else {
        //         //         sumb += arr[j];
        //         //     }
        //         //     --j;
        //         // } else {
        //             if (val) 
        //                 suma += arr[i];
        //             else
        //                 sumb += arr[i];
                    
        //             // } else {
        //             //     sumb += arr[i];
        //             // }
        //             boolean t1 = stoneGameRecursive(arr, i+1, j, !val, suma, sumb);
        //             if (val) {
        //                 suma -= arr[i];
        //                 suma += arr[j];
        //             } else {
        //                 sumb -= arr[i];
        //                 sumb += arr[j];
        //             }
        //             boolean t2 = stoneGameRecursive(arr, i, --j, !val, suma, sumb);
        //             // System.out.println("t1: " + t1);
        //             // System.out.println("t2: " + t2);
                    
        //             return t1 || t2;
        //         // }
        //         // val = !val;
        //     }
        //     return suma > sumb;
        // }
        // public boolean stoneGame(int[] piles) {
        //     if (piles.length == 2) return true;
        //     int n = piles.length;
        //     int i = 0;
        //     int j = n-1;
        //     boolean aturn = true;
        //     int suma = 0;
        //     int sumb = 0;
        //     return stoneGameRecursive(piles, 0, n-1, true, suma, sumb);
        // }

        // public int mctFromLeafValues(int[] arr) {
        //     if (arr.length == 2) return arr[0] * arr[1];
            
        // }

        // public void minFallingPatSumRecursiveh(int[][] arr, int i, int j, int val) {
        //     int n = arr.length;
        //     if ((j < 0 || j >= n) && i < n) return;
        //     if (i == n) {
        //         if (val < minSum) minSum = val;
        //         return;
        //     }
        //     val += arr[i][j];
        //     for (int x = j-1; x <= j+1; x++) {
        //         minFallingPatSumRecursiveh(arr, i+1, x, val);
        //     }
        // }
        // public int minFallingPathSum(int[][] matrix) {
        //     if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
        //     int n = matrix.length;
        //     int sum = 0;
        //     int min = 100;
        //     int idx = 0;
        //      minSum = 100 * n;
        //      for (int j = 0; j < n; j++) {
        //          sum = 0;
        //          minFallingPatSumRecursiveh(matrix, 0, j, sum);
        //      }
        //      return minSum;
        // }
        // private int minSum; // this method works
        // public int minFallingPathSum(int[][] matrix) {
        //     if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
        //     int n = matrix.length;
        //     int [][] arr = new int [n][n];
        //     for (int j = 0; j < n; j++) {
        //         arr[0][j] = matrix[0][j];
        //     }
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (j == 0) {
        //                 arr[i][j] = matrix[i][j] +  Math.min(arr[i-1][j], arr[i-1][j+1]);
        //             } else if (j == n-1) {
        //                 arr[i][j] = matrix[i][j] +  Math.min(arr[i-1][j], arr[i-1][j-1]);
        //             } else {
        //                 arr[i][j] = matrix[i][j] +  Math.min(Math.min(arr[i-1][j], arr[i-1][j-1]), arr[i-1][j+1]);
        //             }
        //         }
        //     }
        //     minSum = arr[n-1][0];
        //     for (int j = 1; j < n; j++) {
        //         if (arr[n-1][j] < minSum) minSum = arr[n-1][j];
        //     }
        //     return minSum;
        // }


        // public int waysToMakeFair(int[] nums) {
        //     if (nums.length == 1) return 1;
        //     int n = nums.length;
        //     int [][] arr = new int[2][n];
        //     int sa = 0, sb = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i % 1 == 0) {
        //             sa += nums[i];
        //             arr[0][i] = sa;
        //         } else {
        //             sb += nums[i];
        //             arr[1][i] = sb;
        //         } 
        //     }
        //     int res = 0;
        //     for (int j = 0; j < n; j++) { // remove
        //         System.out.println("\nj: " + j);
                
        //         if (j == 0) {
        //             sa = 0;
        //             sb = 0;
        //             for (int i = 1; i < n; i++) { 
        //                 if (i % 2 == 1) {
        //                     sa += nums[i];
        //                 } else {
        //                     sb += nums[i];
        //                 } 
        //             }
        //             arr[0][0] = 0; // even
        //             arr[1][0] = 0; // odd
        //              System.out.println("sa: " + sa);
        //              System.out.println("sb: " + sb);
        //         } else if (j == 1) {
        //             arr[0][j] = nums[0];
        //             arr[1][j] = 0;
        //             sa = nums[0];
        //             sb = 0;
        //             for (int i = j+1; i < n; i++) {
        //                 if (i % 2 == 0) {
        //                     sb += nums[i];
        //                 } else {
        //                     sa += nums[i];
        //                 } 
        //             }
        //              System.out.println("sa: " + sa);
        //              System.out.println("sb: " + sb);
        //         } else {
        //             if (j % 2 == 0) {
        //                 // sa = arr[0][j-1];
        //                 // sb = arr[1][j-1] + nums[j-1];
        //                 arr[0][j] = arr[0][j-1];
        //                 arr[1][j] = arr[1][j-1] + nums[j-1];

        //                 System.out.println("arr[1][j-1]: " + arr[1][j-1]);
        //                 System.out.println("arr[1][j]]: " + arr[1][j]);
                        
        //             } else {
        //                 // sa = arr[0][j-1] + nums[j-1];
        //                 // sb = arr[1][j-1];
        //                 arr[0][j] = arr[0][j-1] + nums[j-1];
        //                 arr[1][j] = arr[1][j-1];
        //             }
        //             // System.out.println("");
        //             // System.out.println("arr.length: " + arr.length);
        //             // for (int i = 0; i < arr.length; ++i) {
        //             //     for (int j = 0; j < arr[i].length; j++) {
        //             //         System.out.print(arr[i][j] + ", ");
        //             //     }
        //             //     System.out.print("\n");
        //             // }
        //             // System.out.println("");

        //             sa = arr[0][j-1];
        //             sb = arr[1][j-1];
        //             System.out.println("sa: " + sa);
        //             System.out.println("sb: " + sb);
        //             for (int i = j+1; i < n; i++) {
        //                 // if ((j % 2 == 0 && i % 2 == 1) || (j % 2 == 1 && i % 2 == 1)) {
        //                 if (i % 2 == 1) {
        //                     sa += nums[i];
        //                 } else {
        //                     sb += nums[i];
        //                 } 
        //             }
        //              System.out.println("sa: " + sa);
        //              System.out.println("sb: " + sb);
        //         }
        //         if (sa == sb) res += 1;
        //     }
        //     System.out.println("");
        //     System.out.println("arr.length: " + arr.length);
        //     for (int i = 0; i < arr.length; ++i) {
        //         for (int j = 0; j < arr[i].length; j++) {
        //             System.out.print(arr[i][j] + ", ");
        //         }
        //         System.out.print("\n");
        //     }
        //     System.out.println("");
        //     return res;
        // }

        // public int longestSubarray(int[] nums) {
        //     if (nums.length == 1) return 0;
        //     int n = nums.length;
        //     int i = 0, j = i, k = 0;
        //     int cnt = 0;
        //     int res = 0;
            
        //     while (j < n && nums[j] == 1) ++j;
        //     if (j == n) return n-1;
        //     if (j < n && nums[j] == 0 && cnt == 0) {
        //         k = j;
        //         ++cnt;
        //         ++j;
        //     }
        //     while (j < n) {
        //         while (j < n && nums[j] == 1) ++j;
        //         if (j - i -1 > res) res = j - i -1;
        //         i = k + 1;
        //         if (j < n) {
        //             k = j;
        //             ++j;
        //         }
        //     }
        //     return res;
        // }

        // public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //     int m = nums1.length;
        //     int n = nums2.length;
        //     int [] [] arr = new int [m][n];
        //     for (int i = 0; i < n; i++) {
        //         arr[0][i] = nums1[0] == nums2[i] ? 1 : 0;
        //         if (i > 0 && arr[0][i-1] == 1) arr[0][i] = 1;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         arr[i][0] = nums1[i] == nums2[0] ? 1 : 0;
        //         if (i > 0 && arr[i-1][0] == 1) arr[i][0] = 1;
        //     }
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 1; j < n; j++) {
        //             if (nums1[i] == nums2[j]) arr[i][j] = arr[i-1][j-1] + 1;
        //             else {
        //                 arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
        //             }
        //         }
        //     }
        //     return arr[m-1][n-1];
        // }

        // private boolean isPredecessor(String s, String t) {
        //     if (s.length() >= t.length()) return false;
        //     else if (t.length() - s.length() > 1) return false;
        //     int m = s.length();
        //     int n = t.length();
        //     int cnt = 0;
        //     int i = 0;
        //     int j = 0;
        //     if (i < m & j < n && s.charAt(i) != t.charAt(j)) {
        //         ++cnt;
        //         if (cnt > 1) return false;
        //         ++j;
        //     }
        //     while (i < m && j < n) {
        //         while (i < m && j < n && s.charAt(i) == t.charAt(j)) {
        //             ++i;
        //             ++j;
        //         }
        //         if (i < m & j < n && s.charAt(i) != t.charAt(j)) {
        //             ++cnt;
        //             if (cnt > 1) return false;
        //             ++j;
        //         }
        //     }
        //     if (i == m && j == n && cnt == 1) return true;
        //     return false;
        // }
        // public int longestStrChain(String[] words) {
        //     if (words.length == 1) return 1;
        //     Arrays.sort(words, new java.util.Comparator<String>() {
        //             @Override
        //             public int compare(String s1, String s2) {
        //                 return s1.length() - s2.length();
        //             }
        //         });
        //     // System.out.println("");
        //     // System.out.println("words.length: " + words.length);
        //     // for (int i = 0; i < words.length; ++i) 
        //     // System.out.print(words[i] + ", ");
        //     // System.out.println("");
        //     int res = 1;
        //     int idx = 0;
        //     for (int i = 1; i < words.length; i++) {
        //         if (isPredecessor(words[i-1], words[i])) {
        //             ++res;
        //             idx = i;
        //         } else {
        //             for (int j = 0; j < i; j++) {
        //                 if (isPredecessor(words[j], words[i])) {
        //                     ++res;
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        //     return res;
        // }

        // public static  void Sort2DArrayBasedOnColumnNumber (int[][] array, final int columnNumber){
        //     Arrays.sort(array, new Comparator<int[]>() {
        //             @Override
        //             public int compare(int[] first, int[] second) {
        //                 if (first[columnNumber] > second[columnNumber]) return 1;
        //                 else if (first[columnNumber] == second[columnNumber]) return (first[columnNumber+1] < second[columnNumber+1]) ? 1 : -1;
        //                 else return -1;
        //             }
        //         });
        // }
        // public int findLongestChain(int[][] pairs) {
        //     Sort2DArrayBasedOnColumnNumber(pairs, 0);
        //     int res = 1;
        //     int cnt = 1;
            
        //     System.out.println("");
        //     System.out.println("pairs.length: " + pairs.length);
        //     for (int i = 0; i < pairs.length; ++i) {
        //         for (int j = 0; j < pairs[i].length; j++) {
        //             System.out.print(pairs[i][j] + ", ");
        //         }
        //         System.out.print("\n");
        //     }
        //     System.out.println("");

        //     int prev = 0;
        //     for (int i = 1; i < pairs.length; i++) {
        //         if (pairs[i][0] > pairs[prev][1]) {
        //             ++res;
        //             prev = i;
        //         } else if (res == 1 && pairs[i][1] < pairs[prev][1]) {
        //             prev = i;
        //         }
        //     }
        //     return res;
        // }
        // int [][] a = new int [][] {{1,2},{2,3},{3,4}};
        // int [][] a = new int [][] {{1,2},{7,8},{4,5}}; 
        // int [][] a = new int [][] {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}}; 
        // int [][] a = new int [][] {{9,10},{-4,9},{-5,6},{-5,9},{8,9}}; 
        // int [][] a = new int [][] {{9,10},{-9,9},{-6,1},{-4,1},{8,10},{7,10},{9,10},{2,10}}; 

        // public int maxScoreSightseeingPair(int[] values) {
        //     if (values.length == 2) return values[0] + values[1]-1;
        //     int idx = 0;
        //     int best = values[0];
        //     int res = 0;
            
        //     for (int i = 1; i < values.length; i++) {
        //         if (values[i] + best + idx - i > res) {
        //             res = values[i] + best + idx - i;
        //         }
        //         if (values[i] > best + idx - i) {
        //             best = values[i];
        //             idx = i;
        //         }
        //     }
        //     return res;
        // }

        // public int arrayNesting(int[] nums) {
        //     if (nums.length == 1) return 1;
        //     int n = nums.length;
        //     int tmp = 0;
        //     int res = 0;
        //     HashSet<Integer> s;
        //     for (int i = 0; i < n; i++) {
        //         s = new HashSet<>();
        //         s.add(nums[i]);
        //         tmp = nums[i];
        //         while (tmp < n && !s.contains(nums[tmp])) {
        //             s.add(nums[tmp]);
        //             tmp = nums[tmp];
        //         }
        //         if (s.size() > res) res = s.size();
        //     }
        //     return res;
        // }

        // private int getCosts(int [] arr, int i, int j) {
        //     int max = arr[i];
        //     int sum = 0;
        //     for (int x = i+1; x < j; x++) {
        //         if (arr[x] > max) {
        //             sum += max;
        //             max = arr[x];
        //             continue;
        //         }
        //         sum += arr[x];
        //     }
        //     return sum;
        // }
        // public int minCost(String s, int[] cost) {
        //     if (s.length() == 1) return 0;
        //     int n = s.length();
        //     int res = 0;
        //     int i = 0, j = 0;

        //     while (j < n) {
        //         while (j < n && s.charAt(j) == s.charAt(i)) ++j;
        //         res += getCosts(cost, i, j);
        //         if (j == n) return res;
        //         i = j;
        //     }
        //     return res;
        // }

        // public int numSubmat(int[][] mat) {
        //     if (mat.length == 1 && mat[0].length == 1) return mat[0][0] == 1 ? 1 : 0;
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int [][] arr = new int[m][n];
        //     for (int i = 0; i < m; i++) {
        //         arr[i][0] = mat[i][0] == 1 ? 1 : 0;
        //         for (int j = 1; j < n; j++) {
        //             if (mat[i][j] == 0) arr[i][j] = 0;
        //             else arr[i][j] = arr[i][j-1] + 1;
        //         }
        //     }
        //     // System.out.println("");
        //     // System.out.println("arr.length: " + arr.length);
        //     // for (int i = 0; i < arr.length; ++i) {
        //     //     for (int j = 0; j < arr[i].length; j++) {
        //     //         System.out.print(arr[i][j] + ", ");
        //     //     }
        //     //     System.out.print("\n");
        //     // }
        //     // System.out.println("");
        //     return 0;
        // }

        // public int numberOfArithmeticSlices(int[] nums) {
        //     if (nums.length < 3) return 0;
        //     int n = nums.length;
        //     int [] arr = new int[n];
        //     arr[0] = 0;
        //     arr[1] = 0;
        //     int i = 0, j = i + 1;
        //     int res = 0;
        //     if (nums[j] - nums[j-1] == nums[j+1] - nums[j]) arr[j+1] = 1;
        //     else arr[j+1] = 0;
        //     if (n == 3) return arr[2];
        //     ++j;
        //     int val = nums[j] - nums[j-1];
        //     i = 1;
        //     j = i + 2;
        //     while (j < n) {
        //         while (j < n && nums[j] - nums[j-1] == val) {
        //             arr[j] = arr[j-1] > 0 ? (arr[j-1] == 1 ? 3 : arr[j-1] + arr[j-1] - arr[j-2] + 1) : 1;
        //             ++i;
        //             ++j;
        //         }
        //         if (j == n) {
        //             res += arr[n-1];
        //             return res;
        //         }
        //         if (j < n && nums[j] - nums[j-1] != val) {
        //             val = nums[j] - nums[j-1];
        //             res += arr[j-1];
        //             ++i;
        //             ++j;
        //         }
        //     }
        //     return res;
        // }

        // public int mctFromLeafValues(int[] arr) {
        //     if (arr.length == 2) return arr[0] * arr[1];
        //     int n = arr.length;
        //     int [][] dp = new int[n][n];
        //     int left = 0, right = 0;
        //     int prod = 1;

        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             for (int k = i; k < j; k++) {
        //                 left = Integer.MIN_VALUE;
        //                 for (int y = i; y <= k; y++) {
        //                     if (arr[y] > left) left = arr[y];
        //                 }
        //                 right = Integer.MIN_VALUE;
        //                 for (int y = k+1; y < j; y++) {
        //                     if (arr[y] > right) right = arr[y];
        //                 }
        //                 System.out.println("left: " + left);
        //                 System.out.println("right: " + right);
        //                 dp[i][j] = left * right + dp[i][k] + dp[k+1][j];
        //             }
        //         }
        //     }
        //     int res = Integer.MIN_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (dp[i][j] > res) res = dp[i][j];
        //         }
        //     }
        //     return res;
        // }

        // private boolean 
        // private int getPalindromeCnts(String s) {
        //     if (s.length() == 2) return 3;
        //     int n = s.length();
        //     int res = n;
        //     int i = 1;
        //     while (i < n && s.charAt(i) == s.charAt(i-1)) {
        //         ++res;
        //         ++i;
        //     }
        //     if (i == n) {
        //         return n*(n+1)/2;
        //     }
        //     // HashMap<Character, Integer> m = new HashMap<>();
        //     // i = 0;
        //     // while (i < n && !m.containsKey(s.charAt(i))) {
        //     //     m.put(s.charAt(i), i);
        //     //     ++i;  
        //     // } 
            
        //     if (n % 2 == 0) return n + n/2;
        //     else return n + (n-1)/2;
        // }
        // public int countSubstrings(String s) {
        //     if (s.length() == 1) return 1;
        //     int n = s.length();
        //     HashMap<Character, Integer> m = new HashMap<>();
        //     int i = 0, j = 0, res = 0;
        //     while (i < n) {
        //         while (i < n && !m.containsKey(s.charAt(i))) {
        //             m.put(s.charAt(i), i);
        //             ++i;  
        //         } 
        //         if (i == n) return n;
        //         if (m.containsKey(s.charAt(i))) {
        //             j = m.get(s.charAt(i));
        //             if (i - j <= 2) {
        //                 while (i < n-1 && j > 0 && s.charAt(i+1) == s.charAt(j-1)) {
        //                     ++i;
        //                     --j;
        //                 }
        //                 if (i == n) {
        //                     res = j + getPalindromeCnts(s.substring(j, i-j+1));
        //                 } else {
        //                     res = j + getPalindromeCnts(s.substring(j, i-j+1)) + countSubstrings(s.substring(i+1));
        //                 }
        //                 return res;
        //             }
        //         }
        //     }
        //     return -1;
        // }

        // public int countVowelStrings(int n) {
        // }
        // private int count(int n, char c) {
        // }

        // HashMap<Character, Integer> ma = new HashMap<>();
        // HashMap<Character, Integer> mb = new HashMap<>();
        // int n;
        // public int numSplits(String s) {
        //     n = s.length();
        //     int res = 0;
        //     // int i = 0, j = n-1;
        //     // ma.put(s.charAt(i), ma.getOrDefault(s.charAt(i), 0) + 1);
        //     // mb.put(s.charAt(j), mb.getOrDefault(s.charAt(j), 0) + 1);
        //     int mid = n / 2;
        //     int tmp = 0;
        //     while ( mid < n && Math.abs(ma.size() - mb.size()) <= tmp) {
        //         for (int i = 0; i <= mid; i++) 
        //             ma.put(s.charAt(i), ma.getOrDefault(s.charAt(i), 0) + 1);
        //         for (int i = mid+1; i < n; i++) 
        //             mb.put(s.charAt(i), mb.getOrDefault(s.charAt(i), 0) + 1);
        //         if (ma.size() == mb.size()) {
        //             ++res;
        //             ++mid;
        //         }
        //         else if (ma.size() > mb.size()) --mid;
        //         else ++mid;
        //         tmp = Math.abs(ma.size() - mb.size());
        //     }
        // }
        // private int distinctDiff(int mid) {
        //     for (int i = 0; i <= mid; i++) 
        //         ma.put(s.charAt(i), ma.getOrDefault(s.charAt(i), 0) + 1);
        //     for (int i = mid+1; i < n; i++) 
        //         mb.put(s.charAt(i), mb.getOrDefault(s.charAt(i), 0) + 1);
        //     return 
        // }

        // public int maxSumAfterPartitioning(int[] arr, int k) {
        //     int n = arr.length;
        //     int res = 0;
        //     int [] dp = new int[n];
        //     dp[0] = arr[0];
        //     int max = arr[0];
        //     for (int i = 0; i < n; i++) {
        //         if (i - k >= 0) {
        //             max = arr[i];
        //             for (int j = i-1; j >= i-k; --j) {
        //                 dp[i] = Math.max(dp[i], dp[j] + (i-j)*max);
        //                 max = Math.max(max, arr[j]);
        //             }
        //         } else {
        //             max = Math.max(max, arr[i]);
        //             dp[i] = max * (i+1);
        //         }
        //     }
        //     return dp[n-1];
        // }

        // public int maxSubArray(int[] nums) {
        //     int res = nums[0], sum = 0;
        //     for (int i = 0; i < nums.length; i++) {
        //         sum = Math.max(sum + nums[i], nums[i]);
        //         res = Math.max(res, sum);
        //     }
        //     return res;
        // }
        // public int maxProfit(int[] prices) {
        //     int min = Integer.MAX_VALUE;
        //     int max = Integer.MIN_VALUE;
        //     for (int i = 0; i < prices.length; i++) {
        //         if (prices[i] < min) min = prices[i];
        //         max = Math.max(max, prices[i] - min);
        //     }
        //     return max;
        // }
        // public int maxProfit(int[] prices) {
        //     int start = prices[0];
        //     int res = 0;
        //     for (int i = 1; i < prices.length; i++) {
        //         if (prices[i] >= prices[i-1]) continue;
        //         res += prices[i-1] - start;
        //         start = prices[i];
        //     }
        //     res += prices[prices.length-1] - start;
        //     return res;
        // }

        // public int maxProfit(int[] prices) {
        //     if (prices.length < 2) return 0; 
        //     int [] past = new int[prices.length];
        //     int [] futu = new int[prices.length];
        //     int result = 0;
        //     for (int i = 1, valley = prices[0]; i < prices.length; i++) {
        //         valley = Math.min(valley, prices[i]);
        //         past[i] = Math.max(past[i - 1], prices[i]-valley);
        //     }
        //     for (int i = prices.length-2, peak = prices[prices.length-1]; i >= 0 ; i--) {
        //         peak = Math.max(peak, prices[i]);
        //         futu[i] = Math.max(futu[i+1], peak-prices[i]);
        //         result = Math.max(result, past[i] + futu[i]);
        //     }
        //     return result;
        // }

        // public int maxProfit(int[] prices, int fee) {
        //     int start = prices[0];
        //     int min = Integer.MAX_VALUE;
        //     int res = 0;
        //     for (int i = 1; i < prices.length; i++) {
        //         if (prices[i] < min) min = prices[i];
        //         if (prices[i] >= prices[i-1]) continue;
        //         res = Math.max(res, prices[i-1] - min - fee);
        //         start = prices[i];
        //     }
        //     res += prices[prices.length-1] - start > fee ? prices[prices.length-1] - start - fee : 0;
        //     return res;
        // }


        public int longestCommonSubsequence(String S, String T) {
            int m = S.length();
            int n = T.length();
            int [][] dp = new int [m+1][n+1];
            for (int i = 1; i <= m; i++) 
                for (int j = 1; j <= n; j++) 
                    if (S.charAt(i-1) == T.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            return dp[m][n];
        }
   }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  { -2, 1, -3, 4, -1, 2, 1, -5, 4}; 
        int []  a = new int []  {5, 4, -1, 7, 8}; 

        int res = s.maxSubArray(a);
        System.out.println("res: " + res);
    }
}