import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
//import java.lang.AbstractStringBuilder;

public class fractionToDecimal {
    public static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            StringBuffer result = new StringBuffer();
            if (denominator == 0) {
                return "";
            }
            if ((numerator > 0 && denominator < 0)
                || (numerator < 0 && denominator > 0)) {
                result.append('-');
            }
            long num = Math.abs((long)numerator);
            long den = Math.abs((long)denominator);
            result.append((num / den));
            if (num % den == 0) {
                return result.toString();   
            }

            result.append('.');
            Map<Long, Integer> hash = new HashMap<Long, Integer>();
            long remainder;
            for (remainder = num % den; remainder > 0; remainder %= den) {
                if (hash.containsKey(remainder)) {
                    result.insert(hash.get(remainder), "(");  // insert overload function '('
                    result.append(')');
                    break;
                }
                hash.put(remainder, result.length());
                remainder *= 10;
                result.append(remainder / den);
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String res = result.fractionToDecimal(2, 6);
        System.out.println(res);
    }
}
