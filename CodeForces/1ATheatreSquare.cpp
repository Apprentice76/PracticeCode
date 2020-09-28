#include <bits/stdc++.h>
#include <cmath>
#define FOR(i, j, k, in) for(int i=j; i<k; i+=in)
#define FORD(i, j) FOR(i, 0, j, 1)
#define RFOR(i, j, k, in) for(int i=j; i>=k; i-=in)
#define RFORD(i, j) RFOR(i, 0, j, 1)


int main() {
    long long x, y, k, res;
    std::cin >> x >> y >> k;
    if (x%k == 0) res = x/k;
    else res = x/k + 1;
    if (y%k == 0) res *= y/k;
    else res*= (y/k + 1);
    std::cout << res;
    return 0;
}