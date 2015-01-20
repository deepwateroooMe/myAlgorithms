import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class partition {
    public static class Solution {
        public void dfs(String s, List<String> one, List<List<String>> res) {
            if (s.length() == 0) {
                res.add(new ArrayList<String>(one));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                int bgn = 0;
                int end = i;
                while (bgn < end) {
                    if (s.charAt(bgn) == s.charAt(end)) {
                        bgn ++;
                        end --;
                    } else break;
                }
                if (bgn >= end) {
                    one.add(s.substring(0, i + 1));
                    dfs(s.substring(i + 1), one, res);
                    one.remove(one.size() - 1);
                } 
            }
            return;
        }
        
        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<List<String>>();
            if (s == null || s.length() == 0)  return res;
            List<String> one = new ArrayList<String>();
            dfs(s, one, res);
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "aab";
        List<List<String>> res = result.partition(s);
        
        System.out.println(res);
    }
}
