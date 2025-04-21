import java.util.Arrays;
import java.util.Collections;

class Solution
{
    public int solution(int []A, int []B)
    {
        /* 문제풀이 : '가장 큰 수 * 가장 작은수'로 계산 해야한다. */
        // 1. 배열을 정렬한다.
        Arrays.sort(A); // 오름차순
        // 주석처리
        // Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new); //Integer 배열로 변환(-> 내림차순)
        // Arrays.sort(arrB, Collections.reverseOrder()); // 내림차순
        Arrays.sort(B);
        
        // 2. 계산
        int result = 0;
        for(int i=0; i<A.length; i++) {
            result += A[i] * B[B.length-1 - i];
        }
        
        // 3. 반환
        return result;
    }
}