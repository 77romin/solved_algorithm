#include <bits/stdc++.h>

using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    priority_queue<int> pq(works.begin(), works.end());
    
    while(n>0 && !pq.empty()) {
        int max_work = pq.top();
        pq.pop();
        
        if(max_work == 0) break;
        
        pq.push(max_work-1);
        n--;
    }
    
    while(!pq.empty()) {
        long long work = pq.top();
        pq.pop();
        answer += work*work;
    }
    
    return answer;
}

// Greedy + Max Heep(Priority Queue)