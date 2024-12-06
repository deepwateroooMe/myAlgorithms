import com.TreeNode;

// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         static final int mod = (int)1e9 + 7;
//         public int possibleStringCount(String S, int k) {
//             int m = S.length(); char [] s = S.toCharArray();
//             // 过滤：把不曾重复的字符去掉。或也可以
//             List<Integer> l = new ArrayList<>(); // 只需要知道：重复数字
//             int f = 1, i = 1, sum = 0;
//             char p = s[0];--k;
//             while (i < m) {
//                 if (s[i] == p) 
//                     f++;
//                 else {
//                     --k;
//                     if (f > 1) {
//                         l.add(f-1);
//                         sum += f-1;
//                     }
//                     p = s[i];
//                     f = 1;
//                 }
//                 i++;
//             }
//             if (k <= 0 || sum == k) return 1;
//             // 转变成：【背包问题？】：长度 n 的数组【重复硬币】，有【和：不小于 k】的方案数
//             // Instead of solving for at least k, can we solve for at most k - 1 length?
// // 上面，这里，还需要一个转换。。。【total】－【<= k-1】= [>=k]
//             // 亲爱的表哥的活宝妹，这里，有点儿糊里糊涂，快要想不清楚了。。。晚点儿再写这个破烂题目！！
//             // 亲爱的表哥的活宝妹，去看提示，再决定要不要接着写。。。破烂题目！！
//             int n = l.size(), max = Collections.max(l)+1;
//             // 亲爱的表哥的活宝妹，觉得，这里，像是，快要用 2 个BIT 来写了。。。
//             int [] f = new int [Math.max(k, max)+1];
//             f[0] = 1;
//             // 遍历： n 个【0/1 可选、可重复、可不选、的硬币】
//             for (int r : l) { // 这是个：典型 BIT 【1,r】的区间更新。。
//                 // 遍历：【自大到小】，累积和
//                 // for (int i = k-1; i >= k-r-1; i--) {
//                 // for (int i = r; i >= 1; i--) {
//                 for (int i = 1; i <= r; i++) // 从头上，区间更新 
//                     f[i] = (f[i] + 1) % mod;
//                 for (int i = k-1-1; i >= k-1-r; i--) 
//                     f[i] = (f[i] + f[k-1-i]) % mod;
//             }
//             // return f[k-1];
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，把题目读懂了，也能够【写得出：LCA 找最近公共祖先】，可是，后面的 reparenting 不知道有哪些机关？
        // public int [] findSubtreeSizes(int [] a, String S) {
        //     n = a.length; s = S.toCharArray();
        //     // 【建图】
        //     g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     for (int i = 1; i < n; i++) 
        //         g[a[i]].add(i);
        //     f = new int [26]; Arrays.fill(f, -1);
        //     ans = new int [n]; Arrays.fill(ans, 1);
        //     // 可以把，下面2 遍 DFS 合并成一遍遍历，就可以
        //     // dfsWithModification(0);
        //     dfs(0);
        //     return ans;
        // }
        // List<Integer> [] g;
        // int [] f, ans; // 
        // int n;
        // char [] s;
        // // 【自顶向下DFS】：
        // void dfs(int i) {
        //     ans[i] = 1;
        //     int pre = f[s[i] - 'a'];
        //     f[s[i] - 'a'] = i;
        //     for (int j = g[i].size()-1; j >= 0; j--) { // 倒序遍历
        //         int v = g[i].get(j);
        //         // if (v == -1) continue;
        //         // int anc = f[s[v]-'a'];
        //         // if (anc != -1) {
        //         //     g[anc].add(v); // 链条尾巴上，添加
        //         //     g[i].set(j, -1); // 做个记号：
        //         // }
        //         int anc = f[s[v]-'a'];
        //         dfs(v);
        //         if (anc != -1) 
        //             ans[anc] += ans[v];
        //         else 
        //             ans[i] += ans[v];
        //     }
        //     f[s[i] - 'a'] = pre;
        // }
        // void dfsWithModification(int i) {
        //     int pre = f[s[i] - 'a'];
        //     f[s[i] - 'a'] = i;
        //     for (int j = g[i].size()-1; j >= 0; j--) { // 倒序遍历
        //         int v = g[i].get(j);
        //         if (v == -1) continue;
        //         int anc = f[s[v]-'a'];
        //         if (anc != -1) {
        //             g[anc].add(v); // 链条尾巴上，添加
        //             g[i].set(j, -1); // 做个记号：
        //         }
        //         dfsWithModification(v);
        //     }
        //     f[s[i] - 'a'] = pre;
        // }
        // void dfs(int i) {
        //     ans[i] = 1;
        //     for (int j : g[i]) {
        //         if (j != -1) {
        //             dfs(j);
        //             ans[i] += ans[j];
        //         }
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 这组、破烂题目，好难；周四了，四个题目的最高通过率，也不足39.99% 他们的贱鸡、贱畜牲，赶人的手段，真贱恶！！！
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不喜欢 GCD 算法。。。不知道，这个破烂算法，是怎么回事！！！
        // public long maxScore(int[] a) {
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     long [] g = new long [n+1];
        //     f[n] = 0;
        //     g[n] = 1;
        //     for (int i = n-1; i >= 0; i--) {
        //         f[i] = gcd(f[i+1], a[i]);
        //         g[i] = lcm(g[i+1], a[i]);
        //     }
        //     long r = f[0] * g[0];
        //     long preGcd = 0, preLcm = 1;
        //     for (int i = 0; i < n; i++) {
        //         r = Math.max(r, gcd(preGcd, f[i+1]) * lcm(preLcm, g[i+1]));
        //         preGcd = gcd(preGcd, a[i]);
        //         preLcm = lcm(preLcm, a[i]);
        //     }
        //     return r;
        // }
        // long gcd(long i, long j) {
        //     while (i != 0) {
        //         long k = i;
        //         i = j % i;
        //         j = k;
        //     }
        //     return j;
        // }
        // // 求：【最小公倍数】
        // long lcm(long i, long j) {
        //     return (long) i / gcd(i, j) * j;
        // }


        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不要去想，这种恶心死人不偿命的破烂题目，真贱！！
        // public int lengthAfterTransformations(String S, int t) {
        //     int n = S.length(), r = n; char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) f[c-'a']++;
        //     System.out.println(Arrays.toString(f));
        //     for (int i = 0; i < 26; i++) {
        //         // 感觉，这个思路不对！！！
        //         // // 亲爱的表哥的活宝妹，觉得这里，要不就是 BIT: 区间更新上面 f[26] 每个 t 次后的累积次数。。仍然想得不对！！
        //         // int [] f = new int [27];
        //         // 这里，只计算了，当前字符【a-z】中、当前字符产生 z->ab 的次数；没有累加，过程中产生其它字符的、可能产生 z->ab 的次数
        //         int v = (t > 25 - i ? (t - (25 - i)) / 26 + 1 : 0); 
        //         r += f[i] * v;
        //     }
        //     return r;
        // }

        // // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // // 亲爱的表哥的活宝妹，笨宝妹，为什么【永远、万能的、记忆化深搜】，到这种题型，亲爱的表哥的活宝妹，就认不出来了？？？！！！
        // // // 少了种：【火眼金睛】【一眼、认出、或是，分析出】它是【永远、万能的、记忆化深搜】题目的【认知、分析、转化】的思维过程。。。
        // static final int mod = (int)1e9 + 7;
        // public int subsequencePairCount(int[] a) {
        //     n = a.length; this.a = a; 
        //     int m = Arrays.stream(a).max().getAsInt();
        //     // 【方法一】：亲爱的表哥的活宝妹，【永远、万能的、记忆化深搜】
        //     // f = new Integer [n][m+1][m+1];
        //     // return (dfs(n-1, 0, 0) - 1 + mod) % mod; // －1 是因为，多数了1 个空集
        //     // 【方法二】：破烂【动规】
        //     int [][][] f = new int [n+1][m+1][m+1];
        //     for (int j = 1; j <= m; j++)
        //         f[0][j][j] = 1;
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i];
        //         for (int j = 0; j <= m; j++) 
        //             for (int k = 0; k <= m; k++) 
        //                 f[i+1][j][k] = (int)(((long)f[i][gcd(j, v)][k] + (long)f[i][j][k] + (long)f[i][j][gcd(k, v)]) % mod);
        //     }
        //     return f[n][0][0];
        // }
        // // Integer [][][] f;
        // int n; int [] a;
        // // int dfs(int i, int j, int k) {
        // //     if (i < 0)
        // //         return j == k ? 1 : 0;
        // //     if (f[i][j][k] != null) return f[i][j][k];
        // //     return f[i][j][k] = (int)(((long)dfs(i-1, j, k) + dfs(i-1, gcd(a[i], j), k) + dfs(i-1, j, gcd(a[i], k))) % mod);
        // // }
        // int gcd(int i, int j) {
        //     while (i != 0) {
        //         int k = i;
        //         i = j % i;
        //         j = k;
        //     }
        //     return j;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【0/1 背包】：
        // int aa(int [] a, int [] v, int w) {
        //     int n = 1027;
        //     int [] f = new int [w+1];
        //     for (int j = 0; j < n; j++) {
        //         // 【重点】：【倒序遍历】
        //         for (int i = w; i >= a[j]; i--) 
        //             f[i] = Math.max(f[i], f[i-a[j]] + v[j]);
        //     }
        //     return f[w];
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【完全背包】：同一件物品、硬币，可以【重复使用多次】，是为【完全】背包
        // int aa(int [] a, int [] v, int w) { // a[i]: weight v[i]: value
        //     int n = 1027;
        //     int [] f = new int [w+1];
        //     for (int j = 0; j < n; j++) {
        //         // for (int i = w; i >= a[i]; i--) // 【0/1 背包】的【倒序遍历】
        //         // 【重点】：【正序、遍历】！！
        //         for (int i = a[j]; i <= w; i++)
        //             // if (f[i - a[j]] + v[j] > f[i])
        //             //     f[i] = f[i - a[j]] + v[j];
        //             f[i] = Math.max(f[i], f[i-a[j]] + v[j]);
        //     }
        //     return f[w];
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【多重背包】：同一件物品、硬币，可以【重复使用、特定最大限度的次数】，是为【多重】背包
        // int aa(int [] a, int [] v, int [] r, int w) { // a[i]: weight v[i]: value r[i]: cnts of each items
        //     int n = 1027;
        //     int [] f = new int [w+1];
        //     for (int j = 0; j < n; j++) // 【多重背包】：如同【0/1 背包】，需要【倒序遍历】来【避免重复、累加错误效应】。。 
        //         // for (int i = a[j]; i <= w; i++) // 遍历：重量
        //         for (int i = w; i >= a[j]; i--) 
        //             for (int k = 1; k * a[j] <= i && k <= r[j]; k++) 
        //                 f[i] = Math.max(f[i], f[i - k * a[j]] + v[j] * k);
        //     }
        //     return f[w];
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【混合背包】：混合背包就是将前面三种的背包问题混合起来，有的只能取一次，有的能取无限次，有的只能取 k 次。
        // int aa(int [] a, int [] v, int [] r, int w) { // a[i]: weight v[i]: value r[i]: cnts of each items
        //     int n = 1027;
        //     int [] f = new int [w+1];
        //     for (int j = 0; j < n; j++) // 【多重背包】：如同【0/1 背包】，需要【倒序遍历】来【避免重复、累加错误效应】。。
        //         if (r[i] == 0) { // 如果【数量没有限制】使用【完全背包】的核心代码
        //             for (int i = a[j]; i <= w; i++) // 重复累回效应，方便快速运算 
        //                 f[i] = Math.max(f[i], f[i - a[j]] + v[j]);
        //         } else { // 【0/1 背包】或是【多重背包】
        //             for (int i = w; i >= a[j]; i--) 
        //                 for (int k = 1; k * a[j] <= i && k <= r[j]; k++) // 没有【优化】：几种优化方法，【TODO：】改天去看懂 
        //                     f[i] = Math.max(f[i], f[i - k * a[j]] + v[j] * k);
        //         }
        //     }
        //     return f[w];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 狗屁、破烂、机器絮叨不清的、狗屁破烂【国王问题】
        // int idx;
        // int [] sit, sta;
        // int [][][] f;
        // int getCnts(int n, int kk) { // 可能还存在 int 转为 long 的破烂问题、破烂题解。。。
        //     idx = 0;
        //     sit = new int [1327]; sta = new int [1327];
        //     dfs(0, 0, 0);
        //     f = new int [n][1327][kk+1];
        //     // 【初始化】；第1 行的【初始化】，写丢了。。。
        //     for (int j = 1; j <= idx; j++) // 有效座位：方案数为 1
        //         f[0][j][sta[j]] = 1;
        //     // 遍历【行】：【1,n-1】
        //     for (int i = 1; i < n; i++)
        //         // 遍历：当前第 i 行、当前坐位值为 j 时
        //         // for (int j = 1; j < (1 << n); j++)
        //         for (int j = 1; j <= idx; j++)
        //             // 遍历：前一行 i-1 行，的坐位值为 k 时，方案数
        //             // for (int x = 1; x < (1 << n); x++) {
        //             for (int x = 1; x <= idx; x++) {
        //                 if (!validSitting(sit[j], sit[x])) continue; // 非合法座位
        //                 for (int k = 1; k <= kk; k++) 
        //                     f[i][j][k] += f[i-1][x][k - sta[j]];
        //             }
        //     int r = 0;
        //     for (int i = 1; i <= cnt; i++) 
        //         r += f[n-1][i][kk];
        //     return r;
        // }
        // boolean validSitting(int i, int j) { // 根那个考场学生坐位置一样：上下左右再加四个斜方向
        //     if (i & j) return false;
        //     // if ((i >> 1) & j) return false; // 这个方向，移得不精确，可能会出【BUG：】：只能左移，不能右移，右移会屏闭掉一个位 bit
        //     if ((i << 1) & j) return false;
        //     if (i & (j << 1)) return false;
        // }
        // void dfs(int i, int j, int k) { // i: 坐了几个国王； j:mask 位值 k: 是【列的、自左向右】遍历下标 idx
        //     if (k >= n) { // 某个合法状态、终止条件
        //         sit[++idx] = j;
        //         sta[idx] = i;
        //         return ;
        //     }
        //     dfs(i, j, k+1);              // 当前列 k 上，不坐国王；下一列就可以试坐一个国王
        //     dfs(i+1, j | (1 << i), k+2); // 当前列 k 上，坐国王；下一列就【不能再坐】要 k+2 列才能再试坐一个国王
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean isBalanced(String S) {
        //     int n = S.length(), f = 0;  char [] s = S.toCharArray();
        //     for (int i = 1; i < n; i += 2) 
        //         f += s[i] - s[i-1];
        //     if (n % 2 == 1) f -= s[n-1] - '0';
        //     return f == 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 转化成图：求最小代价、最短距离
        // // 亲爱的表哥的活宝妹，又是在【背题目】吗？怎么就认定是【0/1 BFS】的？既然【背题目】，就把前不久那个被背住的【0/1 BFS】再找出来、对比一下，为什么不会用？？？
        // // 亲爱的表哥的活宝妹，是对【四个方向】都能走、没有遍历前后顺序了、破烂题目，辨识不清，不知道是怎么回事。。。心理障碍。。。
        // public int minTimeToReach(int[][] a) { // 741/743 passed 358/717 passed
        //     int n = a.length, m = a[0].length, t = 1;
        //     int [][] f = new int [n][m];
        //     // 【01 BFS】有优先级: 是怎么写的？亲爱的表哥的活宝妹，为什么会忘记？
        //     int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        //     boolean [][] g = new boolean [n][m];
        //     Queue<int []> p = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        //     p.offer(new int [] {0, 0, 0, -1});
        //     g[0][0] = true; 
        //     while (!p.isEmpty() || !q.isEmpty()) {
        //         int [] cur = new int [3];
        //         // int size = p.size() + q.size();
        //         int size = p.size();
        //         for (int step = p.size()-1; step >= 0; step--) {
        //             // System.out.println("\n step: " + step);
        //             // if (!p.isEmpty())
        //                 cur = p.poll();
        //             // else if (!q.isEmpty()) cur = q.poll();
        //             // System.out.println(Arrays.toString(cur));
        //                 int x = cur[1], y = cur[2], v = cur[0], pre = cur[3];
        //             if (x == n-1 && y == m-1)
        //                 return v;
        //             for (int [] d : dirs) {
        //                 int i = x + d[0], j = y + d[1];
        //                 if (i < 0 || i >= n || j < 0 || j >= m || g[i][j]) continue;
        //                 // if (i < 0 || i >= n || j < 0 || j >= m || g[i][j] && pre == i * m + j) continue;
        //                 // // 有重复访问问题
        //                 // if (g[i][j] && f[i][j] >= Math.max(a[i][j]+t, v+t)) continue;
        //                 // if (!g[i][j] && a[i][j] > v+t) {
        //                 if (a[i][j] > v+t) {
        //                     f[i][j] = a[i][j] + t;
        //                     q.offer(new int [] {a[i][j] + t, i, j, pre});
        //                 } else if (a[i][j] == v+t) {
        //                     f[i][j] = a[i][j] + t;
        //                     p.offer(new int [] {a[i][j] + t, i, j, pre});
        //                 } else {
        //                     f[i][j] = v + t;
        //                     p.offer(new int [] {v + t, i, j, pre});
        //                 }
        //                 pre = i * m + j;
        //                 g[i][j] = true;
        //             }
        //         }
        //         p.addAll(q);
        //         q.clear();
        //         t = 3 - t;
        //     }
        //     return -1;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 现在再看：一个最短距离题目，无限简单呀。。。
        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // public int minTimeToReach(int [][] a) {
        //     int n = a.length, m = a[0].length;
        //     int [][] f = new int [n][m];
        //     for (int i = 0; i < n; i++) Arrays.fill(f[i], Integer.MAX_VALUE);
        //     f[0][0] = 0;
        //     Queue<int []> q = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        //     q.offer(new int [] {0, 0, 0});
        //     for (;;) {
        //         int [] cur = q.poll();
        //         int t = cur[0], x = cur[1], y = cur[2];
        //         // 【终止条件】：
        //         if (x == n-1 && y == m-1) return t;
        //         if (t > f[x][y]) continue; // 后续遍历到的：较远较大值
        //         for (int [] d : dirs) {
        //             int i = x + d[0], j = y + d[1];
        //             if (i < 0 || i >= n || j < 0 || j >= m) continue;
        //             // int v = Math.max(t, a[i][j]) + (i + j) % 2 + 1; // 【写错了】：没看懂
        //             // int v = Math.max(t, a[i][j]) + (x + y) % 2 + 1;
        //             int v = Math.max(t, a[i][j]) + 1;
        //             if (v < f[i][j]) {
        //                 f[i][j] = v;
        //                 q.offer(new int [] {v, i, j});
        //             }
        //         }
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int countBalancedPermutations(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     int [] r = new int [10]; // 纪录：【0-9】各数字出现在的频率
        //     int sum = 0;
        //     for (int i = 0; i < 10; i++) 
        //         sum += i * r[i];
        //     if (sum % 2 > 0) return 0;
        //     // 转化为：亲爱的表哥的活宝妹，万能的【记忆化深搜】？O(N=79 * 720 * 720) 应该能过
        //     // 【状态】定义：不对！！还要背个字频数组 r[]. 【优化】：背r[] 数组，或是背【用过的字与频】, 【奇位和】与【偶位和】只要一个就可以，另一个可以手算手撕出来
        //     int [][][] f = new int [n][sum+1][sum+1];
        //     // 看不下去、破烂题解、机器码：破烂题解的、机器码题解、令人无法看、看不下去、再不想看。。。破烂题解！！！
        //     // 亲爱的表哥的活宝妹，不写这个破烂题目了、讨厌机器码，让正常人类的眼睛、无法看无法读。。。
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int smallestNumber(int n, int t) {
        //     int f = 1;
        //     while (true) {
        //         f = 1;
        //         System.out.println("\n n: " + n);
        //         for (char v : String.valueOf(n).toCharArray()) 
        //             f *= v-'0';
        //         System.out.println("f: " + f);
        //         if (f % t == 0) return n;
        //         n++;
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，这个破烂题目，没有思路。。破烂题目，出得越来越比登天还难。。。看提示了再试写。。
        // // 这不才是真正的BIT 吗？数个数。。1 个频率BIT 标记，这个数出现的次数。。
        // public class BIT {
        //     int [] f;
        //     int n;
        //     public BIT(int n) {
        //         this.n = n;
        //         f = new int [n];
        //     }
        //     void update(int i, int v) { // 自底向上：把当前节点、及父节点，全部更新
        //         while (i < n) {
        //             f[i] += v;
        //             i += lowBit(i); // <<<<<<<<<<<<<<<<<<<< 【TODO：】写得对吗？迷迷糊糊。。。
        //         }
        //     }
        //     // 查询：闭区间【1,i】的【区间和】
        //     int querySum(int i) {
        //         int r = 0;
        //         while (i > 0) {
        //             r += f[i];
        //             i -= lowBit(i); // <<<<<<<<<<<<<<<<<<<< 【TODO：】写得对吗？迷迷糊糊。。。 
        //         }
        //         return r;
        //     }
        //     // 查询：闭区间【l,r】的【区间和】，就是区间内数字的频率和
        //     int queryRange(int l, int r) {
        //         return querySum(r) - querySum(l-1);
        //     }
        //     int lowBit(int i) {
        //         return i & -i;
        //     }
        // }
        // public int maxFrequency(int[] a, int k, int t) {
        //     int n = a.length, f = 1;
        //     Arrays.sort(a); // 顺序无关：就可以排序
        //     // 原数组：频率分布
        //     BIT bit = new BIT (a[n-1]+1);
        //     for (int v : a) 
        //         bit.update(v, 1);
        //     for (int i = 0; i < n; i++) {
        //         int l = a[i], r = a[i] + k * 2;
        //         // 不知道那个操作次数是怎么弄的。。
        //         // 亲爱的表哥的活宝妹，上午不要再写这、比登天还难的破烂题目了，它们的贱鸡、贱畜牲，真贱！！！
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean hasIncreasingSubarrays(List<Integer> l, int k) {
        //     int n = l.size();
        //     // 【差分数组】
        //     for (int i = n-1; i >= 1; i--) {
        //         int v = l.get(i) - l.get(i-1);
        //         l.set(i, v);
        //     }
        //     this.l = l; 
        //     for (int i = 0; i <= n-2 * k; i++) {
        //         if (increasing(i, i+k-1) && increasing(i+k, i+2*k-1))
        //             return true;
        //     }
        //     return false;
        // }
        // List<Integer> l;
        // boolean increasing(int x, int y) {
        //     for (int i = x+1; i < y+1; i++) 
        //         if (l.get(i) <= 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxIncreasingSubarrays(List<Integer> l) {
        //     int n = l.size(), max = 1;
        //     // 【差分数组】
        //     for (int i = n-1; i >= 1; i--) {
        //         int v = l.get(i) - l.get(i-1);
        //         l.set(i, v);
        //     }
        //     System.out.println("l.size(): " + l.size());
        //     System.out.println(Arrays.toString(l.toArray()));
        //     int j = 0, i = 1, left = 0, r = 0; // left, right, length
        //     while (i < n) {
        //         System.out.println("\n i: " + i + " max: " + max);
        //         if (l.get(i) <= 0) {
        //             if (i >= j+1) {
        //                 left = i - j;
        //                 r = i+1;
        //                 while (r < n && l.get(r) > 0) 
        //                     r++;
        //                 if (left <= r-i) {
        //                     max = Math.max(max, left);
        //                     left = r-i;
        //                     j = i;
        //                 } else {
        //                     max = Math.max(max, Math.max(left/2, r-i));
        //                     j = r;
        //                 }
        //                 i = r+1;
        //                 left = 0; r = 0;
        //                 System.out.println("left: " + left + " " + "max: " + max);
        //             } else {
        //                 j = i;
        //                 i++;
        //             } 
        //         } else i++;
        //     }
        //     if (left > 0) {
        //         if (left <= n-j) 
        //             max = Math.max(max, left);
        //         else 
        //             max = Math.max(max, Math.max(left/2, n-j));
        //     } else if (j < n)
        //         max = Math.max(max, (n-j)/2);
        //     return max;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int sumOfGoodSubsequences(int[] a) {
        //     int n = a.length;
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countValidSelections(int[] b) {
        //     int n = b.length, f = 0, j = 0, d = 0;
        //     int [] a = Arrays.copyOf(b, n);
        //     int [] dd = new int [] {1, -1};
        //     for (int i = 0; i < n; i++) {
        //         if (b[i] != 0) continue;
        //         for (int k = 0; k < dd.length; k++) {
        //             d = dd[k];
        //             a = Arrays.copyOf(b, n);
        //             j = i+d;
        //             while (j >= 0 && j < n) {
        //                 if (a[j] == 0) {
        //                     j += d;
        //                     continue;
        //                 } else {
        //                     a[j]--;
        //                     d = -d;
        //                     j += d;
        //                 }
        //                 if (Arrays.stream(a).sum() == 0) {// 又检查了一遍
        //                     f++;
        //                     break;
        //                 }
        //             }
        //             if (j < 0 || j >= n) {
        //                 if (Arrays.stream(a).sum() == 0) // 又检查了一遍
        //                     f++;
        //                 continue;
        //             }
        //             if (Arrays.stream(a).sum() == 0) // 又检查了一遍
        //                 continue;
        //         }
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean isZeroArray(int[] a, int[][] qs) {
        //     int n = a.length;
        //     // 【差分数组】：原位变成差分数组
        //     for (int i = n-1; i > 0; i--) 
        //         a[i] -= a[i-1];
        //     for (int [] f : qs) {
        //         int i = f[0], j = f[1];
        //         a[i]--;
        //         if (j < n-1)
        //             a[j+1]++;
        //     }
        //     int f = 0;
        //     for (int i = 0; i < n; i++) {
        //         f += a[i];
        //         if (f > 0) return false;
        //     }
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【BIT 或是线段树】：维护【差分数组】或原数组？，求【区间最大值】，感觉是这个思路，但思路还有点儿不太彻底，这里想太复杂了。。。
        // // 【二分查找】：不知道，怎么动态处理 qs 里的、各阶段？看了一下提示，确认【思路方向正确】后自己写出来滴～～
        // // 【二分查找】：去想，动态处理 qs 里的、各阶段，只影响【差分数组】上的哪几个细节点？亲爱的表哥的活宝妹，先前写过类似的题目，【记忆力还在】！！！
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minZeroArray(int[] a, int[][] qs) {
        //     n = a.length; this.qs = qs;
        //     if (Arrays.stream(a).sum() == 0) return 0;
        //     // 【差分数组】：原位变成差分数组
        //     for (int i = n-1; i > 0; i--) 
        //         a[i] -= a[i-1]; this.a = a; 
        //     int l = 0, r = qs.length-1; // 【二分查找，左右端点】
        //     // 【过程中】：动态维护【差分数组】, 涉及【撤销效果】与【添加效果】
        //   pre = -1;
        //   int min = qs.length+1;
        //     while (l <= r) {
        //         int m = (l + r) / 2;
        //         if (isZeroArray(m)) {
        //             min = Math.min(min, m);
        //             r = m-1;
        //         } else l = m+1;
        //         pre = m;
        //     }
        //     return min > qs.length ? -1 : min + 1;
        // }
        // int [] a; int [][] qs;
        // int pre, n;
        // boolean isZeroArray(int j) {
        //     int bgn = (pre == -1 ? 0 : (pre < j ? pre+1 : j+1)), f = 0;
        //     for (int i = bgn; i <= Math.max(pre, j) && i < qs.length; i++) {
        //         int l = qs[i][0], r = qs[i][1];
        //         if (pre < j) { // [pre+1,j]
        //             a[l] -= qs[i][2];
        //             if (r < n-1)
        //                 a[r+1] += qs[i][2];
        //         } else { // j < pre: [j+1,pre]
        //             a[l] += qs[i][2];
        //             if (r < n-1)
        //                 a[r+1] -= qs[i][2];
        //         }
        //     }
        //     for (int i = 0; i < n; i++) {
        //         f += a[i];
        //         if (f > 0) return false;
        //     }
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉也是【差分数组】，可是，亲爱的表哥的活宝妹，这个题目，没有思路。。。
        // public int minDifference(int[] a) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean canAliceWin(int n) {
        //     if (n < 10) return false; // [1,9][19,26][34,39]
        //     if (n < 19) return true;  // [10,18][27,34)[40,45)
        //     if (n < 27) return false;
        //     if (n < 34) return true;
        //     if (n < 40) return false;
        //     if (n < 45) return true;
        //     if (n < 49) return false;
        //     if (n < 51) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，读不懂这个破烂题目，说的是什么意思。。。
        // public long shiftDistance(String S, String T, int [] a, int[] g) { // f:next g:prev
        //     int n = S.length(); char [] s = S.toCharArray(); char [] t = T.toCharArray();
        //     long [] f = new long [n+1];
        //     for (int i = 0; i < n; i++) {
        //         if (t[i] == s[i]) {
        //             f[i+1] = f[i];
        //             continue;
        //         }
        //         if (t[i] > s[i]) {
        //             long l = (long)a[s[i]-'a'] * (t[i] - s[i]), r = (long)g[s[i]-'a'] * (26-t[i]+s[i]);
        //             // 亲爱的表哥的活宝妹，昨天晚上、今天上午吃了【炸面片】的脑袋，在这里发酱紫。。。晚点儿再写这个破烂题目
        //             f[i+1] = f[i] + (Long.compare(l, r) <= 0 ? l : r);
        //         } else {
        //             long l = (long)g[s[i]-'a'] * (s[i]-t[i]), r = (long)a[s[i]-'a'] * (26 - s[i] + t[i]);
        //             f[i+1] = f[i] + (Long.compare(l, r) <= 0 ? l : r);
        //         }
        //         System.out.println(Arrays.toString(f));
        //     }
        //     return f[n];
        // }
        // String a = "abab";
        // String b = "baba";
        // int [] c = new int [] {100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        // int [] d = new int [] {1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxRemoval(int[] nums, int[][] queries) {
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个题目，同【左上角】【右上角】【2 个机器人】采樱桃的题型，好像，就只多了【左下角】一个小屁孩而已。。。
        // // 一定是【动规】！！亲爱的表哥的活宝妹，感觉思路想清楚了，可是答案还不对，需要再 debug 一下。。。
        // // 亲爱的表哥的活宝妹，吃午餐的时候，瓣瓣脚趾头想想：状态转移方程，没写对，改改应该就可以过了！！
        // public int maxCollectedFruits(int[][] a) {
        //     int n = a.length;
        //     // 考虑：当步数 x 固定，【左上角】【右上角】与【左下角】的坐标
        //     // 【左上角】：行列都不固定，但只需要记一个？只记一个好像不够用。。。。这里记【行下标】
        //     // 【右上角】：行【永远固定】，只记【列】
        //     // 【左下角】：列【永远固定】，只记【行】
        //     // 【动规】状态定义： f[i][j][k]: i 是【左上角、行坐标】;j 是【右上角、列坐标】；k 是【左下角、行】坐标
        //     int [][][][] f = new int [n][n][n][n];
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < n; j++)
        //             for (int k = 0; k < n; k++) 
        //             Arrays.fill(f[i][j][k], -1);
        //     f[0][0][n-1][n-1] = a[0][0] + a[0][n-1] + a[n-1][0];
        //     System.out.println("f[0][0][n-1][n-1]: " + f[0][0][n-1][n-1]);
        //     boolean [][] vis = new boolean [n][n];
        //     int [][] dra = {{1, 0}, {0, 1}, {1, 1}}; // 【左上角】移动方向
        //     int [][] drb = {{1, -1}, {1, 0}, {1, 1}};
        //     int [][] drc = {{-1, 1}, {0, 1}, {1, 1}};
        //     Set<int []> sa = new HashSet<>(), ssa = new HashSet<>();
        //     Set<Integer> sb = new HashSet<>(), ssb = new HashSet<>();
        //     Set<Integer> sc = new HashSet<>(), ssc = new HashSet<>();
        //     sa.add(new int [] {0, 0});
        //     sb.add(n-1);
        //     sc.add(n-1);
        //     for (int x = 1; x <= n-1; x++) { // The children will make exactly n - 1 moves
        //         for (int[] aa : sa) {
        //             int ii = aa[0], jj = aa[1];
        //             System.out.println("\n ii: " + ii + " " + "jj: " + jj);
        //             for (int [] da : dra) { // 先前位置：【ii,x-1-ii】, 现在位置【i,x-i】
        //                 int i = ii + da[0], ja = jj+da[1];
        //                 if (i >= n || ja >= n || vis[i][ja]) continue;
        //                 // System.out.println("i: " + i + " " + "ja: " + ja);
        //                 ssa.add(new int [] {i, ja});

        //                 for (int bb : sb) {
        //                     // System.out.println("bb: " + bb);
        //                     for (int [] db : drb) {
        //                         int ib = x, j = bb + db[1];
        //                         if (ib < 0 || j >= n || vis[ib][j]) continue;
        //                         // if (ib == i && j == ja) continue; // 两小屁孩，踩进同一格
        //                         // 【TODO：】把占同一个格的情况写里面，比较好写
        //                         // System.out.println("ib: " + ib + " " + "j: " + j);
        //                         ssb.add(j);
        //                         for (int cc : sc) {
        //                             // System.out.println("cc: " + cc);
        //                             for (int [] dc : drc) {
        //                                 int k = cc + dc[0], jc = x;
        //                                 if (k >= n || jc >= n || vis[k][jc]) continue;
        //                                 // if (k == i && jc == ja || k == ib && jc == j) continue; // 两小屁孩，踩进同一格
        //                                 // System.out.println("k: " + k + " " + "jc: " + jc);
        //                                 ssc.add(k);
        //                                 // vis[i][ja] = true;
        //                                 // vis[ib][j] = true;
        //                                 // vis[k][jc] = true;
        //                                 int va = a[i][ja], vb = a[ib][j], vc = a[k][jc];
        //                                 // 【状态转移方程】：在【前一状态】之后，现状态，
        //                                 // 【前状态】： f[ii][jj][bb][cc]
        //                                 if (f[i][ja][j][k] == -1 || va + vb + vc + f[ii][jj][bb][cc] > f[i][ja][j][k]) 
        //                                     f[i][ja][j][k] = va + vb + vc + f[ii][jj][bb][cc];
        //                                 // System.out.println("f[i][ja][j][k]: " + f[i][ja][j][k]);
        //                             }
        //                         }
        //                         // // 这些，不要放在后面处理，放前面处理，就可以了呀，。。比放后面简单好写
        //                         // int va = a[i][ja], vb = a[ib][j];
        //                         // if (f[i][ja][j][i] == -1 || va + vb + f[ii][jj][bb][ii] > f[i][ja][j][i]  // 【左上下、同一格】
        //                         //     || f[i][ja][j][x] == -1 || va + vb + f[ii][jj][bb][x] > f[i][ja][j][x])  // 【右上、左下、同一格】
        //                         //     if (va + vb + f[ii][jj][bb][ii] > f[i][ja][j][i])
        //                         //         f[i][ja][j][i] = va + vb + f[ii][jj][bb][ii];
        //                         //     else
        //                         //         // if (va + vb + f[ii][jj][bb][x] > f[i][ja][j][x])
        //                         //         f[i][ja][j][x] = va + vb + f[ii][jj][bb][x];
        //                         //     // else 
        //                         //     //     f[i][ja][j][k] = va + vb + f[ii][jj][bb][cc];
        //                     }
        //                 }
        //                 // int va = a[i][ja];
        //                 // // 这里，另2 个小屁孩的、各自前3 种情况，写得比较繁琐了。。。下午或是改天有兴趣时再弄。。。
        //                 // if (f[i][ja][ja][i] == -1 || va + f[ii][jj][])
        //             }
        //         }
        //         sa.clear();
        //         sa.addAll(ssa);
        //         ssa.clear();
        //         sb.clear();
        //         sb.addAll(ssb);
        //         ssb.clear();
        //         sc.clear();
        //         sc.addAll(ssc);
        //         ssc.clear();
        //     }
        //     return f[n-1][n-1][n-1][n-1];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumSumSubarray(List<Integer> li, int l, int r) {
        //     int n = li.size(), min = 100001;
        //     int [] a = new int [n], f = new int [n+1];
        //     for (int i = 0; i < n; i++) {
        //         a[i] = li.get(i);
        //         f[i+1] = f[i] + a[i];
        //     }
        //     for (int d = l; d <= r; d++) 
        //         for (int i = 0; i+d <= n; i++) 
        //             if (f[i+d] - f[i] > 0)
        //                 min = Math.min(min, f[i+d] - f[i]);
        //     return min == 100001 ? -1 : min;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean isPossibleToRearrange(String S, String T, int k) {
        //     int n = S.length(); char [] s = S.toCharArray(), t = T.toCharArray();
        //     Map<String, Integer> ss = new HashMap<>();
        //     for (int i = 0; i < n; i += n/k) {
        //         String cur = S.substring(i, i+n/k), curt = T.substring(i, i+n/k);
        //         if (s[i] == t[i] && cur.equals(T.substring(i, i+n/k)))
        //             continue;
        //         if (ss.containsKey(curt)) {
        //             ss.put(curt, ss.get(curt)-1);
        //             if (ss.get(curt) == 0)
        //                 ss.remove(curt);
        //         } else
        //             ss.put(curt, -1);
        //         ss.put(cur, ss.getOrDefault(cur, 0) + 1);
        //         if (ss.get(cur) == 0)
        //             ss.remove(cur);
        //     }
        //     return ss.size() == 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minArraySum(int[] a, int k, int ii, int jj) {
        //     n = a.length;
        //     int sum = Arrays.stream(a).sum();
        //     Arrays.sort(a); this.a = a; this.kk = k; 
        //     // 【排序】后、【倒序】遍历、【动规】求【减少】的最大值
        //     // 亲爱的表哥的活宝妹，写不到【动规】，就还是先去写【记忆化深搜】
        //     // int [][][][] f = new int [n+1][3][ii+1][jj+1]; // 0: ii 1:jj 2:ii+jj
        //     // for (int i = n-1; i >= 0 && ii+jj > 0; i--) {
        //     //     f[i][0][ii-1][jj] = f[i+1][]
        //     //     if (a[i] >= k)
        //     //     f[i][0]
        //     // }
        //     f = new Integer [n][ii+1][jj+1];
        //     int v = dfs(n-1, ii, jj);
        //     return sum - v;
        // }
        // Integer [][][] f;
        // int n, kk; int [] a;
        // // 最多操作 [j+k] 次，最大【减副】效果
        // int dfs(int i, int j, int k) { // i:idx 
        //     if (j == 0 && k == 0) return 0;
        //     if (i < 0) return 0;
        //     if (f[i][j][k] != null) return f[i][j][k];
        //     int r = 0;
        //     // 操作1:/2
        //     if (j > 0)
        //         r = Math.max(r, a[i] / 2 + dfs(i-1, j-1, k));
        //     // 操作2:a[i]>=k
        //     if (k > 0 && a[i] >= kk)
        //         r = Math.max(r, kk + dfs(i-1, j, k-1));
        //     // 两个都操作
        //     if (j > 0 && k > 0 && a[i] > kk) {
        //         if (a[i] - a[i]/2 < kk)
        //             r = Math.max(r, kk + (a[i]-kk > 1 ? (a[i] - kk)/2 : 0) + dfs(i-1, j-(a[i]-kk > 1 ? 1 : 0), k-1));
        //         else 
        //             r = Math.max(r, a[i] / 2 + (a[i] - a[i]/2 >= kk ? kk : 0) + dfs(i-1, j-1, k - (a[i] - a[i]/2 >= kk ? 1 : 0)));
        //     }
        //     return f[i][j][k] = r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maximizeSumOfWeights(int[][] egs, int k) {
        //     n = egs.length + 1; this.k = k; 
        //     long totalWeight = 0;
        //     // 【权重】：【由小到大】
        //     g = new PriorityQueue[n];
        //     Arrays.setAll(g, z -> new PriorityQueue<int []>((x, y) -> x[1] - y[1]));
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1], w = e[2];
        //         g[u].offer(new int [] {v, w});
        //         g[v].offer(new int [] {u, w});
        //         totalWeight += w;
        //     }
        //     f = new Long [n];
        //     long v = dfs(0, -1);
        //     // System.out.println(Arrays.toString(f));
        //     return totalWeight - v;
        // }
        // Queue<int []> [] g;
        // // List<int []> [] g;
        // Long [] f;
        // int n, k;
        // // 感觉，亲爱的表哥的活宝妹，弄得，像是【遍历、轻链树？】一样。。。
        // // 实时更新：如果【子树】链边断开了，【父树】效应？？
        // long dfs(int u, int p) {
        //     int egsToBeRemoved = Math.max(0, g[u].size() - k);
        //     long r = 0;
        //     for (int [] n : g[u]) {
        //         int v = n[0], w = n[1];
        //         // if (v == p) continue;
        //         if (v == p) {
        //             if (egsToBeRemoved > 0) {
        //                 // 亲爱的表哥的活宝妹，觉得、这个题目这里，可能没能想透彻，这个题目暂时不写了。。
        //                 r += w;
        //                 --egsToBeRemoved;
        //             }
        //             continue;
        //         }
        //         // 先、【深搜子树】
        //         dfs(v, u);
        //         // 累加：【子树效应】
        //         r += f[v]; 
        //         if (egsToBeRemoved > 0) {
        //             r += w;
        //             egsToBeRemoved--;
        //         }
        //     }
        //     f[u] = r;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int smallestNumber(int n) {
        //     int f = n;
        //     for (int i = 9; i >= 0; i--) {
        //         if (n < (1 << i)) continue;
        //         if ((n & (1 << i)) == 0)
        //             f |= (1 << i);
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int getLargestOutlier(int [] a) {
        //     int n = a.length, sum = Arrays.stream(a).sum();
        //     Arrays.sort(a); 
        //     Map<Integer, Integer> s = new HashMap<>();
        //     for (int v : a) 
        //         s.put(v, s.getOrDefault(v, 0) + 1);
        //     for (int i = n-1; i >= 0; i--) 
        //         if ((sum - a[i]) % 2 == 0 && s.containsKey((sum - a[i]) / 2)
        //             && ((sum - a[i]) / 2 != a[i] || s.get((sum - a[i]) / 2) > 1)) {
        //             System.out.println("a[i]: " + a[i]);
        //             return a[i];
        //         }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 思路应该还是比较简单：甲树，所有【1,n-1】节点到0 节点的【最短距离】，然后【换根DP】；乙树：找到【树的重心】？
        // // 然后，就成为：乙树、【树的重心】节点，到甲树，所有节点的【换根DP】
        // // 亲爱的表哥的活宝妹，感觉，想到这里，思路算是比较清楚，
        // // 可是写的时候，乙树：找到【树的重心】？好像忘记了，先前看机器题解，只看了一遍，没太看懂就容易忘记，看懂了就不会忘记！！
        // // 另外，连的时候，随【甲树、DFS换根？】，【乙树的、重心节点】为什么不是固定的呢？
        // // 破烂题目：亲爱的表哥的活宝妹，随便想想，都比这【暴力】解法想得远。。。
        // // 知道是用【暴力】求解，亲爱的表哥的活宝妹，不再看题解，也该能够自己写得出来了。。。// TLE TLE TLE 
        // public int[] maxTargetNodes(int[][] egs, int[][] egss, int k) {
        //     m = egss.length + 1; n = egs.length + 1;
        //     int [] ans = new int [n];
        //     if (k == 0) {
        //         Arrays.fill(ans, 1);
        //         return ans;
        //     }
        //     g = new ArrayList [n];
        //     gg = new ArrayList [m];
        //     Arrays.setAll(g, z -> new ArrayList<>());
        //     Arrays.setAll(gg, z -> new ArrayList<>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     for (int [] e : egss) {
        //         int u = e[0], v = e[1];
        //         gg[u].add(v);
        //         gg[v].add(u);
        //     }
        //     // 【第二棵树】：【某个最佳节点——最多合法节点】距离其它本树的节点距离合法的、其它节点的总个数，本题中是【固定不变】的，只用计算一遍！！！
        //     int maxCnts = 1;
        //     cnts = 0;
        //     for (int j = 0; j < m; j++) {
        //         cnts = 0;
        //         dfs(j, -1, 0, k-1, gg);
        //         maxCnts = Math.max(maxCnts, cnts);
        //     }
        //     for (int i = 0; i < n; i++) {
        //         cnts = 0;
        //         dfs(i, -1, 0, k, g);
        //         ans[i] += cnts + maxCnts;
        //     }
        //     return ans;
        // }
        // List [] g, gg;
        // int m, n, cnts;
        // void dfs(int u, int p, int d, int l, List<Integer> [] g) {
        //     if (d <= l) 
        //         cnts++;
        //     else return ;
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         dfs(v, u, d+1, l, g);
        //     }
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 如上面的【暴力解法】，亲爱的表哥的活宝妹，是一定写得出来的
        // 问题是：【暴力解法】，在O(N=10^5 × logN) 下不会超时吗？实测，超时了。。。TLE TLE TLE
        // 【优化】：觉得【第一棵树】，有什么【换根动规DFS】的特性，得实现。。。
        //          或是，先前某些题型的：【2 遍DFS: 一遍普通DFS, 第二遍换根动规DFS】
        public int[] maxTargetNodes(int[][] egs, int[][] egss) {
            m = egss.length + 1; n = egs.length + 1;
            ans = new int [n];
            g = new ArrayList [n];
            gg = new ArrayList [m];
            Arrays.setAll(g, z -> new ArrayList<>());
            Arrays.setAll(gg, z -> new ArrayList<>());
            for (int [] e : egs) {
                int u = e[0], v = e[1];
                g[u].add(v);
                g[v].add(u);
            }
            for (int [] e : egss) {
                int u = e[0], v = e[1];
                gg[u].add(v);
                gg[v].add(u);
            }
            // 【第二棵树】：【某个最佳节点——最多合法节点】距离其它本树的节点距离合法的、其它节点的总个数，本题中是【固定不变】的，只用计算一遍！！！
            // 【奇偶性变化】后，上面的，还对吗？还是要同第一棵树一样呢？？至少也需要【奇偶性】吧。。。
            int maxCnts = 0;
            cnts = 0;
            for (int j = 0; j < m; j++) {
                cnts = 0;
                dfs(j, -1, 0, gg, 1);
                maxCnts = Math.max(maxCnts, cnts);
            }
            Arrays.fill(ans, maxCnts);
            // 下面，亲爱的表哥的活宝妹，把题目写得太细化了，还需要再总结归纳一下。。。【TODO：】
// 定义：以【0 节点】为根节点的树中，以各节点为根节点的子树的、合法节点个数. 【既记奇数，也记偶数】？或是记【偶数，与，总个数】先试写后者
            f = new int [n]; // 【定义】：以当前节点【i】为根节点的树中，各子树的合法【偶数】节点个数
            ff = new int [n];// 子树总结点数
            Arrays.fill(f, 1); // 【每个节点】：自己本身，就是一个合法节点
            // 【第1 遍DFS】
            dfsOne(0, -1, g);
            // 【第2 遍DFS】：【树型动规、换根DP 动规，换根DFS】？？？
            dfsOneSecondTime(0, -1, g);      // 复杂度：O(N) 应该就不会超时TLE 了: 还是超时了 TLE TLE TLE 。。。。眠灭人性。。。
            // for (int i = 0; i < n; i++) { // 复杂度：O(NlogN)
            //     cnts = 0;
            //     dfs(i, -1, 0, g, 0);
            //     ans[i] += cnts + maxCnts;
            // }
            return ans;
        }
        List<Integer> [] g, gg;
        int m, n, cnts;
        int [] f, ff, ans;
        // 【树型动规、换根DP 动规，换根DFS】？？？
        // 亲爱的表哥的活宝妹，现在【自顶向下】在更新答案，但好像仍然该是【自顶向上】？？？
        void dfsOneSecondTime(int u, int p, List<Integer> [] g) {
            if (p == -1)
                ans[u] += f[u]; // 原本的【0 根节点】的全局树
            // 【换根DP】：树型DFS遍历，执行遍历过程中，【换根】对【结果】的【增减偏差量】
            // 精确计算：从【父节点 u】为根节点，到【子节点 v】为根节点，对【结果】的【增减偏差量】
            // 过程中：【动规】动态、【实时】更新 f[] 与 ff[] 全局数据  // <<<<<<<<<<<<<<<<<<<< 这个细节没写对
            for (int v : g[u]) {
                if (v == p) continue;
                // 新【v】为根节点的树中，合法个数
                // ＝ 原本【u】为根节点时，【v】为根节点子树的合法个数 (f[v])
                // ＋ 新【v】为根节点的树中，【u】为根节点的子树中【不合法】的个数
                //    ＝ 新子树总个数（ff[u]-ff[v]）
                //    － 新子树【当前】合法个数(f[u] - (ff[v]-f[v]))  // <<<<<<<<<<<<<<<<<<<< 这个细节没写对。。。
                // ans[v] += f[v] + (ff[u] - ff[v]) - (f[u] - (ff[v] - f[v]));
                ff[u] -= ff[v];       // 裁减掉、一个子树
                f[u] -= ff[v] - f[v]; //【合法数】：裁减掉、一个子树的【非合法数】
                int preFV = f[v];
                f[v] = f[v] + ff[u] - f[u];
                ans[v] += f[v];
                ff[v] += ff[u]; // 新【v】根树，变大
                // 遍历【新子节点】前，树上【作记号？】有必要吗？  // <<<<<<<<<<<<<<<<<<<< 
                dfsOneSecondTime(v, u, g);
                ff[v] -= ff[u];
                f[v] = preFV;
                ff[u] += ff[v];
                f[u] += ff[v] - f[v];
            }
        }
        void dfsOne(int u, int p, List<Integer> [] g) {
            int ss = 1; // 计算：以 U 为根节点的子树的、【总节点个数】
            for (int v : g[u]) {
                if (v == p) continue;
                dfsOne(v, u, g);
                ss += ff[v];
                // 以【u】为根节点的树中，【偶数】合法总个数：加的是【子节点、奇数】合法个数
                f[u] += ff[v] - f[v];
            }
            // if (ss == 1) // 【叶子节点】，特殊情况，预处理过了
            //     f[u] = 1; // 定义：以
            ff[u] = ss;
        }
        void dfs(int u, int p, int d, List<Integer> [] g, int one) {
            if (d % 2 == one) 
                cnts++;
            for (int v : g[u]) {
                if (v == p) continue;
                dfs(v, u, d+1, g, one);
            }
        }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    public static void main (String[] args) { 
		Solution s = new Solution ();

        int [][] a = new int [][] {{0,1},{0,2},{2,3},{2,4}};
        int [][] b = new int [][] {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};

        int [] r = s.maxTargetNodes(a, b);
        System.out.println(Arrays.toString(r));
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