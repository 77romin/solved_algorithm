import java.util.*;
import java.io.*;

class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int N;
    private static long[] h;
    
    private static long rangeCnt;
    
    private static void init() throws IOException {
        rangeCnt = 0;
        N = sc.nextInt();
        h = new long[N];

        for(int i=0; i<N; i++) {
            h[i] = sc.nextLong();
        }
    }
    
    private static void split_conquer() {
        for(int i=1; i<N-1; i++) {
            if(h[i]-h[i-1]>0 && h[i]-h[i+1]>0) { // top of the mountain
                int s = i-1;
                int e = i+1;
                while(s>=1) {
                    if(h[s]>h[s-1])
                        s--;
                    else
                        break;
                }
                while(e<N-1) {
                    if(h[e]>h[e+1])
                        e++;
                    else
                        break;
                }
                rangeCnt += (long) (i-s)*(e-i);
            }
        }
    }
    
	public static void main(String args[]) throws Exception {
		int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
            init();
            split_conquer();
            sb.append("#").append(test_case).append(" ").append(rangeCnt).append("\n");
		}
        System.out.print(sb);
	}
}

/**
 * 시간복잡도: O(N)
 * 원리: 단조성을 활용한 투 포인터 / 봉우리 중심 탐색
 */