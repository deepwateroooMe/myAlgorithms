import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;
// import com.google.common.primitives.Booleans;
import java.util.List;

import static java.util.stream.Collectors.toMap;

public class nRayTree {
    public static class Solution {

        // private List<Integer> res;
        // private void preOrder(Node r) {
        //     if (r == null) return;
        //     res.add(r.val);
        //     if (r.children != null) {
        //         for (int i = 0; i < r.children.size(); i++) {
        //             preOrder(r.children.get(i));
        //         }
        //     }
        // }
        // public List<Integer> preorder(Node root) {
        //     res = new ArrayList<Integer>();
        //     preOrder(root);
        //     return res;
        // }
        
        // private List<Integer> res;
        // private void postOrder(Node r) {
        //     if (r == null) return;
        //     if (r.children != null) {
        //         for (int i = 0; i < r.children.size(); i++) {
        //             postOrder(r.children.get(i));
        //         }
        //     }
        //     res.add(r.val);
        // }
        // public List<Integer> postorder(Node root) {
        //     res = new ArrayList<Integer>();
        //     postOrder(root);
        //     return res;
        // }

        // public List<List<Integer>> levelOrder(Node root) {
        //     List<List<Integer>> ll = new ArrayList<List<Integer>>();
        //     if (root == null) return ll;
        //     List<Integer> l = new ArrayList<Integer>();
        //     Node p = root;
        //     Queue<Node> q = new LinkedList<>();
        //     q.add(p);
        //     int levelCnt = 1;
        //     int tmpcnt = 0;
        //     int cnt = 0;
        //     while (!q.isEmpty()) {
        //         p = q.poll();
        //         l.add(p.val);
        //         ++tmpcnt;
        //         if (p.children != null) {
        //             for (int i = 0; i < p.children.size(); i++) {
        //                 q.add(p.children.get(i));
        //                 ++cnt;
        //             }
        //         }
        //         while (tmpcnt < levelCnt) {
        //             p = q.poll();
        //             l.add(p.val);
        //             ++tmpcnt;
        //             if (p.children != null) {
        //                 for (int i = 0; i < p.children.size(); i++) {
        //                     q.add(p.children.get(i));
        //                     ++cnt;
        //                 }
        //             }
        //         }
        //         if (tmpcnt == levelCnt) {
        //             ll.add(l);
        //             l = new ArrayList<>();
        //             tmpcnt = 0;
        //             levelCnt = cnt;
        //             cnt = 0;
        //         }
        //     }
        //     return ll;
        // }

        // private int maxDepth;
        // private void maxDepthRecursive(Node r, int val) {
        //     if (r == null) return;
        //     System.out.println("r.val: " + r.val);
            
        //     if (r.children == null)  {
        //         if (val > maxDepth) {
        //             maxDepth = val;
        //             System.out.println("maxDepth: " + maxDepth);
        //         }
        //         return;
        //     }
        //     if (r.children != null) {
        //         for (int i = 0; i < r.children.size(); i++) {
        //             System.out.println("r.children.get(i).val: " + r.children.get(i).val);
        //             maxDepthRecursive(r.children.get(i), val + 1);
        //         }
        //     }
        // }
        // public int maxDepth(Node root) {
        //     if (root == null) return 0;
        //     maxDepth = 0;
        //     maxDepthRecursive(root, 1);
        //     System.out.println("maxDepth: " + maxDepth);
        //     return maxDepth;
        // }


