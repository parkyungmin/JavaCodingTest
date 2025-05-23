// ArrayList 사용 시 시간초과 걸릴 수 있음
// -> HashMap 사용
// * HashMap : {key, value} 한 쌍
//  - Map 인터페이스 구현

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 참여한 선수 등록
        Map<String, Integer> list = new HashMap<>();
        for (String name : participant) {
            list.put(name, list.getOrDefault(name, 0) + 1); // 동명이인은 +1 처리
        }
        
        // 2. 완주한 선수 제거
        for (String name : completion) {
            list.put(name, list.get(name) - 1); // 완주한 선수는 제거
        }
        
        // 3. 남아있는 선수 출력
        /*
        for (String key : list.keySet()) { // keySet : key값을 set형태로 반환
            if (list.get(key) > 0) {
                return key;
            }
        }
        */
        
        // ※ entrySet() : key, value 둘 다 필요한 경우 사용. key-value 값을 하나의 객체로 갖고 있는다.
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 이거 안하면 컴파일 에러
    }
}