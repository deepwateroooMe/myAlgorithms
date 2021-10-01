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


        // public int countPairs(int[] arr, int low, int high) {
        //     int n = arr.length, v = 0, res = 0;
        //     // Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         for (int j = i+1; j < n; j++) {
        //             v = arr[i] ^ arr[j];
        //             if (v >= low && v <= high) {
        //                 ++res;
        //                 // m.put(v, m.getOrDefault(v, 0) + 1);
        //             }
        //         }
        //     System.out.println("res: " + res);
        //     return res;
        //     // return (new ArrayList<>(m.values())).stream().mapToInt(Integer::intValue).sum();
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


        // public class Trie {
        //     private class Node {
        //         public char val;
        //         public boolean isWord;
        //         public TreeMap<Character, Node> next;
        //         public Node(boolean isWord) {
        //             this.isWord = isWord;
        //             next = new TreeMap<>();
        //         }
        //         public Node() {
        //             this(false);
        //             next = new TreeMap<>();
        //         }
        //         public Node(char va) {
        //             this(false);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     private int size;
        //     HashMap<Integer, List<Integer>> idx = new HashMap<>();
        //     public Trie(int [] arr) {
        //         size = arr.length;
        //         idx = new HashMap<>();
        //         for (int i = 0; i < arr.length; i++) {
        //             if (!idx.containsKey(arr[i]))
        //                 idx.put(arr[i], new ArrayList<>());
        //             idx.get(arr[i]).add(i);
        //         }
        //         int key = -1;
        //     }
        //     public void insert(String word) {
        //         Node cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char c = word.charAt(i);
        //             if (cur.next.get(c) == null) 
        //                 cur.next.put(c, new Node());
        //             cur = cur.next.get(c);
        //         }
        //         if (!cur.isWord) {
        //             cur.isWord = true;
        //             size++;
        //         }
        //     }
        //     int cnt = 0;
        //     List<Pt> ll = new ArrayList<>();
        //     private void getCntsLessThanOrEqualToK(Node r, int val, int k, String s) {
        //         if (r.isWord) {
        //             int tmp = Integer.parseInt(s);
        //             if (tmp > k) return;
        //             if (tmp <= k && (tmp ^ val) >= max) {
        //                 max = Math.max(max, (tmp ^ val));
        //                 if (tmp == k) return;
        //             }
        //         }
        //         for (Character key : r.next.keySet()) 
        //             getCntsLessThanOrEqualToK(r.next.get(key), val, k, s + key);
        //     }
        //     private int getCntsLessThanOrEqualToK(int val, int k) { 
        //         max = -1;
        //         getCntsLessThanOrEqualToK(root, val, k, "");
        //         return max;
        //     }
        // }
        // public class Trie {
        //     private class Node {
        //         public int val;
        //         public boolean isExist;
        //         public Node [] next;
        //         public Node(boolean isExist) {
        //             this.isExist = isExist;
        //             next = new Node[2];
        //             val = 0;
        //         }
        //         public Node() { this(false); }
        //         public Node(char va) {
        //             this(true);
        //             this.val = va;
        //         }
        //     }
        //     private Node root;
        //     public Trie() { root = new Node(); }
        //     public void insert(int va) {
        //         Node cur = root;
        //         for (int i = 31; i >= 0; i--) {
        //             int tmp = (va >> i) & 1;
        //             if (cur.next[tmp] == null)
        //                 cur.next[tmp] = new Node();
        //             cur = cur.next[tmp];
        //         }
        //         cur.isExist = true;
        //     }
        //     public int search(int va) {
        //         int max = 0;
        //         Node cur = root;
        //         for (int i = 31; i >= 0; i--) {
        //             int t = (va >> i) & 1;
        //             if (cur.next[t^1] != null) {
        //                 max += (1 << i);
        //                 cur = cur.next[t^1];
        //             } else
        //                 cur = cur.next[t&1];
        //         }
        //         return max;
        //     }
        // }
        // public int[] maximizeXor(int[] nums, int[][] queries) { // 这里还需要一点儿工作
        //     Arrays.sort(nums);
        //     Trie t = new Trie();
        //     for (int i = 0; i < nums.length; i++)
        //         t.insert(queries[i]);
        //     int [] arr = new int[queries.length];
        //     // sort queries as well
        //     for (int i = 0; i < queries.length; i++)  
        //         arr[i] = t.getCntsLessThanOrEqualToK(queries[i][0], queries[i][1]);
        //     return arr;
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


       //  public int longestAwesome(String s) {
       //      int n = s.length(), mask = 0, max = 0, cur = 0;
       //      int [] masks = new int [n];
       //      for (int i = 0; i < n; i++) {
       //          // System.out.println("\n i: " + i);
       //          mask ^= (1 << (s.charAt(i) - '0'));
       //          masks[i] = mask;
       //          // System.out.println("masks[i]: " + Integer.toBinaryString(masks[i]));
       //          for (int j = 0; j < i; j++) {
       //              if (j == 0) cur = masks[i]; // 这里的细节上有点儿问题，需要回头再改一下
       //              else cur = masks[i] & masks[j-1];
       // //              System.out.println("j: " + j);
       // // System.out.println("cur: " + Integer.toBinaryString(cur));
       // //              System.out.println("Integer.toBinaryString(cur): " + Integer.toBinaryString(cur));
       // //              System.out.println("(cur == 0 || Integer.bitCount(cur) == 1): " + (cur == 0 || Integer.bitCount(cur) == 1));
       //              if (cur == 0 || Integer.bitCount(cur) == 1)
       //                  max = Math.max(max, i-j);
       //              // System.out.println("max: " + max);
       //          }
       //      }
       //      return max;
       //  }


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

        
        // public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        //     int n = s.length();
        //     int m = queries.length, mask = 0;
        //     int [] arr = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         mask ^= (1 << s.charAt(i)-'a');
        //         arr[i] = mask;
        //     }
        //     List<Boolean> ans = new ArrayList<>();
        //     for (int i = 0; i < m; i++)
        //         if (queries[i][0] == queries[i][1])
        //             ans.add(true);
        //         else ans.add(Integer.bitCount(arr[queries[i][1]] & arr[queries[i][0]]) <= queries[i][2]+1); // bug:  & arr[queries[i][0]]
        //     return ans;
        // }

        // public int movesToChessboard(int[][] bd) { // bd: board
        //     int n = bd.length, maskRow = 0, maskCol;
        //     Set<Integer> s = new HashSet<>();
        //     Set<Integer> t = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         maskRow = 0;
        //         maskCol = 0;
        //         for (int j = 0; j < n; j++)  {
        //             maskRow |= (1 << bd[i][j]);
        //             maskCol |= (1 << bd[j][i]);
        //         }
        //         s.add(maskRow);
        //         t.add(maskCol);
        //     }
        //     if (s.size() > 2 || t.size() > 2) return -1;
        //     // 接下来怎么搜呢？
        //     return Integer.MAX_VALUE;
        // }


        // private boolean helper(int [] arr, int i, int xor) { // xor: the current leftover array xor result
        //     // 这里的思路还是不太清楚
        // }
        // // Boolean [] dp;
        // int n;
        // public boolean xorGame(int[] arr) {
        //     n = arr.length, v = 0;
        //     dp = new Boolean [n];
        //     int [] xor = new int [n];
        //     for (int i = 0; i < n; i++) 
        //         xor[i] = (v ^ arr[i]);
        //     return helper(arr, 0, xor[n-1]); // i: turn
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


        // public int minFlips(int a, int b, int c) {
        //     int res = 0;
        //     for (int i = 0; i < 31; i++) {
        //         if (((c >> i) & 1) == 1) {
        //             if (((a >> i) & 1) == 1) {
        //         } else {
        //         }
        //     }
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


        private String dfs(int n) {
            if (n == 1) return "0";
            if (n <= 3) return "01";
            if (dp[n] != null) return dp[n];
            String pre = dfs(n-1);
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < pre.length(); i++) {
                if (pre.charAt(i) == '0') {
                    s.append('0');
                    s.append('1');
                } else {
                    s.append('1');
                    s.append('0');
                }
            }
            return dp[n] = s.toString();
        }
        String [] dp;
        public int kthGrammar(int n, int k) {
            dp = new String [n+1];
            String tmp = dfs(n);
            if (k <= tmp.length()) return tmp.charAt(k-1)-'0';
            else return 1 - (tmp.charAt(k - tmp.length()-1)-'0');
        }
   }

    public static void main(String[] args) {
        Solution s = new Solution();

        int res = s.kthGrammar(3, 1);
        System.out.println("res: " + res);
    }
}