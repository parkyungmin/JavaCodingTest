import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //과목의 개수 N개를 설정한다.
        int N = sc.nextInt();
        //각 과목의 점수를 셋팅한다.
        int[] iScore = new int[N];
        int iMax = 0; //최대값을 저장하기위한 변수
        for(int i=0; i<N; i++) {
            iScore[i] = sc.nextInt();
            if (iMax < iScore[i]) {
                iMax = iScore[i]; // 큰 수가 들어오면 변수에 저장해준다.
            }
        }

        //1.점수를 조작해서 배열에 다시 저장하고 총합을 구한다.
        double iSum = 0;
        for(int i=0; i<iScore.length; i++) {
            iSum +=  ((double) iScore[i] / iMax)  * 100; //!! 정수형에서는 50 / 100 = 0.5가 나오는게 아니라 0이 나온다...
        }

        //2.평균을 계산 후 출력한다.
        System.out.print(iSum/N);

    }

}
