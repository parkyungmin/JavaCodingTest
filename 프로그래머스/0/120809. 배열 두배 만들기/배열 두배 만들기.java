class Solution {
    public int[] solution(int[] numbers) {
        // answer 배열 초기화 (배열의 크기를 정의하지 않고 초기화하면, 배열을 동적으로 늘리는 것이 불가능)
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }
        
        return answer;
    }
}