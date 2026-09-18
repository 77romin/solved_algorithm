import java.util.*;
import java.io.*;

public class Solution {	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int answer;
	private static int K;
	
	private static int[][] gear;
	private static int[] gearTop;
	
	private static int[][] cmd;
	
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			/* ----- Initialize ----- */
			answer = 0;
			gear = new int[4][8]; // 4개 톱니바퀴의 8개 톱니 상태
			gearTop = new int[4]; // 4개 톱니바퀴의 꼭대기 인덱스
			K = Integer.parseInt(br.readLine().trim());
			
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for(int j=0; j<8; j++)
					gear[i][j] = Integer.parseInt(st.nextToken());
			}

			/* ----- input Command ----- */
			for(int i=0; i<K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int gearIndex = Integer.parseInt(st.nextToken()) - 1; // gear Index
				int direction = Integer.parseInt(st.nextToken());
				rotate(gearIndex, direction);
			}

			/* ----- Calculate Top Wings ----- */
			calculate();
			/* ----- Record Output ----- */
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
	
	private static void rotate(int target, int direction) {
		/* ----- 각 톱니바퀴의 움직이는 방향 설정 ----- */
		// 0: 무회전, 1: 시계방향, -1: 반시계방향
		int[] rotateDir = new int[4]; // {0, 0, 0, 0}
		
		rotateDir[target] = direction;
		
		// propagation to RIGHT
		for(int i=target; i<3; i++) {
			int curRight = (gearTop[i]+2)%8;
			int nextLeft = (gearTop[i+1]+6)%8;
			
			// 같은 극이면 회전 전달 안함
			if(gear[i][curRight]==gear[i+1][nextLeft]) break;
			
			rotateDir[i+1] = -rotateDir[i];
		}
		
		// propagation to LEFT
		for(int i=target; i>0; i--) {
			int curLeft = (gearTop[i]+6)%8;
			int prevRight = (gearTop[i-1]+2)%8;

			// 같은 극이면 회전 전달 안함
			if(gear[i][curLeft]==gear[i-1][prevRight]) break;
			
			rotateDir[i-1] = -rotateDir[i];
		}
		
		/* ----- 실제로 회전 ----- */
		for(int i=0; i<4; i++) {
			if(rotateDir[i]==1) // 시계방향 회전!
				gearTop[i] = (gearTop[i]+7)%8;
			else if(rotateDir[i]==-1) // 반시계방향 회전!
				gearTop[i] = (gearTop[i]+1)%8;			
		}
		
	}
	
	private static void calculate() {
		for(int i=0; i<4; i++) {
			int top = gearTop[i];
			answer += gear[i][top] * (1<<i);
		}
	}
	
}