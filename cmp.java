import com.TreeNode;            

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
import static java.util.stream.Collectors.toMap;
public class cmp {
    public static class Solution {
        
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 亲爱的表哥的活宝妹的脑袋，【好疯呀】。。。亲爱的表哥的活宝妹，记错题目了？是真的记错题目了，是另外一个
//         class Bit {
//             int [] f; // 【0/1】单点值：标记，一个下标序号的【存在与否】或说有效性
//             int n;
//             public Bit(int n) { // 实际插入值范围：【1,n-2】＋1【不是永远要＋1!!】==> 【2,n-1】。维度够用
//                 this.n = n;
//                 f = new int [n];
//             }
//             // 【单点修改】：【自底向上】，效果累加到、各后续父节点
//             void update(int i, int v) {
//                 for (; i < n; i += lowBit(i))
//                     f[i] += v;
//             }
//             // 【区间和】：【1,i】区间和. 【自顶向下】：自最顶最右单点或小区间，累加其前段小区间，去求和累加区间和
//             int preSum(int i) { 
//                 int r = 0;
//                 while (i > 0) {
//                     r += f[i];
//                     // 下面两行，效果等价：
//                     // i -= lowBit(i);
//                     i &= (i-1); // i = (i & (i-1));
//                 }
//                 return r;
//             }
//             // 【区间，求：和、积、异或值】等
//             int query(int l, int r) { // 求区间【l,r】的和
//                 if (l > r) return 0; // 这个条件要：当平移左右端点时，可能发生 l>r
//                 return preSum(r) - preSum(l-1);
//             }
//             int lowBit(int x) { // 【破烂位操作】：不知道它回字的几样写法。。
//                 return x & -x;
//             }
//         }
//         public List<Integer> countOfPeaks(int[] a, int[][] qs) {
//             int n = a.length;
//             Bit f = new Bit(n); // 实际插入值范围：【1,n-2】＋1==> 【2,n-1】
//             Set<Integer> s = new HashSet<>(); // 【 bit 树状数组】中：有效点集
//             // 【BIT 树状数组】数据预处理：填充初始数据
//             for (int i = 1; i < n-1; i++) 
//                 if (a[i-1] < a[i] && a[i] > a[i+1]) {
//                     // 当【BIT 树状数组】里的下标，有效范围，落在【1,n-1】，就不需要，再永远＋1 了呀。。。
//                     f.update(i, 1); // <<<<<<<<<<<<<<<<<<<< i+1: 笨宝妹，这里，为什么永远 +1？
// // 下面：不曾【纪录备案】：添加过的【下标集合】Set<Integer> s, 后面就又【暴力了 2 遍】！！
//                     s.add(i);
//                 }
//             // 【在线解题】：实时动态更新数组、实时动态、维护BiT 树状数组
//             List<Integer> li = new ArrayList<>();
//             for (int [] q : qs) {
//                 if (q[0] == 1) {
//                     // 答案要求：开区间（q[1],q[2]），不包括2 个端点
//                     // 即：     闭区间【q[1]+1,q[2]-1】，
//                     // 对应【树状数组】的下标为：【q[1]+2, q[2]】；不加1 的话是，如上如下
//                     li.add(f.query(q[1]+1, q[2]-1));
//                     continue;
//                 }
//                 int i = q[1], v = q[2];
//                 if (a[i] == v) continue;
//                 // 【实时更新】：a[i], 仅只影响【i-1,i,i+1】三个点，且在【1,n-2】范围内
//                 int l = Math.max(1, i-1), r = Math.min(n-2, i+1); // 界定范围
//                 // 先，消除——完全擦除，之前【预处理】时，可能最多存在的3 个点
//                 for (int j = l; j <= r; j++) 
//                     if (s.contains(j)) {
//                         s.remove(j);
//                         f.update(j, -1); 
//                     }
//                 // 再：更新数据
//                 a[i] = v;
//                 // 再：更新，题解数据结构，对数据变更的维护
//                 for (int j = l; j <= r; j++)
//                     if (a[j-1] < a[j] && a[j] > a[j+1])
//                         if (!s.contains(j)) {
//                             f.update(j, 1);
//                             s.add(j);
//                         }
//             }
//             return li;
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 找到那个，记忆里唯一一个、要用2 个BIT 来解题的题目：
        // // 可是，现在这个破烂题目，要怎么去想呢？
        // // 实在不会想，就先，去看，破烂 leetcode 给出的提示：看，能想出点儿什么吗？
        // // 亲爱的表哥的活宝妹，现在想起来、会写了吗？亲爱的表哥的活宝妹、笨宝妹！！！
        // // 【在线解题】：实时更新，实时求解，就需要借助【必要的数据结构】来实现O(logN) 【单点更新】【区间更新、或查询】。这样才不容易超时
        // // 2 个BIT: 1 个纪录，不同片段的长度【1,50000】；另一个纪录：各种不同长度的【出现频率】，这样才能，都O(logN) 实时更新，实时全长区间查询
        // // 【单点更新】实现细节不懂：改变一个下标值，如何影响，不同片段的长度与频率？
        // final int N = 50001;
        // public class  Bit {
        //     int [] f; // 标记：【1,50000】的长度、其【01 存在与否】OK？还是【1,n-1】标记，各下标长度的【实际长度值】？不需要实际数值，就是【01】存在与否
        //     int n;
        //     public Bit () {
        //         this.n = N;
        //         f = new int [N];
        //     }
        //     // 【单点修改】：存在，不存在
        //     void update(int i, v) {
        //         while (i < n) {
        //             f[i] += v;
        //             i += lowBit(i);
        //         }
        //     }
        //     int lowBit(int x) {
        //         return x & -x;
        //     }
        // }
        // public List<Integer> numberOfAlternatingGroups(int [] a, int[][] qs) {
		// 	int n = a.length;
        //     int [] f = new int [2 * n]; // 环形数组，特殊处理：重复一遍，再数数。。
        //     for (int i = 0; i < n; i++)
        //         f[i+n] = a[i];
        //     int [] g = new int [n]; // dp 数组
        //     Arrays.fill(g, 1); // 最小长度为 1
        //     for (int i = 1; i < 2 * n; i++) 
        //         if (f[i] != f[i-1])
        //             g[i] = g[i-1] + 1;
        //     int [] r = new int [N];
        //     for (int i = n; i < 2 * n; i++) 
        //         r[g[i]]++;
        //     // 初始化：离线数据，一次填充
        //     Bit f = new Bit(), ff = new Bit();;
        //     for (int i = 3; i < N; i++) 
        //         if (r[i] > 0) { // 题目说：仅只查询【3,50000】长度大小
        //             f.update(i, 1); // 【片段长度 i】：有效取值为【1==>3,50000】
        //             ff.update(i, r[i]); // 【片段频率 r[i]】：
        //         }
        //     // 【在线修改更新、实时查询】：现在，就到亲爱的表哥的活宝妹，得自己去想，
        //     // 怎么分析：修改一个下标 a[i], 对【i-1,i,i+1】片段长度、片段频率，可能的影响了。。笨宝妹。。
        //     // 亲爱的表哥的活宝妹，先去吃饭浇地，平时浇地要1 小时左右太慢了，今天快点儿弄，可是不要太晚，像先前一不小心天就黑了、黑得太快太早了。。            
        //     // 亲爱的表哥的活宝妹，今天晚上，是一定想不出、怎么分析这个题目了
        //     // 亲爱的表哥的活宝妹，今天晚上先写点儿别的，明天或是改天再写个难题目
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，笨宝妹：一早上，明明感觉看懂了，为什么自己再写时，就又感觉，全部忘记掉了，没能理解透彻？？？这是【读源码】与【自己手写】的【本质区别】笨宝妹！！
        // // 【定义 f[i]】：求S 与 S[i:n-1] 后缀串的、最长公共前缀、长度
        // // 对于 i，我们称区间 [i,i+z[i]-1] 是 i 的 匹配段，也可以叫 Z-box。
        // // 算法的过程中，我们【维护右端点最靠右的匹配段】
        // // 为了方便，记作【l,r】。根据定义，s[l,r] 是 s 的前缀。【l,r】标记：一段、某个长度【r-l+1】的S 的前缀的【左右端点】
        // // 在计算 z[i] 时我们保证 l <= i。初始时 l = r = 0。
        // // 在计算 z[i] 的过程中：
        // //     如果 i <= r，那么根据 [l,r] 的定义有 s[i,r] = s[i-l,r-l] 【相当于，往左平移 l 长度】，因此 z[i] >= min(z[i-l],r-i+1)。这时：
        // //         若 z[i-l] < r-i+1，则 z[i] = z[i-l]。
        // //         否则 z[i-l] > r-i+1，这时我们令 z[i] = r-i+1，然后暴力枚举下一个字符扩展 z[i] 直到不能扩展为止。
        // //     如果 i > r，那么我们直接按照朴素算法，从 s[i] 开始比较，暴力求出 z[i]。
        // //     在求出 z[i] 后，如果 i+z[i]-1>r，我们就需要更新 [l,r]，即令 l=i, r=i+z[i]-1。
        // int [] calcZ(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] f = new int [n];
        //     int l = 0, r = 0; // 【l,r】只【自左向右】遍历一次O(N)
        //     for (int i = 1; i < n; i++) {
        //         // 遍历到了【l,r】的、【不能延至、最右端点】的某下标，且S[l,r] ＝ S[i-l,r-l] 时，
        //         // 【不能延至、最右端点】意味着 S【i-l,i-l+f[i-l]）！最右端点不匹配？？
        //         // 上面，亲爱的表哥的活宝妹，又想到，某个死角里去了吗？？明天再想这个
        //         if (i <= r && f[i-l] < r-i+1) 
        //             f[i] = f[i-l];
        //         // else if (i <= r && f[i-l] >= r-i+1 || i > r)
        //         else { // 如果i > r 则【f[i] = 0 >= r-i+1】
        //             f[i] = Math.max(0, r - i + 1);
        //             // 下面一行，自己【写错了】：【BUGlly-coding】：当 i > r 时 f[i]=0, 【l,r】盒，虽然是前缀，但可能是【太短小的前缀】而出【BUG】
        //             // 当【l,r】是前一个【狠短小的片段，长度为 len】，这个【短小片段】，对于【当前左端点为 i】，但右端点可能会延伸、超出到 >=i+len 时，就会出【BUG】出错。。
        //             // while (i + f[i] < n && s[i+f[i]] == s[i+f[i]-l]) f[i]++; 
        //             while (i + f[i] <= n && s[f[i]] == s[i+f[i]-1]) f[i]++; // 所以，避免 bug, 就是与S【0:i】相比较
        //         }
        //         // 当前【左端点为 i】时，查找、扩展到一个、更往右的【延展右端】：
        //         // 不一定是【最长长度、但、最右右端点！】，
        //         // 同时更新【最右端点盒的、左右端点】
        //         if (i + f[i] - 1 > r) { 
        //             l = i;
        //             r = i + f[i] - 1;
        //         }
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 贱鸡、贱畜牲，亲爱的表哥的活宝妹，讨厌什么题目，贱鸡、贱畜牲就出什么破烂、狗屁题目，它们的贱鸡、贱畜牲，真贱！！！
        // public int [] minBitwiseArray(List<Integer> li) {
        //     int n = li.size();
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++)
        //         if (li.get(i) % 2 == 0)
        //             f[i] = -1;
        //         else {
        //             // int v = li.get(i);
        //             f[i] = getMin(li.get(i)-1);
        //         }                    
        //     return f;
        // }
        // int getMin(int v) {
        //     for (int i = 0; i < v; i++) {
        //         if ((i | (i + 1)) == v)
        //             return i;
        //     }
        //     return -1;
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，晚点儿再写这个破烂题目。。亲爱的表哥的活宝妹中，不喜欢这个破烂题目，不写这个题目！！
        // public int[] minBitwiseArray(List<Integer> li) {
        //     int n = li.size();
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++)
        //         if (li.get(i) % 2 == 0)
        //             f[i] = -1;
        //         else {
        //             int v = li.get(i);
        //             int r = Integer.bitCount(v);
        //             // if (r == String.valueOf(v).length())
        //             if (r == Integer.toBinaryString(v).length())
        //                 f[i] = getMin(v);
        //             else {
        //                 f[i] = findMin(v);
        //             }
        //         }                    
        //     return f;
        // }
        // int findMin(int v) {
        //     int r = 0;
        //     for (int i = 30; i >= 0; i--) {
        //         if (((v >> i) & 1) == 1) {
        //             // if ((1 << i) - (v - (1 << i)))
        //             if ((1 << i) + 1 == v)
        //                 return 1 << i;
        //             r |= (1 << i);
        //             while ((r | r+1) < v) r++;
        //             return (r | r+1) == v ? r : ((v & 1) == 1 ? v-1 : -1);
        //         }
        //     }
        //     return -1;
        // }
        // int getMin(int v) {
        //     System.out.println("v: " + v);
        //     for (int i = 30; i >= 0; i--) {
        //         if (((v >> i) & 1) == 1)
        //             // if ((1 << i) + 1 == v)
        //             //     return 1 << i;
        //             return Math.min(1 << i, v - (1 << i));
        //     }
        //     return -1;
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 亲爱的表哥的活宝妹，觉得，这个题目狠难：是【字符串】文本串里，多点匹配模式串【且模式串，是子序列，不是子串，更难！】，结合了【动规】：
//         // 有序数组狠帮助，可以实现【动规】求全局最大
//         // 但是可以试着想一想！！
//         // 先，想明白：【子序列】【子串】，这里有区别吗？
//         // 再，想明白：是【前缀匹配】还是【后缀匹配】？
//         // 【左三圈右三圈？】：
//         //     【自左向右】遍历一遍，找【模式序列】每下标字符的【最左有效位】
//         //     【自右向左】遍历一遍，找【模式序列】每下标字符的【最右有效位】
//         // 然后，在【最左、最右】有效位，之间的序列，什么情况下，可以删除、且【动规】全局最大？
//         // 【模式序列】：每个字符，【前缀、后缀匹配】 fail 跳转，前跳、后跳，是否越界？
//         // 【有序数组、动规】：如何设计，实现？
//         // 这个题目：其实，想明白了，不难，跟先前一个 dfs 题目狠像【匹配遍历2 个串，且排除第三个串，含不匹配重新跳位】【TODO】把这个题目找出来重写一遍，但这个要动规
// // 亲爱的表哥的活宝妹，今天上午，剩余 3 个相对难里，亲爱的表哥的活宝妹，能够瓣出来1 题，就算，亲爱的表哥的活宝妹，还是在动脑袋的。。亲爱的表哥的活宝妹，活宝笨宝妹！！
//         // 亲爱的表哥的活宝妹，思路基本就只能够想到这么多了，看下【破烂提示】，再想再写。。。【破烂提示】对把这个题目想得更多的亲爱的表哥的活宝妹，提示跟没提示、木有半点儿区别
//         // 亲爱的表哥的活宝妹，笨宝妹：下面 z 数组，匹配的是：子串，不是【子序列】，但是是适用的
//         int [] z_function(String S) { // z function
//             int n = S.length(); char [] s = S.toCharArray();
//             int [] f = new int [n];
//             for (int i = 0, l = 0, r = 0; i < n; i++) {
//                 if (i <= r)
//                     f[i] = f[i-l];
//                 else {
//                     f[i] = Math.max(0, r - i + 1);
//                     while (i + f[i] <= n && s[f[i]] == s[i+f[i]-1])
//                         f[i]++;
//                 }
//                 if (i + f[i] - 1 > r) {
//                     l = i;
//                     r = i + f[i] - 1;
//                 }
//             }
//             return f;
//         }
//         void prefix_function(String S) { // pi function: 
//             int n = S.length(), j = 0;
//             char [] s = S.toCharArray();
//             for (int i = 1; i <= n; i++) {
//                 j = g[i-1];
//                 while (j > 0 && s[i] != s[j])
//                     j = g[j-1];
//                 if (j > 0 && s[i] == s[j])
//                     j++;
//                 g[i] = j;
//             }
//         }
//         int [] prefix_function_PreProcessing(String S) { // pi function: 弄个【自动机】试试
//             int n = S.length();
//             char [] s = S.toCharArray();
//             prefix_function(S);
//             for (int i = 0; i < m; i++) 
//                 for (int j = 0; j < 26; j++) {
//                     if (i > 0 && 'a'+j != s[i])
//                         f[i][j] = f[g[i-1]][j];
//                     else
//                         f[i][j] = i + ('a'+j == s[i]);
//                 }
//         }
//         void prefix_function_AC_toIdx(int idx) { // pi function: 弄个【自动机】试试
//             // 链接，预处理到 idx
//             for (i; i < idx; i++) 
//                 for (int j = 0; j < 26; j++) {
//                     if (i > 0 && 'a'+j != s[i])
//                         f[i][j] = f[g[i-1]][j];
//                     else
//                         f[i][j] = i + ('a'+j == s[i]);
//                 }
//         }
//         void prefix_function_Update_fromIdx(int idx) { // pi function:
//             int j = 0;
//             for (int i = idx; i <= m+n; i++) {
//                 j = g[i-1];
//                 while (j > 0 && s[i] != s[j])
//                     j = g[j-1];
//                 if (j > 0 && s[i] == s[j])
//                     j++;
//                 g[i] = j;
//             }
//         }
//         boolean prefix_function_AC_FromIdx(int idx) { // pi function: 弄个【自动机】试试
//             //pi 函数，实时更新 g[i]
//             prefix_function_Update_fromIdx(idx);
//             boolean match = false;
//             int j = i;
//             for (j; j < m+n; j++)
//                 for (int k = 0; k < 26; k++) {
//                     if (j > 0 && 'a'+k != s[j])
//                         f[j][k] = f[g[j-1]][k];
//                     else {
//                         f[j][k] = j + ('a'+k == s[j]);
//                         if (f[j][k] >= m && !match) {
//                             match = true;
//                             return true;
//                         }
//                     }
//                 }
//             return true;
//         }
//         StringBuilder s;
//         int [][] f; // 弄个【自动机】版本的，试试
//         int [] g;
//         int m, n, i; // idx for S
//         int [] r; // operation or not 
//         // 亲爱的表哥的活宝妹，想要整个【自动机】先【暴力】一遍，体会一下，再作后续修改。。
//         public int maxRemovals(String S, String P, int [] a) {
//             m = P.length(); n = S.length(); 
//             s = new StringBuilder(P + S);
//             f = new int [m+n][26];
//             // 【自动机】：预处理【0,m-1】数据
//             prefix_function_PreProcessing(P+S);
//             // 遍历操作：自动机，多次重复处理
//             r = new int [m];
//             i = 0;
//             for (int k = 0; k < a.length; k++) {
//                 int j = a[k];
//                 if (i < j) { // 可操作
//                     prefix_function_AC_toIdx(j);
//                     // i 会：向右遍历，到 i==j 且未处理
//                     // 先，操作。
//                     // 亲爱的表哥的活宝妹，笨宝妹，【暴力2^m】即便是【AC 自动机】，就不超时了吗？写到这里，亲爱的表哥的活宝妹，今天终于不想再写这些恶心吧啦的破烂的题目了
//                     s[i+m] = '_'; // pi 函数，也要实时更新
//                     if (prefix_function_AC_FromIdx(j)) {
//                     }
//                 } else { // j <= i: 结果未必
//                 }
//             }
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] findXSum(int[] a, int k, int x) {
        //     int n = a.length;
        //     int [] f = new int [n-(k-1)], r = new int [51];
        //     // TreeMap<Integer, Integer> m = new TreeMap<>((x, y)->);
        //     for (int i = 0, j = 0; i < n; i++) {
        //         r[a[i]]++;
        //         if (i < k-1) continue;
        //         f[j] = getXMostFreqSum(r, x);
        //         r[a[j]]--;
        //         j++;
        //     }
        //     return f;
        // }
        // int getXMostFreqSum(int [] r, int v) {
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 1; i < r.length; i++)
        //         if (r[i] != 0)
        //             l.add(new int [] {i, r[i]});
        //     Collections.sort(l, (x, y)->y[1] != x[1] ? y[1] - x[1] : y[0] - x[0]);
        //     int f = 0;
        //     for (int i = 0; i < Math.min(v, l.size()); i++) 
        //         f += l.get(i)[0] * l.get(i)[1];
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥，亲爱的表哥的活宝妹，觉得：这是，他们的贱鸡、贱畜牲，在检测亲爱的表哥的活宝妹
        // // 【二叉树】：对现在的亲爱的表哥的活宝妹，真如亲爱的表哥的活宝妹，所感觉的：
        // // 以前，亲爱的表哥的活宝妹，觉得，链条链表、最好写，加加减减、就可以了
        // // 后来，亲爱的表哥的活宝妹，觉得，二叉树、最好写，轻轻松松，写题目可以不用带脑袋 ...
        // // 现在，亲爱的表哥的活宝妹，觉得，天下的树长得都狠像，看懂掌握原理，写出来、不带冒一点儿汗的。。。
        // // 亲爱的表哥，亲爱的表哥的活宝妹，觉得：这是，他们的贱鸡、贱畜牲，在检测亲爱的表哥的活宝妹
        // // 【二叉树】：对现在的亲爱的表哥的活宝妹，真如亲爱的表哥的活宝妹，所感觉的：【二叉树】，在现在的亲爱的表哥的活宝妹，真有那么简单吗？
        // // 真的有！解题的第一思路，都是对的！！只是昨天被瞎吃嗨胀胀傻的亲爱的表哥的活宝妹，细节上出小错误。。。
        // // 亲爱的表哥，昨天晚上，胀傻的亲爱的表哥的活宝妹，一写对思路，它们的贱鸡、贱畜牲，就瞬间即刻，将题目的难度的【标记】巨副降低了
        // // 它们的贱鸡、贱畜牲，经常这么贱恶地干——亲爱的表哥的活宝妹，想不出写不到的，永远【标记】极难，试图想要劝人赶人快滚吧、去谋生。。。亲爱的表哥的活宝妹一旦会写，永远【标记】最简单、不带任何挑战的0难度，写出来，也什么也不是什么也不算什么也不值。。。他们的贱鸡、贱畜牲 leetcode 贱鸡、贱畜牲，真贱！！！
        // // 亲爱的表哥的活宝妹，觉得，他们的贱鸡、贱畜牲 leetcode,是在赶人远离专业，他们的贱鸡、贱畜牲，真贱！！！
        // // 这么简单的题目，亲爱的表哥的活宝妹昨天，被自己前天晚上、昨天的饮食胀傻，晚上细节上出错了。。它有任何难度吗？！！
        // public class Node {
        //     TreeNode f;
        //     Node l, r; // 左右子节点
        //     boolean i; // is perfect binary tree
        //     int rr;    // size
        //     public Node(TreeNode root) {
        //         f = root;
        //         l = r = null;
        //         i = false;
        //         rr = 1;
        //     }
        // }
        // Node buildTree(TreeNode r) {
        //     if (r == null) return null;
        //     Node f = new Node(r);
        //     // System.out.println("f.f.val: " + f.f.val);
        //     if (r.left == null && r.right == null) {
        //         f.i = true;
        //         g[f.rr]++;
        //         return f;
        //     }
        //     if (r.left != null)
        //         f.l = buildTree(r.left);
        //     if (r.right != null)
        //         f.r = buildTree(r.right);
        //     if (f.l != null && f.r != null && f.l.i && f.r.i && f.l.rr == f.r.rr) {
        //         f.i = true;
        //         f.rr += f.l.rr * 2;
        //         g[f.rr]++;
        //     } else
        //         f.rr += (f.l != null ? f.l.rr : 0) + (f.r != null ? f.r.rr : 0);
        //     return f;
        // }
        // int [] g;
        // public int kthLargestPerfectSubtree(TreeNode r, int k) {
        //     int N = 2027;
        //     g = new int [N];
        //     Node f = buildTree(r);
        //     if (f.rr < k) return -1; // 裁枝：最初步少量
        //     for (int i = N-1; i > 0 && k >= 1; i--) {
        //         if (g[i] > 0) {
        //             k -= g[i];
        //             if (k <= 0) return i;
        //         }
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：这个破烂动规题目，狠简单呀。。。N[1,1000] 数据规模，也这么小，随便写【记忆化深搜】、怎么写都能过的呀。。。
        // // 笨宝妹：不要忘记，还要记两个人的得分。。
        // // 记【两个人、各自得分f[i-1000][j-1000][k-1000]】
        // // ＝＝》优化，不如记
        // // 【B-A 的差值得分f[i-1000][j-2000]】，就不会超时TLE 了
        // // 那么，笨宝妹，就不用再笨笨去写【记忆化深搜】，直接【动规】就可以过了！！！
        // // 亲爱的表哥的活宝妹，笨宝妹，还是要先写【记忆化深搜】，写得比较顺畅。。。
        // // 亲爱的表哥的活宝妹，把一个【某个方向、自底向上】的、常规题型的、1 个【记忆化深搜】
        // // 这个题目，拆成了2 个【记忆化深搜】：一个【自顶向下】算分数，一个【自底向上】算0 差分、后序列的【方法数】
        // // 解题：【自顶向下：0->n-1】累积差分＋同步统计【自顶向下】的该差分总方法法 * （【0,n-1】任何 i 出现 f 差分》0 时，剩余序列差值为0平分的、总方法数）
        // // 但，不一定，必须。想错了，想得不对，分成两步，会计算重复，所以不对！！！
        // // 【TODO】：【自顶向下】累积分数 f[n][3] 这里，还有点儿想不清楚，晚点儿再写这个破烂题目
        // static final int mod = (int)1e9 + 7;
        // public int countWinningSequences(String S) {
        //     n = S.length(); s = S.toCharArray();
        //     // 数据预处理：根据A 序列 S
        //     // 不必：【自左向右】：【0,n-1】与A 【最终平分】序列数
        //     // 【自右向左】：【n-1,0】与A 【最终平分】序列数，感觉，这个好用！！！
        //     // 方向不同，同样长度的、方法数不同，是由 A 的出牌S 决定的
        //     for (int i = 0; i < n; i++)
        //         if (s[i] == 'W') s[i] = 'G';
        //     t = new char [n]; // 倒序的
        //     for (int i = 0; i < n; i++)
        //         t[n-1-i] = s[i];
        //     f = new Integer [n];
        //     dfs()
        //     // 用2 个数组：一个记【差值分数？、滚动数组】，一个记【方法数】,
        //     // 【自顶向下】动规
        //     // 写过的【刷房子、动规】：Bob 每相临两字符，不重复！！
        //     int [][] f = new int [2][3], ff = new int [n+1][3]; // Bob: 3 种，可能的出牌【EFG/W】＝【012】
        //     Arrays.fill(ff[0], 1);
        //     for (int i = 0; i < n; i++) {     // 遍历：A 的出牌
        //         int k = s[i] - 'E'; // Alice
        //         for (int j = 0; j < 3; j++) { // 遍历Bob: 所有可能的出牌
        //             // 更新：第 i+1 轮，B 【012】出牌的、【得分】
        //             f[i&1][j] = 
        //             if (k == 0) {
        //             }
        //         }
        //     }
        // }
        // char [] s, t;
        // int n;
        // Integer [] f;
        // // Integer [][] f, ff;

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 亲爱的表哥的活宝妹，不是把【记忆化深搜】写得【深入骨髓】般万能吗？怎么这个【记忆化深搜】认不出来了？！！！
//         public int maxRemovals(String S, String P, int [] a) {
//             int m = P.length(), n = S.length(), o = a.length; si = S.toCharArray();
// // 【模式序列】当前下标 i字符 c: 左一位，存在的下标 j, 右一位，存在的下标 k? 感觉不对，需要KMP 失败 fail 指针，O(1) 指向【前一位】或【后一位】
//             int [] g = prefix_function(P + S);
//             int [] gg = prefix_function(new StringBuilder(P).reverse().toString() + new StringBuilder(P).reverse().toString()); // 倒着来，数组还要倒一下
//             // 这不就成了，建立倒序的【状态机】了吗？可是【状态机】怎么【动规】最大操作数呢？
//             // 最大操作数：是什么意思？
//             ll = new int [m]; rr = new int [m];  // 先记：【最左】【最右】出现的下标
//             Arrays.fill(f, -1); Arrays.fill(g, -1);
//             for (int j = 0; j < n; j++) {
//                 int i = s[j] - 'a';
//                 if (ll[i] == -1) ll[i] = j;
//             }
//             for (int j = n-1; j >= 0; j--) {
//                 int i = s[j] - 'a';
//                 if (rr[i] == -1) rr[i] = j;
//             }
//             s = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
//             sp = new StringBuilder(P);
//             for (int i = n-1; i >= 0; i--) // 倒序遍历：同步更新 sp
//                 if (f[i] == g[i] && f[i] != -1 && s.contains(i)) {
//                     sp.deleteCharAt(i);
//                     sp.insert(i, '-'); // 不能把它的、【前后下标】给弄变了
//                     s.remove(i);
//                 }
//             // 模式序列：每个字符，全局唯一，不可删除任何
//             if (s.size() == 0) return 0; 
//             t = new TreeMap<>();
//             int j = 0;
//             for (int v : s) {
//                 while (j < m && a[i] != v) j++;
//                 t.put(v, j);
//             }
//             // 【动规】：对可能可以删除的 m 个下标，动规，求全局最大 
//             // int [] dp = new int [sp.length()+1];
//             f = new Integer [m+1][2]; // 后一位标记：不操作0 ，与操作 1
//             int [][] r = new int [m][2];
//             // 遍历： a[i] 操作数组, 怎么维护 S 文本串，当前遍历的下标 j ？
//             int j = 0, pj = -1; // j 【自左向右】全局遍历一遍S
//             for (int i = 0; i < m; i++) { // 【从左往右】与【从右往左】遍历，效果一样，没不同
//                 if (!s.contains(a[i])) {  // 这里，S 文本串，当前遍历的下标 j 也要右移才对
//                     for (int k = 0; k < 2; k++) 
//                         f[i][k] = f[i-1][k];
//                     continue;
//                 }
//                 // j: ll[i] rr[i] g[j] gg[j]
//                 // 不使用：当前删除操作, 同步维护 [0/1] 下Sj 下标
//                 for (int k = 0; k < 2; k++) {
//                     f[i][0] = f[i-1][k];
//                     f[i][]
//                 }
//                 // 使用：当前删除操作，维护 S 下标 j, 需要判断，当前使用的合法性。。
//                 // 【贪心】：永远把 j 维护到最小值, 保留右侧的最大匹配空间、可能性 
//                 // j 因为【数据预处理】，是小步、连蹦带跳、跳着、向右遍历的
//                 int idx = a[i];
//                 // 先，判断，当前操作的可行性，当前可行的前提下，才删除
//                 // 两个 pi 数组：界定两端点，【最左、最右】可行性位置。不是 z 数组，是两个 pi 数组
//                 // while (j < n && s[j] != sp.charAt(i)) j++; // // <<<<<<<<<<<<<<<<<<<<
//                 if (j < gg[n-1-i+m && gg[n-1-i+m] > idx) { // 右边，至少还存在1 个可用点，但不能保证全局可以匹配完，仅只【局部、仍有解】
//                     f[i][1] = 1 + Math.max(f[i-1][0], f[i-1][1]);
//                     if (j < g[i+m]) { // S 下标不一定对。。。
//                         j = g[i+m]+1;
//                         // 实时更新 s[j]-'#'                        
//                     }
//                     j = Math.max(idx+1, j)
//                 }
//             }
//             return 0;
//         }
//         Integer [][] f;
//         Set<Integer> s; char [] si;
//         StringBuilder sp;
//         TreeMap<Integer, Integer> t;
//         int [] g, gg, ll, rr;
//         int m, n;
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【自顶向下】的【记忆化深搜】
        // public int maxRemovals(String S, String T, int[] a) {
        //     n = S.length(); m = T.length();
        //     s = S.toCharArray(); t = T.toCharArray();
        //     si = new HashSet<Integer>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     f = new Integer [n][m];
        //     dfs(n-1, m-1);
        //     return f[n-1][m-1];
        // }
        // Integer [][] f;
        // Set<Integer> si = new HashSet<>();
        // char [] s, t;
        // int m, n;
        // int dfs(int i, int j) {
        //     if (i < j) return Integer.MIN_VALUE;
        //     // if (i < 0 && j < 0) return 0; // 写错了，未必同时 < 0
        //     // if (i < 0 || j < 0) return 0; // 【写错了】：必须把 i 遍历到 < 0, 才能保证全局最优解
        //     // 一定要把 i 遍历完，才能求到【全局最优解】
        //     if (i < 0) return 0;
        //     if (j >= 0 && f[i][j] != null) return f[i][j];
        //     int r = Integer.MIN_VALUE;
        //     // 使用：当前匹配
        //     if (j >= 0 && s[i] == t[j])
        //         r = Math.max(r, dfs(i-1, j-1));
        //     // 不使用：当前的匹配
        //     r = Math.max(r, dfs(i-1, j) + (si.contains(i) ? 1 : 0));
        //     if (j >= 0) f[i][j] = r;
        //     return r;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 它说机器说，这个方法，叫【递推】，不叫【动规】！！亲爱的表哥的活宝妹，一直以为，这个方法叫【动规】，并且 bigOO 不一样。。。
        // // 【自顶向下】的【递推】
        // public int maxRemovals(String S, String T, int[] a) {
        //     int n = S.length(), m = T.length();
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     Set<Integer> si = new HashSet<Integer>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     // 不写【记忆化深搜】，写【递推】
        //     // 【递推】记忆数组：【初始化】，保障【最大】
        //     int [][] f = new int [n+1][m+1];
        //     for (int i = 0; i <= n; i++)
        //         Arrays.fill(f[i], Integer.MIN_VALUE);
        //     f[0][0] = 0;
        //     for (int i = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         // 不匹配：当前字符 i
        //         f[i+1][0] = f[i][0] + (si.contains(i) ? 1 : 0); // 下面，【压缩】掉第一维，一个细节，对应这里，看得别扭。。。
        //         for (int j = 0; j < Math.min(i+1, m); j++) {
        //             int r = f[i][j+1] + (si.contains(i) ? 1 : 0); // 这里，f[i][j+1] 写得最别扭。。就把理解成：列向右填充数据的【初始化】
        //             // 不使用删除操作：匹配当前【i,j】
        //             if (s[i] == t[j])
        //                 r = Math.max(r, f[i][j]);
        //             f[i+1][j+1] = r;
        //         }
        //     }
        //     return f[n][m];
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【空间优化】：极度空间、压缩、优化！
        // public int maxRemovals(String S, String T, int[] a) {
        //     int n = S.length(), m = T.length();
        //     char [] s = S.toCharArray(), t = T.toCharArray();
        //     // 有序数组，用一个指针，代替，顺序遍历
        //     // Set<Integer> si = new HashSet<Integer>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        //     // 【空间优化】：压缩掉，一个维度。压缩了一个维度，为避免脏数据，就需要【倒序遍历】！！
        //     // int [][] f = new int [n+1][m+1];
        //     // 观察上面的状态转移方程，在计算 f[i+1] 时，只会用到 f[i]，不会用到比 i 更早的状态。
        //     // 因此可以像 0-1 背包 那样，去掉第一个维度，把 f[i+1] 和 f[i] 保存到同一个数组中。注意和 0-1 背包一样，j 要倒序枚举。
        //     // 状态转移方程改为
        //     // f[j+1] = max(f[j+1]+[i∈targetIndices], f[j])
        //     int [] f = new int [m+1];
        //     Arrays.fill(f, Integer.MIN_VALUE);
        //     f[0] = 0;
        //     int k = 0, cts = 0; // 【有序数组】：自左向右的指针
        //     for (int j = 0; j < n; j++) { // 遍历、压缩掉的维度 S 序列
        //         while (k < a.length && a[k] < j) k++;
        //         cts = (k < a.length && a[k] == j ? 1 : 0);
        //         for (int i = Math.min(j, m-1); i >= 0; i--) {
        //             // 如果，不匹配，当前字符
        //             f[i+1] += cts; // 更新的下标范围【1,Math.min(j,m-1)+1】，从来不曾更新【0】
        //             // 如果，匹配，当前字符
        //             if (s[j] == t[i])
        //                 // f[i+1] += f[i]; // 【写错了】：这里，压缩掉一个维度后，【倒序遍历】，才结果正确
        //                 f[i+1] = Math.max(f[i+1], f[i]); // 取两者，最大值，而非累加
        //         }
        //         f[0] += cts; // 为什么，这一步是【必须】的？
        //     }
        //     return f[m];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // private static final int MX = 1001;
        // private static final int [][] f = new int[MX][MX];
        // static {
        //     f[0][0] = 1;
        //     for (int i = 1; i < MX; i++) 
        //         for (int j = 1; j <= i; j++)
        //             // 把第 i 个人，单独一组；或者，把第 i 个人，分到先前 i-1 个人、所组成的 j 个组中的、任何一个组
        //             f[i][j] = (int)(f[i-1][j-1] + (long)j * f[i-1][j] % mod);
        // }
        // public int numberOfWays(int n, int x, int y) {
        //     long ans = 0;
        //     long perm = 1;
        //     long powY = 1;
        //     for (int i = 1; i <= Math.min(n, x); i++) {
        //         perm = perm * (x + 1 - i) % mod;
        //         powY = powY * y % mod;
        //         ans = (ans + perm * f[n][i] % MOD * powY) % MOD;
        //     }
        //     return (int)ans;
        // }

    //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    //     public List<String> stringSequence(String S) {
    //         List<String> f = new ArrayList<>();
    //         int n = S.length(); char [] s = S.toCharArray();
    //         for (int i = 0; i < n; i++) {
    //             System.out.println("\n i: " + i);
    // char  c = s[i];
    //             if (i == 0) {
    //                 f.add("a");
    //                 if (c == 'a') continue;
    //                 StringBuilder si = new StringBuilder(f.get(f.size()-1));
    //                 for (int j = 1; j < 26; j++) {
    //                     if ('a' + j <= s[i]) {
    //                         si.deleteCharAt(si.length()-1);
    //                         si.append((char)('a'+j));
    //                         f.add(new String(si));
    // } else break;
    //                 }
    //                 continue;
    //             }
    //             StringBuilder si = new StringBuilder(f.get(f.size()-1));
    //             for (int j = 0; j < 26; j++) {
    //                 if ((char)('a' + j) <= c) {
    //                     si.append((char)('a'+j));
    //                     f.add(new String(si));
    //                     si.deleteCharAt(si.length()-1);
    //                 } else break;
    //             }
    //         }
    //         return f;
    //     }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 以【左端点】为固定点，数右边合法个数.
        // // 所以，亲爱的表哥的活宝妹，只要稍微动动脑袋，亲爱的表哥的活宝妹，自己，还是可以独立想出来的，虽然它狠简单。。
        // public int numberOfSubstrings(String S, int va) {
        //     int n = S.length(), f = 0, max = 1; char [] s = S.toCharArray();
        //     if (va == 1) return n * (n + 1) / 2;
        //     TreeMap<Integer, Integer> m = new TreeMap<>();
        //     int i = 0, j = 0;
        //     while (i < n) {
        //         while (j < n && max < va) {
        //             int k = s[j]-'a';
        //             m.put(k, m.getOrDefault(k, 0) + 1);
        //             max = Math.max(max, m.get(k));
        //             j++;
        //         }
        //         if (max == va) f += n - j + 1;
        //         int k = s[i] - 'a';
        //         m.put(k, m.getOrDefault(k, 1)-1);
        //         if (m.get(k) == 0) m.remove(k);
        //         max = m.isEmpty() ? 0 : Collections.max(m.values());
        //         i++;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：一定是这个思路，但亲爱的表哥的活宝妹，N[100000]a[i]=100000 数据规模大，不一定写得对
        // public int minOperations(int[] a) {
        //     int n = a.length;
        //     int [][] f = new int [n][2];// 0 不操作 1 操作
        //     Arrays.stream(f).forEach(z -> Arrays.fill(z, n+1));
        //     f[0][0] = 0;
        //     f[0][1] = 
        // }
        // int getVal(int x) {
        //     int f = 1;
        //     for (int i = 1; i <= (int)Math.sqrt(x); i++) 
        //         if (x % i == 0)
        //             f = Math.max(f, Math.max(i, x / i));
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：这个题目，看起来像是狠简单，数量级大：【TLE 超时】或是【暴内存】
        // // 【暴内存】了。。580/582 passed 亲爱的表哥的活宝妹，昨天晚上、第一次写到一个会【暴内存】的破烂题目。。。
        // // 亲爱的表哥的活宝妹，写过1 个【DFS 时间戳】但几年前写的、彻底忘记了、昨天晚上、居然又出一个【DFS时间戳】，亲爱的表哥的活宝妹还没能来得及复习到那个题型。。。
        // public boolean[] findAnswer(int[] a, String S) {
        //     int n = a.length; s = S.toCharArray();
        //     g = new ArrayList[n];
        //     for (int i = 0; i < n; i++)
        //         g[i] = new ArrayList<Integer>();
        //     // 【建图】：有向图
        //     for (int i = 1; i < n; i++) // i 是升序遍历
        //         g[a[i]].add(i); // 所以， g[a[i]] 链条里的值，也是【必然】升序
        //     // // 【排序】：不必要！！亲爱的表哥的活宝妹，这里昨天晚上脑袋昏，既放错位置，还是完全不必要的步骤。。。
        //     // for (List<Integer> l : g)
        //     //     Collections.sort(l); // 升序排列
        //     f = new String [n];
        //     vis = new boolean [n];
        //     // sb = new StringBuilder(n);
        //     dfs(0); // O(N) 后序遍历
        //     // 求解：O(NN)
        //     // 换一种：【树的遍历】方法：父节点；右节点、左节点。可是提升的是【时间复杂度】不是【空间复杂度】
        //     int j = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (vis[i]) continue;
        //         int m = f[i].length();
        //         for ( j = 0; j < m/2; j++) 
        //             if (f[i].charAt(j) != f[i].charAt(m-1-j)) {
        //                 vis[i] = false;
        //                 break;
        //             }
        //         if (j == m/2) vis[i] = true;
        //     }
        //     dfsdsf(0);
        //     return vis;
        // }
        // List<Integer> [] g;
        // String [] f; char [] s;
        // boolean [] vis;
        // void dfs(int u) {
        //     if (g[u].size() == 0) {
        //         f[u] = new String("" + s[u]);
        //         vis[u] = true;
        //         return ;
        //     }
        //     StringBuilder sb = new StringBuilder();
        //     int m = g[u].size();
        //     for (int i = 0; i < m; i++) {
        //         int v = g[u].get(i);
        //         if (vis[u] && i == 0 && s[v] != s[u]) 
        //             vis[u] = false;
        //         dfs(v);
        //         // if (m > 1 && (i > 0 && sb.charAt(i) != s[m-1-i])
        //         sb.append(f[v]);
        //     }
        //     sb.append(s[u]);
        //     f[u] = new String(sb);
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean[] findAnswer(int[] a, String S) {
        //     int n = a.length; s = S.toCharArray(); r = new char [n];
        //     g = new ArrayList[n];
        //     for (int i = 0; i < n; i++)
        //         g[i] = new ArrayList<Integer>();
        //     // 【建图】：有向图
        //     for (int i = 1; i < n; i++) // i 是升序遍历
        //         g[a[i]].add(i); // 所以， g[a[i]] 链条里的值，也是【必然】升序
        //     f = new int [n][2]; // 【DFS时间戳】：亲爱的表哥的活宝妹，先前抄答案，彻底忘记的，这次要记住了！！！
        //     // 【DFS时间戳、遍历】
        //     t = 0;
        //     dfs(0);
        //     // 【马拉车算法】：O(n) 时间、求答案
        //     // Manacher 模板
        //     // 将 dfsStr 改造为 t，这样就不需要讨论 n 的奇偶性，因为新串 t 的每个回文子串都是奇回文串（都有回文中心）
        //     // dfsStr 和 t 的下标转换关系：
        //     // (dfsStr_i + 1) * 2 = ti
        //     // ti / 2 - 1 = dfsStr_i
        //     // ti 为偶数，对应奇回文串（从 2 开始）
        //     // ti 为奇数，对应偶回文串（从 3 开始）
        //     char [] rr = new char [n * 2 + 3]; // [0,2n+2] 下标有效
        //     Arrays.fill(rr, '#');
        //     rr[0] = '^';         // 开始标记
        //     for (int i = 0; i < n; i++) 
        //         rr[2 * (i + 1)] = r[i];
        //     rr[2 * n + 2] = '$'; // 结束标记
        //     // 定义一个【奇回文串】的【回文半径】 = (长度 + 1)/2，即【保留回文中心，去掉一侧后的剩余字符串的长度】
        //     // halfLen[i] 表示在 t 上的以 t[i] 为回文中心的最长回文子串的回文半径
        //     // 即 [i-halfLen[i]+1,i+halfLen[i]-1] 是 t 上的一个回文子串
        //     int[] halfLen = new int[rr.length - 2]; // 取值范围：【0,2n】2n+1 的长度
        //     halfLen[1] = 1;
        //     int boxM = 0; // boxM 为该【回文子串的中心位置】，二者的关系为 boxR = boxM + halfLen[boxM]
        //     int boxR = 0; // boxR 表示当前【右边界下标最大】的回文子串的【右边界下标+1】
        //     for (int i = 2; i < halfLen.length; i++) { // 循环的起止位置对应着原串的首尾字符
        //         int hl = 1; // 【初始化】：当前【回文中心 i】的半径长度
        //         if (i < boxR) {
        //             // 记 i 关于 boxM 的对称位置 i' = boxM * 2 - i,为【M-(i-m)=2M-i, M, i】换个大小方向，结果一样【i(M-i), M, M+(M-i)=2M-i】
        //             // 若以 i' 为中心的最长回文子串范围，超出了以 boxM 为中心的回文串的范围（即 i+halfLen[i'] >= boxR）【超出的部分，未必匹配，要取小值保守值】
        //             // 则 halfLen[i] 应先初始化为，【较小的】已知的回文半径 boxR-i，然后再继续暴力匹配
        //             // 否则 halfLen[i] 与 halfLen[i'] 相等
        //             hl = Math.min(halfLen[2 * boxM - i], boxR - i); // 取【保守最小值、最大合法值】
        //         }
        //         // 暴力扩展
        //         // 算法的复杂度，取决于这部分，执行的次数
        //         // 由于扩展之后 boxR 必然会更新（右移），且扩展的的次数就是 boxR 右移的次数
        //         // 因此算法的复杂度 = O(len(t)) = O(n)
        //         while (rr[i - hl] == rr[i + hl]) {
        //             hl++;
        //             boxM = i;
        //             boxR = i + hl;
        //         }
        //         halfLen[i] = hl;
        //     }
        //     // rr 中回文子串的长度为 hl*2-1
        //     // 由于其中 # 的数量总是比字母的数量多 1
        //     // 因此其在 dfsStr 中对应的回文子串的长度为 hl-1
        //     // 这一结论可用在下面的判断回文串中
        //     boolean[] ans = new boolean[n];
        //     for (int i = 0; i < n; i++) {
        //         // 判断左闭右开区间 [l,r) 是否为回文串  0 <= l < r <= n
        //         // 根据下标转换关系得到 dfsStr 的 [l,r) 子串，在 rr 中对应的回文中心下标为 l+r+1 = [l+(r-l)/2+1]*2=2l+r-l+2=l+r+2?? 这个地方算不对。。
        //         // 需要满足 halfLen[l + r + 1] - 1 >= r - l，即 halfLen[l + r + 1] > r - l
        //         int l = f[i][0];
        //         int r = f[i][1];
        //         ans[i] = halfLen[l + r + 1] > r - l;
        //     }
        //     return ans;
        // }
        // List<Integer> [] g;
        // char [] s, r; // r: dfsStr
        // int [][] f;
        // int t; // 【DFS时间戳】全局时钟 time=clock=t
        // void dfs(int u) {
        //     f[u][0] = t; // in[u]: 第一次、访问到、父节点 u 的时间戳
        //     for (int v : g[u]) 
        //         dfs(v);
        //     // 亲爱的表哥的活宝妹，觉得，下面怎么写，效果是一样的【会跳过 0 节点，下标超长度。。】。。。测试一下
        //     // f[u][1] = ++t; // out[u]: 第二次、访问到、父节点 u 的时间戳
        //     // r[t] = s[u];
        //     r[t++] = s[u];
        //     f[u][1] = t; // out[u]: 第二次、访问到、父节点 u 的时间戳
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int possibleStringCount(String S) {
        //     int n = S.length(), r = 1; char [] s = S.toCharArray();
        //     int i = 1, f = 1;
        //     char p = s[0];
        //     while (i < n) {
        //         if (s[i] == p)
        //             f++;
        //         else {
        //             r += f-1;
        //             f = 1;
        //             p = s[i];
        //         }
        //         i++;
        //     }
        //     r += f-1;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：破烂动规！
        // // 亲爱的表哥的活宝妹，今天终于会写，破烂动规了！！！
        // public int maxScore(int n, int d, int[][] a, int[][] g) { // f: stay g: travel
        //     int [][] f = new int [d][n];
        //     // 遍历： k 天行程
        //     for (int i = 0; i < d; i++) {
        //         // 遍历： n 个城市
        //         for (int j = 0; j < n; j++) {
        //             // 留在本城
        //             f[i][j] = a[i][j] + (i == 0 ? 0 : f[i-1][j]);
        //             if (i == 0) { // 【初始化】：一个最大分值的、起步城市
        //                 for (int k = 0; k < n; k++) {
        //                     if (j == k) continue;
        //                     f[i][j] = Math.max(f[i][j], g[k][j]);
        //                 }
        //                 continue;
        //             }
        //             // 去其它城市: 【出发城市】【去往城市】
        //             for (int k = 0; k < n; k++) {
        //                 if (j == k) continue;
        //                 // 从前一天 i-1 天的、第 k 个城市，去往到今天的、第 j 个城市
        //                 f[i][j] = Math.max(f[i][j], f[i-1][k] + g[k][j]);
        //             }
        //         }
        //     }
        //     return Arrays.stream(f[d-1]).max().getAsInt();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，把题目读懂了，也能够【写得出：LCA 找最近公共祖先】，可是，后面的 reparenting 不知道有哪些机关？
        // public int [] findSubtreeSizes(int [] a, String s) {
        //     n = a.length;
        //     // 【建图】
        //     g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int i = 1; i < n; i++) 
        //         g[a[i]].add(i);
        //     // DFS:【倍增法：求两节点，最近公共祖先】
        //     f = new int [n][31];
        //     dfs(0, -1);
        //     // 亲爱的表哥的活宝妹，写到这里：不知道 make change on the tree one time simultaneously for all nodes x from 1 to n - 1 要怎么弄，
        //     // 亲爱的表哥的活宝妹，去看下提示，再接着写。。。
        //     // 亲爱的表哥的活宝妹，看了【破烂提示】，看了跟没看一样，【破烂提示】什么用也不起。。。
        // }
        // List<Integer> [] g;
        // int [][] f;
        // int n;
        // // 【自顶向下DFS】：
        // void dfs(int i, int p) {
        //     if (p != -1)
        //         // 树 i 节点的、第 2^j 个祖先：是 i 节点的第 2^j-1 个祖先的、它的第 2^j-1 个祖先
        //         // 就是： 2^j ＝ 2^j-1 ＋ 2^j-1
        //         for (int j = 1; j < 31; j++) 
        //             f[i][j] = f[f[i][j-1]][j-1];
        //     for (int j : g[i]) 
        //         dfs(j, i);
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        static final int mod = (int)1e9 + 7;
        public int possibleStringCount(String S, int k) {
            int m = S.length(); char [] s = S.toCharArray();
            // 过滤：把不曾重复的字符去掉。或也可以
            List<Integer> l = new ArrayList<>(); // 只需要知道：重复数字
            int f = 1, i = 1, sum = 0;
            char p = s[0];--k;
            while (i < m) {
                if (s[i] == p) 
                    f++;
                else {
                    --k;
                    if (f > 1) {
                        l.add(f-1);
                        sum += f-1;
                    }
                    p = s[i];
                    f = 1;
                }
                i++;
            }
            if (k <= 0 || sum == k) return 1;
            // 转变成：【背包问题？】：长度 n 的数组【重复硬币】，有【和：不小于 k】的方案数
            // Instead of solving for at least k, can we solve for at most k - 1 length?
// 上面，这里，还需要一个转换。。。【total】－【<= k-1】= [>=k]
            // 亲爱的表哥的活宝妹，这里，有点儿糊里糊涂，快要想不清楚了。。。晚点儿再写这个破烂题目！！
            // 亲爱的表哥的活宝妹，去看提示，再决定要不要接着写。。。破烂题目！！
            int n = l.size(), max = Collections.max(l)+1;
            // 亲爱的表哥的活宝妹，觉得，这里，像是，快要用 2 个BIT 来写了。。。
            int [] f = new int [Math.max(k, max)+1];
            f[0] = 1;
            // 遍历： n 个【0/1 可选、可重复、可不选、的硬币】
            for (int r : l) { // 这是个：典型 BIT 【1,r】的区间更新。。
                // 遍历：【自大到小】，累积和
                // for (int i = k-1; i >= k-r-1; i--) {
                // for (int i = r; i >= 1; i--) {
                for (int i = 1; i <= r; i++) // 从头上，区间更新 
                    f[i] = (f[i] + 1) % mod;
                for (int i = k-1-1; i >= k-1-r; i--) 
                    f[i] = (f[i] + f[k-1-i]) % mod;
            }
            // return f[k-1];
        }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int [][] a = new int [][] {{1,1}};
        int [][] b = new int [][] {{0,1},{6,0}};

        int r = s.maxScore(2, 1, a, b);
        System.out.println("r: " + r);
    }
}
// ListNode head = new ListNode(a0]); 
// head.buildList(head, a);
// head.printList(head);
// TreeNode rr = new TreeNode(a[0]);
// rr.buildTree(rr, a);
// rr.levelPrintTree(rr);
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】