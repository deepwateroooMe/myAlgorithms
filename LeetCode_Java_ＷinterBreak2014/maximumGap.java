import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class maximumGap {
    public static class Solution {

        // https://oj.leetcode.com/discuss/18499/bucket-sort-java-solution-with-explanation-o-time-and-space
        public int maximumGap(int[] num) {
            if (num == null || num.length < 2) {
                return 0;
            } 

            // find min and max first
            int imax = num[0];
            int imin = num[0];
            for (int i : num) {
                imin = Math.min(i, imin);
                imax = Math.max(i, imax);
            }

            // the mininum possible gap, ceiling of the integer division
            int gap = (int)Math.ceil((double)(imax-imin)/(num.length-1));
            int[] bucketsMin = new int[num.length-1];// store the min value in the bucket
            int[] bucketsMax = new int[num.length-1];// store the max value in the bucket
            Arrays.fill(bucketsMin, Integer.MAX_VALUE);
            Arrays.fill(bucketsMax, Integer.MIN_VALUE);

            // put numbers into buckets
            for(int i : num) {
                if (i == imin || i == imax) {
                    continue;
                }
                int idx = (i - imin) / gap; // index of right position in the buckets
                bucketsMin[idx] = Math.min(i, bucketsMin[idx]);
                bucketsMax[idx] = Math.max(i, bucketsMax[idx]);
            }

            // scan the buckets for the max gap
            int maxGap = Integer.MIN_VALUE;
            int prev = imin;
            for (int i = 0; i < num.length-1; i++) {
                if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                    continue;
                }
                maxGap = Math.max(maxGap, bucketsMin[i]-prev);
                prev = bucketsMax[i];
            }
            maxGap = Math.max(maxGap, imax-prev);
            return maxGap;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
        int[] arr = {3, 6, 9, 1};
        int res = result.maximumGap(arr);
        System.out.println(res);
    }
}
