import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class convertZigZag {
    public static class Solution {
        public String convert(String s, int nRows) {
            if (nRows == 1 || s.length() <= nRows) return s;
            StringBuffer result = new StringBuffer();
            StringBuffer [] tmp = new StringBuffer[nRows];
            for (int i = 0; i < nRows; i++) 
                tmp[i] = new StringBuffer();
            int start = 0;
            while (start < s.length()) {
                for (int i = 0; i < nRows && start < s.length(); i++) 
                    tmp[i].append(s.charAt(start++));
                for(int i = nRows-2; i >= 1 && start < s.length(); i--)
                    tmp[i].append(s.charAt(start++));
            }
            for (int i = 0; i < nRows; i++) 
                result.append(tmp[i]);
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "PAYPALISHIRING";
        String res = result.convert(s, 3);
        
        System.out.println(res);
    }
}
