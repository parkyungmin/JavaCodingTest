/* JadenCase 문자열 만들기 */
class Solution {
    public String solution(String s) {
        // 1. 공백을 구분자로 문자열 나누기
        // 문제 : 공백이 연속으로 등장하면 이상하게 잘림.
        // 해결방안 : 공백은 그대로 유지하고 문자만 변경
        //String[] str = s.split(" ");
        
        StringBuilder result = new StringBuilder();
        boolean isStartOfWord = true;
        
        for (char c : s.toCharArray()) { // 한 단어씩 짜르기.
            if (c == ' ') {
                result.append(c); //공백보존
                isStartOfWord = true;
            } else {
                if (isStartOfWord) {
                    result.append(Character.toUpperCase(c));
                    isStartOfWord = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }
        return result.toString();
    }
}