import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class isPalindrome {
    public static class Solution {
        public boolean isPalindrome(int x) {
            if (x == null || x < 0 || x % 10 == 0) return false;
            
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int x = -321;
        boolean res = result.isPalindrome(x);
        System.out.println(res);
    }
}
