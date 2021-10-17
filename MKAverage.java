import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.TreeSet;

public class MKAverage {

    // int m, k, n;
    // Queue<Integer> que = new LinkedList<>();//数据流中的最后m个元素
    // PriorityQueue<Integer> minHeap, minHeapNums;//最大的k个数、除最小的k个数之外的数
    // PriorityQueue<Integer> maxHeap, maxHeapNums;//最小的k个数、除最大的k个数之外的数
    // Map<Integer, Integer> maxNums = new HashMap<>();//最大的k个数
    // Map<Integer, Integer> minNums = new HashMap<>();//最小的k个数
    // long sum = 0L;//中间数据的和
    // int index = 0;//数据总个数
    // // int minN = 0, maxN = 0;//当前最小、最大的数个数
    // public MKAverage(int m, int k) {
    //     Comparator<Integer> comp = new Comparator<Integer>() {
    //         public int compare(Integer a, Integer b) {
    //             return b - a;
    //         }
    //     };
    //     this.m = m;
    //     this.k = k;
    //     this.n = m - k * 2;
    //     this.minHeap = new PriorityQueue<>(m);//最大的k个数
    //     this.minHeapNums = new PriorityQueue<>(m);//除最小的k个数之外的数
    //     this.maxHeap = new PriorityQueue<>(m, comp);//最小的k个数
    //     this.maxHeapNums = new PriorityQueue<>(m, comp);//除最大的k个数之外的数
    // }
    // public void addElement(int num) {
    //     sum += num;
    //     que.offer(num);
    //     if (++index > m) {//数据个数超过m，删除之前m个位置的数
    //         int del = que.poll();//从队列中取出待删除数据
    //         if (maxNums.containsKey(del)) {//在最大的k个数中
    //             if (maxNums.get(del) == 1)
    //                 maxNums.remove(del);
    //             else
    //                 maxNums.put(del, maxNums.get(del) - 1);
    //             minHeap.remove(del);
    //             minHeapNums.remove(del);
    //         }
    //         else if (minNums.containsKey(del)) {//在最小的k个数中
    //             if (minNums.get(del) == 1)
    //                 minNums.remove(del);
    //             else
    //                 minNums.put(del, minNums.get(del) - 1);
    //             maxHeap.remove(del);
    //             maxHeapNums.remove(del);
    //         }
    //         else {//在中间数据
    //             sum -= del;
    //             maxHeapNums.remove(del);
    //             minHeapNums.remove(del);
    //         }
    //     }
    //     minHeapNums.offer(num);
    //     maxHeapNums.offer(num);
    // }
    // public int calculateMKAverage() {
    //     if (index < m)//数据个数小于m
    //         return -1;
    //     while (minHeap.size() < k) {//补齐最大的k个数
    //         Integer num = maxHeapNums.poll();
    //         minHeap.offer(num);
    //         sum -= num;
    //         maxNums.put(num, maxNums.getOrDefault(num, 0) + 1);
    //     }
    //     while (maxHeapNums.peek() > minHeap.peek()) {//调整最大的k个数
    //         sum = sum + minHeap.peek() - maxHeapNums.peek();
    //         maxNums.put(maxHeapNums.peek(), maxNums.getOrDefault(maxHeapNums.peek(), 0) + 1);
    //         if (maxNums.get(minHeap.peek()) == 1)
    //             maxNums.remove(minHeap.peek());
    //         else
    //             maxNums.put(minHeap.peek(), maxNums.get(minHeap.peek()) - 1);
    //         minHeap.offer(maxHeapNums.poll());
    //         maxHeapNums.offer(minHeap.poll());
    //     }
    //     while (maxHeap.size() < k) {//补齐最小的k个数
    //         Integer num = minHeapNums.poll();
    //         maxHeap.offer(num);
    //         sum -= num;
    //         minNums.put(num, minNums.getOrDefault(num, 0) + 1);
    //     }
    //     while (minHeapNums.peek() < maxHeap.peek()) {//调整最小的k个数
    //         sum = sum + maxHeap.peek() - minHeapNums.peek();
    //         minNums.put(minHeapNums.peek(), minNums.getOrDefault(minHeapNums.peek(), 0) + 1);
    //         if (minNums.get(maxHeap.peek()) == 1)
    //             minNums.remove(maxHeap.peek());
    //         else
    //             minNums.put(maxHeap.peek(), minNums.get(maxHeap.peek()) - 1);
    //         maxHeap.offer(minHeapNums.poll());
    //         minHeapNums.offer(maxHeap.poll());
    //     }
    //     return (int)(sum / n);
    // }
// // 上面参考的起的名字很绕，下面不知道哪里错了，改天再挑出来
//     Queue<Integer> q = new LinkedList<>();  //数据流中的最后m个元素
//     Queue<Integer> maxk, mma; //最大的k个数、除最小的k个数之外的数
//     Queue<Integer> mink, mmi; //最小的k个数、除最大的k个数之外的数
//     Map<Integer, Integer> maxKVal = new HashMap<>(); //最大的k个数
//     Map<Integer, Integer> minKVal = new HashMap<>(); //最小的k个数
//     int idx = 0;
//     // , minCnt = 0, maxCnt = 0;
//     int m, n, k;
//     long sum = 0;
//     public MKAverage(int m, int k) {
//         mink = new PriorityQueue<>(m, (a, b)->b-a);
//         mmi = new PriorityQueue<>(m, (a, b)->b-a); //除最大的k个数之外的数
//         maxk = new PriorityQueue<>(m);
//         mma = new PriorityQueue<>(m); //除最小的k个数之外的数 // increasing
//         this.m = m;
//         this.k = k;
//         this.n = n - 2 * k;
//     }
//     public void addElement(int num) {
//         sum += num;
//         q.offer(num);
//         if (++idx == m) { //数据个数超过m，删除之前m个位置的数
//             int dll = q.poll(); //从队列中取出待删除数据
//             if (maxKVal.containsKey(dll)) { //在最大的k个数中
//                 if (maxKVal.get(dll) == 1) maxKVal.remove(dll);
//                 else maxKVal.put(dll, maxKVal.get(dll)-1);
//                 maxk.remove(dll);
//                 mma.remove(dll);
//             } else if (minKVal.containsKey(dll)) { //在最小的k个数中
//                 if (minKVal.get(dll) == 1) minKVal.remove(dll);
//                 else minKVal.put(dll, minKVal.get(dll)-1);
//                 mink.remove(dll);
//                 mmi.remove(dll);
//             } else { //在中间数据
//                 sum -= dll;
//                 mma.remove(dll);
//                 mmi.remove(dll);
//             }
//         }
//         mmi.offer(num);
//         mma.offer(num);
//     }
    //  public int calculateMKAverage() {
    //     if (idx < m) return -1;
    //     while (maxk.size() < k) {//补齐最大的k个数
    //         Integer num = mmi.poll();
    //         maxk.offer(num);
    //         sum -= num;
    //         maxKVal.put(num, maxKVal.getOrDefault(num, 0) + 1);
    //     }
    //     while (mmi.peek() > maxk.peek()) {//调整最大的k个数:剩余数中最大的比当前最大数还要大，需要调整
    //         sum = sum + maxk.peek() - mmi.peek();
    //         maxKVal.put(mmi.peek(), maxKVal.getOrDefault(mmi.peek(), 0) + 1);
    //         if (maxKVal.get(maxk.peek()) == 1) maxKVal.remove(maxk.peek());
    //         else maxKVal.put(maxk.peek(), maxKVal.get(maxk.peek()) - 1);
    //         maxk.offer(mmi.poll());
    //         mmi.offer(maxk.poll());
    //     }
    //     while (mink.size() < k) { //补齐最小的k个数
    //         Integer cur = mma.poll();
    //         mink.offer(cur);
    //         sum -= cur;
    //         minKVal.put(cur, minKVal.getOrDefault(cur, 0) + 1);
    //     }
    //     while (mma.peek() < mink.peek()) { //调整最小的k个数: 除最小k之外的m-k个数中最小的比当前最小还要小，就需要调整
    //         sum = sum + mink.peek() - mma.peek();
    //         minKVal.put(mma.peek(), minKVal.getOrDefault(mma.peek(), 0) + 1);
    //         if (minKVal.get(mink.peek()) == 1) minKVal.remove(mink.peek());
    //         else minKVal.put(mink.peek(), minKVal.get(mink.peek())-1);
    //         mink.offer(mma.poll());
    //         mma.offer(mink.poll());
    //     }
    //     return (int)(sum / n);
    // }


