class Solution {
    public int solution(int n) {
        return fibonacci(n);
    }
    
    // DFS는 시간초과가 난다!
    // public int fibonacci(int n) {
    //     if(n>=2)
    //         return fibonacci(n-1)+fibonacci(n-2);
    //     else
    //         return n%1234567;
    // }
   
    // DP
    public int fibonacci(int n) {
        int[] dp = new int[n+1]; 
        // [0]: f(0)==0, [1]: f(1)==1, [2]: f(2)=f(1)+f(0), [3]: f(3)=f(2)+f(1), ...
        // [0]: 0, [1]: 1, [2]: [1]+[0], [3]: [2]+[1], ...
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<n+1; i++)
            dp[i] = (dp[i-2]+dp[i-1])%1234567;
        return dp[n];
    }
    
}

// 재귀(DFS)로 한번 풀어보고, DB로도 풀어보자.