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
			System.out.printf("#%d %d\n", test_case, run(sc));
		}
	}
    private static int run(Scanner sc) {
        String[] strBits = sc.next().split("");
        boolean isZero = true;
        int cnt = 0;
        for(String strBit:strBits) {
            if(isZero && strBit.equals("1")) {
                isZero = false;
                cnt++;
            } else if(!isZero && strBit.equals("0")) {
                isZero = true;
                cnt++;
            }
        }
        return cnt;
    }
}