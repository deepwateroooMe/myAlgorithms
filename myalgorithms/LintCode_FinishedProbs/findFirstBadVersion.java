import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class findFirstBadVersion {
    public static class Solution {
        /**
         * public class VersionControl {
         *     public static boolean isBadVersion(int k);
         * }
         * you can use VersionControl.isBadVersion(k) to judge wether 
         * the kth code version is bad or not.
         */
        /**
         * @param n: An integers.
         * @return: An integer which is the first bad version.
         */
        public int findFirstBadVersion(int n) {
            if (VersionControl.isBadVersion(1)) return 1;
            if (!VersionControl.isBadVersion(n)) return -1;
            if (VersionControl.isBadVersion(n) && !VersionControl.isBadVersion(n - 1)) return n;
            int bgn = 2, end = n - 1;
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (VersionControl.isBadVersion(mid)) end = mid;
                else bgn = mid + 1;
            }
            return (VersionControl.isBadVersion(bgn)) ? bgn : -1;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();

        System.out.println(res);
    }
}
