import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class reverseInteger {
    public static class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if (Math.abs(res) > 214748364) return 0;
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int x = 1000000003;
        int res = result.reverse(x);
        
        System.out.println(res);
    }
}
