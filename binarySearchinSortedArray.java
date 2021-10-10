import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import javafx.util.Pair;

import static java.util.stream.Collectors.toMap;

public class binarySearchinSortedArray {
    public static class Solution {

        // private int binarySearchinSortedArray(int [] arr, int target, int bgn, int end) {
        //     int mid;
        //     while (bgn < end) {
        //         mid = bgn + (end - bgn) / 2;
        //         if (arr[mid] == target) return mid;
        //         if (arr[mid] < target) {
        //             bgn = mid + 1;
        //         } else
        //             end = mid - 1;
        //     }
        //     if (bgn == end && arr[bgn] == target) return bgn;
        //     return -1;
        // }
        // public int search(int[] nums, int target) {
        //     return binarySearchinSortedArray(nums, target, 0, nums.length - 1);
        // }

        // private int findCloestElement(int [] arr, int val, int i, int j) {
        //     if (i == j) return arr[i];
        //     if (j - i == 1) return Math.abs(val - arr[i]) < Math.abs(val - arr[i+1]) ? arr[i] : arr[i+1];
        //     int k = i + (j-i) / 2;
        //     if (arr[k] == val) {
        //         return arr[k];
        //     } else if (arr[k] < val && arr[k+1] > val) {
        //         return Math.abs(val - arr[k]) < Math.abs(val - arr[k+1]) ? arr[k] : arr[k+1];
        //     } else if (val < arr[k] && val > arr[k-1]) {
        //         return Math.abs(val - arr[k-1]) < Math.abs(val - arr[k]) ? arr[k-1] : arr[k];
        //     } else if (val < arr[k-1]) return findCloestElement(arr, val, i, k-1);
        //     else return findCloestElement(arr, val, k+1, j);
        // }
        // public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        //     Arrays.sort(arr2);
        //     int res = 0;
        //     for (int i = 0; i < arr1.length; i++) {
        //         // System.out.println("\narr1[i]: " + arr1[i]);
        //         // System.out.println("findCloestElement(arr2, arr1[i], 0, arr2.length-1): " + findCloestElement(arr2, arr1[i], 0, arr2.length-1));
        //         if (Math.abs(arr1[i] - findCloestElement(arr2, arr1[i], 0, arr2.length-1)) > d) ++res;
        //     }
        //     return res;
        // }
        // int [] a = new int [] {4, 5, 8}; 
        // int [] b = new int [] {10, 9, 1, 8}; 
        // int [] a = new int [] {1, 4, 2, 3}; 
        // int [] b = new int [] {-4, -3, 6, 10, 20, 30}; 
        // int [] a = new int [] {2, 1, 100, 3}; 
        // int [] b = new int [] {-5, -2, 10, -3, 7}; 
        // int [] a = new int [] {4, -3, -7, 0, -1069};
        // int [] b = new int [] {10}; 
        // int [] a = new int [] {395, -194, 468, 304, -288, -214, 54, 731, -663, 114, 494, -917, 73, -815, 654, -478}; 
        // int [] b = new int [] {287, -794, -453, 509, 869, -829, 964, 996, -716, 984, 588, 263, 724, 980, 351, 406, 434, -833, -89, 742, 892, -507, 989, 742, -217, 925, 643, 850, -114, -187, -663, 863, -334, -103, -742, 274, 861, -1, 964, -566, -756, -117, 230, 93, -164, 862, -759, 352, -395, -432, -492, -225, 535, 145, -992, 965, -612, 82, -102, 185, -957, -937, 285, 992, 240, -504, 710, -467, -577, -646, -417, -697, 110}; 

        // public int[] intersection(int[] nums1, int[] nums2) {
        //     Set<Integer> s = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        //     Set<Integer> t = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        //     if (s.size() > t.size()) return intersection(nums2, nums1);
            
        //     List<Integer> l = new ArrayList<>();
        //     for (Integer key : s) {
        //         if (t.contains(key)) l.add(key);
        //     }
        //     int [] res = new int [l.size()];
        //     res = l.stream().mapToInt(i->i).toArray(); 
        //     return res;
        // }
        // public int[] intersect(int[] nums1, int[] nums2) {
        //     if (nums1.length > nums2.length) return intersect(nums2, nums1);
        //     Arrays.sort(nums1);
        //     Arrays.sort(nums2);
        // }

        // public int findKthPositive(int[] arr, int k) {
        //     if (arr.length == 0) return k;
        //     List<Integer> l = new ArrayList<>();
        //     if (arr[0] > 1) {
        //         for (int i = 0; i < arr[0]-1; i++) {
        //             l.add(i+1);
        //         }
        //     }
        //     int prev = arr[0];
        //     for (int i = 1; i < arr.length; i++) {
        //         if (arr[i] - prev > 1) {
        //             for (int x = arr[i-1]+1; x < arr[i]; x++) {
        //                 l.add(x);
        //             }
        //         }
        //         prev = arr[i];
        //     }
        //     if (l.size() > 0 && k <= l.size()) return l.get(k-1);
        //     else if (l.size() > 0 && k > l.size()) {
        //         int tmp = l.get(l.size()-1);
        //         return tmp > arr[arr.length-1] ? tmp + k - l.size() : arr[arr.length-1] + k - l.size();
        //     } else if (l.size() == 0) return arr[arr.length-1]+k;
        //     return -1;
        // }

        // private int countNoLessthen(int [] arr, int val, int i, int j) { // with repeats
        //     if (arr[i] > val || (arr[i] == val && arr[j] == val)) return j-i+1;
        //     else if (arr[j] < val) return 0;
            
