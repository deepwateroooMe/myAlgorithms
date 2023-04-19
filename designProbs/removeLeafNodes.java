import com.TreeNode;
import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class removeLeafNodes {
    public static class Solution {


        // public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //     if (root1 == null && root2 == null) return true;
        //     if (root1 == null || root2 == null) return false;
        //     if (root1 != null && root2 != null && root1.val != root2.val) return false;
        //     return ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
        //             || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));
        // }

        // //  这个没有调，今天可以把它弄好一下
        // private int maxDepth;
        // private void maxDepthRecursive(Node r, int val) {
        //     if (r == null) return;
        //     if (r.children == null)  {
        //         ++val;
        //         if (val > maxDepth) {
        //             maxDepth = val;
        //         }
        //         return;
        //     }
        //     if (r.children != null) {
        //         val += 1;
        //         for (int i = 0; i < children.size(); i++) {
        //             maxDepthRecursive(r.children.get(i), val);
        //         }
        //     }
        // }
        // public int maxDepth(Node root) {
        //     maxDepth = 0;
        //     if (root == null) return 0;
        //     maxDepthRecursive(root, 1);
        //     // System.out.println("maxDepth: " + maxDepth);
        //     return maxDepth;
        // }

        // private TreeNode tmp;
        // public void invertTreeRecursive(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left == null || r.right == null) {
        //         tmp = r.left;
        //         r.left = r.right;
        //         r.right = tmp;
        //         if (r.left != null) invertTreeRecursive(r.left);
        //         if (r.right != null) invertTreeRecursive(r.right);
        //         return;
        //     }
        //     tmp = r.left;
        //     r.left = r.right;
        //     r.right = tmp;
        //     invertTreeRecursive(r.left);
        //     invertTreeRecursive(r.right);
        // }
        // public TreeNode invertTree(TreeNode root) {
        //     if (root == null) return root;
        //     invertTreeRecursive(root);
        //     return root;
        // }

        // List<String> l;
        // public void binaryTreePathsRecursive(TreeNode r, StringBuilder s) {
        //     if (r == null) return;
        //     if (s.length() == 0) s.append(r.val);
        //     else {
        //         s.append("->");
        //         s.append(r.val);
        //     }
        //     if (r.left == null && r.right == null) {
        //         l.add(s.toString());
        //         return;
        //     }
        //     if (r.left != null) binaryTreePathsRecursive(r.left, new StringBuilder(s));
        //     if (r.right!= null) binaryTreePathsRecursive(r.right, new StringBuilder(s));
        // }
        // public List<String> binaryTreePaths(TreeNode root) {
        //     l = new ArrayList<String>();
        //     StringBuilder s = new StringBuilder();
        //     if (root.left == null && root.right == null) {
        //         s.append(root.val);
        //         l.add(s.toString());
        //         return l;
        //     }
        //     binaryTreePathsRecursive(root, s);
        //     return l;
        // }

        // private StringBuilder s;
        // public void tree2strRecursive(TreeNode r) {
        //     if (r == null) return;
        //     if (s == null) s = new StringBuilder();
        //     s.append(r.val);
        //     if (r.left != null) {
        //         s.append('(');
        //         tree2strRecursive(r.left);
        //         s.append(')');
        //     }
        //     if (r.right != null) {
        //         if (r.left == null) s.append("()");
        //         s.append('(');
        //         tree2strRecursive(r.right);
        //         s.append(')');
        //     }
        // }
        // public String tree2str(TreeNode root) {
        //     tree2strRecursive(root);
        //     return s.toString();
        // }

        // private int res;
        // public void sumOfLeftLeavesRecursive(TreeNode r, boolean l) {
        //     if (r == null) return;
        //     if (r.left == null && r.right == null) {
        //         if (l) res += r.val;
        //         return;
        //     }
        //     if (r.left != null) sumOfLeftLeavesRecursive(r.left, true);
        //     if (r.right != null) sumOfLeftLeavesRecursive(r.right, false);
        // }
        // public int sumOfLeftLeaves(TreeNode root) {
        //     sumOfLeftLeavesRecursive(root, false);
        //     return res;
        // }

        // public TreeNode lowestCommonAncestorRecursive(TreeNode r, TreeNode p, TreeNode q) {
        //     if (p.val < r.val && q.val > r.val) return r;
        //     if (q.val == r.val || p.val == r.val) return r;
        //     if (q.val < r.val) return lowestCommonAncestorRecursive(r.left, p, q);
        //     if (p.val > r.val) return lowestCommonAncestorRecursive(r.right, p, q);
        //     return null;
        // }
        // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //     TreeNode tmp = (p.val < q.val) ? q : p;
        //     p = (p.val < q.val) ? p : q;
        //     q = tmp;
        //     return lowestCommonAncestorRecursive(root, p, q);
        // }

        // public boolean isCousinsRecursiveTwo(TreeNode p, TreeNode q, int x, int y, int d) {
        //     if (p == null || q == null) return false;
        //     if (p != null)
        //     if (q != null)
        //     if (d > 1 && p.val == x && q.val == y) return true;
        //     if ((p.left == null && p.right == null)
        //         || (q.left == null && q.right == null)) return false;
        //     if (p.left == null || p.right == null) {
        //         return (isCousinsRecursiveTwo((p.left == null) ? p.right : p.left, q.left, x, y, d + 1)
        //                 || isCousinsRecursiveTwo((p.left == null) ? p.right : p.left, q.right, x, y, d + 1));
        //     } else {
        //         return (isCousinsRecursiveTwo(p.left, q.left, x, y, d + 1)
        //                 || isCousinsRecursiveTwo(p.right, q.left, x, y, d + 1)
        //                 || isCousinsRecursiveTwo(p.left, q.right, x, y, d + 1)
        //                 || isCousinsRecursiveTwo(p.right, q.right, x, y, d + 1));
        //     }
        // }
        // public boolean isCousinsRecursive(TreeNode r, int x, int y, int d) {
        //     if (r == null) return false;
        //     if (r.val == x || r.val == y) return false;
        //     if (d < 2) {
        //         if ((r.left != null && (r.left.val == x || r.left.val == y))
        //             || (r.right != null && (r.right.val == x || r.right.val == y))) return false;
        //     }
        //     if (r.left == null || r.right == null) {
        //         if (r.left == null) {
        //             return isCousinsRecursive(r.right, x, y, 0);
        //         } else {
        //             return isCousinsRecursive(r.left, x, y, 0);  
        //         } 
        //     }

        //     if (d > 1) {
        //         if ((r.left.val == x && r.right.val == y)
        //             || (r.left.val == y && r.right.val == x)) return true;
        //         else if (r.left.val == x || r.left.val == y
        //                  || r.right.val == x || r.right.val == y) return false;
        //         else {
        //             return (isCousinsRecursiveTwo(r.left, r.right, x, y, 1)
        //                     || isCousinsRecursiveTwo(r.left, r.right, y, x, 1));
        //         }
        //     } else {
        //         return (isCousinsRecursive(r.left, x, y, 0)
        //                 || isCousinsRecursive(r.right, x, y, 0)
        //                 || isCousinsRecursiveTwo(r.left, r.right, x, y, 1)
        //                 || isCousinsRecursiveTwo(r.left, r.right, y, x, 1));
        //     }
        // }
        // public boolean isCousins(TreeNode root, int x, int y) {
        //     return isCousinsRecursive(root, x, y, 0);
        // }

        // private int res, val;
        // private void maxDepthRecursize(TreeNode r, int val) {
        //     if (r == null) return;
        //     if (r.left == null && r.right == null) {
        //         if (val > res) res = val;
        //         return;
        //     }
        //     if (r.left != null) {
        //         maxDepthRecursize(r.left, val + 1);
        //     }
        //     if (r.right != null) {
        //         maxDepthRecursize(r.right, val + 1);
        //     }
        // }
        // private int maxDiameter;
        // private void diameterOfBinaryTreeRecursive(TreeNode r) {
        //     if (r == null || (r.left == null && r.right == null)) return;
        //     if (r.right != null) diameterOfBinaryTreeRecursive(r.right);
        //     if (r.left != null) diameterOfBinaryTreeRecursive(r.left);
        //     res = 0;
        //     val = 0;
        //     if (r.left != null) {
        //         maxDepthRecursize(r.left, 1);
        //     }
        //     val = res;
        //     res = 0;
        //     if (r.right != null) {
        //         maxDepthRecursize(r.right, 1);
        //     }
        //     if (res + val > maxDiameter) maxDiameter = val + res;
        // }
        // public int diameterOfBinaryTree(TreeNode root) {
        //     if (root == null || (root.left == null && root.right == null)) return 0;
        //     maxDiameter = 0;
        //     diameterOfBinaryTreeRecursive(root);
        //     return maxDiameter;
        // }

        // public TreeNode bstFroPreorderRecursivem(int[] arr, int bgn, int end) {
        //     if (bgn > end) return null;
        //     if (bgn == end) return new TreeNode(arr[bgn]);
        //     TreeNode r = new TreeNode(arr[bgn]);
        //     int i = 0;
        //     for ( i = bgn + 1; i <= end; i++) {
        //         if (arr[i] > arr[bgn]) break;
        //     }
        //     if (i == bgn) {
        //         r.right = bstFroPreorderRecursivem(arr, bgn + 1, end);
        //     } else if (i == end) {
        //         r.left = bstFroPreorderRecursivem(arr, bgn + 1, i - 1);
        //         r.right = new TreeNode(arr[end]);
        //     } else if (i < end) {
        //         r.left = bstFroPreorderRecursivem(arr, bgn + 1, i - 1);
        //         r.right = bstFroPreorderRecursivem(arr, i, end);
        //     } else if (i > end) {
        //         r.left =  bstFroPreorderRecursivem(arr, bgn + 1, end);
        //     }
        //     return r;
        // }
        // public TreeNode bstFromPreorder(int[] preorder) {
        //     TreeNode r = bstFroPreorderRecursivem(preorder, 0, preorder.length - 1);
        //     return r;
        // }

        private void dfsTraverse(TreeNode r, int val) { // stack, recursion next time
            Stack<TreeNode> s = new Stack<TreeNode>();
            Stack<TreeNode> t = new Stack<TreeNode>();
            TreeNode p = r, q = null; // q for parent
            s.push(p);
            s.push(p);
            while (!s.isEmpty()) {
                p = s.pop();
                q = s.pop();
                System.out.println("p.val: " + p.val);
                System.out.println("q.val: " + q.val);
                
                if (p.left == null && p.right == null) {
                    System.out.println("p.val I :  " + p.val);
                    System.out.println("q.val I :  " + q.val);
                    System.out.println("val: " + val);
                    System.out.println("(p.val == val): " + (p.val == val));
                    
                    if (p.val == val) {
                        if (p == q.left) q.left = null;
                        else if (p == q.right) q.right = null;
                        
                        // if (q.val == val && q == tmp3) {
                        System.out.println("q.val == val && !t.isEmpty()): " + (q.val == val && !t.isEmpty()));
                        
                        if (q.val == val && !t.isEmpty()) {
                            System.out.println("t.size(): " + t.size());
                            TreeNode tmp2 = t.pop();
                            System.out.println("(q.val == val && q == tmp2 && !t.isEmpty()): " + (q.val == val && q == tmp2 && !t.isEmpty()));
                            
                            while (q.val == val && q == tmp2 && !t.isEmpty()) {
                                System.out.println("q.val: " + q.val);
                                System.out.println("t.size(): " + t.size());
                                TreeNode tmp = t.pop();
                                System.out.println("tmp.val: " + tmp.val);

                                System.out.println("(q == tmp.left): " + (q == tmp.left));
                                
                                if (q == tmp.left && tmp.right == null) tmp.left = null;
                                else if  (q == tmp.right && tmp.left == null) tmp.right = null;

                                System.out.println("\n");
                                System.out.println("tmp.val: " + tmp.val);
                                System.out.println("q.val: " + q.val);

                                tmp.levelPrintTree(tmp);
                                
                                
                                q = tmp;
                                System.out.println("(q.val == val): " + (q.val == val));
                                if (!t.isEmpty()) {
                                    tmp2 = t.pop();
                                }
                            }
                            if (!t.isEmpty() && q != tmp2) t.push(tmp2);
                        }
                    }
                }
                // }
                if (p.val == val && (p.left == null || p.right == null)) {
                    t.push(q);
                    t.push(p);
                    System.out.println("p.val B : " + p.val);
                    System.out.println("q.val B : " + q.val);
                    System.out.println("t.size(): " + t.size());
                    
                }
                if (p.left != null) {
                    s.push(p);
                    s.push(p.left);
                }
                if (p.right != null) {
                    s.push(p);
                    s.push(p.right);
                }
            }
            System.out.println("dfsTraverse");
            r.levelPrintTree(r);
        }

        // public void removeLeafNodesRecursive(TreeNode p, int target, TreeNode q) {
        //     if (p == null) return;
        //     if (p.left != null)  removeLeafNodesRecursive(p.left, target, p);
        //     if (p.right != null) removeLeafNodesRecursive(p.right, target, p);
        //     if (p.left == null && p.right == null && p.val == target) {
        //         if (q == null) {
        //             return;
        //         }
        //         if (p == q.left) q.left = null;
        //         if (p == q.right) q.right = null;
        //          return; 
        //     } else return;
        // }
        // public TreeNode removeLeafNodes(TreeNode root, int target) {
        //     TreeNode dummy = new TreeNode(0);
        //     dummy.left = root;
        //     removeLeafNodesRecursive(root, target, dummy);
        //     return dummy.left;
        // }

        // private int res;
        // public void goodNodesRecursive(TreeNode r, int val) {
        //     if (r.val >= val) {
        //         res += 1;
        //     }
        //     if (r.left != null) {
        //         goodNodesRecursive(r.left, r.val > val ? r.val : val);
        //     }
        //     if (r.right != null) {
        //         goodNodesRecursive(r.right, r.val > val ? r.val : val);
        //     }
        // }
        // public int goodNodes(TreeNode root) {
        //     res = 0;
        //     goodNodesRecursive(root, root.val);
        //     return res;
        // }

        // public void pruneTreeRecursive(TreeNode p, TreeNode q) {
        //     if (p.left != null) pruneTreeRecursive(p.left, p);
        //     if (p.right != null) pruneTreeRecursive(p.right, p);
        //     if (p.left == null && p.right == null && p.val == 0) {
        //         if (p == q.left) q.left = null;
        //         else if (p == q.right) q.right = null;
        //         return;
        //     }
        // }
        // public TreeNode pruneTree(TreeNode root) {
        //     TreeNode dummy = new TreeNode(-1);
        //     dummy.left = root;
        //     pruneTreeRecursive(dummy.left, dummy);
        //     return dummy.left;
        // }

        // private int min, max, maxDiff;
        // private void minMaxRecursive(TreeNode r) {
        //     if (r.left != null) minMaxRecursive(r.left);
        //     if (r.right != null) minMaxRecursive(r.right);
        //     if (r.val > max) max = r.val;
        //     if (r.val < min) min = r.val;
        // }
        // public void maxAncestorDiffRecursive(TreeNode r) {
        //     min = Integer.MAX_VALUE;
        //     max = 0;
        //     minMaxRecursive(r);
        //     if (r.left != null || r.right != null) {
        //         int tmp = Math.max(Math.abs(r.val - min), Math.abs(r.val - max));
        //         if (tmp > maxDiff) {
        //             maxDiff = tmp;
        //         }
        //     }
        //     max = 0;
        //     minMaxRecursive(r);
        //     if (r.left != null) maxAncestorDiffRecursive(r.left);
        //     max = 0;
        //     minMaxRecursive(r);
        //     if (r.right != null) maxAncestorDiffRecursive(r.right);
        // }
        // public int maxAncestorDiff(TreeNode root) {
        //     min = Integer.MAX_VALUE;
        //     max = 0;
        //     maxDiff = 0;
        //     maxAncestorDiffRecursive(root);
        //     return maxDiff;
        // }

        


        

        // public int maxLevelSum(TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     int res = 0;
        //     int maxSum = Integer.MIN_VALUE;
        //     int cnt = 0;
        //     Queue<TreeNode> q = new LinkedList<>();
        //     TreeNode p = root;
        //     q.add(p);
        //     ++cnt;
        //     int tmpcnt = 0;
        //     int levelCnt = cnt;
        //     int levelSum = 0;
        //     int level = 0;
        //     while (!q.isEmpty()) {
        //         cnt = 0;
        //         while (!q.isEmpty() && tmpcnt < levelCnt) {
        //             p = q.poll();
        //             ++tmpcnt;
        //             levelSum += p.val;
        //             if (p.left != null) {
        //                 q.add(p.left);
        //                 ++cnt;
        //             }
        //             if (p.right != null) {
        //                 q.add(p.right);  
        //                 ++cnt;
        //             } 
        //         }
        //         ++level;
        //         if (levelSum > maxSum) {
        //             maxSum = levelSum;
        //             res = level;
        //         }
        //         levelCnt = cnt;
        //         tmpcnt = 0;
        //         levelSum = 0;
        //     }
        //     return res;
        // }

        // private int maxDepth;
        // private TreeNode res;
        // private int deepNodeCnts;
        // private TreeNode rootG;
        // public void lcaDeepestLeavesRecursive(TreeNode r, int cnt, TreeNode p) {
        //       System.out.println("r.val: " + r.val);
            
        //     if (r.left != null) lcaDeepestLeavesRecursive(r.left, cnt + 1, r);
        //     if (r.right != null) lcaDeepestLeavesRecursive(r.right, cnt + 1, r);

        //       System.out.println("(r.left == null || r.right == null): " + (r.left == null || r.right == null));
        //       if (res != null)
        //       System.out.println("res.val: " + res.val);
        //       System.out.println("r.val M: " + r.val);
        //       System.out.println("(cnt == maxDepth): " + (cnt == maxDepth));
             
        //     if (r.left == null && r.right == null) {

        //           System.out.println("(cnt > maxDepth): " + (cnt > maxDepth));
        //         if (cnt > maxDepth) {
        //             maxDepth = cnt;
        //             deepNodeCnts = 1;
        //             res = r;
        //               System.out.println("maxDepth: " + maxDepth);
        //         } else if (cnt == maxDepth) {
        //             deepNodeCnts += 1;
        //             System.out.println("deepNodeCnts: " + deepNodeCnts);
        //             System.out.println("(deepNodeCnts == 2) AAAA: " + (deepNodeCnts == 2));
                    
        //             if (deepNodeCnts >= 2) {
        //                   System.out.println("((r == p.left && p.right != null) || (r == p.right && p.left != null)): " + ((r == p.left && p.right != null) || (r == p.right && p.left != null)));
        //                 TreeNode tmp = res;
        //                  System.out.println("res.val: " + res.val);
        //                 findGrandParent(rootG, p, tmp);
        //                  System.out.println("res.val: " + res.val);
        //                 return;
        //             }
        //         }
        //     } else if (r.left != null && r.right != null) {
        //           System.out.println("maxDepth: " + maxDepth);
        //           System.out.println("(cnt == maxDepth - 1 && deepNodeCnts == 2): " + (cnt == maxDepth - 1 && deepNodeCnts == 2));
        //         if (cnt == maxDepth - 1 && deepNodeCnts == 2) {
        //             res = r;
        //         }
        //     } else if (r.left == null || r.right == null) {
        //           System.out.println("deepNodeCnts: " + deepNodeCnts);
        //           if (res != null)
        //           System.out.println("res.val: " + res.val);
        //           System.out.println("(cnt == maxDepth -1 && deepNodeCnts > 1): " + (cnt == maxDepth -1 && deepNodeCnts > 1));

        //         if (cnt == maxDepth -1 && deepNodeCnts > 1) {
        //               System.out.println("p.val: " + p.val);
        //               System.out.println("(r == p.right): " + (r == p.right));
        //               System.out.println("(r == p.left): " + (r == p.left));
                    
        //             if (r == p.right) {
        //                 if (p.left != null) {
        //                     if (deepNodeCnts == 2 && (p.left.left != null || p.left.right != null)) res = p;
        //                     else if (deepNodeCnts == 3 && (p.left.left != null && p.left.right != null)) res = p;
        //                     else {
        //                         TreeNode tmp = res;
        //                           System.out.println("res.val: " + res.val);
        //                         findGrandParent(rootG, p, tmp);
        //                           System.out.println("res.val: " + res.val);
        //                     }
        //                 } 
        //             } else {
        //                 if (p.right != null) {
        //                     if (deepNodeCnts == 2 && (p.right.left != null || p.right.right != null)) res = p;
        //                     else if (deepNodeCnts == 3 && (p.right.left != null && p.right.right != null)) res = p;
        //                     else {
        //                         TreeNode tmp = res;
        //                           System.out.println("res.val: " + res.val);
        //                         findGrandParent(rootG, p, tmp);
        //                           System.out.println("res.val: " + res.val);
        //                     }
        //                 }      
        //             } 
        //         }
        //     }
        // }
        // private boolean inSubTree(TreeNode p, int val) {
        //     Stack<TreeNode> s = new Stack<TreeNode>();
        //     s.push(p);
        //     while (!s.isEmpty()) {
        //         p = s.pop();
        //         if (p.val == val) return true;
        //         if (p.left != null) s.push(p.left);
        //         if (p.right != null) s.push(p.right);
        //     }
        //     return false;
        // }
        // private void findGrandParent(TreeNode r, TreeNode p, TreeNode q) {
        //      System.out.println("findGrandParent");
        //       if (r != null)
        //       System.out.println("r.val: " + r.val);
        //       System.out.println("p.val: " + p.val);
        //       System.out.println("q.val: " + q.val);
            
        //     if (r == p || r == null) return;
        //     if (r.left == p || r.right == p) {
        //         if (inSubTree((r.left == p) ? r.right : r.left, q.val)) {
        //             res = r;
        //               System.out.println("r.val: " + r.val);
        //             return;
        //         } 
        //     }

        //      System.out.println("r.val: " + r.val);
        //      System.out.println(" (r.left == null || r.right == null): " +  (r.left == null || r.right == null));
            
        //     if (r.left == null || r.right == null) {
        //         findGrandParent((r.left == null) ? r.right : r.left, p, q);
        //     } else {
        //         if ((inSubTree(r.left, p.val) && inSubTree(r.right, q.val))
        //             || (inSubTree(r.right, p.val) && inSubTree(r.left, q.val)) ) {
        //             res = r;
        //             return;
        //         } else {
        //             findGrandParent(r.left, p, q);
        //             findGrandParent(r.right, p, q);
        //         }
        //     }
        // }

        // public class Td {
        //     TreeNode r;
        //     int d;
        //     Td l;
        //     Td y;
        //     Td p;
        //     public Td () {
        //         r = null;
        //         d = 0;
        //     }
        //     public Td (TreeNode x, int a, Td z) {
        //         r = x;
        //         d = a;
        //         p = z;
        //         l = null;
        //         y = null;
        //     }
        //     public Td (TreeNode x, int a, Td z, Td ll, Td rr) {
        //         r = x;
        //         d = a;
        //         p = z;
        //         l = ll;
        //         y = rr;
        //     }
        // }
        // private Td head;
        // private Td findGrandParent(Td p, Td q) {
        //     while (p.p != null && q.p != null && p.p.r.val != q.p.r.val) {
        //         p = p.p;
        //         q = q.p;
        //     }
        //     return p.p;
        // }
        // public TreeNode lcaDeepestLeaves(TreeNode root) {
        //     if (root.left == null && root.right == null) return root;
        //     int maxDepth = 1;
        //     head = new Td(root, 1, null);
        //     Td p = head, q;
        //     Stack<Td> s = new Stack<Td>();
        //     Stack<Td> t = new Stack<>();
        //     s.push(p);
        //     while (!s.isEmpty()) {
        //         p = s.pop();
        //         if (p.r.left == null && p.r.right == null) {
        //             if (p.d >= maxDepth) {
        //                 if (maxDepth < p.d) maxDepth = p.d;
        //                 t.push(p);
        //             }
        //         }
        //         if (p.r.left != null) {
        //             q = new Td(p.r.left, p.d + 1, p);
        //             p.l = q;
        //             s.push(q);
        //         }
        //         if (p.r.right != null) {
        //             q = new Td(p.r.right, p.d + 1, p);
        //             p.y = q;
        //             s.push(q);
        //         }
        //     }
        //       p = t.pop();
        //       Td res = p;
        //       if (t.isEmpty()) return p.r;
        //       q = p;

        //       while (!t.isEmpty() && q.d == maxDepth) {
        //           q = t.pop();
        //           if (p.d == q.d && p.d == maxDepth) {
        //               res = findGrandParent(p, q);
        //           }
        //       }
        //     return (res == null) ? null : res.r;
        // }


        // private TreeNode res;
        // public void trimBSTRecursive(TreeNode r, int l, int h, TreeNode p) {
        //     if (r.left != null) trimBSTRecursive(r.left, l, h, r);
        //     if (r.right != null) trimBSTRecursive(r.right, l, h, r);
        //     if (r.left == null & r.right == null) {
        //         if (r.val < l || r.val > h) {
        //             if (p != null) {
        //                 if (r == p.left) p.left = null;
        //                 if (r == p.right) p.right = null;
        //                 return;
        //             }
        //         }
        //     } else {
        //         if (r.val < l && r.right != null) {
        //             if (p != null) {
        //                 if (r == p.left) p.left = r.right;
        //                 if (r == p.right) p.right = r.right;
        //             } else res = r.right;
        //         } else if (r.val > h && r.left != null) {
        //             if (p != null) {
        //                 if (r == p.left) p.left = r.left;
        //                 if (r == p.right) p.right = r.left;
        //             } else res = r.left;
        //         } else res = r;
        //     }
        // }
        // public TreeNode trimBST(TreeNode root, int low, int high) {
        //     if ((root.left == null && root.right == null && (root.val > high || root.val < low)) return null;
        //     res = root;
        //     trimBSTRecursive(root, low, high, null);
        //     return res;
        // }

        // public int findBottomLeftValue(TreeNode root) {
        //     if (root.left == null && root.right == null) return root.val;
        //     int res = 0;
        //     int maxSum = Integer.MIN_VALUE;
        //     int cnt = 0;
        //     Queue<TreeNode> q = new LinkedList<>();
        //     TreeNode p = root;
        //     q.add(p);
        //     ++cnt;
        //     int tmpcnt = 0;
        //     int levelCnt = cnt;
        //     while (!q.isEmpty()) {
        //         cnt = 0;
        //         while (!q.isEmpty() && tmpcnt < levelCnt) {
        //             p = q.poll();
        //             if (tmpcnt == 0) res = p.val;
        //             System.out.println("res.: " + res);
                    
        //             ++tmpcnt;
        //             if (p.left != null) {
        //                 q.add(p.left);
        //                 ++cnt;
        //             }
        //             if (p.right != null) {
        //                 q.add(p.right);  
        //                 ++cnt;
        //             } 
        //         }
        //         levelCnt = cnt;
        //         tmpcnt = 0;
        //     }
        //     return res;
        // }

        // public List<Integer> largestValues(TreeNode root) {
        //     List<Integer> res = new ArrayList<>();
        //     if (root == null) return res;
        //     int levelMax = Integer.MIN_VALUE;
        //     int cnt = 0;
        //     Queue<TreeNode> q = new LinkedList<>();
        //     TreeNode p = root;
        //     q.add(p);
        //     ++cnt;
        //     int tmpcnt = 0;
        //     int levelCnt = cnt;
        //     while (!q.isEmpty()) {
        //         cnt = 0;
        //         while (!q.isEmpty() && tmpcnt < levelCnt) {
        //             p = q.poll();
        //             if (p.val > levelMax) {
        //                 levelMax = p.val;
        //             }
        //             ++tmpcnt;
        //             if (p.left != null) {
        //                 q.add(p.left);
        //                 ++cnt;
        //             }
        //             if (p.right != null) {
        //                 q.add(p.right);  
        //                 ++cnt;
        //             } 
        //         }
        //         res.add(levelMax);
        //         levelMax = Integer.MIN_VALUE;
        //         levelCnt = cnt;
        //         tmpcnt = 0;
        //     }
        //     return res;
        // }

        // private int val;
        // public void  bstToGstRecursive(TreeNode r) {
        //     if (r.right != null) bstToGstRecursive(r.right);
        //     val += r.val;
        //     r.val = val;
        //     if (r.left != null) bstToGstRecursive(r.left);
        // }            
        // public TreeNode bstToGst(TreeNode root) {
        //     if (root == null) return root;
        //     val = 0;
        //     bstToGstRecursive(root);
        //     return root;
        // }

        // private TreeNode l, y;
        // public void  addOneRowRecursive(TreeNode r, int val, int d, int cnt) {
        //     if (r.left == null && r.right == null && cnt == d - 1) {
        //         l = new TreeNode(val);
        //         y = new TreeNode(val);
        //         r.left = l;
        //         r.right = y;
        //         return;
        //     } else if  (cnt == d - 1) {
        //         l = new TreeNode(val);
        //         y = new TreeNode(val);
        //         l.left = r.left;
        //         y.right = r.right;
        //         r.left = l;
        //         r.right = y;
        //         return;
        //     }
        //     if (r.left != null) addOneRowRecursive(r.left, val, d, cnt + 1);
        //     if (r.right != null) addOneRowRecursive(r.right, val, d, cnt + 1);
        // }
        // public TreeNode addOneRow(TreeNode root, int val, int depth) {
        //     if ((root.left == null && root.right == null) || depth == 1) {
        //         TreeNode dummy = new TreeNode(val);
        //         dummy.left = root;
        //         return dummy;
        //     }
        //     int cnt = 0;
        //     addOneRowRecursive(root, val, depth, 1);
        //     return root;
        // }

        // private boolean isOnlyLastLayerUncompleteQueue(TreeNode p, TreeNode q) {
        //     Queue<TreeNode> s = new LinkedList<TreeNode>();
        //     s.add(q);
        //     s.add(p);
        //     int levelCnt = 2;
        //     int tmpcnt = 0;
        //     int maxDepth = 1;
        //     int recnt = 0;
        //     while (!s.isEmpty()) {
        //         p = s.poll();
        //         q = s.poll();
        //         recnt += 2;
        //         if ()
        //     }
        // }

        // public boolean isEvenOddTree(TreeNode root) {
        //     Stack<TreeNode> s = new Stack<TreeNode>();
        //     Stack<TreeNode> t = new Stack<TreeNode>();
        //     TreeNode p = root, q = root;
        //     s.push(root);
        //     int pp = Integer.MAX_VALUE;
        //     int qq = Integer.MAX_VALUE;
        //     while (!s.isEmpty() || !t.isEmpty()) {
        //         pp = Integer.MAX_VALUE;
        //         while (!s.isEmpty()) {
        //             p = s.pop();
        //             if (p.val % 2 == 0 || p.val >= pp) return false;
        //             if (p.right != null) {
        //                 t.push(p.right);
        //             }
        //             if (p.left != null) {
        //                 t.push(p.left);
        //             }
        //             pp = p.val;
        //         }
        //         qq = Integer.MAX_VALUE;
        //         while (!t.isEmpty()) {
        //             q = t.pop();
        //             if (q.val % 2 == 1 || q.val >= qq) return false;
        //             if (q.left != null) {
        //                 s.push(q.left);
        //             }
        //             if (q.right != null) {
        //                 s.push(q.right);
        //             }
        //             qq = q.val;
        //         }
        //     }
        //     return true;
        // }

        // private TreeNode pp, qq;
        
        // private TreeNode res;
        // private boolean inSubTree(TreeNode r, int val) {
        //     if (r == null) return false;
        //     if (r.val == val) return true;
        //     if (r.left != null && r.right != null) return inSubTree(r.left, val) || inSubTree(r.right, val);
        //     else if (r.left != null) return inSubTree(r.left, val);
        //     else return inSubTree(r.right, val);
        // }
        // public void lowestCommonAncestorRecursive(TreeNode r, TreeNode p, TreeNode q) {
        //     if (r == null) return;
        //     if (r.left != null) lowestCommonAncestorRecursive(r.left, p, q);
        //     if (r.right != null) lowestCommonAncestorRecursive(r.right, p, q);
            
        //     if ((r.left == p && r.right == q) || (r.left == q && r.right == p)) {
        //         res = r;
        //         return;
        //     } else if ((r.val == p.val && inSubTree(r, q.val))
        //                 || (r.val == q.val && inSubTree(r, p.val))) {
        //         res = r;
        //         return;
        //     } else if (r.left != null && r.right != null) {
        //         if ((r.left.val == p.val) && inSubTree(r.right, q.val)
        //             || (r.right.val == p.val) && inSubTree(r.left, q.val)
        //             || (r.left.val == q.val) && inSubTree(r.right, p.val)
        //             || (r.right.val == q.val) && inSubTree(r.left, p.val)
        //             || (inSubTree(r.left, p.val) && inSubTree(r.right, q.val))
        //             || (inSubTree(r.left, q.val) && inSubTree(r.right, p.val))) {
        //             res = r;
        //             return;
        //         }
        //     }
        // }        
        // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //     if (root.val == p.val || root.val == q.val) return root;
        //     lowestCommonAncestorRecursive(root, p, q);
        //     return res;
        // }




        // public void findTiltRecursive(TreeNode r) {
        //     if (r == null) return;
        //     if (r.right != null) {
        //         findTiltRecursive(r.right);
        //         rsum = sum;
        //         System.out.println("rsum: " + rsum);
                
        //     }
        //     if (r.left != null) {
        //         findTiltRecursive(r.left);
        //         lsum = sum;
        //         System.out.println("lsum: " + lsum);
        //     }

        //     if (r.left == null && r.right == null) {
        //         // if (l) lsum = r.val;
        //         // else rsum = r.val;
        //         sum = r.val;
        //         System.out.println("lsum: " + lsum);
        //         System.out.println("rsum: " + rsum);

        //         System.out.println("r.val: " + r.val);
        //         System.out.println("sum: " + sum);
        //         System.out.println("\n");

        //         r.val = 0;
        //         System.out.println("r.val after: " + r.val);
                
        //     } else if (r.left == null || r.right == null) {
        //         if (r.left == null) {
        //             lsum = 0;
        //             rsum = sum;
        //         } else {
        //             rsum = 0;
        //             lsum = sum;
        //         }
        //         System.out.println("r.val: " + r.val);
        //         System.out.println("lsum: " + lsum);
        //         System.out.println("rsum: " + rsum);
        //         System.out.println("sum: " + sum);
        //         sum += r.val;
        //         r.val = Math.abs(lsum - rsum);
        //         System.out.println("sum B : " + sum);
        //         System.out.println("r.val after B: " + r.val);
        //     } else {
        //         sum += r.val;
        //         r.val = Math.abs(lsum - rsum);
        //     }
        // }

        // private int res;
        // private int subtreeSum(TreeNode r) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) {
        //         return r.val;
        //     } else if (r.left != null && r.right != null) {
        //         return subtreeSum(r.right) + subtreeSum(r.left) + r.val;
        //     } else if (r.right != null) return subtreeSum(r.right) + r.val;
        //     else return subtreeSum(r.left) + r.val;
        // }
        // public void findTiltRecursive(TreeNode r) {
        //     if (r.left == null && r.right == null) {
        //         res += 0;
        //     } else if (r.left != null && r.right != null) {
        //         res += Math.abs(subtreeSum(r.right) - subtreeSum(r.left));
        //     } else {
        //         res += Math.abs((r.right == null ? 0 : subtreeSum(r.right))
        //                         - (r.left == null ? 0 : subtreeSum(r.left)));
        //     }
        //     if (r.right != null) findTiltRecursive(r.right);
        //     if (r.left != null) findTiltRecursive(r.left);
        // }
        // public int findTilt(TreeNode root) {
        //     if (root == null || (root.left == null && root.right == null)) return 0;
        //     res = 0;
        //     findTiltRecursive(root);
        //     return res;
        // }

        // private int res; // 这里面是有问题的
        // public void pseudoPalindromicPathsRecursive(TreeNode r, HashSet<Integer> m) {
        //     // System.out.println("r.val: " + r.val);
        //     // System.out.println("(m.contains(r.val)): " + (m.contains(r.val)));
            
        //     if (m.contains(r.val)) {
        //         // for (Integer val : m) {
        //         //     System.out.println("m: " + m);
        //         // }
        //         m.remove(r.val);
        //         // System.out.println("m.size: " + m.size());
        //         // for (Integer val : m) {
        //         //     System.out.println("m: " + m);
        //         // }
        //     } else {
        //         m.add(r.val);
        //     }

        //     // System.out.println("(r.left == null && r.right == null): " + (r.left == null && r.right == null));
        //     if (r.left == null && r.right == null) {
        //         // System.out.println("m.size: " + m.size());
        //         // for (Integer val : m) {
        //         //     System.out.println("m: " + m);
        //         // }
        //         if (m.size() == 1) {
        //             res += 1;
        //             // System.out.println("res: " + res);
        //         }                    
        //         m.remove(r.val);
        //     } 
        //     if (r.left != null) pseudoPalindromicPathsRecursive(r.left, m);
        //     if (r.right != null) pseudoPalindromicPathsRecursive(r.right, m);
        //     m.remove(r.val);
        // }
        // public int pseudoPalindromicPaths (TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     HashSet<Integer> s = new HashSet<Integer>();
        //     res = 0;
        //     pseudoPalindromicPathsRecursive(root, s);
        //     return res;
        // }

        // private int res; // 方法有点儿慢
        // private boolean oneUnique(HashMap<Integer, Integer> m) {
        //     int cnt = 0;
        //     for (Integer key : m.keySet()) {
        //         if (m.get(key) % 2 != 0) ++cnt;
        //     }
        //     return cnt <= 1;
        // }
        // public void pseudoPalindromicPathsRecursive(TreeNode r, HashMap<Integer, Integer> m) {
        //      System.out.println("r.val: " + r.val);
        //     if (m.containsKey(r.val)) {
        //         int tmp = m.get(r.val);
        //         m.put(r.val, tmp + 1);
        //     } else { 
        //         m.put(r.val, 1);
        //     }
        //     if (r.left == null && r.right == null) {
        //         if (oneUnique(m)) {
        //             res += 1;
        //              // System.out.println("res: " + res);
        //         }                    
        //     } 
        //     if (r.left != null) pseudoPalindromicPathsRecursive(r.left, m);
        //     if (r.right != null) pseudoPalindromicPathsRecursive(r.right, m);
        //     if (m.containsKey(r.val)) {
        //         if (m.get(r.val) > 1) m.put(r.val, m.get(r.val) - 1);
        //         else m.remove(r.val, 1);
        //     } 
        // }
        // public int pseudoPalindromicPaths (TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        //     res = 0;
        //     pseudoPalindromicPathsRecursive(root, m);
        //     return res;
        // }

        // private List<TreeNode> l;
        // private boolean inArr(int [] arr, int val) {
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] == val)
        //         return true;
        //     }
        //     return false;
        // }
        // public void delNodesRecursive(TreeNode r, int[] arr, TreeNode p, boolean newRoot) {
        //     if (r == null) return;
        //     if (inArr(arr, r.val)) {
        //         if (p != null && p.left == r) p.left = null;
        //         if (p != null && p.right == r) p.right = null;
        //         if (r.left != null)  {
        //             delNodesRecursive(r.left, arr, null, true);
        //         }
        //         if (r.right != null)  {
        //             delNodesRecursive(r.right, arr, null, true);
        //         }
        //     } else {
        //         if (newRoot) {
        //             l.add(r);
        //         }
        //         if (r.left != null) 
        //         delNodesRecursive(r.left, arr, r, false);
        //         if (r.right != null)
        //         delNodesRecursive(r.right, arr, r, false);
        //     }
        // }
        // public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //     if (root == null) return null;
        //     l = new ArrayList<TreeNode>();
        //     delNodesRecursive(root, to_delete, null, true);
        //     return l;
        // }

        // private TreeNode t, prev;
        // public TreeNode deleteNodeRecursive(TreeNode r, TreeNode p, int val) {
        //     if (r == null) return r;
        //     if (val < r.val) {
        //         return deleteNodeRecursive(r.left, r, val);
        //     } else if (val > r.val) {
        //         return deleteNodeRecursive(r.right, r, val);
        //     } else { //if (r.val == val) {
        //         System.out.println("r.val: " + r.val);
        //         if (r.right != null) {
        //             t = r.right;
        //             prev = r;
        //             while (t.left != null) {
        //                 prev = t;
        //                 t = t.left;
        //             }
        //             r.val = t.val;
        //             if (prev != r) {
        //                 if (t.right == null) prev.left = null;
        //                 if (t.right != null) {
        //                     prev.left = deleteNodeRecursive(t, prev, t.val);
        //                 }
        //             } else {
        //                 r.right = t.right;
        //                 t.right = null;
        //             }
        //             return r;
        //         } else { //if (r.right == null) {
        //             t = r.left;
        //             if (r == p.left) p.left = t;
        //             if (r == p.right) p.right = t;
        //             r.left = null;
        //             return r;
        //         }
        //     } 
        // }
        // public TreeNode deleteNode(TreeNode root, int key) {
        //     if (root == null) return null;
        //     TreeNode dummy = new TreeNode(100001);
        //     dummy.left = root;
        //     deleteNodeRecursive(dummy.left, dummy, key);
        //     return dummy.left;
        // }

        // public TreeNode insertIntoMaxTreeRecursive(TreeNode r, int val) {
        //     if (r == null) return new TreeNode(val);
        //     if (val > r.val) {
        //         TreeNode res = new TreeNode(val);
        //         res.left = r;
        //         return res;
        //     } else {
        //         r.right = insertIntoMaxTreeRecursive(r.right, val);
        //         return r;
        //     }
        // }
        // public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        //     return insertIntoMaxTreeRecursive(root, val);
        // }

        // private int res;
        // public void kthSmallestRecursive(TreeNode r, int val, int cnt) {
        //     if (r == null) return;
        //     System.out.println("r.val 0: " + r.val);
        //     ++cnt;
        //     if (r.left != null) kthSmallestRecursive(r.left, val, cnt);
        //     System.out.println("r.val M: " + r.val);
        //     System.out.println("cnt: " + cnt);
        //     System.out.println("(cnt == val) : " + (cnt == val) );
        //     if (cnt == val) {
        //         res = val;
        //         System.out.println("res: " + res);
        //         return;
        //     }
        //     if (r.right != null) kthSmallestRecursive(r.right, val, cnt);
        // }
        // public int kthSmallest(TreeNode root, int k) {
        //     res = 0;
        //     int cnt = 0;
        //     kthSmallestRecursive(root, k, 0);
        //     return res;
        // }


        // private List<Integer> l;
        // private HashSet<Integer> s;
        // private void leavesDepthRecursive( TreeNode r, int val) {
        //     if (r.left == null & r.right == null) {
        //         l.add(val);
        //         if (!s.contains(val)) s.add(val);
        //     }
        // }
        // public boolean isCompleteTree(TreeNode root) {
        //     if (root.left == null && root.right == null) return true;
        //     if (root.left != null && root.right == null && root.left.left == null) return true;
        //     else if (root.left != null && root.right == null && root.left.left != null) return false;
        //     if (root.left == null && root.right != null) return false;
        //     leavesDepthRecursive(root, 1);
        //     // return isOnlyLastLayerUncompleteRecursive(root.left, root.right, 1);
        //     return false;
        // }

        // public boolean isCompleteTree(TreeNode root) {
        //     if (root.left == null && root.right == null) return true;
        //     if (root.left != null && root.right == null && root.left.left == null) return true;
        //     else if (root.left != null && root.right == null && root.left.left != null) return false;
        //     if (root.left == null && root.right != null) return false;
        //     Queue<TreeNode> l = new LinkedList<TreeNode>();
        //     Queue<TreeNode> r = new LinkedList<TreeNode>();
        //     TreeNode p = root, q;
        //     l.add(p.left);
        //     r.add(p.right);
        //     int levelcnt = 1, tmpcnt = 0, recnt = 0;
        //     boolean rightEnded = false;
        //     boolean leftEnded = false;
        //     while (!l.isEmpty()) {
        //         while (levelcnt > 0 && !l.isEmpty()) {
        //             p =  l.poll();
        //             if (p.left != null) {
        //                 if (leftEnded || rightEnded) return false;
        //                 l.add(p.left);
        //                 ++tmpcnt;
        //             } else leftEnded = true;
        //             if (p.right != null) {
        //                 if (leftEnded || rightEnded) return false;
        //                 l.add(p.right);
        //                 ++tmpcnt;
        //             } else {
        //                 leftEnded = true;
        //             }
        //             if (!r.isEmpty()) {
        //                 q =  r.poll();
        //                  System.out.println("q.val: " + q.val);
        //                 if (q.left != null) {
        //                     if (leftEnded) return false;
        //                     r.add(q.left);
        //                     ++recnt;
        //                 }
        //                 if (q.right != null) {
        //                     if (q.left == null) return false;
        //                     r.add(q.right);
        //                     ++recnt;
        //                 }
        //             }
        //             --levelcnt;
        //         }
        //         if (recnt < tmpcnt) rightEnded = true;
        //         levelcnt = tmpcnt;
        //         tmpcnt = 0;
        //         recnt = 0;
        //     }
        //     return true;
        // }


        
        // private List<Integer> res;
        // private int minleaf;
        // public void FromLeafRecursive(TreeNode r, List<Integer> l) {
        //     l.add(0, r.val);
        //     if (r.left == null && r.right == null) {
        //         if (r.val < minleaf) {
        //             minleaf = r.val;
        //             res = new ArrayList<>(l);
        //         } else if (r.val == minleaf) {
        //             int i = 0, cnt = 0;
        //             boolean needUpdate = false;
        //             for ( i = 0; i < res.size() && i < l.size(); i++) {
        //                 if (res.get(i) < l.get(i)) {
        //                     needUpdate = false;
        //                     break;
        //                 }  else if (res.get(i) > l.get(i)) {
        //                     needUpdate = true;
        //                     break;
        //                 }  else if (res.get(i) == l.get(i)) {
        //                     ++cnt;
        //                 }
        //             }
        //             if (!needUpdate && cnt == l.size() && res.size() > l.size()) {
        //                 for (int j = res.size() - 1; j >= l.size(); j--) {
        //                     res.remove(j);
        //                 }
        //             }
        //             if (needUpdate) {
        //                 res = new ArrayList<>(l);
        //             }
        //         }
        //         return;
        //     }
            
        //     if (r.left != null) {
        //         List<Integer> tmp = new ArrayList<>(l);
        //         FromLeafRecursive(r.left, tmp);
        //     }
        //     if (r.right != null) {
        //         List<Integer> tmp = new ArrayList<>(l);
        //         FromLeafRecursive(r.right, tmp);
        //     }
        // }
        // public String smallestFromLeaf(TreeNode root) {
        //     minleaf = Integer.MAX_VALUE;
        //     res = new ArrayList<Integer>();
        //     List<Integer> l =  new ArrayList<Integer>();
        //     FromLeafRecursive(root, l);
        //     StringBuilder s = new StringBuilder();
        //     for (int i = 0; i < res.size(); i++) {
        //         s.append((char)(res.get(i)+97));
        //     }
        //     return s.toString();
        // }

        // private int res;
        // public void sumRootToLeafRecursive(TreeNode r, List<Integer> l) {
        //     // System.out.println("r.val: " + r.val);
        //     if (r.left == null && r.right == null) {
        //         l.add(0, r.val);
        //         // System.out.println("l.size(): " + l.size());
        //         // System.out.println("");
        //         // for (int i = 0; i < l.size(); ++i) {
        //         //     System.out.println(l.get(i));
        //         // }
        //         // System.out.println("");
        //         StringBuilder s = new StringBuilder();
        //         for (int i = l.size() - 1; i >= 0; i--) {
        //             s.append((char)('0'+l.get(i)));
        //         }
        //         // System.out.println("s.toString: " + s.toString());
        //         res += Integer.parseInt(s.toString(), 2);
        //         System.out.println("res: " + res);

        //         l.remove(0);
        //     }
        //     if (r.left != null) {
        //         l.add(0, r.val);
        //         sumRootToLeafRecursive(r.left, l);
        //         l.remove(0);
        //     }
        //     if (r.right != null) {
        //         l.add(0, r.val);
        //         sumRootToLeafRecursive(r.right, l);
        //         l.remove(0);
        //     }
        // }        
        // public int sumRootToLeaf(TreeNode root) {
        //     if (root.left == null && root.right == null) return root.val;
        //     List<Integer> l = new ArrayList<>();
        //     res = 0;
        //     sumRootToLeafRecursive(root, l);
        //     return res;
        // }


        


        
        // private boolean containsAlready(List<List<TreeNode>> ll, List<TreeNode> l) {
        //     // System.out.println("\ncontainsAlready");
        //     if (ll == null || ll.size() == 0) return false;
        //     int i = 0;
        //     int j = 0;
        //     int cnt = 0;
        //     for ( i = 0; i < ll.size(); i++) {
        //         // System.out.println("i: " + i);
        //         if (ll.get(i).size() != l.size()) continue;
        //         if (l.size() == 1 && ll.get(i).size() == l.size() && ll.get(i).get(0) == l.get(0)) return true;
        //         for ( j = 0; j < l.size(); j++) {
        //             if (ll.get(i).get(j) != l.get(j)) continue;
        //             // if (ll.get(i).get(j) != l.get(j)) {
        //             //     cnt = 0;
        //             //     continue;
        //             // }
        //             // System.out.println("ll.get(i).get(j): " + ll.get(i).get(j));
        //             // System.out.println("l.get(j): " + l.get(j));
        //             // System.out.println("(ll.get(i).get(j) == l.get(j)): " + (ll.get(i).get(j) == l.get(j)));
        //             if (ll.get(i).get(j) == l.get(j)) {
        //                 ++cnt;
        //                 // System.out.println("cnt: " + cnt);
        //             }
        //         }
        //         if (i == ll.size() && cnt == 0) return false;
        //         // System.out.println("(cnt == l.size()): " + (cnt == l.size()));
        //         if (cnt == l.size()) return true;
        //         cnt = 0;
        //     }
        //     return false;
        // }
        // private int res;
        // private List<List<TreeNode>> ll;
        // private void minPathValueToLeaves(TreeNode r, TreeNode p, int val, int t, List<TreeNode> l) {
        //      // System.out.println("r.val 0: " + r.val);
        //      // System.out.println("val: " + val);
        //      // System.out.println("(r.val + val == t || r.val == t): " + (r.val + val == t || r.val == t));
        //      // System.out.println("(r.val == t): " + (r.val == t));
        //      // System.out.println("(r.val + val == t): " + (r.val + val == t));
        //     if (r.left != null) {
        //         l.add(0, r);
        //         minPathValueToLeaves(r.left, r, r.val + val, t, l);
        //         l.remove(0);
        //     }
        //     if (r.right != null) {
        //         l.add(0, r);
        //         minPathValueToLeaves(r.right, r, r.val + val, t, l);
        //         l.remove(0);
        //     }
        //      if (r.val + val == t || r.val == t) {
        //         // System.out.println("(r.val == t): " + (r.val == t));
        //         if (r.val == t) {
        //             res += 1;
        //             List<TreeNode> tmp2 = new ArrayList<>();
        //             tmp2.add(r);
        //              // System.out.println("(!containsAlready(ll, tmp2)): " + (!containsAlready(ll, tmp2)));
        //              if (!containsAlready(ll, tmp2)) { 
        //                 ll.add(tmp2);
        //                  // System.out.println("ll.size(): " + ll.size());
        //                  // for (int i = 0; i < ll.size(); ++i) {
        //                  //     System.out.println("i: " + i);
        //                  //     for (int j = 0; j < ll.get(i).size(); j++) {
        //                  //         System.out.println("ll.get(i).get(j): " + ll.get(i).get(j));
        //                  //     }
        //                  // }
        //                  // System.out.println("");
        //              }
        //         }
        //         // System.out.println("(r.val + val == t): " + (r.val + val == t));
        //         if (r.val + val == t) { 
        //             res += 1;
        //             l.add(0, r);
        //              // System.out.println("l.size(): " + l.size());
        //              // for (int i = 0; i < l.size(); ++i) {
        //              //     System.out.println(l.get(i));
        //              // }
        //              // System.out.println("");
        //              // System.out.println("(!containsAlready(ll, l)): " + (!containsAlready(ll, l)));
        //              // System.out.println("ll.size(): " + ll.size());
        //             if (!containsAlready(ll, l)) {  
        //                 List<TreeNode> tmp = new ArrayList<>();
        //                 for (int i = 0; i < l.size(); i++) {
        //                     tmp.add(l.get(i));
        //                 }
        //                 ll.add(tmp);  
        //                  // System.out.println("ll.size(): " + ll.size());
        //                  // System.out.println("");
        //                  // for (int i = 0; i < ll.size(); ++i) {
        //                  //     for (int j = 0; j < ll.get(i).size(); j++) {
        //                  //         System.out.println("ll.get(i).get(j): " + ll.get(i).get(j));
        //                  //     }
        //                  // }
        //                  // System.out.println("res: " + res);
        //                  // System.out.println("\n");
        //                  // System.out.println("");
        //             }
        //             l.remove(0);
        //         }
        //     }
        // }
        // private void minPostSum(TreeNode r, TreeNode p, int t, int sum, List<TreeNode> l) {
        //     if (r.left != null) {
        //         minPostSum(r.left, r, t, sum + r.val, l);
        //     }
        //     if (r.right != null) {
        //         minPostSum(r.right, r, t, sum + r.val, l);
        //     }
        //     minPathValueToLeaves(r, p, 0, t, l);
        //      // System.out.println("r.val minPostSum: " + r.val);
        //      // System.out.println("res minPostSum: " + res);
        //      // System.out.println("\n");
        // }
        // public int pathSum(TreeNode root, int targetSum) {
        //     if (root == null) return 0;
        //     if (root.left == null && root.right == null) {
        //         if (root.val == targetSum) return 1;
        //         else return 0;
        //     } 
        //     res = 0;
        //     ll = new ArrayList<List<TreeNode>>();
        //     List<TreeNode> l =  new ArrayList<>();
        //     minPostSum(root, null, targetSum, 0, l);
        //     // minPathValueToLeaves(root, null, 0, targetSum, l);

        //     // System.out.println("ll.size(): " + ll.size());
        //     // System.out.println("");
        //     // for (int i = 0; i < ll.size(); ++i) {
        //     //     System.out.println("i: " + i);
        //     //     for (int j = 0; j < ll.get(i).size(); j++) {
        //     //         System.out.println("ll.get(i).get(j): " + ll.get(i).get(j));
        //     //     }
        //     //     System.out.println("\n");
        //     // }
        //     // System.out.println("");
        //     return ll.size();
        // }

        
        // private int solve(TreeNode r, int t, int value) {
        //     if (r == null) return 0;
        //     if (value + r.val == t)
        //         return 1 + solve(r.left, 0, 0) + solve(r.right, 0, 0);
        //     return solve(r.left, t, value + r.val) + solve(r.right, t, value + r.val);
        // }
        // public int pathSum(TreeNode root, int targetSum) {
        //     if (root == null) return 0;
        //     return solve(root, targetSum, 0) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
        // }


        // private int getIdx(int [] arr, int bgn, int end, int val) {
        //     for (int i = bgn; i <= end; i++) {
        //         if (arr[i] == val) return i;
        //     }
        //     return -1;
        // }
        // public TreeNode constructFromPrePostRecursive(int[] p, int bgn, int end, int[] q, int a, int b) {
        //     if (bgn > end || a > b) return null;

        //     System.out.println("bgn: " + bgn);
        //     System.out.println("end: " + end);
        //     System.out.println("a: " + a);
        //     System.out.println("b: " + b);
            
        //     TreeNode res = new TreeNode(p[bgn]);
        //     System.out.println("(bgn == end && a == b): " + (bgn == end && a == b));
            
        //     if (bgn == end && a == b) return res;
        //     System.out.println("res.val: " + res.val);
            
        //     System.out.println("\n");
        //     System.out.println("bgn: " + bgn);
        //     System.out.println("end: " + end);
        //     System.out.println("a: " + a);
        //     System.out.println("b: " + b);
        //     int i = getIdx(p, bgn, end, q[b - 1]);
        //     int j = getIdx(q, a, b, p[bgn + 1]);

        //     System.out.println("i: " + i);
        //     System.out.println("j: " + j);
        //     System.out.println("res.val 2: " + res.val);

        //     System.out.println(" (i >= bgn && i <= end && j >= a && j <= b): " +  (i >= bgn && i <= end && j >= a && j <= b));
        //     System.out.println("(i < bgn && j >= a): " + (i < bgn && j >= a));
            
        //     if (i >= bgn && i <= end && j >= a && j <= b) {
        //         System.out.println("(j == b - 1): " + (j == b - 1));
        //         System.out.println("(i == end - 1): " + (i == end - 1));
        //         System.out.println(" (j == b - 1 || i == end - 1): " +  (j == b - 1 || i == end - 1));
                
        //         if (j == b - 1 || i == end - 1) {
        //             if (j == b - 1) {
        //                 res.left = constructFromPrePostRecursive(p, bgn + 1, i, q, a, j);
        //             } else {
        //                 res.left = constructFromPrePostRecursive(p, bgn + 1, i, q, a, j);
        //             }
        //         } else if (i == end && j == a) {
        //             res.left = constructFromPrePostRecursive(p, bgn + 1, i - 1, q, a, j);
        //             res.right = constructFromPrePostRecursive(p, i, end, q, j + 1, b - 1);
        //             System.out.println("res.left.val: " + res.left.val);
        //             System.out.println("res.right.val: " + res.right.val);
        //         } else {
        //             if (i >= bgn) {
        //                 res.left = constructFromPrePostRecursive(p, bgn + 1, i - 1, q, a, j);
        //                 // res.left = constructFromPrePostRecursive(p, bgn + 1, i, q, a, j);
        //                 System.out.println("res.left.val: " + res.left.val);
        //             }
        //             System.out.println("\n");
        //             System.out.println("i inside:  " + i);
        //             System.out.println("j inside:  " + j);
        //             System.out.println("res.val 2inside:  " + res.val);

        //             // res.right = constructFromPrePostRecursive(p, i + 1, end, q, j + 1, b - 1);  
        //             res.right = constructFromPrePostRecursive(p, i, end, q, j + 1, b - 1);

        //             System.out.println("(res.right != null): " + (res.right != null));
        //             if (res.right != null)
        //             System.out.println("res.right.val: " + res.right.val);
        //         }
        //     } else if (i < bgn && j >= a) {
        //         res.right = new TreeNode(q[j]);
        //         System.out.println("res.right.val: " + res.right.val);
        //         if (j > a) {
        //             res.right
        //         }
        //     }
        //     return res;
        // }
        // public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //     if (pre.length == 1) return new TreeNode(pre[0]);
        //     if (pre.length == 2) {
        //         TreeNode r = new TreeNode(pre[0]);
        //         r.left =  new TreeNode(pre[1]);
        //         return r;
        //     }
        //     TreeNode res = constructFromPrePostRecursive(pre, 0, pre.length - 1, post, 0, post.length - 1);
        //     return res;
        // }
        // public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // public TreeNode constructFromPrePost(int[] preorder, int[] postorder) { // final
        //     int n = preorder.length;
        //     TreeNode r = new TreeNode(preorder[0]);
        //     if (n == 1) return r;
        //     Stack<TreeNode> s = new Stack<>();
        //     s.push(r);
        //     int idx = 0;
        //     for (int i = 1; i < n; i++) {
        //         TreeNode cur = new TreeNode(preorder[i]);
        //         if (s.peek().left == null) s.peek().left = cur;
        //         else s.peek().right = cur;
        //         s.push(cur);
        //         while (idx < n && postorder[idx] == s.peek().val) {
        //             s.pop();
        //             ++idx;
        //         }
        //     }
        //     return r;
        // }


        // public void  sufficientSubsetRecursive(TreeNode r, int val, TreeNode p, int sum) {
        //     System.out.println("r.val: " + r.val);
        //     System.out.println("sum: " + sum);
        //     if (r.left == null && r.right == null) {
        //         if (r.val + sum < val) {
        //             if (r == p.left) p.left = null;
        //             if (r == p.right) p.right = null;
        //         }
        //     }
        //     if (r.left != null) sufficientSubsetRecursive(r.left, val, r, r.val + sum);
        //     if (r.right != null) sufficientSubsetRecursive(r.right, val, r, r.val + sum);
        // }
        // private int minSum;
        // private int maxSum;
        // private void minPathValueToLeaves(TreeNode r, TreeNode p, int val, int l) {
        //     System.out.println("r.val: " + r.val);
        //     // System.out.println("val: " + val);
        //     if (r.left == null && r.right == null) {
        //         if (r.val + val < minSum) {
        //             minSum = r.val + val;
        //             System.out.println("minSum: " + minSum);
        //         }
        //         if (r.val + val < l) {
        //             if (r == p.left) p.left = null;
        //             if (r == p.right) p.right = null;
        //         }
        //         if (r.val + val > maxSum) {
        //             maxSum = r.val + val;
        //             System.out.println("maxSum: " + maxSum);
        //         }
        //     }
        //     if (r.left != null) minPathValueToLeaves(r.left, r, r.val + val, l);
        //     if (r.right != null) minPathValueToLeaves(r.right, r, r.val + val, l);
        // }
        // private void minPostSum(TreeNode r, TreeNode p, int val, int sum) {
        //     if (r.left != null || r.right != null) {
        //         minSum =  Integer.MAX_VALUE;
        //         maxSum = Integer.MIN_VALUE;
        //         minPathValueToLeaves(r, p, 0, val);
        //         System.out.println("r.val: " + r.val);
        //         System.out.println("sum: " + sum);
        //         System.out.println("minSum: " + minSum);
        //         System.out.println("maxSum: " + maxSum);
        //         System.out.println("\n");
        //         // if (maxSum < val) {
        //         //     if (r == p.left) p.left = null;
        //         //     if (r == p.right) p.right = null;
        //         //     return;
        //         // }
        //     }
        //     if (r.left != null) minPostSum(r.left, r, val, sum + r.val);
        //     if (r.right != null) minPostSum(r.right, r, val, sum + r.val);
        // }
        // public void  sufficientSubsetRecursive(TreeNode r, int val, TreeNode p, int sum) {
        //     System.out.println("r.val: " + r.val);
        //     System.out.println("sum: " + sum);
        //     if (r.left == null && r.right == null) {
        //         if (r.val + sum < val) {
        //             if (p != null && p.left != null && r == p.left) p.left = null;
        //             if (p != null && p.left != null && r == p.right) p.right = null;
        //         }
        //     }
        //     if (r.left != null) sufficientSubsetRecursive(r.left, val, r, r.val + sum);
        //     if (r.right != null) sufficientSubsetRecursive(r.right, val, r, r.val + sum);
        // }
        // public TreeNode sufficientSubset(TreeNode root, int limit) {
        //     if (root.left == null && root.right == null) {
        //         return root.val < limit ? null : root;
        //     }
        //     minSum = Integer.MAX_VALUE;
        //     // minPostSum(root, null, limit, 0);
        //     minPathValueToLeaves(root, null, 0, limit);
        //     // sufficientSubsetRecursive(root, limit, null, 0);
        //     return root;
        // }
        
        // public class Td {
        //     TreeNode r;
        //     int minsum;
        //     int maxsum;
        //     Td lt;
        //     Td rt;
        //     Td p;
        //     // boolean go;
        //     public Td () {
        //         r = null;
        //     }
        //     public Td (TreeNode x, Td z) {
        //         r = x;
        //         p = z;
        //         lt = null;
        //         rt = null;
        //         minsum = 0;
        //         // go = false;
        //     }
        //     public Td (TreeNode x, Td z, Td ll, Td rr , int val, int val2) {
        //         r = x;
        //         p = z;
        //         lt = ll;
        //         rt = rr;
        //         minsum = val;
        //         maxsum = val2;
        //         // go = false;
        //     }
        // }
        // private Td head, tmp;
        // private TreeNode rootOri;
        // private void preOrderTraversalTree(TreeNode r, Td p, int val, int k) {
        //     System.out.println("\nr.val: " + r.val);
        //     if (r.left != null) {
        //         tmp = new Td(r.left, p);
        //         p.lt = tmp;
        //         preOrderTraversalTree(r.left, p.lt, val + r.val, k);
        //     }
        //     if (r.right != null) {
        //         tmp = new Td(r.right, p);
        //         p.rt = tmp;
        //         preOrderTraversalTree(r.right, p.rt, val + r.val, k);
        //     }
        //     if (r.left != null && r.right != null) {
        //         p.minsum = Math.min(p.lt.minsum, p.rt.minsum) + r.val;
        //         p.maxsum = Math.max(p.lt.maxsum, p.rt.maxsum) + r.val;
        //         System.out.println("r.val: " + r.val);
        //         System.out.println("p.minsum: " + p.minsum);
        //         System.out.println("p.maxsum: " + p.maxsum);
        //         // if (val + p.minsum < k && val + r.val + p.lt.maxsum < k && val + r.val + p.rt.maxsum < k) {
        //         if (val + p.minsum < k){
        //             if (val + r.val + p.lt.maxsum < k || val + r.val + p.rt.maxsum < k) {
        //                 Td q = p.p;
        //                 q.minsum = Math.min(p.lt.minsum, p.rt.minsum) + q.r.val;
        //                 q.maxsum = Math.max(p.lt.maxsum, p.rt.maxsum) + q.r.val;
        //                 // while (val - q.r.val + q.minsum < k) {
        //                 //     q.r.val = -100001;
        //                 //     q = q.p;
        //                 //     q.minsum = Math.min(q.lt.minsum, q.rt.minsum) + q.r.val;
        //                 //     q.maxsum = Math.max(q.lt.maxsum, q.rt.maxsum) + q.r.val;
        //                 // }
        //                 if (val - q.r.val + q.minsum < k && val - q.r.val + q.maxsum < k ) {
        //                         q.r.val = -100001;
        //                 }
        //                 TreeNode parent = q.r;
        //                 System.out.println("parent.val: " + parent.val);
        //                 if (inLeftSubTree(parent, r)) {
        //                     parent.left = null;
        //                     q.lt = null; 
        //                 } else {
        //                     parent.right = null;
        //                     q.rt = null;
        //                 }
        //                 return;
        //             }
        //         }
        //     } else if (((r.left == null && r.right != null) || (r.right == null && r.left != null))) {
        //         p.minsum = r.left == null ? p.rt.minsum : p.lt.minsum + r.val;
        //         p.maxsum = r.left == null ? p.rt.maxsum : p.lt.maxsum + r.val;
        //         System.out.println("r.val: " + r.val);
        //         System.out.println("p.minsum: " + p.minsum);
        //         System.out.println("p.maxsum: " + p.maxsum);
        //         if (val + p.minsum < k && val + r.val + (r.left == null ? p.rt.maxsum : p.lt.maxsum) < k) {
        //             Td q = p.p;
        //             q.minsum = Math.min(p.lt.minsum, p.rt.minsum) + q.r.val;
        //             q.maxsum = Math.max(p.lt.maxsum, p.rt.maxsum) + q.r.val;
        //             // while (val - q.r.val + q.minsum < k) {
        //             //     q.r.val = -100001;
        //             //     q = q.p;
        //             //     q.minsum = Math.min(q.lt.minsum, q.rt.minsum) + q.r.val;
        //             //     q.maxsum = Math.max(q.lt.maxsum, q.rt.maxsum) + q.r.val;
        //             // }
        //             if (val - q.r.val + q.minsum < k && val - q.r.val + q.maxsum < k ) {
        //                 q.r.val = -100001;
        //             }
        //             parent = q.r;
        //             // TreeNode parent = q.r;
        //             if (!inLeftSubTree(parent, r)) {
        //                 parent.right = null;
        //                 q.rt = null;
        //             } else {
        //                 parent.left = null;
        //                 q.lt = null;
        //             }
        //             return;
        //         }
        //     } else if (r.left == null && r.right == null) {
        //         p.minsum = r.val;
        //         p.maxsum = r.val;
        //         if (val + p.minsum < k) {
        //             Td q = p.p;
        //             System.out.println("val: " + val);
        //             System.out.println("q.val: " + q.r.val);
        //             if (q.lt != null && q.rt != null) {
        //                 q.minsum = Math.min(q.lt.minsum, q.rt.minsum) + q.r.val;
        //                 q.maxsum = Math.max(q.lt.maxsum, q.rt.maxsum) + q.r.val;
        //             } else if (q.lt == null) {
        //                 q.minsum = q.rt.minsum + q.r.val;
        //                 q.maxsum = q.rt.maxsum + q.r.val;
        //             } else {
        //                 q.minsum = q.lt.minsum + q.r.val;
        //                 q.maxsum = q.lt.maxsum + q.r.val;
        //             }
        //             System.out.println("r.val: " + r.val);
        //             System.out.println("q.minsum: " + q.minsum);
        //             System.out.println("q.maxsum: " + q.maxsum);
        //             System.out.println("(val - q.r.val + q.minsum < k): " + (val - q.r.val + q.minsum < k));
        //             System.out.println(" (val - q.r.val + q.maxsum < k): " +  (val - q.r.val + q.maxsum < k));
        //             // while (val - q.r.val + q.maxsum < k) {
        //             //     // q.go = true;
        //             //     q.r.val = -100001;
        //             //     q = q.p;
        //             //     if (q.lt != null && q.rt != null) {
        //             //         q.minsum = Math.min(q.lt.minsum, q.rt.minsum) + q.r.val;
        //             //         q.maxsum = Math.max(q.lt.maxsum, q.rt.maxsum) + q.r.val;
        //             //     } else if (q.lt == null) {
        //             //         q.minsum = q.rt.minsum + q.r.val;
        //             //         q.maxsum = q.rt.maxsum + q.r.val;
        //             //     } else {
        //             //         q.minsum = q.lt.minsum + q.r.val;
        //             //         q.maxsum = q.lt.maxsum + q.r.val;
        //             //     }
        //             // }
        //             // parent = findParent(rootOri, q.r);
        //             // if  (val - q.r.val + q.maxsum < k) {
        //             if (val - q.r.val + q.minsum < k && val - q.r.val + q.maxsum < k ) {
        //                 q.r.val = -100001;
        //             }
        //             parent = q.r;
        //             parent.levelPrintTree(parent); 
        //             System.out.println("parent.val L: " + parent.val);
        //             System.out.println("(inLeftSubTree(parent, r)): " + (inLeftSubTree(parent, r)));
        //             if (inLeftSubTree(parent, r)) {
        //                 parent.left = null;
        //                 q.lt = null;
        //                 // q.lt.go = true;
        //             } else {
        //                 parent.right = null;
        //                 // q.rt.go = true;
        //                 q.rt = null;
        //             }
        //         }
        //     }
        // }
        // private TreeNode parent;
        // private TreeNode findParent(TreeNode r, TreeNode p) {
        //     if (r == p) return r;
        //     if (r.left != null && r.left == p) return r.left;
        //     else if (r.right != null && r.right == p) return r.right;
        //     parent = null;
        //     TreeNode res = findParent(r.left, p);
        //     if (res != null) return res;
        //     return findParent(r.right, p);
        // }
        // private boolean inLeftSubTree(TreeNode r, TreeNode p) {
        //     if (r.left == p) return true;
        //     if (r.left == null) return false;
        //     return inLeftSubTree(r.left, p);
        // }
        // public TreeNode sufficientSubset(TreeNode root, int limit) {
        //     if (root.left == null && root.right == null) {
        //         return root.val < limit ? null : root;
        //     }
        //     // minSum = Integer.MAX_VALUE;
        //     head = new Td(root, null);
        //     rootOri = root;
        //     preOrderTraversalTree(root, head, 0, limit);
        //     // // minPostSum(root, null, limit, 0);
        //     // minPathValueToLeaves(root, null, 0, limit);
        //     // // sufficientSubsetRecursive(root, limit, null, 0);
        //     return root;
        // }

        // public void pathSumtoNodeTopDown(TreeNode r, TreeNode p, int val, int k) {
        //     if (r == null) return;
        //     max = Integer.MIN_VALUE;
        //     pathSumtoNodeBottomUp(r, 0);
        //     if (val + max < k) {
        //         if (p == null) {
        //             rootG = null;
        //             return;
        //         }
        //         if (r == p.left) p.left = null;
        //         else p.right = null;
        //         return;
        //     }
        //     pathSumtoNodeTopDown(r.left, r, val + r.val, k);
        //     pathSumtoNodeTopDown(r.right, r, val + r.val, k);
        // }
        // int max = Integer.MIN_VALUE;
        // TreeNode rootG;
        // public void pathSumtoNodeBottomUp(TreeNode r, int val) { // TOP DOWN FOR MIN PATH SUM
        //     if (r == null) return;
        //     if (r.left == null && r.right == null) 
        //         if (r.val + val > max) max = r.val + val;
        //     pathSumtoNodeBottomUp(r.left, r.val + val);
        //     pathSumtoNodeBottomUp(r.right, r.val + val);
        // } 
        // public TreeNode sufficientSubset(TreeNode root, int limit) {
        //     if (root == null || (root.val < limit && root.left == null && root.right == null)) return null;
        //     rootG = root;
        //     pathSumtoNodeTopDown(rootG, null, 0, limit);
        //     return rootG;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int []  a = new int []  {1, 2, 3, 4, -99, -99, 7, 8, 9, -99, -99, 12, 13, -99, 14}; 
        // int []  a = new int []  {5, 4, 8, 11, -1, 17, 4, 7, 1, -1, -1, 5, 3}; 
        // int []  a = new int []  {1, 2, -3, -5, -1, 4, -1}; 
        int []  a = new int []  {10, 5, 10}; 

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        TreeNode res = s.sufficientSubset(root, 21);
        res.levelPrintTree(res);         
    }
}
