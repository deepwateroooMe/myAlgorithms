import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class intToRoman {
    public static class Solution {
        public String intToRoman(int num) {
            int radix [] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String symbol [] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            StringBuffer res = new StringBuffer();
            for (int i = 0; num > 0; i++) {
                int cnt = num / radix[i];
                num %= radix[i];
                for (; cnt > 0 ; --cnt)
                    res.append(symbol[i]);
            }
            return res.toString();
        }
        
        public String intToRoman0(int num) {
            // index        0    1    2    3    4    5    6
            char [] sym = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
            // value:       1    5    10   50   100  500  1000
            int scale = 1000;
            StringBuffer result = new StringBuffer();
            for (int i = 6; i >= 0; i -= 2) {
                int digit = num / scale;
                if (digit != 0) {
                    if (digit <= 3) {
                        for (int j = 0; j < digit; j++) 
                            result.append(sym[i]);    
                    } else if (digit == 4) {
                        result.append(sym[i]);
                        result.append(sym[i+1]);
                    } else if (digit == 5)
                        result.append(sym[i+1]);
                    else if (digit > 5 && digit <= 8) {
                        result.append(sym[i+1]);
                        for (int j = 0; j < digit-5; j++) 
                            result.append(sym[i]);
                    } else { // == 9
                            result.append(sym[i]);
                            result.append(sym[i+2]);
                    }
                }
                num = num % scale;
                scale /= 10;
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int a = 3999;
        String res = result.intToRoman(a);
        
        System.out.println(res);
    }
}
