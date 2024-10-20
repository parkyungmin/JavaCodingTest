import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a[] = new int[N];
        //입력받은 값 만큼 배열 셋팅
        for(int i=0; i<N; i++) {
            a[i] = i + 1;
        }

        int count = 0; //총 개수

        //조건에 만족하는 수 구하기
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<N; j++) {
                sum += a[j];

                if (sum > N) {
                    break;
                } else if (sum == N) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
