import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
//import java.util.Arrays.Sort;

public class nextPermutation {
    public static class Solution {
        public void swap(int [] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        public void nextPermutation(int[] a) {
            if (a == null || a.length < 2) return;
            int n = a.length - 1;
            int i = n;
            int j = n - 1;
            while (i >= 1) {
                while (j >= 0 && a[j] > a[i]) {
                    j--;
                    i--;
                } 
                if (j < 0 && i >= 1 ||
                    (j >= 0 && i >= 1 && a[j] == a[i] && i - j >= 1)) {
                    i--;
                    j = i - 1;
                } else if (j >= 0 && a[j] < a[i]) {
                    while (i <= n && a[i] > a[j]) i++;
                    swap(a, j, i - 1);
                    Arrays.sort(a, j + 1, n + 1); 
                    return;
                }
                if (i < 1) {
                    Arrays.sort(a);
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {5, 1, 1};
        int [] a = {2, 3, 0, 2, 4,1};
        
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");

        result.nextPermutation(a);

        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");
    }
}
/*
  Input:	[2,3,0,2,4,1]
Output:	[2,3,1,0,2,4]
Expected:	[2,3,0,4,1,2]

  Input:	[5,1,1]
Output:	[5,1,1]
Expected:	[1,1,5]

  Input:	[4,2,0,2,3,2,0]
Output:	[4,2,2,0,0,2,3]
Expected:	[4,2,0,3,0,2,2]

  Input:	[1,5,1]
Output:	[1,1,5]
Expected:	[5,1,1]

  Input:	[2,3,1]
Output:	[1,2,3]
Expected:	[3,1,2]

  Input:	[1,3,2]
Output:	[2,3,1]
Expected:	[2,1,3]
 */
