#include <bits/stdc++.h>
#define ll long long
#define el cout<<"\n"
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
        int res=0;
        while (n/5) {
            res += n/5;
            n/=5;
        }
        cout << res;
        el;
    }
    
    return 0;
}