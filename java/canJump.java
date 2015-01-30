import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class canJump {
    public static class Solution {
        public boolean canJump(int[] a) {
            if (a == null || a.length == 0 ||
                (a[0] == 0 && a.length != 1)) return false;
            else if (a.length == 1 && a[0] == 0) return true;

            int maxj = 0;   // from curr, the most idx can reach
            int lastj = 0;  // last pos 
            int i = 0;      // start from here
            while (maxj < a.length - 1) {  
                if (i + a[i] > maxj) maxj = i + a[i];  // new reach
                if (i >= lastj) {     // finsh one fragment
                    if (maxj <= lastj) return false;   // limited in range
                    lastj = maxj;     // start new frag
                }
                i++;
            }
            return true;

            /*
            int [] res = new int[a.length];
            res[0] = 0;
            for (int i = 1; i < a.length; i++)  {
                res[i] = Math.max(res[i - 1], a[i]) - 1;  
                if (res[i] < 0) return false;
            }
            return res[a.length - 1] >= 0;
            */
        }

        public boolean canJump(int[] a) {
            int reach = 1;
            for (int i = 0; i < reach && reach < a.length; i++) 
                reach = Math.max(reach, i + 1 + a[i]);
            return reach >= a.length;
        }

        public boolean canJump(int[] a) {
            if (a.length == 0) return true;
            int leftMost = a.length - 1;
            for (int i = a.length - 2; i >= 0; i--) 
                if (i + a[i] >= leftMost)
                    leftMost = i;
            return leftMost == 0;
        }

        public boolean canJump(int[] a) {
            int f[] = new int[a.length];
            for (int i = 1; i < a.length; i++) {
                f[i] = Math.max(f[i - 1], a[i - 1]) - 1;
                if (f[i] < 0) return false;
            }
            return f[a.length - 1] >= 0;
        }

    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {3, 2, 10, 4};
        boolean res = result.canJump(a);
        
        System.out.println(res);
    }
}
/*
  Input:	[2,0]
Output:	false
Expected:	true

  [0] true

  Input:	[0,1]
Output:	true
Expected:	false
*/
