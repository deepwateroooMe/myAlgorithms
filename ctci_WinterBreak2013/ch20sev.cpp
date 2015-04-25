#include <iostream>
#include <algorithm>
#include "hash.h"
using namespace std;

Hash hash;

inline bool cmp (string s1, string s2) {
    return s2.length() < s1.length();
}

bool MakeOfWords(string word, int length) {
    int len = word.length();
    if (len == 0) return true;

    for (int i = 0; i <= len; ++i) {
	if (i == length) return false;
	string str = word.substr(0, i);
	if ( hash.find((char*)&str[0]) ) {
	    if ( MakeOfWords(word.substr(i), length) )
		return true;
	}
    }
    return false;
}

void PrintLongestWord(string word[], int n) {
    for (int i = 0; i < n; ++i) 
	hash.insert( (char*)&word[i][0] );
    sort(word, word+n, cmp);
 
    for (int i = 0; i < n; ++i) {
	if ( MakeOfWords(word[i], word[i].length()) ) {
	    cout << "Longest Word: " << word[i] << endl;
	    return;
	}
    }
}

int main() {
    string arr[] = {"test", "tester", "testertest", "testing", 
		    "apple", "seattle", "banana", "batting", "ngcat", 
		    "batti", "bat", "testingtester", "testbattingcat"};
    int len = 13;
    PrintLongestWord(arr, len);
    return 0;
}
