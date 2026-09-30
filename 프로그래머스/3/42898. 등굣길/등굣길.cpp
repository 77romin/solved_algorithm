#include <bits/stdc++.h>

using namespace std;

int dx[] = {1, 0}; // 우, 하
int dy[] = {0, 1}; // 우, 하

int solution(int m, int n, vector<vector<int>> puddles) { // m는 가로, n은 세로
    int cnt = 0;
    
    vector<vector<int>> dp(m+1, vector<int>(n+1, 0));
    vector<vector<bool>> noGo(m+1, vector<bool>(n+1, false));
    
    for(vector<int> &puddle : puddles) {
        int px = puddle[0];
        int py = puddle[1];
        noGo[px][py] = true;
    }
    
    for(int i=1; i<=m; i++) {
        if(noGo[i][1]) break;
        dp[i][1] = 1;
    }
    for(int i=1; i<=n; i++) {
        if(noGo[1][i]) break;
        dp[1][i] = 1;
    }
    
    for(int y=2; y<=n; y++) {
        for(int x=2; x<=m; x++) {
            if(noGo[x][y]) continue;
            dp[x][y] = (dp[x-1][y]%1000000007 + dp[x][y-1]%1000000007)%1000000007;
        }
    }
    
    return dp[m][n];
}