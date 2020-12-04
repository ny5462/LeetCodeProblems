/** program to find error in an array of numbers 1 to n, where a number is repeated twice, 
replacing one of the numbers ,which isn't present. both the repeated and missing number is returned as an array. Done using counter array.
TC-O(N)
**/
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] returner=new int[2];
        int[] counter=new int[nums.length+1];
        for(int num:nums){
            counter[num]+=1;
        }
        for(int i=1;i<counter.length;i++){
            if(counter[i]==2)returner[0]=i;
            if(counter[i]==0)returner[1]=i;
        }
        return returner;
        
    }
}
