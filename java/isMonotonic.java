/** program to find whether given array is either monotonic increasing or montonic decreasing.
TC-O(2N)
**/
class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length==1)return true;
        if(monoInc(A))return true;
        if(monoDec(A))return true;
        return false;
        
    }
    
    public boolean monoInc(int[] A){
        for(int i=0;i<A.length-1;i++){
            if(A[i]>A[i+1])return false;
        }
        return true;
    }
    public boolean monoDec(int [] A){
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1])return false;
        }
        return true;
    }
}
