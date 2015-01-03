import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class singleNumber {
    public static class Solution {
        public int singleNumber(int[] A) {
            if (A.length == 1) return A[0];
            for (int i = 0; i < A.length/2; i++) {
                A[A.length/2] ^= A[i] ^ A[A.length-1-i];
            }
            return A[A.length/2];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {2, 2, 1};
        int res = result.singleNumber(a);
        
        System.out.println(res);
    }
}
