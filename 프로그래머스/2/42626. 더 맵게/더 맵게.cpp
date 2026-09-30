#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    for(int scov : scoville)
        pq.push(scov);
    
    while(pq.size()>=2) {
        if(pq.top()>=K) break;
        
        int first_scov = pq.top();
        pq.pop();
        int second_scov = pq.top();
        pq.pop();
       
        pq.push(first_scov+second_scov*2);
        answer++;
    }
    
    return pq.top()>=K ? answer : -1;
}