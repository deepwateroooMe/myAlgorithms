import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;

public class combine {
    public static class Solution {
        public void recursion(List<List<Integer>> res, List<Integer> src, int n, int k, int depth) {
            if (src.size() == k) {
                res.add(new ArrayList<Integer>(src));
                return;
            }

            for (int i = depth; i <= n; i ++) {
                //Collections.sort(src);
                src.add(i);
                recursion(res, new ArrayList<Integer>(src), n, k, i + 1);
                src.remove(src.size() - 1);
            }
            return;
        }

        // compare against remove, added has order, & won't produce duplicates ~~!!
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (n == 0 || k == 0) return res;
            if (n == k) {
                List<Integer> src = new ArrayList<Integer>();
                for (int i = 1; i <= n ; i++) src.add(i);
                res.add(src);
                return res;
            }

            List<Integer> one = new ArrayList<Integer>();
            recursion(res, one, n, k, 1); // one src
           /*
           HashSet<List<Integer>> set = new HashSet<List<Integer>>(res);
           res.clear();
           res.addAll(set);
           Collections.sort(res, new Comparator<List<Integer>>(){
                   @Override
                       public int compare(List<Integer> a, List<Integer> b) {
                       for (int i = 0; i < a.size(); i++) {
                           if (a.get(i) < b.get(i))
                               return -1;
                           else if (a.get(i) == b.get(i)) continue;
                           else return 1;
                       }
                       return 1;
                   }
               });
           */
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
