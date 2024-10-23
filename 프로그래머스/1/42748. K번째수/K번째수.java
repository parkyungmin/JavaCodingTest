import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        //2차 배열 행수만틈 결과값 크기 셋팅
        int[] answer = new int[commands.length];
        
        for(int t=0; t<commands.length; t++) { //행 수
            int[] arr = new int[commands.length];
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            arr = Arrays.copyOfRange(array,i-1,j); //copyOfRange : 2~5까지이면 실제로 2~4까지 출력한다.
            Arrays.sort(arr); // 오름차순 정렬
            
            //k번째 값 셋팅
            answer[t] = arr[k-1];   
        }
        
        return answer;
    }
}