#include <iostream>
#include <limits.h>
using namespace std;

double pow(double x, int n) {

    if (n == 0 || x-1.0000 < 0.00000001) return 1.0;
    else if (n == 1) return x;
    else if (n == -1) return -x;
    else if (n == 2) return x*x;
    else if (n == -2) return (1/x)*(1/x);

    if (x - 0.00001 && n >= INT_MAX) return 0;
    else if (x - 0.99999 < 0.00001 && n >= 10000) return 1;
    
    int a;
    double mid;

    if (n > 2) {    
        double middle[n];
        if (x > 0.0000001) mid = x;
        else mid = -x;
        middle[0] = mid;
        middle[1] = mid*mid;
        a = 2;
        while (a < n){
            middle[a] = middle[a-1]*mid;
            a++;
        }
        return middle[n-1];        
    } else if (n < -2) {
        double middle[-n];
        if (x > 0.0000001) mid = 1/x;
        else mid = -1/x;
        middle[0] = mid;
        middle[1] = mid*mid;
        a = -2;
        while (a > n){
            middle[-a] = middle[-a+1]*mid;
            a--;
        }
        return middle[-n-1];
    }

}

int main() 
{
    double x = 34.00515;
    int n = -3;
    cout << pow(x, n) << endl;
    cout << (1/x)*(1/x)*(1/x) << endl;
    
    return 0;
}
