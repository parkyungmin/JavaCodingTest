import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    //배열 셋팅
    int arr[] = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = sc.nextInt();
    }

    //값 정렬
    for(int i=0; i<N-1; i++) {
      for(int j=0; j<N-1-i; j++) {
        if(arr[j] > arr[j+1]) {
          int temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }

    //출력
    for (int i=0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
  }
}
