import java.util.Stack;

class Solution {
    boolean solution(String s) {
        String[] queryBits = s.trim().split("");
        return chkRight(queryBits);
    }
    
    boolean chkRight(String[] queryBits) {
        Stack<String> stack = new Stack<>();
        
        for(String queryBit : queryBits) {
            if(stack.size()==0 && queryBit.equals(")")) return false;
            
            if(queryBit.equals("(")) {
                stack.add("(");
            } else if(queryBit.equals(")")) { 
                stack.pop();
            }
        }
        if(stack.size()!=0) return false;
        else return true;
    }
}