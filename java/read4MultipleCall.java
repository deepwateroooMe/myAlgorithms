import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class read4MultipleCall {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    
    public static class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        // don't like this question, too confusing~~~
        // https://oj.leetcode.com/discuss/19581/clean-accepted-java-solution
        // The key is to store memorized variable in the class level and remember
        // offset position and remaining number of elements.
        private int offset = 0;
        private int remaining = 0;
        private boolean isEndOfFile = false;
        private char[] buffer = new char[4];  // store the currently read buffer <= 4
        
        public int read(char[] buf, int n) {
            int readBytes = 0;
            while (readBytes < n && (remaining != 0 || !isEndOfFile)) {
                int readsize = 0;
                if (remaining != 0) {
                    readsize = remaining;
                } else {
                    offset = 0;
                    readsize = read4(buffer);
                    if (readsize != 4) {
                        isEndOfFile = true;
                    }
                }
                int length = Math.min(n - readBytes, readsize);
                for(int i = offset; i < offset + length; i++) {
                    buf[readBytes++] = buffer[i];
                }
                remaining = readsize - length;
                if (remaining != 0) {
                    offset += length;
                }
            }
            return readBytes;
        }
    };

    public static void main(String[] args){
        Solution result = new Solution();
        System.out.println(result);
    }
}
