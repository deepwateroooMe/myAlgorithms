#include <iostream>
#include <vector>
using namespace std;

typedef vector<string> vs;

void print_vs(vs result) {
    cout << "Permutation result size: " << result.size() << endl;

    for (int i = 0; i < result.size(); ++i) 
	cout << result[i] << " ";
    cout << endl;
}

vs permu(string s) {
    vs result;
    if (s == "") {
	result.push_back(s);
	return result;
    } 

    string c = s.substr(0, 1);
    vs res = permu( s.substr(1) );
    for (int i = 0; i < res.size(); ++i) {
	string t = res[i];
	//result.push_back(t);  // made mistake here, NOT necessary
	for (int j = 0; j <= t.length(); ++j) {   // one >= length()
	    // string u = t.substr(0,j) + c + t.substr(j);  // equivalent method
	    string u = t;
	    u.insert(j, c);
	    result.push_back(u);
	}
    }
    return result;
}

vs permu1(string s) {
    vs result; 
    if (s == "") {
	result.push_back(s);
	return result;
    }

    for (int i = 0; i < s.length(); ++i) {
	string c = s.substr(i,1);  // made mistake s.substr(i, i+1)
	string rest = s.substr(0,i)+s.substr(i+1);
     // vs res = permu1( s.substr(0,i)+s.substr(i+1) );  // equivalent
	string t = s;
	vs res = permu1( t.erase(i,1) );
	for (int j = 0; j < res.size(); ++j) 
	    result.push_back(c+res[j]);
    }
    return result;
}


int main() {
    string s = "abcd";
    vs result = permu(s);
    print_vs(result);
    vs result1 = permu1(s);
    print_vs(result1);
    return 0;
}
