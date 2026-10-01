#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, -1, 1};
int dy[] = {1, -1, 0, 0};

int n, m;

struct Point {
    int y, x, cnt;
};

bool isIn(int y, int x) {
    return y>=0 && x>=0 && y<n && x<m;
}

int solution(vector<string> board) {
    n = board.size(); // 세로개수
    m = board[0].length(); // 가로개수

    pair<int, int> r, g;    
    vector<vector<bool>> visited(n, vector<bool>(m, false));
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(board[i][j]=='R') r = {i, j};
            else if(board[i][j]=='G') g = {i, j};
        }
    }
    
    queue<Point> q;
    q.push({r.first, r.second, 0});
    visited[r.first][r.second] = true;
    
    while(!q.empty()) {
        Point cur = q.front();
        q.pop();
        
        if(cur.y == g.first && cur.x == g.second) {
            return cur.cnt;
        }
        
        for(int i=0; i<4; i++) {
            int nx = cur.x;
            int ny = cur.y;
            
            while(true) {
                int next_nx = nx + dx[i];
                int next_ny = ny + dy[i];
                
                if(!isIn(next_ny, next_nx)||board[next_ny][next_nx]=='D') break;
                
                ny = next_ny;
                nx = next_nx;
            }
            
            if(visited[ny][nx]) continue;
            
            visited[ny][nx]=true;
            q.push({ny, nx, cur.cnt+1});
        }
    }
    
    return -1;
}