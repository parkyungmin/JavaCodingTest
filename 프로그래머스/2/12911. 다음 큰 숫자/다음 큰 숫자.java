class Solution {
    public int solution(int n) {
        /* 문제풀이2 - bitCount 사용*/
        // bitCount : 2진수 표현에서 1의 개수를 반환
        int targetCount = Integer.bitCount(n); // 1의 개수 반환
        int num = n+1;

        // 조건 2
        while (targetCount != Integer.bitCount(num)) {
          num++;      
        }

        return num;

        /* 문제풀이1 - 정답은 맞으나 속도이슈 때문에 탈락
        int n = 78;
        String binaryN = Integer.toBinaryString(n); // 1111
        binaryN = binaryN.replaceAll("0",""); //0제거
        int countN = binaryN.length(); // 1의 개수
        int num = n;

        // '숫자+1' 하면서 조건에 만족하는 숫자 찾기
        while (true) {
          num++;
          String binaryNum = Integer.toBinaryString(num); // 2진수로 변환
          binaryNum = binaryNum.replaceAll("0",""); // 0제거
          int countNum = binaryNum.length(); // 1의 개수

          if (countN == countNum) {
            break;
          }
        }
        */
    }
}