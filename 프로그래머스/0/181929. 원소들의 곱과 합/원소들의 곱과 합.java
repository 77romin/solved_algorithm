class Solution {
    public int solution(int[] num_list) {
        int multAll = 1;
        int sum = 0;
        for(int num : num_list) {
            multAll *= num;
            sum += num;
        }
        return multAll<sum*sum?1:0;
    }
}