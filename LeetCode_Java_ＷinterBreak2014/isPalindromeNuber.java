import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isPalindromeNuber {
    public static class Solution {
        public boolean isPalindrome(int x) {
            if ( x < 0) return false;
            else if (x >= 0 && x < 10)  return true;
            
            int bgn = 1;
            int tmp = x;
            while (tmp / 10 > 0) {
                tmp /= 10;
                bgn *= 10;   
            }
            while (x % 10 == x / bgn) {
                x %= bgn;
                x /= 10;
                bgn /= 100;
                if (bgn == 0) break;
            }
            if (x == 0 && bgn == 0) return true;
            else if (x % 10 != x / bgn) return false;
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int x = 10;
        boolean res = result.isPalindrome(x);
        System.out.println(res);
    }
}
