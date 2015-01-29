import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class partition {
    public static class Solution {
        public void dfs(String s, List<String> path, List<List<String>> res) {
            if (s.length() == 0) {
                res.add(new ArrayList<String>(path));
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
                    path.add(s.substring(0, i + 1));
                    dfs(s.substring(i + 1), path, res);
                    path.remove(path.size() - 1);
                } 
            }
            return;
        }
        
        public List<List<String>> partition0(String s) {
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>();
            dfs(s, path, res);
            return res;
        }

        public List<List<String>> partition(String s) {
            int n = s.length();
            boolean [][] p = new boolean[n][n];
            boolean [][] f = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) 
                for (int j = i; j < n; j++) 
                    p[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || p[i + 1][j - 1]);
            // crazy....
            List<List<String>> [] res = new ArrayList<List<String>>();
        

        }

    }


            List<List<String>> res = new ArrayList<List<String>>();
            List<String> path = new ArrayList<String>();
            
            
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
