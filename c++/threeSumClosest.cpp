#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
#include <unordered_map>
#include <set>
#include <algorithm>
#include <climits>
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

int threeSumClosest(vector<int> &num, int target) {
    int n = num.size();
    if (n < 3) return 0;
    else if (n == 3) return num[0]+num[1]+num[2];
    
    int j, k, sum;
    sort(num.begin(), num.end());
    int final = INT_MAX-2;
    
    for(int i = 0; i < n-2; ++i)  {
        if (i > 0 && num[i] == num[i-1]) continue;
        j = i+1, k = n-1;
        while (j < k) {
            sum = num[i] + num[j] + num[k] - target;
            if ( abs(sum) < abs(final-target) ) {
                final = sum + target;
            }
            
            if (sum > 0) k--;
            else if (sum < 0) j++;
            else if (sum == 0) {
                final = target;
                return final;
            }
        }
    }
    return final;
}

int main(){
    int n = 5;
    int s[] = {-3, -2, -5, 3, -4};
    vi tmp;
    for(int i = 0; i < n; ++i)
        tmp.push_back(s[i]);
    printVI(tmp);
        
    int result = threeSumClosest(tmp, -1);
    cout << result << endl;
       
    return 0;
}

//    (-1, 0, 1)
//    (-1, -1, 2)
