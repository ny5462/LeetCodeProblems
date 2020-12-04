/** program to put all even integers in an array before all the odd integers, and
return the array in any order following the condition.Done keeping count and swapping when
encountering an even integer.
TC-O(N)
**/
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                int temp=A[count];
                A[count]=A[i];
                A[i]=temp;
                ++count;
            }
        }
        return A;
    }
}
