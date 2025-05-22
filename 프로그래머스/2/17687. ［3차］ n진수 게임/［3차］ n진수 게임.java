class Solution {
    public String solution(int n, int t, int m, int p) { // n(진법), t(미리 구할 숫자 갯수), m(참가인원), p(튜브의 순서)
        StringBuilder total = new StringBuilder(); // 전체 숫자 문자열 저장
        int num = 0;

        // 필요한 길이만큼 전체 숫자를 n진수로 만들어서 붙이기
        while (total.length() < t * m) { // 튜브가 t의 개수만큼 대답하기 위해선 최소 t*m만큼 (<=이면, 한 번 더타니 불필요)
            String converted = Integer.toString(num, n); // n진수로 변환
            total.append(converted.toUpperCase()); // 문자열 대문자로 변환(조건)
            num++;
        }

        // 튜브가 말해야 하는 글자만 골라서 결과 만들기
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int index = (p - 1) + i * m; // 튜브의 차례에 해당하는 인덱스 계산
            answer.append(total.charAt(index)); // StringBuilder는 char, String, int, boolean 다 append 가능(오버로딩)
        }

        return answer.toString();
    }
}