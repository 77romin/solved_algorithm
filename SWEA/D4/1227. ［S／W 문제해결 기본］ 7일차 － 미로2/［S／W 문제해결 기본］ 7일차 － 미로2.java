import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] maze;
    private static int[][] dp;
    private static boolean isPossible;

    private static int sy, sx;
    private static int ey, ex;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= 10; test_case++) {
            init();
			mazeRun(sy, sx, 0); // y, x, time
            sb.append("#").append(test_case).append(" ").append(isPossible?1:0).append("\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isIn(int y, int x) {
        return y>=0 && y<100 && x>=0 && x<100;
    }
    
    private static void mazeRun(int y, int x, int time) {
        if(isPossible) return;
        
        if(y==ey && x==ex) {
            isPossible = true;
            return;
        }
        
        for(int d=0; d<4; d++) {
            int ny = y+dy[d];
            int nx = x+dx[d];
            
            if(!isIn(ny, nx)) continue; // 경계벗어나면 패스, 가지치기
            if(maze[ny][nx]==1) continue; // 벽이면 패스, 가지치기
            if(dp[ny][nx]<=time+1) continue; // 메모이제이션을 통한 가지치기
            
            int tmp = dp[ny][nx];
            dp[ny][nx] = time+1;
            mazeRun(ny, nx, time+1);
            dp[ny][nx] = tmp;            
        }
    }
    
    private static void init() throws IOException {
        String dump = br.readLine();

        isPossible = false;
        maze = new int[100][100];
        
        for(int i=0; i<100; i++) {
            String[] oneLineBits = br.readLine().trim().split("");
            for(int j=0; j<100; j++) {
                maze[i][j] = Integer.parseInt(oneLineBits[j]);
                if(maze[i][j]==2) {
                    sy=i; sx=j;
                } else if(maze[i][j]==3) {
                    ey=i; ex=j;
                }
            }
        }
        
        dp = new int[100][100];
         for(int i=0; i<100; i++)
              for(int j=0; j<100; j++) 
                  dp[i][j] = Integer.MAX_VALUE;
    }
}
        
// DP Memoization 사용, DFS