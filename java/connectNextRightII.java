import com.TreeLinkNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class connectNextRightII {
    public static class Solution {

        // try most basic queue first
        public class Oj {
            TreeLinkNode tln;
            int i;
            public Oj(TreeLinkNode tmp, int x) {            
                tln = tmp;
                i = x;
            }
        }
        // need a tricky constant space one
        public void connect0(TreeLinkNode root) {
            if (root == null || (root.left == null && root.right == null)) return;
            Queue<Oj> q = new LinkedList<Oj>();
            Oj tmp;
            TreeLinkNode curr = null;
            int cnt = 1, old = cnt;
            q.add(new Oj(root, 1));
            while (!q.isEmpty()) {
                tmp = q.poll();
                curr = tmp.tln;
                cnt = tmp.i;
                if (!q.isEmpty() && q.peek().i == cnt){
                    curr.next = q.peek().tln;
                }
                if (curr.left != null)
                    q.add(new Oj(curr.left, cnt + 1));
                if (curr.right != null)
                    q.add(new Oj(curr.right, cnt + 1));
            }
            return;
        }

        public void connect(TreeLinkNode root) {
            if (root == null) return;
            TreeLinkNode curr = root.next;
            while (curr != null) {
                if (curr.left != null) {
                    curr = curr.left;
                    break;
                }
                if (curr.right != null) {
                    curr = curr.right;
                    break;
                }
                curr = curr.next;
            }
            if (root.right != null)
                root.right.next = curr;

            if (root.left != null) 
                root.left.next = root.right == null ? curr : root.right;

            if (root.right != null) connect(root.right);                
            if (root.left != null) connect(root.left);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        TreeLinkNode root = new TreeLinkNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        System.out.println("GotHere");

        result.connect(root);
        System.out.println("GotHere");

        root.levelPrintTree(root);
    }
}

/*
  Time Limit ExceededMore Details 

Last executed input:
Time Limit ExceededMore Details 
Last executed input:	{1,2,3}

// why the machine can always generate codes like this ? ...
  Last executed input:	
  
Input:	{0,2,4,1,#,3,-1,5,1,#,6,#,8}
Output:	{0,#,2,4,#,1,3,-1,#,5,#}
Expected:	{0,#,2,4,#,1,3,-1,#,5,1,6,8,#}
 */
