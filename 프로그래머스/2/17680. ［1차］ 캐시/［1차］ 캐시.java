import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>(); // 캐시를 구현할 큐
        Map<String, Boolean> isInCache = new HashMap<>(); // 캐시에 도시가 있는지 빠르게 확인하기 위한 맵
        int excutionTime = 0; // 총 실행 시간
        
        // 캐시 크기가 0인 경우, 모든 요청은 Cache Miss 처리해야한다.
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        // 모든 도시 이름을 순회하면서 캐시 동작 시뮬레이션
        for (String city : cities) {
            String lowerCaseCity = city.toLowerCase(); // 대소문자 구분 없으므로 소문자로 변환

            // Cashe Hit 경우
            if (isInCache.containsKey(lowerCaseCity)) {
                excutionTime += 1; // 실행 시간 1 증가
                cache.remove(lowerCaseCity); // 기존 위치에서 제거
                cache.offer(lowerCaseCity); // 가장 최근 사용으로 큐의 뒤쪽에 증가
            }
            // Cache Miss 경우
            else {
                excutionTime += 5; // 실행 시간 5 증가

                // 캐시가 가득 찼다면 가장 오래된 항목 제거
                if (cache.size() == cacheSize) {
                    String oldestCity = cache.poll(); // 큐의 가장 앞 요소 제거 (가장 오래된 항목)
                    isInCache.remove(oldestCity); // 맵에서도 제거
                }

                cache.offer(lowerCaseCity); // 새로운 도시를 큐의 뒤쪽에 추가
                isInCache.put(lowerCaseCity, true); //맵에 새로운 도시 추가
            }
        }
        
        return excutionTime; // 총 실행 시간 반환
    }
}