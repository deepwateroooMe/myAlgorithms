import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class generateparenthesis {
    public static class Solution {
        public void generate(List<String> res, int n, StringBuffer tmp, int left, int right) {
            if (left < 0 || right < left) return;
            if (left == 0 && right == 0) { 
                res.add(tmp.toString());
                return;
            } else {
                if (left > 0) 
                    generate(res, n, new StringBuffer(tmp).append("("), left - 1, right);
                if (right > left) 
                    generate(res, n, new StringBuffer(tmp).append(")"), left, right - 1);
            }
        }
        
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            if (n > 0) 
                generate(res, n, new StringBuffer(), n, n);
            return res;
        }

        public void generate(List<String> res, int n, StringBuffer one, int left, int right) {
            StringBuffer tmp = new StringBuffer(one);
            if (left == n) {
                for (int i = 0; i < n - right; i++)
                    tmp.append(")");
                res.add(tmp.toString());
                return;
            }
            generate(res, n, new StringBuffer(one).append("("), left + 1, right);
            if (left > right)
                generate(res, n, new StringBuffer(one).append(")"), left, right + 1);
        }
        
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            if (n > 0)
                generate(res, n, new StringBuffer(), 0, 0);
            return res;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 3;
        List<String> res = result.generateParenthesis(n);
        
        System.out.println(res);
    }
}

/*
  Input:	1
  Output:	["()","()"]
  Expected:	["()"]
*/
