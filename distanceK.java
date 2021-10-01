import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class distanceK {
    public static class Solution {

        
        // private List<TreeNode> l;
        // public void findDuplicateSubtreesRecursive(TreeNode r) {
        // }
        // public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //     l = new ArrayList<>();
        //     if (root.left == null && root.right == null) return l;
            
        // }


        // public class Node {
        //     int val;
        //     int d;
        //     public Node() {
        //         val = 0;
        //         d = 0;
        //     }
        //     public Node(int x, int y) {
        //         val = x;
        //         d = y;
        //     }
        // }
        // private List<Node> l;
        // private Stack<Node> s;
        // private void parseStringIntoNodeList(String s) {
        //     l = new ArrayList<Node>();
        //     if (s == null) return;
        //     int n = s.length();
        //     int i = 0, x = 0, cnt = 0;
        //     while (x < s.length()) {
        //         while (x < s.length() && s.charAt(x) == '-') {
        //             ++cnt;
        //             x++;
        //         }
        //         i = x;
        //         while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        //         Node tmp = new Node(Integer.parseInt(s.substring(x, i)), cnt);
        //         l.add(tmp);
        //         x = i;
        //         cnt = 0;
        //     }
        // }
        // public TreeNode recoverFromPreorder(String traversal) {
        //     if (traversal.length() == 0) return null;
        //     l = new ArrayList<Node>();
        //     s = new Stack<Node>();
        //     HashMap<Node, TreeNode> m = new HashMap<>();
        //     int d = 0;
        //     parseStringIntoNodeList(traversal);
        //     TreeNode root = new TreeNode(l.get(0).val);
        //     TreeNode prev = root;
        //     s.push(l.get(0));
        //     m.put(l.get(0), root);
        //     Node p;
        //     for (int i = 1; i < l.size(); i++) {
        //         TreeNode curr = new TreeNode(l.get(i).val);
        //         if (l.get(i).d == l.get(i - 1).d + 1) {
        //             prev.left = curr;
        //             s.push(l.get(i));
        //             m.put(l.get(i), curr);
        //             prev = curr;
        //         } else {
        //             p = s.pop();
        //             while (l.get(i).d < p.d + 1 && !s.isEmpty()) {
        //                 p = s.pop();
        //             }
        //             if (p.d + 1 == l.get(i).d) {
        //                 m.get(p).right = curr;
        //                 prev = curr;
        //             }
        //             s.push(p);
        //             s.push(l.get(i));
        //             m.put(l.get(i), curr);
        //         }
        //     }
        //     return root;
        // }


        // private int getParentVal(int val) {
        //     int d;
        //     if (val == 1) d = 0;
        //     else if (val < 4) d = 1;
        //     else 
        //         d = (int)Math.ceil((double)Math.log(val)) + 1; 
        //      System.out.println("d: " + d);
        //     int label = 0;
        //     if (d % 2 == 0) {
        //         label = (int)Math.pow(2, d) - (int)Math.ceil((double)(val - (Math.pow(2, d) - 1)) / 2.0);
        //         System.out.println("label: " + label); 
        //         return label;
        //     } else { 
        //         if (val > 3) {
        //             label = (int)Math.pow(2, d - 1) + (int)(Math.pow(2, d + 1) - val) / 2 + 1 - 1;  
        //              System.out.println("label: " + label); 
        //             return label;
        //         } else return 1;
        //     }
        // }
        // public List<Integer> pathInZigZagTree(int label) {
        //     List<Integer> l = new ArrayList<Integer>();
        //     l.add(label);
        //     int p = getParentVal(label);
        //      System.out.println("p: " + p);
        //     l.add(0, p);
        //     int res;
        //     while (p > 1) {
        //         res = getParentVal(p);
        //          System.out.println("res: " + res);
        //         l.add(0, res);
        //         p = res;
        //     }
        //      System.out.println("");
        //      System.out.println("l.size(): " + l.size());
        //      for (int i = 0; i < l.size(); ++i) 
        //      System.out.println(l.get(i));
        //      System.out.println("");
        //     return l;
        // }

        // private List<Integer> l;
        // private int depth, maxDepth;
        // private void getDepth(TreeNode r, TreeNode p, int d) {
        //     if (r == p) {
        //         depth = d;
        //     }
        //     if (r.left == null && r.right == null) {
        //         if (d > maxDepth) maxDepth = d;
        //     } 
        //     if (r.left != null) getDepth(r.left, p, d + 1);
        //     if (r.right != null) getDepth(r.right, p, d + 1);
        // }
        // private boolean inSubTree(TreeNode r, TreeNode p) {
        //     if (r == null) return false;
        //     if (r == p) return true;
        //     if (r != p) {
        //         return inSubTree(r.left, p) || inSubTree(r.right, p);
        //     }
        //     return false;
        // }
        // public void distanceKHelperRecursive(TreeNode r, int k, int d) { 
        //     if (d == k) { 
        //         l.add(r.val);
        //         return;
        //     }
        //     if (r.left != null) distanceKHelperRecursive(r.left, k, d + 1);
        //     if (r.right != null) distanceKHelperRecursive(r.right, k, d + 1);
        // }
        // public void distanceKRecursive(TreeNode r, TreeNode t, int k, int d) {
        //     if (r == null) return;
        //     if (r == t) {
        //         distanceKHelperRecursive(r, k, 0); 
        //         return;
        //     }
        //     if (r.left == null && r.right == null) return;
        //     boolean tmp = inSubTree(r, t);
        //     if ((k < depth && d >= depth - k && tmp) || k >= depth) {
        //         if (d == depth - k) l.add(r.val);
        //         if (r.left != null && r.right != null) {
        //             if (inSubTree(r.left, t)) distanceKHelperRecursive(r.right, k + d - depth - 1, 0);
        //             if (inSubTree(r.right, t)) distanceKHelperRecursive(r.left, k + d - depth - 1, 0);
        //         }
        //     }
        //     if (r.left != null){
        //         distanceKRecursive(r.left, t, k, d + 1);
        //     }
        //     if (r.right != null){
        //         distanceKRecursive(r.right, t, k, d + 1);
        //     }
        // }
        // public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //     l = new ArrayList<Integer>();
        //     depth = 0;
        //     getDepth(root, target, 0);
        //     System.out.println("d: " + depth);
        //     System.out.println("maxDepth: " + maxDepth);
        //     TreeNode dummy = new TreeNode(-1);
        //     dummy.left = root;
        //     distanceKRecursive(dummy.left, target, k, 0);
        //     return l;
        // }


        // public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean desc) {
        //     List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        //     if (!desc) {
        //         list.sort(Map.Entry.comparingByValue());
        //     } else {
        //         list.sort(Map.Entry.<K, V>comparingByValue().reversed());
        //     }
        //     Map<K, V> result = new LinkedHashMap<>();
        //     for (Map.Entry<K, V> entry : list) {
        //         result.put(entry.getKey(), entry.getValue());
        //     }
        //     return result;
        // }
        // Map<Integer, Integer> m;
        // List<Integer> l;
        // int cnt, maxCnt;
        // private void treeSum(TreeNode r) {
        //     if (r == null) return;
        //     if (r.left != null)  treeSum(r.left);
        //     if (r.right != null) treeSum(r.right);
        //     if (r.left != null && r.right != null) {
        //         r.val = r.val + r.left.val + r.right.val;
        //     } else if (r.left == null || r.right == null) {
        //         r.val = r.val + (r.left == null ? 0 : r.left.val) + (r.right == null ? 0 : r.right.val);
        //     }
        // }
        // private void preOrderTraversal(TreeNode r) {
        //     l.add(r.val);
        //     if (r.left != null) preOrderTraversal(r.left);
        //     if (r.right != null) preOrderTraversal(r.right);
        // }
        // public int[] findFrequentTreeSum(TreeNode root) {
        //     l = new ArrayList<>();
        //     treeSum(root);
        //     preOrderTraversal(root);
        //     m = new HashMap<Integer, Integer>();
        //     int n = l.size();
        //     for (int i = 0; i < n; i++) {
        //         if (!m.containsKey(l.get(i))) {
        //             m.put(l.get(i), 1);
        //         } else {
        //             int tmp = m.get(l.get(i));
        //             m.put(l.get(i), tmp + 1);
        //         }
        //     }
        //     maxCnt = 0;
        //     int res = 0;
        //     cnt = 0;
        //     m = sortByValue(m, true);

        //     Map.Entry<Integer, Integer> ent = m.entrySet().iterator().next();
        //     res = ent.getValue();
            
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         if (entry.getValue() == res) ++cnt;
        //     }
        //     int i = 0;
        //     if (cnt == l.size()) {
        //         int [] result = new int [l.size()];
        //         for (int j = 0; j < l.size(); j++) {
        //             result[i++] = l.get(j);
        //         }
        //         return result;
        //     }
        //     int [] result = new int [cnt];
        //     int tmp = 0;
        //     for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
        //         if (entry.getValue() == res && tmp < cnt) {
        //             result[i++] = entry.getKey();
        //             ++tmp;
        //         }
        //     }
        //     return result;
        // }

        // private int gcdOne(int a, int b) {
        //     if (b == 0) return 0;
        //     int tmp = 1;
        //     while (b != 0) {
        //         tmp = b;
        //         b = a % b;
        //         a = tmp;
        //     }
        //     // System.out.println("a: " + a);
        //     return a;
        // }
        // private int getKey(HashMap<Integer, List<Integer>> m, int val) {
        //     for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //         List<Integer> l = entry.getValue();
        //         for (int i = 0; i < l.size(); i++) {
        //             if (l.get(i) == val) return entry.getKey();
        //         }
        //     }
        //     return -1;
        // }
        // private boolean containsVal(List<Integer> l, int val) {
        //     for (int i = 0; i < l.size(); i++) {
        //         if (l.get(i) == val) return true;
        //     }
        //     return false;
        // }
        // public int[] getCoprimes(int[] nums, int[][] edges) {
        //     int [] res = new int [nums.length];
        //     res[0] = -1;
        //     HashMap<Integer, List<Integer>> m = new HashMap<>();
        //     List<Integer> l = new ArrayList<>();

        //     for (int i = 0; i < edges.length; i++) {
        //         if (!m.containsKey(edges[i][0])) {
        //             l = new ArrayList<>();
        //             l.add(edges[i][1]);
        //             m.put(edges[i][0], l);
        //         } else {
        //             List<Integer> tmp = new ArrayList<>(l);
        //             tmp.add(edges[i][1]);
        //             m.put(edges[i][0], tmp);
        //         }
        //     }
        //     // System.out.println("");
        //     // System.out.println("m.size(): " + m.size());
        //     // for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
        //     //     System.out.print(entry.getKey() + ": ");
        //     //     List<Integer> tmp = new ArrayList<>(entry.getValue());
        //     //     for (int i = 0; i < tmp.size(); i++) {
        //     //         System.out.print(tmp.get(i) + ", ");
        //     //     }
        //     //     System.out.print("\n");
        //     // }
        //     // System.out.println("");
        //     boolean zeroNull = false;
        //     int i = 0;
        //     if (edges[0][0] != 0) {
        //         i += edges[0][0];
        //         zeroNull = true;
        //     }
        //     i = zeroNull ? edges[0][0]+1 : 1;
        //     int tmp = i;
        //     for ( i = tmp; i < tmp + nums.length - 1; i++) {
        //         // System.out.println("\ni: " + i);
        //         // System.out.println("(i >= 1 && i < nums.length && gcdOne(nums[i], nums[i-1]) == 1 && edges[i-1][0] == i-1 && edges[i-1][1] == i): " + (i >= 1 && i < nums.length && gcdOne(nums[i], nums[i-1]) == 1 && edges[i-1][0] == i-1 && edges[i-1][1] == i));
        //         // System.out.println(" (i >= 0 && i < nums.length && getKey(m, i) != -1 && gcdOne(nums[getKey(m, i)], nums[i]) == 1): " +  (i >= 0 && i < nums.length && getKey(m, i) != -1 && gcdOne(nums[getKey(m, i)], nums[i]) == 1));
        //         // System.out.println("getKey(m, i): " + getKey(m, i));
        //         if (i >= 1 && i < nums.length && gcdOne(nums[i], nums[i-1]) == 1 && edges[i-1][0] == i-1 && edges[i-1][1] == i) {
        //             if (!zeroNull) res[i] = i-1;
        //             else res[i-edges[0][0]] = i-1 - edges[0][0];
        //         } else if (i >= 0 && i < nums.length && getKey(m, i) != -1 && gcdOne(nums[getKey(m, i)], nums[i]) == 1) {
        //             if (!zeroNull) res[i] = getKey(m, i);
        //             else res[i-edges[0][0]] = getKey(m, i) - edges[0][0];
        //             // res[i] = getKey(m, i);
        //         } else {
        //             int idx = getKey(m, i);
        //             while (idx >= 0 && idx < nums.length && gcdOne(nums[idx], nums[i]) != 1) {
        //                 idx = getKey(m, idx);
        //             }
        //             System.out.println("idx: " + idx);
        //             if (!zeroNull) {
        //                 if (idx == nums.length || idx == -1) res[i] = -1;
        //                 else res[i] = idx;
        //             } else {
        //                 // System.out.println("(i-edges[0][0]): " + (i-edges[0][0]));
        //                 // System.out.println("nums.length: " + nums.length);
        //                 // System.out.println("(idx == nums.length + edges[0][0] || idx == -1): " + (idx == nums.length + edges[0][0] || idx == -1));
        //                 if (idx == nums.length + edges[0][0] || idx == -1) res[i-edges[0][0]] = -1;
        //                 else res[i-edges[0][0]] = idx - edges[0][0];
        //             }
        //         }
        //     }
        //     return res;
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
        // private int mincol, maxcol;

        // public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        //     List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        //     list.sort(Map.Entry.comparingByKey());
        //     Map<K, V> result = new LinkedHashMap<>();
        //     for (Map.Entry<K, V> entry : list) {
        //         result.put(entry.getKey(), entry.getValue());
        //     }
        //     return result;
        // }
        // private Map<Integer, Map<Integer, List<Integer>>> map;
        // private Map<Integer, List<Integer>> m;
        // private List<Integer> l;
        // private void preOrderTraversalRecursive(TreeNode r, int x, int y) {
        //     if (!map.containsKey(y)) {
        //         l = new ArrayList<>();
        //         m = new HashMap<>();
        //         l.add(r.val);
        //         m.put(x, l);
        //         map.put(y, m);
        //     } else {
        //         m = map.get(y);
        //         if (m.containsKey(x)) {
        //             l = m.get(x);
        //             l.add(r.val);
        //             m.put(x, l);
        //         } else {
        //             l = new ArrayList<>();
        //             l.add(r.val);
        //             m.put(x, l);
        //         }
        //         map.put(y, m);
        //     }
        //     if (r.left != null) {
        //         preOrderTraversalRecursive(r.left, x+1, y-1);
        //     }
        //     if (r.right != null) {
        //         preOrderTraversalRecursive(r.right, x+1, y+1);
        //     }
        // }
        // public List<List<Integer>> verticalTraversal(TreeNode root) {
        //     map = new HashMap<>();
        //     m = new HashMap<>();
        //     List<List<Integer>> ll = new ArrayList<>();
        //     l = new ArrayList<>();
        //     if (root.left == null && root.right == null) {
        //         l.add(root.val);
        //         ll.add(l);
        //         return ll;
        //     }
        //     preOrderTraversalRecursive(root, 0, 0);
        //     map = sortByKey(map);
        //     ll = new ArrayList<>();
        //     for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : map.entrySet()) {
        //             m = sortByKey(entry.getValue());
        //             l = new ArrayList<>();
        //             for (List<Integer> val : m.values()) {
        //                 if (val.size() > 1) {
        //                     Collections.sort(val);
        //                 }
        //                 for (int i = 0; i < val.size(); i++) {
        //                     l.add(val.get(i));
        //                 }
        //             }
        //             ll.add(l);
        //     }
        //     return ll;
        // }

        // private List<TreeNode> l;
        // private boolean isSameTree(TreeNode r, TreeNode h) {
        //     if (r == null && h == null) return true;
        //     else if (r == null && h != null) return false;
        //     if (r != null && h != null && r.left == null && r.right == null && h.left == null && h.right == null) return true;
        //     if (r != null && r.left != null && r.right != null && (h.left == null || h.right == null)) return false;
        //     if (r != null && ((r.left != null && h.left == null) || (r.right != null && h.right == null))) return false;
        //     return isSameTree(r.left, h.left) && isSameTree(r.right, h.right);
        // }
        // private TreeNode cloneTree(TreeNode r) {
        //     if (r == null) return null;
        //     TreeNode root = new TreeNode(r.val);
        //     if (r.left == null && r.right == null) {
        //         return root;
        //     }
        //     TreeNode p = r;
        //     TreeNode q = root;
        //     if (p.left != null) q.left = cloneTree(p.left);
        //     if (p.right != null) q.right = cloneTree(p.right);
        //     return root;
        // }
        // private TreeNode findTheLeaf(TreeNode p, TreeNode q, TreeNode t) {
        //     if (p == null) return null;
        //     if (p == t) return q;
        //     if (p.left == null && p.right == null && p != t) return null;
        //     if (p.left != null && t == p.left) return q.left;
        //     else if (p.right != null && t == p.right) return q.right;
        //     TreeNode res = findTheLeaf(p.left, q.left, t);
        //     if (res != null) return res;
        //     return findTheLeaf(p.right, q.right, t);
        // }
        // private void workOnOneTreeEach(TreeNode p) {
        //     Queue<TreeNode> s = new LinkedList<>();
        //     TreeNode head = p;
        //     s.add(p);
        //     boolean exist = false;
        //     while (!s.isEmpty()) {
        //         p = s.poll();
        //         if (p.left != null) s.add(p.left);
        //         if (p.right != null) s.add(p.right);
        //         if (p.left == null && p.right == null) {
        //             TreeNode q = cloneTree(head);
        //             TreeNode tmp = findTheLeaf(head, q, p);
        //             tmp.left = new TreeNode(0);
        //             tmp.right = new TreeNode(0);
        //             exist = false;
        //             if (l.size() == 0) l.add(q);
        //             else {
        //                 for (int i = 0; i < l.size(); i++) {
        //                     if (isSameTree(l.get(i), q)) {
        //                         exist = true;
        //                         break;
        //                     }
        //                 }
        //                 if (!exist) l.add(q);
        //             }
        //         }
        //     }
        // }
        // public List<TreeNode> allPossiblRecursiveeFBT(int val) {
        //     l = new ArrayList<>();
        //     if (val == 1) {
        //         l.add(new TreeNode(0));
        //         return l;
        //     } 
        //     if (val == 3) {
        //         TreeNode r = new TreeNode(0);
        //         r.left = new TreeNode(0);
        //         r.right = new TreeNode(0);
        //         l.add(r);
        //         return l;
        //     }
        //     List<TreeNode> res = allPossibleFBT(val - 2);
        //     l = new ArrayList<>();
        //     for (int i = 0; i < res.size(); i++) {
        //         workOnOneTreeEach(res.get(i));
        //     }
        //     return l;
        // }
        // public List<TreeNode> allPossibleFBT(int n) {
        //     l = new ArrayList<TreeNode>();
        //     if (n % 2 == 0) return l;
        //     return allPossiblRecursiveeFBT(n);
        // }


        // public class TreeNodeComparator implements Comparator<TreeNode> {
        //     @Override
        //     public int compare(TreeNode o1, TreeNode o2) {
        //         return (o1.val).compareTo(o2.val);
        //     }
        // }

        
        // private int height;
        // private void traversalTree(TreeNode r, int val) {
        //     if (r.left != null) traversalTree(r.left, val + 1);
        //     if (r.right != null) traversalTree(r.right, val + 1);
        //     if (r.left == null && r.right == null && val > height) height = val;
        // }
        // public List<List<String>> printTree(TreeNode root) {
        //     List<List<String>> ll = new ArrayList<>();
        //     if (root == null) return ll;
        //     height = 0;
        //     traversalTree(root, 0);
        //     int m = height + 1;
        //     int n = (int)Math.pow(2, height + 1) - 1;
        //     String [][] arr = new String[m][n];
            
        //     Queue<TreeNode> q = new LinkedList<>();
        //     Queue<Integer> t = new LinkedList<>();
            
        //     TreeNode p = root;
        //     int i = 0;
        //     int j = (n-1)/2;
        //     q.add(p);
        //     t.add(i * n + j);
            
        //     arr[0][(n-1)/2] = Integer.toString(root.val);
        //     i = 0;
        //     j = (n-1)/2;
        //     int val = 0;
        //     while (!q.isEmpty() && i < m && j < n) {
        //         p = q.poll();
        //         val = (int)t.poll();
        //         i = val / n;
        //         j = val % n;
        //         if (p.left != null) {
        //             arr[i+1][j - (int)Math.pow(2, height - i - 1)] = Integer.toString(p.left.val);
        //             q.add(p.left);
        //             t.add((i+1) * n + j - (int)Math.pow(2, height - i - 1));
        //         }
        //         if (p.right != null) {
        //             j = j + (int)Math.pow(2, height - i - 1);
        //             arr[i+1][j] = Integer.toString(p.right.val);
        //             q.add(p.right);
        //             t.add((i+1) * n + j);
        //         }
        //         i = i + 1;
        //     }
        //     for ( i = 0; i < m; i++) {
        //         for ( j = 0; j < n; j++) {
        //             if (arr[i][j] == null) arr[i][j] = "";
        //         }
        //     }
        //     for ( i = 0; i < m; i++) {
        //         List<String> l = new ArrayList<String>(Arrays.asList(arr[i]));
        //         ll.add(l);
        //     }
        //     return ll;
        //  }

        // private int height;
        // private int cnt;
        // private void traversalTree(TreeNode r, int d) {
        //     if (r.left != null) traversalTree(r.left, d+1);
        //     if (r.right != null) traversalTree(r.right, d+1);
        //     if (r.left == null && r.right == null && d > height) height = d;
        // }
        // private void traversalTreeCounting(TreeNode r, int d) {
        //     if (r.left != null) traversalTreeCounting(r.left, d+1);
        //     if (r.right != null) traversalTreeCounting(r.right, d+1);
        //     if (r.left == null && r.right == null && d < height) cnt += 2;
        //     if (r.left != null && r.right == null) cnt += 1;

        // }
        // public int countNodes(TreeNode root) {
        //     if (root == null) return 0;
        //     if (root.left == null && root.right == null) return 1;
        //     height = 0;
        //     cnt = 0;
        //     traversalTree(root, 0);
        //     traversalTreeCounting(root, 0);
        //     System.out.println("cnt: " + cnt);
            
        //     return (int)Math.pow(2, height + 1) - 1 - cnt;
        // }



        
        // public int widthOfBinaryTree(TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     Queue<TreeNode> q = new LinkedList<>();
        //     TreeNode p = root;
        //     q.add(p);
        //     int levelCnt = 1;
        //     int recnt = 0;
        //     int cnt = 0;
        //     int trueCnt = 0;
        //     int levelTrueCnt = 0;
        //     int falseCnt = 0;
        //     int width = 1;
        //     int bgn = 0;
        //     boolean firstTrue = true;
        //     while (!q.isEmpty()) {
        //         while (!q.isEmpty() && recnt < levelCnt) {
        //             p = q.poll();
        //             System.out.println("\np.val: " + p.val);
        //             ++recnt;

        //             if (p.val != 111) ++trueCnt;
        //             if (trueCnt == 1 && firstTrue) {
        //                 bgn = recnt;
        //                 firstTrue = false;
        //             }
                    
        //             if (trueCnt == levelTrueCnt && recnt - bgn + 1 > width) {
        //                 width = recnt - bgn + 1;
        //                 System.out.println("width: " + width);
        //             }

        //             System.out.println("recnt: " + recnt);
        //             System.out.println("levelCnt: " + levelCnt);
        //             System.out.println("trueCnt: " + trueCnt);
        //             System.out.println("levelTrueCnt: " + levelTrueCnt);
        //             // System.out.println("(trueCnt <= levelTrueCnt && (cnt > 0 || p.right != null) && p.left == null): " + (trueCnt <= levelTrueCnt && (cnt > 0 || p.right != null) && p.left == null));
                    
        //             if (p.left != null && p.left.val != 111) { //  && p.left.val != 111
        //                 q.add(p.left);
        //                 ++cnt;
        //             } else if (trueCnt <= levelTrueCnt && (cnt > 0 || p.right != null) && p.left == null) {
        //                 TreeNode tmp = new TreeNode(111);
        //                 q.add(tmp);
        //                 ++falseCnt;
        //             }
        //             if (p.right != null && p.right.val != 111) { //  && p.right.val != 111
        //                 q.add(p.right);
        //                 ++cnt;
        //             } else if (trueCnt <= levelTrueCnt && (p.left != null || levelCnt - recnt >= 1) && p.right == null) {
        //                 TreeNode tmp = new TreeNode(111);
        //                 q.add(tmp);
        //                 ++falseCnt;
        //             }
        //             while (trueCnt == levelTrueCnt && recnt < levelCnt) {
        //                 p = q.poll();
        //                 System.out.println("\np.val: " + p.val);
        //                 ++recnt;
        //             }
        //         }
        //         if (cnt == 0) return width;
        //         System.out.println("cnt: " + cnt);
        //         System.out.println("falseCnt: " + falseCnt);
                
        //         levelTrueCnt = cnt; // trueCnt
        //         levelCnt = cnt + falseCnt; // recnt
        //         cnt = 0;
        //         recnt = 0;
        //         trueCnt = 0;
        //         firstTrue = true;
        //     }
        //     return width;
        // }
        // public int widthOfBinaryTree(TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     Queue<TreeNode> q = new LinkedList<>();
        //     Queue<TreeNode> t = new LinkedList<>();
        //     TreeNode p = root;
        //     int width = 1;
        //     int cnt = 0; 
        //     int trueCnt = 0;
        //     int levelTrueCnt = 1;
        //     int recnt = 0;
        //     q.add(p);
        //     int bgn = 0, end = 0;
        //     boolean started = false;
            
        //     while (!q.isEmpty()) {
        //         while (trueCnt < levelTrueCnt && !q.isEmpty()) {
        //             p = q.poll();
        //             ++cnt;
        //             // System.out.println("\np.val: " + p.val);
        //             if (p.val != 111 && !started) {
        //                 bgn = cnt;
        //                 ++trueCnt;
        //                 started = true;
        //             } else if (p.val != 111) {
        //                 ++trueCnt;
        //             }
        //             if (trueCnt == levelTrueCnt && cnt - bgn + 1 > width) {
        //                 width = cnt - bgn + 1;
        //                 // System.out.println("width: " + width);
        //             }
        //             if (p.val != 111) end = cnt;

        //             if (p.left != null) {
        //                 t.add(p.left);
        //                 ++recnt;
        //             } else if (p.left == null && t.size() > 0) {
        //                 t.add(new TreeNode(111));
        //             }

        //             if (p.right != null) {
        //                 t.add(p.right);
        //                 ++recnt;
        //             } else if (p.right == null && t.size() > 0) {
        //                 t.add(new TreeNode(111));
        //             }
        //         }
        //         while (trueCnt == levelTrueCnt && !q.isEmpty()) {
        //             p = q.poll();
        //         }
                    
        //         if (q.isEmpty() && !t.isEmpty()) {
        //             if (end - bgn + 1 > width) {
        //                 width = end - bgn + 1;
        //                 // System.out.println("width: " + width);
        //             }
        //             q = t;
        //             t = new LinkedList<>();
        //             levelTrueCnt = recnt;
        //             cnt = 0;
        //             trueCnt = 0;
        //             recnt = 0;
        //             started = false;
        //         }                    
        //     }       
        //     return width;
        // }
        // private int height;
        // public void traversalTree(TreeNode r, int val) {
        //     if (r.left != null) traversalTree(r.left, val+1);
        //     if (r.right != null) traversalTree(r.right, val+1);
        //     if (r.left == null && r.right == null && val > height) {
        //         height = val;
        //     }
        // }
        // public int widthOfBinaryTree(TreeNode root) {
        //     height = 0;
        //     traversalTree(root, 0);
        // }

        // public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //     if (n == 1) return true;
        //     int [] arr = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         arr[i] = -1;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (leftChild[i] != -1 && arr[leftChild[i]] == -1) {
        //             arr[leftChild[i]] = i;
        //         } else if (leftChild[i] != -1 && arr[leftChild[i]] != -1)
        //         return false;
        //         if (rightChild[i] != -1 && arr[rightChild[i]] == -1) {
        //             arr[rightChild[i]] = i;
        //         } else if (rightChild[i] != -1 && arr[rightChild[i]] != -1)
        //         return false;
        //     }
        //     int cnt = 0;
        //     List<Integer> p = new ArrayList<>();
        //     int idx = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (arr[i] == -1) ++cnt;
        //         if (cnt > 1) return false;
        //         if (p.size() == 0) {
        //             p.add(arr[i]);
        //             p.add(i);
        //         } else if (arr[i] == p.get(p.size()-1)) {
        //             idx = 0;
        //             while (idx < p.size() && p.get(idx) != i) ++idx;
        //             if (idx < p.size() && p.get(idx) == i) return false;
        //             p.add(i);
        //             continue;
        //         }           
        //     }
        //     return cnt == 1 ? true : false;
        // }


        // private int maxzig; 
        // public void longestZigZagRecursive(TreeNode r, int d, boolean dir) {
        //     if (r == null) return;
        //     if (dir) {
        //         if (r.right != null) {
        //             longestZigZagRecursive(r.right, d + 1, false);
        //         } else 
        //             if (d > maxzig) maxzig = d;
        //         longestZigZagRecursive(r.left, 1, true);
        //     } else {
        //         if (r.left != null) {
        //             longestZigZagRecursive(r.left, d + 1, true);
        //         } else 
        //             if (d > maxzig) maxzig = d;
        //         longestZigZagRecursive(r.right, 1, false);
        //     }
        // }
        // public int longestZigZag(TreeNode root) {
        //     if (root.left == null && root.right == null) return 0;
        //     maxzig = Integer.MIN_VALUE;
        //     longestZigZagRecursive(root.left, 1, true);
        //     longestZigZagRecursive(root.right, 1, false);
        //     return maxzig;
        // }


        // public class Camera {
        //     int val;
        //     boolean on;
        //     public Camera() {
        //         cnt = 0;
        //         on = false;
        //     }
        //     public Camera(int cnt, boolean installed) {
        //         val = cnt;
        //         on = installed;
        //     }
        // }
        // private Camera res;
        // private int cnt;
        // public void CameraCoverRecursive(TreeNode r) {
        // }
        // private void postOrderTraversalTree(TreeNode r, TreeNode p, boolean on) {
        //     if (r == null) return;

        //     if (r.left == null && r.right == null) return;
        //     else if (r.left != null && r.right != null && p != null && !on) {
        //         on = true;
        //         ++cnt;
        //     } else {
        //         // if (p != null && !on){
        //         if (!on) {
        //             on = true;
        //             ++cnt;
        //         } 
        //     }
        //     if (r.left != null) postOrderTraversalTree(r.left, r, !on);
        //     if (r.right != null) postOrderTraversalTree(r.right, r, !on);
        // }
        // public int minCameraCover(TreeNode root) {
        //     if (root.left == null && root.right == null) return 1;
        //     cnt = 0;
        //     int res = Integer.MAX_VALUE;
        //     if (root.left == null || root.right == null) {
        //         if (root.left == null) {
        //             cnt = 0;
        //             postOrderTraversalTree(root.right, root, true);

        //             System.out.println("cnt: " + cnt);
        //             res = cnt;
        //         }
        //         if (root.right == null) {
        //             cnt = 0;
        //             postOrderTraversalTree(root.left, root, true);
        //             System.out.println("cnt: " + cnt);
        //             res = cnt;
        //         }
        //         cnt = 0;
        //         postOrderTraversalTree(root, null, true);
        //         System.out.println("cnt: " + cnt);
        //         return Math.min(res, cnt);
        //     } else {
        //         postOrderTraversalTree(root, null, true);
        //         System.out.println("cnt: " + cnt);
        //         res = cnt;
        //         cnt = 0;
        //         postOrderTraversalTree(root.right, root, true);
        //         System.out.println("cnt: " + cnt);
        //         int tmp = cnt;
        //         cnt = 0;
        //         postOrderTraversalTree(root.left, root, true);
        //         System.out.println("cnt: " + cnt);
        //         tmp += cnt;
        //         return Math.min(res, tmp);
        //     }
        // }

        // private void getCnts(TreeNode r, int val, boolean vis) {
        //     if (r == null) return;
        //      System.out.println("\nr.val: " + r.val);
        //      System.out.println("vis: " + vis);

        //      if (r.left == null && r.right == null && val + 1 > res) {
        //         res = val + 1;
        //         return;
        //     }
        //     if (vis) {
        //         // return val + 1 + (r.left != null ? getCnts(r.left.left, 0, !vis) + getCnts(r.left.right, 0, !vis);)
        //         if (r.left != null && (r.left.left != null || r.left.right != null)) {
        //             getCnts(r.left.left, val+1, !vis);
        //             getCnts(r.left.right, val+1, !vis);
        //         } // else if (r.left != null && val+1 > res) {
        //         //     res = val + 1;
        //         //     return;
        //         // }
        //         if (r.right != null && (r.right.left != null || r.right.right != null)) {
        //             getCnts(r.right.left, val+1, !vis);
        //             getCnts(r.right.right, val+1, !vis);
        //         } else if ((r.left != null || r.right != null) && res < val + 1) {
        //             res = val + 1;
        //             return;
        //         }
        //     } else {
        //         getCnts(r.left, val, !vis);
        //         getCnts(r.right, val, !vis);
        //     }
        // }
        

        // private List<Integer> l;
        // private TreeNode tmp;
        // private void preOrderTraversalTree(TreeNode r) {
        //     l.add(r.val);
        //     if (r.left != null) preOrderTraversalTree(r.left);
        //     if (r.right != null) preOrderTraversalTree(r.right);
        // }
        // private int getValIdx(int [] arr, int val) {
        //     for (int i = 0; i < arr.length; i++) {
        //         if (arr[i] == val) return i;
        //     }
        //     return -1;
        // }
        // public void flipMatchVoyageRecursive(TreeNode r, int[] arr, int i, int j) {
        //     if (r == null || i > j || r.val != arr[i]) {
        //         l.add(-1);
        //         return;
        //     }
        //     if (r.left == null && r.right == null && r.val == arr[i]) return;
        //     if (r.right == null) {
        //         while (i <= j && r.left.val == arr[i+1]) {
        //             r = r.left;
        //             ++i;
        //         }
        //         if (i == j+1) {
        //             return ;
        //         }
        //         l.add(r.val);
        //         flipMatchVoyageRecursive(r, arr, i-1, j);
        //     } else if (r.left == null) {
        //         while (i <= j && r.right.val == arr[i+1]) {
        //             r = r.right;
        //             ++i;
        //         }
        //         if (i == j+1) {
        //             return ;
        //         }
        //         l.add(r.val);
        //         flipMatchVoyageRecursive(r, arr, i-1, j);
        //     }
        //     if (r.right != null && r.left != null && arr[i+1] == r.right.val) {
        //         l.add(r.val);
        //         tmp = r.left;
        //         r.left = r.right;
        //         r.right = tmp;
        //         flipMatchVoyageRecursive(r.left, arr, i+1, getValIdx(arr, r.right.val)-1);
        //         flipMatchVoyageRecursive(r.right, arr, getValIdx(arr, r.right.val)-1, j);
        //         return;
        //     } else {
        //         int idx = getValIdx(arr, r.right.val);
        //         TreeNode tmp = r.right;
        //         while (i < idx && r.left != null && r.left.val == arr[i+1]) {
        //             r = r.left;
        //             ++i;
        //         }
        //         if (i == idx) {
        //             flipMatchVoyageRecursive(tmp, arr, idx, j);
        //             return ;
        //         } else {
        //             l.add(r.val);
        //             flipMatchVoyageRecursive(r, arr, i-1, idx-1);
        //             flipMatchVoyageRecursive(tmp, arr, idx, j);
        //         }
        //     }
        // }
        // public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //     l = new ArrayList<>();
        //     if (voyage.length <= 2) {
        //         if (root.val == voyage[0]) return l;
        //         l.add(-1);
        //         return l;
        //     }
        //     preOrderTraversalTree(root);
        //     int cnt = 0;
        //     for (int i = 0; i < voyage.length; i++) {
        //         if (l.get(i) != voyage[i]) break;
        //         else ++cnt;
        //     }
        //     if (cnt == voyage.length) {
        //         l = new ArrayList<>();
        //         return l;
        //     }
        //     l = new ArrayList<>();
        //     flipMatchVoyageRecursive(root, voyage, 0, voyage.length -1);
        //     return l;
        // }


        // public TreeNode canMerge(List<TreeNode> trees) {
        //     final int size = trees.size();
        //     final Map<Integer, TreeNode> roots = new HashMap<>(size);
        //     for (final TreeNode node : trees) 
        //         roots.put(node.val, node);
        //     for (final TreeNode node : trees) {
        //         if (roots.containsKey(node.val)) { // 这里判断：是因为接下来buildTree会将可以合并的子树键值对删除并回收利用建大树了
        //             final TreeNode root = buildTree(roots, node);
        //             roots.put(root.val, root); // update root node
        //         }
        //     }
        //     if (roots.size() != 1) return null; // 无法合并所有的子树
        //     final TreeNode root = roots.values().iterator().next(); // 只有这一颗树根
        //     return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? root : null;
        // }
        // private TreeNode buildTree(Map<Integer, TreeNode> roots, TreeNode node) { // 用recursion把所有需要/可以合并的子树建成一棵完整大树，方法很传神
        //     final TreeNode next = roots.remove(node.val); // map.remove()返回值: 如果存在key, 则删除并返回value；如果不存在则返回null
        //     if (next != null) {
        //         if (next.left != null) node.left = buildTree(roots, next.left);
        //         if (next.right != null) node.right = buildTree(roots, next.right);
        //     }
        //     return node;
        // }
        // private boolean isValid(TreeNode node, int min, int max) { // 这些个递归写得很传功力，要活学活用到出神入化。。。。。。
        //     if (node == null) return true;
        //     final int value = node.val;
        //     if (value <= min || value >= max) return false;
        //     return isValid(node.left, min, value) && isValid(node.right, value, max);
        // }

        
        // private void topDownTraverseTree(TreeNode r) {
        //     if (r == null) return;
        //     res = Math.max(res, (sum - m.get(r)) * m.get(r));
        //     topDownTraverseTree(r.left);
        //     topDownTraverseTree(r.right);
        // }
        // public int traversalTree(TreeNode r) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) {
        //         m.put(r, r.val);
        //         return r.val;
        //     }
        //     int tmp = r.val + traversalTree(r.left) + traversalTree(r.right);
        //     m.put(r, tmp);
        //     return tmp;
        // }
        // Map<TreeNode, Integer> m = new HashMap<>();
        // int mod = (int) 1e9 + 7;
        // long sum, res, left, right;
        // long locMax;
        // public int maxProduct(TreeNode root) {
        //     traversalTree(root);
        //     sum = m.get(root);
        //     topDownTraverseTree(root);
        //     return (int) (res % mod);
        // }


        // private String duplicate(TreeNode node) {
        //     if(node == null) return "X";
        //     String l = duplicate(node.left);
        //     String r = duplicate(node.right);
        //     String s = Integer.toString(node.val) + "-" + l + "-" + r;
        //     map.put(s, map.getOrDefault(s, 0)+1);
        //     if (map.get(s) == 2)
        //         list.add(node);
        //     return s;
        // }
        // HashMap<String,Integer> map = new HashMap<>();
        // ArrayList list = new ArrayList<>();
        // public List findDuplicateSubtrees(TreeNode root) {
        //     duplicate(root);
        //     return list;
        // }
        // HashSet<String> set, added; // dfs 的写法
        // List<TreeNode> list;
        // public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //     set = new HashSet();
        //     added = new HashSet();
        //     list = new ArrayList();
        //     StringBuilder ret = dfs(root);
        //     return list;
        // }
        // private StringBuilder dfs(TreeNode root){
        //     if (root == null) return null;
        //     StringBuilder sbL = dfs(root.left), sbR = dfs(root.right);
        //     if (sbL == null && sbR == null){
        //         sbL = new StringBuilder();
        //         sbL.append(root.val);
        //     } else if (sbL != null){
        //         sbL.append(" " + root.val);
        //         if (sbR != null){
        //             sbL.append(' ');
        //             sbL.append(sbR);
        //         } else sbL.append(" n");
        //     } else if (sbL == null){
        //         if (sbR != null){
        //             sbR.insert(0, " n " + root.val);
        //             sbL = sbR;
        //         }
        //     }
        //     String temp = sbL.toString();
        //     if (set.contains(temp) && !added.contains(temp)){
        //         list.add(root);
        //         added.add(temp);
        //     }
        //     set.add(temp);
        //     return sbL;
        // }

        Map<Integer, Integer> count;           // frequency of each subtree represented in string
        Map<List<Integer>, Integer> numberMap; // ** not hashset since it cannot reserve element order
        List<TreeNode> ans;
        int globalNumber = 1;
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap();
            numberMap = new HashMap();
            ans = new ArrayList();
            collect(root);
            return ans;
        }
        public int collect(TreeNode node) {
            if (node == null) return 0;
            int leftNumber = collect(node.left);
            int rightNumber = collect(node.right);
            List<Integer> numberExp = new ArrayList<>(); // construct expression
            numberExp.add(node.val);
            numberExp.add(leftNumber);
            numberExp.add(rightNumber);
            if (!numberMap.containsKey(numberExp)) { // update numberMap
                numberMap.put(numberExp, globalNumber);
                globalNumber++;
            }
            // check number frequency. if == 2, meaning duplication then add to result
            int rootNumber = numberMap.get(numberExp).intValue();
            count.put(rootNumber, count.getOrDefault(rootNumber, 0)+1);
            if (count.get(rootNumber) == 2) // not >=2, otherwise ans will have duplicated nodes
                ans.add(node);
            return rootNumber;
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {1, 2, 3, 4, -1, 2, 4, -1, -1, 4};

        TreeNode root = new TreeNode(a[0]);
        root.buildTree(root, a);
        root.levelPrintTree(root);
        
        List<TreeNode> res = s.findDuplicateSubtrees(root);
        System.out.println("res.size(): " + res.size());
        for (int z = 0; z < res.size(); ++z) 
            res.get(z).levelPrintTree(res.get(z));
        System.out.print("\n");
        
    }
}