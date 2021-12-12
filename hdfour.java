import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toMap;

public class hdfour {
    public static class Solution {
        
        // public String numberToWords(int num) { // 再参考一下，看下代码是否可以再精简
        //     int n = String.valueOf(num).length();
        //     if (n <= 3) return getLessThan1000(num);
        //     if (n <= 6) return getLessThan1000(num / 1000) + " Thousand" + (num % 1000 == 0 ? "" : " " + getLessThan1000(num % 1000));
        //     if (n <= 9) return getLessThan1000(num / 1000000) + " Million" + (num % 1000000 == 0 ? "" : " " + numberToWords(num % 1000000));
        //     return switchN(num / 1000000000) + " Billion" + (num % 1000000000 == 0 ? "" : " " + numberToWords(num % 1000000000));
        // }
        // String getLessThan1000(int v) {
        //     String s = String.valueOf(v);
        //     int n = s.length();
        //     if (n == 1) return switchN(v);
        //     if (n == 2) {
        //         if (v / 10 == 1) return switchNN(v % 10); // [10, 19]
        //         return switchN1N(v / 10) + (v % 10 == 0 ? "" : " " + switchN(v % 10));
        //     }
        //     String ans = switchN(v / 100) + " Hundred"; // [1xx, 9xx] 百位的处理
        //     int resi = v % 100;
        //     if (resi == 0) return ans;
        //     return ans + " " + getLessThan1000(resi);
        // }
        // private String switchN1N(int n) {
        //     String ans = "";
        //     switch (n) { // 10 11 12 .... 19
        //     case 2: ans += "Twenty"; return ans;
        //     case 3: ans += "Thirty"; return ans;
        //     case 4: ans += "Forty"; return ans;
        //     case 5: ans += "Fifty"; return ans;
        //     case 6: ans += "Sixty"; return ans;
        //     case 7: ans += "Seventy"; return ans;
        //     case 8: ans += "Eighty"; return ans;
        //     case 9: ans += "Ninety"; return ans;
        //     }
        //     return ans;
        // }
        // private String switchNN(int n) {
        //     String ans = "";
        //     switch (n) { // 10 11 12 .... 19
        //     case 0: ans += "Ten"; return ans;
        //     case 1: ans += "Eleven"; return ans;
        //     case 2: ans += "Twelve"; return ans;
        //     case 3: ans += "Thirteen"; return ans;
        //     case 4: ans += "Fourteen"; return ans;
        //     case 5: ans += "Fifteen"; return ans;
        //     case 6: ans += "Sixteen"; return ans;
        //     case 7: ans += "Seventeen"; return ans;
        //     case 8: ans += "Eighteen"; return ans;
        //     case 9: ans += "Nineteen"; return ans;
        //     }
        //     return ans;
        // }
        // private String switchN(int n) {
        //     String ans = "";
        //     switch (n) {
        //     case 0: ans += "Zero"; return ans;
        //     case 1: ans += "One"; return ans;
        //     case 2: ans += "Two"; return ans;
        //     case 3: ans += "Three"; return ans;
        //     case 4: ans += "Four"; return ans;
        //     case 5: ans += "Five"; return ans;
        //     case 6: ans += "Six"; return ans;
        //     case 7: ans += "Seven"; return ans;
        //     case 8: ans += "Eight"; return ans;
        //     case 9: ans += "Nine"; return ans;
        //     }
        //     return ans;
        // }
        // public final String[] belowTwenty = {"","One", "Two", "Three", "Four","Five", "Six","Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen"};
        // public  final String[] belowHundred ={"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        // public String numberToWords(int num) {
        //     if(num==0) return "Zero";
        //     else return helper(num);
        // }
        // public String helper(int num){
        //     StringBuilder result =new StringBuilder();
        //     if(num<20) result.append(belowTwenty[num]);
        //     else if (num<100)
        //         result.append(belowHundred[num/10]) .append(" ").append(helper(num%10));
        //     else if(num<1000)
        //         result.append(helper(num/100)).append(" Hundred ").append(helper(num%100));
        //     else if(num<1000000)
        //         result.append(helper(num/1000)).append(" Thousand ").append(helper(num%1000));
        //     else if(num<1000000000)
        //         result.append(helper(num/1000000)).append(" Million ").append(helper(num%1000000));
        //     else
        //         result.append(helper(num/1000000000)). append(" Billion ").append(helper(num%1000000000));
        //     return result.toString().trim();  
        // }

