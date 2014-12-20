#include <iostream>
#include <string.h>
using namespace std;

bool isMatch(const char *s, const char *p) {

    if (!*s && !*p) return true;
    else if (!*s && *p && *p != '*') return false;
    
    if (*p == *s) return isMatch(s+1, p+1);
    else if (*p == '.' && *s) return isMatch(s+1, p+1);
    else if (*p == '*') {
        int ret = false;
        while (*p == '*') ++p;  // need one * only
        if (!*p) return true;

        while (*s) {
            const char *ts = s, *tp = p;
            
            while ( (*ts == *tp || *tp == '.') && *ts) {
                if (*tp == '*') break;
                ++ts; ++tp;
            }

            if (!*ts && !*tp ) return true;
            if (*tp == '*') {
                ret |= isMatch(ts, tp);
                return ret;
            }
            if (!*ts) return false;
            ++s;
        }
        return ret;
    } else return false;
}

int main() 
{
    cout << isMatch("aab","c*a*b") << endl;
    /*
    cout << isMatch("aa","aa")<< endl;
    cout << isMatch("aaa","aa")<< endl;
    cout << isMatch("aa", "*") << endl;
    cout << isMatch("aa", "a*")<< endl;
    cout << isMatch("ab", "?*")<< endl;
    cout << isMatch("aab", "c*a*b")<< endl;
    */
    return 0;
}
