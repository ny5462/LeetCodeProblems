/** program to return the nth tribonacci no. Done using dynammic programming.TC-O(N)
**/
class Solution {
    public int tribonacci(int n) {
        if(n<2&&n>=0)return n;
        int [] memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        memo[2]=1;
        if(n<=2)return memo[n];
        for(int i=3;i<n+1;i++){
            memo[i]=memo[i-1]+memo[i-2]+memo[i-3];
        }
        return memo[n];
        
    }
}