    // // 根据题意需要找到前k大的数，又需要求区间和，就自然想到线段树.写起来较不容易出错。
    // // 维护2个线段树数组，一个记录数的个数，一个记录区间值，
    // // 注意一般线段树中[s，e]指固定的区间，这里类似线段数求第k小的数，所以[s,e]指第s小的值到第e小的值的区间。
    // LinkedList<Integer> q;
    // int [] cnt;
    // long[] sum;
    // int m,k;
    // public MKAverage(int m, int k) {
    //     q = new LinkedList<>();
    //     cnt = new int[400001]; // space: 4N
    //     sum = new long[400001];
    //     this.m = m;
    //     this.k = k;
    // }
    // public void addElement(int num) {
    //     if (q.size() == m) {
    //         int v = q.pollFirst();
    //         insert(1, 0, 100000, v, -1);
    //     }
    //     insert(1, 0, 100000, num, 1);
    //     q.addLast(num);
    // }
    // public int calculateMKAverage() {
    //     if (q.size() < m)return -1;
    //     int s = k+1, e = m-k;
    //     return (int)(query(1, 0, 100000, s, e)/(m-2*k));
    // }
    // void insert(int idx, int l, int r, int v, long d) {
    //     cnt[idx] += d;
    //     sum[idx] += d*v;
    //     if (l == r) return;
    //     int m = l + (r-l)/2;
    //     if (v <= m)
    //         insert(idx<<1, l, m, v, d);    // 向左子树查询
    //     else
    //         insert(idx<<1|1, m+1, r, v, d);// 向右子树查询
    // }
    // long query(int idx, int l, int r, int s, int e){//线段中第s个到第e个
    //     if (l == r) {//起始和结束最多出现2次此情况
    //         int c = e-s+1;
    //         return (long)c*l;
    //     } else if (cnt[idx] == e-s+1) {
    //         return sum[idx];
    //     } else {
    //         int m = (l+r)/2;
    //         int c1 = cnt[idx<<1];
    //         int c2 = cnt[idx<<1|1];
    //         if (c1 >= e){
    //             return query(idx<<1, l, m, s, e);
    //         } else if (c1 >= s){
    //             return query(idx<<1, l, m, s, c1)+query(idx<<1|1, m+1, r, 1, e-c1);
    //         } else {//c1<s
    //             return query(idx<<1|1, m+1, r, s-c1, e-c1);
    //         }
    //     }
    // }

    
    // Queue<Integer> q = new LinkedList<>();
    // FenWick fone, ftwo;
    // int [] cnt = new int [100010];
    // long sum = 0;
    // int m,k;
    // public MKAverage(int m, int k) {
    //     this.m = m;
    //     this.k = k;
    //     long A [] = new long [100010];
    //     long B [] = new long [100010];
    //     fone = new FenWick(A);
    //     ftwo = new FenWick(B);
    // }
    // public void addElement(int num) {
    //     q.add(num);
    //     sum += num;
    //     fone.update(num, 1);
    //     ftwo.update(num, num);
    //     cnt[num]++;
    // }
    // public int calculateMKAverage() {
    //     if (q.size() < m) return -1;
    //     while (q.size() > m) {
    //         int cur = q.poll();
    //         cnt[cur]--;
    //         sum -= cur;
    //         fone.update(cur, -1);
    //         ftwo.update(cur, -cur);
    //     }
    //     // binary search for the first k (there may be duplicated)
    //     int l = 0, r = cnt.length-1;
    //     int i = -1, j = -1; // pos1, pos2 
    //     while (l <= r) { // 二分查找总计数
    //         int m = (r + l) / 2;
    //         long count = fone.sumRange(0, m);
    //         if (count >= k) {
    //             i = m;
    //             r = m -1;
    //         } else l = m+1;
    //     }
    //     // binary search for the last k (there may be duplicated)
    //     l = 0;
    //     r = cnt.length-1;
    //     while (l <= r) {
    //         int m = l + (r-l)/2;
    //         long count = fone.sumRange(m, cnt.length-1);
    //         if (count >= k) {
    //             j = m;
    //             l = m + 1;
    //         } else r = m-1;
    //     }
    //     long sum1 = ftwo.sumRange(0,  i);
    //     long sum2 = ftwo.sumRange(j, cnt.length-1);
    //     long cnt1 = fone.sumRange(0, i);
    //     long cnt2 = fone.sumRange(j, cnt.length-1);
    //     if (cnt1 > k)
    //         sum1 -= i*(cnt1-k);
    //     if (cnt2 > k)
    //         sum2 -= j*(cnt2-k);
    //     long remain = sum - sum1 - sum2; // 总和， 减去两边最小最大各K个数的和
    //     return (int)(remain / (m-2*k));
    // }
    // class FenWick {
    //     long tree []; //1-index based
    //     long A [];
    //     long arr[];
    //     public FenWick(long [] A) {
    //         this.A = A;
    //         arr = new long [A.length];
    //         tree = new long [A.length + 1];
    //     }
    //     public void update(int i, int v) {
    //         arr[i] += v;
    //         i++;
    //         while (i < tree.length) {
    //             tree[i] += v;
    //             i += (i & -i); // 这是的原理细节再回去复习一下
    //         }
    //     }
    //     public long sumRange(int i, int j) {
    //         return pre(j+1)-pre(i);
    //     }
    //     public long pre(int i) {
    //         long sum = 0;
    //         while (i > 0) {
    //             sum += tree[i];
    //             i -= (i & -i);
    //         }
    //         return sum;
    //     }
    // }

// python BST思路： https://leetcode.com/problems/finding-mk-average/discuss/1388111/python-or-100-faster-or-bst-solution-explained
    class BST { // 改天把这个写完
        class TreeNode {
            public int val;
            public int sum;
            public int cnt;
            public int size;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) {
                val = x;
                left = right = null;
            }
        }
        TreeNode root;
        public BST() {
            root = null;
        }
        public void insert(int val) {
            root = insertRecursive(root, val);
        }
        public void delete(int val) {
            root = deleteRecursive(root, val);
        }
        public int kSmallest(int k) {
            return kSmallestRecursive(root, k);
        }
        private int kSmallestRecursive(TreeNode r, int k) {
            int sum = 0;
            if (r.left != null) {
                if (k < )
            }
        }
        public List<Integer> inOrderTraverse() {
            res.clear();
            inOrderTraverseRecursive(root);
            return res;
        }
        List<Integer> res = new ArrayList<>();
        private void inOrderTraverseRecursive(TreeNode r) {
            if (r == null) return;
            inOrderTraverseRecursive(r.left);
            res.add(r.val);
            inOrderTraverseRecursive(r.right);
        }
        private TreeNode deleteRecursive(TreeNode r, int v) {
            if (r == null) return r;
            if (v < r.val)
                r.left = deleteRecursive(r.left, v);
            else if (v > r.val) 
                r.right = deleteRecursive(r.right, v);
            else {
                if (r.left == null) return r.right;
                else if (r.right == null) return r.left;
                r.val = minVal(r.right);
                r.right = deleteRecursive(r.right, r.val);
            }
            return r;
        }
        private int minVal(TreeNode r) {
            int minVal = r.val;
            while (r.left != null) {
                minVal = r.left.val;
                r = r.left;
            }
            return minVal;
        }
        private TreeNode insertRecursive(TreeNode r, int v) {
            if (r == null) {
                r = new TreeNode(v);
                r.size += 1;
                r.sum += val;
                return r;
            }
            if (v < r.val)
                r.left = insertRecursive(r.left, v);
            else if (v > r.val) 
                r.right = insertRecursive(r.right, v);
            return r;
        }
    }
    ArrayDeque<Integer> q;
    int m, k, n, l, idx = 0;
    BST tree;
    // List<Integer> inOrder = new ArrayList<>();
    // int [] arr;
    // Map<Integer, Integer> map = new HashMap<>();
    public MKAverage(int m, int k) {
        // arr = new int [m];
        q = new ArrayDeque<>();
        tree = new BST();
        this.m = m;
        this.k = k;
        this.l = m - k;
        this.n = m - 2 * k;
    }
    public void addElement(int num) {
        if (q.size() == m)
            tree.delete(q.pollFirst());
        q.offerLast(num);
        tree.insert(num);
    }
    public int calculateMKAverage() {
        if (idx < m) return -1;
        return (tree.kSmallest(l) - tree.kSmallest(k))/ n;
    }

    public static void main(String[] args) {
        MKAverage s  =  new MKAverage(6,  1);
        s.addElement(3);
        s.addElement(1);

        int r  =  s.calculateMKAverage();
        System.out.println("r: " + r);

        s.addElement(12);
        s.addElement(5);
        s.addElement(3);
        s.addElement(4);
        
        int r1  =  s.calculateMKAverage();
        System.out.println("r1: " + r1);

        // int r2  =  s.calculateMKAverage();
        // System.out.println("r2: " + r2);
    }
 }
