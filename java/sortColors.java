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
            int n = a.length;
            int i = 0;
            int zEnd = -1;  // 0 end
            int tEnd = n;   // 2 end
            while (i < tEnd) {
                if (a[i] == 0 && i != ++zEnd) // first 0
                    swap(a, zEnd, i);
                else if (a[i] == 2 && i != --tEnd)
                    swap(a, i, tEnd);
                else i++;
            }
            return;
        }

        public void sortColors(int[] a) {
            int [] cnt = new int[3];
            for (int i = 0; i < a.length; i++) 
                cnt[a[i]]++;
            for (int i = 0, index = 0; i < 3; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    a[index++] = i;
                }
            }
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
