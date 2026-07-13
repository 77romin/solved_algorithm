class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int arrBit : arr) {
            answer += arrBit;
        }
        
        return answer/arr.length;
    }
}