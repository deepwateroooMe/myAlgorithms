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
                while (k >= 0 && a[k] == 2) --k;
                if (k < 0) return;
                if (k > 0 && a[i] == 2) {
                    swap(a, i, k);
                    --k;
                }
                if (a[k] == 0 && a[0] != 0) {
                    swap(a, 0, k);
                    i = 1;
                    j = i + 1;
                }
                while (j < n && a[i] == 0) {
                    ++i;
                    j = i + 1;
                } 
                while (j < n && a[j] < a[i]) {
                    swap(a, i, j);
                    if (a[i] == 0) {
                        ++i;
                        j = i + 1;
                    } else j++;
                }
                while (j < n && j < k && a[j] >= a[i]) {
                    if (a[j] == 2) {
                        while (k >= 0 && a[k] == 2) --k;
                        if (k >= 0) {
                            swap(a, j, k);
                            --k;
                            if (a[j] < a[i]) {
                                swap(a, i, j);
                                ++i;
                                j = i + 1;
                            }
                            if (k < 0) return;
                        }
                    }
                    if (j > i + 1 && a[j] == a[i]) {
                        swap(a, i + 1, j);
                    }

                    System.out.println("");
                    for(int x : a)
                        System.out.print(x + ", ");
                    System.out.println("");
                    System.out.println("j 0: " + j);
                    System.out.println("k: " + k);
                    System.out.println("a[i]: " + a[i]);
                    System.out.println("a[k]: " + a[k]);

                    if (j < k && a[j] >= a[0] && a[j] <= a[k]) j++;
                    else if (j < k && a[j] > a[k]) {
                        if (a[i] > a[k]) {
                            swap(a, i, k);
                            i++;
                            j = i + 1;
                        }
                    }
                    if (a[j] == a[k] && j == k - 1) return;
                    
                    System.out.println("");
                    for(int x : a)
                        System.out.print(x + ", ");
                    System.out.println("");

                }
                if (j < k && a[j] > a[k]) {
                    swap(a, j, k);
                    --k;
                } 
            }
            return;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        //int [] a = {2, 1, 1, 2, 2, 2, 2};//
        int [] a = {2, 2, 1, 2, 1, 1, 1, 0, 0, 2, 1, 0, 2, 1, 2, 2, 1, 1, 1, 1, 1, 0, 2, 0, 2, 0, 2, 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 0, 0, 2, 1, 0, 1, 0, 2, 2, 1, 2, 1, 1, 2, 1, 1, 0, 0, 2, 1, 0, 0};
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
  Time Limit ExceededMore Details  // don't want to touch is any more ~~!!!
  Last executed input:	[2,2,1,2,1,1,1,0,0,2,1,0,2,1,2,2,1,1,1,1,1,0,2,0,2,0,2,2,1,0,2,1,0,2,1,2,0,0,0,0,2,1,1,2,0,1,2,2,0,0,2,2,0,1,0,1,0,0,1,1,1,0,0,2,2,2,1,0,0,2,1,0,1,0,2,2,1,2,1,1,2,1,1,0,0,2,1,0,0]

  Time Limit ExceededMore Details 
  Last executed input:	[1,2,2,2,2,0,0,0,1,1]

  Time Limit ExceededMore Details 
  Last executed input:	[0,0,1,0,1,1]

  Time Limit ExceededMore Details 
  Last executed input:	[1,1,0]

  Time Limit ExceededMore Details 
  Last executed input:	[0,0,1]

  Input:	[0,2,1]
  Output:	[0,2,1]
  Expected:	[0,1,2]

  Input:	[1,0,0]
  Output:	[0,1,0]
  Expected:	[0,0,1]

  Input:	[1,2,0]
  Output:	[1,0,2]
  Expected:	[0,1,2]
*/
