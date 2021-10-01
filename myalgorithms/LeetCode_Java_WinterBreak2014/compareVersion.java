import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class compareVersion {
    public static class Solution {
        public int compareVersion(String version1, String version2) {
            String [] one = version1.split("\\.");
            String [] two = version2.split("\\.");
            int [] ione = new int[one.length];
            int [] itwo = new int[two.length];
            for (int i = 0; i < one.length; i++) {
                ione[i] = Integer.parseInt(one[i]);
            }
            for (int i = 0; i < two.length; i++) {
                itwo[i] = Integer.parseInt(two[i]);
            }
            for (int i = 0; i < one.length && i < two.length; i++) {
                if (ione[i] == itwo[i]) {
                    continue;
                } else if (ione[i] > itwo[i]) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (one.length < two.length) {
                for (int i = one.length; i < two.length; i++) {
                    if (itwo[i] > 0) {
                        return -1;
                    }
                }
                return 0;
            } else {
                for (int i = two.length; i < one.length; i++) {
                    if (ione[i] > 0) {
                        return 1;
                    }
                }
                return 0;
            }
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        String s = "1.23";
        String t = "12.34";
        int res = result.compareVersion(s, t);
        System.out.println(res);
    }
}
