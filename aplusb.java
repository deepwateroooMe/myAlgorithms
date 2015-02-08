import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class aplusb {
    public static class Solution {
        /*
         * param a: The first integer
         * param b: The second integer
         * return: The sum of a and b
         */
        // don't know how to do it
        public int aplusb(int a, int b) {
            int res = ((a & b) & 1) == 1 ? 0 : 1;
            a >>= 1;
            b >>= 1;
            System.out.println("a: " + a);
System.out.println("b: " + b);

            while (a > 0 || b > 0) {
                res <<= 1;
                System.out.println("res: " + res);

                res += ((a & b) & 1);
                a >>= 1;
                b >>= 1;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int a = 1;
        int b = 2;
        int res = result.aplusb(a, b);
        System.out.println(res);
    }
}
