// 자료구조 : 중복X => HashSet
// 아니면 ArrayList 사용해서 전화번호 저장한 다음에 반복문 돌려서 앞에어서 부터 포함하고 있는지 확인?
// -> ArrayList.contains()는 내부적으로 반복문(for)돌며 하나 하나 비교한다. O(n)
// -> HashSet.contains()는 해시값을 이용해 바로 찾을 수 있다. O(1)

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> hashSet = new HashSet<>();
        
        // 1. 전화번호 등록
        for (String s : phone_book) {
            hashSet.add(s);
        }
        
        // 2. 자기 자신을 제외하고 포함하고 있는지 확인
        for (String phoneNumber : phone_book) {
            for (int i=1; i<phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0,i); // ※ String은 0-based index이다.
                if (hashSet.contains(prefix)) { // HashSet.contains() 시간복잡도는 O(1)
                    return false; // 존재
                }
            }
        }
        
        return answer; // 미존재
    }
}