        //     if (i == j) return arr[i] >= val ? 1 : 0;
        //     int n = j - i;
        //     int m = i + (j-i) / 2;
        //     if (arr[m] == val) {
        //         int tmp = m;
        //         while (tmp >= i && arr[tmp] == val) --tmp;
        //         if (tmp < i) return j - i + 1;
        //         else return j - tmp;
        //     } else if (arr[m] < val) {
        //         return countNoLessthen(arr, val, m+1, j);
        //     } else return j-m+1 + countNoLessthen(arr, val, i, m-1);
        // }
        // public int specialArray(int[] nums) {
        //     if (nums.length == 1 && nums[0] >= 1) return 1;
        //     else if (nums.length == 1) return -1;
        //     int n = nums.length;
        //     int [] arr = new int[n+1];
        //     Arrays.sort(nums);
        //     for (int i = n; i >= 0; i--) {
        //         arr[i] = countNoLessthen(nums, i, 0, n-1);
        //         if (arr[i] == i) return i;
        //     }
        //     return -1;
        // }

        // public char nextGreatestLetterBinaryS(char[] arr, char val, int i, int j) {
        //     int m = i + (j-i)/2;
        //     if (arr[m] == val) {
        //         int a = m;
        //         while (a <= j && arr[a] == val) ++a;
        //         if (a > j) return arr[i];
        //         else return arr[a];
        //     } else if (arr[m] <= val && m <= j-1 && arr[m+1] > val) {
        //         return arr[m+1];
        //     } else if (m <= j-1 && val >= arr[m+1]) {
        //         return nextGreatestLetterBinaryS(arr, val, m+1, j);
        //     } else if (val < arr[m] && m > i && val >= arr[m-1]) {
        //         return arr[m];
        //     } else if (val < arr[m] && m > i && val < arr[m-1]) {
        //         return nextGreatestLetterBinaryS(arr, val, i, m-1);
        //     }
        //     return ' ';
        // }
        // public char nextGreatestLetter(char[] letters, char target) {
        //     if (target >= letters[letters.length -1] || target < letters[0]) return letters[0];
        //     return nextGreatestLetterBinaryS(letters, target, 0, letters.length-1);
        // }

        // public boolean isPerfecRecursivetSquare(int val, int i, int j) {
        //     if (i == j) return i * i == val ? true : false;
        //     else if (j - i == 1) return (i*i == val || j*j == val) ? true : false;
        //     int mid = i + (j-i)/2;
        //     long tmp = mid * mid;
        //     System.out.println("\nval: " + val);
        //     System.out.println("mid: " + mid);
        //     System.out.println("tmp: " + tmp);
            
        //     if (tmp == val) return true;
        //     else if (tmp < val) return isPerfecRecursivetSquare(val, mid+1, j);
        //     else return isPerfecRecursivetSquare(val, i, mid-1);
        // }
        // public boolean isPerfectSquare(int num) {
        //     if (num == 1) return true;
        //     else if (num == 2) return false;
        //     else if (num == 3) return false;
        //     return isPerfecRecursivetSquare(num, 1, num-1);
        // }
        // boolean res = s.isPerfectSquare(808201);

        
        // public int rangeSum(int[] nums, int n, int left, int right) {
        //     long [] arr = new long [n * (n+1)/2];
        //     int idx = 0;
        //     long sum = 0;
        //     int j = 0;
        //     for (int i = 0; i < n; i++) {
        //         arr[idx] = nums[i]; ++idx;
        //         sum += nums[i];
        //         for ( j = i+1; j < n; j++) {
        //             sum += nums[j];
        //             arr[idx] = sum; ++idx;
        //         }
        //         if (j == n) sum = 0;
        //     }
        //     Arrays.sort(arr);
        //     long res = 0;
        //     for (int i = left-1; i <= right -1; i++) {
        //         res += arr[i];
        //     }
        //     return (int)(res % 1000000007);
        // }

        // public int findDuplicate(int[] nums) {
        //     int n = nums.length;
        //     for (int i = 0; i < n; i++) {
        //         sum += nums[i];
        //     }
        //     return (int)(sum - n*(n-1)/2);
        // }

        // public int countNegativesRecursive(int[][] arr, int i, int j, int m, int n) {
        //     System.out.println("\ni: " + i);
        //     System.out.println("j: " + j);
        //     System.out.println("m: " + m);
        //     System.out.println("n: " + n);
        //     if (i == j && m == n) return arr[i][m] < 0 ? 1 : 0;
        //     else if (i == j) {
        //         int cnt = 0;
        //         for (int x = n; x >= m; x--) {
        //             if (arr[i][x] < 0) ++cnt;
        //             else break;
        //         }
        //         return cnt;
        //     } else if (m == n) {
        //         int cnt = 0;
        //         for (int x = j; x >= i; x--) {
        //             if (arr[x][m] < 0) ++cnt;
        //             else break;
        //         }
        //         return cnt;
        //     }
        //     int x = i + (j-i) / 2;
        //     int y = m + (n-m) / 2;
        //     System.out.println("\nx: " + x);
        //     System.out.println("y: " + y);
        //     System.out.println("(arr[x][y] >= 0): " + (arr[x][y] >= 0));
        //     System.out.println("(arr[x][n] >= 0 && arr[j][y] >= 0): " + (arr[x][n] >= 0 && arr[j][y] >= 0));
        //     System.out.println("(arr[x][n] >= 0 || arr[j][y] >= 0): " + (arr[x][n] >= 0 || arr[j][y] >= 0));
        //     System.out.println("(arr[x][n] >= 0 ? countNegativesRecursive(arr, x+1, j, m, y) : countNegativesRecursive(arr, i, x, y+1, n)): " + (arr[x][n] >= 0 ? countNegativesRecursive(arr, x+1, j, m, y) : countNegativesRecursive(arr, i, x, y+1, n)));
            
        //     if (arr[x][y] >= 0) {
        //         if (arr[x][n] >= 0 && arr[j][y] >= 0) {
        //             return countNegativesRecursive(arr, x+1, j, y+1, n);
        //         } else if (arr[x][n] >= 0 || arr[j][y] >= 0) {
        //             System.out.println("countNegativesRecursive(arr, x+1, j, y+1, n): " + countNegativesRecursive(arr, x+1, j, y+1, n));
        //             System.out.println("( countNegativesRecursive(arr, x+1, j, y+1, n) + arr[x][n] >= 0 ? countNegativesRecursive(arr, x+1, j, m, y) : countNegativesRecursive(arr, i, x, y+1, n)): " + ( countNegativesRecursive(arr, x+1, j, y+1, n) + arr[x][n] >= 0 ? countNegativesRecursive(arr, x+1, j, m, y) : countNegativesRecursive(arr, i, x, y+1, n)));
                    
