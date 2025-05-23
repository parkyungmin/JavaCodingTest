// 순서 상관 x, 중복가능, => HashMap 사용
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        
        // 1. 포켓몬 종류 저장
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        
        // 2. 가질 수 있는 포켓문 수 구하기
        int num = nums.length / 2; // 배열.lentgh는 메서드가 아닌 필드 속성. *String 객체는 length필드가 없으며 length()메서드 사용!
        
        // 3. 최대 몇 종류를 선택할 수 있는지 구하기
        System.out.println("해시 : " + hashMap.size());
        System.out.println("num : " + num);
        
        if (num <= hashMap.size()) { // 선택할 수 있는 개수보다 포켓몬 종류가 더 많으면
            return num;
        } else { // 포켓몬 종류가 더 적으면
            return hashMap.size();
        }
    }
}