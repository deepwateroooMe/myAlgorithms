import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class backPack {
    public static class Solution {
        /**
         * @param m: An integer m denotes the size of a backpack
         * @param A: Given n items with size A[i]
         * @return: The maximum size
         */
        public int findIdx(int [] a, int val) {
            int bgn = 0, end = a.length - 1;
            while (bgn < end) {
                int mid = bgn + (end - bgn) / 2;
                if (a[mid] == val) return mid;
                if (a[mid] < val) bgn = mid + 1;
                else end = mid - 1;
            }
            if (bgn == end && a[bgn] == val) return bgn;
            return -1;
        }
        
        public int backPack(int m, int[] A) {
            Arrays.sort(A);
            int j = A.length - 1;
            if (A[0] > m || A[A.length - 1] < 0) return 0;
            if ( A[A.length - 1] < m) j = A.length - 1;
            else j = findIdx(A, m);
            System.out.println("j: " + j);
            /*
            while (j >= 0 && A[j] > m) j--;
            if (A[j] == m) return m;
            */
            int res = 0;
            for (int i = 1; i < Math.pow(2, j + 1); i++) {
                int k = i;
                int tmp = 0;
                int cnt = 0;
                while (k > 0) {
                    if ((k & 1) == 1) {
                        tmp += A[cnt];
                    }
                    ++cnt;
                    k = (k >> 1);
                }
                if (tmp <= m && tmp > res)
                    res = tmp;
            }
            return res;
        }
    }

    public static void main(String[] args){
        Solution result = new Solution();
int [] a = {828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388};
int b = 5000;
int res = result.backPack(b, a);

        System.out.println(res);
    }
}
/*
  5000, [828,125,740,724,983,321,773,678,841,842,875,377,674,144,340,467,625,916,463,922,255,662,692,123,778,766,254,559,480,483,904,60,305,966,872,935,626,691,832,998,508,657,215,162,858,179,869,674,452,158,520,138,847,452,764,995,600,568,92,496,533,404,186,345,304,420,181,73,547,281,374,376,454,438,553,929,140,298,451,674,91,531,685,862,446,262,477,573,627,624,814,103,294,388]
*/