        //             return countNegativesRecursive(arr, x+1, j, y+1, n) + arr[x][n] >= 0 ? countNegativesRecursive(arr, x+1, j, m, y) : countNegativesRecursive(arr, i, x, y+1, n);
        //         } else {
        //             System.out.println("countNegativesRecursive(arr, x+1, j, m, y): " + countNegativesRecursive(arr, x+1, j, m, y));
        //             System.out.println("countNegativesRecursive(arr, i, x, y+1, n): " + countNegativesRecursive(arr, i, x, y+1, n));
        //             System.out.println(")((j-x)*(n-y) + countNegativesRecursive(arr, x+1, j, m, y) + countNegativesRecursive(arr, i, x, y+1, n): " + ((j-x)*(n-y) + countNegativesRecursive(arr, x+1, j, m, y) + countNegativesRecursive(arr, i, x, y+1, n)));
                    
        //             return (j-x)*(n-y) + countNegativesRecursive(arr, x+1, j, m, y) + countNegativesRecursive(arr, i, x, y+1, n);
        //         }
        //     } else {
        //         return (j-x)*(n-y) + countNegativesRecursive(arr, i, x, m, y)
        //             + countNegativesRecursive(arr, i, x, y+1, n) + countNegativesRecursive(arr, x+1, j, m, y);
        //     }
        // }
        // public int countNegatives(int[][] grid) {
        //     if (grid.length == 1) return grid[0][0] < 0 ? 1 : 0;
        //     return countNegativesRecursive(grid, 0, grid.length-1, 0, grid[0].length -1);
        // }
        // int [][] a = new int [] []{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};

        // public int findLength(int[] nums1, int[] nums2) {
        //     int m = nums1.length;
        //     int n = nums2.length;
        //     int [][] arr = new int[m][n];
        //     for (int j = 0; j < n; j++) {
        //         if (nums1[0] == nums2[j]) arr[0][j] = 1;
        //         else arr[0][j] = 0;
        //     }
        //     for (int i = 0; i < m; i++) {
        //         if (nums1[i] == nums2[0]) arr[i][0] = 1;
        //         else arr[i][0] = 0;
        //     }
        //     for (int i = 1; i < m; i++) {
        //         for (int j = 1; j < n; j++) {
        //             if (nums1[i] == nums2[j] && nums1[i-1] == nums2[j-1]) arr[i][j] = arr[i-1][j-1] + 1;
        //             else if (nums1[i] == nums2[j]) arr[i][j] = 1;
        //             else arr[i][j] = 0;
        //         }
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
        //     int res = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             if (arr[i][j] > res) res = arr[i][j];
        //         }
        //     }
        //     return res;
        // }


        // private int getCnt(String s) {
        //     if (s.length() == 1) return 1;
        //     Map<Character, Integer> m = new HashMap<>();
        //     int n = s.length();
        //     char c = 'z';
        //     for (int i = 0; i < n; i++) {
        //         if (s.charAt(i) < c) c = s.charAt(i);
        //         m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        //     }
        //     return m.get(c);
        // }
        // private int binarySearchinSortedArray(int [] arr, int val, int i, int j) { // > val , consider repeats
        //     if (i == j) {
        //         return arr[i] > val ? i : -1;
        //     } else if (i == j -1) {
        //         return arr[i] > val ? i : (arr[j] > val ? j : j+1);
        //     }
        //     int m = i + (j-i)/2;
        //     if (arr[m] == val && arr[m+1] == val) {
        //         int k = m;
        //         while (k <= j && arr[k] == val) ++k;
        //         if (k == j+1) return -1;
        //         return k;
        //     } else if (arr[m] == val) return m+1;
        //     else if (arr[m] < val && arr[m+1] > val) return m+1;
        //     else if (arr[m] < val)
        //         return binarySearchinSortedArray(arr, val, m+1, j);
        //     else if (arr[m] > val && arr[m-1] <= val) return m;
        //     else return binarySearchinSortedArray(arr, val, i, m-1);
        // } 
        // public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //     int n = queries.length;
        //     int m = words.length;
        //     int [] g = new int[n];
        //     for (int i = 0; i < n; i++) 
        //         g[i] = getCnt(queries[i]);
        //     int [] arr = new int[m];
        //     for (int i = 0; i < m; i++) 
        //         arr[i] = getCnt(words[i]);
        //     Arrays.sort(arr);
        //     int [] ans = new int[n];
        //     int tmp = 0;
        //     for (int i = 0; i < n; i++) {
        //         tmp = binarySearchinSortedArray(arr, g[i], 0, m-1);
        //         if (tmp != -1)
        //             ans[i] = m - tmp;
        //     }
        //     return ans;
        // }

