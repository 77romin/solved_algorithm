import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    private static int N;
    private static int[][] farm;
    
    private static int center;
    
    private static int crops;
    
	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            harvest();
            
            sb.append("#").append(test_case).append(" ")
                .append(crops).append("\n");
		}
        System.out.print(sb);
	}
    
    private static void harvest() {
        int sp = center;
        int ep = center;
        
         for(int i=0; i<N; i++) {
             for(int j=sp; j<=ep; j++) {
                 crops += farm[i][j];
             }

             if(i<center) {
                 sp -= 1;
                 ep += 1;
             } else {
                 sp += 1;
                 ep -= 1;
             }
             
        }
    }
    
    private static void init() throws IOException {
        crops = 0;
        N = Integer.parseInt(br.readLine().trim());
        farm = new int[N][N];
        for(int i=0; i<N; i++) {
            String[] oneLine = br.readLine().trim().split("", N);
            for(int j=0; j<N; j++) {
                farm[i][j] = Integer.parseInt(oneLine[j]);
            }
        }
        center = (N-1)/2;
    }
}

/**
 * 시간복잡도: O(N^2)
 * 원리: 슬라이딩 윈도우(투포인터 방식 범위활용 2차원 영역 탐색)
 */