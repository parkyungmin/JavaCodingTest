class Solution {
    public int[] solution(int num, int total) {
        // 배열 초기화
        int[] answer = new int[num];
        
        for(int j=-100; j<1001; j++){
            int result = 0;
            
            for(int i=j; i < num+j; i++) {
                answer[i-j] = i;
                result += i;
            }
            if(result == total) {
                break;
            }
        }
        
        return answer;
    }
}