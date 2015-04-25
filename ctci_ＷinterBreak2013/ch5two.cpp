#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;

string print_binary(string val) {
    int pos = val.find('.', 0);
    int intpart =  atoi( val.substr(0, pos).c_str() ); // c_str() function
    double decipart = atof( val.substr(pos, val.length()-pos).c_str() );
    string left = "", right = "";

    while(intpart > 0) {
	if (intpart & 1) left = "1"+left;
	else left = "0" + left;
	intpart >>= 1;
    }

    int cnt = 0;
    while (decipart > 0) {
	if ( right.length() > 32 ) return "ERROR";

	decipart *= 2;
	if (decipart >= 1) {
	    right += "1";
	    decipart -= 1;
	} else
	    right += "0";
    }

    return left + "." + right;
}

int main() {
    string val = "19.25";
    cout << print_binary(val) << endl;
    return 0;
}
