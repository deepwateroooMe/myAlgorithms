import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class searchBST {
    public static class Solution {

        // 这个题目是正确的，只是为了 res variable
        // private TreeNode res;
        // private boolean searchBSTRecursive(TreeNode r, int val) {
        //     if (r == null) return false;
        //     else if (r.val == val) {
        //         res = r;
        //         return true;
        //     }
        //     if (r.left != null && r.val > val) {
        //         return searchBSTRecursive(r.left, val);
        //     } else if (r.right != null && r.val < val) {
        //         return searchBSTRecursive(r.right, val);
        //     } else return false;
        // }
        
        // public TreeNode searchBST(TreeNode root, int val) {
        //     if (root == null || root.val == val) return root;
        //     else if (root.left == null && root.right == null) return null;

        //     if (searchBSTRecursive(root, val)) return res;
        //     else return null;
        // }

        
        private boolean preOrderRecursive(TreeNode r, int val) {
            if (r == null) return true;
            if (r.val != val) {
                return false;
            } else {
                if (r.left != null && r.right != null) {
                    return preOrderRecursive(r.left, val) && preOrderRecursive(r.right, val);
                } else if (r.left != null) {
                    return preOrderRecursive(r.left, val);
                } else if (r.right != null) {
                    return preOrderRecursive(r.right, val);
                } else
                return true;
            }
        }
        
        public boolean isUnivalTree(TreeNode root) {
            if (preOrderRecursive(root, root.val)) return true;
            return false;
        }

        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<Double>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            long levelSum = 0; // int overflow
            int levelCnt = 0;
            int tmp = 0, reCnt = 0;
            int idx = 1;
            TreeNode p = root;
            q.add(p);
            ++levelCnt;
            while (!q.isEmpty()) {
                tmp = levelCnt;
                levelCnt = 0;
                reCnt = 0;
                while (reCnt < tmp) {
                    p = q.poll();
                    levelSum += p.val;

                    ++reCnt;

                    if (p.left != null) {
                        q.add(p.left);
                        ++levelCnt;
                    }
                    if (p.right != null) {
                        q.add(p.right);
                        ++levelCnt;
                    }
                }
                res.add(((double)levelSum / (double)tmp));
                levelSum = 0;
            }
            return res;
        }

        // private List<Integer> l1;
        // private List<Integer> l2;

        // private void inOrderTraversalTree(TreeNode r, List<Integer> leaves) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTree(r.left, leaves);
        //     }
        //     if (r.left == null && r.right == null) {
        //         leaves.add(r.val);
        //     }
        //     if (r.right != null) {
        //         inOrderTraversalTree(r.right, leaves);
        //     }
        // }
        
        // public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //     l1 = new ArrayList<Integer>();
        //     l2 = new ArrayList<Integer>();
        //     inOrderTraversalTree(root1, l1);
        //     inOrderTraversalTree(root2, l2);
        //     if (l1.size() != l2.size()) return false;
            
        //     for (int i = 0; i < l1.size(); i++) {
        //         if (l1.get(i) != l2.get(i)) {
        //             return false;
        //         }
        //     }
        //     return true;
        // }


        private boolean searchInBST(TreeNode r, int val) {
            if (r == null) return false;
            if (r.val == val) return true;
            if (r.left != null && r.val > val) {
                return searchInBST(r.left, val);
            } else if (r.right != null && r.val < val) {
                return searchInBST(r.right, val);
            } else return false;
        }
        private int other;
        private boolean preOrderTraversalRecursive(TreeNode r, int val, TreeNode root) {
            if (r == null) return false;

            other = val - r.val;
            if (other > root.val && root.right != null) {
                if (r.val > root.val && other == r.val) return false;
                
                if (searchInBST(root.right, other)) return true;
                // return preOrderTraversalRecursive(r.right, val, root);
            } else if (other < r.val && r.left != null) {
                if (searchInBST(r.left, other)) return true;
                // return preOrderTraversalRecursive(r.left, val, root);
            } //else if (other == r.val) return false;
            else if (other > r.val && other < root.val) {
                // if (searchInBST(r.right, other)) return true;
                if (searchInBST(root.left, other) && (r.val != other)) return true; //
            } 

                        
            if (r.left != null && r.right != null) {
                return (preOrderTraversalRecursive(r.left, val, root) || preOrderTraversalRecursive(r.right, val, root));
            } else if (r.left != null) {
                return preOrderTraversalRecursive(r.left, val, root);
            } else if (r.right != null) {
                return preOrderTraversalRecursive(r.right, val, root);
            } else {
                // return preOrderTraversalRecursive(root, other, root);
                return (searchInBST(root, other) && (r.val != other));
            }
        }
        public boolean findTarget(TreeNode root, int k) {
            if (root.left == null && root.right == null) return false;
            return preOrderTraversalRecursive(root, k, root);
        }

        // private List<Integer> l;
        // private void inOrderTraversalTree(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTree(r.left);
        //     }
        //     l.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTree(r.right);
        //     }
        // }
        // public int minDiffInBST(TreeNode root) {            
        //     // public int getMinimumDifference(TreeNode root) {
        //     l = new ArrayList<Integer>();
        //     inOrderTraversalTree(root);
        //     int res = Integer.MAX_VALUE;
        //     for (int i = 1; i < l.size(); i++) {
        //         res = Math.min(res, l.get(i) - l.get(i - 1));
        //     }
        //     return res;
        // }

        // private int res;
        // private postOrderTraversalTreeRecursive(TreeNode r) {
        //     if (r.left != null) {
        //         postOrderTraversalTreeRecursive(r.left);
        //     }
        //     if (r.right != null) {
        //         postOrderTraversalTreeRecursive(r.right);
        //     }
            
        // }
        // public int sumOfLeftLeaves(TreeNode root) {
        //     if (root.left == null && root.right == null) return root.val;
        //     res = 0;
        //     Stack<TreeNode> s = new Stack<TreeNode>();
        //     TreeNode p = root, q = null;
        //     s.push(p);
        //     while (!s.isEmpty()) {
        //         if (p.left != null) {
        //             s.push(p.left);
        //         }
        //         if (p.right != null) {
        //             s.push(p.right);
        //         }
                
        //     }
        //     return res;
        // }

        // private int depth;
        // // private void findTargetInBT(TreeNode r, int val) {
            
        // // }
        
        // public boolean isCousins(TreeNode root, int x, int y) {
        //     if (root.val == x || root.val == y) return false;
        //     depth = 0;
        //     int dx = 0, dy = 0;
            
        // }


        // public boolean isSameTree(TreeNode p, TreeNode q) {
        //     Stack<TreeNode> s = new Stack<TreeNode>();
        //     s.push(p);
        //     s.push(q);
        //     while (!s.isEmpty()) {
        //         p = s.pop();
        //         q = s.pop();
        //         if (p == null && q == null) continue;
        //         if (p == null || q == null) return false;
        //         if (p.val != q.val) return false;
        //         s.push(p.left);
        //         s.push(q.left);
        //         s.push(p.right);
        //         s.push(q.right);
        //     }
        //     return true;
        // }
        
        private List<TreeNode> rr;
        private void findTargetInBT(TreeNode r, int val) {
            if (r == null) return;
            if (r.val == val) {
                rr.add(r);
                // return;
            }
            
            // if (r.left != null && r.right != null) {
            //      (findTargetInBT(r.left, val) || findTargetInBT(r.right, val));
            // } else
            if (r.left != null) {
                findTargetInBT(r.left, val);
            }
            if (r.right != null) {
                findTargetInBT(r.right, val);
            } 
        }
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            rr = new ArrayList<TreeNode>();
            findTargetInBT(root, subRoot.val);
            
            if (rr.size() == 0) return false;
            int n = rr.size();
            
            Stack<TreeNode> s = new Stack<TreeNode>();
            TreeNode ss= subRoot, p = null, q = null;
            for (int i = 0; i < rr.size(); i++) {
                
                s.push(rr.get(i));
                s.push(ss);
                while (!s.isEmpty()) {
                    q = s.pop();
                    p = s.pop();
                    
                    if (p == null && q == null) continue;
                    // if (p != null && q != null) continue;
                    if (p != null && q != null) {
                        if (p.val != q.val) {
                            if (n == 1) return false;
                            else continue;
                        } //continue;
                        //return false;
                    } 
                    if (p == null || q == null) {
                        if (n == 1) return false;
                        else continue;
                    }
                    //return false;
                    // if (p.val != q.val) return false;
                    s.push(p.left);
                    s.push(q.left);
                    s.push(p.right);
                    s.push(q.right);
                }
                return true;
            }
            return false;
        }

        // private List<Integer> val;
        // private void inOrderTraversalTreeWithDuplicatesRecusive(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTreeWithDuplicatesRecusive(r.left);
        //     }
        //     val.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTreeWithDuplicatesRecusive(r.right);
        //     }
        // }
        // public int[] findMode(TreeNode root) {
        //     val = new ArrayList<Integer>();
        //     inOrderTraversalTreeWithDuplicatesRecusive(root);
        //     HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        //     for (int i = 0; i < val.size(); i++) {
        //         if (m.containsKey(val.get(i))) {
        //             int tmp = m.get(val.get(i));
        //             m.put(val.get(i), ++tmp);
        //         } else m.put(val.get(i), 1);
        //     }
        //     List<Integer> li = new LinkedList<Integer>();
        //     int maxCnt = m.get(root.val);
        //     int maxVal = root.val;
        //     for (Integer key : m.keySet()) {
        //         maxCnt = Math.max(maxCnt, m.get(key));
        //     }
        //     for (Integer key : m.keySet()) {
        //         if (m.get(key) == maxCnt) {
        //             li.add(key);
        //         }
        //     }
        //     int [] res = new int[li.size()];
        //     for (int i = 0; i < li.size(); i++) {
        //         res[i] = li.get(i);
        //     }
        //     return res;
        // }

        private int secMe;
        private boolean flag;
        private void findSecondMinimumValueRecursive(TreeNode r, int val) { // val: min
            if (r == null) return;
            if (r.val > val && (r.val < secMe || (r.val == secMe && r.val == Integer.MAX_VALUE))) { // 比最小的大，比第二小候选又要小一点儿
                secMe = r.val;
                if (r.val == Integer.MAX_VALUE) flag = true;
                System.out.println("flag: " + flag);
                
            } 
            if (r.left != null) {
                findSecondMinimumValueRecursive(r.left, val);
            }
            if (r.right != null && r.right.val <= secMe) {
                findSecondMinimumValueRecursive(r.right, val);
            }
        }
        
        public int findSecondMinimumValue(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) return -1;
            flag = false;
            secMe = Integer.MAX_VALUE;
            findSecondMinimumValueRecursive(root, root.val);
            return ((secMe == Integer.MAX_VALUE) && (!flag)) ? -1 : (int)secMe;
        }


        // private int maxDepth;
        // public class Td {
        //     TreeNode r;
        //     int d;
        //     public Td () {
        //         r = null;
        //         d = 0;
        //     }
        //     public Td (TreeNode x, int y) {
        //         r = x;
        //         d = y;
        //     }
        // }
        // private int getMaxDepth(TreeNode root) {
        //     Td r = new Td(root, 1), p;
        //     Stack<Td> s = new Stack<Td>();
        //     int maxDepth = 1;
        //     s.push(r);
        //     while (!s.isEmpty()) {
        //         p = s.pop();
        //         if (p.r.left == null && p.r.right == null) {
        //             if (p.d > maxDepth) {
        //                 maxDepth = p.d;
        //                 continue;
        //             }
        //         }
        //         if (p.r.left != null) s.push(new Td(p.r.left, p.d + 1));
        //         if (p.r.right != null) s.push(new Td(p.r.right, p.d + 1));
        //     }
        //     return maxDepth;
        // }
        // private int getDeepestLeavesSum(TreeNode root, int maxDepth) {
        //     int res = 0;
        //     Td r = new Td(root, 1), p;
        //     Stack<Td> s = new Stack<Td>();
        //     s.push(r);
        //     while (!s.isEmpty()) {
        //         p = s.pop();
        //         if (p.r.left == null && p.r.right == null) {
        //             if (p.d == maxDepth) {
        //                 res += p.r.val;
        //                 continue;
        //             }
        //         }
        //         if (p.r.left != null) s.push(new Td(p.r.left, p.d + 1));
        //         if (p.r.right != null) s.push(new Td(p.r.right, p.d + 1));
        //     }
        //     return res;
        // }

        private int cnt;
        private int res;
        private int maxDepth;
        
        private void findMaxDepthRecursive(TreeNode r, int cnt) {
            System.out.println("findMaxDepthRecursive");
            System.out.println("cnt: " + cnt);
             
            if (r == null) return;

            System.out.println("r.val: " + r.val);
            if (r.left == null && r.right == null) {
                System.out.println("r.val: " + r.val);
                if (cnt > maxDepth) {
                    maxDepth = cnt;
                    System.out.println("maxDepth: " + maxDepth);
                }
                // --cnt;
                return;
            }
            if (r.left != null) {
                ++cnt;
                System.out.println("r.left.val: " + r.left.val);
                System.out.println("cnt: " + cnt);
                
                findMaxDepthRecursive(r.left, cnt);
            }
            if (r.right != null) {
                ++cnt;
                System.out.println("r.right.val: " + r.right.val);
                System.out.println("cnt: " + cnt);
                findMaxDepthRecursive(r.right, cnt);
            }
        }
        private void findMaxDepthRecursiveHelper (TreeNode r, List<Integer> res, int cnt) {
            if (r == null) return;
            if (r.left == null && r.right == null) {
                if (cnt > res.get(0)) {
                    maxDepth = cnt;
                    res.add(0, cnt);
                }
                // cnt = 1;
                return;
            }
            if (r.left != null) {
                ++cnt;
                findMaxDepthRecursiveHelper(r.left, res, cnt);
            }
            if (r.right != null) {
                ++cnt;
                findMaxDepthRecursiveHelper(r.right, res, cnt);
            }
        }
        // private void getDeepestLeavesSum(TreeNode r) {
        private void getDeepestLeavesSum(TreeNode r, int cnt) {
            System.out.println("getDeepestLeavesSum");
            System.out.println("cnt: " + cnt);
             
            if (r == null) return;
            if (r.left == null && r.right == null) {

                System.out.println("r.val: " + r.val);
                System.out.println("cnt: " + cnt);
                System.out.println("maxDepth: " + maxDepth);
                System.out.println("(cnt == maxDepth): " + (cnt == maxDepth));
                
                if (cnt == maxDepth) {
                    res += r.val;
                    System.out.println("res: " + res);
                }
                // cnt = 1;
                return;
            }
            if (r.left != null) {
                ++cnt;
                System.out.println("r.left.val: " + r.left.val);
                getDeepestLeavesSum(r.left, cnt);
            }
            if (r.right != null) {
                ++cnt;
                System.out.println("r.right.val: " + r.right.val);
                getDeepestLeavesSum(r.right, cnt);
            }
        }

        public int deepestLeavesSum(TreeNode root) {
            if (root.left == null && root.right == null) return root.val;
            maxDepth = Integer.MIN_VALUE;
            cnt = 1;
            findMaxDepthRecursive(root, cnt);
            cnt = 1;
            getDeepestLeavesSum(root, 1);
            
            // maxDepth = Integer.MIN_VALUE;
            // maxDepth = getMaxDepth(root);
            // res = 0;
            // res = getDeepestLeavesSum(root, maxDepth);
            return res;
        }

        public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            TreeNode p = original, q = cloned;
            if (p == target) return q;
            Stack<TreeNode> s = new Stack<TreeNode>();
            s.push(q);
            s.push(p);
            p = s.pop();
            while (!s.isEmpty() && (p != target)) {
                q = s.pop();
                if (p.left != null) {
                    s.push(q.left);
                    s.push(p.left);
                }
                if (p.right != null) {
                    s.push(q.right);
                    s.push(p.right);
                }
                p = s.pop();
            }
            return s.pop();
        }

        
        public class Td {
            TreeNode r;
            int d;
            Td p;
            public Td () {
                r = null;
                p = null;
                d = 0;
            }
            public Td (TreeNode x, int y, Td z) {
                r = x;
                d = y;
                p = z;
            }
        }
        private int maxDepthWP;
        private int sumWP;
        private Td head;
        private void preOrderRecursiveWParent(TreeNode root) {
            if (root == null) return;
            head = new Td(root, 1, null);
            Td p = head, q; 
            Stack<Td> s = new Stack<Td>();
            s.push(p);
            while (!s.isEmpty()) {
                p = s.pop();
                if (p.d >= 3 && p.p.p.r.val % 2 == 0) {
                    sumWP += p.r.val;
                }
                if (p.r.left == null && p.r.right == null) {
                    if (p.d > maxDepthWP) maxDepthWP = p.d;
                    continue;
                }
                if (p.r.left != null) {
                    q = new Td(p.r.left, p.d + 1, p);
                    s.push(q);
                }
                if (p.r.right != null) {
                    q = new Td(p.r.right, p.d + 1, p);
                    s.push(q);
                }
            }
        }
        public int sumEvenGrandparent(TreeNode root) {
            maxDepthWP = 1;
            sumWP = 0;
            preOrderRecursiveWParent(root);
            return sumWP;
        }

        // public class Td {
        //     TreeNode r;
        //     int s;
        //     public Td () {
        //         r = null;
        //         d = 0;
        //     }
        //     public Td (TreeNode x, int y) {
        //         r = x;
        //         d = y;
        //     }
        // }
        // private Td head;
        // private void RighMiddleLeftTraversalRecursive(TreeNode r) {
        //     if (r == null) return;
        //     if (r.right != null) {
        //         RighMiddleLeftTraversalRecursive(r.right);
        //     }
        // }

        
        // private List<Integer> l;
        // private HashMap<Integer, Integer> m;
        // private void inOrderTraversalTree(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTree(r.left);
        //     }
        //     l.add(r.val);
        //     m.put(r.val, r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTree(r.right);
        //     }
        // }
        // private void inOrderTraversalTreeWithModification(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTreeWithModification(r.left);
        //     }
        //     r.val = m.get(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTreeWithModification(r.right);
        //     }
        // }
        // public TreeNode bstToGst(TreeNode root) {
        //     if (root.left == null && root.right == null) return root;
        //     l = new ArrayList<Integer>();
        //     m = new HashMap<Integer, Integer>();
        //     inOrderTraversalTree(root);
        //     int tmp;
        //     for (int i = l.size() - 2; i >= 0; i--) {
        //         tmp = l.get(i);
        //         l.set(i, l.get(i) + l.get(i + 1));
        //         m.put(tmp, l.get(i));
        //     }
        //     inOrderTraversalTreeWithModification(root);
        //     return root;
        // }

        // private int findMaxIndex(int [] arr, int bgn, int end) {
        //     int max = Integer.MIN_VALUE;
        //     int maxIdx = Integer.MAX_VALUE;
        //     for (int i = bgn; i <= end; i++) {
        //         if (arr[i] > max) {
        //             max = arr[i];
        //             maxIdx = i;
        //         }
        //     }
        //     return maxIdx;
        // }
        // private TreeNode buildBinaryTreeRecursive(int [] arr, int bgn, int end) {
        //     int idx = findMaxIndex(arr, bgn, end);
        //     TreeNode r = new TreeNode(arr[idx]);
        //     if (idx > bgn) {
        //         r.left = buildBinaryTreeRecursive(arr, bgn, idx - 1);
        //     }
        //     if (idx == bgn && bgn == end) {
        //         return r;
        //     }
        //     if (idx < end) {
        //         r.right = buildBinaryTreeRecursive(arr, idx + 1, end);
        //     }
        //     return r;
        // }
        // public TreeNode constructMaximumBinaryTree(int[] nums) {
        //     if (nums.length == 1) return new TreeNode(nums[0]);
        //     TreeNode res = buildBinaryTreeRecursive(nums, 0, nums.length - 1);
        //     return res;
        // }


        // 永远告别这段历史吧！！！！
        // private List<Integer> l1; 
        // private List<Integer> l2;
        // private void inOrderTraversalTreeL1(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTreeL1(r.left);
        //     }
        //     l1.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTreeL1(r.right);
        //     }
        // }
        // private void inOrderTraversalTreeL2(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTreeL2(r.left);
        //     }
        //     l2.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTreeL2(r.right);
        //     }
        // }
        // l1 = new ArrayList<Integer>();
        // l2 = new ArrayList<Integer>();
        // inOrderTraversalTreeL1(root1);
        // inOrderTraversalTreeL2(root2);

        // private void inOrderTraversalTreeLocal(TreeNode r, List<Integer> l) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalTreeLocal(r.left, l);
        //     }
        //     l.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalTreeLocal(r.right, l);
        //     }
        // }
        // public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //     List<Integer> l1 = new ArrayList<Integer>();
        //     List<Integer> l2 = new ArrayList<Integer>();
        //     inOrderTraversalTreeLocal(root1, l1);
        //     inOrderTraversalTreeLocal(root2, l2);
        //     if (l1 == null || l2 == null) {
        //         return (l1 == null) ? l2 : l1;
        //     }
        //     List<Integer> res = new ArrayList<Integer>();
        //     int m = l1.size();
        //     int n = l2.size();
        //     int p = 0, q = 0;
        //     while (p < m && q < n) {
        //         while (p < m && q < n && l1.get(p) > l2.get(q)) {
        //             res.add(l2.get(q++));
        //         }
        //         while (p < m && q < n && l1.get(p) <= l2.get(q)) {
        //             res.add(l1.get(p++));
        //         }
                
        //     }
        //     if (q == n && p == m) return res;
        //     if (q < n) {
        //         for (int i = q; i < n; i++) {
        //             res.add(l2.get(i));
        //         }
        //     } else if (p < m) {
        //         for (int i = p; i < m; i++) {
        //             res.add(l1.get(i));
        //         }
        //     }
        //     return res;
        // }

        // List<Integer> l;
        // private void inOrderTraversalRecursively(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null) {
        //         inOrderTraversalRecursively(r.left);
        //     }
        //     l.add(r.val);
        //     if (r.right != null) {
        //         inOrderTraversalRecursively(r.right);
        //     }
        // }
        // private int getMaxIdx(int [] arr, int bgn, int end) {
        //     int max = Integer.MIN_VALUE;
        //     int maxIdx = Integer.MAX_VALUE;
        //     for (int i = bgn; i <= end; i++) {
        //         if (arr[i] > max) {
        //             max = arr[i];
        //             maxIdx = i;
        //         }
        //     }
        //     return maxIdx;
        // }
        // private TreeNode buildBSTFromSortedArray(int [] arr, int bgn, int end) {
        //     int idx = getMaxIdx(arr, bgn, end);
        //     // System.out.println("idx: " + idx);
        //     TreeNode r = new TreeNode(arr[idx]);
        //     if (idx > bgn) {
        //         r.left = buildBSTFromSortedArray(arr, bgn, idx - 1);
        //     }
        //     if (bgn == end && idx == bgn) {
        //         return r;
        //     }
        //     if (idx < end) {
        //         r.right = buildBSTFromSortedArray(arr, idx + 1, end);
        //     }
        //     return r;
        // }
        // public TreeNode balanceBST(TreeNode root) {
        //     if (root.left == null && root.right == null) return root;
        //     l = new ArrayList<Integer>();
        //     inOrderTraversalRecursively(root);
        //     int [] arr = new int [l.size()];
        //     for (int i = 0; i < l.size(); i++) {
        //         arr[i] = l.get(i);
        //     }
        //     TreeNode res = buildBSTFromSortedArray(arr, 0, arr.length - 1);
        //     return res;
        // }

        // private void insertIntoBSTRecursive(TreeNode r, int val) {
        //     if (r == null) return;
        //     if (r.left == null & r.right == null) {
        //         if (val < r.val) r.left = new TreeNode(val);
        //         else r.right = new TreeNode(val);
        //         return;
        //     }
        //     if (r.left == null && val < r.val) {
        //         r.left = new TreeNode(val);
        //         return;
        //     } else if (r.right == null && val > r.val) {
        //         r.right = new TreeNode(val);
        //         return;
        //     }
        //     if (val < r.val) insertIntoBSTRecursive(r.left, val);
        //     if (val > r.val) insertIntoBSTRecursive(r.right, val);
        // }
        // public TreeNode insertIntoBST(TreeNode root, int val) {
        //     if (root == null) return new TreeNode(val);
        //     insertIntoBSTRecursive(root, val);
        //     return root;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // int [] a = new int [] {4,2,7,1,3};
        // int [] a = new int [] {40,20,60,10,30,50,70};
        int [] a = new int [] {8,-1,55,39,-1,11,-1,-1,23,-1,-1};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);

        TreeNode res = s.insertIntoBST(root, 17);
        res.levelPrintTree(res);
        
        // int [] a = new int [] {2,2,2147483647};
        // int [] a = new int [] {3,9,20,-1,-1,15,7};
        // int [] a = new int [] {1,2,3,-1,4,-1,5};
        // int [] a = new int [] {3,4,5,1,2,-1,-1,-1,-1,0};
        // int [] a = new int [] {3,4,5,1,2};
        // int [] a = new int [] {1, 1};
        // int [] b = new int [] {4, 1, 2};

        // TreeNode root2 = new TreeNode(b[0]);
        // root2.buildTree(root2, b);
        // root2.levelPrintTree(root2);
        

        // int [] a = new int [] {2147483647,2147483647,2147483647}; // testing int overflow
        // int [] b = new int [] {1,3,2};
        // int [] a = new int [] {5, 3, 6, 2, 4, -1, 7};
        // int [] a = new int [] {2, 1, 3};
        // int [] a = new int [] {2, -1, 3};
        // int [] a = new int [] {600,424,612,-1,499,-1,689};
        // int [] a = new int [] {334,277,507,-1,285,-1,678};

        // int [] a = new int [] {1564,1434,3048,1,-1,-1,3184};
        // TreeNode root = new TreeNode(a[0]);
        // // TreeNode root2 = new TreeNode(b[0]);
        // root.buildTree(root, a);
        // root2.buildTree(root, b);
        // root.levelPrintTree(root);
    }
}