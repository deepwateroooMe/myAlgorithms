#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <sstream>

using namespace std;

int compareVersion(string version1, string version2) {
    istringstream ss1(version1), ss2(version2);
    vector<string> vs1, vs2;
    string tmp;
    while (getline(ss1, tmp, '.')) {
        vs1.push_back(tmp);
    }
    while (getline(ss2, tmp, '.')) {
        vs2.push_back(tmp);
    }

    int i, s = 0, t = 0;
    int val1 = 0, val2 = 0;
    for (i = 0; i < vs1.size() && i < vs2.size(); ++i) {    
        if (!vs1[i].compare(vs2[i])) {
            s = 0, t = 0;
            continue;
        }
        while (vs1[i][s] == '0') s++;
        while (vs2[i][t] == '0') t++;
        while (s < vs1[i].size() && t < vs2[i].size() ) {
            val1 += vs1[i][s] - '0';
            val2 += vs2[i][t] - '0';
            s++; t++;
            val1 *= 10;
            val2 *= 10;
        }

        if (s == vs1[i].size() && t == vs2[i].size()) {
            if (val1 < val2) return -1;
            else if (val1 > val2) return 1;
            else return 0;  
        } else {        
            if (s > vs1[i].size()-1) {
                while (t < vs2[i].size()) {
                    val2 += vs2[i][t] - '0';
                    t++;
                    val2 *= 10;
                }
            } else {
                while (s < vs1[i].size()) {
                    val1 += vs1[i][s] - '0';
                    s++;
                    val1 *= 10;
                }
            }
            if (val1 < val2)
                return -1;
            else if (val1 == val2) continue;
            else return 1;
        }
    }
    
    if (i == vs1.size() && i == vs2.size()) {
        if (val1 < val2) return -1;
        else if (val1 > val2) return 1;
        else return 0;  
    } else {    
        if (i == vs1.size()) { // vs1 ends first
            t = 0;
            while (t < vs2[i].size() && vs2[i][t] == '0') t++;
            if (t == vs2[i].size()) return 0;
            else return -1;
        } else { // vs2 ends first
            t = 0;
            while (t < vs1[i].size() && vs1[i][t] == '0') t++;
            if (t == vs1[i].size()) return 0;
            return 1; 
        }
    } 
}

int main(){
    string s1 = "3.2.1.9";
    string s2 = "3.2";
    
    cout << compareVersion(s1, s2) << endl;
    
    return 0;
}
