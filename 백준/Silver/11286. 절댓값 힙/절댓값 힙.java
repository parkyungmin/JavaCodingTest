import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    /* 우선순위 큐 : 새로운 정렬방법을 modify해야함 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 양수 반환 시 : 우선순위 스왑! (o2가 먼저), 음수 반환 시 : 스왑 x (o1이 먼저) */
        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
            //절대값 작은 데이터 우선
            //절대값이 같은 경우 음수 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1; //절대값이 같은 경우 음수 우선(양수를 반환하면 o2가 우선.)
            }
            return first_abs - second_abs; //첫번째가 크면 양수, 두번째가 크면 음수 반환
        });

        for(int i=0; i<N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {
                if(myQueue.isEmpty()) {
                    System.out.println("0");
                }
                else {
                    System.out.println(myQueue.poll());
                }
            } else {
                myQueue.add(request);
            }
        }
    }
}
