import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;

public class combine {
    public static class Solution {
        /**
         * @param n: Given the range of numbers
         * @param k: Given the numbers of combinations
         * @return: All the combinations of k numbers out of 1..n
         */
        public void combine(int n, int k, int idx, List<Integer> src, List<Integer> path,
                      List<List<Integer>> res) {
            if (path.size() == k) {
                List<Integer> one = new ArrayList<Integer>(path);
                Collections.sort(one);
                res.add(new ArrayList(one));
                return;
            }
            for (int i = idx; i < n; i++) {
                path.add(src.get(i));
                combine(n, k, i + 1, src, path, res);
                path.remove(path.size() - 1);
            }
        }
        
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> src = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) 
                src.add(i + 1);
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            combine(n, k, 0, src, path, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 4;
        int k = 2;
        List<List<Integer>> res = result.combine(n, k);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
