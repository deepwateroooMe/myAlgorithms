#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>
#include <set>
#include <algorithm>
using namespace std;

typedef vector<int> vi;
typedef vector<vector<int> > vvi;

void printVI(vi tmp) {
    for(int i = 0; i < tmp.size(); ++i) 
        cout << tmp[i] << ", ";
    cout << endl;
}

void printVVI(vvi tmp) {
    cout << "tmp.size(): " << tmp.size() << endl;
    for(int i = 0; i < tmp.size(); ++i) 
        printVI(tmp[i]);
    cout << endl;
}

vector<vector<int> > fourSum(vector<int> &num, int target) {
    vector<vector<int> > result;
    set<vector<int> > res;
    
    int n = num.size();
    if (n < 4) return result;
    
    vector<int> one;
    int x, j, k, sum;
    sort(num.begin(), num.end());
    
    for(int i = 0; i < n-3; ++i)  {
        if (i > 0 && num[i] == num[i-1]) continue;
        for(int x = i+1; x < n-2; ++x) {
            j = x+1, k = n-1;
            while (j < k) {
                sum = num[i] + num[x] + num[j] + num[k];
                if (sum > target) k--;
                else if (sum < target) j++;
                else  {
                    one.push_back(num[i]);
                    one.push_back(num[x]);
                    one.push_back(num[j]);
                    one.push_back(num[k]);
                    res.insert(one);
                    one.clear();
                    j++;
                    k--;
                }
            }
        }
    }
    set<vector<int> >::iterator it;
    for(it = res.begin(); it != res.end(); ++it)
        result.push_back(*it);
    return result;
}

int main(){
    int n = 6;
    int s[] = {-1, 0, 1, 2, 0, -2};
    vi tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(s[i]);
    printVI(tmp);
        
    vvi result = fourSum(tmp, 0);
    printVVI(result);
    
    return 0;
}

//    (-1, 0, 1)
//    (-1, -1, 2)
