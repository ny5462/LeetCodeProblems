/** program to check the no of people in wrong position w.r.t order of their heights.
DOne by copying the array into another array, sorting the other array, and comparing the no of mismatches. 
TC-O(NlogN)
**/
class Solution {
    public int heightChecker(int[] heights) {
        int[] correct=new int [heights.length];
        for(int i=0;i<heights.length;i++){
            correct[i]=heights[i];
        }
        Arrays.sort(correct);
        int wrong=0;
        for(int i=0;i<heights.length;i++){
            if(!(correct[i]==heights[i]))++wrong;
        }
        return wrong;
    }
}

