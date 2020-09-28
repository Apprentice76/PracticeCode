#include <bits/stdc++.h>
#define ll long long
using namespace std;

int getMaxRevenue(ll arr[]);

int main()
{   ll n, i=0;
    cin >> n;
    ll arr[n];
    while (n--) {
        cin >> arr[i++];
    }
    int res = getMaxRevenue(arr);
    cout << res;
    return 0;
}

int getMaxRevenue(ll arr[]) {
    int res = 0;
    
    return res;
}