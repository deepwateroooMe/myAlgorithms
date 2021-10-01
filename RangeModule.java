import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class RangeModule {

    // private class Node {
    //     private int bgn;
    //     private int end;
    //     private int sum;
    //     private Node left;
    //     private Node right;
    //     public Node(int bgn, int end, int sum, Node left, Node right) {
    //         this.bgn = bgn;
    //         this.end = end;
    //         this.sum = sum;
    //         this.left = left;
    //         this.right = right;
    //     }
    //     public Node(int a, int b) {
    //         this.bgn = a;
    //         this.end = b;
    //     }
    //     public Node(Node r, int[] nums) {
    //         root = r;
    //         buildTree(r, nums, 0, nums.length-1);
    //         levelPrintTree(root); 
    //     }
    
    //     public void update(int index, int val) {
    //         updateTree(root, index, val);
    //     }
    //     // public int sumRange(int left, int right) {
    //     //     return sumRangeFromTree(root, left, right);
    //     // }
    //     // private int sumRangeFromTree(Node r, int i, int j) {
    //     //     if (r == null || j < r.bgn || i > r.end) return 0;
    //     //     else if (i <= r.bgn && j >= r.end) return r.sum;
    //     //     else {
    //     //         return sumRangeFromTree(r.left, i, j) + sumRangeFromTree(r.right, i, j);
    //     //     }
    //     // }
    //     private void updateTree(Node r, int i, int va) {
    //         if (r == null || i < r.bgn || i > r.end) return;
    //         else if (r.bgn == r.end && r.bgn == i) r.sum = va; // 需要更新的节点是根本身，整棵树只有一个节点
    //         else {
    //             updateTree(r.left, i, va);
    //             updateTree(r.right, i, va);
    //             int sum = 0;
    //             if (r.left != null) sum += r.left.sum;
    //             if (r.right != null) sum += r.right.sum;
    //             r.sum = sum;
    //         }
    //     }
    //     private Node buildTree(int [] arr, int i, int j) { // i : start; j : end
    //         if (i > j) return null;
    //         else if (i == j)
    //             return new Node(i, i, arr[i], null, null);
    //         else {
    //             int mid = i + (j-i)/2;
    //             Node left = buildTree(arr, i, mid);
    //             Node right = buildTree(arr, mid+1, j);
    //             int sum = left.sum;
    //             if (right != null) sum += right.sum;
    //             return new Node(i, j, sum, left, right);
    //         }
    //     }
    //     private void insertNode(int i, int j) {
    //         insertNodeRecursiont(root, i, j);
    //     }
    //     private void insertNodeRecursiont(Node r, int i, int j) {
    //         if (r == null && root == null) {
    //             root = new Node(i, j);
    //             return;
    //         }
    //     }

    // public void levelPrintTree(Node root) {
    //     Node tmp = root;
    //     Queue<Node> queue = new LinkedList<Node>();
    //     queue.add(tmp);
    //     System.out.println("\nTREE Level order traversal: \n");
    //     System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.sum + "}  -> root\n");
    //     System.out.print("    ");
    //     Node curr;
    //     int levelCnt = 1;
    //     int recnt = 0, tmpcnt = 0;
    //     while (!queue.isEmpty()) {
    //         while (recnt < levelCnt) {
    //             curr = queue.poll();
    //             ++recnt;
    //             if (curr.left != null) {
    //                 queue.add(curr.left);
    //                 System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.sum + "}");
    //                 // System.out.print(curr.left.val + ", ");
    //                 ++tmpcnt;
    //             } else
    //                 System.out.print("#.");
    //             if (curr.right != null) {
    //                 queue.add(curr.right);
    //                 System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.sum + "}");
    //                 // System.out.print(curr.right.val + ", ");
    //                 ++tmpcnt;
    //             } else
    //                 System.out.print("#| ");
    //         }
    //         System.out.print(" -> \n");
    //         levelCnt = tmpcnt;
    //         tmpcnt = 0;
    //         recnt = 0;
    //     }
    //     System.out.println("");
    // }
    // }
    // private Node root;
    // root = null;


    // public int createSortedArray(int[] instructions) {
    //     int n = instructions.length;
    //     long res = 0;
    //     Arrays.fill(tree, 0);
    //     for (int i = 0; i < n; i++) {
    //         //              严格小于此数的个数 严格大于此数的个数： 为总个数（不含自己） - 小于自己的个数
    //         res += Math.min(getSum(instructions[i]-1), i-getSum(instructions[i])); 
    //         update(instructions[i], 1);
    //     }
    //     return (int)(res % ((int)Math.pow(10, 9) + 7));
    // }
    // public int lowbit(int i) {
    //     return i & -i;
    // }
    // public void update(int i, int v) { // 更新父节点
    //     while (i <= N) {
    //         tree[i] += v;
    //         i += lowbit(i);
    //     }
    // }
    // public int getSum(int i) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, i]的和，1-based
    //     int ans = 0;
    //     while (i > 0) {
    //         ans += tree[i];
    //         i -= lowbit(i);
    //     }
    //     return ans;
    // }
    
    // private static int N = 1000000001;
    // private static int [] tree = new int [N]; // 拿元素值作为 key 对应 tree 的下标值
    // public RangeModule() {
    // }
    // public void addRange(int left, int right) {
    //     for (int i = left; i < right; i++) {
    //         update(i, 1);
    //     }
    //     // if (m.size() == 0)
    //     //     m.put(left, right);
    //     // else {
    //     //     int max = 0;
    //     //     for (Integer key : m.keySet()) 
    //     //         if (key <= left) max = Math.max(max, key);
    //     //     if (m.get(max) < right) {
    //     //         if (max < left && m.get(max) < left)
    //     //             m.put(left, right);
    //     //         else
    //     //             m.put(max, right);
    //     //     }
    //     // }
    // }
    // public boolean queryRange(int left, int right) {
    //     for (int i = left; i < right; i++) 
    //         if (tree[i] == 0) return false;
    //     return true;
    //     // int max = 0;
    //     // for (Integer key : m.keySet()) 
    //     //     if (key <= left) max = Math.max(max, key);
    //     // if (m.containsKey(max) && m.get(max) >= right) return true;
    //     // return false;
    // }
    // public void removeRange(int left, int right) {
    //     for (int i = left; i < right; i++) {
    //         update(i, 0);
    //     }
    //     // int max = 0;
    //     // int min = 1000000000;
    //     // for (Integer key : m.keySet()) {
    //     //     if (key <= left) max = Math.max(max, key);
    //     //     // if (key >= left) min = Math.min(min, key);
    //     // }
    //     // for (Map.Entry<Integer, Integer> entry : m.entrySet()) { // 值<=右边的最大键
    //     //     if (key >= left && m.get(key) <= right) min = Math.max(min, key);
    //     // }
    //     // System.out.println("max: " + max);
    //     // System.out.println("min: " + min);

    //     // if (min >= right) {
    //     //     if (m.get(max) <= right) {
    //     //         if (max > left) { // 有交差
    //     //             int tmp = m.get(max);
    //     //             if (max == left) m.put(tmp, right);
    //     //             else m.put(max, left);
    //     //         }
    //     //     } else { // prev-right > right
    //     //         m.put(right, m.get(max));
    //     //         if (max < left) 
    //     //             m.put(max, left);
    //     //     }
    //     // }
    //     // }
    // // https://www.codeleading.com/article/56643289441/
    // // https://blog.csdn.net/magicbean2/article/details/79327658
    // // http://bookshadow.com/weblog/2017/10/22/leetcode-range-module/
    // // https://leetcode-cn.com/problems/range-module/solution/xian-duan-shu-mo-gai-ban-by-levyjeng/

    class Range {
        int left, right;
        public Range(int left, int right) {
            this.left = left;
            this.right = right;
        }
        public String toString() {
            return "Range(" + left + "," + right + ")";
        }
    }
    TreeSet<Range> ts;
    public RangeModule() {
        ts = new TreeSet<>(new Comparator<Range>() {
                @Override public int compare(Range one, Range two) {
                    if (one.left == two.left) {
                        return one.right - two.right;
                    }
                    return one.left - two.left;
                }
            });
    }
    public void addRange(int left, int right) {
        int nl = left, nr = right;
        Range high = new Range(right, Integer.MAX_VALUE);
        while (true) {
            Range r = ts.lower(high);
            if (r == null || r.right < left) break;
            if (r.right > right) nr = r.right;
            if (r.left < left) nl = r.left;
            ts.remove(r);
        }
        ts.add(new Range(nl, nr));
    }
    public boolean queryRange(int left, int right) {
        Range target = ts.floor(new Range(left, Integer.MAX_VALUE));
        return target != null && target.left <= left && target.right >= right;
    }
    public void removeRange(int left, int right) {
        Range high = new Range(right, right);
        while (true) {
            Range r = ts.lower(high);
            if (r == null || r.right <= left) break;
            if (r.right > right)
                ts.add(new Range(right, r.right));
            if (r.left < left)
                ts.add(new Range(r.left, left));
            ts.remove(r);
        }
    }
         
    public static void main(String[] args) {
        RangeModule s = new RangeModule();

        s.addRange(5, 8);

        boolean r = s.queryRange(3, 4);
        System.out.println("r: " + r);

        s.removeRange(5, 6);
        s.removeRange(3, 6);

        // s.addRange(1, 3);

        // boolean r1 = s.queryRange(2, 3);
        // System.out.println("r1: " + r1);

        // s.addRange(4, 8);
        
        // boolean r2 = s.queryRange(2, 3);
        // System.out.println("r2: " + r2);

        // s.removeRange(4, 9);

        // ["RangeModule","addRange","queryRange","removeRange","removeRange","addRange","queryRange","addRange","queryRange","removeRange"]
        //     [[],        [5,8],     [3,4],       [5,6],        [3,6],        [1,3],    [2,3],        [4,8],     [2,3],     [4,9]]
            
        // ["RangeModule","addRange","addRange","addRange",   "queryRange","queryRange","queryRange","removeRange","queryRange"]
        //     [[]        ,[10,180]  ,[150,200], [250,500],    [50,100],    [180,300],   [600,1000],[50,150],[50,100]]
            
        // ["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]
        //     [[],          [10, 20],  [14, 16],      [10, 14],      [13, 15],    [16, 17]]
     }
}
