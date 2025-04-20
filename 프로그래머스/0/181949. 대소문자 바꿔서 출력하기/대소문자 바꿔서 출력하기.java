import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 문자열 저장
        String a = sc.next();
        char b;
        String answer = "";
        
        // 문자 단위로 분리
        for (int i=0; i<a.length(); i++) {
            b = a.charAt(i);
            
            // 대소문자 구분
            if (Character.isUpperCase(b)) {
                answer += Character.toLowerCase(b);
            } else {
                answer += Character.toUpperCase(b);
            }
        }
        
        System.out.println(answer);
    }
}