#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

typedef vector<char> vc;

string onePosition(char a, char b)  {
    if (a == b) {
        if (a == '0')
            return "0";
        else
            return "2";
    } else
        return "1";
}

string addBinary(string a, string b) {
    vector<string> mid;
    int one = a.size()-1;
    int two = b.size()-1;
    char tmp, rover = '0';
    string result = "";
    
    while(one >= 0 && two >= 0) {
        if ( onePosition(a[one], b[two]) == "0")
            if (rover == '0')
                mid.push_back("0");
            else  {
                mid.push_back("1");
                rover = '0';
            }
        else if (onePosition(a[one], b[two]) == "1") {
            if (rover == '0')
                mid.push_back("1");
            else 
                mid.push_back("0");
        } else  {
            if (rover == '0')  {
                mid.push_back("0");
                rover = '1';
            } else 
                mid.push_back("1");
        }
        --one;
        --two;
    }
    
    if (one < 0 && two < 0) {
        if (rover == '1')
            result.append("1");
    } else { //if (one >= 0 || two >= 0)  {
        if (one > 0) result.append(a.substr(0, one+1));
        else if (one == 0) result.append(a.substr(0, 1));
        else if (two == 0) result.append(b.substr(0, 1));
        else result.append(b.substr(0, two+1));
        
        if (rover == '1') {
            one = result.size()-1;
            while (result[one] == '1') {
                result.replace(one, 1, "0");
                --one;
            }
            if (one > 0)
                result.replace(one, 1, "1");
            else
                result.insert(0, 1, '1');
        }
    }
    for (int i = mid.size()-1; i >= 0; --i )
        result.append(mid[i]);
    return result;
}

int main() {
    string a = "11";
    string b = "1";
    cout << addBinary(a, b) << endl;
    
    return 0;
}
