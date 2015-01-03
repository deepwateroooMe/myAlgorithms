import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class canCompleteCircuit {
    public static class Solution {

        // can think through, but still logic feels slightly confusing
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas.length == 1) return gas[0] >= cost[0] ? 0 : -1;
            
            int [] ben = new int[gas.length];
            int total = 0;
            for (int i = 0; i < gas.length; i++) {
                ben[i] = gas[i] - cost[i];
                total += ben[i];
            }
            if (total < 0) return -1;

            total = 0;
            int result = 0;
            for (int i = 0; i < gas.length; i++) {
                total += ben[i];
                if (total < 0) {
                    total = 0;
                    result = (i == gas.length-1) ? 0 : i + 1;
                    continue;
                }
                if (i == gas.length - 1) {  // failed on minor mistake, i == gas.length -1!!!
                    i = 0;   
                    if (total > 0) {
                        for (int j = 0; j < result; j++) {
                            total += ben[j];
                            if (total < 0) {
                                total = 0;
                                result = (i == gas.length-1) ? 0 : i + 1;
                                break;  
                            } 
                        }
                        if (total >= 0) return result;
                    }
                }
            }
            return -1;  // still must have this one
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {3, 4, 5, 1, 2};
        int res = result.canCompleteCircuit(a, b);
        
        System.out.println(res);
    }
}
