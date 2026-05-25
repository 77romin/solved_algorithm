import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int maxCnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int cnt=0;
                for(int i1=0; i1<3; i1++) {
                    for(int j1=0; j1<3; j1++) {
                        if(i+i1<n && j+j1<n && grid[i+i1][j+j1] == 1)
                            cnt++;
                    }
                }
                maxCnt = Math.max(maxCnt, cnt);
                
            }
        }
        System.out.println(maxCnt);
    }
}