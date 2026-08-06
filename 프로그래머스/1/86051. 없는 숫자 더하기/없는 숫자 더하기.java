import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int result = 45;
        for(int n : numbers)
            result -= n;
        return result;
    }
}