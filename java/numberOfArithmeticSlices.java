/** problem to count the total no of arithmetic slices, i.e A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

Done using DP .
TC-O(N)
**/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length<3){
            return 0;
        }
        int S[]=new int[A.length];
        int sum=0;
        S[0]=0;
        S[1]=0;
        if(A[2]-A[1]==A[1]-A[0]){
            S[2]=1;
            sum+=1;
        }else{
            S[2]=0;
        }
        
        for(int i=3;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                S[i]=1+S[i-1];
                sum+=S[i];
            }
        }
        return sum;
    }
}
