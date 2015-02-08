import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class hashCode {
    public static class Solution {
        /**
         * @param key: A String you should hash
         * @param HASH_SIZE: An integer
         * @return an integer
         */
        // change to be string manipulation to avoid overflow .... 
        public int hashCode(char[] key,int HASH_SIZE) {
            int n = key.length;
            long [] dp = new long[n];
            dp[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) dp[i] = dp[i + 1] * 33;
            long res = 0;
            for (int i = 0; i < n; i++) res += key[i] * dp[i];
            System.out.println("res: " + res);
System.out.println("Integer.MAX_VALUE % HASH_SIZE: " + Integer.MAX_VALUE % HASH_SIZE);

            return res > 0 ? (int)(res % HASH_SIZE)
                : HASH_SIZE + (int)(res % HASH_SIZE) - Integer.MAX_VALUE % HASH_SIZE;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "abcdefghijklmnopqrstuvwxyz";
        int n = 2607;
        int res = result.hashCode(s.toCharArray(), n);
        
        System.out.println(res);
    }
}
