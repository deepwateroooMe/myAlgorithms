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

vector<vector<int> > threeSum(vector<int> &num) {
    vector<vector<int> > result;
    set<vector<int> > res;
    
    int n = num.size();
    if (n < 3) return result;
    
    vector<int> one;
    int j, k, sum;
    sort(num.begin(), num.end());
    
    for(int i = 0; i < n-2; ++i)  {
        if (i > 0 && num[i] == num[i-1]) continue;
        j = i+1, k = n-1;
        while (j < k) {
            while (k > n-1 && num[k] == num[k+1]) k--;

            sum = num[i] + num[j] + num[k];
            if (sum > 0) k--;
            else if (sum < 0) j++;
            else  {
                one.push_back(num[i]);
                one.push_back(num[j]);
                one.push_back(num[k]);
                res.insert(one);
                one.clear();
                j++;
                k--;
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
    int s[] = {-1, 0, 1, 2, -1, -4};
    vi tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(s[i]);
    printVI(tmp);
        
    vvi result = threeSum(tmp);
    printVVI(result);
    
    return 0;
}

//    (-1, 0, 1)
//    (-1, -1, 2)
