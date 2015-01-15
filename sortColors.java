import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortColors {
    public static class Solution {
        public void myswap(int [] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        public void sortColors(int[] a) {
            if (a == null || a.length < 2) return;
            else if (a.length == 2) {
                if (a[0] <= a[1]) return;
                else {
                    myswap(a, 0, 1);
                    return;
                }
            }

            int i = 0, j = a.length - 1;
            int m = i + 1, n = j - 1;
            if (a[i] != 0 && a[m] != 0) { // a[0] = 0
                while (m < a.length && a[m] != 0) m++;
                if (m == a.length);
                else {
                    myswap(a, i, m);
                    m = i + 1;
                }
            }
            if (m == a.length) { // a[0] = 1
                if (a[i] == 1) m = i + 1;
                else if (a[i + 1] == 1) {
                    myswap(a, i, i + 1);
                    m = i + 1;
                } else {                
                    while (m < a.length && a[m] != 1) m++;
                    //System.out.println("m: " + m);
                    if (m < a.length) {
                        myswap(a, i, m);
                        m = i + 1;
                    }
                }
            }
            if (m == a.length) return;
            /*
            if (a[j] != 2 && a[n] != 2) { // a[j] = 2
                while (n >= 0 && a[n] != 2) n--;
                if (n >= 0) {
                    myswap(a, j, n);
                    n = j - 1;
                }
            }
            */
            while ( m < n) {
                if (a[m] != a[i])
            }

        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {2, 1, 1, 2, 2, 2, 2};//
        int [] a = {1, 2, 2, 1, 0, 0, 0, 2, 2, 1, 1, 1};
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");

        result.sortColors(a);
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");

    }
}
