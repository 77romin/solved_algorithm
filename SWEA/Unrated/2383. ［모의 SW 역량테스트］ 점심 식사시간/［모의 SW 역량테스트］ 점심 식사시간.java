
import java.io.*;
import java.util.*;

class Solution {
    private static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Person> pList;
    private static List<Stair> sList;
    private static int[] selectedStair;
    private static int ans;

    static class Person {
        int y, x;

        Person(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Stair {
        int y, x, height;

        Stair(int y, int x, int height) {
            this.y = y;
            this.x = x;
            this.height = height;
        }
    }

    // 특정 계단을 선택한 사람들의 하강 완료 시간 계산
    private static int processStair(
            PriorityQueue<Integer> pq, int height) {

        Queue<Integer> goingDown = new ArrayDeque<>();
        int maxTime = 0;

        while (!pq.isEmpty()) {
            int arrivalTime = pq.poll();

            // 도착한 후 1분이 지나야 계단 진입 가능
            int startTime = arrivalTime + 1;

            // 3명 사용 중이면 가장 먼저 끝나는 사람 확인
            if (goingDown.size() == 3) {
                int earliestFinish = goingDown.poll();

                startTime = Math.max(
                        startTime, earliestFinish);
            }

            int finishTime = startTime + height;

            // 새로 진입한 사람의 완료 시간도 기록
            goingDown.offer(finishTime);

            maxTime = Math.max(maxTime, finishTime);
        }

        return maxTime;
    }

    private static int simulate() {
        PriorityQueue<Integer> pq0 = new PriorityQueue<>();
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        for (int i = 0; i < pList.size(); i++) {
            Person p = pList.get(i);
            int stairIndex = selectedStair[i];
            Stair s = sList.get(stairIndex);

            int arrivalTime =
                    Math.abs(p.x - s.x) +
                    Math.abs(p.y - s.y);

            if (stairIndex == 0) {
                pq0.offer(arrivalTime);
            } else {
                pq1.offer(arrivalTime);
            }
        }

        int time0 = processStair(
                pq0, sList.get(0).height);
        int time1 = processStair(
                pq1, sList.get(1).height);

        return Math.max(time0, time1);
    }

    private static void dfs(int pIndex) {
        if (pIndex == pList.size()) {
            ans = Math.min(ans, simulate());
            return;
        }

        selectedStair[pIndex] = 0;
        dfs(pIndex + 1);

        selectedStair[pIndex] = 1;
        dfs(pIndex + 1);
    }

    public static void main(String[] args)
            throws IOException {

        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            pList = new ArrayList<>();
            sList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(
                        br.readLine());

                for (int j = 0; j < N; j++) {
                    int val = Integer.parseInt(st.nextToken());

                    if (val == 1) {
                        pList.add(new Person(i, j));
                    } else if (val >= 2) {
                        sList.add(new Stair(i, j, val));
                    }
                }
            }

            selectedStair = new int[pList.size()];
            ans = Integer.MAX_VALUE;

            dfs(0);

            sb.append("#").append(tc)
              .append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
