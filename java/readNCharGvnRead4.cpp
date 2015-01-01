#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int read(char *buf, int n) {
        int cnt = read4(buf);
        if (n == 0) return 0;
        else if (cnt < 4) return (cnt < n) ? cnt : n;
        else if (n <= 4) return n;
        
        int result = 0;
        while (cnt == 4 && result < n) {
            result += 4;
            buf += 4;
            cnt = read4(buf);
        }
       
        result += (cnt > n-result) ? n-result : cnt;
        return result;
    }
};

int main(){


    return 0;
}
