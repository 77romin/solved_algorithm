import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            boolean isPossible = true;
            
            int n = Integer.parseInt(sc.nextLine().trim());
            for(int i=0; i<n; i++) {
                String[] oneLineBits = sc.nextLine().trim().split(" ");

           		if(oneLineBits.length==2 && (oneLineBits[1].equals("+") || oneLineBits[1].equals("-") || oneLineBits[1].equals("*") || oneLineBits[1].equals("/") )) {
                    isPossible=false;
                    continue;
                }                                             
            }
            sb.append(isPossible?1:0).append("\n");
		}
        System.out.print(sb);
	}
}

/**
 * 시간복잡도: O(N)
 * 원리: leaf node가 숫자가 아닌 연산자일 경우 계산불가로 판단. 별도 트리구조 미생성하여 풀이
 */