        // private boolean binarySearchinMatrix(int [][] arr, int l, int r) {
        //     int cnt = 0;
        //     if (l == r) {
        //         for (int i = 1; i < m-1; i++) {
        //             cnt = 0;
        //             if (i > 0 && arr[i-1][l] < arr[i][l]) ++cnt;
        //             if (i < m-1 && arr[i+1][l] < arr[i][l]) ++cnt;
        //             if (l > 0 && arr[i][l-1] < arr[i][l]) ++ cnt;
        //             if (l < n-1 && arr[i][l+1] < arr[i][l]) ++cnt;
        //             if (cnt == 4 || (cnt == 3 && (i == 0 || i == m-1))) {
        //                  res = new int[]{i-1, l-1};
        //                  return true;
        //             }
        //         }
        //         return false;
        //     } else if (l == r -1) {
        //         for (int j = l; j <= r; j++) {
        //             for (int i = 1; i < m-1; i++) {
        //                 cnt = 0;
        //                 if (i > 0 && arr[i-1][j] < arr[i][j]) ++cnt;
        //                 if (i < m-1 && arr[i+1][j] < arr[i][j]) ++cnt;
        //                 if (j > 0 && arr[i][j-1] < arr[i][j]) ++ cnt;
        //                 if (j < n-1 && arr[i][j+1] < arr[i][j]) ++cnt;
        //                 if (cnt == 4 || (cnt == 3 && (i == 0 || i == m-1))) {
        //                     res = new int[]{i-1, j-1};
        //                     return true;
        //                 }
        //             }
        //         }
        //         return false;
        //     }
        //     int mid = l + (r-l)/2;
        //     boolean left = false, right = false;
        //     for (int i = 1; i < m-1; i++) {
        //         cnt = 0;
        //         if (i > 0 && arr[i-1][mid] < arr[i][mid]) ++cnt;
        //         if (i < m-1 && arr[i+1][mid] < arr[i][mid]) ++cnt;
        //         if (arr[i][mid-1] < arr[i][mid]) ++ cnt;
        //         if (arr[i][mid+1] < arr[i][mid]) ++cnt;
        //         if (cnt == 4 || (cnt == 3 && (i == 0 || i == m-1))) {
        //             res = new int[]{i-1, mid-1};
        //             return true;
        //         }
        //         if (arr[i][mid-1] > arr[i][mid]) left = true;
        //         if (arr[i][mid+1] > arr[i][mid]) right = true;
        //     }
        //     if (left && binarySearchinMatrix(arr, l, mid-1)) return true;
        //     return binarySearchinMatrix(arr, mid+1, r);
        // }
        // int [] res;
        // int m, n;
        // public int[] findPeakGrid(int[][] mat) {
        //     m = mat.length+2;
        //     n = mat[0].length+2;
        //     int [][] arr = new int[m][n];
        //     for (int i = 0; i < m; i++) 
        //         Arrays.fill(arr[i], -1);
        //     for (int i = 1; i < m-1; i++) 
        //         for (int j = 1; j < n-1; j++) 
        //             arr[i][j] = mat[i-1][j-1];
        //     res = new int[2];
        //     binarySearchinMatrix(arr, 1, n-2);
        //     return res;
        // }


        // private boolean canMake(int [] arr, int m, int k, int v) {
        //     int i = 0, j = 0, cnt = 0, bcnt = 0;
        //     while (i < n) {
        //         while (i < n && arr[i] <= v) {
        //             ++cnt;
        //             if (cnt == k) {
        //                 cnt = 0;
        //                 ++bcnt;
        //                 if (bcnt == m) return true;
        //             }
        //             ++i;
        //         }
        //         if (i == n) return bcnt >= m;
        //         if (arr[i] > v) {
        //             cnt = 0;
        //             ++i;
        //         }
        //     }
        //     return bcnt >= m;
        // }
        // int binarySearchinArray(int [] arr, int m, int k, int l, int h) {
        //     if (l == h) {
        //         return canMake(arr, m, k, l) ? l : -1;
        //     } else if (l == h-1) {
        //         return canMake(arr, m, k, l) ? l : (canMake(arr, m, k, h) ? h : -1);
        //     }
        //     int mid = l + (h-l) / 2;
        //     if (canMake(arr, m, k, mid)) {
        //         return binarySearchinArray(arr, m, k, l, mid);
        //     } else return binarySearchinArray(arr, m, k, mid+1, h);
        // }
        // int n;
        // public int minDays(int[] bloomDay, int m, int k) {
        //     n = bloomDay.length;
        //     if (n == 1) return (m == 1 && k == 1 ? 1 : 0);
        //     int min = Integer.MAX_VALUE, max = 0;
        //     for (int i = 0; i < n; i++) {
        //         min = Math.min(min, bloomDay[i]);
        //         max = Math.max(max, bloomDay[i]);
        //     }
        //     return binarySearchinArray(bloomDay, m, k, min, max);
        // }


        // private int getSumAftD(int [] arr, int v) {
        //     int res = 0;
        //     for (int i = 0; i < n; i++) 
        //         res += arr[i] / v + (arr[i] % v == 0 ? 0 : 1);
        //     return res;
        // }
        // private int binarySearchinSorted(int [] arr, int k, int l, int h) {
        //     if (l == h) {
        //         return getSumAftD(arr, l) <= k ? l : l+1;
        //     } else if (l == h-1) {
        //         return (getSumAftD(arr, l) <= k ? l : (getSumAftD(arr, h) <= k ? h : h+1));
        //     }
        //     int m = l + (h-l)/2;
        //     if (getSumAftD(arr, m) <= k) {
        //         return binarySearchinSorted(arr, k, l, m);
        //     } else return binarySearchinSorted(arr, k, m+1, h);
        // }
        // int n;
        // public int smallestDivisor(int[] nums, int threshold) {
        //     n = nums.length;
        //    long min = Integer.MAX_VALUE, max = 0, sum = 0;
        //     for (int i = 0; i < n; i++) {
        //         min = Math.min(min, nums[i]);
        //         max = Math.max(max, nums[i]);
        //         sum += nums[i];
        //     }
        //     if (sum <= threshold) return 1;
        //     if (n == 1) return nums[0] / threshold + (nums[0] % threshold == 0 ? 0 : 1);
        //     if (getSumAftD(nums, (int)max) == threshold) return (int)max;
        //     while (getSumAftD(nums, (int)max) > threshold) max *= 2;
        //     while (getSumAftD(nums, (int)min) < threshold) min /= 2;
        //     return binarySearchinSorted(nums, threshold, (int)min, (int)max);
        // }

        
        // public int[][] matrixBlockSum(int[][] mat, int k) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     if (m == 1 && n == 1) return mat;
        //     int [][] arr = new int[m][n];
        //     int val = 0;
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             val = 0;
        //             for (int x = i-k; x <= i+k; x++) {
        //                 if (x < 0 || x >= m) continue;
        //                 for (int y = j-k; y <= j+k; y++) {
        //                     if (y < 0 || y >= n) continue;
        //                     val += mat[x][y];
        //                 }
        //             }
        //             arr[i][j] = val;
        //         }
        //     }
        //     return arr;
        // }
        // public int[][] matrixBlockSum(int[][] mat, int k) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     int [][] arr = new int[m][n]; // presum matrix
        //     int sum = 0;
        //     for (int i = 0; i < m; i++) {
        //         sum = 0;
        //         for (int j = 0; j < n; j++) {
        //             sum += mat[i][j];
        //             arr[i][j] = sum;
        //             if (i > 0) arr[i][j] += arr[i-1][j];
        //         }
        //     }
        //     int [][] res = new int[m][n];
        //     for (int i = 0; i < m; i++) {
        //         for (int j = 0; j < n; j++) {
        //             // 计算出对于该点存在的合理子矩阵范围
        //             int minR = Math.max(0, i-k);  // min Row
        //             int maxR = Math.min(m-1, i+k);// max Row
        //             int minC = Math.max(0, j-k);  // min Column
        //             int maxC = Math.min(n-1, j+k);  // max Column
        //             // 利用前缀和数组计算该子矩阵内所有数字和 (x1, y1)表示左上角坐标， (x2, y2)表示右下角坐标
        //                // sum([x1,y1],[x2,y2]) = presum[x2][y2]
        //                                 //     - presum[x1-1][y2]
        //                                 //     - presum[x2][y1-1]
        //                                 //     + presum[x1-1][y1-1];
        //             res[i][j] = arr[maxR][maxC];
        //             if (minR > 0) res[i][j] -= arr[minR-1][maxC];
        //             if (minC > 0) res[i][j] -= arr[maxR][minC-1];
        //             if (minR > 0 && minC > 0) res[i][j] += arr[minR-1][minC-1];
        //         }
        //     }
        //     return res;
        // }
        
