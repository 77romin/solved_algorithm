import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int cnt;
    
    private static void cal(long num) {
        while(num>2) {
            long sqrt = (long) Math.sqrt(num);
            if(sqrt*sqrt == num) {
                num = sqrt;
                cnt++;
            } else {
                long nextNum = (sqrt+1)*(sqrt+1);
                cnt += nextNum-num;
                num = nextNum;
            }
        }
    }
    
	public static void main(String args[]) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            long n = Long.parseLong(br.readLine().trim());
            cal(n);
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
		}
        System.out.print(sb);
	}
}