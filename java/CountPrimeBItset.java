/** program to count no of prime bitsets between 2 nnumbers(inclusive), i. e the no of 1's in a binary equivalent of a number is prime.
TC-O(R-L log(R-L))
**/
class Solution {
    
    public int countPrimeSetBits(int L, int R) {
        int count=0;
        for(int i=L;i<=R;i++){
            if(isPrime(Integer.bitCount(i)))count++;
        }
        return count;
        }
    
    public boolean isPrime(int n){
        if(n==2||n==3||n==5||n==7||n==11||n==13||n==17||n==19)return true;
        return false;
    }
}
