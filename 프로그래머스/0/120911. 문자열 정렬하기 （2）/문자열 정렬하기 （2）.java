import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        String[] strBits = my_string.split("");
        Arrays.sort(strBits);
        String ans = "";
        for(String strBit : strBits)
            ans += strBit;
        return ans;
    }
}