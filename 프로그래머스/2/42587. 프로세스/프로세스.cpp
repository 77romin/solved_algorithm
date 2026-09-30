#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    
    priority_queue<int, vector<int>> pq; // 내림차순
    queue<pair<int, int>> q;
    int idx=0;
    for(int p : priorities) {
        pq.push(p);
        q.push({idx++, p});
    }
    
    while(!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();
        if(cur.second == pq.top()) {
            pq.pop();
            answer++;
            if(cur.first == location)
                break;
        } else {
            q.push(cur);
        }
    }
    
    
    return answer;
}