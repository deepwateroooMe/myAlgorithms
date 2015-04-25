import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class wordBreakII {
    public static class Solution {
        // tag: dynamic programming, backtracing
        // do it backwards

        public void helper(String s, Set<String> dict, List<String> list, int end,
                           List<String> res) {
            if (end == 0) {
                StringBuffer tmp = new StringBuffer();
                for (int i = list.size() - 1; i >= 0; i--) {
                    tmp.append(list.get(i));
                    tmp.append(" ");
                }
                list = new ArrayList<String>();
                res.add(tmp.toString().trim());
                return;
            }

            int fast = end - 1;
            while (fast >= 0) {
                String tmp = new String(s.substring(fast, end));
                if (dict.contains(tmp)) {
                    list.add(tmp);
                    helper(s, dict, list, fast, res);
                    list.remove(list.size() - 1);
                }
                --fast;
            }
        }

        // use a ArrayList to store the strings for one path
        public List<String> wordBreak(String s, Set<String> dict) {
            List<String> result = new ArrayList<String>();
            List<String> list = new ArrayList<String>();
            if (s == null || s.length() == 0) return null;
            if (dict == null || dict.size() == 0) return result;
            if (s.length() == 1) {
                if (dict.contains(s)) {
                    list.add(s);
                    return list; 
                } else return result;
            }

            int slow = s.length(), fast = slow - 1;
            while (fast >= 0) {
                String tmp = new String(s.substring(fast, slow));
                if (dict.contains(tmp)) {
                    list = new ArrayList<String>();
                    list.add(tmp);
                    helper(s, dict, list, fast, result);
                }
                --fast;
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        String [] a = {"cat","cats","and","sand","dog"};
        for(String i : a)
            dict.add(i);
        List<String> res;
        res = result.wordBreak(s, dict);
        
        System.out.println(res);
    }
}

/*
  Input:	"catsanddog", ["cat","cats","and","sand","dog"]
Output:	["cat sand cats and dog"]
Expected:	["cats and dog","cat sand dog"]

  Input:	"a", ["b"]
Output:	["a"]
Expected:	[]

Input:	"a", []
Output:	["a"]
Expected:	[]

// I traced and got the results, but too slow~
// time limit exceed: because I didn't use any dp ?  backwards
Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
*/
