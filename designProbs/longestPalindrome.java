import com.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class longestPalindrome {
    public static class Solution {

        // private int expandAroundCenter(String s, int left, int right) {
        //     int L = left, R = right;
        //     while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        //         L--;
        //         R++;
        //     }
        //     return R - L - 1;
        // }
        // public String longestPalindrome(String s) {
        //     int bgn = 0, end = 0;
        //     for (int i = 0; i < s.length(); i++) {
        //         int len1 = expandAroundCenter(s, i, i);
        //         int len2 = expandAroundCenter(s, i, i + 1);
        //         int len = Math.max(len1, len2);
        //         if (len > end - bgn) {
        //             bgn = i - (len - 1) / 2;
        //             end = i + len / 2;
        //         }
        //     }
        //     return s.substring(bgn, end + 1);
        // }

        // public void levelPrintTree(TreeNode root) {
        //     TreeNode tmp = root;
        //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //     queue.add(tmp);
        //     System.out.println("\nTREE Level order traversal: \n");
        //     System.out.print("      " + tmp.val + " -> root\n");
        //     System.out.print("    ");
        //     TreeNode curr;
        //     int levelCnt = 1;
        //     int recnt = 0, tmpcnt = 0;
        //     while (!queue.isEmpty()) {
        //         // System.out.print("    ");
        //         while (recnt < levelCnt) {
        //             curr = queue.poll();
        //             ++recnt;
        //             // if (curr.val != -1 && tmpcnt > 1 && recnt < levelCnt)
        //             //     System.out.print(curr.val + ", ");
        //             // else
        //             // System.out.print("#, ");
        //             if (curr.left != null) {
        //                 queue.add(curr.left);
        //                 System.out.print(curr.left.val + ", ");
        //                 ++tmpcnt;
        //             } else
        //             System.out.print("#.");
        //             if (curr.right != null) {
        //                 queue.add(curr.right);
        //                 System.out.print(curr.right.val + ", ");
        //                 ++tmpcnt;
        //             } else
        //             System.out.print("#| ");
        //         }
        //         System.out.print(" -> \n");
        //         levelCnt = tmpcnt;
        //         tmpcnt = 0;
        //         recnt = 0;
        //     }
        //     System.out.println("");
        // }

        // private boolean isUniform(int [][] arr, int i, int j, int n) {
        //     int val = arr[i][j];
        //     boolean isUniform = true;
        //     for (int x = i; x < i+n; x++) {
        //         for (int y = j; y < j+n; y++) {
        //             if (arr[x][y] != val) {
        //                 isUniform = false;
        //                 return false;
        //             }
        //         }
        //     }
        //     return true;
        // }
        // public Node constructRecursive(int[][] arr, int i, int j, int n) {
        //     if (n == 1) return new Node(arr[i][j] == 0 ? false : true, true);
        //     if (n == 2) {
        //         if (isUniform(arr, i, j, 2)) {
        //             Node root = new Node(arr[i][j] == 0 ? false : true, true);
        //             return root;
        //         }
        //         Node root = new Node(true, false);
        //         root.topLeft = new Node(arr[i][j] == 0 ? false : true, true);
        //         root.topRight = new Node(arr[i][j+1] == 0 ? false : true, true);
        //         root.bottomLeft = new Node(arr[i+1][j] == 0 ? false : true, true);
        //         root.bottomRight = new Node(arr[i+1][j+1] == 0 ? false : true, true);
        //         return root;
        //     }
        //     if (isUniform(arr, i, j, n)) {
        //         Node root = new Node(arr[i][j] == 0 ? false : true, true);
        //         return root;
        //     }
        //     Node root = new Node(true, false);
        //     root.topLeft = constructRecursive(arr, i, j, n/2);
        //     root.topRight = constructRecursive(arr, i, j + n/2, n/2);
        //     root.bottomLeft = constructRecursive(arr, i+n/2, j, n/2);
        //     root.bottomRight = constructRecursive(arr, i+n/2, j+n/2, n/2);
        //     return root;
        // }
        // public Node construct(int[][] grid) {
        //     return constructRecursive(grid, 0, 0, grid.length);
        // }

        public Node intersect(Node quadTree1, Node quadTree2) {
            if (quadTree1.isLeaf && quadTree2.isLeaf) return quadTree1.val == true ? quadTree1 : quadTree2;
            
            if (quadTree1.isLeaf && quadTree1.val == true) return quadTree1;
            else if (quadTree2.isLeaf && quadTree2.val == true) return quadTree2;
            
            if (quadTree1.isLeaf && quadTree1.val == false) return quadTree2;
            else if (quadTree2.isLeaf && quadTree2.val == false) return quadTree1;

            Node root = new Node((quadTree1.val || quadTree2.val), false);
            root.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            root.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            root.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            root.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if (root.topLeft.isLeaf && root.topRight.isLeaf
                && root.bottomLeft.isLeaf && root.bottomRight.isLeaf
                && ((root.topLeft.val && root.topRight.val
                     && root.bottomLeft.val && root.bottomRight.val)
                    ||  (!root.topLeft.val && !root.topRight.val
                         && !root.bottomLeft.val && !root.bottomRight.val))) {
                    root.isLeaf = true;
                    root.val = root.topLeft.val;
                    root.topLeft = null;
                    root.topRight = null;
                    root.bottomLeft = null;
                    root.bottomRight = null;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{0,1},{1,1},{1,1},{1,0},{1,0}}; 
        // int [][] b = new int [][] {{0,1},{1,1},{0,1},{1,1},{1,0},-1,-1,-1,-1,{1,0},{1,0},{1,1},{1,1}}; 

        System.out.println("");
        System.out.println("a.length: " + a.length);
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + ", ");
            }
            System.out.print("\n");
        }
        System.out.println("");

        Node res = s.construct(a);
        if (res != null)
        res.levelPrintTree(res); 
    }
}