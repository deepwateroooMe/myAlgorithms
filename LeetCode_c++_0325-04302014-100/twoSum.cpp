/*
  Given an array of integers, find two numbers such that they add up to a specific target number.

  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

  You may assume that each input would have exactly one solution.

  Input: numbers={2, 7, 11, 15}, target=9
  Output: index1=1, index2=2
*/

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> twoSum(vector<int> &numbers, int target) {
    unordered_map<int, int> hash;
    vector<int> result;
        
    for (int i = 0; i < numbers.size(); ++i) {
        if ( hash.count(target - numbers[i]) )  {
            result.push_back(hash[target-numbers[i]]+1);
            result.push_back(i+1);
            break;
        } else  {
            hash[numbers[i]] = i;
        }
    }
    return result;
}

int main() {
    int x[] = {0, 4, 3, 0};
    vector<int> numbers, result;
    for (int i = 0; i < 4; ++i)
        numbers.push_back(x[i]);
    result = twoSum(numbers, 0);
    cout << result[0] << "\t" << result[1] << endl;
    return 0;
}
