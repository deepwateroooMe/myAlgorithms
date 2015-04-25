#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;

string toRomPos(int num, int i)  {
    string one, two, thr;
    string res = "";
    if (i == 1)  {
        one = "I";
        two = "V";
        thr = "X";
    } else if (i ==  2)  {
        one = "X";
        two = "L";
        thr = "C";
    } else if (i == 3) {
        one = "C";
        two = "D";
        thr = "M";
    } else  {
        one = "M";
        two = "";
        thr = "";
    }
    switch(num) {
    case 0: break;
    case 1: res += one; break;        
    case 2: res += one + one; break;        
    case 3: res += one + one + one; break;        
    case 4: res += one + two; break;        
    case 5: res += two; break;        
    case 6: res += two + one; break;        
    case 7: res += two + one + one; break;        
    case 8: res += two + one + one + one; break;        
    case 9: res += one + thr; break;        
    }
    return res;
}

string intToRoman(int num) {
    string result = "";
    int cnt = (int)log10(num);
    for (int i = cnt+1; i >= 2; i--){
        result += toRomPos(num/pow(10, i-1), i);
        num = num - ((int)(num/pow(10, i-1)))*pow(10, i-1);
    }
    result += toRomPos(num % 10, 1);
    return result;
}

int main(){
    int a = 3999;
    cout << intToRoman(a) << endl;
    return 0;
}
