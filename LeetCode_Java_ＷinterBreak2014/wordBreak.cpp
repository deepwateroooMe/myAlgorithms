bool wordBreak(string s, unordered_set<string> &dict) {
    if (find(dict.begin(), dict.end(), s) != dict.end()) return true;

    int m = s.size();
    bool dp[m];
    memset(dp, false, sizeof(dp));
    
    for(int j = 0; j < m; j++) {
        for(int i = j; i >= 0; i--) {
            string tmp(s.begin()+i, s.begin()+j+1);
            if (find(dict.begin(), dict.end(), tmp) != dict.end()) {
                if ( (i >= 1 && dp[i-1]) || (i == 0) )
                    dp[j] = true;
            }
        }
    }
    return dp[m-1];
}
