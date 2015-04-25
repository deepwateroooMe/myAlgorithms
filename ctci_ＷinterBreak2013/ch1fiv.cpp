#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

char* replace1 (char* c) {
    if (c == NULL) return NULL; // didn't notice this one

    int len = strlen(c);   // didn't notice this one
    if (len == 0) return NULL; 

    int cnt = 0; 
    for (int i = 0; i < len; ++i) {
	if (c[i] == ' ')
	    ++cnt;
    }

    char* cc = new char[len + 2*cnt];   // something I missed here!!!
    int p = 0;
    for (int i = 0; i < len; ++i) {
	if (c[i] == ' ') {
	    cc[p++] = '%';	    
	    cc[p++] = '2';	    
	    cc[p++] = '0';	    
	} else
	    cc[p++] = c[i];
    }
    cc[p] = '\0';
    return cc;
}

void replace2 (char* c) {
    if (c == NULL) return; // didn't notice this one

    int len = strlen(c);   // didn't notice this one
    if (len == 0) return; 

    int cnt = 0; 
    for (int i = 0; i < len; ++i) {
	if (c[i] == ' ')
	    ++cnt;
    }

    int p = len + 2 * cnt;
    c[p--] = '\0';    // the space must be allocated first!
    for (int i = len-1; i >= 0; --i) {
	if (c[i] == ' ') {
	    c[p] = '0';
	    c[p - 1] = '2';
	    c[p - 2] = '%';
	    p -= 3;
	} else {
	    c[p] = c[i];
	    --p;
	}
    }
}

int main() {
    const int len = 100;
    char s[len] = "I am beautiful!";
    cout << replace1(s) << endl;
    //replace2(s);
    //cout << s << endl;
    return 0;
}
