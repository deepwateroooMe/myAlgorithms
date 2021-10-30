import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
// import javafx.util.Pair;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class sort {
    public static class Solution {

        // private void mergeSort(int [] arr, int i, int j, int [] res) {
        //     if (i < j) {
        //         int k = i + (j-i)/2;
        //         mergeSort(arr, i, k, res);
        //         mergeSort(arr, k+1, j, res);
        //         mergeArrays(arr, i, k, j, res);
        //     }
        // }
        // private void mergeArrays(int [] arr, int i, int k, int j, int [] res) {
        //     int x = i;
        //     int y = k+1;
        //     int idx = i;
        //     int tmp = 0;
        //     while (x <= k && y <= j) {
        //         if (arr[x] <= arr[y]) {
        //             res[idx]= arr[x];
        //             ++idx;
        //             ++x;
        //         } else {
        //             res[idx] = arr[y];
        //             ++idx;
        //             ++y;
        //         }
        //     }
        //     while (x <= k) {
        //         res[idx++] = arr[x++];
        //     }
        //     while (y <= j) {
        //         res[idx++] = arr[y++];
        //     }
        //     for (int o = i; o <= j; o++) {
        //         arr[o] = res[o];
        //     }
        // }        
        // public int[] sortArray(int[] nums) { // merge sort
        //     if (nums.length == 1) return nums;
        //     int n = nums.length;
        //     int [] arr = new int [n];
        //     mergeSort(nums, 0, nums.length-1, arr);
        //     return arr;
        // }

        // private int binarySearch(int [] arr, int i, int j, int val) {
        //     System.out.println("\ni: " + i);
        //     System.out.println("j: " + j);
        //     if (j - i == 1) {
        //         if (arr[i] < val && arr[j] > val) return i;
        //         else if (arr[i] > val) return i-1;
        //     }
        //     int k = i + (j-i)/ 2;
        //     if (arr[k] == val) {
        //         int tmp = k;
        //         while (tmp > i && arr[tmp] == val) --tmp;
        //         return tmp;
        //     } else if (arr[k] < val && k < j-1 && arr[k+1] > val) {
        //         return k;
        //     } else if (arr[k] > val && k > i && arr[k-1] < val) {
        //         return k-1;
        //     } else if (arr[k] < val) {
        //         return binarySearch(arr, k+1, j, val);
        //     } else {
        //         return binarySearch(arr, i, k-1, val);
        //     }
        // }
        // public List<Integer> countSmaller(int[] nums) {
        //     int n = nums.length;
        //     List<Integer> l = new ArrayList<>();
        //     if (n == 1) {
        //         l.add(0);
        //         return l;
        //     } else if (n == 2) {
        //         l.add(0);
        //         l.add(0, nums[0] > nums[1] ? 1 : 0);
        //         return l;
        //     }
        //     int [] arr = new int [n];
        //     int [] res = new int [n];
        //     int cnt = 0;
        //     arr[n-1] = 0;
        //     arr[n-2] = nums[n-2] > nums[n-1] ? 1 : 0;
        //     res[n-1] = Math.max(nums[n-1], nums[n-2]);
        //     res[n-2] = Math.min(nums[n-1], nums[n-2]);

        //     System.out.println("");
        //     System.out.println("res.length: " + res.length);
        //     for (int z = 0; z < res.length; ++z) 
        //     System.out.print(res[z] + ", ");
        //     System.out.println("");


        //     for (int i = n-3; i >= 0; i--) {
        //         System.out.println("\ni: " + i);
                
        //         // mergeSort(nums, i+1, nums.length-1, res);
        //         if (nums[i+1] < res[i+2]) {
        //             res[i+1] = nums[i+1];
        //             // System.out.println("binarySearch(res, i+1, n-1, nums[i+1]): " + (binarySearch(res, i+1, n-1, nums[i+1])));
        //             int j = binarySearch(res, i+1, n-1, nums[i+1]);
        //             arr[i] = j == i ? 0 : n - j -1;
        //         } else {
        //             int j = binarySearch(res, i+1, n-1, nums[i+1]);
        //             int x = 0;
        //             for ( x = i+1; x < j; x++) {
        //                 res[x] = res[x+1];
        //             }
        //             res[x] = nums[i+1];
        //             arr[i] = n - j;
        //         }
        //         // System.out.println("");
        //         // System.out.println("res.length: " + res.length);
        //         // for (int z = 0; z < res.length; ++z) 
        //         // System.out.print(res[z] + ", ");
        //         // System.out.println("");
        //     }
        //     l = Arrays.stream(arr).boxed().collect(Collectors.toList());
        //     return l;
        // }
        // int [] a = new int [] {5, 2, 6, 1};
        // int [] a = new int [] {-1, -2}; 
        // int [] a = new int [] {0, 1, 2};
        // int [] a = new int [] {-1}; 
        // int [] a = new int [] {1, 0, 2}; 

        // private int getInsertPos(int [] arr, int val, int j) {
        //     return binarySearchInsertPos(arr, val, 0, j);
        // }
        // private int binarySearchInsertPos(int [] arr, int val, int i, int j) { // with repeats
        //     System.out.println("\nval: " + val);
        //     System.out.println("i: " + i);
        //     System.out.println("j: " + j);
            
        //     if (j - i == 1) {
        //         if (val > arr[j]) return j+1;
        //         else if (val <= arr[i]) return i-1;
        //         else if (arr[i] < val && val < arr[j]) return j;
        //     }
        //     int k = i + (j-i) / 2;
        //     if (arr[k] == val) {
        //         int tmp = k;
        //         while (tmp >= i && arr[tmp] == val) --tmp;
        //         // System.out.println("tmp: " + tmp);
                
        //         if (tmp < i) return i-1;
        //         else return tmp+1;
        //     } else if (k < j-1 && arr[k] < val && val <= arr[k+1]) {
        //         return k+1;
        //     } else if (k > i && val < arr[k] && arr[k-1] < val) {
        //         return k;
        //     } else if (arr[k] < val) {
        //         return binarySearchInsertPos(arr, val, k+1, j);
        //     } else {
        //         return binarySearchInsertPos(arr, val, i, k-1);
        //     }
        // }
        
        // int res;
        // private int binarySearchInsertPos(List<Integer> arr, int val, int i, int j) { // with repeats
        //     if (j - i == 1) {
        //         if (val > arr.get(j)) return j+1;
        //         else if (val <= arr.get(i)) return i -1;
        //         else if (arr.get(i) < val && val <= arr.get(j)) return j;
        //     }
        //     int k = i + (j-i) / 2;
        //     if (arr.get(k) == val) {
        //         int tmp = k;
        //         while (tmp >= i && arr.get(tmp) == val) --tmp;
        //         return tmp+1;
        //     } else if (k <= j-1 && arr.get(k) < val && val <= arr.get(k+1)) {
        //         return k+1;
        //     } else if (k >= i && val < arr.get(k) && arr.get(k-1) < val) {
        //         return k;
        //     } else if (k <= j-1 && arr.get(k) < val) {
        //         return binarySearchInsertPos(arr, val, k+1, j);
        //     } else if (k >= i && arr.get(k) > val){
        //         return binarySearchInsertPos(arr, val, i, k-1);
        //     }
        //     return -1;
        // }
        
        // public int createSortedArray(int[] instructions) {
        //     if (instructions.length == 1) return 0;
        //     int n = instructions.length;
        //     long res = 0;
        //     List<Integer> arr = new ArrayList<>();
            
        //     int idx = 0;
        //     arr.add(instructions[0]);
        //     for (int i = 1; i < n; i++) {
        //         // System.out.println("\ninstructions[i]: " + instructions[i]);
        //         if (instructions[i] <= arr.get(0)) idx = 0;
        //         else if (instructions[i] >= arr.get(arr.size()-1)) idx = arr.size();
        //         else idx = binarySearchInsertPos(arr, instructions[i], 0, arr.size());
        //         // System.out.println("idx: " + idx);
        //         if (idx < arr.size())
        //         arr.add(idx, instructions[i]);
        //         else
        //         arr.add(instructions[i]);
                
        //         // System.out.println("");
        //         // System.out.println("arr.size(): " + arr.size());
        //         // for (int z = 0; z < arr.size(); ++z) 
        //         // System.out.print(arr.get(z) + ", ");
        //         // System.out.print("\n");

        //         int cnt = 0;
        //         for (int x = idx; x < arr.size(); x++) {
        //             if (arr.get(x) <= instructions[i]) ++cnt;
        //             else if (arr.get(x) > instructions[i]) break;
        //         }
        //         res += Math.min(idx, arr.size() - idx - cnt);
        //         // System.out.println("res: " + res);
        //     }
        //     return (int)(res % 1000000007);
        // }

        // public int[][] diagonalSort(int[][] mat) {
        //     int m = mat.length;
        //     int n = mat[0].length;
        //     Map<Integer, List<Integer>> map = new HashMap<>();
        //     int [][] arr = new int [m][n];
        //     for (int i = 0-(n-1); i <= m-1; i++) 
        //         map.put(i, new ArrayList<Integer>());
        //     for (int i = 0; i < m; i++) 
        //         for (int j = 0; j < n; j++) 
        //             map.get(i-j).add(mat[i][j]);
        //     for (List<Integer> l : map.values()) 
        //         Collections.sort(l);
        //     List<Integer> l = new ArrayList<>();
        //     int i = 0, j = 0;
        //     for (int o = -(n-1); o <= m-1; o++) {
        //         int key = o;
        //         l = map.get(o);
        //         if (key == -(n-1)){
        //             arr[0][n-1] = l.get(0);
        //             continue;
        //         } else if (key == m-1) {
        //             arr[m-1][0] = l.get(0);
        //             continue;
        //         }
        //         if (key <= 0) {
        //             i = 0;
        //             j = 0 - key;
        //         } else {
        //             i = key;
        //             j = 0;
        //         }
        //         for (int k = 0; k < l.size(); k++) {
        //             arr[i][j] = l.get(k);
        //             ++i;
        //             ++j;
        //         }
        //     }
        //     return arr;
        // }


        // public List<Boolean> checkArithmeticSubarrays(int[] arr, int[] l, int[] r) {
        //     int n = arr.length;
        //     int m = l.length;
        //     // TreeSet<Integer> ts = new TreeSet<>();
        //     List<Integer> li = new ArrayList<>();
        //     List<Boolean> res = new ArrayList<>();
        //     int k = 0, dif = 0;
        //     for (int i = 0; i < m; i++) {
        //         li.clear();
        //         for (int j = l[i]; j <= r[i]; j++) 
        //             li.add(arr[j]);
        //         Collections.sort(li);
        //         if (li.size() < 2) {
        //             res.add(false);
        //             continue;
        //         }
        //         k = 2;
        //         dif = li.get(1) - li.get(0);
        //         while (k < li.size() && li.get(k) - li.get(k-1) == dif ) ++k;
        //         if (k == li.size()) res.add(true);
        //         else res.add(false);
        //     }
        //     return res;
        // }

        // public int kthSmallest(int[][] arr, int k) {
        //     int m = arr.length;
        //     int n = arr[0].length;
        // }
        // public int [] merge_sort(int [] input) {
        //     if (input.length <= 1) {
        //         return input;
        //     }
        //     int pivot = input.length / 2;
        //     int [] left_list = merge_sort(Arrays.copyOfRange(input, 0, pivot));
        //     int [] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
        //     return merge(left_list, right_list);
        // }
        // public int [] merge(int [] left_list, int [] right_list) {
        //     int [] ret = new int[left_list.length + right_list.length];
        //     int left_cursor = 0, right_cursor = 0, ret_cursor = 0;
        //     while (left_cursor < left_list.length && 
        //            right_cursor < right_list.length) {
        //         if (left_list[left_cursor] < right_list[right_cursor]) {
        //             ret[ret_cursor++] = left_list[left_cursor++];
        //         } else {
        //             ret[ret_cursor++] = right_list[right_cursor++];
        //         }
        //     }
        //     while (left_cursor < left_list.length) {
        //         ret[ret_cursor++] = left_list[left_cursor++];
        //     }
        //     while (right_cursor < right_list.length) {
        //         ret[ret_cursor++] = right_list[right_cursor++];
        //     }  
        //     return ret;
        // }

        // public int[] getStrongest(int[] num, int k) {
        //     int n = num.length;
        //     Arrays.sort(num);
        //     double med = num[(n-1)/2];
        //     int [] arr = IntStream.rangeClosed(1, n).map(i->num[n-i]).toArray();
        //     int [] res = new int[k];
        //     int i = 0, j = n-1, idx = 0;
        //     int tmp = k;
        //     while (tmp > 0) {
        //         while (arr[i] - med >= med-arr[j]) {
        //             res[idx++] = arr[i];
        //             if (idx == k) break;
        //             ++i;
        //             --tmp;
        //             continue;
        //         }
        //         while (med-arr[j] > arr[i]-med) {
        //             res[idx++] = arr[j];
        //             if (idx == k) break;
        //             --j;
        //             --tmp;
        //             continue;
        //         }
        //         if (idx == k) break;
        //     }
        //     return res;
        // }

        // public String customSortString(String s, String ss) {
        //     int n = s.length();
        //     int m = ss.length();
        //     int [] idx = new int [26];
        //     Arrays.fill(idx, -1);
        //     for (int i = 0; i < n; i++) 
        //         idx[s.charAt(i)-'a'] = i;
        //     Map<Character, Integer> map = new HashMap<>();
        //     StringBuilder t = new StringBuilder(ss);
        //     for (int i = 0; i < m; i++) 
        //         map.put(ss.charAt(i), map.getOrDefault(ss.charAt(i), 0) + 1);
        //     int i = 0, j = 0, cnt = 0;
        //     while (i < n && j < m) {
        //         if (t.charAt(j) != s.charAt(i) && map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > 0) {
        //             char tmp = t.charAt(j);
        //             t.deleteCharAt(j);
        //             t.insert(j, s.charAt(i));
        //             cnt = 1;
        //             if (map.get(s.charAt(i)) > 1 && cnt < map.get(s.charAt(i))) {
        //                 while (cnt < map.get(s.charAt(i))) {
        //                     t.insert(j, s.charAt(i));
        //                     ++cnt;
        //                 }
        //             }
        //             j += map.get(s.charAt(i));
        //             map.put(s.charAt(i), 0);
        //             t.append(tmp);
        //             ++i;
        //         } else if (s.charAt(i) != t.charAt(j) && !map.containsKey(s.charAt(i))) {
        //             if (map.get(t.charAt(j)) > 1) map.put(t.charAt(j), map.get(t.charAt(j))-1);
        //             else map.put(t.charAt(j), 0);
        //             ++j;
        //         } else if (s.charAt(i) == t.charAt(j)) {
        //             if (map.get(s.charAt(i)) == 1) {
        //                 map.put(s.charAt(i), 0);
        //                 ++i;
        //                 ++j;
        //             } else {
        //                 cnt = 1;
        //                 while (cnt < map.get(s.charAt(i))) {
        //                     t.insert(j, s.charAt(i));
        //                     ++cnt;
        //                 }
        //                 j += map.get(s.charAt(i));
        //                 map.put(s.charAt(i), 0);
        //                 ++i;
        //             }
        //         } else if (t.charAt(j) != s.charAt(i) && map.get(t.charAt(j)) == 0) 
        //             t.deleteCharAt(j);
        //     }
        //     if (j < t.length()) {
        //         t = new StringBuilder(t.toString().substring(0, j));
        //         for (Map.Entry<Character, Integer> en : map.entrySet()) {
        //             if (en.getValue() == 1) {
        //                 t.append(en.getKey());
        //                 continue;
        //             }
        //             cnt = 0;
        //             while (cnt < en.getValue()) {
        //                 t.append(en.getKey());
        //                 ++cnt;
        //             }
        //         }
        //     }
        //     return t.toString();
        // }

        // public String arrangeWords(String text) {
        //     if (text.length() == 1) return text;
        //     String [] tmp = text.split("\\s+");
        //     String start = tmp[0];
        //     Arrays.sort(tmp, (a, b)->a.length()-b.length());
        //     StringBuilder t = new StringBuilder();
        //     for (int i = 0; i < tmp.length; i++) {
        //         if (i == 0) {
        //             t.append(Character.toUpperCase(tmp[0].charAt(0)));
        //             t.append(tmp[i].substring(1, tmp[0].length()).toCharArray());
        //         } else {
        //             if (start.equals(tmp[i])) {
        //                 t.append(Character.toLowerCase(tmp[i].charAt(0)));
        //                 t.append(tmp[i].substring(1, tmp[i].length()).toCharArray());
        //             } else
        //                 t.append(tmp[i].toCharArray());
        //         }
        //         if (i < tmp.length-1)
        //             t.append(' ');
        //     }
        //     return t.toString();
        // }

        // public int reductionOperations(int[] nums) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < nums.length; i++) 
        //         m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        //     int [] arr = Arrays.stream(nums).distinct().toArray();
        //     Arrays.sort(arr);
        //     int n = arr.length;
        //     int res = 0;
        //     for (int i = n-1; i > 0; i--) 
        //         res += i * m.get(arr[i]);
        //     return res;
        // }

        // public boolean closeStrings(String s, String t) {
        //     int m = s.length();
        //     int n = t.length();
        //     if (m != n) return false;
        //     if (s.chars().distinct().count() != t.chars().distinct().count()) return false;
        //     Set<Character> ss = new HashSet<>();
        //     Set<Character> st = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         ss.add(s.charAt(i));
        //         st.add(t.charAt(i));
        //     }
        //     for (Character c : ss) 
        //         if (!st.contains(c)) return false;
        //     for (Character c : st) 
        //         if (!ss.contains(c)) return false;
        //     Map<Character, Integer> ms = new HashMap<>();
        //     Map<Character, Integer> mt = new HashMap<>();
        //     for (int i = 0; i < m; i++) {
        //         ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0) + 1);
        //         mt.put(t.charAt(i), mt.getOrDefault(t.charAt(i), 0) + 1);
        //     }
        //     if (ms.size() != st.size()) return false;
        //     for (Integer v : ms.values()) 
        //         if (!mt.values().contains(v)) return false;
        //     for (Integer v : mt.values()) 
        //         if (!ms.values().contains(v)) return false;
        //     Map<Integer, Integer> si = new HashMap<>();
        //     Map<Integer, Integer> ti = new HashMap<>();
        //     for (Integer val : ms.values()) 
        //         si.put(val, si.getOrDefault(val, 0) + 1);
        //     for (Integer val : mt.values()) 
        //         ti.put(val, ti.getOrDefault(val, 0) + 1);
        //     for (Map.Entry<Integer, Integer> en : si.entrySet()) 
        //         if (!ti.containsKey(en.getKey()) || ti.get(en.getKey()) != en.getValue()) return false;
        //     return true;
        // }

        // public int minMoves2(int[] arr) {
        //     int n = arr.length;
        //     int sum = arr[0];
        //     for (int i = 1; i < n; i++) 
        //         sum += arr[i];
        //     int v = sum / n;
        //     System.out.println("v: " + v);
        //     sum = 0;
        //     for (int i = 0; i < n; i++)
        //         sum += Math.abs(arr[i] - v);
        //     return sum;
        // }

        // private boolean valid(String s, String t, int idx) {
        //     int n = s.length();
        //     for (int i = idx; i < idx+t.length(); i++) 
        //         if (s.charAt(i) != t.charAt(i-idx)) return false;
        //     return true;
        // }
        // public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //     Map<Integer, String []> map = new HashMap<>();
        //     for (int i = 0; i < sources.length; i++) {
        //         if (valid(s, sources[i], indices[i]))
        //             map.put(indices[i], new String[]{sources[i], targets[i]});
        //     }
        //     Map<Integer, String[]> m = map.entrySet().stream()
        //         .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        //         .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        //     StringBuilder t = new StringBuilder(s);
        //     String ss = "", tt = "";
        //     for (Map.Entry<Integer, String[]> en : m.entrySet()) {
        //         ss = en.getValue()[0];
        //         tt = en.getValue()[1];
        //         for (int i = 0; i < ss.length(); i++) 
        //             t.deleteCharAt(en.getKey());
        //         for (int i = tt.length()-1; i >= 0; i--) 
        //             t.insert((int)en.getKey(), tt.charAt(i));
        //     }
        //     return t.toString();
        // }


        // public int removeCoveredIntervals(int[][] intervals) {
        //     Arrays.sort(intervals, (x, y)-> (x[0] == y[0] ? y[1]-x[1] : x[0]-y[0]));
        //     int n = intervals.length;
        //     int cnt = n;
        //     for (int i = 0; i < n; i++) {
        //         if (intervals[i][1] == 100001) continue;
        //         for (int j = i+1; j < n; j++) {
        //             if (intervals[i][1] >= intervals[j][1]) {
        //                 --cnt;
        //                 intervals[j][1] = 100001;
        //             }
        //         }
        //     }
        //     return cnt;
        // }


        // public String rankTeams(String[] votes) {
        //     int n = votes[0].length;
        //     int [][] cnt = new int[26][27];
        //     for (int i = 0; i < 26; i++) 
        //         cnt[i][26] = -1;
        //     for (int i = 0; i < votes.length; i++) {
        //         String vote = votes[i];
        //         for (int j = 0; j < n; j++) {
        //             int team = vote.charAt(j)-'A';
        //             cnt[team][j]++;
        //             cnt[team][26] = team;
        //         }
        //     }
        //     Arrays.sort(cnt, (a, b)->{
        //             for (int i = 0; i < 26; i++) 
        //                 if (a[i] != b[i]) return b[i] - a[i];
        //             return a[26]-b[26];
        //         });
        //     StringBuilder s = new StringBuilder();
        //     for (int i = 0; i < 26; i++) {
        //         if (cnt[i][26] == -1) break;
        //         sb.append((char)(cnt[i][26]+'A'));
        //     }
        //     return sb.toString();
        // }

        // public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        //     int n = restaurants.length;
        //     Arrays.sort(restaurants, (a, b) -> {
        //             if (a[1] != b[1]) return b[1]- a[1];
        //             return b[0] - a[0];
        //         });
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         if  (veganFriendly == 1 && restaurants[i][2] == 0) continue;
        //         if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) continue;
        //         l.add(restaurants[i][0]);
        //     }
        //     return l;
        // }

        
        // private int helper(int [][] arr, int x, int y) {
        //     if (x > n/2 || y > n/2) return Integer.MAX_VALUE;
        //     int idx = x + y;
        //     if (idx == n) return 0;
        //     if (memo[x][y] > 0) return memo[x][y];
        //     int ca = helper(arr, x+1, y);
        //     if (ca != Integer.MAX_VALUE) ca += arr[idx][0];
        //     int cb = helper(arr, x, y+1);
        //     if (cb != Integer.MAX_VALUE) cb += arr[idx][1];
        //     int res = Math.min(ca, cb);
        //     memo[x][y] = res;
        //     return res;
        // }
        // int n;
        // int [][] memo;
        // public int twoCitySchedCost(int[][] costs) {
        //     n = costs.length;
        //     memo = new int [n][n];
        //     return helper(costs, 0, 0);
        // }
        // public int twoCitySchedCost(int[][] costs) {
        //     Arrays.sort(costs, new Comparator<int[]>() {
        //             @Override public int compare(int[] a, int[] b) {
        //                 int v1 = a[1] - a[0];    
        //                 int v2 = b[1] - b[0];
        //                 return v1-v2;
        //             }
        //         });
        //     int sum = 0;
        //     for(int[] cost: costs) {
        //         sum += cost[0];
        //     }
        //     for(int i = 0; i < costs.length/2; ++i) {
        //         sum += costs[i][1] - costs[i][0];
        //     }
        //     return sum;
        // }
        // public int twoCitySchedCost(int[][] costs) {
        //     int n = costs.length / 2;
        //     int [][] dp = new int[n+1][n+1];
        //     for (int i = 1; i <= n; i++) {
        //         dp[i][0] = dp[i-1][0] + costs[i-1][0]; // 0-js to city A
        //         dp[0][i] = dp[0][i-1] + costs[i-1][1]; // 0-is to city B
        //     }
        //     for (int i = 1; i <= n; i++) 
        //         for (int j = 1; j <= n; j++) 
        //             dp[i][j] = Math.min(dp[i-1][j]+costs[i+j-1][0], dp[i][j-1]+costs[i+j-1][1]);
        //     return dp[n][n];
        // }

        
        // private int getGCD(int x, int y) {
        //       // Euclidean algorithm to find GCD
        //       // https://en.wikipedia.org/wiki/Euclidean_algorithm
        //     if (y == 0) return x;
        //     return getGCD(y,  x % y);
        // }
        // boolean [][] pos;
        // ArrayList<Integer>[] tree;
        // // Each entry will represent: <value, [depth, nodeIndex]>
        // Map<Integer, int []> m;
        // boolean [] vis;
        // private void dfs(int [] arr, int depth, int node, int [] ans) { // 深度优先遍历树的时候维护路径上的节点的位置
        //     if (vis[node]) return;
        //     vis[node] = true;
        //     int ancestor = -1;         // cloest ancestor
        //     int d = Integer.MAX_VALUE; // depth of ancestor
        //     // Find a number (candidate) that is Co-prime with current node value and also check
        //     // if we have that candidate in out 'ancestor' map. 
        //     // If found, try to minimize the depth between them.
        //     for (int i = 1; i < 51; i++) {
        //         if (pos[arr[node]][i] && m.containsKey(i)) {
        //             if (depth - m.get(i)[0] <= d) {
        //                 d = depth - m.get(i)[0];
        //                 ancestor = m.get(i)[1];
        //             }
        //         }
        //     }
        //     // Store the closest ancestor found, If not, by default -1
        //     ans[node] = ancestor;
        //     // for backtracking purpose, store old entry so that we can restore it back
        //     // when we come again after visiting its children.
        //     // If No such entry in our ancestor, we store [-1, -1] (distinguishing value)  
        //     int [] exist = (m.containsKey(arr[node]) ? m.get(arr[node]) : new int[] {-1, -1});
        //     m.put(arr[node], new int[]{depth, node});
        //     // Visit its child just like we do in DFS. Just skip the parent
        //     for (int child : tree[node]) { 
        //         if (vis[child]) continue; // tree[node].get(0) alreaday vised
        //         dfs(arr, depth+1, child, ans);
        //     }
        //     // backtracking : restrore old entry if present
        //     if (exist[0] != -1) m.put(arr[node], exist);
        //     else m.remove(arr[node]);
        // }
        // public int[] getCoprimes(int[] nums, int[][] edges) {
        //     pos = new boolean[51][51];
        //     for (int i = 1; i < 51; i++) {    // coprimes within [1, 50] between each other
        //         for (int j = 1; j < 51; j++) {
        //             if (!pos[i][j] && getGCD(i, j) == 1) {
        //                 pos[i][j] = true;
        //                 pos[j][i] = true;
        //             }
        //         }
        //     }
        //     int n = nums.length;
        //     tree = new ArrayList[n];
        //     for (int i = 0; i < tree.length; i++) 
        //         tree[i] = new ArrayList<>();
        //     for (int [] v : edges) {
        //         tree[v[0]].add(v[1]);
        //         tree[v[1]].add(v[0]);
        //     }
        //     int [] ans = new int[n];
        //     Arrays.fill(ans, -1);
        //     vis = new boolean[n];
        //     m = new HashMap<>();
        //     dfs(nums, 0, 0, ans);
        //     return ans;
        // }


        // public int minimumEffort(int[][] tasks) {
        //     int n = tasks.length;
        //     Arrays.sort(tasks, (a, b)->(a[1]-a[0]-(b[1]-b[0]))); // 这个排序要排成前面小， 中间大，后面小才行
        //     // int max = tasks[0][1] - tasks[0][0];
        //     // int res = tasks[0][1];
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         res = Math.max(res+tasks[i][0], tasks[i][1]);
        //         // if (max < tasks[i][1]) {
        //         //     res += tasks[i][1] - max;
        //         //     max += tasks[i][1] - max;
        //         //     max -= tasks[i][0];
        //         // } else max -= (tasks[i][1] - tasks[i][0]);
        //     }
        //     return res;
        // }


        // private boolean satisfies(Map<Character, Integer> s, Map<Character, Integer> t) {
        //     if (s.size() < t.size()) return false;
        //     for (Map.Entry<Character, Integer> en : t.entrySet()) {
        //         if (!s.containsKey(en.getKey()) || s.containsKey(en.getKey()) && s.get(en.getKey()) < en.getValue()) return false;
        //     }
        //     return true;
        // }
        // public String minWindow(String s, String t) {
        //     int m = s.length();
        //     int n = t.length();
        //     if (m < n) return "";
        //     if (m == 1 && n == 1 && s.charAt(0) != t.charAt(0)) return "";
        //     if (n == 1) {
        //         boolean contains = false;
        //         for (char c : s.toCharArray()) {
        //             if (c == t.charAt(0)) {
        //                 contains = true;
        //                 break;
        //             }
        //         }
        //         return !contains ? "" : t;
        //     } 
        //     Map<Character, Integer> mt = new HashMap<>();
        //     for (char c : t.toCharArray()) 
        //         mt.put(c, mt.getOrDefault(c, 0) + 1);
        //     Map<Character, Integer> ms = new HashMap<>();
        //     int l = 0, r = 0, i = 0, j = 0, pl = 0;
        //     String res = "", tmp = "";
        //     while (i < m) {
        //         while (i < m && !satisfies(ms, mt)) {
        //             ms.put(s.charAt(i), ms.getOrDefault(s.charAt(i), 0) + 1);
        //             ++i;
        //         }
        //         if (satisfies(ms, mt)) {
        //             tmp = s.substring(l, i);
        //             if (res.equals("") || res.length() > tmp.length()) res = tmp;
        //         }
        //         pl = l;
        //         while (l < i && satisfies(ms, mt)) {
        //             ms.put(s.charAt(l), ms.get(s.charAt(l))- 1);
        //             if (ms.get(s.charAt(l)) == 0) ms.remove(s.charAt(l));
        //             ++l;
        //         }
        //         if (satisfies(ms, mt) || pl != l) {
        //             tmp = s.substring(l-1, i);
        //             if (res.equals("") || res.length() > tmp.length()) res = tmp;
        //         }
        //         if (i == m) break;
        //     }
        //     return res;
        // }


        // private boolean equals(List<Integer> l, List<Integer> ll) {
        //     if (l.size() != ll.size()) return false;
        //     Collections.sort(l);
        //     Collections.sort(ll);
        //     for (int i = 0; i < l.size(); i++) 
        //         if (ll.get(i) != l.get(i)) return false;
        //     return true;
        // }
        // public int maxChunksToSorted(int[] arr) {
        //     int n = arr.length;
        //     int [] st = new int [n];
        //     System.arraycopy(arr, 0, st, 0, n);
        //     Arrays.sort(st);
        //     // System.out.println("st.length: " + st.length);
        //     // for (int z = 0; z < st.length; ++z) 
        //     //     System.out.print(st[z] + ", ");
        //     // System.out.println("");
        //     List<Integer> s = new ArrayList<>();
        //     int cnt = 0, i = 0, j = 0;
        //     boolean ins = false;
        //     while (i < n) {
        //         System.out.println("i: " + i);
        //         while (i < n && arr[i] == st[i]) {
        //             ins = true;
        //             ++cnt;
        //             System.out.println("cnt: " + cnt);
        //             ++i;   // not equals any more
        //         }
        //         System.out.println("i: " + i);
        //         if (i == n && ins) return cnt;
        //         else if (i == n) return cnt == 0 ? 1 : cnt;
        //         ins = false;
        //         j = i+1;
        //         s.add(arr[i]);
        //         while (j < n && (!s.contains(st[i]) )) {
        //             s.add(arr[j]);
        //             if (equals(IntStream.rangeClosed(i, j).mapToObj(z->st[z]).collect(Collectors.toList()), s)) {
        //                 ++cnt;
        //                 break;
        //             }
        //             ++j;
        //         }
        //         if (j == n) return ++cnt;
        //         // System.out.println("j: " + j);
        //         i = j+1;
        //         // System.out.println("cnt: " + cnt);
        //     }
        //     System.out.println("j: " + j);
        //     return cnt == 0 && !ins ? 1 : cnt;
        // }


        // public int intersectionSizeTwo(int[][] intervals) {
        //     int n = intervals.length;
        //     Arrays.sort(intervals, (a, b)->(a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]));
        //     TreeSet<Integer> s = new TreeSet<>();
        //     int min = 0, max = 0, cnt = 0;
        //     int [] cur = null;
        //     for (int i = 0; i < n; i++) {
        //         cur = intervals[i];
        //         if (i == 0) {
        //             s.add(cur[1]);
        //             s.add(cur[1]-1);
        //             continue;
        //         }
        //         min = s.first();
        //         max = s.last();
        //         if (cur[0] >= max) {
        //             if (cur[0] > max)
        //                 s.add(cur[1]-1);
        //             s.add(cur[1]);
        //         } else if (cur[1] == max && cur[0] > min
        //             || min < cur[0] && max < cur[1]) {
        //             cnt = 0;
        //             for (Integer v : s) 
        //                 if (v >= cur[0] && v <= cur[1]) ++cnt;
        //             if (cnt < 2) {
        //                 int v = cur[1];
        //                 while (s.contains(v)) --v;
        //                 s.add(v);
        //                 ++cnt;
        //             }
        //         }
        //     }
        //     return s.size();
        // }


        // public int bagOfTokensScore(int[] tokens, int power) {
        //     int n = tokens.length; 
        //     Arrays.sort(tokens);
        //     if (power < tokens[0]) return 0;
        //     boolean [] vis = new boolean [n];
        //     int i = n-1, res = 0;
        //     power -= tokens[0];
        //     res = 1;
        //     vis[0] = true;
        //     while (i >= 0) {
        //         // System.out.println("res: " + res);
        //         // System.out.println("(res > 0): " + (res > 0));
        //         if (res > 0) {
        //             i = n-1;
        //             while (i >= 0 && vis[i]) --i;
        //              if (i < 0) return res;
        //             power += tokens[i];
        //             vis[i] = true;
        //             --i;
        //             --res;
        //         }
        //         while (i >= 0 && (power < tokens[i] || vis[i])) --i;
        //         System.out.println("\ni: " + i);
        //         if (i < 0) return res;
        //         power -= tokens[i];
        //         vis[i] = true;
        //         ++res;
        //     }
        //     return res;
        // }


        // private int binarySearch(int [] arr, int v, int l, int r) {
        //     if (l == r) return arr[l] > v ? l : -1;
        //     if (l == r-1) return arr[l] > v ? l : (arr[r] > v ? r : -1);
        //     int m = l + (r-l)/2;
        //     if (arr[m] > v) return binarySearch(arr, v, l, m);
        //     return binarySearch(arr, v, m+1, r);
        // }
        // public int numFriendRequests(int[] ages) {
        //     int n = ages.length;
        //     Arrays.sort(ages);
        //     int res = 0, j = 0;
        //     for (int i = 0; i < n; i++) {
        //         j = binarySearch(ages, (int)Math.floor(0.5 * ages[i] + 7), 0, n-1);
        //         for (; j < n; j++) {
        //             if (i == j) continue;
        //             if (ages[j] > ages[i]) break;
        //             ++res;
        //         }
        //     }
        //     return res;
        // }


        // int getDiff(int [] arr, int v) {
        //     int res = 0;
        //     for (int i = 0; i < arr.length; i++) 
        //         res += Math.abs(arr[i] - v);
        //     return res;
        // }
        // public int minMoves2(int[] arr) {
        //     int n = arr.length;
        //     int sum = Arrays.stream(arr).sum();
        //     Arrays.sort(arr);
        //     int med = 0, hi = 0;
        //     if (n % 2 == 1) {
        //         med = arr[n/2];
        //         return getDiff(arr, med);
        //     } else {
        //         med = arr[n/2];
        //         hi = arr[n/2-1];
        //         return Math.min(getDiff(arr, med), getDiff(arr, hi));
        //     }
        // }


        // public boolean reorderedPowerOf2(int n) {
        //     String s = String.valueOf(n);
        //     System.out.println("s: " + s);
        //     int m = s.length();
        //     if (m == 2 && s.charAt(1) == '0') return false;
        //     char [] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     // s = (new StringBuilder(arr)).reverse().toString();
        //     System.out.println("s: " + s);
        //     return true;
        // }


        // public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        //     int n = aliceValues.length;
        //     int [][] arr = new int [n][2];
        //     for (int i = 0; i < n; i++) {
        //         arr[i][0] = aliceValues[i];
        //         arr[i][1] = bobValues[i];
        //     }
        //     Arrays.sort(arr, (a, b)->(b[0]+b[1]) - (a[0]+a[1])); // 升序排列对应下面的Integer.compare()
        //     // Arrays.sort(arr, (a, b)-> -Integer.compare(a[0]+a[1], b[0]+b[1])); // 升序排列对应下面的Integer.compare()，效果都一样
        //     int va = 0, vb = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (i % 2 == 0) va += arr[i][0];
        //         else vb += arr[i][1];
        //     return Integer.compare(va, vb);
        // }


        // public int maxOperations(int[] arr, int kk) {
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     Map<Integer, Integer> tmp = new HashMap<>(m);
        //     int res = 0, k = 0;
        //     for (Map.Entry<Integer, Integer> en : m.entrySet()) {
        //         k = en.getKey();
        //         if (k < kk && tmp.containsKey(kk - k) && k != kk-k) {
        //             res += Math.min(m.get(k), m.get(kk-k));
        //             tmp.remove(k);
        //             tmp.remove(kk-k);
        //         } else if (k < kk && k == kk / 2 && kk % k == 0) {
        //             res += m.get(k) / 2;
        //             tmp.remove(k);
        //         }
        //     }
        //     return res;
        // }


        // public int numberOfWeakCharacters(int[][] properties) {
        //     int maxAttrack = 0; // 找到所有士兵中的最大值
        //     for (int[] p : properties)
        //         maxAttrack = Math.max(maxAttrack,p[0]);
        //     // 为每一个攻击创建一个桶的位置
        //     int[] bucket = new int[maxAttrack + 2];     
        //     // 在每一个攻击力上找到最大的防御力
        //     for (int[] p : properties)
        //         bucket[p[0]] = Math.max(bucket[p[0]],p[1]);
        //     // 将桶的每一个位置都寻找到大于其攻击力的最大防御数值
        //     int rightMax = bucket[maxAttrack];
        //     for (int i = maxAttrack; i >= 0; i--) 
        //         if (rightMax > bucket[i])
        //             bucket[i] = rightMax;
        //         else
        //             rightMax = bucket[i];
        //     int ans = 0;
        //     // 最后遍历p 寻找所有的弱将
        //     for (int[] p : properties)
        //         if (bucket[p[0] + 1] > p[1]) ans++;  // 攻击力比当前小兵的攻击力大1的桶的位置存放着最大的防御力，与这个防御作比较可以得到当前小兵是否全面弱
        //     return ans;
        // }
        // public int numberOfWeakCharacters(int[][] properties) {
        //     int cnt = 0;
        //     int len = properties.length;
        //     Arrays.sort(properties, (a, b) -> (a[0] ! =  b[0] ? a[0]-b[0] : b[1]-a[1]));
        //     int max = properties[len-1][1];
        //     for(int i = len-1;i> = 0;i--){
        //         if(properties[i][1] < max)
        //             cnt++;
        //         max = Math.max(max,properties[i][1]);
        //     }
        //     return cnt;
        // }


        // public boolean carPooling(int[][] trips, int capacity) { // O(NlogN)
        //     int n = trips.length;
        //     Arrays.sort(trips, (a, b) -> (a[1] != b[1] ? a[1]-b[1] : a[2]-b[2]));
        //     System.out.println("trips.length: " + trips.length);
        //     for (int z = 0; z < trips.length; ++z) 
        //         System.out.println(Arrays.toString(trips[z]));
        //     int seat = capacity - trips[0][0];
        //     if (seat < 0) return false;
        //     // Queue<int []> q = new PriorityQueue<>(n, (a, b) -> a[2]-b[2]); // 已经坐在车上的人，按照下车时间排序
        //     Queue<int []> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // 已经坐在车上的人，按照下车时间排序
        //     q.offer(trips[0]);
        //     int [] pre = trips[0], cur = null;
        //     for (int i = 1; i < n; i++) {
        //         cur = trips[i];
        //         while (!q.isEmpty() && q.peek()[2] <= cur[1]) seat += q.poll()[0];
        //         if (seat < cur[0]) return false;
        //         seat -= cur[0];
        //         q.offer(cur);
        //     }
        //     return true;
        // }
        // public boolean carPooling(int[][] trips, int capacity) { // O(N^2)
        //     int[] sum = new int[1001]; // 构建数组，为了判断每站的乘客数
        //     for (int[] trip: trips){   // 循环trips
        //         for (int i=trip[1];i<trip[2];i++){ // 循环每个trip的起点到终点
        //             sum[i]+=trip[0];   // 在每一站加入当前trip的人数
        //             if (sum[i] > capacity){ // 如果超载返回false
        //                 return false;
        //             }
        //         }
        //     }
        //     return true;
        // }
        // public boolean carPooling(int[][] trips, int capacity) { // O(N)
        //     int[] sum = new int[1001]; // 记录每一站乘客的相对变化
        //     for (int[] trip: trips){ // 循环trips
        //         sum[trip[1]]+=trip[0]; // 起点增加此trip的人数
        //         sum[trip[2]]-=trip[0]; // 终点减少此trip的人数
        //     }
        //     for (int i=0;i<sum.length;i++){ // 利用前缀和判断当前站的乘客数
        //         sum[i] = i==0 ? sum[i] : sum[i]+sum[i-1];
        //         if (sum[i] > capacity){
        //             return false;
        //         }
        //     }
        //     return true;
        // }

        
        //   // 时间复杂度：O(nk \log k)O(nklogk)，其中 nn 是所有列表的平均长度，kk 是列表数量。所有的指针移动的总次数最多是 nknk 次，每次从堆中取出元素和添加元素都需要更新堆，时间复杂度是 O(\log k)O(logk)，因此总时间复杂度是 O(nk \log k)O(nklogk)。
        //   // 空间复杂度：O(k)O(k)，其中 kk 是列表数量。空间复杂度取决于堆的大小，堆中维护 kk 个元素。
          public int[] smallestRange(List<List<Integer>> nums) {
              int n = nums.size();
              int resMin = 0, resMax = Integer.MAX_VALUE;
              int minRg = resMax - resMin;
              int max = Integer.MIN_VALUE;
              int [] next = new int [n]; // 各子链表中比当前idx位数值大的下一个数的下标，即idx+1,初始化全为0
              Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
                      public int compare(Integer idx1, Integer idx2) {
                          return nums.get(idx1).get(next[idx1]) - nums.get(idx2).get(next[idx2]);
                      }
                  });
              for (int i = 0; i < n; i++) {
                  q.offer(i); // 0, 1, 2, .... n-1 真神奇呀
                  max = Math.max(max, nums.get(i).get(0));
              }
              int minIdx = 0, curRg = 0;
              while (true) {
                  minIdx = q.poll(); // 取出的是最小值的子链表的序号，而子链表里的当前最小值所在子链表中的位置存于next[minIdx]中
                  curRg = max - nums.get(minIdx).get(next[minIdx]);
                  if (curRg < minRg)  {
                      minRg = curRg;
                      resMin = nums.get(minIdx).get(next[minIdx]);
                      resMax = max;
                  }
                  next[minIdx]++;
                  if (next[minIdx] == nums.get(minIdx).size()) break;
                  q.offer(minIdx); // 加回去，但是queue里真正比较的值已经变了，变强大了。。。 // 更新最小值的替换值 
                  max = Math.max(max, nums.get(minIdx).get(next[minIdx]));  // 更新最大值
              }
              return new int [] {resMin, resMax};
          }
        //   // 这里的 BB 序列是什么？我们可以用一个哈希映射来表示 BB 序列—— B[i]
        //   // B[i] 表示 ii 在哪些列表当中出现过，
        //   // 这里哈希映射的键是一个整数，表示列表中的某个数值，
        //   // 哈希映射的值是一个数组，这个数组里的元素代表当前的键出现在哪些列表里。
        //   // 如果列表集合为：
        //   // 0: [-1, 2, 3]
        //   // 1: [1]
        //   // 2: [1, 2]
        //   // 3: [1, 1, 3]
        //   // 那么可以得到这样一个哈希映射
        //   // -1: [0]
        //   // 1: [1, 2, 3, 3]
        //   // 2: [0, 2]
        //   // 3: [0, 3]
        //   // 时间复杂度：O(nk + |V|)O(nk+∣V∣)，其中 nn 是所有列表的平均长度，kk 是列表数量，|V|∣V∣ 是列表中元素的值域，在本题中 |V| \leq 2*10^5∣V∣≤2∗10 
        //   // 5
        //   // 。构造哈希映射的时间复杂度为 O(nk)O(nk)，双指针的移动范围为 |V|∣V∣，在此过程中会对哈希映射再进行一次遍历，时间复杂度为 O(nk)O(nk)，因此总时间复杂度为 O(nk + |V|)O(nk+∣V∣)。
        //   // 空间复杂度：O(nk)O(nk)，即为哈希映射使用的空间。哈希映射的「键」的数量由列表中的元素个数 nknk 以及值域 |V|∣V∣ 中的较小值决定，「值」为长度不固定的数组，但是它们的长度之和为 nknk，因此哈希映射使用的空间为 O(nk)O(nk)。在使用双指针时，还需要一个长度为 nn 的数组，其对应的空间在渐进意义下小于 O(nk)O(nk)，因此可以忽略。
        // public int[] smallestRange(List<List<Integer>> nums) {
        //       int n = nums.size();
        //       Map<Integer, List<Integer>> indices = new HashMap<>();
        //       int xmin = Integer.MAX_VALUE, xmax = Integer.MIN_VALUE;
        //       for (int i = 0; i < n; i++) {
        //           for (int v : nums.get(i)) { // 把大链表中出出过的每一个值作键，值为它所存在于的子链表序号链表
        //               List<Integer> list = indices.getOrDefault(v, new ArrayList<>());
        //               list.add(i);
        //               indices.put(v, list);
        //               xmin = Math.min(xmin, v);
        //               xmax = Math.max(xmax, v); // 这里得到全局的最小最大值
        //           }
        //       }
        //       int [] freq = new int [n];
        //       int inside = 0; // cnt # of lists included in miniRanges
        //       int left = xmin, right = xmin -1;
        //       int resLeft = xmin, resRight = xmax;
        //       while (right < xmax) {
        //           right ++;
        //           if (indices.containsKey(right)) {
        //               for (int x : indices.get(right)) {
        //                   freq[x]++;
        //                   if (freq[x] == 1) inside++;
        //               }
        //               while (inside == n) { // find ONE satified solution, try to minimize the range
        //                   if (right - left < resRight - resLeft) {
        //                       resLeft = left;
        //                       resRight = right;
        //                   }
        //                   if (indices.containsKey(left)) { // sliding the left size towards right
        //                       for (int v : indices.get(left)) {
        //                           freq[v]--;
        //                           if (freq[v] == 0) --inside;
        //                       }
        //                   }
        //                   left++;
        //               }
        //           }
        //       }
        //       return new int [] {resLeft, resRight};
        //   }


        public boolean reorderedPowerOf2(int n) {
            String t = "" + n;
            char [] s = t.toCharArray();
            Arrays.sort(s);
            String ori = new String(s);
            for (int i = 0; i < 31; i++) {
                String cur = "" + (1 << i);
                char [] curArr = cur.toCharArray();
                Arrays.sort(curArr);
                if (new String(curArr).equals(ori))
                    return true;
            }
            return false;
        }        
    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int [][] a = new int [][] {{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        
        boolean res  =  s.smallestRange(a);
        System.out.println("res: " + res);
        
    }
}