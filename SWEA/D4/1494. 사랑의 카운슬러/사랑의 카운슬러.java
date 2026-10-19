import java.util.*;
import java.io.*;

class Solution {
    static int N;
    static Worm[] worms;
    static long ans;
    
    static class Worm {
        long x, y;
        Worm(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static void comb(int idx, int cnt, boolean[] selected) {
        if(cnt==N/2) {
            long sumX=0, sumY=0;
            
            for(int i=0; i<N; i++) {
                if(selected[i]) {
                	sumX += worms[i].x;
                	sumY += worms[i].y;
                } else {
                    sumX -= worms[i].x;
                	sumY -= worms[i].y;
                }
            }
            
            long vec = sumX*sumX + sumY*sumY;
            ans = Math.min(ans, vec);
            return;
        }
        
        // 남은 개수를 다 골라도 N/2개를 채울 수 없는 경우 가지치기
        if(idx == N || cnt + (N-idx) < N/2) return;
        
        // 현재 지렁이를 선택하는 경우
        selected[idx] = true;
        comb(idx+1, cnt+1, selected);
        
        // 현재 지렁이를 선택하지 않는 경우
        selected[idx] = false;
        comb(idx+1, cnt, selected);
    }
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
		int T = Integer.parseInt(br.readLine().trim());

		for(int test_case = 1; test_case <= T; test_case++) {
            ans = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());
            
            worms = new Worm[N];
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                long x = Long.parseLong(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                worms[i] = new Worm(x, y);
            }
               
            comb(0, 0, new boolean[N]); // 조합 탐색 시작 (idx: 현재 탐색중인 인덱스, cnt: 고른 지렁이 수) 
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");

		}
        
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
	}
}