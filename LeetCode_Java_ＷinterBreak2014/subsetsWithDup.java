import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;
import java.util.Arrays;
import java.util.HashSet;


import java.util.Comparator;
import java.util.Collections;

public class subsetsWithDup {
    public static class Solution {
        public List<List<Integer>> subsetsWithDup3(int[] s) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if (s == null || s.length == 0) return res;
            List<Integer> one = new ArrayList<Integer>();

            HashSet<List<Integer>> set = new HashSet<List<Integer>>();  //// ....
            int n = (int)Math.pow(2.0, s.length);
            int idx = 0;

            Arrays.sort(s);
            for (int i = 0; i < n; i++) {
                int val = i;
                idx = 0;
                while (val > 0) {
                    if ((val & 1) == 1) 
                        one.add(s[idx]);
                    ++idx;
                    val = (val >>> 1);
                }
                //res.add(one);
                set.add(one);
                one = new ArrayList<Integer>();
            }
            
            res.addAll(set);
            // a == b t, a == c t, b <> c ?
            Collections.sort(res, new Comparator<List<Integer>>() {
                    // 1 -1 0 : ???
                    @Override
                        public int compare(List<Integer> a, List<Integer> b) {
                        if (a.size() < b.size()) return -1;
                        else if (a.size() > b.size()) return 1;
                        else { // if (a.size() == b.size()) {
                            for (int i = 0; i < a.size(); i++) 
                                if (a.get(i) < b.get(i))
                                    return -1;
                                else if (a.get(i) == b.get(i)) continue;  // added this condtion
                                else return 1;
                            return 0;
                        }
                    }
                });
            return res;
        }

        public void helper1(int [] s, List<Integer> path, List<List<Integer>> res) {
            res.add(new ArrayList<Integer>(path));
            for (int i = 0; i < s.length; i++) {
                if (i != 0 && s[i] == s[i - 1]) continue;
                path.add(s[i]);
                helper1(s, path, res);
                path.remove(path.size() - 1);
            }
        }
        
        public List<List<Integer>> subsetsWithDup1(int[] s) {
            Arrays.sort(s); 
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            helper1(s, path, res);
            return res;
        }

        public void helper(int [] s, boolean [] selected, int step, List<List<Integer>> res) {
            if (step == s.length) {
                List<Integer> path = new ArrayList<Integer>();
                for (int i = 0; i < s.length; i++) {
                    if (selected[i]) path.add(s[i]);
                }
                res.add(path);
                return;   
            }
            selected[step] = false;
            helper(s, selected, step + 1, res);
            selected[step] = true;
            helper(s, selected, step + 1, res);
        }
        
        public List<List<Integer>> subsets2(int[] s) {
            Arrays.sort(s); 
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            boolean [] selected = new boolean[s.length];
            helper(s, selected, 0, res);
            return res;
        }

        public List<List<Integer>> subsetsWithDup(int[] s) {
            Arrays.sort(s);   
            HashSet<List<Integer>> res = new HashSet<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            int n = s.length;
            for (int i = 0; i < (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) path.add(s[j]);
                    //if(((i >> j) & 1 ) != 0) path.add(s[j]);   
                }
                res.add(path);
                path = new ArrayList<Integer>();
            }
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.addAll(res);
            return result;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5, 6, 7, 8, 10, 0};
        List<List<Integer>> res = result.subsetsWithDup(a);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
/*
  /// ... wired wired could NOT be any wireder, but ... fox protended to be tiger
  Runtime Error Message:	Line 28: java.lang.IllegalArgumentException: Comparison method violates its general contract!
Last executed input:	[1,2,3,4,5,6,7,8,10,0]
 */
