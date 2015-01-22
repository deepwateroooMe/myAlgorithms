import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class firstMissingPositive {
    public static class Solution {
        public void swap(int [] a, int i, int j) {        
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        public int firstMissingPositive(int[] a) {
            if (a == null || a.length == 0) return 1;
            if (a.length == 1) return a[0] == 1 ? 2 : 1;
            
            int n = a.length;
            boolean equl = false;
            int i;
            for ( i = 0; i < n; i++) {
                if (a[i] < 0) continue;
                if (a[i] == n) {
                    equl = true;
                    continue;
                }
                while ( (i == 0 || (i != 0 && a[i] != i))
                        && a[i] < n && a[i] > 0 ) {
                    swap(a, i, a[i]);
                    if (a[i] == n) {
                        equl = true;
                        break;
                    }
                    if ((a[i] > n || a[i] < 0) || (a[i] >= 0 && a[i] == a[a[i]]))
                        break; // to avoid infite loop
                }
            }
            for ( i = 1; i < n; i++) 
                if (a[i] != i) return i;
            if (equl || a[0] == n) return n + 1;
            else return n;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3};
        int res = result.firstMissingPositive(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[3]
Output:	2
Expected:	1

  Runtime Error Message:	Line 29: java.lang.ArrayIndexOutOfBoundsException: 3
Last executed input:	[1,2,3]

  Runtime Error Message:	Line 29: java.lang.ArrayIndexOutOfBoundsException: 1000
Last executed input:	[1,1000]

   Time Limit ExceededMore Details 
Last executed input:	[1,1]
 */
