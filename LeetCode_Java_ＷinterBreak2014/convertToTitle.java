import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class convertToTitle {
    public static class Solution {
        public String convertToTitle(int n) {
            StringBuffer result = new StringBuffer();
            while (n > 26) {
                if (n % 26 == 0) {
                    result.insert(0, 'Z');
                    n -= 26;
                } else {
                    result.insert(0, (char)(n % 26 + 'A' -1)); 
                    n -= n % 26;
                }
                n /= 26;
            }
            if (n > 0) {
                result.insert(0, (char)(n + 'A' -1));
            }
            return result.toString();
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int s = 52;
        String res = result.convertToTitle(s);
        System.out.println(res);
    }
}
