import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class heapify {
    public static class Solution {
        /**
         * @param A: Given an integer array
         * @return: void
         */
        public void heapify(int[] A) {
            Arrays.sort(A);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3,2,1,4,5};
        result.heapify(a);
        System.out.println(res);
    }
}
