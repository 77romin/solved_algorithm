#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    deque<int> dq;
    vector<bool> visited(n, false);
    
    for(int i=0; i<n; i++) {
        if(visited[i]) continue;
        
        visited[i] = true;
        dq.push_back(i);
        
        while(!dq.empty()) {
            int node = dq.front();
            dq.pop_front();
            for(int j=0; j<n; j++) {
                if(node==j) continue; // 자기자신 패스
                if(computers[node][j]==0) continue; // 미연결 패스
                if(visited[j]) continue; // 기방문 패스
                visited[j] = true;
                dq.push_back(j);
            }
        }
        answer++;
    }
    
    
    return answer;
}

// BFS를 활용