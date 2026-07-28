class Solution {
    int digitSum(int n){
        if(n<=9) return n;
        int sum=0;
        while(n>0){
            int digit=n%10;
            n/=10;
            sum+=digit;
        }
        return sum;
    }
    public int addDigits(int num) {
        while(num>=10){
            num=digitSum(num);
        }
        return num;
    }
}