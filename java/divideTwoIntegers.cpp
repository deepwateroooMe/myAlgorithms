#include <iostream>
using namespace std;

int divide(int dividend, int divisor) {
    
    if (dividend + divisor == 0) return -1;
    if (divisor == 1) return dividend;
    if (divisor == -1) return -dividend;
    if (dividend < 0 && dividend > divisor ) return 0;
    if (dividend > 0 && dividend < divisor ) return 0;
    
    bool neg = false;
    if ( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) neg = true;
    if (dividend < 0) dividend = -dividend;
    if (divisor < 0) divisor = -divisor;

    int result = 0;
    int base = 1;
    int tmpDivisor = divisor;

    while (dividend >= tmpDivisor) {
        dividend -= tmpDivisor;
        result += base;
        tmpDivisor += tmpDivisor;
        base += base;
    }
    
    if (dividend != 0) {     
        while (dividend < tmpDivisor && tmpDivisor > divisor) {
            tmpDivisor -= divisor;
            base--;
        }
        result += base;
    }

    if (neg) return -result;
    return result;
    
}

int main() 
{
    int dividend = 2147483647;
    int divisor = 3;
    cout << divide(dividend, divisor) << endl;
    
    return 0;
}
