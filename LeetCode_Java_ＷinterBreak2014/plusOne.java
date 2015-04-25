import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class plusOne {
    public static class Solution {
        public int[] plusOne(int[] digits) {
            int [] res = null;
            StringBuffer s = new StringBuffer();
            int val = 1, rol = 0, tmp;
            for (int i = digits.length - 1; i >= 0 ; i--) {
                if (i == digits.length - 1) {
                    val  = (1 + rol + digits[i]) % 10;
                    rol = (1 + rol + digits[i]) / 10;
                    System.out.println("rol: " + rol);
                } else {
                    tmp = rol + digits[i];
                    rol = tmp / 10;
                    val  = tmp % 10;
                }
                s.insert(0, val);
                val = 0;
            }
            if (rol > 0)
                s.insert(0, rol);
            res = new int[s.length()];
            for (int i = 0; i < s.length(); i++)
                res[i] = s.charAt(i) - '0';
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {9, 9, 9};
        int [] res = result.plusOne(a);
        for (int i = 0; i < res.length; i++) {
            System.out.println("res[i]: " + res[i]);
        }
    }
}
