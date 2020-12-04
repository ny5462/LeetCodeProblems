/**
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Done by merge intervals, keeping a list to check the intersection if present and add to the list the intersection interval
TC-O(len(A)+len(B))
**/

class Solution {
    List<int[]> list=new ArrayList<>();
    int i=0,j=0;
    public int[][] intervalIntersection(int[][] A, int[][] B) {           
        while(i<A.length&&j<B.length){
            compare(A[i],B[j]);
        }
        int [][] ans=new int[list.size()][2];
        for(int index=0;index<ans.length;index++){
            ans[index]=list.get(index);
        }
        return ans;
    }
    
    public void compare(int A[], int B[]){
        int maxStart=Math.max(A[0],B[0]);
        int minEnd= Math.min(A[1],B[1]); 
        if(maxStart>minEnd){
            if(minEnd==A[1])i++;
            else j++; 
            return;
        }
        else{
            int[] temp=new int[2];
            temp[0]=maxStart;
            temp[1]=minEnd;
            list.add(temp);
            if(minEnd==A[1])i++;
            else j++;                   
        }
    }
}
