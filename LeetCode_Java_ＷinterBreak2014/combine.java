import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class combine {
    public static class Solution {
        public void dfs(List<List<Integer>> res, List<Integer> path, int n, int k, int bgn, int cur) {
            if (cur == k) {
                res.add(new ArrayList<Integer>(path));
            }
            for (int i = bgn; i <= n; i ++) {
                path.add(i);
                dfs(res, new ArrayList<Integer>(path), n, k, i + 1, cur + 1);
                path.remove(path.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            dfs(res, path, n, k, 1, 0); 
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        List<List<Integer>> res = result.combine(13, 3);

        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
/*
  Time Limit ExceededMore Details 
  Last executed input:	13, 3
*/
