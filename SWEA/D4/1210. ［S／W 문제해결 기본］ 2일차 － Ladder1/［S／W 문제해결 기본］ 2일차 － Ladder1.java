import java.util.*;
import java.io.*;

class Solution {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    
    private static int[][] ladders;
    private static int[] target;
    
    private static final int[] dx = {1, -1, 0}; // right, left, down
    private static final int[] dy = {0, 0, 1}; // right, left, down
    
    private static int answerPath;
    
	public static void main(String args[]) throws Exception {
		for(int test_case = 1; test_case <= 10; test_case++) {
            String t = br.readLine();
            init(); // Set Ladders
            findPath(); // Literally Find the Path to Target
            sb.append("#").append(test_case).append(" ")
                .append(answerPath).append("\n");
		}
        System.out.print(sb);
	}
    
    private static void findPath() {
        for(int s=0; s<100; s++) {
            if(answerPath != -1) break;
            if(ladders[0][s] == 0) continue;
            boolean[][] visited = new boolean[100][100];
            dfs(0, s, s, visited);
        }
    }
    
    private static void dfs(int cy, int cx, int pathNum, boolean[][] visited) { // param: currentY, currentX, pathNum, Double Array about visited
        if(!isIn(cy, cx)) return;
        if(ladders[cy][cx]==0) return;
        if(visited[cy][cx]) return;
        
        visited[cy][cx] = true;
        
        if(cy==target[0] && cx==target[1]) {
            answerPath = pathNum;
            return;
        }

        int ny=0, nx=0;
        for(int i=0; i<3; i++) {
            ny = cy+dy[i];
        	nx = cx+dx[i];
            if(!isIn(ny, nx)) continue;
            else if(ladders[ny][nx]==0) continue;
            else if(visited[ny][nx]) continue;
            else break;
        }
        dfs(ny, nx, pathNum, visited);
    }
    
    private static boolean isIn(int y, int x) {
        return y>=0 && y<100 && x>=0 && x<100;
    }
    
    private static void init() throws IOException {
        answerPath = -1;
        ladders =  new int[100][100];
        target = new int[2];
        for(int i=0; i<100; i++) {
            int j=0;
            st = new StringTokenizer(br.readLine());
            while(j<100) {
                ladders[i][j] = Integer.parseInt(st.nextToken());
                if(ladders[i][j]==2) {
                    target[0] = i;
                    target[1] = j;
                }
                j++;
            }
        }
    }
}

/**
 * Time Complexity : O(N**2)
 * Principal : DFS
 */