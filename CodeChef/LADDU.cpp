#include <bits/stdc++.h>
#define ll long long
#define el << "\n"
#define FORD(i, n) for (int i = 0; i < n; i++)
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        string o;
        int res = 0;
        cin >> n >> o;
        while (n--)
        {
            string act;
            cin >> act;
            if (act == "CONTEST_WON")
            {
                int x = 0;
                cin >> x;
                res += 300;
                if (x < 20)
                    res += (20 - x);
            }
            else if (act == "TOP_CONTRIBUTOR")
                res += 300;
            else if (act == "BUG_FOUND")
            {
                int x;
                cin >> x;
                res += x;
            }
            else if (act == "CONTEST_HOSTED")
                res += 50;
        }
        if (o == "INDIAN")
            cout << res / 200 el;
        else
            cout << res / 400 el;
    }

    return 0;
}