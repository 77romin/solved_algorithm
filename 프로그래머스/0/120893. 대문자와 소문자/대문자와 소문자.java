class Solution {
    public String solution(String my_string) {
        String[] my_string_bits = my_string.split("");
        
        String answer = "";
        for(int i=0; i<my_string_bits.length; i++) {
            if(my_string_bits[i].toUpperCase().equals(my_string_bits[i]))
                answer += my_string_bits[i].toLowerCase();
            else
                answer += my_string_bits[i].toUpperCase();
        }
        return answer;
    }
}