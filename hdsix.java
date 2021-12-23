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

public class hdsix {
    public static class Solution {

        // public String minInteger(String t, int k) {
        //     int n = t.length();
        //     t = " " + t;
        //     char [] s = t.toCharArray();
        //     ArrayDeque<Integer> [] q = new ArrayDeque [10];
        //     for (int i = 1; i <= n; i++) {
        //         int j = s[i] - '0';
        //         if (q[j] == null) q[j] = new ArrayDeque<>();
        //         q[j].offerLast(i);
        //     }
        //     BIT bit = new BIT(n);
        //     StringBuilder sb = new StringBuilder();
        //     for (int i = 1; i <= n; i++) {
        //         for (int j = 0; j < 10; j++) { // 从小数值往大数值遍历
        //             if (q[j] == null || q[j].isEmpty()) continue;
        //             int top = q[j].peekFirst(), pos = top + bit.sum(top); // pos是最优解的位置，最优解的位置是原来的位置加上偏移量
        //             if (pos - i <= k) {
        //                 k -= pos - i;
        //                 sb.append(j);
        //                 q[j].pollFirst();
        //                 bit.add(1, 1); // 更新[1, t)这段的值每个加1，即向右偏移1位.为什么要 从1开始更新：假装每次都移动到最前端，方便计算 ?
        //                 bit.add(top, -1);
        //                 break;
        //             }
        //         }
        //     }
        //     return sb.toString();
        // }
        // class BIT { // 开一个树状数组类，维护每个位置的字符的向右的偏移量 ? 向左偏移量
        //     private int n;
        //     private int [] a;
        //     public BIT(int n) {
        //         this.n = n;
        //         this.a = new int [n+1];
        //     }
        //     public void add(int idx, int v) { // 只有发生偏移，才移动某段区间的值
        //         while (idx <= n) {
        //             a[idx] += v;
        //             idx += lowbit(idx);
        //         }
        //     }
        //     public int sum(int idx) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, idx]的和，1-based
        //         int ans = 0;
        //         while (idx > 0) {
        //             ans += a[idx];
        //             idx -= lowbit(idx);
        //         }
        //         return ans;
        //     }
        //     int lowbit(int x) {
        //         return x & -x;
        //     }
        // }

    // private long add, mul;
    // private List<Integer> l;
    // static final int mod = (int)1e9 + 7;
    // public Fancy() {
    //     add = 0;
    //     mul = 1;
    //     l = new ArrayList<>();
    // }
    // public void append(int val) {
    //     val = (int)((val - add + mod) % mod);
    //     val = (int)((long)val * quickMul(mul, mod - 2) % mod);
    //     l.add(val);
    // }
    // public void addAll(int inc) {
    //     add = (add + inc) % mod;
    // }
    // public void multAll(int m) {
    //     add = add * m % mod;
    //     mul = mul * m % mod;
    // }
    // public int getIndex(int idx) {
    //     if (idx >= l.size()) return -1;
    //     return (int)((l.get(idx) * mul + add) % mod);
    // }
    // long quickMul(long base, int exp) {
    //     long ans = 1;
    //     while (exp > 0) {
    //         if (exp % 2 == 1)
    //             ans = ans * base % mod;
    //         base = base * base % mod;
    //         exp >>= 1;
    //     }
    //     return ans;
    // }

        // public int minimumEffort(int[][] a) {
        //     int n = a.length, ans = 0;
        //     Arrays.sort(a, (x, y)->(x[1]-x[0] - (y[1]-y[0]))); // 从能量消耗最小的任务，到能量消耗较大的任务
        //     for (int i = 0; i < n; i++) 
        //         ans = Math.max(ans + a[i][0], a[i][1]);
        //     return ans;
        // }

