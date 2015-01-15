import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class addBinary {
    public static class Solution {
        public char myadd(char a, char b) {
            if ((a == '1' && b == '1') || (a == '0' && b == '0')) return '0';
            else return '1';
        }
    
        public String addBinary(String a, String b) {
            if (a == null || a.length() == 0) return b;
            if (b == null || b.length() == 0) return a;
            StringBuffer res = new StringBuffer();
            int i = a.length() - 1;
            int j = b.length() - 1;
            char leftover = '0', tmp;
            while (i >= 0 && j >= 0) {
                if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                    res.insert(0, leftover);
                    leftover = '1';
                } else {
                    tmp = myadd(a.charAt(i), b.charAt(j));
                    res.insert(0, myadd(tmp, leftover));
                    if (tmp == '1' && leftover == '1')
                        leftover = '1';
                    else
                        leftover = '0';
                }
                --i;
                --j;
            }
            String left = i >= 0 ? a.substring(0, i+1) : b.substring(0, j + 1);
            i = left.length() - 1;
            
            while (i >= 0) {
                tmp = myadd(left.charAt(i), leftover);
                res.insert(0, tmp);
                if (left.charAt(i) == '1' && leftover == '1')
                    leftover = '1';
                else
                    leftover = '0';
                --i;
            }
            if (leftover == '1') res.insert(0, leftover);
            return res.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String a = "11";
        String b = "1";
        String res = result.addBinary(a, b);
        
        System.out.println(res);
    }
}
