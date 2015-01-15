import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class removeDuplicates {
    public static class Solution {
        public void myswap(int [] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        
        public int removeDuplicates(int[] a) {
            if (a == null || a.length == 0) return 0;
            else if (a.length == 1) return 1;
            else if (a.length == 2) return a[0] == a[1] ? 1 : 2;
            int i = 0;
            int j = i + 1;
            int end = a.length - 1;
            while (end >= 1 && a[end - 1] == a[end]) --end;
            if (end == 0) return 1;
            System.out.println("end 0: " + end);
            while (j < end) {
                while (j < end && a[j] == a[i]) {
                    if (j == end) return i + 1;
                    else if (a[j] == a[end]) {
                        --end;
                        while (end >= 0 && a[end] == a[j]) --end;
                    }
                    System.out.println("j: " + j);
                    System.out.println("end: " + end);
                    if (end <= i) return i + 1;
                    myswap(a, j, end);

                    // no no no
                    while (j < end && a[j] > a[j + 1]) {
                        myswap(a, j, j + 1);
                        ++j;
                    }
System.out.println("j: " + j);
                    while (end >= 1 && a[end - 1] == a[end])
                        --end;
                    --end;
                    while (end >= 1 && a[end - 1] == a[end])
                        --end;
                    System.out.println("end 1: " + end);
                    if (j == end) return end + 1;
                    ++i;
                    ++j;
                }
                while (j < end && a[j] != a[i]) {
                    if (a[i] > a[j]) myswap(a, i, j);
                    ++i;
                    ++j;
                }
            }
            System.out.println("j: " + j);
            System.out.println("end: " + end);
            if (j == end) {
                if (a[i] > a[j]) 
                    myswap(a, i, j);
                return (a[j] == a[i]) ? i + 1 : i + 2;   
            }
            return end + 1;
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
