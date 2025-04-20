class Solution {
    public String solution(String s) {
        
        // 1. 공백을 기준으로 문자열 나누기
        String[] arr = s.split(" ");
        
        // 2. 비교할 값 초기화
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : arr) {
            int num = Integer.parseInt(str); // 숫자로 형변환
            
            //최소값
            if (min > num) {
                min = num;
            }

            //최대값
            if (max < num) {
                max = num;
            }
        }

        return min + " " + max;
    }
}