
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicatesArrayII {
    public static class Solution {
    public int removeDuplicates(int[] a) {
            //if (a.length == 0) return 0;
            int idx = 0;
            for (int i = 0; i < a.length; i++) {
                if (i > 0 && i < a.length - 1 && a[i] == a[i - 1] && a[i] == a[i + 1])
                    continue;
                a[idx++] = a[i];
            }
            return idx;
        }
        
        public int removeDuplicates(int[] a) {
            if (a.length == 0) return 0;
            int ocnt = 1;  // occurance count
            int idx = 0;
            for (int i = 1; i < a.length; i++) {
                if (a[idx] == a[i]) {
                    if (ocnt < 2) {
                        a[++idx] = a[i];
                        ocnt++;
                    }
                } else {
                    a[++idx] = a[i];
                    ocnt = 1;
                }
            }
            return idx + 1;
        }
        
        public int removeDuplicates0(int[] a) {
            if (a == null || a.length == 0) return 0;
            else if (a.length == 1) return 1;
            else if (a.length == 2) return 2;
            
            int i = 0;
            int j = i + 1;
            int n = a.length;
            int cnt = 1;
            while (j < n) {
                while (j < n && a[j] == a[i] && cnt < 2) {
                    ++cnt;
                    j++;
                    ++i;
                }
                while (j < n && a[j] == a[i] && cnt == 2) j++;
                if (j == n) return i + 1;

                a[++i] = a[j++];
                if (a[i] == a[i - 1]) cnt = 2;
                else cnt = 1;

                System.out.println("i: " + i);
                System.out.println("j: " + j);

                while (j < n && (a[j] != a[j - 1] || (a[j] == a[j - 1] && cnt < 2))) {
                    a[++i] = a[j++];
                    if (a[i] == a[i - 1]) cnt = 2;
                    else cnt = 1;
                }
            }
            return i + 1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {0, 0, 0, 0, 0, 1, 2, 2, 3, 3, 4, 4};
        System.out.println("");
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");
        
        int res = result.removeDuplicates(a);
        System.out.println(res);
        for(int i : a)
            System.out.print(i + ", ");
        System.out.println("");
    }
}
/*
  Input:	[0,0,0,0,0,1,2,2,3,3,4,4]
  Output:	[0,0,0,0,1,2,2,3,4]
  Expected:	[0,1,2,3,4]

  Input:	[-3,-3,-2,-1,-1,0,0,0,0,0]
  Output:	[-3,0,-2,-1]
  Expected:	[-3,-2,-1,0]

  Input:	[-3,-1,-1,0,0,0,0,0,2]
  Output:	[-3,-1,2,0]
  Expected:	[-3,-1,0,2]

  Input:	[1,1,1,2]
  Output:	[1,2,1]
  Expected:	[1,2]

  Input:	[-1,0,0,0,0,3,3]
  Output:	[-1,0,3,0,3]
  Expected:	[-1,0,3]

  Input:	[1,1,2,3]
  Output:	[1,3,2]
  Expected:	[1,2,3]

  Input:	[1,2,2]
  Output:	[1,2,2]
  Expected:	[1,2]

  Runtime Error Message:	Line 4: java.lang.ArrayIndexOutOfBoundsException: -1
  Last executed input:	[1,1,1]
*/
