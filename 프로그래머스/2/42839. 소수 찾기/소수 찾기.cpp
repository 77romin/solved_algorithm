#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n) {
    if(n<2) return false;
    for(int i=2; i<=sqrt(n); i++) {
        if(n%i==0) return false;
    }
    return true;
}

int solution(string numbers) {
    unordered_set<int> unique_nums;
    
    sort(numbers.begin(), numbers.end());
    
    do {
        for(int i=1; i<=numbers.length(); i++) {
            int num = stoi(numbers.substr(0, i));
            unique_nums.insert(num);
        }
    } while(next_permutation(numbers.begin(), numbers.end()));
    
    int answer = 0;
    for(int num : unique_nums) {
        if(isPrime(num)) answer++;
    }
    
    return answer;
}