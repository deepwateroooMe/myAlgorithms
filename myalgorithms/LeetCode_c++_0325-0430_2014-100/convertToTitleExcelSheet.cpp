#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

string convertToTitle(int n) {
    if (n == 0) return "";

    string result = "";
    while (n) {
        result += (--n % 26 + 'A');
        n /= 26;
    }
    
    return string(result.rbegin(), result.rend()); // reverse iterator
}

int main(){
    cout << convertToTitle(28) << endl;
    
    return 0;
}
