#include <bits/stdc++.h>
#define ll long long
#define el <<"\n"
#define FORD(i, n) for (int i=0; i<n; i++)
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        while (n--) {
            int i, tot, q;
            cin >> i >> tot >> q;
            int res = tot/2;
            if (!(tot&1)) cout<< res el;
            else {
                if (i == q) cout<< res el;
                else cout<< res+1 el;
            }
        }
    }
    
    return 0;
}