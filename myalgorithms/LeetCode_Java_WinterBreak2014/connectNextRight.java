import com.TreeLinkNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class connectNextRight {
    public static class Solution {
        public void connect(TreeLinkNode root, TreeLinkNode sibling) {
            if (root == null) return;
            else root.next = sibling;
            connect(root.left, root.right);
            if (sibling != null)
                connect(root.right, sibling.left);
            else
                connect(root.right, null);
        }

        public void connect(TreeLinkNode root) {
            connect(root, null);
        }
        
        public void connect2(TreeLinkNode root) {
            while (root != null) {
                TreeLinkNode next = null;
                TreeLinkNode prev = null;
                for (; root != null;
                     root = root.next) {
                    if (next == null) 
                        next = root.left != null ? root.left : root.right;
                    if (root.left != null) {
                        if (prev != null)
                            prev.next = root.left;
                        prev = root.left;
                    }
                    if (root.right != null) {
                        if (prev != null)
                            prev.next = root.right;
                        prev = root.right;
                    }
                }
                root = next;
            }
        }

        public void connect1(TreeLinkNode root) {
            if (root == null) return;
            TreeLinkNode dummy = new TreeLinkNode(-1);
            for (TreeLinkNode curr = root, prev = dummy;
                 curr != null;
                 curr = curr.next) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
            }
            connect(dummy.next);
        }
        
        public void connect0(TreeLinkNode root) {
            if (root == null) return;
            TreeLinkNode dummy = new TreeLinkNode(-1);
            

            TreeLinkNode left = null;
            TreeLinkNode right = null;
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
                left = root.left;
                right = root.right;
                while (left.right != null) {
                    left.right.next = right.left;
                    left = left.right;
                    right = right.left;
                }
                connect(root.left);
                connect(root.right);
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        TreeLinkNode root = new TreeLinkNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        result.connect(root);
        root.levelPrintTree(root);
    }
}
/*
  Input:	{-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13}
  Output:	{-1,#,0,1,#,2,3,4,5,#,6,7,8,9,#}
  Expected:	{-1,#,0,1,#,2,3,4,5,#,6,7,8,9,10,11,12,13,#}
*/
