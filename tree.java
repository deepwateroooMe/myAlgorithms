import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class tree {
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


        // public int longestSubarray(int[] arr, int limit) { // 单调递增队列，左小右大，右进左出 
        //     int n = arr.length, max = 0;
        //     ArrayDeque<Integer> minq = new ArrayDeque<>(), maxq = new ArrayDeque<>(); 
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


        // private int dfs(TreeNode r) { // 统计把自身，左右子树都平衡，需要移动的coins个数
        //     if (r == null) return 0;
        //     int left = dfs(r.left);      // 左、右子树缺多少
        //     int right = dfs(r.right);
        //     res += Math.abs(left) + Math.abs(right); // 左，右子树和自身都平衡需要的移动数
        //     return left + right + r.val-1;
        // }
        // int res;
        // public int distributeCoins(TreeNode root) {
        //     res = 0;
        //     return res;
        // }
        // 前面的代码使用了全部变量， 当然一般我们递归最好是可以不用全局变量， 所以， 把dfs的返回值修改成一个数组，把返回的值和整体的步数保存起来，就可以避免全部变量了
        // public int[] dfs(TreeNode node) {
        //     if (null == node) 
        //         return new int[]{0,0};
        //     int[] left = dfs(node.left);
        //     int[] right = dfs(node.right);
        //     int v = left[0] + right[0] + node.val;
        //     return new int[]{v-1, left[1] + right[1] + Math.abs(left[0]) + Math.abs(right[0])};
        // }        
        // public int distributeCoins(TreeNode root) {
        //     return dfs(root)[1];
        // }


        // public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        //     int m = n-1, range = 1 << (n-1);
        //     int [] ans = new int [n-1];
        //     for (int i = 1; i < range; i++) {
        //         // build tree based on each i mask
        //         // validate if the tree is valid
        //         // if it is, count it towards the Integer.bitCount(i) answer
        //     }
        // }


        // private int topDownTraverse(TreeNode r) { 
        //     if (r == null) return 0;
        //     int left = topDownTraverse(r.left);
        //     int right = topDownTraverse(r.right);
        //     if (r.left == null || r.left.val != r.val) left = 0;
        //     if (r.right == null || r.right.val != r.val) right = 0;
        //     max = Math.max(max, left + right);
        //     return Math.max(left, right) + 1;
        // }
        // int max = 0;
        // public int longestUnivaluePath(TreeNode root) {
        //     if (root == null) return 0;
        //     topDownTraverse(root);
        //     return max;
        // }

        // private void preOrder(TreeNode r, int [] arr, int i, int j) {
        //     if (r == null || (res.size() > 0 && res.get(0) == -1)) return;
        //     if (r.val != arr[i]) {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        //     if (i == j && r.left == null && r.right == null
        //         || j == i+1 && (r.left == null || r.right == null)) return;
        //     else if (i == j || i+1 == j) {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        //     if (r.left != null && r.left.val == arr[i+1]) {
        //         if (r.right == null) preOrder(r.left, arr, i+1, j);
        //         else {
        //             int k = i;
        //             for ( k = i; k <= j; k++) 
        //                 if (arr[k] == r.right.val) break;
        //             preOrder(r.left, arr, i+1, k-1);
        //             preOrder(r.right, arr, k, j);
        //         }
        //     } else if (r.right != null && arr[i+1] == r.right.val) { 
        //         if (r.left == null) preOrder(r.right, arr, i+1, j);
        //         else {
        //             res.add(r.val);  // flip here
        //             int k = i;
        //             for ( k = i; k <= j; k++) 
        //                 if (arr[k] == r.left.val) break;
        //             preOrder(r.right, arr, i+1, k-1);
        //             preOrder(r.left, arr, k, j);
        //         }
        //     } else {
        //         res.clear();
        //         res.add(-1);
        //         return;
        //     }
        // }
        // List<Integer> res = new ArrayList<>();
        // public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //     preOrder(root, voyage, 0, voyage.length-1);
        //     return res;
        // }


        
    }
        
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {1, 2, -1, 3};
        // int [] b = new int [] {1, 3, 2};

        int []  a = new int []  {7, 1, 5, -1, -1, 3, 2, -1, -1, 6, 4, -1, -1, -1, -1};
        int []  b = new int []  {7, 5, 2, 4, 3, 6, 1};
        
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        List<Integer> r2 = s.flipMatchVoyage(root, b);
        System.out.println("r2.size(): " + r2.size());
        for (int z = 0; z < r2.size(); ++z) 
            System.out.print(r2.get(z) + ", ");
        System.out.print("\n");
        
    }
}