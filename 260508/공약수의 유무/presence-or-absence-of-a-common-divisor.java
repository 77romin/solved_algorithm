import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = 0;
        for(int i=a; i<=b; i++)
            if(1920%i==0 && 2880%i==0) 
                result = 1;
        System.out.println(result);
    }
}