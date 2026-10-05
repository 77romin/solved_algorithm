class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int mep = my_string.length()-1;
        int sep = is_suffix.length()-1;
        
        while(sep>=0) {
            if(mep<0) return 0;
            if(my_string.charAt(mep) != is_suffix.charAt(sep)) return 0;
            mep--;
            sep--;
        }
        
        return 1;
    }
}