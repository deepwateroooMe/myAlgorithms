import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class mergeTrees {
    public static class Solution {

        public void mergeTreesRecursive(TreeNode r1, TreeNode r2) {
            if (r2.left == null && r1.left != null) {
                r2.left = r1.left;
            } else if (r1.left != null && r2.left != null) {
                mergeTreesRecursive(r1.left, r2.left);
            }
            
            r2.val += r1.val;
            
            if (r2.right == null && r1.right != null) {
                r2.right = r1.right;
            } else if (r1.right != null && r2.right != null) {
                mergeTreesRecursive(r1.right, r2.right);
            }
        }
        
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) return root2;
            else if (root2 == null) return root1;
            mergeTreesRecursive(root1, root2);
            return root2;
        }

        // private TreeNode head, prev, tail;
        // private boolean fromR, fromL;
        // private void increasingBSTRecursive(TreeNode r) {
        //     fromR = false;
        //     fromL = false;
        //     // System.out.println("r.val: " + r.val);
        //     // System.out.println("(r != tail): " + (r != tail));
        //     if (r.left == null && r.right == null && r != tail) { // leaf
        //         if (tail != null)
        //         // System.out.println("tail.val: " + tail.val);
        //         // System.out.println("prev.val: " + prev.val);
        //         // System.out.println("r.val: " + r.val);
                
        //         if (r != prev.right) {
        //             r.right = prev;
        //             prev.left = null;
        //             if (head == null) head = r;
                    
        //             if (tail == null) tail = r.right;
        //             else {
        //                 tail.right = r;
        //                 tail = r;
        //             }
        //             fromL = true;
        //         }
        //         // System.out.println("head.val: " + head.val);
        //         return;
        //     }
            
        //     if (r.left != null) {
        //         prev = r;
        //         increasingBSTRecursive(r.left);
        //     }

        //     // System.out.println("\n Middle node: ");
        //     // System.out.println("prev.val: " + prev.val);
        //     // System.out.println("r.val M: " + r.val);
        //     // System.out.println("fromR: " + fromR);

        //     if (fromR) {
        //         prev.right = r;
        //         r.left = null;
        //         prev = r;
        //         tail = r;
        //         fromR = false;
        //     } else if (fromL && r != tail) {
        //         prev.right = r;
        //         r.left = null;
        //         prev = r;
        //         tail = r;
        //         fromL = false;
        //     }
        //     else if (r.left == null){  // left == null
        //         prev = r;
        //     }
        //     tail = r;
            
        //     // System.out.println("(r.right != null): " + (r.right != null));
        //     if (r.right != null) {
        //         // System.out.println("r.val R: " + r.val);
        //         r = r.right;
        //         tail = r;
        //         increasingBSTRecursive(r);
        //     }
        // }

        private Stack<Integer> s;
        private TreeNode tmp;
        private void postOrderTraversalTreeRecursive(TreeNode t) {
            if (t == null) return;
            // if (t.left == null && t.right == null) {
            //     s.push(t.val);
            //     return;
            // } // 这些是不干净的coding
            if (t.right != null) {
                postOrderTraversalTreeRecursive(t.right);
            }
            s.push(t.val);
            if (t.left != null) {
                postOrderTraversalTreeRecursive(t.left);
            }
        }

        private ArrayList<TreeNode> l ;
        private void inOrderTraversalTree(TreeNode r) {
            if (r == null) return;
            if (r.left != null) {
                inOrderTraversalTree(r.left);
            }
            l.add(r);
            if (r.right != null) {
                inOrderTraversalTree(r.right);
            }
        }
         
        public TreeNode increasingBST(TreeNode root) {
            if (root.left == null && root.right == null) return root;
            l = new ArrayList<TreeNode>();
            inOrderTraversalTree(root);
            TreeNode head = l.get(0);
            TreeNode tmp = head;
            for (int i = 0; i < l.size() - 1; i++) {
                l.get(i).right = l.get(i + 1);
                l.get(i).left = null;
            }
            l.get(l.size()-1).right = null;
            l.get(l.size()-1).left = null;
            
            return l.get(0);

            // s = new Stack<Integer>();
            // postOrderTraversalTreeRecursive(root);
            // TreeNode head = new TreeNode(s.pop());
            // tmp = head;
            // while (!s.isEmpty()) {
            //     tmp.right = new TreeNode(s.pop());
            //     tmp = tmp.right;
            // }
            // return head;
        }

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> l = new ArrayList<Integer>();
            if (root == null) return l;
            int cnt = 0;
            l.add(root.val);
            int counter = 0;
            int tmp;
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            TreeNode tmpNode;
            if (root.right != null) {
                q.add(root.right);
                ++cnt;
            }
            if (root.left != null) {
                q.add(root.left);
                ++cnt;
            }
            while (!q.isEmpty()) {
                tmp = cnt;
                cnt = 0;
                counter = 0;
                while (counter < tmp) {
                    tmpNode = q.remove();
                    if (counter == 0) {
                        l.add(tmpNode.val);
                    }
                    ++counter;
                    if (tmpNode.right != null) {
                        q.add(tmpNode.right);
                        ++cnt;
                    }
                    if (tmpNode.left != null) {
                        q.add(tmpNode.left);
                        ++cnt;
                    }
                }
            }
            return l;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {5,3,6,2,4,-1,8,1,-1,-1,-1,7,9}; //
        // int [] a = new int [] {2, 1, 3};

        int [] a = new int [] {1, 2, 3,5, 6};
        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        List<Integer> res = s.rightSideView(root);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
        
        
        // int [] a = new int [] {1,3,2,5};
        // TreeNode root = new TreeNode(a[0]);
        // root.buildTree(root, a);
        // root.levelPrintTree(root);
        // int [] b = new int [] {2,1,3,-1,4,-1,7};
        // TreeNode rootB = new TreeNode(b[0]);
        // rootB.buildTree(rootB, b);
        // rootB.levelPrintTree(rootB);
        // TreeNode res = s.mergeTrees(root, rootB);
        // res.levelPrintTree(res);
    }
}