class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 판 단위로 떨어지는 경우
        if (n % 7 == 0) {
            answer = n / 7;
        // 판 단위로 떨어지고 못 받은 사람이 있는경우 +1판 추가
        } else {
            answer = n / 7 + 1;
        }
        return answer;
    }
}