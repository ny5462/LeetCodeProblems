/** program to solve fibonacci sequence, derived from https://leetcode.com/problems/fibonacci-number/discuss/324488/Java-time-O(n)-space-O(1)
**/

class Solution {
    public int fib(int N) {
       if(N==0||N==1)return N;
        int one=0,two=1,sum=one+two;
        for(int i=3;i<=N;i++){
            one=two;
            two=sum;
            sum=one+two;
        }
        return sum;
    }
}
