import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import static java.util.stream.Collectors.toMap;

public class cmp {
    public static class Solution {
// public int[] sortEvenOdd(int[] a) {
//     int n = a.length;
//     List<Integer> od = new ArrayList<>();
//     List<Integer> en = new ArrayList<>();
//     for (int i = 0; i < n; i++) 
//         if (i % 2 == 0)
//             en.add(a[i]);
//         else od.add(a[i]);
//     Collections.sort(od, (x, y)->y-x);
//     Collections.sort(en, (x, y)->x-y);
//     int i = 0, j = 0, m = en.size(), o = od.size(), idx = 0;
//     while (i < m || j < o) {
//         while (i < m && j < o) {
//             a[idx++] = en.get(i++);
//             a[idx++] = od.get(j++);
//         }
//         if (i < m)
//             a[idx++] = en.get(i++);
//         else if (j < o)
//             a[idx++] = od.get(j++);
//     }
//     return a;
// }
// public long smallestNumber(long num) {
//     if (num == 0) return 0;
//     if (num > 0) return getLow(String.valueOf(num));
//     return -getHi(String.valueOf(-num));
// }
// long getLow(String t) {
//     int n = t.length(), i = 0;
//     char [] s = t.toCharArray();
//     Arrays.sort(s);
//     while (i < n && s[i] == '0') i++;
//     swap(i, 0, s);
//     return Long.parseLong(new String(s));
// }
// long getHi(String t) {
//     int n = t.length();
//     char [] s = t.toCharArray();
//     Arrays.sort(s);
//     StringBuilder sb = new StringBuilder();
//     for (int i = n-1; i >= 0; i--) 
//         sb.append(s[i]);
//     return Long.parseLong(new String(sb));
// }
// void swap(int i, int j, char [] s) {
//     char c = s[i];
//     s[i] = s[j];
//     s[j] = c;
// }

// class cmp { // tle
        // int n, sum = 0;
        // char [] a;
        // public Bitset(int size) { // tle
        //     // public cmp(int size) {
        //     n = size;
        //     a = new char [n];
        //     Arrays.fill(a, '0');
        // }
        // public void fix(int idx) {
        //     if (a[idx] == '0') {
        //         sum += 1;
        //         a[idx] = '1';
        //     }
        //     System.out.println(Arrays.toString(a));
        // }
        // public void unfix(int idx) {
        //     if (a[idx] == '1') {
        //         sum -= 1;
        //         a[idx] = '0';
        //     }
        //     System.out.println(Arrays.toString(a));
        // }
        // public void flip() {  这里的操作比较慢，需要线段树懒更新的方式
        //         sum = n - sum;
        //     for (int i = 0; i < n; i++) 
        //         if (a[i] == '0') a[i]= '1';
        //         else a[i] = '0';
        //     System.out.println(Arrays.toString(a));
        // }
        // public boolean all() {
        //     return sum == n;
        // }
        // public boolean one() {
        //     return sum > 0;
        // }
        // public int count() {
        //     return sum;
        // }
        // public String toString() {
        //     return new String(a);
        // }
        public SegNode build(int left, int right) {
            SegNode node = new SegNode(left, right);
            if (left == right) {
                return node;
            }
            int mid = (left + right) / 2;
            node.lchild = build(left, mid);
            node.rchild = build(mid + 1, right);
            return node;
        }
        public int count(SegNode root, int left, int right) {
            if (left > root.hi || right < root.lo)
                return 0;
            if (left <= root.lo && root.hi <= right)
                return root.add;
            return count(root.lchild, left, right) + count(root.rchild, left, right);
        }
        public void insert(SegNode root, int val) {
            root.add++;
            if (root.lo == root.hi)
                return;
            int mid = (root.lo + root.hi) / 2;
            if (val <= mid)
                insert(root.lchild, val);
            else insert(root.rchild, val);
        }
        class SegNode {
            int lo, hi, add;
            SegNode lchild, rchild;
            public SegNode(int left, int right) {
                lo = left;
                hi = right;
                add = 0;
                lchild = null;
                rchild = null;
            }
        }

