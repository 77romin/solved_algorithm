import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    private static int V; // 정점의 개수 (0은 안 씀)
    private static int E; // 간선의 개수
    
    private static ArrayList<Integer>[] graph; // 각 정점 자리에 자식 정점 인덱스 저장(리스트)
    private static int[] edge; // 각 정점으로 들어오는 진입차수 저장
    
    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++)
            graph[i] = new ArrayList<>();
        
        edge = new int[V+1];
        
        st = new StringTokenizer(br.readLine().trim());
        for(int i=0; i<E; i++) {
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[p].add(c); // 각 정점에 자식 정점 인덱스 저장
            edge[c]++; // 자식 정점 진입차수 증가
        }
    }
    
    private static void process() {
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=1; i<=V; i++) {
            if(edge[i] == 0) // 진입차수가 0인 정점은 '루트 노드'이다! 그러므로 모두 큐에 넣어주자. (작업 최우선순위로!)
                q.offer(i);
        }
        
        while(!q.isEmpty()) {
            int parent = q.poll();
            sb.append(parent).append(" ");
            
            for(int child : graph[parent]) {
                edge[child]--;
                if(edge[child]==0)
                    q.offer(child);
            }
        }
        
    }
    
	public static void main(String args[]) throws Exception {
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            sb.append("#").append(test_case).append(" ");
            process();
            sb.append("\n");
		}
        System.out.print(sb);
	}
}