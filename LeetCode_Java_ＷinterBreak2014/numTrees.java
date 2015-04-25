import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class numTrees {
    public static class Solution {
        public int numTrees(int n) {
            int [] cnt = new int[n + 1];
            cnt[0] = 1; // empty element
            cnt[1] = 1; // one element
            /*
              when n == 3:
              Count[3] = Count[0]*Count[2]  (1为根)
                       + Count[1]*Count[1]  (2为根)
                       + Count[2]*Count[0]  (3为根)
             */
            for (int i = 2; i <= n ; i++) {
                for (int j = 0; j < i; j++) {
                    cnt[i] += cnt[j]*cnt[i - 1 - j];
                }
            }
            return cnt[n];
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int n = 3;
        int res = result.numTrees(n);
        
        System.out.println(res);
    }
}
