import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class sortColors {
    public static class Solution {
        public void swap(int [] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        public void sortColors(int[] a) {
            if (a == null || a.length < 2) return;
            else if (a.length == 2) {
                if (a[0] <= a[1]) return;
                else {
                    swap(a, 0, 1);
                    return;
                }
            }

            int n = a.length;
            int i = 0;
            int k = n - 1;
            int j = i + 1;
            while (j < k) {
                if (a[i] == 2) {
                    swap(a, i, k);
                    --k;
                } else if (a[i] == 0) ++i;
                while (a[j] < a[i]) {
                    swap(a, i, j);
                    if (a[i] == 0){
                        ++i;
                        j = i + 1;
                    } else if (a[j] == 2) {
                        swap(a, j, k);
                        --k;
                    } else j++;
                }
                while (j <= k && (a[j] >= a[i] || a[j] == a[j - 1])) {
                    if (a[j] == 2) {
                        swap(a, j, k);
                        --k;
                        if (a[j] < a[i]) {
                            swap(a, i, j);
                            ++i;
                        }
                    } else j++;
                }
                if (j <= k && a[j] < a[i]) {
                    swap(a, i, j);
                    ++i;
                    j = i + 1;
                }

                System.out.println("i: " + i);
                System.out.println("j: " + j);
                System.out.println("k: " + k);
                System.out.println("");
                
                if (a[i] > a[j]) {
                    swap(a, i, j);
                    ++i;
                    j = i + 1;
                }
            }

            
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {2, 1, 1, 2, 2, 2, 2};//
        int [] a = {1, 0, 0};
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
/*
  Input:	[1,0,0]
Output:	[0,1,0]
Expected:	[0,0,1]

  Input:	[1,2,0]
Output:	[1,0,2]
Expected:	[0,1,2]
*/
