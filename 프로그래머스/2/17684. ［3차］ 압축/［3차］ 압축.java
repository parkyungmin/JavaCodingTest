import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();

        // 1. A~Z 사전 초기화
        for (int i = 0; i < 26; i++) {
          dictionary.put("" + (char) ('A' + i), i + 1);
        }

        // 결과를 반환할 리스트 생성
        List<Integer> result = new ArrayList<>();
        int dictSize = 27;
        int idx = 0;

        System.out.println("▶ 초기 사전: " + dictionary);
        System.out.println("▶ 입력 문자열: " + msg);
        System.out.println("-----------------------------");

        while (idx < msg.length()) { // 문자열 처음부터 끝까지 검토
          String w = "";
          int len = 0;

          // 사전에 있는 가장 긴 w 찾기
          // ※ subString(시작index, 종료index) 종료index는 불포함한다!
          while (idx + len < msg.length() && dictionary.containsKey(msg.substring(idx, idx + len + 1))) { // 사전에 없으면 false 반환
            len++;
          }

          w = msg.substring(idx, idx + len); // 존재하는 단어는 List에 추가
          int wIndex = dictionary.get(w);
          result.add(wIndex);

          System.out.println("현재 위치 idx = " + idx);
          System.out.println("사전에 있는 가장 긴 단어 w = \"" + w + "\", 사전 인덱스 = " + wIndex);

          // 다음 단어 w + c를 사전에 등록
          if (idx + len < msg.length()) {
            String next = msg.substring(idx, idx + len + 1);
            dictionary.put(next, dictSize++);
            System.out.println("새 단어 추가: \"" + next + "\", 인덱스 = " + (dictSize - 1));
          }

          System.out.println("-----------------------------");

          idx += len;
        }

        // 결과 출력
        System.out.println("최종 출력 인덱스 리스트: " + result);

        // List → 배열 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
          answer[i] = result.get(i);
        }

        return answer;
    }
}