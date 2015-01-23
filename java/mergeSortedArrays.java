import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class mergeSortedArrays {
    public static class Solution {
        public void merge(int a[], int m, int b[], int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (j >= 0 && i >= 0) {
                if (a[i] < b[j]) {
                    a[k] = b[j];
                    --k;
                    --j;
                } else { // a[i] >= b[j]
                    a[k] = a[i];
                    --k;
                    --i;
                }
            }
            if (j >= 0)
                for (int x = 0; x <= k ; x++) 
                    a[x] = b[x];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {-6, -5, 1, 3, 5, 7, 0, 0, 0, 0, 0};
        int [] b = {-1, -2, 6, 8, 10};
        result.merge(a, 4, b, 5);
        
        for( int i : a)
            System.out.println(i);
    }
}
