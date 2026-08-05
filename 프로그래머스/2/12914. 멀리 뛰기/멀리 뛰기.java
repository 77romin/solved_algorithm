class Solution {
    public long solution(int n) {
        if(n<=2)
            return n;
        
        long[] dp = new long[n];
        
        dp[0]=1; // 1칸 이동
        dp[1]=dp[0]+1; // 1에서 한칸 이동, 0에서 두칸 이동
        // dp[3]=dp[2]+dp[1] // 2에서 한칸 이동, 1에서 두칸 이동
        
        for(int i=2; i<n; i++)
            dp[i]=(long)((dp[i-1]+dp[i-2])%1234567);
        
        return dp[n-1];
    }
}

// DP로 풀면 될 듯