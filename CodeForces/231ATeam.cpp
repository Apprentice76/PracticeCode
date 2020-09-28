#include <bits/stdc++.h>
#include <cmath>
#define FOR(i, j, k, in) for (int i = j; i < k; i += in)
#define FORD(i, j) FOR(i, 0, j, 1)
#define RFOR(i, j, k, in) for (int i = j; i >= k; i -= in)
#define RFORD(i, j) RFOR(i, 0, j, 1)

using namespace std;

int main() {
    int n;
    cin >> n;
    int res = 0;
    for (int i=0; i<n; i++) {
        int counter = 0;
        for (int j=0; j<3; j++) {
            int solve;
            cin >> solve;
            if (solve == 1) counter++;
        }
        if (counter > 1) res++;
    }
    cout << res;
    return 0;
}