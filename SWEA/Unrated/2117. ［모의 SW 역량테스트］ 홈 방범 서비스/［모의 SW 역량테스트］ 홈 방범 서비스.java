import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M; // N: 지역 크기 한 변, M: 지불가능한 비용
    private static int[][] area; // 지역
    private static int ans; // 결과값
    
    private static void init() throws Exception {
        ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            area = new int[N][N];
            
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }
    }
    
    private static void install(int k) {
        int needPay = k*k + (k-1)*(k-1); // 운영비용
        
        for(int y=0; y<N; y++) {
            for(int x=0; x<N; x++) { // 기준점
                int cnt = 0;
                
                for(int i=0; i<N; i++)
                    for(int j=0; j<N; j++) // 비교점
                        if(Math.abs(i-y)+Math.abs(j-x) < k && area[i][j]==1)
                            cnt++;
                
                if(cnt*M>=needPay) // 운영비용 손실 안 날 때
                    ans = Math.max(ans, cnt); 
            }
        }
        
    }
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            
            int maxK = N+3;
            for(int k=1; k<=maxK; k++)
                install(k);
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n"); 
		}
        System.out.print(sb);
        br.close();
	}
}