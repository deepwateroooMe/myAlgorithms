#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

typedef vector<string> vs;
typedef vector<vector<string> > vvs;

void print(vvs tmp) {
    int n = tmp.size();
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < tmp[i].size(); ++j) {
            cout << tmp[i][j] << ", ";
        }
        cout << endl;
    }
}

void helper(string s, vector<vector<bool> > &pali, int begin, int len, vector<string> &cur, vector<vector<string> > &res) {
    if (len <= 0)
        res.push_back(cur);
    
    for (int i = 0; i < len; i++) {
        if (pali[begin][begin+i])  {
            // substr of len (begin+1)
            cur.push_back(s.substr(begin, 1+i));  
            helper(s, pali, begin+i+1, len-i-1, cur, res);
            cur.pop_back();
        }
    }
}

vector<vector<string> > partition(string s) {
    int len = s.size();
    vector<vector<bool> > parlindrome(len, vector<bool>(len, false));
    vector<vector<string> > result;
    vector<string> tmp;

    // right-top half matrix is useless ?
    for (int j = 0; j < len; ++j) {
        for (int i = j; i < len; ++i) {
            parlindrome[i][j] = true; // don't understand here
        }
    }

    // get bottom-left half matrix check if elements [i][j] from i-j substr is a palindrome
    for (int j = 0; j < len; ++j) {
        for (int i = 0; i < j; ++i) {
            parlindrome[i][j] = ((s[i] == s[j] && parlindrome[i+1][j-1]));
        }
    }  // these two for loops are kind of wired
    
    helper(s, parlindrome, 0, len, tmp, result);
    return result;
}

int main(){
    string s = "aab";
    vvs result = partition(s);
    cout << "result.size(): " << result.size() << endl;
    
    print(result);
    
    return 0;
}
