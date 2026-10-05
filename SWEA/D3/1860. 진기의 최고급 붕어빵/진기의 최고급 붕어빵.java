import java.util.*;
import java.io.*;

class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, K;
    private static int[] customer;
    
    private static void init() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        customer = new int[N];
        st = new StringTokenizer(br.readLine().trim());
        for(int i = 0; i < N; i++) {
            customer[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    private static boolean isPossible() {
        // 도착 시간 기준 오름차순 정렬
        Arrays.sort(customer);
        
        for (int i = 0; i < N; i++) {
            // customer[i] 시점까지 만들어진 총 붕어빵 수
            int totalFishBread = (customer[i] / M) * K;
            
            // i번째 손님을 포함해 지금까지 필요한 붕어빵은 (i + 1)개
            if (totalFishBread < i + 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            init();
            sb.append("#").append(test_case).append(" ")
              .append(isPossible() ? "Possible" : "Impossible").append("\n");
        }
        System.out.print(sb);
    }
}