        // public int countPairs(int[] a, int low, int high) { // 暴力解法，勉强能过
        //     int n = a.length, N = 2 * 10000 + 1;
        //     int [] cnt = new int [N];
        //     for (int v : a) cnt[v]++;
        //     int val = 0, ans = 0;
        //     for (int v : a) {
        //         for (int i = low; i <= high; i++) {
        //             val = v ^ i;
        //             if (val < N)
        //                 ans += cnt[val];
        //         }
        //         cnt[v]--;
        //     }
        //     return ans;
        // }
        // public int countPairs(int[] a, int low, int high) { // trie
        //     int n = a.length, ans = 0, maxHeight = 14; // 2^15=32768 ， 15 位二进制足够计算
        //     Trie t = new Trie();
        //     for (int v : a) {
        //         ans += t.search(t, maxHeight, v, high) - t.search(t, maxHeight, v, low-1);
        //         t.insert(v);
        //     }
        //     return ans;
        // }
        // class Trie {
        //     static final int h = 14; // 2^15=32768 ， 15 位二进制足够计算
        //     int cnt;
        //     Trie [] next;
        //     public Trie() {
        //         this.cnt = 0;
        //         this.next = new Trie[2];
        //     }
        //     public void insert(int v) {
        //         Trie r = this;
        //         for (int i = h; i >= 0; i--) {
        //             int j = (v >> i) & 1;
        //             if (r.next[j] == null)
        //                 r.next[j] = new Trie();
        //             r = r.next[j];
        //             r.cnt++;
        //         }
        //     }
        //     public int search(Trie r, int d, int v, int range) {
        //         if (r == null) return 0;
        //         if (d < 0) return r.cnt;
        //         int vb = (v >> d) & 1;
        //         int vr = (range >> d) & 1;
        //         if (vr == 1) {   // range在该位为1
        //             if (vb == 0) // num在该位为0，num2在该位为0的全部满足，为1的部分需要继续判断
        //                 return (r.next[0] == null ? search(r.next[1], d-1, v, range) : r.next[0].cnt + search(r.next[1], d-1, v, range));
        //             else // num在该位为1，num2在该位为1的全部满足，为0的需要继续判断
        //                 return (r.next[1] == null ? search(r.next[0], d-1, v, range) : r.next[1].cnt + search(r.next[0], d-1, v, range));
        //         } // range在该位为0，num2在该位必须与num一致
        //         return search(r.next[vb], d-1, v, range);
        //     }
        // }

