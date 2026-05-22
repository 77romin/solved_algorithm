class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0;
        for(int truck : truck_weights) sum += truck;
        
        int[] bridge_afford = new int[sum*bridge_length];
        int cur = 1;
        int time = 0;
        
        for(int truck : truck_weights) {
            while(bridge_afford[cur]+truck > weight)
                cur++;
            // System.out.println(truck+" "+cur);
            for(int i=0; i<bridge_length; i++) {
                bridge_afford[cur+i] += truck;
                time = cur+i+1>time?cur+i+1:time;
            }
            cur++;
        }
        return time;
    }
}