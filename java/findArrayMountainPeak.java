/** program to find highest peak index in the mountain in an array of nos, i.e the index of highest value in the array,where the array is increasing or decreasing by reaching a point, i.e like a mountain.
Done by checking if the next element is smaller than current element.
TC-O(N)
**/
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for(int i=0;i<A.length-1;i++){
            if(A[i+1]<A[i])return i;
        }
        return A.length-1;
    }
}
