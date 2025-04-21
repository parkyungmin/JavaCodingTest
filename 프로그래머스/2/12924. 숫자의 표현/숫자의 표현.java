class Solution {
    public int solution(int n) {
        int result = 1;
        int num = n/2;

        if (n%2==0) {
            num--;
        }

        for (int i=1; i<=num; i++) {
            int sum = 0;
            for (int j=i; j<=num+1; j++) {
                sum += j;
                if (sum == n) {
                    result++;
                } else if (sum > n) {
                    break;
                }
            }
        }
        
        return result;
    }
}