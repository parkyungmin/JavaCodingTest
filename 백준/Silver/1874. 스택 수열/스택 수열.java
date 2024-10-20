import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        //n만큼 입력값 셋팅
        int A[] = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        //스택 생성
        Stack<Integer> stack = new Stack<>();
        int num = 1; //스택 1부터 시작
        StringBuffer bf = new StringBuffer(); //출력
        boolean result = true;

        for (int i=0; i<A.length; i++) {
            int su = A[i];

            //수열과 같을 때 까지 값 push
            if (su >= num) {
                while (su >= num) {
                    stack.push(num);
                    num++;
                    bf.append("+\n");
                }
                //같아지면 뺀다.
                stack.pop();
                bf.append("-\n");
            }
            //수열이 더 작으면
            else {
                int q = stack.pop();
                if(q > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }
            }
        }

        if (result) System.out.println(bf.toString());

    }
}
