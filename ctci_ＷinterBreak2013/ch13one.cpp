#include <iostream>
#include <fstream>
using namespace std;

void printLastKLines(ifstream &fin, int k) {
    string line[k];
    int lines = 0;
    string tmp; 

 // while (fin.get_line() != EOF) {   // my original, mistake
 // while ( !fin.eof() ) {    // WRONG
    while ( getline(fin, tmp) ) {
	line[lines % k] = tmp;
	++lines;
    }

    /* // my original
    if (lines % k == 0)
	for (int i = 0; i < k; ++k) 
	    cout << line[i] << endl;
    else {
	for (int i = lines%k; i < k; ++i) 
	    cout << line[i] << endl;
	for (int i = 0; i < lines % k; ++i)
	    cout << line[i] << endl;
    } */

    int start, cnt; 
    if (lines < k) {
	start = 0;
	cnt = k;
    } else {
	start = lines % k;
	cnt = k;
    }
    for (int i = 0; i < cnt; ++i) 
	cout << line[ (start+i) % k ] << endl;
}

int main() {
    ifstream fin("ch1313.1.in");
    int k = 4;
    printLastKLines(fin, k);
    fin.close();
    return 0;
}
