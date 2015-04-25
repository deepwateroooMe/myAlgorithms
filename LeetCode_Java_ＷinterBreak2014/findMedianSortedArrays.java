import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findMedianSortedArrays {
    public static class Solution {
        public int helper(int [] a, int [] b, int k, int i, int j, int x, int y) {
            int m = a.length;
            int n = b.length;
            if (j == i) return b[x + k];
            if (y == x) return a[i + k];
            int mida = (i + j) / 2;
            int midb = (x + y) / 2;
            int lena = mida - i;
            int lenb = midb - x;
            if (b[midb] >= a[mida]) {
                if (k <= lena + lenb) 
                    return helper(a, b, k, i, j, x, midb);
                else
                    return helper(a, b, k - lena - 1, mida + 1, j, x, y);
            } else {
                if (k <= lena + lenb) {
                    return helper(a, b, k, i, mida, x, y);
                } else {
                    return helper(a, b, k - lenb - 1, i, j, midb + 1, y);
                }
            }
        }
        
        public double findMedianSortedArrays(int a[], int b[]) {
            int m = a.length;
            int n = b.length;
            if ((m + n) % 2 == 0)
                return (helper(a, b, (m + n) / 2, 0, m, 0, n) +
                        helper(a, b, (m + n) / 2 - 1, 0, m, 0, n)) / 2.0;
            else
                return helper(a, b, (m + n) / 2, 0, m, 0, n);
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 3, 5, 5};
        int [] b = {2, 4, 6, 8};
        double res = result.findMedianSortedArrays(a, b);
        
        System.out.println(res);
    }
}
