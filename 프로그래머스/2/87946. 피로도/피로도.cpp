#include <bits/stdc++.h>
using namespace std;

void dfs(int curK, vector<vector<int>>& dungeons, vector<bool>& visited, int cnt, int& answer) {
    for(int i=0; i<dungeons.size(); i++) {
        if(visited[i]) continue;
        if(curK<dungeons[i][0]) continue;
        visited[i] = true;
        dfs(curK-dungeons[i][1], dungeons, visited, cnt+1, answer);
        visited[i] = false;
    }
    
    answer = max(answer, cnt);
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    vector<bool> visited(dungeons.size(), false);
    dfs(k, dungeons, visited, 0, answer);
    return answer;
}