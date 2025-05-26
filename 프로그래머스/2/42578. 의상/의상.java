// HashMap 사용 - {옷 종류, 옷 이름}
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 1. 옷 종류별 개수 세기
        for (String[] cloth : clothes) { // 각 행을 가져옴
            String sort = cloth[1]; // 옷의 종류
            hashMap.put(sort, hashMap.getOrDefault(sort, 0) + 1);
        }
        
        // 2. 조합가능한 수 계산하기
        for(String key : hashMap.keySet()) {
            answer *= hashMap.get(key) + 1; // +1 : 옷을 선택 안할 수도 있다.
        }
        
        // 3. 결과 출력
        return answer - 1; // -1 : 아무옷도 안입는거는 안됨
    }
}