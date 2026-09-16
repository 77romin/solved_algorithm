import java.util.*;
import java.io.*;

class Solution {
    private static final int[] dx = {1, -1, -1, 1};
	private static final int[] dy = {1, 1, -1, -1};
    
    private static int N;
    private static int[][] cafe;
    private static boolean[] eaten;
    private static int ox, oy; // origin x, y
    
    private static int maxDesert;
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
            maxDesert = -1;
            N = Integer.parseInt(br.readLine().trim());
            cafe = new int[N][N];
            eaten = new boolean[101]; // 디저트 종류 100개 (1~100번)
            
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<N; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    oy = i;
                    ox = j;
                    eaten[cafe[i][j]]=true;
                    visitCafe(i, j, 1, 0); // 일단 첫 카페에서 하나 먹고 시작하자. 배고프니까
                    eaten[cafe[i][j]]=false;
                }
            }
            
            sb.append("#").append(test_case).append(" ").append(maxDesert).append("\n");
		}
        System.out.print(sb);
	}
    
    private static void visitCafe(int y, int x, int cnt, int d) {
        for(int nd=d; nd<4; nd++) {
            int ny = y+dy[nd];
            int nx = x+dx[nd];
            
            if(cnt>=4 && oy==ny && ox==nx) { // 원래 카페로 되돌아왔을 경우 (단, 제자리 맴도는 거 안된다)
                maxDesert = Math.max(maxDesert, cnt);
                return;
            }
            
            if(!isIn(ny, nx)) continue; // 범위 밖이면 패스
            if(eaten[cafe[ny][nx]]) continue; // 이미 먹어본 디저트면 패스
            
            eaten[cafe[ny][nx]] = true;
            visitCafe(ny, nx, cnt+1, nd);
            eaten[cafe[ny][nx]] = false;
        }
    }
            
    private static boolean isIn(int y, int x) {
        return y>=0 && y<N && x>=0 && x<N;
    }
}

/*
visited로 방문한 곳 재방문 안하게.
이동은 대각선으로!
dx = {1, -1, -1, 1}
dy = {1, 1, -1, -1}
*/