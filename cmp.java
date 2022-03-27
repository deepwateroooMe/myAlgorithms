import com.TreeNode;
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

        public List<List<Integer>> findDifference(int[] a, int[] b) {
            Set<Integer> sa = new HashSet<>();
            Set<Integer> sb = new HashSet<>();
            for (int v : a) sa.add(v);
            for (int v : b) sb.add(v);
            List<Integer> la = new ArrayList<>();
            List<Integer> lb = new ArrayList<>();
            for (int v : sa)
                if (!sb.contains(v)) la.add(v);
            for (int v : sb)
                if (!sa.contains(v)) lb.add(v);
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(la);
            ans.add(lb);
            return ans;
        }

        public int minDeletion(int [] a) {
            int n = a.length, cnt = 0;
            boolean even = true;
            for (int i = 0; i < n-1; i++) {
                if (i % 2 == 0 && even) {
                    if (a[i] != a[i+1]) i++;
                    else {
                        cnt++;
                        
                    }
                }
            }
            return 0;
        }

        public long[] kthPalindrome(int[] queries, int intLength) { // 大致的思路方向是对的，但很繁琐
            int n = queries.length;
            for (int i = 0; i < n; i++) {
                s.add(queries[i]); 
                l.add(new int [] {i, queries[i]}); // 因为对每个排位进行独立生成，一开始的排序已经不是必须的了
                m.computeIfAbsent(queries[i], z -> new ArrayList<>()).add(i);
            }
            Collections.sort(l, (a ,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
            ans = new long [n];
            generatePal(intLength);
            return ans;
        }
        List<int []> l = new ArrayList<>();
        Map<Integer, List<Integer>> m = new HashMap<>();
        TreeSet<Integer> s = new TreeSet<>();
        long [] ans;
        void generatePal(int n) { 
            if (s.size() == 0) return ;
            while (s.size() > 0) {
                int v = s.pollFirst();
                long res = getValAtIdx(n, v);
                for (int i : m.get(v)) 
                    ans[i] = res;
            }
        }
        long getValAtIdx(int n, int i) {
            String res = "";
            System.out.println("i: " + i);
            if (n == 1) {
                if (i < 10) return i;
                return -1;
            }
            if (i < 10) { // 这里和while里面的i < 10怎么合并一下简化代码
                if (n % 2 == 1) {
                        res = "1"+"0".repeat(n/2-1) + (i-1) + "0".repeat(n/2-1) + "1"; // 这里有点儿问题，分奇偶
                } else {
                    if (n == 2)
                        res = i + "" + i;
                    else 
                        res = "1"+ (n/2 >= 2 ? "0".repeat(n/2-2) : "") + (i-1) + (i-1) + (n/2 >= 2 ? "0".repeat(n/2-2) : "") + "1"; // 这里有点儿问题，分奇偶
                    // return res;
                }
            } else
            if (i > 9 * Math.pow(10, n/2)) return -1;
            else if (i == 9 * Math.pow(10, n/2))
                return Long.parseLong("9".repeat(n));
            else { // 这里好像res只有一半长度
                long base = 0;
                while (i > 0) {
                    if (i < 10) {
                        System.out.println("res: " + res);
                        if (n > 2)
                            res += (i-1);
                        else res += i;
                        break;
                    }
                    res += i / Math.pow(10, n/2-base);
                    base++;
                    i /= 10;
                }
                res += new StringBuilder (res).reverse().toString();
            }
            System.out.println("res: " + res);
            return Long.parseLong(res);
            // if (n % 2 == 0) return Long.parseLong(res + new StringBuilder (res).reverse().toString());
            // return Long.parseLong(res + new StringBuilder (res).reverse().substring(1).toString());
        }

        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            int n = piles.size();
            List<List<Integer>> ll = new ArrayList<>();
            

        }
    }
    public static void main(String args[]) {
        Solution s = new Solution();

        // int []  a = new int []  {1, 2, 3, 4, 5, 90};
        // int [] a = new int [] {2, 4, 6};
        // int []  a = new int []  {2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6};
        // int []  a = new int []  {392015495, 5, 4, 1, 425320571, 565971690, 3, 7, 6, 3, 506222280, 468075092, 5};
        int []  a = new int []  {928053739, 72, 86059860, 90, 622074924, 831263840, 8, 10, 43, 13, 54, 870906009, 64};

        long [] r = s.kthPalindrome(a, 3);
        System.out.println(Arrays.toString(r));
    }
}
// ListNode head = new ListNode(a[0]);
// head.buildList(head, a);
// head.printList(head);

// TreeNode root = new TreeNode(a[0]);
// root.buildTree(root, a);
// root.levelPrintTree(root);

// 相比于去年12月底当有一个面试，感觉leetcode的题目故意叼难自己，不得不躲起来藏两三个星期不敢参赛
// 现在最大的勇气在于：不管它现在是不是现在还在故意为难我，都试图去理自己的思路解题，也当是自己的一点儿进步吧