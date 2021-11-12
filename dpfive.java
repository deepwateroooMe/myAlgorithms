import com.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.stream.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class dpfive {
    public static class Solution {

        // List<List<Integer>> ll = new ArrayList<>();
        // boolean [] vis;
        // int n;
        // public int numSquarefulPerms(int[] a) {
        //     n = a.length;
        //     if (Arrays.stream(a).distinct().count() == 1) {
        //         if (!isSquare(a[0] + a[1])) return 0;
        //         return 1;
        //     }
        //     vis = new boolean[n];
        //     dfs(a, 0, new ArrayList<>());
        //     return ll.size();
        // }
        // private void dfs(int [] a, int idx, List<Integer> l) { // tle tle tle
        //     if (l.size() >= 2 && !isValid(l)) return;
        //     if (l.size() == n) {
        //         if (isValid(l) && !ll.contains(l)) ll.add(new ArrayList<>(l));
        //         return ;
        //     }
        //     for (int i = 0; i < n; i++) {
        //         if (i > 0 && a[i] == a[i-1] && vis[i-1]) continue; // 很重要,总结
        //         if (!vis[i]) {
        //             vis[i] = true;
        //             l.add(a[i]);
        //            dfs(a, i+1, l);
        //             l.remove(l.size()-1);
        //             vis[i] = false;
        //         }
        //     }
        // }
        // private boolean isSquare(int v) {
        //     return Math.pow((int)Math.sqrt(v), 2) == v;
        // }
        // private boolean isValid(List<Integer> l) {
        //     for (int i = 0; i <= l.size()-2; i++) 
        //         if (!isSquare(l.get(i) + l.get(i+1))) return false;
        //     return true;
        // }


        

    }
    public static void main(String[] args) {
        Solution s  =  new Solution();

        int []  a = new int []  {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};

        int  r  =  s.numSquarefulPerms(a);
        System.out.println("r: " + r);
    }
}