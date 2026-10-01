#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int aIndex = 0;
    int bIndex = 0;
    
    while(bIndex<B.size()) {
        if(A[aIndex]<B[bIndex]) {
            aIndex++;
            bIndex++;
            answer++;
        } else {
            bIndex++;
        }
    }

    return answer;
}

/*
 * 투 포인터 사용 / 두 배열을 오름차순 정렬하고 A의 검사인덱스와 B의 검사인덱스 비교하며 각자 증가시키기
 * 시간복잡도: O(NlogN) --> sort알고리즘 때문
 */