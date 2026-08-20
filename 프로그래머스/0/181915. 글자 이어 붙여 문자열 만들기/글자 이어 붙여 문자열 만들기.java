class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        String[] ms = my_string.split("",my_string.length());
        for(int i : index_list)
            answer += ms[i];
        return answer;
    }
}