        // public List<Integer> countSmaller(int[] a) { // BUG: 这个思路没有想对，思路不对
        //     int n = a.length;
        //     List<Integer> ans = new ArrayList<>();
        //     for (int i = 0; i < n; i++) 
        //         ans.add(0);
        //     ArrayDeque<Integer> q = new ArrayDeque<>(); // 单调递增
        //     for (int i = n-1; i >= 0; i--) {
        //         while (!q.isEmpty() && a[q.peekLast()] >= a[i]) q.pollLast();
        //         if (!q.isEmpty()) ans.set(i, 1 + ans.get(q.peekLast()));
        //         q.offerLast(i);
        //     }
        //     return ans;
        // }
        // public List<Integer> countSmaller(int[] a) { // tle: O(NlogN) ?
        //      int n = a.length;
        //     List<Integer> ans = new ArrayList<>();
        //     if (n == 1) {
        //         ans.add(0);
        //         return ans;
        //     }
        //     ans.add(0);
        //     Node root = new Node(a[n-1]);
        //     for (int i = n-2; i >= 0; i--) 
        //         ans.add(0, insertIntoTreeNode(root, a[i]));
        //     return ans;
        // }
        // int insertIntoTreeNode(Node r, int v) {
        //     if (v == r.val) {
        //         r.dcnt++;
        //         return r.scnt;
        //     }
        //     if (v > r.val) {
        //         if (r.right == null) {
        //             r.right = new Node(v);
        //             return r.scnt + r.dcnt;
        //         } else 
        //             return r.scnt + r.dcnt + insertIntoTreeNode(r.right, v);
        //     } else { // v < r.val 需要放置到此根节点的左侧
        //         if (r.left == null) {
        //             r.left = new Node(v);
        //             r.scnt++;
        //             return 0;
        //         } else {
        //             r.scnt++; // 更新当前根节点，小于其值的节点个数
        //             return insertIntoTreeNode(r.left, v);
        //         }
        //     }
        // }
        // private class Node {
        //     int val;
        //     int scnt; // smaller Cnt: 小于当前节点的数的个数
        //     int dcnt; // duplicate Cnt 与当前同数值的数的重复数
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
        // public List<Integer> countSmaller(int[] a) { // tle 
        //     List<Integer> res = new ArrayList<>();
        //     int n = a.length;
        //     if (n == 1) {
        //         res.add(0);
        //         return res;
        //     }
        //     Node root = new Node(a[n-1]);
        //     res.add(0);
        //     Node r = null;
        //     int val = 0;
        //     for (int i = n-2; i >= 0; i--) {
        //         int c = 0;
        //         r = root;
        //         val = a[i];
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
        // private class Node {
        //     int val;
        //     int scnt; // smaller Cnt: 小于当前节点的数的个数
        //     int dcnt; // duplicate Cnt 与当前同数值的数的重复数
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
        // public List<Integer> countSmaller(int[] a) { // O(NlogN) 插入排序
        //     int n = a.length;
        //     List<Integer> ans = new ArrayList<>();
        //     List<Integer> list = new ArrayList<>(); // 新建一个list，用于排序
        //     int [] tmp = new int [n]; // 为了提高效率，新建一个数组型的返回结果
        //     for (int i = n-1; i >= 0; i--) {
        //         int v = a[i];       // 将当前数字插入到新建list中, 使用二分查找找到插入位置
        //         int l = 0, r = list.size()-1; // l: left; r: right 从排好序的list中二分查找正确的插入位置
        //         while (l <= r) {
        //             int m = l + (r - l) / 2;
        //             if (v <= list.get(m)) r = m-1;
        //             else l = m + 1;
        //          }
        //         list.add(l, v); // 将当前数字插入到相应位置，保证list升序排列
        //         tmp[i] = l; // 当前位置前所有数字均小于当前数字，将个数加入返回结果
        //     }
        //     for (Integer v : tmp) ans.add(v);
        //     return ans;
        // }
        // private int[] c;
        // private int[] a; // 离散化、去重复 后的数组
        // public List<Integer> countSmaller(int[] nums) { // 树状数组
        //     List<Integer> ans = new ArrayList<Integer>();  
        //     discretization(nums);
        //     init(nums.length + 5);
        //     for (int i = nums.length - 1; i >= 0; --i) {
        //         int id = getId(nums[i]);
        //         ans.add(query(id - 1));
        //         update(id);
        //     }
        //     Collections.reverse(ans);
        //     return ans;
        // }
        // private void init(int length) {
        //     c = new int[length];
        //     Arrays.fill(c, 0);
        // }
        // private int lowBit(int x) {
        //     return x & (-x);
        // }
        // private void update(int pos) {
        //     while (pos < c.length) {
        //         c[pos] += 1;
        //         pos += lowBit(pos);
        //     }
        // }
        // private int query(int pos) {
        //     int ret = 0;
        //     while (pos > 0) {
        //         ret += c[pos];
        //         pos -= lowBit(pos);
        //     }
        //     return ret;
        // }
        // private void discretization(int[] nums) { // 离散化、去重复 ？
        //     Set<Integer> set = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        //     int size = set.size();
        //     a = new int[size];
        //     int index = 0;
        //     for (int num : set) a[index++] = num;
        //     Arrays.sort(a);
        // }
        // private int getId(int x) {
        //     return Arrays.binarySearch(a, x) + 1; // 
        // }
        // public List<Integer> countSmaller(int[] nums) { // merge sort： 归并排序
        //     this.index = new int[nums.length];
        //     this.temp = new int[nums.length];
        //     this.tempIndex = new int[nums.length];
        //     this.ans = new int[nums.length];
        //     for (int i = 0; i < nums.length; ++i) {
        //         index[i] = i;
        //     }
        //     int l = 0, r = nums.length - 1;
        //     mergeSort(nums, l, r);
        //     List<Integer> list = new ArrayList<Integer>();
        //     for (int num : ans) {
        //         list.add(num);
        //     }
        //     return list;
        // }
        // private int[] index;
        // private int[] temp;
        // private int[] tempIndex;
        // private int[] ans;
        // public void mergeSort(int[] a, int l, int r) {
        //     if (l >= r) {
        //         return;
        //     }
        //     int mid = (l + r) >> 1;
        //     mergeSort(a, l, mid);
        //     mergeSort(a, mid + 1, r);
        //     merge(a, l, mid, r);
        // }
        // public void merge(int[] a, int l, int mid, int r) {
        //     int i = l, j = mid + 1, p = l;
        //     while (i <= mid && j <= r) {
        //         if (a[i] <= a[j]) {
        //             temp[p] = a[i];
        //             tempIndex[p] = index[i];
        //             ans[index[i]] += (j - mid - 1);
        //             ++i;
        //             ++p;
        //         } else {
        //             temp[p] = a[j];
        //             tempIndex[p] = index[j];
        //             ++j;
        //             ++p;
        //         }
        //     }
        //     while (i <= mid)  {
        //         temp[p] = a[i];
        //         tempIndex[p] = index[i];
        //         ans[index[i]] += (j - mid - 1);
        //         ++i;
        //         ++p;
        //     }
        //     while (j <= r) {
        //         temp[p] = a[j];
        //         tempIndex[p] = index[j];
        //         ++j;
        //         ++p;
        //     }
        //     for (int k = l; k <= r; ++k) {
        //         index[k] = tempIndex[k];
        //         a[k] = temp[k];
        //     }
        // }
        // // 分治法。 https://blog.csdn.net/jmspan/article/details/51219203
        // // 思路：从大到小合并左右已排序的两段，根据右边剩余，来个左边元素对应的counts[ ],但是，排序后元素的位置要变化，就不能追踪某个元素的逆序数和其开始对应的位置了。这就自然想到一个数组pos[ ]排名和开始的位置建立联系。
        // //     此方法类似归并排序，但不用创建新数组就行排序，只在pos[ ]更新排名和位置的信息即可，参考https://blog.csdn.net/jmspan/article/details/51219203
        // //     1.类似归并排序，因为归并排序要改变元素位置，无法追踪每个元素对应的值，
        // //         2.每次排序记录一个排名和位置的映射，pos[i]=j排名第i对应原位置j,能通过位置j在找到原值nums[j]，j能代表原值。
        // //         3.每次归并时，只是对应两个已排序的区间，pos[i]记录这个区间的排序信息，不用真的定义一个数组排序。
        // //         时间复杂度O（nlog n）
        // public List<Integer> countSmaller(int[] a) {
        //     List<Integer> list=new ArrayList<>();
        //     int[] pos=new int[a.length];
        //     int[] counts=new int[a.length];
        //     for(int i=0;i<a.length;i++) pos[i]=i;//排名的初始化赋值
        //     sort(a,counts,pos,0,a.length-1);
        //     for(int count:counts) {
        //         list.add(count);
        //     }
        //     return list;
        // }
        // public void sort(int[] a,int[] counts,int[] pos,int l,int r){
        //     if(l==r) return;
        //     int m=(l+r)/2;
        //     sort(a,counts,pos,l,m);
        //     sort(a,counts,pos,m+1,r);
        //     //统计count根据右边那个子数组剩余,更新pos[],根据[l,m]区间从大到小
        //     int[] temp=new int[r-l+1];//总数组的新排名
        //     int lc=l,rc=m+1,t=0;
        //     while(lc<=m&&rc<=r){
        //         if(a[pos[lc]]<a[pos[rc]]){
        //             temp[t++]=pos[rc++];
        //         }else if(a[pos[lc]]>a[pos[rc]]){
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
        // private void sort(int[] a, int[] smaller, int[] pos, int from, int to) {
        //     if (from >= to) return;
        //     int m = (from + to) / 2;
        //     sort(a, smaller, pos, from, m);
        //     sort(a, smaller, pos, m+1, to);
        //     int[] merged = new int[to-from+1];
        //     int i=from, j=m+1, k=0, jump = 0;
        //     while (i<=m || j<=to) {
        //         if (i>m) {
        //             jump ++;
        //             merged[k++] = pos[j++];
        //         } else if (j>to) {
        //             smaller[pos[i]] += jump;
        //             merged[k++] = pos[i++];
        //         } else if (a[pos[i]] <= a[pos[j]]) {
        //             smaller[pos[i]] += jump;
        //             merged[k++] = pos[i++];
        //         } else {
        //             jump ++;
        //             merged[k++] = pos[j++];
        //         }
        //     }
        //     for(int p=0; p<merged.length; p++) pos[from+p] = merged[p];
        // }
        // public List<Integer> countSmaller(int[] a) {
        //     int[] smaller = new int[a.length];
        //     int[] pos = new int[a.length];
        //     for (int i=0; i<pos.length; i++) pos[i] = i;
        //     sort(a, smaller, pos, 0, a.length-1);
        //     List<Integer> result = new ArrayList<>(a.length);
        //     for(int i=0; i<a.length; i++) result.add(smaller[i]);
        //     return result;
        // }

