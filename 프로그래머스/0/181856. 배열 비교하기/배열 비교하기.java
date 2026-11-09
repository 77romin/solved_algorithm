class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length == arr2.length) {
            int sum1 = 0;
            int sum2 = 0;
            for(int a1 : arr1)
                sum1 += a1;
            for(int a2 : arr2)
                sum2 += a2;
            if(sum1==sum2)
                return 0;
            else
                return sum1>sum2 ? 1 : -1;
        } else {
            return arr1.length>arr2.length ? 1 : -1;
        }
    }
}