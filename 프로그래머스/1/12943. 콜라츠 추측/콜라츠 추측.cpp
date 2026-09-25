#include <bits/stdc++.h>

using namespace std;

int solution(int num) {
    int answer = 0;
    
    long long n = num;
    
    if(num==1)
        return answer;

    while(n>1) {
        if(answer>500)
            return -1;
        
        answer++;
        n = n%2==0 ? n/2 : n*3+1;
    }

    return answer;
}