        // public int countRangeSum(int[] a, int lower, int upper) { // bug
        //     n = a.length;
        //     sum = new long [n];
        //     for (int i = 0; i < n; i++) 
        //         sum[i] = (i == 0 ? 0 : sum[i-1]) + a[i];
        //     return getCnt(upper) - getCnt(lower-1);
        // }
        // long [] sum;
        // int n;
        // int getCnt(int v) {
        //     int cnt = 0;
        //     Map<Long, Integer> m = new HashMap<>();
        //     m.put(0l, 1); // v == 0 ?
        //     for (int i = 0; i < n; i++) {
        //         if (sum[i] < v) // 键里存的所有的key,构成的子片段都会小
        //             cnt += m.values().stream().reduce(0, Integer::sum);
        //         else if (sum[i] >= v && m.containsKey(sum[i] - v))
        //             cnt += m.get(sum[i] - v);
        //         m.put(sum[i], m.getOrDefault(sum[i], 0) + 1);
        //     }
        //     return cnt;
        // }
        // public int countRangeSum(int[] a, int lower, int upper) { // tle
        //     if (a == null || a.length==0) return 0;
        //     long[] sums = new long[a.length];
        //     sums[0] = a[0];
        //     for(int i=1; i<a.length; i++) sums[i] = sums[i-1] + a[i];
        //     int total = 0;
        //     TreeMap<Long, Integer> treemap = new TreeMap<>();
        //     for(int i=0; i<a.length; i++) {
        //         if (lower <= sums[i] && sums[i] <= upper) total ++;
        //         for(Integer count: treemap.subMap(sums[i]-upper, true, sums[i]-lower, true).values()) 
        //             total += count;
        //         Integer count = treemap.get(sums[i]);
        //         if (count == null) count = 1; else count ++;
        //         treemap.put(sums[i], count);
        //     }
        //     return total;
        // }
        private class Bit {
             int size;
             int [] arr;
             long [] tree; // sum
             public Bit(int size) {
                 this.size = size;
                 this.tree = new long[size+1];
             }
             public Bit(int [] arr) {
                 this.size = arr.length+1;
                 this.tree = new long[size];
                 this.arr = new int[size];
                 for (int i = 0; i < arr.length; i++) {
                     update(i, arr[i]);
                 }
             }
             private long sum(int i) {
                 long res = 0;
                 while (i > 0 && i < size) {
                     res += tree[i];
                     i -= lowBit(i);
                 }
                 return res;
             }
             private void update(int i, int val) { //logn i - 0 based
                 int diff = val - arr[i+1];
                 arr[i+1] = val;
                 i += 1; // tree中下标从1开始
                 while(i+1 < arr.length){
                     tree[i+1] += diff;
                     i += lowBit(i);
                 }            
             }
             public int sumRange(int i, int j) { // sum [i, j]
                 return (int)(sum(j+1) - sum(i));
             }
             private int lowBit(int n) {
                 return n & (-n); 
             }
             public int find(int rank) {
                 int lowerRank = 0;
                 while (rank > 0) {
                     lowerRank = (int)Math.max(lowerRank, tree[rank]);
                     rank -= lowBit(rank);
                 }
                 // System.out.println("rank: " + rank);
                 return lowerRank;
             }
             public int update(int rank) { // rank: rank of nums[i]
                 // NOT find(n), due to the requirement of *strictly* increasing sequence
                 // int l = find(rank - 1) + 1; // 更新所有的父————接下来的节点
                 // System.out.println("tree.length: " + tree.length);
                 // for (int z = 0; z < tree.length; ++z) 
                 //     System.out.print(tree[z] + ", ");
                 // System.out.println("");
                 int val = find(rank-1) + 1; // 更新所有的父————接下来的节点
                 while (rank <= size && tree[rank] < val) {
                     tree[rank] = val;
                     rank += lowBit(rank);
                 }
                 // System.out.println("tree.length: " + tree.length);
                 // for (int z = 0; z < tree.length; ++z) 
                 //     System.out.print(tree[z] + ", ");
                 // System.out.println("");
                 return val;
             }
        }
        public int countRangeSum(int[] nums, int lower, int upper) { // bug
            int n = nums.length;
            if (n == 1) return nums[0] <= upper && nums[0] >= lower ? 1 : 0;
            // else if (n == 2)
            //     return (nums[0] <= upper && nums[0] >= lower ? 1 : 0)
            //         + (nums[1] <= upper && nums[1] >= lower ? 1 : 0)
            //         + (nums[0]+nums[1] <= upper && nums[0] + nums[1] >= lower ? 1 : 0);
            Bit bit = new Bit(nums);
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    long sum = bit.sumRange(i+1, j+1);
                    if (sum >= lower && sum <= upper) ++cnt;
                }
            }
            return cnt;
        }
        // public int countRangeSum(int[] a, int lower, int upper) { // 这个merge sort的思维很奇特: 二分，O(NlogN)
        //     int n = a.length;
        //     long [] sum = new long[n+1];
        //     for (int i = 1; i <= n; i++) 
        //         sum[i] = sum[i-1] + a[i-1];
        //     return mergeAnalyse(sum, 0, n+1, lower, upper);
        // }
        // int mergeAnalyse(long [] a, int l, int r, int lo, int hi) { // l, r: 寻找[l, r)范围内和为[lower, upper]的片段的个数
        //     if (r - l <= 1) return 0;
        //     int mid = l + (r - l) / 2;
        //     int m = mid, n = mid, ans = 0;
        //     ans = mergeAnalyse(a, l, mid, lo, hi) + mergeAnalyse(a, mid, r, lo, hi);
        //     for (int i = l; i < mid; i++) { // 遍历[l, r)的半段长度： pivot 右移，滑动窗口，寻找合法窗口 // 通过遍历寻找当前范围中符合要求的个数，
        //         while (m < r && a[m] - a[i] < lo) m++; // 左端点右移，直到找到合法（sum >= lo）的解：m合法
        //         while (n < r && a[n] - a[i] <= hi) n++; // 右端点右移，直到右端点右移至不再合法（sum > hi）, n 不合法 
        //         ans += n - m; // 对于[l, r)范围内的当前i来说，满足要求的总个数为 n - m
        //     }
        //     Arrays.sort(a, l, r); // 将[l, r)片段排序
        //     return ans;
        // }
        // public int countRangeSum(int[] a, int lo, int hi) { // 线段树
        //     int n = a.length;
        //     long [] preSum = new long[n + 1];
        //     for (int i = 1; i <= n; i++) 
        //         preSum[i] = preSum[i-1] + a[i-1];
        //     Set<Long> allNumbers = new TreeSet<Long>();
        //     for (long x : preSum) {
        //         allNumbers.add(x);
        //         allNumbers.add(x - lo); //
        //         allNumbers.add(x - hi); // 
        //     }
        //     // 利用哈希表进行离散化
        //     Map<Long, Integer> values = new HashMap<Long, Integer>();
        //     int idx = 0;
        //     for (long x : allNumbers) {
        //         values.put(x, idx);
        //         idx++;
        //     }
        //     SegNode root = build(0, values.size() - 1);
        //     int ret = 0;
        //     for (long x : preSum) {
        //         int left = values.get(x - hi), right = values.get(x - lo);
        //         ret += count(root, left, right);
        //         insert(root, values.get(x));
        //     }
        //     return ret;
        // }
        // public SegNode build(int left, int right) {
        //     SegNode node = new SegNode(left, right);
        //     if (left == right) {
        //         return node;
        //     }
        //     int mid = (left + right) / 2;
        //     node.lchild = build(left, mid);
        //     node.rchild = build(mid + 1, right);
        //     return node;
        // }
        // public int count(SegNode root, int left, int right) {
        //     if (left > root.hi || right < root.lo) 
        //         return 0;
        //     if (left <= root.lo && root.hi <= right) 
        //         return root.add;
        //     return count(root.lchild, left, right) + count(root.rchild, left, right);
        // }
        // public void insert(SegNode root, int val) {
        //     root.add++;
        //     if (root.lo == root.hi) 
        //         return;
        //     int mid = (root.lo + root.hi) / 2;
        //     if (val <= mid) 
        //         insert(root.lchild, val);
        //     else insert(root.rchild, val);
        // }
        // class SegNode {
        //     int lo, hi, add;
        //     SegNode lchild, rchild;
        //     public SegNode(int left, int right) {
        //         lo = left;
        //         hi = right;
        //         add = 0;
        //         lchild = null;
        //         rchild = null;
        //     }
        // }
        // public int countRangeSum(int[] a, int lower, int upper) { // 树状数组
        //     int n = a.length;
        //     long[] preSum = new long[a.length + 1];
        //     for (int i = 1; i <= n; i++) 
        //         preSum[i] = preSum[i-1] + a[i-1];
        //     Set<Long> allNumbers = new TreeSet<Long>();
        //     for (long x : preSum) {
        //         allNumbers.add(x);
        //         allNumbers.add(x - lower);
        //         allNumbers.add(x - upper);
        //     }
        //     // 利用哈希表进行离散化
        //     Map<Long, Integer> values = new HashMap<Long, Integer>();
        //     int idx = 0;
        //     for (long x: allNumbers) {
        //         values.put(x, idx);
        //         idx++;
        //     }
        //     int ret = 0;
        //     BIT bit = new BIT(values.size());
        //     for (int i = 0; i < preSum.length; i++) {
        //         int left = values.get(preSum[i] - upper), right = values.get(preSum[i] - lower);
        //         ret += bit.query(right + 1) - bit.query(left);
        //         bit.update(values.get(preSum[i]) + 1, 1);
        //     }
        //     return ret;
        // }
        // class BIT {
        //     int [] tree;
        //     int n;
        //     public BIT(int n) {
        //         this.n = n;
        //         this.tree = new int[n + 1];
        //     }
        //     public int lowbit(int x) {
        //         return x & (-x);
        //     }
        //     public void update(int x, int d) {
        //         while (x <= n) {
        //             tree[x] += d;
        //             x += lowbit(x);
        //         }
        //     }
        //     public int query(int x) {
        //         int ans = 0;
        //         while (x != 0) {
        //             ans += tree[x];
        //             x -= lowbit(x);
        //         }
        //         return ans;
        //     }
        // }
        // public int countRangeSum(int[] nums, int lower, int upper) { // 平衡二叉树
        //     long sum = 0;
        //     long[] preSum = new long[nums.length + 1];
        //     for (int i = 0; i < nums.length; ++i) {
        //         sum += nums[i];
        //         preSum[i + 1] = sum;
        //     }
        //     BalancedTree treap = new BalancedTree();
        //     int ret = 0;
        //     for (long x : preSum) {
        //         long numLeft = treap.lowerBound(x - upper);
        //         int rankLeft = (numLeft == Long.MAX_VALUE ? (int) (treap.getSize() + 1) : treap.rank(numLeft)[0]);
        //         long numRight = treap.upperBound(x - lower);
        //         int rankRight = (numRight == Long.MAX_VALUE ? (int) treap.getSize() : treap.rank(numRight)[0] - 1);
        //         ret += rankRight - rankLeft + 1;
        //         treap.insert(x);
        //     }
        //     return ret;
        // }
        // class BalancedTree {
        //     private class BalancedNode {
        //         long val;
        //         long seed;
        //         int count;
        //         int size;
        //         BalancedNode left;
        //         BalancedNode right;
        //         BalancedNode(long val, long seed) {
        //             this.val = val;
        //             this.seed = seed;
        //             this.count = 1;
        //             this.size = 1;
        //             this.left = null;
        //             this.right = null;
        //         }
        //         BalancedNode leftRotate() {
        //             int prevSize = size;
        //             int currSize = (left != null ? left.size : 0) + (right.left != null ? right.left.size : 0) + count;
        //             BalancedNode root = right;
        //             right = root.left;
        //             root.left = this;
        //             root.size = prevSize;
        //             size = currSize;
        //             return root;
        //         }
        //         BalancedNode rightRotate() {
        //             int prevSize = size;
        //             int currSize = (right != null ? right.size : 0) + (left.right != null ? left.right.size : 0) + count;
        //             BalancedNode root = left;
        //             left = root.right;
        //             root.right = this;
        //             root.size = prevSize;
        //             size = currSize;
        //             return root;
        //         }
        //     }
        //     private BalancedNode root;
        //     private int size;
        //     private Random rand;
        //     public BalancedTree() {
        //         this.root = null;
        //         this.size = 0;
        //         this.rand = new Random();
        //     }
        //     public long getSize() {
        //         return size;
        //     }
        //     public void insert(long x) {
        //         ++size;
        //         root = insert(root, x);
        //     }
        //     public long lowerBound(long x) {
        //         BalancedNode node = root;
        //         long ans = Long.MAX_VALUE;
        //         while (node != null) {
        //             if (x == node.val) return x;
        //             if (x < node.val) {
        //                 ans = node.val;
        //                 node = node.left;
        //             } else node = node.right;
        //         }
        //         return ans;
        //     }
        //     public long upperBound(long x) {
        //         BalancedNode node = root;
        //         long ans = Long.MAX_VALUE;
        //         while (node != null) {
        //             if (x < node.val) {
        //                 ans = node.val;
        //                 node = node.left;
        //             } else node = node.right;
        //         }
        //         return ans;
        //     }
        //     public int[] rank(long x) {
        //         BalancedNode node = root;
        //         int ans = 0;
        //         while (node != null) {
        //             if (x < node.val) {
        //                 node = node.left;
        //             } else {
        //                 ans += (node.left != null ? node.left.size : 0) + node.count;
        //                 if (x == node.val) {
        //                     return new int[]{ans - node.count + 1, ans};
        //                 }
        //                 node = node.right;
        //             }
        //         }
        //         return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        //     }
        //     private BalancedNode insert(BalancedNode node, long x) {
        //         if (node == null) 
        //             return new BalancedNode(x, rand.nextInt());
        //         ++node.size;
        //         if (x < node.val) {
        //             node.left = insert(node.left, x);
        //             if (node.left.seed > node.seed) 
        //                 node = node.rightRotate();
        //         } else if (x > node.val) {
        //             node.right = insert(node.right, x);
        //             if (node.right.seed > node.seed) 
        //                 node = node.leftRotate();
        //         } else ++node.count;
        //         return node;
        //     }
        // }
        // public int countRangeSum(int[] nums, int lower, int upper) { // 分治法
        //     long[] sums = new long[nums.length + 1];
        //     for(int i = 0 ; i<nums.length ; i++) {
        //         sums[i+1] = sums[i] + nums[i];
        //     }
        //     long[] sortedSums = new long[nums.length + 1];
        //     return mergeCountRangeSum(sums, sortedSums, 0, nums.length+1, lower, upper);
        // }
        // public int mergeCountRangeSum(long[] sums,long[]  sortedSums, int start, int end, int lower, int upper) {
        //     if(end - start <= 1) return 0;
        //     int mid = (start + end) / 2;
        //     int count = mergeCountRangeSum(sums, sortedSums, start, mid, lower, upper) 
        //         + mergeCountRangeSum(sums, sortedSums, mid, end, lower, upper);
        //     int firstLargerThanUpper = mid, firstLargerThanLower = mid, indexOfRightHalf = mid;
        //     for(int i = start, sortedSumsIndex = start; i < mid ; i++, sortedSumsIndex++) {
        //         while(firstLargerThanUpper < end && sums[firstLargerThanUpper] - sums[i] <= upper)  firstLargerThanUpper++;
        //         while(firstLargerThanLower < end && sums[firstLargerThanLower] - sums[i] <lower) firstLargerThanLower++;
        //         while(indexOfRightHalf < end && sums[indexOfRightHalf] < sums[i]) sortedSums[sortedSumsIndex++] = sums[indexOfRightHalf++];
        //         sortedSums[sortedSumsIndex] = sums[i];
        //         count += firstLargerThanUpper - firstLargerThanLower;
        //     }
        //     System.arraycopy(sortedSums, start, sums, start, indexOfRightHalf - start);
        //     return count;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] a = new int [] {-2,5,-1};

        System.out.println(Arrays.toString(a));

        int r = s.countRangeSum(a, -2, 2);
        System.out.println("r: " + r);
    }
}
// TreeNd root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.lvlPrintTree(root);