import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class {
    public static class Solution {
        /*
         * @param n: An integer
         * @return: True or false
         */
        public boolean checkPowerOf2(int n) {
            if (n <= 0) return false;
            while (n > 0) {
                if (n & 1 == 1) return false;
                else n >>= 1;
            }
            return true;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
