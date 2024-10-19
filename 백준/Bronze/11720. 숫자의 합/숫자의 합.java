import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//정수 N값 받기
		int N = sc.nextInt();
		//자리수가 N인 숫자값 STRING형으로 받기 
		//※N으로 올 수 있는 최대갑이 100이므로 100자리수의 숫자는 INT,LONG으로도 저장 불가하기 때문에 STRING으로 저장한다.
		String sNum = sc.next();
		
		//1.문자열로 받은 값을 한자리씩 배열로 넣기
		char[] cNum = sNum.toCharArray();
		
		//2.반복문을 통해 각 자리수를 더하기
		int sum = 0;
		
		for(int i=0; i<cNum.length; i++) {
			sum += cNum[i] - '0'; //아스키코드를 사용하여 문자값을 숫자값으로 변환('0' = 48)
		}
		
		System.out.print(sum);
		
		
	}

}
