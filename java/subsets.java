import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Collections;

public class subsets {
    public static class Solution {
        public List<List<Integer>> subsets0(int[] s) {
            Arrays.sort(s);   
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            int n = s.length;
            int idx = 0;
            for (int i = 0; i < (1 << n); i++) {
                for (int j = 0; j < n; j++) {
                    // if ((i & (1 << j)) != 0) path.add(s[j]);
                    if(((i >> j) & 1 ) != 0) path.add(s[j]);   
                }
                res.add(path);
                path = new ArrayList<Integer>();
            }
            return res;
        }

        public void helper1(int [] s, List<Integer> path, int step, List<List<Integer>> res) {
            if (step == s.length) {
                res.add(new ArrayList<Integer>(path));
                return;   
            }
            helper1(s, path, step + 1, res);
            path.add(s[step]);
            helper1(s, path, step + 1, res);
            path.remove(path.size() - 1);
        }
        
        public List<List<Integer>> subsets1(int[] s) {
            Arrays.sort(s); 
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> path = new ArrayList<Integer>();
            helper1(s, path, 0, res);
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

        public List<List<Integer>> subsets(int[] s) {
            Arrays.sort(s); 
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int val : s) {
    
            }

            return res;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {4, 1, 0};
        List<List<Integer>> res = result.subsets(a);
        System.out.println("");
        for (int i = 0; i < res.size(); ++i) {
            System.out.println(res.get(i));
        }
        System.out.println("");
    }
}
/*
  Input:	[4,1,0]
  Output:	[[],[0],[1],[4],[1,0],[4,0],[4,1],[4,1,0]]
  Expected:	[[],[0],[1],[4],[0,1],[0,4],[1,4],[0,1,4]]

  Input:	[4,1,0]
  Output:	[[],[4],[1],[4,1],[0],[4,0],[1,0],[4,1,0]]
  Expected:	[[],[0],[1],[4],[0,1],[0,4],[1,4],[0,1,4]]
*/
