// import com.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Fancy {

    // private static int N = 100001;
    // private static int [] tree = new int [N]; // 拿元素值作为 key 对应 tree 的下标值
    // public int lowbit(int i) {
    //     return i & -i;
    // }
    // public void update(int i, int v) { // 更新父节点
    //     while (i <= N) {
    //         tree[i] += v;
    //         i += lowbit(i);
    //     }
    // }
    // public int getSum(int i) { // 得到以 i 为下标1-based的所有子、叶子节点的和， 也就是[1, i]的和，1-based
    //     int ans = 0;
    //     while (i > 0) {
    //         ans += tree[i];
    //         i -= lowbit(i);
    //     }
    //     return ans;
    // }

    // private long add, mul;
    // public List<Integer> l;
    // private static final int mod = 1000000007;
    
    // public Fancy() {
    //     add = 0;
    //     mul = 1;
    //     l = new ArrayList<>();
    // }
    // public void append(int val) {
    //     val = (int)((val - add + mod) % mod);
    //     val = (int)(((long)val * q(mul, mod-2)) % mod);
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
    // private long q (long x, long y) {
    //     long res = 1;
    //     while (y > 0) {
    //         if (y % 2 != 0)
    //             res = res * x % mod;
    //         x = x * x % mod;
    //         y /= 2;
    //     }
    //     return res;
    // }

    private long add, mul;
    private List<Integer> l;
    private static final int mod = 1000000007;
 
    public Fancy() {
        add = 0;
        mul = 1;
        l = new ArrayList<>();
    }
 
    public void append(int val) {
        val = (int) ((val - add + mod) % mod);
        val = (int) (((long) val * q(mul, mod - 2)) % mod);
        l.add(val);
    }
 
    public void addAll(int inc) {
        add = (add + inc) % mod;
    }
 
    public void multAll(int m) {
        add = add * m % mod;
        mul = mul * m % mod;
    }
 
    public int getIndex(int idx) {
        if (idx >= l.size())
            return -1;
        return (int) ((l.get(idx) * mul + add) % mod);
    }
 
    private long q(long x, int y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 != 0)
                res = res * x % mod;
            x = x * x % mod;
            y /= 2;
        }
        return res;
    }

    // public static class Solution {    }

    public static void main(String[] args) {
        Fancy s = new Fancy();
        s.append(2);   // 奇妙序列：[2]

        System.out.println("s.l.size(): " + s.l.size());
        for (int z = 0; z < s.l.size(); ++z) 
            System.out.print(s.l.get(z) + ", ");
        System.out.print("\n");

        s.addAll(3);   // 奇妙序列：[2+3] -> [5]
        s.append(7);   // 奇妙序列：[5, 7]
        System.out.println("s.l.size(): " + s.l.size());
        for (int z = 0; z < s.l.size(); ++z) 
            System.out.print(s.l.get(z) + ", ");
        System.out.print("\n");

        s.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
        s.getIndex(0); // 返回 10
        s.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
        s.append(10);  // 奇妙序列：[13, 17, 10]
        System.out.println("s.l.size(): " + s.l.size());
        for (int z = 0; z < s.l.size(); ++z) 
            System.out.print(s.l.get(z) + ", ");
        System.out.print("\n");

        s.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
        s.getIndex(0); // 返回 26
        s.getIndex(1); // 返回 34
        s.getIndex(2); // 返回 20
        System.out.println("s.l.size(): " + s.l.size());
        for (int z = 0; z < s.l.size(); ++z) 
            System.out.print(s.l.get(z) + ", ");
        System.out.print("\n");
        

    }
}