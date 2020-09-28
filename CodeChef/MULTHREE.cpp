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
        ll k;
        int d0, d1;
        cin >> k >> d0 >> d1;
        int d2 = (d0 + d1)%10;
        int d3 = (d0 + d1 +d2)%10;
        int tmp = 0;
        int sum = 0;
        switch(d3) {
            case 0:
                break;
            case 2:
                tmp = 3;
                break;
            case 6:
                tmp = 4;
                break;
            case 8:
                tmp = 5;
                break;
            case 4:
                tmp = 6;
                break;
        }

        if (k > tmp)
        {
            int sum_till_tmp = 0;
            FORD(i, tmp)
            {
                if (i == 0)
                    sum_till_tmp += d0;
                else if (i == 1)
                    sum_till_tmp += d1;
                else
                    sum_till_tmp += sum_till_tmp % 10;
            }

            int l_digits = (k - tmp) % 4;
            int l_sum = 0;
            switch (l_digits)
            {
            case 0:
                break;
            case 1:
                l_sum = 2;
                break;
            case 2:
                l_sum = 6;
                break;
            case 3:
                l_sum = 14;
                break;
            }
            sum = sum_till_tmp + l_sum + ((k - tmp) >> 2) * 20;
        }

        else
        {
            sum = d0 + d1;
            k -= 2;
            while (k--)
            {
                sum += sum % 10;
            }
        }
        int tmp = 0;
        int tmp_sum = sum;
        while (tmp_sum) {
            tmp += tmp_sum%10;
            tmp_sum /= 10;
        }
    }
    return 0;
}