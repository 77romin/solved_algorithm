#include<bits/stdc++.h>
using namespace std;

static int dx [] = {1, 0, -1, 0};
static int dy [] = {0, 1, 0, -1};

static int INF = 1e9;

int solution(vector<vector<int> > maps) {
    int n = maps.size();
    int m = maps[0].size();
    
    vector<vector<int>> dp(n, vector<int>(m, INF));
    
    deque<pair<int, int>> q;
    q.push_back({0, 0});
    int cnt = 1;
    while(!q.empty()) {
        int qsize = q.size();
        cnt++;
        for(int i=0; i<qsize; i++) {
            auto [x, y] = q.front();
            q.pop_front();
            for(int j=0; j<4; j++) {
                int nx = x+dx[j];
                int ny = y+dy[j];
                
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue; // out of boundary check
                if(dp[ny][nx] != INF) continue; // visited check
                if(maps[ny][nx] == 0) continue; // wall check
                
                dp[ny][nx] = cnt;
                q.push_back({nx, ny});
            }
        }
    }
    
    if(dp[n-1][m-1] == INF) return -1;
    
    return dp[n-1][m-1];
}