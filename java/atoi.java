import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class atoi {
    public static class Solution {

        private static final int maxdt = Integer.MAX_VALUE / 10;
        public int atoi(String str) {
            int i = 0, n = str.length();
            while (i < n && Character.isWhitespace(str.charAt(i))) i++;

            int sign = 1;
            if (i < n && str.charAt(i) == '+') i++;
            else if (i < n && str.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int val = 0;
            while (i < n && Character.isDigit(str.charAt(i))) {
                int dgt = Character.getNumericValue(str.charAt(i));
                //System.out.println("dgt: " + dgt);
                if (val > maxdt || val == maxdt && dgt >= 8) 
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                val = val * 10 + dgt;
                i++;
            }
            return sign * val;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "1000000003";
        int res = result.atoi(s);
        
        System.out.println(res);
    }
}
