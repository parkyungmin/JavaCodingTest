class Solution {
    public int solution(int n) {
        int f0 = 0;
        int f1 = 1;
        int sum = 0;

        for (int i=2; i<=n; i++) {
          sum = (f0 + f1) % 1234567; //(a+b)(mod m)=(a(mod m)+b(mod m))(mod m)
          f0 = f1;
          f1 = sum;
        }
        
        return sum;
    }
}