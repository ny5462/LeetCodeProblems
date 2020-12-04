/** program to sort arrray by parity, where odd no lies in odd index and vice versa.
Done by creating a new array, and traversing and adding to new index w.r.t modulus 2 operation.
TC-O(N)
**/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
       int[] ans=new int[A.length];
        int evenC=0;;
        int odd=1;
        for(int i:A){
            if(i%2==0){
                ans[evenC]=i;
                evenC+=2;
            }else{
                ans[odd]=i;
                odd+=2;
            }
            
        }
        return ans;
}
}
