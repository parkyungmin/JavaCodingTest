import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] iSno = new int[N];
        
        //배열로 값 셋팅
        for (int i=0; i<N; i++) {
            iSno[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        //두 개의 수를 더해 M이 되는 수 count하기
        int count = 0;
        int firstSno = 0;
        for (int i=0; i<N-1; i++) {
            firstSno = iSno[i];
            for (int j=i+1; j<N; j++) {
                if (firstSno + iSno[j] == M) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
