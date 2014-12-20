#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>
#include <algorithm>

using namespace std;

typedef vector<string> vs;

void print(vs tmp) {
    for (int i = 0; i < tmp.size(); ++i)
        cout << tmp[i] << ", ";
    cout << endl;
}

vector<string> anagrams(vector<string> &strs) {
    vector<string> result;
    if (strs.size() == 0) return result;
    
    int n = strs.size();
    unordered_map<string, vector<string> > hash;
    string tmp;
     
    for(string s: strs) {
        tmp = s;
        sort(tmp.begin(), tmp.end());
        /* // need to learn how to use auto iterator in c++11
        vector<string> array;
        if (!hash.count(tmp))  {
            array.push_back(s);
            hash[tmp] = array;
        } else
            array.push_back(s);
        */
        hash[tmp].push_back(s);
    }

    //unordered_map<string, vector<string> >::iterator it;
    //for(it = hash.begin(); it != hash.end(); ++it)  {
    for(auto key: hash)  {
        if (key.second.size() > 1)
            result.insert(result.end(), key.second.begin(), key.second.end());
    }
    return result;
}

int main(){
    int n = 10;
    string a[] = {"cat","rye","aye","dog", "god","cud","cat","old","fop","bra"};
    vs tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(a[i]);
    vs result = anagrams(tmp);
    print(result);

    return 0;
}
