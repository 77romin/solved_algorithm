class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for(int i=0; i<absolutes.length; i++) {
            absolutes[i] *= signs[i]?1:-1;
            sum += absolutes[i];
        }
        
        return sum;
    }
}