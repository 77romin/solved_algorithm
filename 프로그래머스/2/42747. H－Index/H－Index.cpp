#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    
    sort(citations.begin(), citations.end(), greater<int>()); // 내림차순 정렬
    
    for(int h=1; h<=citations.size(); h++) {
        if(citations[h-1]>=h) {
            answer = h;
            //break;
        }
    }
    
    return answer;
}