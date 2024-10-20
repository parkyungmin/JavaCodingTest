import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int[] ary = new int[N];

        for (int i=0; i<N; i++) {
            ary[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        //배열 정렬
        Arrays.sort(ary);

        //값 초기화
        int count = 0;
        int first = 0; //시작 인덱스
        int last = N-1; //마지막 인덱스

        //두 포인터가 겹쳐질때까지 반복문 수행
        while (first<last) {
            if (ary[first] + ary[last] < M) {
                first++;
            } else if (ary[first] + ary[last] > M) {
                last--;
            } else {
                count++;
                first++;
                last--;
            }
        }

        System.out.println(count);

    }
}
