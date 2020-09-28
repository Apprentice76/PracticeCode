#include <bits/stdc++.h>
#define ll  long long
using namespace std;

void reverse(ll num);

int main() {
	int t;
    cin >> t;
    while (t--) {
        ll n;
        cin >> n;
        reverse(n);
    }
	return 0;
}

void reverse(ll x) {
    ll rev=0;
    ll num=x;
    while(num) {
        int r = num%10;
        rev = 10*rev + r;
        num/=10;
    }
    cout << rev << endl;
}