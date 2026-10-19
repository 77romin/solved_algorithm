import java.util.*;
import java.io.*;

class Solution {
    static int N; // 학생 수
    static int M; // 비교 수
    static int[][] adj; // 인접정점 맵
    
    static int cnt;
    static int ans;
    
    static void gtDFS(int cur, boolean[] visited) {
        
        visited[cur] = true;
        for(int i=1; i<=N; i++) {
            if(visited[i] || adj[cur][i]==0) continue; // 이미 탐색되었거나 인접 정점이 아닌 경우
            // 인접정점이면서 탐색되지 않은 경우
            ++cnt; // 나보다 큰 학생수 카운팅
            gtDFS(i, visited);
        }
        
    }
    
    static void ltDFS(int cur, boolean[] visited) {
        
        visited[cur] = true;
        for(int i=1; i<=N; i++) {
            if(visited[i] || adj[i][cur]==0) continue; // 이미 탐색되었거나 인접 정점이 아닌 경우
            // 인접정점이면서 탐색되지 않은 경우
            ++cnt; // 나보다 큰 학생수 카운팅
            ltDFS(i, visited);
        }
        
    }
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());
            
            ans = 0;
            adj = new int[N+1][N+1];

            for(int i=0; i<M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());
                adj[small][big] = 1; // small보다 big이 키가 크다
            }
            
            for(int i=1; i<=N; i++) {
                cnt = 0;
                boolean[] visited = new boolean[N+1];
                gtDFS(i, visited);
                ltDFS(i, visited);
                if(cnt == N-1)  ++ans;
            }
            
            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
	}
}