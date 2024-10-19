import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        //1.입력받은 N만큼 배열값 셋팅
        int[] A = new int[N];
        int[] S = new int[N]; //합배열
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();

            //합배열 셋팅
            if (i==0){
                S[i] = A[i];
            } else {
                S[i] = S[i-1] + A[i];
            }
        }

        //2.입력받은 M만큼 구간합 출력
        for(int i=0; i<M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x==1){
                System.out.println(S[y-1]);
            } else if (x==y) {
                System.out.println(A[y-1]);
            } else {
                System.out.println(S[y-1] - S[x-2]);
            }
        }
    }
}
