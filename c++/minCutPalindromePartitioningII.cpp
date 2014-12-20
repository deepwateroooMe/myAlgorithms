#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

int minCut(string s) {
    int n = s.size();
    vector<int> cut(n+1, 0);  // number of cuts for the first k characters

    for (int i = 0; i <= n; i++)
        cut[i] = i-1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; i-j >= 0 && i+j < n && s[i-j]==s[i+j] ; j++) // odd length palindrome
            cut[i+j+1] = min(cut[i+j+1],1+cut[i-j]);

        for(int j = 0; i-j >=0 && i+j+1 < n && s[i-j] == s[i+1+j]; j++) // even length palindrome
            cut[i+1+j+1] = min(cut[i+j+2], 1 + cut[i-j]);
        /*    
              for (int j = 1; i-j+1 >= 0 && i+j < n && s[i-j+1] == s[i+j]; j++) // even length palindrome
              cut[i+j+1] = min(cut[i+j+1],1+cut[i-j+1]);
        */
    }
    return cut[n];   
}

int main(){
    string s = "cabbac";
    cout << "out: " << minCut(s) << endl;
    

    return 0;
}
