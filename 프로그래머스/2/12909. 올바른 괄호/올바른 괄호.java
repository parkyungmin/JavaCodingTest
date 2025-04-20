class Solution {
    boolean solution(String s) {
        int total = s.length();
        
        // 1. 시작이 ')' 이거나 마지막이 '('이면 false
        if (s.charAt(0) == ')' || s.charAt(s.length()-1) == '(') {
            return false;
        }
        
        // (추가) 총 개수가 홀수이면 false
        if (total % 2 == 1) {
            return false;
        }
        
        // 2. 중간에 ')'가 더 많아지면 무조건 false
        int balance = 0;
        
        for (int i=0; i<total; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;        
            } else {
                balance--;
            }
            
            if (balance < 0) {
                return false;
            }
        }
        
        return balance == 0;
    }
}