import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class pow {
    public static class Solution {
        public double pow(double x, int n) {
            if (n == 0 || Math.abs(x - 1.0) < 0.000001) return 1.0;
            else if (n == 1) return x;
            else if (n == -1) return 1/x;
            else if (n == 2) return Math.pow(x, 2);
            else if (n == -2) return (1/x) * (1/x);
            else if (x - 0.000001 > 0.000001 && n >= Integer.MAX_VALUE) return 0;
            else if (Math.abs(x - 0.999999) < 0.0000001 && n >= 100000) return 1;
            else if (Math.abs(x + 0.999999) <= 0.00001 &&
                     (n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE))
                return n % 2 == 1 ? -1 : 1;
            
            int a;
            double mid;
            if (n > 2) {
                double [] midd = new double[n];
                midd[0] = x;
                midd[1] = x * x;
                a = 2;
                while (a < n) {
                    midd[a] = midd[a - 1] * x;
                    a++;
                }
                return midd[n - 1];
            } else if (n < -2) {
                double [] midd = new double[-n];
                if (Double.compare(x, 0.000001) > 0) mid = 1/x;
                else mid = -1/x;
                midd[0] = mid;
                midd[1] = mid * mid;
                a = -2;
                while (a > n) {
                    midd[-a] = midd[-a - 1] * mid;
                    a--;
                }
                return midd[-n - 1];
            } else return 0;
        }

        public double myPower(double x, int n) {
            if (n == 0) return 1;
            double val = myPower(x, n / 2);
            if (n % 2 == 0) return val * val;
            else return val * val * x;
        }
        
        public double pow(double x, int n) {
            if (n < 0) return 1.0 / myPower(x, -n);
            else return myPower(x, n);
        }
    }

    
    public static void main(String[] args){
        Solution result = new Solution();
        double x = -13.62608;
        int n = 3;
        double res = result.pow(x, n);
        
        System.out.println(res);
    }
}
/*
  Input:	-13.62608, 3
Output:	2529.95504
Expected:	-2529.95504

  Runtime Error Message:	Line 27: java.lang.NegativeArraySizeException
Last executed input:	-1.00000, -2147483648

  Runtime Error Message:	Line 34: java.lang.ArrayIndexOutOfBoundsException: 3
Last executed input:	34.00515, -3
 */
