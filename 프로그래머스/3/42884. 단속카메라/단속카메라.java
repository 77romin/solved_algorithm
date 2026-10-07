import java.util.*;

class Solution {
    class Car implements Comparable<Car> {
        int s, e;
        Car(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Car o) {
            return Integer.compare(this.e, o.e);
        }
        
    }
    
    public int solution(int[][] routes) {
        Car[] cars = new Car[routes.length];
        int i=0;
        for(int[] route : routes)
            cars[i++] = new Car(route[0], route[1]);
        Arrays.sort(cars); // 진출지점 기준 오름차순 정렬
        
        int camPoint = cars[0].e; // 가장 빨리 진출한 차량으로 초기화
        int camCnt = 1; // 설치 카메라 대수
        i=0;
        while(i<cars.length) {
            if(!(camPoint >= cars[i].s && camPoint <= cars[i].e)) { // **핵심!!**
                camPoint = cars[i].e;
                camCnt++;
            }
            i++;
        }
        return camCnt;
    }
}