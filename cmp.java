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
// 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
public class cmp {
    // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
    public static class Solution { 
        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目，狠简单，但就是细节繁琐，遇上一个刚过去两天假日把自己胀傻的脑袋不转的活宝妹。。改了这么久才把破烂细节改过来。。。
        // public int minMirrorPairDistance(int[] a) {
        //     int n = a.length, f = Integer.MAX_VALUE;
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = 0; i < n; i++) 
        //         m.computeIfAbsent(a[i], z -> new ArrayList<>()).add(i);
        //     for (int i = 0; i < n; i++) {
        //         int v = a[i];
        //         int j = Integer.parseInt(new StringBuilder(String.valueOf(v)).reverse().toString());
        //         if (m.containsKey(j) && (v != j || m.get(j).size() > 1)) {
        //             List<Integer> li = m.get(j);
        //             // 【二分查找】：（有序链条）中的下标
        //             int idx = Collections.binarySearch(li, i); // java 里 binarySearch() 返回值的意义，还没理解透彻，还没写透彻
        //             int k = 0;
        //            if (idx >= 0) { // 应该只存在于 v == j 的情况里 
        //                while (idx < li.size() &&  li.get(idx) <= i) idx++;
        //                 k = idx;
        //             } else k = (idx + 1) * (-1);
        //             f = Math.min(f, li.size() > k ? Math.abs(i - li.get(k)) : Integer.MAX_VALUE);
        //         }
        //         if (f == 1) return 1;
        //     }
        //     return f == Integer.MAX_VALUE ? -1 : f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maxDistinct(String S) {
        //     int n = S.length(), r = 0; char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s)
        //         f[c-'a']++;
        //     for (int v : f)
        //         if (v > 0) r++;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，放假两天吃喝了太多毒药，这两天有点儿冒傻，不知道哪里写错了，晚点儿再写这个
        // // 亲爱的表哥的活宝妹，不知道这里哪里细节写错了，还有最后几个测试用例没过。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countElements(int[] a, int k) {
        //     int n = a.length;
        //     if (k == 0) return n;
        //     Integer [] f = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        //     Arrays.sort(f, (i, j)->a[i] != a[j] ? a[j] - a[i] : i - j);
        //     int p = a[f[0]], i = 1;
        //     while (i < n && a[f[i]] == p) i++;
        //     if (i == n) return 0;
        //     --k;
        //     while (k > 0 && i < n) {
        //         while (i < n && a[f[i]] == p) i++;
        //         if (i == n) return 0;
        //        p = a[f[i]];
        //        --k;
        //        i++;
        //     }
        //     if (i == n) return 0;
        //     while (i < n && a[f[i]] == p) i++;
        //     return n - i;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 维护：【0,n-1】上（差分数组）％k 取余的余数
        // // BIT 【最大值、最小值、线段树？】 维护 【0,n-1】上（差分数组）％k 取余的余数，数量级在【0,10_000】不会超时
        // // 对每个 query, 求 [l,r] 差分数组 %k 区间的【>0 的最小、最大值 min-max】
        // // 若 min 与 max 不同，此 query 返回－1;
        // // 若 min 与 max 相同，此 query 返回？【TODO：】这里还有一点儿没想透彻。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long[] minOperations(int[] a, int k, int[][] qs) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean completePrime(int v) {
        //     String S = String.valueOf(v);
        //     char [] s = S.toCharArray();
        //     int n = s.length, f = 0;
        //     for (int i = 0; i < n; i++) {
        //         f = f * 10 + s[i]-'0';
        //         if (!isPrime(f)) return false;
        //     }
        //     f = 0;
        //     for (int i = 1; i <= n-1; i++) {
        //         f = Integer.parseInt(S.substring(i, n));
        //         if (!isPrime(f)) return false;
        //     }
        //     return true;
        // }
        // boolean isPrime(int v) {
        //     if (v == 1) return false;
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] minOperations(int[] a) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得，这应该是【世界上最简单的动规】了吗？！！！除非笨宝妹把它写【TLE TLE TLE 超时】了。。。
        // // 这个破烂题目，感觉【动规】的思路极其简单，可是写的过程中，被亲爱的表哥的活宝妹、笨宝妹写趴了。。感觉昨天一整天昨天晚上大风带走了雨雪水湿夜间休息被世界上最贱恶的追杀谋杀杀的它们的贱鸡、贱畜牲恶吵，亲爱的表哥的活宝妹，写这个【动规】的过程中，脑袋就迷糊掉了、写不清楚了。。
        // public long maxPoints(int[] a, int[] b, int kk) {
        //     int n = a.length, k = 0;
        //     long [][] f = new long [n+1][kk > 0 ? kk+1 : n+1]; // O(NK)?O(NN)?
        //     for (int i = 0; i < n; i++) {
        //         k = Math.min(kk > 0 ? kk : n, i+1);
        //         System.out.println("" );
        //         System.out.println("i: " + i + " " + "k: " + k);
        //       // 把当前下标【i】强制为 a[] 里任务
        //         for (int j = 0; j <= k; j++) {
        //             System.out.println("j: " + j);
        //             f[i+1][j] = Math.max((j > 0 ? f[i][j-1] + (long)a[i] : f[i+1][j]), f[i][j] + (long)b[i]);
        //        // if (j < k)
        //        //          // 【TODO：】亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这里忘记了：是怎么优化出、全局最优解的？？？
        //        //          f[i+1][j] = Math.max((j > 0 ? f[i][j-1] + (long)a[i] : 0), f[i][j] + (long)b[i]);
        //        //      else
        //        //      // if (j == i+1) //if (j > 0)
        //        //          // f[i+1][j] = (j > 0 ? f[i][j-1] + (long)a[i] : (long)b[i]);
        //        //          f[i+1][j] = Math.max(f[i][j] + (long)b[i], f[i][j-1] + (long)a[i]);
        //        // System.out.println("f.length: " + f.length);
        //        // for (int z = 0; z < f.length; ++z)
        //        //     System.out.println(Arrays.toString(f[z]));
        //         }
        //     }
        //    return kk > 0 ? f[n][kk] : LongStream.of(f[n]).max().getAsLong();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] sortByReflection(int[] a) {
        //     int n = a.length;
        //     Integer [] f = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        //     Arrays.sort(f, new Comparator<Integer> () {
        //             @Override public int compare(Integer i, Integer j) {
        //                 int x = Integer.parseInt(removeLeadingZeroes(new StringBuilder(Integer.toBinaryString(a[i])).reverse().toString()), 2);
        //                 int y = Integer.parseInt(removeLeadingZeroes(new StringBuilder(Integer.toBinaryString(a[j])).reverse().toString()), 2);
        //                 int cmp = x - y;
        //                 if (cmp != 0) return cmp;
        //                 return a[i] - a[j];
        //             }
        //         });
        //     System.out.println(Arrays.toString(f));
        //     int [] r = new int [n];
        //     for (int i = 0; i < n; i++)
        //         r[i] = a[f[i]];
        //     System.out.println(Arrays.toString(r));
        //     return r;
        // }
        // public String removeLeadingZeroes(String num){
        //     int i=0;
        //     char charArray[] = num.toCharArray();
        //     for( ; i<= charArray.length; i++){
        //         if(charArray[i] != '0'){
        //             break;
        //         }
        //     }
        //     return (i == 0) ? num :num.substring(i);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int largestPrime(int n) {
        //     if (n < 2) return 0;
        //     for (int i = n; i >= 2; i--) {
        //         if (!isPrime(i)) continue;
        //         return i;
        //     }
        //     return 0;
        // }
        // boolean isSumable(int v) {
        // }
        // boolean isPrime(int v) {
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，读不懂这个破烂题目... 可能会超时？？？？950/979 passed
        // public long totalScore(int hp, int[] a, int[] b) {
        //     int n = a.length, j = 0, cur = hp;
        //     long r = 0;
        //     // int [] f = new int [n+1], ff = new int [n+1]; // a[i] 前缀和
        //     // for (int i = 0; i < n; i++) {
        //     //     f[i+1] = f[i] + a[i];
        //     //     ff[i+1] = ff[i] + b[i];
        //     // }
        //     // 先，试写【暴力解法】
        //     for (int i = 0; i < n; i++) {
        //         cur = hp;
        //         j = i;
        //         while (j < n && cur > 0 && cur - a[j] >= b[j]) {
        //             r ++;
        //             cur -= a[j];
        //             j ++;
        //         }
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，感觉，这个破烂题目，像是：【树型动规】中的【换根、树型动规】？
        // // 可是，【换根树型动规】的细节，感觉被亲爱的表哥的活宝妹、笨宝妹忘记光了。。。        
        // public int[] maxSubgraphScore(int n, int[][] egs, int[] a) {
        //     this.n = n; g = new ArrayList[n]; this.a = a; 
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int [] e : egs) {
        //         int u = e[0], v = e[1];
        //         g[u].add(v);
        //         g[v].add(u);
        //     }
        //     // 纪录【整个树、不是子树！】： good － bad 节点数
        //     // 【TODO：】应该纪录，以【0】为根节点的树，以【i】为根节点的（子树）上， good/bad 节点数『最多/最少』的（路径 Path）上的 good/bad 节点个数
        //     f = new int [n]; ff = new int [n];
        //     fa = dep = siz = son = top = dfn = rnk = new int [n];
        //     // 预处理数据：数据【初始化：以 0 为根节点】当作（有向树）来遍历
        //     // 【TODO：】亲爱的表哥的活宝妹、笨宝妹觉得，这里应该加上【重链树剖？排序】才更方便，这里（重链）定义为 good 节点最多的子树链？
        //     // 【TODO：】亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这里如果 good 用【重链重儿了】纪录，是否同时同步纪录 bad 用【最轻链、最轻儿子】来也纪录？
        //     // 【TODO：】【重链树剖？排序】
        //     // 【TODO：】不用去想【重链路、轻链路】，
        //     // 感觉这里涉及【所有子树】的参与与否，经典题型如（没有上司的舞会）？某个上司的任何下属（及其下属）都是可能参与的，
        //     // 所以涉及任何子树的【参与与否】的动规选择与状态转换，那就仍然是数【子树里的、good/bad 总数】最方便
        //     dfs(0, -1);
        //     // 【重链】搭建
        //     idx = 0;
        //     // dfsdfs(0, 0);
        //     // 【换根动规】：可能会影响【重链】，可能把一个重链拆成 2 个。。。

        //     // 【换根动规】：
        //     // 感觉这里涉及【所有子树】的参与与否，经典题型如（没有上司的舞会）？某个上司的任何下属（及其下属）都是可能参与的，
        //     // 所以涉及任何子树的【参与与否】的动规选择与状态转换，那就仍然是数【子树里的、good/bad 总数】最方便
        //     r = new int [n];
        //     // 【换根动规】：要考虑换树，对重链的影响
        //     dfsdfs(0, -1);
        //     return r;
        // }
        // List<Integer> [] g;
        // int n, idx; int [] a;
        // int [] r, f, ff;
        // // // 求解： r[] 不按 idx[0...n-1] 序，按树遍历
        // // void dfsdfs(int u, int p) {
        // //     int max = f[u] - ff[u];
        // //     if (son[u] != 0) {
        // //         // 【根节点 u】＋【 son[u] 重链路】
        // //         max = Math.max(max, f[son[u]] - ff[son[u]] + a[u] * (a[u] > 0 ? 1 : -1));
        // //         // 【TODO：】，亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这里，只考虑了：
        // //         //     以【 u】为根节点的原树的子树，和
        // //         //     以【son[u]】为根节点的重链路＋子树【根节点 u】：一条路径 path
        // //         //     而没能考虑，包括：其它非【重链】Path, 和（换根前换根后）形成的【新、前父节点 u 链路 Path】
        // //         // 【TODO：】感觉，这里应该存在一个、笨宝妹脑袋里冒出来的【重链路】与【轻链路】的贪心解法、或优化存在，才对。。
        // //         // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，今天写不到这个破烂题目。。。改天、将来，亲爱的表哥的活宝妹、笨宝妹可能写得出来。、。。
        // //         dfsdfs(son[u], ftop); // ftop: 【重链的顶端节点】
        // //     }
        // //     for (int v : g[u]) {
        // //         if (v != son[u] && v != fa[u])
        // //             dfsdfs(v, v); // 轻链：以自己为（顶端节点）
        // //     }
        // // }
        // void dfs(int u, int p) {
        //     fa[u] = p;
        //     dep[u] = (p == -1 ? 0 : dep[p]) + 1;
        //     siz[u] = 1;
            
        //     f[u] = a[u]; // 【初始化】当前（根节点） 
        //     // 【0 为根节点、有向树：叶子节点】
        //     if (g[u].size() == 1 && g[u].get(0) == p) {
        //         // f[u] = a[u];      // good
        //         ff[u] = 1 - a[u]; // bad
        //         return ;
        //     }
        //     for (int v : g[u]) {
        //         if (v == p) continue;
        //         dfs(v, u);
        //         siz[u] += siz[v];
        //         // 【重链重儿子】：实时更新
        //         // if (siz[v] > siz[son[u]]) // 【TODO：】这个【重链】的比较标准，不对
        //         if (f[v] - ff[v] > f[son[u]] - ff[son[u]]) 
        //             son[u] = v;
                
        //         f[u] += f[v];
        //         ff[u] += ff[v];
        //     }
        //     ff[u] += 1 - a[u];
        // }        
        // int [] fa, dep, siz, son, top, dfn, rnk;
        // void dfsdfs(int u, int ftop) { // ftop: 【重链的顶端节点】
        //     top[u] = ftop;
        //     dfn[u] = ++idx;
        //     rnk[idx] = u;
        //     if (son[u] != 0)
        //         dfsdfs(son[u], ftop); // ftop: 【重链的顶端节点】
        //     for (int v : g[u]) {
        //         if (v != son[u] && v != fa[u])
        //             dfsdfs(v, v); // 轻链：以自己为（顶端节点）
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int absDifference(int[] a, int k) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     int [] f = new int [n+1];
        //     for (int i = 0; i < n; i++)
        //         f[i+1] = f[i] + a[i];
        //     return f[n] - f[n-k] - (f[k] - f[0]);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String reverseWords(String S) {
        //     String [] sa = S.split(" ");
        //     StringBuilder sb = new StringBuilder(sa[0]);
        //     if (sa.length == 1) return sb.toString();
        //     sb.append(' ');
        //     int r = getVowelCnts(sa[0]);
        //     for (int i = 1; i < sa.length; i++) {
        //         if (getVowelCnts(sa[i]) == r)
        //             sb.append(new StringBuilder(sa[i]).reverse().toString());
        //         else sb.append(sa[i]);
        //         if (i < sa.length-1)
        //         sb.append(' ');
        //     }
        //     return sb.toString();
        // }
        // Set<Character> s = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        // int getVowelCnts(String S) {
        //     int f = 0;
        //     for (char c : S.toCharArray()) 
        //         if (s.contains(c)) f++;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，读不懂这个破烂题目，尤其是2 个例子的案例，实例分析互相矛盾、读不懂。。。【circular 滚动数组】。。。
        // // 这个破烂题目、最初读丢了【环形数组】所以读不懂题目、、后来读懂了，就是感觉细节恶心吧拉地。。只能捡一个【最方便避免犯小细节错误】的相对低效写法来写，
        // // 感觉这种破烂题目恶心吧啦地。。
        // public long minMoves(int[] a) {
        //     int n = a.length, k = -1, i = 0, j = 0;
        //     long sum = 0;
        //     for (int v : a)
        //         sum += (long)v;
        //     if (sum < 0) return -1;
        //     for ( i = 0; i < n; i++)
        //         if (a[i] < 0) {
        //             k = i;
        //             break;
        //         }
        //     if (k == -1) return 0;
        //     long f = 0;
        //     for (int d = 1; d <= n/2 && a[k] < 0; d++) {
        //         i = k-d;
        //         if (i < 0) i += n;
        //         if (a[i] > 0) {
        //             f += (i < k ? d : Math.min(d, i-k)) * (long)Math.min(a[k] * (-1), a[i]);
        //             a[k] += a[i];
        //             if (a[k] >= 0) return f;
        //         }
        //         j = k+d;
        //         if (j >= n) j -= n;
        //         if (a[j] > 0) {
        //             f += (j > k ? d : Math.min(d, k-j)) * (long)Math.min(-1 * a[k], a[j]);
        //             a[k] += a[j];
        //             if (a[k] >= 0) return f;
        //         }
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不想再写这个破烂题目了，感觉细节恶心吧啦地。。除非能够想到狠好的【方便避免犯小细节错误】的解题写法，笨宝妹不喜欢写这些感觉既没有技术含量又极度恶心吧啦的破烂题目。。。这个题目今天不写了。。前几个题目也都太简单，今天晚上这组比赛题目出得没什么意思。。
        // public int[] minDeletions(String S, int[][] qs) {
        //     n = S.length(); char [] s = S.toCharArray();
        //     f = new int [n]; // A=0 B=1
        //     for (int i = 0; i < n; i++)
        //         f[i] = s[i] - 'A';
        //     List<Integer> li = new ArrayList<>();
        //     for (int i = 0; i < qs.length; i++) 
        //         if (qs[i][0] == 1)
        //             f[qs[i][1]] = 1 - f[qs[i][1]];
        //         else {
        //             int l = qs[i][1], r = qs[i][2];
        //             li.add(getMinCnts(l, r));
        //         }
        //     int [] ans = new int [li.size()];
        //     int i = 0;
        //     for (int v : li) 
        //         ans[i++] = v;
        //     return ans;
        // }
        // int [] f; int n;
        // int getMinCnts(int l, int r) {
        //     System.out.println(Arrays.toString(f));
        //     if (l == r) return 0;
        //     int cur = 0, curr = r-l+1, p = f[l], pp = 1-f[l];
        //     for (int i = l+1; i <= r; i++) {
        //         // cur: 以 f[l] 打头
        //         // curr: 以 1-f[l] 打头
        //         if (f[i] == p) {
        //             cur++;
        //             if (curr != r-l+1)
        //                 pp = f[i];
        //         }
        //         //else
        //         if (f[i] == pp) {
        //             if (curr == r-l+1)
        //                 curr = i-l;
        //             else
        //                 curr++;
        //             p = f[i];
        //         }
        //     }
        //     return Math.min(cur, curr);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minOperations(int[] a) {
        //     int n = a.length, ans = 0;
        //     int [] f = new int [n]; Arrays.fill(f, -1);
        //     int [] r = new int [n]; Arrays.fill(r, -1);// 需要移除掉的、最小下标 idx
        //     Map<Integer, Integer> m = new HashMap<>();
        //     m.put(a[n-1], n-1);
        //     for (int i = n-2; i >= 0; i--) {
        //         if (m.containsKey(a[i])) {
        //             f[i] = m.get(a[i]);
        //             r[i] = Math.max(i, r[i+1]);
        //         } else
        //             r[i] = r[i+1];
        //         m.put(a[i], i);
        //     }
        //     if (r[0] == -1) return 0;
        //     if (n < 3) return 1;
        //     for (int i = 2; i < n; i += 2) 
        //         r[i] = Math.max(r[i], Math.max(r[i-1], r[i-2]));
        //     for (int i = 2; i < n; i += 3) {
        //         if (r[i] <= i) return ans + 1;
        //         ans++;
        //     }
        //     return ans + 1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximumSum(int[] a) {
        //     int n = a.length;
        //     Arrays.sort(a);
        //     System.out.println(Arrays.toString(a));
        //     Map<Integer, List<Integer>> m = new HashMap<>();
        //     for (int i = n-1; i >= 0; i--) {
        //         int j = a[i] % 3;
        //         if (!m.containsKey(j))
        //             m.computeIfAbsent(j, z -> new ArrayList<>()).add(a[i]);
        //         else if (m.get(j).size() < 3) {
        //             m.get(j).add(a[i]);
        //             if (m.get(j).size() == 3) {
        //                 boolean enough = true;
        //                 for (int k = 0; k < 3; k++) {
        //                     if (k == j) continue;
        //                     if (!m.containsKey(k) || m.get(k).size() < 3) enough = false;
        //                 }
        //                 if (enough) break;
        //             }
        //         }
        //     }
        //     // if (m.size() < 3) return 0;
        //     int k = 0;
        //     if (m.size() == 3)
        //         k = m.get(0).get(0) + m.get(1).get(0) + m.get(2).get(0); 
        //     if (m.containsKey(0) || m.containsKey(1) || m.containsKey(2)) {
        //        int i = (m.containsKey(1) && m.get(1).size() == 3 ? m.get(1).stream().mapToInt(Integer::intValue).sum() : 0);
        //        int j = (m.containsKey(2) && m.get(2).size() == 3 ? m.get(2).stream().mapToInt(Integer::intValue).sum() : 0);
        //        int x = (m.containsKey(0) && m.get(0).size() == 3 ? m.get(0).stream().mapToInt(Integer::intValue).sum() : 0);
        //         if ((!m.containsKey(0) || m.get(0).size() < 3) || (!m.containsKey(1) || m.get(1).size() < 3) && (!m.containsKey(2) || m.get(2).size() < 3))
        //             return ((!m.containsKey(0) || m.get(0).size() < 3) ? Math.max(k, Math.max(i, j)) : Math.max(k, x));
        //         return Math.max(Math.max(x, k), Math.max(i, j)); 
        //     }
        //     return k;
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 【思路错误】：每个子片段（局部最优解），子片段合并后并不累积：全局最优解。。
//         // 【动规】：这个【兼并了贪心——同值重复数字，永远取最左边】的动规，笨宝妹不会写这个动规
//         // 【记忆化深搜】：应该能够写得出来；感觉记忆化深搜就像写【暴力】一样搜索了所有的可能性，但是必定会TLE TLE TLE... 所以，不想写这个破烂题目了。。。
//         // 破烂题目，出得不好：无限抹杀解题热情、现在看着这个破烂题目就够了。。。
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 亲爱的表哥的活宝妹，昨天晚上又被世界上最贱恶的追杀、谋杀杀人的它们的贱鸡贱畜牲爪牙恶吵
        // 它们的贱鸡、贱畜牲，真贱：就它妈的至贱无敌地、一定要半夜恶开窗、利用 freeway 过往车辆声恶吵恶打扰笨宝妹的休息、把别人折磨成肾脏衰竭、被它们的贱鸡贱畜牲活活折磨死
        // 它们的贱鸡、贱畜牲，真贱：就它妈的至贱无敌地、一定要半夜恶开窗夜间、午夜或是凌晨的大风、恶冻笨宝妹，想要把笨宝妹恶冻至感冒发烧免疫瘫痪败血症多脏器衰竭谋杀杀人
        // 它们的贱鸡、贱畜牲，真贱；出门就被车撞死、出门就被雷劈死；开打雷劈得不好死；不是不报，时候未到，它们的贱鸡、贱畜牲，迟早遭报应；天底下最贱恶的一群贱渣！！！
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         public long maximumScore(int[] a, String S) {
//             char [] s = S.toCharArray();
//             int n = a.length, i = 0, j = n-1;
//             ArrayDeque<Integer> q = new ArrayDeque<>(); // 【最大堆－单调队列：降序排列】
//             long ans = 0;
//             int [] f = new int [n]; Arrays.fill(f, -1);
//             while (j >= 0 && s[j] == '0') --j; // 最尾一个1
//             if (j < 0) return 0;
//             while (i < n && s[i] == '0') {
//                 while (!q.isEmpty() && a[q.peekFirst()] < a[i]) q.pollFirst();
//                 q.offerFirst(i);
//                 i++;  // 最头一个1
//             }
//            while (i <= j) { // 【自左向右】：遍历i: s[i]='1'
//                 // s[i]='1'; 这里，是可能：【i==j】的
//                 // 当前下标【i: 入单调递减队列】
//                while (!q.isEmpty() && a[q.peekFirst()] < a[i]) q.pollFirst();
//                q.offerFirst(i);
// // 取局闻最优解
//                ans += (i == 0 ? a[0] : a[q.peekLast()]);
//                 if (!q.isEmpty()) q.pollLast();

//                 ++i;
//                 if (i > j) return ans;
//                 // i <= j
//                 while (i < j && s[i] == '0') {
//                     while (!q.isEmpty() && a[q.peekFirst()] < a[i]) q.pollFirst();
//                     q.offerFirst(i);
//                     i++;
//                 }
//             }
//             return 0;
//         }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
        public static void main (String[] args) { 
		Solution s = new Solution ();

        int []   a = {5, 6, 4, 6, 10, 3, 2, 2, 6}; //5-6-6-10-6 
        String b = "010010111";

        System.out.println("b: " + b);
        System.out.println(Arrays.toString(a));

        long r = s.maximumScore(a, b);
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
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】