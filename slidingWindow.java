// import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class slidingWindow {
    public static class Solution {

        // public int numOfSubarrays(int[] arr, int k, int threshold) {
        //     int n = arr.length;
        //     int [] pre = new int [n];
        //     pre[0] = arr[0];
        //     int res = 0;
        //     for (int i = 1; i < n; i++) 
        //         pre[i] = pre[i-1] + arr[i];
        //     for (int i = 0; i+k <= n; i++) { // j = i+k-1]
        //         if (pre[i+k-1] < k * threshold) continue;
        //         if (pre[i+k-1]-(i == 0 ? 0 : pre[i-1]) >= threshold*k) ++res;
        //     } 
        //     return res;
        // } 


        // // https://blog.csdn.net/Yaokai_AssultMaster/article/details/79599809
        // public class MaxSeg {
        //     List<Integer> tree = new ArrayList<>();
        //     int n;
        //     public MaxSeg (int [] arr) {
        //         n = arr.length;
        //         tree = new ArrayList<>(2*n);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(0);
        //         for (int i = 0; i < n; i++) 
        //             tree.add(arr[i]); // same effect as below
        //         for (int i = n-1; i >= 0; i--) // i >= 0
        //             tree.set(i, Math.max(tree.get(2*i), tree.get(2*i+1)));
        //     }
        //     public void update(int idx, int v) {
        //         idx += n;
        //         tree.set(idx, v);
        //         while (idx > 1) {
        //             idx /= 2;
        //             tree.set(idx, Math.max(tree.get(2*idx), tree.get(2*idx+1)));
        //         }
        //     }
        //     public int getMax(int l, int r) {
        //         l += n;
        //         r += n;
        //         int max = Integer.MIN_VALUE;
        //         while (l < r) {
        //             if ((l & 1) == 1) {
        //                 max = Math.max(max, tree.get(l));
        //                 l++;
        //             }
        //             if ((r & 1) == 1) {
        //                 r--;            // order matters !!!
        //                 max = Math.max(max, tree.get(r));
        //             }
        //             l >>= 1;
        //             r >>= 1;
        //         }
        //         return max;
        //     }
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length;
        //     MaxSeg mat = new MaxSeg(arr);
        //     if (n == k) return new int [] {mat.getMax(0, n)};
        //     int [] res = new int [n-k+1];
        //     for (int i = 0; i+k <= n; i++) 
        //         res[i] = mat.getMax(i, i+k);
        //     return res;
        // }
        // public int[] maxSlidingWindow(int[] arr, int k) {
        //     int n = arr.length, startWindowIdx = 0;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 维持一个递减队列
        //     int [] ans = new int [n - k + 1];
        //     for (int i = 0; i < n; i++) {
        //         startWindowIdx = i-k+1;
        //         while (!q.isEmpty() && i - q.peekFirst() >= k) q.pollFirst();     // 左出q：maintain k size window, 去头：去掉k windows之外的元素
        //         while (!q.isEmpty() && arr[q.peekLast()] <= arr[i]) q.pollLast(); // 右出q：去掉递减队列尾部所有不大于当前值的元素，就留一个最大值也行
        //         q.offerLast(i);  // 进q：进后此时q.size() == k 
        //         if (startWindowIdx >= 0)
        //             ans[startWindowIdx] = arr[q.peekFirst()]; // 使用递减队列左端最大值
        //     }
        //     return ans;
        // }

        
        // public int shortestSubarray(int[] nums, int k) { 
        //     int n = nums.length;
        //     int [] sum = new int[n+1];  
        //     for (int i = 1; i <= n; i++)  
        //         sum[i] = nums[i-1] + sum[i-1];
        //     int res = n + 1;
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // decreasing sum [] deque
        //     for (int i = 0; i <= n; i++) {
        //         while (!q.isEmpty() && sum[i] - sum[q.peekFirst()] >= k)  // 左出：
        //             res = Math.min(res, i - q.pollFirst()); // 取值了      // 取解
        //         while (!q.isEmpty() && sum[q.peekLast()] >= sum[i])       // 右出
        //             q.pollLast();  
        //         q.offerLast(i);                                           // 当前元素进队列
        //     }
        //     return res <= n ? res : -1;
        // }


        // public int minKBitFlips(int [] arr, int k) {
        //     int n = arr.length;
        //     int cnt = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == 0) {
        //             if (i + k <= n) {
        //                 ++cnt;
        //                 for (int j = i; j < i+k; j++) 
        //                     arr[j] = 1 - arr[j];
        //             } else return -1;
        //         }
        //     }
        //     return cnt;
        // }


        // public int subarraysWithKDistinct(int[] arr, int k) {
        //     int n = arr.length;
        //     Map<Integer, Integer> m = new HashMap<>();
        //     for (int i = 0; i < k; i++) 
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1); // 1st window
        //     int cnt = m.size() == k ? 1 : 0;
        //     for (int i = k; i < n; i++) {
        //         m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //     }
        // }


        // public int subarraysWithKDistinct(int [] arr, int k) {
        //     Map<Integer, Integer> m = new HashMap<>();
        //     ArrayDeque<Integer> q = new ArrayDeque<>();
        //     int res = 0, idx = 0;
        //     for (int i = 0; i < arr.length; i++) {
        //         System.out.println("\ni: " + i);
        //         while (!q.isEmpty() && m.keySet().size() == k && !m.containsKey(arr[i])) {
        //             idx = q.pollFirst();
        //             m.put(arr[idx], m.get(arr[idx])-1);
        //             if (m.get(arr[idx]) == 0) m.remove(arr[idx]);
        //             if (m.keySet().size() == k) ++res;
        //         }
        //         if (q.size() > 0 && arr[i] == arr[q.peekFirst()] && m.keySet().size() == k) ++res;
        //         q.offerLast(i);
        //         System.out.println("q.size(): " + q.size());
        //       m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        //       if (m.keySet().size() == k) ++res;
        //       // System.out.println("m.size(): " + m.size());
        //       // for (Map.Entry<Integer, Integer> entry : m.entrySet()) 
        //       //     System.out.print(entry.getKey() + ", " + entry.getValue() + "\n");
        //       // System.out.println("res: " + res);
        //     }
        //     return res;
        // }


        // public int longestSubarray(int[] arr, int limit) { // 单调递增队列，左小右大，右进左出 
        //     int n = arr.length, maxV = 0;
        //     ArrayDeque<Integer> minq = new ArrayDeque<>(); // 单调递增队列
        //     ArrayDeque<Integer> maxq = new ArrayDeque<>(); // 单调递减队列
        //     for (int i = 0; i < n; i++) {
        //         while (!minq.isEmpty() && arr[i] - arr[q.peekFirst()] > limit) 
        //             q.pollFirst(); 
        //         while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]) // 出尾：虽然arr[i]可能比队尾元素小，但当前元素构成的子数组长度最优
        //             q.pollLast();
        //         minq.offerLast(i);   
        //         maxq.offerLast(i);   
        //         max = Math.max(max, Math.max(maxq.peekLast() - minq.peekFirst(), minq.peekLast()-maxq.peekFirst()) + 1);
        //     }
        //     return max;
        // }


        // public int numberOfSubstrings(String s) { // 这个，不知道自己错哪里了
        //     int n = s.length(), j = 0;
        //     int [][] idx = new int [n][3]; // a b c
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(idx[i], -1);
        //     char cur = ' ';
        //     int mask = 0;
        //     int res = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
        //             idx[i][s.charAt(i)-'a'] = i;
        //             for ( j = 0; j < 3; j++) 
        //                 if (j != s.charAt(i)-'a') idx[i][j] = idx[i-1][j];
        //             continue;
        //         }
        //         cur = s.charAt(i);
        //         mask |= (1 << cur-'a');
        //         idx[i][cur-'a'] = i;
        //         j = i + 1;
        //         while (j < n && mask != 7) {
        //             if (s.charAt(j) != cur) {
        //                 idx[i][s.charAt(j)-'a'] = j;
        //                 mask |= (1 << s.charAt(j)-'a');
        //             }
        //             ++j;
        //         }
        //         mask = 0;
        //     }
        //    for (int i = 0; i < n; i++) {
        //         for ( j = 0; j < 3; j++) 
        //             if (idx[i][j] == -1) break;
        //         if (j < 3) continue;
        //         res += n-Math.max(idx[i][0], Math.max(idx[i][1], idx[i][2])); // 可以在前面一个循环里执行
        //     }
        //     return res;
        // }
        public int numberOfSubstrings(String t) {
            int n = t.length(), left = 0, right = 0, res = 0;
            int [] cnt = new int [3];
            char [] s = t.toCharArray();
            while (left < n && right < n) {
                cnt[s[right]-'a']++;
                while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                    res += n - right;
                    cnt[s[left++]-'a']--;
                }
                right++;
            }
            return res;
        }

        public int numberOfSubarrays(int[] arr, int k) {
            int n = arr.length;
            int cnt = 0, res = 0, left = 0, right = 0;
            while (left < n && right < n) {
                if (arr[right] % 2 == 1) ++cnt;
                if (cnt > k) {
                    while (cnt > k) {
                        if (arr[left] % 2 == 1) --cnt;
                        ++left;
                    }
                }
                if (cnt == k) {
                    System.out.println("\nleft: " + left);
                    System.out.println("right: " + right);
                    ++res;   
                }
                right++;
            }
            return res;
        }
    }
        
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {1,1,2,1,1};
        int []  a = new int []  {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};

        int r2 = s.numberOfSubarrays(a, 2);
        System.out.println("r2: " + r2);
    }
}