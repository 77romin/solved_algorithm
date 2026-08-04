class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle[triangle.length-1].length];
        
        dp[0] = triangle[0][0];
        for(int i=1; i<triangle.length; i++) { // 행
            int[] nLine = new int[triangle[i].length];
            for(int j=0; j<triangle[i].length-1; j++) { // 열
                nLine[j] = triangle[i][j]+dp[j] > nLine[j] ? triangle[i][j]+dp[j] : nLine[j];
                nLine[j+1] = triangle[i][j+1]+dp[j] > nLine[j+1] ? triangle[i][j+1]+dp[j] : nLine[j+1];
            }
            for(int j=0; j<nLine.length; j++)
                dp[j] = nLine[j];
        }
        
        int max = 0;
        for(int num : dp)
            max = num>max ? num : max;
        
        return max;
    }
}