        // private int getTreeSize(TreeNode r, int val) {
        //     if (r == null) return 0;
        //     if (r.left == null && r.right == null) return 1;
        //     return getTreeSize(r.left, val + 1) + getTreeSize(r.right, val + 1) + 1;
        // }
        // private TreeNode getTreeNode(TreeNode r, TreeNode pa, int p) { // return parent node
        //     if (r == null) return null;
        //     if (r.val == p) return pa;
        //     TreeNode tmp = getTreeNode(r.left, r, p);
        //     if (tmp == null) return getTreeNode(r.right, r, p);
        //     return tmp;
        // }
        // public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        //     if (root.left == null && root.right == null && x == root.val) return false;
        //     TreeNode dummy = new TreeNode(0);
        //     dummy.left = root;
        //     TreeNode cur = getTreeNode(root, dummy, x);
        //     if (cur == dummy && getTreeSize(cur.left.left, 0) != getTreeSize(cur.left.right, 0)) return true;
        //     else if (cur == dummy) return false;
        //     int left = getTreeSize(cur.left != null && cur.left.val == x ? cur.left.left : cur.right.left, 0);
        //     int right = getTreeSize(cur.left != null && cur.left.val == x ? cur.left.right : cur.right.right, 0);
        //     int rcnt = getTreeSize(root, 0);
        //     if (rcnt - left - right - 1 > left + right + 1) return true;
        //     if (Math.max(left, right) > rcnt - Math.max(left, right)) return true;
        //     return false;
        // }

        // List<Integer> ord = new ArrayList<>();
        // private void preOrderTraversal(TreeNode r) {
        //     if (r == null) return;
        //     ord.add(r.val);
        //     preOrderTraversal(r.left);
        //     preOrderTraversal(r.right);
        // }
        // public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //     List<Integer> l = new ArrayList<>();
        //     if (root.val != voyage[0]) {
        //         l.add(-1);
        //         return l;
        //     }
        //     preOrderTraversal(root);
        //     if (ord.equals(Arrays.stream(voyage).boxed().collect(Collectors.toList()))) return l;
        //     int n = voyage.length;
        //     int i = 1;
        //     Stack<TreeNode> s = new Stack<>();
        //     TreeNode cur = null, tmp = null;
        //     s.push(root);
        //     while (!s.isEmpty() && i < n) {
        //         cur = s.peek();
        //         // System.out.println("i: " + i);
        //         // System.out.println("cur.val: " + cur.val);
        //         // System.out.println("(i < n && cur.left != null && cur.left.val != voyage[i]): " + (i < n && cur.left != null && cur.left.val != voyage[i]));
        //         if (i < n && cur.left != null && cur.left.val != voyage[i]) {
        //             l.add(s.peek().val);
        //             cur = s.pop();
        //             tmp = cur.left;
        //             cur.left = cur.right;
        //             cur.right = tmp;
        //             s.push(cur);
        //             s.push(cur.left);
        //             // System.out.println("cur.left.val: " + cur.left.val);
        //             ++i;
        //         }
        //         while (s.size() > 0 && i < n && (s.peek()).val != voyage[i]) {
        //             // System.out.println("s.peek().val: " + s.peek().val);
        //             s.pop();
        //             if (s.peek().right != null && s.peek().right.val == voyage[i]) {
        //                 s.pop();
        //                 ++i;
        //             }
        //             System.out.println("i: " + i);
        //         }
        //         if (i == n) break;
        //     }
        //     return l;
// }


// HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // int [] vis;
        // public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //     if (n == 1 && informTime[0] == 0) return 0;
        //     else if (n == 1) return informTime[0];
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < n; i++) 
        //         if (manager[i] != -1) 
        //             m.get(manager[i]).add(i);
        //     vis = new int [n];
        //     vis[headID] = -1;
        //     dfs(headID, informTime[headID], informTime);
        //     return res;
        // }
        // int res = 0;
        // private void dfs(int i, int t, int [] informTime) {
        //     if (m.get(i).size() == 0 && t > res) {
        //         res = t;
        //         return;
        //     }
        //     for (int j = 0; j < m.get(i).size(); j++) {
        //         if (vis[m.get(i).get(j)] == -1) continue;
        //         vis[m.get(i).get(j)] = -1;
        //         dfs(m.get(i).get(j), t + informTime[m.get(i).get(j)], informTime);
        //         vis[m.get(i).get(j)] = 1;
        //     }
        // }


