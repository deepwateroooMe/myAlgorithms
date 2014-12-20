#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

string expandAroundCenter(string s, int c1, int c2)  {
    int l = c1, r = c2;
    int n = s.length();
    while (l >= 0 && r < n && s[l] == s[r])  {
        l--;
        r++;
    }
    return s.substr(l+1, r-l-1);
}

string longestPalindrome(string s) {
    if (s.length() < 2) return s;
    int n = s.length();
    string result = s.substr(0, 1);  // a single char itself
    string p1, p2;
    for (int i = 0; i < n-1; ++i) {
        p1 = expandAroundCenter(s, i, i);
        if (p1.length() > result.length())
            result = p1;
        p2 = expandAroundCenter(s, i, i+1);
        if (p2.length() > result.length())
            result = p2;
    }
    return result;
}

/*
// O(n^2)
string longestPalindrome(string s) {
    if (s.length() < 2) return s;
    // dp[i][j] denotes if the substring from i to j is a palindrome
    vector<vector<bool> > dp(s.length(), vector<bool>(s.length(), false));
    int n = s.length();
    int start = 0, max = 1, len;
    for (int i = n-1; i >= 0; --i) {
        dp[i][i] = true;
        for (int j = i+1; j < n; ++j) {
            dp[i][j] = (s[i] == s[j] && (j-i < 3 || dp[i+1][j-1])) ? true : false;
            if (dp[i][j]) {
                len = j - i + 1;
                if (len > max)  {
                    start = i;
                    max = len;
                }
            }
        }
    }
    return s.substr(start, max);
}
*/

int main(){
    string s = "eabac";

    // TLE for this case;
    //string s = "flsuqzhtcahnyickkgtfnlyzwjuiwqiexthpzvcweqzeqpmqwkydhsfipcdrsjkefehhesubkirhalgnevjugfohwnlhbjfewiunlgmomxkafuuokesvfmcnvseixkkzekuinmcbmttzgsqeqbrtlwyqgiquyylaswlgfflrezaxtjobltcnpjsaslyviviosxorjsfncqirsjpkgajkfpoxxmvsyynbbovieoothpjgncfwcvpkvjcmrcuoronrfjcppbisqbzkgpnycqljpjlgeciaqrnqyxzedzkqpqsszovkgtcgxqgkflpmrikksaupukdvkzbltvefitdegnlmzeirotrfeaueqpzppnsjpspgomyezrlxsqlfcjrkglyvzvqakhtvfmeootbtbwfhqucbnuwznigoyatvkocqmbtqghybwrhmyvvuchjpvjckiryvjfxabezchynfxnpqaeampvaapgmvoylyutymdhvhqfmrlmzkhuhupizqiujpwzarnszrexpvgdmtoxvjygjpmiadzdcxtggwamkbwrkeplesupagievwsaaletcuxtpsxmbmeztcylsjxvhzrqizdmgjfyftpzpgxateopwvynljzffszkzzqgofdlwyknqfruhdkvmvrrjpijcjomnrjjubfccaypkpfokohvkqndptciqqiscvmpozlyyrwobeuazsawtimnawquogrohcrnmexiwvjxgwhmtpykqlcfacuadyhaotmmxevqwarppknoxthsmrrknu";
    cout << "out: " << longestPalindrome(s) << endl;
    

    return 0;
}
