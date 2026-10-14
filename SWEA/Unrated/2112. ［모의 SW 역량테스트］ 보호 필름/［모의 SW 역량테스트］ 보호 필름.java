import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int D, W, K;
    static int[][] film;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 약품을 투입하지 않고 이미 통과하는 경우 체크
            if (check()) {
                sb.append("#").append(test_case).append(" ").append(0).append("\n");
                continue;
            }

            // 최소 투입 횟수(1 ~ D)를 차례대로 늘려가며 탐색
            for (int target = 1; target <= D; target++) {
                if (dfs(0, 0, target)) {
                    sb.append("#").append(test_case).append(" ").append(target).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    // row: 현재 탐색 중인 행, cnt: 현재까지 투입한 횟수, target: 목표 투입 횟수
    static boolean dfs(int row, int cnt, int target) {
        // 목표 투입 횟수만큼 골랐다면 성능 검사 수행
        if (cnt == target) {
            return check();
        }

        // 더 이상 고를 행이 없으면 종료
        if (row >= D) {
            return false;
        }

        // 1. 현재 행을 건너뛰는 경우 (약품 미투입)
        if (dfs(row + 1, cnt, target)) {
            return true;
        }

        // 원래 행 상태 백업 (백트래킹을 위한 Deep Copy)
        int[] backup = film[row].clone();

        // 2. 현재 행에 약품 A(0) 투입
        Arrays.fill(film[row], 0);
        if (dfs(row + 1, cnt + 1, target)) {
            return true;
        }

        // 3. 현재 행에 약품 B(1) 투입
        Arrays.fill(film[row], 1);
        if (dfs(row + 1, cnt + 1, target)) {
            return true;
        }

        // 원상 복구
        film[row] = backup;

        return false;
    }

    // 모든 열에 대해 K개 이상 연속된 동일 특성이 있는지 검사
    static boolean check() {
        for (int c = 0; c < W; c++) {
            int consecutive = 1;
            boolean passed = false;

            for (int r = 0; r < D - 1; r++) {
                if (film[r][c] == film[r + 1][c]) {
                    consecutive++;
                } else {
                    consecutive = 1;
                }

                if (consecutive >= K) {
                    passed = true;
                    break;
                }
            }

            // K가 1인 경우 예외적으로 항상 통과 처리
            if (K == 1) {
                passed = true;
            }

            // 단 하나의 열이라도 조건을 만족하지 못하면 실패
            if (!passed) {
                return false;
            }
        }
        return true;
    }
}