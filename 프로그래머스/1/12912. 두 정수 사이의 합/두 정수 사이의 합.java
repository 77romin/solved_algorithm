class Solution {
    public long solution(int a, int b) {
        if(a==b) return a;
        
        long answer = 0;
        int small = a<b? a:b;
        int big = a>b? a:b;
        
        for(int i=small; i<=big; i++) {
            answer += i;
        }
        return answer;
    }
}