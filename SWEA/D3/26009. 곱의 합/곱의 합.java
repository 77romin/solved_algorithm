import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long result = sum(a)%998244353;
            result = (result*sum(b))%998244353;
            result = (result*sum(c))%998244353;
			System.out.println(result);
		}
	}
    
    private static long sum(long n) {
        long sumResult = 0;
        n = n%998244353;
        sumResult = (n*n+n)/2;
        sumResult %= 998244353;
        return sumResult;
    }
}