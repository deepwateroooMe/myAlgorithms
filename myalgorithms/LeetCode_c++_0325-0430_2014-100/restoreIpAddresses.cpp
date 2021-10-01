#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <cmath>
#include <stack>
#include <queue>
using namespace std;
typedef vector<string> vs;

/*
void dfs(vector<string> &result, string s, int one[4], int i, int idx, int cnt) {
}
*/

vector<string> restoreIpAddresses(string s) {
    vector<string> result;
    if (s.size() > 12 || s.size() == 0) return result;

    string tmp = "";
    for (int i = 1; i <= s.size()-3; i++) {
        if ( (s[0] == '0' && i > 1)
             || (i == 3 &&
                 (s[0]-'2' > 0 || (s[0] == '2' && s[1]-'5'>0)
                  || (s[0] == '2' && s[1] == '5' && s[2]-'5'>0)))
             || (i > 3) )
            break;

        for (int j = i + 1; j <= s.size()-2; j++) {
            if ( (s[i] == '0' && j-i > 1)
                 || (j-i == 3 &&
                     (s[i]-'2' > 0 || (s[i] == '2' && s[i+1]-'5'>0)
                      || (s[i] == '2' && s[i+1] == '5' && s[i+2]-'5'>0)))
                 || (j-i > 3) ) 
                break;

            for (int k = j + 1; k <= s.size()-1; k++) {
                if ( (s[k] == '0' && s.size()-k > 1)
                     || (s.size()-k == 3 &&
                         (s[k]-'2' > 0 || (s[k] == '2' && s[k+1]-'5'>0)
                          || (s[k] == '2' && s[k+1] == '5' && s[k+2]-'5'>0)))
                     || (s.size()-k > 3) )
                    continue;

                if ( (s[j] == '0' && k-j > 1)
                     || (k-j == 3 &&
                         (s[j]-'2' > 0 || (s[j] == '2' && s[j+1]-'5'>0)
                          || (s[j] == '2' && s[j+1] == '5' && s[j+2]-'5'>0)))
                     || (k-j > 3) )
                    break;

                tmp.append(s.substr(0, i));
                tmp.append(".");
                tmp.append(s.substr(i, j-i));
                tmp.append(".");
                tmp.append(s.substr(j, k-j));
                tmp.append(".");
                tmp.append(s.substr(k, s.size()-k));
                result.push_back(tmp);
                tmp = "";
            }
        }
    }
    return result;
}

int main(){
    string s = "101023";
    vs tmp = restoreIpAddresses(s);
    for(int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;

    return 0;
}

