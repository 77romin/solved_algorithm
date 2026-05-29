import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                sb.append("* ");
            }
            if(i!=0)
                sb.append("\n");
        }
        for(int i=0; i<n; i++) {
            for(int j=n-i; j>0; j--) {
                sb.append("* ");
            }
            if(i!=n-1)
                sb.append("\n");
        }
        System.out.println(sb);
    }
}