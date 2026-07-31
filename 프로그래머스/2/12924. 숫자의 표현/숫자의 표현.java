class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int firstN = i;
            int sum = 0;
            while(sum<n)
                sum += firstN++;
            answer = sum==n?answer+1:answer;
        }
        return answer;
    }
}