        // private boolean getMaxSumWithSideLengthV(int [][] arr, int t, int v) {
        //     int sum = 0;
        //     for (int i = 0; i+v-1 < m; i++) {
        //         for (int j = 0; j+v-1 < n; j++) {
        //             for (int k = 0; k < v; k++) {
        //                 if (i == 0 && j == 0) {
        //                     sum = arr[v-1][v-1];
        //                     sum = 0;
        //                     continue;
        //                 }
        //                 sum = arr[i+v-1][j+v-1] - (j-1 >= 0 ? arr[i+v-1][j-1] : 0) -  (i-1 >= 0 ? arr[i-1][j+v-1] : 0) +
        //                     (i-1 >= 0 && j-1 >= 0 ? arr[i-1][j-1] : 0); 
        //                 if (sum <= t) return true;
        //             }
        //         }
        //     }
        //     return false;
        // }
        // private int binarySearchinMatrix(int [][] arr, int t, int l, int h) {
        //     if (l == h) {
        //         if (getMaxSumWithSideLengthV(arr, t, l)) return l;
        //         return 0;
        //     }
        //     if (l == h-1) {
        //         if (getMaxSumWithSideLengthV(arr, t, h)) return h;
        //         if (getMaxSumWithSideLengthV(arr, t, l)) return l;
        //         return 0;
        //     }
        //     int mid = l + (h-l)/2;
        //     if (getMaxSumWithSideLengthV(arr, t, mid)) return binarySearchinMatrix(arr, t, mid, h);
        //     return binarySearchinMatrix(arr, t, l, mid-1);
        // }
        // int m, n;
        // int [][] arr;
        // public int maxSideLength(int[][] mat, int threshold) {
        //     m = mat.length;
        //     n = mat[0].length;
        //     if (m == 1 && n == 1) return mat[0][0] <= threshold ? 1 : 0;
        //     arr = new int[m][n];
        //     arr[0][0] = mat[0][0];
        //     int sum = 0;
        //     int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        //     for (int i = 0; i < m; i++) {
        //         sum = 0;
        //         for (int j = 0; j < n; j++) {
        //             sum += mat[i][j];
        //             arr[i][j] = sum;
        //             if (i > 0) arr[i][j] += arr[i-1][j];
        //             min = Math.min(min, arr[i][j]);
        //             max = Math.max(max, arr[i][j]);
        //         }
        //     }
        //     if (threshold < min) return 0;
        //     if (threshold > max) return Math.min(m, n);
        //     return binarySearchinMatrix(arr, threshold, 1, Math.min(m, n));
        // }

        // private int binarySearchinSortedArray(int [] arr, int v, int l, int h) {
        //     if (l > h) return -1;
        //     if (l == h) return arr[l] >= v ? l : -1;
        //     if (l == h-1) {
        //         if (arr[h] >= v) return h;
        //         if (arr[l] >= v) return l;
        //         return -1;
        //     }
        //     int m = l + (h-l)/2;
        //     if (arr[m] == v) {
        //         int i = m;
        //         while (i <= h && arr[i] == v) ++i;
        //         if (i == h+1) return h;
        //         return i-1;
        //     } else if (arr[m] > v && arr[m+1] < v) return m;
        //     else if (arr[m] > v) return binarySearchinSortedArray(arr, v, m+1, h);
        //     else if (arr[m] < v && arr[m-1] >= v) return m-1;
        //     else return binarySearchinSortedArray(arr, v, l, m-1);
        // }
        // public int maxDistance(int[] a, int[] b) {
        //     int m = a.length;
        //     int n = b.length;
        //     if (n == 1) return 0;
        //     int j = 0, max = 0;
        //     for (int i = 0; i < m; i++) {
        //         j = binarySearchinSortedArray(b, a[i], i+1, n-1);
        //         if (j != -1 && j >= i)
        //             max = Math.max(max, j-i);
        //     }
        //     return max;
        // }


        // private int binarySearchinSortedArray(int k, int n, int l, int h, int cnt) {
        //     if (l == h) 
        // }
        // public int superEggDrop(int k, int n) {
        //     return binarySearchinSortedArray(k, n, 1, n, 0);
        // }

