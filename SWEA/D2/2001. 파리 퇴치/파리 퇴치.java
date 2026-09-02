import java.util.Scanner;

class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static int N;
    private static int M;
    private static int[][] flies;
    private static int maxKill;
    
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		int T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            killFlies();
            sb.append("#").append(test_case).append(" ")
                .append(maxKill)
                .append("\n");
		}
        System.out.print(sb);
	}
    
    private static void init() {
        maxKill=0;
        N = sc.nextInt();
        M = sc.nextInt();
        flies = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                flies[i][j] = sc.nextInt();
            }
        }
    }
    
    private static void killFlies() {
        for(int i=0; i<=N-M; i++) {
            for(int j=0; j<=N-M; j++) {
                int cnt = smash(i, j);
                maxKill = maxKill<cnt ? cnt : maxKill;
            }   
        }
    }
    
    private static int smash(int y, int x) {
        int cnt = 0;
        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                cnt += flies[y+i][x+j];
            }
        }
        return cnt;
    }
}

/**
 * 시간복잡도: O( (N-M+1)**2 x M**2)
 * 원리: 슬라이딩 윈도우 - MxM배열을 1 인덱스만큼 움직이며 해당 영역의 파리개수 최대값 갱신
 */