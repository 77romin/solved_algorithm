import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chk = 1;
        for(int i=0; i<5; i++) {
            int n = sc.nextInt();
            if(n%3!=0) {
                chk = 0;
            }
        }
        System.out.println(chk);


    }
}