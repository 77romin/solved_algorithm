import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
            int maxUp = 0;
            int maxDown = 0;
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++) arr[i] = sc.nextInt();
          	for(int i=0; i<n-1; i++) {
                int distinct = arr[i]-arr[i+1];
                if(distinct>0)
                    maxDown = maxDown<distinct?distinct:maxDown;
                else if(distinct<0)
                    maxUp = maxUp<Math.abs(distinct)?Math.abs(distinct):maxUp;
            }
            
			System.out.printf("#%d %d %d\n", test_case, maxUp, maxDown);
		}
	}
}