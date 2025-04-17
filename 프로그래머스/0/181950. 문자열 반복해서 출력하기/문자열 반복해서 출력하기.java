import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // string
        int n = sc.nextInt(); // 5
        
        // 출력
        for(int i=0; i<n; i++) {
            System.out.print(str);
        }
    }
}