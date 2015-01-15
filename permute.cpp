#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include "tree.h"

using namespace std;

vector<vector<int> > permute0(vector<int> &num);

vector<vector<int> > res;

void perm(vector<int> &num, int i) {
    if(num.size() == i){  
        res.push_back(num);  
    }
    for (int j = i; j < num.size(); ++j) {
        swap(num[i], num[j]);
        perm(num, i + 1);
        swap(num[i], num[j]);
    }
}

vector<vector<int> > permute(vector<int> &num) {  
    int N = num.size();  
    perm(num, 0);
    return res;
}

int main() {
    int a[] = {1, 2, 3, 4};
    vi b = buildVI(a, 4);
    vector<vector<int> > res = permute(b);
    printVVI(res);

    return 0;
}

// http://blog.csdn.net/tuantuanls/article/details/8717262
vector<vector<int> > permute0(vector<int> &num) {  
    int N = num.size();  
    vector<vector<int> > ret;  
    if(N == 1){  
        ret.push_back(num);  
        return ret;  
    }  
    vector<vector<int> > post;  
    vector<int> cur;  
    vector<int> tmp;  
    for(int i = 0; i < N; i++){  
        cur = num;  
        cur.erase(cur.begin()+i);  
        post = permute0(cur);  
        for(int j = 0; j < post.size(); j++){  
            tmp = post[j];  
            tmp.insert(tmp.begin(), num[i]);  
            ret.push_back(tmp);  
        }  
    }  
    return ret;  
}  

