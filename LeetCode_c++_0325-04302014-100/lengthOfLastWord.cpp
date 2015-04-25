#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <sstream>
#include <string>
using namespace std;

int lengthOfLastWord(const char *s) {
    stringstream ss;
    ss << s;
    string tmp;
    while(ss)
        ss >> tmp;
    return tmp.size();
}

int main(){
    const char* tmp = "hello world!";
    cout << lengthOfLastWord(tmp) << endl;
    
return 0;
}
