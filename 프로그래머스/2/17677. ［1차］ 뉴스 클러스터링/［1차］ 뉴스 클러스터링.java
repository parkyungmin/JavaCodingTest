import java.util.*; // 자료구조(List, ArrayList) 사용하기 위해 import

class Solution {
    public int solution(String str1, String str2) {
        // 두 글자씩 잘라서 저장
        List<String> list1 = makeList(str1.toLowerCase());
        List<String> list2 = makeList(str2.toLowerCase());
        
        // 교집합, 합집합 초기화
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>(list1);
        
        // 교집합, 합집합 구하기
        for (String s : list2) {
            // 교집합
            if (list1.contains(s)) {
                intersection.add(s);
                list1.remove(s); // 가장 앞에 있는 하나 제거
            } 
            // 합집합
            else {
                union.add(s);
            }
        }
        
        // 두 집합 모두 공집합인 경우
        if (union.size() == 0) return 65536; // 두 집합을 합친 합집합이 0이면 65536 반환
        
        // 자카드 유사도 계산 (유사도 값은 0~1사이에 실수)
        double jacquard = (double) intersection.size() / union.size(); // 2/5 = 0.4 int로 선언하면 0이 됨
        return (int) (jacquard * 65536);
    }
    
    private List<String> makeList(String str) {
        List<String> list = new ArrayList<>();
        
        for (int i=0; i < str.length() -1; i++) {
            // 문자 단위로 자르기
            char c1 = str.charAt(i);
            char c2 = str.charAt(i+1);
            
            // 두 문자 모두 영문자일 때만 조합
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                list.add("" + c1 + c2); // 문자(=아스키) + 문자(=아스키) = 숫자
            }
        }
        
        return list;
    }
}