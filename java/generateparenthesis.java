import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class generateparenthesis {
    public static class Solution {
        public void mygenerate(List<String> res, int n, StringBuffer tmp, int left, int right) {
            StringBuffer one = new StringBuffer();
            StringBuffer two = new StringBuffer();
            one.append(tmp);
            two.append(tmp);
            if (left < 0 || right < left) return;
            if (left == 0 && right == 0) { // done one possible result
                res.add(one.toString());
                return;
            } else {
                if (left > 0) {
                    one.append('(');
                    mygenerate(res, n, one, left - 1, right);
                }
                if (right > left) {  //  print ')
                    //one.append(')');
                    two.append(')');
                    mygenerate(res, n, two, left, right - 1);
                }
            }
        }
        
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<String>();
            if (n == 1) {
                res.add("()");
                return res;
            }
            int left = 0, right = 0;
            StringBuffer tmp = new StringBuffer();
            mygenerate(res, n, tmp, n, n);
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