        // public int minimumTime(String t) {
        //     int n = t.length(), i = 0, j = n-1, ans = 0;
        //     char [] s = t.toCharArray();
        //     while (i < n && s[i] == '1') i++;
        //     if (i == n) return i;
        //     while (j >= i && s[j] == '1') j--;
        //     ans = i + (n-1-j);
        //     // System.out.println("i: " + i);
        //     // System.out.println("j: " + j);
        //     if (i == j) return ans;
        //     while (i < j) {
        //         while (i < j && s[i] == '0') i++;
        //         while (j > i && s[j] == '0') j--;
        //         System.out.println("i: " + i);
        //         System.out.println("j: " + j);
        //         while (i <= j && s[i] == '1') {
        //             i++;
        //             ans += 2;
        //         } 
        //     }
        //     return ans;
        // }

//         class SegmentTree {
//             int st[];  
//             SegmentTree(int arr[], int n) {
//                 int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
//                 int max_size = 2 * (int) Math.pow(2, x) - 1;
//                 st = new int[max_size]; // Memory allocation
//                 constructSTUtil(arr, 0, n - 1, 0);
//             }
//             int getMid(int s, int e) {
//                 return s + (e - s) / 2;
//             }
//             int getSumUtil(int ss, int se, int qs, int qe, int si) {
//                 if (qs <= ss && qe >= se)
//                     return st[si];
//                 if (se < qs || ss > qe)
//                     return 0;
//                 int mid = getMid(ss, se);
//                 return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
//                     getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
//             }
//             void updateValueUtil(int ss, int se, int i, int diff, int si) {
//                 if (i < ss || i > se)
//                     return;
//                 st[si] = st[si] + diff;
//                 if (se != ss) {
//                     int mid = getMid(ss, se);
//                     updateValueUtil(ss, mid, i, diff, 2 * si + 1);
//                     updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
//                 }
//             }
//             void updateValue(int arr[], int n, int i, int new_val) {
//                 if (i < 0 || i > n - 1) {
//                     System.out.println("Invalid Input");
//                     return;
//                 }
//                 int diff = new_val - arr[i];
//                 arr[i] = new_val;
//                 updateValueUtil(0, n - 1, i, diff, 0);
//             }
//             int getSum(int n, int qs, int qe) {
//                 if (qs < 0 || qe > n - 1 || qs > qe) {
//                     System.out.println("Invalid Input");
//                     return -1;
//                 }
//                 return getSumUtil(0, n - 1, qs, qe, 0);
//             }
//             int constructSTUtil(int arr[], int ss, int se, int si) {
//                 if (ss == se) {
//                     st[si] = arr[ss];
//                     return arr[ss];
//                 }
//                 int mid = getMid(ss, se);
//                 st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) +
//                     constructSTUtil(arr, mid + 1, se, si * 2 + 2);
//                 return st[si];
//             }
//         }
//         int n, sum;
//         int [] a; // flip cnts
//     SegmentTree st;
//         public Bitset(int size) {
//         // public cmp(int size) {
//             n = size;
//             a = new int [n];
//             st = new SegmentTree(a, n);
//         }
//         public void fix(int idx) {
//             if (a[idx] == 0)
// // a[idx] = 1;
//                 st.updateValue(a, n, idx, 1);
//         }
//         public void unfix(int idx) {
//             if (a[idx] == 1)
// // a[idx] = 1;
//                 st.updateValue(a, n, idx, 0);
//         }
//         public void flip() {
//             for (int i = 0; i < n; i++) 
//                 if (a[i] == 0)
//                     st.updateValue(a, n, i, 1);
//                 else 
//                     st.updateValue(a, n, i, 0);
//         }
//         public boolean all() {
//             return st.getSum(n, 0, n-1) == n;
//         }
//         public boolean one() {
//             return st.getSum(n, 0, n-1) > 0;
//         }
//         public int count() {
//             return st.getSum(n, 0, n-1);
//         }
//         public String toString() {
//             StringBuilder s = new StringBuilder();
//             for (int v : a) 
//                 s.append((char)(v-0 + '0'));
//             return s.toString();
//         }
    
        int n;
        Set<Integer> one = new HashSet<>();
        Set<Integer> zoo = new HashSet<>();
        public Bitset(int size) { // 这个题最开始的思路被自己想偏了。。。。。。
            // public cmp(int size) {
            n = size;
            for (int i = 0; i < n; i++) 
                zoo.add(i);
        }
        public void fix(int idx) {
            one.add(idx);
            zoo.remove(idx);
        }
        public void unfix(int idx) {
            one.remove(idx);
            zoo.add(idx);
        }
        public void flip() {
            Set<Integer> tmp = one;
            one = zoo;
            zoo = tmp;
        }
        public boolean all() {
            return one.size() == n;
        }
        public boolean one() {
            return one.size() > 0;
        }
        public int count() {
            return one.size();
        }
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) 
                if (one.contains(i)) s.append('1');
                else s.append('0');
        
            return s.toString();
        }

    }
    public static void main (String[] args) {
        // Solution s = new Solution ();
        // String a = "1100101";
        // int r = s.minimumTime(a);
        // System.out.println("r: " + r);
        cmp s = new cmp(5); // bitset = "00000".
        s.fix(3);     // the value at idx = 3 is updated to 1, so bitset = "00010".
        s.fix(1);     // the value at idx = 1 is updated to 1, so bitset = "01010". 
        s.flip();     // the value of each bit is flipped, so bitset = "10101". 
        boolean r = s.all();      // return False, as not all values of the bitset are 1.
        System.out.println("r: " + r);
        
        s.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "00101".
        s.flip();     // the value of each bit is flipped, so bitset = "11010". 
        boolean r1 = s.one();      // return True, as there is at least 1 index with value 1.
        System.out.println("r1: " + r1);
        
        s.unfix(0);   // the value at idx = 0 is updated to 0, so bitset = "01010".
        int r2 = s.count();    // return 2, as there are 2 bits with value 1.
        System.out.println("r2: " + r2);
        
        String r3 =  s.toString(); // return "01010", which is the composition of bitset.
        System.out.println("r3: " + r3);
    }
}

// public static void main(String args[]) {
//     int arr[] = {1, 3, 5, 7, 9, 11};
//     int n = arr.length;
//     SegmentTree  tree = new SegmentTree(arr, n);
//     // Build segment tree from given array
//     // Print sum of values in array from index 1 to 3
//     System.out.println("Sum of values in given range = " +
//                        tree.getSum(n, 1, 3));
//     // Update: set arr[1] = 10 and update corresponding segment
//     // tree nodes
//     tree.updateValue(arr, n, 1, 10);
//     // Find sum after the value is updated
//     System.out.println("Updated sum of values in given range = " +
//                        tree.getSum(n, 1, 3));
// }

// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);
// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);
