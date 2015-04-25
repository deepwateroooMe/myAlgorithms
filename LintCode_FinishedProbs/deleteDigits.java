import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class deleteDigits {
    public static class Solution {
        /**
         *@param A: A positive integer which has N digits, A is a string.
         *@param k: Remove k digits.
         *@return: A string
         */
        public String DeleteDigits(String s, int k) {
            if (k == 0) return s;
            int n = s.length();
            if (k == n) return "";
            StringBuffer tmp = new StringBuffer(s);
            int i = 1;
            while (tmp.length() > n - k ) {
                while (tmp.length() > n - k && i < tmp.length() - 1
                       && tmp.charAt(i) > tmp.charAt(i - 1) && tmp.charAt(i) < tmp.charAt(i + 1)) {
                    i++;   
                }
                if (tmp.charAt(i) > tmp.charAt(i - 1) && tmp.charAt(i) > tmp.charAt(i + 1)) {
                    tmp.deleteCharAt(i);
                }
            }
            if (tmp.length() == n - k)
                return tmp.toString();
            return tmp.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "254193";
        int b = 1;
        String res = result.DeleteDigits(s, b);
        System.out.println(res);
    }
}
