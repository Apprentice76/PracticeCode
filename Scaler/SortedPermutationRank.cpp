#include <bits/stdc++.h>
// #include <string.h>

class Solution {
    Solution();
    int findRank(std::string A);
};

long fact(int x) {
    return x < 3 ? x : x*fact(x-1);
}

void update(int count[], char c) {
    for (int i=c; i<256; i++) count[i]--;
}
#define mod 1000003

int Solution::findRank(std::string A) {
    int count[256] = {0};
    int len = A.length();
    // char arr[len+1];
    // for (int)
    for (int i=0; i<len; i++) count[A[i]]++;
    for (int i=1; i<256; i++) count[i] += count[i-1];
    
    int rank=1;
    long perms=fact(len);
    
    for(int i=0; i<len; i++) {
        perms /= len - i;
        rank += (perms*count[A[i] - 1])%mod;
        update(count, A[i]);
    }
    return rank%mod;
}