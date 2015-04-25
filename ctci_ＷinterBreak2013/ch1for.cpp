#include<iostream>
#include<cstring>
#include<algorithm>
using namespace std;

bool isAnagram1 (string s, string t) {
    if (s == "" || t == "") return false;
    if (s.length() != t.length()) return false;

    sort(&s[0], &s[0]+s.length());
    sort(&t[0], &t[0]+t.length());
    if (s == t) return true;
    else return false;
}

bool isAnagram2 (string s, string t) {
    if (s == "" || t == "") return false;
    if (s.length() != t.length()) return false;

    int a[256];
    memset(a, 0, sizeof(a));

    int len = s.length();
    for (int i = 0; i < len; ++i) {
	++a[s[i]];
	--a[t[i]];
    }

    for (int i = 0; i < 256; ++i)
	if (a[i])
	    return false;
    return true;
}

int main() {
    string s1 = "aeiou";
    string s2 = "uoeai";
    cout << isAnagram1(s1, s2) << endl;
    cout << isAnagram2(s1, s2) << endl;
    return 0;
}
