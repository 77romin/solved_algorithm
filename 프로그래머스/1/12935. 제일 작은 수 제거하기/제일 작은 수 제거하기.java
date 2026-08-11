import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {        
        if(arr.length == 1) {
            int[] result = {-1};
            return result;
        }
        
        int[] result = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            min = min>arr[i]?arr[i]:min;
        }
        
        int cnt = 0;
        for(int a : arr)
            if(min!=a)
                result[cnt++] = a;

        return result;
    }
}