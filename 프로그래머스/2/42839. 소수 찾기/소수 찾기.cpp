#include <bits/stdc++.h>
using namespace std;

unordered_set<int> unique_nums;
bool visited[7]; // numbers는 1이상 7이하의 문자열

bool isPrime(int n) {
    if(n<2) return false;
    for(int i=2; i<=sqrt(n); i++) {
        if(n%i == 0) return false;
    }
    return true;
}

void dfs(string numbers, string current) {
    if(!current.empty()) {
        unique_nums.insert(stoi(current));
    }
    
    for(int i=0; i<numbers.length(); i++) {
        if(!visited[i]) {
            visited[i] = true;
            dfs(numbers, current+numbers[i]);
            visited[i] = false;
        }
    }
}

int solution(string numbers) {
    unique_nums.clear();
    
    dfs(numbers, "");
    
    int answer = 0;
    for(int num : unique_nums) {
        if(isPrime(num)) answer++;
    }
    
    return answer;
}