import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> jobs = new LinkedList<>();
        LinkedList<Integer> speedList = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();

        // 작업 초기화
        for (int i : progresses) {
          jobs.add(i); // 작업 초기화
        }

        // 작업속도 초기화
        for (int i : speeds) {
          speedList.add(i); // 작업속도 초기화
        }

        while (!jobs.isEmpty()) { // 작업이 없을 때까지 수행
          // [반복] 각 작업에 작업시간 더하기
          for (int i=0; i<jobs.size(); i++) {
            jobs.set(i, jobs.get(i) + speedList.get(i));
          }

          // 맨 앞에 있는 작업이 완료되면, 완료된 다른 작업들도 빼낸다.
          if (jobs.getFirst() >= 100) {
            int count = 0;

            while (!jobs.isEmpty() && jobs.getFirst() >= 100) {
              jobs.removeFirst(); // 작업 제거
              speedList.removeFirst(); // 작업속도 제거
              count++;
            }

            if (count > 0 ) {
              resultList.add(count); // 제거된 개수 저장
            }

          }
        }

        // 결과 출력
        int[] result = new int[resultList.size()];
        for (int i=0; i < resultList.size(); i++) {
          result[i] = resultList.get(i);
        }

        return result;
    }
}