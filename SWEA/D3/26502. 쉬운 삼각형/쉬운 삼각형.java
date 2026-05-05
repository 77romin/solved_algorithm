import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            for(int i=0; i<N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            int max = 0;

            for(int i=0; i<N-2; i++) {
                for(int j=0; j<N-1; j++) {
                    for(int k=0; k<N; k++) {
                        int x1 = arr[i][1]; int y1 = arr[i][0];
                        int x2 = arr[j][1]; int y2 = arr[j][0];
                        int x3 = arr[k][1]; int y3 = arr[k][0];

                        if(x1==x2) {
                            if(y1==y2) continue;
                            if(x1==x3) continue;
                            if(y2==y3) { max = max<Math.abs((y1-y2)*(x2-x3))?Math.abs((y1-y2)*(x2-x3)):max; }
                        } else if(x2==x3) {
                            if(y2==y3) continue;
                            if(x2==x1) continue;
                            if(y1==y3) { max = max<Math.abs((x1-x3)*(x2-x3))?Math.abs((x1-x3)*(x2-x3)):max; }
                        } else if(x3==x1) {
                            if(y3==y1) continue;
                            if(x3==x2) continue;
                            if(y1==y2) { max = max<Math.abs((x1-x2)*(y3-y1))?Math.abs((x1-x2)*(y3-y1)):max; }
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}