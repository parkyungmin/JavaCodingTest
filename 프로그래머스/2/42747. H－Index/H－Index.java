import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 배열 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // 남은 논문의 수
            if (citations[i] >= h) {
                return h; // H-Index는 최대값이므로 찾자마자 반환
            }
        }
        return 0; // H-Index가 없는 경우
    }
}
