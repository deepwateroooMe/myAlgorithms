#include <iostream>
#include <string.h>
using namespace std;

char pre;   // p
bool preStar = false;
bool anySeq = false;

// https://oj.leetcode.com/discuss/9405/the-shortest-ac-code
// '.' if p has a '.', it can pass any single character in s except '\0'.
// '*' if p has a '*' character, it can pass any length of first-match
//                    characters in s including '\0'.
bool matchFirst(const char *s, const char *p) {
    return (*p == *s || (*p == '.' && *s != '\0'));
}

bool isMatch(const char *s, const char *p) {  // only p . *
    if (*p == '\0') return *s == '\0';  // empty
    if (*(p+1) != '*') {  // without '*'
        if (!matchFirst(s, p)) return false;
        return isMatch(s+1, p+1);
    } else {
        if (isMatch(s, p+2)) return true;
        while (matchFirst(s, p)) {
            if (isMatch(++s, p+2)) return true;
        }
    }
}

int main() 
{  /*
    cout << isMatch("aa","a")<< endl;
    cout << isMatch("aa","aa")<< endl;
    cout << isMatch("aaa","aa")<< endl;
    cout << isMatch("aa", "a*")<< endl;
    cout << isMatch("aa", ".*") << endl;
    cout << isMatch("ab", ".*")<< endl;
    cout << isMatch("aab","c*a*b") << endl; 
    cout << isMatch("abaabababbcbcabbcbc", "b*ab.*.*.*.b..*") << endl;  */
    cout << isMatch("abbabaaaaaaacaa", "a*.*b.a.*c*b*a*c*") << endl;
    
    return 0;
}

bool isMatch1(const char *s, const char *p) {  // only p . *

    if (!*s && !*p) return true;   // both empty
    else if (strlen(s) != strlen(p) && !strchr(p, '*')) return false; //不等长
    else if (!*s && *p && *p != '*') return false;
    else if (!*s && *p) {
        while (*p && *p == '*') ++p;
        if (!*p) return true;
        else return false;
    }
    
    if (*p == *s) {
        pre = *p;
        return isMatch(s+1, p+1);
    } else if (*s && *p == '.') {
        pre = *p;
        return isMatch(s+1, p+1);
    } else if (*p == '*') {
        if (pre == '.') anySeq = true;
        while (*p == '*') ++p;  // need one * only
        // consider .*.*.* situation
        if (*p == '.') {
            while (*p == '.' && *(p+1) == '*') {
                anySeq = true;
                ++p; ++p;
            }
            while (*p == '*') ++p;  // need one * only
        }

        if (!*p && anySeq) {
            anySeq = false;
            return true;  
        } else if (!*p) {  // !anySeq
            while (*s && *s == pre) ++s;
            if (!*s) return true;
            else return false;
        }

        int ret = false;        
        const char *ts = s, *tp = p;
        while ( (*ts == *tp || *tp == '.') && *ts) {
            pre = *tp;
            if (*tp == '*') break;
            ++ts; ++tp;
        }

        if (!anySeq && *tp != '*') {
            while (*ts && *ts == pre) ++ts;  // match * only
            if (!*ts) return false;
            else if (*ts != *tp && *tp != '.') return false;
            else if (*ts == *tp || *tp == '.') {
                pre = *tp;
                return isMatch(ts+1, tp+1);
            }
        }
        
        if (!*ts && !*tp ) return true;
        if (*tp == '*') {
            if (pre == '.') anySeq = true;
            while (*tp == '*') ++tp;  // need one * only
            // consider .*.*.* situation
            if (*tp == '.') {
                while (*tp == '.' && *(tp+1) == '*') {
                    anySeq = true;
                    ++tp; ++tp;
                }
                while (*tp == '*') ++tp;  // need one * only
            }
            if (!*tp && anySeq) return true;    // why, modified here

            // *tp
            if (anySeq) {        // !* .        
                pre = *tp;
                if (*tp == '.') {
                    pre = *tp;
                    anySeq = false;
                    return isMatch(ts+1, tp+1);
                } else if (*tp != '.') {
                    ts = strchr(ts, *tp);
                    if (!*ts) return false;
                    while (ts) {                    
                        ret = ret | isMatch(ts, tp);
                        ts = strchr(ts, *tp);
                    }
                    if (!*ts) return false;
                    return ret;
                }
            } else {
                if (*tp != '.') {
                    while (*ts && *ts == pre) ++ts;
                    pre = *tp;
                    if (*ts == *tp) return isMatch(ts+1, tp+1);
                    else return false;
                } else if (*tp == '.') {
                    while (*ts && *ts == pre) ++ts;
                    return isMatch(ts, tp);
                }
            }
        } // *tp == '*'
        if (!*ts) return false;
    } else if (*s != *p && *p != '.' && *p != '*') {
        if (*(p+1) == '*') {
            pre = *p;
            ++p; 
            while (*p == '*') ++p;  // need one * only
            if (!*p) return false;
            else if (*s == *p || *p == '.') {
                pre = *p;
                return isMatch(s+1, p+1);
            } else if (*s != *p && *p != '.') return false;
        }
    } else return false;
}

