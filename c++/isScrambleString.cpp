#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <string.h>
#include <algorithm>

#include <cstdlib>

using namespace std;

bool isScramble(string s1, string s2) {
    if (s1.size() != s2.size()) return false;
    if ( !s1.compare(s2) ) return true;  // strings are the same

    string tmp1 = s1, tmp2 = s2;
    sort(tmp1.begin(), tmp1.end());
    sort(tmp2.begin(), tmp2.end());
    if (tmp1.compare(tmp2)) return false;

    for (int i = 1; i < s1.size(); ++i) {
        if ( isScramble(s1.substr(0, i), s2.substr(0, i))
             && isScramble(s1.substr(i), s2.substr(i)) )
            return true;
        if ( isScramble(s1.substr(0, i), s2.substr(s2.size()-i))
             && isScramble(s1.substr(i), s2.substr(0, s2.size()-i)) )
            return true;
    }
    return false;
    /*
      char c1[s1.size()];
      strcpy(c1, s1.c_str());
      char c2[s2.size()];
      strcpy(c2, s2.c_str());
      sort(c1, c1+sizeof(c1));
      sort(c2, c2+sizeof(c2));
      for (int i = 0; i < s1.size; ++i) {
      if (c1[i] != c2[i])
      }
    */
    
    /*
      int len = s1.size();
      bool dp[100][100][100] = {false};
      for (int i = len-1; i >= 0; --i)
      for (int j = len-1; j >= 0; --j)  {
      dp[i][j][1] = (s1[i] == s2[j]);
      for (int k = 2; i+k <= len && j+k <= len; ++k) {
      for (int n = 1; n < k; ++n)  {
      dp[i][j][k] |= dp[i][j][n] && dp[i][j][k-n];
      dp[i][j][k] |= dp[i][j+k-n][n] && dp[i+n][j][k-n];
      }
      }
      }
      return dp[0][0][len];
    */
}

int main(){
    string s1 = "abcd";
    string s2 = "bdac";
    cout << ": " << isScramble(s1, s2) << endl;
    

    return 0;
}
