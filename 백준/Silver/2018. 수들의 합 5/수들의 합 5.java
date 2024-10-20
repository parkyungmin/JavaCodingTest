import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //변수 초기화
        int count = 1; //자기 자신은 미리 count
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        
        //자기자신을 만나면 반복문 종료
        while (end_index != N) {
            //sum이 N과 같으면  count +1, end를 +1 해주고 sum에 더한다.
            if(sum == N) {
                count++;
                end_index++;
                sum += end_index;
            }
            //sum이 N보다 크면 sum에서 start를 빼주고
            else if (sum > N) {
                sum -= start_index;
                start_index++;
            }
            //sum이 N보다 작으면 end +1, sum에 end값 더해준다.
            else {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);

    }
}
