public class divideTwoInteger {
    public static class Solution {

        // https://oj.leetcode.com/discuss/11992/a-readable-java-implementation
        public int divide(int dividend, int divisor) {
            if (divisor == 1) return dividend;
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
            
            // use ngetive integers to avoid integer overflow
            if (dividend > 0)
                return -divide(-dividend, divisor);
            if (divisor > 0)
                return -divide(dividend, -divisor);
                        
            if (dividend > divisor)  // Trivial case 2: both negative, 0
                return 0;
            
            // Find the highest mult = (divisor * 2^shift) which is <= dividend
            // by shifting mult to the left without causing an overflow
            // at most log2|dividend| - log2|divisor| + 1 iterations

            int min_divisor = Integer.MIN_VALUE >> 1; // 2^(-31) >> 1
            int mult = divisor; // divisor * 2^shifts
            int shifts = 0;
            while (mult >= min_divisor && mult > dividend) {  
                mult <<= 1;
                ++shifts;
            }

            // compute the result by shifting mult to the right
            // at most (log2|dividend| - log2|divisor| + 1) iterations for the outer loop
            // at most (log2|dividend| - log2|divisor| + 1) iterations for the inner loop
            // (in total, not per outer iteration)
            int result = 0;
            int power = 1 << shifts; // 2^shifts
            while (dividend <= divisor) {
                shifts = 0;
                while (mult < dividend) {
                    mult >>= 1;
                    ++shifts;
                }
                dividend -= mult;
                power >>= shifts;
                result |= power;  // adds power to result
            }
            return result;
        }
    }
    
    public static void main(String[] args) {
        //int dividend = 2147483647;
        int dividend = -2147483648;
        int divisor = -1;
        Solution result = new Solution();
        int results = result.divide(dividend, divisor);
        
        System.out.print(results);
    }
}
