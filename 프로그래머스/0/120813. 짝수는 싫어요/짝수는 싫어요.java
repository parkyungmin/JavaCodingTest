class Solution {
    public int[] solution(int n) {
        // n이 짝수라면 
        int count = 0;
        if (n % 2 == 0){
            count = n/2;
        } else
            count = n/2 + 1;
        
        
        int[] answer = new int[count];
        
        int j = 0;
        for (int i=1; i<=n; i++) {
            if (i % 2 == 1) {
                answer[j] = i;
                j++;
            }
        }
        
        return answer;
    }
}