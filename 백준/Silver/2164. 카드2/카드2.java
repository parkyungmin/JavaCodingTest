import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //큐 셋팅
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        //큐에 카드가 한 장 남을때까지 반복
        while (queue.size() > 1) {
            queue.poll(); //카드버리기
            int temp = queue.poll();
            queue.add(temp);
        }

        System.out.println(queue.poll());
    }
}
