import java.io.*;
import java.util.*;

public class Solution {
    private static final int MAP_SIZE = 4001;
    private static final int OFFSET = 2000;

    // 상(0: y증가), 하(1: y감소), 좌(2: x감소), 우(3: x증가)
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    static class Atom {
        int x, y, dir, energy;

        Atom(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

    private static int[][] map = new int[MAP_SIZE][MAP_SIZE];
    private static List<Atom> atoms;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            atoms = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(st.nextToken()) * 2 + OFFSET;
                int y = Integer.parseInt(st.nextToken()) * 2 + OFFSET;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());

                atoms.add(new Atom(x, y, dir, energy));
            }

            System.out.println("#" + tc + " " + simulate());
        }
    }

    private static int simulate() {
        int totalEnergy = 0;

        while (!atoms.isEmpty()) {
            // 1. 이동 및 에너지 누적
            for (Atom atom : atoms) {
                atom.x += dx[atom.dir];
                atom.y += dy[atom.dir];

                if (isInside(atom.x, atom.y)) {
                    map[atom.x][atom.y] += atom.energy;
                }
            }

            // 2. 충돌 확인
            List<Atom> nextAtoms = new ArrayList<>();
            for (Atom atom : atoms) {
                if (!isInside(atom.x, atom.y)) continue;

                if (map[atom.x][atom.y] == atom.energy) {
                    nextAtoms.add(atom);
                } else {
                    totalEnergy += atom.energy;
                }
            }

            // 3. 맵 초기화 (사용한 위치만)
            for (Atom atom : atoms) {
                if (isInside(atom.x, atom.y)) {
                    map[atom.x][atom.y] = 0;
                }
            }

            atoms = nextAtoms;
        }

        return totalEnergy;
    }

    private static boolean isInside(int x, int y) {
        return x >= 0 && x < MAP_SIZE && y >= 0 && y < MAP_SIZE;
    }
}