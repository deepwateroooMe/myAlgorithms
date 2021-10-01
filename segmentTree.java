// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class segmentTree {
    public static class Solution {

        // public class SegTree {
        //     private class Node {
        //         private int bgn;
        //         private int end;
        //         private int sum;
        //         private Node left;
        //         private Node right;
        //         public Node(int bgn, int end, int sum, Node left, Node right) {
        //             this.bgn = bgn;
        //             this.end = end;
        //             this.sum = sum;
        //             this.left = left;
        //             this.right = right;
        //         }
        //     }
        //     private Node root;
        //     public NumArray(int[] nums) {
        //         root = buildTree(nums, 0, nums.length-1);
        //     }
        //     public void update(int index, int val) {
        //         updateTree(root, index, val);
        //     }
        //     public int sumRange(int left, int right) {
        //         return sumRangeFromTree(root, left, right);
        //     }
        //     private int sumRangeFromTree(Node r, int i, int j) {
        //         if (r == null || i < r.bgn || i > r.eng) return 0;
        //         else if (i <= r.bgn && j >= r.end) return r.sum;
        //         else {
        //             return sumRangeFromTree(r.left, i, j) + sumRangeFromTree(r.right, i, j);
        //         }
        //     }
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
        //     private void buildTree(int [] arr, int i, int j) { // i : start; j : end
        //         if (i > j) return null;
        //         else if (i == j)
        //             return new Node(i, i, arr[i], null, null);
        //         else {
        //             int mid = i + (j-1)/2;
        //             Node left = buildTree(arr, i, mid);
        //             Node right = buildTree(arr, mid+1, j);
        //             int sum = left.sum;
        //             if (right != null) sum += right.sum;
        //             return new Node(i, j, sum, left, right);
        //         }
        //     }

        //     public void levelPrintTree(Node root) {
        //         Node tmp = root;
        //         Queue<Node> queue = new LinkedList<Node>();
        //         queue.add(tmp);
        //         System.out.println("\nTREE Level order traversal: \n");
        //         System.out.print("                  {[" + tmp.scnt + "," + tmp.dcnt + ")," + tmp.val + "}  -> root\n");
        //         System.out.print("    ");
        //         Node curr;
        //         int levelCnt = 1;
        //         int recnt = 0, tmpcnt = 0;
        //         while (!queue.isEmpty()) {
        //             while (recnt < levelCnt) {
        //                 curr = queue.poll();
        //                 ++recnt;
        //                 if (curr.left != null) {
        //                     queue.add(curr.left);
        //                     System.out.print("      {[" + curr.left.scnt + "," + curr.left.dcnt + ")," + curr.left.val + "}");
        //                     ++tmpcnt;
        //                 } else
        //                     System.out.print("#.");
        //                 if (curr.right != null) {
        //                     queue.add(curr.right);
        //                     System.out.print("      {[" + curr.right.scnt + "," + curr.right.dcnt + ")," + curr.right.val + "}");
        //                     ++tmpcnt;
        //                 } else
        //                     System.out.print("#| ");
        //             }
        //             System.out.print(" -> \n");
        //             levelCnt = tmpcnt;
        //             tmpcnt = 0;
        //             recnt = 0;
        //         }
        //         System.out.println("");
        //     }
        // }
        
        // private class Node {
        //     int val;
        //     int scnt;
        //     int dcnt;
        //     Node left;
        //     Node right;
        //     public Node (int val) {
        //         this.val = val;
        //         this.scnt = 0;
        //         this.dcnt = 1;
        //         this.left = null;
        //         this.right = null; 
        //     }
        // }
        // 分治法。 https://blog.csdn.net/jmspan/article/details/51219203
        // 思路：从大到小合并左右已排序的两段，根据右边剩余，来个左边元素对应的counts[ ],但是，排序后元素的位置要变化，就不能追踪某个元素的逆序数和其开始对应的位置了。这就自然想到一个数组pos[ ]排名和开始的位置建立联系。
        //     此方法类似归并排序，但不用创建新数组就行排序，只在pos[ ]更新排名和位置的信息即可，参考https://blog.csdn.net/jmspan/article/details/51219203
        //     1.类似归并排序，因为归并排序要改变元素位置，无法追踪每个元素对应的值，
        //         2.每次排序记录一个排名和位置的映射，pos[i]=j排名第i对应原位置j,能通过位置j在找到原值nums[j]，j能代表原值。
        //         3.每次归并时，只是对应两个已排序的区间，pos[i]记录这个区间的排序信息，不用真的定义一个数组排序。
        //         时间复杂度O（nlog n）
        // public List<Integer> countSmaller(int[] nums) {
        //     List<Integer> list=new ArrayList<>();
        //     if(nums==null||nums.length==0) return list;
        //     int[] pos=new int[nums.length];
        //     int[] counts=new int[nums.length];
        //     for(int i=0;i<nums.length;i++) pos[i]=i;//排名的初始化赋值
        //     sort(nums,counts,pos,0,nums.length-1);
        //     for(int count:counts) {
        //         list.add(count);
        //     }
        //     return list;
        // }
        // public void sort(int[] nums,int[] counts,int[] pos,int l,int r){
        //     if(l==r) return;
        //     int m=(l+r)/2;
        //     sort(nums,counts,pos,l,m);
        //     sort(nums,counts,pos,m+1,r);
        //     //统计count根据右边那个子数组剩余,更新pos[],根据[l,m]区间从大到小
        //     int[] temp=new int[r-l+1];//总数组的新排名
        //     int lc=l,rc=m+1,t=0;
        //     while(lc<=m&&rc<=r){
        //         if(nums[pos[lc]]<nums[pos[rc]]){
        //             temp[t++]=pos[rc++];
        //         }else if(nums[pos[lc]]>nums[pos[rc]]){
        //             //更新counts,因为左边大于右边，是逆序,加上右边剩余的数，右边顺序已经打乱，但是在一个子区间内。
        //             counts[pos[lc]]+=(r-rc+1);//pos[lc]:排名和位置的映射
        //             temp[t++]=pos[lc++];
        //         }else{//相等先存右边
        //             temp[t++]=pos[rc++];
        //         }
        //     }
        //     //剩余元素存进新排名
        //     while(lc<=m) temp[t++]=pos[lc++];
        //     while(rc<=r) temp[t++]=pos[rc++];   
        //     //新一轮的位置信息存在了temp中，更新pos
        //     for(int i=0;i<temp.length;i++) pos[l+i]=temp[i];
        // }
        // private void sort(int[] nums, int[] smaller, int[] pos, int from, int to) {
        //     if (from >= to) return;
        //     int m = (from + to) / 2;
        //     sort(nums, smaller, pos, from, m);
        //     sort(nums, smaller, pos, m+1, to);
        //     int[] merged = new int[to-from+1];
        //     int i=from, j=m+1, k=0, jump = 0;
        //     while (i<=m || j<=to) {
        //         if (i>m) {
        //             jump ++;
        //             merged[k++] = pos[j++];
        //         } else if (j>to) {
        //             smaller[pos[i]] += jump;
        //             merged[k++] = pos[i++];
        //         } else if (nums[pos[i]] <= nums[pos[j]]) {
        //             smaller[pos[i]] += jump;
        //             merged[k++] = pos[i++];
        //         } else {
        //             jump ++;
        //             merged[k++] = pos[j++];
        //         }
        //     }
        //     for(int p=0; p<merged.length; p++) pos[from+p] = merged[p];
        // }
        // public List<Integer> countSmaller(int[] nums) {
        //     int[] smaller = new int[nums.length];
        //     int[] pos = new int[nums.length];
        //     for (int i=0; i<pos.length; i++) pos[i] = i;
        //     sort(nums, smaller, pos, 0, nums.length-1);
        //     List<Integer> result = new ArrayList<>(nums.length);
        //     for(int i=0; i<nums.length; i++) result.add(smaller[i]);
        //     return result;
        // }
        // // Node root;
        // public List<Integer> countSmaller(int[] nums) {
        //     int[] smaller = new int[nums.length];
        //     for(int i = nums.length-2; i>=0; i--) {
        //         int left = i+1;
        //         int right = nums.length-1;
        //         while (left<=right) {
        //             int m = (left+right)/2;
        //             if (nums[i] > nums[m]) right = m - 1;
        //             else left = m + 1;
        //         }
        //         smaller[i] = nums.length - left;
        //         int temp = nums[i];
        //         for(int j=i; j<right; j++) nums[j] = nums[j+1];
        //         nums[right] = temp;
        //     }
        //     List<Integer> results = new ArrayList<>(nums.length);
        //     for(int i=0; i<smaller.length; i++) results.add(smaller[i]);
        //     return results;
        // }
        // public List<Integer> countSmaller(int[] nums) {
        //     List<Integer> res = new ArrayList<>();
        //     int n = nums.length;
        //     if (n == 1) {
        //         res.add(0);
        //         return res;
        //     }
        //     Node root = new Node(nums[n-1]);
        //     res.add(0);
        //     Node r = null;
        //     int val = 0;
        //     for (int i = n-2; i >= 0; i--) {
        //         int c = 0;
        //         r = root;
        //         val = nums[i];
        //         while (true) {
        //             if (r.val < val) {
        //                 c += r.scnt + r.dcnt;
        //                 if (r.right == null) {
        //                     r.right = new Node(val);
        //                     break;
        //                 }
        //                 r = r.right;
        //             } else if (r.val == val) {
        //                 r.dcnt++;
        //                 c += r.scnt;
        //                 break;
        //             } else { // r.val > val
        //                 r.scnt++;
        //                 if (r.left == null) {
        //                     r.left = new Node(val);
        //                     break;
        //                 }
        //                 r = r.left;
        //             }
        //         }
        //         res.add(0, c);
        //     }
        //     return res;
        // }
        // private int insertIntoTreeNode(Node r, int val) {
        //     if (r.val == val) {
        //         r.dcnt++;
        //         return r.scnt;
        //     } else if (r.val < val) {
        //         if (r.right == null) {
        //             Node right = new Node(val);
        //             r.right = right;
        //             // right.scnt = r.scnt + r.dcnt;
        //             // return right.scnt;
        //             return r.scnt + r.dcnt;
        //         } else
        //             return r.scnt + r.dcnt + insertIntoTreeNode(r.right, val); 
        //     } else { // if (val < r.val) {
        //         if (r.left == null) {
        //             Node left = new Node(val);
        //             r.left = left;
        //             r.scnt++; // 从根节点到左r节点 + 从根节点到根右所有节点需要更新
        //             return 0;
        //         } else {
        //             r.scnt++;
        //             return insertIntoTreeNode(r.left, val);
        //         }
        //     }
        // }
        // public List<Integer> countSmaller(int[] nums) {
        //     List<Integer> res = new ArrayList<>();
        //     int n = nums.length;
        //     if (n == 1) {
        //         res.add(0);
        //         return res;
        //     }
        //     res.add(0);
        //     root = new Node(nums[n-1]);
        //     for (int i = n-2; i >= 0; i--) {
        //         res.add(0, insertIntoTreeNode(root, nums[i]));
        //     }
        //     // levelPrintTree(root);
        //     return res;
        // }

        
        // public void levelPrintTree(Node root) {
        //     Node tmp = root;
        //     Queue<Node> queue = new LinkedList<Node>();
        //     queue.add(tmp);
        //     System.out.println("\nTREE Level order traversal: \n");
        //     System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.ht + "}  -> root\n");
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
        //                 System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.ht + "}");
        //                 // System.out.print(curr.left.val + ", ");
        //                 ++tmpcnt;
        //             } else
        //                 System.out.print("#.");
        //             if (curr.right != null) {
        //                 queue.add(curr.right);
        //                 System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.ht + "}");
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
        // private class Node {
        //     private int bgn;
        //     private int end;
        //     private int ht;
        //     private Node left;
        //     private Node right;
        //     public Node(int bgn, int end, int ht, Node left, Node right) {
        //         this.bgn = bgn;
        //         this.end = end;
        //         this.ht = ht;
        //         this.left = left;
        //         this.right = right;
        //     }
        // }
        // private Node root;
        // public void update(int index, int val) {
        //     updateTree(root, index, val);
        // }
        // // public int htRange(int left, int right) {
        // //     return htRangeFromTree(root, left, right);
        // // }
        // // private int htRangeFromTree(Node r, int i, int j) {
        // //     if (r == null || i < r.bgn || i > r.end) return 0;
        // //     else if (i <= r.bgn && j >= r.end) return r.ht;
        // //     else {
        // //         return htRangeFromTree(r.left, i, j) + htRangeFromTree(r.right, i, j);
        // //     }
        // // }
        // private void updateTree(Node r, int i, int va) {
        //     if (r == null || i < r.bgn || i > r.end) return;
        //     else if (r.bgn == r.end && r.bgn == i) r.ht = va; // 需要更新的节点是根本身，整棵树只有一个节点
        //     else {
        //         updateTree(r.left, i, va);
        //         updateTree(r.right, i, va);
        //         int ht = 0;
        //         if (r.left != null) ht = r.left.ht;
        //         if (r.right != null) ht = Math.max(ht, r.right.ht);
        //         r.ht = ht;
        //     }
        // }
        // private Node buildTree(int [][] arr, int i, int j, boolean sep) {
        //     if (!sep) return null;
        //     if (arr[i][2] <= arr[j][1]) {
        //         Node left = new Node(arr[i][0], arr[i][1], arr[i][2], null, null);
        //         Node right = new Node(arr[j][0], arr[j][1], arr[j][2], null, null);
        //         return new Node(Math.min(arr[i][0], arr[j][0]), Math.max(arr[i][1], arr[j][1]), Math.max(left.ht, right.ht), left, right);
        //     } else { // arr[j][1] < arr[i][2]
        //         Node left = new Node(arr[i][0], arr[i][2] <= arr[j][2] ? arr[j][1] : arr[i][1], arr[i][2], null, null);
        //         Node right = new Node(arr[i][2], arr[i][2] <= arr[j][2] ? arr[j][1] : arr[i][1], arr[j][2], null, null);
        //         return new Node(Math.min(arr[i][0], arr[j][0]), Math.max(arr[i][1], arr[j][1]), Math.max(left.ht, right.ht), left, right);
        //     }
        // }
        // private Node buildTree(int [][] arr, int i, int j) { // i : start; j : end
        //     if (i > j) return null;
        //     else if (i == j)
        //         return new Node(arr[i][0], arr[i][1], arr[i][2], null, null);
        //     else if (i == j-1) {
        //         return buildTree(arr, i, j, true);
        //         // Node left = new Node(arr[i][0], arr[i][1], arr[i][2], null, null);
        //         // Node right = new Node(arr[j][0], arr[j][1], arr[j][2], null, null);
        //         // return new Node(Math.min(arr[i][0], arr[j][0]), Math.max(arr[i][1], arr[j][1]), Math.max(left.ht, right.ht), left, right);
        //     } else {
        //         int mid = i + (j-1)/2;
        //         // if (arr[mid][1] <= arr[mid+1][0]) {
        //             Node left = buildTree(arr, i, mid);
        //             Node right = buildTree(arr, mid+1, j);
        //             int ht = left.ht;
        //             if (right != null) ht = Math.max(ht, right.ht);
        //             return new Node(Math.min(arr[i][0], arr[j][0]), Math.max(arr[i][1], arr[j][1]), ht, left, right);
        //         // } else {
                    
        //         // }
                
        //     }
        //     // if (i > j) return null;
        //     // else if (i == j)
        //     //     return new Node(i, i, arr[i][2], null, null);
        //     // else if (i == j-1) {
        //     //     Node left = new Node(i, i, arr[i][2], null, null);
        //     //     Node right = new Node(j, j, arr[j][2], null, null);
        //     //     return new Node(i, j, Math.max(left.ht, right.ht), left, right);
        //     // } else {
        //     //     int mid = i + (j-1)/2;
        //     //     System.out.println("mid: " + mid);
        //     //     Node left = buildTree(arr, i, mid);
        //     //     Node right = buildTree(arr, mid+1, j);
        //     //     int ht = left.ht;
        //     //     if (right != null) ht = Math.max(ht, right.ht);
        //     //     return new Node(i, j, ht, left, right);
        //     // }
        // }
        // public List<List<Integer>> getSkyline(int[][] buildings) {
        //     int n = buildings.length;
        //     root = buildTree(buildings, 0, n-1);
        //     levelPrintTree(root);

        //     List<List<Integer>> res = new ArrayList<>();
        //     return res;
        // }


        // public int lengthOfLIS(int[] nums) {
        //     int n = nums.length;
        //     int [] arr = new int[n];
        //     Arrays.fill(arr, 1);
        //     int max = 1;
        //     for (int i = 1; i < n; i++) {
        //         for (int j = 0; j < i; j++) {
        //             if (nums[j] < nums[i])
        //                 arr[i] = Math.max(arr[i], arr[j] + 1);
        //         }
        //         max = Math.max(max, arr[i]);
        //     }
        //     return max;
        // }
        // public int lengthOfLIS(int[] nums) {
        //     int n = nums.length;
        //     List<Integer> l = new ArrayList<>();
        //     l.add(nums[0]);
        //     for (int i = 1; i < n; i++) {
        //         if (nums[i] > l.get(l.size()-1)) l.add(nums[i]);
        //         else {
        //             // 反之二分查找到第一个大于等于当前数字的元素
        //             int bgn = 0, end = l.size()-1;
        //             while (bgn < end) {
        //                 int mid = bgn + (end - bgn) / 2;
        //                 if (l.get(mid) >= nums[i]) { // === ?
        //                     end = mid -1;
        //                 } else bgn = mid + 1;
        //             }
        //             l.set(bgn, nums[i]);
        //         }
        //     }
        //     return l.size();
        // }

    // https://massivealgorithms.blogspot.com/2018/05/leetcode-673-number-of-longest.html
        // public int findNumberOfLIS(int[] nums) {
        //     int n = nums.length;
        //     int [][] arr = new int[n][n];
        //     for (int i = 0; i < n; i++) 
        //         Arrays.fill(arr[i], 1);
        //     for (int i = 1; i < n; i++) {
        //         if ()
        //         for (int j = 0; j < i; j++) {
        //             if (nums[j] < nums[i])
        //                 arr[i] = Math.max(arr[i], arr[j] + 1);
        //         }
        //         max = Math.max(max, arr[i]);
        //         }
        //         return max;
        // }

        // public class SegTree {
        //     public void levelPrintTree() {
        //         Node tmp = root;
        //         Queue<Node> queue = new LinkedList<Node>();
        //         queue.add(tmp);
        //         System.out.println("\nTREE Level order traversal: \n");
        //         System.out.print("                  {[" + tmp.bgn + "," + tmp.end + ")," + tmp.cnt + "}  -> root\n");
        //         System.out.print("    ");
        //         Node curr;
        //         int levelCnt = 1;
        //         int recnt = 0, tmpcnt = 0;
        //         while (!queue.isEmpty()) {
        //             while (recnt < levelCnt) {
        //                 curr = queue.poll();
        //                 ++recnt;
        //                 if (curr.left != null) {
        //                     queue.add(curr.left);
        //                     System.out.print("      {[" + curr.left.bgn + "," + curr.left.end + ")," + curr.left.cnt + "}");
        //                     ++tmpcnt;
        //                 } else
        //                     System.out.print("[#####]");
        //                 if (curr.right != null) {
        //                     queue.add(curr.right);
        //                     System.out.print("      {[" + curr.right.bgn + "," + curr.right.end + ")," + curr.right.cnt + "}");
        //                     ++tmpcnt;
        //                 } else
        //                     System.out.print("[#####] | ");
        //             }
        //             System.out.print(" -> \n");
        //             levelCnt = tmpcnt;
        //             tmpcnt = 0;
        //             recnt = 0;
        //         }
        //         System.out.println("");
        //     }
        //     private class Node {
        //         private int bgn;
        //         private int end;
        //         private int val;
        //         private int cnt;
        //         private Node left;
        //         private Node right;
        //         public Node(int bgn, int end, int val, int cnt) {
        //             this.bgn = bgn;
        //             this.end = end;
        //             this.val = val;
        //             this.cnt = cnt;
        //             this.left = null;
        //             this.right = null;
        //         }
        //         public Node(int bgn, int end, int val, int cnt, Node left, Node right) {
        //             this.bgn = bgn;
        //             this.end = end;
        //             this.val = val;
        //             this.cnt = cnt;
        //             this.left = left;
        //             this.right = right;
        //         }
        //     }
        //     private Node root;
        //     public SegTree(int[] nums) {
        //         root = buildTree(nums, 0, nums.length-1);
        //     }
        //     // public void update(int index, int val) {
        //     //     updateTree(root, index, val);
        //     // }
        //     // public int cntRange(int left, int right) {
        //     //     return cntRangeFromTree(root, left, right);
        //     // }
        //     // private int cntRangeFromTree(Node r, int i, int j) {
        //     //     if (r == null || i < r.bgn || i > r.end) return 0;
        //     //     else if (i <= r.bgn && j >= r.end) return r.cnt;
        //     //     else return cntRangeFromTree(r.left, i, j) + cntRangeFromTree(r.right, i, j);
        //     // }
        //     // private void updateTree(Node r, int i, int va) {
        //     //     if (r == null || i < r.bgn || i > r.end) return;
        //     //     else if (r.bgn == r.end && r.bgn == i) r.cnt = va; // 需要更新的节点是根本身，整棵树只有一个节点
        //     //     else {
        //     //         updateTree(r.left, i, va);
        //     //         updateTree(r.right, i, va);
        //     //         int cnt = 0;
        //     //         if (r.left != null) cnt += r.left.cnt;
        //     //         if (r.right != null) cnt += r.right.cnt;
        //     //         r.cnt = cnt;
        //     //     }
        //     // }
        //     // private Node buildTree(int [] arr, int i, int j) { // i : start; j : end
        //     //     if (i > j) return null;
        //     //     else if (i == j)
        //     //         return new Node(i, i, arr[i], null, null);
        //     //     else if (i + 1 == j) {
        //     //         Node pare = new Node(i, j, arr[i] + arr[j], null, null);
        //     //         Node left = new Node(i, i, arr[i], null, null);
        //     //         Node right = new Node(j, j, arr[j], null, null);
        //     //         pare.left = left;
        //     //         pare.right = right;
        //     //         return pare;
        //     //     } else {
        //     //         int mid = i + (j-1)/2;
        //     //         Node left = buildTree(arr, i, mid);
        //     //         Node right = buildTree(arr, mid+1, j);
        //     //         int cnt = left.cnt;
        //     //         if (right != null) cnt += right.cnt;
        //     //         return new Node(i, j, cnt, left, right);
        //     //     }
        //     // }

        //     //  rec1 [x1 y1 x2 y2]
        //     //  rec2 [x1 y1 x2 y2]
        //     // public boolean isRectangleOverlap(int[] rec1, int[] rec2) { 
        //     // public boolean isRectangleOverlap(int[] aa, int[] bb) { 
        //     //     if (bb[0] >= aa[0] && bb[0] < aa[2]
        //     //             && ((bb[1] >= aa[1] && bb[1] < aa[3])
        //     //                 || (bb[1] <= aa[1] && bb[3] <= aa[3]))) return true;
        //     //     if (bb[0] <= aa[0] && bb[2] > aa[0]
        //     //         && ((bb[1] <= aa[1] && bb[3] > aa[1])
        //     //             || (bb[1] >= aa[1] && bb[1] < aa[3]))) return true;
        //     //     return false;
        //     // }
        // }

        
        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int []  a = new int []  {1, 3, -1, -3, 5, 3, 6, 7};

        int [] res = s.maxSlidingWindow(a, 3);
        System.out.println("res.length: " + res.length);
        for (int z = 0; z < res.length; ++z) 
            System.out.print(res[z] + ", ");
        System.out.println("");
    }
}