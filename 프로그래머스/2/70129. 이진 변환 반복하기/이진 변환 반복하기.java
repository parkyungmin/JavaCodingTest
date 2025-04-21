class Solution {
    public int[] solution(String s) {
        int i = 1; // 횟수
        int zeroCnt = 0; // 제거된 0 횟수
        
        while (true) {
            int len = s.length();
            s = s.replaceAll("0", ""); // 0제거
            if (len != s.length()) {
                zeroCnt += len - s.length();
            }

            if (s.length() == 1) { // 0을 제거한 길이가 1이면 종료
                break;
            } else { // 0이 아니면 길이만큼 2진법으로 표현한 문자열로 변환
                s = Integer.toBinaryString(s.length()); // 10진수 -> 2지눗
                i++;
            }
        }
        
        int[] answer = {i, zeroCnt};
        return answer;
    }
}