import java.util.HashMap;
import java.util.Map;

public class readnCharGvnRead4 {
    /* The read4 API is defined in the parent class Reader4.
       int read4(char[] buf); */
    public static class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        public int read(char[] buf, int n) {
            char[] buffer = new char[4];
            boolean endOfFile = false;
            int result = 0;

            while (result < n && !endOfFile) {
                int cnt = read4(buffer);
                if (cnt != 4) {
                    endOfFile = true;
                }
                int length = Math.min(n - result, cnt);
                for(int i = 0; i < length; ++i) {
                    buf[result+i] = buffer[i];
                }
                result += length;
            }
            return result;
        }
        /*
        public int read(char[] buf, int n) {
            int cnt = read4(buf);
            if (n == 0) {
                return 0;   
            } else if (cnt < 4) {
                return (cnt < n) ? cnt : n;
            } else if (n <= 4) {
                return n;
            }

            int result = 0;
            while (cnt == 4 && result < n) {
                result += 4;
                // don't know how to move the buf here, applied there method instead
                //char[] tmp = Arrays.copyOfRange(buf, result-1, buf.length);
                //char[] tmp = Arrays.copyOfRange(buf, result, ((buf.length < n) ? buf.length : n));
                //char[] tmp = subarray(buf, result, ((buf.length < n) ? buf.length : n));
                cnt = read4(tmp);
            }
            result += (cnt > n - result) ? n - result : cnt;
            return result;
        } */
    }
        
    public static void main(String[] args) {
        Solution result = new Solution();
                
        //System.out.println(result.find(4));
        System.out.println(result.find(0));
        //System.out.println(result.find(7));
    }
}