        // private Map<Integer, Set<List<Integer>>> getLenthM(int [][] arr, int v) { // of length v
        //     Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        //     Set<List<Integer>> sli = new TreeSet<>();
        //     for (int i = 0; i < m; i++) {
        //         map.put(i, new HashSet<List<Integer>>());
        //         sli = new HashSet<>();
        //         if (arr[i].length == v) {
        //             sli.add(Arrays.stream(arr[i]).boxed().collect(Collectors.toList()));
        //             map.put(i, sli);
        //             continue;
        //         }
        //         int [] tmp = arr[i];
        //         for (int j = 0; j+v <= tmp.length; j++) {
        //             sli.add(IntStream.range(j, j+v).mapToObj(k -> tmp[k]).collect(Collectors.toList()));
        //         }
        //         map.put(i, sli);
        //     }
        //     return map;
        // }
        // private boolean possible(int [][] arr, int v) {
        //     System.out.println("v: " + v);
        //     Map<Integer, Set<List<Integer>>> map = getLenthM(arr, v);
        //     // System.out.println("map.size(): " + map.size());
        //     // for (Map.Entry<Integer, Set<List<Integer>>> entry : map.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": ");
        //     //     System.out.println("entry.getValue().size(): " + entry.getValue().size());
        //     //     for (List<Integer> li : entry.getValue()) {
        //     //         for (int z = 0; z < li.size(); ++z) 
        //     //             System.out.print(li.get(z) + ", ");
        //     //         System.out.print("\n");
        //     //     }
        //     // }
        //     // System.out.print("\n");
        //     int minSize = map.get(0).size();
        //     int key = 0;
        //     for (Map.Entry<Integer, Set<List<Integer>>> entry : map.entrySet()) {
        //         if (entry.getValue().size() < minSize) {
        //             minSize = entry.getValue().size();
        //             key = entry.getKey();
        //         }
        //     }
        //     System.out.println("key: " + key);
        //     System.out.println("map.get(key).size()): " + map.get(key).size());

        //     int cnt = 0;
        //     Set<List<Integer>> sli = map.get(key);
        //     // for (List<Integer> li : sli) {
        //     //     for (int z = 0; z < li.size(); ++z) 
        //     //         System.out.print(li.get(z) + ", ");
        //     //     System.out.print("\n");
        //     // }
            
        //     for (List<Integer> li : sli) {
        //         // System.out.println("li.size(): " + li.size());
        //         // for (int z = 0; z < li.size(); ++z) 
        //         //     System.out.print(li.get(z) + ", ");
        //         // System.out.print("\n");
        //         cnt = 0;
        //         for (Set<List<Integer>> val : map.values()) {
        //             if (!val.contains(li)) break;
        //             ++cnt;
        //         }
        //         if (cnt == m) return true;
        //         cnt = 0;
        //     }
        //     return false;
        // }
        // int m;
        // private int binarySearchinMatrix(int [][] arr, int l, int h) {
        //     // System.out.println("\nl: " + l);
        //     // System.out.println("h: " + h);
        //     if (l == h) {
        //         if (possible(arr, h)) return h;
        //         return 0;
        //     } else if (l == h -1) {
        //         if (possible(arr, h)) return h;
        //         if (possible(arr, l)) return l;
        //         return 0;
        //     }
        //     int mid = l + (h-l)/2;
        //     // System.out.println("mid: " + mid);
        //     if (possible(arr, mid)) {
        //         int res = binarySearchinMatrix(arr, mid+1, h);
        //         if (res > 0) return res;
        //         return mid;
        //     }
        //     return binarySearchinMatrix(arr, l, mid-1);
        // }
        // public int longestCommonSubpath(int n, int[][] arr) {
        //     m = arr.length;
        //     int min = arr[0].length;
        //     for (int i = 1; i < m; i++) 
        //         min = Math.min(min, arr[i].length);
        //     // System.out.println("min: " + min);
        //     return binarySearchinMatrix(arr, 0, min);
        // }


