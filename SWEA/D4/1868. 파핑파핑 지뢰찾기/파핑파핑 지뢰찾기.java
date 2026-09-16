import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static char[][] area;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            area = new char[N][N];

            for (int i = 0; i < N; i++) {
                area[i] = br.readLine().toCharArray();
            }

            int cnt = 0;

            // 1. 주변 지뢰가 0인 칸을 먼저 찾아 재귀 탐색 시작
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == '.' && getMineCnt(i, j) == 0) {
                        cnt++;
                        findMine(i, j);
                    }
                }
            }

            // 2. 0의 연쇄작용으로 열리지 않은 남아있는 빈 칸 처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (area[i][j] == '.') {
                        cnt++;
                    }
                }
            }

            System.out.println("#" + tc + " " + cnt);
        }
    }

    // 8방향 지뢰 개수를 세어주는 함수
    static int getMineCnt(int y, int x) {
        int mine = 0;
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isIn(ny, nx) && area[ny][nx] == '*') {
                mine++;
            }
        }
        return mine;
    }

    // 기존의 재귀(DFS) 함수 구조를 유지
    static void findMine(int y, int x) {
        area[y][x] = '!'; // 방문 처리 (열림 표시)

        // 주변 지뢰가 0인 경우에만 8방향 연쇄 탐색
        if (getMineCnt(y, x) == 0) {
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (!isIn(ny, nx)) continue;
                
                // 방문하지 않은 지뢰 없는 칸만 재귀 호출
                if (area[ny][nx] == '.') {
                    findMine(ny, nx);
                }
            }
        }
        // *주의*: area[y][x] = '.' 로 원복하는 백트래킹 코드는 작성하지 않습니다.
    }

    static boolean isIn(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}