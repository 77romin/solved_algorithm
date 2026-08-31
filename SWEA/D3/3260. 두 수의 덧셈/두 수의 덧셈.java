import java.util.*;
import java.math.BigInteger;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            sb.append(a.add(b)).append("\n");
		}
        System.out.println(sb);
	}
}