        // public class UnionFind {
        //     int [] pare;
        //     int [] rank;
        //     int n;
        //     int cnt;
        //     public UnionFind(int x) {
        //         n = x;
        //         cnt = n;
        //         pare = new int[n];
        //         rank = new int[n];
        //         for (int i = 0; i < n; i++) {
        //             pare[i] = i;
        //         }
        //         Arrays.fill(rank, 1);
        //     }
        //     public int find(int val) {
        //         while (val != pare[val]) {
        //             pare[val] = pare[pare[val]];
        //             val = pare[val];
        //         }
        //         return val;
        //     }
        //     public void merge(int p, int q) {
        //         int rp = find(p);
        //         int rq = find(q);
        //         if (rank[rp] < rank[rq]) {
        //             swap(rp, rq);
        //         }
        //         pare[rq] = rp;
        //         rank[rp] += rank[rq];
        //         --cnt;
        //     }
        //     public boolean sameGroup(int x, int y) {
        //         return find(x) == find(y);
        //     }
        //     public int getCnt() {
        //         return cnt;
        //     }
        //     private void swap(int x, int y) {
        //         int tmp = x;
        //         x = y;
        //         y = tmp;
        //     }
        //     public UnionFind clone() {
        //         UnionFind copy = new UnionFind(n);
        //         copy.pare = new int[n];
        //         copy.rank = new int[n];
        //         for (int i = 0; i < n; i++) {
        //             copy.pare[i] = pare[i];
        //             copy.rank[i] = rank[i];
        //         }
        //         copy.cnt = cnt;
        //         return copy;
        //     }
        // }
        // private boolean bfsPossible(int [][] arr, int x, int y, int v) {
        //     // System.out.println("arr.length: " + arr.length);
        //     // for (int z = 0; z < arr.length; ++z) {
        //     //     for (int w = 0; w < arr[z].length; w++) 
        //     //         System.out.print(arr[z][w] + ", ");
        //     //     System.out.print("\n");
        //     // }
        //     // System.out.println("v: " + v);
        //     UnionFind uf = new UnionFind(n*n);
        //     for (int i = 0; i < n; i++) Arrays.fill(vis[i], false);
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) { // 这里有个bug改天再改
        //             System.out.println("i: " + i);
        //             System.out.println("j: " + j);
        //             for (int [] d : dirs) {
        //                 if (i+d[0] >= 0 && j+d[1] >= 0 && i+d[0] < n && j+d[1] < n && !vis[i+d[0]][j+d[1]] && arr[i+d[0]][j+d[1]] <= v  && !uf.sameGroup(i*n+j, (i+d[0])*n+j+d[1])) {
        //                     vis[i][j] = true;
        //                     uf.merge(i*n+j, (i+d[0])*n+j+d[1]);
        //                 }
        //             }
        //         }
        //     }
        //     // System.out.println("uf.pare.length: " + uf.pare.length);
        //     // for (int z = 0; z < uf.pare.length; ++z) {
        //     //     if (z % n == n-1)
        //     //         System.out.println("\n");
        //     //     System.out.print(uf.pare[z] + ", ");
        //     // }
        //     // System.out.println("");
        //     return uf.sameGroup(0, n*n-1);
        // }
        // 对深搜和广搜中的重复与纪录备忘问题，想得还不是很透，要再好好想想，再回来写这个
        // private boolean bfsPossible(int [][] arr, int x, int y, int v) {
        //     if (arr[x][y] > v) return false;
        //     Queue<Integer> q = new LinkedList<>();
        //     q.add(x*n+y);
        //     int i = 0, j = 0;
        //     int cur = 0;
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         i = cur / n;
        //         j = cur % n;
        //         if (i == n-1 && j == n-1) return true;
        //         vis[i][j] = true;
        //         for (int [] dir : dirs) 
        //             if (i+dir[0] >= 0 && i+dir[0] < n && j+dir[1] >= 0 && j+dir[1] < n && !vis[i+dir[0]][j+dir[1]] && arr[i+dir[0]][j+dir[1]] <= v)
        //                 q.add((i+dir[0])*n+j+dir[1]);
        //     }
        //     return false;
        // }
        // boolean res = false;
        // private void dfsPossible(int [][] arr, int i, int j, int v) {
        //     if (i < 0 || i >= n || j < 0 || j >= n || vis[i][j] || arr[i][j] > v) return;
        //     if (i == n-1 && j == n-1) {
        //         res = true;
        //         return;
        //     }
        //     vis[i][j] = true;
        //     for (int [] dir : dirs) 
        //         dfsPossible(arr, i+dir[0], j+dir[1], v);
        //     vis[i][j] = false;
        // }
        // private int binarySearchinMatrix(int [][] arr, int l, int h) {
        //       System.out.println("\nl: " + l);
        //       System.out.println("h: " + h);
        //     if (l == h) return l;
        //     else if (l == h-1) {
        //         for (int i = 0; i < n; i++) Arrays.fill(vis[i], false);
        //         if (bfsPossible(arr, 0, 0, l)) return l;
        //         return h;
        //     }
        //     int m = l + (h-l) / 2;
        //       System.out.println("m: " + m);
        //     for (int i = 0; i < n; i++) Arrays.fill(vis[i], false);            
        //     if (bfsPossible(arr, 0, 0, m)) return binarySearchinMatrix(arr, l, m);
        //     else return binarySearchinMatrix(arr, m+1, h);
        // }
        // int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // boolean [][] vis;
        // int n;
        // // UnionFind uf;
        // public int swimInWater(int[][] grid) {
        //     n = grid.length;
        //     // System.out.println("n: " + n);
        //     int max = 0;
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         for (int j = 0; j < n; j++) {
        //             min = Math.min(min, grid[i][j]);
        //             max = Math.max(max, grid[i][j]);
        //         }
        //     }
        //     // System.out.println("min: " + min);
        //     // System.out.println("max: " + max);
        //     vis = new boolean[n][n];
        //     return binarySearchinMatrix(grid, min, max);
        //     // // int min = 0;
        //     // // int max = n*n-1;
        //     // while (min <= max) {
        //     //     int mid = min + (max - min) / 2;
        //     //     for (int i = 0; i < n; i++) Arrays.fill(vis[i], false);
        //     //     // bfsPossible(grid, 0, 0, mid);
        //     //     res = false;
        //     //     dfsPossible(grid, 0, 0, mid);
        //     //     if (res) min = mid+1;
        //     //     else max = mid-1;
        //     // }
        //     // return min;
        // }

        
        // private int binarySearchinArray(int [] arr, int k, int v, int l, int h) {
        //     if (l == h) return arr[l] - (v == 0 ? 0 : arr[v-1]) >= k ? l : -1;
        //     if (l == h-1) return arr[l] - (v == 0 ? 0 : arr[v-1]) >= k ? l : (arr[h]-(v == 0 ? 0 : arr[v-1]) >= k ? h : -1);
        //     int m = l + (h-l)/2;
        //     if (arr[m] - (v == 0 ? 0 : arr[v-1]) == k) return m;
        //     if (arr[m] - (v == 0 ? 0 : arr[v-1]) > k) return binarySearchinArray(arr, k, v, l, m);
        //     return binarySearchinArray(arr, k, v, m+1, h);
        // }
        // int n;
        // public int minSubArrayLen(int target, int[] nums) {
        //     int n = nums.length;
        //     int sum = nums[0];
        //     int [] arr = new int [n];
        //     arr[0] = nums[0];
        //     for (int i = 1; i < n; i++)   {
        //         sum += nums[i];
        //         arr[i] = sum;
        //     }
        //     if (target > arr[n-1]) return 0;
        //     if (target == arr[n-1]) return n;
        //     int j = 0;
        //     int min = Integer.MAX_VALUE;
        //     for (int i = 0; i < n; i++) {
        //         j = binarySearchinArray(arr, target, i, 0, n-1);
        //         if (j != -1)
        //             min = Math.min(min, j-i+1);
        //     }
        //     return min == Integer.MAX_VALUE ? 0 : min;
        // }


        // public int reachNumber(int target) { // n : target 
        //     int [] dp = new int[2 * target +1];
        //     int [] left = new int[target +1];
        //     Arrays.fill(dp, -1);
        //     dp[target+1] = 0;
        //     int j = 0;
        //     for (int i = 1; i <= target; i++) { // update j each time to be current pos, and continue updating dp
        //         if (dp[i+target+1+j] == -1 && dp[target+1] != -1)
        //             dp[i+target+1+j] = dp[target+1] + 1;
        //         if (dp[target-i-1] == -1 && dp[target+1] != -1)
        //             dp[target-1-i] = dp[target+1] + 1;
        //         j = i;
        //     }
        //     for (int i = 1; i <= target; i++) {
        //         if (dp[i] == -1 && dp[0] != -1) dp[i] = dp[0] + 1;
        //         if (left[i] == -1 && left[0] != -1) left[i] = left[0] + 1;
        //     }
        // }

        
        // public int numSubseq(int[] nums, int target) {
        //     int n = nums.length;
        //     Arrays.sort(nums);
        //     System.out.println("nums.length: " + nums.length);
        //     for (int z = 0; z < nums.length; ++z) 
        //         System.out.print(nums[z] + ", ");
        //     System.out.println("");
        //     if (target > nums[n-1] + nums[n-1]) return (int)(Math.pow(n, 2) -1);
        //     int j = 0;
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 &&  nums[i] == nums[i-1]) {
        //             res += j-(i-1)+1;
        //             continue;
        //         }
        //         j = i;
        //         while (j < n &&  nums[i] + nums[j] <= target) ++j;
        //         // System.out.println("(j-i+1): " + (j-i+1));
        //         res += j-i+1;
        //     }
        //     return res;
        // }
        // int []  a = new int []  {2, 3, 3, 4, 6, 7}; // 怎么考虑重复的问题


        // public int chalkReplacer(int[] chalk, int k) {
        //     int n = chalk.length;
        //     int sum = 0;
        //     for (int i = 0; i < n; i++) 
        //         sum += chalk[i];
        //     k = k % sum;
        //     int i = 0;
        //     while (i < n && chalk[i] <= k) {
        //         k -= chalk[i];
        //         ++i;
        //     }
        //     return i;
        // }



        // public int findPairs(int[] arr, int k) {
        //     int n = arr.length;
        //     int cnt = 0;
        //     Set<Pair<Integer, Integer>> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         for (int j = i+1; j < n; j++) {
        //             if (Math.abs(arr[i]-arr[j]) == k) {
        //                 ++cnt;
        //                 if (!s.contains(new Pair<>(arr[i], arr[j])) && !s.contains(new Pair<>(arr[j], arr[i])))
        //                     s.add(new Pair<>(arr[i], arr[j]));
        //             }
        //         }
        //     }
        //     return s.size();
        // }

        // private boolean citationsable(int [] arr, int v) {
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (arr[i] >= v) ++cnt;
        //     return cnt >= v;
        // }
        // private int binarySearchinSortedArray(int [] arr, int l, int h) {
        //     if (l == h) return citationsable(arr, h) ? h : 0;
        //     if (l == h-1)
        //         return citationsable(arr, h) ? h : (citationsable(arr, l) ? l : 0);
        //     int m = l + (h-l)/2;
        //     if (citationsable(arr, m)) return binarySearchinSortedArray(arr, m, h);
        //     return binarySearchinSortedArray(arr, l, m-1);
        // }
        // int n;
        // public int hIndex(int[] citations) {
        //     n = citations.length;
        //     if (n == 1) return citations[0] >= 1 ? 1 : 0;
        //     int min = citations[0];
        //     int max = citations[0];
        //     for (int i = 0; i < n; i++) {
        //         min = Math.min(min, citations[i]);
        //         max = Math.max(max, citations[i]);
        //     }
        //     if (n <= min) return n;
        //     return binarySearchinSortedArray(citations, 0, n-1);
        // }

        // public int findRadius(int[] houses, int[] heaters) {
        //     int n = houses.length;
        //     int m = heaters.length;
        //     Arrays.sort(houses);
        //     Arrays.sort(heaters);
        // }

        // private int binarySearchinSortedArray(int [] arr, int v, int l, int h) {
        //     if (l == h) return arr[l] >= v ? l : -1;
        //     if (l == h-1) return arr[l] >= v ? l : (arr[h] >= v ? h : -1);
        //     int m = l + (h-l)/2;
        //     if (arr[m] >= v) return binarySearchinSortedArray(arr, v, l, m);
        //     return binarySearchinSortedArray(arr, v, m+1, h);
        // }
        // private int getLongestLength(int [] aa, int x, int y, int [] bb, int a, int b) {
        //     int j = 0;
        //     int max = 0;
        //     for (int i = y; i >= x; i--) {
        //         j = binarySearchinSortedArray(bb, aa[i], a, b);
        //         if (j != -1) {
        //             max = Math.max(max, i-x+1 + b-j+1);
        //         }
        //     }
        //     max = Math.max(max, y-x+1);
        //     max = Math.max(max, b-a+1);
        //     return max == 0 ? y-x+1 : max;
        // }
        // public int findLengthOfShortestSubarray(int[] arr) {
        //     int n = arr.length;
        //     int i = 1;
        //     while (i < n && arr[i] >= arr[i-1]) ++i;
        //     if (i == n) return 0;
        //     int j = n-2;
        //     while (j >= 0 && arr[j] <= arr[j+1]) --j;
        //     return n - getLongestLength(arr, 0, i-1, arr, j+1, n-1);
        // }


        // public boolean judgeSquareSum(int c) {
        //     if (c == 0 || c == 3) return false;
        //     if (c <= 5)  return true;
        //     int v = c/2;
        //     while (v * v > c) {
        //         v /= 2;
        //         // System.out.println("v: " + v);
        //     }
        //     // System.out.println("v: " + v);
            
        //     if (c - v*v == v*v) return true;
        //     int k = (c - v*v)/2;
        //     // System.out.println("k: " + k);
        //     while (k*k > c-v*v) k /= 2;
            

        //     if (k*k != c - v*v) return false;
        //     return true;
        // }


        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        boolean res = s.judgeSquareSum(6);
        System.out.println("res: " + res);
    }
}