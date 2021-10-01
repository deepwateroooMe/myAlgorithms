#include<iostream>
#include<cstring>
using namespace std;

string removeDuplicate1(char s[]) {
    int len = strlen(s);
    if (len < 2) 
	return s;
    string str = "";

    int a = 0;
    for (int i = 0; i < len; ++i) {
	int shift = (int)(s[i] - 'a');
	if ( (a & (1 << shift)) == 0 ) {
	    str += s[i];
	    a |= (1 << shift);
	}
    }
    return str; 
}

string removeDuplicate2(char s[]) {
    int len = strlen(s);
    if (len < 2) 
	return s;
    string str = "";

    for(int i = 0; i < len; ++i) {
	if (s[i] != '\0') {
	    str += s[i];
	    for (int j = i+1; j < len; ++j) 
		if ( s[j] == s[i] ) 
		    s[j] = '\0';
	}
    }
    return str;
}

void removeDuplicate3(char s[]) {
    int len = strlen(s);
    if (len < 2) return;
	
    int p = 0;
    for(int i = 0; i < len; ++i) {
	if (s[i] != '\0') {
	    s[p++] = s[i];
	    for (int j = i+1; j < len; ++j) 
		if ( s[j] == s[i] ) 
		    s[j] = '\0';
	}
    }
    s[p] = '\0';
}

void removeDuplicate4(char s[]) {
    int len = strlen(s);
    if (len < 2) return;	

    bool flag[256];
    memset(flag, 0, sizeof(flag));

    int p = 0;
    for (int i = 0; i < len; ++i) {
	if (!flag[s[i]]) {
	    s[p++] = s[i];
	    flag[s[i]] = true;
	}
    }
    s[p] = '\0';
}

void removeDuplicate5(char s[]) {
    int len = strlen(s);
    if (len < 2) return;	

    int a = 0, p = 0;
    for (int i = 0; i < len; ++i) {
	int shift = (int)(s[i] - 'a');
	if ( !(a & (1 << shift)) ) {
	    s[p++] = s[i];
	    a |= 1 << shift;
	}
    }
    s[p] = '\0';
}

int main() {
    char a[] = "abcdefg";
    char b[] = "aaaaabbbbbccccc";
    char c[] = "";
    char d[] = "abcdefgadchijkadefgabc";
    char e[] = "aaaaaaaaa";
    char a2[] = "abcdefg";
    char b2[] = "aaaaabbbbbccccc";
    char c2[] = "";
    char d2[] = "abcdefgadchijkadefgabc";
    char e2[] = "aaaaaaaaa";
    cout << removeDuplicate1(a) << " " << removeDuplicate2(a2) << endl;
    cout << removeDuplicate1(b) << " " << removeDuplicate2(b2) << endl;
    cout << removeDuplicate1(c) << " " << removeDuplicate2(c2) << endl;
    cout << removeDuplicate1(d) << " " << removeDuplicate2(d2) << endl;
    cout << removeDuplicate1(e) << " " << removeDuplicate2(e2) << endl;  
    char a3[] = "abcdefg";
    char b3[] = "aaaaabbbbbccccc";
    char c3[] = "";
    char d3[] = "abcdefgadchijkadefgabc";
    char e3[] = "aaaaaaaaa";
    removeDuplicate3(a3);
    removeDuplicate3(b3);
    removeDuplicate3(c3);
    removeDuplicate3(d3);
    removeDuplicate3(e3);   
    cout << "removeDuplicate3 a: " << a3 << endl;
    cout << "removeDuplicate3 b: " << b3 << endl;
    cout << "removeDuplicate3 c: " << c3 << endl;
    cout << "removeDuplicate3 d: " << d3 << endl;
    cout << "removeDuplicate3 e: " << e3 << endl;   
    char a4[] = "abcdefg";
    char b4[] = "aaaaabbbbbccccc";
    char c4[] = "";
    char d4[] = "abcdefgadchijkadefgabc";
    char e4[] = "aaaaaaaaa";
    removeDuplicate4(a4);
    removeDuplicate4(b4);
    removeDuplicate4(c4);
    removeDuplicate4(d4);
    removeDuplicate4(e4);   
    cout << "removeDuplicate4 a: " << a4 << endl;
    cout << "removeDuplicate4 b: " << b4 << endl;
    cout << "removeDuplicate4 c: " << c4 << endl;
    cout << "removeDuplicate4 d: " << d4 << endl;
    cout << "removeDuplicate4 e: " << e4 << endl;   
    char a5[] = "abcdefg";
    char b5[] = "aaaaabbbbbccccc";
    char c5[] = "";
    char d5[] = "abcdefgadchijkadefgabc";
    char e5[] = "aaaaaaaaa";
    removeDuplicate5(a5);
    removeDuplicate5(b5);
    removeDuplicate5(c5);
    removeDuplicate5(d5);
    removeDuplicate5(e5);   
    cout << "removeDuplicate5 a: " << a5 << endl;
    cout << "removeDuplicate5 b: " << b5 << endl;
    cout << "removeDuplicate5 c: " << c5 << endl;
    cout << "removeDuplicate5 d: " << d5 << endl;
    cout << "removeDuplicate5 e: " << e5 << endl;   
    return 0;
}
