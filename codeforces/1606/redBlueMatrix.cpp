// 1606D - Red-Blue Matrix
// Imagine you fixed some cut and then colored one row red. Which rows can now be colored red or blue so that the condition on the left matrix is satisfied? If the row has at least one number greater or equal than the numbers in the red row, then the row must be red. Otherwise, it can be either red or blue.

//     However, imagine a weaker condition. Let's look only at the first cell in each row. Sort the rows by the first cell in them. Similarly, if a row is colored red, all the rows that are further in the sorted order should also be red, because they already have a greater or equal number in them.

//     It implies that after you sort the rows, the only possible colorings are: color some prefix of the rows in blue and the remaining suffix in red.

//     So there are n possible colorings and m possible cuts. If we learn to check if they are perfect in O(1), we can get the solution in O(nm).

//     Turns out, the condition "all numbers in the submatrix should be greater than all numbers in the other submatrix" is the same as "the minimum in the first submatrix should be greater than the maximum in the second submatrix".

//     Thus, you can first precalculate prefix and suffix minimums and maximums and check a coloring and a cut in O(1).

//     Overall complexity: O(nlogn+nm) per testcase.

//     Solution (awoo)
#include <bits/stdc++.h>

#define forn(i, n) for (int i = 0; i < int(n); i++)

    using namespace std;

const int INF = 1e9;

int main() {
	int tc;
	scanf("%d", &tc);
	while (tc--){
		int n, m;
		scanf("%d%d", &n, &m);
		vector<vector<int>> a(n, vector<int>(m));
		forn(i, n) forn(j, m) scanf("%d", &a[i][j]);
		vector<int> ord(n);
		iota(ord.begin(), ord.end(), 0);
		sort(ord.begin(), ord.end(), [&a](int x, int y){ return a[x][0] > a[y][0]; });
		vector<vector<int>> mxl(n, vector<int>(m, -INF));
		vector<vector<int>> mnr(n, vector<int>(m, INF));
		for (int i = n - 1; i >= 0; --i) forn(j, m){
			mxl[i][j] = a[ord[i]][j];
			if (i < n - 1) mxl[i][j] = max(mxl[i][j], mxl[i + 1][j]);
			if (j > 0) mxl[i][j] = max(mxl[i][j], mxl[i][j - 1]);
		}
		for (int i = n - 1; i >= 0; --i) for (int j = m - 1; j >= 0; --j){
			mnr[i][j] = a[ord[i]][j];
			if (i < n - 1) mnr[i][j] = min(mnr[i][j], mnr[i + 1][j]);
			if (j < m - 1) mnr[i][j] = min(mnr[i][j], mnr[i][j + 1]);
		}
		vector<int> mnl(m, INF), mxr(m, -INF);
		pair<int, int> ans(-1, -1);
		forn(i, n - 1){
			forn(j, m){
				mnl[j] = min(mnl[j], a[ord[i]][j]);
				if (j > 0) mnl[j] = min(mnl[j], mnl[j - 1]);
			}
			for (int j = m - 1; j >= 0; --j){
				mxr[j] = max(mxr[j], a[ord[i]][j]);
				if (j < m - 1) mxr[j] = max(mxr[j], mxr[j + 1]);
			}
			forn(j, m - 1) if (mnl[j] > mxl[i + 1][j] && mxr[j + 1] < mnr[i + 1][j + 1]){
				ans = {i, j};
			}
		}
		if (ans.first == -1){
			puts("NO");
			continue;
		}
		puts("YES");
		string res(n, '.');
		forn(i, n) res[ord[i]] = i <= ans.first ? 'R' : 'B';
		printf("%s %d\n", res.c_str(), ans.second + 1);
	}
	return 0;
}