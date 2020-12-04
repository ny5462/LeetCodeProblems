/** pancake sort Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length, then reverse the order of the first k elements of A.  We want to perform zero or more pancake flips (doing them one after another in succession) to sort the array A.

Return the k-values corresponding to a sequence of pancake flips that sort A.  Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
TC-O(N^2)
logic inspired by- https://leetcode.com/problems/pancake-sorting/discuss/349200/Java-O(N2)-100-beats-solution-with-detailed-explanation
**/
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int N=A.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=A.length-1;i>0;i--){
            int maxIndex=findMaxIndex(A,i);
            reverse(A,maxIndex);
            reverse(A,i);
            ans.add(maxIndex+1);
            ans.add(i+1);
        }
        return ans;

    }
    public int findMaxIndex(int[] A,int index){
        int max=A[0];
        int  maxIndex=0;
        for(int i=0;i<=index;i++){
            if(A[i]>max){
                max=A[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public void reverse(int [] A, int index){
        int start=0;
        int end=index;
        while(start<end){
            int temp=A[start];
            A[start]=A[end];
            A[end]=temp;
            start++;
            end--;
        }
    }
}