        // Map<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // int [] vis;
        // int [] arr;
        // int [] res;
        // private int [] dfs(int i, String s) {
        //     if (m.get(i).size() == 1 && vis[m.get(i).get(0)] == -1) {
        //         int [] arr = new int [26];
        //         arr[s.charAt(i)-'a'] = 1;
        //         res[i] = 1;
        //         return arr;
        //     }
        //     int [] arr = new int [26];
        //     arr[s.charAt(i)-'a'] = 1;
        //     for (int j = 0; j < m.get(i).size(); j++)  {
        //         if (vis[m.get(i).get(j)] == -1) continue;
        //         vis[m.get(i).get(j)] = -1;
        //         int [] tmp = dfs(m.get(i).get(j), s);
        //         for (int x = 0; x < 26; x++)
        //             arr[x] += tmp[x];
        //         vis[m.get(i).get(j)] = 1;
        //     }
        //     res[i] = arr[s.charAt(i)-'a'];
        //     return arr;
        // }
        // public int[] countSubTrees(int n, int[][] edges, String labels) {
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     vis = new int [n];
        //     arr = new int [26];
        //     res = new int [n];
        //     vis[0] = -1;
        //     dfs(0, labels);
        //     return res;
        // }

        
        // public boolean buildTree(TreeNode root, int [] a) {
        //     TreeNode curr = root;
        //     Stack<TreeNode> s = new Stack<TreeNode>();
        //     s.push(curr);
        //     int idx = 1;
        //     while (!s.isEmpty() && idx < a.length) {
        //         curr = s.pop();
        //         if (idx % 2 == 1 && a[idx] != -1) { 
        //             curr.left = new TreeNode(a[idx]); 
        //             s.push(curr.left);
        //             ++idx;
        //         } else if (idx % 2 == 1 && a[idx] == -1)
        //             ++idx;
        //         if (idx == a.length) return false;
        //         if (idx < a.length && idx % 2 == 0 && a[idx] != -1) {  // right
        //             curr.right = new TreeNode(a[idx]); 
        //             s.push(curr.right);
        //             ++idx;
        //         } else if (idx < a.length && idx % 2 == 0 && a[idx] == -1) ++idx;
        //     }
        //     if (s.isEmpty() && idx < a.length) return false;
        //     return true;
        // }
        // public boolean isValidSerialization(String preorder) {
        //     if (preorder.length() == 1 && preorder.charAt(0) == '#') return true;
        //     if (preorder.length() < 3 || (preorder.length() >= 3 && preorder.charAt(0) == '#')) return false;
        //     List<String> list = Arrays.asList(preorder.split(","));
        //     int n = list.size();
        //     int [] arr = new int[n];
        //     for (int i = 0; i < n; i++) {
        //         if (!list.get(i).equals("#")) arr[i] = Integer.parseInt(list.get(i));
        //         else arr[i] = -1;
        //     }
        //     TreeNode r = new TreeNode(arr[0]);
        //     return buildTree(r, arr);
        // }


