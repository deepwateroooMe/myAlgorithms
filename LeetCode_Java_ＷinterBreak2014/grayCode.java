import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class grayCode {
    public static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<Integer>();
            int bnd = (int)Math.pow(2.0, n);
            int tmp, one;
            for (int i = 0; i < bnd; i++) {
                tmp = i;
                one = tmp ^ (tmp >>> 1);
                res.add(one);
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 2;
        List<Integer> res = result.grayCode(n);
        
        System.out.println(res);
    }
}
