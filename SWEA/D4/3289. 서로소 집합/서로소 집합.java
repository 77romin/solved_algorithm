import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    
    private static int N; // 원소 수
    private static int M; // 간선 수
    
    private static int[] rootParent; // 각 원소의 루트 부모 저장하는 배열
    
    private static int answer;
    
    private static void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        rootParent = new int[N+1]; // 1번~N번 원소
        for(int i=1; i<=N; i++) // 최초에는 각 원소 스스로만 원소가 된 그룹 설정
            rootParent[i] = i;
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            boolean merge = st.nextToken().equals("0") ? true : false; // 0: merge, 1: print what is contained
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!merge) // a, b가 같은 집합에 속하는지 확인하여 출력
                sb.append(findRoot(a)==findRoot(b)?1:0);
            else // a, b가 속한 집합을 서로 합치기
            	doMerge(a, b);
        }
        
        sb.append("\n");
    }
    
    private static void doMerge(int a, int b) {
        int rootParentA = findRoot(a); // a의 루트노드
        int rootParentB = findRoot(b); // b의 루트노드
        if(rootParentA == rootParentB) return; // 서로 부모가 같으면 아무일도 안 일어남
        rootParent[rootParentA] = rootParentB; // 서로 부모가 다르면 서로 부모를 일치화 시키기
    }
    
    private static int findRoot(int child) {
        if(rootParent[child] == child) return child; // 루트노드 본인이면 본인을 반환
        
        return rootParent[child] = findRoot(rootParent[child]);
    }
    
	public static void main(String args[]) throws Exception {
		int T=Integer.parseInt(br.readLine().trim());
		for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            run();
		}
        System.out.print(sb);
	}
}