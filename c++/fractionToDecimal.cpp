#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <sstream>
#include <cstring>
#include <unordered_map>

using namespace std;

// change stringstream method to use to_string() function
// don't know why, fail this case, rethink about it tomorrow;
string fractionToDecimal(int numerator, int denominator) { 
    string result;
    if (denominator == 0) return "";
    if ( (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0) )
        result += '-'; 
    long num = abs((long)numerator);
    long den = abs((long)denominator);
    result += to_string(num / den);
    if (num % den == 0) return result;

    result += '.'; 
    unordered_map<int, int> hashmap;
    long remainder;
    for(remainder = num % den; remainder; remainder %= den) {
        if (hashmap.count(remainder) > 0) { // if recurring, add ( at the first appeared place
            result.insert(hashmap[remainder], 1, '(');
            result += ')';  
            break;
        }
        hashmap[remainder] = result.size();
        remainder *= 10;
        result += to_string(remainder / den);
    } 
    return result;
}

int main(){
    cout << fractionToDecimal(-1, -2147483648) << endl;
    return 0;
}
/*
Input:	-1, -2147483648
Output:	"0.0000000000000000000000000000001"
Expected:	"0.0000000004656612873077392578125"
*/
