/** program to find whether an integer is a power of two. 
Approach 1 done iteratively using a variable
Approach 2 done recursively by dividing by 2.
TC-O(logN)
**/
class Solution {
    public boolean isPowerOfTwo(int n) {
         if(n==1)return true;
        if(n<1||n%2!=0)return false;
        int val=1;  
        while(val<n&&val<Integer.MAX_VALUE/2){
                val=val*2;
                if(val==n)return true;
            }
            return false;
        
    }
}


class Solution {
    public boolean isPowerOfTwo(int n) {
         if(n==1)return true;
         if(n<1||n%2!=0)return false;
        return isPowerOfTwo(n/2);
    }
}
