class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int cur = x;
        while(cur!=0) {
            sum += cur%10;
            cur = cur/10;
        }
        return x%sum==0;
    }
}