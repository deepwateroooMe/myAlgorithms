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
        // int []   a = {5, 6, 4, 6, 10, 3, 2, 2, 6}; //5-6-6-10-6 
        // String b = "010010111";

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int mirrorDistance(int n) {
        //     int r = Integer.parseInt((new StringBuilder(String.valueOf(n)).reverse()).toString().replaceFirst("^0+(?!$)", ""));
        //     return Math.abs(n - r);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：这个破烂题目，是伪装仅只四分、简单题目的、实际上的难题、、、晚点儿再写这个
        // // 这个破烂题目：无限遭人恨痛的地方在于，它们的贱鸡、贱畜牲的破烂题目出得【无限歧义】题目与示例案例分析，让写题目的人，永远读不懂说的是什么狗屁意思。。。。
        // public long minCost(String S, int[] a) {
        //     int n = a.length, cnt = 0; char [] s = S.toCharArray();
        //     int [] f = new int [26];
        //     for (char c : s) 
        //         f[c-'a']++;
        //     for (int v : f) 
        //         if (v > 0) cnt++;
        //     if (cnt == 1) return 0;
        //     Map<Integer, Long> m = new HashMap<>();
        //     long sum = 0;
        //     for (int v : a) {
        //         sum += (long)v;
        //         m.put(v, (long)m.getOrDefault(v, 0l) + (long)v);
        //     }
        //     long maxSum = Collections.max(m.values());
        //     return Math.min(sum - maxSum, m.size() == 2 ? maxSum : Long.MAX_VALUE);
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minSwaps(int[] nums, int[] forbidden) {
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 这个破烂题目，最简单？??
//         // 【LCA 最近公共祖先】：亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，再次遇见（LCA 最近公共祖先）破烂题目。。。
//         // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，上次，【自悟】终于回想起这个【LCA 最近公共祖先】题型的边角料，可是仅只能写出一半，感觉细节有误，没能及时纠正自己。。
//         // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这次，能够把它写完、写完整、写正确了吗？？？？？
//         // 今天晚上的这组题目，被它们的贱鸡、贱畜牲们给出得恶心吧啦。。亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，今天晚上的这组题目
//         // 仅只觉得：最后这一题、相对、稍微有点儿思考价值，其它的题目太破烂。。。
//         // 亲爱的表哥的活宝妹，下个周再接着写
//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         public long interactionCosts(int n, int[][] egs, int[] a) {
//             g = new ArrayList [n]; this.a = a; o = 17;
//             Arrays.setAll(g, z -> new ArrayList<Integer>());
//             for (int [] e : egs) {
//                 int u = e[0], v = e[1];
//                 g[u].add(v);
//                 g[v].add(u);
//             }
//             m = new HashMap<>();
//             d = new int [n]; // 以【0 为根节点】有向图，各节点距离（根节点 0） r 距离——边数
//             f = new int [n][o];
//             for (int i = 0; i < n; i++)
//                 Arrays.fill(f[i], -1);
// // 数据预处理：每个节点的、多少阶祖先，数据
//             dfs(0, -1, 0);
//             long ans = 0;
//             System.out.println(Arrays.toString(d));
//             for (List<Integer> li : m.values()) {
//                 if (li.size() == 1) continue;
//                 for (int i = 0; i < li.size()-1; i++) {
//                     for (int j = i+1; j < li.size(); j++) {
//                         int u = li.get(i), v = li.get(j);
//                         int p = lca(u, v);
//                         ans += d[u] + d[v] - d[p] * (p == u || p == v ? 2 : 1);
//                         // System.out.println("d[u] + d[v] - d[lca(u, v)]: " + (d[u] + d[v] - d[lca(u, v)]));
//                         // System.out.println(" // <<<<<<<<<<<<<<<<<<<<  u: " + u + " " + "v: " + v + " ans: " + ans);
//                     }
//                 }
//             }
//             return ans;
//         }
//         List<Integer> [] g;
//         Map<Integer, List<Integer>> m;
//         int n, o, k; int [] a, d;
//         int [][] f; // 【LCA 最近公共祖先】
//         // 求：两个不同节点【u,v】的（LCA 最近公共祖先）
//         int lca(int u, int v) {
//             // d[u] >= d[v]
//             if (d[u] < d[v]) {
//                 int tmp = u;
//                 u = v;
//                 v = tmp;
//             }
//             // System.out.println("d[u]: " + d[u] + " " + "d[v]: " + d[v]);
//             if (d[u] != d[v]) {
//                 k = o-1;
//                 // 【多阶跳】：跳到，最接近 d[v] 的、 >=d[v] 的祖先层级
//                 while (f[u][k] < 0 || d[f[u][k]] < d[v]) --k;
//             }
//             u = f[u][k];
//             // 【TODO：】这里可能想得不透彻，这个部分，不必要
//             // 【1 阶1 阶地跳】：直到 d[u] == d[v]
//             // System.out.println("0 u: " + u + " " + "v: " + v);
//             while (d[u] > d[v]) 
//                 u = f[u][0];
//             // System.out.println("1 u: " + u + " " + "v: " + v);
//              // d[u] == d[v]
//             // System.out.println("d[u]: " + d[u] + " " + "d[v]: " + d[v]);
//             while (u != v) {
//                 u = f[u][0];
//                 v = f[v][0];
//                 // System.out.println("u: " + u + " " + "v: " + v);
//             }
//             return u;
//         }
//         void dfs(int u, int p, int h) {
//             // m.computeIfAbsent(a[u], z -> new HashSet<Integer>()).add(u);
//             m.computeIfAbsent(a[u], z -> new ArrayList<Integer>()).add(u);
//             f[u][0] = p; // 每个节点的：【第2^0=1 个祖先】
//             d[u] = h;
//             if (p != -1) {
//                 k = 1;
//                 while (k < o && f[p][k-1] >= 0) k++;
//             } // 不包含 j 
//             for (int v : g[u]) {
//                 if (v == p) continue;
//                 if (p != -1)
//                     for (int j = 1; j < k; j++) 
//                         f[u][j] = f[f[u][j-1]][j-1];
//                 dfs(v, u, h + 1);
//             }
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long maximumScore(int[] a) {
        //     int n = a.length;
        //     long [] f = new long [n+1];
        //     for (int i = 0; i < n; i++) 
        //         f[i+1] = f[i] + (long)a[i];       // Pre
        //     int [] ff = new int [n+1];
        //     ff[n] = Integer.MAX_VALUE;
        //     for (int i = n-1; i >= 0; i--) 
        //         ff[i] = Math.min(ff[i+1], a[i]);
        //     long r = Long.MIN_VALUE;
        //     for (int i = 0; i < n; i++) 
        //         r = Math.max(r, f[i+1] - (long)ff[i+1]);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minimumCost(int a, int b, int ab, int x, int y) {
        //     if (a > b) {
        //         int [] cur = swap(a, b);
        //         a = cur[0]; b = cur[1];
        //         cur = swap(x, y);
        //         x = cur[0]; y = cur[1];
        //     }
        //     if (ab <= a) {
        //         return (long)ab * Math.max(x, y);
        //     } else if (a < ab && ab <= a + b) {
        //         return (long)ab * Math.min(x, y) + (x >= y ? (long)a * (x - y) : (long)Math.min(ab, b) * (y - x));
        //     } else {
        //         return (long)a * x + (long)b * y;
        //     }
        // }
        // int [] swap(int x, int y) { // x <= y
        //     return new int [] {y, x};
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，这里 Arrays.binarySearch() 返回值，上次写后，还是没能弄得狠清楚，没记进记忆里。。。
        // public int minAllOneMultiple(int k) {
        //     if (k % 2 == 0) return -1;
        //     int n = 9;
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++) {
        //         f[i] = (int)Math.pow(10, i);
        //         if (i > 0)
        //             f[i] += f[i-1];
        //     }
        //     System.out.println(Arrays.toString(f));
        //     // 【TODO：】感觉，亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这里搜索的值，直接用 k 不太对，需要某种优化。。。晚点儿再写这个
        //     int i = Arrays.binarySearch(f, k), j = 1;
        //     System.out.println("i: " + i);
        // if (i >= 0) return i+1;
        //     while (i >= -1 * n) {
        //         ++j;
        //         i = Arrays.binarySearch(f, k * j);
        //         if (i >= 0) return i+1;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉像是：【数位动规】；
        // // 亲爱的表哥的活宝妹、笨宝妹，还记得笨宝妹先前写过：【左右边界串、且非毒串】的，是（记忆化深搜）还是写的是动规来着？？？好像是【记忆化深搜】！！！
        // // 这里没有【毒串】，只数【左右边界串】范围内的、合法个数，所以应该、一定是（数位动规）！用来数左右边界内的合法个数，方法用：记忆化深搜！！！
        // // 【状态定义】：数位下标 i [0,16]; 是否（左串）；是否（右串）???
        // // 上面想错了。。。
        // // 更简单的【数位动规】的数法，是数 f(x)=【0,x】范围内的合法数，求结果用 f(hi)-f(lo-1); 就可以了
        // // 【状态定义】：数位下标 i [0,16]; 是否 match（当前位上的数值）
        // // 【记忆化深搜、记忆工具字典里的銉 key 的合法范围】（记忆化深搜：记忆工具字典里的銉 key 定义）：二进制 mask
        // // 遍布数位下标 i：【前 15 位，二进制的、高位】即 m.getKey() 的 2^[16,31], 15 位高位，表示当前遍历的下标【0,14】
        // // 当前遍历数的 j【所有数位、总和】：15*9=135 占用 8 个数位 [8,15]
        // // 当前遍历数的 k 【偶数位、总和】：8*9=72 占用 7 个数位 [1,7]
        // // 当前遍历数位，是否 match 边界数位 o: 占用 1 个数位 [0]
        // // 上面想错了。。。上面 f(x)=【0,x】范围内的合法数的、（记忆化深搜）的数位，与暴力解题，有什么区别？？？
        // // 【左右边界串，不带毒串】好歹算是某种优化，至少不用暴力数 2 遍？？？
        // // 【TODO：】【左右边界串，不带毒串】状态定义时，记忆工具字典里的銉 Integer 的 31 位数位不够用。。。那就用 Long 用 32 位来记忆呀。。。笨宝妹？！！！
        // // 所以，这里，笨宝妹，仍然先用 f(x)=【0,x】范围内的合法数的、（记忆化深搜）的数位，与暴力解题，有什么区别？？？这个思路来解题
        // public long countBalanced(long lo, long hi) {
        //     low = Math.max(low, 10l);
        //     long ans = (hi == (int)Math.pow(10, 15) ? 1 : 0);
        //     if (hi == (int)Math.pow(10, 15)) hi -= 1; // 用来帮助限制【记忆化深搜、记忆工具字典里的銉 key 的合法范围】
        //     // s = String.valueOf(low).toCharArray(); t = String.valueOf(high).toCharArray();
        //     // 这里把两个串倒一下，后面再写【程度会方便书写狠多】
        //     s = new StringBuilder(low).reverse().toString().toCharArray();
        //     t = new StringBuilder(hi).reverse().toString().toCharArray();
        //     // 【记忆化深搜、记忆工具字典里的銉 key 的合法范围】（记忆化深搜：记忆工具字典里的銉 key 定义）：二进制 mask
        //     // 遍布数位下标 i：【前 15 位，二进制的、高位】即 m.getKey() 的 2^[17,31], 15 位高位，表示当前遍历的下标【0,14】
        //     // 当前遍历数的 j【所有数位、总和】：15*9=135 占用 8 个数位 [9,16]
        //     // 当前遍历数的 k 【偶数位、总和】：8*9=72 占用 7 个数位 [2,8]
        //     // 当前遍历数位，是否 match 【左边界 lo】边界数位 o: 占用 1 个数位 [1]
        //     // 当前遍历数位，是否 match 【右边界 hi】边界数位 p: 占用 1 个数位 [0]
        //     m = s.length; n = t.length;
        //     f = new HashMap<>();
        //     int evenSum = 0, sum = 0;
        //     // for (int i = m-1; i > 0; i--) {
        //     for (int i = 0; i < m-1; i++) {
        //         sum += s[i] - '0';
        //         if (i % 2 == 0)
        //             evenSum += s[i] - '0';
        //     }
        //     // 现在是：【记忆化深搜】，想要从低位 m-1 遍历到高位 n-1
        //     // 【TODO：】可是感觉【记忆化深搜】与动规的遍历方向是反的，应该自高位 n-1 遍历深搜到低位 m-1 ？？？
        //     // return dfs(m-1, sum, evenSum, true, lo == hi);
        //     return dfs(n-1, 0, 0, true, lo == hi);
        // }
        // Map<Long, Long> f;
        // char [] s, t;
        // int m, n, evenSum, sum;
        // // 【记忆化深搜】：数【左右边界串】范围内，合法数的总个数，即不小于左边界，不大于右边界的、合法数的总个数
        // // 这里，【记忆化深搜】里，遍历的可能的2 个方面（自顶向下、与、自底向上），笨宝妹，正在与【动规】的遍历方向，弄混。。。
        // // 亲爱的表哥的活宝妹，前段时间——多久以前，还回忆自悟、写出来过【左右边界串】的记忆化深搜的方法
        // // 可是今天，当记忆工具字典需要占用32 位，笨宝妹最近几天状态不够不太好，感觉今天晚上，笨宝妹在细节上犯迷糊
        // // 亲爱的表哥的活宝妹，今天晚上不写了，改天脑袋相对清醒的时候，还是会、能够写得出来的！！！
        // //       i:idx  j:sum  k:evenSum il:matchLow ir:matchHi
        // long dfs(int i, int j, int k, boolean il, boolean ir) {
        //     Long key = ((17 << i) | (9 << j) | (2 << k) | (1 << (il ? 1 : 0)) | (ir ? 1 : 0));
        //     if (m.containsKey(key)) return m.get(key);
        //     // 当前数位下标 i 时，可以取值的合法范围 [l,r]
        //     // 【左边界】：除非（ il 不小于左边界），否则总是从 1 或是 0 开始; 【TODO：】这里 0 可能还需要特殊处理？！！！
        //     int l = (il && s[i]-'0' > 0 ? s[i]-'0' : (i == n-1 ? 1 : 0));
        //     // 【右边界】：除非（ ir 不大于右边界），否则总是可以数到 9
        //     int r = (ir && t[i]-'0' < 9 ? t[i]-'0' : 9);
        //     // 【终止条件】终止状况：
        //     if (i == m-1) {
        //     }
        //     long ans = 0;
        //     // 遍历：当前数位下标 i 时，所有【合法取值】
        //     for (int v = l; v <= r; v++) {
        //         ans += (i == m-1
        //                 ? (sum + v == (evenSum + (i % 2 == 0 ? v : 0)) * 2 ? 1 : 0)
        //                 // 【TODO：】亲爱的表哥的活宝妹，今天晚上这里，对2 个可能方向的数值的处理，脑袋里犯迷糊，感觉今天写不出来了，改天再写，还是会能够写得出来的！！
        //                 : dfs(i-1, 。。) 
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String reversePrefix(String s, int k) {
        //     return new StringBuilder((new StringBuilder(s.substring(0, k)).reverse().toString()).toString() + s.substring(k, s.length())).toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 题目假装狠简单，仅只4 分：可是【数据规模狠大，N(1,10^5)】并且子数组里数的是不重复数的和。。晚点儿再写这个
        // public int minLength(int[] a, int k) {
        //     int n = a.length;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【记忆化深搜】：感觉（思路无限清晰），可是就是感觉脑袋有点儿昏昏，细节上出各种错。。。先前笨宝妹从来不担心细节出错，永远第一时间纠正错误细节；现在感觉脑袋昏的时候一时半会儿还不一定纠正得了细节。。。
        // public int findMaxVal(int n, int[][] a, int[] b) {
        //     this.n = n; this.a = a; this.b = b; m = a.length;
        //     // a[][]: 应该是排序好了的；但是还是排序一下
        //     Arrays.sort(a, (x, y)->(x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]));
        //     f = new Integer [n][11];
        //     return dfs(0, b[0], 0);
        // }
        // int n, m; int [][] a; int [] b;
        // Integer [][] f;
        // int dfs(int i, int j, int x) {
        //     System.out.println("");
        //     System.out.println("i: " + i + " " + "j: " + j + " x: " + x);
        //    while (x < m && a[x][0] < i+1) x++;
        //     // if (i == n-1) { // j==11
        //     //     if (x < m && a[x][0] == i) return Math.min(a[x][1], b)
        //     //     return 0;
        //     // }
        //     if (j < 0 || x < m && a[x][0] == i+1 && a[x][1] < j) return -1;
        //     if (f[i][j] != null) return f[i][j];
        //     int r = -1, ff = 0, xx = x;
        //     boolean curr = (x < m && a[x][0] == i+1);
        //     // 遍历：当前下标 i 所有可能的有效取值
        //     // 【TODO：】不知道这里哪里细节写错了。。。。
        //     for (int k = (curr ? Math.min(j, a[x][0]) : j); k >= 0; k--) {
        //         xx = x;
        //         // 分情况【i == n-2】讨论结果：
        //         if (i == n-3) {
        //             if (x < m-1 && a[x+1][0] == i+2) {
        //                 ff = Math.max(k, Math.min(a[x+1][1], k + b[i]));
        //             } else
        //                 ff = Math.max(k, k + b[i]);
        //         } else {
        //             ff = dfs(i+1, k+b[i], xx);
        //             if (ff > -1)
        //                 ff = Math.max(k, ff);
        //         }
        //         r = Math.max(r, ff);
        //         System.out.println("k: " + k + " " + "ff: " + ff + " r: " + r);
        //     }
        //     return f[i][j] = r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String largestEven(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     if (s[n-1] == '2') return S;
        //     // if (n == 1) return "";
        //     for (int i = n-2; i >= 0; i--) {
        //         if (s[i] == '2')
        //             return new StringBuilder(S.substring(0, i+1)).toString();
        //     }
        //     return "";
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<List<String>> wordSquares(String[] a) {
        //     int n = a.length;
        //     Set<String> s = new HashSet<>();
        //     for (String si : a) s.add(si);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minMergeCost(int[][] a) {
        //     int m = a.length, n = 0;
        //     // 【TODO：】这个数据结构，能够保证【全局最小值、全局最优解】吗？
        //     Queue<List<Integer>> f = new PriorityQueue<>((x, y)-> (x.get(0) != y.get(0) ? x.get(0) - y.get(0) : x.get(1) - y.get(1)));
        //     for (int i = 0; i < m; i++) {
        //         List<Integer> l = new ArrayList<>(Arrays.asList(a[i]));
        //         n = a[i].length;
        //         l.add(0, n);
        //         l.add(1, a[n % 2 == 1 ? n/2 : n/2-1]);
        //         f.add(l);
        //     }
        // }

        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：亲爱的表哥的活宝妹，笨宝妹，好不容易把这个破烂题目的（动规）解法给写完整了，它居然超时了TLE TLE TLE 。。。。
        // // 亲爱的表哥的活宝妹，亲爱的表哥的活宝妹、笨宝妹，这里还差不步【前缀和优化】！！！有前缀和优化，就不会再超时TLE TLE TLE 了。。。。
        // // 亲爱的表哥的活宝妹，今天下午再也不想再写这个破烂题目了。。。傍晚晚上再接着写。。。
        // // 亲爱的表哥的活宝妹，感觉，最后2 个题目，思路都算清晰，可是脑袋线团。。。上一题目【记忆化深搜】怎么就把细节写错了呢？下午再接着折腾这些破烂题目。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int numberOfRoutes(String[] s, int d) {
        //     int m = s.length, n = s[0].length();
        //     int [][] a = new int [m][n];
        //     for (int i = 0; i < m; i++)
        //         for (int j = 0; j < n; j++)
        //             if (s[i].charAt(j) == '.') a[i][j] = 1;
        //     int [][][] f = new int [m][n][2];
        //     for (int i = m-1; i >= 0; i--) { // 这个破烂题目，【自上向下】与【自下向上】效果是等同的 
        //         for (int j = 0; j < n; j++) {
        //             if (a[i][j] == 0) continue;
        //             if (i == m-1) 
        //                 f[i][j][0] = 1;
        //             for (int k = 1; k * k <= d * d; k++) {
        //                 // 先：统计【向左、向右】方案数；再，统计（向上）方案数；顺序重要！要不然会少数
        //                 // 当且仅当：当前节点，是自下而上移动上来的，才可以，【向左、向右】移动一次！
        //                 if (f[i][j][0] > 0 && n > 1) {
        //                     // 【向左、向右】移动
        //                     if (j - k >= 0 && a[i][j-k] > 0)
        //                         f[i][j-k][1] = (f[i][j-k][1] + f[i][j][0]) % mod; 
        //                     if (j + k < n && a[i][j+k] > 0)
        //                         f[i][j+k][1] = (f[i][j+k][1] + f[i][j][0]) % mod;
        //                 }
        //             }
        //         }
        //         for (int j = 0; j < n; j++) {
        //             if (a[i][j] == 0) continue;
        //             // 【向上】移动: 不仅仅是【直上】，还可以是（斜上）！！
        //             if (i - 1 >= 0) {
        //                 // 【直上】
        //                 if (a[i-1][j] > 0)
        //                     f[i-1][j][0] = ((f[i-1][j][0] + f[i][j][0]) % mod + f[i][j][1]) % mod;
        //                 // 【斜上】: 向上移动 k 行，并（向左、向右）移动 x 列
        //                 if (n > 1) 
        //                     for (int x = 1; 1 + x * x <= d * d; x++) {
        //                         // 【向左、向右】移动 x 列
        //                         if (j - x >= 0 && a[i-1][j - x] > 0)
        //                             f[i-1][j-x][0] = ((f[i-1][j-x][0] + f[i][j][0]) % mod + f[i][j][1]) % mod;
        //                         if (j + x < n && a[i-1][j + x] > 0)
        //                             f[i-1][j+x][0] = ((f[i-1][j+x][0] + f[i][j][0]) % mod + f[i][j][1]) % mod;
        //                     }
        //             }
        //         }
        //     }
        //     int r = 0;
        //     for (int j = 0; j < n; j++)
        //         r = ((r + f[0][j][0]) % mod + f[0][j][1]) % mod;
        //     return r;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int numberOfRoutes(String [] S, int d) {
        //     int m = S.length, n = S[0].length();
        //     long [] sum = new long [n+1], sumF = new long [n+1]; // 【前缀和】数组：【TODO：】感觉搞不清楚，这2 个数组是怎么回事。。。
        //     long [] f = new long [n], g = new long [n];
        //     // 【自上向下】：遍历行
        //     for (int j = 0; j < m; j++) {
        //         // 每一行， sum 和 sumF 数据【自动擦新】，因为 sum[0]=sumF[0]=0; 【写错了：但是！】当 s[i][j]='#" 时还是会产生脏数据。。。所以不能合并 for 循环写法。。
        //         Arrays.fill(f, 0); Arrays.fill(g, 0); // <<<<<<<<<<<<<<<<<<<< 
        //         char [] s = S[j].toCharArray();
        //         // 【遍历列】
        //         for (int i = 0; i < n; i++) {
        //             if (s[i] == '#') continue;
        //             // 【自：上一行 i-1 行，下移】过来的方案数 f[i]
        //             if (j == 0)
        //                 f[i] = 1;
        //             else { // 可以自 j-1 行的【i-(d-1), i+(d-1)】列，下移过来
        //                 f[i] = sum[Math.min(i+d, n)] - sum[Math.max(0, i-d+1)]; // <<<<<<<<<<<<<<<<<<<< 
        //                 // sumF[i+1] = (sumF[i] + f[i]) % mod; // <<<<<<<<<<<<<<<<<<<< 【写错了：产生脏数据】！！！
        //             }
        //         }
        //         for (int i = 0; i < n; i++)
        //             sumF[i+1] = (sumF[i] + f[i]) % mod; // <<<<<<<<<<<<<<<<<<<< 【写错了：产生脏数据】！！！
        //         // 【自：同一行 i 行，左右移动】过来的方案数 g[i]
        //         for (int i = 0; i < n; i++) {
        //             if (s[i] == '#') continue;
        //             g[i] = sumF[Math.min(n, i+d+1)] - sumF[Math.max(0, i-d)] - f[i]; // 【这里写错】：不能（原地踏步）！ // <<<<<<<<<<<<<<<<<<<< 
        //             // sum[i+1] = (sum[i] + f[i] + g[i]) % mod; // <<<<<<<<<<<<<<<<<<<< 【写错了：产生脏数据】！！！
        //         }
        //         for (int i = 0; i < n; i++) 
        //             sum[i+1] = (sum[i] + f[i] + g[i]) % mod; // <<<<<<<<<<<<<<<<<<<< 【写错了：产生脏数据】！！！
        //     }
        //     return (int)((sum[n] + mod) % mod);
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int numberOfRoutes(String [] S, int d) {
        //     int m = S.length, n = S[0].length();
        //     long [] f = new long [n+1], g = new long [n+1]; // 【前缀和】数组：【TODO：】感觉搞不清楚，这2 个数组是怎么回事。。。
        //     // 【自上向下】：遍历行
        //     for (int j = 0; j < m; j++) {
        //         // 每一行， sum 和 sumF 数据【自动擦新】，因为 sum[0]=sumF[0]=0; 【写错了：但是！】当 s[i][j]='#" 时还是会产生脏数据。。。所以不能合并 for 循环写法。。
        //         char [] s = S[j].toCharArray();
        //         // 【遍历列】: 计算 sumf[] 及其前缀和
        //         for (int i = 0; i < n; i++) {
        //             if (s[i] == '#')
        //                 f[i+1] = f[i];
        //             // 【自：上一行 i-1 行，下移】过来的方案数 f[i]
        //             else if (j == 0)
        //                 f[i+1] = f[i] + 1l;
        //             else // 可以自 j-1 行的【i-(d-1), i+(d-1)】列，下移过来
        //                 f[i+1] = ((f[i] + g[Math.min(i+d, n)]) % mod + mod - g[Math.max(0, i-d+1)]) % mod; 
        //         }
        //         // 【自：同一行 i 行，左右移动】过来的方案数 g[i]
        //         // 计算 f[i]+g[i] 的前缀和 sum[]
        //         for (int i = 0; i < n; i++) {
        //             if (s[i] == '#')
        //                 g[i+1] = g[i];
        //             else
        //                 g[i+1] = ((g[i] + f[Math.min(n, i+d+1)]) % mod + mod - f[Math.max(0, i-d)]) % mod; 
        //         }
        //     }
        //     return (int)((g[n] + mod) % mod);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int residuePrefixes(String S) {
        //     int n = S.length(), f = 0;
        //     Set<Character> s = new HashSet<>();
        //     for (int i = 0; i < n; i++) {
        //         s.add(S.charAt(i));
        //         if (s.size() == (i+1) % 3)
        //             f++;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int centeredSubarrays(int[] a) {
        //     int n = a.length, r = 0;
        //     int [] f = new int [n+1];
        //     for (int i = 0; i < n; i++)
        //         f[i+1] = f[i] + a[i];
        //     System.out.println(Arrays.toString(f));
        //     Map<Integer, Integer> [] m = new HashMap[n];
        //     // Arrays.fill(m, new HashMap<>());
        //     // 【暴力解法】：
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0) {
        //             m[i] = new HashMap<>();
        //             m[i].put(a[i], 1);
        //             continue;
        //         }
        //         m[i] = new HashMap<>(m[i-1]);
        //         // m[i].putAll(m[i-1]); // <<<<<<<<<<<<<<<<<<<< evil google AI search....
        //         m[i].put(a[i], m[i].getOrDefault(a[i], 0)+1);
        //     }
        //     for (int i = 0; i < n; i++) 
        //         for (int j = 0; j <= i; j++) 
        //             if (m[i].containsKey(f[i+1] - f[j]) && m[i].get(f[i+1] - f[j]) - (j > 0 ? m[j-1].getOrDefault(f[i+1] - f[j], 0) : 0) > 0) 
        //                 r++;
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这些题目，都太简单
        // public long countPairs(String[] S) {
        //     int n = S.length, m = S[0].length();
        //     long r = 0;
        //     int [][] f = new int [n][m];
        //     TreeMap<int [], Integer> mi = new TreeMap<>((x, y)->Arrays.compare(x, y));
        //     for (int i = 0; i < n; i++) {
        //         char [] s = S[i].toCharArray();
        //         int [] g = new int [m]; 
        //         int d = 26 - (s[0] - 'a');
        //         for (int j = 1; j < m; j++) 
        //             g[j] = (s[j] -'a' + d) % 26;
        //         if (mi.containsKey(g)) 
        //             r += (long)mi.get(g);
        //         mi.put(g, mi.getOrDefault(g, 0) + 1);
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 按【32 位（0,31）、数位遍历】这个题目不太好想，先不写了，下周再写。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int maximumAND(int[] a, int k, int m) {
        //     if (m == 1) return Arrays.stream(a).max().getAsInt() + k; // 1 个元素
        //     int n = a.length;
        //     Arrays.sort(a); // ras: 可以 ras 倒序、降序排列
        // }
    }
// 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
        public static void main (String[] args) { 
		Solution s = new Solution ();

        String []  a = {"ab", "aa", "za", "aa"};
        System.out.println(Arrays.toString(a));

        long r = s.countPairs(a);
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
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
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
// 【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//  【爱表哥，爱生活！！！任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】