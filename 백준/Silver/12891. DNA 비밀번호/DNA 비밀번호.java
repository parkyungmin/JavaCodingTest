import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        // 슬라이딩 시간 복잡도 : O(n)
        /*----------------기본값 셋팅-----------------*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0; //정답 개수

        //비밀번호 체크 배열
        checkArr = new int[4];
        myArr = new int[4]; // 나의 현재 상태 배열
        checkSecret = 0; //조건에 만족하는 개수

        //전체배열
        char A[] = new char[S];

        /*------------------------------------------*/
        A = bf.readLine().toCharArray(); //문자열 배열로 셋팅

        //조건 배열값 셋팅
        st = new StringTokenizer(bf.readLine());
        for (int i=0; i<4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());

            //예외처리 - 만약 0이 들어오면 그 문자는 있든 없든 상관없으므로 조건에 만족한다는 의미로 +1처리
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        //부분문자 처음 받을때 셋팅
        for (int i=0; i<P; i++) {
            Add(A[i]);
        }

        //처음에 조건에 만족하면 count +1
        if (checkSecret == 4) {
            Result++;
        }

        //슬라이딩 윈도우
        for (int i=P; i<S; i++) { //i=P : 새로 추가되는 숫자
            int j = i-P; //배열중 앞에 있는 인덱스
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result++;
            }
        }

        System.out.println(Result);
        bf.close();

    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                //조건 충족하는지 확인
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                //조건 충족하는지 확인
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                //조건 충족하는지 확인
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                //조건 충족하는지 확인
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }


    //각 문자가 뭔지 확인
    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                //조건 충족하는지 확인
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                //조건 충족하는지 확인
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                //조건 충족하는지 확인
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                //조건 충족하는지 확인
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
