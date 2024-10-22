import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        /* 방법1 *********************************
        //가변 크기의 배열 선언
        List<Integer> answerList = new ArrayList<>();
        
        //List에 연속된 값 중복없이 값 셋팅
        int value = -1; //-1로 선언한 이유는 원소가 0~9에 숫자가 나오기 때문
        for(int i=0; i<arr.length; i++) {
            if (arr[i] != value) {
                answerList.add(arr[i]); //중복되지 않으면 add
                value = arr[i];
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray(); //List를 배열로 변환
        ******************************************/
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr) {
            //스택이 비어있거나(맨처음값) stack에 있는 값과 비교하여 같지 않으면 추가
            if(stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }
        
        int[] answer = new int[stack.size()]; //!! stack.length가 아니라 stack.size()이다!!
        for(int j=stack.size() - 1; j>=0; j--) {
            answer[j] = stack.pop();
        }
        
        return answer;
        
    }
}