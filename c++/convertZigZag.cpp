#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

string convert(string s, int nRows) {
    if (s.length() == 0 || s.length() <= nRows || nRows == 1) return s;

    string result = "";
    int zig = 2 * (nRows - 1);
    int zag = zig;

    for (int i = 0; i < nRows; ++i) {
        for (int j = i; j < s.length(); j += zig) {
            result  += s[j];
            if (zag < zig && (j + zag) < s.length() && zag > 0)
                result += s[j + zag];
        }
        zag -= 2;
    }
    return result;
}

int main(){
    string s = "PAYPALISHIRING";
    cout << "out: " << convert(s, 3) << endl;
    

    return 0;
}
