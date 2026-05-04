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
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] minDistinctFreqPair(int[] a) {
        //     int n = a.length, m = 101;
        //     int [] f = new int [m];
        //     for (int v : a)
        //         f[v]++;
        //     int [] r = new int [2];
        //     for (int i = 0; i < m; i++) {
        //         if (f[i] == 0) continue;
        //         for (int j = i+1; j < m; j++) {
        //             if (f[j] == 0 || f[j] == f[i]) continue;
        //             r[0] = i; r[1] = j;
        //             return r;
        //         }
        //     }
        //     Arrays.fill(r, -1);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数据规模小，直接暴力解法
        // public String mergeCharacters(String S, int k) {
        //     int n = S.length(), m = 26, o = 0; char [] s = S.toCharArray();
        //     int [] f = new int [m]; Arrays.fill(f, -1);
        //     StringBuilder sb = new StringBuilder();
        //     sb.append(s[0]);
        //     boolean merged = false;
        //     for (int i = 1; i < n; i++) {
        //         o = sb.length();
        //         merged = false;
        //         for (int j = Math.max(0, o-k); j < o; j++) 
        //             if (sb.charAt(j) == s[i]) {
        //                 merged = true;
        //                 break;
        //             }
        //         if (merged) continue;
        //         sb.append(s[i]);
        //     }
        //     return sb.toString();
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 今天早上的破烂题目，都出得极其恶心，恶心死人、恶心坏这个世界不偿命！！！它们的贱鸡、贱畜牲们，真贱！！！
        // public int[] makeParityAlternating(int[] a) {
        //     int n = a.length, min = Arrays.stream(a).min().getAsInt(), max = Arrays.stream(a).max().getAsInt();
        //     int r = 0, curMin = Integer.MAX_VALUE / 2, curMax = Integer.MIN_VALUE / 2;
        //     int [] f = new int [2]; 
        //     if (n == 1) return f;
        //     f[0] = n;
        //     if (n == 2 && a[0] == a[1]) {
        //         Arrays.fill(f, 1);
        //         return f;
        //     }
        //     boolean odd = false;
        //     // 遍历 2 遍
        //     // 第一遍：【不修改 0-index】的数值
        //     r = 0;
        //     odd = false;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0
        //             || odd && i % 2 != (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 == (a[i] % 2 + 2) % 2) {
        //             curMin = Math.min(curMin, a[i]);
        //             curMax = Math.max(curMax, a[i]);
        //             if (i == 0) odd = ((a[i] % 2 + 2) % 2 == 1 ? true : false);
        //             continue;
        //         }
        //         if (odd && i % 2 == (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 != ((a[i] % 2) + 2) % 2) {
        //             if (a[i] == min) {
        //                 curMin = Math.min(curMin, a[i] + 1);
        //                 curMax = Math.max(curMax, a[i]);
        //             } else if (a[i] == max) {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]-1);
        //             }
        //             r++;
        //         }
        //     }
        //     if (r < f[0]) {
        //         f[0] = r; f[1] = curMax - curMin;
        //     }
        //     // 第二遍：【修改 0-index】的数值
        //     r = 0;
        //     odd = false;
        //     curMin = Integer.MAX_VALUE / 2; curMax = Integer.MIN_VALUE / 2;
        //     for (int i = 0; i < n; i++) {
        //         if (i == 0
        //             || odd && i % 2 != (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 == (a[i] % 2 + 2) % 2) {
        //             if (i == 0) {
        //                 if (a[i] == min) {
        //                     curMin = Math.min(curMin, a[i] + 1);
        //                     curMax = Math.max(curMax, a[i]);
        //                 } else if (a[i] == max) {
        //                     curMin = Math.min(curMin, a[i]);
        //                     curMax = Math.max(curMax, a[i]-1);
        //                 }
        //                 odd = (((a[i] % 2) + 2) % 2 == 1 ? false : true);
        //                 r++;
        //                 continue;
        //             } else {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]);
        //             }
        //         }
        //         if (odd && i % 2 == (a[i] % 2 + 2) % 2
        //             || !odd && i % 2 != ((a[i] % 2) + 2) % 2) {
        //             if (a[i] == min) {
        //                 curMin = Math.min(curMin, a[i] + 1);
        //                 curMax = Math.max(curMax, a[i]);
        //             } else if (a[i] == max) {
        //                 curMin = Math.min(curMin, a[i]);
        //                 curMax = Math.max(curMax, a[i]-1);
        //             }
        //             r++;
        //         }
        //     }
        //     if (r < f[0] || r == f[0] && curMax - curMin < f[1]) {
        //         f[0] = r; f[1] = curMax - curMin;
        //     }
        //     if (n > 1 && min == max) f[1] = 1;
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 感觉，这个破烂题目，是【暴力数】个数，太不想写这类恶心死人、恶心坏这个世界不偿命！！！数个数的题目了。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int sumOfNumbers(int l, int r, int k) {
        //     return 0;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String trimTrailingVowels(String S) {
        //     Set<Character> s = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        //     int n = S.length(), i = n-1;
        //     while (i >= 0 && s.contains(S.charAt(i))) --i;
        //     return (i >= 0 ? S.substring(0, i+1) : "");
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minCost(int n) {
        //     if (n == 1) return 0;
        //     if (n == 2) return 1;
        //     int [] f = new int [n+1];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     f[1] = 1;
        //     f[2] = 1;
        //     f[3] = 3;
        //     for (int i = 4; i <= n; i++) 
        //         for (int j = 1; j <= i/2; j++) 
        //             f[i] = Math.min(f[i], j * (i-j) + (j > 1 ? f[j] : 0) + (i-j > 1 ? f[i-j] : 0));
        //     return f[n];
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 不知道这个题目怎么去想，亲爱的表哥的活宝妹，写不到后面的两个破烂题目了，不想再写了。。。下个周六再写
        // public int minimumOR(int[][] a) {
        //     int m = a.length, n = a[0].length, f = 0;
        //     for (int i = 0; i < m; i++)
        //         Arrays.sort(a[i]);
        //     for (int i = 0; i < m; i++)
        //         f |= a[i][0];
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minimumIndex(int[] a, int v) {
        //     int n = a.length;
        //     int min = 1027, j = -1;
        //     for (int i = 0; i < n; i++)
        //         if (a[i] >= v) 
        //             if (a[i] < min) {
        //                 min = a[i];
        //                 j = i;
        //             }
        //     return j;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int smallestBalancedIndex(int[] a) {
        //     int n = a.length;
        //     if (n == 1) return -1;
        //     long [] f = new long [n+1], g = new long [n+1];
        //     for (int i = 1; i <= n; i++)
        //         f[i] = f[i-1] + (long)a[i-1];
        //     g[n] = 1;
        //     for (int i = n-1; i >= 0; i--)
        //         g[i] = g[i+1] * (long)a[i];
        //     for (int i = 1; i <= n; i++)
        //         if (f[i] == (i == n ? 1 : g[i+1])) return i;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【TODO：】思路不对；最贪心的算法，却没能保障（答案正确）。。。
        // public int minOperations(String S) {
        //     n = S.length(); 
        //     s = S.toCharArray(); t = S.toCharArray();
        //     Arrays.sort(t);
        //     System.out.println(Arrays.toString(s));
        //     System.out.println(Arrays.toString(t));
        //     m = new HashMap<>();
        //     int i = 0, j = 0, r = 0;
        //     for (i = 0, j = 0; i < n; i++) {
        //         System.out.println("\n i: " + i);
        //         if (s[i] == t[i]) continue;
        //         if (i < n-1 && s[i+1] == t[i] && t[i+1] == s[i]) {
        //             r++;
        //             i++;
        //             continue;
        //         }
        //         m.put(s[i], m.getOrDefault(s[i], 0)+1);
        //         m.put(t[i], m.getOrDefault(t[i], 0)-1);
        //         j = i+1;
        //         m.put(s[j], m.getOrDefault(s[j], 0)+1);
        //         m.put(t[j], m.getOrDefault(t[j], 0)-1);
        //         System.out.println("i: " + i + " " + "j: " + j);
        //         while (j < n && m.values().stream().distinct().count() > 1) {
        //             j++;
        //             if (j == n) break;
        //             m.put(s[j], m.getOrDefault(s[j], 0)+1);
        //             m.put(t[j], m.getOrDefault(t[j], 0)-1);
        //         }
        //         System.out.println("j: " + j);
        //         if (j == n) break;
        //         // if (i > 0 &&  m.values().stream().distinct().count() == 1) {
        //         if (m.values().stream().distinct().count() == 1) {
        //             r++;
        //             System.out.println("j: " + j + " " + "r: " + r);
        //             if (j == n-1) return (i > 0 ? r : -1);
        //             m.clear();
        //             i = j;
        //         }
        //     }
        //     System.out.println("i: " + i + " " + "j: " + j + " " + "r: " + r);
        //    if (i != 0 && j == n && m.values().stream().distinct().count() == 1) return r+1;
        //    if (i > 0 && n > 2) return r;
        //    return -1;
        // }
        // Map<Character, Integer> m;
        // char [] s, t;
        // int n;

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // TLE TLE TLE 885/1009-passed..
        // // 亲爱的表哥的活宝妹，今天不想再写这组题目了，下个周六再写。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long minCost(String S, int y, int x) {
        //     n = S.length(); this.x = x; this.y = y;
        //     s = S.toCharArray();
        //     // 【前缀和】
        //     f = new int [n+1]; ff = new int [n+1]; 
        //     for (int i = 0; i < n; i++) 
        //         f[i+1] = f[i] + s[i]-'0';
        //     // 数【最小：片段】前缀和个数
        //     ff[1] = 1;
        //     for (int i = 1; i < n; i++) 
        //         if (s[i] != s[i-1])
        //             ff[i+1] = ff[i] + 1;
        //     // 区间型动规：【记忆字典】
        //     m = new HashMap<>();
        //     return dfs(0, n-1);
        // }
        // Map<String, Long> m;
        // int [] f, ff; char [] s;
        // int n, x, y;
        // long dfs(int i, int j) {
        //     if (i > j) return 0l;
        //     String key = i + "-" + j;
        //     if (m.containsKey(key)) return m.get(key);
        //     long r = Long.MAX_VALUE / 2;
        //     if (i == j || f[j+1]-f[i] == 0l) {
        //         if (i == j)
        //             r = (long)(s[i] == '1' ? y : x);
        //         else r = x;
        //         m.put(key, r);
        //         return r;
        //     }
        //     // 【1 整条片段】的代价
        //     r = Math.min(r, (f[j+1]-f[i] > 0 ? (long)(j-i+1) * (f[j+1]-f[i]) * y : x));
        //    System.out.println("r: " + r);
        //    // 2 个【半条片段】的、代价和, 只在，整条片段代价过大时，使用
        //    // if ((j-i+1) % 2 == 0 && r > (long)(j-i+1-(f[j+1]-f[i])) * x) { // 思路不透彻，这么不能保障【正确答案】
        //    if ((j-i+1) % 2 == 0) {
        //         r = Math.min(r, dfs(i, i + (j+1-i)/2 -1) + dfs(i+(j-i+1)/2, j));
        //         System.out.println("r: " + r);
        //     }
        //     m.put(key, r); 
        //     return r; 
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int firstUniqueEven(int[] a) {
        //     int n = a.length, m = 101;
        //     int [] f = new int [m];
        //     for (int v : a) f[v]++;
        //     for (int i = 0; i < n; i++) 
        //         if (f[a[i]] == 1 && a[i] % 2 == 0)
        //             return a[i];
        //     return -1;
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long gcdSum(int[] a) {
        //     int n = a.length, f = 0;
        //     for (int i = 0; i < n; i++) 
        //         if (i == 0) {
        //             f = a[i];
        //             continue;
        //         } else {
        //             f = Math.max(f, a[i]);
        //             a[i] = gcd(a[i], f);
        //         }
        //     Arrays.sort(a);
        //     int i = 0, j = n-1;
        //     long r = 0l;
        //     while (i < j) 
        //         r += (long)gcd(a[i++], a[j--]);
        //     return r;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 破烂题目，被烦死了。。
        // public int minCost(int[] f, int[] g) {
        //     int o = f.length, p = 8 * (int)Math.pow(10, 4) + 1;
        //     Map<Integer, Integer> m = new HashMap<>(), n = new HashMap<>();
        //     for (int i = 0; i < o; i++) {
        //         m.put(f[i], m.getOrDefault(f[i], 0) + 1);
        //         n.put(f[i], n.getOrDefault(f[i], 0) + 1);
        //         n.put(g[i], n.getOrDefault(g[i], 0) + 1);
        //     }
        //     for (int v : n.values()) 
        //         if (v % 2 == 1) return -1;
        //     Map<Integer, List<Integer>> mi = new HashMap<>();
        //     for (int i = 0; i < o; i++)
        //         mi.computeIfAbsent(f[i], z -> new ArrayList<>()).add(i);
        //     int r = 0;
        //     for (int i = 0; i < o; i++) {
        //         if (!mi.containsKey(f[i]) || mi.get(f[i]).size() == 0) return -1;
        //         mi.get(f[i]).remove(0);
        //         if (f[i] == g[i]) continue;
        //         if (!mi.containsKey(g[i]) || mi.get(g[i]).size() == 0) {
        //             r ++;
        //             // 两数组间互换 1 次
        //             int v = g[i];
        //             g[i] = f[i];
        //             f[i] = v;
        //             if (mi.get(g[i]).size() == 0) return -1;
        //             int idx = mi.get(g[i]).get(0);
        //             mi.get(g[i]).remove(0); // 这个数，用来匹配，换到 g[i] 上的，当前下标 i 数值
        //             mi.computeIfAbsent(f[i], z -> new ArrayList<>()).add(idx);
        //             f[idx] = f[i];
        //             f[i] = g[i]; // 这个，遍历之后的的【数组前片段】：可以不用再修改
        //         } else { // 数组后面，有当前数 g[i]
        //             int idx = mi.get(g[i]).get(0);
        //             mi.get(g[i]).remove(0);
        //             // 【有序链条】：二分查找，有序插入到固定位置
        //             int j = Collections.binarySearch(mi.get(f[i]), idx);
        //             if (j >= 0)
        //                 mi.get(f[i]).add(j, idx);
        //             else
        //                 mi.get(f[i]).add(-1 * (j+1), idx);
        //             f[idx] = f[i];
        //             f[i] = g[i];
        //         }
        //     }
        //     return r;
        // }
        // void swap(int i, int j, int [] a) {
        //     int v = a[i];
        //     a[i] = a[j];
        //     a[j] = v;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，今天再不想写这个破烂题目了，傍晚晚上再接着写。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minCost(int[] f, int[] g) {
        //     int r = 0, n = f.length;
        //     int m = Math.min(Math.max(Arrays.stream(f).max().getAsInt(), Arrays.stream(g).max().getAsInt())+1, 8 * (int)Math.pow(10, 4) + 1);
        //     int [] a = new int [m];
        //     for (int v : f) a[v]++;
        //     for (int v : g) a[v]--;
        //     Set<Integer> s = new HashSet<>(Arrays.stream(f).boxed().collect(Collectors.toList()));
        //     Set<Integer> t = new HashSet<>(Arrays.stream(g).boxed().collect(Collectors.toList()));
        //     Queue<Integer> p = new PriorityQueue<>(), q = new PriorityQueue<>();
        //     for (int i = 0; i < m; i++)
        //         if (a[i] > 0)
        //             for (int j = 0; j < a[i]; j++) 
        //                 p.add(i);
        //     for (int i = 0; i < m; i++)
        //         if (a[i] < 0)
        //             for (int j = 0; j < -1*a[i]; j++) 
        //                 q.add(i);
        //     boolean swaped = false;
        //     while (!p.isEmpty() && !q.isEmpty()) {
        //         if (p.peek() == q.peek()) {
        //             p.poll(); q.poll();
        //             if (swaped) swaped = false;
        //         } else if (!swaped) {
        //             int x = p.peek(); p.poll();
        //             int y = q.peek(); q.poll();
        //             p.add(y); q.add(x);
        //             r++;
        //             swaped = true;
        //         } else return -1;
        //     }
        //     if (p.isEmpty() && q.isEmpty()) return r;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countCommas(int n) {
        //     if (n < 1000) return 0;
        //     return (n - 1000 + 1);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 破烂题目。。。
        // public long countCommas(long n) {
        //     if (n < 1000l) return 0l;
        //     if (n == 1000l) return 1;
        //     if (n < 1000000l) return (n - 1000 + 1) * 1l;
        //     if (n < 1000000000l) return 2 * (n - 1000000l + 1) + 999000l;
        //     if (n < 1000000000000l) return 3 * (n - 1000000000l + 1) + 999000000l * 2 + 999000l;
        //     if (n == 1000000000000000l) return 5 + 4 * 999000000000000l+ 999000000000l * 3 + 999000000l * 2 + 999000l;
        //     return 4 * (n - 1000000000000l + 1) +  999000000000l * 3 + 999000000l * 2 + 999000l;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int longestArithmetic(int[] a) {
        //     int n = a.length, j = 0, k = 0, max = 3;
        //     if (Arrays.stream(a).distinct().count() == 1) return n;
        //     int [] f = new int [n], g = new int [n];
        //     boolean mod = false;
        //     for (int i = 2; i < n; i++) {
        //         int d = a[i-1] - a[i-2];
        //         mod = false;
        //         if (a[i] - a[i-1] == d) 
        //             j = i + 1;
        //         else j = i;
        //         while (j < n && (a[j] - a[j-1] == d || !mod && (j < n-1 && a[j+1] - a[j-1] == 2 * d || j == n-1))) {
        //             if (a[j] - a[j-1] != d) {
        //                 mod = true;
        //                 k = j;
        //                 if (j < n-1)
        //                     ++j;
        //             }
        //             j++;
        //         }
        //         max = Math.max(max, j - i+2);
        //         if (!mod && max < n) max = Math.max(max, j - i+ 2+1);
        //         if (mod) i = k;
        //         else i = j;
        //     }
        //     for (int i = n-3; i >= 0; i--) {
        //         int d = a[i+1] - a[i+2];
        //         mod = false;
        //         if (a[i] - a[i+1] == d) 
        //             j = i - 1;
        //         else j = i;
        //         while (j >= 0 && (a[j] - a[j+1] == d || !mod && (j > 0 && a[j-1] - a[j+1] == 2 * d || j == 0))) {
        //             if (a[j] - a[j+1] != d) {
        //                 mod = true;
        //                 k = j;
        //                 if (j > 0)
        //                     --j;
        //             }
        //             j--;
        //         }
        //         max = Math.max(max, i+2 - j);
        //         if (!mod && max < n) max = Math.max(max,i+2-j+1);
        //         if (mod) i = k;
        //         else i = j;
        //     }
        //     return max;
        // }

//         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
//         // 亲爱的表哥的活宝妹，感觉，亲爱的表哥的活宝妹的这个思路不太对。。
        // 亲爱的表哥的活宝妹，今天晚上不要再写这些恶心死人、恶心坏这个世界不偿命！！的破烂题目了。。
//         public int maxActivated(int[][] a) {
//             int n = a.length;
//             Arrays.sort(a, (x, y)->x[0] != y[0] ? x[0] - y[0] : x[1] - y[1]);
//             TreeMap<Integer, Integer> mx = new TreeMap<>(), my = new TreeMap<>();
//             for (int[] f : a) {
//                 int i = f[0], j = f[1];
//                 mx.put(i, mx.getOrDefault(i, 0) + 1);
//             }
//             Map<Integer, Integer> m = MapUtil.sortByValue(mx, true);
//             Arrays.sort(a, (x, y)->x[1] != y[1] ? x[1] - y[1] : x[0] - y[0]);
//             for (int[] f : a) {
//                 int i = f[0], j = f[1];
//                 my.put(j, my.getOrDefault(j, 0) + 1);
//             }
//             Map<Integer, Integer> mm = MapUtil.sortByValue(my, true);
//         }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean uniformArray(int[] a) {
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，晚点儿再写这个破烂题目
        // public boolean uniformArray(int[] a) {
        //     int n = a.length;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {i, a[i]});
        //     Collections.sort(l, (x, y) -> x[1] - y[1]);
        //     boolean odd = (l.get(0)[1] % 2 == 1), valid = false;
        //     for (int i = 1; i < n; i++) {
        //         if (odd && l.get(i)[1] % 2 == 1
        //             || !odd && l.get(i)[1] % 2 == 0) continue;
        //         valid = false;
        //         for (int j = 0; j < i; j++) 
        //             if (l.get(i)[1] - l.get(j)[1] >= 1 && (l.get(i)[1] - l.get(j)[1]) % 2 == (odd ? 1 : 0)) {
        //                 valid = true;
        //                 break;
        //             }
        //         if (valid) continue;
        //         return false;
        //     }
        //     return true; 
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minRemovals(int[] a, int target) {
        //     // int f = (int)Math.pow(2, 14); // [1, 10,000] 2 进制，不到 14 个数位
        //     // 这个破烂题目：八九不离十，一定与数位操作（遍历 target 最多可能的 14 个数位，及其所有可能的（数位子集集合）相关）
        //     // 亲爱的表哥的活宝妹，今天晚上不要再写这些恶心死人的偿命的破烂题目了
        //     // 亲爱的表哥的活宝妹，下个周六再接着写
        //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得今天晚上这个破烂题目最简单：
        // // 对于（重复数字 i>0 && a[i]==a[i-1]）的处理，像是处理对了
        // // 【TODO：】对于（最小子数组）中存在【有间隔的重复数字】如下例（7,5,7）。。亲爱的表哥的活宝妹，感觉今天晚上精力脑力不够，想不出来了。。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countGoodSubarrays(int[] a) { // 755/790 passed 
        //     int n = a.length, j = 0;
        //     // 以【当前下标 i】为子数组（最大值）：分别，向左、向右，可以延伸的最远下标
        //     // int [] f = new int [n+1], g = new int [n+1];
        //     int [] f = new int [n], g = new int [n];
        //     Arrays.fill(f, -1); Arrays.fill(g, n);
        //     // 【自左向右】遍历：
        //     f[0] = 0;
        //     for (int i = 1; i < n; i++) {
        //         f[i] = i;
        //         j = i-1;
        //         while (j >= 0 && a[i] >= a[j] && (a[i] | a[j]) == a[i]) {
        //             f[i] = f[j];
        //             j = f[i]-1;
        //         }
        //     }
        //     g[n-1] = n-1;
        //     for (int i = n-2; i >= 0; i--) {
        //         g[i] = i;
        //         j = i+1;
        //         while (j < n && a[i] >= a[j] && (a[i] | a[j]) == a[i]) {
        //             g[i] = g[j];
        //             j = g[j]+1;
        //         }
        //     }
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(g));
        //   long r = 0;
        //     for (int i = 0; i < n; i++) {
        //         if (f[i] < i || g[i] > i) {
        //             r += (long)(i - f[i] + 1) * (g[i] - i + 1);
        //         } else 
        //             r++;
        //         if (i > 0 && a[i] == a[i-1])
        //             r -= (long)(g[i] - i + 1) * (i - f[i]);
        //     }
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minAbsoluteDifference(int[] a) {
        //     int n = a.length, f = Integer.MAX_VALUE;
        //     List<Integer> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         if (a[i] == 2) l.add(i);
        //     for (int i = 0; i < n; i++) {
        //         if (a[i] != 1) continue;
        //         for (int j : l) 
        //             f = Math.min(f, Math.abs(i - j));
        //     }
        //     return (f == Integer.MAX_VALUE ? -1 : f);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，这个题目，感觉：整体思路是对的，但是细节哪里没能写对，晚点儿再写这个破烂题目
        // // 亲爱的表哥的活宝妹，昨天晚上休息不足 3.5 小时，一早上读不懂：在 idx 位置的人，L/R 什么时候 count, 什么时候不能 count 。。
        // static final int mod = (int)1e9 + 7;
        // public int countVisiblePeople(int n, int idx, int k) {
        //     long f = 0, v = 0;
        //     if (idx == 0 || idx == n-1) 
        //         f = (f + combination(n-1, k)) % mod;
        //     else {
        //         if (idx >= k) {
        //             // 在 idx 位置的人：可以有 L/R 2 种可能的选择
        //             v = combination(idx, k);
        //             f = (f + v + v) % mod;
        //         }
        //         if (idx < n-k) {
        //             v = combination(n-1-idx, k);
        //             f = (f + v + v) % mod;
        //         }
        //         int maxR = Math.min(n-1-idx, k-1), minL = k - maxR, maxL = Math.min(idx, k-1);
        //         // int maxR = Math.min(n-1-idx, k), minL = k - maxR, maxL = Math.min(idx, k);
        //         for (int i = minL; i <= maxL; i++) {
        //             v = combination(idx, i);
        //             f = (f + v + v) % mod;
        //         }
        //     }
        //     return (int)f;
        // }
        // public static long factorial(int n) {
        //     if (n == 0) return 1;
        //     long fact = 1;
        //     for (int i = 1; i <= n; i++) fact *= i;
        //     return fact;
        // }
        // public static long combination(int n, int r) {
        //     return factorial(n) / (factorial(r) * factorial(n - r));
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int countArrays(int[] a) {
        //     int n = a.length;
        //     if (Arrays.stream(a).max().getAsInt() > 40) return 0;
        //     List<Integer> [] g = new ArrayList[n];
        //     Arrays.setAll(l, z -> new ArrayList<Integer>());
        //     l = new ArrayList<>();
        //     for (int i = 0; i < n; i++) {
        //         l.clear();
        //         // g[i] = 
        //     }
        // }
        // List<Integer> getValidCandidates(int v) {
        //     List<Integer> f = new ArrayList<>();
        //     if (v == 0) {
        //         f.add(0);
        //         return ;
        //     }
        //     if (v == 40) {
        //         f.add(49999);
        //         return ;
        //     }
        //     return ;
        // }
        // List<Integer> l = new ArrayList<>();
        // // 【TODO：】需要一个 recursion 方法，来生成针对特定 v 的每一个 candidate 值，加进 global=l 链条里

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，觉得：这是世界上、最基础、最简章的（动规）;
        // // 可是，亲爱的表哥的活宝妹，早上不知道哪里写错了、下午或是傍晚再写
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int minCost(int[][] a) {
        //     int m = a.length, n = a[0].length;
        //     int [][] f = new int [m+1][n+1];
        //     for (int i = 0; i <= m; i++)
        //         Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        //     f[0][0] = f[0][1] = f[1][0] = 0;
        //     for (int i = 1; i <= m; i++) 
        //         for (int j = 1; j <= n; j++) {
        //             if (i == 1 && j == 1) {
        //                 f[i][j] = a[i-1][j-1];
        //                 continue;
        //             }
        //             f[i][j] = Math.min(f[i-1][j] ^ a[i-1][j-1], f[i][j-1] ^ a[i-1][j-1]);
        //         }
        //     return f[m][n];
        // }
        // int [][] a = new int [][] {{26,24,3},{2,22,17}};// 16==>5 
        // System.out.println("a.length: " + a.length);
        // for (int z = 0; z < a.length; ++z)
        //     System.out.println(Arrays.toString(a[z]));

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int firstMatchingIndex(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     for (int i = 0; i < n/2; i++) 
        //         if (s[i] == s[n-1-i])
        //             return i;
        //     if (n % 2 == 1) return n/2;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // class EventManager {
        // // class cmp {
        //     Map<Integer, Integer> m;
        //     Queue<int []> q;
        //     // public cmp(int[][] events) {
        //     public EventManager(int[][] events) {
        //         m = new HashMap<>();
        //         for (int [] e : events) 
        //             m.put(e[0], e[1]);
        //         q = new PriorityQueue<>((x, y) -> (x[1] != y[1] ? y[1] - x[1] : x[0] - y[0]));
        //         for (int [] e : events) 
        //             q.offer(new int [] {e[0], e[1]});
        //     }
        //     public void updatePriority(int eventId, int newPriority) {
        //         if (m.containsKey(eventId)) {
        //             m.put(eventId, newPriority);
        //             q.offer(new int [] {eventId, newPriority});
        //         }
        //     }
        //     public int pollHighest() {
        //         if (m.size() == 0) return -1;
        //         int [] f = new int [] {-1, -1};
        //         while (!q.isEmpty()) {
        //             f = q.poll();
        //             while ((!m.containsKey(f[0]) || m.get(f[0]) != f[1]) && !q.isEmpty()) 
        //                 f = q.poll();
        //             if (!m.containsKey(f[0]) || m.get(f[0]) != f[1]) return -1;
        //             // if (q.isEmpty()) return -1;
        //             m.remove(f[0]);
        //             System.out.println(Arrays.toString(f));
        //             break;
        //         }
        //         return f[0];
        //     }
        // }
            
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，不想再写这个破烂题目了。。
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int sortableIntegers(int[] a) {
        //     int n = a.length, r = 0;
        //     if (isDecending(a) && n >= 3) return 0;
        //     if (n == 1) return 1;
        //     if (n == 2) return 2 + (isNonDecending(a) ? 1 : 0);
        //     for (int i = 1; i <= n; i++) {
        //         if (i == 1) {
        //             if (isNonDecending(a))
        //                 r += i;
        //             continue;
        //         }
        //         if (n % i > 0) continue;
        //         if (i == n) {
        //             if (rotateAchievable(a, 0, n-1))
        //                 r += i;
        //             continue;
        //         }
        //         boolean possible = true;
        //         for (int j = 0; j < n-i; j += i) 
        //             if (!rotateAchievable(a, j, j+i-1)) {
        //                 possible = false;
        //                 break;
        //             }
        //         if (possible) 
        //             r += i;
        //     }
        //     return r;
        // }
        // boolean rotateAchievable(int [] f, int l, int r) {
        //     int n = f.length, min = f[l], idx = l, max = f[l], midx = l;
        //     for (int i = l+1; i <= r; i++) {
        //         if (f[i] < min) {
        //             min = f[i];
        //             idx = i;
        //         } else if (f[i] > max) {
        //             max = f[i];
        //             midx = i;
        //         }
        //     }
        //     boolean valid = true; // 【大大、小、大大】
        //     for (int i = idx+1; i <= r; i++)
        //         if (f[i] < f[i-1]) {
        //             valid = false;
        //             break;
        //         }
        //     if (valid)
        //         for (int i = idx-1; i >= l; i--) 
        //             if (f[i] < f[i+1]) {
        //                 valid = false;
        //                 break;
        //             }
        //     if (valid) return true;
        //     valid = true; // 【小小、大、小小】
        //     for (int i = midx+1; i <= r; i++)
        //         if (f[i] > f[i-1]) {
        //             valid = false;
        //             break;
        //         }
        //     if (valid)
        //         for (int i = midx-1; i >= l; i--) 
        //             if (f[i] > f[i+1]) {
        //                 valid = false;
        //                 break;
        //             }
        //     return valid;
        // }
        // boolean isDecending(int [] f) {
        //     int n = f.length;
        //     for (int i = 1; i < n; i++)
        //         if (f[i] >= f[i-1]) return false;
        //     return true;
        // }
        // boolean isNonDecending(int [] f) {
        //     int n = f.length;
        //     for (int i = 1; i < n; i++)
   //         if (f[i] < f[i-1]) return false;
        //     return true;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】  
        // // 亲爱的表哥的活宝妹，觉得；今天晚上的、最近一段时间的 leetcode 它们的贱鸡、贱畜牲们，出的破烂题目，都好恶心，恶心死人、恶心坏这个世界不偿命！！！它们的贱鸡、贱畜牲们真贱！！◎
        // public long minIncrease(int[] a) {
        //     int n = a.length;
        //     if (n == 3)
        //         return (a[1] > a[0] && a[1] > a[2] ? 0 : Math.max(a[0], a[2]) - a[1] + 1);
        //     long ans = 0, ff = 0, r = 0;
        //     if (n % 2 == 1) {
        //         for (int i = 1; i < n-1; i += 2) {
        //             if (a[i] > a[i-1] && a[i] > a[i+1]) continue;
        //             ans += (long)(Math.max(a[i-1], a[i+1]) - a[i]+1);
        //         }
        //         return ans;
        //     }
        //     long [] f = new long [n], g = new long [n];
        //     for (int i = 1; i < n-1; i += 2) {
        //         if (a[i] > a[i-1] && a[i] > a[i+1]) {
        //             f[i] = (i == 1 ? 0 : f[i-2]);
        //             continue;
        //         }
        //         f[i] = (long)(Math.max(a[i-1], a[i+1]) - a[i]+1) + (i == 1 ? 0 : f[i-2]);
        //     }
        //     for (int i = n-2; i > 0; i -= 2) {
        //         if (a[i] > a[i-1] && a[i] > a[i+1]) {
        //             g[i] = (i == n-2 ? 0 : g[i+2]);
        //             continue;
        //         }
        //         g[i] = (long)(Math.max(a[i-1], a[i+1]) - a[i]+1) + (i == n-2 ? 0 : g[i+2]);
        //     }
        //     r = Math.min(f[n-3], g[2]);
        //     if (n >= 6)
        //         for (int i = 1; i < n-1; i += 2) 
        //             r = Math.min(r, f[i] + (i >= n-3 ? 0 : g[i+3]));
        //     return r;
               // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目的本质：是【动规】
        // // 亲爱的表哥的活宝妹，今天晚上不想再写这组恶心死人、恶心坏这个世界不偿命！！！的破烂题目了，。。
        // // 亲爱的表哥的活宝妹，下个周六再接着写
        // public int minOperations(int[] b, int k) {
        //     int m = b.length, n = m * 2, j = 0, o = 2 * k + 1, curMaxPeaks = 0;
        //     // 【环形数组】的话：把2 个数组串起来，就方便处理了
        //     // 【TODO：】亲爱的表哥的活宝妹，环形数组这里，【直接串起来】可能有细节未能处理完整，，650/1143-passed
        //     int [] a = new int [n];
        //     for (int i = 0; i < m; i++) 
        //         a[i] = a[i+ m] = b[i];
        //     System.out.println(Arrays.toString(a));
        //     // 【动规、状态数组】 f[i][j]：遍历到当下标 i, 取得 j 个 peaks 所需要的最小操作数
        //     // int [][] f = new int [n][2 * k+1];
        //     int [][][] f = new int [n][Math.max(2 * k+1, n/2 + (n % 2 == 1 ? 1 : 0)+1)][2]; // 最后一维：标记当前下标 i 是否视为峰 peaks. 1 为 peaks
        //     for (int i = 0; i < n; i++)
        //         for ( j = 0; j < o; j++) 
        //         Arrays.fill(f[i][j], Integer.MAX_VALUE / 2);
        //     for (int i = 0; i < n; i++)
        //         f[i][0][0] = 0; // 无峰 0 操作
        //     // f[0][0][0] = 0;
        //     // f[0][0][1] = 0;
        //     // 遍历：【0 操作数】时最大峰数
        //     j = 0;
        //     for (int i = 1; i < n-1; i++) 
        //         if (a[i-1] < a[i] && a[i] > a[i+1]) {
        //             ++j; //
        //             f[i][j][1] = 0;
        //         }
        //     if (j >= k * 2) return 0;
        //     f[0][1][1] = (a[0] > a[1] ? 0 : a[1]-a[0]+1);
        //     // 遍历：
        //     for (int i = 1; i < n-1; i++) {
        //         curMaxPeaks = (i+1)/2 + ((i+1) % 2 == 1 ? 1 : 0);
        //         for ( j = curMaxPeaks; j > 0; j--) {
        //             // 当前下标 i:【不作峰】
        //             System.out.println("i: " + i + " " + "j: " + j);
        //             f[i][j][0] = Math.min(f[i][j][0], Math.min(f[i-1][j][0], f[i-1][j][1]));
        //             // 当前下标 i:【作峰】
        //             if (a[i-1] < a[i] && a[i] > a[i+1]) {// a[i-1] 的有效性？
        //                 // i-1 不是峰， a[i-1] 有效；或，i-1 是峰
        //                 f[i][j][1] = Math.min(0 + f[i-1][j-1][0], f[i-1][j][1]);
        //             } else {
        //                 // i-1 不是峰， a[i-1] 有效；或，i-1 是峰
        //                 f[i][j][1] = Math.min(Math.max(a[i-1], a[i+1]) - a[i] + 1 + f[i-1][j-1][0], f[i-1][j][1]);
        //             }
        //         }
        //     }
        //     int min = Integer.MAX_VALUE / 2;
        //     for (int i = m; i < n; i++) 
        //         for ( j = o-1; j >= k; j--) {
        //             if (f[i][j][1] < Integer.MAX_VALUE / 2 && f[i-m][j-k][1] < Integer.MAX_VALUE / 2)
        //                 min = Math.min(min, f[i][j][1] - f[i-m][j-k][1]);
        //         }
        //     return (min == Integer.MAX_VALUE / 2 ? -1 : min);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int mirrorFrequency(String S) {
        //     int n = S.length(), r = 0; char [] s = S.toCharArray();
        //     int [] f = new int [26], g = new int [10];
        //     for (int i = 0; i < n; i++)
        //         if (Character.isDigit(s[i])) 
        //             g[s[i]-'0']++;
        //         else f[s[i]-'a']++;
        //     System.out.println(Arrays.toString(f));
        //     System.out.println(Arrays.toString(g));
        //     for (int i = 0; i < 13; i++)
        //         if (f[i] > 0 || f[25-i] > 0) r += Math.abs(f[i] - f[25-i]);
        //     for (int i = 0; i <= 4; i++)
        //         if (g[i] > 0 || g[9-i] > 0) r += Math.abs(g[i] - g[9-i]);
        //     return r;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String trafficSignal(int v) {
        //   if (v == 0) return "Green";
        //   if (v == 30) return "Orange";
        //   if (30 < v && v <= 90) return "Red";
        //   return "Invalid";
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countDigitOccurrences(int[] a, int digit) {
        //     int n = a.length, f = 0;
        //     for (int S : a) {
        //         char [] s = String.valueOf(S).toCharArray();
        //         for (char c : s)
        //             if (c - '0' == digit) f++;
        //     }
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 这个破烂题目，思路无限简单，可是查找质烽无限繁琐，恶心死人、恶心坏这个世界不偿命！！！不写或是晚点儿再写这个破烂题目
        // public int minOperations(int[] a) {
        //     int n = a.length;
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // static final int mod = (int)1e9 + 7;
        // public int maxValue(int[] a, int[] b) {
        //     int n = a.length;
        //     long f = 0;
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < n; i++)
        //         l.add(new int [] {a[i], b[i]});
        //     Collections.sort(l, (x, y)->(x[0] != y[0] ? y[0] - x[0] : y[1] - x[1]));
        //     for (int i = 0; i < n; i++) {
        //         int [] g = l.get(i);
        //         System.out.println(Arrays.toString(g));
        //      int m = Arrays.stream(g).sum();
        //         int cur = getFastSum(g[0]);
        //         // System.out.println("cur: " + cur);
        //         // System.out.println("(f << m): " + (f << m));
        //         f = ((i == 0 ? 0 : (long)(f << m)) + (g[1] == 0 ? cur : (long)(cur << g[1]))) % mod;
        //         System.out.println("i: " + i + " " + "f: " + f);
        // }
        //     return (int)f;
        // }
        // int getFastSum(int m) {
        //     long f = 0;
        //     for (int i = 0; i < m; i++)
        //         f = (f + (long)Math.pow(2, i)) % mod;
        //     return (int)f;
        // }
        // 早上的一组破烂题目，都出得极度恶心。亲爱的表哥的活宝妹，不写了；亲爱的表哥的活宝妹，傍晚再写另一组

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] findDegrees(int[][] a) {
        //     int n = a.length;
        //     List<Integer> [] g = new ArrayList[n];
        //     Arrays.setAll(g, z -> new ArrayList<Integer>());
        //     for (int i = 0; i < n; i++)
        //         for (int j = 0; j < i; j++) 
        //             if (a[i][j] == 1) {
        //                 g[i].add(j);
        //                 g[j].add(i);
        //             }
        //     int [] f = new int [n];
        //     for (int i = 0; i < n; i++)
        //         f[i] = g[i].size();
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 算三角形的内角。这个破烂题目好恶心，半点儿也不想写
        // public double[] internalAngles(int[] sides) {
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int longestBalanced(String S) {
        //     int n = S.length(), max = 2; char [] s = S.toCharArray();
        //     int [] g = new int [n+1];
        //     for (int i = 0; i < n; i++)
        //         g[i+1] = g[i] + (s[i] - '0');
        //     if (g[n] == n || g[n] == 0) return 0;
        //     if (g[n] * 2 == n) return n;
        //     // 哪里是什么动规？明明是：双指针【滑动窗口】。。
        //     char c = (g[n] >= n / 2 + (n % 2 == 1 ? 1 : 0) ? '0' : '1');
        //     // 查找：可以取得的、连续 c 字符的最大片段长度
        //     for (int i = 0, j = i+1; i < n; i++) {
        //         if (s[i] != c) continue;
        //         while (j < n &&
        //                (c == '0' && 2 * (g[j+1]-g[i]) <= j-i+1
        //                 || c == '1' && g[j+1]-g[i] >= (j-i+1) / 2 +(j-i+1) % 2)) j++;
        //         // 这里的判断标准，细节了繁琐，不想写了，下个周六再写
        //         // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        //     }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int countGoodSubseq(int[] a, int p, int[][] qs) { // TLE TLE 983/1036 passed
        //     int n = a.length, m = qs.length, f = 0;
        //     TreeSet<Integer> s = new TreeSet<>((i, j)->(a[i] != a[j] ? a[i] - a[j] : i - j));
        //     for (int i = 0; i < n; i++)
        //         if (a[i] % p == 0) s.add(i);
        //     for (int i = 0; i < m; i++) {
        //         int k = qs[i][0], v = qs[i][1];
        //         if (v % p == 0) {
        //             if (a[k] % p == 0)
        //                 s.remove(k);
        //             a[k] = v;
        //             s.add(k);
        //         } else if (a[k] % p == 0)
        //             s.remove(k);
        //         if (!s.isEmpty() && a[s.first()] == p) f++;
        //         else if (s.size() >= 2) {
        //             Iterator<Integer> it = s.iterator();
        //             int pre = s.first(), cur = 0;
        //             it.next();
        //             boolean valid = false;
        //             while (it.hasNext()) {
        //                 cur = it.next();
        //                 for (int j : s) {
        //                     if (j == cur) continue;
        //                     if (gcd(a[cur], a[j]) == p) {
        //                         f++;
        //                         valid = true;
        //                         break;
        //                     }
        //                 }
        //                 if (valid) break;
        //             }
        //         }
        //         // System.out.println("i: " + i + " " + "f: " + f);
        //     }
        //     return f;
        // }
        // int gcd(int x, int y) {
        //     if (y == 0) return x;
        //     return gcd(y, x % y);
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int firstStableIndex(int[] a, int k) {
        //     int n = a.length, r = 0;
        //     if (n == 1) return 0;
        //     int [] f = new int [n];
        //     Arrays.fill(f, Integer.MAX_VALUE / 2);
        //     f[n-1] = a[n-1];
        //     for (int i = n-2; i >= 0; i--) 
        //         f[i] = Math.min(f[i+1], a[i]);
        //     for (int i = 0; i < n; i++) {
        //         r = Math.max(r, a[i]);
        //         if (r - f[i] <= k) return i;
        //     }
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // int [][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        // public int[][] colorGrid(int m, int n, int[][] a) {
        //     System.out.println("m: " + m + " " + "n: " + n);
        //    int [][] f = new int [m][n];
        //     Deque<int []> q = new ArrayDeque<>();
        //     for (int i = 0; i < a.length; i++) {
        //         q.offerFirst(a[i]);
        //         f[a[i][0]][a[i][1]] = a[i][2];
        //     }
        //     Map<Integer, Integer> s = new HashMap<>();
        //     while (!q.isEmpty()) {
        //         for (int w = q.size()-1; w >= 0; w--) {
        //             int [] g = q.pollLast();
        //             int i = g[0], j = g[1], v = g[2];
        //             for (int [] d : dirs) {
        //                 int x = i + d[0], y = j + d[1];
        //                 if (x < 0 || x >= m || y < 0 || y >= n || f[x][y] > 0 && !s.containsKey(x * n + y)) continue;
        //                 if (!s.containsKey(x * n + y)) 
        //                     s.put(x * n + y, v);
        //                 else 
        //                     s.put(x * n + y, Math.max(v, s.get(x * n + y)));
        //             }
        //         }
        //         for (Map.Entry<Integer, Integer> en : s.entrySet()) {
        //             int k = en.getKey(), v = en.getValue();
        //            q.offerFirst(new int [] {k / n, k % n, v});
        //             f[k/n][k%n] = v;
        //         }
        //         s.clear();
        //     }
        //     return f;
        // }
        
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 亲爱的表哥的活宝妹，能够想到的就是【暴力解法】按步就班地、遍历：不知道会不会 TLE ？？？一定会 TLE 的！！！
        // // 【暴力】不好、拒绝暴力！！！
        // // 1.【String directions】是离线不变数据；并且它界定了【16 个数位】里：（真正 matter 的 critical 的数位，仅仅只 7 个数位），其它不关键数位任意填。。
        // // 2.【l,r】都是 long, 数据规模大，但（不超过：16 个数位）
        // // 上面两点，就决定了，这个题目，应该是【数位 DP 动规】：遍历 16 个有效数位；根据字符串等限制条件，来判定合法有效性数个数
        // // 亲爱的表哥的活宝妹，曾经【灵光一现的：左右边界串、且非毒串】记忆化深搜数个数，同这个数个数，除了更简单（不涉及：非毒串）；判断计入统计的标准，多一点儿新意
        // // 亲爱的表哥的活宝妹，明天周日会抽时间再想想、写写这个破烂题目。
        // // 【记忆化深搜】：定义（哪些状态、界定）一个 state 状态？【TODO：】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹女，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public long countGoodIntegersOnPath(long l, long r, String D) {
        //     String S = String.valueOf(l), T = String.valueOf(r);
        //     m = S.length(); n = T.length(); o = 16 - m; p = 16 - n
        //     s = S.toCharArray(); t = T.toCharArray(); d = D.toCharArray();
        //     // 【TODO：】把【16 个数位】里：（真正 matter 的 critical 的数位，仅仅只 7 个数位），其它不关键数位任意填。。把 7 个关键位放进一个 set 里
        //     // m <= n
        //     long ans = 0;
        //     f = new HashMap<>();
        //     for (int i = o; i >= 0; i--) {
        //         // for (int j = 0; j < 10; j++) {
        //         int lo = (i == o ? s[0]-'0' : 1);
        //         int hi = (i == p ? t[0]-'0' : 9);
        //         for (int j = lo; j <= hi; j++) 
        //             // ans += dfs(i, (i == o || i == p ? 1 : 0), k=pre|todo);
        //             ;
        //     }
        //     return ans;
        // }
        // Map<Long, Long> f;
        // char [] s, t, d;
        // int m, n, o;
        // // long dfs(int i, boolean j, boolean k) { // i: 数位下标 idx; j: 是否 match 【左右l.r 边界】; k: 是否 match 【7 个关键数位】——这个可以不用
        // long dfs(int i, int j, int k) { // i: 数位下标 idx; j: 是否 match 【左右l.r 边界】; k:  【7 个关键数位】前一个高位 pre 的取值
        //     // i: [0,15] 16 个数位，用 5 个 bit 来纪录状态； j:[0/1] 1 个bit 来纪录状态； k:pre[0,1...9]用 4 个 bit 来纪录状态
        //     long key = ((i << 5) | (j << 4) | k);
        //     if (f.containsKey(key)) return f.get(key);
        //     // 【TODO：】亲爱的表哥的活宝妹，明天拉着这里往后写。
        //     // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public List<Integer> findValidElements(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n], g = new int [n];
        //     f[0] = 0;
        //     for (int i = 1; i < n; i++)
        //         if (a[i] > a[f[i-1]])
        //             f[i] = i;
        //         else f[i] = f[i-1];
        //     g[n-1] = n-1;
        //     for (int i = n-2; i >= 0; i--)
        //         if (a[i] > a[g[i+1]])
        //             g[i] = i;
        //         else g[i] = g[i+1];
        //     List<Integer> l = new ArrayList<>();
        //     l.add(a[0]);
        //     for (int i = 1; i < n-1; i++) 
        //         if (f[i] == i || g[i] == i)
        //             l.add(a[i]);
        //     if (n > 1)
        //         l.add(a[n-1]);
        //     return l;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public String sortVowels(String S) {
        //     int n = S.length(); char [] s = S.toCharArray();
        //     Set<Character> sc = new HashSet<>(List.Of('a', 'e', 'i', 'o', 'u'));
        //     int [] g = new int [26];
        //     Arrays.fill(g, -1);
        //     TreeMap<Integer, Character> idx = new TreeMap<>();
        //     TreeMap<Integer, Integer> mo = new TreeMap<>();
        //     for (int i = 0; i < n; i++)
        //         if (sc.contains(s[i])) {
        //             mo.put(s[i], mo.getOrDefault(s[i], 0) + 1);
        //             if (!idx.containsKey(s[i]))
        //                 idx.put(i, s[i]);
        //             if (g[s[i]-'a'] == -1)
        //                 g[s[i]-'a'] = i;
        //         }
        //     Map<Integer, Integer> m = MapUtil.sortByValue(mo, true); // 【TODO：】这个排序算法，对此题不完整
        //     // 【TODO：】亲爱的表哥的活宝妹，晚点儿再写这个破烂题目
        //     for (int i = 0; i < n; i++) 
        //         if (sc.contains(s[i])) {
        //         }
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【动规】：一定是动规！！！
        // // 亲爱的表哥的活宝妹，还是某些时候写不习惯【动规】，就先写【记忆化深搜 DFS】
        // public long maxAlternatingSum(int[] a, int k) {
        //     n = a.length; this.k = k;
        //     l = new int [n]; r = new int [n];
        //     for (int i = n-2; i >= 0; i--) {
        //         if ()
        //     }
        //     long max = (long)Arrays.stream(a).max().getAsInt();
        //     f = new Long [n]; // 升
        //     g = new Long [n]; // 降
        //     for (int i = 0; i < n; i++)
        //         max = Math.max(max, Math.max(dfs(i, 0), dfs(i, 1)));
        //     return max;
        // }
        // Long [] f, g;
        // // 想要存储：【自右往左】遍历：比（当前下标 i）k 元素之外 [小，或是，大] 的最近下标。不要 k 元素之外的限制
        // int [] l, r;
        // int n, k;
        // // 【TODO：】记（升序降序）没用，得知道，（上个元素、下标 idx 在哪里）以便比较是升或是降序
        // long dfs(int i, int j) { // j : [0:升序；1:降序]
        //     if (i >= n) return Long.MIN_VALUE / 2;
        //     if (j == 0 && f[i] != null) return f[i];
        //     else if (j == 1 && g[i] != null) return g[i];
        //     if (i == n-1)
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public boolean validDigit(int n, int x) {
        //     char [] s = String.valueOf(n).toCharArray();
        //     if (s[0] - '0' == x) return false;
        //     if (n == 1) return false;
        //     for (int i = 1; i < s.length; i++)
        //         if (s[i] - '0' == x) return true;
        //     return false;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int compareBitonicSums(int[] a) {
        //     int n = a.length, j = 0;
        //     if (n == 1) return -1;
        //     long [] f = new long [n+1];
        //     for (int i = 0; i < n; i++)
        //         f[i+1] = f[i] + (long)a[i];
        //     for (int i = 1; i < n; i++)
        //         if (a[i] > a[i-1]) j = i;
        //     long r = f[n] - f[j];
        //     if (f[j+1] > r) return 0;
        //     if (f[j+1] < r) return 1;
        //     return -1;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 【无向图】：基本建图都懂；但不知道怎么遍历和判断，晚点儿再写这个破烂题目
        // public int evenSumSubgraphs(int[] a, int[][] egs) {
        //     int n = a.length;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public class SegTree {
        //     public class Node {
        //         int i; // idx
        //         int v; // 是否【偶数】的标记（0,1）
        //         Node l, r;
        //         public Node(int i, int j) {
        //             this.i = i; v = j;
        //         }
        //     }
        //     Node r; // root
        //     int n;
        //     public SegTree(int [] a) {
        //         n = a.length;
        //     }
        // }
        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // a[i] 数组：离散化数据的（集中化处理），集中到【0,10^5】下标 idx 范围内；方便【Bit 数据】区间更新？还是一个一个单点更新恢复数据
        // // 【单点更新】：是用 Bit 还是用线段树？统计（偶数总个数的）求和线段树？如果只是数偶数总个数，用个数偶数个数【前缀和】数组就可以了。。。不需要 BIT 或是线段树！！！
        // // 每个 qs[i]: 数的是 [li,ri] 下标范围内（偶数）的总个数，或某个个数（若 qs[i][3] 落在【li,ri】范围内）
        // // qs 离线数据，顺序不重要、不产生交互影响，【可排序】优化
        // public int[] kthRemainingInteger(int[] a, int[][] qs) {
        //     int n = a.length;
        //     // Map<Integer, Integer> m = new HashMap<>(); // 离散化数据、集中化处理时的【一一对应】：
        //     // TreeSet<Integer> s = new TreeSet<>(); // 方便快速遍历恢复数据
        //     int [] f = new int [n];
        //     f[0] = (a[0] >= 2 && a[0] % 2 == 0 ? 1 : 0);
        //     for (int i = 0; i < n; i++)
        //         // if (a[i] >= 2 && a[i] % 2 == 0) s.add(i);  // <<<<<<<<<<<<<<<<<<<< idx
        //         f[i+1] = f[i] + (a[i] >= 2 && a[i] % 2 == 0 ? 1 : 0);
        //     List<int []> l = new ArrayList<>();
        //     for (int i = 0; i < qs.length; i++) 
        //         l.add(new int [] {qs[i][0], qs[i][1], qs[i][2], i});
        //     Collections.sort(l, (x, y) -> x[0] != y[0] ? x[0] - y[0] : (x[1] != y[1] ? x[1] - y[1] : x[2] - y[2]));
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // public int[] countOppositeParity(int[] a) {
        //     int n = a.length;
        //     int [] f = new int [n];
        //     int [] l = new int [n+1], r = new int [n+1];
        //     for (int i = n-1; i >= 0; i--) {
        //         if (a[i] % 2 == 1) {
        //             l[i] = l[i+1] + 1;
        //             r[i] = r[i+1];
        //         } else {
        //             l[i] = l[i+1];
        //             r[i] = r[i+1] + 1;
        //         }
        //     }
        //     for (int i = 0; i < n; i++)
        //         f[i] = (a[i] % 2 == 1 ? r[i+1] : l[i+1]);
        //     return f;
        // }

        // // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // // 数据规模不大，就【暴力】所有步骤与可能性
        // public int sumOfPrimesInRange(int n) {
        //     int m = Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
        //     int l = Math.min(m, n), r = Math.max(m, n);
        //     int f = 0;
        //     for (int i = l; i <= r; i++)
        //         if (isPrime(i))
        //             f += i;
        //     return f;
        // }
        // boolean isPrime(int v) {
        //     if (v < 2) return false;
        //     if (v == 2) return true;
        //     for (int i = 2; i * i <= v; i++) 
        //         if (v % i == 0) return false;
        //     return true;
        // }

        // 【亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹，就是一定要、一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！】
        // 这是个【带边线权重的、图 graph: 有向图！】：求两节点间的（最小代价、最小权重）等。感觉所它转化成图的问题，应该是正确的思路，但细节未能完成完整
        // 亲爱的表哥的活宝妹，不知道这个题目，哪里的细节写错了，改天再接着这里往后改。
        public int[] minCost(int[] a, int[][] qs) {
            n = a.length;
            int [] f = new int [n];
            f[0] = 1; f[n-1] = n-2;
            for (int i = 1; i < n-1; i++) 
                f[i] = (Math.abs(a[i] - a[i-1]) <= Math.abs(a[i] - a[i+1]) ? i-1 : i+1);
            System.out.println(Arrays.toString(f));
            // 【建图：边有权重的、无向图】？
            g = new ArrayList[n];
            Arrays.setAll(g, z -> new ArrayList<int []>());
            for (int i = 0; i < n; i++) 
                g[i].add(new int [] {f[i], 1});
            m = new HashMap<>();
            int idx = 0;
            for (int [] e : qs) {
                int u = e[0], v = e[1], x = Math.abs(a[u] - a[v]);
                g[u].add(new int [] {v, x});
                // g[v].add(new int [] {u, x});
                m.computeIfAbsent(u, z -> new HashMap<Integer, Integer>());
                m.get(u).put(v, idx);
                idx++;
            }
            // 【有向图】：两节点间的（最短距离），
            // 设定【根节点、起始节点】为 0
            // 预处理数据：所有节点，到根节点的（最小距离）。。。这个思路，像是，不再对了。。。?????
            // 思路换成：【有向图的、树型遍历？广度优先遍历？动规DP】
            d = new long [n];
            // 【TODO：】想要一种，有序遍历方法，能够有序一次遍历出 qs 里所有的结果，但【TODO：】感觉这里思路欠缺一点儿什么。。。
            // 【有向图】：把它想像成（有向树）。自底向上遍历。。。
            bfs(0);
            int [] ans;
            ans = new int [qs.length];
            for (int u : m.keySet()) {
                if (d[u] == Long.MAX_VALUE / 2) continue; // <<<<<<<<<<<<<<<<<<<< 存在这种情况吗？？？存在！！
                for (int v : m.get(u).keySet()) 
                    ans[m.get(u).get(v)] = (int)(d[v] - d[u]);
            }
            System.out.println(Arrays.toString(ans));
            for (int u : m.keySet()) {
                if (d[u] == Long.MAX_VALUE / 2) {
                    // 以【u 为根节点：BFS】求结果
                    bfs(u);
                    for (int v : m.get(u).keySet()) 
                        ans[m.get(u).get(v)] = (int)(d[v] - d[u]);
                }
            }
            return ans;
        }
        List<int []> [] g;        
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        long [] d;
        int n;
        void bfs(int uu) {
            Arrays.fill(d, Long.MAX_VALUE / 2);
            d[uu] = 0;
            Deque<long []> q = new ArrayDeque<>();
            q.offerFirst(new long [] {uu, 0l});
            while (!q.isEmpty()) {
                long [] cur = q.pollLast();
                int u = (int)cur[0]; long dv = cur[1];
                for (int [] v : g[u]) {
                    if ((long)v[1] + dv <= d[v[0]]) { // <= ?
                        d[v[0]] = (long)v[1] + dv;
                        q.offerFirst(new long [] {(long)v[0], (long)v[1] + dv});
                    }
                }
            }
        }        
        // void Dij() // 应该，不再是【最短距离】的那个、想不起来名字的 Dij 算法
    }    // 亲爱的表哥的活宝妹，任何时候，亲爱的表哥的活宝妹就是一定要,一定会嫁给活宝妹的亲爱的表哥！！！爱表哥，爱生活！！！ 
    
    public static void main (String[] args) { 
        Solution s = new Solution (); 

        int []  a = new int []  {-5, -2, 3};
        int [][] b = new int [][] {{0,2},{2,0},{1,2}};

        int [] r = s.minCost(a, b);
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