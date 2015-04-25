#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;
typedef vector<int> vi;

void nextPermutation(vector<int> &num) {
    if (num.empty()) return;
    int n = num.size();
    int prev = n-2;
    int curr = n-1;
    int cnt, tmp;
    for( ; prev >= 0 && num[curr] <= num[prev]; prev--, curr--);
    /*
    while (num[prev] == num[curr]) {    
        curr--; prev = curr-1;
        for( ; prev >= 0 && num[curr] < num[prev]; prev--, curr--);
    }
    */
    if (prev >= 0) {
        swap(num[prev], num[curr]);
        sort(num.begin()+prev+1, num.end());
        return;
    } else if (prev < 0) {
        while (curr >= 0) {        
            curr--;
            prev = curr-1;
            for( ; prev >= 0 && num[curr] <= num[prev]; prev--);
            if (prev >= 0) {
                swap(num[prev], num[curr]); 
                sort(num.begin()+prev+1, num.end());
                return;
            }
        } 
        reverse(num.begin(), num.end());
    }
}

int main(){
    vi one;
    one.push_back(2);
    one.push_back(3);
    one.push_back(0);
    one.push_back(2);
    one.push_back(4);
    one.push_back(1);
    for(int i = 0; i < one.size(); ++i)
        cout << one[i] << endl;
    cout << endl;

    nextPermutation(one);
    for(int i = 0; i < one.size(); ++i)
        cout << one[i] << endl;
    cout << endl;

    return 0;
}
