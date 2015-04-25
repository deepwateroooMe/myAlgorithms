#include <iostream>
#include <vector>
#include <stack>
#include <queue>
#include <cmath>
using namespace std;

typedef vector<vector<int> > vvi;

/*
  dfs to find all combination
  var candidates: candidates
  var size: candidate's length
  var start: because I sort candidates first, dfs() just need to start permutate from "start"
  don't need to start from every element. Then prevent duplicate combinations.
  var now: sum of present numbers
  var target: target
  var save: to save the combination of candidates
  var vvi: the final return vector
*/
void dfs(vector<int> candidates, int size, int start, int now, int target,
         vector<int> &save, vector<vector<int> > &vvi) {
    if (now == target)  {
        for (int i = 0; i < vvi.size(); ++i) {
            if (std::equal(vvi[i].begin(), vvi[i].begin() + vvi[i].size(), save.begin()))
                return;
        }
        vvi.push_back(save);
        return;
    }

    for (int i = start; i < size; ++i) {
        if (now + candidates[i] > target) // above the target value, so the rest(bigger) value is impossible
            return;       // because of this "return" step
        save.push_back(candidates[i]);

        // for Combination Sum, which each number can use "as many times as you want"
        //dfs(candidates, size, i, now + candidates[i], target, save, vvi); // why start from i instead of i+1 ?

        // for Combination Sum II, which each candidate element can only be used "ONCE" !!!!
        dfs(candidates, size, i+1, now + candidates[i], target, save, vvi); 
        save.pop_back();  // this clear step is very important
    }
    return;
}

// my C++ solution use DFS to search all possibility
vector<vector<int> > combinationSum(vector<int> &candidates, int target) {
    vector<vector<int> > vvi;
    vector<int> save;

    // must sort first! then even though there's same element in candidates,
    // it will not produce duplicate combination
    sort(candidates.begin(), candidates.end());
    dfs(candidates, candidates.size(), 0, 0, target, save, vvi);
    return vvi;
}

int main(){


    return 0;
}
