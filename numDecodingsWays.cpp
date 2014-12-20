#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int numDecodings(string s) {
    /*
    int n = s.size();
    if (n == 0 || s[0] == '0') return 0;
    else if (n == 1) return 1;
    else if (n == 2)  {
        if ( s[1] != '0' && (s[0]-'0' == 1 || (s[0]-'0' == 2 && s[1]-'0' <= 6)) )
            return 2;
        else if (s[1] == '0' && s[0]-'0' >= 3) return 0;
        else return 1;
    }

    int one = 1, two = 0;
    for (int i = 1; i < n; ++i)  {
        two = 0;
        if (s[i] == '0' && s[i-1] == '0') return 0;
        else if (s[i] == '0' && (s[i-1]-'0' == 1 || s[i-1]-'0' == 2)) {
            if (i-1 == 0)
                continue;  //one -= 1;
            else if (s[i-2] == '1' || s[i-2] == '2') one -= 1;
        } else if ( s[i] == '0' && (s[i-1]-'0' > 2) ) return 0;
        else if (s[i] != '0' && s[i]-'0' <= 6 && (s[i-1]-'0' == 1 || s[i-1]-'0' == 2) ) {
            ++two;
            one += two;
        } else if (s[i]-'0' > 0 && s[i]-'0' <= 9 && s[i-1] == '1') {
            two += 1;
            one  += two;
        }
        cout << "i: " << i << endl;
        cout << "one: " << one << endl;
    }
    return one;
    */
    
    if(!s.size()||s[0]=='0')return 0;
    int cur_2 = 1,cur_1 = 1,cur = 0;

    for(int i = 2;i<=s.size();i++){
        if(s[i-1]!='0')cur+=cur_1;
        if(s[i-2]=='1'||(s[i-2]=='2'&&s[i-1]<'7'))cur+=cur_2;
        cur_2 = cur_1;
        cur_1 =  cur;
        cur = 0;
    }
    return cur_1;
}

int main(){
    // 101 1
    // 110 1
    // 230 0
    // 17 2
    // 30 0
    // 1212 5
    string s = "1212";
    cout << numDecodings(s) << endl;
    
    return 0;
}