        // long mul = 1_000_000_007;
        // long mod = (1l<<61)-1;
        // long[] pow;
        // public int longestCommonSubpath(int n, int[][] paths) { // 这个题要好好再理解消化一下
        //     int pl = paths.length;
        //     int max = Integer.MAX_VALUE;
        //     for(int i = 0; i < pl; i++)
        //         max = Math.min(max, paths[i].length);
        //     pow = new long[max+1];
        //     pow[0] = 1;
        //     for(int i = 1; i <= max; i++) 
        //         pow[i] = multipy(pow[i-1], mul);
        //     int le = 0, ri = max;
        //     while(le < ri) {
        //         int mid = le + (ri - le + 1) / 2;
        //         if(valid(paths, mid)) le = mid;
        //         else ri = mid - 1;
        //     }
        //     return le;
        // }
        // private boolean valid(int[][] paths, int len) {
        //     int pl = paths.length;
        //     Set<Long> prev = null;
        //     for(int i = 0; i < pl; i++) {
        //         Set<Long> hashs = rollingHashs(paths[i], len);
        //         if(prev == null) 
        //             prev = hashs;
        //         else {
        //             prev.retainAll(hashs);
        //             if(prev.size() == 0) return false;
        //         }
        //     }
        //     return true;
        // }
        // private Set<Long> rollingHashs(int[] arr, int len) {
        //     int l = arr.length;
        //     long[] hash = new long[l+1];
        //     for(int i = 1; i <= l; i++) 
        //         hash[i] = modulo(multipy(hash[i-1], mul) + (arr[i-1]+1));
        //     Set<Long> ret = new HashSet<>();
        //     for(int i = len-1; i < l; i++) {
        //         long soFarHash = hash[i+1];
        //         long prevHash = hash[i-len+1];
        //         prevHash = multipy(prevHash, pow[len]);
        //         long currHash = modulo(soFarHash - prevHash);
        //         ret.add(currHash);
        //     }
        //     return ret;
        // }
        // private long multipy(long a, long b) {
        //     long al = a&((1l<<31)-1), ah = (a>>>31);  // ???
        //     long bl = b&((1l<<31)-1), bh = (b>>>31);
        //     long ll = al * bl;
        //     long mid = al * bh + bl * ah;
        //     long hh = bh * ah + (mid >>> 31);
        //     long ret = modulo(modulo(2*hh+ll) + ((mid & (1l<<31)-1)<<31));
        //     return ret;
        // }
        // private long modulo(long hash) {
        //     while(hash >= mod)
        //         hash -= mod;
        //     while(hash < 0)
        //         hash += mod;
        //     return hash;
        // }
        // public int longestCommonSubpath(int n, int[][] a) { // BUG: 78/81 passed
        //     m = a.length;
        //     idx = 0;
        //     int r = Integer.MAX_VALUE, l = 1;
        //     for (int i = 0; i < m; i++)
        //         if (a[i].length < r) {
        //             r = a[i].length;
        //             idx = i;
        //         }
        //     while (l <= r) {
        //         int mid = l + (r - l) / 2;
        //         if (hasCommonPathOfLengthVal(mid, a)) 
        //             l = mid + 1;
        //         else r = mid - 1;
        //     }
        //     return l - 1;
        // } // The collision probability here will be = 10^5 / 10^11 = 10^-6, which is acceptable for current leetcode testcases.
        // // long base = 100001, mod = (long)(Math.pow(10,11) + 7);
        // // int m, idx;
        // static final int mod = (int)1e9 + 7;
        // int m, idx, base = 113;
        // boolean hasCommonPathOfLengthVal(int n, int [][] a) { // rolling hash to tell if has common subpath of length n
        //     long hash = 0;                                    // n: length 这种解法可能还存在hash冲突的问题
        //     Set<Long> sl = new HashSet<>();
        //     for (int i = 0; i < n; i++) 
        //         hash = (hash * base + a[idx][i]) % mod;
        //     sl.add(hash);
        //     long mul = quickMul(base, n-1);
        //     for (int i = n; i < a[idx].length; i++) {
        //         hash = ((hash - a[idx][i-n] * mul % mod + mod) % mod * base + a[idx][i]) % mod;
        //         sl.add(hash); // 遍历所有m条路径中最短的一条，并计算出所有长度为n的hash值 备用
        //     }
        //     int j = 0;
        //     for (int i = 0; i < a.length; i++) {
        //         if (i == idx) continue;
        //         long hb = 0; // the other hash: current path len n hashes
        //         for (j = 0; j < n; j++) 
        //             hb = (hb * base + a[i][j]) % mod;
        //         if (sl.contains(hb)) continue; 
        //         for ( j = n; j < a[i].length; j++) {
        //             hb = ((hb - a[i][j-n] * mul % mod + mod) % mod * base + a[i][j]) % mod;
        //             if (sl.contains(hb)) break;
        //         }
        //         if (j < a[i].length) continue;
        //         else return false;
        //     }
        //     return true;
        // }
        // long quickMul(long base, int exp) {
        //     long ans = 1;
        //     while (exp > 0) {
        //         if (exp % 2 == 1)
        //             ans = ans * base % mod;
        //         base = base * base % mod;
        //         exp >>= 1;
        //     }
        //     return ans;
        // }
        // long base = 100001, mod = (long)(Math.pow(10,11) + 7), pow[];  
        // public int longestCommonSubpath(int n, int[][] paths) { // 这个思路可以过，好好看一下
        //     int res = 0, min = Integer.MAX_VALUE;
        //     for(int[] path : paths) min = Math.min(min, path.length);
        //     pow = new long[min+1]; pow[0]++; 
        //     for(int i=1 ; i<=min ; i++)
        //         pow[i] = ( pow[i-1] * base ) % mod;
        //     for(int st=1, end=min, mid = (st+end)/2; st <=end ; mid = (st+end)/2){ 
        //         if( commonSubstring(paths, mid) ){
        //             res = mid;
        //             st = mid+1;
        //         }
        //         else
        //             end = mid-1;   
        //     }
        //     return res;
        // }
        // private boolean commonSubstring(int[][] paths, int l){
        //     HashSet<Long> set = rollingHash(paths[0],l);
        //     for(int i=1,n = paths.length; i<n ; i++){
        //         set.retainAll(rollingHash(paths[i],l));
        //         if(set.isEmpty()) return false;
        //     }
        //     return true;
        // }
        // private HashSet<Long> rollingHash(int[] a,int l){
        //     HashSet<Long> set = new HashSet<>();
        //     long hash = 0;
        //     for(int i=0 ; i<l ; i++)
        //         hash = ( hash*base + a[i] ) % mod;
        //     set.add(hash);
        //     for(int n=a.length, curr=l, prev = 0; curr<n ; prev++,curr++){
        //         hash = ( ( (hash*base)%mod - (a[prev]*pow[l])%mod + a[curr] ) + mod ) % mod;
        //         set.add(hash);
        //     }
        //     return set;
        // }

        
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        // int [][] a = new int [][] {{0,1,2,3,4},{2,3,4},{4,0,1,2,3}};
        int [][] a = new int [][] {{913,510,506,730,880,145,269,976,636,667,355,406,46,309,149,986,314,173,35,786,677,389,825,897,80,569,596,268,523,941,187,444,411,55,613,974,457,179,464,533,503,51,313,804,494,122,608,85,654,393,727,86,448,380,848,227,430,331,948,681,864,695,386,354,716,971,83,528,751,54,944,441,77,573,38,190,863,904,215,423,106,397,223,211,858,443,544,466,541,338,244,365,41,747,992,781,479,567,866,32,292,801,472,560,694,851,196,831,325,779,737,926,283,318,20,350,361,512,977,720,333,509,228,330,208,290,336,604,384,488,165,240,501,591,920,576,332,507,890,931,329,61,154,912,427,714,561,59,584,140,353,914,713,270,731,692,828,829,929,28,812,440,186,638,889,185,241,998,750,219,649,137,853,738,982,666,505,151,19,793,597,34,490,985,193,775,956,838,249,961,669,857,709,264,937,255,133,777,822,99,867,693,275,847,625,679,495,536,823,155,454,673,575,653,66,141,722,342,598,31,92,621,928,390,585,3,792,946,826,983,617,873,980,565,47,610,180,230,144,698,462,13,242,453,374,73,930,373,9,237,633,364,127,650,687,459,538,918,312,485,903,159,908,212,60,174,404,949,978,407,644,113,748,950,136,524,774,477,586,123,433,258,33,845,429,899,753,434,383,274,840,267,532,834,696,958,830,370,21,87,712,301,239,2,813,463,114,859,339,819,514,537,924,628,735,672,766,319,251,547,306,745,282,778,743,566,357,218,199,780,755,17,942,960,648,795,426,917,726,993,82,376,742,233,439,68,221,932,238,191,194,758,571,701,540,981,65,381,486,839,662,497,768,962,172,594,200,849,344,952,142,799,26,95,916,367,202,682,243,11,707,771,217,741,422,770,181,45,349,216,892,634,483,587,169,896,62,518,939,475,415,401,44,277,88,105,345,590,531,733,307,431,554,878,476,321,935,25,762,48,496,498,936,854,868,671,728,678,419,821,808,539,220,579,652,715,189,317,656,645,451,188,405,158,417,925,740,81,222,129,911,388,250,639,706,470,265,534,456,806,520,347,248,206,446,861,400,907,796,157,247,413,736,279,299,303,789,623,308,837,79,395,615,311,810,131,968,824,461,964,261,609,152,117,63,209,870,548,542,375},{375,542,548,870,209,63,117,152,609,261,964,461,824,968,131,810,311,615,395,79,837,308,623,789,303,299,279,736,413,247,157,796,907,400,861,446,206,248,347,520,806,456,534,265,470,706,639,250,388,911,129,222,81,740,925,417,158,405,188,451,645,656,317,189,715,652,579,220,539,808,821,419,678,728,671,868,854,936,498,496,48,762,25,935,321,476,878,554,431,307,733,531,590,345,105,88,277,44,401,415,475,939,518,62,896,169,587,483,634,892,216,349,45,181,770,422,741,217,771,707,11,243,682,202,367,916,95,26,799,142,952,344,849,200,594,172,962,768,497,662,839,486,381,65,981,540,701,571,758,194,191,238,932,221,68,439,233,742,376,82,993,726,917,426,795,648,960,942,17,755,780,199,218,357,566,743,778,282,745,306,547,251,319,766,672,735,628,924,537,514,819,339,859,114,463,813,2,239,301,712,87,21,370,830,958,696,834,532,267,840,274,383,434,753,899,429,845,33,258,433,123,586,477,774,524,136,950,748,113,644,407,978,949,404,174,60,212,908,159,903,485,312,918,538,459,687,650,127,364,633,237,9,373,930,73,374,453,242,13,462,698,144,230,180,610,47,565,980,873,617,983,826,946,792,3,585,390,928,621,92,31,598,342,722,141,66,653,575,673,454,155,823,536,495,679,625,847,275,693,867,99,822,777,133,255,937,264,709,857,669,961,249,838,956,775,193,985,490,34,597,793,19,151,505,666,982,738,853,137,649,219,750,998,241,185,889,638,186,440,812,28,929,829,828,692,731,270,713,914,353,140,584,59,561,714,427,912,154,61,329,931,890,507,332,576,920,591,501,240,165,488,384,604,336,290,208,330,228,509,333,720,977,512,361,350,20,318,283,926,737,779,325,831,196,851,694,560,472,801,292,32,866,567,479,781,992,747,41,365,244,338,541,466,544,443,858,211,223,397,106,423,215,904,863,190,38,573,77,441,944,54,751,528,83,971,716,354,386,695,864,681,948,331,430,227,848,380,448,86,727,393,654,85,608,122,494,804,313,51,503,533,464,179,457,974,613,55,411,444,187,941,523,268,596,569,80,897,825,389,677,786,35,173,314,986,149,309,46,406,355,667,636,976,269,145,880,730,506,510,913}};

        int r = s.longestCommonSubpath(1000, a);
        System.out.println("r: " + r);
    }
}






