import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력받는 수가 많을 때는 BufferReader를 쓴다.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //계산해야 하는 개수가 최대 10만개 까지 들어오는데, int형으로 받기 힘들기 때문에 Stringtoken을 사용한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); //readLine() : 입력된 첫 번째 줄을 읽어옴.

        //첫 번째 줄에 셋팅하는 입력값 셋팅
        int suNo = Integer.parseInt(stringTokenizer.nextToken()); //정수형으로 변경
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        //합배열 구하기
        long[] S = new long[suNo + 1]; //+1은 나중에 계산하기 편하게 하기 위해서..
        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); //한 줄에 입력된 값 한 번에 가져오기
        for (int i=1; i<=suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken()); //합배열 구하는 공식
        }

        //출력값 구하기
        for(int q=0; q<quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine()); //한 줄에 입력된 값 한 번에 가져오기
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);

        }

    }
}
