import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findMissingRanges {
    public static class Solution {

        private String getRange(int from, int to) {
            return (from == to) ? String.valueOf(from) : from + "->" + to;
        }
        
        public List<String> findMissingRanges(int [] vals, int bgn, int end) {
            List<String> ranges = new ArrayList<>();
            int prev = bgn - 1;
            for (int i = 0; i <= vals.length; i++) {
                int curr = (i == vals.length) ? end + 1 : vals[i];
                if (curr - prev >= 2) {
                    ranges.add(getRange(prev + 1, curr - 1));
                }
                prev = curr;
            }
            return ranges;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [] a = {1, 3, 50, 75};
        List<String> res = s.findMissingRanges(a, 0, 99);

        System.out.println(res);
    }
}