#include <bits/stdc++.h>
using namespace std;

int solution(vector<vector<int> > land) {
    int n = land.size();
    
    vector<vector<int>> dp(n, vector<int>(4, 0));
    
    for(int i=0; i<4; i++)
        dp[0][i] = land[0][i];
    
    for(int i=1; i<n; i++) {
        for(int j=0; j<4; j++) {
            dp[i][j] += land[i][j];
            int maxPrev = 0;
            for(int k=0; k<4; k++) {
                if(j==k) continue;
                maxPrev = max(maxPrev, dp[i-1][k]);
            }
            dp[i][j] += maxPrev;
            
        }
    }
    
    int answer = 0;
    for(int i=0; i<4; i++)
        answer = answer>=dp[n-1][i] ? answer : dp[n-1][i];
    return answer;
}

// 각 행에서 각 열의 결과값 중 큰 값을 저장하는 식으로 DP를 사용해야겠다.