import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class multiply {
    public static class Solution {
        public int getVal(char x) {
            switch (x) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            }
            return 0;
        }

        public String myMul(String a, char s) {
            StringBuffer res = new StringBuffer();
            int b = getVal(s);
            int leftover = 0;
            int curr = 0;
            for (int i = a.length() - 1; i >= 0 ; i--) {
                curr = (getVal(a.charAt(i)) * b + leftover) % 10 ;
                leftover = (getVal(a.charAt(i)) * b + leftover) / 10;
                res.insert(0, curr);
            }
            if (leftover > 0)
                res.insert(0, leftover);
            return res.toString();
        }

        public String myAdd(StringBuffer a, StringBuffer b) {
            StringBuffer res;
            res = new StringBuffer(a.length() < b.length() ? a : b);
            a = a.length() < b.length() ? b : a; // long
            b = res;   // short
            int gap = a.length() - b.length();
            int leftover = 0;
            int curr = 0;
            res = new StringBuffer("");
            for (int i = b.length() - 1; i >= 0; i--) {
                curr = (getVal(a.charAt(i+gap)) + getVal(b.charAt(i)) + leftover) % 10;
                leftover = (getVal(a.charAt(i+gap)) + getVal(b.charAt(i)) + leftover) / 10;
                res.insert(0, curr);
            }
            for (int i = gap - 1; i >= 0; i--) {
                curr = (getVal(a.charAt(i)) + leftover) % 10;
                leftover = (getVal(a.charAt(i)) + leftover) / 10;
                res.insert(0, curr);
            }
            if (leftover > 0)
                res.insert(0, leftover);
            return res.toString();
        }
        
        public String multiply(String num1, String num2) {
            if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
            if (num1.equals("0") || num2.equals("0")) return "0";  // forgot "0" case
            StringBuffer res, tmp = new StringBuffer();
            String temp;
            res = new StringBuffer(num1.length() < num2.length() ? num1 : num2);
            num1 = num1.length() < num2.length() ? num2 : num1; // long
            num2 = res.toString();   // short
            for (int i = num2.length() - 1; i >= 0 ; i--) {
                temp = myMul(num1, num2.charAt(i));
                if (i == num2.length() - 1)
                    res = new StringBuffer(temp);
                else {
                    tmp = new StringBuffer(temp);
                    for (int j = 0; j < num2.length() - 1 - i; j++)
                        tmp.append('0');
                    res = new StringBuffer(myAdd(res, tmp));
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String a = "123";
        String b = "0";
        String res = result.multiply(a, b);
        
        System.out.println(res);
    }
}
