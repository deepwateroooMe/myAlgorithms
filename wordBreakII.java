import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class wordBreakII {
    public static class Solution {
        // tag: dynamic programming, backtracing
        public void helper(String s, Set<String> dict, List<String> list, int start) {
            if (start == s.length()) return;
            int fast = start + 1;
            while (fast <= s.length()) {
                String tmp = new String(s.substring(start, fast));
                if (dict.contains(tmp)) {
                    list.add(tmp);
                    helper(s, dict, list, fast);
                }
                fast++;
            }
        }

        public String buildString(List<String> list) {
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                result.append(list.get(i));
                result.append(" ");
            }
            return result.toString().trim();
        }
        
        // use a ArrayList to store the strings for one path
        public List<String> wordBreak(String s, Set<String> dict) {
            if (s == null || s.length() == 0) return null;
            List<String> list = new ArrayList<String>();
            if (s.length() == 1) {
                list.add(s);
                return list;
            }
            
            int slow = 0, fast = slow + 1;
            List<String> result = new ArrayList<String>();
            while (fast <= s.length()) {
                String tmp = new String(s.substring(slow, fast));
                if (dict.contains(tmp)) {
                    list = new ArrayList<String>();
                    list.add(tmp);
                    helper(s, dict, list, fast);
                    result.add(buildString(list));
                }
                fast++;
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set<String> dict = new HashSet<String>();
        String [] a = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        for(String i : a)
            dict.add(i);
        List<String> res;
        res = result.wordBreak(s, dict);
        
        System.out.println(res);
    }
}

// I traced and got the results, but too slow~
/*  // time limit exceed: because I didn't use any dp ?
Last executed input:	"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
*/
