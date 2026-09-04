import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] tmpStrBits = my_string.split(" ");
        int i=0;
        List<String> list = new ArrayList<>();
        for(String a : tmpStrBits) {
            if(!a.trim().equals(""))
                list.add(a.trim());
        }
        
        return list.toArray(new String[list.size()]);
    }
}