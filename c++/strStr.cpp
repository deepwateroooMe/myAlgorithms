#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

char *strStr(char *haystack, char *needle) {
    if (!needle || !haystack) return NULL;
    if (!*needle) return haystack;

    char * tmp = haystack;
    char * one = needle;
    int cnt = 0;
    while (*tmp && *one && *tmp == *one)  {
        ++tmp;
        ++one;
        ++cnt;
    }

    if (!*one) return tmp-cnt;
    else if (!*tmp) return NULL;
    strStr(++haystack, needle);
}

int main(){
    char* a = "mississippi";
    char* b = "issip";
    cout << strStr(a, b) << endl;
    
    return 0;
}
