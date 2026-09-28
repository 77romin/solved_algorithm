#include <bits/stdc++.h>
using namespace std;

int dx[] = {0, 0, 1, -1};
int dy[] = {-1, 1, 0, 0};
set<pair<pair<int, int>, pair<int, int>>> visited;

int checkCommand(char c) {
    if(c=='U') return 0;
    else if(c=='D') return 1;
    else if(c=='R') return 2;
    else if(c=='L') return 3;
    return -1;
}

bool isIn(int &x, int &y) {
    return x>=0 && x<=10 && y>=0 && y<=10;
}

int solution(string dirs) {
    int answer = 0;
    
    pair<int, int> cp = {5, 5};
    
    vector<char> command;
    for(int i=0; i<dirs.length(); i++) {
        command.push_back(dirs[i]);
    }
    
    for(char c : command) {
        int i = checkCommand(c);
        
        int x = cp.first;
        int y = cp.second;
        int nx = cp.first + dx[i];
        int ny = cp.second + dy[i];
        
        if(!isIn(nx, ny)) continue;
        
        if(visited.count({{x, y}, {nx, ny}}) == 0)
            answer++;
        
        visited.insert({{x, y}, {nx, ny}});
        visited.insert({{nx, ny}, {x, y}});
        
        cp.first = nx;
        cp.second = ny;
    }
    
    return answer;
}