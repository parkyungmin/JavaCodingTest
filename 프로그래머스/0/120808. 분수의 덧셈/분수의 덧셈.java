class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        //분자 구하기
        int numer = numer1 * denom2 + numer2 * denom1;
        //분모 구하기
        int denom = denom1 * denom2;
        
        //기약분수로 만들기_유클리드 호제법 사용
        int result = getResult(numer,denom);
        
        answer[0] = numer/result;
        answer[1] = denom/result;
        
        return answer;
    }
    
    //최대공약수 구하기 (어떻게 최소공약수가 계산되는지 모르겠네..)
    public int getResult(int numer, int denom) {
        while(denom != 0) {
            int iDvs = numer % denom;
            numer = denom;
            denom = iDvs;
        }
        return numer;
    }

}

