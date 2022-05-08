import com.TreeNode;
import com.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class isSubPath {
    public static class Solution {

        private int res; // about prev == != p
        private void dfsFromLeavesRecursive(TreeNode r, int k, int val) {
            if (r == null) return;
            if (r.left != null && val < k) dfsFromLeavesRecursive(r.left, k, val + 1);
            if (r.right != null && val < k) dfsFromLeavesRecursive(r.right, k, val + 1);
            if ((val == k || val < k) && r.left == null && r.right == null) {
                res += 1;
            }
        }
        public void countPairsRecursive(TreeNode r, int k, TreeNode p, Stack<TreeNode> s) {
            if (r == null) return;
             System.out.println("r.val: " + r.val);
            if (r.left != null) {
                s.push(r);
                System.out.println("r.val push(r): " + r.val);
                countPairsRecursive(r.left, k, r, s);
                TreeNode xx = s.pop();
                System.out.println("xx.val: " + xx.val);
            }
            if (r.right != null) {
                if (r.left == null) {
                    s.push(r);
                }
                countPairsRecursive(r.right, k, r, s);
                if (r.left == null) {
                    s.pop();
                }
            }
            if (r.left == null && r.right == null) {
                int cnt = 1;
                Stack<TreeNode> m = (Stack<TreeNode>)s.clone();
                boolean tmp = false;
                if ((r == p.left && p.right == null)
                    || (r == p.right && p.left == null)) {
                    p = m.pop();
                    while ((p.left == null || p.right == null) && !m.isEmpty()) {
                        p = m.pop();
                        ++cnt;
                    }
                    if (m.isEmpty() && (p.left == null || p.right == null)) return;
                }
                 if (((inSubTree(p.left, r) && p.right == null) || (inSubTree(p.right, r) && p.left == null)) && m.isEmpty()) return;
                if ((inSubTree(p.left, r) && p.right != null) || (inSubTree(p.right, r) && p.left != null)) {
                     dfsFromLeavesRecursive(inSubTree(p.right, r) ? p.left : p.right, k - cnt - 1, 0);
                }
                TreeNode prev = p;
                while (!m.isEmpty()) {
                    p = m.pop();
                    if (p != prev)
                    ++cnt;
                    System.out.println("r.val: " + r.val);
                    System.out.println("prev.val: " + prev.val);
                    System.out.println("p.val: " + p.val);
                    System.out.println("cnt: " + cnt);
                    
                    if (p.left != null && p.right != null)
                      if (p != prev)
                         dfsFromLeavesRecursive(inSubTree(p.left, r) ? p.right : p.left, k - cnt - 1, 0);
                     prev = p;
                }
            }
        }
        private boolean inSubTree(TreeNode r, TreeNode p) {
            if (r == null) return false;
            if (r == p && r != null && p != null) return true;
            if (r.left == null && r.right == null && p != null) return false;
            if (r.left != null && r.right != null) return (inSubTree(r.left, p) || inSubTree(r.right, p));
            else return inSubTree(r.left == null ? r.right : r.left, p);
        }
        public int countPairs(TreeNode root, int distance) {
            if (distance < 2) return 0;
            res = 0;
            Stack<TreeNode> p = new Stack<>();
            p.push(root);
            countPairsRecursive(root, distance, null, p);
            return res / 2;
        }

        public class Res {
            int sum;
            boolean isBST;
            int maxLeft;
            int minLeft;
            public Res() {
                sum = 0;
                isBST = false;
                maxLeft = Integer.MIN_VALUE;
                minLeft = Integer.MAX_VALUE;
            }
            public Res (int x, boolean y, int a, int b) {
                sum = x;
                isBST = y;
                maxLeft = a;
                minLeft = b;
            }
            public Res(Res ori) {
                sum = ori.sum;
                isBST = ori.isBST;
                maxLeft = ori.maxLeft;
                minLeft = ori.minLeft;
            }
        }
        private boolean isBST(TreeNode r) {
            if (r == null) return true;
            if (r.left == null && r.right == null) return true;
            if (r.left != null && r.right != null) {
                if (r.left.val > r.val || r.right.val < r.val) return false;
                return r.left.val < r.val && r.val < r.right.val 
                    && isBST(r.left) && isBST(r.right);
            }
            return r.left == null ? isBST(r.right) : isBST(r.left);
        }
        private Res nodeRes, res;
        private void maxSumBSTRecursiveHelper(TreeNode r) {
            if (r == null) return;
            if (r.left == null && r.right == null) {
                nodeRes.sum = r.val; 
                nodeRes.isBST = true;
                nodeRes.minLeft = r.val;
                nodeRes.maxLeft = r.val;
                if (nodeRes.sum > res.sum)
                res = new Res(nodeRes);
                return;
            }
            nodeRes = new Res();
            if (r.left != null) maxSumBSTRecursiveHelper(r.left);
            Res resLeft = new Res(nodeRes);
            nodeRes = new Res();
            
            if (r.right != null) maxSumBSTRecursiveHelper(r.right);
            Res resRight = new Res(nodeRes);
            nodeRes = new Res();

            if (r.left != null && r.right != null) {
                if (resLeft.isBST && resRight.isBST) {
                    nodeRes.isBST = true;
                    if (resLeft.maxLeft < r.val && resRight.minLeft > r.val) {
                        nodeRes.isBST = true;
                        nodeRes.sum = r.val + resLeft.sum + resRight.sum;
                        nodeRes.minLeft = resLeft.minLeft;
                        nodeRes.maxLeft = resRight.maxLeft;
                         if (nodeRes.sum > res.sum)
                         res = new Res(nodeRes);   // nodeRes = new Res(); 注意这里不能改写
                    } else {
                        nodeRes.isBST = false;
                    }
                } else {
                    nodeRes.isBST = false;
                    nodeRes.sum = 0;
                }  
            } else {
                if (r.left == null) {
                    if (resRight.isBST && r.val < resRight.minLeft) {
                        nodeRes.isBST = true;
                        nodeRes.sum = resRight.sum + r.val;
                        nodeRes.minLeft = r.val;
                        nodeRes.maxLeft = resRight.maxLeft;
                        if (nodeRes.sum > res.sum)
                        res = new Res(nodeRes); 
                    } else {
                        nodeRes.isBST = false;
                    }
                } else {
                    if (resLeft.isBST && r.val > resLeft.maxLeft) {
                        nodeRes.isBST = true;
                        nodeRes.sum = resLeft.sum + r.val;
                        nodeRes.minLeft = resLeft.minLeft;
                        nodeRes.maxLeft = r.val;
                        if (nodeRes.sum > res.sum)
                        res = new Res(nodeRes);
                    } else {
                        nodeRes.isBST = false;
                        nodeRes.sum = 0;
                    }
                }
            }
        }
        public void maxSumBSTRecursive(TreeNode r) {
            if (r == null) return;
            if (r.left != null) maxSumBSTRecursiveHelper(r.left);
            if (r.right != null) maxSumBSTRecursiveHelper(r.right);
            maxSumBSTRecursiveHelper(r);
        }
        public int maxSumBST(TreeNode root) {
            nodeRes = new Res();
            res = new Res();
            maxSumBSTRecursive(root);
            return Math.max(0, res.sum);
        }

        
        public boolean isSubPathRecursive(TreeNode r, ListNode h) { // 这种方法有个bug
            if (r == null && h == null) return true;
            if (r == null && h != null) return false;
            else if (h == null && r != null) return true;
            if (r.val != h.val) {
                if (r.left == null && r.right == null) return false;
                else if (r.left != null && r.right != null) {
                    return (isSubPathRecursive(r.left, h)
                            || isSubPathRecursive(r.right, h));
                } else { 
                    return isSubPathRecursive(r.left == null ? r.right : r.left, h);
                }
            } else {
                if (h.next == null) return true;
                return ((r.left != null && isSubPathRecursive(r.left, h.next))
                        || (r.right != null && isSubPathRecursive(r.right, h.next))
                        || (r.left != null && isSubPathRecursive(r.left, h))
                        || (r.right != null && isSubPathRecursive(r.right, h)));
                        // || isSubPathRecursive(r.left, h) || isSubPathRecursive(r.right, h));
            }
        }
        this method BELOW is OK
        private List<List<Integer>> ll; 
        private List<Integer> l;
        private int count;
        private void preOrderTraversalRecursive(TreeNode r, int val, List<Integer> l, boolean poss) {
            if (r.val == val && !poss) poss = true;
            if (r.left != null) {
                l.add(r.val);
                preOrderTraversalRecursive(r.left, val, l, poss);
                l.remove(l.size()-1);
            }
            if (r.right != null) {
                l.add(r.val);
                preOrderTraversalRecursive(r.right, val, l, poss);
                l.remove(l.size()-1);
            }
            if (r.left == null && r.right == null) {
                l.add(r.val);
                List<Integer> tmp = new ArrayList<>(l);
                if (poss) {
                    while (tmp.get(0) != val) {
                        tmp.remove(0);
                    }
                    if (tmp.size() >= count) ll.add(tmp);
                }
                l.remove(l.size()-1);
            }            
        }
        private List<Integer> res;
        private boolean hasMultipleVal(List<Integer> l, int val) {
            res = new ArrayList<>();
            int cnt = 0;
            for (int i = 1; i < l.size(); i++) {
                if (l.get(i) == val && i + count <= l.size()) {
                    ++cnt;
                    res.add(i);
                }
            }
            if (cnt >= 1) return true;
            return false;
        }
        private boolean hasVal(TreeNode r, int val) {
            if (r.val == val) return true;
            if (r.left == null && r.right == null) return false;
            if (r.left != null && r.right != null) return hasVal(r.left, val) || hasVal(r.right, val);
            else return r.left == null ? hasVal(r.right, val) : hasVal(r.left, val);
        }
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root.left == null && root.right == null) {
                if (head.next == null && head.val == root.val) return true;
                return false;
            }
            ListNode p = head;
            List<Integer> ln = new ArrayList<>();
            while (p != null) {
                ln.add(p.val);
                p = p.next;
            }
            count = ln.size();
            if (count == 1) return hasVal(root, head.val);
            ll = new ArrayList<>();
            l = new ArrayList<>();
            boolean poss = root.val == head.val ? true : false;
            preOrderTraversalRecursive(root, head.val, l, poss);
            int j = 0;
            for (int i = 0; i < ll.size(); i++) {
                for ( j = 0; j < count; j++) {
                    if (ln.get(j) != ll.get(i).get(j)) break;
                }
                if (j == count) return true;
                if (ll.get(i).size() > count && hasMultipleVal(ll.get(i), head.val)) {
                    for (int x = 0; x < res.size(); x++) {
                        for ( j = 0; j < count; j++) {
                            if (ln.get(j) != ll.get(i).get(j + res.get(x))) break;
                        }
                        if (j == count) return true;
                        j = 0;
                    }
                }
            }
            return false;
        }        


        public class Uni {
            TreeNode r;
            int val;
            boolean isUni;
            Uni p;
            Uni left;
            Uni right;
            public Uni() {
                r = null;
                val = 0;      // cnt
                isUni = false;
                p = null;
                left = null;
                right = null;
            }
            public Uni(TreeNode x, int cnt, boolean boo, Uni y) {
                r = x;
                val = cnt;
                isUni = boo;
                p = y;
                left = null;
                right = null;
            }
        }
        private void preOrderTraversal(TreeNode r, Uni p) {
            if (r.left == null && r.right == null) {
                p.val = 0;
                p.isUni = true;
                return;
            }
            if (r.left != null) {
                tmp = new Uni(r.left, 0, false, p);
                p.left = tmp;
                tmp.p = p;
                preOrderTraversal(r.left, tmp);
            }
            if (r.right != null) {
                tmp = new Uni(r.right, 0, false, p);
                p.right = tmp;
                tmp.p = p;
                preOrderTraversal(r.right, tmp);
            }
            if (r.left != null && r.right != null) {
                if (r.val == r.left.val && r.val == r.right.val) {
                    p.isUni = true;
                    p.val = Math.max(p.left.isUni ? p.left.val : 1,  p.right.isUni ? p.right.val : 1) + 1;
                    if ((p.left.isUni ? p.left.val : 0) + (p.right.isUni ? p.right.val : 0) + 2 > res) {
                        res = (p.left.isUni ? p.left.val : 0) + (p.right.isUni ? p.right.val : 0) + 2;
                    }
                } else if (r.val == r.left.val || r.val == r.right.val) {
                    p.isUni = true;
                    p.val = Math.max((p.left.isUni ? p.left.val : 0), (p.right.isUni ? p.right.val : 0)) + 1;
                    if (p.val > res) {
                        res = p.val;
                    }
                } else {
                    p.isUni = false;
                    if (p.left.isUni || p.right.isUni) {
                        if (res < (p.left.isUni ? p.left.val : p.right.val)) {
                            res = p.left.isUni ? p.left.val : p.right.val;
                        }
                    }
                }
            } else {
                if ((r.left == null && r.val == r.right.val) || (r.right == null && r.val == r.left.val)) {
                    p.isUni = true;
                    p.val = (r.left == null ? p.right.val : p.left.val) + 1;
                    if (p.val > res) {
                        res = p.val;
                        System.out.println("res: " + res);
                    }
                } else {
                    p.isUni = false;
                }
            } 
        }
        private Uni ur, tmp;

        private int res;
        private int longestUnivaluePathRecursive(TreeNode r, TreeNode p, int val) {
            if (r == null) return 0;
            // System.out.println("\nr.val: " + r.val);
            // System.out.println("(r.left == null && r.right == null): " + (r.left == null && r.right == null));
            // System.out.println("(r.left != null && r.right != null): " + (r.left != null && r.right != null));
            if (r.left == null && r.right == null) {
                if ((p == null || r.val == p.val) && val > res) {
                    res = val;
                    return val;
                } else
                    return val-1 > 0 ? val-1 : 0;
            }
            else if (r.left != null && r.right != null) {
                if (r.val == r.left.val && r.val == r.right.val) {
                    int left = longestUnivaluePathRecursive(r.left, r, 1);
                    int right = longestUnivaluePathRecursive(r.right, r, 1);
                    System.out.println("left: " + left);
                    System.out.println("right: " + right);
                    
                    if (p == null || r.val == p.val)
                        return Math.max(val + Math.max(left, right), left + right);
                    else {
                        if (val > res) res = val;
                        return left + right;
                    }
                } else if (r.val == r.left.val || r.val == r.right.val) {
                    if  (p == null || r.val == p.val)
                        return val + longestUnivaluePathRecursive(r.left.val == r.val ? r.left : r.right, r, 1);
                    else  {
                        if (val > res) res = val;
                        return longestUnivaluePathRecursive(r.left.val == r.val ? r.left : r.right, r, 1);
                    }
                } 
            } else if (r.left == null || r.right == null) {
                if  (p == null || r.val == p.val) {
                    return val + longestUnivaluePathRecursive(r.left == null ? r.right : r.left, r, 1);
                } else {
                    if (val > res) res = val;
                    return  longestUnivaluePathRecursive(r.left == null ? r.right : r.left, r, 0);
                }
            }
            return -1;
        }
        private void preOrderTraversal(TreeNode r, TreeNode p) {
            if (r == null) return;
            int tmp = longestUnivaluePathRecursive(r, p, 0);
            if (tmp > res) res = tmp;
            preOrderTraversal(r.left, r);
            preOrderTraversal(r.right, r);
        }
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 0;
            // Stack<TreeNode> s = new Stack<>();
            // ur = new Uni(root, 0, false, null);
            // s.push(root);
            // preOrderTraversal(root, ur);
            // longestUnivaluePathRecursive(root, null, 0);
            res = Integer.MIN_VALUE;
            preOrderTraversal(root, null);
            return res;
        }


        // https://www.shuzhiduo.com/A/obzbjv4bzE/
        // count[root] = sum(count[i]) + 1
        // res[root] = sum(res[i]) + sum(count[i])
        private void helper(int cur, int pre, int [] cnt, int [] res) { // post-order traversal indirected graph
            for (Integer v : tree.get(cur)) {
                if (v == pre) continue; // indirected graph, to avoid repeat
                helper(v, cur, cnt, res);
                cnt[cur] += cnt[v];
                res[cur] += res[v] + cnt[v];
            }
            ++cnt[cur]; // include sub-root itself into its cnt val
        }
        // 更新完了所有的 count[root] 和 res[root] 之后，就要来更新所有的 res[i] 了
        // res[i] = res[root] - count[i] + N - count[i]
        private void helper2(int cur, int pre, int [] cnt, int [] res) { // pre-order traversal
            for (Integer v : tree.get(cur)) {
                if (v == pre) continue;
                res[v] = res[cur] - cnt[v] + cnt.length - cnt[v];
                helper2(v, cur, cnt, res);
            }
        } 
        List<List<Integer>> tree;
        int [] cnt;
        int [] res;
        public int[] sumOfDistancesInTree(int n, int[][] edges) {
            cnt = new int[n];
            res = new int[n];
            tree = new ArrayList<>();
            for (int i = 0; i < n; i++) 
                tree.add(new ArrayList<>());
            for (int i = 0; i < edges.length; i++) {
                tree.get(edges[i][0]).add(edges[i][1]);
                tree.get(edges[i][1]).add(edges[i][0]);
            }
            helper(0, -1, cnt, res);
            helper2(0, -1, cnt, res);
            return res;
        }

        
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,1},{0,2},{2,3},{2,4},{2,5}};
        
        int [] res = s.sumOfDistancesInTree(6, a);
        System.out.println("res.length: " + res.length);
        for (int z = 0; z < res.length; ++z) 
            System.out.print(res[z] + ", ");
        System.out.println("");
        
    }
}
