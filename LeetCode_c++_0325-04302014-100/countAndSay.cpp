#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

string countAndSay(int n) {
    string res[n];
    int cnt, tmp, counter;
    
    res[0] = "1";
    for(int i = 1; i < n; ++i)  {
        res[i] = "";
        cnt = res[i-1].size();
        tmp = 1;
        counter = 1;
        while(tmp < cnt) {
            while (res[i-1][tmp] == res[i-1][tmp-1]) {
                ++counter;
                ++tmp;
            }
            switch(counter) {
            case 1: res[i].append("1"); break;
            case 2: res[i].append("2"); break;
            case 3: res[i].append("3"); break;
            case 4: res[i].append("4"); break;
            case 5: res[i].append("5"); break;
            case 6: res[i].append("6"); break;
            case 7: res[i].append("7"); break;
            case 8: res[i].append("8"); break;
            case 9: res[i].append("9"); break;
            }
            res[i].append(1u, res[i-1][tmp-1]);
            ++tmp;
            if (tmp <= cnt)
                counter = 1;
        }

        if (cnt == 1) {
            res[i].append("1"); 
            res[i].append(1u, res[i-1][tmp-1]);
        }
        
        if (i > 2 && res[i-1][cnt-1] != res[i-1][cnt-2] )  {        
            res[i].append("1"); 
            res[i].append(1u, res[i-1][tmp-1]);
        }
    }
    return res[n-1];
}

int main(){
    cout << countAndSay(5) << endl;
    return 0;
}
/*
  1, 11, 21, 1211, 111221, ...
  1 is read off as "one 1" or 11.
  11 is read off as "two 1s" or 21.
  21 is read off as "one 2, then one 1" or 1211.
*/
