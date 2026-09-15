import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] cheese;
    private static boolean[][] isEaten;
    private static boolean[][] isSelected;
    
    private static int maxChunks;
    
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    private static void chunking(int y, int x) {
       isSelected[y][x] = true; // 방문 처리

        for(int i=0; i<4; i++) {
            int ny = y+dy[i];
            int nx = x+dx[i];
            
            if(!isIn(ny, nx)) continue; // 경계 밖이면 패스
            
            if(isSelected[ny][nx] || isEaten[ny][nx]) continue; // 이미 방문했거나 먹힌 치즈면 패스
            
            chunking(ny, nx);
        }
    }
    
    private static void eatCheese(int day) {        
        if(day>100) // 최대 100일
            return;
        
        isSelected = new boolean[N][N];

        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                if(cheese[i][j]==day)
                    isEaten[i][j] = true;
        
        int curChunks = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!isSelected[i][j] && !isEaten[i][j]) {
        			chunking(i, j); // 덩어리 세기
                    curChunks++;
                }
            }
        }
        
        if(curChunks == 0) return; // 치즈가 모두 먹혔을 경우 더이상 진행하지 않음
        
        maxChunks = Math.max(maxChunks, curChunks);
        eatCheese(day+1);
    }
    
    private static void init() throws IOException {
        maxChunks = 1; // 기본은 한 덩어리!
        
        N = Integer.parseInt(br.readLine().trim());
        cheese = new int[N][N]; // 치즈 맛지도
        isEaten = new boolean[N][N]; // 요정이 먹은 치즈의 부분
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            for(int j=0; j<N; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            init();
            eatCheese(1);
            sb.append("#").append(test_case).append(" ").append(maxChunks).append("\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isIn(int y, int x) {
        return y>=0 && y<N && x>=0 && x<N;
    }
}

/**
 * 시간복잡도: O(N^2)
 * 원리 : DFS
 */