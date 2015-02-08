import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class mergeSortedArrayII {
    public static class Solution {
        /**
         * @param A: sorted integer array A which has m elements, 
         *           but size of A is m+n
         * @param B: sorted integer array B which has n elements
         * @return: void
         */
        public void mergeSortedArray(int[] a, int m, int[] b, int n) {
            int i = m - 1, j = n - 1, k = m + n - 1;
            while (i >= 0 && j >= 0) {
                if (a[i] <= b[j]) a[k--] = b[j--];
                else a[k--] = a[i--];
            }
            while (j >= 0) a[k--] = b[j--];
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = new int[6];
        int [] c = {1, 2, 3, 4};
        for (int i = 0; i < 4; i++) {
            a[i] = c[i];
        }
        int [] b = {-2, -1};
        result.mergeSortedArray(a, 4, b, 2);
        System.out.println("");
        for(int val : a)
            System.out.print(val + ", ");
        System.out.println("");
    }
}
