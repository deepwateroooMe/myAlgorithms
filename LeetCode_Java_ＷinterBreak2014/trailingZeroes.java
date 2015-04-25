import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class trailingZeroes {
    public static class Solution {
        // https://oj.leetcode.com/discuss/20025/whats-the-problem-of-this-log-solution-cannot-pass-two-cases
        public int trailingZeroes(int n) {
            if (n < 5) {
                return 0;
            }
            int cnt = 0;
            while (n / 5 > 0) {
                cnt += n / 5;
                n /= 5;
            }
            return cnt;
        }

        // not n, but n!, understand the question wrong
        public int trailingZeroes1(int n) {
            if (n == 0) {
                return 0;
            }
            int cntz = 0;
            while ((n & 1) == 0) {
                n >>= 1;
                cntz++;
            }
            int cntf = 0;
            while (n % 5 == 0) {
                n /= 5;
                cntf++;
            }
            return Math.min(cntz, cntf);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 1808548329;
        int res = result.trailingZeroes(n);
        System.out.println(res);
    }
}