        // int cnt = 0;
        // int res = 0;
        // private void preOrderTraversal(Node r, int d) {
        //     if (r == null || r.cnt == 0) return;
        //     if (r.app && r.cnt == 1) {
        //         res += d;
        //         return;
        //     }
        //     if (r.children != null) {
        //         cnt = 0;
        //         for (int i = 0; i < r.children.size(); i++) {
        //             if (r.children.get(i).cnt == 0) continue;
        //             preOrderTraversal(r.children.get(i), d+1);
        //             ++cnt;
        //         }
        //         res -= (cnt-1) * d;
        //     }
        // }
        // private void postOrderTraversal(Node r) {
        //     if (r == null) return;
        //     if (r.children != null) {
        //         for (int i = 0; i < r.children.size(); i++) {
        //             postOrderTraversal(r.children.get(i));
        //             r.cnt += r.children.get(i).cnt;
        //         }
        //     }
        // }
        // HashMap<Integer, List<Integer>> m = new HashMap<>();
        // List<Integer> l = new ArrayList<>();
        // public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         m.put(i, l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         m.get(edges[i][0]).add(edges[i][1]);
        //         m.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     int key = 0, val = 0;
        //     Node r = new Node(0, hasApple.get(0));
        //     Node cur = r, tmp = null;
        //     List<Node> ln = new ArrayList<>();
        //     Queue<Node> q = new LinkedList<>();
        //     q.add(cur);
        //     while (!q.isEmpty()) {
        //         cur = q.poll();
        //         l = m.get(cur.val);
        //         if (l.size() == 1) continue;
        //         ln = new ArrayList<>();
        //         for (int i = 0; i < l.size(); i++) {
        //             if (cur.p != null && l.get(i) == cur.p.val) continue; // parent
        //             tmp = new Node(l.get(i), hasApple.get(l.get(i)));
        //             tmp.p = cur;
        //             ln.add(tmp);
        //             q.add(tmp);
        //         }
        //         cur.children = ln;
        //     }
        //     r.levelPrintTree(r);
        //     postOrderTraversal(r);
        //     r.levelPrintTree(r);
        //     // preOrderTraversal(r, 0);
        //     res = 0;
        //     Stack<Node> s = new Stack<>();
        //     s.push(r); 
        //     while (!s.isEmpty()) {
        //         if (s.peek().cnt > 1 || (s.peek().cnt == 1 && !s.peek().app)) {
        //             if (s.peek().children != null) 
        //                 for (int i = 0; i < s.peek().children.size(); i++) {
        //                     if (s.peek().children.get(i).cnt == 0) continue;
        //                     s.push(s.peek().children.get(i));
        //                     ++res;
        //                 }
        //         }
        //         while (!s.isEmpty() && ((s.peek().cnt == 1 && s.peek().app) || s.peek().cnt > 1)) {
        //             s.pop();
        //             ++res;
        //         }
        //     }
        //     return res*2;
        // }


        // class Edge {
        //     int i;
        //     int j;
        //     public Edge(int a, int b) {
        //         i = a;
        //         j = b;
        //     }
        // }
        // private void dfsTraversealTree(List<Boolean> apple, int idx, List<Edge> l) {
        //     vis[idx] = true;
        //     if (apple.get(idx)) 
        //         se.addAll(l);
        //     if (ll.get(idx).size() == 1 && vis[ll.get(idx).get(0)]) return;
        //     int v = 0;
        //     for (int i = 0; i < ll.get(idx).size(); i++) {
        //         v = ll.get(idx).get(i);
        //         if (vis[v]) continue;
        //         l.add(new Edge(idx, v));
        //         dfsTraversealTree(apple, v, l);
        //         l.remove(l.size()-1);
        //     }
        // }
        // Set<Edge> se = new HashSet<>();
        // boolean [] vis;
        // List<List<Integer>> ll = new ArrayList<>();
        // public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l = new ArrayList<>();
        //         ll.add(l);
        //     }
        //     for (int i = 0; i < edges.length; i++) {
        //         ll.get(edges[i][0]).add(edges[i][1]);
        //         ll.get(edges[i][1]).add(edges[i][0]);
        //     }
        //     vis = new boolean [n];
        //     dfsTraversealTree(hasApple, 0, new ArrayList<Edge>());
        //     return se.size() * 2;
        // }

        
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] a = new int [][] {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
Boolean[]  b = new Boolean[]  {false, false, true, false, false, true, false};

        // Boolean [] b = new Boolean [] {false, false, true, false, true, true, false};

        List<Boolean> bb = new ArrayList<>();
        for (int i = 0; i < b.length; i++) 
            bb.add(b[i]);
        
        int res = s.minTime(7, a, bb);
        System.out.println("res: " + res);
    }
}

// m = map.entrySet().stream() 
//     .sorted(Comparator.comparingInt(e -> e.getValue().size()))
//     .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> { throw new AssertionError(); }, LinkedHashMap::new));
